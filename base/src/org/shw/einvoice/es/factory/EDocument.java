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

public abstract class EDocument {

	public abstract Identificacion getIdentificacion();
	public abstract void fillIdentification(JSONObject factoryInput, Identificacion identificacion);
	
	public abstract List<DocumentoRelacionadoItem> getDocumentoRelacionado();
	public abstract  void fillDocumentoRelacionado(JSONObject factoryInput,List<DocumentoRelacionadoItem> documentoRelacionado);

	public abstract Emisor getEmisor();
	public abstract void fillEmisor(JSONObject factoryInput, Emisor emisor);

	public abstract Receptor getReceptor();
	public abstract void fillReceptor(JSONObject factoryInput, Receptor receptor);
	
	public abstract List<OtrosDocumentosItem> getOtrosDocumentos();
	public abstract  void fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos);

	public abstract VentaTercero getVentaTercero();
	public abstract void fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero);
	
	public abstract List<CuerpoDocumentoItem> getCuerpoDocumento();
	public abstract void fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento);
	
	public abstract Resumen getResumen();
	public abstract void fillResumen(JSONObject factoryInput, Resumen resumen);
	
	public abstract Extension getExtension();
	public abstract void fillExtension(JSONObject factoryInput, Extension extension);
	
	public abstract List<ApendiceItem> getApendice();
	public abstract void fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice);
	
	public abstract Documento getDocumento();
	public abstract void fillDocumento(JSONObject factoryInput, Documento documento);
	
	public abstract Motivo getMotivo();
	public abstract void fillMotivo(JSONObject factoryInput, Motivo motivo);
	
}
