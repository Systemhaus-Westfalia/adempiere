package org.shw.einvoice.es.fecrretencionv1;
import java.util.regex.Pattern;

import org.shw.einvoice.es.util.pojo.Identificacion;  

public class IdentificacionRetencion implements Identificacion {

	static final int VERSION              = 1;
	static final String TIPO_DE_DOCUMENTO = "07";
	static final String TIPOMONEDA        = "USD";
	static final int TIPOMODELO           = 1;
	static final int TIPOOPERACION        = 1;
	
	int version=VERSION;
	String ambiente;
	String tipoDte=TIPO_DE_DOCUMENTO;
	String numeroControl;
	String codigoGeneracion;
	int tipoModelo=TIPOMODELO;
	int tipoOperacion=TIPOOPERACION;
	Integer tipoContingencia=null;  // null mandatory
	String motivoContingencia=null; // null mandatory
	String fecEmi;
	String horEmi;
	String tipoMoneda = TIPOMONEDA;

	/**
	 * No parameters
	 */
	public IdentificacionRetencion() {
		this.version            = VERSION;
		this.tipoDte            = TIPO_DE_DOCUMENTO;
		this.tipoModelo         = TIPOMODELO;
		this.tipoOperacion      = TIPOOPERACION;
		this.tipoContingencia   = null;
		this.motivoContingencia = null;
		this.tipoMoneda         = TIPOMONEDA;
	}


	/**
	 * No validation required.
	 */
	@Override
	public String validateValues() {
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
	        throw new IllegalArgumentException("Wrong parameter 'ambiente' in Retencion.Identificacion.setAmbiente()");
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
	 * "pattern" : "^DTE-07-[A-Z0-9]{8}-[0-9]{15}$"
	 */
	@Override
	public void setNumeroControl(String numeroControl) {
		final String PATTERN = "^DTE-07-[A-Z0-9]{8}-[0-9]{15}$";
		boolean patternOK = (numeroControl!=null) && Pattern.matches(PATTERN, numeroControl);  
		
		if(patternOK)
			this.numeroControl = numeroControl;
		else
	        throw new IllegalArgumentException("Wrong expression 'numeroControl' in Retencion.Identificacion.setNumeroControl()");
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
	 * null mandatory
	 */
	@Override
	public void setTipoContingencia(Integer tipoContingencia) {
		if (tipoContingencia==null)
			this.tipoContingencia = tipoContingencia;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoContingencia' in Retencion.Identificacion.setTipoContingencia()");

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
	        throw new IllegalArgumentException("Wrong expression 'codigoGeneracion' in Retencion.Identificacion.setCodigoGeneracion()");
	}


	/**
	 * @return the motivoContingencia
	 */
	@Override
	public String getMotivoContingencia() {
		return motivoContingencia;
	}


	/**
	 * @param motivoContingencia the motivoContingencia to set<br>
	 * The parameter is validated.<br>
	 * null mandatory
	 */
	@Override
	public void setMotivoContingencia(String motivoContingencia) {
		if(motivoContingencia==null)
			this.motivoContingencia = motivoContingencia;
		else
	        throw new IllegalArgumentException("Wrong parameter 'motivoContingencia' in Retencion.Identificacion.setMotivoContingencia()");
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
	        throw new IllegalArgumentException("Wrong parameter 'fecEmi' in Retencion.Identificacion.setFecEmi()");
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
	        throw new IllegalArgumentException("Wrong expression 'horEmi' in Retencion.Identificacion.setHorEmi()");
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
		if (tipoMoneda==TIPOMONEDA)
			this.tipoMoneda = tipoMoneda;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoMoneda' in Retencion.Identificacion.setTipoMoneda()");
		
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
	 * "enum" : [1]
	 */
	@Override
	public void setTipoModelo(int tipoModelo) {
		if (tipoModelo==TIPOMODELO)
			this.tipoModelo = tipoModelo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoModelo' in Retencion.Identificacion.setTipoModelo()");
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
	 * "enum" : [1]
	 */
	@Override
	public void setTipoOperacion(int tipoOperacion) {
		if (tipoOperacion==TIPOOPERACION)
			this.tipoOperacion = tipoOperacion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoOperacion' in Retencion.Identificacion.setTipoOperacion()");
	}

	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getFecAnula() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Identificacion.getFecAnula() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setFecAnula(String fecAnula) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Identificacion.setFecAnula() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getHorAnula() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Identificacion.getHorAnula() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setHorAnula(String horAnula) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Identificacion.setHorAnula() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getMotivoContigencia() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Identificacion.getMotivoContigencia() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMotivoContigencia(String motivoContigencia) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Identificacion.setMotivoContigencia() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getMotivoContin() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Identificacion.getMotivoContin() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMotivoContin(String motivoContin) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Identificacion.setMotivoContin() is not allowed");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



}
