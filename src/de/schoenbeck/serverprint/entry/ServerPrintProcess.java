package de.schoenbeck.serverprint.entry;

import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Msg;

import de.schoenbeck.serverprint.params.ServerPrintWorkerParam;
import de.schoenbeck.serverprint.params.ServerPrintWorkerParamBuilder;
import de.schoenbeck.serverprint.work.ServerPrintWorker;

public class ServerPrintProcess extends SvrProcess {

	int ad_client_id, ad_org_id, c_bpartner_id, ad_user_id, c_doctype_id, ad_tab_id, ad_table_id, ad_user_id_bpartner, printoption_id, record_id;
	
	public ServerPrintProcess() {
		
	}

	@Override
	protected void prepare() {
		
		//get Parameters 
		ProcessInfoParameter[] paras = getParameter();
		for (ProcessInfoParameter p : paras) {
			switch (p.getParameterName()) {
			case "AD_Client_ID":
				ad_client_id = p.getParameterAsInt();
				break;
			case "AD_Org_ID":
				ad_org_id = p.getParameterAsInt();
				break;
			case "C_BPartner_ID":
				c_bpartner_id = p.getParameterAsInt();
				break;
			case "AD_User_ID":
				ad_user_id = p.getParameterAsInt();
				break;
			case "C_DocType_ID":
				c_doctype_id = p.getParameterAsInt();
				break;
			case "AD_Tab_ID":
				ad_tab_id = p.getParameterAsInt();
				break;
			case "AD_Table_ID":
				ad_table_id = p.getParameterAsInt();
				break;
			case "AD_User_ID_bpartner": //for compatibility
			case "BPartner_AD_User_ID":
				ad_user_id_bpartner = p.getParameterAsInt();
				break;
			case "sbsp_printoption_ID":
				printoption_id = p.getParameterAsInt();
				break;
			default:
				log.info("Unknown Parameter: " + p.getParameterName());
				break;
			}
		}
		record_id = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		
		ServerPrintWorkerParam param = 
				new ServerPrintWorkerParamBuilder()
					.setAd_client_id(ad_client_id)
					.setAd_org_id(ad_org_id)
					.setAd_tab_id(ad_tab_id)
					.setAd_table_id(ad_table_id)
					.setAd_user_id(ad_user_id)
					.setAd_user_id_bpartner(ad_user_id_bpartner)
					.setC_bpartner_id(c_bpartner_id)
					.setC_doctype_id(c_doctype_id)
					.setSbsp_printoption_id(printoption_id)
					.setRecord_id(record_id)
					.setProcessParameters(getParameter())
					.build();
		
		ServerPrintWorker worker = new ServerPrintWorker(true, 0);
		worker.prepare(param);
		worker.start();
		return Msg.getMsg(Env.getCtx(), "Printedsuccessfully");
	}

}
