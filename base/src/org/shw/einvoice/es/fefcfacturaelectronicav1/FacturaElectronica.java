/**
 * 
 */
package org.shw.einvoice.es.fefcfacturaelectronicav1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.Extension;
import org.shw.einvoice.es.util.pojo.VentaTercero;

/**
 * 
 */
public class FacturaElectronica {
	static final int MINIMUM_TOTOTAL_OF_OPERATION = 1095;
	static final int CUERPODOCUMENTO_MAXIMUM_ITEMS = 2000;

	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_RESUMEN_OR_MONTO_IS_NULL   = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'getResumen() y getMontoTotalOperacion()' no debe ser ='null'";
	static final String VALIDATION_TIPODOCUMENTO_IS_NULL      = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'tipoDocumento' no debe ser ='null'";
	static final String VALIDATION_NUMDOCUMENTO_IS_NULL       = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'numDocumento' no debe ser ='null'";
	static final String VALIDATION_NOMBRE_IS_NULL             = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'NOMBRE' no debe ser ='null'";
	static final String VALIDATION_CUERPODOCUMENTO_MAX_ITEMS  = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'cuerpoDocumento' debe  contener máximo " + CUERPODOCUMENTO_MAXIMUM_ITEMS + " elementos";
	
	IdentificacionFactura identificacion;
	List<DocumentoRelacionadoItemFactura> documentoRelacionado = null;
	EmisorFactura emisor;
	ReceptorFactura receptor;
	List<OtrosDocumentosItemFactura> otrosDocumentos = null;
	VentaTercero ventaTercero = null;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	Extension extension;
	List<ApendiceItem> apendice=null;  // null allowed

	/**
	 * No parameters
	 */
	public FacturaElectronica() {
		this.identificacion       = new IdentificacionFactura();
		//this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItem>();
		this.emisor               = new EmisorFactura();
		this.receptor             = new ReceptorFactura();
		//this.otrosDocumentos      = new ArrayList<OtrosDocumentosItem>();
		//this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		this.extension            = new Extension();
		//this.apendice             = new ArrayList<ApendiceItem>();
	}

	/**
	 * @return the identificacion
	 */
	public IdentificacionFactura getIdentificacion() {
		return identificacion;
	}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {
		if( (getResumen()==null) || (getResumen().getMontoTotalOperacion()==null) ) {
			return VALIDATION_RESUMEN_OR_MONTO_IS_NULL;
		}
		
		if(getResumen().getMontoTotalOperacion().compareTo(BigDecimal.valueOf(MINIMUM_TOTOTAL_OF_OPERATION))==1) {
			if ( getReceptor().getTipoDocumento()== null)
				return VALIDATION_TIPODOCUMENTO_IS_NULL;
			if ( getReceptor().getNumDocumento()== null)
				return VALIDATION_NUMDOCUMENTO_IS_NULL;
			if ( getReceptor().getNombre()== null)
				return VALIDATION_NOMBRE_IS_NULL;
		} 
		
		if( (getCuerpoDocumento()==null) ||  (getCuerpoDocumento().size()==0)  ||  (getCuerpoDocumento().size()>CUERPODOCUMENTO_MAXIMUM_ITEMS) ) {
			return VALIDATION_CUERPODOCUMENTO_MAX_ITEMS;
		}
		
		return VALIDATION_RESULT_OK;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionFactura identificacion) {
		this.identificacion = identificacion;
	}


	/**
	 * @return the documentoRelacionado
	 */
	public List<DocumentoRelacionadoItemFactura> getDocumentoRelacionado() {
		return documentoRelacionado;
	}


	/**
	 * @param documentoRelacionado the documentoRelacionado to set
	 */
	public void setDocumentoRelacionado(List<DocumentoRelacionadoItemFactura> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}


	/**
	 * @return the emisor
	 */
	public EmisorFactura getEmisor() {
		return emisor;
	}


	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorFactura emisor) {
		this.emisor = emisor;
	}


	/**
	 * @return the receptor
	 */
	public ReceptorFactura getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorFactura receptor) {
		this.receptor = receptor;
	}

	/**
	 * @return the otrosDocumentos
	 */
	public List<OtrosDocumentosItemFactura> getOtrosDocumentos() {
		return otrosDocumentos;
	}


	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(List<OtrosDocumentosItemFactura> otrosDocumentos) {
		this.otrosDocumentos = otrosDocumentos;
	}


	/**
	 * @return the ventaTercero
	 */
	public VentaTercero getVentaTercero() {
		return ventaTercero;
	}


	/**
	 * @param ventaTercero the ventaTercero to set
	 */
	public void setVentaTercero(VentaTercero ventaTercero) {
		this.ventaTercero = ventaTercero;
	}


	/**
	 * @return the cuerpoDocumento
	 */
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
		return cuerpoDocumento;
	}


	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}


	/**
	 * @return the resumen
	 */
	public Resumen getResumen() {
		return resumen;
	}


	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(Resumen resumen) {
		this.resumen = resumen;
	}


	/**
	 * @return the extension
	 */
	public Extension getExtension() {
		return extension;
	}


	/**
	 * @param extension the extension to set
	 */
	public void setExtension(Extension extension) {
		this.extension = extension;
	}



	/**
	 * @return the apendice
	 */
	public List<ApendiceItem> getApendice() {
		return apendice;
	}


	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(List<ApendiceItem> apendice) {
		this.apendice = apendice;
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
