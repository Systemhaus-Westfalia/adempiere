package org.shw.einvoice.es.factory;


public class AnulacionStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocumentFactory anulacionFactory = new AnulacionFactory();
		EDocument anulacion = new Anulacion(anulacionFactory);  // Anulacion must extend EDocument!!!
		return anulacion;
	}

}
