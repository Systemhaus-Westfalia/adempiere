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
	Emisor emisor;
	Receptor receptor;

	/**
	 * No parameters
	 */
	public NotaDeCredito() {
		this.identificacion       = new Identificacion();
		this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItem>();
		this.emisor               = new Emisor();
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
