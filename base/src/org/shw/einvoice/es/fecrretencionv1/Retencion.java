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
	static final String VALIDATION_CUERPODOCUMENTO_MAX_ITEMS  = "Documento: Retencion, clase: Retencion. Validacion falló: valor de 'cuerpoDocumento' debe  de 1 a 500 elementos";
	
	Identificacion identificacion;
	Emisor emisor;
	Receptor receptor;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	Extension extension;
	List<ApendiceItem> apendice=null;  // null allowed

	/**
	 * No parameters
	 */
	public Retencion() {
		this.identificacion       = new Identificacion();
		this.emisor               = new Emisor();
		this.receptor             = new Receptor();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		this.extension            = new Extension();
		this.apendice             = new ArrayList<ApendiceItem>();
	}
	
	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {
		if( (getCuerpoDocumento().size()==0) || (getCuerpoDocumento().size()>CUERPODOCUMENTO_MAXIMUM_ITEMS) ) {
			return VALIDATION_CUERPODOCUMENTO_MAX_ITEMS;
		}
		
		return VALIDATION_RESULT_OK;
	}

	/**
	 * @return the identificacion
	 */
	public Identificacion getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the emisor
	 */
	public Emisor getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}

	/**
	 * @return the receptor
	 */
	public Receptor getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
		return cuerpoDocumento;
	}

	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}

	/**
	 * @return the resumen
	 */
	public Resumen getResumen() {
		return resumen;
	}

	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(Resumen resumen) {
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
