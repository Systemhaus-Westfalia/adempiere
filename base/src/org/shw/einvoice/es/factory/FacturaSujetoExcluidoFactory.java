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
import org.compiere.model.MOrgInfo;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.TimeUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.shw.einvoice.es.anulacionv2.Anulacion;
import org.shw.einvoice.es.fefsefacturasujetoexcluido.CuerpoDocumentoItemFacturaSujetoExcluido;
import org.shw.einvoice.es.fefsefacturasujetoexcluido.EmisorFacturaSujetoExcluido;
import org.shw.einvoice.es.fefsefacturasujetoexcluido.FacturaSujetoExcluido;
import org.shw.einvoice.es.fefsefacturasujetoexcluido.IdentificacionFacturaSujetoExcluido;
import org.shw.einvoice.es.fefsefacturasujetoexcluido.ResumenFacturaSujetoExcluido;
import org.shw.einvoice.es.fefsefacturasujetoexcluido.SujetoExcluidoFacturaSujetoExcluido;
import org.shw.einvoice.es.util.pojo.EDocumentFactory;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;
import org.shw.model.MLCOInvoiceWithholding;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FacturaSujetoExcluidoFactory extends EDocumentFactory {
	FacturaSujetoExcluido facturaSujetoExcluido;
	MInvoice invoice;
	
	public FacturaSujetoExcluidoFactory(String trxName, Properties contextProperties, MClient client, MOrgInfo orgInfo, MInvoice invoice) {
		super(trxName, contextProperties, client, orgInfo);
		this.invoice = invoice;
		facturaSujetoExcluido = new FacturaSujetoExcluido();
		}

	public FacturaSujetoExcluido generateEDocument() {
		System.out.println("Factura: start generating and filling the Document");
		String result="";
		facturaSujetoExcluido = new FacturaSujetoExcluido();

		System.out.println("Instatiate, fill and verify Identificacion");
		IdentificacionFacturaSujetoExcluido identification = facturaSujetoExcluido.getIdentificacion();
		if(identification!=null) {
			facturaSujetoExcluido.errorMessages.append(facturaSujetoExcluido.fillIdentification(jsonInputToFactory));
			result = identification.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				facturaSujetoExcluido.errorMessages.append(result);
			}
		}
		

		System.out.println("Instatiate, fill and verify Sujeto Excluido");
		SujetoExcluidoFacturaSujetoExcluido sujetoExcluido = facturaSujetoExcluido.getSujetoExcluido();
		if(sujetoExcluido!=null) {
			facturaSujetoExcluido.errorMessages.append(facturaSujetoExcluido.fillSujetoExcluido(jsonInputToFactory));
			result = sujetoExcluido.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				facturaSujetoExcluido.errorMessages.append(result);
			}
		}
		
//		List<DocumentoRelacionadoItem> documentoRelacionado = facturaNoSujeto.getDocumentoRelacionado();
//		if(documentoRelacionado!=null) {
//			errorMessages.append(facturaNoSujeto.fillDocumentoRelacionado(jsonInputToFactory));
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
		EmisorFacturaSujetoExcluido emisor = facturaSujetoExcluido.getEmisor();
		if(emisor!=null) {
			facturaSujetoExcluido.fillEmisor(jsonInputToFactory);
			result = emisor.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				facturaSujetoExcluido.errorMessages.append(result);
			}
		}
		
//		List<OtrosDocumentosItem> otrosDocumentos = facturaNoSujeto.getOtrosDocumentos();
//		if(otrosDocumentos!=null) {
//			facturaNoSujeto.fillOtrosDocumentos(jsonInputToFactory);
//			
//			otrosDocumentos.stream().forEach( otrosDocumentosItem -> { 
//				String resultLambda = otrosDocumentosItem.validateValues();
//					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//						errorMessages.append(resultLambda);
//					}
//				} 
//			);
//		}
		
