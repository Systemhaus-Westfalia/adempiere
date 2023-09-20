/**
 * 
 */
package org.shw.einvoice.es.fefexfacturaexportacionv1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.VentaTercero;


/**
 * 
 */
public class FacturaExportacion {
	static final int OTROSDOCUMENTOS_MAXIMUM_ITEMS = 20;
	static final int CUERPODOCUMENTO_MAXIMUM_ITEMS = 2000;

	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_RESUMEN_OR_MONTO_IS_NULL  = "Documento: Factura, clase: FacturaExportacion. Validacion falló: valor de 'getResumen() y getMontoTotalOperacion()' no debe ser ='null'";
	static final String VALIDATION_CORREO_IS_NULL            = "Documento: Factura de Exportacion, clase: FacturaExportacion. Validacion falló: valor de 'receptor.correo' no debe ser ='null'";
	static final String VALIDATION_OTROSDOCUMENTOS_MAXITEMS  = "Documento: Factura de Exportacion, clase: FacturaExportacion. Validacion falló: valor de 'otrosDocumentos' debe contemner entre 1 y " + 
																OTROSDOCUMENTOS_MAXIMUM_ITEMS + " elementos";
	static final String VALIDATION_CUERPODOCUMENTO_MAXITEMS  = "Documento: Factura de Exportacion, clase: FacturaExportacion. Validacion falló: valor de 'cuerpoDocumento' debe contemner entre 1 y " + 
																CUERPODOCUMENTO_MAXIMUM_ITEMS + " elementos";
	
	IdentificacionFacturaExportacion identificacion;
	EmisorFacturaExportacion emisor;
	ReceptorFacturaExportacion receptor;
	List<OtrosDocumentosItemFacturaExportacon> otrosDocumentos = null;
	VentaTercero ventaTercero = null;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	List<ApendiceItem> apendice=null;  // null allowed

	/**
	 * No parameters
	 */
	public FacturaExportacion() {
		this.identificacion       = new IdentificacionFacturaExportacion();
		this.emisor				  = new EmisorFacturaExportacion();
		this.receptor             = new ReceptorFacturaExportacion();
		//this.otrosDocumentos      = new ArrayList<OtrosDocumentosItem>();
		//this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		//this.apendice             = new ArrayList<ApendiceItem>();
	}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {

		if( (getResumen()==null) || (getResumen().getMontoTotalOperacion()==null) ) {
			return VALIDATION_RESUMEN_OR_MONTO_IS_NULL;
		}
		
		if(getResumen().getMontoTotalOperacion().compareTo(BigDecimal.valueOf(10000-1))==1) {
			if ( getReceptor().getCorreo()== null)
				return VALIDATION_CORREO_IS_NULL;
		} 
		
		if( (getOtrosDocumentos()!=null) && ( (getOtrosDocumentos().size()==0) || (getOtrosDocumentos().size()>OTROSDOCUMENTOS_MAXIMUM_ITEMS) ) ) {
			return VALIDATION_OTROSDOCUMENTOS_MAXITEMS;
		}
		
		if( (getCuerpoDocumento()==null) || (getCuerpoDocumento().size()==0) || (getCuerpoDocumento().size()>CUERPODOCUMENTO_MAXIMUM_ITEMS) ) {
			return VALIDATION_CUERPODOCUMENTO_MAXITEMS;
		}
		
		return VALIDATION_RESULT_OK;
	}
	
	
	/**
	 * @return the identificacion
	 */
	public IdentificacionFacturaExportacion getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionFacturaExportacion identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the emisor
	 */
	public EmisorFacturaExportacion getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorFacturaExportacion emisor) {
		this.emisor = emisor;
	}

	/**
	 * @return the receptor
	 */
	public ReceptorFacturaExportacion getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorFacturaExportacion receptor) {
		this.receptor = receptor;
	}

	/**
	 * @return the otrosDocumentos
	 */
	public List<OtrosDocumentosItemFacturaExportacon> getOtrosDocumentos() {
		return otrosDocumentos;
	}

	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(List<OtrosDocumentosItemFacturaExportacon> otrosDocumentos) {
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
