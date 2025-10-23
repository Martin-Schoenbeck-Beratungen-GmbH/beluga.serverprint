package de.schoenbeck.serverprint.params;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;

import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.util.DB;
import org.compiere.util.Env;

import de.schoenbeck.serverprint.work.Copy;

public class ServerPrintCopyParam {

	public final int ad_client_id;
	public final int ad_org_id;
	public final int ad_user_id;
	public final int c_bpartner_id;
	public final int c_doctype_id;
	public final int sbsp_printconfig_id;
	public final int ad_process_id;
	public final String reportVariant;
	public final String exportFileExtension;
	public final String exportFilenamePattern;
	public final String depositPath;
	public final int from_ad_user_id;
	public final int r_mailtext_id;
	public final int copies;
	public final String eMailTo;
	public final Set<String> eMailCc;
	public final Set<String> eMailBcc;
	public final Set<String> eMailFromQuery;
	public final String[] mailAttPrefix;
	
	public final boolean toArchive;
	public final boolean useFromArchive;
	public final boolean mailtouser;
	public final boolean mailtoaddress;
	public final boolean senddirectly;
	public final boolean actualuserasfrom;
	
	public final int ad_table_id;
	public final int ad_user_id_bpartner;
	public final int record_id;
	
	public final int sbsp_printoption_id;
	
	public final int sbsp_copy_id;
	
	public final int windowno = 0;
	public final boolean isCalledFromProcess;
	public final ProcessInfoParameter[] processParams;
	public final String trxname;
	
	
	ServerPrintCopyParam(ServerPrintCopyParamBuilder b) throws SQLException {
		this.ad_client_id = b.ad_client_id;
		this.ad_org_id = b.ad_org_id;
		this.ad_user_id = b.ad_user_id;
		this.c_bpartner_id = b.c_bpartner_id;
		this.c_doctype_id = b.c_doctype_id;
		this.sbsp_printconfig_id = b.sbsp_printconfig_id;
		this.ad_process_id = b.ad_process_id;
		this.reportVariant = b.reportVariant;
		this.exportFileExtension = b.exportFileExtension;
		this.exportFilenamePattern = b.exportFilenamePattern;
		this.depositPath = b.depositPath;
		this.from_ad_user_id = b.from_ad_user_id;
		this.r_mailtext_id = b.r_mailtext_id;
		this.copies = b.copies;
		this.eMailTo = b.eMailTo;
		this.eMailCc = b.eMailCc;
		this.eMailBcc = b.eMailBcc;
		this.mailAttPrefix = b.mailAttPrefix;
		this.toArchive = b.toArchive;
		this.useFromArchive = b.useFromArchive;
		this.mailtouser = b.mailtouser;
		this.mailtoaddress = b.mailtoaddress;
		this.senddirectly = b.senddirectly;
		this.actualuserasfrom = b.actualuserasfrom;
		this.ad_table_id = b.ad_table_id;
		this.ad_user_id_bpartner = b.ad_user_id_bpartner;
		this.record_id = b.record_id;
		this.isCalledFromProcess = b.isCalledFromProcess;
		this.trxname = b.trxname;
		this.sbsp_printoption_id = b.sbsp_printoption_id;
		this.sbsp_copy_id = b.sbsp_copy_id;
		this.processParams = b.processParams;
		
		this.eMailFromQuery = b.eMailFromQuery != null ? executeMailQuery(b.eMailFromQuery) : Collections.emptySet();
	}

	/**
	 * Executes the query to gather more email addresses.
	 * Does so as early as possible to fail fast.
	 * <br>
	 * Warning: Token replacement syntax is not injection-safe!
	 * @param eMailFromQuery - A syntactically correct and injection-safe SQL Query
	 * @return A Set of mail addresses
	 * @throws SQLException
	 */
	private Set<String> executeMailQuery(String eMailFromQuery) throws SQLException {
		String sql = replaceTokens(eMailFromQuery);
		Set<String> rtn = new HashSet<>();
		
		PreparedStatement ps = DB.prepareStatement(sql, this.trxname);
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
			while (rs.next())
				rtn.add(rs.getString(1));
		}finally {
			DB.close(rs, ps);
		}
		
		return rtn;
	}
	private String replaceTokens(String rawSQL) {
		PO record = MTable.get(this.ad_table_id).getPO(this.record_id, null);
		String rtn = rawSQL;
		
		final Matcher replacements = Copy.TITLE_REPLACE_REGEX.matcher(rtn);
		while (replacements.find()) {
			int index = record.get_ColumnIndex(replacements.group(1));
			if (index >= 0)
				rtn = rtn.replaceFirst(Matcher.quoteReplacement(replacements.group(0)), record.get_Value(index).toString());
		}
		
		return Env.parseContext(Env.getCtx(), this.windowno, rtn, false, true);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ad_process_id, ad_table_id, exportFileExtension, record_id, reportVariant, useFromArchive);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerPrintCopyParam other = (ServerPrintCopyParam) obj;
		return ad_process_id == other.ad_process_id && ad_table_id == other.ad_table_id
				&& Objects.equals(exportFileExtension, other.exportFileExtension) && record_id == other.record_id
				&& Objects.equals(reportVariant, other.reportVariant) && useFromArchive == other.useFromArchive;
	}

}
