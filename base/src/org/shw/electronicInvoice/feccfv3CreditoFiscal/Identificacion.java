package org.shw.electronicInvoice.feccfv3CreditoFiscal;
import java.util.regex.Pattern;  

public class Identificacion {

	static final int    VERSION           = 3;
	static final String TIPODTE           = "03";
	static final String TIPOMONEDA        = "USD";
	
	int version     = VERSION;
	String ambiente;
	String tipoDte  = TIPODTE;
	String numeroControl;
	String codigoGeneracion;
	int tipoModelo;
	int tipoOperacion;
	Integer tipoContingencia=null;  // null erlaubt
	String motivoContin=null;       // null erlaubt
	String fecEmi;
	String horEmi;
	String tipoMoneda = TIPOMONEDA;
		
	/**
	 * No Parameters
	 */
	public Identificacion() {
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
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
	 * The content is validated.
	 * "enum" : ["00", "01"]
	 */
	public void setAmbiente(String ambiente) {
		if (ambiente.compareTo("00")==0 || ambiente.compareTo("01")==0)
			this.ambiente = ambiente;
		else
	        throw new IllegalArgumentException("Wrong parameter 'ambiente' in setAmbiente()");
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
	 * "pattern" : "^DTE-03-[A-Z0-9]{8}-[0-9]{15}$"
	 */
	public void setNumeroControl(String numeroControl) {
		final String PATTERN = "^DTE-03-[A-Z0-9]{8}-[0-9]{15}$";
		boolean patternOK = Pattern.matches(PATTERN, numeroControl);  
		
		if(patternOK)
			this.numeroControl = numeroControl;
		else
	        throw new IllegalArgumentException("Wrong expression 'numeroControl' in setNumeroControl()");
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
	public Integer getTipoContingencia() {
		return tipoContingencia;
	}

	/**
	 * @param tipoContingencia the tipoContingencia to set
	 * "enum" : [1,2,3,4,5], null
	 */
	public void setTipoContingencia(Integer tipoContingencia) {
		if (tipoContingencia==1 || tipoContingencia==2 || tipoContingencia==3 || tipoContingencia==4 || tipoContingencia==5 || tipoContingencia==null)
			this.tipoContingencia = tipoContingencia;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoContingencia' in setTipoContingencia()");

		// Schema conditions
		//if(getTipoContingencia()==5) {
		//	// it should be a string, but how???
		//}
	}

	/**
	 * @param codigoGeneracion the codigoGeneracion to set
	 * "pattern" : "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$"
	 */
	public void setCodigoGeneracion(String codigoGeneracion) {
		final String PATTERN = "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$";
		boolean patternOK = Pattern.matches(PATTERN, codigoGeneracion);  
		
		if(patternOK)
			this.codigoGeneracion = codigoGeneracion;
		else
	        throw new IllegalArgumentException("Wrong expression 'codigoGeneracion' in setCodigoGeneracion()");
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
	 * "pattern" : "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]?$"
	 */
	public void setHorEmi(String horEmi) {
		final String PATTERN = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]?$";
		boolean patternOK = Pattern.matches(PATTERN, horEmi);  
		
		if(patternOK)
			this.horEmi = horEmi;
		else
	        throw new IllegalArgumentException("Wrong expression 'horEmi' in setHorEmi()");
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
	 * The content is validated.
	 * "enum" : [1,2]
	 */
	public void setTipoModelo(int tipoModelo) {
		if (tipoModelo==1 || tipoModelo==2)
			this.tipoModelo = tipoModelo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoModelo' in setTipoModelo()");
	}

	/**
	 * @return the tipoOperacion
	 */
	public int getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion the tipoOperacion to set
	 * The content is validated.
	 * "enum" : [1,2]
	 */
	public void setTipoOperacion(int tipoOperacion) {
		if (tipoOperacion==1 || tipoOperacion==2)
			this.tipoOperacion = tipoOperacion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoOperacion' in setTipoOperacion()");

		// Schema conditions
		if(this.tipoOperacion==1) {
			setTipoModelo(1);
			setTipoContingencia(null);
			setMotivoContin(null);
		} else  {
			this.setTipoModelo(2);
		}
		
		// Schema conditions
		if(this.tipoOperacion==2) {
			// In schema: "tipoContingencia" : {"type" : "integer"}
			if(getTipoContingencia()==null)
		        throw new IllegalArgumentException("Wrong expression in setTipoOperacion(): tipoContingencia must be integer");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
