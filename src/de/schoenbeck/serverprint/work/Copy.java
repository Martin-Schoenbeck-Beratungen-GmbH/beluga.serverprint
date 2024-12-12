package de.schoenbeck.serverprint.work;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.FileDataSource;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.apps.AEnv;
import org.compiere.model.MArchive;
import org.compiere.model.MAttachmentEntry;
import org.compiere.model.MClient;
import org.compiere.model.MMailText;
import org.compiere.model.MPInstance;
import org.compiere.model.MTable;
import org.compiere.model.MUser;
import org.compiere.model.MUserMail;
import org.compiere.model.PO;
import org.compiere.model.PrintInfo;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.ServerProcessCtl;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.EMail;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.jfree.io.IOUtils;

import de.schoenbeck.serverprint.exceptions.CalledFromProcessException;
import de.schoenbeck.serverprint.exceptions.InvalidMailAddressException;
import de.schoenbeck.serverprint.exceptions.MailNotSentException;
import de.schoenbeck.serverprint.exceptions.NoTemplateException;
import de.schoenbeck.serverprint.exceptions.TemplateNotFoundException;
import de.schoenbeck.serverprint.helper.SBSP_EMailDialog;
import de.schoenbeck.serverprint.model.MPrinter;
import de.schoenbeck.serverprint.model.MPrinterProvider;
import de.schoenbeck.serverprint.model.X_sbsp_copy;
import de.schoenbeck.serverprint.params.ServerPrintCopyParam;
import de.schoenbeck.serverprint.printProvider.ServerPrintProcessManager;

public class Copy {

	public static final String SQL_QUERY =
		"with params as"
         + "     (select ? ad_client_id,"
		 + "             ? ad_org_id,"
		 + "             ? c_bpartner_id,"
		 + "             ? ad_user_id,"
		 + "             cast (? as numeric) c_doctype_id,"
		 + "             cast (? as numeric) ad_tab_id,"
		 + "			 ? calledfromprocess),"
		 /* subquery subprofiles looks up a list of applicable subprofiles for each present copytype
		  * this subprofiles are then sorted by priority and those with both a tab and a doctype first,
		  * then those with only a doctype and then those with only a tab. Only the first of them is
		  * delivered, so that for each copytype one or no subprofile is delivered
		  */
		 + "     subprofiles as "
         + "	 (select spp.sbsp_subprintprofile_id,"
         + "	             cptype.sbsp_copytype_id "
         + "	        from sbsp_copytype cptype,"
         + "		     	 sbsp_subprintprofile spp,"
         + "				 params "
		 + "		   where cptype.ad_client_id = params.ad_client_id "
		 + "		  	 and cptype.isactive = 'Y' "
		 + "		     and spp.sbsp_subprintprofile_id in " 
		 + "				   (select sp.sbsp_subprintprofile_id " 
		 + "	           	      from sbsp_printprofile pp,"
		 + "	           		       sbsp_copy cp,"
		 + "	           		       sbsp_subprintprofile sp "
		 + "			         where sp.sbsp_printprofile_id = pp.sbsp_printprofile_id "
		 + "		        	   and sp.ad_client_id = params.ad_client_id "
		 + "		               and cp.ad_client_id = params.ad_client_id "
		 + "			           and pp.ad_client_id = params.ad_client_id "
		 + "			           and (pp.isstandardprintprofile = 'Y' "
		 + "			                or pp.sbsp_printprofile_id in "
		 + "			                    (select ppl.sbsp_printprofile_id "
		 + "			                       from sbsp_printprofilelink ppl "
		 + "			                      where ppl.ad_client_id = params.ad_client_id "
		 + "			                        and (ppl.ad_org_id = 0 or ppl.ad_org_id = params.ad_org_id) "
		 + "			                        and (ppl.c_bpartner_id = params.c_bpartner_id "
		 + "			                             or ppl.ad_user_id = params.ad_user_id)"
		 + "			                        and ppl.isactive = 'Y'))"
		 + "			           and (sp.ad_org_id = 0 or sp.ad_org_id = params.ad_org_id)"
		 + "		               and (pp.ad_org_id = 0 or pp.ad_org_id = params.ad_org_id)"
		 + "			           and (cp.ad_org_id = 0 or cp.ad_org_id = params.ad_org_id)"
		 + "			           and (sp.c_doctype_id = params.c_doctype_id or sp.ad_tab_id = params.ad_tab_id)"      
		 + "		               and cp.sbsp_subprintprofile_id = sp.sbsp_subprintprofile_id "
		 + "		               and cp.sbsp_copytype_id = cptype.sbsp_copytype_id "
		 + "		               and pp.isactive = 'Y' "
		 + "		               and cp.isactive = 'Y' "
		 + "		               and sp.isactive = 'Y' "		            
		 + "	     	          order by pp.printpriority desc,"
		 + "	                        pp.isstandardprintprofile,"
		 + "	                        pp.ad_org_id desc,"			 
		 + "	                        sp.c_doctype_id nulls last,"
		 + "	                        sp.ad_tab_id nulls last "
		 + "		              fetch first row only))"
		 /* with the previously selected subprofiles now select all copy entries, but only those
		  * which are defined for that copytype the subprofile was chosen for. Sorted by ad_process_id
		  * so that each jasper report has to be run only once as soon as it is found 
		  */
		 + "	 select params.c_bpartner_id, params.ad_user_id, params.ad_org_id, params.ad_tab_id, params.c_doctype_id, cp.* "
		 + "	   from subprofiles sub,"
		 + "	        sbsp_copy cp,"
		 + "	        params "
		 + "	  where cp.sbsp_subprintprofile_id = sub.sbsp_subprintprofile_id "
		 + "	    and cp.sbsp_copytype_id = sub.sbsp_copytype_id "
		 + "	    and cp.ad_client_id = params.ad_client_id "
		 + "	    and cp.isactive = 'Y' "
		 + "	    and (cp.ad_org_id = 0 or cp.ad_org_id = params.ad_org_id)"
		 + "		and (coalesce(cp.sbsp_printoption_id,0) = 0 "
		 + "			or exists (select 1 from sbsp_printoption po "
		 + "						WHERE cp.sbsp_printoption_id = po.sbsp_printoption_id "
		 + "						and (po.islimitedtoprocess = 'N' "
		 + "							or po.islimitedtoprocess = params.calledfromprocess)"
		 + "						AND po.isactive = 'Y'))"
		 + "      order by cp.sbsp_copytype_id, cp.reportvariant";
	
	
	private ServerPrintCopyParam[] copyParams;
	public final int sbsp_printoption_id;
	
