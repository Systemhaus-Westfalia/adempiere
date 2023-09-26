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
 * 
 */
public class Retencion extends EDocument {
	static final int CUERPODOCUMENTO_MAXIMUM_ITEMS = 500;
	
	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_CUERPODOCUMENTO_MAX_ITEMS  = "Documento: Retencion, clase: Retencion. Validacion falló: valor de 'cuerpoDocumento' debe  contener de 1 a 500 elementos";
	
	IdentificacionRetencion identificacion;
	EmisorRetencion emisor;
	ReceptorRetencion receptor;
	List<CuerpoDocumentoItemRetencion> cuerpoDocumento;
	ResumenRetencion resumen;
	ExtensionRetencion extension;
	List<ApendiceItemRetencion> apendice=null;  // null allowed
	
	RetencionFactory retencionFactory;  // This must be eliminated from JSON production.

	/**
	 * No parameters
	 */
	public Retencion() {
		List<?> tmpList;

		this.identificacion       = (IdentificacionRetencion) retencionFactory.createIdentificacion();
		this.emisor               = (EmisorRetencion) retencionFactory.createEmisor();
		this.receptor             = (ReceptorRetencion) retencionFactory.createReceptor();		

		tmpList = retencionFactory.createCuerpoDocumento();
	    this.cuerpoDocumento      = (List<CuerpoDocumentoItemRetencion>) tmpList;

		this.resumen              = (ResumenRetencion) retencionFactory.createResumen();
		this.extension            = (ExtensionRetencion) retencionFactory.createExtension();
		
		tmpList = retencionFactory.createApendice();
	    this.apendice             = (List<ApendiceItemRetencion>) tmpList;
	}
	
	public Retencion(EDocumentFactory retencionFactory) {
		// call constructor without parameters
		this();
		this.retencionFactory = (RetencionFactory) retencionFactory;
	}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {
		if( (getCuerpoDocumento()==null) ||  (getCuerpoDocumento().size()==0) || (getCuerpoDocumento().size()>CUERPODOCUMENTO_MAXIMUM_ITEMS) ) {
			return VALIDATION_CUERPODOCUMENTO_MAX_ITEMS;
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
		this.identificacion = (IdentificacionRetencion) identificacion;
	}

	/**
	 * @param identificacion the (IdentificacionFactura) identificacion to set
	 */
	@Override
	public void fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		retencionFactory.fillIdentification( (IdentificacionRetencion) identificacion );
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
		this.emisor = (EmisorRetencion) emisor;
	}

	@Override
	public void fillEmisor(JSONObject factoryInput, Emisor emisor) {
		retencionFactory.fillEmisor( (EmisorRetencion) emisor);
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
	public void setReceptor(ReceptorRetencion receptor) {
		this.receptor = (ReceptorRetencion) receptor;
	}

	@Override
	public void fillReceptor(Receptor receptor) {
		retencionFactory.fillReceptor( (ReceptorRetencion) receptor);
	}

	/**
	 * @return the cuerpoDocumento
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
	    List<?> tempList = (List<CuerpoDocumentoItemRetencion>) this.cuerpoDocumento;
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		List<CuerpoDocumentoItemRetencion> cuerpoDocumentoItemRetencion = new ArrayList<CuerpoDocumentoItemRetencion>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemRetencion.add((CuerpoDocumentoItemRetencion) e) );
		
		this.cuerpoDocumento = cuerpoDocumentoItemRetencion;
	}

	
	@Override
	public void fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {
		retencionFactory.fillCuerpoDocumento(cuerpoDocumento);
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
	public void setResumen(ResumenRetencion resumen) {
		this.resumen = (ResumenRetencion) resumen;
	}

	
	@Override
	public void fillResumen(JSONObject factoryInput, Resumen resumen) {
		retencionFactory.fillResumen( (ResumenRetencion) resumen);
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
	public void setExtension(ExtensionRetencion extension) {
		this.extension = extension;
	}

	
	@Override
	public void fillExtension(JSONObject factoryInput, Extension extension) {
		retencionFactory.fillExtension( (ExtensionRetencion) extension);
	}

	/**
	 * @return the apendice
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApendiceItem> getApendice() {
	    List<?> tempList = (List<ApendiceItemRetencion>) this.apendice;
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}

	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(List<ApendiceItem> apendice) {
		List<ApendiceItemRetencion> apendiceItemRetencion = new ArrayList<ApendiceItemRetencion>();
		apendice.stream().forEach(e -> apendiceItemRetencion.add((ApendiceItemRetencion) e) );
		
		this.apendice = apendiceItemRetencion;
	}

	
	@Override
	public void fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		retencionFactory.fillApendice(apendice);		
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
	public void fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * THIS CLASS DOESN'T HAVE AN OTROSDOCUMENTOS PROPERTY
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
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createDocumentoRelacionado() is not allowed");
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
	public void fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createDocumentoRelacionado() is not allowed");
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
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createDocumentoRelacionado() is not allowed");
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
		throw new UnsupportedOperationException("In Document Retencion calling the method Retencion.createDocumentoRelacionado() is not allowed");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
