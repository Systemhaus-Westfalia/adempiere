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

	void fillIdentification(Identificacion identificacion);
	void fillDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado);
	void fillEmisor(Emisor emisor);
	void fillReceptor(Receptor receptor);
	void fillOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos);
	void fillVentaTercero(VentaTercero ventaTercero);
	void fillCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento);
	void fillResumen(Resumen resumen);
	void fillExtension(Extension extension);
	void fillApendice(List<ApendiceItem> apendice);

	void fillDocumento(Documento documento);
	void fillMotivo(Motivo motivo);
}
