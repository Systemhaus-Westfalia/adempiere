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
	public static final String VALIDATION_RESULT_OK = "OK";
	public StringBuffer errorMessages = new StringBuffer();
	
	public abstract Identificacion getIdentificacion();
	public abstract StringBuffer fillIdentification(JSONObject factoryInput);
	
	public abstract List<DocumentoRelacionadoItem> getDocumentoRelacionado();
	public abstract StringBuffer fillDocumentoRelacionado(JSONObject factoryInput);

	public abstract Emisor getEmisor();
	public abstract StringBuffer fillEmisor(JSONObject factoryInput);

	public abstract Receptor getReceptor();
	public abstract StringBuffer fillReceptor(JSONObject factoryInput);
	
	public abstract List<OtrosDocumentosItem> getOtrosDocumentos();
	public abstract  StringBuffer fillOtrosDocumentos(JSONObject factoryInput);

	public abstract VentaTercero getVentaTercero();
	public abstract StringBuffer fillVentaTercero(JSONObject factoryInput);
	
	public abstract List<CuerpoDocumentoItem> getCuerpoDocumento();
	public abstract StringBuffer fillCuerpoDocumento(JSONObject factoryInput);
	
	public abstract Resumen getResumen();
	public abstract StringBuffer fillResumen(JSONObject factoryInput);
	
	public abstract Extension getExtension();
	public abstract StringBuffer fillExtension(JSONObject factoryInput);
	
	public abstract List<ApendiceItem> getApendice();
	public abstract StringBuffer fillApendice(JSONObject factoryInput);
	
	public abstract Documento getDocumento();
	public abstract StringBuffer fillDocumento(JSONObject factoryInput);
	
	public abstract Motivo getMotivo();
	public abstract StringBuffer fillMotivo(JSONObject factoryInput);
	
	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {		
		return VALIDATION_RESULT_OK;
	}
	
}
