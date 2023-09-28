package org.shw.einvoice.es.factory;


public class RetencionStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocument retencion = new Retencion();  // Retencion must extend EDocument!!!
		return retencion;
	}

	String createJsonString() {
		return null;
	}

}
