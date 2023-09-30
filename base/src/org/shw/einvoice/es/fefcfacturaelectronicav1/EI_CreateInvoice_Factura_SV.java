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

package org.shw.einvoice.es.fefcfacturaelectronicav1;


import java.math.BigDecimal;
import java.util.List;

import org.adempiere.core.domains.models.X_E_InvoiceElectronic;
import org.apache.commons.lang3.StringUtils;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MInvoiceTax;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.json.JSONArray;
import org.json.JSONObject;
import org.shw.einvoice.es.factory.FacturaStore;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;

/** Generated Process for (SHW_Create_ElectronicInvoice)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_CreateInvoice_Factura_SV extends EI_CreateInvoice_Factura_SVAbstract
{
	MClient				client = null;
	MOrgInfo 			orgInfo = null;
	StringBuffer errorMessages = new StringBuffer();
	
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{	
		System.out.println("Process EI_CreateInvoice_Factura_SV : started");
		
		MInvoice invoice = new MInvoice(getCtx(), getInvoiceId(), get_TrxName());
		System.out.println("Process EI_CreateInvoice_Factura_SV : Started with Invoice " + invoice.getDocumentNo());
		
		if (invoice.getC_DocType().getE_DocType_ID()<= 0 ||
				!invoice.getC_DocType().getE_DocType().getValue().equals(IdentificacionFactura.TIPO_DE_DOCUMENTO)) {
			String errorMessage = "El documento" + invoice.getDocumentNo() + " no es una Factura. Aquí se interrumpe el proceso";
			errorMessages.append(errorMessage);
			System.out.println(errorMessage);
			System.out.println("Process EI_CreateInvoice_Factura_SV : finished with errors");
			return errorMessages.toString();
		}
		
		System.out.println("Process EI_CreateInvoice_Factura_SV : Started with Invoice " + invoice.getDocumentNo());
		client = new MClient(getCtx(), invoice.getAD_Client_ID(), get_TrxName());
		int orgID = invoice.getAD_Org_ID();		
		orgInfo= MOrgInfo.get(getCtx(), orgID, get_TrxName());
		
		JSONObject jsonInputToFactory = generateJSONInputData(invoice); // Will contain data passed to factory
		FacturaStore facturaStore = new FacturaStore();
		facturaStore.generateEDocument(jsonInputToFactory);
		errorMessages.append(facturaStore.getEDocumentErrorMessages());

    	X_E_InvoiceElectronic invoiceElectronic = new X_E_InvoiceElectronic(getCtx(), 0, get_TrxName());
    	invoiceElectronic.setC_Invoice_ID(invoice.getC_Invoice_ID());
    	invoiceElectronic.setei_ValidationStatus("01");
    	if (errorMessages.length() > 0) {
    		invoiceElectronic.seterrMsgIntern(errorMessages.toString());
    		invoiceElectronic.setei_ValidationStatus("02");
        	invoiceElectronic.saveEx();
			System.out.println(errorMessages.toString());
			System.out.println("Process EI_CreateInvoice_Factura_SV : finished with errors");
    		return errorMessages.toString();
    	}	
    	
    	String facturaAsJsonString = facturaStore.createJsonString();
       	invoiceElectronic.setjson(facturaAsJsonString);
    	invoiceElectronic.saveEx();
    	log.config(facturaAsJsonString);
    	
    	if (isSaveInHistoric()) {
    		if (!EDocumentUtils.writeToFile(facturaAsJsonString, invoice, EDocumentUtils.ABSDIRECTORY)) {
    			invoiceElectronic.seterrMsgIntern("Root File From MSystConfig EI_PATH does not exist");
    		}
    	}
		
    	System.out.println("Factura generada: " + invoice.getDocumentNo() + "Estado: " + invoiceElectronic.getei_ValidationStatus());
    	System.out.println(facturaAsJsonString);
		System.out.println("Process EI_CreateInvoice_Factura_SV : Finished");
		return "";
	}

	private JSONObject generateJSONInputData(MInvoice invoice) {
		JSONObject factoryInput = new JSONObject();  // Will contain data passed to factory

		factoryInput.put(EDocumentUtils.IDENTIFICACION, generateIdentificationInputData(invoice));
		factoryInput.put(EDocumentUtils.RECEPTOR, generateReceptorInputData(invoice));
		factoryInput.put(EDocumentUtils.EMISOR, generateEmisorInputData(invoice));
		factoryInput.put(EDocumentUtils.RESUMEN, generateResumenInputData(invoice));
		factoryInput.put(EDocumentUtils.CUERPODOCUMENTO, generateCuerpoDocumentoInputData(invoice));

		return factoryInput;

	}
	
	private JSONObject generateIdentificationInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Identificacion");
		
		Integer invoiceID = invoice.get_ID();
		String numeroControl = EDocumentUtils.getNumeroControl(invoiceID, orgInfo, "DTE-01-");
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(invoiceID.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();
		jsonObjectIdentificacion.put(EDocumentUtils.NUMEROCONTROL, numeroControl);
		jsonObjectIdentificacion.put(EDocumentUtils.CODIGOGENERACION, codigoGeneracion);
		jsonObjectIdentificacion.put(EDocumentUtils.TIPOMODELO, 1);
		jsonObjectIdentificacion.put(EDocumentUtils.TIPOOPERACION, 1);
		jsonObjectIdentificacion.put(EDocumentUtils.FECEMI, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put(EDocumentUtils.HOREMI, "00:00:00");
		jsonObjectIdentificacion.put(EDocumentUtils.TIPOMONEDA, "USD");
		jsonObjectIdentificacion.put(EDocumentUtils.AMBIENTE, "00");

		System.out.println("Finish collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;
		
	}
	
	private JSONObject generateEmisorInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put(EDocumentUtils.NIT, orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put(EDocumentUtils.NRC, StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		jsonObjectEmisor.put(EDocumentUtils.NOMBRE, client.getName());
		jsonObjectEmisor.put(EDocumentUtils.CODACTIVIDAD, client.getE_Activity().getValue());
		jsonObjectEmisor.put(EDocumentUtils.DESCACTIVIDAD, client.getE_Activity().getName());
		jsonObjectEmisor.put(EDocumentUtils.NOMBRECOMERCIAL, client.getDescription());
		jsonObjectEmisor.put(EDocumentUtils.TIPOESTABLECIMIENTO, client.getE_PlantType().getValue());

		JSONObject jsonDireccion = new JSONObject();
		jsonDireccion.put(EDocumentUtils.DEPARTAMENTO, orgInfo.getC_Location().getC_City().getC_Region().getValue());
		jsonDireccion.put(EDocumentUtils.MUNICIPIO, orgInfo.getC_Location().getC_City().getValue());
		jsonDireccion.put(EDocumentUtils.COMPLEMENTO, orgInfo.getC_Location().getAddress1());
		jsonObjectEmisor.put(EDocumentUtils.DIRECCION, jsonDireccion);
		
		jsonObjectEmisor.put(EDocumentUtils.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(EDocumentUtils.CORREO, client.getEMail());

		System.out.println("Finish collecting JSON data for Emisor");
		return jsonObjectEmisor;
		
	}
	
	private JSONObject generateReceptorInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Receptor");

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
		if (partner.getE_Activity_ID()<=0 || partner.getE_Recipient_Identification_ID() <= 0) {
			String errorMessage = "Socio de Negocio " + partner.getName() + ": Falta configuracion para Facturacion Electronica"; 
			errorMessages.append(errorMessage);
			System.out.println(errorMessage);
		}
		
		JSONObject jsonObjectReceptor = new JSONObject();
		
		jsonObjectReceptor.put(EDocumentUtils.TIPODOCUMENTO, partner.getE_Recipient_Identification().getValue());
		jsonObjectReceptor.put(EDocumentUtils.NUMDOCUMENTO, partner.getTaxID().replace("-", ""));
		jsonObjectReceptor.put(EDocumentUtils.NOMBRE, partner.getName());
		
		if (partner.getE_Activity_ID()>0) {
			jsonObjectReceptor.put(EDocumentUtils.CODACTIVIDAD, partner.getE_Activity().getValue());
			jsonObjectReceptor.put(EDocumentUtils.DESCACTIVIDAD, partner.getE_Activity().getName());
		} else  {
			jsonObjectReceptor.put(EDocumentUtils.CODACTIVIDAD, "");
			jsonObjectReceptor.put(EDocumentUtils.DESCACTIVIDAD, "");
		}

		JSONObject jsonDireccion = new JSONObject();
		String departamento = "";
		String municipio = "";
		String complemento = "";
		for (MBPartnerLocation partnerLocation : MBPartnerLocation.getForBPartner(getCtx(), partner.getC_BPartner_ID(), get_TrxName())){
			if (partnerLocation.isBillTo()) {
				departamento = partnerLocation.getC_Location().getC_City().getC_Region().getValue();
				municipio =  partnerLocation.getC_Location().getC_City().getValue();
				complemento = (partnerLocation.getC_Location().getAddress1() + " " + partnerLocation.getC_Location().getAddress2());
				jsonDireccion.put(EDocumentUtils.DEPARTAMENTO, departamento);
				jsonDireccion.put(EDocumentUtils.MUNICIPIO, municipio);
				jsonDireccion.put(EDocumentUtils.COMPLEMENTO, complemento);
				break;
			}
		}		
		
		// In case there is no address
		if (departamento == null) {
			jsonDireccion.put(EDocumentUtils.DEPARTAMENTO, departamento);
			jsonDireccion.put(EDocumentUtils.MUNICIPIO, municipio);
			jsonDireccion.put(EDocumentUtils.COMPLEMENTO, complemento);
		}		
		jsonObjectReceptor.put(EDocumentUtils.DIRECCION, jsonDireccion);
		
		jsonObjectReceptor.put(EDocumentUtils.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectReceptor.put(EDocumentUtils.CORREO, partner.get_ValueAsString("EMail"));		

		System.out.println("Finish collecting JSON data for Receptor");
		return jsonObjectReceptor;
		
	}
	
	private JSONObject generateResumenInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Resumen");
		BigDecimal totalNoSuj 	= Env.ZERO;
		BigDecimal totalExenta 	= Env.ZERO;
		BigDecimal totalGravada = Env.ZERO;		
		BigDecimal totalIVA 	= Env.ZERO;
		
		String totalLetras=Msg.getAmtInWords(Env.getLanguage(getCtx()), invoice.getGrandTotal().setScale(2).toString());

		List<MInvoiceTax> invoiceTaxes = new Query(getCtx() , MInvoiceTax.Table_Name , "C_Invoice_ID=?" , get_TrxName())
				.setParameters(invoice.getC_Invoice_ID())
				.list();
		
		for (MInvoiceTax invoiceTax:invoiceTaxes) {
			if (invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ")) {
				totalNoSuj = invoiceTax.getTaxBaseAmt();
			}
			if (!invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ") && invoiceTax.getC_Tax().getRate().doubleValue()==0.00) {
				totalExenta = invoiceTax.getTaxBaseAmt();
			}
			if (!invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ") && invoiceTax.getC_Tax().getRate().doubleValue()!=0.00) {
				totalGravada = invoiceTax.getTaxBaseAmt();
				totalIVA = invoiceTax.getTaxAmt();
			}
		}
				
		JSONObject jsonObjectResumen = new JSONObject();
		jsonObjectResumen.put(EDocumentUtils.TOTALNOSUJ, totalNoSuj);
		jsonObjectResumen.put(EDocumentUtils.TOTALEXENTA, totalExenta);
		jsonObjectResumen.put(EDocumentUtils.TOTALGRAVADA, totalGravada);
		jsonObjectResumen.put(EDocumentUtils.SUBTOTALVENTAS, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(EDocumentUtils.DESCUNOSUJ, Env.ZERO);
		jsonObjectResumen.put(EDocumentUtils.DESCUEXENTA, Env.ZERO);
		jsonObjectResumen.put(EDocumentUtils.DESCUGRAVADA, Env.ZERO);
		jsonObjectResumen.put(EDocumentUtils.PORCENTAJEDESCUENTO, Env.ZERO);
		jsonObjectResumen.put(EDocumentUtils.SUBTOTAL, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(EDocumentUtils.IVARETE1, Env.ZERO);
		jsonObjectResumen.put(EDocumentUtils.MONTOTOTALOPERACION, invoice.getGrandTotal());
		jsonObjectResumen.put(EDocumentUtils.TOTALNOGRAVADO, totalExenta.add(totalNoSuj));
		jsonObjectResumen.put(EDocumentUtils.TOTALPAGAR, invoice.getGrandTotal());
		jsonObjectResumen.put(EDocumentUtils.TOTALLETRAS, totalLetras);
		jsonObjectResumen.put(EDocumentUtils.SALDOFAVOR, invoice.getGrandTotal());
		jsonObjectResumen.put(EDocumentUtils.CONDICIONOPERACION, 1);
		jsonObjectResumen.put(EDocumentUtils.TOTALDESCU, Env.ZERO);
		jsonObjectResumen.put(EDocumentUtils.RETERENTA, Env.ZERO);
		jsonObjectResumen.put(EDocumentUtils.TOTALIVA, totalIVA);

		JSONArray jsonArrayPagos = new JSONArray();
			JSONObject jsonPago = new JSONObject();
			jsonPago.put(EDocumentUtils.CODIGO, "05");
			jsonPago.put(EDocumentUtils.MONTOPAGO, new BigDecimal(0.00));
			jsonPago.put(EDocumentUtils.REFERENCIA, "Transferencia_ Depósito Bancario");
			jsonPago.put(EDocumentUtils.PLAZO, invoice.getC_PaymentTerm().getE_TimeSpan().getValue());
			jsonPago.put(EDocumentUtils.PERIODO, invoice.getC_PaymentTerm().getNetDays());
		jsonArrayPagos.put(jsonPago);

		jsonObjectResumen.put(EDocumentUtils.PAGOS, jsonArrayPagos);
		
		System.out.println("Finish collecting JSON data for Resumen");
		return jsonObjectResumen;
		
	}
	
	private JSONObject generateCuerpoDocumentoInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		JSONObject jsonCuerpoDocumento = new JSONObject();
		JSONArray jsonCuerpoDocumentoArray = new JSONArray();
		
		for (MInvoiceLine invoiceLine:invoice.getLines()) { 
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() );
			
			BigDecimal ventaNoSuj 	= Env.ZERO;
			BigDecimal ventaExenta 	= Env.ZERO;
			BigDecimal ventaGravada = Env.ONEHUNDRED;
			BigDecimal ivaItem 		= Env.ZERO;
			
			if (invoiceLine.getC_Tax().getTaxIndicator().equals("NSUJ"))
				ventaNoSuj = invoiceLine.getLineNetAmt();
			if (invoiceLine.getC_Tax().getTaxIndicator().equals("EXT"))
				ventaExenta = invoiceLine.getLineNetAmt();
			if (invoiceLine.getC_Tax().getTaxIndicator().equals("IVA") ) {
				ventaGravada = invoiceLine.getLineNetAmt(); 
				MTax tax = (MTax)invoiceLine.getC_Tax();
				if (invoiceLine.getTaxAmt().compareTo(Env.ZERO) == 0)
					ivaItem = tax.calculateTax(invoiceLine.getLineNetAmt(), invoice.getM_PriceList().isTaxIncluded(), 2);
			}
			
			JSONObject jsonCuerpoDocumentoItem = new JSONObject();
                
			jsonCuerpoDocumentoItem.put(EDocumentUtils.NUMITEM, invoiceLine.getLine());
			jsonCuerpoDocumentoItem.put(EDocumentUtils.TIPOITEM, 2);
			jsonCuerpoDocumentoItem.put(EDocumentUtils.NUMERODOCUMENTO, EDocumentUtils.getNumeroControl(invoice.get_ID(), orgInfo, "DTE-01-"));
			jsonCuerpoDocumentoItem.put(EDocumentUtils.CANTIDAD, invoiceLine.getQtyInvoiced());
			jsonCuerpoDocumentoItem.put(EDocumentUtils.CODIGO, invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(EDocumentUtils.CODIGOTRIBUTO, "");  // String codTributo = "20";
			
			JSONArray jsonTributosArray = new JSONArray();
			jsonCuerpoDocumentoItem. put( EDocumentUtils.TRIBUTOS, jsonTributosArray); //tributosItems.add("20");
			
			jsonCuerpoDocumentoItem.put(EDocumentUtils.UNIMEDIDA, 1);
			jsonCuerpoDocumentoItem.put(EDocumentUtils.DESCRIPCION, invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(EDocumentUtils.PRECIOUNI, invoiceLine.getPriceActual());
			jsonCuerpoDocumentoItem.put(EDocumentUtils.MONTODESCU, Env.ZERO);
			jsonCuerpoDocumentoItem.put(EDocumentUtils.VENTANOSUJ, ventaNoSuj);
			jsonCuerpoDocumentoItem.put(EDocumentUtils.VENTAEXENTA, ventaExenta);
			jsonCuerpoDocumentoItem.put(EDocumentUtils.VENTAGRAVADA, ventaGravada);
			jsonCuerpoDocumentoItem.put(EDocumentUtils.PSV, invoiceLine.getTaxAmt());
			jsonCuerpoDocumentoItem.put(EDocumentUtils.NOGRAVADO, ventaNoSuj.add(ventaNoSuj));
			jsonCuerpoDocumentoItem.put(EDocumentUtils.IVAITEM, ivaItem);

			jsonCuerpoDocumentoArray.put(jsonCuerpoDocumentoItem);
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() + " Finished");

		}  
		
		jsonCuerpoDocumento.put(EDocumentUtils.CUERPODOCUMENTO, jsonCuerpoDocumentoArray);
		System.out.println("Finish collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		
		return jsonCuerpoDocumento;
	}
  

}