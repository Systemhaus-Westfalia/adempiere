package org.shw.einvoice.es.util.pojo;

import java.math.BigDecimal;
import java.util.List;

public interface Resumen {
	static final String VALIDATION_RESULT_OK = "OK";
	public String validateValues();

	// For ComprobanteCreditoFiscal, FacturaElectronica, NotaDeCredito, NotaDeDebito
	public BigDecimal getTotalNoSuj();
	public void setTotalNoSuj(BigDecimal totalNoSuj);
	public BigDecimal getTotalExenta();
	public void setTotalExenta(BigDecimal totalExenta);
	public BigDecimal getSubTotalVentas();
	public void setSubTotalVentas(BigDecimal subTotalVentas);
	public BigDecimal getDescuNoSuj();
	public void setDescuNoSuj(BigDecimal descuNoSuj);
	public BigDecimal getDescuExenta();
	public void setDescuExenta(BigDecimal descuExenta);
	public BigDecimal getDescuGravada();
	public void setDescuGravada(BigDecimal descuGravada);
	public List<TributosItem> getTributos();
	public void setTributos(List<TributosItem> tributos);
	public BigDecimal getSubTotal();
	public void setSubTotal(BigDecimal subTotal);
	public BigDecimal getIvaRete1();
	public void setIvaRete1(BigDecimal ivaRete1);
	public BigDecimal getReteRenta();
	public void setReteRenta(BigDecimal reteRenta);

	// For ComprobanteCreditoFiscal, FacturaElectronica, FacturaExportacion, NotaDeCredito, NotaDeDebito
	public BigDecimal getTotalGravada();
	public void setTotalGravada(BigDecimal totalGravada);
	public BigDecimal getTotalDescu();
	public void setTotalDescu(BigDecimal totalDescu);
	public BigDecimal getMontoTotalOperacion();
	public void setMontoTotalOperacion(BigDecimal montoTotalOperacion);
	public String getTotalLetras();
	public void setTotalLetras(String totalLetras);
	public int getCondicionOperacion();
	public void setCondicionOperacion(int condicionOperacion);

	// For ComprobanteCreditoFiscal, FacturaElectronica, FacturaExportacion
	public BigDecimal getPorcentajeDescuento();
	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento);
	public BigDecimal getTotalNoGravado();
	public void setTotalNoGravado(BigDecimal totalNoGravado);
	public BigDecimal getTotalPagar();
	public void setTotalPagar(BigDecimal totalPagar);
	public List<PagosItem> getPagos();
	public void setPagos(List<PagosItem> pagos);

	// For ComprobanteCreditoFiscal, NotaDeCredito, NotaDeDebito
	public BigDecimal getIvaPerci1();
	public void setIvaPerci1(BigDecimal ivaPerci1);

	// For ComprobanteCreditoFiscal, FacturaElectronica
	public BigDecimal getSaldoFavor();
	public void setSaldoFavor(BigDecimal saldoFavor);

	// For ComprobanteCreditoFiscal, FacturaElectronica, FacturaExportacion, NotaDeDebito
	public String getNumPagoElectronico();
	public void setNumPagoElectronico(String numPagoElectronico);

	// For Retencion
	public BigDecimal getTotalSujetoRetencion();
	public void setTotalSujetoRetencion(BigDecimal totalSujetoRetencion);
	public BigDecimal getTotalIVAretenido();
	public void setTotalIVAretenido(BigDecimal totalIVAretenido);
	public String getTotalIVAretenidoLetras();
	public void setTotalIVAretenidoLetras(String totalIVAretenidoLetras);

	// For FacturaExportacion
	public BigDecimal getDescuento();
	public void setDescuento(BigDecimal descuento);
	public BigDecimal getSeguro();
	public void setSeguro(BigDecimal seguro);
	public BigDecimal getFlete();
	public void setFlete(BigDecimal flete);
	public String getCodIncoterms();
	public void setCodIncoterms(String codIncoterms);
	public String getDescIncoterms();
	public void setDescIncoterms(String descIncoterms);
	public String getObservaciones();
	public void setObservaciones(String observaciones);

	// For FacturaElectronica
	public BigDecimal getTotalIva();
	public void setTotalIva(BigDecimal totalIva);

}
