package org.shw.einvoice.es.util.pojo;

public interface Identificacion {
	static final String VALIDATION_RESULT_OK = "OK";
	
	// First: differences

	// Only for class Anulacion 	
	public String getFecAnula();
	public void setFecAnula(String fecAnula);
	public String getHorAnula();
	public void setHorAnula(String horAnula);

	// Only for class Factura Exportacion 
	public String getMotivoContigencia();	
	public void setMotivoContigencia(String motivoContigencia);
	
	// Only for class Retencion
	public String getMotivoContingencia();
	public void setMotivoContingencia(String motivoContingencia);

	// Common properties for all classes 
	public String validateValues();
	public int getVersion();	
	public void setVersion(int version);	
	public String getAmbiente();	
	public void setAmbiente(String ambiente);	
	public String getTipoDte();	
	public void setTipoDte(String tipoDte);	
	public String getNumeroControl();	
	public void setNumeroControl(String numeroControl);	
	public String getCodigoGeneracion();	
	public void setCodigoGeneracion(String codigoGeneracion);	
	public int getTipoModelo();	
	public void setTipoModelo(int tipoModelo);	
	public int getTipoOperacion();	
	public void setTipoOperacion(int tipoOperacion);	
	public Integer getTipoContingencia();	
	public void setTipoContingencia(Integer tipoContingencia);	
	public String getMotivoContin();	
	public void setMotivoContin(String motivoContin);	
	public String getFecEmi();	
	public void setFecEmi(String fecEmi);	
	public String getHorEmi();	
	public void setHorEmi(String horEmi);	
	public String getTipoMoneda();	
	public void setTipoMoneda(String tipoMoneda);
}


