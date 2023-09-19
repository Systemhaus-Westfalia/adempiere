package org.shw.einvoice.es.anulacionv2;
import java.util.regex.Pattern;

import org.shw.einvoice.es.util.pojo.Identificacion;  

/**
 * Just for class Anulacion
 */
public class IdentificacionAnulacion implements Identificacion {

	static final int VERSION  = 2;
	int version;
	String ambiente;
	String codigoGeneracion;
	String fecAnula;
	String horAnula; 

	/**
	 * No parameters
	 */
	public IdentificacionAnulacion() {
		this.version = VERSION;
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
			throw new IllegalArgumentException("Wrong parameter 'ambiente' in Anulacion.identificacion.setAmbiente()");
	}


	/**
	 * @return the codigoGeneracion
	 */
	@Override
	public String getCodigoGeneracion() {
		return codigoGeneracion;
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
			throw new IllegalArgumentException("Wrong expression 'codigoGeneracion' in Anulacion.identificacion.setCodigoGeneracion()");
	}



	/**
	 * @return the fecAnula
	 */
	@Override
	public String getFecAnula() {
		return fecAnula;
	}


	/**
	 * @param fecEmi the fecAnula to set<br>
	 * null not allowed
	 */
	@Override
	public void setFecAnula(String fecAnula) {
		if(fecAnula!=null)
			this.fecAnula = fecAnula;
		else
			throw new IllegalArgumentException("Wrong parameter 'fecAnula' in Anulacion.Identificacion.setFecEmi()");
	}


	/**
	 * @return the horAnula
	 */
	@Override
	public String getHorAnula() {
		return horAnula;
	}


	/**
	 * @param horEmi the horAnula to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]?$"
	 */
	@Override
	public void setHorAnula(String horAnula) {
		final String PATTERN = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]?$";
		boolean patternOK = (horAnula!=null) && Pattern.matches(PATTERN, horAnula);  

		if(patternOK)
			this.horAnula = horAnula;
		else
			throw new IllegalArgumentException("Wrong expression 'horAnula' in Anulacion.identificacion.setHorAnula()");
	}

	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getTipoDte() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getTipoDte() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoDte(String tipoDte) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setTipoDte() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNumeroControl() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getNumeroControl() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNumeroControl(String numeroControl) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setNumeroControl() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public int getTipoModelo() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getTipoModelo() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoModelo(int tipoModelo) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setTipoModelo() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public int getTipoOperacion() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getTipoOperacion() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoOperacion(int tipoOperacion) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setTipoOperacion() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Integer getTipoContingencia() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getTipoContingencia() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoContingencia(Integer tipoContingencia) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setTipoContingencia() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getMotivoContin() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getMotivoContin() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMotivoContin(String motivoContin) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setMotivoContin() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getMotivoContigencia() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getMotivoContigencia() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMotivoContigencia(String motivoContigencia) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setMotivoContigencia() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getMotivoContingencia() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getMotivoContingencia() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMotivoContingencia(String motivoContingencia) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setMotivoContingencia() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getFecEmi() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getFecEmi() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setFecEmi(String fecEmi) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setFecEmi() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getHorEmi() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getHorEmi() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setHorEmi(String horEmi) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setHorEmi() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getTipoMoneda() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.getTipoMoneda() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoMoneda(String tipoMoneda) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Identificacion.setTipoMoneda() is not allowed");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
