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

package org.shw.einvoice.es.feccfcreditofiscalv3;


import java.math.BigDecimal;
import java.util.List;

import org.adempiere.core.domains.models.X_E_InvoiceElectronic;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceTax;
import org.compiere.model.MOrgInfo;
import org.compiere.model.Query;
import org.shw.einvoice.es.anulacionv2.Anulacion;
import org.shw.einvoice.es.factory.AnulacionFactory;
import org.shw.einvoice.es.factory.CreditoFiscalFactory;
import org.shw.einvoice.es.factory.FacturaSujetoExcluidoFactory;
import org.shw.einvoice.es.factory.NotaDeCreditoFactory;
import org.shw.einvoice.es.factory.RetencionFactory;
import org.shw.einvoice.es.fencnotadecreditov1.IdentificacionNotaDeCredito;
import org.shw.einvoice.es.util.pojo.EDocumentFactory;
import org.shw.model.MLCOInvoiceWithholding;

/** Generated Process for (SHW_Create_ElectronicInvoice)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_CreateInvoice_CCFF_SV extends EI_CreateInvoice_CCFF_SVAbstract
{
	static final String VALIDATION_RESULT_OK = "OK";

	String 				numeroControl;
	String 				codigoGeneracion;
	MClient				client = null;
	MOrgInfo 			orgInfo = null;
	List<MInvoiceTax> invoiceTaxes = null;
	BigDecimal zero = new BigDecimal(0.00);
	StringBuffer error = new StringBuffer();
	String absDirectory = "";
		// TODO Auto-generated method stub
	
	
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{	
		System.out.println("Process EI_CreateInvoice_CCFF_SV : started");
		MClient	 client = null;
		MOrgInfo orgInfo = null;
		
		MInvoice invoice = new MInvoice(getCtx(), getInvoiceId(), get_TrxName());
		System.out.println("Process EI_CreateInvoice_CCFF_SV : Started with Invoice " + invoice.getDocumentNo());
		Boolean iscorrectDocType = 
				invoice.getC_DocType().getE_DocType_ID()>0 ;													//TODO; package problem loesen
		if (!iscorrectDocType) {
			String errorMessage = "El documento" + invoice.getDocumentNo() + " no es un Credito Fiscal o Nota de Credito. Aquí se interrumpe el proceso";
			System.out.println(errorMessage);
			System.out.println("Process EI_CreateInvoice_CCFF_SV : finished with errors");
			return errorMessage;
		} else  {
			System.out.println("Process EI_CreateInvoice_CCFF_SV : produced no errors");			
		}
		System.out.println("Process EI_CreateInvoice_CCFF_SV : Started with Invoice " + invoice.getDocumentNo());
		Boolean isreversal = ((invoice.getDocStatus().equals("VO")) || invoice.getDocStatus().equals("RE"))
				&& invoice.getReversal_ID() > 0
				&& invoice.getReversal_ID() < invoice.getC_Invoice_ID();
				
		Boolean isOriginal = ((invoice.getDocStatus().equals("CO") || 
				invoice.getReversal_ID() > invoice.getC_Invoice_ID())) ;
		List<MLCOInvoiceWithholding> invoiceWithholdings = new Query(getCtx(), MLCOInvoiceWithholding.Table_Name, 
				" C_Invoice_ID=?", get_TrxName())
				.setParameters(getInvoiceId())
				.list();
		Boolean existsWithholding = false;
		//existsRetencion = !invoiceWithholdings.isEmpty();		
		
		client = new MClient(getCtx(), invoice.getAD_Client_ID(), get_TrxName());
		int orgID = invoice.getAD_Org_ID();		
		orgInfo= MOrgInfo.get(getCtx(), orgID, get_TrxName());
		EDocumentFactory documentBuilder = null;
		if (invoice.getC_DocType().getC_DocBaseType_ID() == 50005 && isOriginal) {
			documentBuilder = new CreditoFiscalFactory(get_TrxName(), getCtx(), client, orgInfo, invoice);
			documentBuilder.generateJSONInputData(); // Will contain data passed to factory
			documentBuilder.generateEDocument();			
		} else if (invoice.getC_DocType().getC_DocBaseType_ID() == 50006 && invoice.getDocStatus().equals("CO")) {
			documentBuilder = new NotaDeCreditoFactory(get_TrxName(), getCtx(), client, orgInfo, invoice);
			documentBuilder.generateJSONInputData(); // Will contain data passed to factory
			documentBuilder.generateEDocument();			
		}
		else if (invoice.getC_DocType().getE_DocType().getValue().equals("14") && invoice.getDocStatus().equals("CO")) {
			documentBuilder = new FacturaSujetoExcluidoFactory(get_TrxName(), getCtx(), client, orgInfo, invoice);
			documentBuilder.generateJSONInputData(); // Will contain data passed to factory
			documentBuilder.generateEDocument();
		}
		else if (isreversal) {
			documentBuilder = new AnulacionFactory(get_TrxName(), getCtx(), client, orgInfo, invoice);
			documentBuilder.generateJSONInputData(); // Will contain data passed to factory
			documentBuilder.generateEDocument();			
		}
		else if (existsWithholding) {
			documentBuilder = new RetencionFactory(get_TrxName(), getCtx(), client, orgInfo, invoice);
			documentBuilder.generateJSONInputData(); // Will contain data passed to factory
			documentBuilder.generateEDocument();			
		}
		
    	X_E_InvoiceElectronic invoiceElectronic = new X_E_InvoiceElectronic(getCtx(), 0, get_TrxName());
    	invoiceElectronic.setC_Invoice_ID(invoice.getC_Invoice_ID());
    	invoiceElectronic.setei_ValidationStatus("01");
    	if (documentBuilder.getEDocumentErrorMessages().length() > 0) {
    		invoiceElectronic.seterrMsgIntern(documentBuilder.getEDocumentErrorMessages().toString());
    		invoiceElectronic.setei_ValidationStatus("02");
        	invoiceElectronic.saveEx();
			System.out.println("Process EI_CreateInvoice_CCFF_SV : produced the following errors:");
			System.out.println(documentBuilder.getEDocumentErrorMessages().toString());
			System.out.println("Process EI_CreateInvoice_CCFF_SV : finished");
    		return documentBuilder.getEDocumentErrorMessages().toString();
    	}	
    	
    	String creditoFiscalAsJsonString = documentBuilder.createJsonString();
       	invoiceElectronic.setjson(creditoFiscalAsJsonString);
    	invoiceElectronic.saveEx();
    	
    	if (isSaveInHistoric()) {
    		if (!documentBuilder.writeToFile(creditoFiscalAsJsonString, invoice, CreditoFiscal.ABSDIRECTORY)) {
    			invoiceElectronic.seterrMsgIntern("Root File From MSystConfig EI_PATH does not exist");
    		}
    	}
		
    	System.out.println("Credito Fiscal generado: " + invoice.getDocumentNo() + "Estado: " + invoiceElectronic.getei_ValidationStatus());
		System.out.println("Process EI_CreateInvoice_CCFF_SV : finished");
		return "";
	}

	

}