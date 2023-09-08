/**
 * 
 */
package org.shw.einvoice.es.fencnotadecreditov1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.Receptor;




/**
 * 
 */
public class NotaDeCredito {
	
	Identificacion identificacion;
	List<DocumentoRelacionadoItem> documentoRelacionado;
	Receptor receptor;

	/**
	 * No parameters
	 */
	public NotaDeCredito() {
		this.identificacion       = new Identificacion();
		this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItem>();
		this.receptor             = new Receptor();
	}

	/**
	 * @return the identificacion
	 */
	public Identificacion getIdentificacion() {
		return identificacion;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
