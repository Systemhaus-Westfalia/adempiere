package org.shw.einvoice.es.factory;


public class FacturaExportacionStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocumentFactory facturaExportacionFactory = new FacturaExportacionFactory();
		EDocument facturaExportacion = new FacturaExportacion(facturaExportacionFactory);  // FacturaExportacion must extend EDocument!!!
		return facturaExportacion;
	}

	String createJsonObject() {
		return null;
	}

}
