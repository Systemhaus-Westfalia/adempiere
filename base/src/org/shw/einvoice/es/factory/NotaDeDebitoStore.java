package org.shw.einvoice.es.factory;


public class NotaDeDebitoStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocumentFactory notaDeDebitoFactory = new NotaDeDebitoFactory();
		EDocument notaDeDebito = new NotaDeDebito(notaDeDebitoFactory);  // NotaDeDebito must extend EDocument!!!
		return notaDeDebito;
	}

}
