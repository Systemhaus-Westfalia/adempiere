/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.fencnotadecreditov1.ApendiceItemNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.CuerpoDocumentoItemNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.DocumentoRelacionadoItemNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.EmisorNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.ExtensionNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.IdentificacionNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.ReceptorNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.ResumenNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.VentaTerceroNotaDeCredito;
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
public class NotaDeCreditoFactory implements EDocumentFactory {
	StringBuffer errorMessages = new StringBuffer();
	
	@Override
	public Identificacion createIdentificacion() {
		Identificacion identificacion = new IdentificacionNotaDeCredito();
		return identificacion;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoRelacionadoItem> createDocumentoRelacionado() { 
	    List<?> tempList = new ArrayList<DocumentoRelacionadoItemNotaDeCredito>();
	    List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}

	@Override
	public Emisor createEmisor() {
		Emisor emisor = new EmisorNotaDeCredito();
		return emisor;
	}

	@Override
	public Receptor createReceptor() {
		Receptor receptor = new ReceptorNotaDeCredito();
		return receptor;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<OtrosDocumentosItem> createOtrosDocumentos() {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCreditoFactory.createOtrosDocumentos() is not allowed");
	}

	@Override
	public VentaTercero createVentaTercero() {
		VentaTercero ventaTercero = new VentaTerceroNotaDeCredito();
		return ventaTercero;
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
	    List<?> tempList = new ArrayList<CuerpoDocumentoItemNotaDeCredito>();
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	@Override
	public Resumen createResumen() {
		Resumen resumen = new ResumenNotaDeCredito();
		return resumen;
	}

	@Override
	public Extension createExtension() {
		Extension extension = new ExtensionNotaDeCredito();
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
	    List<?> tempList = new ArrayList<ApendiceItemNotaDeCredito>();
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	@Override
	public StringBuffer fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		IdentificacionNotaDeCredito identificacionNotaDeCredito = (IdentificacionNotaDeCredito) identificacion;
		
		return errorMessages;
	}


	@Override
	public StringBuffer fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		// Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemNotaDeCredito)
		List<DocumentoRelacionadoItemNotaDeCredito> documentoRelacionadoItemNotaDeCredito= new ArrayList<DocumentoRelacionadoItemNotaDeCredito>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemNotaDeCredito.add((DocumentoRelacionadoItemNotaDeCredito) e) );
		

		return errorMessages;
	}


	@Override
	public StringBuffer fillEmisor(JSONObject factoryInput, Emisor emisor) {
		EmisorNotaDeCredito emisorNotaDeCredito = (EmisorNotaDeCredito) emisor;
		return errorMessages;
	}


	@Override
	public StringBuffer fillReceptor(JSONObject factoryInput, Receptor receptor) {
		ReceptorNotaDeCredito receptorNotaDeCredito = (ReceptorNotaDeCredito) receptor;
		return errorMessages;
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCreditoFactory.fillOtrosDocumentos() is not allowed");
	}


	@Override
	public StringBuffer fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		VentaTerceroNotaDeCredito ventaTerceroNotaDeCredito = (VentaTerceroNotaDeCredito) ventaTercero;
		return errorMessages;
	}


	@Override
	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemNotaDeCredito)
		List<CuerpoDocumentoItemNotaDeCredito> cuerpoDocumentoItemNotaDeCredito= new ArrayList<CuerpoDocumentoItemNotaDeCredito>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemNotaDeCredito.add((CuerpoDocumentoItemNotaDeCredito) e) );
		return errorMessages;
	}


	@Override
	public StringBuffer fillResumen(JSONObject factoryInput, Resumen resumen) {
		ResumenNotaDeCredito resumenNotaDeCredito = (ResumenNotaDeCredito) resumen;
		return errorMessages;
	}


	@Override
	public StringBuffer fillExtension(JSONObject factoryInput, Extension extension) {
		ExtensionNotaDeCredito extensionNotaDeCredito = (ExtensionNotaDeCredito) extension;
		return errorMessages;
	}


	@Override
	public StringBuffer fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemNotaDeCredito)
		List<ApendiceItemNotaDeCredito> apendiceItemNotaDeCredito= new ArrayList<ApendiceItemNotaDeCredito>();
		apendice.stream().forEach(e -> apendiceItemNotaDeCredito.add((ApendiceItemNotaDeCredito) e) );
		return errorMessages;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Documento createDocumento() {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCreditoFactory.createDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Motivo createMotivo() {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCreditoFactory.createMotivo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillDocumento(JSONObject factoryInput, Documento documento) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCreditoFactory.fillDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillMotivo(JSONObject factoryInput, Motivo motivo) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCreditoFactory.fillMotivo() is not allowed");
	}


}
