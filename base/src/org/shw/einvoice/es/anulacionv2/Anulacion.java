/**
 * 
 */
package org.shw.einvoice.es.anulacionv2;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.Emisor;

/**
 * 
 */
public class Anulacion {

	static final int    VERSION       = 3;
	
	Identificacion identificacion;
	Emisor emisor;

	/**
	 * No parameters
	 */
	public Anulacion() {
		this.identificacion       = new Identificacion(VERSION);
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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
