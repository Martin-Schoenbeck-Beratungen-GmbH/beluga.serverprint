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
package de.schoenbeck.serverprint.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for sbsp_copy
 *  @author iDempiere (generated) 
 *  @version Release 10
 */
@SuppressWarnings("all")
public interface I_sbsp_copy 
{

    /** TableName=sbsp_copy */
    public static final String Table_Name = "sbsp_copy";

    /** AD_Table_ID=1000008 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_Process_ID */
    public static final String COLUMNNAME_AD_Process_ID = "AD_Process_ID";

	/** Set Process.
	  * Process or Report
	  */
	public void setAD_Process_ID (int AD_Process_ID);

	/** Get Process.
	  * Process or Report
	  */
	public int getAD_Process_ID();

	public org.compiere.model.I_AD_Process getAD_Process() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DepositPath */
    public static final String COLUMNNAME_DepositPath = "DepositPath";

	/** Set DepositPath.
	  * Path to deposit printout
	  */
	public void setDepositPath (String DepositPath);

	/** Get DepositPath.
	  * Path to deposit printout
	  */
	public String getDepositPath();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name EMail_CC */
    public static final String COLUMNNAME_EMail_CC = "EMail_CC";

	/** Set To EMails (CC).
	  * EMail addresses to be added as CC, seperated by comma
	  */
	public void setEMail_CC (String EMail_CC);

	/** Get To EMails (CC).
	  * EMail addresses to be added as CC, seperated by comma
	  */
	public String getEMail_CC();

    /** Column name EMail_To */
    public static final String COLUMNNAME_EMail_To = "EMail_To";

	/** Set To EMail.
	  * EMail address to send requests to - e.g. edi@manufacturer.com 
	  */
	public void setEMail_To (String EMail_To);

	/** Get To EMail.
	  * EMail address to send requests to - e.g. edi@manufacturer.com 
	  */
	public String getEMail_To();

    /** Column name ExportFileExtension */
    public static final String COLUMNNAME_ExportFileExtension = "ExportFileExtension";

	/** Set Export File Extension.
	  * File type to generate. Default (when empty) is pdf.
	  */
	public void setExportFileExtension (String ExportFileExtension);

	/** Get Export File Extension.
	  * File type to generate. Default (when empty) is pdf.
	  */
	public String getExportFileExtension();

    /** Column name ExportFilenamePattern */
    public static final String COLUMNNAME_ExportFilenamePattern = "ExportFilenamePattern";

	/** Set Export Filename Pattern.
	  * Pattern (allowing @tag@ substitution) of how to name the file
	  */
	public void setExportFilenamePattern (String ExportFilenamePattern);

	/** Get Export Filename Pattern.
	  * Pattern (allowing @tag@ substitution) of how to name the file
	  */
	public String getExportFilenamePattern();

    /** Column name From_AD_User_ID */
    public static final String COLUMNNAME_From_AD_User_ID = "From_AD_User_ID";

	/** Set User to be used as From:	  */
	public void setFrom_AD_User_ID (int From_AD_User_ID);

	/** Get User to be used as From:	  */
	public int getFrom_AD_User_ID();

	public org.compiere.model.I_AD_User getFrom_AD_User() throws RuntimeException;

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name R_MailText_ID */
    public static final String COLUMNNAME_R_MailText_ID = "R_MailText_ID";

	/** Set Mail Template.
	  * Text templates for mailings
	  */
	public void setR_MailText_ID (int R_MailText_ID);

	/** Get Mail Template.
	  * Text templates for mailings
	  */
	public int getR_MailText_ID();

	public org.compiere.model.I_R_MailText getR_MailText() throws RuntimeException;

    /** Column name RecipientBcc */
    public static final String COLUMNNAME_RecipientBcc = "RecipientBcc";

	/** Set Bcc	  */
	public void setRecipientBcc (String RecipientBcc);

	/** Get Bcc	  */
	public String getRecipientBcc();

    /** Column name ReportVariant */
    public static final String COLUMNNAME_ReportVariant = "ReportVariant";

	/** Set ReportVariant.
	  * Allow Variants of the same Report
	  */
	public void setReportVariant (String ReportVariant);

	/** Get ReportVariant.
	  * Allow Variants of the same Report
	  */
	public String getReportVariant();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name actualUserAsFrom */
    public static final String COLUMNNAME_actualUserAsFrom = "actualUserAsFrom";

	/** Set use actual user as From:	  */
	public void setactualUserAsFrom (boolean actualUserAsFrom);

	/** Get use actual user as From:	  */
	public boolean isactualUserAsFrom();

    /** Column name copies */
    public static final String COLUMNNAME_copies = "copies";

	/** Set Copies	  */
	public void setcopies (int copies);

	/** Get Copies	  */
	public int getcopies();

    /** Column name mailToAddress */
    public static final String COLUMNNAME_mailToAddress = "mailToAddress";

