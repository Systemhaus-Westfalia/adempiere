/**
 * 
 */
package org.shw.einvoice.es.fefexfacturaexportacionv1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.PagosItem;
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.TributosItem;

/**
 * 
 */
public class ResumenFacturaExportacion implements Resumen {

	BigDecimal totalGravada;
	BigDecimal descuento;
	BigDecimal porcentajeDescuento;
	BigDecimal totalDescu;
	BigDecimal seguro=null;  // null allowed
	BigDecimal flete=null;  // null allowed
	BigDecimal montoTotalOperacion;
	BigDecimal totalNoGravado;
	BigDecimal totalPagar;
	String totalLetras;
	int condicionOperacion;
	List<PagosItem> pagos ;  // there must be at least one item
	String codIncoterms=null;  // null allowed
	String descIncoterms=null;  // null allowed
	String numPagoElectronico=null;  // null allowed
	String observaciones=null;  // null allowed   


	/**
	 * No parameters
	 */
	public ResumenFacturaExportacion() {
		this.pagos = new ArrayList<PagosItem>();
	}
	
	/**
	 * Validate the Schema conditions
	 */
	@Override
	public String validateValues() {
		return VALIDATION_RESULT_OK;
	}


	/**
	 * @return the totalGravada
	 */
	@Override
	public BigDecimal getTotalGravada() {
		return totalGravada;
	}


	/**
	 * @param totalGravada the totalGravada to set
	 */
	@Override
	public void setTotalGravada(BigDecimal totalGravada) {
		this.totalGravada = totalGravada;
	}

	/**
	 * @return the descuento
	 */
	@Override
	public BigDecimal getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	@Override
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the porcentajeDescuento
	 */
	@Override
	public BigDecimal getPorcentajeDescuento() {
		return porcentajeDescuento;
	}


