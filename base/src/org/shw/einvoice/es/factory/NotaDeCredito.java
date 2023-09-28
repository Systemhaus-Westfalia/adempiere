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
 * 
 */
public class NotaDeCredito extends EDocument {

	IdentificacionNotaDeCredito identificacion;
	List<DocumentoRelacionadoItemNotaDeCredito> documentoRelacionado;
	EmisorNotaDeCredito emisor;
	ReceptorNotaDeCredito receptor;
	VentaTerceroNotaDeCredito ventaTercero = null;
	List<CuerpoDocumentoItemNotaDeCredito> cuerpoDocumento;
	ResumenNotaDeCredito resumen;
	ExtensionNotaDeCredito extension;
	List<ApendiceItemNotaDeCredito> apendice=null;  // null allowed

	NotaDeCreditoFactory notaDeCreditoFactory;  // This must be eliminated from JSON production.

	/**
	 * No parameters
	 */
	public NotaDeCredito() {
		List<?> tmpList;
		notaDeCreditoFactory      = new NotaDeCreditoFactory();
		this.identificacion       = (IdentificacionNotaDeCredito) notaDeCreditoFactory.createIdentificacion();
		
	    tmpList = (List<DocumentoRelacionadoItem>) notaDeCreditoFactory.createDocumentoRelacionado();
	    this.documentoRelacionado = (List<DocumentoRelacionadoItemNotaDeCredito>) tmpList;

		this.emisor               = (EmisorNotaDeCredito) notaDeCreditoFactory.createEmisor();
		this.receptor             = (ReceptorNotaDeCredito) notaDeCreditoFactory.createReceptor();
		this.ventaTercero         = (VentaTerceroNotaDeCredito) notaDeCreditoFactory.createVentaTercero();  // must be eliminated from JSON

	    tmpList = (List<CuerpoDocumentoItem>) notaDeCreditoFactory.createCuerpoDocumento();
	    this.cuerpoDocumento      = (List<CuerpoDocumentoItemNotaDeCredito>) tmpList;

		this.resumen              = (ResumenNotaDeCredito) notaDeCreditoFactory.createResumen();
		this.extension            = (ExtensionNotaDeCredito) notaDeCreditoFactory.createExtension();

	    tmpList = (List<ApendiceItem>) notaDeCreditoFactory.createApendice();
	    this.apendice             = (List<ApendiceItemNotaDeCredito>) tmpList;								  // must be eliminated from JSON
	}
	
	/**
	 * validateValues() from super class
	 */

	/**
	 * @return the identificacion
	 */
	@Override
	public Identificacion getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = (IdentificacionNotaDeCredito) identificacion;
	}


	/**
	 * @param identificacion the (IdentificacionFactura) identificacion to set
	 */
	@Override
	public StringBuffer fillIdentification(JSONObject factoryInput) {
		errorMessages = notaDeCreditoFactory.fillIdentification(factoryInput, identificacion );
		
		return errorMessages;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoRelacionadoItem> getDocumentoRelacionado() {
		List<?> tempList = (List<DocumentoRelacionadoItemNotaDeCredito>) this.documentoRelacionado;
		List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}

	public void setDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado) {
		List<DocumentoRelacionadoItemNotaDeCredito> documentoRelacionadoItemNotaDeCredito = new ArrayList<DocumentoRelacionadoItemNotaDeCredito>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemNotaDeCredito.add((DocumentoRelacionadoItemNotaDeCredito) e) );

		this.documentoRelacionado = documentoRelacionadoItemNotaDeCredito;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StringBuffer fillDocumentoRelacionado(JSONObject factoryInput) {
		List<?> tmpList = documentoRelacionado;
		errorMessages = notaDeCreditoFactory.fillDocumentoRelacionado(factoryInput, (List<DocumentoRelacionadoItem>) tmpList);		
		return errorMessages;
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
		this.emisor = (EmisorNotaDeCredito) emisor;
	}

	@Override
	public StringBuffer fillEmisor(JSONObject factoryInput) {
		errorMessages = notaDeCreditoFactory.fillEmisor(factoryInput, emisor);
		return errorMessages;
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
		this.receptor = (ReceptorNotaDeCredito) receptor;
	}

	@Override
	public StringBuffer fillReceptor(JSONObject factoryInput) {
		errorMessages = notaDeCreditoFactory.fillReceptor(factoryInput, receptor);
		return errorMessages;
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
		this.ventaTercero = (VentaTerceroNotaDeCredito) ventaTercero;
	}

	@Override
	public StringBuffer fillVentaTercero(JSONObject factoryInput) {
		errorMessages = notaDeCreditoFactory.fillVentaTercero(factoryInput, ventaTercero); 
		return errorMessages;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
		List<?> tempList = (List<CuerpoDocumentoItemNotaDeCredito>) this.cuerpoDocumento ;
		List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	public void setCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemNotaDeCredito)
		List<CuerpoDocumentoItemNotaDeCredito> cuerpoDocumentoItemNotaDeCredito = new ArrayList<CuerpoDocumentoItemNotaDeCredito>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemNotaDeCredito.add((CuerpoDocumentoItemNotaDeCredito) e) );

		this.cuerpoDocumento = cuerpoDocumentoItemNotaDeCredito;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput) {
		List<?> tmpList = cuerpoDocumento;
		errorMessages = notaDeCreditoFactory.fillCuerpoDocumento(factoryInput, (List<CuerpoDocumentoItem>) tmpList);
		return errorMessages;
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
		this.resumen = (ResumenNotaDeCredito) resumen;
	}

	@Override
	public StringBuffer fillResumen(JSONObject factoryInput) {
		errorMessages = notaDeCreditoFactory.fillResumen(factoryInput, resumen); 
		return errorMessages;
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
		this.extension = (ExtensionNotaDeCredito) extension;
	}

	@Override
	public StringBuffer fillExtension(JSONObject factoryInput) {
		errorMessages = notaDeCreditoFactory.fillExtension(factoryInput, extension); 
		return errorMessages;
	}

	/**
	 * @return the apendice
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApendiceItem> getApendice() {	
		List<?> tempList = (List<ApendiceItemNotaDeCredito>) this.apendice;
		List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}

	public void setApendice(List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemNotaDeCredito)
		List<ApendiceItemNotaDeCredito> apendiceItemNotaDeCredito = new ArrayList<ApendiceItemNotaDeCredito>();
		apendice.stream().forEach(e -> apendiceItemNotaDeCredito.add((ApendiceItemNotaDeCredito) e) );

		this.apendice = apendiceItemNotaDeCredito;
	}

	@SuppressWarnings("unchecked")
	@Override
	public StringBuffer fillApendice(JSONObject factoryInput) {
		List<?> tmpList = apendice;
		errorMessages = notaDeCreditoFactory.fillApendice(factoryInput, (List<ApendiceItem>) tmpList);
		return errorMessages;
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
	public StringBuffer fillOtrosDocumentos(JSONObject factoryInput) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCredito.fillOtrosDocumentos() is not allowed");
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
	public StringBuffer fillDocumento(JSONObject factoryInput) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCredito.fillDocumento() is not allowed");
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
	public StringBuffer fillMotivo(JSONObject factoryInput) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method NotaDeCredito.fillMotivo() is not allowed");
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
}
