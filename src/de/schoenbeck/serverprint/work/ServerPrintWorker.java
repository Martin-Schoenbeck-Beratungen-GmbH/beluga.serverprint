package de.schoenbeck.serverprint.work;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.adwindow.ADWindowContent;
import org.adempiere.webui.editor.WButtonEditor;
import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.editor.WRadioGroupEditor;
import org.adempiere.webui.window.Dialog;
import org.compiere.model.GridField;
import org.compiere.model.GridFieldVO;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import de.schoenbeck.serverprint.exceptions.CalledFromProcessException;
import de.schoenbeck.serverprint.exceptions.DocumentIsNewException;
import de.schoenbeck.serverprint.exceptions.NoPrintProfileException;
import de.schoenbeck.serverprint.exceptions.NotPreparedException;
import de.schoenbeck.serverprint.params.ServerPrintCopyParam;
import de.schoenbeck.serverprint.params.ServerPrintCopyParamBuilder;
import de.schoenbeck.serverprint.params.ServerPrintWorkerParam;
import de.schoenbeck.serverprint.params.ServerPrintWorkerParamBuilder;

public class ServerPrintWorker {

	// internal
	boolean isPrepared = false;
	final boolean isCalledFromProcess;
	String trxName = null;
	
	// process parameters
	int windowno;
	ServerPrintWorkerParam[] params;
	
	
	public ServerPrintWorker(boolean calledFromProcess, int windowno) {
		this.isCalledFromProcess = calledFromProcess;
		this.windowno = windowno;
	}

	@Deprecated
	public void prepare (int ad_client_id, int ad_org_id, int c_bpartner_id, int ad_user_id, int c_doctype_id, 
			int ad_tab_id, int ad_user_id_bpartner, int ad_table_id, int record_id) {
		ServerPrintWorkerParam param = 
				new ServerPrintWorkerParamBuilder()
					.setAd_client_id(ad_client_id)
					.setAd_org_id(ad_org_id)
					.setC_bpartner_id(c_bpartner_id)
					.setAd_user_id(ad_user_id_bpartner)
					.setC_doctype_id(c_doctype_id)
					.setAd_tab_id(ad_tab_id)
					.setAd_user_id_bpartner(ad_user_id_bpartner)
					.setAd_table_id(ad_table_id)
					.setRecord_id(record_id)
					.build();
		prepare(param);
		
	}
	
	public void prepare (ServerPrintWorkerParam param) {
		prepare(new ServerPrintWorkerParam[] {param});
	}
	
	public void prepare (ServerPrintWorkerParam[] params) {
		this.params = params;
		this.isPrepared = true;
	}
	
	public void start () throws Exception {
		if (!isPrepared)
			throw new NotPreparedException();
		
		PO doc = new MTable(Env.getCtx(), params[0].ad_table_id, trxName).getPO(params[0].record_id, trxName);
		if (doc.columnExists("DocStatus")) {
			if (doc.get_Value("DocStatus").equals("DR")) throw new DocumentIsNewException();
		}
	
//		Stack<Object> deletionStack = null; //FIXME: braucht neuen Cleaner
		
		LinkedList<Copy> copies = new LinkedList<>();
		ResultSet rs = null;
		PreparedStatement ps = DB.prepareStatement(Copy.SQL_QUERY, trxName);
		
		try {
			ps.setInt(1, params[0].ad_client_id);
			ps.setInt(2, params[0].ad_org_id);
			ps.setInt(3, params[0].c_bpartner_id);
			ps.setInt(4, params[0].ad_user_id);
			ps.setInt(5, params[0].c_doctype_id);
			ps.setInt(6, params[0].ad_tab_id);
			ps.setString(7, isCalledFromProcess ? "Y" : "N");
			
			rs = ps.executeQuery();
			while (rs.next()) {
				// If subregister_id > 0:
					// add a copy per record in subregister table
				// Otherwise:
				LinkedList<ServerPrintCopyParam> copyparams = new LinkedList<>();

				copyparams.add(new ServerPrintCopyParamBuilder(trxName)
						.setFromResultSet(rs)
						.setAd_user_id_bpartner(params[0].ad_user_id_bpartner)
						.setAd_table_id(params[0].ad_table_id)
						.setRecord_id(params[0].record_id)
						.setCalledFromProcess(isCalledFromProcess)
						.setProcessParams(params[0].parameter)
						.build());
				
				if (params.length > 1)
					copyparams.addAll(getSubParams(Arrays.copyOfRange(params, 1, params.length), params[0].sbsp_printoption_id));
				
				copies.add(new Copy(copyparams.toArray(new ServerPrintCopyParam[copyparams.size()])));
			}
		} finally {			
			DB.close(rs, ps);
		}
		
		copies = checkCopiesForPrintOptions(copies);
		
		Map<ServerPrintCopyParam, File> files = new HashMap<>();
		
		for (Copy c : copies)				
			c.execute(files);
	}
	
