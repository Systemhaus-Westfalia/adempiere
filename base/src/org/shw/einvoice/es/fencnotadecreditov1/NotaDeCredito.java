/**
 * 
 */
package org.shw.einvoice.es.fencnotadecreditov1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;




/**
 * 
 */
public class NotaDeCredito {
	
	Identificacion identificacion;
	List<DocumentoRelacionadoItem> documentoRelacionado;

	/**
	 * No parameters
	 */
	public NotaDeCredito() {
		this.identificacion       = new Identificacion();
		this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItem>();
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
