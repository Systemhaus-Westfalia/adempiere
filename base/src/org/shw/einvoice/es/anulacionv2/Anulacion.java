/**
 * 
 */
package org.shw.einvoice.es.anulacionv2;


/**
 * 
 */
public class Anulacion {
	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_CODIGOGENERACIONR_IS_NOT_NULL = "Documento: Anulacion, clase: Anulacion. Validacion falló: valor de 'codigoGeneracionR' debe ser ='null'";
	static final String VALIDATION_CODIGOGENERACIONR_IS_NULL = "Documento: Anulacion, clase: Anulacion. Validacion falló: valor de 'codigoGeneracionR' no deber ser ='null'";

	IdentificacionAnulacion identificacion;
	Emisor emisor;
	Documento documento;
	Motivo motivo;

	/**
	 * No parameters
	 */
	public Anulacion() {
		this.identificacion = new IdentificacionAnulacion();
		this.emisor         = new Emisor();
		this.documento      = new Documento();
		this.motivo         = new Motivo();
	}



/**
 * Validate the Schema conditions
 */
public String validateValues() {
	
	if(getMotivo().getTipoAnulacion()==2) {
		if ( getDocumento().getCodigoGeneracionR()!= null)
			return VALIDATION_CODIGOGENERACIONR_IS_NOT_NULL;
	} else {
		if ( getDocumento().getCodigoGeneracionR()== null)
			return VALIDATION_CODIGOGENERACIONR_IS_NULL;
	}
	
	return VALIDATION_RESULT_OK;
}
	
	/**
	 * @return the identificacion
	 */
	public IdentificacionAnulacion getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionAnulacion identificacion) {
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