	/** Set mail to fixed address.
	  * The printout has to be send to a fixed address
	  */
	public void setmailToAddress (boolean mailToAddress);

	/** Get mail to fixed address.
	  * The printout has to be send to a fixed address
	  */
	public boolean ismailToAddress();

    /** Column name mailToUser */
    public static final String COLUMNNAME_mailToUser = "mailToUser";

	/** Set Send mail to User/Contact.
	  * The printout has to be send by mail to User/Contact
	  */
	public void setmailToUser (boolean mailToUser);

	/** Get Send mail to User/Contact.
	  * The printout has to be send by mail to User/Contact
	  */
	public boolean ismailToUser();

    /** Column name mailattachment_prefix */
    public static final String COLUMNNAME_mailattachment_prefix = "mailattachment_prefix";

	/** Set E-Mail Attachment Prefixes.
	  * Prefixes for document attachments to be added to emails
	  */
	public void setmailattachment_prefix (String mailattachment_prefix);

	/** Get E-Mail Attachment Prefixes.
	  * Prefixes for document attachments to be added to emails
	  */
	public String getmailattachment_prefix();

    /** Column name sbsp_copy_ID */
    public static final String COLUMNNAME_sbsp_copy_ID = "sbsp_copy_ID";

	/** Set Copy	  */
	public void setsbsp_copy_ID (int sbsp_copy_ID);

	/** Get Copy	  */
	public int getsbsp_copy_ID();

    /** Column name sbsp_copy_UU */
    public static final String COLUMNNAME_sbsp_copy_UU = "sbsp_copy_UU";

	/** Set sbsp_copy_UU	  */
	public void setsbsp_copy_UU (String sbsp_copy_UU);

	/** Get sbsp_copy_UU	  */
	public String getsbsp_copy_UU();

    /** Column name sbsp_copytype_ID */
    public static final String COLUMNNAME_sbsp_copytype_ID = "sbsp_copytype_ID";

	/** Set Copy Type	  */
	public void setsbsp_copytype_ID (int sbsp_copytype_ID);

	/** Get Copy Type	  */
	public int getsbsp_copytype_ID();

	public I_sbsp_copytype getsbsp_copytype() throws RuntimeException;

    /** Column name sbsp_mailtosql */
    public static final String COLUMNNAME_sbsp_mailtosql = "sbsp_mailtosql";

	/** Set MailTo Query	  */
	public void setsbsp_mailtosql (int sbsp_mailtosql);

	/** Get MailTo Query	  */
	public int getsbsp_mailtosql();

	public I_sbsp_userqueries getsbsp_mailto() throws RuntimeException;

    /** Column name sbsp_printconfig_ID */
    public static final String COLUMNNAME_sbsp_printconfig_ID = "sbsp_printconfig_ID";

	/** Set Printconfig	  */
	public void setsbsp_printconfig_ID (int sbsp_printconfig_ID);

	/** Get Printconfig	  */
	public int getsbsp_printconfig_ID();

	public I_sbsp_printconfig getsbsp_printconfig() throws RuntimeException;

    /** Column name sbsp_printoption_ID */
    public static final String COLUMNNAME_sbsp_printoption_ID = "sbsp_printoption_ID";

	/** Set Print Option.
	  * Options displayed in dialogue if there are multiple valid options in the given print profiles.
	  */
	public void setsbsp_printoption_ID (int sbsp_printoption_ID);

	/** Get Print Option.
	  * Options displayed in dialogue if there are multiple valid options in the given print profiles.
	  */
	public int getsbsp_printoption_ID();

	public I_sbsp_printoption getsbsp_printoption() throws RuntimeException;

    /** Column name sbsp_subprintprofile_ID */
    public static final String COLUMNNAME_sbsp_subprintprofile_ID = "sbsp_subprintprofile_ID";

	/** Set Sub Printprofile	  */
	public void setsbsp_subprintprofile_ID (int sbsp_subprintprofile_ID);

	/** Get Sub Printprofile	  */
	public int getsbsp_subprintprofile_ID();

	public I_sbsp_subprintprofile getsbsp_subprintprofile() throws RuntimeException;

    /** Column name senddirectly */
    public static final String COLUMNNAME_senddirectly = "senddirectly";

	/** Set senddirectly	  */
	public void setsenddirectly (boolean senddirectly);

	/** Get senddirectly	  */
	public boolean issenddirectly();

    /** Column name toArchive */
    public static final String COLUMNNAME_toArchive = "toArchive";

	/** Set To Archive	  */
	public void settoArchive (boolean toArchive);

	/** Get To Archive	  */
	public boolean istoArchive();

    /** Column name use_existing */
    public static final String COLUMNNAME_use_existing = "use_existing";

	/** Set Use existing Doc	  */
	public void setuse_existing (boolean use_existing);

	/** Get Use existing Doc	  */
	public boolean isuse_existing();
}