//		VentaTercero ventaTercero = facturaNoSujeto.getVentaTercero();
//		if(ventaTercero!=null) {
//			facturaNoSujeto.fillVentaTercero(jsonInputToFactory);
//			result = ventaTercero.validateValues();
//			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//				errorMessages.append(result);
//			}
//		}

		System.out.println("Instatiate, fill and verify Cuerpo Documento");
		List<CuerpoDocumentoItemFacturaSujetoExcluido> cuerpoDocumento = facturaSujetoExcluido.getCuerpoDocumento();
		if(cuerpoDocumento!=null) {
			facturaSujetoExcluido.fillCuerpoDocumento(jsonInputToFactory);
			
			cuerpoDocumento.stream().forEach( cuerpoDocumentoItem -> { 
				String resultLambda = cuerpoDocumentoItem.validateValues();
					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
						facturaSujetoExcluido.errorMessages.append(resultLambda);
					}
				} 
			);
		}

		System.out.println("Instatiate, fill and verify Resumen");
		ResumenFacturaSujetoExcluido resumen = facturaSujetoExcluido.getResumen();
		if(resumen!=null) {
			facturaSujetoExcluido.fillResumen(jsonInputToFactory);
			result = resumen.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				facturaSujetoExcluido.errorMessages.append(result);
			}
		}
		
//
//		System.out.println("Instatiate, fill and verify Receptor");
//		ReceptorFacturaSujetoExcluido receptor = facturaSujetoExcluido.getReceptor();
//		if(receptor!=null) {
//			facturaSujetoExcluido.fillReceptor(jsonInputToFactory);
//			result = receptor.validateValues();
//			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//				facturaSujetoExcluido.errorMessages.append(result);
//			}
//		}
		
//		Extension extension = facturaNoSujeto.getExtension();
//		if(extension!=null) {
//			facturaNoSujeto.fillExtension(jsonInputToFactory);
//			result = extension.validateValues();
//			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
//				errorMessages.append(result);
//			}
//		}
		
