/**
 * 
 */
package org.shw.einvoice.es.feccfcreditofiscalv3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.PagosItem;
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.TributosItem;

/**
 * 
 */
public class ResumenCreditoFiscal implements Resumen {
	static final String VALIDATION_TOTALGRAVADA_IS_NULL  = "Documento: Credito Fiscal, clase: Resumen. Validacion falló: valor de 'totlaGravada' no debe ser = null";
	static final String VALIDATION_PLAZO_IS_NULL         = "Documento: Credito Fiscal, clase: Resumen. Validacion falló: valor de 'plazo' de pagos no debe ser ='null'";
	static final String VALIDATION_PERIODO_IS_NULL       = "Documento: Credito Fiscal, clase: Resumen. Validacion falló: valor de 'periodo' de pagos no debe ser ='null'";
	static final String VALIDATION_TOTALGRAVADA_IVAPERC1 = "Documento: Credito Fiscal, clase: Resumen. Validacion falló: valor de 'ivaPerci1' no debe ser mayor que cero";
	static final String VALIDATION_TOTALGRAVADA_IVARETE1 = "Documento: Credito Fiscal, clase: Resumen. Validacion falló: valor de 'ivaRete1' no debe ser mayor que cero";
	static final String VALIDATION_TOTALGRAVADA_CONDOP   = "Documento: Credito Fiscal, clase: Resumen. Validacion falló: valor de 'condicionOperacion' no debe ser diferente a 1";

	BigDecimal totalNoSuj;
	BigDecimal totalExenta;
	BigDecimal totalGravada;
	BigDecimal subTotalVentas;
	BigDecimal descuNoSuj;
	BigDecimal descuExenta;
	BigDecimal descuGravada;
	BigDecimal porcentajeDescuento;
	BigDecimal totalDescu;
	List<TributosItem> tributos;
	BigDecimal subTotal;
	BigDecimal ivaPerci1;
	BigDecimal ivaRete1;
	BigDecimal reteRenta;
	BigDecimal montoTotalOperacion;
	BigDecimal totalNoGravado;
	BigDecimal totalPagar;
	String totalLetras;
	BigDecimal saldoFavor;
	int condicionOperacion;
	List<PagosItem> pagos ;  // there must be at least one item
	String numPagoElectronico=null;  // null allowed



	/**
	 * No parameters
	 */
	public ResumenCreditoFiscal() {
		this.pagos = new ArrayList<PagosItem>();
	}

	/**
	 * Validate the Schema conditions
	 */
	@Override
	public String validateValues() {
		if(getCondicionOperacion()==2) {
			if ( (getPagos()==null) ||  (getPagos().size()==0) ||  (getPagos().get(0).getPlazo()==null) )
				return VALIDATION_PLAZO_IS_NULL;
		} else {
			if ( (getPagos()==null) ||  (getPagos().size()==0) ||  (getPagos().get(0).getPeriodo()==null) )
				return VALIDATION_PERIODO_IS_NULL;
		}	

		if(getTotalGravada()==null) {
			return VALIDATION_TOTALGRAVADA_IS_NULL;
		}

		if(getTotalGravada().compareTo(BigDecimal.ZERO)==0) {
			if ( (getIvaPerci1()==null) || (getIvaPerci1().compareTo(BigDecimal.ZERO) == 1) )
				return VALIDATION_TOTALGRAVADA_IVAPERC1;
		} 

		if(getTotalGravada().compareTo(BigDecimal.ZERO)==0) {
			if ( (getIvaPerci1()==null) ||  (getIvaRete1().compareTo(BigDecimal.ZERO) == 1) )
				return VALIDATION_TOTALGRAVADA_IVARETE1;
		} 

		if( (getTotalPagar()!=null) && (getTotalPagar().compareTo(BigDecimal.ZERO)==0) ) {
			if ( getCondicionOperacion() != 1 )
				return VALIDATION_TOTALGRAVADA_CONDOP;
		}

		return VALIDATION_RESULT_OK;
	}

	/**
	 * @return the totalNoSuj
	 */
	@Override
	public BigDecimal getTotalNoSuj() {
		return totalNoSuj;
	}


	/**
	 * @param totalNoSuj the totalNoSuj to set
	 */
	@Override
	public void setTotalNoSuj(BigDecimal totalNoSuj) {
		this.totalNoSuj = totalNoSuj;
	}


	/**
	 * @return the totalExenta
	 */
	@Override
	public BigDecimal getTotalExenta() {
		return totalExenta;
	}


