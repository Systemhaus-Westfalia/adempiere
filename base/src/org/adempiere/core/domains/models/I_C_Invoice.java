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
package org.adempiere.core.domains.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.compiere.model.MTable;
import org.compiere.util.KeyNamePair;

/** Generated Interface for C_Invoice
 *  @author Adempiere (generated) 
 *  @version Release 3.9.4
 */
public interface I_C_Invoice 
{

    /** TableName=C_Invoice */
    public static final String Table_Name = "C_Invoice";

    /** AD_Table_ID=318 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

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

    /** Column name AD_OrgTrx_ID */
    public static final String COLUMNNAME_AD_OrgTrx_ID = "AD_OrgTrx_ID";

	/** Set Trx Organization.
	  * Performing or initiating organization
	  */
	public void setAD_OrgTrx_ID (int AD_OrgTrx_ID);

	/** Get Trx Organization.
	  * Performing or initiating organization
	  */
	public int getAD_OrgTrx_ID();

    /** Column name AD_User_ID */
    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";

	/** Set User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID);

	/** Get User/Contact.
	  * User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID();

	public org.adempiere.core.domains.models.I_AD_User getAD_User() throws RuntimeException;

    /** Column name BackupValue */
    public static final String COLUMNNAME_BackupValue = "BackupValue";

	/** Set Backup Value.
	  * The value of the column prior to migration.
	  */
	public void setBackupValue (String BackupValue);

	/** Get Backup Value.
	  * The value of the column prior to migration.
	  */
	public String getBackupValue();

    /** Column name Bill_BPartner_ID */
    public static final String COLUMNNAME_Bill_BPartner_ID = "Bill_BPartner_ID";

	/** Set Invoice Partner.
	  * Business Partner to be invoiced
	  */
	public void setBill_BPartner_ID (int Bill_BPartner_ID);

	/** Get Invoice Partner.
	  * Business Partner to be invoiced
	  */
	public int getBill_BPartner_ID();

	public org.adempiere.core.domains.models.I_C_BPartner getBill_BPartner() throws RuntimeException;

    /** Column name BillTo_ID */
    public static final String COLUMNNAME_BillTo_ID = "BillTo_ID";

	/** Set Invoice To.
	  * Bill to Address
	  */
	public void setBillTo_ID (int BillTo_ID);

	/** Get Invoice To.
	  * Bill to Address
	  */
	public int getBillTo_ID();

	public org.adempiere.core.domains.models.I_C_BPartner_Location getBillTo() throws RuntimeException;

    /** Column name BOMDrop */
    public static final String COLUMNNAME_BOMDrop = "BOMDrop";

	/** Set BOM Drop.
	  * Drop (expand) Bill of Materials into an Order, Invoice, etc.
	  */
	public void setBOMDrop (String BOMDrop);

	/** Get BOM Drop.
	  * Drop (expand) Bill of Materials into an Order, Invoice, etc.
	  */
	public String getBOMDrop();

    /** Column name broker_ID */
    public static final String COLUMNNAME_broker_ID = "broker_ID";

	/** Set broker_ID	  */
	public void setbroker_ID (int broker_ID);

	/** Get broker_ID	  */
	public int getbroker_ID();

	public org.adempiere.core.domains.models.I_C_BPartner getbroker() throws RuntimeException;

    /** Column name C_Activity_ID */
    public static final String COLUMNNAME_C_Activity_ID = "C_Activity_ID";

	/** Set Activity.
	  * Business Activity
	  */
	public void setC_Activity_ID (int C_Activity_ID);

	/** Get Activity.
	  * Business Activity
	  */
	public int getC_Activity_ID();

	public org.adempiere.core.domains.models.I_C_Activity getC_Activity() throws RuntimeException;

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.adempiere.core.domains.models.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_BPartner_Location_ID */
    public static final String COLUMNNAME_C_BPartner_Location_ID = "C_BPartner_Location_ID";

