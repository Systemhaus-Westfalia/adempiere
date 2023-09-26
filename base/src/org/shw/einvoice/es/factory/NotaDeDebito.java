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
 * 
 */
public class NotaDeDebito extends EDocument {

	IdentificacionNotaDeDebito identificacion;
	List<DocumentoRelacionadoItemNotaDeDebito> documentoRelacionado;
	EmisorNotaDeDebito emisor;
	ReceptorNotaDeDebito receptor;
	VentaTerceroNotaDeDebito ventaTercero = null;
	List<CuerpoDocumentoItemNotaDeDebito> cuerpoDocumento;
	ResumenNotaDeDebito resumen;
	ExtensionNotaDeDebito extension;
	List<ApendiceItemNotaDeDebito> apendice=null;  // null allowed

	NotaDeDebitoFactory notaDeDebitoFactory;  // This must be eliminated from JSON production.

	/**
	 * No parameters
	 */
	public NotaDeDebito() {
		List<?> tmpList;
		this.identificacion       = (IdentificacionNotaDeDebito) notaDeDebitoFactory.createIdentificacion();
		
	    tmpList = (List<DocumentoRelacionadoItem>) notaDeDebitoFactory.createDocumentoRelacionado();
	    this.documentoRelacionado = (List<DocumentoRelacionadoItemNotaDeDebito>) tmpList;

		this.emisor               = (EmisorNotaDeDebito) notaDeDebitoFactory.createEmisor();
		this.receptor             = (ReceptorNotaDeDebito) notaDeDebitoFactory.createReceptor();
		this.ventaTercero         = (VentaTerceroNotaDeDebito) notaDeDebitoFactory.createVentaTercero();  // must be eliminated from JSON

	    tmpList = (List<CuerpoDocumentoItem>) notaDeDebitoFactory.createCuerpoDocumento();
	    this.cuerpoDocumento      = (List<CuerpoDocumentoItemNotaDeDebito>) tmpList;

		this.resumen              = (ResumenNotaDeDebito) notaDeDebitoFactory.createResumen();
		this.extension            = (ExtensionNotaDeDebito) notaDeDebitoFactory.createExtension();

	    tmpList = (List<ApendiceItem>) notaDeDebitoFactory.createApendice();
	    this.apendice             = (List<ApendiceItemNotaDeDebito>) tmpList;								  // must be eliminated from JSON
	}
	/**
	 * No parameters
	 */
	public NotaDeDebito(EDocumentFactory notaDeDebitoFactory) {
		// call constructor without parameters
		this();
		this.notaDeDebitoFactory = (NotaDeDebitoFactory) notaDeDebitoFactory;
	}

