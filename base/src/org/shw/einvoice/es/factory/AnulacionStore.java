package org.shw.einvoice.es.factory;


public class AnulacionStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocument anulacion = new Anulacion();  // Anulacion must extend EDocument!!!
		return anulacion;
	}

	String createJsonString() {
		return null;
	}

}
