package org.shw.einvoice.es.factory;


public class FacturaExportacionStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocument facturaExportacion = new FacturaExportacion();  // FacturaExportacion must extend EDocument!!!
		return facturaExportacion;
	}

	String createJsonString() {
		return null;
	}

}