	public Copy (ServerPrintCopyParam[] params) {
		copyParams = params;
		this.sbsp_printoption_id = params[0].sbsp_printoption_id;
	}
	

	public void execute (Map<ServerPrintCopyParam, File> files) throws Exception {
		
		LinkedList<File> mailFileList = new LinkedList<>();
		for (ServerPrintCopyParam p : copyParams) {
			
			if (!files.containsKey(p))
				files.put(p, prepareReport(p));
			File file = files.get(p);
		
			if (p.toArchive) {
	    		archive(p, file);
	    	}
	    	if (p.sbsp_printconfig_id > 0 && p.copies > 0) {
	    		print(p, file);
	    	}
	    	mailFileList.add(file);
	    	if (!p.depositPath.equals("")) {
	    		saveFile(p, file);
	    	}
		}

		if (copyParams[0].mailtouser || copyParams[0].mailtoaddress) {
			sendMail(copyParams[0], mailFileList.toArray(new File[mailFileList.size()]));
		}
	}
	
	public static File prepareReport (ServerPrintCopyParam p) {

		try {
			if (p.useFromArchive) {
				String fileName = p.reportVariant == "" || p.reportVariant == null 
						? "%#." + p.exportFileExtension
						: "%." + p.reportVariant + "." + p.exportFileExtension;
				
				final String sql = "ad_client_id = ? "
							+ "AND ad_table_id = ? "
							+ "AND record_id = ? "
							+ "AND name LIKE ? ";
				
				MArchive doc = new Query(Env.getCtx(), MArchive.Table_Name, sql, null)
						.setParameters(p.ad_client_id, p.ad_table_id, p.record_id, fileName)
						.setOrderBy(MArchive.COLUMNNAME_Created + " desc")
						.first();
				
				if (doc != null) {
					doc.setName(doc.getName().replace("#" + "." + p.exportFileExtension, "." + p.exportFileExtension));
					doc.setName(doc.getName().replace("." + p.reportVariant + "." + p.exportFileExtension, "." + p.exportFileExtension));
					String path = System.getProperty("java.io.tmpdir") + File.separator + doc.getName();
					File rtn = new File(path);
					//FIXME
					rtn.delete();
					try (FileOutputStream outputStream = new FileOutputStream(rtn)) {
					    outputStream.write(doc.getBinaryData());
					}
					return rtn;
				}
			}
		} catch (IOException e) {
			CLogger.get().log(Level.SEVERE, "Exception loading file from archive", e);
			return null;
		}
		
		ProcessInfo reportPI = new ProcessInfo("Document", p.ad_process_id, p.ad_table_id, p.record_id);
		var params = new ProcessInfoParameter[p.processParams.length + 2];
		params[0] =	new ProcessInfoParameter("C_Doctype_ID", p.c_doctype_id, null,"","");
		params[1] = new ProcessInfoParameter("ReportVariant", p.reportVariant, null,"","");
		for (int i = 2; i < params.length; i++)
			params[i] = p.processParams[i-2];
		reportPI.setParameter(params);
		
		MPInstance mpi = new MPInstance(Env.getCtx(), 0, null);
		mpi.setAD_Process_ID(p.ad_process_id); 
		mpi.setRecord_ID(p.record_id);
		mpi.save();
		reportPI.setAD_PInstance_ID(mpi.getAD_PInstance_ID());
		reportPI.setExport(true);
		reportPI.setIsBatch(true);
		reportPI.setPrintPreview(true);
		reportPI.setReportingProcess(true);
		if (p.exportFileExtension != null) {
			reportPI.setExportFileExtension(p.exportFileExtension);
			reportPI.setReportType(p.exportFileExtension.toUpperCase());
		}
		
		ServerProcessCtl process = new ServerProcessCtl(reportPI, null);
		process.run();
		if (reportPI.isError())
			throw new AdempiereException(Msg.getMsg(Env.getAD_Language(Env.getCtx()), "@Error@") + reportPI.getSummary());
		
		File export = reportPI.getExportFile();
		if (export == null)
			export = reportPI.getPDFReport();
		if (export == null)
			throw new AdempiereException("No Report returned");
		
		String title = createReportTitle(p);
		if (title == null)
			return export;
		
		File rtn = new File(
				title + 
				(p.exportFilenamePattern.equals("") ? java.lang.Math.abs(new java.util.Random().nextInt(1000000)) : "") + //add a random number to temporary files
				"." + (p.exportFileExtension.startsWith(".") ? p.exportFileExtension.substring(1) : p.exportFileExtension));
		export.renameTo(rtn);
		return rtn;
	}
	
	
	// PRIVATE METHODS ////
	
