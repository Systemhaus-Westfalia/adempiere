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

package org.shw.einvoice.es.fencnotadecreditov1;


import org.adempiere.core.domains.models.X_E_InvoiceElectronic;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrgInfo;
import org.shw.einvoice.es.factory.NotaDeCreditoFactory;

/** Generated Process for (SHW_Create_ElectronicInvoice)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_CreateInvoice_NotaCredito_SV extends EI_CreateInvoice_NotaCredito_SVAbstract
{
	
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{	
		System.out.println("Process EI_CreateInvoice_NotaCredito_SV : started");
		MClient	 client = null;
		MOrgInfo orgInfo = null;
		
		MInvoice invoice = new MInvoice(getCtx(), getInvoiceId(), get_TrxName());
		System.out.println("Process EI_CreateInvoice_NotaCredito_SV : Started with Invoice " + invoice.getDocumentNo());
		
		if (invoice.getC_DocType().getE_DocType_ID()<= 0 ||
				!invoice.getC_DocType().getE_DocType().getValue().equals(IdentificacionNotaDeCredito.TIPO_DE_DOCUMENTO)) {
			String errorMessage = "El documento" + invoice.getDocumentNo() + " no es una Nota de Credito. Aquí se interrumpe el proceso";
			System.out.println(errorMessage);
			System.out.println("Process EI_CreateInvoice_NotaCredito_SV : finished with errors");
			return errorMessage;
		} else  {
			System.out.println("Process EI_CreateInvoice_NotaCredito_SV : produced no errors");			
		}
		
		System.out.println("Process EI_CreateInvoice_NotaCredito_SV : Started with Invoice " + invoice.getDocumentNo());
		client = new MClient(getCtx(), invoice.getAD_Client_ID(), get_TrxName());
		int orgID = invoice.getAD_Org_ID();		
		orgInfo= MOrgInfo.get(getCtx(), orgID, get_TrxName());

		NotaDeCreditoFactory notaDeCreditoBuilder = new NotaDeCreditoFactory(get_TrxName(), getCtx(), client, orgInfo, invoice);
		notaDeCreditoBuilder.generateJSONInputData(); // Will contain data passed to factory
		notaDeCreditoBuilder.generateEDocument();
		
    	X_E_InvoiceElectronic invoiceElectronic = new X_E_InvoiceElectronic(getCtx(), 0, get_TrxName());
    	invoiceElectronic.setC_Invoice_ID(invoice.getC_Invoice_ID());
    	invoiceElectronic.setei_ValidationStatus("01");
    	if (notaDeCreditoBuilder.getEDocumentErrorMessages().length() > 0) {
    		invoiceElectronic.seterrMsgIntern(notaDeCreditoBuilder.getEDocumentErrorMessages().toString());
    		invoiceElectronic.setei_ValidationStatus("02");
        	invoiceElectronic.saveEx();
			System.out.println("Process EI_CreateInvoice_NotaCredito_SV : produced the following errors:");
			System.out.println(notaDeCreditoBuilder.getEDocumentErrorMessages().toString());
			System.out.println("Process EI_CreateInvoice_NotaCredito_SV : finished");
    		return notaDeCreditoBuilder.getEDocumentErrorMessages().toString();
    	}	
    	
    	String facturaAsJsonString = notaDeCreditoBuilder.createJsonString();
       	invoiceElectronic.setjson(facturaAsJsonString);
    	invoiceElectronic.saveEx();
    	
    	if (isSaveInHistoric()) {
    		if (!notaDeCreditoBuilder.writeToFile(facturaAsJsonString, invoice, NotaDeCredito.ABSDIRECTORY)) {
    			invoiceElectronic.seterrMsgIntern("Root File From MSystConfig EI_PATH does not exist");
    		}
    	}
		
    	System.out.println("Nota de Credito generada: " + invoice.getDocumentNo() + "Estado: " + invoiceElectronic.getei_ValidationStatus());
		System.out.println("Process EI_CreateInvoice_NotaCredito_SV : Finished");
		return "";
	}  

}