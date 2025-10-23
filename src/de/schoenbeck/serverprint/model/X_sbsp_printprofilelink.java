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

/** Generated Model for sbsp_printprofilelink
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="sbsp_printprofilelink")
public class X_sbsp_printprofilelink extends PO implements I_sbsp_printprofilelink, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20240325L;

    /** Standard Constructor */
    public X_sbsp_printprofilelink (Properties ctx, int sbsp_printprofilelink_ID, String trxName)
    {
      super (ctx, sbsp_printprofilelink_ID, trxName);
      /** if (sbsp_printprofilelink_ID == 0)
        {
			setsbsp_printprofile_ID (0);
			setsbsp_printprofilelink_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printprofilelink (Properties ctx, int sbsp_printprofilelink_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printprofilelink_ID, trxName, virtualColumns);
      /** if (sbsp_printprofilelink_ID == 0)
        {
			setsbsp_printprofile_ID (0);
			setsbsp_printprofilelink_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printprofilelink (Properties ctx, String sbsp_printprofilelink_UU, String trxName)
    {
      super (ctx, sbsp_printprofilelink_UU, trxName);
      /** if (sbsp_printprofilelink_UU == null)
        {
			setsbsp_printprofile_ID (0);
			setsbsp_printprofilelink_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_sbsp_printprofilelink (Properties ctx, String sbsp_printprofilelink_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, sbsp_printprofilelink_UU, trxName, virtualColumns);
      /** if (sbsp_printprofilelink_UU == null)
        {
			setsbsp_printprofile_ID (0);
			setsbsp_printprofilelink_ID (0);
        } */
    }

    /** Load Constructor */
    public X_sbsp_printprofilelink (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
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
      StringBuilder sb = new StringBuilder ("X_sbsp_printprofilelink[")
        .append(get_ID()).append("]");
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
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
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

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
	{
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_ID)
			.getPO(getC_BPartner_ID(), get_TrxName());
	}

	/** Set Business Partner.
		@param C_BPartner_ID Identifies a Business Partner
	*/
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner.
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
			set_Value (COLUMNNAME_sbsp_printprofile_ID, null);
		else
			set_Value (COLUMNNAME_sbsp_printprofile_ID, Integer.valueOf(sbsp_printprofile_ID));
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

	/** Set sbsp_printprofilelink.
		@param sbsp_printprofilelink_ID sbsp_printprofilelink
	*/
	public void setsbsp_printprofilelink_ID (int sbsp_printprofilelink_ID)
	{
		if (sbsp_printprofilelink_ID < 1)
			set_ValueNoCheck (COLUMNNAME_sbsp_printprofilelink_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_sbsp_printprofilelink_ID, Integer.valueOf(sbsp_printprofilelink_ID));
	}

	/** Get sbsp_printprofilelink.
		@return sbsp_printprofilelink	  */
	public int getsbsp_printprofilelink_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_sbsp_printprofilelink_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set sbsp_printprofilelink_UU.
		@param sbsp_printprofilelink_UU sbsp_printprofilelink_UU
	*/
	public void setsbsp_printprofilelink_UU (String sbsp_printprofilelink_UU)
	{
		set_ValueNoCheck (COLUMNNAME_sbsp_printprofilelink_UU, sbsp_printprofilelink_UU);
	}

	/** Get sbsp_printprofilelink_UU.
		@return sbsp_printprofilelink_UU	  */
	public String getsbsp_printprofilelink_UU()
	{
		return (String)get_Value(COLUMNNAME_sbsp_printprofilelink_UU);
	}
}