package org.shw.einvoice.es.factory;

import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.CuerpoDocumentoItem;
import org.shw.einvoice.es.util.pojo.Documento;
import org.shw.einvoice.es.util.pojo.DocumentoRelacionadoItem;
import org.shw.einvoice.es.util.pojo.Emisor;
import org.shw.einvoice.es.util.pojo.Extension;
import org.shw.einvoice.es.util.pojo.Identificacion;
import org.shw.einvoice.es.util.pojo.Motivo;
import org.shw.einvoice.es.util.pojo.OtrosDocumentosItem;
import org.shw.einvoice.es.util.pojo.Receptor;
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.VentaTercero;

public interface EDocumentFactory {
	Identificacion createIdentificacion();
	List<DocumentoRelacionadoItem> createDocumentoRelacionado();
	Emisor createEmisor();
	Receptor createReceptor();
	List<OtrosDocumentosItem> createOtrosDocumentos();
	VentaTercero createVentaTercero();
	List<CuerpoDocumentoItem> createCuerpoDocumento();
	Resumen createResumen();
	Extension createExtension();
	List<ApendiceItem> createApendice();
	
	Documento createDocumento();
	Motivo createMotivo();	

	public StringBuffer fillIdentification(JSONObject factoryInput, Identificacion identificacion);
	public StringBuffer fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado);
	public StringBuffer fillEmisor(JSONObject factoryInput, Emisor emisor);
	public StringBuffer fillReceptor(JSONObject factoryInput, Receptor receptor);
	public StringBuffer fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos);
	public StringBuffer fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero);
	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento);
	public StringBuffer fillResumen(JSONObject factoryInput, Resumen resumen);
	public StringBuffer fillExtension(JSONObject factoryInput, Extension extension);
	public StringBuffer fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice);

	public StringBuffer fillDocumento(JSONObject factoryInput, Documento documento);
	public StringBuffer fillMotivo(JSONObject factoryInput, Motivo motivo);
}