	private static final Pattern TITLE_REPLACE_REGEX = Pattern.compile("@\\$([^@ \\n]+)@");
	private static String createReportTitle(ServerPrintCopyParam p) {
		if (p.exportFilenamePattern == null || p.exportFilenamePattern.equals(""))
			return null;
		
		PO record = MTable.get(p.ad_table_id).getPO(p.record_id, null);
		
		String rtn = p.exportFilenamePattern;
		
		final Matcher replacements = TITLE_REPLACE_REGEX.matcher(rtn);
		while (replacements.find()) {
			int index = record.get_ColumnIndex(replacements.group(1));
			if (index >= 0)
				rtn = rtn.replaceFirst(Matcher.quoteReplacement(replacements.group(0)), record.get_Value(index).toString());
		}
		
		
		return Env.parseContext(Env.getCtx(), p.windowno, rtn, false, true);
	}
	
	private static void archive (ServerPrintCopyParam p, File printedDoc) throws IOException {
		
		String fileName = p.reportVariant == "" || p.reportVariant == null 
						? "%#." + p.exportFileExtension
						: "%." + p.reportVariant + "." + p.exportFileExtension;
		
		// don't archive a doc we have taken from the archive!
		final String sql = "ad_client_id = ? "
				+ "AND ad_table_id = ? "
				+ "AND record_id = ? "
				+ "AND name LIKE ? ";
		if (p.useFromArchive
				&& new Query(Env.getCtx(), MArchive.Table_Name, sql, null)
				.setParameters(p.ad_client_id, p.ad_table_id, p.record_id, fileName)
				.match()
				)
			return;
		
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(printedDoc);
			BufferedInputStream bis = new BufferedInputStream(fis);
			IOUtils.getInstance().copyStreams(bis, bas);
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		byte[] data = bas.toByteArray();  
		
		String printedDocName = p.reportVariant == "" || p.reportVariant == null 
								? printedDoc.getName().replace("." + p.exportFileExtension, "#" + "." + p.exportFileExtension)
		                 		: printedDoc.getName().replace("." + p.exportFileExtension, "." + p.reportVariant + "." + p.exportFileExtension);
		
		PrintInfo pinfo = new PrintInfo (printedDocName, p.ad_table_id, p.record_id, p.c_bpartner_id);
		MArchive archive = new MArchive (Env.getCtx(), pinfo, p.trxname);
		archive.setBinaryData(data);
		archive.saveEx();
	}
	
