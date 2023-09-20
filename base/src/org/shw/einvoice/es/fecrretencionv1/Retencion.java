/**
 * 
 */
package org.shw.einvoice.es.fecrretencionv1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.ApendiceItem;


/**
 * 
 */
public class Retencion {
	static final int CUERPODOCUMENTO_MAXIMUM_ITEMS = 500;
	
	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_CUERPODOCUMENTO_MAX_ITEMS  = "Documento: Retencion, clase: Retencion. Validacion falló: valor de 'cuerpoDocumento' debe  contener de 1 a 500 elementos";
	
	IdentificacionRetencion identificacion;
	EmisorRetencion emisor;
	ReceptorRetencion receptor;
	List<CuerpoDocumentoItemRetencion> cuerpoDocumento;
	ResumenRetencion resumen;
	Extension extension;
	List<ApendiceItem> apendice=null;  // null allowed

	/**
	 * No parameters
	 */
	public Retencion() {
		this.identificacion       = new IdentificacionRetencion();
		this.emisor               = new EmisorRetencion();
		this.receptor             = new ReceptorRetencion();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItemRetencion>();
		this.resumen              = new ResumenRetencion();
		this.extension            = new Extension();
		this.apendice             = new ArrayList<ApendiceItem>();
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
	public IdentificacionRetencion getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionRetencion identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the emisor
	 */
	public EmisorRetencion getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorRetencion emisor) {
		this.emisor = emisor;
	}

	/**
	 * @return the receptor
	 */
	public ReceptorRetencion getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorRetencion receptor) {
		this.receptor = receptor;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	public List<CuerpoDocumentoItemRetencion> getCuerpoDocumento() {
		return cuerpoDocumento;
	}

	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItemRetencion> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}

	/**
	 * @return the resumen
	 */
	public ResumenRetencion getResumen() {
		return resumen;
	}

	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(ResumenRetencion resumen) {
		this.resumen = resumen;
	}

	/**
	 * @return the extension
	 */
	public Extension getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	/**
	 * @return the apendice
	 */
	public List<ApendiceItem> getApendice() {
		return apendice;
	}

	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(List<ApendiceItem> apendice) {
		this.apendice = apendice;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