	/** Set Partner Location.
	  * Identifies the (ship to) address for this Business Partner
	  */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID);

	/** Get Partner Location.
	  * Identifies the (ship to) address for this Business Partner
	  */
	public int getC_BPartner_Location_ID();

	public org.adempiere.core.domains.models.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException;

    /** Column name c_BPartnerimport_ID */
    public static final String COLUMNNAME_c_BPartnerimport_ID = "c_BPartnerimport_ID";

	/** Set c_BPartnerimport_ID	  */
	public void setc_BPartnerimport_ID (int c_BPartnerimport_ID);

	/** Get c_BPartnerimport_ID	  */
	public int getc_BPartnerimport_ID();

	public org.adempiere.core.domains.models.I_C_BPartner getc_BPartnerimport() throws RuntimeException;

    /** Column name C_Campaign_ID */
    public static final String COLUMNNAME_C_Campaign_ID = "C_Campaign_ID";

	/** Set Campaign.
	  * Marketing Campaign
	  */
	public void setC_Campaign_ID (int C_Campaign_ID);

	/** Get Campaign.
	  * Marketing Campaign
	  */
	public int getC_Campaign_ID();

	public org.adempiere.core.domains.models.I_C_Campaign getC_Campaign() throws RuntimeException;

    /** Column name C_CashLine_ID */
    public static final String COLUMNNAME_C_CashLine_ID = "C_CashLine_ID";

	/** Set Cash Journal Line.
	  * Cash Journal Line
	  */
	public void setC_CashLine_ID (int C_CashLine_ID);

	/** Get Cash Journal Line.
	  * Cash Journal Line
	  */
	public int getC_CashLine_ID();

	public org.adempiere.core.domains.models.I_C_CashLine getC_CashLine() throws RuntimeException;

    /** Column name C_Charge_ID */
    public static final String COLUMNNAME_C_Charge_ID = "C_Charge_ID";

	/** Set Charge.
	  * Additional document charges
	  */
	public void setC_Charge_ID (int C_Charge_ID);

	/** Get Charge.
	  * Additional document charges
	  */
	public int getC_Charge_ID();

	public org.adempiere.core.domains.models.I_C_Charge getC_Charge() throws RuntimeException;

    /** Column name C_CommissionRun_ID */
    public static final String COLUMNNAME_C_CommissionRun_ID = "C_CommissionRun_ID";

	/** Set Commission Run.
	  * Commission Run or Process
	  */
	public void setC_CommissionRun_ID (int C_CommissionRun_ID);

	/** Get Commission Run.
	  * Commission Run or Process
	  */
	public int getC_CommissionRun_ID();

	public org.adempiere.core.domains.models.I_C_CommissionRun getC_CommissionRun() throws RuntimeException;

    /** Column name C_ConversionType_ID */
    public static final String COLUMNNAME_C_ConversionType_ID = "C_ConversionType_ID";

	/** Set Currency Type.
	  * Currency Conversion Rate Type
	  */
	public void setC_ConversionType_ID (int C_ConversionType_ID);

	/** Get Currency Type.
	  * Currency Conversion Rate Type
	  */
	public int getC_ConversionType_ID();

	public org.adempiere.core.domains.models.I_C_ConversionType getC_ConversionType() throws RuntimeException;

    /** Column name C_Currency_ID */
    public static final String COLUMNNAME_C_Currency_ID = "C_Currency_ID";

	/** Set Currency.
	  * The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID);

	/** Get Currency.
	  * The Currency for this record
	  */
	public int getC_Currency_ID();

	public org.adempiere.core.domains.models.I_C_Currency getC_Currency() throws RuntimeException;

    /** Column name C_DocType_ID */
    public static final String COLUMNNAME_C_DocType_ID = "C_DocType_ID";

	/** Set Document Type.
	  * Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID);

	/** Get Document Type.
	  * Document type or rules
	  */
	public int getC_DocType_ID();

	public org.adempiere.core.domains.models.I_C_DocType getC_DocType() throws RuntimeException;

    /** Column name C_DocTypeTarget_ID */
    public static final String COLUMNNAME_C_DocTypeTarget_ID = "C_DocTypeTarget_ID";

	/** Set Target Document Type.
	  * Target document type for conversing documents
	  */
	public void setC_DocTypeTarget_ID (int C_DocTypeTarget_ID);

	/** Get Target Document Type.
	  * Target document type for conversing documents
	  */
	public int getC_DocTypeTarget_ID();

	public org.adempiere.core.domains.models.I_C_DocType getC_DocTypeTarget() throws RuntimeException;

    /** Column name C_DunningLevel_ID */
    public static final String COLUMNNAME_C_DunningLevel_ID = "C_DunningLevel_ID";

	/** Set Dunning Level	  */
	public void setC_DunningLevel_ID (int C_DunningLevel_ID);

	/** Get Dunning Level	  */
	public int getC_DunningLevel_ID();

	public org.adempiere.core.domains.models.I_C_DunningLevel getC_DunningLevel() throws RuntimeException;

    /** Column name C_Invoice_ID */
    public static final String COLUMNNAME_C_Invoice_ID = "C_Invoice_ID";

	/** Set Invoice.
	  * Invoice Identifier
	  */
	public void setC_Invoice_ID (int C_Invoice_ID);

	/** Get Invoice.
	  * Invoice Identifier
	  */
	public int getC_Invoice_ID();

    /** Column name C_Order_ID */
    public static final String COLUMNNAME_C_Order_ID = "C_Order_ID";

	/** Set Order.
	  * Order
	  */
	public void setC_Order_ID (int C_Order_ID);

	/** Get Order.
	  * Order
	  */
	public int getC_Order_ID();

	public org.adempiere.core.domains.models.I_C_Order getC_Order() throws RuntimeException;

    /** Column name C_Payment_ID */
    public static final String COLUMNNAME_C_Payment_ID = "C_Payment_ID";

	/** Set Payment.
	  * Payment identifier
	  */
	public void setC_Payment_ID (int C_Payment_ID);

	/** Get Payment.
	  * Payment identifier
	  */
	public int getC_Payment_ID();

	public org.adempiere.core.domains.models.I_C_Payment getC_Payment() throws RuntimeException;

    /** Column name C_PaymentTerm_ID */
    public static final String COLUMNNAME_C_PaymentTerm_ID = "C_PaymentTerm_ID";

	/** Set Payment Term.
	  * The terms of Payment (timing, discount)
	  */
	public void setC_PaymentTerm_ID (int C_PaymentTerm_ID);

	/** Get Payment Term.
	  * The terms of Payment (timing, discount)
	  */
	public int getC_PaymentTerm_ID();

	public org.adempiere.core.domains.models.I_C_PaymentTerm getC_PaymentTerm() throws RuntimeException;

    /** Column name C_Period_ID */
    public static final String COLUMNNAME_C_Period_ID = "C_Period_ID";

	/** Set Period.
	  * Period of the Calendar
	  */
	public void setC_Period_ID (int C_Period_ID);

	/** Get Period.
	  * Period of the Calendar
	  */
	public int getC_Period_ID();

	public org.adempiere.core.domains.models.I_C_Period getC_Period() throws RuntimeException;

    /** Column name C_POS_ID */
    public static final String COLUMNNAME_C_POS_ID = "C_POS_ID";

	/** Set POS Terminal.
	  * Point of Sales Terminal
	  */
	public void setC_POS_ID (int C_POS_ID);

	/** Get POS Terminal.
	  * Point of Sales Terminal
	  */
	public int getC_POS_ID();

	public org.adempiere.core.domains.models.I_C_POS getC_POS() throws RuntimeException;

    /** Column name C_Project_ID */
    public static final String COLUMNNAME_C_Project_ID = "C_Project_ID";

	/** Set Project.
	  * Financial Project
	  */
	public void setC_Project_ID (int C_Project_ID);

	/** Get Project.
	  * Financial Project
	  */
	public int getC_Project_ID();

	public org.adempiere.core.domains.models.I_C_Project getC_Project() throws RuntimeException;

    /** Column name C_SalesRegion_ID */
    public static final String COLUMNNAME_C_SalesRegion_ID = "C_SalesRegion_ID";

	/** Set Sales Region.
	  * Sales coverage region
	  */
	public void setC_SalesRegion_ID (int C_SalesRegion_ID);

	/** Get Sales Region.
	  * Sales coverage region
	  */
	public int getC_SalesRegion_ID();

	public org.adempiere.core.domains.models.I_C_SalesRegion getC_SalesRegion() throws RuntimeException;

    /** Column name cashcollector */
    public static final String COLUMNNAME_cashcollector = "cashcollector";

	/** Set cashcollector	  */
	public void setcashcollector (int cashcollector);

	/** Get cashcollector	  */
	public int getcashcollector();

	public org.adempiere.core.domains.models.I_AD_User getcashcollec() throws RuntimeException;

    /** Column name ChargeAmt */
    public static final String COLUMNNAME_ChargeAmt = "ChargeAmt";

	/** Set Charge amount.
	  * Charge Amount
	  */
	public void setChargeAmt (BigDecimal ChargeAmt);

	/** Get Charge amount.
	  * Charge Amount
	  */
	public BigDecimal getChargeAmt();

    /** Column name CodigoDeDeclaracion */
    public static final String COLUMNNAME_CodigoDeDeclaracion = "CodigoDeDeclaracion";

	/** Set Código registro DM.
	  * Código registro de la declaración de mercancías en el sistema de Aduanas
	  */
	public void setCodigoDeDeclaracion (String CodigoDeDeclaracion);

	/** Get Código registro DM.
	  * Código registro de la declaración de mercancías en el sistema de Aduanas
	  */
	public String getCodigoDeDeclaracion();

    /** Column name Comments */
    public static final String COLUMNNAME_Comments = "Comments";

	/** Set Comments.
	  * Comments or additional information
	  */
	public void setComments (String Comments);

	/** Get Comments.
	  * Comments or additional information
	  */
	public String getComments();

    /** Column name Concepto */
    public static final String COLUMNNAME_Concepto = "Concepto";

	/** Set Concepto	  */
	public void setConcepto (String Concepto);

	/** Get Concepto	  */
	public String getConcepto();

    /** Column name CopyFrom */
    public static final String COLUMNNAME_CopyFrom = "CopyFrom";

	/** Set Copy From.
	  * Copy From Record
	  */
	public void setCopyFrom (String CopyFrom);

	/** Get Copy From.
	  * Copy From Record
	  */
	public String getCopyFrom();

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

    /** Column name CreateFrom */
    public static final String COLUMNNAME_CreateFrom = "CreateFrom";

	/** Set Create lines from.
	  * Process which will generate a new document lines based on an existing document
	  */
	public void setCreateFrom (String CreateFrom);

	/** Get Create lines from.
	  * Process which will generate a new document lines based on an existing document
	  */
	public String getCreateFrom();

    /** Column name DateAcct */
    public static final String COLUMNNAME_DateAcct = "DateAcct";

	/** Set Account Date.
	  * Accounting Date
	  */
	public void setDateAcct (Timestamp DateAcct);

	/** Get Account Date.
	  * Accounting Date
	  */
	public Timestamp getDateAcct();

    /** Column name DateInvoiced */
    public static final String COLUMNNAME_DateInvoiced = "DateInvoiced";

	/** Set Date Invoiced.
	  * Date printed on Invoice
	  */
	public void setDateInvoiced (Timestamp DateInvoiced);

	/** Get Date Invoiced.
	  * Date printed on Invoice
	  */
	public Timestamp getDateInvoiced();

    /** Column name DateOrdered */
    public static final String COLUMNNAME_DateOrdered = "DateOrdered";

	/** Set Date Ordered.
	  * Date of Order
	  */
	public void setDateOrdered (Timestamp DateOrdered);

	/** Get Date Ordered.
	  * Date of Order
	  */
	public Timestamp getDateOrdered();

    /** Column name DatePrinted */
    public static final String COLUMNNAME_DatePrinted = "DatePrinted";

	/** Set Date printed.
	  * Date the document was printed.
	  */
	public void setDatePrinted (Timestamp DatePrinted);

	/** Get Date printed.
	  * Date the document was printed.
	  */
	public Timestamp getDatePrinted();

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

    /** Column name descriptionCancel */
    public static final String COLUMNNAME_descriptionCancel = "descriptionCancel";

	/** Set descriptionCancel	  */
	public void setdescriptionCancel (String descriptionCancel);

	/** Get descriptionCancel	  */
	public String getdescriptionCancel();

    /** Column name DifBPPaytmentTo */
    public static final String COLUMNNAME_DifBPPaytmentTo = "DifBPPaytmentTo";

	/** Set DifBPPaytmentTo.
	  * Paytment/Reimbursement To business partner
	  */
	public void setDifBPPaytmentTo (int DifBPPaytmentTo);

	/** Get DifBPPaytmentTo.
	  * Paytment/Reimbursement To business partner
	  */
	public int getDifBPPaytmentTo();

	public org.adempiere.core.domains.models.I_C_BPartner getDifBPPaytmen() throws RuntimeException;

    /** Column name DocAction */
    public static final String COLUMNNAME_DocAction = "DocAction";

	/** Set Document Action.
	  * The targeted status of the document
	  */
	public void setDocAction (String DocAction);

	/** Get Document Action.
	  * The targeted status of the document
	  */
	public String getDocAction();

    /** Column name DocStatus */
    public static final String COLUMNNAME_DocStatus = "DocStatus";

	/** Set Document Status.
	  * The current status of the document
	  */
	public void setDocStatus (String DocStatus);

	/** Get Document Status.
	  * The current status of the document
	  */
	public String getDocStatus();

    /** Column name DocumentNo */
    public static final String COLUMNNAME_DocumentNo = "DocumentNo";

	/** Set Document No.
	  * Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo);

	/** Get Document No.
	  * Document sequence number of the document
	  */
	public String getDocumentNo();

    /** Column name DocumentoDeTransporte */
    public static final String COLUMNNAME_DocumentoDeTransporte = "DocumentoDeTransporte";

	/** Set Documento transporte.
	  * Número de documento de transporte (AWB, BL, carta porte, etc.)
	  */
	public void setDocumentoDeTransporte (String DocumentoDeTransporte);

	/** Get Documento transporte.
	  * Número de documento de transporte (AWB, BL, carta porte, etc.)
	  */
	public String getDocumentoDeTransporte();

    /** Column name DunningGrace */
    public static final String COLUMNNAME_DunningGrace = "DunningGrace";

	/** Set Dunning Grace Date	  */
	public void setDunningGrace (Timestamp DunningGrace);

	/** Get Dunning Grace Date	  */
	public Timestamp getDunningGrace();

    /** Column name ei_codigoGeneracion */
    public static final String COLUMNNAME_ei_codigoGeneracion = "ei_codigoGeneracion";

	/** Set ei_codigoGeneracion	  */
	public void setei_codigoGeneracion (String ei_codigoGeneracion);

	/** Get ei_codigoGeneracion	  */
	public String getei_codigoGeneracion();

    /** Column name ei_numeroControl */
    public static final String COLUMNNAME_ei_numeroControl = "ei_numeroControl";

	/** Set numeroControl	  */
	public void setei_numeroControl (String ei_numeroControl);

	/** Get numeroControl	  */
	public String getei_numeroControl();

    /** Column name ei_selloRecibido */
    public static final String COLUMNNAME_ei_selloRecibido = "ei_selloRecibido";

	/** Set selloRecibido	  */
	public void setei_selloRecibido (String ei_selloRecibido);

	/** Get selloRecibido	  */
	public String getei_selloRecibido();

    /** Column name ei_ValidationStatus */
    public static final String COLUMNNAME_ei_ValidationStatus = "ei_ValidationStatus";

	/** Set EI Validation Status (Intern).
	  * EI Validation Status
	  */
	public void setei_ValidationStatus (String ei_ValidationStatus);

	/** Get EI Validation Status (Intern).
	  * EI Validation Status
	  */
	public String getei_ValidationStatus();

    /** Column name FM_Account_ID */
    public static final String COLUMNNAME_FM_Account_ID = "FM_Account_ID";

	/** Set Financial Account	  */
	public void setFM_Account_ID (int FM_Account_ID);

	/** Get Financial Account	  */
	public int getFM_Account_ID();

    /** Column name FM_Agreement_ID */
    public static final String COLUMNNAME_FM_Agreement_ID = "FM_Agreement_ID";

	/** Set Agreement	  */
	public void setFM_Agreement_ID (int FM_Agreement_ID);

	/** Get Agreement	  */
	public int getFM_Agreement_ID();

    /** Column name GenerateTo */
    public static final String COLUMNNAME_GenerateTo = "GenerateTo";

	/** Set Generate To.
	  * Generate To
	  */
	public void setGenerateTo (String GenerateTo);

	/** Get Generate To.
	  * Generate To
	  */
	public String getGenerateTo();

    /** Column name GenerateWithholding */
    public static final String COLUMNNAME_GenerateWithholding = "GenerateWithholding";

	/** Set Generate Withholding	  */
	public void setGenerateWithholding (String GenerateWithholding);

	/** Get Generate Withholding	  */
	public String getGenerateWithholding();

    /** Column name GrandTotal */
    public static final String COLUMNNAME_GrandTotal = "GrandTotal";

	/** Set Grand Total.
	  * Total amount of document
	  */
	public void setGrandTotal (BigDecimal GrandTotal);

	/** Get Grand Total.
	  * Total amount of document
	  */
	public BigDecimal getGrandTotal();

    /** Column name Incoterms */
    public static final String COLUMNNAME_Incoterms = "Incoterms";

	/** Set Incoterm.
	  * Término de compra del pedido
	  */
	public void setIncoterms (String Incoterms);

	/** Get Incoterm.
	  * Término de compra del pedido
	  */
	public String getIncoterms();

    /** Column name invoiceclass */
    public static final String COLUMNNAME_invoiceclass = "invoiceclass";

	/** Set invoiceclass	  */
	public void setinvoiceclass (String invoiceclass);

	/** Get invoiceclass	  */
	public String getinvoiceclass();

    /** Column name InvoiceCollectionType */
    public static final String COLUMNNAME_InvoiceCollectionType = "InvoiceCollectionType";

	/** Set Collection Status.
	  * Invoice Collection Status
	  */
	public void setInvoiceCollectionType (String InvoiceCollectionType);

	/** Get Collection Status.
	  * Invoice Collection Status
	  */
	public String getInvoiceCollectionType();

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

    /** Column name IsApproved */
    public static final String COLUMNNAME_IsApproved = "IsApproved";

	/** Set Approved.
	  * Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved);

	/** Get Approved.
	  * Indicates if this document requires approval
	  */
	public boolean isApproved();

    /** Column name isContract */
    public static final String COLUMNNAME_isContract = "isContract";

	/** Set isContract	  */
	public void setisContract (boolean isContract);

	/** Get isContract	  */
	public boolean isContract();

    /** Column name IsDiscountPrinted */
    public static final String COLUMNNAME_IsDiscountPrinted = "IsDiscountPrinted";

	/** Set Discount Printed.
	  * Print Discount on Invoice and Order
	  */
	public void setIsDiscountPrinted (boolean IsDiscountPrinted);

	/** Get Discount Printed.
	  * Print Discount on Invoice and Order
	  */
	public boolean isDiscountPrinted();

    /** Column name IsFixedAssetInvoice */
    public static final String COLUMNNAME_IsFixedAssetInvoice = "IsFixedAssetInvoice";

	/** Set Is Fixed Asset Invoice.
	  * Indicates if an Invoice is for a Fixed Asset
	  */
	public void setIsFixedAssetInvoice (boolean IsFixedAssetInvoice);

	/** Get Is Fixed Asset Invoice.
	  * Indicates if an Invoice is for a Fixed Asset
	  */
	public boolean isFixedAssetInvoice();

    /** Column name IsInDispute */
    public static final String COLUMNNAME_IsInDispute = "IsInDispute";

	/** Set In Dispute.
	  * Document is in dispute
	  */
	public void setIsInDispute (boolean IsInDispute);

	/** Get In Dispute.
	  * Document is in dispute
	  */
	public boolean isInDispute();

    /** Column name IsPaid */
    public static final String COLUMNNAME_IsPaid = "IsPaid";

	/** Set Paid.
	  * The document is paid
	  */
	public void setIsPaid (boolean IsPaid);

	/** Get Paid.
	  * The document is paid
	  */
	public boolean isPaid();

    /** Column name IsPayScheduleValid */
    public static final String COLUMNNAME_IsPayScheduleValid = "IsPayScheduleValid";

	/** Set Pay Schedule valid.
	  * Is the Payment Schedule is valid
	  */
	public void setIsPayScheduleValid (boolean IsPayScheduleValid);

	/** Get Pay Schedule valid.
	  * Is the Payment Schedule is valid
	  */
	public boolean isPayScheduleValid();

    /** Column name IsPrinted */
    public static final String COLUMNNAME_IsPrinted = "IsPrinted";

	/** Set Printed.
	  * Indicates if this document / line is printed
	  */
	public void setIsPrinted (boolean IsPrinted);

	/** Get Printed.
	  * Indicates if this document / line is printed
	  */
	public boolean isPrinted();

    /** Column name IsPublished */
    public static final String COLUMNNAME_IsPublished = "IsPublished";

	/** Set Published.
	  * The Topic is published and can be viewed
	  */
	public void setIsPublished (boolean IsPublished);

	/** Get Published.
	  * The Topic is published and can be viewed
	  */
	public boolean isPublished();

    /** Column name IsSelfService */
    public static final String COLUMNNAME_IsSelfService = "IsSelfService";

	/** Set Self-Service.
	  * This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public void setIsSelfService (boolean IsSelfService);

	/** Get Self-Service.
	  * This is a Self-Service entry or this entry can be changed via Self-Service
	  */
	public boolean isSelfService();

    /** Column name IsSOTrx */
    public static final String COLUMNNAME_IsSOTrx = "IsSOTrx";

	/** Set Sales Transaction.
	  * This is a Sales Transaction
	  */
	public void setIsSOTrx (boolean IsSOTrx);

	/** Get Sales Transaction.
	  * This is a Sales Transaction
	  */
	public boolean isSOTrx();

    /** Column name isSplitInvoice */
    public static final String COLUMNNAME_isSplitInvoice = "isSplitInvoice";

	/** Set isSplitInvoice	  */
	public void setisSplitInvoice (boolean isSplitInvoice);

	/** Get isSplitInvoice	  */
	public boolean isSplitInvoice();

    /** Column name IsTaxIncluded */
    public static final String COLUMNNAME_IsTaxIncluded = "IsTaxIncluded";

	/** Set Price includes Tax.
	  * Tax is included in the price 
	  */
	public void setIsTaxIncluded (boolean IsTaxIncluded);

	/** Get Price includes Tax.
	  * Tax is included in the price 
	  */
	public boolean isTaxIncluded();

    /** Column name IsTransferred */
    public static final String COLUMNNAME_IsTransferred = "IsTransferred";

	/** Set Transferred.
	  * Transferred to General Ledger (i.e. accounted)
	  */
	public void setIsTransferred (boolean IsTransferred);

	/** Get Transferred.
	  * Transferred to General Ledger (i.e. accounted)
	  */
	public boolean isTransferred();

    /** Column name LG_Route_ID */
    public static final String COLUMNNAME_LG_Route_ID = "LG_Route_ID";

	/** Set LG_Route ID	  */
	public void setLG_Route_ID (int LG_Route_ID);

	/** Get LG_Route ID	  */
	public int getLG_Route_ID();

    /** Column name M_PriceList_ID */
    public static final String COLUMNNAME_M_PriceList_ID = "M_PriceList_ID";

	/** Set Price List.
	  * Unique identifier of a Price List
	  */
	public void setM_PriceList_ID (int M_PriceList_ID);

	/** Get Price List.
	  * Unique identifier of a Price List
	  */
	public int getM_PriceList_ID();

	public org.adempiere.core.domains.models.I_M_PriceList getM_PriceList() throws RuntimeException;

    /** Column name M_Product_Classification_ID */
    public static final String COLUMNNAME_M_Product_Classification_ID = "M_Product_Classification_ID";

	/** Set Product Classification.
	  * Classification of a Product
	  */
	public void setM_Product_Classification_ID (int M_Product_Classification_ID);

	/** Get Product Classification.
	  * Classification of a Product
	  */
	public int getM_Product_Classification_ID();

	public org.adempiere.core.domains.models.I_M_Product_Classification getM_Product_Classification() throws RuntimeException;

    /** Column name M_RMA_ID */
    public static final String COLUMNNAME_M_RMA_ID = "M_RMA_ID";

	/** Set RMA.
	  * Return Material Authorization
	  */
	public void setM_RMA_ID (int M_RMA_ID);

	/** Get RMA.
	  * Return Material Authorization
	  */
	public int getM_RMA_ID();

	public org.adempiere.core.domains.models.I_M_RMA getM_RMA() throws RuntimeException;

    /** Column name oneProjectInvoice */
    public static final String COLUMNNAME_oneProjectInvoice = "oneProjectInvoice";

	/** Set oneProjectInvoice	  */
	public void setoneProjectInvoice (boolean oneProjectInvoice);

	/** Get oneProjectInvoice	  */
	public boolean isoneProjectInvoice();

    /** Column name PayDate */
    public static final String COLUMNNAME_PayDate = "PayDate";

	/** Set Payment date.
	  * Date Payment made
	  */
	public void setPayDate (Timestamp PayDate);

	/** Get Payment date.
	  * Date Payment made
	  */
	public Timestamp getPayDate();

    /** Column name PaymentRule */
    public static final String COLUMNNAME_PaymentRule = "PaymentRule";

	/** Set Payment Rule.
	  * How you pay the invoice
	  */
	public void setPaymentRule (String PaymentRule);

	/** Get Payment Rule.
	  * How you pay the invoice
	  */
	public String getPaymentRule();

    /** Column name POReference */
    public static final String COLUMNNAME_POReference = "POReference";

	/** Set Order Reference.
	  * Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public void setPOReference (String POReference);

	/** Get Order Reference.
	  * Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
	  */
	public String getPOReference();

    /** Column name Posted */
    public static final String COLUMNNAME_Posted = "Posted";

	/** Set Posted.
	  * Posting status
	  */
	public void setPosted (boolean Posted);

	/** Get Posted.
	  * Posting status
	  */
	public boolean isPosted();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name ProcessedOn */
    public static final String COLUMNNAME_ProcessedOn = "ProcessedOn";

	/** Set Processed On.
	  * The date+time (expressed in decimal format) when the document has been processed
	  */
	public void setProcessedOn (BigDecimal ProcessedOn);

	/** Get Processed On.
	  * The date+time (expressed in decimal format) when the document has been processed
	  */
	public BigDecimal getProcessedOn();

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name Provider */
    public static final String COLUMNNAME_Provider = "Provider";

	/** Set Provider	  */
	public void setProvider (String Provider);

	/** Get Provider	  */
	public String getProvider();

    /** Column name ProviderPO */
    public static final String COLUMNNAME_ProviderPO = "ProviderPO";

	/** Set Pedido.
	  * Número de la Orden de Compra o pedido del cliente hacia el proveedor
	  */
	public void setProviderPO (String ProviderPO);

	/** Get Pedido.
	  * Número de la Orden de Compra o pedido del cliente hacia el proveedor
	  */
	public String getProviderPO();

    /** Column name Ref_Invoice_ID */
    public static final String COLUMNNAME_Ref_Invoice_ID = "Ref_Invoice_ID";

	/** Set Referenced Invoice	  */
	public void setRef_Invoice_ID (int Ref_Invoice_ID);

	/** Get Referenced Invoice	  */
	public int getRef_Invoice_ID();

    /** Column name ReferenciaDeDeclaracion */
    public static final String COLUMNNAME_ReferenciaDeDeclaracion = "ReferenciaDeDeclaracion";

	/** Set Referencia DM.
	  * Referencia interna de la mercancía del agente de aduana
	  */
	public void setReferenciaDeDeclaracion (String ReferenciaDeDeclaracion);

	/** Get Referencia DM.
	  * Referencia interna de la mercancía del agente de aduana
	  */
	public String getReferenciaDeDeclaracion();

    /** Column name remitee_ID */
    public static final String COLUMNNAME_remitee_ID = "remitee_ID";

	/** Set remitee_ID	  */
	public void setremitee_ID (int remitee_ID);

	/** Get remitee_ID	  */
	public int getremitee_ID();

	public org.adempiere.core.domains.models.I_C_BPartner getremitee() throws RuntimeException;

    /** Column name Reversal_ID */
    public static final String COLUMNNAME_Reversal_ID = "Reversal_ID";

	/** Set Reversal ID.
	  * ID of document reversal
	  */
	public void setReversal_ID (int Reversal_ID);

	/** Get Reversal ID.
	  * ID of document reversal
	  */
	public int getReversal_ID();

	public org.adempiere.core.domains.models.I_C_Invoice getReversal() throws RuntimeException;

    /** Column name SalesRep_ID */
    public static final String COLUMNNAME_SalesRep_ID = "SalesRep_ID";

	/** Set Sales Representative.
	  * Sales Representative or Company Agent
	  */
	public void setSalesRep_ID (int SalesRep_ID);

	/** Get Sales Representative.
	  * Sales Representative or Company Agent
	  */
	public int getSalesRep_ID();

	public org.adempiere.core.domains.models.I_AD_User getSalesRep() throws RuntimeException;

    /** Column name SendEMail */
    public static final String COLUMNNAME_SendEMail = "SendEMail";

	/** Set Send EMail.
	  * Enable sending Document EMail
	  */
	public void setSendEMail (boolean SendEMail);

	/** Get Send EMail.
	  * Enable sending Document EMail
	  */
	public boolean isSendEMail();

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

    /** Column name SerNo */
    public static final String COLUMNNAME_SerNo = "SerNo";

	/** Set Serial No.
	  * Product Serial Number 
	  */
	public void setSerNo (String SerNo);

	/** Get Serial No.
	  * Product Serial Number 
	  */
	public String getSerNo();

    /** Column name shw_Amt */
    public static final String COLUMNNAME_shw_Amt = "shw_Amt";

	/** Set shw_Amt	  */
	public void setshw_Amt (BigDecimal shw_Amt);

	/** Get shw_Amt	  */
	public BigDecimal getshw_Amt();

    /** Column name SHW_ChangeDocumentNo */
    public static final String COLUMNNAME_SHW_ChangeDocumentNo = "SHW_ChangeDocumentNo";

	/** Set SHW_ChangeDocumentNo	  */
	public void setSHW_ChangeDocumentNo (String SHW_ChangeDocumentNo);

	/** Get SHW_ChangeDocumentNo	  */
	public String getSHW_ChangeDocumentNo();

    /** Column name shw_contract_ID */
    public static final String COLUMNNAME_shw_contract_ID = "shw_contract_ID";

	/** Set shw_contract_ID	  */
	public void setshw_contract_ID (int shw_contract_ID);

	/** Get shw_contract_ID	  */
	public int getshw_contract_ID();

	public org.adempiere.core.domains.models.I_C_Invoice getshw_contract() throws RuntimeException;

    /** Column name SHW_CreateQuedan */
    public static final String COLUMNNAME_SHW_CreateQuedan = "SHW_CreateQuedan";

	/** Set SHW_CreateQuedan	  */
	public void setSHW_CreateQuedan (String SHW_CreateQuedan);

	/** Get SHW_CreateQuedan	  */
	public String getSHW_CreateQuedan();

    /** Column name SHW_INV_Reactivate */
    public static final String COLUMNNAME_SHW_INV_Reactivate = "SHW_INV_Reactivate";

	/** Set SHW_INV_Reactivate	  */
	public void setSHW_INV_Reactivate (String SHW_INV_Reactivate);

	/** Get SHW_INV_Reactivate	  */
	public String getSHW_INV_Reactivate();

    /** Column name shw_PrintComprobanteReintegro */
    public static final String COLUMNNAME_shw_PrintComprobanteReintegro = "shw_PrintComprobanteReintegro";

	/** Set shw_PrintComprobanteReintegro	  */
	public void setshw_PrintComprobanteReintegro (String shw_PrintComprobanteReintegro);

	/** Get shw_PrintComprobanteReintegro	  */
	public String getshw_PrintComprobanteReintegro();

    /** Column name shw_reason_Cancelation */
    public static final String COLUMNNAME_shw_reason_Cancelation = "shw_reason_Cancelation";

	/** Set shw_reason_Cancelation	  */
	public void setshw_reason_Cancelation (String shw_reason_Cancelation);

	/** Get shw_reason_Cancelation	  */
	public String getshw_reason_Cancelation();

    /** Column name shw_retaceo_ID */
    public static final String COLUMNNAME_shw_retaceo_ID = "shw_retaceo_ID";

	/** Set shw_retaceo ID	  */
	public void setshw_retaceo_ID (int shw_retaceo_ID);

	/** Get shw_retaceo ID	  */
	public int getshw_retaceo_ID();

    /** Column name shw_tax */
    public static final String COLUMNNAME_shw_tax = "shw_tax";

	/** Set shw_tax	  */
	public void setshw_tax (BigDecimal shw_tax);

	/** Get shw_tax	  */
	public BigDecimal getshw_tax();

    /** Column name TaxAmt */
    public static final String COLUMNNAME_TaxAmt = "TaxAmt";

	/** Set Tax Amount.
	  * Tax Amount for a document
	  */
	public void setTaxAmt (BigDecimal TaxAmt);

	/** Get Tax Amount.
	  * Tax Amount for a document
	  */
	public BigDecimal getTaxAmt();

    /** Column name taxamtdeclared */
    public static final String COLUMNNAME_taxamtdeclared = "taxamtdeclared";

	/** Set taxamtdeclared	  */
	public void settaxamtdeclared (BigDecimal taxamtdeclared);

	/** Get taxamtdeclared	  */
	public BigDecimal gettaxamtdeclared();

    /** Column name TaxBaseAmt */
    public static final String COLUMNNAME_TaxBaseAmt = "TaxBaseAmt";

	/** Set Tax base Amount.
	  * Base for calculating the tax amount
	  */
	public void setTaxBaseAmt (BigDecimal TaxBaseAmt);

	/** Get Tax base Amount.
	  * Base for calculating the tax amount
	  */
	public BigDecimal getTaxBaseAmt();

    /** Column name taxbaseamtdeclared */
    public static final String COLUMNNAME_taxbaseamtdeclared = "taxbaseamtdeclared";

	/** Set taxbaseamtdeclared	  */
	public void settaxbaseamtdeclared (BigDecimal taxbaseamtdeclared);

	/** Get taxbaseamtdeclared	  */
	public BigDecimal gettaxbaseamtdeclared();

    /** Column name TotalLines */
    public static final String COLUMNNAME_TotalLines = "TotalLines";

	/** Set Total Lines.
	  * Total of all document lines
	  */
	public void setTotalLines (BigDecimal TotalLines);

	/** Get Total Lines.
	  * Total of all document lines
	  */
	public BigDecimal getTotalLines();

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

    /** Column name User1_ID */
    public static final String COLUMNNAME_User1_ID = "User1_ID";

	/** Set User List 1.
	  * User defined list element #1
	  */
	public void setUser1_ID (int User1_ID);

	/** Get User List 1.
	  * User defined list element #1
	  */
	public int getUser1_ID();

	public org.adempiere.core.domains.models.I_C_ElementValue getUser1() throws RuntimeException;

    /** Column name User2_ID */
    public static final String COLUMNNAME_User2_ID = "User2_ID";

	/** Set User List 2.
	  * User defined list element #2
	  */
	public void setUser2_ID (int User2_ID);

	/** Get User List 2.
	  * User defined list element #2
	  */
	public int getUser2_ID();

	public org.adempiere.core.domains.models.I_C_ElementValue getUser2() throws RuntimeException;

    /** Column name User3_ID */
    public static final String COLUMNNAME_User3_ID = "User3_ID";

	/** Set User List 3.
	  * User defined list element #3
	  */
	public void setUser3_ID (int User3_ID);

	/** Get User List 3.
	  * User defined list element #3
	  */
	public int getUser3_ID();

	public org.adempiere.core.domains.models.I_C_ElementValue getUser3() throws RuntimeException;

    /** Column name User4_ID */
    public static final String COLUMNNAME_User4_ID = "User4_ID";

	/** Set User List 4.
	  * User defined list element #4
	  */
	public void setUser4_ID (int User4_ID);

	/** Get User List 4.
	  * User defined list element #4
	  */
	public int getUser4_ID();

	public org.adempiere.core.domains.models.I_C_ElementValue getUser4() throws RuntimeException;

    /** Column name UUID */
    public static final String COLUMNNAME_UUID = "UUID";

	/** Set Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID);

	/** Get Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public String getUUID();

    /** Column name WithholdingAmt */
    public static final String COLUMNNAME_WithholdingAmt = "WithholdingAmt";

	/** Set Withholding Amount	  */
	public void setWithholdingAmt (BigDecimal WithholdingAmt);

	/** Get Withholding Amount	  */
	public BigDecimal getWithholdingAmt();

    /** Column name Z_SHW_AMOUNT_HAC */
    public static final String COLUMNNAME_Z_SHW_AMOUNT_HAC = "Z_SHW_AMOUNT_HAC";

	/** Set Z_SHW_AMOUNT_HAC	  */
	public void setZ_SHW_AMOUNT_HAC (BigDecimal Z_SHW_AMOUNT_HAC);

	/** Get Z_SHW_AMOUNT_HAC	  */
	public BigDecimal getZ_SHW_AMOUNT_HAC();

    /** Column name Z_SHW_AMOUNTIVA */
    public static final String COLUMNNAME_Z_SHW_AMOUNTIVA = "Z_SHW_AMOUNTIVA";

	/** Set Z_SHW_AMOUNTIVA	  */
	public void setZ_SHW_AMOUNTIVA (BigDecimal Z_SHW_AMOUNTIVA);

	/** Get Z_SHW_AMOUNTIVA	  */
	public BigDecimal getZ_SHW_AMOUNTIVA();

    /** Column name Z_SHW_InvoiceType */
    public static final String COLUMNNAME_Z_SHW_InvoiceType = "Z_SHW_InvoiceType";

	/** Set Z_SHW_InvoiceType	  */
	public void setZ_SHW_InvoiceType (String Z_SHW_InvoiceType);

	/** Get Z_SHW_InvoiceType	  */
	public String getZ_SHW_InvoiceType();

    /** Column name Z_SHW_NoCorr */
    public static final String COLUMNNAME_Z_SHW_NoCorr = "Z_SHW_NoCorr";

	/** Set Z_SHW_NoCorr	  */
	public void setZ_SHW_NoCorr (int Z_SHW_NoCorr);

	/** Get Z_SHW_NoCorr	  */
	public int getZ_SHW_NoCorr();
}
