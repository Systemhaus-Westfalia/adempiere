package org.shw.einvoice.es.fencnotadecreditov1;
import java.util.regex.Pattern;

import org.shw.einvoice.es.util.pojo.Identificacion;  

public class IdentificacionNotaDeCredito implements Identificacion {

	static final int VERSION              = 3;
	static final String TIPO_DE_DOCUMENTO = "05";
	static final String TIPOMONEDA        = "USD";
	
	static final String VALIDATION_TIPOMODELO_FAILED_1         = "Documento: Nota de Credito, clase: Identificacion. Validacion falló: valor de 'tipoModelo' no debe ser diferente a 1";
	static final String VALIDATION_TIPOCONTINGENCIA_NOT_NULL   = "Documento: Nota de Credito, clase: Identificacion. Validacion falló: valor de 'tipoContingencia' debe ser ='null'";
	static final String VALIDATION_MOTIVOCONTINGENCIA_NOT_NULL = "Documento: Nota de Credito, clase: Identificacion. Validacion falló: valor de 'motivoContingencia' debe ser ='null'";
	static final String VALIDATION_TIPOMODELO_FAILED_2         = "Documento: Nota de Credito, clase: Identificacion. Validacion falló: valor de 'tipoModelo' no debe ser diferente a 2";
	static final String VALIDATION_TIPOOCONTINGENCIA_IS_NULL   = "Documento: Nota de Credito, clase: Identificacion. Validacion falló: valor de 'tipoContingencia' no debe ser ='null'";
	static final String VALIDATION_MOTIVOCONTINGENCIA_IS_NULL  = "Documento: Nota de Credito, clase: Identificacion. Validacion falló: valor de 'motivoContingencia' no debe ser ='null'";
	
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
	public IdentificacionNotaDeCredito() {
		this.version    = VERSION;
		this.tipoDte    = TIPO_DE_DOCUMENTO;
		this.tipoMoneda = TIPOMONEDA;
	}
	
	/**
	 * Validate the Schema conditions
	 */
	@Override
	public String validateValues() {
		if(getTipoOperacion()==1) {
			if (getTipoModelo() != 1) 
				return VALIDATION_TIPOMODELO_FAILED_1;
			if (getTipoContingencia() != null) 
				return VALIDATION_TIPOCONTINGENCIA_NOT_NULL;
			if (getMotivoContin() != null) 
				return VALIDATION_MOTIVOCONTINGENCIA_NOT_NULL;
		} else  {
			if (getTipoModelo() != 2) 
				return VALIDATION_TIPOMODELO_FAILED_2;
		}
		
		if(getTipoOperacion()==2) {
			// In schema: "tipoContingencia" : {"type" : "integer"}
			if(getTipoContingencia()==null)
		        return VALIDATION_TIPOOCONTINGENCIA_IS_NULL;
		}
		
		if(getTipoContingencia()==5) {
			// In schema: "motivoContin" : {"type" : "string"}
			if(getMotivoContin()==null)
		        return VALIDATION_MOTIVOCONTINGENCIA_IS_NULL;
		}
		
		return VALIDATION_RESULT_OK;
	}


	/**
	 * @return the version
	 */
	@Override
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	@Override
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the ambiente
	 */
	@Override
	public String getAmbiente() {
		return ambiente;
	}


	/**
	 * @param ambiente the ambiente to set<br>
	 * The parameter is validated.<br>
	 * "enum" : ["00", "01"]
	 */
	@Override
	public void setAmbiente(String ambiente) {
		if (ambiente.compareTo("00")==0 || ambiente.compareTo("01")==0)
			this.ambiente = ambiente;
		else
	        throw new IllegalArgumentException("Wrong parameter 'ambiente' in NotaDeCredito.Identificacion.setAmbiente()");
	}

	/**
	 * @return the tipoDte
	 */
	@Override
	public String getTipoDte() {
		return tipoDte;
	}


	/**
	 * @param tipoDte the tipoDte to set
	 */
	@Override
	public void setTipoDte(String tipoDte) {
		this.tipoDte = tipoDte;
	}


	/**
	 * @return the numeroControl
	 */
	@Override
	public String getNumeroControl() {
		return numeroControl;
	}


	/**
	 * @param numeroControl the numeroControl to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^DTE-05-[A-Z0-9]{8}-[0-9]{15}$"
	 */
	@Override
	public void setNumeroControl(String numeroControl) {
		final String PATTERN = "^DTE-05-[A-Z0-9]{8}-[0-9]{15}$";
		boolean patternOK = (numeroControl!=null) && Pattern.matches(PATTERN, numeroControl);  
		
		if(patternOK)
			this.numeroControl = numeroControl;
		else
	        throw new IllegalArgumentException("Wrong expression 'numeroControl' in NotaDeCredito.Identificacion.setNumeroControl()");
	}


