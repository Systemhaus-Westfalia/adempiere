package org.shw.einvoice.es.feccfcreditofiscalv3;

import java.util.List;

import org.shw.einvoice.es.fefexfacturaexportacionv1.OtrosDocumentosItem;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.Emisor;
import org.shw.einvoice.es.util.pojo.Extension;
import org.shw.einvoice.es.util.pojo.PagosItem;
import org.shw.einvoice.es.util.pojo.Receptor;
import org.shw.einvoice.es.util.pojo.VentaTercero;

public class Creditofiscalv3_SV {

	 private Emisor 					emisor;
	 private String 					estado;
	 private Resumen 					resumen;
	 private String 					version;
	 private String 					ambiente;
	 private List<ApendiceItem> 		apendiceItems;
	 private Receptor 					receptor;
	 private String						codiMsg;
	 private Extension 					extension;
	 private Integer 					versionApp;
	 private String						clasificaMsg;
	 private VentaTercero 				ventaTercero;
	 private List<Object>				obsercaciones;
	 private String 					selloRecibido;
	 private String 					descripcionMsg;
	 private Identificacion 			identificacion;
	 private List<CuerpoDocumentoItem> 	cuerpoDocumentoItems;
	 private String 					fhProcesamiento;
	 private List<OtrosDocumentosItem> 	otrosDocumentosItems;
	 
	 private String 						codigoGeneracion;
	 private List<DocumentoRelacionadoItem> documentoRelacionadoItems;
	 
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAmbiente() {
		return ambiente;
	}
	/**
	 * @param ambiente the ambiente to set<br>
	 * The parameter is validated.<br>
	 * "enum" : ["00", "01"]
	 */
	public void setAmbiente(String ambiente) {
		if (ambiente.compareTo("00")==0 || ambiente.compareTo("01")==0)
			this.ambiente = ambiente;
		else
	        throw new IllegalArgumentException("Wrong parameter 'ambiente' in setAmbiente()");
	}
	public String getCodiMsg() {
		return codiMsg;
	}
	public void setCodiMsg(String codiMsg) {
		this.codiMsg = codiMsg;
	}
	public Integer getVersionApp() {
		return versionApp;
	}
	public void setVersionApp(Integer versionApp) {
		this.versionApp = versionApp;
	}
	public String getClasificaMsg() {
		return clasificaMsg;
	}
	public void setClasificaMsg(String clasificaMsg) {
		this.clasificaMsg = clasificaMsg;
	}
	public List<Object> getObsercaciones() {
		return obsercaciones;
	}
	public void setObsercaciones(List<Object> obsercaciones) {
		this.obsercaciones = obsercaciones;
	}
	public String getSelloRecibido() {
		return selloRecibido;
	}
	public void setSelloRecibido(String selloRecibido) {
		this.selloRecibido = selloRecibido;
	}
	public String getDescripcionMsg() {
		return descripcionMsg;
	}
	public void setDescripcionMsg(String descripcionMsg) {
		this.descripcionMsg = descripcionMsg;
	}
	public String getFhProcesamiento() {
		return fhProcesamiento;
	}
	public void setFhProcesamiento(String fhProcesamiento) {
		this.fhProcesamiento = fhProcesamiento;
	}
	public String getCodigoGeneracion() {
		return codigoGeneracion;
	}
	public void setCodigoGeneracion(String codigoGeneracion) {
		this.codigoGeneracion = codigoGeneracion;
	}
	public Identificacion getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = identificacion;
	}
	public List<DocumentoRelacionadoItem> getDocumentoRelacionadoItems() {
		return documentoRelacionadoItems;
	}
	public void setDocumentoRelacionadoItems(List<DocumentoRelacionadoItem> documentoRelacionadoItems) {
		this.documentoRelacionadoItems = documentoRelacionadoItems;
	}
	public Emisor getEmisor() {
		return emisor;
	}
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}
	public Receptor getReceptor() {
		return receptor;
	}
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	public List<OtrosDocumentosItem> getOtrosDocumentosItems() {
		return otrosDocumentosItems;
	}
	public void setOtrosDocumentosItems(List<OtrosDocumentosItem> otrosDocumentosItems) {
		this.otrosDocumentosItems = otrosDocumentosItems;
	}
	public VentaTercero getVentaTercero() {
		return ventaTercero;
	}
	public void setVentaTercero(VentaTercero ventaTercero) {
		this.ventaTercero = ventaTercero;
	}
	public List<CuerpoDocumentoItem> getCuerpoDocumentoItems() {
		return cuerpoDocumentoItems;
	}
	public void setCuerpoDocumentoItems(List<CuerpoDocumentoItem> cuerpoDocumentoItems) {
		this.cuerpoDocumentoItems = cuerpoDocumentoItems;
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
	public List<ApendiceItem> getApendiceItems() {
		return apendiceItems;
	}
	public void setApendiceItems(List<ApendiceItem> apendiceItems) {
		this.apendiceItems = apendiceItems;
	}	

}
