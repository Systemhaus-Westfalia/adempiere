/**
 * 
 */
package org.shw.einvoice.es.fencnotadecreditov1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.Receptor;
import org.shw.einvoice.es.util.pojo.VentaTercero;




/**
 * 
 */
public class NotaDeCredito {
	
	IdentificacionNotaDeCredito identificacion;
	List<DocumentoRelacionadoItemNotaDeCredito> documentoRelacionado;
	EmisorNotaDeCredito emisor;
	Receptor receptor;
	VentaTercero ventaTercero = null;
	List<CuerpoDocumentoItem> cuerpoDocumento;
	Resumen resumen;
	Extension extension;
	List<ApendiceItem> apendice=null;  // null allowed
	//this.apendice             = new ArrayList<ApendiceItem>();

	/**
	 * No parameters
	 */
	public NotaDeCredito() {
		this.identificacion       = new IdentificacionNotaDeCredito();
		this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItemNotaDeCredito>();
		this.emisor               = new EmisorNotaDeCredito();
		this.receptor             = new Receptor();
		//this.ventaTercero         = new VentaTercero();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItem>();
		this.resumen              = new Resumen();
		this.extension            = new Extension();
	}

	/**
	 * @return the identificacion
	 */
	public IdentificacionNotaDeCredito getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(IdentificacionNotaDeCredito identificacion) {
		this.identificacion = identificacion;
	}
	
	public List<DocumentoRelacionadoItemNotaDeCredito> getDocumentoRelacionado() {
		return documentoRelacionado;
	}

	public void setDocumentoRelacionado(List<DocumentoRelacionadoItemNotaDeCredito> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}

	public EmisorNotaDeCredito getEmisor() {
		return emisor;
	}

	public void setEmisor(EmisorNotaDeCredito emisor) {
		this.emisor = emisor;
	}

	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}

	public VentaTercero getVentaTercero() {
		return ventaTercero;
	}

	public void setVentaTercero(VentaTercero ventaTercero) {
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
