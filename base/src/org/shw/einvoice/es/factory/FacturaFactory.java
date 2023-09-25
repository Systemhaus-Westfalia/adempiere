/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.fefcfacturaelectronicav1.ApendiceItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.CuerpoDocumentoItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.DocumentoRelacionadoItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.EmisorFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.ExtensionFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.IdentificacionFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.OtrosDocumentosItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.ReceptorFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.ResumenFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.VentaTerceroFactura;
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
public class FacturaFactory implements EDocumentFactory {
	
	@Override
	public Identificacion createIdentificacion() {
		Identificacion identificacion = new IdentificacionFactura();
		return identificacion;
	}

	/**
	 * To cast Lists where B extends A
	 * 
	 * List<B> b = new ArrayList<>();
	 * List<?> t = (List<B>)b;
	 * List<A> a = (List<A>)t;
	 * 
	 * List<DocumentoRelacionadoItemFactura> documentoRelacionado = new ArrayList<DocumentoRelacionadoItemFactura>();
	 * List<?> tempList = (List<DocumentoRelacionadoItemFactura>) documentoRelacionado;
	 * List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoRelacionadoItem> createDocumentoRelacionado() {
	    List<?> tempList = new ArrayList<DocumentoRelacionadoItemFactura>();
	    List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}

	@Override
	public Emisor createEmisor() {
		Emisor emisor = new EmisorFactura();
		return emisor;
	}

	@Override
	public Receptor createReceptor() {
		Receptor receptor = new ReceptorFactura();
		return receptor;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OtrosDocumentosItem> createOtrosDocumentos() {
		    List<?> tempList = new ArrayList<OtrosDocumentosItemFactura>();
		    List<OtrosDocumentosItem> finalList = (List<OtrosDocumentosItem>)tempList;
			return finalList;
	}

	@Override
	public VentaTercero createVentaTercero() {
		VentaTercero ventaTercero = new VentaTerceroFactura();
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
	    List<?> tempList = new ArrayList<CuerpoDocumentoItemFactura>();
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	@Override
	public Resumen createResumen() {
		Resumen resumen = new ResumenFactura();
		return resumen;
	}

	@Override
	public Extension createExtension() {
		Extension extension = new ExtensionFactura();
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
	    List<?> tempList = new ArrayList<ApendiceItemFactura>();
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	@Override
	public void fillIdentification(Identificacion identificacion) {
		IdentificacionFactura identificacionFactura = (IdentificacionFactura) identificacion;
	}


	@Override
	public void fillDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado) {
		// Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemFactura)
		List<DocumentoRelacionadoItemFactura> documentoRelacionadoItemFactura = new ArrayList<DocumentoRelacionadoItemFactura>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemFactura.add((DocumentoRelacionadoItemFactura) e) );
		
	}


	@Override
	public void fillEmisor(Emisor emisor) {
		EmisorFactura emisorFactura = (EmisorFactura) emisor;
	}


	@Override
	public void fillReceptor(Receptor receptor) {
		ReceptorFactura receptorFactura = (ReceptorFactura) receptor;
	}


	@Override
	public void fillOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos) {
		// Convert (=cast) all (OtrosDocumentosItem) to (OtrosDocumentosItemFactura)
		List<OtrosDocumentosItemFactura> otrosDocumentosItemFactura = new ArrayList<OtrosDocumentosItemFactura>();
		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemFactura.add((OtrosDocumentosItemFactura) e) );
	}


	@Override
	public void fillVentaTercero(VentaTercero ventaTercero) {
		VentaTerceroFactura ventaTerceroFactura = (VentaTerceroFactura) ventaTercero;
	}


	@Override
	public void fillCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemFactura)
		List<CuerpoDocumentoItemFactura> cuerpoDocumentoItemFactura = new ArrayList<CuerpoDocumentoItemFactura>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemFactura.add((CuerpoDocumentoItemFactura) e) );
	}


	@Override
	public void fillResumen(Resumen resumen) {
		ResumenFactura resumenFactura = (ResumenFactura) resumen;
	}


	@Override
	public void fillExtension(Extension extension) {
		ExtensionFactura extensionFactura = (ExtensionFactura) extension;
	}


	@Override
	public void fillApendice(List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemFactura)
		List<ApendiceItemFactura> apendiceItemFactura = new ArrayList<ApendiceItemFactura>();
		apendice.stream().forEach(e -> apendiceItemFactura.add((ApendiceItemFactura) e) );
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Documento createDocumento() {
		throw new UnsupportedOperationException("In Document Factura calling the method FacturaFactory.createDocumento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumento(Documento documento) {
		throw new UnsupportedOperationException("In Document Factura calling the method FacturaFactory.fillDocumento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Motivo createMotivo() {
		throw new UnsupportedOperationException("In Document Factura calling the method FacturaFactory.createMotivo() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillMotivo(Motivo motivo) {
		throw new UnsupportedOperationException("In Document Factura calling the method FacturaFactory.fillMotivo() is not allowed");
	}


}
