package org.shw.einvoice.es.util.pojo;

public interface Receptor {
	static final String VALIDATION_RESULT_OK = "OK";
	public String validateValues();

	//common for all documents
	public String getNombre();
	public void setNombre(String nombre);
	public String getDescActividad();
	public void setDescActividad(String descActividad);
	public Direccion getDireccion();
	public void setDireccion(Direccion direccion);
	public String getTelefono();
	public void setTelefono(String telefono);
	public String getCorreo();
	public void setCorreo(String correo);
	
	// For CreditoFiscal, NotaDeCredito, NotaDeDebito
	public String getNit();
	public void setNit(String nit);
	public String getNrc();
	
	// For CreditoFiscal, NotaDeCredito, NotaDeDebito, Retencion, Factura
	public void setNrc(String nrc);
	public String getCodActividad();
	public void setCodActividad(String codActividad);
	
	// For CreditoFiscal, NotaDeCredito, NotaDeDebito, Retencion, FacturaExportacion
	public String getNombreComercial();
	public void setNombreComercial(String nombreComercial);
	public String getNombrePais();

	// For FacturaExportacion
	public void setNombrePais(String nombrePais);
	public String getCodPais();
	public void setCodPais(String codPais);
	public String getComplemento();
	public void setComplemento(String complemento);
	public int getTipoPersona();
	public void setTipoPersona(int tipoPersona);

	// For Retencion, Factura, FacturaExportacion
	public String getTipoDocumento();
	public void setTipoDocumento(String tipoDocumento);
	public String getNumDocumento();
	public void setNumDocumento(String numDocumento);
}