	/**
	 * @return the codigoGeneracion
	 */
	@Override
	public String getCodigoGeneracion() {
		return codigoGeneracion;
	}

	/**
	 * @return the tipoContingencia
	 */
	@Override
	public Integer getTipoContingencia() {
		return tipoContingencia;
	}

	/**
	 * @param tipoContingencia the tipoContingencia to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2,3,4,5], null
	 */
	@Override
	public void setTipoContingencia(Integer tipoContingencia) {
		if (tipoContingencia==null || tipoContingencia==1 || tipoContingencia==2 || tipoContingencia==3 || tipoContingencia==4 || tipoContingencia==5)
			this.tipoContingencia = tipoContingencia;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoContingencia' in NotaDeCredito.Identificacion.setTipoContingencia()");

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
	@Override
	public void setCodigoGeneracion(String codigoGeneracion) {
		final String PATTERN = "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$";
		boolean patternOK = (codigoGeneracion!=null) && Pattern.matches(PATTERN, codigoGeneracion);  
		
		if(patternOK)
			this.codigoGeneracion = codigoGeneracion;
		else
	        throw new IllegalArgumentException("Wrong expression 'codigoGeneracion' in NotaDeCredito.Identificacion.setCodigoGeneracion()");
	}


	/**
	 * @return the motivoContin
	 */
	@Override
	public String getMotivoContin() {
		return motivoContin;
	}


	/**
	 * @param motivoContin the motivoContin to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 150
	 */
	@Override
	public void setMotivoContin(String motivoContin) {
		final int MINLENGTH = 1;		
		final int MAXLENGTH = 150;
		int length = motivoContin==null?0:motivoContin.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH ) || (motivoContin==null) )
			this.motivoContin = motivoContin;
		else
	        throw new IllegalArgumentException("Wrong parameter 'motivoContin' in NotaDeCredito.Identificacion.setMotivoContin()");
	}


	/**
	 * @return the fecEmi
	 */
	@Override
	public String getFecEmi() {
		return fecEmi;
	}


	/**
	 * @param fecEmi the fecEmi to set<br>
	 * null not allowed
	 */
	@Override
	public void setFecEmi(String fecEmi) {
		if (fecEmi!=null)
			this.fecEmi = fecEmi;
		else
	        throw new IllegalArgumentException("Wrong parameter 'fecEmi' in NotaDeCredito.Identificacion.setFecEmi()");
	}


	/**
	 * @return the horEmi
	 */
	@Override
	public String getHorEmi() {
		return horEmi;
	}


	/**
	 * @param horEmi the horEmi to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]?$"
	 */
	@Override
	public void setHorEmi(String horEmi) {
		final String PATTERN = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]?$";
		boolean patternOK = (horEmi!=null) && Pattern.matches(PATTERN, horEmi);  
		
		if(patternOK)
			this.horEmi = horEmi;
		else
	        throw new IllegalArgumentException("Wrong expression 'horEmi' in NotaDeCredito.Identificacion.setHorEmi()");
	}


	/**
	 * @return the tipoMoneda
	 */
	@Override
	public String getTipoMoneda() {
		return tipoMoneda;
	}


	/**
	 * @param tipoMoneda the tipoMoneda to set
	 */
	@Override
	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	/**
	 * @return the tipoModelo
	 */
	@Override
	public int getTipoModelo() {
		return tipoModelo;
	}

	/**
	 * @param tipoModelo the tipoModelo to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2]
	 */
	@Override
	public void setTipoModelo(int tipoModelo) {
		if (tipoModelo==1 || tipoModelo==2)
			this.tipoModelo = tipoModelo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoModelo' in NotaDeCredito.Identificacion.setTipoModelo()");
	}

	/**
	 * @return the tipoOperacion
	 */
	@Override
	public int getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * @param tipoOperacion the tipoOperacion to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2]
	 */
	@Override
	public void setTipoOperacion(int tipoOperacion) {
		if (tipoOperacion==1 || tipoOperacion==2)
			this.tipoOperacion = tipoOperacion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoOperacion' in NotaDeCredito.Identificacion.setTipoOperacion()");
	}


	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION
	

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getFecAnula() {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method Identificacion.getFecAnula() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setFecAnula(String fecAnula) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method Identificacion.setFecAnula() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getHorAnula() {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method Identificacion.getHorAnula() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setHorAnula(String horAnula) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method Identificacion.setHorAnula() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getMotivoContigencia() {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method Identificacion.getMotivoContigencia() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMotivoContigencia(String motivoContigencia) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method Identificacion.setMotivoContigencia() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getMotivoContingencia() {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method Identificacion.getMotivoContingencia() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMotivoContingencia(String motivoContingencia) {
		throw new UnsupportedOperationException("In Document Nota de Credito calling the method Identificacion.setMotivoContingencia() is not allowed");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
