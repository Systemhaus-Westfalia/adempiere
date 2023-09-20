/**
 * 
 */
package org.shw.einvoice.es.fecrretencionv1;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.shw.einvoice.es.util.pojo.CuerpoDocumentoItem;

/**
 * 
 */
public class CuerpoDocumentoItemRetencion implements CuerpoDocumentoItem {
	
	int numItem;
	String tipoDte;
	int tipoDoc;
	String numDocumento;
	String fechaEmision;
	BigDecimal montoSujetoGrav;
	String codigoRetencionMH;
	BigDecimal ivaRetenido;
	String descripcion;
	
    
    /**
	 * Constructor without parameters. 
	 */
	public CuerpoDocumentoItemRetencion() {
		
	}

	

	/**
	 * Validate the Schema conditions
	 * Schema is wrong.
	 * According to schema
	 * if(getTipoDoc()==1)  -> codGeneracion PATTERN = "^[a-zA-Z0-9]{1,20}$"
	 * if(getTipoDoc()==2)  -> codGeneracion PATTERN = "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$"
	 * But there is no codGeneracion in this class.
	 */
	@Override
	public String validateValues() {	
		return VALIDATION_RESULT_OK;
	}

	/**
	 * @return the numItem
	 */
	@Override
	public int getNumItem() {
		return numItem;
	}

	/**
	 * @param numItem the numItem to set<br>
	 * The parameter is validated.<br>
	 * "minimum" : 1, "maximum" : 500
	 */
	@Override
	public void setNumItem(int numItem) {
		final int MINIMUM = 1;
		final int MAXIMUM = 500;
		
		if(numItem>=MINIMUM && numItem<=MAXIMUM)
			this.numItem = numItem;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numItem' in Retencion.CuerpoDocumentoItem.setNumItem()");
	}

	/**
	 * @return the descripcion
	 */
	@Override
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the tipoDte
	 */
	@Override
	public String getTipoDte() {
		return tipoDte;
	}



	/**
	 * @param tipoDte the tipoDte to set<br>
	 * The parameter is validated.<br>
	 * "enum" : ["14", "03", "01"]
	 */
	@Override
	public void setTipoDte(String tipoDte) {
		if (tipoDte.compareTo("14")==0 || tipoDte.compareTo("03")==0 || tipoDte.compareTo("01")==0)
			this.tipoDte = tipoDte;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoDte' in Retencion.CuerpoDocumentoItem.setTipoDte()");
	}



	/**
	 * @return the tipoDoc
	 */
	@Override
	public int getTipoDoc() {
		return tipoDoc;
	}



	/**
	 * @param tipoDoc the tipoDoc to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2]
	 */
	@Override
	public void setTipoDoc(int tipoDoc) {
		if (tipoDoc==1 || tipoDoc==2)
			this.tipoDoc = tipoDoc;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoDoc' in Retencion.CuerpoDocumentoItem.setTipoDoc()");
	}



	/**
	 * @return the numDocumento
	 */
	@Override
	public String getNumDocumento() {
		return numDocumento;
	}



	/**
	 * @param numDocumento the numDocumento to set
	 * Schema allows only strings
	 */
	@Override
	public void setNumDocumento(String numDocumento) {
		if (numDocumento!=null)
			this.numDocumento = numDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numDocumento' in Retencion.CuerpoDocumentoItem.setNumDocumento()");
	}



	/**
	 * @return the fechaEmision
	 */
	@Override
	public String getFechaEmision() {
		return fechaEmision;
	}



	/**
	 * @param fechaEmision the fechaEmision to set<br>
	 * null not allowed
	 */
	@Override
	public void setFechaEmision(String fechaEmision) {
		if (fechaEmision!=null)
			this.fechaEmision = fechaEmision;
		else
	        throw new IllegalArgumentException("Wrong parameter 'fechaEmision' in Retencion.CuerpoDocumentoItem.setFechaEmision()");
	}



	/**
	 * @return the montoSujetoGrav
	 */
	@Override
	public BigDecimal getMontoSujetoGrav() {
		return montoSujetoGrav;
	}



	/**
	 * @param montoSujetoGrav the montoSujetoGrav to set
	 */
	@Override
	public void setMontoSujetoGrav(BigDecimal montoSujetoGrav) {
		this.montoSujetoGrav = montoSujetoGrav;
	}



	/**
	 * @return the codigoRetencionMH
	 */
	@Override
	public String getCodigoRetencionMH() {
		return codigoRetencionMH;
	}



	/**
	 * @param codigoRetencionMH the codigoRetencionMH to set<br>
	 * The parameter is validated.<br>
	 * "enum" : ["22", "C4", "C9"]
	 */
	@Override
	public void setCodigoRetencionMH(String codigoRetencionMH) {
		if (codigoRetencionMH.compareTo("22")==0 || codigoRetencionMH.compareTo("C4")==0 || codigoRetencionMH.compareTo("C9")==0)
			this.codigoRetencionMH = codigoRetencionMH;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codigoRetencionMH' in Retencion.CuerpoDocumentoItem.setCodigoRetencionMH()");
	}



	/**
	 * @return the ivaRetenido
	 */
	@Override
	public BigDecimal getIvaRetenido() {
		return ivaRetenido;
	}



	/**
	 * @param ivaRetenido the ivaRetenido to set
	 */
	@Override
	public void setIvaRetenido(BigDecimal ivaRetenido) {
		this.ivaRetenido = ivaRetenido;
	}



	/**
	 * @param descripcion the descripcion to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 1000
	 */
	@Override
	public void setDescripcion(String descripcion) {
		final int MAXLENGTH = 1000;
		int length = descripcion==null?0:descripcion.length();
		
		if(length<=MAXLENGTH)
			this.descripcion = descripcion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descripcion' in Retencion.CuerpoDocumentoItem.setDescripcion()");
	}



    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION



	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodigo() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getCodigo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodigo(String codigo) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setCodigo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public int getUniMedida() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getUniMedida() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setUniMedida(int uniMedida) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setUniMedida() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getCantidad() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getCantidad() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCantidad(BigDecimal cantidad) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setCantidad() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getPrecioUni() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getPrecioUni() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPrecioUni(BigDecimal precioUni) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setPrecioUni() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getMontoDescu() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getMontoDescu() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setMontoDescu(BigDecimal montoDescu) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setMontoDescu() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getVentaGravada() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getVentaGravada() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setVentaGravada(BigDecimal ventaGravada) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setVentaGravada() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public ArrayList<String> getTributos() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getTributos() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTributos(ArrayList<String> tributos) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setTributos() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public int getTipoItem() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getTipoItem() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoItem(int tipoItem) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setTipoItem() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodTributo() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getCodTributo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodTributo(String codTributo) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setCodTributo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getVentaNoSuj() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getVentaNoSuj() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setVentaNoSuj(BigDecimal ventaNoSuj) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setVentaNoSuj() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getVentaExenta() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getVentaExenta() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setVentaExenta(BigDecimal ventaExenta) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setVentaExenta() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNumeroDocumento() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getNumeroDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNumeroDocumento(String numeroDocumento) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setNumeroDocumento() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getPsv() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getPsv() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPsv(BigDecimal psv) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setPsv() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getNoGravado() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getNoGravado() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNoGravado(BigDecimal noGravado) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setNoGravado() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public BigDecimal getIvaItem() {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.getIvaItem() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setIvaItem(BigDecimal ivaItem) {
		throw new UnsupportedOperationException("In Document Retencion calling the method CuerpoDocumentoItem.setIvaItem() is not allowed");
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
