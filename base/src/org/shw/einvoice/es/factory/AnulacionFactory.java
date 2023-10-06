package org.shw.einvoice.es.factory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrgInfo;
import org.json.JSONObject;
import org.shw.einvoice.es.anulacionv2.Anulacion;
import org.shw.einvoice.es.anulacionv2.DocumentoAnulacion;
import org.shw.einvoice.es.anulacionv2.EmisorAnulacion;
import org.shw.einvoice.es.anulacionv2.IdentificacionAnulacion;
import org.shw.einvoice.es.anulacionv2.MotivoAnulacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.FacturaExportacion;
import org.shw.einvoice.es.util.pojo.EDocumentFactory;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AnulacionFactory extends EDocumentFactory {
	Anulacion anulacion;
	MInvoice invoice;
	
	public AnulacionFactory(String trxName, Properties contextProperties, MClient client, MOrgInfo orgInfo, MInvoice invoice) {
		super(trxName, contextProperties, client, orgInfo);
		this.invoice = invoice;
	}

	public Anulacion generateEDocument() {
		System.out.println("Anulacion: start generating and filling the Document");
		String result="";
		anulacion = new Anulacion();

		System.out.println("Instatiate, fill and verify Identificacion");
		IdentificacionAnulacion identification = anulacion.getIdentificacion();
		if(identification!=null) {
			anulacion.errorMessages.append(anulacion.fillIdentification(jsonInputToFactory));
			result = identification.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				anulacion.errorMessages.append(result);
			}
		}

		System.out.println("Instatiate, fill and verify Emisor");
		EmisorAnulacion emisor = anulacion.getEmisor();
		if(emisor!=null) {
			anulacion.fillEmisor(jsonInputToFactory);
			result = emisor.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				anulacion.errorMessages.append(result);
			}
		}

		System.out.println("Instatiate, fill and verify Documento");
		DocumentoAnulacion documento = anulacion.getDocumento();
		if(documento!=null) {
			anulacion.fillDocumento(jsonInputToFactory);
			result = documento.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				anulacion.errorMessages.append(result);
			}
		}
