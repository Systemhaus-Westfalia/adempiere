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
import org.shw.einvoice.es.fefcfacturaelectronicav1.CuerpoDocumentoItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.EmisorFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.Factura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.IdentificacionFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.ResumenFactura;
import org.shw.einvoice.es.util.pojo.EDocumentFactory;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FacturaFactory extends EDocumentFactory {
	Factura factura;
	MInvoice invoice;
	
	public FacturaFactory(String trxName, Properties contextProperties, MClient client, MOrgInfo orgInfo, MInvoice invoice) {
		super(trxName, contextProperties, client, orgInfo);
		this.invoice = invoice;
	}

	public Factura generateEDocument() {
		String result="";
		factura = new Factura();
		
		IdentificacionFactura identification = factura.getIdentificacion();
		if(identification!=null) {
			factura.errorMessages.append(factura.fillIdentification(jsonInputToFactory));
			result = identification.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				factura.errorMessages.append(result);
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
		
		EmisorFactura emisor = factura.getEmisor();
		if(emisor!=null) {
			factura.fillEmisor(jsonInputToFactory);
			result = emisor.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				factura.errorMessages.append(result);
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
		
		List<CuerpoDocumentoItemFactura> cuerpoDocumento = factura.getCuerpoDocumento();
		if(cuerpoDocumento!=null) {
			factura.fillCuerpoDocumento(jsonInputToFactory);
			
			cuerpoDocumento.stream().forEach( cuerpoDocumentoItem -> { 
				String resultLambda = cuerpoDocumentoItem.validateValues();
					if(! resultLambda.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
						factura.errorMessages.append(resultLambda);
					}
				} 
			);
		}
		
		ResumenFactura resumen = factura.getResumen();
		if(resumen!=null) {
			factura.fillResumen(jsonInputToFactory);
			result = resumen.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				factura.errorMessages.append(result);
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

		factura.validateValues();
		if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
			factura.errorMessages.append(result);
		}
		
		return factura;
	}

	@Override
	public void generateJSONInputData() {
		jsonInputToFactory = new JSONObject();

		jsonInputToFactory.put(Factura.IDENTIFICACION, generateIdentificationInputData());
		jsonInputToFactory.put(Factura.RECEPTOR, generateReceptorInputData());
		jsonInputToFactory.put(Factura.EMISOR, generateEmisorInputData());
		jsonInputToFactory.put(Factura.RESUMEN, generateResumenInputData());
		jsonInputToFactory.put(Factura.CUERPODOCUMENTO, generateCuerpoDocumentoInputData());
	}
	
	private JSONObject generateIdentificationInputData() {
		System.out.println("Start collecting JSON data for Identificacion");
		
		Integer invoiceID = invoice.get_ID();
		String numeroControl = getNumeroControl(invoiceID, orgInfo, "DTE-01-");
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(invoiceID.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();
		jsonObjectIdentificacion.put(Factura.NUMEROCONTROL, numeroControl);
		jsonObjectIdentificacion.put(Factura.CODIGOGENERACION, codigoGeneracion);
		jsonObjectIdentificacion.put(Factura.TIPOMODELO, 1);
		jsonObjectIdentificacion.put(Factura.TIPOOPERACION, 1);
		jsonObjectIdentificacion.put(Factura.FECEMI, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put(Factura.HOREMI, "00:00:00");
		jsonObjectIdentificacion.put(Factura.TIPOMONEDA, "USD");
		jsonObjectIdentificacion.put(Factura.AMBIENTE, "00");

		System.out.println("Finish collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;
		
	}
	
	private JSONObject generateEmisorInputData() {
		System.out.println("Start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put(Factura.NIT, orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put(Factura.NRC, StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		jsonObjectEmisor.put(Factura.NOMBRE, client.getName());
		jsonObjectEmisor.put(Factura.CODACTIVIDAD, client.getE_Activity().getValue());
		jsonObjectEmisor.put(Factura.DESCACTIVIDAD, client.getE_Activity().getName());
		jsonObjectEmisor.put(Factura.NOMBRECOMERCIAL, client.getDescription());
		jsonObjectEmisor.put(Factura.TIPOESTABLECIMIENTO, client.getE_PlantType().getValue());

		JSONObject jsonDireccion = new JSONObject();
		jsonDireccion.put(Factura.DEPARTAMENTO, orgInfo.getC_Location().getC_City().getC_Region().getValue());
		jsonDireccion.put(Factura.MUNICIPIO, orgInfo.getC_Location().getC_City().getValue());
		jsonDireccion.put(Factura.COMPLEMENTO, orgInfo.getC_Location().getAddress1());
		jsonObjectEmisor.put(Factura.DIRECCION, jsonDireccion);
		
		jsonObjectEmisor.put(Factura.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(Factura.CORREO, client.getEMail());

		System.out.println("Finish collecting JSON data for Emisor");
		return jsonObjectEmisor;
		
	}
	
	private JSONObject generateReceptorInputData() {
		System.out.println("Start collecting JSON data for Receptor");

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
		if (partner.getE_Activity_ID()<=0 || partner.getE_Recipient_Identification_ID() <= 0) {
			String errorMessage = "Socio de Negocio " + partner.getName() + ": Falta configuracion para Facturacion Electronica"; 
			factura.errorMessages.append(errorMessage);
			System.out.println(errorMessage);
		}
		
		JSONObject jsonObjectReceptor = new JSONObject();
		
		jsonObjectReceptor.put(Factura.TIPODOCUMENTO, partner.getE_Recipient_Identification().getValue());
		jsonObjectReceptor.put(Factura.NUMDOCUMENTO, partner.getTaxID().replace("-", ""));
		jsonObjectReceptor.put(Factura.NOMBRE, partner.getName());
		
		if (partner.getE_Activity_ID()>0) {
			jsonObjectReceptor.put(Factura.CODACTIVIDAD, partner.getE_Activity().getValue());
			jsonObjectReceptor.put(Factura.DESCACTIVIDAD, partner.getE_Activity().getName());
		} else  {
			jsonObjectReceptor.put(Factura.CODACTIVIDAD, "");
			jsonObjectReceptor.put(Factura.DESCACTIVIDAD, "");
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
				jsonDireccion.put(Factura.DEPARTAMENTO, departamento);
				jsonDireccion.put(Factura.MUNICIPIO, municipio);
				jsonDireccion.put(Factura.COMPLEMENTO, complemento);
				break;
			}
		}		
		
		// In case there is no address
		if (departamento == null) {
			jsonDireccion.put(Factura.DEPARTAMENTO, departamento);
			jsonDireccion.put(Factura.MUNICIPIO, municipio);
			jsonDireccion.put(Factura.COMPLEMENTO, complemento);
		}		
		jsonObjectReceptor.put(Factura.DIRECCION, jsonDireccion);
		
		jsonObjectReceptor.put(Factura.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectReceptor.put(Factura.CORREO, partner.get_ValueAsString("EMail"));		

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
		jsonObjectResumen.put(Factura.TOTALNOSUJ, totalNoSuj);
		jsonObjectResumen.put(Factura.TOTALEXENTA, totalExenta);
		jsonObjectResumen.put(Factura.TOTALGRAVADA, totalGravada);
		jsonObjectResumen.put(Factura.SUBTOTALVENTAS, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(Factura.DESCUNOSUJ, Env.ZERO);
		jsonObjectResumen.put(Factura.DESCUEXENTA, Env.ZERO);
		jsonObjectResumen.put(Factura.DESCUGRAVADA, Env.ZERO);
		jsonObjectResumen.put(Factura.PORCENTAJEDESCUENTO, Env.ZERO);
		jsonObjectResumen.put(Factura.SUBTOTAL, totalGravada.add(totalNoSuj).add(totalExenta));
		jsonObjectResumen.put(Factura.IVARETE1, Env.ZERO);
		jsonObjectResumen.put(Factura.MONTOTOTALOPERACION, invoice.getGrandTotal());
		jsonObjectResumen.put(Factura.TOTALNOGRAVADO, totalExenta.add(totalNoSuj));
		jsonObjectResumen.put(Factura.TOTALPAGAR, invoice.getGrandTotal());
		jsonObjectResumen.put(Factura.TOTALLETRAS, totalLetras);
		jsonObjectResumen.put(Factura.SALDOFAVOR, invoice.getGrandTotal());
		jsonObjectResumen.put(Factura.CONDICIONOPERACION, 1);
		jsonObjectResumen.put(Factura.TOTALDESCU, Env.ZERO);
		jsonObjectResumen.put(Factura.RETERENTA, Env.ZERO);
		jsonObjectResumen.put(Factura.TOTALIVA, totalIVA);

		JSONArray jsonArrayPagos = new JSONArray();
			JSONObject jsonPago = new JSONObject();
			jsonPago.put(Factura.CODIGO, "05");
			jsonPago.put(Factura.MONTOPAGO, new BigDecimal(0.00));
			jsonPago.put(Factura.REFERENCIA, "Transferencia_ Depósito Bancario");
			jsonPago.put(Factura.PLAZO, invoice.getC_PaymentTerm().getE_TimeSpan().getValue());
			jsonPago.put(Factura.PERIODO, invoice.getC_PaymentTerm().getNetDays());
		jsonArrayPagos.put(jsonPago);

		jsonObjectResumen.put(Factura.PAGOS, jsonArrayPagos);
		
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
                
			jsonCuerpoDocumentoItem.put(Factura.NUMITEM, invoiceLine.getLine());
			jsonCuerpoDocumentoItem.put(Factura.TIPOITEM, 2);
			jsonCuerpoDocumentoItem.put(Factura.NUMERODOCUMENTO, getNumeroControl(invoice.get_ID(), orgInfo, "DTE-01-"));
			jsonCuerpoDocumentoItem.put(Factura.CANTIDAD, invoiceLine.getQtyInvoiced());
			jsonCuerpoDocumentoItem.put(Factura.CODIGO, invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(Factura.CODIGOTRIBUTO, "");  // String codTributo = "20";
			
			JSONArray jsonTributosArray = new JSONArray();
			jsonCuerpoDocumentoItem. put( Factura.TRIBUTOS, jsonTributosArray); //tributosItems.add("20");
			
			jsonCuerpoDocumentoItem.put(Factura.UNIMEDIDA, 1);
			jsonCuerpoDocumentoItem.put(Factura.DESCRIPCION, invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName());
			jsonCuerpoDocumentoItem.put(Factura.PRECIOUNI, invoiceLine.getPriceActual());
			jsonCuerpoDocumentoItem.put(Factura.MONTODESCU, Env.ZERO);
			jsonCuerpoDocumentoItem.put(Factura.VENTANOSUJ, ventaNoSuj);
			jsonCuerpoDocumentoItem.put(Factura.VENTAEXENTA, ventaExenta);
			jsonCuerpoDocumentoItem.put(Factura.VENTAGRAVADA, ventaGravada);
			jsonCuerpoDocumentoItem.put(Factura.PSV, invoiceLine.getTaxAmt());
			jsonCuerpoDocumentoItem.put(Factura.NOGRAVADO, ventaNoSuj.add(ventaNoSuj));
			jsonCuerpoDocumentoItem.put(Factura.IVAITEM, ivaItem);

			jsonCuerpoDocumentoArray.put(jsonCuerpoDocumentoItem);
			System.out.println("Collect JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo() + ", Line: " + invoiceLine.getLine() + " Finished");

		}  
		
		jsonCuerpoDocumento.put(Factura.CUERPODOCUMENTO, jsonCuerpoDocumentoArray);
		System.out.println("Finish collecting JSON data for Cuerpo Documento. Document: " + invoice.getDocumentNo());
		
		return jsonCuerpoDocumento;
	}

	public String createJsonString() throws Exception {
    	ObjectMapper objectMapper = new ObjectMapper();
    	String facturaAsString    = objectMapper.writeValueAsString(factura);
        JSONObject  facturaAsJson = new JSONObject(facturaAsString);
        
        facturaAsJson.remove(Factura.DOCUMENTORELACIONADO);
        facturaAsJson.remove(Factura.OTROSDOCUMENTOS);
        facturaAsJson.remove(Factura.RECEPTOR);
        facturaAsJson.remove(Factura.VENTATERCERO);        
        facturaAsJson.remove(Factura.EXTENSION);
        facturaAsJson.remove(Factura.APENDICE);
        facturaAsJson.remove(Factura.DOCUMENTO);
        facturaAsJson.remove(Factura.MOTIVO);
        facturaAsJson.remove(Factura.ERRORMESSAGES);

        facturaAsJson.getJSONObject(Factura.IDENTIFICACION).remove("horAnula");
        facturaAsJson.getJSONObject(Factura.IDENTIFICACION).remove("motivoContigencia");
        facturaAsJson.getJSONObject(Factura.IDENTIFICACION).remove("fecAnula");
        facturaAsJson.getJSONObject(Factura.IDENTIFICACION).remove("motivoContingencia");

        facturaAsJson.getJSONObject(Factura.RESUMEN).remove("seguro");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("totalSujetoRetencion");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("tributos");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("tributosFactura");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("numPagoElectronico");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("flete");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("ivaPerci1");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("descuento");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("codIncoterms");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("totalIVAretenidoLetras");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("descIncoterms");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("observaciones");
		facturaAsJson.getJSONObject(Factura.RESUMEN).remove("totalIVAretenido");

		facturaAsJson.getJSONObject(Factura.CUERPODOCUMENTO).remove("numDocumento");
		facturaAsJson.getJSONObject(Factura.CUERPODOCUMENTO).remove("fechaEmision");
		facturaAsJson.getJSONObject(Factura.CUERPODOCUMENTO).remove("tributos");
		facturaAsJson.getJSONObject(Factura.CUERPODOCUMENTO).remove("codTributo");
		facturaAsJson.getJSONObject(Factura.CUERPODOCUMENTO).remove("codigoRetencionMH");
		facturaAsJson.getJSONObject(Factura.CUERPODOCUMENTO).remove("montoSujetoGrav");
		facturaAsJson.getJSONObject(Factura.CUERPODOCUMENTO).remove(" ivaRetenido");
		facturaAsJson.getJSONObject(Factura.CUERPODOCUMENTO).remove("tipoDte");

		facturaAsJson.getJSONObject(Factura.EMISOR).remove("codigo");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("puntoVentaMH");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("direccion");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("codEstable");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("codPuntoVenta");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("codigoMH");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("codEstableMH");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("puntoVenta");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("recintoFiscal");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("regimen");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("nomEstablecimiento");
		facturaAsJson.getJSONObject(Factura.EMISOR).remove("codPuntoVentaMH");

        String finalFacturaAsString = objectMapper.writeValueAsString(facturaAsJson);
		return finalFacturaAsString;
	}

	public String getNumeroControl(Integer id, MOrgInfo orgInfo, String prefix) {
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		String numeroControl = prefix + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		return numeroControl;
	}
	

	@Override
	public StringBuffer getEDocumentErrorMessages() {
		 return factura.errorMessages;
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
