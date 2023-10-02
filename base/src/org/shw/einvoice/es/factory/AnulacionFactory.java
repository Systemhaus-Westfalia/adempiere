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
import org.shw.einvoice.es.anulacionv2.DocumentoAnulacion;
import org.shw.einvoice.es.anulacionv2.EmisorAnulacion;
import org.shw.einvoice.es.anulacionv2.IdentificacionAnulacion;
import org.shw.einvoice.es.anulacionv2.MotivoAnulacion;
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
		String result="";
		anulacion = new Anulacion();
		
		IdentificacionAnulacion identification = anulacion.getIdentificacion();
		if(identification!=null) {
			anulacion.errorMessages.append(anulacion.fillIdentification(jsonInputToFactory));
			result = identification.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				anulacion.errorMessages.append(result);
			}
		}
		
		EmisorAnulacion emisor = anulacion.getEmisor();
		if(emisor!=null) {
			anulacion.fillEmisor(jsonInputToFactory);
			result = emisor.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				anulacion.errorMessages.append(result);
			}
		}
		
		DocumentoAnulacion documento = anulacion.getDocumento();
		if(documento!=null) {
			anulacion.fillDocumento(jsonInputToFactory);
			result = documento.validateValues();
			if(! result.equals(EDocumentUtils.VALIDATION_RESULT_OK)) {
				anulacion.errorMessages.append(result);
			}
		}
//		
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
		
		return anulacion;
	}

	@Override
	public void generateJSONInputData() {
		jsonInputToFactory = new JSONObject();

		jsonInputToFactory.put(Anulacion.IDENTIFICACION, generateIdentificationInputData());
		jsonInputToFactory.put(Anulacion.EMISOR, generateEmisorInputData());
		jsonInputToFactory.put(Anulacion.DOCUMENTO, generateDocumentoInputData());
		jsonInputToFactory.put(Anulacion.MOTIVO, generateMotivoInputData());
	}
	
	private JSONObject generateIdentificationInputData() {
		System.out.println("Start collecting JSON data for Identificacion");
		
		Integer invoiceID = invoice.get_ID();
		String numeroControl = getNumeroControl(invoiceID, orgInfo, "DTE-01-");
		Integer clientID = (Integer)client.getAD_Client_ID();
		String codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(invoiceID.toString(), 12,"0");
		
		JSONObject jsonObjectIdentificacion = new JSONObject();
		jsonObjectIdentificacion.put(Anulacion.NUMEROCONTROL, numeroControl);
		jsonObjectIdentificacion.put(Anulacion.CODIGOGENERACION, codigoGeneracion);
		jsonObjectIdentificacion.put(Anulacion.TIPOMODELO, 1);
		jsonObjectIdentificacion.put(Anulacion.TIPOOPERACION, 1);
		jsonObjectIdentificacion.put(Anulacion.FECEMI, invoice.getDateAcct().toString().substring(0, 10));
		jsonObjectIdentificacion.put(Anulacion.HOREMI, "00:00:00");
		jsonObjectIdentificacion.put(Anulacion.TIPOMONEDA, "USD");
		jsonObjectIdentificacion.put(Anulacion.AMBIENTE, "00");

		System.out.println("Finish collecting JSON data for Identificacion");
		return jsonObjectIdentificacion;
		
	}
	
	private JSONObject generateEmisorInputData() {
		System.out.println("Start collecting JSON data for Emisor");
		
		JSONObject jsonObjectEmisor = new JSONObject();
		jsonObjectEmisor.put(Anulacion.NIT, orgInfo.getTaxID().replace("-", ""));
		jsonObjectEmisor.put(Anulacion.NRC, StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		jsonObjectEmisor.put(Anulacion.NOMBRE, client.getName());
		jsonObjectEmisor.put(Anulacion.CODACTIVIDAD, client.getE_Activity().getValue());
		jsonObjectEmisor.put(Anulacion.DESCACTIVIDAD, client.getE_Activity().getName());
		jsonObjectEmisor.put(Anulacion.NOMBRECOMERCIAL, client.getDescription());
		jsonObjectEmisor.put(Anulacion.TIPOESTABLECIMIENTO, client.getE_PlantType().getValue());

		JSONObject jsonDireccion = new JSONObject();
		jsonDireccion.put(Anulacion.DEPARTAMENTO, orgInfo.getC_Location().getC_City().getC_Region().getValue());
		jsonDireccion.put(Anulacion.MUNICIPIO, orgInfo.getC_Location().getC_City().getValue());
		jsonDireccion.put(Anulacion.COMPLEMENTO, orgInfo.getC_Location().getAddress1());
		jsonObjectEmisor.put(Anulacion.DIRECCION, jsonDireccion);
		
		jsonObjectEmisor.put(Anulacion.TELEFONO, client.get_ValueAsString("phone"));
		jsonObjectEmisor.put(Anulacion.CORREO, client.getEMail());

		System.out.println("Finish collecting JSON data for Emisor");
		return jsonObjectEmisor;
		
	}
	

	private JSONObject generateDocumentoInputData() {
		System.out.println("Start collecting JSON data for Documento");
		
		JSONObject jsonObjectDocumento = new JSONObject();
		jsonObjectDocumento.put(Anulacion.FECEMI, invoice.getDateAcct().toString().substring(0, 10));

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
    	ObjectMapper objectMapper = new ObjectMapper();
    	String facturaAsString    = objectMapper.writeValueAsString(anulacion);
        JSONObject  facturaAsJson = new JSONObject(facturaAsString);
        
        String finalAnulacionAsString = objectMapper.writeValueAsString(facturaAsJson);
		return finalAnulacionAsString;
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
