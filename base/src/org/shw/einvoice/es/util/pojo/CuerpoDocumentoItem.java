package org.shw.einvoice.es.util.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface CuerpoDocumentoItem {
	static final String VALIDATION_RESULT_OK = "OK";
	public String validateValues();
	
	// Common properties
	public int getNumItem();
	public void setNumItem(int numItem);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	
	// For ComprobanteCreditoFiscal, FacturaElectronica, FacturaExportacion, NotaDeCredito, NotaDeDebito
	public String getCodigo();
	public void setCodigo(String codigo);
	public int getUniMedida();
	public void setUniMedida(int uniMedida);
	public BigDecimal getCantidad();
	public void setCantidad(BigDecimal cantidad);
	public BigDecimal getPrecioUni();
	public void setPrecioUni(BigDecimal precioUni);
	public BigDecimal getMontoDescu();
	public void setMontoDescu(BigDecimal montoDescu);
	public BigDecimal getVentaGravada();
	public void setVentaGravada(BigDecimal ventaGravada);
	public ArrayList<String> getTributos();
	public void setTributos(ArrayList<String> tributos);
	
	// For ComprobanteCreditoFiscal, FacturaElectronica, NotaDeCredito, NotaDeDebito
	public int getTipoItem();
	public void setTipoItem(int tipoItem);
	public String getCodTributo();
	public void setCodTributo(String codTributo);
	public BigDecimal getVentaNoSuj();
	public void setVentaNoSuj(BigDecimal ventaNoSuj);
	public BigDecimal getVentaExenta();
	public void setVentaExenta(BigDecimal ventaExenta);

	// For ComprobanteCreditoFiscal, FacturaElectronica, NotaDeCredito, NotaDeDebito
	public String getNumeroDocumento();
	public void setNumeroDocumento(String numeroDocumento);
	
	// For ComprobanteCreditoFiscal, FacturaElectronica
	public BigDecimal getPsv();
	public void setPsv(BigDecimal psv);

	// For ComprobanteCreditoFiscal, FacturaElectronica, FacturaExportacion
	public BigDecimal getNoGravado();
	public void setNoGravado(BigDecimal noGravado);

	// For Retencion
	public String getNumDocumento();
	public void setNumDocumento(String numDocumento);
	public String getFechaEmision();
	public void setFechaEmision(String fechaEmision);
	public BigDecimal getMontoSujetoGrav();
	public void setMontoSujetoGrav(BigDecimal montoSujetoGrav);
	public String getCodigoRetencionMH();
	public void setCodigoRetencionMH(String codigoRetencionMH);
	public BigDecimal getIvaRetenido();
	public void setIvaRetenido(BigDecimal ivaRetenido);	
	public String getTipoDte();
	public void setTipoDte(String tipoDte);
	public int getTipoDoc();
	public void setTipoDoc(int tipoDoc);

	// For FacturaElectronica
	public BigDecimal getIvaItem();
	public void setIvaItem(BigDecimal ivaItem);
}
