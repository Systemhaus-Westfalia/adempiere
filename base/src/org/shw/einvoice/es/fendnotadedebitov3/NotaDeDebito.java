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
	List<CuerpoDocumentoItemNotaDeDebito> cuerpoDocumento;
	ResumenNotaDeDebito resumen;
	ExtensionNotaDeDebito extension;
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
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItemNotaDeDebito>();
		this.resumen              = new ResumenNotaDeDebito();
		this.extension            = new ExtensionNotaDeDebito();
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

	public List<CuerpoDocumentoItemNotaDeDebito> getCuerpoDocumento() {
		return cuerpoDocumento;
	}

	public void setCuerpoDocumento(List<CuerpoDocumentoItemNotaDeDebito> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}

	public ResumenNotaDeDebito getResumen() {
		return resumen;
	}

	public void setResumen(ResumenNotaDeDebito resumen) {
		this.resumen = resumen;
	}

	public ExtensionNotaDeDebito getExtension() {
		return extension;
	}

	public void setExtension(ExtensionNotaDeDebito extension) {
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
