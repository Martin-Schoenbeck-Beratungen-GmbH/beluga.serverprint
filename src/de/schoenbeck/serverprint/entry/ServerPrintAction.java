package de.schoenbeck.serverprint.entry;

import java.util.logging.Level;

import org.adempiere.webui.action.IAction;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.adwindow.ADWindowContent;
import org.compiere.model.GridTab;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import de.schoenbeck.serverprint.params.ServerPrintWorkerParam;
import de.schoenbeck.serverprint.params.ServerPrintWorkerParamBuilder;
import de.schoenbeck.serverprint.work.ServerPrintWorker;

public class ServerPrintAction implements IAction {

	public ServerPrintAction() {}

	@Override
	public void execute(Object target) {
		
		ADWindowContent windowContent = ((ADWindow)target).getADWindowContent();
		GridTab tab = windowContent.getActiveGridTab();
		
		ServerPrintWorkerParam param = 
				new ServerPrintWorkerParamBuilder()
					.setAd_client_id(Env.getAD_Client_ID(Env.getCtx()))
					.setAd_user_id(Env.getAD_User_ID(Env.getCtx()))
					.setC_bpartner_id(integerToInt( (Integer)(tab.getValue("c_bpartner_id")) ))
					.setAd_user_id_bpartner(integerToInt( (Integer)(tab.getValue("ad_user_id")) ))
					.setAd_org_id(integerToInt( (Integer)(tab.getValue("ad_org_id")) ))
					.setC_doctype_id(integerToInt( (Integer)(tab.getValue("c_doctype_id")) ))
					.setAd_tab_id(tab.getAD_Tab_ID())
					.setAd_table_id(tab.getAD_Table_ID())
					.setRecord_id(tab.getRecord_ID())
					.build();
		
		ServerPrintWorker worker = new ServerPrintWorker(false, windowContent.getWindowNo());
		worker.prepare(param);
		
		try {
			worker.start();
			windowContent.getStatusBar().setStatusLine(Msg.getMsg(Env.getCtx(), "Printedsuccessfully"), false);
		} catch (Exception e) {
			CLogger.get().log(Level.WARNING, "", e);
			windowContent.getStatusBar().setStatusLine(e.getLocalizedMessage(), true);
			windowContent.getStatusBar().focus();
		}
	}

	private int integerToInt (Integer object) {
		return object != null ? object : 0;
	}
	
}
