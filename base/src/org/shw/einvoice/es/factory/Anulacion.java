/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.anulacionv2.DocumentoAnulacion;
import org.shw.einvoice.es.anulacionv2.EmisorAnulacion;
import org.shw.einvoice.es.anulacionv2.IdentificacionAnulacion;
import org.shw.einvoice.es.anulacionv2.MotivoAnulacion;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.CuerpoDocumentoItem;
import org.shw.einvoice.es.util.pojo.Documento;
import org.shw.einvoice.es.util.pojo.DocumentoRelacionadoItem;
import org.shw.einvoice.es.util.pojo.Emisor;
import org.shw.einvoice.es.util.pojo.Extension;
import org.shw.einvoice.es.util.pojo.Identificacion;
import org.shw.einvoice.es.util.pojo.Motivo;
import org.shw.einvoice.es.util.pojo.OtrosDocumentosItem;
import org.shw.einvoice.es.util.pojo.Receptor;
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.VentaTercero;

/**
 * 
 */
public class Anulacion extends EDocument {
	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_CODIGOGENERACIONR_IS_NOT_NULL = "Documento: Anulacion, clase: Anulacion. Validacion falló: valor de 'codigoGeneracionR' debe ser ='null'";
	static final String VALIDATION_CODIGOGENERACIONR_IS_NULL = "Documento: Anulacion, clase: Anulacion. Validacion falló: valor de 'codigoGeneracionR' no deber ser ='null'";

	IdentificacionAnulacion identificacion;
	EmisorAnulacion emisor;
	DocumentoAnulacion documento;
	MotivoAnulacion motivo;
	
	AnulacionFactory anulacionFactory;  // This must be eliminated from JSON production.

	/**
	 * No parameters
	 */
	public Anulacion() {
		this.identificacion = (IdentificacionAnulacion) anulacionFactory.createIdentificacion();
		this.emisor         = (EmisorAnulacion) anulacionFactory.createEmisor();
		this.documento      = (DocumentoAnulacion) anulacionFactory.createDocumento();
		this.motivo         = (MotivoAnulacion) anulacionFactory.createMotivo();
	}



	public Anulacion(EDocumentFactory anulacionFactory) {
		// call constructor without parameters
		this();
		this.anulacionFactory = (AnulacionFactory) anulacionFactory;
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

		return VALIDATION_RESULT_OK;
	}


	/**
	 * @return the identificacion
	 */
	@Override
	public Identificacion getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = (IdentificacionAnulacion) identificacion;
	}



	@Override
	public void fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		anulacionFactory.fillIdentification((IdentificacionAnulacion) identificacion );
	}



	/**
	 * @return the emisor
	 */
	@Override
	public Emisor getEmisor() {
		return emisor;
	}


	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(Emisor emisor) {
		this.emisor = (EmisorAnulacion) emisor;
	}



	@Override
	public void fillEmisor(JSONObject factoryInput, Emisor emisor) {
		this.emisor = (EmisorAnulacion) emisor;
	}



	/**
	 * @return the documento
	 */
	@Override
	public Documento getDocumento() {
		return documento;
	}


	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(DocumentoAnulacion
			documento) {
		this.documento = documento;
	}


	@Override
	public void fillDocumento(Documento documento) {
		this.documento = (DocumentoAnulacion) documento;
	}


	/**
	 * @return the motivo
	 */
	@Override
	public Motivo getMotivo() {
		return motivo;
	}


	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(MotivoAnulacion motivo) {
		this.motivo = motivo;
	}


	@Override
	public void fillMotivo(Motivo motivo) {
		this.motivo = (MotivoAnulacion) motivo;
	}


	/**
	 * THIS CLASS DOESN'T HAVE A DOCUMENTORELACIONADOITEM PROPERTY
	 */
	@Override
	public List<DocumentoRelacionadoItem> getDocumentoRelacionado() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumentoRelacionado(JSONObject factoryInput,List<DocumentoRelacionadoItem> documentoRelacionado) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Anulacion.fillDocumentoRelacionado() is not allowed");
	}


	/**
	 * THIS CLASS DOESN'T HAVE A RECEPTOR PROPERTY
	 */
	@Override
	public Receptor getReceptor() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillReceptor(Receptor receptor) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Anulacion.fillReceptor() is not allowed");
	}


	/**
	 * THIS CLASS DOESN'T HAVE AN OTROSDOCUMENTOSITEM PROPERTY
	 */
	@Override
	public List<OtrosDocumentosItem> getOtrosDocumentos() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Anulacion.fillOtrosDocumentos() is not allowed");
	}


	/**
	 * THIS CLASS DOESN'T HAVE A VENTATERCERO PROPERTY
	 */
	@Override
	public VentaTercero getVentaTercero() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillVentaTercero(VentaTercero ventaTercero) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Anulacion.fillVentaTercero() is not allowed");
	}


	/**
	 * THIS CLASS DOESN'T HAVE A CUERPODOCUMENTOITEM PROPERTY
	 */
	@Override
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Anulacion.fillCuerpoDocumento() is not allowed");
	}


	/**
	 * THIS CLASS DOESN'T HAVE A RESUMEN PROPERTY
	 */
	@Override
	public Resumen getResumen() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillResumen(Resumen resumen) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Anulacion.fillResumen() is not allowed");
	}


	/**
	 * THIS CLASS DOESN'T HAVE AN EXTENSION PROPERTY
	 */
	@Override
	public Extension getExtension() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillExtension(Extension extension) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Anulacion.fillExtension() is not allowed");
	}


	/**
	 * THIS CLASS DOESN'T HAVE AN APENDICE PROPERTY
	 */
	@Override
	public List<ApendiceItem> getApendice() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillApendice(List<ApendiceItem> apendice) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Anulacion.fillApendice() is not allowed");
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
