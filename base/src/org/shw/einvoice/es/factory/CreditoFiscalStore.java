package org.shw.einvoice.es.factory;


public class CreditoFiscalStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocument creditoFiscal = new CreditoFiscal();  // CreditoFiscal must extend EDocument!!!
		return creditoFiscal;
	}

	String createJsonString() {
		return null;
	}

}
