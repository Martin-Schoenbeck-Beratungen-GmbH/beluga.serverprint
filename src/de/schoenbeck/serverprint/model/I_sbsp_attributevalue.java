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

/** Generated Interface for sbsp_attributevalue
 *  @author iDempiere (generated) 
 *  @version Release 10
 */
@SuppressWarnings("all")
public interface I_sbsp_attributevalue 
{

    /** TableName=sbsp_attributevalue */
    public static final String Table_Name = "sbsp_attributevalue";

    /** AD_Table_ID=1000005 */
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

    /** Column name PrinterAttributeValue */
    public static final String COLUMNNAME_PrinterAttributeValue = "PrinterAttributeValue";

	/** Set Printer Attribute Value.
	  * Allowed Value for Printer Attribute
	  */
	public void setPrinterAttributeValue (String PrinterAttributeValue);

	/** Get Printer Attribute Value.
	  * Allowed Value for Printer Attribute
	  */
	public String getPrinterAttributeValue();

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

    /** Column name sbsp_attributename_ID */
    public static final String COLUMNNAME_sbsp_attributename_ID = "sbsp_attributename_ID";

	/** Set Printer attributename	  */
	public void setsbsp_attributename_ID (int sbsp_attributename_ID);

	/** Get Printer attributename	  */
	public int getsbsp_attributename_ID();

	public I_sbsp_attributename getsbsp_attributename() throws RuntimeException;

    /** Column name sbsp_attributevalue_ID */
    public static final String COLUMNNAME_sbsp_attributevalue_ID = "sbsp_attributevalue_ID";

	/** Set Attributevalue	  */
	public void setsbsp_attributevalue_ID (int sbsp_attributevalue_ID);

	/** Get Attributevalue	  */
	public int getsbsp_attributevalue_ID();

    /** Column name sbsp_attributevalue_UU */
    public static final String COLUMNNAME_sbsp_attributevalue_UU = "sbsp_attributevalue_UU";

	/** Set sbsp_attributevalue_UU	  */
	public void setsbsp_attributevalue_UU (String sbsp_attributevalue_UU);

	/** Get sbsp_attributevalue_UU	  */
	public String getsbsp_attributevalue_UU();
}
