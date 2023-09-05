/**
 * 
 */
package org.shw.einvoice.es.fefexfacturaexportacionv1;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 */
public class FacturaExportacion {
	
	Identificacion identificacion;
	Emisor emisor;
	Receptor receptor;

	/**
	 * No parameters
	 */
	public FacturaExportacion() {
		this.identificacion       = new Identificacion();
		this.emisor				  = new Emisor();
		this.receptor             = new Receptor();
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
