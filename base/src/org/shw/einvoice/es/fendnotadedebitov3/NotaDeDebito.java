/**
 * 
 */
package org.shw.einvoice.es.fendnotadedebitov3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.ApendiceItem;




/**
 * 
 */
public class NotaDeDebito {
	
	IdentificacionNotaDeDebito identificacion;
	List<DocumentoRelacionadoItemNotaDeDebito> documentoRelacionado;
	EmisorNotaDeDebito emisor;
	ReceptorNotaDeDebito receptor;
	VentaTerceroNotaDeDebito ventaTercero = null;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	Extension extension;
	List<ApendiceItem> apendice=null;  // null allowed
	//this.apendice             = new ArrayList<ApendiceItem>();

	/**
	 * No parameters
	 */
	public NotaDeDebito() {
		this.identificacion       = new IdentificacionNotaDeDebito();
		this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItemNotaDeDebito>();
		this.emisor               = new EmisorNotaDeDebito();
		this.receptor             = new ReceptorNotaDeDebito();
		//this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		this.extension            = new Extension();
	}
	
	public IdentificacionNotaDeDebito getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(IdentificacionNotaDeDebito identificacion) {
		this.identificacion = identificacion;
	}

	public List<DocumentoRelacionadoItemNotaDeDebito> getDocumentoRelacionado() {
		return documentoRelacionado;
	}

	public void setDocumentoRelacionado(List<DocumentoRelacionadoItemNotaDeDebito> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}

	public EmisorNotaDeDebito getEmisor() {
		return emisor;
	}

	public void setEmisor(EmisorNotaDeDebito emisor) {
		this.emisor = emisor;
	}

	public ReceptorNotaDeDebito getReceptor() {
		return receptor;
	}

	public void setReceptor(ReceptorNotaDeDebito receptor) {
		this.receptor = receptor;
	}

	public VentaTerceroNotaDeDebito getVentaTercero() {
		return ventaTercero;
	}

	public void setVentaTercero(VentaTerceroNotaDeDebito ventaTercero) {
		this.ventaTercero = ventaTercero;
	}

	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
		return cuerpoDocumento;
	}

	public void setCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}

	public Resumen getResumen() {
		return resumen;
	}

	public void setResumen(Resumen resumen) {
		this.resumen = resumen;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public List<ApendiceItem> getApendice() {
		return apendice;
	}

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
