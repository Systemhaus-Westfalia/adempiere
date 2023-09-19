package org.shw.einvoice.es.util.pojo;

public interface Emisor {
	static final String VALIDATION_RESULT_OK = "OK";
	public String validateValues();
    
	// Common Properties
	public String getNit();
	public void setNit(String nit);
	public String getNrc();
	public void setNrc(String nrc);
	public String getNombre();
	public void setNombre(String nombre);
	public String getCodActividad();
	public void setCodActividad(String codActividad);
	public String getDescActividad();
	public void setDescActividad(String descActividad);
	public String getNombreComercial();
	public void setNombreComercial(String nombreComercial);
	public String getTipoEstablecimiento();
	public void setTipoEstablecimiento(String tipoEstablecimiento);
	public Direccion getDireccion();
	public void setDireccion(Direccion direccion);
	public String getTelefono();
	public void setTelefono(String telefono);
	public String getCorreo();
	public void setCorreo(String correo);
	public String getCodEstableMH();
	public void setCodEstableMH(String codEstableMH);
	public String getCodEstable();
	public void setCodEstable(String codEstable);
	public String getCodPuntoVentaMH();
	public void setCodPuntoVentaMH(String codPuntoVentaMH);
	public String getCodPuntoVenta();
	public void setCodPuntoVenta(String codPuntoVenta);

    // Properties for Anulacion
	public String getNomEstablecimiento();
	public void setNomEstablecimiento(String nomEstablecimiento);
	
    // Properties for Retencion
	public String getCodigoMH();
	public void setCodigoMH(String codigoMH);
	public String getCodigo();
	public void setCodigo(String codigo);
	public String getPuntoVentaMH();
	public void setPuntoVentaMH(String puntoVentaMH);
	public String getPuntoVenta();
	public void setPuntoVenta(String puntoVenta);

    // Properties for Factura Exportacion
	public int getTipoItemExpor();
	public void setTipoItemExpor(int tipoItemExpor);
	public String getRecintoFiscal();
	public void setRecintoFiscal(String recintoFiscal);
	public String getRegimen();
	public void setRegimen(String regimen);
}
