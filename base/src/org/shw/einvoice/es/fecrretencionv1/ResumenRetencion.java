/**
 * 
 */
package org.shw.einvoice.es.fecrretencionv1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.PagosItem;
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.TributosItem;  // This is only needed because interface Resumen.

/**
 * 
 */
public class ResumenRetencion implements Resumen {

	BigDecimal totalSujetoRetencion;
	BigDecimal totalIVAretenido;
	String totalIVAretenidoLetras;

	/**
	 * No parameters
	 */
	public ResumenRetencion() {
	}




	/**
	 * Validate the Schema conditions
	 */
	@Override
	public String validateValues() {
		return VALIDATION_RESULT_OK;
	}
	
	/**
	 * @return the totalSujetoRetencion
	 */
	@Override
	public BigDecimal getTotalSujetoRetencion() {
		return totalSujetoRetencion;
	}

	/**
	 * @param totalSujetoRetencion the totalSujetoRetencion to set
	 */
	@Override
	public void setTotalSujetoRetencion(BigDecimal totalSujetoRetencion) {
		this.totalSujetoRetencion = totalSujetoRetencion;
	}

	/**
	 * @return the totalIVAretenido
	 */
	@Override
	public BigDecimal getTotalIVAretenido() {
		return totalIVAretenido;
	}

	/**
	 * @param totalIVAretenido the totalIVAretenido to set
	 */
	@Override
	public void setTotalIVAretenido(BigDecimal totalIVAretenido) {
		this.totalIVAretenido = totalIVAretenido;
	}

	/**
	 * @return the totalIVAretenidoLetras;
	 */
	@Override
	public String getTotalIVAretenidoLetras() {
		return totalIVAretenidoLetras;
	}


	/**
	 * @param totalLetras the totalIVAretenidoLetras; to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 200
	 */
	@Override
	public void setTotalIVAretenidoLetras(String totalIVAretenidoLetras) {
		final int MAXLENGTH = 200;
		int length = totalIVAretenidoLetras==null?0:totalIVAretenidoLetras.length();

		if( length<=MAXLENGTH)
			this.totalIVAretenidoLetras = totalIVAretenidoLetras;
		else
			throw new IllegalArgumentException("Wrong parameter 'totalLetras' in Retencion.Resumen.setTotalIVAretenidoLetras()");
	}
	
	


    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalNoSuj() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTotalNoSuj() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalNoSuj(BigDecimal totalNoSuj) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTotalNoSuj() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalExenta() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTotalExenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalExenta(BigDecimal totalExenta) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTotalExenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getSubTotalVentas() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getSubTotalVentas() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setSubTotalVentas(BigDecimal subTotalVentas) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setSubTotalVentas() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getDescuNoSuj() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getDescuNoSuj() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescuNoSuj(BigDecimal descuNoSuj) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setDescuNoSuj() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getDescuExenta() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getDescuExenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescuExenta(BigDecimal descuExenta) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setDescuExenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getDescuGravada() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getDescuGravada() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescuGravada(BigDecimal descuGravada) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setDescuGravada() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<TributosItem> getTributos() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTributos() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTributos(List<TributosItem> tributos) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTributos() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getSubTotal() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getSubTotal() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setSubTotal(BigDecimal subTotal) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setSubTotal() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getIvaRete1() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getIvaRete1() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setIvaRete1(BigDecimal ivaRete1) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setIvaRete1() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getReteRenta() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getReteRenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setReteRenta(BigDecimal reteRenta) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setReteRenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalGravada() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTotalGravada() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalGravada(BigDecimal totalGravada) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTotalGravada() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalDescu() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTotalDescu() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalDescu(BigDecimal totalDescu) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTotalDescu() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getMontoTotalOperacion() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getMontoTotalOperacion() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMontoTotalOperacion(BigDecimal montoTotalOperacion) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setMontoTotalOperacion() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getTotalLetras() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTotalLetras() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalLetras(String totalLetras) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTotalLetras() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public int getCondicionOperacion() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getCondicionOperacion() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCondicionOperacion(int condicionOperacion) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setCondicionOperacion() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getPorcentajeDescuento() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getPorcentajeDescuento() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setPorcentajeDescuento() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalNoGravado() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTotalNoGravado() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalNoGravado(BigDecimal totalNoGravado) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTotalNoGravado() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalPagar() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTotalPagar() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalPagar(BigDecimal totalPagar) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTotalPagar() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<PagosItem> getPagos() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getPagos() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPagos(List<PagosItem> pagos) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setPagos() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getIvaPerci1() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getIvaPerci1() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setIvaPerci1(BigDecimal ivaPerci1) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setIvaPerci1() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getSaldoFavor() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getSaldoFavor() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setSaldoFavor(BigDecimal saldoFavor) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setSaldoFavor() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNumPagoElectronico() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getNumPagoElectronico() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNumPagoElectronico(String numPagoElectronico) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setNumPagoElectronico() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getDescuento() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getDescuento() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescuento(BigDecimal descuento) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setDescuento() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getSeguro() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getSeguro() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setSeguro(BigDecimal seguro) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setSeguro() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getFlete() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getFlete() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setFlete(BigDecimal flete) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setFlete() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodIncoterms() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getCodIncoterms() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodIncoterms(String codIncoterms) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setCodIncoterms() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getDescIncoterms() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getDescIncoterms() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescIncoterms(String descIncoterms) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setDescIncoterms() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getObservaciones() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getObservaciones() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setObservaciones(String observaciones) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setObservaciones() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalIva() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.getTotalIva() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalIva(BigDecimal totalIva) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Resumen.setTotalIva() is not allowed");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
