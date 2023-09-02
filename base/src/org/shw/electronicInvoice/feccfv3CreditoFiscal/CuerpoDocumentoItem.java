/**
 * 
 */
package org.shw.electronicInvoice.feccfv3CreditoFiscal;

import java.util.List;

/**
 * 
 */
public class CuerpoDocumentoItem {
	
	String numItem;
	String tipoItem;
	String numeroDocumento;
	String cantidad;
	String codigo;
	String codTributo;
	String uniMedida;
	String descripcion;
	String precioUni;
	String montoDescu;
	String ventaNoSuj;
	String ventaExenta;
	String ventaGravada;
	List<String> tributos;
    String psv;
    String noGravado;
    String ivaItem;
    
    /**
	 * @param numItem
	 * @param tipoItem
	 * @param numeroDocumento
	 * @param cantidad
	 * @param codigo
	 * @param codTributo
	 * @param uniMedida
	 * @param descripcion
	 * @param precioUni
	 * @param montoDescu
	 * @param ventaNoSuj
	 * @param ventaExenta
	 * @param ventaGravada
	 * @param tributos
	 * @param psv
	 * @param noGravado
	 * @param ivaItem
	 */
	public CuerpoDocumentoItem(String numItem, String tipoItem, String numeroDocumento, String cantidad, String codigo,
			String codTributo, String uniMedida, String descripcion, String precioUni, String montoDescu,
			String ventaNoSuj, String ventaExenta, String ventaGravada, List<String> tributos, String psv,
			String noGravado, String ivaItem) {
		super();
		this.numItem = numItem;
		this.tipoItem = tipoItem;
		this.numeroDocumento = numeroDocumento;
		this.cantidad = cantidad;
		this.codigo = codigo;
		this.codTributo = codTributo;
		this.uniMedida = uniMedida;
		this.descripcion = descripcion;
		this.precioUni = precioUni;
		this.montoDescu = montoDescu;
		this.ventaNoSuj = ventaNoSuj;
		this.ventaExenta = ventaExenta;
		this.ventaGravada = ventaGravada;
		this.tributos = tributos;
		this.psv = psv;
		this.noGravado = noGravado;
		this.ivaItem = ivaItem;
	}

	/**
	 * @return the numItem
	 */
	public String getNumItem() {
		return numItem;
	}

	/**
	 * @param numItem the numItem to set
	 */
	public void setNumItem(String numItem) {
		this.numItem = numItem;
	}

	/**
	 * @return the tipoItem
	 */
	public String getTipoItem() {
		return tipoItem;
	}

	/**
	 * @param tipoItem the tipoItem to set
	 */
	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the cantidad
	 */
	public String getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codTributo
	 */
	public String getCodTributo() {
		return codTributo;
	}

	/**
	 * @param codTributo the codTributo to set
	 */
	public void setCodTributo(String codTributo) {
		this.codTributo = codTributo;
	}

	/**
	 * @return the uniMedida
	 */
	public String getUniMedida() {
		return uniMedida;
	}

	/**
	 * @param uniMedida the uniMedida to set
	 */
	public void setUniMedida(String uniMedida) {
		this.uniMedida = uniMedida;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the precioUni
	 */
	public String getPrecioUni() {
		return precioUni;
	}

	/**
	 * @param precioUni the precioUni to set
	 */
	public void setPrecioUni(String precioUni) {
		this.precioUni = precioUni;
	}

	/**
	 * @return the montoDescu
	 */
	public String getMontoDescu() {
		return montoDescu;
	}

	/**
	 * @param montoDescu the montoDescu to set
	 */
	public void setMontoDescu(String montoDescu) {
		this.montoDescu = montoDescu;
	}

	/**
	 * @return the ventaNoSuj
	 */
	public String getVentaNoSuj() {
		return ventaNoSuj;
	}

	/**
	 * @param ventaNoSuj the ventaNoSuj to set
	 */
	public void setVentaNoSuj(String ventaNoSuj) {
		this.ventaNoSuj = ventaNoSuj;
	}

	/**
	 * @return the ventaExenta
	 */
	public String getVentaExenta() {
		return ventaExenta;
	}

	/**
	 * @param ventaExenta the ventaExenta to set
	 */
	public void setVentaExenta(String ventaExenta) {
		this.ventaExenta = ventaExenta;
	}

	/**
	 * @return the ventaGravada
	 */
	public String getVentaGravada() {
		return ventaGravada;
	}

	/**
	 * @param ventaGravada the ventaGravada to set
	 */
	public void setVentaGravada(String ventaGravada) {
		this.ventaGravada = ventaGravada;
	}

	/**
	 * @return the tributos
	 */
	public List<String> getTributos() {
		return tributos;
	}

	/**
	 * @param tributos the tributos to set
	 */
	public void setTributos(List<String> tributos) {
		this.tributos = tributos;
	}

	/**
	 * @return the psv
	 */
	public String getPsv() {
		return psv;
	}

	/**
	 * @param psv the psv to set
	 */
	public void setPsv(String psv) {
		this.psv = psv;
	}

	/**
	 * @return the noGravado
	 */
	public String getNoGravado() {
		return noGravado;
	}

	/**
	 * @param noGravado the noGravado to set
	 */
	public void setNoGravado(String noGravado) {
		this.noGravado = noGravado;
	}

	/**
	 * @return the ivaItem
	 */
	public String getIvaItem() {
		return ivaItem;
	}

	/**
	 * @param ivaItem the ivaItem to set
	 */
	public void setIvaItem(String ivaItem) {
		this.ivaItem = ivaItem;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
