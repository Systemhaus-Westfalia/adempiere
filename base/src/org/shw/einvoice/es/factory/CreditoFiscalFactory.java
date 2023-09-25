/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.feccfcreditofiscalv3.ApendiceItemCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.CuerpoDocumentoItemCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.DocumentoRelacionadoItemCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.EmisorCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.ExtensionCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.IdentificacionCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.OtrosDocumentosItemCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.ReceptorCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.ResumenCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.VentaTerceroCreditoFiscal;
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
 * List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionado = new ArrayList<DocumentoRelacionadoItemCreditoFiscal>();
 * List<?> tempList = (List<DocumentoRelacionadoItemCreditoFiscal>) documentoRelacionado;
 * List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
 * 
 */
public class CreditoFiscalFactory implements EDocumentFactory {
	
	@Override
	public Identificacion createIdentificacion() {
		Identificacion identificacion = new IdentificacionCreditoFiscal();
		return identificacion;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoRelacionadoItem> createDocumentoRelacionado() {
	    List<?> tempList = new ArrayList<DocumentoRelacionadoItemCreditoFiscal>();
	    List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}

	@Override
	public Emisor createEmisor() {
		Emisor emisor = new EmisorCreditoFiscal();
		return emisor;
	}

	@Override
	public Receptor createReceptor() {
		Receptor receptor = new ReceptorCreditoFiscal();
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
	public List<OtrosDocumentosItem> createOtrosDocumentos() { 
		List<?> tempList = new ArrayList<OtrosDocumentosItemCreditoFiscal>();
		List<OtrosDocumentosItem> finalList = (List<OtrosDocumentosItem>)tempList;
		return finalList;
	}

	@Override
	public VentaTercero createVentaTercero() {
		VentaTercero ventaTercero = new VentaTerceroCreditoFiscal();
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
	    List<?> tempList = new ArrayList<CuerpoDocumentoItemCreditoFiscal>();
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	@Override
	public Resumen createResumen() {
		Resumen resumen = new ResumenCreditoFiscal();
		return resumen;
	}

	@Override
	public Extension createExtension() {
		Extension extension = new ExtensionCreditoFiscal();
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
	    List<?> tempList = new ArrayList<ApendiceItemCreditoFiscal>();
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	@Override
	public void fillIdentification(Identificacion identificacion) {
		IdentificacionCreditoFiscal identificacionCreditoFiscal = (IdentificacionCreditoFiscal) identificacion;
	}


	@Override
	public void fillDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado) {
		// Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemCreditoFiscal)
		List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionadoItemCreditoFiscal= new ArrayList<DocumentoRelacionadoItemCreditoFiscal>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemCreditoFiscal.add((DocumentoRelacionadoItemCreditoFiscal) e) );
		
	}


	@Override
	public void fillEmisor(Emisor emisor) {
		EmisorCreditoFiscal emisorCreditoFiscal = (EmisorCreditoFiscal) emisor;
	}


	@Override
	public void fillReceptor(Receptor receptor) {
		ReceptorCreditoFiscal receptorCreditoFiscal = (ReceptorCreditoFiscal) receptor;
	}


	@Override
	public void fillOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos) {
		// Convert (=cast) all (OtrosDocumentosItem) to (OtrosDocumentosItemCreditoFiscal)
		List<OtrosDocumentosItemCreditoFiscal> otrosDocumentosItemCreditoFiscal= new ArrayList<OtrosDocumentosItemCreditoFiscal>();
		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemCreditoFiscal.add((OtrosDocumentosItemCreditoFiscal) e) );
	}


	@Override
	public void fillVentaTercero(VentaTercero ventaTercero) {
		VentaTerceroCreditoFiscal ventaTerceroCreditoFiscal = (VentaTerceroCreditoFiscal) ventaTercero;
	}


	@Override
	public void fillCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemCreditoFiscal)
		List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumentoItemCreditoFiscal= new ArrayList<CuerpoDocumentoItemCreditoFiscal>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemCreditoFiscal.add((CuerpoDocumentoItemCreditoFiscal) e) );
	}


	@Override
	public void fillResumen(Resumen resumen) {
		ResumenCreditoFiscal resumenCreditoFiscal = (ResumenCreditoFiscal) resumen;
	}


	@Override
	public void fillExtension(Extension extension) {
		ExtensionCreditoFiscal extensionCreditoFiscal = (ExtensionCreditoFiscal) extension;
	}


	@Override
	public void fillApendice(List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemCreditoFiscal)
		List<ApendiceItemCreditoFiscal> apendiceItemCreditoFiscal= new ArrayList<ApendiceItemCreditoFiscal>();
		apendice.stream().forEach(e -> apendiceItemCreditoFiscal.add((ApendiceItemCreditoFiscal) e) );
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Documento createDocumento() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method CreditoFiscalFactory.createDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Motivo createMotivo() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method CreditoFiscalFactory.createMotivo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumento(Documento documento) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method CreditoFiscalFactory.fillDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillMotivo(Motivo motivo) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method CreditoFiscalFactory.fillMotivo() is not allowed");
	}


}
