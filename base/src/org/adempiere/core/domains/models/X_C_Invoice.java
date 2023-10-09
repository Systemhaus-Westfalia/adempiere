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


import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.I_Persistent;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.POInfo;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for C_Invoice
 *  @author Adempiere (generated) 
 *  @version Release 3.9.4 - $Id$ */
public class X_C_Invoice extends PO implements I_C_Invoice, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20231006L;

    /** Standard Constructor */
    public X_C_Invoice (Properties ctx, int C_Invoice_ID, String trxName)
    {
      super (ctx, C_Invoice_ID, trxName);
      /** if (C_Invoice_ID == 0)
        {
			setC_BPartner_ID (0);
			setC_BPartner_Location_ID (0);
			setC_Currency_ID (0);
// @C_Currency_ID@
			setC_DocType_ID (0);
// 0
			setC_DocTypeTarget_ID (0);
			setC_Invoice_ID (0);
			setC_PaymentTerm_ID (0);
			setDateAcct (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDateInvoiced (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDocAction (null);
// CO
			setDocStatus (null);
// DR
			setDocumentNo (null);
			setGrandTotal (Env.ZERO);
			setIsApproved (false);
// @IsApproved@
			setisContract (false);
// N
			setIsDiscountPrinted (false);
			setIsInDispute (false);
// N
			setIsPaid (false);
// N
			setIsPayScheduleValid (false);
			setIsPrinted (false);
			setIsPublished (true);
// Y
			setIsSelfService (false);
			setIsSOTrx (false);
// @IsSOTrx@
			setIsTaxIncluded (false);
			setIsTransferred (false);
			setM_PriceList_ID (0);
			setoneProjectInvoice (true);
// Y
			setPaymentRule (null);
// P
			setPosted (false);
// N
			setProcessed (false);
			setSendEMail (false);
			setTotalLines (Env.ZERO);
			setUser1_ID (0);
        } */
    }

    /** Load Constructor */
    public X_C_Invoice (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_C_Invoice[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Trx Organization.
		@param AD_OrgTrx_ID 
		Performing or initiating organization
	  */
	public void setAD_OrgTrx_ID (int AD_OrgTrx_ID)
	{
		if (AD_OrgTrx_ID < 1) 
			set_Value (COLUMNNAME_AD_OrgTrx_ID, null);
		else 
			set_Value (COLUMNNAME_AD_OrgTrx_ID, Integer.valueOf(AD_OrgTrx_ID));
	}

	/** Get Trx Organization.
		@return Performing or initiating organization
	  */
	public int getAD_OrgTrx_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_OrgTrx_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_AD_User getAD_User() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_AD_User)MTable.get(getCtx(), org.adempiere.core.domains.models.I_AD_User.Table_Name)
			.getPO(getAD_User_ID(), get_TrxName());	}

	/** Set User/Contact.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
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
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Backup Value.
		@param BackupValue 
		The value of the column prior to migration.
	  */
	public void setBackupValue (String BackupValue)
	{
		set_Value (COLUMNNAME_BackupValue, BackupValue);
	}

	/** Get Backup Value.
		@return The value of the column prior to migration.
	  */
	public String getBackupValue () 
	{
		return (String)get_Value(COLUMNNAME_BackupValue);
	}

	public org.adempiere.core.domains.models.I_C_BPartner getBill_BPartner() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_BPartner)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_BPartner.Table_Name)
			.getPO(getBill_BPartner_ID(), get_TrxName());	}

	/** Set Invoice Partner.
		@param Bill_BPartner_ID 
		Business Partner to be invoiced
	  */
	public void setBill_BPartner_ID (int Bill_BPartner_ID)
	{
		if (Bill_BPartner_ID < 1) 
			set_Value (COLUMNNAME_Bill_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_Bill_BPartner_ID, Integer.valueOf(Bill_BPartner_ID));
	}

	/** Get Invoice Partner.
		@return Business Partner to be invoiced
	  */
	public int getBill_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Bill_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_BPartner_Location getBillTo() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_BPartner_Location)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_BPartner_Location.Table_Name)
			.getPO(getBillTo_ID(), get_TrxName());	}

	/** Set Invoice To.
		@param BillTo_ID 
		Bill to Address
	  */
	public void setBillTo_ID (int BillTo_ID)
	{
		if (BillTo_ID < 1) 
			set_Value (COLUMNNAME_BillTo_ID, null);
		else 
			set_Value (COLUMNNAME_BillTo_ID, Integer.valueOf(BillTo_ID));
	}

	/** Get Invoice To.
		@return Bill to Address
	  */
	public int getBillTo_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BillTo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set BOM Drop.
		@param BOMDrop 
		Drop (expand) Bill of Materials into an Order, Invoice, etc.
	  */
	public void setBOMDrop (String BOMDrop)
	{
		set_Value (COLUMNNAME_BOMDrop, BOMDrop);
	}

	/** Get BOM Drop.
		@return Drop (expand) Bill of Materials into an Order, Invoice, etc.
	  */
	public String getBOMDrop () 
	{
		return (String)get_Value(COLUMNNAME_BOMDrop);
	}

	public org.adempiere.core.domains.models.I_C_BPartner getbroker() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_BPartner)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_BPartner.Table_Name)
			.getPO(getbroker_ID(), get_TrxName());	}

	/** Set broker_ID.
		@param broker_ID broker_ID	  */
	public void setbroker_ID (int broker_ID)
	{
		if (broker_ID < 1) 
			set_Value (COLUMNNAME_broker_ID, null);
		else 
			set_Value (COLUMNNAME_broker_ID, Integer.valueOf(broker_ID));
	}

	/** Get broker_ID.
		@return broker_ID	  */
	public int getbroker_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_broker_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_Activity getC_Activity() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Activity)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Activity.Table_Name)
			.getPO(getC_Activity_ID(), get_TrxName());	}

	/** Set Activity.
		@param C_Activity_ID 
		Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1) 
			set_Value (COLUMNNAME_C_Activity_ID, null);
		else 
			set_Value (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Activity.
		@return Business Activity
	  */
	public int getC_Activity_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_BPartner)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_BPartner_Location)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_BPartner_Location.Table_Name)
			.getPO(getC_BPartner_Location_ID(), get_TrxName());	}

	/** Set Partner Location.
		@param C_BPartner_Location_ID 
		Identifies the (ship to) address for this Business Partner
	  */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID)
	{
		if (C_BPartner_Location_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
	}

	/** Get Partner Location.
		@return Identifies the (ship to) address for this Business Partner
	  */
	public int getC_BPartner_Location_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_BPartner getc_BPartnerimport() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_BPartner)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_BPartner.Table_Name)
			.getPO(getc_BPartnerimport_ID(), get_TrxName());	}

	/** Set c_BPartnerimport_ID.
		@param c_BPartnerimport_ID c_BPartnerimport_ID	  */
	public void setc_BPartnerimport_ID (int c_BPartnerimport_ID)
	{
		if (c_BPartnerimport_ID < 1) 
			set_Value (COLUMNNAME_c_BPartnerimport_ID, null);
		else 
			set_Value (COLUMNNAME_c_BPartnerimport_ID, Integer.valueOf(c_BPartnerimport_ID));
	}

	/** Get c_BPartnerimport_ID.
		@return c_BPartnerimport_ID	  */
	public int getc_BPartnerimport_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_c_BPartnerimport_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_Campaign getC_Campaign() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Campaign)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Campaign.Table_Name)
			.getPO(getC_Campaign_ID(), get_TrxName());	}

	/** Set Campaign.
		@param C_Campaign_ID 
		Marketing Campaign
	  */
	public void setC_Campaign_ID (int C_Campaign_ID)
	{
		if (C_Campaign_ID < 1) 
			set_Value (COLUMNNAME_C_Campaign_ID, null);
		else 
			set_Value (COLUMNNAME_C_Campaign_ID, Integer.valueOf(C_Campaign_ID));
	}

	/** Get Campaign.
		@return Marketing Campaign
	  */
	public int getC_Campaign_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Campaign_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_CashLine getC_CashLine() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_CashLine)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_CashLine.Table_Name)
			.getPO(getC_CashLine_ID(), get_TrxName());	}

	/** Set Cash Journal Line.
		@param C_CashLine_ID 
		Cash Journal Line
	  */
	public void setC_CashLine_ID (int C_CashLine_ID)
	{
		if (C_CashLine_ID < 1) 
			set_Value (COLUMNNAME_C_CashLine_ID, null);
		else 
			set_Value (COLUMNNAME_C_CashLine_ID, Integer.valueOf(C_CashLine_ID));
	}

	/** Get Cash Journal Line.
		@return Cash Journal Line
	  */
	public int getC_CashLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_CashLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_Charge getC_Charge() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Charge)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Charge.Table_Name)
			.getPO(getC_Charge_ID(), get_TrxName());	}

	/** Set Charge.
		@param C_Charge_ID 
		Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID)
	{
		if (C_Charge_ID < 1) 
			set_Value (COLUMNNAME_C_Charge_ID, null);
		else 
			set_Value (COLUMNNAME_C_Charge_ID, Integer.valueOf(C_Charge_ID));
	}

	/** Get Charge.
		@return Additional document charges
	  */
	public int getC_Charge_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Charge_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_CommissionRun getC_CommissionRun() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_CommissionRun)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_CommissionRun.Table_Name)
			.getPO(getC_CommissionRun_ID(), get_TrxName());	}

	/** Set Commission Run.
		@param C_CommissionRun_ID 
		Commission Run or Process
	  */
	public void setC_CommissionRun_ID (int C_CommissionRun_ID)
	{
		if (C_CommissionRun_ID < 1) 
			set_Value (COLUMNNAME_C_CommissionRun_ID, null);
		else 
			set_Value (COLUMNNAME_C_CommissionRun_ID, Integer.valueOf(C_CommissionRun_ID));
	}

	/** Get Commission Run.
		@return Commission Run or Process
	  */
	public int getC_CommissionRun_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_CommissionRun_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_ConversionType getC_ConversionType() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_ConversionType)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_ConversionType.Table_Name)
			.getPO(getC_ConversionType_ID(), get_TrxName());	}

	/** Set Currency Type.
		@param C_ConversionType_ID 
		Currency Conversion Rate Type
	  */
	public void setC_ConversionType_ID (int C_ConversionType_ID)
	{
		if (C_ConversionType_ID < 1) 
			set_Value (COLUMNNAME_C_ConversionType_ID, null);
		else 
			set_Value (COLUMNNAME_C_ConversionType_ID, Integer.valueOf(C_ConversionType_ID));
	}

	/** Get Currency Type.
		@return Currency Conversion Rate Type
	  */
	public int getC_ConversionType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ConversionType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_Currency getC_Currency() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Currency)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Currency.Table_Name)
			.getPO(getC_Currency_ID(), get_TrxName());	}

	/** Set Currency.
		@param C_Currency_ID 
		The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID)
	{
		if (C_Currency_ID < 1) 
			set_Value (COLUMNNAME_C_Currency_ID, null);
		else 
			set_Value (COLUMNNAME_C_Currency_ID, Integer.valueOf(C_Currency_ID));
	}

	/** Get Currency.
		@return The Currency for this record
	  */
	public int getC_Currency_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Currency_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_DocType)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_C_DocType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_DocType getC_DocTypeTarget() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_DocType)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_DocType.Table_Name)
			.getPO(getC_DocTypeTarget_ID(), get_TrxName());	}

	/** Set Target Document Type.
		@param C_DocTypeTarget_ID 
		Target document type for conversing documents
	  */
	public void setC_DocTypeTarget_ID (int C_DocTypeTarget_ID)
	{
		if (C_DocTypeTarget_ID < 1) 
			set_Value (COLUMNNAME_C_DocTypeTarget_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocTypeTarget_ID, Integer.valueOf(C_DocTypeTarget_ID));
	}

	/** Get Target Document Type.
		@return Target document type for conversing documents
	  */
	public int getC_DocTypeTarget_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocTypeTarget_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_DunningLevel getC_DunningLevel() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_DunningLevel)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_DunningLevel.Table_Name)
			.getPO(getC_DunningLevel_ID(), get_TrxName());	}

	/** Set Dunning Level.
		@param C_DunningLevel_ID Dunning Level	  */
	public void setC_DunningLevel_ID (int C_DunningLevel_ID)
	{
		if (C_DunningLevel_ID < 1) 
			set_Value (COLUMNNAME_C_DunningLevel_ID, null);
		else 
			set_Value (COLUMNNAME_C_DunningLevel_ID, Integer.valueOf(C_DunningLevel_ID));
	}

	/** Get Dunning Level.
		@return Dunning Level	  */
	public int getC_DunningLevel_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DunningLevel_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Invoice.
		@param C_Invoice_ID 
		Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID)
	{
		if (C_Invoice_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Invoice_ID, Integer.valueOf(C_Invoice_ID));
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

	public org.adempiere.core.domains.models.I_C_Order getC_Order() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Order)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Order.Table_Name)
			.getPO(getC_Order_ID(), get_TrxName());	}

	/** Set Order.
		@param C_Order_ID 
		Order
	  */
	public void setC_Order_ID (int C_Order_ID)
	{
		if (C_Order_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_Order_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_Order_ID, Integer.valueOf(C_Order_ID));
	}

	/** Get Order.
		@return Order
	  */
	public int getC_Order_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Order_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_Payment getC_Payment() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Payment)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Payment.Table_Name)
			.getPO(getC_Payment_ID(), get_TrxName());	}

	/** Set Payment.
		@param C_Payment_ID 
		Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID)
	{
		if (C_Payment_ID < 1) 
			set_Value (COLUMNNAME_C_Payment_ID, null);
		else 
			set_Value (COLUMNNAME_C_Payment_ID, Integer.valueOf(C_Payment_ID));
	}

	/** Get Payment.
		@return Payment identifier
	  */
	public int getC_Payment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Payment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_PaymentTerm getC_PaymentTerm() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_PaymentTerm)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_PaymentTerm.Table_Name)
			.getPO(getC_PaymentTerm_ID(), get_TrxName());	}

	/** Set Payment Term.
		@param C_PaymentTerm_ID 
		The terms of Payment (timing, discount)
	  */
	public void setC_PaymentTerm_ID (int C_PaymentTerm_ID)
	{
		if (C_PaymentTerm_ID < 1) 
			set_Value (COLUMNNAME_C_PaymentTerm_ID, null);
		else 
			set_Value (COLUMNNAME_C_PaymentTerm_ID, Integer.valueOf(C_PaymentTerm_ID));
	}

	/** Get Payment Term.
		@return The terms of Payment (timing, discount)
	  */
	public int getC_PaymentTerm_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_PaymentTerm_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_Period getC_Period() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Period)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Period.Table_Name)
			.getPO(getC_Period_ID(), get_TrxName());	}

	/** Set Period.
		@param C_Period_ID 
		Period of the Calendar
	  */
	public void setC_Period_ID (int C_Period_ID)
	{
		if (C_Period_ID < 1) 
			set_Value (COLUMNNAME_C_Period_ID, null);
		else 
			set_Value (COLUMNNAME_C_Period_ID, Integer.valueOf(C_Period_ID));
	}

	/** Get Period.
		@return Period of the Calendar
	  */
	public int getC_Period_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_POS getC_POS() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_POS)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_POS.Table_Name)
			.getPO(getC_POS_ID(), get_TrxName());	}

	/** Set POS Terminal.
		@param C_POS_ID 
		Point of Sales Terminal
	  */
	public void setC_POS_ID (int C_POS_ID)
	{
		if (C_POS_ID < 1) 
			set_Value (COLUMNNAME_C_POS_ID, null);
		else 
			set_Value (COLUMNNAME_C_POS_ID, Integer.valueOf(C_POS_ID));
	}

	/** Get POS Terminal.
		@return Point of Sales Terminal
	  */
	public int getC_POS_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_POS_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_Project getC_Project() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Project)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Project.Table_Name)
			.getPO(getC_Project_ID(), get_TrxName());	}

	/** Set Project.
		@param C_Project_ID 
		Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID)
	{
		if (C_Project_ID < 1) 
			set_Value (COLUMNNAME_C_Project_ID, null);
		else 
			set_Value (COLUMNNAME_C_Project_ID, Integer.valueOf(C_Project_ID));
	}

	/** Get Project.
		@return Financial Project
	  */
	public int getC_Project_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Project_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_SalesRegion getC_SalesRegion() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_SalesRegion)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_SalesRegion.Table_Name)
			.getPO(getC_SalesRegion_ID(), get_TrxName());	}

	/** Set Sales Region.
		@param C_SalesRegion_ID 
		Sales coverage region
	  */
	public void setC_SalesRegion_ID (int C_SalesRegion_ID)
	{
		if (C_SalesRegion_ID < 1) 
			set_Value (COLUMNNAME_C_SalesRegion_ID, null);
		else 
			set_Value (COLUMNNAME_C_SalesRegion_ID, Integer.valueOf(C_SalesRegion_ID));
	}

	/** Get Sales Region.
		@return Sales coverage region
	  */
	public int getC_SalesRegion_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_SalesRegion_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_AD_User getcashcollec() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_AD_User)MTable.get(getCtx(), org.adempiere.core.domains.models.I_AD_User.Table_Name)
			.getPO(getcashcollector(), get_TrxName());	}

	/** Set cashcollector.
		@param cashcollector cashcollector	  */
	public void setcashcollector (int cashcollector)
	{
		set_Value (COLUMNNAME_cashcollector, Integer.valueOf(cashcollector));
	}

	/** Get cashcollector.
		@return cashcollector	  */
	public int getcashcollector () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_cashcollector);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Charge amount.
		@param ChargeAmt 
		Charge Amount
	  */
	public void setChargeAmt (BigDecimal ChargeAmt)
	{
		set_Value (COLUMNNAME_ChargeAmt, ChargeAmt);
	}

	/** Get Charge amount.
		@return Charge Amount
	  */
	public BigDecimal getChargeAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ChargeAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Código registro DM.
		@param CodigoDeDeclaracion 
		Código registro de la declaración de mercancías en el sistema de Aduanas
	  */
	public void setCodigoDeDeclaracion (String CodigoDeDeclaracion)
	{
		set_Value (COLUMNNAME_CodigoDeDeclaracion, CodigoDeDeclaracion);
	}

	/** Get Código registro DM.
		@return Código registro de la declaración de mercancías en el sistema de Aduanas
	  */
	public String getCodigoDeDeclaracion () 
	{
		return (String)get_Value(COLUMNNAME_CodigoDeDeclaracion);
	}

	/** Set Comments.
		@param Comments 
		Comments or additional information
	  */
	public void setComments (String Comments)
	{
		set_Value (COLUMNNAME_Comments, Comments);
	}

	/** Get Comments.
		@return Comments or additional information
	  */
	public String getComments () 
	{
		return (String)get_Value(COLUMNNAME_Comments);
	}

	/** Set Concepto.
		@param Concepto Concepto	  */
	public void setConcepto (String Concepto)
	{
		set_Value (COLUMNNAME_Concepto, Concepto);
	}

	/** Get Concepto.
		@return Concepto	  */
	public String getConcepto () 
	{
		return (String)get_Value(COLUMNNAME_Concepto);
	}

	/** Set Copy From.
		@param CopyFrom 
		Copy From Record
	  */
	public void setCopyFrom (String CopyFrom)
	{
		set_Value (COLUMNNAME_CopyFrom, CopyFrom);
	}

	/** Get Copy From.
		@return Copy From Record
	  */
	public String getCopyFrom () 
	{
		return (String)get_Value(COLUMNNAME_CopyFrom);
	}

	/** Set Create lines from.
		@param CreateFrom 
		Process which will generate a new document lines based on an existing document
	  */
	public void setCreateFrom (String CreateFrom)
	{
		set_Value (COLUMNNAME_CreateFrom, CreateFrom);
	}

	/** Get Create lines from.
		@return Process which will generate a new document lines based on an existing document
	  */
	public String getCreateFrom () 
	{
		return (String)get_Value(COLUMNNAME_CreateFrom);
	}

	/** Set Account Date.
		@param DateAcct 
		Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct)
	{
		set_Value (COLUMNNAME_DateAcct, DateAcct);
	}

	/** Get Account Date.
		@return Accounting Date
	  */
	public Timestamp getDateAcct () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateAcct);
	}

	/** Set Date Invoiced.
		@param DateInvoiced 
		Date printed on Invoice
	  */
	public void setDateInvoiced (Timestamp DateInvoiced)
	{
		set_Value (COLUMNNAME_DateInvoiced, DateInvoiced);
	}

	/** Get Date Invoiced.
		@return Date printed on Invoice
	  */
	public Timestamp getDateInvoiced () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateInvoiced);
	}

	/** Set Date Ordered.
		@param DateOrdered 
		Date of Order
	  */
	public void setDateOrdered (Timestamp DateOrdered)
	{
		set_ValueNoCheck (COLUMNNAME_DateOrdered, DateOrdered);
	}

	/** Get Date Ordered.
		@return Date of Order
	  */
	public Timestamp getDateOrdered () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateOrdered);
	}

	/** Set Date printed.
		@param DatePrinted 
		Date the document was printed.
	  */
	public void setDatePrinted (Timestamp DatePrinted)
	{
		set_Value (COLUMNNAME_DatePrinted, DatePrinted);
	}

	/** Get Date printed.
		@return Date the document was printed.
	  */
	public Timestamp getDatePrinted () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DatePrinted);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set descriptionCancel.
		@param descriptionCancel descriptionCancel	  */
	public void setdescriptionCancel (String descriptionCancel)
	{
		set_Value (COLUMNNAME_descriptionCancel, descriptionCancel);
	}

	/** Get descriptionCancel.
		@return descriptionCancel	  */
	public String getdescriptionCancel () 
	{
		return (String)get_Value(COLUMNNAME_descriptionCancel);
	}

	public org.adempiere.core.domains.models.I_C_BPartner getDifBPPaytmen() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_BPartner)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_BPartner.Table_Name)
			.getPO(getDifBPPaytmentTo(), get_TrxName());	}

	/** Set DifBPPaytmentTo.
		@param DifBPPaytmentTo 
		Paytment/Reimbursement To business partner
	  */
	public void setDifBPPaytmentTo (int DifBPPaytmentTo)
	{
		set_Value (COLUMNNAME_DifBPPaytmentTo, Integer.valueOf(DifBPPaytmentTo));
	}

	/** Get DifBPPaytmentTo.
		@return Paytment/Reimbursement To business partner
	  */
	public int getDifBPPaytmentTo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_DifBPPaytmentTo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID=135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_Value (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getDocumentNo());
    }

	/** Set Documento transporte.
		@param DocumentoDeTransporte 
		Número de documento de transporte (AWB, BL, carta porte, etc.)
	  */
	public void setDocumentoDeTransporte (String DocumentoDeTransporte)
	{
		set_Value (COLUMNNAME_DocumentoDeTransporte, DocumentoDeTransporte);
	}

	/** Get Documento transporte.
		@return Número de documento de transporte (AWB, BL, carta porte, etc.)
	  */
	public String getDocumentoDeTransporte () 
	{
		return (String)get_Value(COLUMNNAME_DocumentoDeTransporte);
	}

	/** Set Dunning Grace Date.
		@param DunningGrace Dunning Grace Date	  */
	public void setDunningGrace (Timestamp DunningGrace)
	{
		set_Value (COLUMNNAME_DunningGrace, DunningGrace);
	}

	/** Get Dunning Grace Date.
		@return Dunning Grace Date	  */
	public Timestamp getDunningGrace () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DunningGrace);
	}

	/** Set ei_codigoGeneracion.
		@param ei_codigoGeneracion ei_codigoGeneracion	  */
	public void setei_codigoGeneracion (String ei_codigoGeneracion)
	{
		set_Value (COLUMNNAME_ei_codigoGeneracion, ei_codigoGeneracion);
	}

	/** Get ei_codigoGeneracion.
		@return ei_codigoGeneracion	  */
	public String getei_codigoGeneracion () 
	{
		return (String)get_Value(COLUMNNAME_ei_codigoGeneracion);
	}

	/** Set numeroControl.
		@param ei_numeroControl numeroControl	  */
	public void setei_numeroControl (String ei_numeroControl)
	{
		set_Value (COLUMNNAME_ei_numeroControl, ei_numeroControl);
	}

	/** Get numeroControl.
		@return numeroControl	  */
	public String getei_numeroControl () 
	{
		return (String)get_Value(COLUMNNAME_ei_numeroControl);
	}

	/** Set selloRecibido.
		@param ei_selloRecibido selloRecibido	  */
	public void setei_selloRecibido (String ei_selloRecibido)
	{
		set_Value (COLUMNNAME_ei_selloRecibido, ei_selloRecibido);
	}

	/** Get selloRecibido.
		@return selloRecibido	  */
	public String getei_selloRecibido () 
	{
		return (String)get_Value(COLUMNNAME_ei_selloRecibido);
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

	/** Set Financial Account.
		@param FM_Account_ID Financial Account	  */
	public void setFM_Account_ID (int FM_Account_ID)
	{
		if (FM_Account_ID < 1) 
			set_Value (COLUMNNAME_FM_Account_ID, null);
		else 
			set_Value (COLUMNNAME_FM_Account_ID, Integer.valueOf(FM_Account_ID));
	}

	/** Get Financial Account.
		@return Financial Account	  */
	public int getFM_Account_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FM_Account_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Agreement.
		@param FM_Agreement_ID Agreement	  */
	public void setFM_Agreement_ID (int FM_Agreement_ID)
	{
		if (FM_Agreement_ID < 1) 
			set_Value (COLUMNNAME_FM_Agreement_ID, null);
		else 
			set_Value (COLUMNNAME_FM_Agreement_ID, Integer.valueOf(FM_Agreement_ID));
	}

	/** Get Agreement.
		@return Agreement	  */
	public int getFM_Agreement_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FM_Agreement_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Generate To.
		@param GenerateTo 
		Generate To
	  */
	public void setGenerateTo (String GenerateTo)
	{
		set_Value (COLUMNNAME_GenerateTo, GenerateTo);
	}

	/** Get Generate To.
		@return Generate To
	  */
	public String getGenerateTo () 
	{
		return (String)get_Value(COLUMNNAME_GenerateTo);
	}

	/** Set Generate Withholding.
		@param GenerateWithholding Generate Withholding	  */
	public void setGenerateWithholding (String GenerateWithholding)
	{
		set_Value (COLUMNNAME_GenerateWithholding, GenerateWithholding);
	}

	/** Get Generate Withholding.
		@return Generate Withholding	  */
	public String getGenerateWithholding () 
	{
		return (String)get_Value(COLUMNNAME_GenerateWithholding);
	}

	/** Set Grand Total.
		@param GrandTotal 
		Total amount of document
	  */
	public void setGrandTotal (BigDecimal GrandTotal)
	{
		set_Value (COLUMNNAME_GrandTotal, GrandTotal);
	}

	/** Get Grand Total.
		@return Total amount of document
	  */
	public BigDecimal getGrandTotal () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_GrandTotal);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Incoterms AD_Reference_ID=1000015 */
	public static final int INCOTERMS_AD_Reference_ID=1000015;
	/** EXW = 10 */
	public static final String INCOTERMS_EXW = "10";
	/** DAP = 100 */
	public static final String INCOTERMS_DAP = "100";
	/** DDP = 110 */
	public static final String INCOTERMS_DDP = "110";
	/** FCA = 20 */
	public static final String INCOTERMS_FCA = "20";
	/** FAS = 30 */
	public static final String INCOTERMS_FAS = "30";
	/** FOB = 40 */
	public static final String INCOTERMS_FOB = "40";
	/** CFR = 50 */
	public static final String INCOTERMS_CFR = "50";
	/** CIF = 60 */
	public static final String INCOTERMS_CIF = "60";
	/** CPT = 70 */
	public static final String INCOTERMS_CPT = "70";
	/** CIP = 80 */
	public static final String INCOTERMS_CIP = "80";
	/** DAT = 90 */
	public static final String INCOTERMS_DAT = "90";
	/** Set Incoterm.
		@param Incoterms 
		Término de compra del pedido
	  */
	public void setIncoterms (String Incoterms)
	{

		set_Value (COLUMNNAME_Incoterms, Incoterms);
	}

	/** Get Incoterm.
		@return Término de compra del pedido
	  */
	public String getIncoterms () 
	{
		return (String)get_Value(COLUMNNAME_Incoterms);
	}

	/** Set invoiceclass.
		@param invoiceclass invoiceclass	  */
	public void setinvoiceclass (String invoiceclass)
	{
		set_Value (COLUMNNAME_invoiceclass, invoiceclass);
	}

	/** Get invoiceclass.
		@return invoiceclass	  */
	public String getinvoiceclass () 
	{
		return (String)get_Value(COLUMNNAME_invoiceclass);
	}

	/** InvoiceCollectionType AD_Reference_ID=394 */
	public static final int INVOICECOLLECTIONTYPE_AD_Reference_ID=394;
	/** Dunning = D */
	public static final String INVOICECOLLECTIONTYPE_Dunning = "D";
	/** Collection Agency = C */
	public static final String INVOICECOLLECTIONTYPE_CollectionAgency = "C";
	/** Legal Procedure = L */
	public static final String INVOICECOLLECTIONTYPE_LegalProcedure = "L";
	/** Uncollectable = U */
	public static final String INVOICECOLLECTIONTYPE_Uncollectable = "U";
	/** Set Collection Status.
		@param InvoiceCollectionType 
		Invoice Collection Status
	  */
	public void setInvoiceCollectionType (String InvoiceCollectionType)
	{

		set_Value (COLUMNNAME_InvoiceCollectionType, InvoiceCollectionType);
	}

	/** Get Collection Status.
		@return Invoice Collection Status
	  */
	public String getInvoiceCollectionType () 
	{
		return (String)get_Value(COLUMNNAME_InvoiceCollectionType);
	}

	/** Set Approved.
		@param IsApproved 
		Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved)
	{
		set_ValueNoCheck (COLUMNNAME_IsApproved, Boolean.valueOf(IsApproved));
	}

	/** Get Approved.
		@return Indicates if this document requires approval
	  */
	public boolean isApproved () 
	{
		Object oo = get_Value(COLUMNNAME_IsApproved);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set isContract.
		@param isContract isContract	  */
	public void setisContract (boolean isContract)
	{
		set_Value (COLUMNNAME_isContract, Boolean.valueOf(isContract));
	}

	/** Get isContract.
		@return isContract	  */
	public boolean isContract () 
	{
		Object oo = get_Value(COLUMNNAME_isContract);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Discount Printed.
		@param IsDiscountPrinted 
		Print Discount on Invoice and Order
	  */
	public void setIsDiscountPrinted (boolean IsDiscountPrinted)
	{
		set_Value (COLUMNNAME_IsDiscountPrinted, Boolean.valueOf(IsDiscountPrinted));
	}

	/** Get Discount Printed.
		@return Print Discount on Invoice and Order
	  */
	public boolean isDiscountPrinted () 
	{
		Object oo = get_Value(COLUMNNAME_IsDiscountPrinted);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Fixed Asset Invoice.
		@param IsFixedAssetInvoice 
		Indicates if an Invoice is for a Fixed Asset
	  */
	public void setIsFixedAssetInvoice (boolean IsFixedAssetInvoice)
	{
		set_ValueNoCheck (COLUMNNAME_IsFixedAssetInvoice, Boolean.valueOf(IsFixedAssetInvoice));
	}

	/** Get Is Fixed Asset Invoice.
		@return Indicates if an Invoice is for a Fixed Asset
	  */
	public boolean isFixedAssetInvoice () 
	{
		Object oo = get_Value(COLUMNNAME_IsFixedAssetInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set In Dispute.
		@param IsInDispute 
		Document is in dispute
	  */
	public void setIsInDispute (boolean IsInDispute)
	{
		set_Value (COLUMNNAME_IsInDispute, Boolean.valueOf(IsInDispute));
	}

	/** Get In Dispute.
		@return Document is in dispute
	  */
	public boolean isInDispute () 
	{
		Object oo = get_Value(COLUMNNAME_IsInDispute);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Paid.
		@param IsPaid 
		The document is paid
	  */
	public void setIsPaid (boolean IsPaid)
	{
		set_Value (COLUMNNAME_IsPaid, Boolean.valueOf(IsPaid));
	}

	/** Get Paid.
		@return The document is paid
	  */
	public boolean isPaid () 
	{
		Object oo = get_Value(COLUMNNAME_IsPaid);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Pay Schedule valid.
		@param IsPayScheduleValid 
		Is the Payment Schedule is valid
	  */
	public void setIsPayScheduleValid (boolean IsPayScheduleValid)
	{
		set_ValueNoCheck (COLUMNNAME_IsPayScheduleValid, Boolean.valueOf(IsPayScheduleValid));
	}

	/** Get Pay Schedule valid.
		@return Is the Payment Schedule is valid
	  */
	public boolean isPayScheduleValid () 
	{
		Object oo = get_Value(COLUMNNAME_IsPayScheduleValid);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Printed.
		@param IsPrinted 
		Indicates if this document / line is printed
	  */
	public void setIsPrinted (boolean IsPrinted)
	{
		set_ValueNoCheck (COLUMNNAME_IsPrinted, Boolean.valueOf(IsPrinted));
	}

	/** Get Printed.
		@return Indicates if this document / line is printed
	  */
	public boolean isPrinted () 
	{
		Object oo = get_Value(COLUMNNAME_IsPrinted);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Published.
		@param IsPublished 
		The Topic is published and can be viewed
	  */
	public void setIsPublished (boolean IsPublished)
	{
		set_Value (COLUMNNAME_IsPublished, Boolean.valueOf(IsPublished));
	}

	/** Get Published.
		@return The Topic is published and can be viewed
	  */
	public boolean isPublished () 
	{
		Object oo = get_Value(COLUMNNAME_IsPublished);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Self-Service.
		@param IsSelfService 
		This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public void setIsSelfService (boolean IsSelfService)
	{
		set_Value (COLUMNNAME_IsSelfService, Boolean.valueOf(IsSelfService));
	}

	/** Get Self-Service.
		@return This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public boolean isSelfService () 
	{
		Object oo = get_Value(COLUMNNAME_IsSelfService);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Sales Transaction.
		@param IsSOTrx 
		This is a Sales Transaction
	  */
	public void setIsSOTrx (boolean IsSOTrx)
	{
		set_ValueNoCheck (COLUMNNAME_IsSOTrx, Boolean.valueOf(IsSOTrx));
	}

	/** Get Sales Transaction.
		@return This is a Sales Transaction
	  */
	public boolean isSOTrx () 
	{
		Object oo = get_Value(COLUMNNAME_IsSOTrx);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set isSplitInvoice.
		@param isSplitInvoice isSplitInvoice	  */
	public void setisSplitInvoice (boolean isSplitInvoice)
	{
		set_Value (COLUMNNAME_isSplitInvoice, Boolean.valueOf(isSplitInvoice));
	}

	/** Get isSplitInvoice.
		@return isSplitInvoice	  */
	public boolean isSplitInvoice () 
	{
		Object oo = get_Value(COLUMNNAME_isSplitInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Price includes Tax.
		@param IsTaxIncluded 
		Tax is included in the price 
	  */
	public void setIsTaxIncluded (boolean IsTaxIncluded)
	{
		set_Value (COLUMNNAME_IsTaxIncluded, Boolean.valueOf(IsTaxIncluded));
	}

	/** Get Price includes Tax.
		@return Tax is included in the price 
	  */
	public boolean isTaxIncluded () 
	{
		Object oo = get_Value(COLUMNNAME_IsTaxIncluded);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Transferred.
		@param IsTransferred 
		Transferred to General Ledger (i.e. accounted)
	  */
	public void setIsTransferred (boolean IsTransferred)
	{
		set_ValueNoCheck (COLUMNNAME_IsTransferred, Boolean.valueOf(IsTransferred));
	}

	/** Get Transferred.
		@return Transferred to General Ledger (i.e. accounted)
	  */
	public boolean isTransferred () 
	{
		Object oo = get_Value(COLUMNNAME_IsTransferred);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set LG_Route ID.
		@param LG_Route_ID LG_Route ID	  */
	public void setLG_Route_ID (int LG_Route_ID)
	{
		if (LG_Route_ID < 1) 
			set_Value (COLUMNNAME_LG_Route_ID, null);
		else 
			set_Value (COLUMNNAME_LG_Route_ID, Integer.valueOf(LG_Route_ID));
	}

	/** Get LG_Route ID.
		@return LG_Route ID	  */
	public int getLG_Route_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LG_Route_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_M_PriceList getM_PriceList() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_M_PriceList)MTable.get(getCtx(), org.adempiere.core.domains.models.I_M_PriceList.Table_Name)
			.getPO(getM_PriceList_ID(), get_TrxName());	}

	/** Set Price List.
		@param M_PriceList_ID 
		Unique identifier of a Price List
	  */
	public void setM_PriceList_ID (int M_PriceList_ID)
	{
		if (M_PriceList_ID < 1) 
			set_Value (COLUMNNAME_M_PriceList_ID, null);
		else 
			set_Value (COLUMNNAME_M_PriceList_ID, Integer.valueOf(M_PriceList_ID));
	}

	/** Get Price List.
		@return Unique identifier of a Price List
	  */
	public int getM_PriceList_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_PriceList_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_M_Product_Classification getM_Product_Classification() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_M_Product_Classification)MTable.get(getCtx(), org.adempiere.core.domains.models.I_M_Product_Classification.Table_Name)
			.getPO(getM_Product_Classification_ID(), get_TrxName());	}

	/** Set Product Classification.
		@param M_Product_Classification_ID 
		Classification of a Product
	  */
	public void setM_Product_Classification_ID (int M_Product_Classification_ID)
	{
		if (M_Product_Classification_ID < 1) 
			set_Value (COLUMNNAME_M_Product_Classification_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_Classification_ID, Integer.valueOf(M_Product_Classification_ID));
	}

	/** Get Product Classification.
		@return Classification of a Product
	  */
	public int getM_Product_Classification_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_Classification_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_M_RMA getM_RMA() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_M_RMA)MTable.get(getCtx(), org.adempiere.core.domains.models.I_M_RMA.Table_Name)
			.getPO(getM_RMA_ID(), get_TrxName());	}

	/** Set RMA.
		@param M_RMA_ID 
		Return Material Authorization
	  */
	public void setM_RMA_ID (int M_RMA_ID)
	{
		if (M_RMA_ID < 1) 
			set_Value (COLUMNNAME_M_RMA_ID, null);
		else 
			set_Value (COLUMNNAME_M_RMA_ID, Integer.valueOf(M_RMA_ID));
	}

	/** Get RMA.
		@return Return Material Authorization
	  */
	public int getM_RMA_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_RMA_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set oneProjectInvoice.
		@param oneProjectInvoice oneProjectInvoice	  */
	public void setoneProjectInvoice (boolean oneProjectInvoice)
	{
		set_Value (COLUMNNAME_oneProjectInvoice, Boolean.valueOf(oneProjectInvoice));
	}

	/** Get oneProjectInvoice.
		@return oneProjectInvoice	  */
	public boolean isoneProjectInvoice () 
	{
		Object oo = get_Value(COLUMNNAME_oneProjectInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Payment date.
		@param PayDate 
		Date Payment made
	  */
	public void setPayDate (Timestamp PayDate)
	{
		set_Value (COLUMNNAME_PayDate, PayDate);
	}

	/** Get Payment date.
		@return Date Payment made
	  */
	public Timestamp getPayDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_PayDate);
	}

	/** PaymentRule AD_Reference_ID=195 */
	public static final int PAYMENTRULE_AD_Reference_ID=195;
	/** Cash = B */
	public static final String PAYMENTRULE_Cash = "B";
	/** Credit Card = K */
	public static final String PAYMENTRULE_CreditCard = "K";
	/** Direct Deposit = T */
	public static final String PAYMENTRULE_DirectDeposit = "T";
	/** Check = S */
	public static final String PAYMENTRULE_Check = "S";
	/** On Credit = P */
	public static final String PAYMENTRULE_OnCredit = "P";
	/** Direct Debit = D */
	public static final String PAYMENTRULE_DirectDebit = "D";
	/** Mixed = M */
	public static final String PAYMENTRULE_Mixed = "M";
	/** Set Payment Rule.
		@param PaymentRule 
		How you pay the invoice
	  */
	public void setPaymentRule (String PaymentRule)
	{

		set_Value (COLUMNNAME_PaymentRule, PaymentRule);
	}

	/** Get Payment Rule.
		@return How you pay the invoice
	  */
	public String getPaymentRule () 
	{
		return (String)get_Value(COLUMNNAME_PaymentRule);
	}

	/** Set Order Reference.
		@param POReference 
		Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public void setPOReference (String POReference)
	{
		set_Value (COLUMNNAME_POReference, POReference);
	}

	/** Get Order Reference.
		@return Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public String getPOReference () 
	{
		return (String)get_Value(COLUMNNAME_POReference);
	}

	/** Set Posted.
		@param Posted 
		Posting status
	  */
	public void setPosted (boolean Posted)
	{
		set_Value (COLUMNNAME_Posted, Boolean.valueOf(Posted));
	}

	/** Get Posted.
		@return Posting status
	  */
	public boolean isPosted () 
	{
		Object oo = get_Value(COLUMNNAME_Posted);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_ValueNoCheck (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Processed On.
		@param ProcessedOn 
		The date+time (expressed in decimal format) when the document has been processed
	  */
	public void setProcessedOn (BigDecimal ProcessedOn)
	{
		set_Value (COLUMNNAME_ProcessedOn, ProcessedOn);
	}

	/** Get Processed On.
		@return The date+time (expressed in decimal format) when the document has been processed
	  */
	public BigDecimal getProcessedOn () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ProcessedOn);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Provider.
		@param Provider Provider	  */
	public void setProvider (String Provider)
	{
		set_Value (COLUMNNAME_Provider, Provider);
	}

	/** Get Provider.
		@return Provider	  */
	public String getProvider () 
	{
		return (String)get_Value(COLUMNNAME_Provider);
	}

	/** Set Pedido.
		@param ProviderPO 
		Número de la Orden de Compra o pedido del cliente hacia el proveedor
	  */
	public void setProviderPO (String ProviderPO)
	{
		set_Value (COLUMNNAME_ProviderPO, ProviderPO);
	}

	/** Get Pedido.
		@return Número de la Orden de Compra o pedido del cliente hacia el proveedor
	  */
	public String getProviderPO () 
	{
		return (String)get_Value(COLUMNNAME_ProviderPO);
	}

	/** Set Referenced Invoice.
		@param Ref_Invoice_ID Referenced Invoice	  */
	public void setRef_Invoice_ID (int Ref_Invoice_ID)
	{
		if (Ref_Invoice_ID < 1) 
			set_Value (COLUMNNAME_Ref_Invoice_ID, null);
		else 
			set_Value (COLUMNNAME_Ref_Invoice_ID, Integer.valueOf(Ref_Invoice_ID));
	}

	/** Get Referenced Invoice.
		@return Referenced Invoice	  */
	public int getRef_Invoice_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Ref_Invoice_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Referencia DM.
		@param ReferenciaDeDeclaracion 
		Referencia interna de la mercancía del agente de aduana
	  */
	public void setReferenciaDeDeclaracion (String ReferenciaDeDeclaracion)
	{
		set_Value (COLUMNNAME_ReferenciaDeDeclaracion, ReferenciaDeDeclaracion);
	}

	/** Get Referencia DM.
		@return Referencia interna de la mercancía del agente de aduana
	  */
	public String getReferenciaDeDeclaracion () 
	{
		return (String)get_Value(COLUMNNAME_ReferenciaDeDeclaracion);
	}

	public org.adempiere.core.domains.models.I_C_BPartner getremitee() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_BPartner)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_BPartner.Table_Name)
			.getPO(getremitee_ID(), get_TrxName());	}

	/** Set remitee_ID.
		@param remitee_ID remitee_ID	  */
	public void setremitee_ID (int remitee_ID)
	{
		if (remitee_ID < 1) 
			set_Value (COLUMNNAME_remitee_ID, null);
		else 
			set_Value (COLUMNNAME_remitee_ID, Integer.valueOf(remitee_ID));
	}

	/** Get remitee_ID.
		@return remitee_ID	  */
	public int getremitee_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_remitee_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_Invoice getReversal() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Invoice)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Invoice.Table_Name)
			.getPO(getReversal_ID(), get_TrxName());	}

	/** Set Reversal ID.
		@param Reversal_ID 
		ID of document reversal
	  */
	public void setReversal_ID (int Reversal_ID)
	{
		if (Reversal_ID < 1) 
			set_Value (COLUMNNAME_Reversal_ID, null);
		else 
			set_Value (COLUMNNAME_Reversal_ID, Integer.valueOf(Reversal_ID));
	}

	/** Get Reversal ID.
		@return ID of document reversal
	  */
	public int getReversal_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Reversal_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_AD_User getSalesRep() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_AD_User)MTable.get(getCtx(), org.adempiere.core.domains.models.I_AD_User.Table_Name)
			.getPO(getSalesRep_ID(), get_TrxName());	}

	/** Set Sales Representative.
		@param SalesRep_ID 
		Sales Representative or Company Agent
	  */
	public void setSalesRep_ID (int SalesRep_ID)
	{
		if (SalesRep_ID < 1) 
			set_Value (COLUMNNAME_SalesRep_ID, null);
		else 
			set_Value (COLUMNNAME_SalesRep_ID, Integer.valueOf(SalesRep_ID));
	}

	/** Get Sales Representative.
		@return Sales Representative or Company Agent
	  */
	public int getSalesRep_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SalesRep_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Send EMail.
		@param SendEMail 
		Enable sending Document EMail
	  */
	public void setSendEMail (boolean SendEMail)
	{
		set_Value (COLUMNNAME_SendEMail, Boolean.valueOf(SendEMail));
	}

	/** Get Send EMail.
		@return Enable sending Document EMail
	  */
	public boolean isSendEMail () 
	{
		Object oo = get_Value(COLUMNNAME_SendEMail);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Sequence.
		@param SeqNo 
		Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Serial No.
		@param SerNo 
		Product Serial Number 
	  */
	public void setSerNo (String SerNo)
	{
		set_Value (COLUMNNAME_SerNo, SerNo);
	}

	/** Get Serial No.
		@return Product Serial Number 
	  */
	public String getSerNo () 
	{
		return (String)get_Value(COLUMNNAME_SerNo);
	}

	/** Set shw_Amt.
		@param shw_Amt shw_Amt	  */
	public void setshw_Amt (BigDecimal shw_Amt)
	{
		set_Value (COLUMNNAME_shw_Amt, shw_Amt);
	}

	/** Get shw_Amt.
		@return shw_Amt	  */
	public BigDecimal getshw_Amt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_shw_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set SHW_ChangeDocumentNo.
		@param SHW_ChangeDocumentNo SHW_ChangeDocumentNo	  */
	public void setSHW_ChangeDocumentNo (String SHW_ChangeDocumentNo)
	{
		set_Value (COLUMNNAME_SHW_ChangeDocumentNo, SHW_ChangeDocumentNo);
	}

	/** Get SHW_ChangeDocumentNo.
		@return SHW_ChangeDocumentNo	  */
	public String getSHW_ChangeDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_SHW_ChangeDocumentNo);
	}

	public org.adempiere.core.domains.models.I_C_Invoice getshw_contract() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_Invoice)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_Invoice.Table_Name)
			.getPO(getshw_contract_ID(), get_TrxName());	}

	/** Set shw_contract_ID.
		@param shw_contract_ID shw_contract_ID	  */
	public void setshw_contract_ID (int shw_contract_ID)
	{
		if (shw_contract_ID < 1) 
			set_Value (COLUMNNAME_shw_contract_ID, null);
		else 
			set_Value (COLUMNNAME_shw_contract_ID, Integer.valueOf(shw_contract_ID));
	}

	/** Get shw_contract_ID.
		@return shw_contract_ID	  */
	public int getshw_contract_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_shw_contract_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set SHW_CreateQuedan.
		@param SHW_CreateQuedan SHW_CreateQuedan	  */
	public void setSHW_CreateQuedan (String SHW_CreateQuedan)
	{
		set_Value (COLUMNNAME_SHW_CreateQuedan, SHW_CreateQuedan);
	}

	/** Get SHW_CreateQuedan.
		@return SHW_CreateQuedan	  */
	public String getSHW_CreateQuedan () 
	{
		return (String)get_Value(COLUMNNAME_SHW_CreateQuedan);
	}

	/** Set SHW_INV_Reactivate.
		@param SHW_INV_Reactivate SHW_INV_Reactivate	  */
	public void setSHW_INV_Reactivate (String SHW_INV_Reactivate)
	{
		set_Value (COLUMNNAME_SHW_INV_Reactivate, SHW_INV_Reactivate);
	}

	/** Get SHW_INV_Reactivate.
		@return SHW_INV_Reactivate	  */
	public String getSHW_INV_Reactivate () 
	{
		return (String)get_Value(COLUMNNAME_SHW_INV_Reactivate);
	}

	/** Set shw_PrintComprobanteReintegro.
		@param shw_PrintComprobanteReintegro shw_PrintComprobanteReintegro	  */
	public void setshw_PrintComprobanteReintegro (String shw_PrintComprobanteReintegro)
	{
		set_Value (COLUMNNAME_shw_PrintComprobanteReintegro, shw_PrintComprobanteReintegro);
	}

	/** Get shw_PrintComprobanteReintegro.
		@return shw_PrintComprobanteReintegro	  */
	public String getshw_PrintComprobanteReintegro () 
	{
		return (String)get_Value(COLUMNNAME_shw_PrintComprobanteReintegro);
	}

	/** Set shw_reason_Cancelation.
		@param shw_reason_Cancelation shw_reason_Cancelation	  */
	public void setshw_reason_Cancelation (String shw_reason_Cancelation)
	{
		set_Value (COLUMNNAME_shw_reason_Cancelation, shw_reason_Cancelation);
	}

	/** Get shw_reason_Cancelation.
		@return shw_reason_Cancelation	  */
	public String getshw_reason_Cancelation () 
	{
		return (String)get_Value(COLUMNNAME_shw_reason_Cancelation);
	}

	/** Set shw_retaceo ID.
		@param shw_retaceo_ID shw_retaceo ID	  */
	public void setshw_retaceo_ID (int shw_retaceo_ID)
	{
		if (shw_retaceo_ID < 1) 
			set_Value (COLUMNNAME_shw_retaceo_ID, null);
		else 
			set_Value (COLUMNNAME_shw_retaceo_ID, Integer.valueOf(shw_retaceo_ID));
	}

	/** Get shw_retaceo ID.
		@return shw_retaceo ID	  */
	public int getshw_retaceo_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_shw_retaceo_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set shw_tax.
		@param shw_tax shw_tax	  */
	public void setshw_tax (BigDecimal shw_tax)
	{
		set_Value (COLUMNNAME_shw_tax, shw_tax);
	}

	/** Get shw_tax.
		@return shw_tax	  */
	public BigDecimal getshw_tax () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_shw_tax);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tax Amount.
		@param TaxAmt 
		Tax Amount for a document
	  */
	public void setTaxAmt (BigDecimal TaxAmt)
	{
		set_Value (COLUMNNAME_TaxAmt, TaxAmt);
	}

	/** Get Tax Amount.
		@return Tax Amount for a document
	  */
	public BigDecimal getTaxAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TaxAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set taxamtdeclared.
		@param taxamtdeclared taxamtdeclared	  */
	public void settaxamtdeclared (BigDecimal taxamtdeclared)
	{
		set_Value (COLUMNNAME_taxamtdeclared, taxamtdeclared);
	}

	/** Get taxamtdeclared.
		@return taxamtdeclared	  */
	public BigDecimal gettaxamtdeclared () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_taxamtdeclared);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Tax base Amount.
		@param TaxBaseAmt 
		Base for calculating the tax amount
	  */
	public void setTaxBaseAmt (BigDecimal TaxBaseAmt)
	{
		set_Value (COLUMNNAME_TaxBaseAmt, TaxBaseAmt);
	}

	/** Get Tax base Amount.
		@return Base for calculating the tax amount
	  */
	public BigDecimal getTaxBaseAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TaxBaseAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set taxbaseamtdeclared.
		@param taxbaseamtdeclared taxbaseamtdeclared	  */
	public void settaxbaseamtdeclared (BigDecimal taxbaseamtdeclared)
	{
		set_Value (COLUMNNAME_taxbaseamtdeclared, taxbaseamtdeclared);
	}

	/** Get taxbaseamtdeclared.
		@return taxbaseamtdeclared	  */
	public BigDecimal gettaxbaseamtdeclared () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_taxbaseamtdeclared);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Total Lines.
		@param TotalLines 
		Total of all document lines
	  */
	public void setTotalLines (BigDecimal TotalLines)
	{
		set_ValueNoCheck (COLUMNNAME_TotalLines, TotalLines);
	}

	/** Get Total Lines.
		@return Total of all document lines
	  */
	public BigDecimal getTotalLines () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TotalLines);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.adempiere.core.domains.models.I_C_ElementValue getUser1() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_ElementValue)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_ElementValue.Table_Name)
			.getPO(getUser1_ID(), get_TrxName());	}

	/** Set User List 1.
		@param User1_ID 
		User defined list element #1
	  */
	public void setUser1_ID (int User1_ID)
	{
		if (User1_ID < 1) 
			set_Value (COLUMNNAME_User1_ID, null);
		else 
			set_Value (COLUMNNAME_User1_ID, Integer.valueOf(User1_ID));
	}

	/** Get User List 1.
		@return User defined list element #1
	  */
	public int getUser1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_ElementValue getUser2() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_ElementValue)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_ElementValue.Table_Name)
			.getPO(getUser2_ID(), get_TrxName());	}

	/** Set User List 2.
		@param User2_ID 
		User defined list element #2
	  */
	public void setUser2_ID (int User2_ID)
	{
		if (User2_ID < 1) 
			set_Value (COLUMNNAME_User2_ID, null);
		else 
			set_Value (COLUMNNAME_User2_ID, Integer.valueOf(User2_ID));
	}

	/** Get User List 2.
		@return User defined list element #2
	  */
	public int getUser2_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User2_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_ElementValue getUser3() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_ElementValue)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_ElementValue.Table_Name)
			.getPO(getUser3_ID(), get_TrxName());	}

	/** Set User List 3.
		@param User3_ID 
		User defined list element #3
	  */
	public void setUser3_ID (int User3_ID)
	{
		if (User3_ID < 1) 
			set_Value (COLUMNNAME_User3_ID, null);
		else 
			set_Value (COLUMNNAME_User3_ID, Integer.valueOf(User3_ID));
	}

	/** Get User List 3.
		@return User defined list element #3
	  */
	public int getUser3_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User3_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_C_ElementValue getUser4() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_C_ElementValue)MTable.get(getCtx(), org.adempiere.core.domains.models.I_C_ElementValue.Table_Name)
			.getPO(getUser4_ID(), get_TrxName());	}

	/** Set User List 4.
		@param User4_ID 
		User defined list element #4
	  */
	public void setUser4_ID (int User4_ID)
	{
		if (User4_ID < 1) 
			set_Value (COLUMNNAME_User4_ID, null);
		else 
			set_Value (COLUMNNAME_User4_ID, Integer.valueOf(User4_ID));
	}

	/** Get User List 4.
		@return User defined list element #4
	  */
	public int getUser4_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_User4_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Withholding Amount.
		@param WithholdingAmt Withholding Amount	  */
	public void setWithholdingAmt (BigDecimal WithholdingAmt)
	{
		set_Value (COLUMNNAME_WithholdingAmt, WithholdingAmt);
	}

	/** Get Withholding Amount.
		@return Withholding Amount	  */
	public BigDecimal getWithholdingAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_WithholdingAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Z_SHW_AMOUNT_HAC.
		@param Z_SHW_AMOUNT_HAC Z_SHW_AMOUNT_HAC	  */
	public void setZ_SHW_AMOUNT_HAC (BigDecimal Z_SHW_AMOUNT_HAC)
	{
		set_Value (COLUMNNAME_Z_SHW_AMOUNT_HAC, Z_SHW_AMOUNT_HAC);
	}

	/** Get Z_SHW_AMOUNT_HAC.
		@return Z_SHW_AMOUNT_HAC	  */
	public BigDecimal getZ_SHW_AMOUNT_HAC () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Z_SHW_AMOUNT_HAC);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Z_SHW_AMOUNTIVA.
		@param Z_SHW_AMOUNTIVA Z_SHW_AMOUNTIVA	  */
	public void setZ_SHW_AMOUNTIVA (BigDecimal Z_SHW_AMOUNTIVA)
	{
		set_Value (COLUMNNAME_Z_SHW_AMOUNTIVA, Z_SHW_AMOUNTIVA);
	}

	/** Get Z_SHW_AMOUNTIVA.
		@return Z_SHW_AMOUNTIVA	  */
	public BigDecimal getZ_SHW_AMOUNTIVA () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Z_SHW_AMOUNTIVA);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Z_SHW_InvoiceType AD_Reference_ID=1000033 */
	public static final int Z_SHW_INVOICETYPE_AD_Reference_ID=1000033;
	/** Venta con crédito fiscal = VCRE */
	public static final String Z_SHW_INVOICETYPE_VentaConCréditoFiscal = "VCRE";
	/** c = DAI */
	public static final String Z_SHW_INVOICETYPE_C = "DAI";
	/** Factura de Costos Adicionales de Importaciones = FCI */
	public static final String Z_SHW_INVOICETYPE_FacturaDeCostosAdicionalesDeImportaciones = "FCI";
	/** Factura de Cargos Adicionales = FCN */
	public static final String Z_SHW_INVOICETYPE_FacturaDeCargosAdicionales = "FCN";
	/** Factura de Cargos = FCO */
	public static final String Z_SHW_INVOICETYPE_FacturaDeCargos = "FCO";
	/** Factura de mercaderia (importacion) = FMI */
	public static final String Z_SHW_INVOICETYPE_FacturaDeMercaderiaImportacion = "FMI";
	/** Factura de mercaderia (nacional) = FMN */
	public static final String Z_SHW_INVOICETYPE_FacturaDeMercaderiaNacional = "FMN";
	/** Nota de Abono para clientes nacionales = NABO */
	public static final String Z_SHW_INVOICETYPE_NotaDeAbonoParaClientesNacionales = "NABO";
	/** Nota de Credito para contribuyentes = NCRE */
	public static final String Z_SHW_INVOICETYPE_NotaDeCreditoParaContribuyentes = "NCRE";
	/** Exportacion = VEXP */
	public static final String Z_SHW_INVOICETYPE_Exportacion = "VEXP";
	/** Venta al consumidot final = VFAC */
	public static final String Z_SHW_INVOICETYPE_VentaAlConsumidotFinal = "VFAC";
	/** Set Z_SHW_InvoiceType.
		@param Z_SHW_InvoiceType Z_SHW_InvoiceType	  */
	public void setZ_SHW_InvoiceType (String Z_SHW_InvoiceType)
	{

		set_Value (COLUMNNAME_Z_SHW_InvoiceType, Z_SHW_InvoiceType);
	}

	/** Get Z_SHW_InvoiceType.
		@return Z_SHW_InvoiceType	  */
	public String getZ_SHW_InvoiceType () 
	{
		return (String)get_Value(COLUMNNAME_Z_SHW_InvoiceType);
	}

	/** Set Z_SHW_NoCorr.
		@param Z_SHW_NoCorr Z_SHW_NoCorr	  */
	public void setZ_SHW_NoCorr (int Z_SHW_NoCorr)
	{
		set_Value (COLUMNNAME_Z_SHW_NoCorr, Integer.valueOf(Z_SHW_NoCorr));
	}

	/** Get Z_SHW_NoCorr.
		@return Z_SHW_NoCorr	  */
	public int getZ_SHW_NoCorr () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_SHW_NoCorr);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}