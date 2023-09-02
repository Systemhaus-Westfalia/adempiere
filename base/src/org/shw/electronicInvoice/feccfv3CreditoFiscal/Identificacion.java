package org.shw.electronicInvoice.feccfv3CreditoFiscal;

public class Identificacion {


	String version = "3";
	String ambiente = "00";
	String tipoDte = "03";
	String numeroControl;
	String codigoGeneracion;
	int tipoModelo;
	int tipoOperacion;
	int tipoContingencia;  // null erlaubt
	String motivoContin;  // null erlaubt
	String fecEmi;
	String horEmi;
	String tipoMoneda = "USD";
		
	
	
	/**
	 * No Parameters
	 */
	public Identificacion() {
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}




	/**
	 * @return the ambiente
	 */
	public String getAmbiente() {
		return ambiente;
	}




	/**
	 * @param ambiente the ambiente to set
	 */
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}




	/**
	 * @return the tipoDte
	 */
	public String getTipoDte() {
		return tipoDte;
	}




	/**
	 * @param tipoDte the tipoDte to set
	 */
	public void setTipoDte(String tipoDte) {
		this.tipoDte = tipoDte;
	}




	/**
	 * @return the numeroControl
	 */
	public String getNumeroControl() {
		return numeroControl;
	}




	/**
	 * @param numeroControl the numeroControl to set
	 */
	public void setNumeroControl(String numeroControl) {
		this.numeroControl = numeroControl;
	}




	/**
	 * @return the codigoGeneracion
	 */
	public String getCodigoGeneracion() {
		return codigoGeneracion;
	}

	/**
	 * @return the tipoContingencia
	 */
	public int getTipoContingencia() {
		return tipoContingencia;
	}

	/**
	 * @param tipoContingencia the tipoContingencia to set
	 */
	public void setTipoContingencia(int tipoContingencia) {
		this.tipoContingencia = tipoContingencia;
	}

	/**
	 * @param codigoGeneracion the codigoGeneracion to set
	 */
	public void setCodigoGeneracion(String codigoGeneracion) {
		this.codigoGeneracion = codigoGeneracion;
	}



	/**
	 * @return the motivoContin
	 */
	public String getMotivoContin() {
		return motivoContin;
	}




	/**
	 * @param motivoContin the motivoContin to set
	 */
	public void setMotivoContin(String motivoContin) {
		this.motivoContin = motivoContin;
	}




	/**
	 * @return the fecEmi
	 */
	public String getFecEmi() {
		return fecEmi;
	}




	/**
	 * @param fecEmi the fecEmi to set
	 */
	public void setFecEmi(String fecEmi) {
		this.fecEmi = fecEmi;
	}




	/**
	 * @return the horEmi
	 */
	public String getHorEmi() {
		return horEmi;
	}




	/**
	 * @param horEmi the horEmi to set
	 */
	public void setHorEmi(String horEmi) {
		this.horEmi = horEmi;
	}




	/**
	 * @return the tipoMoneda
	 */
	public String getTipoMoneda() {
		return tipoMoneda;
	}




	/**
	 * @param tipoMoneda the tipoMoneda to set
	 */
	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	/**
	 * @return the tipoModelo
	 */
	public int getTipoModelo() {
		return tipoModelo;
	}

	/**
	 * @param tipoModelo the tipoModelo to set
	 */
	public void setTipoModelo(int tipoModelo) {
		this.tipoModelo = tipoModelo;
	}

	/**
	 * @return the tipoOperacion
	 */
	public int getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion the tipoOperacion to set
	 */
	public void setTipoOperacion(int tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
