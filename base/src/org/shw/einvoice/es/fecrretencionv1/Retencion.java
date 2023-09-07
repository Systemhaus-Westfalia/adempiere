/**
 * 
 */
package org.shw.einvoice.es.fecrretencionv1;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.ApendiceItem;


/**
 * 
 */
public class Retencion {
	
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
