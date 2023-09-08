/**
 * 
 */
package org.shw.einvoice.es.fefexfacturaexportacionv1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.fefcfacturaelectronicav1.Resumen;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.VentaTercero;


/**
 * 
 */
public class FacturaExportacion {
	
	Identificacion identificacion;
	Emisor emisor;
	Receptor receptor;
	List<OtrosDocumentosItem> otrosDocumentos;
	VentaTercero ventaTercero;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	List<ApendiceItem> apendice=null;  // null allowed

	/**
	 * No parameters
	 */
	public FacturaExportacion() {
		this.identificacion       = new Identificacion();
		this.emisor				  = new Emisor();
		this.receptor             = new Receptor();
		this.otrosDocumentos      = new ArrayList<OtrosDocumentosItem>();
		this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		this.apendice             = new ArrayList<ApendiceItem>();
	}

	/**
	 * Validate the Schema conditions
	 */
	public boolean validateValues() {
		
		if(getResumen().getMontoTotalOperacion().compareTo(BigDecimal.valueOf(10000-1))==1) {
			if ( getReceptor().getCorreo()== null)
				return false;
		} 
		
		return true;
	}
	
	
	/**
	 * @return the identificacion
	 */
	public Identificacion getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the emisor
	 */
	public Emisor getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}

	/**
	 * @return the receptor
	 */
	public Receptor getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	/**
	 * @return the otrosDocumentos
	 */
	public List<OtrosDocumentosItem> getOtrosDocumentos() {
		return otrosDocumentos;
	}

	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos) {
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