	/**
	 * @param porcentajeDescuento the porcentajeDescuento to set
	 */
	@Override
	public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}


	/**
	 * @return the totalDescu
	 */
	@Override
	public BigDecimal getTotalDescu() {
		return totalDescu;
	}

	/**
	 * @param totalDescu the totalDescu to set
	 */
	@Override
	public void setTotalDescu(BigDecimal totalDescu) {
		this.totalDescu = totalDescu;
	}

	/**
	 * @return the seguro
	 */
	@Override
	public BigDecimal getSeguro() {
		return seguro;
	}

	/**
	 * @param seguro the seguro to set
	 */
	@Override
	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}

	/**
	 * @return the flete
	 */
	@Override
	public BigDecimal getFlete() {
		return flete;
	}

	/**
	 * @param flete the flete to set
	 */
	@Override
	public void setFlete(BigDecimal flete) {
		this.flete = flete;
	}


	/**
	 * @return the montoTotalOperacion
	 */
	@Override
	public BigDecimal getMontoTotalOperacion() {
		return montoTotalOperacion;
	}


	/**
	 * @param montoTotalOperacion the montoTotalOperacion to set
	 */
	@Override
	public void setMontoTotalOperacion(BigDecimal montoTotalOperacion) {
		this.montoTotalOperacion = montoTotalOperacion;
	}


	/**
	 * @return the totalNoGravado
	 */
	@Override
	public BigDecimal getTotalNoGravado() {
		return totalNoGravado;
	}


	/**
	 * @param totalNoGravado the totalNoGravado to set
	 */
	@Override
	public void setTotalNoGravado(BigDecimal totalNoGravado) {
		this.totalNoGravado = totalNoGravado;
	}


	/**
	 * @return the totalPagar
	 */
	@Override
	public BigDecimal getTotalPagar() {
		return totalPagar;
	}


	/**
	 * @param totalPagar the totalPagar to set
	 */
	@Override
	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}


	/**
	 * @return the totalLetras
	 */
	@Override
	public String getTotalLetras() {
		return totalLetras;
	}


	/**
	 * @param totalLetras the totalLetras to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 200
	 */
	@Override
	public void setTotalLetras(String totalLetras) {
		final int MAXLENGTH = 200;
		int length = totalLetras==null?0:totalLetras.length();

		if( length<=MAXLENGTH)
			this.totalLetras = totalLetras;
		else
			throw new IllegalArgumentException("Wrong parameter 'totalLetras' in Factura.Resumen.setTotalLetras()");
	}


	/**
	 * @return the condicionOperacion
	 */
	@Override
	public int getCondicionOperacion() {
		return condicionOperacion;
	}


	/**
	 * @param condicionOperacion the condicionOperacion to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2,3]
	 */
	@Override
	public void setCondicionOperacion(int condicionOperacion) {
		if (condicionOperacion==1 || condicionOperacion==2 || condicionOperacion==2)
			this.condicionOperacion = condicionOperacion;
		else
			throw new IllegalArgumentException("Wrong parameter 'condicionOperacion' in Factura.Resumen.setCondicionOperacion()");
	}


	/**
	 * @return the pagos
	 */
	@Override
	public List<PagosItem> getPagos() {
		return pagos;
	}


	/**
	 * @param pagos the pagos to set
	 */
	@Override
	public void setPagos(List<PagosItem> pagos) {
		this.pagos = pagos;
	}


	/**
	 * @return the codIncoterms
	 */
	@Override
	public String getCodIncoterms() {
		return codIncoterms;
	}

	/**
	 * @param codIncoterms the codIncoterms to set<br>
	 * The parameter is validated.<br>
	 * null is possible
	 */
	@Override
	public void setCodIncoterms(String codIncoterms) {
		this.codIncoterms = codIncoterms;
	}

	/**
	 * @return the descIncoterms
	 */
	@Override
	public String getDescIncoterms() {
		return descIncoterms;
	}

	/**
	 * @param descIncoterms the descIncoterms to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 3, "maxLength" : 150; null also possible
	 */
	@Override
	public void setDescIncoterms(String descIncoterms) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 150;
		int length = descIncoterms==null?0:descIncoterms.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (descIncoterms==null) )
			this.descIncoterms = descIncoterms;
		else
			throw new IllegalArgumentException("Wrong parameter 'descIncoterms' in Factura.Resumen.setDescIncoterms()");
	}

	/**
	 * @return the numPagoElectronico
	 */
	@Override
	public String getNumPagoElectronico() {
		return numPagoElectronico;
	}


	/**
	 * @param numPagoElectronico the numPagoElectronico to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 100; null also possible
	 */
	@Override
	public void setNumPagoElectronico(String numPagoElectronico) {
		final int MAXLENGTH = 100;
		int length = numPagoElectronico==null?0:numPagoElectronico.length();

		if( (length<=MAXLENGTH) || (numPagoElectronico==null) )
			this.numPagoElectronico = numPagoElectronico;
		else
			throw new IllegalArgumentException("Wrong parameter 'numPagoElectronico' in Factura.Resumen.setNumPagoElectronico()");
	}


	/**
	 * @return the observaciones
	 */
	@Override
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 500; null also possible
	 */
	@Override
	public void setObservaciones(String observaciones) {
		final int MAXLENGTH = 500;
		int length = observaciones==null?0:observaciones.length();

		if( (length<=MAXLENGTH) || (observaciones==null) )
			this.observaciones = observaciones;
		else
			throw new IllegalArgumentException("Wrong parameter 'observaciones' in Factura.Resumen.setObservaciones()");
	}

    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalNoSuj() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getTotalNoSuj() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalNoSuj(BigDecimal totalNoSuj) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setTotalNoSuj() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalExenta() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getTotalExenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalExenta(BigDecimal totalExenta) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setTotalExenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getSubTotalVentas() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getSubTotalVentas() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setSubTotalVentas(BigDecimal subTotalVentas) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setSubTotalVentas() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getDescuNoSuj() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getDescuNoSuj() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescuNoSuj(BigDecimal descuNoSuj) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setDescuNoSuj() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getDescuExenta() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getDescuExenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescuExenta(BigDecimal descuExenta) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setDescuExenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getDescuGravada() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getDescuGravada() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescuGravada(BigDecimal descuGravada) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setDescuGravada() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public List<TributosItem> getTributos() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getTributos() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTributos(List<TributosItem> tributos) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setTributos() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getSubTotal() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getSubTotal() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setSubTotal(BigDecimal subTotal) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setSubTotal() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getIvaRete1() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getIvaRete1() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setIvaRete1(BigDecimal ivaRete1) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setIvaRete1() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getReteRenta() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getReteRenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setReteRenta(BigDecimal reteRenta) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setReteRenta() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getIvaPerci1() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getIvaPerci1() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setIvaPerci1(BigDecimal ivaPerci1) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setIvaPerci1() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getSaldoFavor() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getSaldoFavor() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setSaldoFavor(BigDecimal saldoFavor) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setSaldoFavor() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalSujetoRetencion() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getTotalSujetoRetencion() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalSujetoRetencion(BigDecimal totalSujetoRetencion) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setTotalSujetoRetencion() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalIVAretenido() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getTotalIVAretenido() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalIVAretenido(BigDecimal totalIVAretenido) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setTotalIVAretenido() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getTotalIVAretenidoLetras() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getTotalIVAretenidoLetras() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalIVAretenidoLetras(String totalIVAretenidoLetras) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setTotalIVAretenidoLetras() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalIva() {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.getTotalIva() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalIva(BigDecimal totalIva) {
		throw new UnsupportedOperationException("In Document Factura de Exportacion calling the method Resumen.setTotalIva() is not allowed");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
