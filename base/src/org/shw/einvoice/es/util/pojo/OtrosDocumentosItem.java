/**
 * 
 */
package org.shw.einvoice.es.util.pojo;

import java.util.Objects;

/**
 * 
 */
public class OtrosDocumentosItem {

	int codDocAsociado;
	String descDocumento=null;  // null allowed
	String detalleDocumento=null;  // null allowed
	Medico medico=null;  // null allowed
	
	/**
	 * No Parameters
	 */
	public OtrosDocumentosItem() {
		this.medico = new Medico();
	}

	/**
	 * Validate the Schema conditions
	 */
	public boolean validateValues() {
		if(getCodDocAsociado()==3) {
			if (Objects.isNull(getMedico()))
				return false;
			if (getDescDocumento()!=null)
				return false;
			if (getDetalleDocumento()!=null)
				return false;
		} else  {
			if (!Objects.isNull(getMedico()))
				return false;
			if (getDescDocumento()==null)
				return false;
			if (getDetalleDocumento()==null)
				return false;
		}
		
		return true;
	}

	/**
	 * @return the codDocAsociado
	 */
	public int getCodDocAsociado() {
		return codDocAsociado;
	}


	/**
	 * @param codDocAsociado the codDocAsociado to set<br>
	 * The parameter is validated.<br>
	 * "minimum" : 1, "maximum" : 4
	 */
	public void setCodDocAsociado(int codDocAsociado) {
		final int MINIMUM = 1;
		final int MAXIMUM = 4;
		
		if(codDocAsociado>=MINIMUM && codDocAsociado<=MAXIMUM)
			this.codDocAsociado = codDocAsociado;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codDocAsociado' in (POJO).OtrosDocumentosItem.setCodDocAsociado()");
	}


	/**
	 * @return the descDocumento
	 */
	public String getDescDocumento() {
		return descDocumento;
	}

	/**
	 * @param descDocumento the descDocumento to set<br>
	 * The parameter is validated; null also possible.<br>
	 * "maxLength" : 100
	 */
	public void setDescDocumento(String descDocumento) {
		final int MAXLENGTH = 100;
		int length = descDocumento==null?0:descDocumento.length();
		
		if( (length<=MAXLENGTH)  || (descDocumento==null) )
			this.descDocumento = descDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descDocumento' in (POJO).OtrosDocumentosItem.setDescDocumento()");
	}

	/**
	 * @return the detalleDocumento
	 */
	public String getDetalleDocumento() {
		return detalleDocumento;
	}

	/**
	 * @param detalleDocumento the detalleDocumento to set<br>
	 * The parameter is validated; null also possible.<br>.<br>
	 * "maxLength" : 300
	 */
	public void setDetalleDocumento(String detalleDocumento) {
		final int MAXLENGTH = 300;
		int length = detalleDocumento==null?0:detalleDocumento.length();
		
		if( (length<=MAXLENGTH)  || (detalleDocumento==null) )
			this.detalleDocumento = detalleDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'detalleDocumento' in (POJO).OtrosDocumentosItem.setDetalleDocumento()");
	}

	/**
	 * @return the medico
	 */
	public Medico getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
