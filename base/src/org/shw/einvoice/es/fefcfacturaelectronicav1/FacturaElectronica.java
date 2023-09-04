/**
 * 
 */
package org.shw.einvoice.es.fefcfacturaelectronicav1;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.Identificacion;

/**
 * 
 */
public class FacturaElectronica {

	static final int    VERSION          = 1;
	static final String TIPODTE_FACTURA   = "01";
	
	Identificacion identificacion;
	List<DocumentoRelacionadoItem> documentoRelacionado;
	/*
	 * Emisor emisor; Receptor receptor; List<OtrosDocumentosItem> otrosDocumentos;
	 * VentaTercero ventaTercero; List<CuerpoDocumentoItem> cuerpoDocumento; Resumen
	 * resumen; Extension extension; List<ApendiceItem> apendice;
	 */

	/**
	 * No parameters
	 */
	public FacturaElectronica() {
		this.identificacion       = new Identificacion(VERSION, TIPODTE_FACTURA);
		this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItem>();
		/*this.emisor               = new Emisor();
		this.receptor             = new Receptor();
		this.otrosDocumentos      = new ArrayList<OtrosDocumentosItem>();
		this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		this.extension            = new Extension();
		this.apendice             = new ArrayList<ApendiceItem>();*/
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
	 * @return the documentoRelacionado
	 */
	public List<DocumentoRelacionadoItem> getDocumentoRelacionado() {
		return documentoRelacionado;
	}


	/**
	 * @param documentoRelacionado the documentoRelacionado to set
	 */
	public void setDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
