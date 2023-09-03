/**
 * 
 */
package org.shw.electronicInvoice.feccfv3CreditoFiscal;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 */
public class CuerpoDocumentoItem {
	
	int numItem;
	int tipoItem;
	String numeroDocumento=null;  // null allowed
	String codigo=null;  // null allowed
	String codTributo=null;  // null allowed
	int uniMedida;
	String descripcion;
	BigDecimal cantidad;
	BigDecimal precioUni;
	BigDecimal montoDescu;
	BigDecimal ventaNoSuj;
	BigDecimal ventaExenta;
	BigDecimal ventaGravada;
	List<String> tributos=null;  // null allowed
	BigDecimal psv;
	BigDecimal noGravado;
    
    
    /**
	 * Constructor without parameters. 
	 */
	public CuerpoDocumentoItem() {
		
	}

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
	public CuerpoDocumentoItem(int numItem, int tipoItem, String numeroDocumento, BigDecimal cantidad, String codigo,
			String codTributo, int uniMedida, String descripcion, BigDecimal precioUni, BigDecimal montoDescu,
			BigDecimal ventaNoSuj, BigDecimal ventaExenta, BigDecimal ventaGravada, List<String> tributos, BigDecimal psv,
			BigDecimal noGravado) {
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
	}

	

	/**
	 * @return the numItem
	 */
	public int getNumItem() {
		return numItem;
	}

	/**
	 * @param numItem the numItem to set<br>
	 * The parameter is validated.<br>
	 * "minimum" : 1, "maximum" : 2000
	 */
	public void setNumItem(int numItem) {
		final int MINIMUM = 1;
		final int MAXIMUM = 2000;
		
		if(numItem>=MINIMUM && numItem<=MAXIMUM)
			this.numItem = numItem;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numItem' in setNumItem()");
	}


	/**
	 * @return the tipoItem
	 */
	public int getTipoItem() {
		return tipoItem;
	}

	/**
	 * @param tipoItem the tipoItem to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2,3,4]
	 */
	public void setTipoItem(int tipoItem) {
		if (tipoItem==1 || tipoItem==2 || tipoItem==3 || tipoItem==4)
			this.tipoItem = tipoItem;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoItem' in setTipoItem()");
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 36; null also possible
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 36;
		int length = numeroDocumento.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (numeroDocumento==null) )
			this.numeroDocumento = numeroDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numeroDocumento' in setNumeroDocumento()");
	}


	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 * Condition according to schema: "multipleOf" : 0.00000001
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 25; null also possible
	 */
	public void setCodigo(String codigo) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 25;
		int length = codigo.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (codigo==null) )
			this.codigo = codigo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codigo' in setCodigo()");
	}

	/**
	 * @return the codTributo
	 */
	public String getCodTributo() {
		return codTributo;
	}

	/**
	 * @param codTributo the codTributo to set<br>
	 * The parameter is validated.<br>
	 * "enum" : ["A8", "57", "90", "D4", "D5", "25", "A6"], null also allowed
	 */
	public void setCodTributo(String codTributo) {
		if (codTributo.compareTo("A8")==0 || codTributo.compareTo("57")==0 || codTributo.compareTo("90")==0 || codTributo.compareTo("D4")==0 || 
				codTributo.compareTo("D5")==0 || codTributo.compareTo("25")==0 || codTributo.compareTo("A6")==0 || codTributo==null)
			this.codTributo = codTributo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codTributo' in setCodTributo()");
	}


	/**
	 * @return the uniMedida
	 */
	public int getUniMedida() {
		return uniMedida;
	}

	/**
	 * @param uniMedida the uniMedida to set<br>
	 * The parameter is validated.<br>
	 * "minimum" : 1, "maximum" : 99
	 */
	public void setUniMedida(int uniMedida) {
		final int MINIMUM = 1;
		final int MAXIMUM = 99;
		
		if(uniMedida>=MINIMUM && uniMedida<=MAXIMUM)
			this.uniMedida = uniMedida;
		else
	        throw new IllegalArgumentException("Wrong parameter 'uniMedida' in setUniMedida()");
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 1000
	 */
	public void setDescripcion(String descripcion) {
		final int MAXLENGTH = 1000;
		int length = descripcion.length();
		
		if(length<=MAXLENGTH)
			this.descripcion = descripcion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descripcion' in setDescripcion()");
	}
	
	/**
	 * @return the precioUni
	 */
	public BigDecimal getPrecioUni() {
		return precioUni;
	}

	/**
	 * @param precioUni the precioUni to set
	 * Condition according to schema: "multipleOf" : 0.00000001
	 */
	public void setPrecioUni(BigDecimal precioUni) {
		this.precioUni = precioUni;
	}

	/**
	 * @return the montoDescu
	 */
	public BigDecimal getMontoDescu() {
		return montoDescu;
	}

	/**
	 * @param montoDescu the montoDescu to set
	 * Condition according to schema: "multipleOf" : 0.00000001
	 */
	public void setMontoDescu(BigDecimal montoDescu) {
		this.montoDescu = montoDescu;
	}

	/**
	 * @return the ventaNoSuj
	 */
	public BigDecimal getVentaNoSuj() {
		return ventaNoSuj;
	}

	/**
	 * @param ventaNoSuj the ventaNoSuj to set
	 * Condition according to schema: "multipleOf" : 0.00000001
	 */
	public void setVentaNoSuj(BigDecimal ventaNoSuj) {
		this.ventaNoSuj = ventaNoSuj;
	}

	/**
	 * @return the ventaExenta
	 */
	public BigDecimal getVentaExenta() {
		return ventaExenta;
	}

	/**
	 * @param ventaExenta the ventaExenta to set
	 * Condition according to schema: "multipleOf" : 0.00000001
	 */
	public void setVentaExenta(BigDecimal ventaExenta) {
		this.ventaExenta = ventaExenta;
	}

	/**
	 * @return the ventaGravada
	 */
	public BigDecimal getVentaGravada() {
		return ventaGravada;
	}

	/**
	 * @param ventaGravada the ventaGravada to set
	 * Condition according to schema: "multipleOf" : 0.00000001
	 */
	public void setVentaGravada(BigDecimal ventaGravada) {
		this.ventaGravada = ventaGravada;
	}

	/**
	 * @return the psv
	 */
	public BigDecimal getPsv() {
		return psv;
	}

	/**
	 * @param psv the psv to set
	 * Condition according to schema: "multipleOf" : 0.00000001
	 */
	public void setPsv(BigDecimal psv) {
		this.psv = psv;
	}

	/**
	 * @return the noGravado
	 */
	public BigDecimal getNoGravado() {
		return noGravado;
	}

	/**
	 * @param noGravado the noGravado to set
	 * Condition according to schema: "multipleOf" : 0.00000001
	 */
	public void setNoGravado(BigDecimal noGravado) {
		this.noGravado = noGravado;
	}

	/**
	 * @return the tributos
	 */
	public List<String> getTributos() {
		return tributos;
	}

	/**
	 * @param tributos the tributos to set
	 * Very complex logic: either null or a two-character string
	 * "type" : ["array", "null"], "items" : {"type" : "string", "maxLength" : 2, "minLength" : 2}
	 */
	public void setTributos(List<String> tributos) {
		this.tributos = tributos;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
