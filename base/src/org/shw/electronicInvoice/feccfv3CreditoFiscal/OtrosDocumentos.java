/**
 * 
 */
package org.shw.electronicInvoice.feccfv3CreditoFiscal;

import org.shw.util.pojoAdempiere.Medico;

/**
 * 
 */
public class OtrosDocumentos {

	String codDocAsociado;
	String descDocumento;
	String detalleDocumento;
	Medico medico;
	
	/**
	 * No Parameters
	 */
	public OtrosDocumentos() {
		this.medico = new Medico();
	}

	
	/**
	 * @return the codDocAsociado
	 */
	public String getCodDocAsociado() {
		return codDocAsociado;
	}

	/**
	 * @param codDocAsociado the codDocAsociado to set
	 */
	public void setCodDocAsociado(String codDocAsociado) {
		this.codDocAsociado = codDocAsociado;
	}

	/**
	 * @return the descDocumento
	 */
	public String getDescDocumento() {
		return descDocumento;
	}

	/**
	 * @param descDocumento the descDocumento to set
	 */
	public void setDescDocumento(String descDocumento) {
		this.descDocumento = descDocumento;
	}

	/**
	 * @return the detalleDocumento
	 */
	public String getDetalleDocumento() {
		return detalleDocumento;
	}

	/**
	 * @param detalleDocumento the detalleDocumento to set
	 */
	public void setDetalleDocumento(String detalleDocumento) {
		this.detalleDocumento = detalleDocumento;
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
