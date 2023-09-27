/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.fecrretencionv1.ApendiceItemRetencion;
import org.shw.einvoice.es.fecrretencionv1.CuerpoDocumentoItemRetencion;
import org.shw.einvoice.es.fecrretencionv1.EmisorRetencion;
import org.shw.einvoice.es.fecrretencionv1.ExtensionRetencion;
import org.shw.einvoice.es.fecrretencionv1.IdentificacionRetencion;
import org.shw.einvoice.es.fecrretencionv1.ReceptorRetencion;
import org.shw.einvoice.es.fecrretencionv1.ResumenRetencion;
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
 * To cast Lists where B extends A
 * 
 * List<B> b = new ArrayList<>();
 * List<?> t = (List<B>)b;
 * List<A> a = (List<A>)t;
 * 
 */
public class RetencionFactory implements EDocumentFactory {
	StringBuffer errorMessages = new StringBuffer();
	
	@Override
	public Identificacion createIdentificacion() {
		Identificacion identificacion = new IdentificacionRetencion();
		return identificacion;
	}

	@Override
	public Emisor createEmisor() {
		Emisor emisor = new EmisorRetencion();
		return emisor;
	}

	@Override
	public Receptor createReceptor() {
		Receptor receptor = new ReceptorRetencion();
		return receptor;
	}

	/**
	 * To cast Lists where B extends A
	 * 
	 * List<B> b = new ArrayList<>();
	 * List<?> t = (List<B>)b;
	 * List<A> a = (List<A>)t;
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CuerpoDocumentoItem> createCuerpoDocumento() {
	    List<?> tempList = new ArrayList<CuerpoDocumentoItemRetencion>();
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	@Override
	public Resumen createResumen() {
		Resumen resumen = new ResumenRetencion();
		return resumen;
	}

	@Override
	public Extension createExtension() {
		Extension extension = new ExtensionRetencion();
		return extension;
	}


	/**
	 * To cast Lists where B extends A
	 * 
	 * List<B> b = new ArrayList<>();
	 * List<?> t = (List<B>)b;
	 * List<A> a = (List<A>)t;
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApendiceItem> createApendice() {
	    List<?> tempList = new ArrayList<ApendiceItemRetencion>();
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	@Override
	public StringBuffer fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		IdentificacionRetencion identificacionRetencion = (IdentificacionRetencion) identificacion;
		
		return errorMessages;
	}


	@Override
	public StringBuffer fillEmisor(JSONObject factoryInput, Emisor emisor) {
		EmisorRetencion emisorRetencion = (EmisorRetencion) emisor;
		return errorMessages;
	}


	@Override
	public StringBuffer fillReceptor(JSONObject factoryInput, Receptor receptor) {
		ReceptorRetencion receptorRetencion = (ReceptorRetencion) receptor;
		return errorMessages;
	}


	@Override
	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemRetencion)
		List<CuerpoDocumentoItemRetencion> cuerpoDocumentoItemRetencion= new ArrayList<CuerpoDocumentoItemRetencion>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemRetencion.add((CuerpoDocumentoItemRetencion) e) );
		return errorMessages;
	}


	@Override
	public StringBuffer fillResumen(JSONObject factoryInput, Resumen resumen) {
		ResumenRetencion resumenRetencion = (ResumenRetencion) resumen;
		return errorMessages;
	}


	@Override
	public StringBuffer fillExtension(JSONObject factoryInput, Extension extension) {
		ExtensionRetencion extensionRetencion = (ExtensionRetencion) extension;
		return errorMessages;
	}


	@Override
	public StringBuffer fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemRetencion)
		List<ApendiceItemRetencion> apendiceItemRetencion= new ArrayList<ApendiceItemRetencion>();
		apendice.stream().forEach(e -> apendiceItemRetencion.add((ApendiceItemRetencion) e) );
		return errorMessages;
	}
	


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<DocumentoRelacionadoItem> createDocumentoRelacionado() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createDocumentoRelacionado() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<OtrosDocumentosItem> createOtrosDocumentos() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createOtrosDocumentos() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public VentaTercero createVentaTercero() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createVentaTercero() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Documento createDocumento() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Motivo createMotivo() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createMotivo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.fillDocumentoRelacionado() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.fillOtrosDocumentos() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.fillVentaTercero() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillDocumento(JSONObject factoryInput, Documento documento) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.fillDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillMotivo(JSONObject factoryInput, Motivo motivo) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.fillMotivo() is not allowed");
	}


}
