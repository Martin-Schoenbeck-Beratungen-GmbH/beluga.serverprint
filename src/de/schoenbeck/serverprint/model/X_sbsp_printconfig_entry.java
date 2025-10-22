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

/** Generated Model for sbsp_printconfig_entry
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_printconfig_entry")
public class X_sbsp_printconfig_entry extends PO implements I_sbsp_printconfig_entry, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_printconfig_entry (Properties ctx, int sbsp_printconfig_entry_ID, String trxName)
    {
      super (ctx, sbsp_printconfig_entry_ID, trxName);
      /** if (sbsp_printconfig_entry_ID == 0)
        {
			setName (null);
			setisstandardprintconfig (false);
// N
			setsbsp_printconfig_ID (0);
			setsbsp_printconfig_entry_ID (0);
			setsbsp_printer_ID (0);
			setsbsp_printerconfig_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printconfig_entry (Properties ctx, int sbsp_printconfig_entry_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printconfig_entry_ID, trxName, virtualColumns);
      /** if (sbsp_printconfig_entry_ID == 0)
        {
			setName (null);
			setisstandardprintconfig (false);
// N
			setsbsp_printconfig_ID (0);
			setsbsp_printconfig_entry_ID (0);
			setsbsp_printer_ID (0);
			setsbsp_printerconfig_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printconfig_entry (Properties ctx, String sbsp_printconfig_entry_UU, String trxName)
    {
      super (ctx, sbsp_printconfig_entry_UU, trxName);
      /** if (sbsp_printconfig_entry_UU == null)
        {
			setName (null);
			setisstandardprintconfig (false);
// N
			setsbsp_printconfig_ID (0);
			setsbsp_printconfig_entry_ID (0);
			setsbsp_printer_ID (0);
			setsbsp_printerconfig_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printconfig_entry (Properties ctx, String sbsp_printconfig_entry_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printconfig_entry_UU, trxName, virtualColumns);
      /** if (sbsp_printconfig_entry_UU == null)
        {
			setName (null);
			setisstandardprintconfig (false);
// N
			setsbsp_printconfig_ID (0);
			setsbsp_printconfig_entry_ID (0);
			setsbsp_printer_ID (0);
			setsbsp_printerconfig_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_printconfig_entry (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_sbsp_printconfig_entry[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getAD_User_ID(), get_TrxName());
	}

	/** Set User/Contact.
		@param AD_User_ID User within the system - Internal or Business Partner Contact
	*/
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1)
			set_Value (COLUMNNAME_AD_User_ID, null);
		else
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Remote Addr.
		@param Remote_Addr Remote Address
	*/
	public void setRemote_Addr (String Remote_Addr)
	{
		set_Value (COLUMNNAME_Remote_Addr, Remote_Addr);
	}

	/** Get Remote Addr.
		@return Remote Address
	  */
	public String getRemote_Addr()
	{
		return (String)get_Value(COLUMNNAME_Remote_Addr);
	}

	/** Set isStandardPrintConfig.
		@param isstandardprintconfig The standard print config is used if no user-special config is found
	*/
	public void setisstandardprintconfig (boolean isstandardprintconfig)
	{
		set_Value (COLUMNNAME_isstandardprintconfig, Boolean.valueOf(isstandardprintconfig));
	}

	/** Get isStandardPrintConfig.
		@return The standard print config is used if no user-special config is found
	  */
	public boolean isstandardprintconfig()
	{
		Object oo = get_Value(COLUMNNAME_isstandardprintconfig);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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
			set_ValueNoCheck (COLUMNNAME_sbsp_printconfig_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_printconfig_ID, Integer.valueOf(sbsp_printconfig_ID));
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

	/** Set Printconfigentry.
		@param sbsp_printconfig_entry_ID Printconfigentry
	*/
	public void setsbsp_printconfig_entry_ID (int sbsp_printconfig_entry_ID)
	{
		if (sbsp_printconfig_entry_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_printconfig_entry_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_printconfig_entry_ID, Integer.valueOf(sbsp_printconfig_entry_ID));
	}

	/** Get Printconfigentry.
		@return Printconfigentry	  */
	public int getsbsp_printconfig_entry_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_printconfig_entry_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set sbsp_printconfig_entry_UU.
		@param sbsp_printconfig_entry_UU sbsp_printconfig_entry_UU
	*/
	public void setsbsp_printconfig_entry_UU (String sbsp_printconfig_entry_UU)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_printconfig_entry_UU, sbsp_printconfig_entry_UU);
	}

	/** Get sbsp_printconfig_entry_UU.
		@return sbsp_printconfig_entry_UU	  */
	public String getsbsp_printconfig_entry_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_printconfig_entry_UU);
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
			set_Value (COLUMNNAME_sbsp_printer_ID, null);
		else
			set_Value (COLUMNNAME_sbsp_printer_ID, Integer.valueOf(sbsp_printer_ID));
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

	public I_sbsp_printerconfig getsbsp_printerconfig() throws RuntimeException
	{
		return (I_sbsp_printerconfig)MTable.get(getCtx(), I_sbsp_printerconfig.Table_ID)
			.getPO(getsbsp_printerconfig_ID(), get_TrxName());
	}

	/** Set Printer Config.
		@param sbsp_printerconfig_ID Printer Config
	*/
	public void setsbsp_printerconfig_ID (int sbsp_printerconfig_ID)
	{
		if (sbsp_printerconfig_ID < 1)
			set_Value (COLUMNNAME_sbsp_printerconfig_ID, null);
		else
			set_Value (COLUMNNAME_sbsp_printerconfig_ID, Integer.valueOf(sbsp_printerconfig_ID));
	}

	/** Get Printer Config.
		@return Printer Config	  */
	public int getsbsp_printerconfig_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_printerconfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}