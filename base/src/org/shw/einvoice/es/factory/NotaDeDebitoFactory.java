/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.fendnotadedebitov3.ApendiceItemNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.CuerpoDocumentoItemNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.DocumentoRelacionadoItemNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.EmisorNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.ExtensionNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.IdentificacionNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.ReceptorNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.ResumenNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.VentaTerceroNotaDeDebito;
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
public class NotaDeDebitoFactory implements EDocumentFactory {
	
	@Override
	public Identificacion createIdentificacion() {
		Identificacion identificacion = new IdentificacionNotaDeDebito();
		return identificacion;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoRelacionadoItem> createDocumentoRelacionado() { 
	    List<?> tempList = new ArrayList<DocumentoRelacionadoItemNotaDeDebito>();
	    List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}

	@Override
	public Emisor createEmisor() {
		Emisor emisor = new EmisorNotaDeDebito();
		return emisor;
	}

	@Override
	public Receptor createReceptor() {
		Receptor receptor = new ReceptorNotaDeDebito();
		return receptor;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<OtrosDocumentosItem> createOtrosDocumentos() {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebitoFactory.createOtrosDocumentos() is not allowed");
	}

	@Override
	public VentaTercero createVentaTercero() {
		VentaTercero ventaTercero = new VentaTerceroNotaDeDebito();
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
	    List<?> tempList = new ArrayList<CuerpoDocumentoItemNotaDeDebito>();
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	@Override
	public Resumen createResumen() {
		Resumen resumen = new ResumenNotaDeDebito();
		return resumen;
	}

	@Override
	public Extension createExtension() {
		Extension extension = new ExtensionNotaDeDebito();
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
	    List<?> tempList = new ArrayList<ApendiceItemNotaDeDebito>();
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	@Override
	public void fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		IdentificacionNotaDeDebito identificacionNotaDeDebito = (IdentificacionNotaDeDebito) identificacion;
	}


	@Override
	public void fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		// Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemNotaDeDebito)
		List<DocumentoRelacionadoItemNotaDeDebito> documentoRelacionadoItemNotaDeDebito= new ArrayList<DocumentoRelacionadoItemNotaDeDebito>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemNotaDeDebito.add((DocumentoRelacionadoItemNotaDeDebito) e) );
		
	}


	@Override
	public void fillEmisor(JSONObject factoryInput, Emisor emisor) {
		EmisorNotaDeDebito emisorNotaDeDebito = (EmisorNotaDeDebito) emisor;
	}


	@Override
	public void fillReceptor(JSONObject factoryInput, Receptor receptor) {
		ReceptorNotaDeDebito receptorNotaDeDebito = (ReceptorNotaDeDebito) receptor;
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebitoFactory.fillOtrosDocumentos() is not allowed");
	}


	@Override
	public void fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		VentaTerceroNotaDeDebito ventaTerceroNotaDeDebito = (VentaTerceroNotaDeDebito) ventaTercero;
	}


	@Override
	public void fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemNotaDeDebito)
		List<CuerpoDocumentoItemNotaDeDebito> cuerpoDocumentoItemNotaDeDebito= new ArrayList<CuerpoDocumentoItemNotaDeDebito>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemNotaDeDebito.add((CuerpoDocumentoItemNotaDeDebito) e) );
	}


	@Override
	public void fillResumen(JSONObject factoryInput, Resumen resumen) {
		ResumenNotaDeDebito resumenNotaDeDebito = (ResumenNotaDeDebito) resumen;
	}


	@Override
	public void fillExtension(JSONObject factoryInput, Extension extension) {
		ExtensionNotaDeDebito extensionNotaDeDebito = (ExtensionNotaDeDebito) extension;
	}


	@Override
	public void fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemNotaDeDebito)
		List<ApendiceItemNotaDeDebito> apendiceItemNotaDeDebito= new ArrayList<ApendiceItemNotaDeDebito>();
		apendice.stream().forEach(e -> apendiceItemNotaDeDebito.add((ApendiceItemNotaDeDebito) e) );
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Documento createDocumento() {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebitoFactory.createDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Motivo createMotivo() {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebitoFactory.createMotivo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumento(Documento documento) {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebitoFactory.fillDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillMotivo(Motivo motivo) {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebitoFactory.fillMotivo() is not allowed");
	}


}
