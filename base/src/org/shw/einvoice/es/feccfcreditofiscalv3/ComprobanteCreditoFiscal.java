/**
 * 
 */
package org.shw.einvoice.es.feccfcreditofiscalv3;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.Extension;

/**
 * 
 */
public class ComprobanteCreditoFiscal {
	
	IdentificacionCreditoFiscal identificacion;
	List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionado = null;
	EmisorCreditoFiscal emisor;
	ReceptorCreditoFiscal receptor;
	List<OtrosDocumentosItemCreditoFiscal> otrosDocumentos = null;
	VentaTerceroCreditoFiscal ventaTercero = null;
	List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumento;
	ResumenCreditoFiscal resumen;
	Extension extension;
	List<ApendiceItem> apendice=null;  // null allowed

	/**
	 * No parameters
	 */
	public ComprobanteCreditoFiscal() {
		this.identificacion       = new IdentificacionCreditoFiscal();
		//this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItem>();		
		this.emisor               = new EmisorCreditoFiscal();
		this.receptor             = new ReceptorCreditoFiscal();
		//this.otrosDocumentos      = new ArrayList<OtrosDocumentosItem>();
		//this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItemCreditoFiscal>();
		this.resumen              = new ResumenCreditoFiscal();
		this.extension            = new Extension();
		//this.apendice             = new ArrayList<ApendiceItem>();
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * @return the identificacion
	 */
	public IdentificacionCreditoFiscal getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionCreditoFiscal identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the documentoRelacionado
	 */
	public List<DocumentoRelacionadoItemCreditoFiscal> getDocumentoRelacionado() {
		return documentoRelacionado;
	}


	/**
	 * @param documentoRelacionado the documentoRelacionado to set
	 */
	public void setDocumentoRelacionado(List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}


	/**
	 * @return the emisor
	 */
	public EmisorCreditoFiscal getEmisor() {
		return emisor;
	}


	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorCreditoFiscal emisor) {
		this.emisor = emisor;
	}


	/**
	 * @return the receptor
	 */
	public ReceptorCreditoFiscal getReceptor() {
		return receptor;
	}


	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorCreditoFiscal receptor) {
		this.receptor = receptor;
	}


	/**
	 * @return the otrosDocumentos
	 */
	public List<OtrosDocumentosItemCreditoFiscal> getOtrosDocumentos() {
		return otrosDocumentos;
	}


	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(List<OtrosDocumentosItemCreditoFiscal> otrosDocumentos) {
		this.otrosDocumentos = otrosDocumentos;
	}


	/**
	 * @return the ventaTercero
	 */
	public VentaTerceroCreditoFiscal getVentaTercero() {
		return ventaTercero;
	}


	/**
	 * @param ventaTercero the ventaTercero to set
	 */
	public void setVentaTercero(VentaTerceroCreditoFiscal ventaTercero) {
		this.ventaTercero = ventaTercero;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	public List<CuerpoDocumentoItemCreditoFiscal> getCuerpoDocumento() {
		return cuerpoDocumento;
	}


	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}


	/**
	 * @return the resumen
	 */
	public ResumenCreditoFiscal getResumen() {
		return resumen;
	}


	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(ResumenCreditoFiscal resumen) {
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

	
}