//		
		System.out.println("Instatiate, fill and verify Motivo");
		MotivoAnulacion motivo = anulacion.getMotivo();
		if(documento!=null) {
			anulacion.fillMotivo(jsonInputToFactory);
			result = motivo.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				anulacion.errorMessages.append(result);
			}
		}

		anulacion.validateValues();
		if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
			anulacion.errorMessages.append(result);
		}

		System.out.println("Anulacion: end generating and filling the Document");
		return anulacion;
	}

	@Override
	public void generateJSONInputData() {
		System.out.println("Anulacion: start collecting JSON data for all components");
		jsonInputToFactory = new JSONObject();

		jsonInputToFactory.put(Anulacion.IDENTIFICACION, generateIdentificationInputData());
		jsonInputToFactory.put(Anulacion.EMISOR, generateEmisorInputData());
		jsonInputToFactory.put(Anulacion.DOCUMENTO, generateDocumentoInputData());
		jsonInputToFactory.put(Anulacion.MOTIVO, generateMotivoInputData());
		
		System.out.println("Generated JSON object from Invoice:");
		System.out.println(jsonInputToFactory.toString());
		System.out.println("Anulacion: end collecting JSON data for all components");
	}
	
	private JSONObject generateIdentificationInputData() {
		System.out.println("Factura: start collecting JSON data for Identificacion");

		String prefix = invoice.getC_DocType().getDefiniteSequence().getPrefix();
		String documentno = invoice.getDocumentNo().replace(prefix,"");
		int position = documentno.indexOf("_");
		documentno = documentno.substring(0,position);
		
		Integer invoiceID = invoice.get_ID();
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(invoiceID.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();

		jsonObjectIdentificacion.put(Anulacion.AMBIENTE, client.getE_Enviroment().getValue());
		jsonObjectIdentificacion.put(Anulacion.CODIGOGENERACION, codigoGeneracion);
		jsonObjectIdentificacion.put(Anulacion.FECANULA, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put(Anulacion.HORANULA, "00:00:00");
		
		System.out.println("Factura: end collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;	
	}
	
	private JSONObject generateEmisorInputData() {
		System.out.println("Factura: start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put(Anulacion.NIT, orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put(Anulacion.NOMBRE, client.getName());
		jsonObjectEmisor.put(Anulacion.TIPOESTABLECIMIENTO, client.getE_PlantType().getValue());
		jsonObjectEmisor.put(Anulacion.NOMESTABLECIMIENTO, "AAAAAAAAAAAAAAAAAAAAAA");						// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(Anulacion.CODESTABLEMH, "AAAAAAAAAAAAAAAAAAAAAA");								// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(Anulacion.CODESTABLE, "AAAAAAAAAAAAAAAAAAAAAA");								// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(Anulacion.CODPUNTOVENTAMH, "AAAAAAAAAAAAAAAAAAAAAA");							// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(Anulacion.CODPUNTOVENTA, "AAAAAAAAAAAAAAAAAAAAAA");							// TODO: korrekte Daten einsetzen
		jsonObjectEmisor.put(Anulacion.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(Anulacion.CORREO, client.getEMail());

		System.out.println("Factura: end collecting JSON data for Emisor");
		return jsonObjectEmisor;	
	}
	

	private JSONObject generateDocumentoInputData() {
		System.out.println("Start collecting JSON data for Documento");
		
		JSONObject jsonObjectDocumento = new JSONObject();
		jsonObjectDocumento.put(Anulacion.TIPODTE, "BBBBBBBBBBBBBBBBBBBBBB");				// TODO: korrekte Daten einsetzen
		jsonObjectDocumento.put(Anulacion.CODIGOGENERACION, "BBBBBBBBBBBBBBBBBBBBBB");		// TODO: korrekte Daten einsetzen
		jsonObjectDocumento.put(Anulacion.SELLORECIBIDO, "BBBBBBBBBBBBBBBBBBBBBB");			// TODO: korrekte Daten einsetzen
		jsonObjectDocumento.put(Anulacion.NUMEROCONTROL, "BBBBBBBBBBBBBBBBBBBBBB");			// TODO: korrekte Daten einsetzen
		jsonObjectDocumento.put(Anulacion.FECEMI, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectDocumento.put(Anulacion.MONTOIVA, "BBBBBBBBBBBBBBBBBBBBBB");				// TODO: korrekte Daten einsetzen
		jsonObjectDocumento.put(Anulacion.CODIGOGENERACIONR, "BBBBBBBBBBBBBBBBBBBBBB");		// TODO: korrekte Daten einsetzen
		jsonObjectDocumento.put(Anulacion.TIPODOCUMENTO, "BBBBBBBBBBBBBBBBBBBBBB");			// TODO: korrekte Daten einsetzen
		jsonObjectDocumento.put(Anulacion.NUMDOCUMENTO, "BBBBBBBBBBBBBBBBBBBBBB");			// TODO: korrekte Daten einsetzen
		jsonObjectDocumento.put(Anulacion.NOMBRE, client.getName());
		jsonObjectDocumento.put(Anulacion.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectDocumento.put(Anulacion.CORREO, client.getEMail());

		System.out.println("Finish collecting JSON data for Documento");
		return jsonObjectDocumento;		
	}
	
	private JSONObject generateMotivoInputData() {
		System.out.println("Start collecting JSON data for Motivo");
		
		JSONObject jsonObjectMotivo = new JSONObject();
		jsonObjectMotivo.put(Anulacion.MOTIVOANULACION, invoice.getDateAcct().toString().substring(0, 10));

		System.out.println("Finish collecting JSON data for Maotivo");
		return jsonObjectMotivo;
		
	}
	
	
	public String createJsonString() throws Exception {
		System.out.println("Anulacion: start generating JSON object from Document");
		ObjectMapper objectMapper  = new ObjectMapper();
		String anulacionAsString   = objectMapper.writeValueAsString(anulacion);
		JSONObject anulacionAsJson = new JSONObject(anulacionAsString);

		anulacionAsJson.remove(FacturaExportacion.ERRORMESSAGES);

		// Manipulate generated JSON string
		String anulacionAsStringFinal = anulacionAsJson.toString().
				replace(":[],", ":null,").
				replace("\"documentoRelacionado\":[]", "\"documentoRelacionado\":null").
				replace("\"ventaTercero\":{\"nit\":null,\"nombre\":null},", "\"ventaTercero\":null,").
				replace("\"tributos\":[{\"descripcion\":null,\"codigo\":null,\"valor\":null}]", "\"tributos\":null").
				replace("\"extension\":{\"docuEntrega\":null,\"placaVehiculo\":null,\"observaciones\":null,\"nombRecibe\":null,\"nombEntrega\":null,\"docuRecibe\":null},", 
						"\"extension\":null,");

		System.out.println("Anulacion: generated JSON object from Document:");
		System.out.println(anulacionAsStringFinal);
		System.out.println("Anulacion: end generating JSON object from Document");
		return anulacionAsStringFinal;	
	}

	public String getNumeroControl(Integer id, MOrgInfo orgInfo, String prefix) {
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		String numeroControl = prefix + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
		return numeroControl;
	}
	

	@Override
	public StringBuffer getEDocumentErrorMessages() {
		 return anulacion.errorMessages;
	 }
	
	public boolean writeToFile (String json, MInvoice invoice, String directory) {
		System.out.println("Anulacion: start writing to file");
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
			System.out.println("Anulacion: end writing to file");
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
