/**
 * 
 */
package org.shw.einvoice.es.factory;

import org.json.JSONObject;
import org.shw.einvoice.es.anulacionv2.DocumentoAnulacion;
import org.shw.einvoice.es.anulacionv2.EmisorAnulacion;
import org.shw.einvoice.es.anulacionv2.IdentificacionAnulacion;
import org.shw.einvoice.es.anulacionv2.MotivoAnulacion;
import org.shw.einvoice.es.util.pojo.EDocument;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;

/**
 * 
 */
public class Anulacion extends EDocument {
	static final String VALIDATION_CODIGOGENERACIONR_IS_NOT_NULL = "Documento: Anulacion, clase: Anulacion. Validacion falló: valor de 'codigoGeneracionR' debe ser ='null'";
	static final String VALIDATION_CODIGOGENERACIONR_IS_NULL = "Documento: Anulacion, clase: Anulacion. Validacion falló: valor de 'codigoGeneracionR' no deber ser ='null'";

	IdentificacionAnulacion identificacion;
	EmisorAnulacion emisor;
	DocumentoAnulacion documento;
	MotivoAnulacion motivo;
	/**
	 * No parameters
	 */
	public Anulacion() {
		this.identificacion = new IdentificacionAnulacion();
		this.emisor         = new EmisorAnulacion();
		this.documento      = new DocumentoAnulacion();
		this.motivo         = new MotivoAnulacion();
	}


	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {

		if(getMotivo().getTipoAnulacion()==2) {
			if ( getDocumento().getCodigoGeneracionR()!= null)
				return VALIDATION_CODIGOGENERACIONR_IS_NOT_NULL;
		} else {
			if ( getDocumento().getCodigoGeneracionR()== null)
				return VALIDATION_CODIGOGENERACIONR_IS_NULL;
		}

		return EDocumentUtils.VALIDATION_RESULT_OK;
	}


	/**
	 * @return the identificacion
	 */
	public IdentificacionAnulacion getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionAnulacion identificacion) {
		this.identificacion = identificacion;
	}



	public StringBuffer fillIdentification(JSONObject factoryInput) {
		System.out.println("Start Anulacion.fillIdentificacion()"); 
		errorMessages.setLength(0);

		JSONObject identificationJson = factoryInput.getJSONObject(IDENTIFICACION);
		try {identificacion.setVersion(identificationJson.getInt(VERSION));} 		catch (Exception e) {errorMessages.append(e);}
		//TODO weitere Properties setzen

		System.out.println("End Anulacion.fillIdentificacion()");
		return errorMessages;
	}



	/**
	 * @return the emisor
	 */
	public EmisorAnulacion getEmisor() {
		return emisor;
	}


	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorAnulacion emisor) {
		this.emisor = emisor;
	}



	public StringBuffer fillEmisor(JSONObject factoryInput) {
		System.out.println("Start Anulacion.fillEmisor()"); 
		errorMessages.setLength(0);

		JSONObject emisorJson = factoryInput.getJSONObject(EMISOR);
		try {emisor.setCodEstable(emisorJson.getString(CODESTABLE));} 		catch (Exception e) {errorMessages.append(e);}
		//TODO weitere Properties setzen

		System.out.println("End Anulacion.fillEmisor()");
		return errorMessages;
	}



	/**
	 * @return the documento
	 */
	public DocumentoAnulacion getDocumento() {
		return documento;
	}


	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(DocumentoAnulacion	documento) {
		this.documento = documento;
	}


	public StringBuffer fillDocumento(JSONObject factoryInput) {
		System.out.println("Start Anulacion.fillDocumento()"); 
		errorMessages.setLength(0);

		JSONObject documentoJson = factoryInput.getJSONObject(DOCUMENTO);
		try {documento.setCodigoGeneracion(documentoJson.getString(CODIGOGENERACION));} 		catch (Exception e) {errorMessages.append(e);}
		//TODO weitere Properties setzen

		System.out.println("End Anulacion.fillDocumento()");
		return errorMessages;
	}


	/**
	 * @return the motivo
	 */
	public MotivoAnulacion getMotivo() {
		return motivo;
	}


	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(MotivoAnulacion motivo) {
		this.motivo = motivo;
	}


	public StringBuffer fillMotivo(JSONObject factoryInput) {
		System.out.println("Start Anulacion.fillDocumento()"); 
		errorMessages.setLength(0);

		JSONObject motivoJson = factoryInput.getJSONObject(DOCUMENTO);
		try {motivo.setMotivoAnulacion(motivoJson.getString(MOTIVOANULACION));} 		catch (Exception e) {errorMessages.append(e);}
		//TODO weitere Properties setzen

		System.out.println("End Anulacion.fillDocumento()");
		return errorMessages;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
