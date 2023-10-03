package org.shw.einvoice.es.factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

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
import org.shw.einvoice.es.fencnotadecreditov1.CuerpoDocumentoItemNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.EmisorNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.IdentificacionNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.ResumenNotaDeCredito;
import org.shw.einvoice.es.util.pojo.EDocumentFactory;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class NotaDeCreditoFactory extends EDocumentFactory {
	NotaDeCredito notaDeCredito;
	MInvoice invoice;
	
	public NotaDeCreditoFactory(String trxName, Properties contextProperties, MClient client, MOrgInfo orgInfo, MInvoice invoice) {
		super(trxName, contextProperties, client, orgInfo);
		this.invoice = invoice;
	}

	public NotaDeCredito generateEDocument() {
		System.out.println("Nota de Credito: start generating and filling the Document");
		String result="";
		notaDeCredito = new NotaDeCredito();

		System.out.println("Instatiate, fill and verify Identificacion");		
		IdentificacionNotaDeCredito identification = notaDeCredito.getIdentificacion();
		if(identification!=null) {
			notaDeCredito.errorMessages.append(notaDeCredito.fillIdentification(jsonInputToFactory));
			result = identification.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				notaDeCredito.errorMessages.append(result);
			}
		}
		
//		List<DocumentoRelacionadoItem> documentoRelacionado = factura.getDocumentoRelacionado();
//		if(documentoRelacionado!=null) {
//			errorMessages.append(factura.fillDocumentoRelacionado(jsonInputToFactory));
//			
//			documentoRelacionado.stream().forEach( documentoRelacionadoItem -> { 
//					String resultLambda = documentoRelacionadoItem.validateValues();
//					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//						errorMessages.append(resultLambda);
//					}
//				} 
//			);
//		}

		System.out.println("Instatiate, fill and verify Emisor");
		EmisorNotaDeCredito emisor = notaDeCredito.getEmisor();
		if(emisor!=null) {
			notaDeCredito.fillEmisor(jsonInputToFactory);
			result = emisor.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				notaDeCredito.errorMessages.append(result);
			}
		}
		
//		List<OtrosDocumentosItem> otrosDocumentos = factura.getOtrosDocumentos();
//		if(otrosDocumentos!=null) {
//			factura.fillOtrosDocumentos(jsonInputToFactory);
//			
//			otrosDocumentos.stream().forEach( otrosDocumentosItem -> { 
//				String resultLambda = otrosDocumentosItem.validateValues();
//					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//						errorMessages.append(resultLambda);
//					}
//				} 
//			);
//		}
		
//		VentaTercero ventaTercero = factura.getVentaTercero();
//		if(ventaTercero!=null) {
//			factura.fillVentaTercero(jsonInputToFactory);
//			result = ventaTercero.validateValues();
//			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//				errorMessages.append(result);
//			}
//		}

		System.out.println("Instatiate, fill and verify Cuerpo Documento");
		List<CuerpoDocumentoItemNotaDeCredito> cuerpoDocumento = notaDeCredito.getCuerpoDocumento();
		if(cuerpoDocumento!=null) {
			notaDeCredito.fillCuerpoDocumento(jsonInputToFactory);
			
			cuerpoDocumento.stream().forEach( cuerpoDocumentoItem -> { 
				String resultLambda = cuerpoDocumentoItem.validateValues();
					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
						notaDeCredito.errorMessages.append(resultLambda);
					}
				} 
			);
		}

		System.out.println("Instatiate, fill and verify Resumen");
		ResumenNotaDeCredito resumen = notaDeCredito.getResumen();
		if(resumen!=null) {
			notaDeCredito.fillResumen(jsonInputToFactory);
			result = resumen.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				notaDeCredito.errorMessages.append(result);
			}
		}
		
//		Extension extension = factura.getExtension();
//		if(extension!=null) {
//			factura.fillExtension(jsonInputToFactory);
//			result = extension.validateValues();
//			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//				errorMessages.append(result);
//			}
//		}
		
//		List<ApendiceItem> apendice = factura.getApendice();
//		if(apendice!=null) {
//			factura.fillApendice(jsonInputToFactory);
//			
//			apendice.stream().forEach( apendiceItem -> { 
//				String resultLambda = apendiceItem.validateValues();
//					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//						errorMessages.append(resultLambda);
//					}
//				} 
//			);
//		}
		
