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

/** Generated Model for sbsp_userqueries
 *  @author iDempiere (generated)
 *  @version Release 12 - $Id$ */
@org.adempiere.base.Model(table="sbsp_userqueries")
public class X_sbsp_userqueries extends PO implements I_sbsp_userqueries, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20251021L;

    /** Standard Constructor */
    public X_sbsp_userqueries (Properties ctx, int sbsp_userqueries_ID, String trxName)
    {
      super (ctx, sbsp_userqueries_ID, trxName);
      /** if (sbsp_userqueries_ID == 0)
        {
			setName (null);
			setsbsp_userqueries_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_userqueries (Properties ctx, int sbsp_userqueries_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_userqueries_ID, trxName, virtualColumns);
      /** if (sbsp_userqueries_ID == 0)
        {
			setName (null);
			setsbsp_userqueries_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_userqueries (Properties ctx, String sbsp_userqueries_UU, String trxName)
    {
      super (ctx, sbsp_userqueries_UU, trxName);
      /** if (sbsp_userqueries_UU == null)
        {
			setName (null);
			setsbsp_userqueries_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_userqueries (Properties ctx, String sbsp_userqueries_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_userqueries_UU, trxName, virtualColumns);
      /** if (sbsp_userqueries_UU == null)
        {
			setName (null);
			setsbsp_userqueries_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_userqueries (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client
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
      StringBuilder sb = new StringBuilder ("X_sbsp_userqueries[")
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

	/** Set Comment/Help.
		@param Help Comment or Hint
	*/
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp()
	{
		return (String)get_Value(COLUMNNAME_Help);
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

	/** Set SQL Expression/Statement.
		@param SQLStatement SQL Expression/Statement
	*/
	public void setSQLStatement (String SQLStatement)
	{
		set_Value (COLUMNNAME_SQLStatement, SQLStatement);
	}

	/** Get SQL Expression/Statement.
		@return SQL Expression/Statement	  */
	public String getSQLStatement()
	{
		return (String)get_Value(COLUMNNAME_SQLStatement);
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

	/** Set Serverprint User Queries.
		@param sbsp_userqueries_ID Serverprint User Queries
	*/
	public void setsbsp_userqueries_ID (int sbsp_userqueries_ID)
	{
		if (sbsp_userqueries_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_userqueries_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_userqueries_ID, Integer.valueOf(sbsp_userqueries_ID));
	}

	/** Get Serverprint User Queries.
		@return Serverprint User Queries	  */
	public int getsbsp_userqueries_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_userqueries_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set sbsp_userqueries_UU.
		@param sbsp_userqueries_UU sbsp_userqueries_UU
	*/
	public void setsbsp_userqueries_UU (String sbsp_userqueries_UU)
	{
		set_Value (COLUMNNAME_sbsp_userqueries_UU, sbsp_userqueries_UU);
	}

	/** Get sbsp_userqueries_UU.
		@return sbsp_userqueries_UU	  */
	public String getsbsp_userqueries_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_userqueries_UU);
	}
}