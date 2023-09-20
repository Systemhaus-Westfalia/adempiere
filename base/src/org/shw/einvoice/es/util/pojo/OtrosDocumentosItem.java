package org.shw.einvoice.es.util.pojo;

public interface OtrosDocumentosItem {
	static final String VALIDATION_RESULT_OK = "OK";
	public String validateValues();

	// Common properties
	public int getCodDocAsociado();
	public void setCodDocAsociado(int codDocAsociado);
	public String getDescDocumento();
	public void setDescDocumento(String descDocumento);
	public String getDetalleDocumento();
	public void setDetalleDocumento(String detalleDocumento);

	// Only ComprobanteCreditoFiscal and FacturaElectronica
	public Medico getMedico();
	public void setMedico(Medico medico);

	// Only FacturaExportacion
	public String getPlacaTrans();
	public void setPlacaTrans(String placaTrans);
	public Integer getModoTransp();
	public void setModoTransp(Integer modoTransp);
	public String getNumConductor();
	public void setNumConductor(String numConductor);
	public String getNombreConductor();
	public void setNombreConductor(String nombreConductor);

}
