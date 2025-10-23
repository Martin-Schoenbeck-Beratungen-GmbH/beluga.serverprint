package de.schoenbeck.serverprint.params;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Set;

import org.compiere.model.MBPartner;
import org.compiere.model.MDocType;
import org.compiere.model.MUser;
import org.compiere.process.ProcessInfoParameter;

import de.schoenbeck.serverprint.model.X_sbsp_copy;
import de.schoenbeck.serverprint.work.Copy;

public class ServerPrintCopyParamBuilder {

	int ad_client_id = 0;
	int ad_org_id = 0;
	int ad_user_id = 0;
	int c_bpartner_id = 0;
	int c_doctype_id = 0;
	int sbsp_printconfig_id = 0;
	int ad_process_id = 0;
	String reportVariant = "";
	String exportFileExtension = "";
	String exportFilenamePattern = "";
	String depositPath = "";
	int from_ad_user_id = 0;
	int r_mailtext_id = 0;
	int copies = 0;
	String eMailTo = "";
	Set<String> eMailCc = Collections.emptySet();
	Set<String> eMailBcc = Collections.emptySet();
	String eMailFromQuery = null;
	String[] mailAttPrefix = {};
	
	boolean toArchive = false;
	boolean useFromArchive = false;
	boolean mailtouser = false;
	boolean mailtoaddress = false;
	boolean senddirectly = false;
	boolean actualuserasfrom = false;
	
	int ad_table_id = 0;
	int ad_user_id_bpartner = 0;
	int record_id = 0;
	
	int sbsp_printoption_id = 0;
	
	int sbsp_copy_id = 0;
	
	int windowno = 0;
	boolean isCalledFromProcess = true;
	ProcessInfoParameter[] processParams = {};
	public final String trxname;
	
	/**
	 * Values are initialized as follows:
	 * <ul>
	 * <li>All integers are 0.</li>
	 * <li>All booleans are false.</li>
	 * <li>All strings are the empty string.</li>
	 * <li>All iterables are of length 0.</li>
	 * </ul>
	 * @param trxname
	 */
	public ServerPrintCopyParamBuilder (String trxname) {
		this.trxname = trxname;
	}
	
	public ServerPrintCopyParamBuilder setFromResultSet (ResultSet rs) throws SQLException {
		this.ad_client_id = rs.getInt(X_sbsp_copy.COLUMNNAME_AD_Client_ID);
		this.ad_org_id = rs.getInt(X_sbsp_copy.COLUMNNAME_AD_Org_ID);
		this.ad_user_id = rs.getInt(MUser.COLUMNNAME_AD_User_ID);
		this.c_bpartner_id = rs.getInt(MBPartner.COLUMNNAME_C_BPartner_ID);
		this.c_doctype_id = rs.getInt(MDocType.COLUMNNAME_C_DocType_ID);
		
		this.sbsp_printconfig_id = rs.getInt(X_sbsp_copy.COLUMNNAME_sbsp_printconfig_ID);
		this.ad_process_id = rs.getInt(X_sbsp_copy.COLUMNNAME_AD_Process_ID);
		this.reportVariant = nvl(rs.getString(X_sbsp_copy.COLUMNNAME_ReportVariant));
		String extension = nvl(rs.getString(X_sbsp_copy.COLUMNNAME_ExportFileExtension));
		if (extension != null && extension.equals(""))
			extension = "pdf";
		this.exportFileExtension = extension;
		this.exportFilenamePattern = nvl(rs.getString(X_sbsp_copy.COLUMNNAME_ExportFilenamePattern));
		
		this.depositPath = nvl(rs.getString(X_sbsp_copy.COLUMNNAME_DepositPath));
		this.toArchive = rs.getString(X_sbsp_copy.COLUMNNAME_toArchive).equals("Y");
		this.useFromArchive = rs.getString(X_sbsp_copy.COLUMNNAME_use_existing).equals("Y");
		
		this.from_ad_user_id = rs.getInt(X_sbsp_copy.COLUMNNAME_From_AD_User_ID);
		this.r_mailtext_id = rs.getInt(X_sbsp_copy.COLUMNNAME_R_MailText_ID);
		this.copies = (rs.getObject(X_sbsp_copy.COLUMNNAME_copies) == null) ? (1) : rs.getInt(X_sbsp_copy.COLUMNNAME_copies);
		
		this.eMailTo = nvl(rs.getString(X_sbsp_copy.COLUMNNAME_EMail_To));
		this.eMailCc = Copy.makeCcList(rs.getString(X_sbsp_copy.COLUMNNAME_EMail_CC));
		this.eMailBcc = Copy.makeCcList(rs.getString(X_sbsp_copy.COLUMNNAME_RecipientBcc));
		this.eMailFromQuery = rs.getString("mailquery");
		this.mailAttPrefix = ( (rs.getString(X_sbsp_copy.COLUMNNAME_mailattachment_prefix) != null) ? (rs.getString(X_sbsp_copy.COLUMNNAME_mailattachment_prefix).split(",")) : new String[0] );
		this.mailtoaddress = rs.getString(X_sbsp_copy.COLUMNNAME_mailToAddress).equals("Y");
		this.mailtouser = rs.getString(X_sbsp_copy.COLUMNNAME_mailToUser).equals("Y");
		this.senddirectly = rs.getString(X_sbsp_copy.COLUMNNAME_senddirectly).equals("Y");
		this.actualuserasfrom = rs.getString(X_sbsp_copy.COLUMNNAME_actualUserAsFrom).equals("Y");
		
		this.sbsp_printoption_id = rs.getInt(X_sbsp_copy.COLUMNNAME_sbsp_printoption_ID);
		
		this.sbsp_copy_id = rs.getInt(X_sbsp_copy.COLUMNNAME_sbsp_copy_ID);
		
		return this;
	}
	
