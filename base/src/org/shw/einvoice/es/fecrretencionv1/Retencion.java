/**
 * 
 */
package org.shw.einvoice.es.fecrretencionv1;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.Emisor;


/**
 * 
 */
public class Retencion {
	
	Identificacion identificacion;
	Emisor emisor;

	/**
	 * No parameters
	 */
	public Retencion() {
		this.identificacion       = new Identificacion();
		this.emisor               = new Emisor();
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
