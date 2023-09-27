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


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import org.adempiere.core.domains.models.X_E_InvoiceElectronic;
import org.apache.commons.lang3.StringUtils;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MInvoiceTax;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.shw.einvoice.es.factory.FacturaStore;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.CuerpoDocumentoItem;
import org.shw.einvoice.es.util.pojo.Direccion;
import org.shw.einvoice.es.util.pojo.PagosItem;

import com.fasterxml.jackson.databind.ObjectMapper;

/** Generated Process for (SHW_Create_ElectronicInvoice)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_CreateInvoice_Factura_SV extends EI_CreateInvoice_Factura_SVAbstract
{
	MClient				client = null;
	MOrgInfo 			orgInfo = null;
	StringBuffer errorMessages = new StringBuffer();
	String absDirectory = "";	
	
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{	
		System.out.println("Process EI_CreateInvoice_Factura_SV : started");
		
		absDirectory = MSysConfig.getValue("EI_PATH");
		MInvoice invoice = new MInvoice(getCtx(), getInvoiceId(), get_TrxName());
		System.out.println("Process EI_CreateInvoice_Factura_SV : Started with Invoice " + invoice.getDocumentNo());
		
		if (invoice.getC_DocType().getE_DocType_ID()<= 0 ||
				!invoice.getC_DocType().getE_DocType().getValue().equals(IdentificacionFactura.TIPO_DE_DOCUMENTO)) {
			String errorMessage = "El documento" + invoice.getDocumentNo() + " no es una Factura. Aquí se interrumpe el proceso";
			errorMessages.append(errorMessage);
			System.out.println(errorMessage);
			System.out.println("Process EI_CreateInvoice_Factura_SV : finished");
			return errorMessages.toString();
		}
		
		System.out.println("Process EI_CreateInvoice_Factura_SV : Started with Invoice " + invoice.getDocumentNo());
		client = new MClient(getCtx(), invoice.getAD_Client_ID(), get_TrxName());
		int orgID = invoice.getAD_Org_ID();		
		orgInfo= MOrgInfo.get(getCtx(), orgID, get_TrxName());
		
		FacturaStore facturaStore = new FacturaStore();
		JSONObject jsonInputToFactory = generateJSONInputData(invoice); // Will contain data passed to factory	
		Factura factura = (Factura) facturaStore.generateEDocument(jsonInputToFactory);
		errorMessages.append(facturaStore.getEDocumentErrorMessages());

		// TODO folgendes muß weg
		try {fillReceptor((ReceptorFactura)             factura.getReceptor(),       invoice);} catch (Exception e) {errorMessages.append(e);}
		try {fillemisor((EmisorFactura)                 factura.getEmisor(),         invoice);} catch (Exception e) {errorMessages.append(e);}
		try {fillResumen((ResumenFactura)               factura.getResumen(),        invoice);} catch (Exception e) {errorMessages.append(e);}
		try {fillIdentification((IdentificacionFactura) factura.getIdentificacion(), invoice);} catch (Exception e) {errorMessages.append(e);}
		
		//Durch InvoiceZeilen laufen
		for (MInvoiceLine invoiceLine:invoice.getLines()) { 
			System.out.println("Fill Cuerpo Documento: " + invoice.getDocumentNo() + " Line: " + invoiceLine.getLine() );

			int numItem = invoiceLine.getLine();
			int tipoItem = 2;
			String numeroDocumento = getNumeroControl(invoice);
			BigDecimal cantidad = invoiceLine.getQtyInvoiced();
			String codigo = invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName();
			//String codTributo = "20";
			ArrayList<String> tributosItems = new ArrayList<String>();
			//TributosItem tributosItem = new TributosItem("20", "", invoiceLine.getTaxAmt());
			//tributosItems.add("20");

			int uniMedida = 1;
			String descripcion = invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName();
			BigDecimal precioUni = invoiceLine.getPriceActual();
			BigDecimal montoDescu = Env.ZERO;
			BigDecimal ventaNoSuj = Env.ZERO;
			BigDecimal ventaExenta = Env.ZERO;
			BigDecimal ventaGravada = Env.ONEHUNDRED;
			BigDecimal ivaItem = Env.ZERO;
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
			BigDecimal psv = invoiceLine.getTaxAmt();
			BigDecimal noGravado = ventaNoSuj.add(ventaNoSuj);
			CuerpoDocumentoItemFactura cuerpoDocumentoItem = new CuerpoDocumentoItemFactura(numItem, tipoItem, numeroDocumento, cantidad, codigo, 
					null, uniMedida, 
					descripcion, precioUni, montoDescu, ventaNoSuj, ventaExenta, ventaGravada, null, psv, noGravado,ivaItem); 
			cuerpoDocumentoItem.validateValues();
			factura.getCuerpoDocumento().add(cuerpoDocumentoItem);
			System.out.println("Fill Cuerpo Documento: " + invoice.getDocumentNo() + " Line: " + invoiceLine.getLine() + " Finished");

		}  

		validateValues(factura, errorMessages);

    	X_E_InvoiceElectronic invoiceElectronic = new X_E_InvoiceElectronic(getCtx(), 0, get_TrxName());
    	invoiceElectronic.setC_Invoice_ID(invoice.getC_Invoice_ID());
    	invoiceElectronic.setei_ValidationStatus("01");
    	if (errorMessages.length() > 0) {
    		invoiceElectronic.seterrMsgIntern(errorMessages.toString());
    		invoiceElectronic.setei_ValidationStatus("02");
        	invoiceElectronic.saveEx();
    		return errorMessages.toString();
    	}    
	
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	String json = objectMapper.writeValueAsString(factura);

       	invoiceElectronic.setjson(json);
    	invoiceElectronic.saveEx();
    	log.config(json);
    	if (isSaveInHistoric()) {
    		Path rootpath = Paths.get(absDirectory);
    		if (!Files.exists(rootpath)) {
    			invoiceElectronic.seterrMsgIntern("Root File From MSystConfig EI_PATH does not exist");
    		}
    		writeToFile(json, invoice);
    	}
		
    	System.out.println("Factura generada: " + invoice.getDocumentNo() + "Estado: " + invoiceElectronic.getei_ValidationStatus());
    	System.out.println(json);
		System.out.println("Process EI_CreateInvoice_Factura_SV : Finished");
		return "";
	}

	private JSONObject generateJSONInputData(MInvoice invoice) {
		JSONObject factoryInput = new JSONObject();  // Will contain data passed to factory

		factoryInput.put("identificacion", generateIdentificationInputData(invoice));
		factoryInput.put("receptor", generateReceptorInputData(invoice));
		factoryInput.put("emisor", generateEmisorInputData(invoice));
		factoryInput.put("resumen", generateResumenInputData(invoice));
		factoryInput.put("cuerpoDocumento", generateCuerpoDocumentoInputData(invoice));

		return factoryInput;

	}

	private String getNumeroControl(MInvoice invoice) {
		String 	numeroControl;
		Integer id = invoice.get_ID();
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		//final String PATTERN = "^DTE-03-[A-Z0-9]{8}-[0-9]{15}$";	
		String duns = orgInfo.getDUNS().replace("-", "");
	    //final String PATTERN = "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$";
		numeroControl = "DTE-01-" + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		return numeroControl;
	}

	private void fillIdentification(IdentificacionFactura identificacion, MInvoice invoice) {
		Integer id = invoice.get_ID();
		
		String numeroControl = getNumeroControl(invoice);
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(id.toString(), 12,"0");

		System.out.println("Start fillIdentificacion");
		identificacion.setNumeroControl(numeroControl);
		identificacion.setCodigoGeneracion(codigoGeneracion);
		identificacion.setTipoModelo(1);
		identificacion.setTipoOperacion(1);

		String fecha = invoice.getDateAcct().toString().substring(0, 10);

		identificacion.setFecEmi(fecha);
		identificacion.setHorEmi("00:00:00");
		identificacion.setTipoMoneda("USD");
		identificacion.setAmbiente("00");
		
		System.out.println("fillIdentificacion Finished");

	}
	
	private JSONObject generateIdentificationInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Identificacion");
		
		Integer id = invoice.get_ID();
		//final String PATTERN = "^DTE-03-[A-Z0-9]{8}-[0-9]{15}$";
		String numeroControl = getNumeroControl(invoice);
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(id.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();
		jsonObjectIdentificacion.put("numeroControl", numeroControl);
		jsonObjectIdentificacion.put("codigoGeneracion", codigoGeneracion);
		jsonObjectIdentificacion.put("tipoModelo", 1);
		jsonObjectIdentificacion.put("tipoOperacion", 1);
		jsonObjectIdentificacion.put("fecEmi", invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put("horEmi", "00:00:00");
		jsonObjectIdentificacion.put("tipoMoneda", "USD");
		jsonObjectIdentificacion.put("ambiente", "00");

		System.out.println("Finish collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;
		
	}
	
	private void fillemisor(EmisorFactura emisor, MInvoice invoice) {
		System.out.println("Start fillEmisor");
		emisor.setNit(orgInfo.getTaxID().replace("-", ""));
		emisor.setNrc(StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		emisor.setNombre(client.getName()); 
		emisor.setCodActividad(client.getE_Activity().getValue());
		emisor.setDescActividad(client.getE_Activity().getName());
		emisor.setNombreComercial(client.getDescription());
		emisor.setTipoEstablecimiento(client.getE_PlantType().getValue());
		String departamento = orgInfo.getC_Location().getC_City().getC_Region().getValue();
		String municipio = orgInfo.getC_Location().getC_City().getValue();
		String complemento = orgInfo.getC_Location().getAddress1();
		Direccion direccion = new Direccion(departamento, municipio, complemento);
		emisor.setDireccion(direccion);
		emisor.setTelefono(client.get_ValueAsString("phone"));
		emisor.setCorreo(client.getEMail());
		System.out.println("fillEmisor Finished");
	}
	
	private JSONObject generateEmisorInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put("nit", orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put("nrc", StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		jsonObjectEmisor.put("nombre", client.getName());
		jsonObjectEmisor.put("codActividad", client.getE_Activity().getValue());
		jsonObjectEmisor.put("descActividad", client.getE_Activity().getName());
		jsonObjectEmisor.put("nombreComercial", client.getDescription());
		jsonObjectEmisor.put("tipoEstablecimiento", client.getE_PlantType().getValue());
		jsonObjectEmisor.put("departamento", orgInfo.getC_Location().getC_City().getC_Region().getValue());
		jsonObjectEmisor.put("municipio", orgInfo.getC_Location().getC_City().getValue());
		jsonObjectEmisor.put("complemento", orgInfo.getC_Location().getAddress1());
		jsonObjectEmisor.put("telefono", client.get_ValueAsString("phone"));
		jsonObjectEmisor.put("correo", client.getEMail());

		System.out.println("Finish collecting JSON data for Emisor");
		return jsonObjectEmisor;
		
	}
	
	private void fillReceptor(ReceptorFactura receptor, MInvoice invoice) {

		System.out.println("Start fillemisor");

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
		if (partner.getE_Activity_ID()<=0 || partner.getE_Recipient_Identification_ID() <= 0) {
			errorMessages.append("SdN: Falta configuracion para Facturacion Electronica");
			return;
		}
		receptor.setTipoDocumento(partner.getE_Recipient_Identification().getValue());
		if (receptor.getTipoDocumento().equals("36"))

			receptor.setNumDocumento(partner.getTaxID().replace("-", ""));
		receptor.setNombre(partner.getName());
		receptor.setCodActividad(partner.getE_Activity().getValue());
		receptor.setDescActividad(partner.getE_Activity().getName());
		String departamento = "";
		String municipio = "";
		String complemento = "";
		for (MBPartnerLocation partnerLocation : MBPartnerLocation.getForBPartner(getCtx(), partner.getC_BPartner_ID(), get_TrxName())){
			if (partnerLocation.isBillTo()) {
				departamento = partnerLocation.getC_Location().getC_City().getC_Region().getValue();
				municipio =  partnerLocation.getC_Location().getC_City().getValue();
				complemento = (partnerLocation.getC_Location().getAddress1() + " " + partnerLocation.getC_Location().getAddress2());
				break;
			}
		}
		Direccion direccion = new Direccion(departamento, municipio, complemento);
		receptor.setDireccion(direccion);
		receptor.setTelefono("79309099");
		receptor.setCorreo(partner.get_ValueAsString("EMail"));	
		System.out.println("fillemisor Finished");

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
		
		jsonObjectReceptor.put("tipoDocumento", partner.getE_Recipient_Identification().getValue());
		jsonObjectReceptor.put("numDocumento", partner.getTaxID().replace("-", ""));
		jsonObjectReceptor.put("nombre", partner.getName());
		
		if (partner.getE_Activity_ID()>0) {
			jsonObjectReceptor.put("codActividad", partner.getE_Activity().getValue());
			jsonObjectReceptor.put("descActividad", partner.getE_Activity().getName());
		} else  {
			jsonObjectReceptor.put("codActividad", "");
			jsonObjectReceptor.put("descActividad", "");
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
				jsonDireccion.put("departamento", departamento);
				jsonDireccion.put("municipio", municipio);
				jsonDireccion.put("complemento", complemento);
				break;
			}
		}		
		
		// In case there is no address
		if (departamento.isEmpty()) {
			jsonDireccion.put("departamento", departamento);
			jsonDireccion.put("municipio", municipio);
			jsonDireccion.put("complemento", complemento);
		}
		
		jsonObjectReceptor.put("direccion", jsonDireccion);
		
		jsonObjectReceptor.put("telefono", client.get_ValueAsString("phone"));
		jsonObjectReceptor.put("correo", partner.get_ValueAsString("EMail"));		

		System.out.println("Finish collecting JSON data for Receptor");
		return jsonObjectReceptor;
		
	}
	
	
	
	private void fillResumen(ResumenFactura resumen, MInvoice invoice) {
		System.out.println("Start fillResumenr");


		//List<TributosItem> tributos;
		//List<PagosItem> pagos ;  // there must be at least one item

		BigDecimal TotalNoSuj = Env.ZERO;
		BigDecimal TotalExenta = Env.ZERO;
		BigDecimal TotalGravada = Env.ZERO;
		BigDecimal SubTotalVentas = Env.ZERO;
		BigDecimal DescuNoSuj = Env.ZERO;
		BigDecimal DescuExenta = Env.ZERO;
		BigDecimal DescuGravada = Env.ZERO;
		BigDecimal PorcentajeDescuento = Env.ZERO;
		BigDecimal SubTotal = invoice.getTotalLines();
		BigDecimal IvaPerci1 = Env.ZERO;
		BigDecimal IvaRete1 = Env.ZERO;
		BigDecimal MontoTotalOperacion = invoice.getGrandTotal();
		BigDecimal TotalPagar =invoice.getGrandTotal();
		BigDecimal totalIVA = Env.ZERO;

		int CondicionOperacion =2;
		List<PagosItem> pagosItems = new ArrayList<PagosItem>();
		PagosItem pagoitem = new PagosItem("05",
				new BigDecimal(0.00), 
				"Transferencia_ Depósito Bancario", 
				invoice.getC_PaymentTerm().getE_TimeSpan().getValue(),
				invoice.getC_PaymentTerm().getNetDays());
		pagosItems.add(pagoitem);
		resumen.setPagos(pagosItems);

		String TotalLetras=Msg.getAmtInWords(Env.getLanguage(getCtx()), invoice.getGrandTotal().setScale(2).toString());
		BigDecimal SaldoFavor = Env.ZERO;

		List<MInvoiceTax> invoiceTaxes = new Query(getCtx() , MInvoiceTax.Table_Name , "C_Invoice_ID=?" , get_TrxName())
				.setParameters(invoice.getC_Invoice_ID())
				.list();
		
		for (MInvoiceTax invoiceTax:invoiceTaxes) {
			if (invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ")) {
				TotalNoSuj = invoiceTax.getTaxBaseAmt();
			}
			if (!invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ") && invoiceTax.getC_Tax().getRate().doubleValue()==0.00)
				TotalExenta = invoiceTax.getTaxBaseAmt();
			if (!invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ") && invoiceTax.getC_Tax().getRate().doubleValue()!=0.00) {
				TotalGravada = invoiceTax.getTaxBaseAmt();
				totalIVA = invoiceTax.getTaxAmt();
			}

		}

		resumen.setTotalNoSuj(TotalNoSuj);
		resumen.setTotalExenta(TotalExenta);
		resumen.setTotalGravada(TotalGravada);
		resumen.setSubTotalVentas(TotalGravada.add(TotalNoSuj).add(TotalExenta));
		resumen.setDescuNoSuj(DescuNoSuj);
		resumen.setDescuExenta(DescuExenta);
		resumen.setDescuGravada(DescuGravada);
		resumen.setPorcentajeDescuento(PorcentajeDescuento);
		resumen.setSubTotal(TotalGravada.add(TotalNoSuj).add(TotalExenta));
		resumen.setIvaRete1(IvaRete1);
		resumen.setMontoTotalOperacion(invoice.getGrandTotal());
		resumen.setTotalNoGravado(TotalExenta.add(TotalNoSuj));
		resumen.setTotalPagar(invoice.getGrandTotal());
		resumen.setTotalLetras(TotalLetras);
		resumen.setSaldoFavor(invoice.getGrandTotal());
		resumen.setCondicionOperacion(1);
		resumen.setTotalDescu(Env.ZERO);
		resumen.setReteRenta(Env.ZERO);
		resumen.setTotalIva(totalIVA);
		System.out.println("fillResumenr Finished");


	}
	
	private JSONObject generateResumenInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Resumen");
		BigDecimal totalNoSuj = Env.ZERO;
		BigDecimal totalExenta = Env.ZERO;
		BigDecimal totalGravada = Env.ZERO;		
		BigDecimal totalIVA = Env.ZERO;
		
		String totalLetras=Msg.getAmtInWords(Env.getLanguage(getCtx()), invoice.getGrandTotal().setScale(2).toString());

		List<MInvoiceTax> invoiceTaxes = new Query(getCtx() , MInvoiceTax.Table_Name , "C_Invoice_ID=?" , get_TrxName())
				.setParameters(invoice.getC_Invoice_ID())
				.list();
		
		for (MInvoiceTax invoiceTax:invoiceTaxes) {
			if (invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ")) {
				totalNoSuj = invoiceTax.getTaxBaseAmt();
			}
			if (!invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ") && invoiceTax.getC_Tax().getRate().doubleValue()==0.00)
				totalExenta = invoiceTax.getTaxBaseAmt();
			if (!invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ") && invoiceTax.getC_Tax().getRate().doubleValue()!=0.00) {
				totalGravada = invoiceTax.getTaxBaseAmt();
				totalIVA = invoiceTax.getTaxAmt();
			}

		}
				
		JSONObject jsonObjectResumen = new JSONObject();
		jsonObjectResumen.put("totalNoSuj", totalNoSuj);
		jsonObjectResumen.put("totalExenta", totalExenta);
		jsonObjectResumen.put("totalGravada", totalGravada);
		jsonObjectResumen.put("subTotalVentas", totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put("descuNoSuj", Env.ZERO);
		jsonObjectResumen.put("descuExenta", Env.ZERO);
		jsonObjectResumen.put("descuGravada", Env.ZERO);
		jsonObjectResumen.put("porcentajeDescuento", Env.ZERO);
		jsonObjectResumen.put("subTotal", totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put("ivaRete1", Env.ZERO);
		jsonObjectResumen.put("montoTotalOperacion", invoice.getGrandTotal());
		jsonObjectResumen.put("totalNoGravado", totalExenta.add(totalNoSuj));
		jsonObjectResumen.put("totalPagar", invoice.getGrandTotal());
		jsonObjectResumen.put("totalLetras", totalLetras);
		jsonObjectResumen.put("saldoFavor", invoice.getGrandTotal());
		jsonObjectResumen.put("condicionOperacion", 1);
		jsonObjectResumen.put("totalDescu", Env.ZERO);
		jsonObjectResumen.put("reteRenta", Env.ZERO);
		jsonObjectResumen.put("totalIva", totalIVA);

		JSONArray jsonArrayPagos = new JSONArray();
			JSONObject jsonPago = new JSONObject();
			jsonPago.put("codigo", "05");
			jsonPago.put("montoPago", new BigDecimal(0.00));
			jsonPago.put("referencia", "Transferencia_ Depósito Bancario");
			jsonPago.put("plazo", invoice.getC_PaymentTerm().getE_TimeSpan().getValue());
			jsonPago.put("periodo", invoice.getC_PaymentTerm().getNetDays());
		jsonArrayPagos.put(jsonPago);

		jsonObjectResumen.put("pagos", jsonArrayPagos);
		
		System.out.println("Finish collecting JSON data for Resumen");
		return jsonObjectResumen;
		
	}
	
	private JSONObject generateCuerpoDocumentoInputData(MInvoice invoice) {
		System.out.println("Start collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		JSONObject jsonCuerpoDocumento = new JSONObject();
		JSONArray jsonCuerpoDocumentoArray = new JSONArray();
		
		for (MInvoiceLine invoiceLine:invoice.getLines()) { 
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() );
			
			BigDecimal ventaNoSuj = Env.ZERO;
			BigDecimal ventaExenta = Env.ZERO;
			BigDecimal ventaGravada = Env.ONEHUNDRED;
			BigDecimal ivaItem = Env.ZERO;
			
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
                
			jsonCuerpoDocumentoItem.put("numItem", invoiceLine.getLine());
			jsonCuerpoDocumentoItem.put("tipoItem", 2);
			jsonCuerpoDocumentoItem.put("numeroDocumento", getNumeroControl(invoice));
			jsonCuerpoDocumentoItem.put("cantidad", invoiceLine.getQtyInvoiced());
			jsonCuerpoDocumentoItem.put("codigo", invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put("codigoTributo", "");  // String codTributo = "20";
			
			JSONArray jsonTributosArray = new JSONArray();
			jsonCuerpoDocumentoArray.put(jsonTributosArray); //tributosItems.add("20");
			
			jsonCuerpoDocumentoItem.put("uniMedida", 1);
			jsonCuerpoDocumentoItem.put("descripcion", invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put("precioUni", invoiceLine.getPriceActual());
			jsonCuerpoDocumentoItem.put("montoDescu", Env.ZERO);
			jsonCuerpoDocumentoItem.put("ventaNoSuj", ventaNoSuj);
			jsonCuerpoDocumentoItem.put("ventaExenta", ventaExenta);
			jsonCuerpoDocumentoItem.put("ventaGravada", ventaGravada);
			jsonCuerpoDocumentoItem.put("ivaItem", ivaItem);
			jsonCuerpoDocumentoItem.put("psv", invoiceLine.getTaxAmt());
			jsonCuerpoDocumentoItem.put("noGravado", ventaNoSuj.add(ventaNoSuj));

			jsonCuerpoDocumentoArray.put(jsonCuerpoDocumentoItem);
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() + " Finished");

		}  
		
		jsonCuerpoDocumento.put("cuerpoDocumento", jsonCuerpoDocumentoArray);
		System.out.println("Finish collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		
		return null;
	}
	
	private void fillExtension(ExtensionFactura extension, MInvoice invoice) {
		extension.setDocuEntrega("555");
		extension.setDocuRecibe("555");
		extension.setNombEntrega("55");
		extension.setNombRecibe("55");
		extension.setObservaciones("55");
		//extension.setPlacaVehiculo("");
		
	}
	
	private void fillApendiceItem(ApendiceItem apendiceItem, MInvoice invoice) {
		apendiceItem.setCampo("11");
		apendiceItem.setEtiqueta("777");
		apendiceItem.setValor("uu");
	}
	

	private void validateValues(Factura factura, StringBuffer error) {

		System.out.println("Start validateValues");
		System.out.println("Start Resumen validateValues");
		String result = "";
		
		if (factura.getResumen() != null)
		{
			result = factura.getResumen().validateValues();
			if (!result.equals(Factura.VALIDATION_RESULT_OK))
				error.append(result);
		}

		System.out.println("Start Identification validateValues");
		if (factura.getIdentificacion() != null) {
			result = factura.getIdentificacion().validateValues();
			if (!result.equals(Factura.VALIDATION_RESULT_OK))
				error.append(result);
		}

		System.out.println("Start Receptor validateValues");
		if (factura.getReceptor() != null){
			result = factura.getReceptor().validateValues();
			if (!result.equals(Factura.VALIDATION_RESULT_OK))
				error.append(result);
		}

		System.out.println("Start Cuerpo Documento validateValues");
		if (factura.getCuerpoDocumento() != null) {
			for (CuerpoDocumentoItem cuerpoDocumentoItem : factura.getCuerpoDocumento()) {
				cuerpoDocumentoItem = (CuerpoDocumentoItemFactura) cuerpoDocumentoItem;
				result = cuerpoDocumentoItem.validateValues();
				if (!result.equals(Factura.VALIDATION_RESULT_OK))
					error.append(result);			
			}			
		}

		System.out.println("validateValues Finished");


	}
	private void writeToFile (String json, MInvoice invoice)
	{
		try
		{
			absDirectory = (absDirectory.endsWith("/")
					|| absDirectory.endsWith("\\"))
					? absDirectory:absDirectory + "/";
			Path path = Paths.get(absDirectory + invoice.getDateAcct().toString().substring(0, 10) + "/");
			Files.createDirectories(path);
			//java.nio.file.Files;
			Files.createDirectories(path);
			String filename = path +"/" + invoice.getDocumentNo().replace(" ", "") + ".json"; 
			File out = new File (filename);
			Writer fw = new OutputStreamWriter(new FileOutputStream(out, false), "UTF-8");
			fw.write(json);
			fw.flush ();
			fw.close ();
			float size = out.length();
			size /= 1024;
			log.info(out.getAbsolutePath() + " - " + size + " kB");
			System.out.println("Printed To: " + filename);
									
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
  

}