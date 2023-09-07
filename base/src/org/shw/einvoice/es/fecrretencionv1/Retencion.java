/**
 * 
 */
package org.shw.einvoice.es.fecrretencionv1;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.fefcfacturaelectronicav1.Receptor;




/**
 * 
 */
public class Retencion {
	
	Identificacion identificacion;
	Emisor emisor;
	Receptor receptor;
	List<CuerpoDocumentoItem> cuerpoDocumento;

	/**
	 * No parameters
	 */
	public Retencion() {
		this.identificacion       = new Identificacion();
		this.emisor               = new Emisor();
		this.receptor             = new Receptor();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
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
