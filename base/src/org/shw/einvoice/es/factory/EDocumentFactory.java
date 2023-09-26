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

	void fillIdentification(JSONObject factoryInput, Identificacion identificacion);
	void fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado);
	void fillEmisor(JSONObject factoryInput, Emisor emisor);
	void fillReceptor(JSONObject factoryInput, Receptor receptor);
	void fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos);
	void fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero);
	void fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento);
	void fillResumen(JSONObject factoryInput, Resumen resumen);
	void fillExtension(JSONObject factoryInput, Extension extension);
	void fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice);

	void fillDocumento(Documento documento);
	void fillMotivo(Motivo motivo);
}