//		Documento documento = eDocument.getDocumento();
//		if(documento!=null) {
//			eDocument.fillDocumento(jsonInputToFactory);
//			result = documento.validateValues();
//			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//				errorMessages.append(result);
//			}
//		}
		
//		Motivo motivo = eDocument.getMotivo();
//		if(documento!=null) {
//			eDocument.fillMotivo(jsonInputToFactory);
//			result = motivo.validateValues();
//			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//				errorMessages.append(result);
//			}
//		}

		notaDeCredito.validateValues();
		if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
			notaDeCredito.errorMessages.append(result);
		}

		System.out.println("Nota de Credito: end generating and filling the Document");	
		return notaDeCredito;
	}

	@Override
	public void generateJSONInputData() {
		jsonInputToFactory = new JSONObject();

		jsonInputToFactory.put(NotaDeCredito.IDENTIFICACION, generateIdentificationInputData());
		jsonInputToFactory.put(NotaDeCredito.RECEPTOR, generateReceptorInputData());
		jsonInputToFactory.put(NotaDeCredito.EMISOR, generateEmisorInputData());
		jsonInputToFactory.put(NotaDeCredito.RESUMEN, generateResumenInputData());
		jsonInputToFactory.put(NotaDeCredito.CUERPODOCUMENTO, generateCuerpoDocumentoInputData());
	}
	
	private JSONObject generateIdentificationInputData() {
		System.out.println("Start collecting JSON data for Identificacion");
		
		Integer invoiceID = invoice.get_ID();
		String numeroControl = getNumeroControl(invoiceID, orgInfo, "DTE-01-");
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(invoiceID.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();
		jsonObjectIdentificacion.put(NotaDeCredito.NUMEROCONTROL, numeroControl);
		jsonObjectIdentificacion.put(NotaDeCredito.CODIGOGENERACION, codigoGeneracion);
		jsonObjectIdentificacion.put(NotaDeCredito.TIPOMODELO, 1);
		jsonObjectIdentificacion.put(NotaDeCredito.TIPOOPERACION, 1);
		jsonObjectIdentificacion.put(NotaDeCredito.FECEMI, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put(NotaDeCredito.HOREMI, "00:00:00");
		jsonObjectIdentificacion.put(NotaDeCredito.TIPOMONEDA, "USD");
		jsonObjectIdentificacion.put(NotaDeCredito.AMBIENTE, "00");

		System.out.println("Finish collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;
		
	}
	
	private JSONObject generateEmisorInputData() {
		System.out.println("Start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put(NotaDeCredito.NIT, orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put(NotaDeCredito.NRC, StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		jsonObjectEmisor.put(NotaDeCredito.NOMBRE, client.getName());
		jsonObjectEmisor.put(NotaDeCredito.CODACTIVIDAD, client.getE_Activity().getValue());
		jsonObjectEmisor.put(NotaDeCredito.DESCACTIVIDAD, client.getE_Activity().getName());
		jsonObjectEmisor.put(NotaDeCredito.NOMBRECOMERCIAL, client.getDescription());
		jsonObjectEmisor.put(NotaDeCredito.TIPOESTABLECIMIENTO, client.getE_PlantType().getValue());

		JSONObject jsonDireccion = new JSONObject();
		jsonDireccion.put(NotaDeCredito.DEPARTAMENTO, orgInfo.getC_Location().getC_City().getC_Region().getValue());
		jsonDireccion.put(NotaDeCredito.MUNICIPIO, orgInfo.getC_Location().getC_City().getValue());
		jsonDireccion.put(NotaDeCredito.COMPLEMENTO, orgInfo.getC_Location().getAddress1());
		jsonObjectEmisor.put(NotaDeCredito.DIRECCION, jsonDireccion);
		
		jsonObjectEmisor.put(NotaDeCredito.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(NotaDeCredito.CORREO, client.getEMail());

		System.out.println("Finish collecting JSON data for Emisor");
		return jsonObjectEmisor;
		
	}
	
	private JSONObject generateReceptorInputData() {
		System.out.println("Start collecting JSON data for Receptor");

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
		if (partner.getE_Activity_ID()<=0 || partner.getE_Recipient_Identification_ID() <= 0) {
			String errorMessage = "Socio de Negocio " + partner.getName() + ": Falta configuracion para NotaDeCreditocion Electronica"; 
			notaDeCredito.errorMessages.append(errorMessage);
			System.out.println(errorMessage);
		}
		
		JSONObject jsonObjectReceptor = new JSONObject();
		
		jsonObjectReceptor.put(NotaDeCredito.TIPODOCUMENTO, partner.getE_Recipient_Identification().getValue());
		jsonObjectReceptor.put(NotaDeCredito.NUMDOCUMENTO, partner.getTaxID().replace("-", ""));
		jsonObjectReceptor.put(NotaDeCredito.NOMBRE, partner.getName());
		
		if (partner.getE_Activity_ID()>0) {
			jsonObjectReceptor.put(NotaDeCredito.CODACTIVIDAD, partner.getE_Activity().getValue());
			jsonObjectReceptor.put(NotaDeCredito.DESCACTIVIDAD, partner.getE_Activity().getName());
		} else  {
			jsonObjectReceptor.put(NotaDeCredito.CODACTIVIDAD, "");
			jsonObjectReceptor.put(NotaDeCredito.DESCACTIVIDAD, "");
		}

		JSONObject jsonDireccion = new JSONObject();
		String departamento = "";
		String municipio = "";
		String complemento = "";
		for (MBPartnerLocation partnerLocation : MBPartnerLocation.getForBPartner(contextProperties, partner.getC_BPartner_ID(), trxName)){
			if (partnerLocation.isBillTo()) {
				departamento = partnerLocation.getC_Location().getC_City().getC_Region().getValue();
				municipio =  partnerLocation.getC_Location().getC_City().getValue();
				complemento = (partnerLocation.getC_Location().getAddress1() + " " + partnerLocation.getC_Location().getAddress2());
				jsonDireccion.put(NotaDeCredito.DEPARTAMENTO, departamento);
				jsonDireccion.put(NotaDeCredito.MUNICIPIO, municipio);
				jsonDireccion.put(NotaDeCredito.COMPLEMENTO, complemento);
				break;
			}
		}		
		
		// In case there is no address
		if (departamento == null) {
			jsonDireccion.put(NotaDeCredito.DEPARTAMENTO, departamento);
			jsonDireccion.put(NotaDeCredito.MUNICIPIO, municipio);
			jsonDireccion.put(NotaDeCredito.COMPLEMENTO, complemento);
		}		
		jsonObjectReceptor.put(NotaDeCredito.DIRECCION, jsonDireccion);
		
		jsonObjectReceptor.put(NotaDeCredito.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectReceptor.put(NotaDeCredito.CORREO, partner.get_ValueAsString("EMail"));		

		System.out.println("Finish collecting JSON data for Receptor");
		return jsonObjectReceptor;
		
	}
	
	private JSONObject generateResumenInputData() {
		System.out.println("Start collecting JSON data for Resumen");
		BigDecimal totalNoSuj 	= Env.ZERO;
		BigDecimal totalExenta 	= Env.ZERO;
		BigDecimal totalGravada = Env.ZERO;		
		BigDecimal totalIVA 	= Env.ZERO;
		
		String totalLetras=Msg.getAmtInWords(Env.getLanguage(contextProperties), invoice.getGrandTotal().setScale(2).toString());

		List<MInvoiceTax> invoiceTaxes = new Query(contextProperties , MInvoiceTax.Table_Name , "C_Invoice_ID=?" , trxName)
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
		jsonObjectResumen.put(NotaDeCredito.TOTALNOSUJ, totalNoSuj);
		jsonObjectResumen.put(NotaDeCredito.TOTALEXENTA, totalExenta);
		jsonObjectResumen.put(NotaDeCredito.TOTALGRAVADA, totalGravada);
		jsonObjectResumen.put(NotaDeCredito.SUBTOTALVENTAS, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(NotaDeCredito.DESCUNOSUJ, Env.ZERO);
		jsonObjectResumen.put(NotaDeCredito.DESCUEXENTA, Env.ZERO);
		jsonObjectResumen.put(NotaDeCredito.DESCUGRAVADA, Env.ZERO);
		jsonObjectResumen.put(NotaDeCredito.PORCENTAJEDESCUENTO, Env.ZERO);
		jsonObjectResumen.put(NotaDeCredito.SUBTOTAL, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(NotaDeCredito.IVARETE1, Env.ZERO);
		jsonObjectResumen.put(NotaDeCredito.MONTOTOTALOPERACION, invoice.getGrandTotal());
		jsonObjectResumen.put(NotaDeCredito.TOTALNOGRAVADO, totalExenta.add(totalNoSuj));
		jsonObjectResumen.put(NotaDeCredito.TOTALPAGAR, invoice.getGrandTotal());
		jsonObjectResumen.put(NotaDeCredito.TOTALLETRAS, totalLetras);
		jsonObjectResumen.put(NotaDeCredito.SALDOFAVOR, invoice.getGrandTotal());
		jsonObjectResumen.put(NotaDeCredito.CONDICIONOPERACION, 1);
		jsonObjectResumen.put(NotaDeCredito.TOTALDESCU, Env.ZERO);
		jsonObjectResumen.put(NotaDeCredito.RETERENTA, Env.ZERO);
		jsonObjectResumen.put(NotaDeCredito.TOTALIVA, totalIVA);

		JSONArray jsonArrayPagos = new JSONArray();
			JSONObject jsonPago = new JSONObject();
			jsonPago.put(NotaDeCredito.CODIGO, "05");
			jsonPago.put(NotaDeCredito.MONTOPAGO, new BigDecimal(0.00));
			jsonPago.put(NotaDeCredito.REFERENCIA, "Transferencia_ Depósito Bancario");
			jsonPago.put(NotaDeCredito.PLAZO, invoice.getC_PaymentTerm().getE_TimeSpan().getValue());
			jsonPago.put(NotaDeCredito.PERIODO, invoice.getC_PaymentTerm().getNetDays());
		jsonArrayPagos.put(jsonPago);

		jsonObjectResumen.put(NotaDeCredito.PAGOS, jsonArrayPagos);
		
		System.out.println("Finish collecting JSON data for Resumen");
		return jsonObjectResumen;
		
	}
	
	private JSONObject generateCuerpoDocumentoInputData() {
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
                
			jsonCuerpoDocumentoItem.put(NotaDeCredito.NUMITEM, invoiceLine.getLine());
			jsonCuerpoDocumentoItem.put(NotaDeCredito.TIPOITEM, 2);
			jsonCuerpoDocumentoItem.put(NotaDeCredito.NUMERODOCUMENTO, getNumeroControl(invoice.get_ID(), orgInfo, "DTE-01-"));
			jsonCuerpoDocumentoItem.put(NotaDeCredito.CANTIDAD, invoiceLine.getQtyInvoiced());
			jsonCuerpoDocumentoItem.put(NotaDeCredito.CODIGO, invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(NotaDeCredito.CODIGOTRIBUTO, "");  // String codTributo = "20";
			
			JSONArray jsonTributosArray = new JSONArray();
			jsonCuerpoDocumentoItem. put( NotaDeCredito.TRIBUTOS, jsonTributosArray); //tributosItems.add("20");
			
			jsonCuerpoDocumentoItem.put(NotaDeCredito.UNIMEDIDA, 1);
			jsonCuerpoDocumentoItem.put(NotaDeCredito.DESCRIPCION, invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(NotaDeCredito.PRECIOUNI, invoiceLine.getPriceActual());
			jsonCuerpoDocumentoItem.put(NotaDeCredito.MONTODESCU, Env.ZERO);
			jsonCuerpoDocumentoItem.put(NotaDeCredito.VENTANOSUJ, ventaNoSuj);
			jsonCuerpoDocumentoItem.put(NotaDeCredito.VENTAEXENTA, ventaExenta);
			jsonCuerpoDocumentoItem.put(NotaDeCredito.VENTAGRAVADA, ventaGravada);
			jsonCuerpoDocumentoItem.put(NotaDeCredito.PSV, invoiceLine.getTaxAmt());
			jsonCuerpoDocumentoItem.put(NotaDeCredito.NOGRAVADO, ventaNoSuj.add(ventaNoSuj));
			jsonCuerpoDocumentoItem.put(NotaDeCredito.IVAITEM, ivaItem);

			jsonCuerpoDocumentoArray.put(jsonCuerpoDocumentoItem);
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() + " Finished");

		}  
		
		jsonCuerpoDocumento.put(NotaDeCredito.CUERPODOCUMENTO, jsonCuerpoDocumentoArray);
		System.out.println("Finish collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		
		return jsonCuerpoDocumento;
	}

	public String createJsonString() throws Exception {
		System.out.println("Nota de Credito: start generating JSON object from Document");
    	ObjectMapper objectMapper = new ObjectMapper();
    	String facturaAsString    = objectMapper.writeValueAsString(notaDeCredito);
        JSONObject  facturaAsJson = new JSONObject(facturaAsString);
        
        facturaAsJson.remove(NotaDeCredito.DOCUMENTORELACIONADO);
        facturaAsJson.remove(NotaDeCredito.OTROSDOCUMENTOS);
        facturaAsJson.remove(NotaDeCredito.RECEPTOR);
        facturaAsJson.remove(NotaDeCredito.VENTATERCERO);        
        facturaAsJson.remove(NotaDeCredito.EXTENSION);
        facturaAsJson.remove(NotaDeCredito.APENDICE);
        facturaAsJson.remove(NotaDeCredito.DOCUMENTO);
        facturaAsJson.remove(NotaDeCredito.MOTIVO);
        facturaAsJson.remove(NotaDeCredito.ERRORMESSAGES);

        facturaAsJson.getJSONObject(NotaDeCredito.IDENTIFICACION).remove("horAnula");
        facturaAsJson.getJSONObject(NotaDeCredito.IDENTIFICACION).remove("motivoContigencia");
        facturaAsJson.getJSONObject(NotaDeCredito.IDENTIFICACION).remove("fecAnula");
        facturaAsJson.getJSONObject(NotaDeCredito.IDENTIFICACION).remove("motivoContingencia");

        facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("seguro");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("totalSujetoRetencion");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("tributos");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("tributosNotaDeCredito");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("numPagoElectronico");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("flete");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("ivaPerci1");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("descuento");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("codIncoterms");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("totalIVAretenidoLetras");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("descIncoterms");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("observaciones");
		facturaAsJson.getJSONObject(NotaDeCredito.RESUMEN).remove("totalIVAretenido");

		facturaAsJson.getJSONObject(NotaDeCredito.CUERPODOCUMENTO).remove("numDocumento");
		facturaAsJson.getJSONObject(NotaDeCredito.CUERPODOCUMENTO).remove("fechaEmision");
		facturaAsJson.getJSONObject(NotaDeCredito.CUERPODOCUMENTO).remove("tributos");
		facturaAsJson.getJSONObject(NotaDeCredito.CUERPODOCUMENTO).remove("codTributo");
		facturaAsJson.getJSONObject(NotaDeCredito.CUERPODOCUMENTO).remove("codigoRetencionMH");
		facturaAsJson.getJSONObject(NotaDeCredito.CUERPODOCUMENTO).remove("montoSujetoGrav");
		facturaAsJson.getJSONObject(NotaDeCredito.CUERPODOCUMENTO).remove(" ivaRetenido");
		facturaAsJson.getJSONObject(NotaDeCredito.CUERPODOCUMENTO).remove("tipoDte");

		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("codigo");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("puntoVentaMH");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("direccion");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("codEstable");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("codPuntoVenta");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("codigoMH");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("codEstableMH");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("puntoVenta");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("recintoFiscal");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("regimen");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("nomEstablecimiento");
		facturaAsJson.getJSONObject(NotaDeCredito.EMISOR).remove("codPuntoVentaMH");

        String finalNotaDeCreditoAsString = objectMapper.writeValueAsString(facturaAsJson);
		System.out.println("Nota de Credito: end generating JSON object from Document");
		return finalNotaDeCreditoAsString;
	}

	public String getNumeroControl(Integer id, MOrgInfo orgInfo, String prefix) {
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		String numeroControl = prefix + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		return numeroControl;
	}
	

	@Override
	public StringBuffer getEDocumentErrorMessages() {
		 return notaDeCredito.errorMessages;
	 }
	
	public boolean writeToFile (String json, MInvoice invoice, String directory) {
		System.out.println("Nota de Credito: start writing to file");
		try
		{
			Path rootpath = Paths.get(directory);
			if (!Files.exists(rootpath)) {
				return false;
			}    	

			directory = (directory.endsWith("/")
					|| directory.endsWith("\\"))
					? directory:directory + "/";
			Path path = Paths.get(directory + invoice.getDateAcct().toString().substring(0, 10) + "/");
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
			System.out.println("File size: " + out.getAbsolutePath() + " - " + size + " kB");
			System.out.println("Printed To: " + filename);
			System.out.println("Nota de Credito: end writing to file");
			return true;
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	boolean deleteJsonNOde(JsonNode node) {
        if(! node.isEmpty()) {
            ((ObjectNode) node).removeAll();
            return true;
        }
       return false;
	}
}
