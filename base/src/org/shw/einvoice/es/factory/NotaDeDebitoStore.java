package org.shw.einvoice.es.factory;


public class NotaDeDebitoStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocument notaDeDebito = new NotaDeDebito();  // NotaDeDebito must extend EDocument!!!
		return notaDeDebito;
	}

	String createJsonString() {
		return null;
	}

}
