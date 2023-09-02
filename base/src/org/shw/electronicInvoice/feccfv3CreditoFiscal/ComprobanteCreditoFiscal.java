/**
 * 
 */
package org.shw.electronicInvoice.feccfv3CreditoFiscal;
import java.util.List;

/**
 * 
 */
public class ComprobanteCreditoFiscal {

	Identificacion identificacion;
	List<DocumentoRelacionadoItem> documentoRelacionado;
	Emisor emisor;
	Receptor receptor;
	OtrosDocumentos otrosDocumentos;
	VentaTercero ventaTercero;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	Extension extension;
	Apendice apendice;

	/**
	 * No parameters
	 */
	public ComprobanteCreditoFiscal() {
		this.identificacion = new Identificacion();
		// documentoRelacionado not possible to initialize
		this.emisor = new Emisor();
		this.receptor = new Receptor();
		this.otrosDocumentos = new OtrosDocumentos();
		this.ventaTercero = new VentaTercero();
		// cuerpoDocumento not possible to initialize
		this.resumen = new Resumen();
		this.extension = new Extension();
		this.apendice = new Apendice();
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
	public List<DocumentoRelacionadoItem> getDocumentoRelacionado() {
		return documentoRelacionado;
	}




	/**
	 * @param documentoRelacionado the documentoRelacionado to set
	 */
	public void setDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado) {
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
	public OtrosDocumentos getOtrosDocumentos() {
		return otrosDocumentos;
	}




	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(OtrosDocumentos otrosDocumentos) {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
