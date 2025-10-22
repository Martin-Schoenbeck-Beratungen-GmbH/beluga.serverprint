/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package de.schoenbeck.serverprint.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for sbsp_copy
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_copy")
public class X_sbsp_copy extends PO implements I_sbsp_copy, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_copy (Properties ctx, int sbsp_copy_ID, String trxName)
    {
      super (ctx, sbsp_copy_ID, trxName);
      /** if (sbsp_copy_ID == 0)
        {
			setAD_Process_ID (0);
			setName (null);
			setactualUserAsFrom (false);
// N
			setmailToAddress (false);
// N
			setmailToUser (false);
// N
			setsbsp_copy_ID (0);
			setsbsp_copytype_ID (0);
			setsbsp_subprintprofile_ID (0);
			setsenddirectly (false);
// N
			settoArchive (false);
// N
			setuse_existing (false);
// 'N'
        } */
    }

    /** Standard Constructor */
    public X_sbsp_copy (Properties ctx, int sbsp_copy_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_copy_ID, trxName, virtualColumns);
      /** if (sbsp_copy_ID == 0)
        {
			setAD_Process_ID (0);
			setName (null);
			setactualUserAsFrom (false);
// N
			setmailToAddress (false);
// N
			setmailToUser (false);
// N
			setsbsp_copy_ID (0);
			setsbsp_copytype_ID (0);
			setsbsp_subprintprofile_ID (0);
			setsenddirectly (false);
// N
			settoArchive (false);
// N
			setuse_existing (false);
// 'N'
        } */
    }

    /** Standard Constructor */
    public X_sbsp_copy (Properties ctx, String sbsp_copy_UU, String trxName)
    {
      super (ctx, sbsp_copy_UU, trxName);
      /** if (sbsp_copy_UU == null)
        {
			setAD_Process_ID (0);
			setName (null);
			setactualUserAsFrom (false);
// N
			setmailToAddress (false);
// N
			setmailToUser (false);
// N
			setsbsp_copy_ID (0);
			setsbsp_copytype_ID (0);
			setsbsp_subprintprofile_ID (0);
			setsenddirectly (false);
// N
			settoArchive (false);
// N
			setuse_existing (false);
// 'N'
        } */
    }

    /** Standard Constructor */
    public X_sbsp_copy (Properties ctx, String sbsp_copy_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_copy_UU, trxName, virtualColumns);
      /** if (sbsp_copy_UU == null)
        {
			setAD_Process_ID (0);
			setName (null);
			setactualUserAsFrom (false);
// N
			setmailToAddress (false);
// N
			setmailToUser (false);
// N
			setsbsp_copy_ID (0);
			setsbsp_copytype_ID (0);
			setsbsp_subprintprofile_ID (0);
			setsenddirectly (false);
// N
			settoArchive (false);
// N
			setuse_existing (false);
// 'N'
        } */
    }

    /** Load Constructor */
    public X_sbsp_copy (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_sbsp_copy[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Process getAD_Process() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Process)MTable.get(getCtx(), org.compiere.model.I_AD_Process.Table_ID)
			.getPO(getAD_Process_ID(), get_TrxName());
	}

	/** Set Process.
		@param AD_Process_ID Process or Report
	*/
	public void setAD_Process_ID (int AD_Process_ID)
	{
		if (AD_Process_ID < 1)
			set_Value (COLUMNNAME_AD_Process_ID, null);
		else
			set_Value (COLUMNNAME_AD_Process_ID, Integer.valueOf(AD_Process_ID));
	}

	/** Get Process.
		@return Process or Report
	  */
	public int getAD_Process_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Process_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set DepositPath.
		@param DepositPath Path to deposit printout
	*/
	public void setDepositPath (String DepositPath)
	{
		set_Value (COLUMNNAME_DepositPath, DepositPath);
	}

	/** Get DepositPath.
		@return Path to deposit printout
	  */
	public String getDepositPath()
	{
		return (String)get_Value(COLUMNNAME_DepositPath);
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set To EMails (CC).
		@param EMail_CC EMail addresses to be added as CC, seperated by comma
	*/
	public void setEMail_CC (String EMail_CC)
	{
		set_Value (COLUMNNAME_EMail_CC, EMail_CC);
	}

	/** Get To EMails (CC).
		@return EMail addresses to be added as CC, seperated by comma
	  */
	public String getEMail_CC()
	{
		return (String)get_Value(COLUMNNAME_EMail_CC);
	}

	/** Set To EMail.
		@param EMail_To EMail address to send requests to - e.g. edi@manufacturer.com 
	*/
	public void setEMail_To (String EMail_To)
	{
		set_Value (COLUMNNAME_EMail_To, EMail_To);
	}

	/** Get To EMail.
		@return EMail address to send requests to - e.g. edi@manufacturer.com 
	  */
	public String getEMail_To()
	{
		return (String)get_Value(COLUMNNAME_EMail_To);
	}

	/** csv (comma separated values) = csv */
	public static final String EXPORTFILEEXTENSION_CsvCommaSeparatedValues = "csv";
	/** html (Hypertext markup language) = html */
	public static final String EXPORTFILEEXTENSION_HtmlHypertextMarkupLanguage = "html";
	/** pdf (Portable document format) = pdf */
	public static final String EXPORTFILEEXTENSION_PdfPortableDocumentFormat = "pdf";
	/** ps (Postscript) = ps */
	public static final String EXPORTFILEEXTENSION_PsPostscript = "ps";
	/** ssv (semicolon separated values) = ssv */
	public static final String EXPORTFILEEXTENSION_SsvSemicolonSeparatedValues = "ssv";
	/** txt (Simple Text) = txt */
	public static final String EXPORTFILEEXTENSION_TxtSimpleText = "txt";
	/** xls (Excel File) = xls */
	public static final String EXPORTFILEEXTENSION_XlsExcelFile = "xls";
	/** xml (Extensible Markup Language) = xml */
	public static final String EXPORTFILEEXTENSION_XmlExtensibleMarkupLanguage = "xml";
	/** Set Export File Extension.
		@param ExportFileExtension File type to generate. Default (when empty) is pdf.
	*/
	public void setExportFileExtension (String ExportFileExtension)
	{

		set_Value (COLUMNNAME_ExportFileExtension, ExportFileExtension);
	}

	/** Get Export File Extension.
		@return File type to generate. Default (when empty) is pdf.
	  */
	public String getExportFileExtension()
	{
		return (String)get_Value(COLUMNNAME_ExportFileExtension);
	}

	/** Set Export Filename Pattern.
		@param ExportFilenamePattern Pattern (allowing @tag@ substitution) of how to name the file
	*/
	public void setExportFilenamePattern (String ExportFilenamePattern)
	{
		set_Value (COLUMNNAME_ExportFilenamePattern, ExportFilenamePattern);
	}

	/** Get Export Filename Pattern.
		@return Pattern (allowing @tag@ substitution) of how to name the file
	  */
	public String getExportFilenamePattern()
	{
		return (String)get_Value(COLUMNNAME_ExportFilenamePattern);
	}

	public org.compiere.model.I_AD_User getFrom_AD_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getFrom_AD_User_ID(), get_TrxName());
	}

	/** Set User to be used as From:.
		@param From_AD_User_ID User to be used as From:
	*/
	public void setFrom_AD_User_ID (int From_AD_User_ID)
	{
		if (From_AD_User_ID < 1)
			set_Value (COLUMNNAME_From_AD_User_ID, null);
		else
			set_Value (COLUMNNAME_From_AD_User_ID, Integer.valueOf(From_AD_User_ID));
	}

	/** Get User to be used as From:.
		@return User to be used as From:	  */
	public int getFrom_AD_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_From_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	public org.compiere.model.I_R_MailText getR_MailText() throws RuntimeException
	{
		return (org.compiere.model.I_R_MailText)MTable.get(getCtx(), org.compiere.model.I_R_MailText.Table_ID)
			.getPO(getR_MailText_ID(), get_TrxName());
	}

	/** Set Mail Template.
		@param R_MailText_ID Text templates for mailings
	*/
	public void setR_MailText_ID (int R_MailText_ID)
	{
		if (R_MailText_ID < 1)
			set_Value (COLUMNNAME_R_MailText_ID, null);
		else
			set_Value (COLUMNNAME_R_MailText_ID, Integer.valueOf(R_MailText_ID));
	}

	/** Get Mail Template.
		@return Text templates for mailings
	  */
	public int getR_MailText_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_R_MailText_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Bcc.
		@param RecipientBcc Bcc
	*/
	public void setRecipientBcc (String RecipientBcc)
	{
		set_Value (COLUMNNAME_RecipientBcc, RecipientBcc);
	}

	/** Get Bcc.
		@return Bcc	  */
	public String getRecipientBcc()
	{
		return (String)get_Value(COLUMNNAME_RecipientBcc);
	}

	/** Set ReportVariant.
		@param ReportVariant Allow Variants of the same Report
	*/
	public void setReportVariant (String ReportVariant)
	{
		set_Value (COLUMNNAME_ReportVariant, ReportVariant);
	}

	/** Get ReportVariant.
		@return Allow Variants of the same Report
	  */
	public String getReportVariant()
	{
		return (String)get_Value(COLUMNNAME_ReportVariant);
	}

	/** Set use actual user as From:.
		@param actualUserAsFrom use actual user as From:
	*/
	public void setactualUserAsFrom (boolean actualUserAsFrom)
	{
		set_Value (COLUMNNAME_actualUserAsFrom, Boolean.valueOf(actualUserAsFrom));
	}

	/** Get use actual user as From:.
		@return use actual user as From:	  */
	public boolean isactualUserAsFrom()
	{
		Object oo = get_Value(COLUMNNAME_actualUserAsFrom);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Copies.
		@param copies Copies
	*/
	public void setcopies (int copies)
	{
		set_Value (COLUMNNAME_copies, Integer.valueOf(copies));
	}

	/** Get Copies.
		@return Copies	  */
	public int getcopies()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_copies);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set mail to fixed address.
		@param mailToAddress The printout has to be send to a fixed address
	*/
	public void setmailToAddress (boolean mailToAddress)
	{
		set_Value (COLUMNNAME_mailToAddress, Boolean.valueOf(mailToAddress));
	}

	/** Get mail to fixed address.
		@return The printout has to be send to a fixed address
	  */
	public boolean ismailToAddress()
	{
		Object oo = get_Value(COLUMNNAME_mailToAddress);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Send mail to User/Contact.
		@param mailToUser The printout has to be send by mail to User/Contact
	*/
	public void setmailToUser (boolean mailToUser)
	{
		set_Value (COLUMNNAME_mailToUser, Boolean.valueOf(mailToUser));
	}

	/** Get Send mail to User/Contact.
		@return The printout has to be send by mail to User/Contact
	  */
	public boolean ismailToUser()
	{
		Object oo = get_Value(COLUMNNAME_mailToUser);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set E-Mail Attachment Prefixes.
		@param mailattachment_prefix Prefixes for document attachments to be added to emails
	*/
	public void setmailattachment_prefix (String mailattachment_prefix)
	{
		set_Value (COLUMNNAME_mailattachment_prefix, mailattachment_prefix);
	}

	/** Get E-Mail Attachment Prefixes.
		@return Prefixes for document attachments to be added to emails
	  */
	public String getmailattachment_prefix()
	{
		return (String)get_Value(COLUMNNAME_mailattachment_prefix);
	}

	/** Set Copy.
		@param sbsp_copy_ID Copy
	*/
	public void setsbsp_copy_ID (int sbsp_copy_ID)
	{
		if (sbsp_copy_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_copy_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_copy_ID, Integer.valueOf(sbsp_copy_ID));
	}

	/** Get Copy.
		@return Copy	  */
	public int getsbsp_copy_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_copy_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set sbsp_copy_UU.
		@param sbsp_copy_UU sbsp_copy_UU
	*/
	public void setsbsp_copy_UU (String sbsp_copy_UU)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_copy_UU, sbsp_copy_UU);
	}

	/** Get sbsp_copy_UU.
		@return sbsp_copy_UU	  */
	public String getsbsp_copy_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_copy_UU);
	}

	public I_sbsp_copytype getsbsp_copytype() throws RuntimeException
	{
		return (I_sbsp_copytype)MTable.get(getCtx(), I_sbsp_copytype.Table_ID)
			.getPO(getsbsp_copytype_ID(), get_TrxName());
	}

	/** Set Copy Type.
		@param sbsp_copytype_ID Copy Type
	*/
	public void setsbsp_copytype_ID (int sbsp_copytype_ID)
	{
		if (sbsp_copytype_ID < 1)
			set_Value (COLUMNNAME_sbsp_copytype_ID, null);
		else
			set_Value (COLUMNNAME_sbsp_copytype_ID, Integer.valueOf(sbsp_copytype_ID));
	}

	/** Get Copy Type.
		@return Copy Type	  */
	public int getsbsp_copytype_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_copytype_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_sbsp_userqueries getsbsp_mailto() throws RuntimeException
	{
		return (I_sbsp_userqueries)MTable.get(getCtx(), I_sbsp_userqueries.Table_ID)
			.getPO(getsbsp_mailtosql(), get_TrxName());
	}

	/** Set MailTo Query.
		@param sbsp_mailtosql MailTo Query
	*/
	public void setsbsp_mailtosql (int sbsp_mailtosql)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_mailtosql, Integer.valueOf(sbsp_mailtosql));
	}

	/** Get MailTo Query.
		@return MailTo Query	  */
	public int getsbsp_mailtosql()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_mailtosql);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_sbsp_printconfig getsbsp_printconfig() throws RuntimeException
	{
		return (I_sbsp_printconfig)MTable.get(getCtx(), I_sbsp_printconfig.Table_ID)
			.getPO(getsbsp_printconfig_ID(), get_TrxName());
	}

	/** Set Printconfig.
		@param sbsp_printconfig_ID Printconfig
	*/
	public void setsbsp_printconfig_ID (int sbsp_printconfig_ID)
	{
		if (sbsp_printconfig_ID < 1)
			set_Value (COLUMNNAME_sbsp_printconfig_ID, null);
		else
			set_Value (COLUMNNAME_sbsp_printconfig_ID, Integer.valueOf(sbsp_printconfig_ID));
	}

	/** Get Printconfig.
		@return Printconfig	  */
	public int getsbsp_printconfig_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_printconfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_sbsp_printoption getsbsp_printoption() throws RuntimeException
	{
		return (I_sbsp_printoption)MTable.get(getCtx(), I_sbsp_printoption.Table_ID)
			.getPO(getsbsp_printoption_ID(), get_TrxName());
	}

	/** Set Print Option.
		@param sbsp_printoption_ID Options displayed in dialogue if there are multiple valid options in the given print profiles.
	*/
	public void setsbsp_printoption_ID (int sbsp_printoption_ID)
	{
		if (sbsp_printoption_ID < 1)
			set_Value (COLUMNNAME_sbsp_printoption_ID, null);
		else
			set_Value (COLUMNNAME_sbsp_printoption_ID, Integer.valueOf(sbsp_printoption_ID));
	}

	/** Get Print Option.
		@return Options displayed in dialogue if there are multiple valid options in the given print profiles.
	  */
	public int getsbsp_printoption_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_printoption_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_sbsp_subprintprofile getsbsp_subprintprofile() throws RuntimeException
	{
		return (I_sbsp_subprintprofile)MTable.get(getCtx(), I_sbsp_subprintprofile.Table_ID)
			.getPO(getsbsp_subprintprofile_ID(), get_TrxName());
	}

	/** Set Sub Printprofile.
		@param sbsp_subprintprofile_ID Sub Printprofile
	*/
	public void setsbsp_subprintprofile_ID (int sbsp_subprintprofile_ID)
	{
		if (sbsp_subprintprofile_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_subprintprofile_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_subprintprofile_ID, Integer.valueOf(sbsp_subprintprofile_ID));
	}

	/** Get Sub Printprofile.
		@return Sub Printprofile	  */
	public int getsbsp_subprintprofile_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_subprintprofile_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set senddirectly.
		@param senddirectly senddirectly
	*/
	public void setsenddirectly (boolean senddirectly)
	{
		set_Value (COLUMNNAME_senddirectly, Boolean.valueOf(senddirectly));
	}

	/** Get senddirectly.
		@return senddirectly	  */
	public boolean issenddirectly()
	{
		Object oo = get_Value(COLUMNNAME_senddirectly);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set To Archive.
		@param toArchive To Archive
	*/
	public void settoArchive (boolean toArchive)
	{
		set_Value (COLUMNNAME_toArchive, Boolean.valueOf(toArchive));
	}

	/** Get To Archive.
		@return To Archive	  */
	public boolean istoArchive()
	{
		Object oo = get_Value(COLUMNNAME_toArchive);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Use existing Doc.
		@param use_existing Use existing Doc
	*/
	public void setuse_existing (boolean use_existing)
	{
		set_Value (COLUMNNAME_use_existing, Boolean.valueOf(use_existing));
	}

	/** Get Use existing Doc.
		@return Use existing Doc	  */
	public boolean isuse_existing()
	{
		Object oo = get_Value(COLUMNNAME_use_existing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}