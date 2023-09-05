/**
 * 
 */
package org.shw.einvoice.es.anulacionv2;


/**
 * 
 */
public class Anulacion {

	static final int    VERSION       = 2;
	
	Identificacion identificacion;
	Emisor emisor;
	Documento documento;
	Motivo motivo;

	/**
	 * No parameters
	 */
	public Anulacion() {
		this.identificacion = new Identificacion(VERSION);
		this.emisor         = new Emisor();
		this.documento      = new Documento();
		this.motivo         = new Motivo();
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
	 * @return the documento
	 */
	public Documento getDocumento() {
		return documento;
	}


	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}


	/**
	 * @return the motivo
	 */
	public Motivo getMotivo() {
		return motivo;
	}


	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
