package org.shw.einvoice.es.feccfcreditofiscalv3;

import java.util.List;

import org.shw.einvoice.es.fefexfacturaexportacionv1.OtrosDocumentosItemFacturaExportacion;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.PagosItem;
import org.shw.einvoice.es.util.pojo.VentaTercero;

public class Creditofiscalv3_SV {

	 private EmisorCreditoFiscal 		emisor;
	 private String 					estado;
	 private ResumenCreditoFiscal 		resumen;
	 private String 					version;
	 private String 					ambiente;
	 private List<ApendiceItem> 		apendiceItems;
	 private ReceptorCreditoFiscal  	receptor;
	 private String						codiMsg;
	 private ExtensionCreditoFiscal		extension;
	 private Integer 					versionApp;
	 private String						clasificaMsg;
	 private VentaTercero 				ventaTercero;
	 private List<Object>				obsercaciones;
	 private String 					selloRecibido;
	 private String 					descripcionMsg;
	 private IdentificacionCreditoFiscal 			identificacion;
	 private List<CuerpoDocumentoItemCreditoFiscal> 	cuerpoDocumentoItems;
	 private String 					fhProcesamiento;
	 private List<OtrosDocumentosItemFacturaExportacion> 	otrosDocumentosItems;
	 
	 private String 						codigoGeneracion;
	 private List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionadoItems;
	 
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
	public IdentificacionCreditoFiscal getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(IdentificacionCreditoFiscal identificacion) {
		this.identificacion = identificacion;
	}
	public List<DocumentoRelacionadoItemCreditoFiscal> getDocumentoRelacionadoItems() {
		return documentoRelacionadoItems;
	}
	public void setDocumentoRelacionadoItems(List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionadoItems) {
		this.documentoRelacionadoItems = documentoRelacionadoItems;
	}
	public EmisorCreditoFiscal getEmisor() {
		return emisor;
	}
	public void setEmisor(EmisorCreditoFiscal emisor) {
		this.emisor = emisor;
	}
	public ReceptorCreditoFiscal getReceptor() {
		return receptor;
	}
	public void setReceptor(ReceptorCreditoFiscal receptor) {
		this.receptor = receptor;
	}
	public List<OtrosDocumentosItemFacturaExportacion> getOtrosDocumentosItems() {
		return otrosDocumentosItems;
	}
	public void setOtrosDocumentosItems(List<OtrosDocumentosItemFacturaExportacion> otrosDocumentosItems) {
		this.otrosDocumentosItems = otrosDocumentosItems;
	}
	public VentaTercero getVentaTercero() {
		return ventaTercero;
	}
	public void setVentaTercero(VentaTercero ventaTercero) {
		this.ventaTercero = ventaTercero;
	}
	public List<CuerpoDocumentoItemCreditoFiscal> getCuerpoDocumentoItems() {
		return cuerpoDocumentoItems;
	}
	public void setCuerpoDocumentoItems(List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumentoItems) {
		this.cuerpoDocumentoItems = cuerpoDocumentoItems;
	}
	public ResumenCreditoFiscal getResumen() {
		return resumen;
	}
	public void setResumen(ResumenCreditoFiscal resumen) {
		this.resumen = resumen;
	}
	public ExtensionCreditoFiscal getExtension() {
		return extension;
	}
	public void setExtension(ExtensionCreditoFiscal extension) {
		this.extension = extension;
	}
	public List<ApendiceItem> getApendiceItems() {
		return apendiceItems;
	}
	public void setApendiceItems(List<ApendiceItem> apendiceItems) {
		this.apendiceItems = apendiceItems;
	}	

}
