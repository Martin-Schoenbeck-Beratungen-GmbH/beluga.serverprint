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

/** Generated Model for sbsp_printoption
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_printoption")
public class X_sbsp_printoption extends PO implements I_sbsp_printoption, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_printoption (Properties ctx, int sbsp_printoption_ID, String trxName)
    {
      super (ctx, sbsp_printoption_ID, trxName);
      /** if (sbsp_printoption_ID == 0)
        {
			setIsLimitedToProcess (false);
// N
			setName (null);
			setsbsp_printoption_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printoption (Properties ctx, int sbsp_printoption_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printoption_ID, trxName, virtualColumns);
      /** if (sbsp_printoption_ID == 0)
        {
			setIsLimitedToProcess (false);
// N
			setName (null);
			setsbsp_printoption_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printoption (Properties ctx, String sbsp_printoption_UU, String trxName)
    {
      super (ctx, sbsp_printoption_UU, trxName);
      /** if (sbsp_printoption_UU == null)
        {
			setIsLimitedToProcess (false);
// N
			setName (null);
			setsbsp_printoption_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printoption (Properties ctx, String sbsp_printoption_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printoption_UU, trxName, virtualColumns);
      /** if (sbsp_printoption_UU == null)
        {
			setIsLimitedToProcess (false);
// N
			setName (null);
			setsbsp_printoption_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_printoption (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_sbsp_printoption[")
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

	/** Set Is limited to process calls.
		@param IsLimitedToProcess This option will not be shown to users and can only be called explicitly from code.
	*/
	public void setIsLimitedToProcess (boolean IsLimitedToProcess)
	{
		set_Value (COLUMNNAME_IsLimitedToProcess, Boolean.valueOf(IsLimitedToProcess));
	}

	/** Get Is limited to process calls.
		@return This option will not be shown to users and can only be called explicitly from code.
	  */
	public boolean isLimitedToProcess()
	{
		Object oo = get_Value(COLUMNNAME_IsLimitedToProcess);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
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

	/** Set Print Option.
		@param sbsp_printoption_ID Options displayed in dialogue if there are multiple valid options in the given print profiles.
	*/
	public void setsbsp_printoption_ID (int sbsp_printoption_ID)
	{
		if (sbsp_printoption_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_printoption_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_printoption_ID, Integer.valueOf(sbsp_printoption_ID));
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

	/** Set sbsp_printoption_UU.
		@param sbsp_printoption_UU sbsp_printoption_UU
	*/
	public void setsbsp_printoption_UU (String sbsp_printoption_UU)
	{
		set_Value (COLUMNNAME_sbsp_printoption_UU, sbsp_printoption_UU);
	}

	/** Get sbsp_printoption_UU.
		@return sbsp_printoption_UU	  */
	public String getsbsp_printoption_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_printoption_UU);
	}
}