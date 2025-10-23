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

/** Generated Model for sbsp_attributename
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_attributename")
public class X_sbsp_attributename extends PO implements I_sbsp_attributename, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_attributename (Properties ctx, int sbsp_attributename_ID, String trxName)
    {
      super (ctx, sbsp_attributename_ID, trxName);
      /** if (sbsp_attributename_ID == 0)
        {
			setName (null);
			setPrinterAttributeName (null);
			setsbsp_attributename_ID (0);
			setsbsp_printer_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_attributename (Properties ctx, int sbsp_attributename_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_attributename_ID, trxName, virtualColumns);
      /** if (sbsp_attributename_ID == 0)
        {
			setName (null);
			setPrinterAttributeName (null);
			setsbsp_attributename_ID (0);
			setsbsp_printer_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_attributename (Properties ctx, String sbsp_attributename_UU, String trxName)
    {
      super (ctx, sbsp_attributename_UU, trxName);
      /** if (sbsp_attributename_UU == null)
        {
			setName (null);
			setPrinterAttributeName (null);
			setsbsp_attributename_ID (0);
			setsbsp_printer_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_attributename (Properties ctx, String sbsp_attributename_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_attributename_UU, trxName, virtualColumns);
      /** if (sbsp_attributename_UU == null)
        {
			setName (null);
			setPrinterAttributeName (null);
			setsbsp_attributename_ID (0);
			setsbsp_printer_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_attributename (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_sbsp_attributename[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
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

	/** Set Printer Attribute Name.
		@param PrinterAttributeName Name of Attribute to command a printer
	*/
	public void setPrinterAttributeName (String PrinterAttributeName)
	{
		set_Value (COLUMNNAME_PrinterAttributeName, PrinterAttributeName);
	}

	/** Get Printer Attribute Name.
		@return Name of Attribute to command a printer
	  */
	public String getPrinterAttributeName()
	{
		return (String)get_Value(COLUMNNAME_PrinterAttributeName);
	}

	/** Set Printer attributename.
		@param sbsp_attributename_ID Printer attributename
	*/
	public void setsbsp_attributename_ID (int sbsp_attributename_ID)
	{
		if (sbsp_attributename_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_attributename_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_attributename_ID, Integer.valueOf(sbsp_attributename_ID));
	}

	/** Get Printer attributename.
		@return Printer attributename	  */
	public int getsbsp_attributename_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_attributename_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set sbsp_attributename_UU.
		@param sbsp_attributename_UU sbsp_attributename_UU
	*/
	public void setsbsp_attributename_UU (String sbsp_attributename_UU)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_attributename_UU, sbsp_attributename_UU);
	}

	/** Get sbsp_attributename_UU.
		@return sbsp_attributename_UU	  */
	public String getsbsp_attributename_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_attributename_UU);
	}

	public I_sbsp_printer getsbsp_printer() throws RuntimeException
	{
		return (I_sbsp_printer)MTable.get(getCtx(), I_sbsp_printer.Table_ID)
			.getPO(getsbsp_printer_ID(), get_TrxName());
	}

	/** Set Printer.
		@param sbsp_printer_ID Printer
	*/
	public void setsbsp_printer_ID (int sbsp_printer_ID)
	{
		if (sbsp_printer_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_printer_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_printer_ID, Integer.valueOf(sbsp_printer_ID));
	}

	/** Get Printer.
		@return Printer	  */
	public int getsbsp_printer_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_printer_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}