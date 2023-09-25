package org.shw.einvoice.es.factory;

import java.util.List;

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

	abstract Identificacion getIdentificacion();
	abstract void fillIdentification(Identificacion identificacion);
	
	abstract List<DocumentoRelacionadoItem> getDocumentoRelacionado();
	abstract  void fillDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado);

	abstract Emisor getEmisor();
	abstract void fillEmisor(Emisor emisor);

	abstract Receptor getReceptor();
	abstract void fillReceptor(Receptor receptor);
	
	abstract List<OtrosDocumentosItem> getOtrosDocumentos();
	abstract  void fillOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos);

	abstract VentaTercero getVentaTercero();
	abstract void fillVentaTercero(VentaTercero ventaTercero);
	
	abstract List<CuerpoDocumentoItem> getCuerpoDocumento();
	abstract void fillCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento);
	
	abstract Resumen getResumen();
	abstract void fillResumen(Resumen resumen);
	
	abstract Extension getExtension();
	abstract void fillExtension(Extension extension);
	
	abstract List<ApendiceItem> getApendice();
	abstract void fillApendice(List<ApendiceItem> apendice);
	
	abstract Documento getDocumento();
	abstract void fillDocumento(Documento documento);
	
	abstract Motivo getMotivo();
	abstract void fillMotivo(Motivo motivo);
	
}