	public ServerPrintCopyParamBuilder setAd_client_id(int ad_client_id) {
		this.ad_client_id = ad_client_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_org_id(int ad_org_id) {
		this.ad_org_id = ad_org_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_user_id(int ad_user_id) {
		this.ad_user_id = ad_user_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setC_bpartner_id(int c_bpartner_id) {
		this.c_bpartner_id = c_bpartner_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setC_doctype_id(int c_doctype_id) {
		this.c_doctype_id = c_doctype_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setSbsp_printconfig_id(int sbsp_printconfig_id) {
		this.sbsp_printconfig_id = sbsp_printconfig_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_process_id(int ad_process_id) {
		this.ad_process_id = ad_process_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setReportVariant(String reportVariant) {
		this.reportVariant = nvl(reportVariant);
		return this;
	}

	public ServerPrintCopyParamBuilder setExportFileExtension(String exportFileExtension) {
		this.exportFileExtension = nvl(exportFileExtension);
		return this;
	}

	public ServerPrintCopyParamBuilder setExportFilenamePattern(String exportFilenamePattern) {
		this.exportFilenamePattern = nvl(exportFilenamePattern);
		return this;
	}

	public ServerPrintCopyParamBuilder setDepositPath(String depositPath) {
		this.depositPath = nvl(depositPath);
		return this;
	}

	public ServerPrintCopyParamBuilder setFrom_ad_user_id(int from_ad_user_id) {
		this.from_ad_user_id = from_ad_user_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setR_mailtext_id(int r_mailtext_id) {
		this.r_mailtext_id = r_mailtext_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setCopies(int copies) {
		this.copies = copies;
		return this;
	}

	public ServerPrintCopyParamBuilder seteMailTo(String eMailTo) {
		this.eMailTo = nvl(eMailTo);
		return this;
	}

	public ServerPrintCopyParamBuilder seteMailCc(Set<String> eMailCc) {
		this.eMailCc = (eMailCc != null) ? eMailCc : Collections.emptySet();
		return this;
	}

	public ServerPrintCopyParamBuilder seteMailBcc(Set<String> eMailBcc) {
		this.eMailBcc = (eMailBcc != null) ? eMailBcc : Collections.emptySet();
		return this;
	}
	
	public ServerPrintCopyParamBuilder seteMailFromQuery(String eMailFromQuery) {
		this.eMailFromQuery = eMailFromQuery;
		return this;
	}
	
	public ServerPrintCopyParamBuilder setMailAttPrefix(String[] mailAttPrefix) {
		this.mailAttPrefix = (mailAttPrefix != null) ? mailAttPrefix : new String[0];
		return this;
	}

	public ServerPrintCopyParamBuilder setToArchive(boolean toArchive) {
		this.toArchive = toArchive;
		return this;
	}

	public ServerPrintCopyParamBuilder setMailtouser(boolean mailtouser) {
		this.mailtouser = mailtouser;
		return this;
	}

	public ServerPrintCopyParamBuilder setMailtoaddress(boolean mailtoaddress) {
		this.mailtoaddress = mailtoaddress;
		return this;
	}

	public ServerPrintCopyParamBuilder setSenddirectly(boolean senddirectly) {
		this.senddirectly = senddirectly;
		return this;
	}

	public ServerPrintCopyParamBuilder setActualuserasfrom(boolean actualuserasfrom) {
		this.actualuserasfrom = actualuserasfrom;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_table_id(int ad_table_id) {
		this.ad_table_id = ad_table_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setAd_user_id_bpartner(int ad_user_id_bpartner) {
		this.ad_user_id_bpartner = ad_user_id_bpartner;
		return this;
	}

	public ServerPrintCopyParamBuilder setRecord_id(int record_id) {
		this.record_id = record_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setSbsp_printoption_id(int sbsp_printoption_id) {
		this.sbsp_printoption_id = sbsp_printoption_id;
		return this;
	}
	
	public ServerPrintCopyParamBuilder setSbsp_copy_id(int sbsp_copy_id) {
		this.sbsp_copy_id = sbsp_copy_id;
		return this;
	}

	public ServerPrintCopyParamBuilder setWindowno(int windowno) {
		this.windowno = windowno;
		return this;
	}

	public ServerPrintCopyParamBuilder setCalledFromProcess(boolean isCalledFromProcess) {
		this.isCalledFromProcess = isCalledFromProcess;
		return this;
	}
	
	public ServerPrintCopyParamBuilder setProcessParams(ProcessInfoParameter[] params) {
		this.processParams = params;
		return this;
	}

	public ServerPrintCopyParam build () throws SQLException {
		return new ServerPrintCopyParam(this);
	}
	
	private String nvl (String s) {
		return (s == null) ? "" : s;
	}
}
