/**
 * 
 */
package org.shw.einvoice.es.fencnotadecreditov1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.Receptor;
import org.shw.einvoice.es.util.pojo.VentaTercero;




/**
 * 
 */
public class NotaDeCredito {
	
	Identificacion identificacion;
	List<DocumentoRelacionadoItem> documentoRelacionado;
	Receptor receptor;
	VentaTercero ventaTercero = null;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	Extension extension;
	List<ApendiceItem> apendice=null;  // null allowed
	//this.apendice             = new ArrayList<ApendiceItem>();

	/**
	 * No parameters
	 */
	public NotaDeCredito() {
		this.identificacion       = new Identificacion();
		this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItem>();
		this.receptor             = new Receptor();
		//this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		this.extension            = new Extension();
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
