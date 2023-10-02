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
import org.shw.einvoice.es.fecrretencionv1.CuerpoDocumentoItemRetencion;
import org.shw.einvoice.es.fecrretencionv1.EmisorRetencion;
import org.shw.einvoice.es.fecrretencionv1.IdentificacionRetencion;
import org.shw.einvoice.es.fecrretencionv1.ResumenRetencion;
import org.shw.einvoice.es.util.pojo.EDocumentFactory;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RetencionFactory extends EDocumentFactory {
	Retencion retencion;
	MInvoice invoice;
	
	public RetencionFactory(String trxName, Properties contextProperties, MClient client, MOrgInfo orgInfo, MInvoice invoice) {
		super(trxName, contextProperties, client, orgInfo);
		this.invoice = invoice;
	}

	public Retencion generateEDocument() {
		String result="";
		retencion = new Retencion();
		
		IdentificacionRetencion identification = retencion.getIdentificacion();
		if(identification!=null) {
			retencion.errorMessages.append(retencion.fillIdentification(jsonInputToFactory));
			result = identification.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				retencion.errorMessages.append(result);
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
		
		EmisorRetencion emisor = retencion.getEmisor();
		if(emisor!=null) {
			retencion.fillEmisor(jsonInputToFactory);
			result = emisor.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				retencion.errorMessages.append(result);
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
		
		List<CuerpoDocumentoItemRetencion> cuerpoDocumento = retencion.getCuerpoDocumento();
		if(cuerpoDocumento!=null) {
			retencion.fillCuerpoDocumento(jsonInputToFactory);
			
			cuerpoDocumento.stream().forEach( cuerpoDocumentoItem -> { 
				String resultLambda = cuerpoDocumentoItem.validateValues();
					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
						retencion.errorMessages.append(resultLambda);
					}
				} 
			);
		}
		
		ResumenRetencion resumen = retencion.getResumen();
		if(resumen!=null) {
			retencion.fillResumen(jsonInputToFactory);
			result = resumen.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				retencion.errorMessages.append(result);
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

		retencion.validateValues();
		if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
			retencion.errorMessages.append(result);
		}
		
		return retencion;
	}

	@Override
	public void generateJSONInputData() {
		jsonInputToFactory = new JSONObject();

		jsonInputToFactory.put(Retencion.IDENTIFICACION, generateIdentificationInputData());
		jsonInputToFactory.put(Retencion.RECEPTOR, generateReceptorInputData());
		jsonInputToFactory.put(Retencion.EMISOR, generateEmisorInputData());
		jsonInputToFactory.put(Retencion.RESUMEN, generateResumenInputData());
		jsonInputToFactory.put(Retencion.CUERPODOCUMENTO, generateCuerpoDocumentoInputData());
	}
	
	private JSONObject generateIdentificationInputData() {
		System.out.println("Start collecting JSON data for Identificacion");
		
		Integer invoiceID = invoice.get_ID();
		String numeroControl = getNumeroControl(invoiceID, orgInfo, "DTE-01-");
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(invoiceID.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();
		jsonObjectIdentificacion.put(Retencion.NUMEROCONTROL, numeroControl);
		jsonObjectIdentificacion.put(Retencion.CODIGOGENERACION, codigoGeneracion);
		jsonObjectIdentificacion.put(Retencion.TIPOMODELO, 1);
		jsonObjectIdentificacion.put(Retencion.TIPOOPERACION, 1);
		jsonObjectIdentificacion.put(Retencion.FECEMI, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put(Retencion.HOREMI, "00:00:00");
		jsonObjectIdentificacion.put(Retencion.TIPOMONEDA, "USD");
		jsonObjectIdentificacion.put(Retencion.AMBIENTE, "00");

		System.out.println("Finish collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;
		
	}
	
	private JSONObject generateEmisorInputData() {
		System.out.println("Start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put(Retencion.NIT, orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put(Retencion.NRC, StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		jsonObjectEmisor.put(Retencion.NOMBRE, client.getName());
		jsonObjectEmisor.put(Retencion.CODACTIVIDAD, client.getE_Activity().getValue());
		jsonObjectEmisor.put(Retencion.DESCACTIVIDAD, client.getE_Activity().getName());
		jsonObjectEmisor.put(Retencion.NOMBRECOMERCIAL, client.getDescription());
		jsonObjectEmisor.put(Retencion.TIPOESTABLECIMIENTO, client.getE_PlantType().getValue());

		JSONObject jsonDireccion = new JSONObject();
		jsonDireccion.put(Retencion.DEPARTAMENTO, orgInfo.getC_Location().getC_City().getC_Region().getValue());
		jsonDireccion.put(Retencion.MUNICIPIO, orgInfo.getC_Location().getC_City().getValue());
		jsonDireccion.put(Retencion.COMPLEMENTO, orgInfo.getC_Location().getAddress1());
		jsonObjectEmisor.put(Retencion.DIRECCION, jsonDireccion);
		
		jsonObjectEmisor.put(Retencion.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(Retencion.CORREO, client.getEMail());

		System.out.println("Finish collecting JSON data for Emisor");
		return jsonObjectEmisor;
		
	}
	
	private JSONObject generateReceptorInputData() {
		System.out.println("Start collecting JSON data for Receptor");

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
		if (partner.getE_Activity_ID()<=0 || partner.getE_Recipient_Identification_ID() <= 0) {
			String errorMessage = "Socio de Negocio " + partner.getName() + ": Falta configuracion para Retencioncion Electronica"; 
			retencion.errorMessages.append(errorMessage);
			System.out.println(errorMessage);
		}
		
		JSONObject jsonObjectReceptor = new JSONObject();
		
		jsonObjectReceptor.put(Retencion.TIPODOCUMENTO, partner.getE_Recipient_Identification().getValue());
		jsonObjectReceptor.put(Retencion.NUMDOCUMENTO, partner.getTaxID().replace("-", ""));
		jsonObjectReceptor.put(Retencion.NOMBRE, partner.getName());
		
		if (partner.getE_Activity_ID()>0) {
			jsonObjectReceptor.put(Retencion.CODACTIVIDAD, partner.getE_Activity().getValue());
			jsonObjectReceptor.put(Retencion.DESCACTIVIDAD, partner.getE_Activity().getName());
		} else  {
			jsonObjectReceptor.put(Retencion.CODACTIVIDAD, "");
			jsonObjectReceptor.put(Retencion.DESCACTIVIDAD, "");
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
				jsonDireccion.put(Retencion.DEPARTAMENTO, departamento);
				jsonDireccion.put(Retencion.MUNICIPIO, municipio);
				jsonDireccion.put(Retencion.COMPLEMENTO, complemento);
				break;
			}
		}		
		
		// In case there is no address
		if (departamento == null) {
			jsonDireccion.put(Retencion.DEPARTAMENTO, departamento);
			jsonDireccion.put(Retencion.MUNICIPIO, municipio);
			jsonDireccion.put(Retencion.COMPLEMENTO, complemento);
		}		
		jsonObjectReceptor.put(Retencion.DIRECCION, jsonDireccion);
		
		jsonObjectReceptor.put(Retencion.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectReceptor.put(Retencion.CORREO, partner.get_ValueAsString("EMail"));		

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
		jsonObjectResumen.put(Retencion.TOTALNOSUJ, totalNoSuj);
		jsonObjectResumen.put(Retencion.TOTALEXENTA, totalExenta);
		jsonObjectResumen.put(Retencion.TOTALGRAVADA, totalGravada);
		jsonObjectResumen.put(Retencion.SUBTOTALVENTAS, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(Retencion.DESCUNOSUJ, Env.ZERO);
		jsonObjectResumen.put(Retencion.DESCUEXENTA, Env.ZERO);
		jsonObjectResumen.put(Retencion.DESCUGRAVADA, Env.ZERO);
		jsonObjectResumen.put(Retencion.PORCENTAJEDESCUENTO, Env.ZERO);
		jsonObjectResumen.put(Retencion.SUBTOTAL, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(Retencion.IVARETE1, Env.ZERO);
		jsonObjectResumen.put(Retencion.MONTOTOTALOPERACION, invoice.getGrandTotal());
		jsonObjectResumen.put(Retencion.TOTALNOGRAVADO, totalExenta.add(totalNoSuj));
		jsonObjectResumen.put(Retencion.TOTALPAGAR, invoice.getGrandTotal());
		jsonObjectResumen.put(Retencion.TOTALLETRAS, totalLetras);
		jsonObjectResumen.put(Retencion.SALDOFAVOR, invoice.getGrandTotal());
		jsonObjectResumen.put(Retencion.CONDICIONOPERACION, 1);
		jsonObjectResumen.put(Retencion.TOTALDESCU, Env.ZERO);
		jsonObjectResumen.put(Retencion.RETERENTA, Env.ZERO);
		jsonObjectResumen.put(Retencion.TOTALIVA, totalIVA);

		JSONArray jsonArrayPagos = new JSONArray();
			JSONObject jsonPago = new JSONObject();
			jsonPago.put(Retencion.CODIGO, "05");
			jsonPago.put(Retencion.MONTOPAGO, new BigDecimal(0.00));
			jsonPago.put(Retencion.REFERENCIA, "Transferencia_ Depósito Bancario");
			jsonPago.put(Retencion.PLAZO, invoice.getC_PaymentTerm().getE_TimeSpan().getValue());
			jsonPago.put(Retencion.PERIODO, invoice.getC_PaymentTerm().getNetDays());
		jsonArrayPagos.put(jsonPago);

		jsonObjectResumen.put(Retencion.PAGOS, jsonArrayPagos);
		
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
                
			jsonCuerpoDocumentoItem.put(Retencion.NUMITEM, invoiceLine.getLine());
			jsonCuerpoDocumentoItem.put(Retencion.TIPOITEM, 2);
			jsonCuerpoDocumentoItem.put(Retencion.NUMERODOCUMENTO, getNumeroControl(invoice.get_ID(), orgInfo, "DTE-01-"));
			jsonCuerpoDocumentoItem.put(Retencion.CANTIDAD, invoiceLine.getQtyInvoiced());
			jsonCuerpoDocumentoItem.put(Retencion.CODIGO, invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(Retencion.CODIGOTRIBUTO, "");  // String codTributo = "20";
			
			JSONArray jsonTributosArray = new JSONArray();
			jsonCuerpoDocumentoItem. put( Retencion.TRIBUTOS, jsonTributosArray); //tributosItems.add("20");
			
			jsonCuerpoDocumentoItem.put(Retencion.UNIMEDIDA, 1);
			jsonCuerpoDocumentoItem.put(Retencion.DESCRIPCION, invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(Retencion.PRECIOUNI, invoiceLine.getPriceActual());
			jsonCuerpoDocumentoItem.put(Retencion.MONTODESCU, Env.ZERO);
			jsonCuerpoDocumentoItem.put(Retencion.VENTANOSUJ, ventaNoSuj);
			jsonCuerpoDocumentoItem.put(Retencion.VENTAEXENTA, ventaExenta);
			jsonCuerpoDocumentoItem.put(Retencion.VENTAGRAVADA, ventaGravada);
			jsonCuerpoDocumentoItem.put(Retencion.PSV, invoiceLine.getTaxAmt());
			jsonCuerpoDocumentoItem.put(Retencion.NOGRAVADO, ventaNoSuj.add(ventaNoSuj));
			jsonCuerpoDocumentoItem.put(Retencion.IVAITEM, ivaItem);

			jsonCuerpoDocumentoArray.put(jsonCuerpoDocumentoItem);
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() + " Finished");

		}  
		
		jsonCuerpoDocumento.put(Retencion.CUERPODOCUMENTO, jsonCuerpoDocumentoArray);
		System.out.println("Finish collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		
		return jsonCuerpoDocumento;
	}

	public String createJsonString() throws Exception {
    	ObjectMapper objectMapper = new ObjectMapper();
    	String facturaAsString    = objectMapper.writeValueAsString(retencion);
        JSONObject  facturaAsJson = new JSONObject(facturaAsString);
        
        facturaAsJson.remove(Retencion.DOCUMENTORELACIONADO);
        facturaAsJson.remove(Retencion.OTROSDOCUMENTOS);
        facturaAsJson.remove(Retencion.RECEPTOR);
        facturaAsJson.remove(Retencion.VENTATERCERO);        
        facturaAsJson.remove(Retencion.EXTENSION);
        facturaAsJson.remove(Retencion.APENDICE);
        facturaAsJson.remove(Retencion.DOCUMENTO);
        facturaAsJson.remove(Retencion.MOTIVO);
        facturaAsJson.remove(Retencion.ERRORMESSAGES);

        facturaAsJson.getJSONObject(Retencion.IDENTIFICACION).remove("horAnula");
        facturaAsJson.getJSONObject(Retencion.IDENTIFICACION).remove("motivoContigencia");
        facturaAsJson.getJSONObject(Retencion.IDENTIFICACION).remove("fecAnula");
        facturaAsJson.getJSONObject(Retencion.IDENTIFICACION).remove("motivoContingencia");

        facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("seguro");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("totalSujetoRetencion");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("tributos");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("tributosRetencion");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("numPagoElectronico");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("flete");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("ivaPerci1");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("descuento");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("codIncoterms");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("totalIVAretenidoLetras");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("descIncoterms");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("observaciones");
		facturaAsJson.getJSONObject(Retencion.RESUMEN).remove("totalIVAretenido");

		facturaAsJson.getJSONObject(Retencion.CUERPODOCUMENTO).remove("numDocumento");
		facturaAsJson.getJSONObject(Retencion.CUERPODOCUMENTO).remove("fechaEmision");
		facturaAsJson.getJSONObject(Retencion.CUERPODOCUMENTO).remove("tributos");
		facturaAsJson.getJSONObject(Retencion.CUERPODOCUMENTO).remove("codTributo");
		facturaAsJson.getJSONObject(Retencion.CUERPODOCUMENTO).remove("codigoRetencionMH");
		facturaAsJson.getJSONObject(Retencion.CUERPODOCUMENTO).remove("montoSujetoGrav");
		facturaAsJson.getJSONObject(Retencion.CUERPODOCUMENTO).remove(" ivaRetenido");
		facturaAsJson.getJSONObject(Retencion.CUERPODOCUMENTO).remove("tipoDte");

		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("codigo");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("puntoVentaMH");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("direccion");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("codEstable");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("codPuntoVenta");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("codigoMH");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("codEstableMH");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("puntoVenta");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("recintoFiscal");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("regimen");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("nomEstablecimiento");
		facturaAsJson.getJSONObject(Retencion.EMISOR).remove("codPuntoVentaMH");

        String finalRetencionAsString = objectMapper.writeValueAsString(facturaAsJson);
		return finalRetencionAsString;
	}

	public String getNumeroControl(Integer id, MOrgInfo orgInfo, String prefix) {
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		String numeroControl = prefix + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		return numeroControl;
	}
	

	@Override
	public StringBuffer getEDocumentErrorMessages() {
		 return retencion.errorMessages;
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
