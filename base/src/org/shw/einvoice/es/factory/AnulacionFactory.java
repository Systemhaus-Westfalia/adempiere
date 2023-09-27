/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.util.ArrayList;
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


public class AnulacionFactory implements EDocumentFactory {
	StringBuffer errorMessages = new StringBuffer();
	
	@Override
	public Identificacion createIdentificacion() {
		Identificacion identificacion = new IdentificacionAnulacion();
		return identificacion;
	}

	@Override
	public Emisor createEmisor() {
		Emisor emisor = new EmisorAnulacion();
		return emisor;
	}


	@Override
	public StringBuffer fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		IdentificacionAnulacion identificacionAnulacion = (IdentificacionAnulacion) identificacion;
		
		return errorMessages;
	}


	@Override
	public StringBuffer fillEmisor(JSONObject factoryInput, Emisor emisor) {
		EmisorAnulacion emisorAnulacion = (EmisorAnulacion) emisor;
		return errorMessages;
	}

	@Override
	public Documento createDocumento() {
		Documento documento = new DocumentoAnulacion();
		return documento;
	}

	@Override
	public Motivo createMotivo() {
		Motivo motivo = new MotivoAnulacion();
		return motivo;
	}

	@Override
	public StringBuffer fillDocumento(JSONObject factoryInput, Documento documento) {
		DocumentoAnulacion documentoAnulacion = (DocumentoAnulacion) documento;
		return errorMessages;
	}

	@Override
	public StringBuffer fillMotivo(JSONObject factoryInput, Motivo motivo) {
		MotivoAnulacion motivoAnulacion = (MotivoAnulacion) motivo;
		return errorMessages;
	}

	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<DocumentoRelacionadoItem> createDocumentoRelacionado() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Receptor createReceptor() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<OtrosDocumentosItem> createOtrosDocumentos() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public VentaTercero createVentaTercero() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<CuerpoDocumentoItem> createCuerpoDocumento() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Resumen createResumen() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Extension createExtension() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<ApendiceItem> createApendice() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createApendice() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.fillDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillReceptor(JSONObject factoryInput, Receptor receptor) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.fillReceptor() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.fillOtrosDocumentos() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.fillVentaTercero() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.fillCuerpoDocumento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillResumen(JSONObject factoryInput, Resumen resumen) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillExtension(JSONObject factoryInput, Extension extension) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}

	@Override
	public StringBuffer fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method AnulacionFactory.createDocumentoRelacionado() is not allowed");
	}
	


}
