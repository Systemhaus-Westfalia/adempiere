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
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.VentaTercero;

public abstract class EDocumentStore {

	abstract EDocument createEDocument();
	
	public EDocument generateEDocument(JSONObject factoryInput) {
		EDocument eDocument = createEDocument();
		
		Identificacion identification = eDocument.getIdentificacion();
		if(identification!=null) {
			eDocument.fillIdentification(factoryInput, identification);
		}
		
		List<DocumentoRelacionadoItem> documentoRelacionado = eDocument.getDocumentoRelacionado();
		if(documentoRelacionado!=null) {
			eDocument.fillDocumentoRelacionado(factoryInput, documentoRelacionado);
		}
		
		Emisor emisor = eDocument.getEmisor();
		if(emisor!=null) {
			eDocument.fillEmisor(factoryInput, emisor);
		}
		
		List<OtrosDocumentosItem> otrosDocumentos = eDocument.getOtrosDocumentos();
		if(otrosDocumentos!=null) {
			eDocument.fillOtrosDocumentos(factoryInput, otrosDocumentos);
		}
		
		VentaTercero ventaTercero = eDocument.getVentaTercero();
		if(ventaTercero!=null) {
			eDocument.fillVentaTercero(factoryInput, ventaTercero);
		}
		
		List<CuerpoDocumentoItem> cuerpoDocumento = eDocument.getCuerpoDocumento();
		if(cuerpoDocumento!=null) {
			eDocument.fillCuerpoDocumento(factoryInput, cuerpoDocumento);
		}
		
		Resumen resumen = eDocument.getResumen();
		if(resumen!=null) {
			eDocument.fillResumen(factoryInput, resumen);
		}
		
		Extension extension = eDocument.getExtension();
		if(extension!=null) {
			eDocument.fillExtension(factoryInput, extension);
		}
		
		List<ApendiceItem> apendice = eDocument.getApendice();
		if(apendice!=null) {
			eDocument.fillApendice(factoryInput, apendice);
		}
		
		Documento documento = eDocument.getDocumento();
		if(documento!=null) {
			eDocument.fillDocumento(factoryInput, documento);
		}
		
		Motivo motivo = eDocument.getMotivo();
		if(documento!=null) {
			eDocument.fillMotivo(factoryInput, motivo);
		}
		
		return eDocument;
	}
}
