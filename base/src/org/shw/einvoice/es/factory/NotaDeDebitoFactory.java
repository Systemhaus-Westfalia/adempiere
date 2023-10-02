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
import org.shw.einvoice.es.fendnotadedebitov3.CuerpoDocumentoItemNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.EmisorNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.IdentificacionNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.ResumenNotaDeDebito;
import org.shw.einvoice.es.util.pojo.EDocumentFactory;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class NotaDeDebitoFactory extends EDocumentFactory {
	NotaDeDebito notaDeDebito;
	MInvoice invoice;
	
	public NotaDeDebitoFactory(String trxName, Properties contextProperties, MClient client, MOrgInfo orgInfo, MInvoice invoice) {
		super(trxName, contextProperties, client, orgInfo);
		this.invoice = invoice;
	}

	public NotaDeDebito generateEDocument() {
		String result="";
		notaDeDebito = new NotaDeDebito();
		
		IdentificacionNotaDeDebito identification = notaDeDebito.getIdentificacion();
		if(identification!=null) {
			notaDeDebito.errorMessages.append(notaDeDebito.fillIdentification(jsonInputToFactory));
			result = identification.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				notaDeDebito.errorMessages.append(result);
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
		
		EmisorNotaDeDebito emisor = notaDeDebito.getEmisor();
		if(emisor!=null) {
			notaDeDebito.fillEmisor(jsonInputToFactory);
			result = emisor.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				notaDeDebito.errorMessages.append(result);
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
		
		List<CuerpoDocumentoItemNotaDeDebito> cuerpoDocumento = notaDeDebito.getCuerpoDocumento();
		if(cuerpoDocumento!=null) {
			notaDeDebito.fillCuerpoDocumento(jsonInputToFactory);
			
			cuerpoDocumento.stream().forEach( cuerpoDocumentoItem -> { 
				String resultLambda = cuerpoDocumentoItem.validateValues();
					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
						notaDeDebito.errorMessages.append(resultLambda);
					}
				} 
			);
		}
		
		ResumenNotaDeDebito resumen = notaDeDebito.getResumen();
		if(resumen!=null) {
			notaDeDebito.fillResumen(jsonInputToFactory);
			result = resumen.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				notaDeDebito.errorMessages.append(result);
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

		notaDeDebito.validateValues();
		if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
			notaDeDebito.errorMessages.append(result);
		}
		
		return notaDeDebito;
	}

	@Override
	public void generateJSONInputData() {
		jsonInputToFactory = new JSONObject();

		jsonInputToFactory.put(NotaDeDebito.IDENTIFICACION, generateIdentificationInputData());
		jsonInputToFactory.put(NotaDeDebito.RECEPTOR, generateReceptorInputData());
		jsonInputToFactory.put(NotaDeDebito.EMISOR, generateEmisorInputData());
		jsonInputToFactory.put(NotaDeDebito.RESUMEN, generateResumenInputData());
		jsonInputToFactory.put(NotaDeDebito.CUERPODOCUMENTO, generateCuerpoDocumentoInputData());
	}
	
	private JSONObject generateIdentificationInputData() {
		System.out.println("Start collecting JSON data for Identificacion");
		
		Integer invoiceID = invoice.get_ID();
		String numeroControl = getNumeroControl(invoiceID, orgInfo, "DTE-01-");
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(invoiceID.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();
		jsonObjectIdentificacion.put(NotaDeDebito.NUMEROCONTROL, numeroControl);
		jsonObjectIdentificacion.put(NotaDeDebito.CODIGOGENERACION, codigoGeneracion);
		jsonObjectIdentificacion.put(NotaDeDebito.TIPOMODELO, 1);
		jsonObjectIdentificacion.put(NotaDeDebito.TIPOOPERACION, 1);
		jsonObjectIdentificacion.put(NotaDeDebito.FECEMI, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put(NotaDeDebito.HOREMI, "00:00:00");
		jsonObjectIdentificacion.put(NotaDeDebito.TIPOMONEDA, "USD");
		jsonObjectIdentificacion.put(NotaDeDebito.AMBIENTE, "00");

		System.out.println("Finish collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;
		
	}
	
	private JSONObject generateEmisorInputData() {
		System.out.println("Start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put(NotaDeDebito.NIT, orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put(NotaDeDebito.NRC, StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		jsonObjectEmisor.put(NotaDeDebito.NOMBRE, client.getName());
		jsonObjectEmisor.put(NotaDeDebito.CODACTIVIDAD, client.getE_Activity().getValue());
		jsonObjectEmisor.put(NotaDeDebito.DESCACTIVIDAD, client.getE_Activity().getName());
		jsonObjectEmisor.put(NotaDeDebito.NOMBRECOMERCIAL, client.getDescription());
		jsonObjectEmisor.put(NotaDeDebito.TIPOESTABLECIMIENTO, client.getE_PlantType().getValue());

		JSONObject jsonDireccion = new JSONObject();
		jsonDireccion.put(NotaDeDebito.DEPARTAMENTO, orgInfo.getC_Location().getC_City().getC_Region().getValue());
		jsonDireccion.put(NotaDeDebito.MUNICIPIO, orgInfo.getC_Location().getC_City().getValue());
		jsonDireccion.put(NotaDeDebito.COMPLEMENTO, orgInfo.getC_Location().getAddress1());
		jsonObjectEmisor.put(NotaDeDebito.DIRECCION, jsonDireccion);
		
		jsonObjectEmisor.put(NotaDeDebito.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(NotaDeDebito.CORREO, client.getEMail());

		System.out.println("Finish collecting JSON data for Emisor");
		return jsonObjectEmisor;
		
	}
	
	private JSONObject generateReceptorInputData() {
		System.out.println("Start collecting JSON data for Receptor");

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
		if (partner.getE_Activity_ID()<=0 || partner.getE_Recipient_Identification_ID() <= 0) {
			String errorMessage = "Socio de Negocio " + partner.getName() + ": Falta configuracion para NotaDeDebitocion Electronica"; 
			notaDeDebito.errorMessages.append(errorMessage);
			System.out.println(errorMessage);
		}
		
		JSONObject jsonObjectReceptor = new JSONObject();
		
		jsonObjectReceptor.put(NotaDeDebito.TIPODOCUMENTO, partner.getE_Recipient_Identification().getValue());
		jsonObjectReceptor.put(NotaDeDebito.NUMDOCUMENTO, partner.getTaxID().replace("-", ""));
		jsonObjectReceptor.put(NotaDeDebito.NOMBRE, partner.getName());
		
		if (partner.getE_Activity_ID()>0) {
			jsonObjectReceptor.put(NotaDeDebito.CODACTIVIDAD, partner.getE_Activity().getValue());
			jsonObjectReceptor.put(NotaDeDebito.DESCACTIVIDAD, partner.getE_Activity().getName());
		} else  {
			jsonObjectReceptor.put(NotaDeDebito.CODACTIVIDAD, "");
			jsonObjectReceptor.put(NotaDeDebito.DESCACTIVIDAD, "");
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
				jsonDireccion.put(NotaDeDebito.DEPARTAMENTO, departamento);
				jsonDireccion.put(NotaDeDebito.MUNICIPIO, municipio);
				jsonDireccion.put(NotaDeDebito.COMPLEMENTO, complemento);
				break;
			}
		}		
		
		// In case there is no address
		if (departamento == null) {
			jsonDireccion.put(NotaDeDebito.DEPARTAMENTO, departamento);
			jsonDireccion.put(NotaDeDebito.MUNICIPIO, municipio);
			jsonDireccion.put(NotaDeDebito.COMPLEMENTO, complemento);
		}		
		jsonObjectReceptor.put(NotaDeDebito.DIRECCION, jsonDireccion);
		
		jsonObjectReceptor.put(NotaDeDebito.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectReceptor.put(NotaDeDebito.CORREO, partner.get_ValueAsString("EMail"));		

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
		jsonObjectResumen.put(NotaDeDebito.TOTALNOSUJ, totalNoSuj);
		jsonObjectResumen.put(NotaDeDebito.TOTALEXENTA, totalExenta);
		jsonObjectResumen.put(NotaDeDebito.TOTALGRAVADA, totalGravada);
		jsonObjectResumen.put(NotaDeDebito.SUBTOTALVENTAS, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(NotaDeDebito.DESCUNOSUJ, Env.ZERO);
		jsonObjectResumen.put(NotaDeDebito.DESCUEXENTA, Env.ZERO);
		jsonObjectResumen.put(NotaDeDebito.DESCUGRAVADA, Env.ZERO);
		jsonObjectResumen.put(NotaDeDebito.PORCENTAJEDESCUENTO, Env.ZERO);
		jsonObjectResumen.put(NotaDeDebito.SUBTOTAL, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(NotaDeDebito.IVARETE1, Env.ZERO);
		jsonObjectResumen.put(NotaDeDebito.MONTOTOTALOPERACION, invoice.getGrandTotal());
		jsonObjectResumen.put(NotaDeDebito.TOTALNOGRAVADO, totalExenta.add(totalNoSuj));
		jsonObjectResumen.put(NotaDeDebito.TOTALPAGAR, invoice.getGrandTotal());
		jsonObjectResumen.put(NotaDeDebito.TOTALLETRAS, totalLetras);
		jsonObjectResumen.put(NotaDeDebito.SALDOFAVOR, invoice.getGrandTotal());
		jsonObjectResumen.put(NotaDeDebito.CONDICIONOPERACION, 1);
		jsonObjectResumen.put(NotaDeDebito.TOTALDESCU, Env.ZERO);
		jsonObjectResumen.put(NotaDeDebito.RETERENTA, Env.ZERO);
		jsonObjectResumen.put(NotaDeDebito.TOTALIVA, totalIVA);

		JSONArray jsonArrayPagos = new JSONArray();
			JSONObject jsonPago = new JSONObject();
			jsonPago.put(NotaDeDebito.CODIGO, "05");
			jsonPago.put(NotaDeDebito.MONTOPAGO, new BigDecimal(0.00));
			jsonPago.put(NotaDeDebito.REFERENCIA, "Transferencia_ Depósito Bancario");
			jsonPago.put(NotaDeDebito.PLAZO, invoice.getC_PaymentTerm().getE_TimeSpan().getValue());
			jsonPago.put(NotaDeDebito.PERIODO, invoice.getC_PaymentTerm().getNetDays());
		jsonArrayPagos.put(jsonPago);

		jsonObjectResumen.put(NotaDeDebito.PAGOS, jsonArrayPagos);
		
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
                
			jsonCuerpoDocumentoItem.put(NotaDeDebito.NUMITEM, invoiceLine.getLine());
			jsonCuerpoDocumentoItem.put(NotaDeDebito.TIPOITEM, 2);
			jsonCuerpoDocumentoItem.put(NotaDeDebito.NUMERODOCUMENTO, getNumeroControl(invoice.get_ID(), orgInfo, "DTE-01-"));
			jsonCuerpoDocumentoItem.put(NotaDeDebito.CANTIDAD, invoiceLine.getQtyInvoiced());
			jsonCuerpoDocumentoItem.put(NotaDeDebito.CODIGO, invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(NotaDeDebito.CODIGOTRIBUTO, "");  // String codTributo = "20";
			
			JSONArray jsonTributosArray = new JSONArray();
			jsonCuerpoDocumentoItem. put( NotaDeDebito.TRIBUTOS, jsonTributosArray); //tributosItems.add("20");
			
			jsonCuerpoDocumentoItem.put(NotaDeDebito.UNIMEDIDA, 1);
			jsonCuerpoDocumentoItem.put(NotaDeDebito.DESCRIPCION, invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(NotaDeDebito.PRECIOUNI, invoiceLine.getPriceActual());
			jsonCuerpoDocumentoItem.put(NotaDeDebito.MONTODESCU, Env.ZERO);
			jsonCuerpoDocumentoItem.put(NotaDeDebito.VENTANOSUJ, ventaNoSuj);
			jsonCuerpoDocumentoItem.put(NotaDeDebito.VENTAEXENTA, ventaExenta);
			jsonCuerpoDocumentoItem.put(NotaDeDebito.VENTAGRAVADA, ventaGravada);
			jsonCuerpoDocumentoItem.put(NotaDeDebito.PSV, invoiceLine.getTaxAmt());
			jsonCuerpoDocumentoItem.put(NotaDeDebito.NOGRAVADO, ventaNoSuj.add(ventaNoSuj));
			jsonCuerpoDocumentoItem.put(NotaDeDebito.IVAITEM, ivaItem);

			jsonCuerpoDocumentoArray.put(jsonCuerpoDocumentoItem);
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() + " Finished");

		}  
		
		jsonCuerpoDocumento.put(NotaDeDebito.CUERPODOCUMENTO, jsonCuerpoDocumentoArray);
		System.out.println("Finish collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		
		return jsonCuerpoDocumento;
	}

	public String createJsonString() throws Exception {
    	ObjectMapper objectMapper = new ObjectMapper();
    	String facturaAsString    = objectMapper.writeValueAsString(notaDeDebito);
        JSONObject  facturaAsJson = new JSONObject(facturaAsString);
        
        facturaAsJson.remove(NotaDeDebito.DOCUMENTORELACIONADO);
        facturaAsJson.remove(NotaDeDebito.OTROSDOCUMENTOS);
        facturaAsJson.remove(NotaDeDebito.RECEPTOR);
        facturaAsJson.remove(NotaDeDebito.VENTATERCERO);        
        facturaAsJson.remove(NotaDeDebito.EXTENSION);
        facturaAsJson.remove(NotaDeDebito.APENDICE);
        facturaAsJson.remove(NotaDeDebito.DOCUMENTO);
        facturaAsJson.remove(NotaDeDebito.MOTIVO);
        facturaAsJson.remove(NotaDeDebito.ERRORMESSAGES);

        facturaAsJson.getJSONObject(NotaDeDebito.IDENTIFICACION).remove("horAnula");
        facturaAsJson.getJSONObject(NotaDeDebito.IDENTIFICACION).remove("motivoContigencia");
        facturaAsJson.getJSONObject(NotaDeDebito.IDENTIFICACION).remove("fecAnula");
        facturaAsJson.getJSONObject(NotaDeDebito.IDENTIFICACION).remove("motivoContingencia");

        facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("seguro");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("totalSujetoRetencion");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("tributos");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("tributosNotaDeDebito");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("numPagoElectronico");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("flete");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("ivaPerci1");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("descuento");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("codIncoterms");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("totalIVAretenidoLetras");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("descIncoterms");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("observaciones");
		facturaAsJson.getJSONObject(NotaDeDebito.RESUMEN).remove("totalIVAretenido");

		facturaAsJson.getJSONObject(NotaDeDebito.CUERPODOCUMENTO).remove("numDocumento");
		facturaAsJson.getJSONObject(NotaDeDebito.CUERPODOCUMENTO).remove("fechaEmision");
		facturaAsJson.getJSONObject(NotaDeDebito.CUERPODOCUMENTO).remove("tributos");
		facturaAsJson.getJSONObject(NotaDeDebito.CUERPODOCUMENTO).remove("codTributo");
		facturaAsJson.getJSONObject(NotaDeDebito.CUERPODOCUMENTO).remove("codigoRetencionMH");
		facturaAsJson.getJSONObject(NotaDeDebito.CUERPODOCUMENTO).remove("montoSujetoGrav");
		facturaAsJson.getJSONObject(NotaDeDebito.CUERPODOCUMENTO).remove(" ivaRetenido");
		facturaAsJson.getJSONObject(NotaDeDebito.CUERPODOCUMENTO).remove("tipoDte");

		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("codigo");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("puntoVentaMH");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("direccion");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("codEstable");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("codPuntoVenta");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("codigoMH");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("codEstableMH");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("puntoVenta");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("recintoFiscal");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("regimen");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("nomEstablecimiento");
		facturaAsJson.getJSONObject(NotaDeDebito.EMISOR).remove("codPuntoVentaMH");

        String finalNotaDeDebitoAsString = objectMapper.writeValueAsString(facturaAsJson);
		return finalNotaDeDebitoAsString;
	}

	public String getNumeroControl(Integer id, MOrgInfo orgInfo, String prefix) {
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		String numeroControl = prefix + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		return numeroControl;
	}
	

	@Override
	public StringBuffer getEDocumentErrorMessages() {
		 return notaDeDebito.errorMessages;
	 }
	
	public boolean writeToFile (String json, MInvoice invoice, String directory)
		{
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