	/**
	 * @param totalExenta the totalExenta to set
	 */
	@Override
	public void setTotalExenta(BigDecimal totalExenta) {
		this.totalExenta = totalExenta;
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
	 * @return the subTotalVentas
	 */
	@Override
	public BigDecimal getSubTotalVentas() {
		return subTotalVentas;
	}


	/**
	 * @param subTotalVentas the subTotalVentas to set
	 */
	@Override
	public void setSubTotalVentas(BigDecimal subTotalVentas) {
		this.subTotalVentas = subTotalVentas;
	}


	/**
	 * @return the descuNoSuj
	 */
	@Override
	public BigDecimal getDescuNoSuj() {
		return descuNoSuj;
	}


	/**
	 * @param descuNoSuj the descuNoSuj to set
	 */
	@Override
	public void setDescuNoSuj(BigDecimal descuNoSuj) {
		this.descuNoSuj = descuNoSuj;
	}


	/**
	 * @return the descuExenta
	 */
	@Override
	public BigDecimal getDescuExenta() {
		return descuExenta;
	}


	/**
	 * @param descuExenta the descuExenta to set
	 */
	@Override
	public void setDescuExenta(BigDecimal descuExenta) {
		this.descuExenta = descuExenta;
	}


	/**
	 * @return the descuGravada
	 */
	@Override
	public BigDecimal getDescuGravada() {
		return descuGravada;
	}


	/**
	 * @param descuGravada the descuGravada to set
	 */
	@Override
	public void setDescuGravada(BigDecimal descuGravada) {
		this.descuGravada = descuGravada;
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
	 * @return the tributos
	 */
	@Override
	public List<TributosItem> getTributos() {
		return tributos;
	}


	/**
	 * @param tributos the tributos to set
	 */
	@Override
	public void setTributos(List<TributosItem> tributos) {
		this.tributos = tributos;
	}


	/**
	 * @return the subTotal
	 */
	@Override
	public BigDecimal getSubTotal() {
		return subTotal;
	}


	/**
	 * @param subTotal the subTotal to set
	 */
	@Override
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}


	/**
	 * @return the ivaPerci1
	 */
	@Override
	public BigDecimal getIvaPerci1() {
		return ivaPerci1;
	}


	/**
	 * @param ivaPerci1 the ivaPerci1 to set
	 */
	@Override
	public void setIvaPerci1(BigDecimal ivaPerci1) {
		this.ivaPerci1 = ivaPerci1;
	}


	/**
	 * @return the ivaRete1
	 */
	@Override
	public BigDecimal getIvaRete1() {
		return ivaRete1;
	}


	/**
	 * @param ivaRete1 the ivaRete1 to set
	 */
	@Override
	public void setIvaRete1(BigDecimal ivaRete1) {
		this.ivaRete1 = ivaRete1;
	}


	/**
	 * @return the reteRenta
	 */
	@Override
	public BigDecimal getReteRenta() {
		return reteRenta;
	}

	/**
	 * @param reteRenta the reteRenta to set
	 */
	@Override
	public void setReteRenta(BigDecimal reteRenta) {
		this.reteRenta = reteRenta;
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
			throw new IllegalArgumentException("Wrong parameter 'totalLetras' in CreditoFiscal.Resumen.setTotalLetras()");
	}


	/**
	 * @return the saldoFavor
	 */
	@Override
	public BigDecimal getSaldoFavor() {
		return saldoFavor;
	}


	/**
	 * @param saldoFavor the saldoFavor to set
	 */
	@Override
	public void setSaldoFavor(BigDecimal saldoFavor) {
		this.saldoFavor = saldoFavor;
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
	 * "enum" : [1,2, 3]
	 */
	@Override
	public void setCondicionOperacion(int condicionOperacion) {
		if (condicionOperacion==1 || condicionOperacion==2 || condicionOperacion==2)
			this.condicionOperacion = condicionOperacion;
		else
			throw new IllegalArgumentException("Wrong parameter 'condicionOperacion' in CreditoFiscal.Resumen.setCondicionOperacion()");
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
			throw new IllegalArgumentException("Wrong parameter 'numPagoElectronico' in CreditoFiscal.Resumen.setNumPagoElectronico()");
	}


    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalSujetoRetencion() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getTotalSujetoRetencion() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalSujetoRetencion(BigDecimal totalSujetoRetencion) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getTotalSujetoRetencion() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalIVAretenido() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getTotalIVAretenido() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalIVAretenido(BigDecimal totalIVAretenido) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setTotalIVAretenido() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getTotalIVAretenidoLetras() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getTotalIVAretenidoLetras() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalIVAretenidoLetras(String totalIVAretenidoLetras) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setTotalIVAretenidoLetras() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getDescuento() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getDescuento() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescuento(BigDecimal descuento) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setDescuento() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getSeguro() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getSeguro() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setSeguro(BigDecimal seguro) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setSeguro() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getFlete() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getFlete() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setFlete(BigDecimal flete) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setFlete() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodIncoterms() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getCodIncoterms() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodIncoterms(String codIncoterms) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setCodIncoterms() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getDescIncoterms() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getDescIncoterms() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescIncoterms(String descIncoterms) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setDescIncoterms() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getObservaciones() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getObservaciones() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setObservaciones(String observaciones) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setObservaciones() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getTotalIva() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.getTotalIva() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTotalIva(BigDecimal totalIva) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Resumen.setTotalIva() is not allowed");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
