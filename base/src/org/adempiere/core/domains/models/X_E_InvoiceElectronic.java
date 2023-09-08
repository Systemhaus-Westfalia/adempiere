/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.                                     *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net                                                  *
 * or https://github.com/adempiere/adempiere/blob/develop/license.html        *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.adempiere.core.domains.models;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for E_InvoiceElectronic
 *  @author Adempiere (generated) 
 *  @version Release 3.9.4 - $Id$ */
public class X_E_InvoiceElectronic extends PO implements I_E_InvoiceElectronic, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230908L;

    /** Standard Constructor */
    public X_E_InvoiceElectronic (Properties ctx, int E_InvoiceElectronic_ID, String trxName)
    {
      super (ctx, E_InvoiceElectronic_ID, trxName);
      /** if (E_InvoiceElectronic_ID == 0)
        {
			setE_InvoiceElectronic_ID (0);
        } */
    }

    /** Load Constructor */
    public X_E_InvoiceElectronic (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_E_InvoiceElectronic[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.adempiere.core.domains.models.I_C_Invoice getC_Invoice() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Invoice)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Invoice.Table_Name)
			.getPO(getC_Invoice_ID(), get_TrxName());	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_Value (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
	}

	/** Get Invoice.
		@return Invoice Identifier
	  */
	public int getC_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Electronic Invoice.
		@param E_InvoiceElectronic_ID Electronic Invoice	  */
	public void setE_InvoiceElectronic_ID (int E_InvoiceElectronic_ID)
	{
		if (E_InvoiceElectronic_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_E_InvoiceElectronic_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_E_InvoiceElectronic_ID, Integer.valueOf(E_InvoiceElectronic_ID));
	}

	/** Get Electronic Invoice.
		@return Electronic Invoice	  */
	public int getE_InvoiceElectronic_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_InvoiceElectronic_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** ei_ValidationStatus AD_Reference_ID=3000276 */
	public static final int EI_VALIDATIONSTATUS_AD_Reference_ID=3000276;
	/** Valid = 01 */
	public static final String EI_VALIDATIONSTATUS_Valid = "01";
	/** Not Valid = 02 */
	public static final String EI_VALIDATIONSTATUS_NotValid = "02";
	/** Set EI Validation Status (Intern).
		@param ei_ValidationStatus 
		EI Validation Status
	  */
	public void setei_ValidationStatus (String ei_ValidationStatus)
	{

		set_Value (COLUMNNAME_ei_ValidationStatus, ei_ValidationStatus);
	}

	/** Get EI Validation Status (Intern).
		@return EI Validation Status
	  */
	public String getei_ValidationStatus () 
	{
		return (String)get_Value(COLUMNNAME_ei_ValidationStatus);
	}

	/** Set error Msg Intern.
		@param errMsgIntern error Msg Intern	  */
	public void seterrMsgIntern (String errMsgIntern)
	{
		set_Value (COLUMNNAME_errMsgIntern, errMsgIntern);
	}

	/** Get error Msg Intern.
		@return error Msg Intern	  */
	public String geterrMsgIntern () 
	{
		return (String)get_Value(COLUMNNAME_errMsgIntern);
	}

	/** Set json.
		@param json json	  */
	public void setjson (String json)
	{
		set_Value (COLUMNNAME_json, json);
	}

	/** Get json.
		@return json	  */
	public String getjson () 
	{
		return (String)get_Value(COLUMNNAME_json);
	}

	/** Set Immutable Universally Unique Identifier.
		@param UUID 
		Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID)
	{
		set_Value (COLUMNNAME_UUID, UUID);
	}

	/** Get Immutable Universally Unique Identifier.
		@return Immutable Universally Unique Identifier
	  */
	public String getUUID () 
	{
		return (String)get_Value(COLUMNNAME_UUID);
	}
}