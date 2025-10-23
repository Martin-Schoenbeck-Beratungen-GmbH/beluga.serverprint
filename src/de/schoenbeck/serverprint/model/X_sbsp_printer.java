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

/** Generated Model for sbsp_printer
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_printer")
public class X_sbsp_printer extends PO implements I_sbsp_printer, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_printer (Properties ctx, int sbsp_printer_ID, String trxName)
    {
      super (ctx, sbsp_printer_ID, trxName);
      /** if (sbsp_printer_ID == 0)
        {
			setName (null);
			setValue (null);
			setlookup (null);
// 'n'
			setsbsp_printer_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printer (Properties ctx, int sbsp_printer_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printer_ID, trxName, virtualColumns);
      /** if (sbsp_printer_ID == 0)
        {
			setName (null);
			setValue (null);
			setlookup (null);
// 'n'
			setsbsp_printer_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printer (Properties ctx, String sbsp_printer_UU, String trxName)
    {
      super (ctx, sbsp_printer_UU, trxName);
      /** if (sbsp_printer_UU == null)
        {
			setName (null);
			setValue (null);
			setlookup (null);
// 'n'
			setsbsp_printer_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printer (Properties ctx, String sbsp_printer_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printer_UU, trxName, virtualColumns);
      /** if (sbsp_printer_UU == null)
        {
			setName (null);
			setValue (null);
			setlookup (null);
// 'n'
			setsbsp_printer_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_printer (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_sbsp_printer[")
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

	/** Set Printer Name.
		@param PrinterNameIpp Name of the Printer
	*/
	public void setPrinterNameIpp (String PrinterNameIpp)
	{
		set_Value (COLUMNNAME_PrinterNameIpp, PrinterNameIpp);
	}

	/** Get Printer Name.
		@return Name of the Printer
	  */
	public String getPrinterNameIpp()
	{
		return (String)get_Value(COLUMNNAME_PrinterNameIpp);
	}

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

	/** Set Lookup Printerattributes.
		@param lookup Process used for finding IPP printers&#039; attributes
	*/
	public void setlookup (String lookup)
	{
		set_Value (COLUMNNAME_lookup, lookup);
	}

	/** Get Lookup Printerattributes.
		@return Process used for finding IPP printers&#039; attributes
	  */
	public String getlookup()
	{
		return (String)get_Value(COLUMNNAME_lookup);
	}

	/** Set printer password.
		@param printer_password printer password
	*/
	public void setprinter_password (String printer_password)
	{
		set_Value (COLUMNNAME_printer_password, printer_password);
	}

	/** Get printer password.
		@return printer password	  */
	public String getprinter_password()
	{
		return (String)get_Value(COLUMNNAME_printer_password);
	}

	/** Set printer URI.
		@param printer_uri printer URI
	*/
	public void setprinter_uri (String printer_uri)
	{
		set_Value (COLUMNNAME_printer_uri, printer_uri);
	}

	/** Get printer URI.
		@return printer URI	  */
	public String getprinter_uri()
	{
		return (String)get_Value(COLUMNNAME_printer_uri);
	}

	/** Set printer username.
		@param printer_username printer username
	*/
	public void setprinter_username (String printer_username)
	{
		set_Value (COLUMNNAME_printer_username, printer_username);
	}

	/** Get printer username.
		@return printer username	  */
	public String getprinter_username()
	{
		return (String)get_Value(COLUMNNAME_printer_username);
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

	/** Set sbsp_printer_UU.
		@param sbsp_printer_UU sbsp_printer_UU
	*/
	public void setsbsp_printer_UU (String sbsp_printer_UU)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_printer_UU, sbsp_printer_UU);
	}

	/** Get sbsp_printer_UU.
		@return sbsp_printer_UU	  */
	public String getsbsp_printer_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_printer_UU);
	}

	public I_sbsp_printerprovider getsbsp_printerprovider() throws RuntimeException
	{
		return (I_sbsp_printerprovider)MTable.get(getCtx(), I_sbsp_printerprovider.Table_ID)
			.getPO(getsbsp_printerprovider_ID(), get_TrxName());
	}

	/** Set Printer Provider.
		@param sbsp_printerprovider_ID Printer Provider
	*/
	public void setsbsp_printerprovider_ID (int sbsp_printerprovider_ID)
	{
		if (sbsp_printerprovider_ID < 1)
			set_Value (COLUMNNAME_sbsp_printerprovider_ID, null);
		else
			set_Value (COLUMNNAME_sbsp_printerprovider_ID, Integer.valueOf(sbsp_printerprovider_ID));
	}

	/** Get Printer Provider.
		@return Printer Provider	  */
	public int getsbsp_printerprovider_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_printerprovider_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}