package org.shw.einvoice.es.factory;


public class NotaDeCreditoStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocumentFactory notaDeCreditoFactory = new NotaDeCreditoFactory();
		EDocument notaDeCredito = new NotaDeCredito(notaDeCreditoFactory);  // NotaDeCredito must extend EDocument!!!
		return notaDeCredito;
	}

	String createJsonObject() {
		return null;
	}

}