	private static void print (ServerPrintCopyParam p, File printedDoc) throws Exception {
		PrinterConfig conf = printPreparation(p, new FileInputStream(printedDoc), null); //TODO: pass trxname
		try {
			ServerPrintProcessManager.getPrint(conf.provider.getProtocol())
				.ifPresentOrElse(
						(pRun) -> {try {
							pRun.run(conf);
						} catch (Exception e) {
							throw new RuntimeException(e);
						}}, 
						() -> {throw new RuntimeException("No implementation for such provider");}
				);
		} catch (RuntimeException e) {
			if (e.getCause() instanceof Exception)
				throw (Exception) e.getCause();
			else throw e;
		}
	}
	
	private static void sendMail (ServerPrintCopyParam p, File[] printedDoc) throws Exception {
		
		/* first setup mail contents */
    	MUser m_to = null;
    	MUser m_from = null;
    	String to = null;
    	StringBuilder message = null;
    	MMailText  m_MailText = null;
    	
		Properties props = System.getProperties();
		props.put("mail.mime.allowutf8", "true");


    	/* set mail of ad_user_id_bpartner as To: */
		if (p.mailtouser && p.ad_user_id_bpartner > 0)
			m_to = new MUser(Env.getCtx(), p.ad_user_id_bpartner, null);
		
    	if (p.mailtouser) {
    		if (m_to == null)
    			throw new NullPointerException(Msg.getMsg(Env.getCtx(), "Noemailto"));
    	    to = m_to.getEMail();
    	}
    	
    	if (p.mailtoaddress) {
    		if (p.mailtouser)
    			p.eMailCc.add(p.eMailTo); //set fixed mail address as CC
    		else 
    			to = p.eMailTo; //set fixed mail address as To
    	}
    	
    	if (to == null)
			throw new NullPointerException(Msg.getMsg(Env.getCtx(), "Noemailto"));

    	
    	if (p.r_mailtext_id > 0) {
    		m_MailText = new MMailText (Env.getCtx(), p.r_mailtext_id, p.trxname);
    		if (m_MailText.getR_MailText_ID() == 0)
    			throw new TemplateNotFoundException(p.r_mailtext_id);
    		m_MailText.setUser(m_to);		
    		m_MailText.setBPartner(m_to == null ? 0 : m_to.getC_BPartner_ID());
    		message = new StringBuilder(m_MailText.getMailText(true));	
    	}
    	else if (p.senddirectly) {
			throw new NoTemplateException();
    	}
    	/* set from if configured */	    	
    	if (p.actualuserasfrom || p.from_ad_user_id > 0) {
    		m_from = new MUser(null, p.actualuserasfrom ? p.ad_user_id : p.from_ad_user_id, null);
    	}
		
    	
    	// Actually send the mail
    	if (p.senddirectly)
    		sendMailDirectly(p, m_from, m_to, to, message.toString(), m_MailText, printedDoc);
    	else
    		openMailWindow(p, m_from, to, m_MailText, message, printedDoc);
	}
	
