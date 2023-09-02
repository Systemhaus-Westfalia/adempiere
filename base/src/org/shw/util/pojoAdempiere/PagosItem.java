/**
 * 
 */
package org.shw.util.pojoAdempiere;

/**
 * 
 */
public class PagosItem {
	
	String codigo;
	String montoPago;
	String referencia;
	String plazo;
	String periodo;
	
	
	/**
	 * @param codigo
	 * @param montoPago
	 * @param referencia
	 * @param plazo
	 * @param periodo
	 */
	public PagosItem(String codigo, String montoPago, String referencia, String plazo, String periodo) {
		super();
		this.codigo = codigo;
		this.montoPago = montoPago;
		this.referencia = referencia;
		this.plazo = plazo;
		this.periodo = periodo;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the montoPago
	 */
	public String getMontoPago() {
		return montoPago;
	}

	/**
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(String montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the plazo
	 */
	public String getPlazo() {
		return plazo;
	}

	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
