package org.shw.einvoice.es.util.pojo;

public interface DocumentoRelacionadoItem {
	static final String VALIDATION_RESULT_OK = "OK";
	
	public String validateValues();
	public String getTipoDocumento();
	public void setTipoDocumento(String tipoDocumento);
	public int getTipoGeneracion();
	public void setTipoGeneracion(int tipoGeneracion);
	public String getNumeroDocumento();
	public void setNumeroDocumento(String numeroDocumento);
	public String getFechaEmision();
	public void setFechaEmision(String fechaEmision);
}