	private static void saveFile (ServerPrintCopyParam p, File printedDoc) throws Exception {
		
		Path target;
		if (p.depositPath.endsWith("/"))
    		target = Paths.get(p.depositPath, printedDoc.getName());
    	else {
    		String orderNr = (String) MTable.get(p.ad_table_id).getPO(p.record_id, null).get_Value("documentno");
    		target = Paths.get(p.depositPath + orderNr + ".pdf");
    	}
    	
    	Files.copy(printedDoc.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
	}
	
	
	// HELPER METHODS ////
	private static PrinterConfig printPreparation (ServerPrintCopyParam p, InputStream doc, String trxName) throws Exception {
		
		/* first retrieve the information for this printconfiguration */
    	PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			final String sql = 
			 "WITH params AS "
			 + "	(SELECT ? ad_client_id, "
			 + "	        ? ad_org_id, "
			 + "            ? sbsp_printconfig_id, "
			 + "            cast (? as numeric) ad_user_id) "
			 + "SELECT printer.sbsp_printer_id printer, printer.sbsp_printerprovider_id provider, pce.sbsp_printerconfig_id config "
			 + "FROM sbsp_printconfig pc, "
			 + "     sbsp_printconfig_entry pce, "
			 + "     sbsp_printer printer, "
			 + "     params "
			 + "WHERE pc.sbsp_printconfig_id = params.sbsp_printconfig_id "
			 + "	AND pc.isactive = 'Y' "
			 + "	AND pce.ad_client_id = params.ad_client_id "
			 + "	AND (pce.ad_org_id = 0 or pce.ad_org_id = params.ad_org_id) "
			 + "	AND pce.sbsp_printconfig_id = params.sbsp_printconfig_id "
			 + "	AND (pce.ad_user_id = params.ad_user_id or pce.isstandardprintconfig = 'Y') "
			 + "	AND pce.isactive = 'Y' "
			 + "	AND printer.sbsp_printer_id = pce.sbsp_printer_id "
			 + "ORDER BY pce.isstandardprintconfig ASC "
			 + "FETCH FIRST ROW ONLY"; 
			
			pstmt = DB.prepareStatement(sql, trxName);
			pstmt.setInt(1, p.ad_client_id);
			pstmt.setInt(2, p.ad_org_id);
			pstmt.setInt(3, p.sbsp_printconfig_id);
			pstmt.setInt(4, p.ad_user_id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { 
				MPrinter printer = new MPrinter(Env.getCtx(), rs.getInt("printer"), trxName);
				MPrinterProvider provider = new MPrinterProvider(Env.getCtx(), rs.getInt("provider"), trxName);
				int printerconfig_id = rs.getInt("config");
				
				return new PrinterConfig(printer, provider, doc, p, printerconfig_id);
			} 
			else {
				String err = determinePrintError(p);
				throw new AdempiereException(err);
			}
		} finally {
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
	}
	
	
	private static String determinePrintError (ServerPrintCopyParam p) {
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {
			String sql = 
			 "select name, isactive " + 
			 "from sbsp_printconfig " + 
			 "where sbsp_printconfig_id = ?"; 
			
			pstmt2 = DB.prepareStatement(sql, null);
			pstmt2.setInt(1, p.sbsp_printconfig_id);
			rs2 = pstmt2.executeQuery();						
			if (rs2.next()) { 
				if (rs2.getString("isactive").equals("Y")) {						
					return Msg.getMsg(Env.getCtx(), "NoPrintConfigEntryFound", new Object[] {rs2.getString("name")});
				}
				else {
					return Msg.getMsg(Env.getCtx(), "PrintConfigInactive", new Object[] {rs2.getString("name")});								
				}
			}
			else {
				return Msg.getMsg(Env.getCtx(), "PrintConfigNotFound");							
			}
		} catch (SQLException e) {
			CLogger.get().log(Level.WARNING, "", e);
			return "SQL Error during error determination: " + e.getLocalizedMessage();
		} finally {
			DB.close(rs2, pstmt2);
			rs2 = null; pstmt2 = null;
		}
	}

	private static LinkedList<File> collectAttachments (ServerPrintCopyParam p, File[] files) {
		LinkedList<File> rtn = new LinkedList<>();
		for (File printedDoc : files)
			rtn.add(printedDoc);
		
		try {
			MAttachmentEntry[] attachments = new MTable(Env.getCtx(), p.ad_table_id, p.trxname).getPO(p.record_id, p.trxname).getAttachment().getEntries();
			if (!attachments.equals(null) && attachments.length > 0)
				for (MAttachmentEntry entry : attachments)
					for (String prefix : p.mailAttPrefix)
						if (entry.getName().startsWith(prefix)) 
							rtn.add(entry.getFile());		
			
		} catch (NullPointerException | IndexOutOfBoundsException e) {}
		
		try {
			MAttachmentEntry[] attachmentsFromCopy = new X_sbsp_copy(Env.getCtx(), p.sbsp_copy_id, p.trxname).getAttachment().getEntries();
			if (!attachmentsFromCopy.equals(null) && attachmentsFromCopy.length > 0)
				for (MAttachmentEntry entry : attachmentsFromCopy)
					rtn.add(entry.getFile());
		
		} catch (NullPointerException | IndexOutOfBoundsException e) {}
		
		return rtn;
	}
	
	private static void sendMailDirectly (ServerPrintCopyParam p, MUser m_from, MUser m_to, String to, String message, MMailText m_MailText, File[] printedDoc) throws Exception {
		
//		Client Info
		MClient m_client = MClient.get (Env.getCtx());
		if (m_client.getAD_Client_ID() == 0)
			throw new AdempiereException ("Not found @AD_Client_ID@");
		if (m_client.getSMTPHost() == null || m_client.getSMTPHost().length() == 0)
			throw new Exception ("No SMTP Host found"); //FIXME: more specific exception
		EMail email = m_client.createEMail(m_from, to, m_MailText.getMailHeader(), message);
		if (m_MailText.isHtml())
			email.setMessageHTML(m_MailText.getMailHeader(), message);
		else
		{
			email.setSubject (m_MailText.getMailHeader());
			email.setMessageText (message);
		}
		for (String cc : p.eMailCc) {
			if (!email.addCc(cc)) {
				throw new InvalidMailAddressException(cc);
			}
		}
		for (String bcc : p.eMailBcc) {
			if (!email.addBcc(bcc)) {
				throw new InvalidMailAddressException(bcc);
			}
		}
		
		for (File a : collectAttachments(p, printedDoc))
			email.addAttachment(a);

		
		if (!email.isValid(true))
		{
			String invalidWarning = Msg.getMsg(Env.getCtx(), "InvalidEmailAddress", new Object[] {m_to.getEMail()});
			CLogger.get().warning("NOT VALID - " + email);
			m_to.setIsActive(false);
			m_to.addDescription(invalidWarning);
			m_to.saveEx();
			throw new InvalidMailAddressException(m_to.getEMail());
		}
		boolean OK = EMail.SENT_OK.equals(email.send());
		
		if (m_to != null)
			new MUserMail(m_MailText, m_to.get_ID(), email).saveEx();

		if (OK) {
			if (m_to != null) 
			{
				CLogger.get().fine(m_to.getEMail());				
			}
 		} else {
			CLogger.get().warning("FAILURE - " + (m_to==null?"m_to is null":m_to.getEMail()) );
			throw new MailNotSentException( m_to==null?"":m_to.getEMail() );
		} 
	}
	
	private static void openMailWindow (ServerPrintCopyParam p, MUser mfrom, String to, MMailText mailtext, StringBuilder message, File[] printedDoc) throws Exception {
		if (p.isCalledFromProcess)
			throw new CalledFromProcessException();
		
		// Create an email window, give it the stack containing the printedDoc at the very bottom and add a placeholder
		SBSP_EMailDialog dialog = new SBSP_EMailDialog(null, null, p.eMailTo, null, null, null);
//		dialog.setDeletionStack(p.deletionStack);
//		p.deletionStack.push(new Object());
		
		// present prepared window to the user
		try {
			AEnv.showWindow(dialog);
    		dialog.setFrom(mfrom);
    		dialog.setTo(to);
    		for (String cc : p.eMailCc) {
    			if (!SBSP_EMailDialog.isValidEmailAddress(cc))
    				throw new InvalidMailAddressException(cc);
    			dialog.addCC(cc, true);
    		}
    		for (String bcc : p.eMailBcc) {
    			if (!SBSP_EMailDialog.isValidEmailAddress(bcc))
    				throw new InvalidMailAddressException(bcc);
    			dialog.addCC(bcc, true); //FIXME: mail dialog does not support bcc!
    		}
    		dialog.setSubject(mailtext.getMailHeader());
    		dialog.setMessage(message.toString());
		} catch (NullPointerException e) {
			CLogger.get().log(Level.WARNING, "Cannot initialize mail window; some information might have been incorrect", e);
		}

		for (File a : collectAttachments(p, printedDoc)) {
			dialog.addAttachment(new FileDataSource(a), false);
		}

		
		dialog.focus();
	}
	

	// STATIC METHODS ////
	
	public static List<String> makeCcList (String dbEntry) {
    	LinkedList<String> rtn = new LinkedList<>();
    	if (dbEntry != null && !dbEntry.equals("")) //if necessary, return empty list to continue workflow
    		for (String s : dbEntry.split(","))
    			rtn.add(s.trim());
    	return rtn;
    }
}