	/**
	 * Remove from the list all copies but the copies with standard or specified printoption
	 * @param copies - All valid copies
	 * @return Modified list containing only copies with chosen printoptions
	 * @throws Exception - If lookup fails, the window times out or if called from process (from {@link ServerPrintWorker#choosePrintOptionId(HashSet)}
	 */
	private LinkedList<Copy> checkCopiesForPrintOptions(LinkedList<Copy> copies) throws Exception {
		
		HashSet<Integer> options = new HashSet<>();
		
		for (Copy c : copies) {
			options.add(c.sbsp_printoption_id);
		}
		
		if (options.size() == 0) throw new NoPrintProfileException();
		if (options.size() <= 1) return copies;
		if (options.size() == 2 && options.contains(0)) return copies;
		
		int option;
		if (params[0].sbsp_printoption_id != -1)
			option = params[0].sbsp_printoption_id;
		else
			option = choosePrintOptionId(options);
		
		LinkedList<Copy> testcopies = new LinkedList<Copy>();
		
		for (Copy c : copies) {
			if (!(c.sbsp_printoption_id != option && c.sbsp_printoption_id != 0))
				testcopies.add(c);	
			}
		return testcopies;
	}
	
	/**
	 * Show dialog for the user to choose a print option.
	 * @param options - A set of all options that are available
	 * @return The user's chosen option
	 * @throws Exception - If lookup fails, the window times out or if called from process
	 */
	private int choosePrintOptionId (HashSet<Integer> options) throws Exception {
		if (isCalledFromProcess) 
			throw new CalledFromProcessException();
		
		var optArr = options.toArray(new Integer[options.size()]);

		CompletableFuture<Object> future = new CompletableFuture<>();
		
		StringBuilder validation = new StringBuilder("sbsp_printoption.sbsp_printoption_id IN (");
		if (optArr.length > 0)
			validation.append(optArr[0]);
		for (int i = 1; i < optArr.length; i++)
			validation.append(",").append(optArr[i]);
		validation.append(") AND sbsp_printoption.islimitedtoprocess = 'N'");
		MLookup lookup = MLookupFactory.get(
				Env.getCtx(), 
				windowno,
				1000191, /*sbsp_printoption.value*/
				DisplayType.TableDir, 
				Env.getLanguage(Env.getCtx()), 
				"sbsp_printoption_ID",
				19, /*table direct*/
				false,
				validation.toString());
		
		
		WEditor editor = new WRadioGroupEditor(lookup, "", "", true, false, true);

		
		String msg = Msg.getMsg(Env.getCtx(), "sbsp_printoptiondialog");
		
	
		Dialog.askForInput(windowno, editor, msg, (obj) -> {
			ServerPrintWorkerParam param = 
					new ServerPrintWorkerParamBuilder(params[0])
						.setSbsp_printoption_id(obj == null ? 0 : (Integer) obj)
						.build();
			var worker = new ServerPrintWorker(isCalledFromProcess, windowno);
			worker.prepare(param);
			try {
				worker.start();
				ADWindow.get(windowno).getADWindowContent().getStatusBar().setStatusLine(Msg.getMsg(Env.getCtx(), "Printedsuccessfully"), false);
			} catch (Exception e) {
				CLogger.get().log(Level.WARNING, "", e);
				ADWindowContent windowContent = ADWindow.get(windowno).getADWindowContent();
				windowContent.getStatusBar().setStatusLine(e.getLocalizedMessage(), true);
				windowContent.getStatusBar().focus();
			}
		});
		
		
		Object rtn = future.get(10, TimeUnit.SECONDS);
		return rtn == null ? 0 : (Integer) rtn;
	}

	private List<ServerPrintCopyParam> getSubParams (ServerPrintWorkerParam[] subParams, int printoption_id) throws SQLException {
		LinkedList<ServerPrintCopyParam> rtn = new LinkedList<>();
		
		ResultSet rs = null;
		for (var param : subParams) {
			PreparedStatement ps = DB.prepareStatement(Copy.SQL_QUERY, trxName);
			try {
				ps.setInt(1, param.ad_client_id);
				ps.setInt(2, param.ad_org_id);
				ps.setInt(3, param.c_bpartner_id);
				ps.setInt(4, param.ad_user_id);
				ps.setInt(5, param.c_doctype_id);
				ps.setInt(6, param.ad_tab_id);
				ps.setString(7, isCalledFromProcess ? "Y" : "N");
				
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getInt("sbsp_printoption_id") != printoption_id
							&& rs.getInt("sbsp_printoption_id") != 0)
						continue;
					
					rtn.add(new ServerPrintCopyParamBuilder(trxName)
					.setFromResultSet(rs)
					.setAd_user_id_bpartner(param.ad_user_id_bpartner)
					.setAd_table_id(param.ad_table_id)
					.setRecord_id(param.record_id)
					.setProcessParams(param.parameter)
					.build());
				}
			} finally {
				DB.close(rs, ps);
			}
		}
		
		return rtn;
	}
}
