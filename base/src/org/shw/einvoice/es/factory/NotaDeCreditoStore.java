package org.shw.einvoice.es.factory;


public class NotaDeCreditoStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocument notaDeCredito = new NotaDeCredito();  // NotaDeCredito must extend EDocument!!!
		return notaDeCredito;
	}

	String createJsonString() {
		return null;
	}

}
