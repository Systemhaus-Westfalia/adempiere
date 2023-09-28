package org.shw.einvoice.es.factory;


public class RetencionStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocumentFactory retencionFactory = new RetencionFactory();
		EDocument retencion = new Retencion(retencionFactory);  // Retencion must extend EDocument!!!
		return retencion;
	}

	String createJsonObject() {
		return null;
	}

}
