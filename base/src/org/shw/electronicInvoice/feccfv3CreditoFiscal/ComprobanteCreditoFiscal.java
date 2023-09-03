/**
 * 
 */
package org.shw.electronicInvoice.feccfv3CreditoFiscal;
import java.util.ArrayList;

/**
 * 
 */
public class ComprobanteCreditoFiscal {

	Identificacion identificacion;
	ArrayList<DocumentoRelacionadoItem> documentoRelacionado;
	Emisor emisor;
	Receptor receptor;
	ArrayList<OtrosDocumentosItem> otrosDocumentos;
	VentaTercero ventaTercero;
	ArrayList<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	Extension extension;
	Apendice apendice;

	/**
	 * No parameters
	 */
	public ComprobanteCreditoFiscal() {
		this.identificacion       = new Identificacion();
		this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItem>();
		this.emisor               = new Emisor();
		this.receptor             = new Receptor();
		this.otrosDocumentos      = new ArrayList<OtrosDocumentosItem>();
		this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		this.extension            = new Extension();
		this.apendice             = new Apendice();
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
	 * @return the documentoRelacionado
	 */
	public ArrayList<DocumentoRelacionadoItem> getDocumentoRelacionado() {
		return documentoRelacionado;
	}


	/**
	 * @param documentoRelacionado the documentoRelacionado to set
	 */
	public void setDocumentoRelacionado(ArrayList<DocumentoRelacionadoItem> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
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
	public ArrayList<OtrosDocumentosItem> getOtrosDocumentos() {
		return otrosDocumentos;
	}


	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(ArrayList<OtrosDocumentosItem> otrosDocumentos) {
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
	public ArrayList<CuerpoDocumentoItem> getCuerpoDocumento() {
		return cuerpoDocumento;
	}


	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(ArrayList<CuerpoDocumentoItem> cuerpoDocumento) {
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
	public Apendice getApendice() {
		return apendice;
	}


	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(Apendice apendice) {
		this.apendice = apendice;
	}
	
	

}
