/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ApendiceItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.CuerpoDocumentoItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.EmisorFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.IdentificacionFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.OtrosDocumentosItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ReceptorFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ResumenFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.VentaTerceroFacturaExportacion;
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
public class FacturaExportacionFactory implements EDocumentFactory {
	
	@Override
	public Identificacion createIdentificacion() {
		Identificacion identificacion = new IdentificacionFacturaExportacion();
		return identificacion;
	}



	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<DocumentoRelacionadoItem> createDocumentoRelacionado() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacionFactory.createDocumentoRelacionado() is not allowed");
	}

	@Override
	public Emisor createEmisor() {
		Emisor emisor = new EmisorFacturaExportacion();
		return emisor;
	}

	@Override
	public Receptor createReceptor() {
		Receptor receptor = new ReceptorFacturaExportacion();
		return receptor;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OtrosDocumentosItem> createOtrosDocumentos() { 
		List<?> tempList = new ArrayList<OtrosDocumentosItemFacturaExportacion>();
		List<OtrosDocumentosItem> finalList = (List<OtrosDocumentosItem>)tempList;
		return finalList;
	}

	@Override
	public VentaTercero createVentaTercero() {
		VentaTercero ventaTercero = new VentaTerceroFacturaExportacion();
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
	    List<?> tempList = new ArrayList<CuerpoDocumentoItemFacturaExportacion>();
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	@Override
	public Resumen createResumen() {
		Resumen resumen = new ResumenFacturaExportacion();
		return resumen;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Extension createExtension() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacionFactory.createExtension() is not allowed");
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
	    List<?> tempList = new ArrayList<ApendiceItemFacturaExportacion>();
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	@Override
	public void fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		IdentificacionFacturaExportacion identificacionFacturaExportacion = (IdentificacionFacturaExportacion) identificacion;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacionFactory.fillDocumentoRelacionado() is not allowed");
	}


	@Override
	public void fillEmisor(JSONObject factoryInput, Emisor emisor) {
		EmisorFacturaExportacion emisorFacturaExportacion = (EmisorFacturaExportacion) emisor;
	}


	@Override
	public void fillReceptor(JSONObject factoryInput, Receptor receptor) {
		ReceptorFacturaExportacion receptorFacturaExportacion = (ReceptorFacturaExportacion) receptor;
	}


	@Override
	public void fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		// Convert (=cast) all (OtrosDocumentosItem) to (OtrosDocumentosItemFacturaExportacion)
		List<OtrosDocumentosItemFacturaExportacion> otrosDocumentosItemFacturaExportacion = new ArrayList<OtrosDocumentosItemFacturaExportacion>();
		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemFacturaExportacion.add((OtrosDocumentosItemFacturaExportacion) e) );
	}


	@Override
	public void fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		VentaTerceroFacturaExportacion ventaTerceroFacturaExportacion = (VentaTerceroFacturaExportacion) ventaTercero;
	}


	@Override
	public void fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemFacturaExportacion)
		List<CuerpoDocumentoItemFacturaExportacion> cuerpoDocumentoItemFacturaExportacion = new ArrayList<CuerpoDocumentoItemFacturaExportacion>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemFacturaExportacion.add((CuerpoDocumentoItemFacturaExportacion) e) );
	}


	@Override
	public void fillResumen(JSONObject factoryInput, Resumen resumen) {
		ResumenFacturaExportacion resumenFacturaExportacion = (ResumenFacturaExportacion) resumen;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillExtension(JSONObject factoryInput, Extension extension) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacionFactory.fillExtension() is not allowed");
	}


	@Override
	public void fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemFacturaExportacion)
		List<ApendiceItemFacturaExportacion> apendiceItemFacturaExportacion = new ArrayList<ApendiceItemFacturaExportacion>();
		apendice.stream().forEach(e -> apendiceItemFacturaExportacion.add((ApendiceItemFacturaExportacion) e) );
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Documento createDocumento() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacionFactory.createDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Motivo createMotivo() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacionFactory.createMotivo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumento(Documento documento) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacionFactory.fillDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillMotivo(Motivo motivo) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacionFactory.fillMotivo() is not allowed");
	}

}
