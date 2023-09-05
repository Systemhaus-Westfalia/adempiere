package org.shw.einvoice.es.fefexfacturaexportacionv1;
import java.util.regex.Pattern;  

public class Identificacion {

	// motivoContin min length depends on value of "tipoDte
	static final int VERSION   = 1;
	static final String TIPOD_DE_DOCUMENTO = "11";
	static final String TIPOMONEDA        = "USD";
	
	int version;
	String ambiente;
	String tipoDte ;
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
	 * No parameters
	 */
	public Identificacion() {
		this.version = VERSION;
		this.tipoDte = TIPOD_DE_DOCUMENTO;
	}
	
	/**
	 * Validate the Schema conditions
	 */
	public boolean validateValues() {
		if(this.tipoOperacion==1) {
			if (getTipoModelo() != 1) 
				return false;
			if (getTipoContingencia() != null) 
				return false;
			if (getMotivoContin() != null) 
				return false;
		} else  {
			if (getTipoModelo() != 2) 
				return false;
		}
		
		if(this.tipoOperacion==2) {
			// In schema: "tipoContingencia" : {"type" : "integer"}
			if(getTipoContingencia()==null)
		        return false;
		}
		
		return true;
	}


	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
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
	 * @param ambiente the ambiente to set<br>
	 * The parameter is validated.<br>
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
	 * @param numeroControl the numeroControl to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^DTE-11-[A-Z0-9]{8}-[0-9]{15}$"
	 */
	public void setNumeroControl(String numeroControl) {
		final String PATTERN = "^DTE-11-[A-Z0-9]{8}-[0-9]{15}$";
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
	 * @param tipoContingencia the tipoContingencia to set<br>
	 * The parameter is validated.<br>
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
	 * @param codigoGeneracion the codigoGeneracion to set<br>
	 * The parameter is validated.<br>
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
	 * @param motivoContin the motivoContin to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 5, "maxLength" : 150
	 */
	public void setMotivoContin(String motivoContin) {
		final int MINLENGTH = 1;		
		final int MAXLENGTH = 500;
		int length = motivoContin.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH ) || (motivoContin==null) )
			this.motivoContin = motivoContin;
		else
	        throw new IllegalArgumentException("Wrong parameter 'motivoContin' in setMotivoContin()");
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
	 * @param horEmi the horEmi to set<br>
	 * The parameter is validated.<br>
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
	 * @param tipoModelo the tipoModelo to set<br>
	 * The parameter is validated.<br>
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
	 * @param tipoOperacion the tipoOperacion to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2]
	 */
	public void setTipoOperacion(int tipoOperacion) {
		if (tipoOperacion==1 || tipoOperacion==2)
			this.tipoOperacion = tipoOperacion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoOperacion' in setTipoOperacion()");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
