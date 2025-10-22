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

/** Generated Model for sbsp_printprofile
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_printprofile")
public class X_sbsp_printprofile extends PO implements I_sbsp_printprofile, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_printprofile (Properties ctx, int sbsp_printprofile_ID, String trxName)
    {
      super (ctx, sbsp_printprofile_ID, trxName);
      /** if (sbsp_printprofile_ID == 0)
        {
			setName (null);
			setValue (null);
			setisstandardprintprofile (false);
			setprintpriority (0);
			setsbsp_printprofile_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printprofile (Properties ctx, int sbsp_printprofile_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printprofile_ID, trxName, virtualColumns);
      /** if (sbsp_printprofile_ID == 0)
        {
			setName (null);
			setValue (null);
			setisstandardprintprofile (false);
// N
			setprintpriority (0);
			setsbsp_printprofile_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printprofile (Properties ctx, String sbsp_printprofile_UU, String trxName)
    {
      super (ctx, sbsp_printprofile_UU, trxName);
      /** if (sbsp_printprofile_UU == null)
        {
			setName (null);
			setValue (null);
			setisstandardprintprofile (false);
// N
			setprintpriority (0);
			setsbsp_printprofile_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printprofile (Properties ctx, String sbsp_printprofile_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printprofile_UU, trxName, virtualColumns);
      /** if (sbsp_printprofile_UU == null)
        {
			setName (null);
			setValue (null);
			setisstandardprintprofile (false);
// N
			setprintpriority (0);
			setsbsp_printprofile_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_printprofile (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_sbsp_printprofile[")
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

	/** Set Standard.
		@param isstandardprintprofile Standard
	*/
	public void setisstandardprintprofile (boolean isstandardprintprofile)
	{
		set_Value (COLUMNNAME_isstandardprintprofile, Boolean.valueOf(isstandardprintprofile));
	}

	/** Get Standard.
		@return Standard	  */
	public boolean isstandardprintprofile()
	{
		Object oo = get_Value(COLUMNNAME_isstandardprintprofile);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Priority.
		@param printpriority Priority
	*/
	public void setprintpriority (int printpriority)
	{
		set_Value (COLUMNNAME_printpriority, Integer.valueOf(printpriority));
	}

	/** Get Priority.
		@return Priority	  */
	public int getprintpriority()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_printpriority);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Print Profile.
		@param sbsp_printprofile_ID Print Profile
	*/
	public void setsbsp_printprofile_ID (int sbsp_printprofile_ID)
	{
		if (sbsp_printprofile_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_printprofile_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_printprofile_ID, Integer.valueOf(sbsp_printprofile_ID));
	}

	/** Get Print Profile.
		@return Print Profile	  */
	public int getsbsp_printprofile_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_printprofile_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set sbsp_printprofile_UU.
		@param sbsp_printprofile_UU sbsp_printprofile_UU
	*/
	public void setsbsp_printprofile_UU (String sbsp_printprofile_UU)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_printprofile_UU, sbsp_printprofile_UU);
	}

	/** Get sbsp_printprofile_UU.
		@return sbsp_printprofile_UU	  */
	public String getsbsp_printprofile_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_printprofile_UU);
	}
}