//		List<ApendiceItem> apendice = facturaNoSujeto.getApendice();
//		if(apendice!=null) {
//			facturaNoSujeto.fillApendice(jsonInputToFactory);
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

		facturaSujetoExcluido.validateValues();
		if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
			facturaSujetoExcluido.errorMessages.append(result);
		}

		System.out.println("Factura: end generating and filling the Document");
		return facturaSujetoExcluido;
	}

	@Override
	public void generateJSONInputData() {
		System.out.println("Factura Sujeto Exluido: start collecting JSON data for all components");
		jsonInputToFactory = new JSONObject();

		jsonInputToFactory.put(FacturaSujetoExcluido.IDENTIFICACION, generateIdentificationInputData());
		jsonInputToFactory.put(FacturaSujetoExcluido.SUJETOEXCLUIDO, generateSujetoExcluidoInputData());
		jsonInputToFactory.put(FacturaSujetoExcluido.EMISOR, generateEmisorInputData());
		jsonInputToFactory.put(FacturaSujetoExcluido.RESUMEN, generateResumenInputData());
		jsonInputToFactory.put(FacturaSujetoExcluido.CUERPODOCUMENTO, generateCuerpoDocumentoInputData());
		
		System.out.println("Generated JSON object from Invoice:");
		System.out.println(jsonInputToFactory.toString());
		System.out.println("Factura: end collecting JSON data for all components");
	}
	
	private JSONObject generateIdentificationInputData() {
		System.out.println("Factura: start collecting JSON data for Identificacion");

		String prefix = invoice.getC_DocType().getDefiniteSequence().getPrefix();
		String documentno = invoice.getDocumentNo().replace(prefix,"");
		int position = documentno.indexOf("_");
		if (position >=0)
			documentno = documentno.substring(0,position);
		String idIdentification  = StringUtils.leftPad(documentno, 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		
		String numeroControl = "DTE-" + invoice.getC_DocType().getE_DocType().getValue()
				+ "-"+ StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		Integer invoiceID = invoice.get_ID();
		//String numeroControl = getNumeroControl(invoiceID, orgInfo, "DTE-01-");
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(invoiceID.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();
		Boolean isContigencia = false;
		if (TimeUtil.getDaysBetween(invoice.getDateAcct(), TimeUtil.getDay(0))>=3) {
			isContigencia = true;
		}

		int tipoModelo = isContigencia?FacturaSujetoExcluido.TIPOMODELO_CONTIGENCIA:FacturaSujetoExcluido.TIPOMODELO_NOCONTIGENCIA;
		int tipoOperacion = isContigencia?FacturaSujetoExcluido.TIPOOPERACION_CONTIGENCIA:FacturaSujetoExcluido.TIPOOPERACION_NOCONTIGENCIA;
		jsonObjectIdentificacion.put(FacturaSujetoExcluido.NUMEROCONTROL, numeroControl);
		jsonObjectIdentificacion.put(FacturaSujetoExcluido.CODIGOGENERACION, codigoGeneracion);
		jsonObjectIdentificacion.put(FacturaSujetoExcluido.TIPOMODELO, tipoModelo);
		jsonObjectIdentificacion.put(FacturaSujetoExcluido.TIPOOPERACION, tipoOperacion);
		jsonObjectIdentificacion.put(FacturaSujetoExcluido.FECEMI, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put(FacturaSujetoExcluido.HOREMI, "00:00:00");
		jsonObjectIdentificacion.put(FacturaSujetoExcluido.TIPOMONEDA, "USD");
		jsonObjectIdentificacion.put(FacturaSujetoExcluido.AMBIENTE, client.getE_Enviroment().getValue());
		
		if (isContigencia) {
			jsonObjectIdentificacion.put(FacturaSujetoExcluido.MOTIVOCONTIN, "Contigencia por fecha de facturaNoSujeto");
			jsonObjectIdentificacion.put(FacturaSujetoExcluido.TIPOCONTINGENCIA, 5);
		}
		
		System.out.println("Factura: end collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;
		
	}
	
	private JSONObject generateEmisorInputData() {
		System.out.println("Factura: start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put(FacturaSujetoExcluido.NIT, orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put(FacturaSujetoExcluido.NRC, StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		jsonObjectEmisor.put(FacturaSujetoExcluido.NOMBRE, client.getName());
		jsonObjectEmisor.put(FacturaSujetoExcluido.CODACTIVIDAD, client.getE_Activity().getValue());
		jsonObjectEmisor.put(FacturaSujetoExcluido.DESCACTIVIDAD, client.getE_Activity().getName());

		JSONObject jsonDireccion = new JSONObject();
		jsonDireccion.put(FacturaSujetoExcluido.DEPARTAMENTO, orgInfo.getC_Location().getC_City().getC_Region().getValue());
		jsonDireccion.put(FacturaSujetoExcluido.MUNICIPIO, orgInfo.getC_Location().getC_City().getValue());
		jsonDireccion.put(FacturaSujetoExcluido.COMPLEMENTO, orgInfo.getC_Location().getAddress1());
		jsonObjectEmisor.put(FacturaSujetoExcluido.DIRECCION, jsonDireccion);
		
		jsonObjectEmisor.put(FacturaSujetoExcluido.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(FacturaSujetoExcluido.CORREO, client.getEMail());
		jsonObjectEmisor.put(FacturaSujetoExcluido.CODESTABLEMH, "");								// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(FacturaSujetoExcluido.CODESTABLE, client.getE_PlantType_ID());								// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(FacturaSujetoExcluido.CODPUNTOVENTAMH, "");							// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(FacturaSujetoExcluido.CODPUNTOVENTA, "");							// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(FacturaSujetoExcluido.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(FacturaSujetoExcluido.CORREO, client.getEMail());


		System.out.println("Factura: end collecting JSON data for Emisor");
		return jsonObjectEmisor;
		
	}
	private JSONObject generateSujetoExcluidoInputData() {
		System.out.println("Factura: start collecting JSON data for Sujeto Excluido");

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
		if (partner.getE_Activity_ID()<=0 || partner.getE_Recipient_Identification_ID() <= 0) {
			String errorMessage = "Socio de Negocio " + partner.getName() + ": Falta configuracion para Facturacion Electronica"; 
			facturaSujetoExcluido.errorMessages.append(errorMessage);
			System.out.println(errorMessage);
		}
		
		JSONObject jsonObjectSujetoExcluido = new JSONObject();
		
		jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.TIPODOCUMENTO, partner.getE_Recipient_Identification().getValue());
		if (partner.getTaxID() != null) {
			jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.NUMDOCUMENTO, partner.getTaxID().replace("-", ""));
			jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.NOMBRE, partner.getName());			
		}
		else {
			String errorMessage = "Socio de Negocio " + partner.getName() + ": Falta NIT"; 
			facturaSujetoExcluido.errorMessages.append(errorMessage);
			System.out.println(errorMessage);
		}
		
		if (partner.getE_Activity_ID()>0) {
			jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.CODACTIVIDAD, partner.getE_Activity().getValue());
			jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.DESCACTIVIDAD, partner.getE_Activity().getName());
		} else  {
			jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.CODACTIVIDAD, "");
			jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.DESCACTIVIDAD, "");
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
				jsonDireccion.put(FacturaSujetoExcluido.DEPARTAMENTO, departamento);
				jsonDireccion.put(FacturaSujetoExcluido.MUNICIPIO, municipio);
				jsonDireccion.put(FacturaSujetoExcluido.COMPLEMENTO, complemento);
				break;
			}
		}		
		
		// In case there is no address
		if (departamento == null) {
			jsonDireccion.put(FacturaSujetoExcluido.DEPARTAMENTO, departamento);
			jsonDireccion.put(FacturaSujetoExcluido.MUNICIPIO, municipio);
			jsonDireccion.put(FacturaSujetoExcluido.COMPLEMENTO, complemento);
		}		
		jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.DIRECCION, jsonDireccion);
		
		jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectSujetoExcluido.put(FacturaSujetoExcluido.CORREO, partner.get_ValueAsString("EMail"));		

		System.out.println("Factura: end collecting JSON data for Receptor");
		return jsonObjectSujetoExcluido;
		
	}
	
	private JSONObject generateResumenInputData() {
		System.out.println("Factura Sujeto Excluido: start collecting JSON data for Resumen");
		BigDecimal 			totalDescu 	= Env.ZERO;
		BigDecimal 			ivaRete1	= Env.ZERO;
		BigDecimal 			reteRenta 	= Env.ZERO;
		BigDecimal 			totalCompra	= invoice.getGrandTotal();
		BigDecimal			descu		= Env.ZERO;
		BigDecimal			subTotal	= invoice.getGrandTotal();

		String 	   			totalLetras;
		
		totalLetras=Msg.getAmtInWords(Env.getLanguage(contextProperties), invoice.getGrandTotal().setScale(2).toString());

		
				
		JSONObject jsonObjectResumen = new JSONObject();
		

		JSONArray jsonTributosArray = new JSONArray();
		List<MLCOInvoiceWithholding> invoiceWithholdings = new Query(contextProperties, MLCOInvoiceWithholding.Table_Name, 
				"C_Invoice_ID=?", trxName)
				.setParameters(invoice.getC_Invoice_ID())
				.list();
		for (MLCOInvoiceWithholding invoiceWithholding:invoiceWithholdings) {
			reteRenta = reteRenta.add(invoiceWithholding.getTaxAmt());
			subTotal = totalCompra.add(invoiceWithholding.getTaxAmt());
		}
		// (!jsonTributosArray.isEmpty())
		jsonObjectResumen.put(FacturaSujetoExcluido.TRIBUTOS, jsonTributosArray);
		
		
		jsonObjectResumen.put(FacturaSujetoExcluido.IVARETE1, ivaRete1);
		jsonObjectResumen.put(FacturaSujetoExcluido.MONTOTOTALOPERACION, invoice.getGrandTotal());
		jsonObjectResumen.put(FacturaSujetoExcluido.TOTALPAGAR, invoice.getGrandTotal());
		jsonObjectResumen.put(FacturaSujetoExcluido.TOTALLETRAS, totalLetras);		
		jsonObjectResumen.put(FacturaSujetoExcluido.CONDICIONOPERACION, FacturaSujetoExcluido.CONDICIONOPERACION_A_CREDITO);
		jsonObjectResumen.put(FacturaSujetoExcluido.TOTALDESCU, totalDescu);
		jsonObjectResumen.put(FacturaSujetoExcluido.DESCU, descu);
		jsonObjectResumen.put(FacturaSujetoExcluido.RETERENTA, reteRenta);
		jsonObjectResumen.put(FacturaSujetoExcluido.TOTALCOMPRA, totalCompra);
		jsonObjectResumen.put(FacturaSujetoExcluido.SUBTOTAL, subTotal);
		jsonObjectResumen.put(FacturaSujetoExcluido.OBSERVACIONES, invoice.getDescription());

		JSONArray jsonArrayPagos = new JSONArray();
			JSONObject jsonPago = new JSONObject();
			jsonPago.put(FacturaSujetoExcluido.CODIGO, "05");
			jsonPago.put(FacturaSujetoExcluido.MONTOPAGO, invoice.getGrandTotal());
			jsonPago.put(FacturaSujetoExcluido.REFERENCIA, "Transferencia_ Depósito Bancario");
			jsonPago.put(FacturaSujetoExcluido.PLAZO, invoice.getC_PaymentTerm().getE_TimeSpan().getValue());
			jsonPago.put(FacturaSujetoExcluido.PERIODO, invoice.getC_PaymentTerm().getNetDays());
		jsonArrayPagos.put(jsonPago);
		
		

		jsonObjectResumen.put(FacturaSujetoExcluido.PAGOS, jsonArrayPagos);

		

		System.out.println("Factura: end collecting JSON data for Resumen");
		return jsonObjectResumen;
		
	}
	
	private JSONObject generateCuerpoDocumentoInputData() {
		System.out.println("Factura: start collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		JSONObject jsonCuerpoDocumento = new JSONObject();
		JSONArray jsonCuerpoDocumentoArray = new JSONArray();
		
		for (MInvoiceLine invoiceLine:invoice.getLines()) { 
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() );
			
			BigDecimal compra 	= Env.ZERO;
			String description = invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName();
			String codigo = invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName();
			compra = invoiceLine.getLineTotalAmt();
			
			JSONObject jsonCuerpoDocumentoItem = new JSONObject();
                
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.NUMITEM, invoiceLine.getLine()/10);
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.TIPOITEM, 2);
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.CANTIDAD, invoiceLine.getQtyInvoiced());
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.CODIGO, codigo.substring(0,10));
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.UNIMEDIDA, 1);
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.DESCRIPCION, description);
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.PRECIOUNI, invoiceLine.getPriceActual());
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.MONTODESCU, Env.ZERO);
			jsonCuerpoDocumentoItem.put(FacturaSujetoExcluido.COMPRA, compra);

			jsonCuerpoDocumentoArray.put(jsonCuerpoDocumentoItem);
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() + " Finished");

		}  
		jsonCuerpoDocumento.put(FacturaSujetoExcluido.CUERPODOCUMENTO, jsonCuerpoDocumentoArray);
		System.out.println("Factura: end collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		
		return jsonCuerpoDocumento;
	}

	public String createJsonString() throws Exception {
		System.out.println("Factura: start generating JSON object from Document");
    	ObjectMapper objectMapper = new ObjectMapper();
    	String facturaAsStringTmp = objectMapper.writeValueAsString(facturaSujetoExcluido);
        JSONObject facturaAsJson  = new JSONObject(facturaAsStringTmp);
        
        facturaAsJson.remove(FacturaSujetoExcluido.ERRORMESSAGES);

     // Manipulate generated JSON string
        String facturaAsStringFinal = facturaAsJson.toString().
        		replace(":[],", ":null,").
        		replace("\"documentoRelacionado\":[]", "\"documentoRelacionado\":null").
        		replace("\"ventaTercero\":{\"nit\":null,\"nombre\":null},", "\"ventaTercero\":null,").
        		replace("\"tributos\":[{\"descripcion\":null,\"codigo\":null,\"valor\":null}]", "\"tributos\":null").
        		replace("\"extension\":{\"docuEntrega\":null,\"placaVehiculo\":null,\"observaciones\":null,\"nombRecibe\":null,\"nombEntrega\":null,\"docuRecibe\":null},", 
        				"\"extension\":null,").
        		replace(",\"documentoRelacionado\":null","");

		System.out.println("Factura: generated JSON object from Document:");
		System.out.println(facturaAsStringFinal);
		System.out.println("Factura: end generating JSON object from Document");
		return facturaAsStringFinal;
	}

	public String getNumeroControl(Integer id, MOrgInfo orgInfo, String prefix) {
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		String numeroControl = prefix + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		return numeroControl;
	}
	

	@Override
	public StringBuffer getEDocumentErrorMessages() {
		 return facturaSujetoExcluido.errorMessages;
	 }
	
	public boolean writeToFile (String json, MInvoice invoice, String directory) {
		System.out.println("Factura: start writing to file");
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
			System.out.println("Factura: end writing to file");
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
