/**
 * 
 */
package org.shw.electronicInvoice.feccfv3CreditoFiscal;

import java.util.ArrayList;
import java.util.List;

import org.shw.util.pojoAdempiere.PagosItem;
import org.shw.util.pojoAdempiere.TributosItem;

/**
 * 
 */
public class Resumen {
	
	String totalNoSuj;
	String totalExenta;
	String totalGravada;
	String subTotalVentas;
	String descuNoSuj;
	String descuExenta;
	String descuGravada;
	String porcentajeDescuento;
	String totalDescu;
	List<TributosItem> tributos;
    String subTotal;
    String ivaPerci1;
    String ivaRete1;
    String reteRenta;
    String montoTotalOperacion;
    String totalNoGravado;
    String totalPagar;
    String totalLetras;
    String saldoFavor;
    String condicionOperacion;
	List<PagosItem> pagos ;
   String numPagoElectronico;
   
   

	/**
	 * No parameters
	 */
public Resumen() {
	this.pagos = new ArrayList<PagosItem>();
}

	/**
	 * @return the totalNoSuj
	 */
	public String getTotalNoSuj() {
		return totalNoSuj;
	}

	/**
	 * @param totalNoSuj the totalNoSuj to set
	 */
	public void setTotalNoSuj(String totalNoSuj) {
		this.totalNoSuj = totalNoSuj;
	}

	/**
	 * @return the totalExenta
	 */
	public String getTotalExenta() {
		return totalExenta;
	}

	/**
	 * @param totalExenta the totalExenta to set
	 */
	public void setTotalExenta(String totalExenta) {
		this.totalExenta = totalExenta;
	}

	/**
	 * @return the totalGravada
	 */
	public String getTotalGravada() {
		return totalGravada;
	}

	/**
	 * @param totalGravada the totalGravada to set
	 */
	public void setTotalGravada(String totalGravada) {
		this.totalGravada = totalGravada;
	}

	/**
	 * @return the subTotalVentas
	 */
	public String getSubTotalVentas() {
		return subTotalVentas;
	}

	/**
	 * @param subTotalVentas the subTotalVentas to set
	 */
	public void setSubTotalVentas(String subTotalVentas) {
		this.subTotalVentas = subTotalVentas;
	}

	/**
	 * @return the descuNoSuj
	 */
	public String getDescuNoSuj() {
		return descuNoSuj;
	}

	/**
	 * @param descuNoSuj the descuNoSuj to set
	 */
	public void setDescuNoSuj(String descuNoSuj) {
		this.descuNoSuj = descuNoSuj;
	}

	/**
	 * @return the descuExenta
	 */
	public String getDescuExenta() {
		return descuExenta;
	}

	/**
	 * @param descuExenta the descuExenta to set
	 */
	public void setDescuExenta(String descuExenta) {
		this.descuExenta = descuExenta;
	}

	/**
	 * @return the descuGravada
	 */
	public String getDescuGravada() {
		return descuGravada;
	}

	/**
	 * @param descuGravada the descuGravada to set
	 */
	public void setDescuGravada(String descuGravada) {
		this.descuGravada = descuGravada;
	}

	/**
	 * @return the porcentajeDescuento
	 */
	public String getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * @param porcentajeDescuento the porcentajeDescuento to set
	 */
	public void setPorcentajeDescuento(String porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	/**
	 * @return the totalDescu
	 */
	public String getTotalDescu() {
		return totalDescu;
	}

	/**
	 * @param totalDescu the totalDescu to set
	 */
	public void setTotalDescu(String totalDescu) {
		this.totalDescu = totalDescu;
	}

	/**
	 * @return the tributos
	 */
	public List<TributosItem> getTributos() {
		return tributos;
	}

	/**
	 * @param tributos the tributos to set
	 */
	public void setTributos(List<TributosItem> tributos) {
		this.tributos = tributos;
	}

	/**
	 * @return the subTotal
	 */
	public String getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return the ivaPerci1
	 */
	public String getIvaPerci1() {
		return ivaPerci1;
	}

	/**
	 * @param ivaPerci1 the ivaPerci1 to set
	 */
	public void setIvaPerci1(String ivaPerci1) {
		this.ivaPerci1 = ivaPerci1;
	}

	/**
	 * @return the ivaRete1
	 */
	public String getIvaRete1() {
		return ivaRete1;
	}

	/**
	 * @param ivaRete1 the ivaRete1 to set
	 */
	public void setIvaRete1(String ivaRete1) {
		this.ivaRete1 = ivaRete1;
	}

	/**
	 * @return the reteRenta
	 */
	public String getReteRenta() {
		return reteRenta;
	}

	/**
	 * @param reteRenta the reteRenta to set
	 */
	public void setReteRenta(String reteRenta) {
		this.reteRenta = reteRenta;
	}

	/**
	 * @return the montoTotalOperacion
	 */
	public String getMontoTotalOperacion() {
		return montoTotalOperacion;
	}

	/**
	 * @param montoTotalOperacion the montoTotalOperacion to set
	 */
	public void setMontoTotalOperacion(String montoTotalOperacion) {
		this.montoTotalOperacion = montoTotalOperacion;
	}

	/**
	 * @return the totalNoGravado
	 */
	public String getTotalNoGravado() {
		return totalNoGravado;
	}

	/**
	 * @param totalNoGravado the totalNoGravado to set
	 */
	public void setTotalNoGravado(String totalNoGravado) {
		this.totalNoGravado = totalNoGravado;
	}

	/**
	 * @return the totalPagar
	 */
	public String getTotalPagar() {
		return totalPagar;
	}

	/**
	 * @param totalPagar the totalPagar to set
	 */
	public void setTotalPagar(String totalPagar) {
		this.totalPagar = totalPagar;
	}

	/**
	 * @return the totalLetras
	 */
	public String getTotalLetras() {
		return totalLetras;
	}

	/**
	 * @param totalLetras the totalLetras to set
	 */
	public void setTotalLetras(String totalLetras) {
		this.totalLetras = totalLetras;
	}

	/**
	 * @return the saldoFavor
	 */
	public String getSaldoFavor() {
		return saldoFavor;
	}

	/**
	 * @param saldoFavor the saldoFavor to set
	 */
	public void setSaldoFavor(String saldoFavor) {
		this.saldoFavor = saldoFavor;
	}

	/**
	 * @return the condicionOperacion
	 */
	public String getCondicionOperacion() {
		return condicionOperacion;
	}

	/**
	 * @param condicionOperacion the condicionOperacion to set
	 */
	public void setCondicionOperacion(String condicionOperacion) {
		this.condicionOperacion = condicionOperacion;
	}

	/**
	 * @return the pagos
	 */
	public List<PagosItem> getPagos() {
		return pagos;
	}

	/**
	 * @param pagos the pagos to set
	 */
	public void setPagos(List<PagosItem> pagos) {
		this.pagos = pagos;
	}

	/**
	 * @return the numPagoElectronico
	 */
	public String getNumPagoElectronico() {
		return numPagoElectronico;
	}

	/**
	 * @param numPagoElectronico the numPagoElectronico to set
	 */
	public void setNumPagoElectronico(String numPagoElectronico) {
		this.numPagoElectronico = numPagoElectronico;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
