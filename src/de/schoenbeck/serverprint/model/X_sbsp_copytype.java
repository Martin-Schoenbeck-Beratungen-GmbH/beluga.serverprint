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

/** Generated Model for sbsp_copytype
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_copytype")
public class X_sbsp_copytype extends PO implements I_sbsp_copytype, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_copytype (Properties ctx, int sbsp_copytype_ID, String trxName)
    {
      super (ctx, sbsp_copytype_ID, trxName);
      /** if (sbsp_copytype_ID == 0)
        {
			setName (null);
			setValue (null);
			setsbsp_copytype_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_copytype (Properties ctx, int sbsp_copytype_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_copytype_ID, trxName, virtualColumns);
      /** if (sbsp_copytype_ID == 0)
        {
			setName (null);
			setValue (null);
			setsbsp_copytype_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_copytype (Properties ctx, String sbsp_copytype_UU, String trxName)
    {
      super (ctx, sbsp_copytype_UU, trxName);
      /** if (sbsp_copytype_UU == null)
        {
			setName (null);
			setValue (null);
			setsbsp_copytype_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_copytype (Properties ctx, String sbsp_copytype_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_copytype_UU, trxName, virtualColumns);
      /** if (sbsp_copytype_UU == null)
        {
			setName (null);
			setValue (null);
			setsbsp_copytype_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_copytype (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_sbsp_copytype[")
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

	/** Set Copy Type.
		@param sbsp_copytype_ID Copy Type
	*/
	public void setsbsp_copytype_ID (int sbsp_copytype_ID)
	{
		if (sbsp_copytype_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_copytype_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_copytype_ID, Integer.valueOf(sbsp_copytype_ID));
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

	/** Set sbsp_copytype_UU.
		@param sbsp_copytype_UU sbsp_copytype_UU
	*/
	public void setsbsp_copytype_UU (String sbsp_copytype_UU)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_copytype_UU, sbsp_copytype_UU);
	}

	/** Get sbsp_copytype_UU.
		@return sbsp_copytype_UU	  */
	public String getsbsp_copytype_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_copytype_UU);
	}
}