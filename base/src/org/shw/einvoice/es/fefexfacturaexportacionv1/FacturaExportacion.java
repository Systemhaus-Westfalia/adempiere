/**
 * 
 */
package org.shw.einvoice.es.fefexfacturaexportacionv1;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.fefcfacturaelectronicav1.CuerpoDocumentoItem;
import org.shw.einvoice.es.fefcfacturaelectronicav1.Resumen;
import org.shw.einvoice.es.util.pojo.OtrosDocumentosItem;
import org.shw.einvoice.es.util.pojo.VentaTercero;


/**
 * 
 */
public class FacturaExportacion {
	
	Identificacion identificacion;
	Emisor emisor;
	Receptor receptor;
	List<OtrosDocumentosItem> otrosDocumentos;
	VentaTercero ventaTercero;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;

	/**
	 * No parameters
	 */
	public FacturaExportacion() {
		this.identificacion       = new Identificacion();
		this.emisor				  = new Emisor();
		this.receptor             = new Receptor();
		this.otrosDocumentos      = new ArrayList<OtrosDocumentosItem>();
		this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
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
