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

/** Generated Model for sbsp_subprintprofile
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_subprintprofile")
public class X_sbsp_subprintprofile extends PO implements I_sbsp_subprintprofile, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_subprintprofile (Properties ctx, int sbsp_subprintprofile_ID, String trxName)
    {
      super (ctx, sbsp_subprintprofile_ID, trxName);
      /** if (sbsp_subprintprofile_ID == 0)
        {
			setName (null);
			setsbsp_printprofile_ID (0);
			setsbsp_subprintprofile_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_subprintprofile (Properties ctx, int sbsp_subprintprofile_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_subprintprofile_ID, trxName, virtualColumns);
      /** if (sbsp_subprintprofile_ID == 0)
        {
			setName (null);
			setsbsp_printprofile_ID (0);
			setsbsp_subprintprofile_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_subprintprofile (Properties ctx, String sbsp_subprintprofile_UU, String trxName)
    {
      super (ctx, sbsp_subprintprofile_UU, trxName);
      /** if (sbsp_subprintprofile_UU == null)
        {
			setName (null);
			setsbsp_printprofile_ID (0);
			setsbsp_subprintprofile_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_subprintprofile (Properties ctx, String sbsp_subprintprofile_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_subprintprofile_UU, trxName, virtualColumns);
      /** if (sbsp_subprintprofile_UU == null)
        {
			setName (null);
			setsbsp_printprofile_ID (0);
			setsbsp_subprintprofile_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_subprintprofile (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_sbsp_subprintprofile[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Tab getAD_Tab() throws RuntimeException
	{
		return (org.compiere.model.I_AD_Tab)MTable.get(getCtx(), org.compiere.model.I_AD_Tab.Table_ID)
			.getPO(getAD_Tab_ID(), get_TrxName());
	}

	/** Set Tab.
		@param AD_Tab_ID Tab within a Window
	*/
	public void setAD_Tab_ID (int AD_Tab_ID)
	{
		if (AD_Tab_ID < 1)
			set_Value (COLUMNNAME_AD_Tab_ID, null);
		else
			set_Value (COLUMNNAME_AD_Tab_ID, Integer.valueOf(AD_Tab_ID));
	}

	/** Get Tab.
		@return Tab within a Window
	  */
	public int getAD_Tab_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Tab_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
	{
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_ID)
			.getPO(getC_DocType_ID(), get_TrxName());
	}

	/** Set Document Type.
		@param C_DocType_ID Document type or rules
	*/
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0)
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
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

	public I_sbsp_printprofile getsbsp_printprofile() throws RuntimeException
	{
		return (I_sbsp_printprofile)MTable.get(getCtx(), I_sbsp_printprofile.Table_ID)
			.getPO(getsbsp_printprofile_ID(), get_TrxName());
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

	/** Set sbsp_subprintprofile_UU.
		@param sbsp_subprintprofile_UU sbsp_subprintprofile_UU
	*/
	public void setsbsp_subprintprofile_UU (String sbsp_subprintprofile_UU)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_subprintprofile_UU, sbsp_subprintprofile_UU);
	}

	/** Get sbsp_subprintprofile_UU.
		@return sbsp_subprintprofile_UU	  */
	public String getsbsp_subprintprofile_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_subprintprofile_UU);
	}
}