	/**
	 * @return the identificacion
	 */
	@Override
	public Identificacion getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = (IdentificacionNotaDeDebito) identificacion;
	}


	/**
	 * @param identificacion the (IdentificacionFactura) identificacion to set
	 */
	@Override
	public void fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		notaDeDebitoFactory.fillIdentification(factoryInput, (IdentificacionNotaDeDebito) identificacion );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoRelacionadoItem> getDocumentoRelacionado() {
		List<?> tempList = (List<DocumentoRelacionadoItemNotaDeDebito>) this.documentoRelacionado;
		List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}

	public void setDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado) {
		List<DocumentoRelacionadoItemNotaDeDebito> documentoRelacionadoItemNotaDeDebito = new ArrayList<DocumentoRelacionadoItemNotaDeDebito>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemNotaDeDebito.add((DocumentoRelacionadoItemNotaDeDebito) e) );

		this.documentoRelacionado = documentoRelacionadoItemNotaDeDebito;
	}

	@Override
	public void fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {	
		notaDeDebitoFactory.fillDocumentoRelacionado(factoryInput, documentoRelacionado);
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
		this.emisor = (EmisorNotaDeDebito) emisor;
	}

	@Override
	public void fillEmisor(JSONObject factoryInput, Emisor emisor) {
		notaDeDebitoFactory.fillEmisor(factoryInput, (EmisorNotaDeDebito) emisor);
	}

	/**
	 * @return the receptor
	 */
	@Override
	public Receptor getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(Receptor receptor) {
		this.receptor = (ReceptorNotaDeDebito) receptor;
	}

	@Override
	public void fillReceptor(JSONObject factoryInput, Receptor receptor) {
		notaDeDebitoFactory.fillReceptor(factoryInput, (ReceptorNotaDeDebito) receptor);
	}

	/**
	 * @return the ventaTercero
	 */
	@Override
	public VentaTercero getVentaTercero() {
		return ventaTercero;
	}

	/**
	 * @param ventaTercero the ventaTercero to set
	 */
	public void setVentaTercero(VentaTercero ventaTercero) {
		this.ventaTercero = (VentaTerceroNotaDeDebito) ventaTercero;
	}

	@Override
	public void fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		notaDeDebitoFactory.fillVentaTercero(factoryInput, (VentaTerceroNotaDeDebito) ventaTercero);
	}

	/**
	 * @return the cuerpoDocumento
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
		List<?> tempList = (List<CuerpoDocumentoItemNotaDeDebito>) this.cuerpoDocumento ;
		List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	public void setCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemNotaDeDebito)
		List<CuerpoDocumentoItemNotaDeDebito> cuerpoDocumentoItemNotaDeDebito = new ArrayList<CuerpoDocumentoItemNotaDeDebito>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemNotaDeDebito.add((CuerpoDocumentoItemNotaDeDebito) e) );

		this.cuerpoDocumento = cuerpoDocumentoItemNotaDeDebito;
	}

	@Override
	public void fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {
		notaDeDebitoFactory.fillCuerpoDocumento(factoryInput, cuerpoDocumento);	
	}

	/**
	 * @return the resumen
	 */
	@Override
	public Resumen getResumen() {
		return resumen;
	}

	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(Resumen resumen) {
		this.resumen = (ResumenNotaDeDebito) resumen;
	}

	@Override
	public void fillResumen(JSONObject factoryInput, Resumen resumen) {
		notaDeDebitoFactory.fillResumen(factoryInput, (ResumenNotaDeDebito) resumen);
	}

	/**
	 * @return the extension
	 */
	@Override
	public Extension getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(Extension extension) {
		this.extension = (ExtensionNotaDeDebito) extension;
	}

	@Override
	public void fillExtension(JSONObject factoryInput, Extension extension) {
		notaDeDebitoFactory.fillExtension(factoryInput, (ExtensionNotaDeDebito) extension);
	}

	/**
	 * @return the apendice
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApendiceItem> getApendice() {	
		List<?> tempList = (List<ApendiceItemNotaDeDebito>) this.apendice;
		List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}

	public void setApendice(List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemNotaDeDebito)
		List<ApendiceItemNotaDeDebito> apendiceItemNotaDeDebito = new ArrayList<ApendiceItemNotaDeDebito>();
		apendice.stream().forEach(e -> apendiceItemNotaDeDebito.add((ApendiceItemNotaDeDebito) e) );

		this.apendice = apendiceItemNotaDeDebito;
	}

	@Override
	public void fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		notaDeDebitoFactory.fillApendice(factoryInput, apendice);		
	}

	/**
	 * THIS CLASS DOESN'T HAVE A OTROSDOCUMENTOSITEM PROPERTY
	 */
	@Override
	public List<OtrosDocumentosItem> getOtrosDocumentos() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebito.fillOtrosDocumentos() is not allowed");
	}

	/**
	 * THIS CLASS DOESN'T HAVE A DOCUMENTO PROPERTY
	 */
	@Override
	public Documento getDocumento() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumento(JSONObject factoryInput, Documento documento) {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebito.fillDocumento() is not allowed");
	}

	/**
	 * THIS CLASS DOESN'T HAVE A MOTIVO PROPERTY
	 */
	@Override
	public Motivo getMotivo() {
		return null;
	}



	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillMotivo(JSONObject factoryInput, Motivo motivo) {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method NotaDeDebito.fillMotivo() is not allowed");
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
}
