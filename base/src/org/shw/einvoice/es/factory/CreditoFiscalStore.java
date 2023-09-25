package org.shw.einvoice.es.factory;


public class CreditoFiscalStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocumentFactory creditoFiscalFactory = new CreditoFiscalFactory();
		EDocument factura = new CreditoFiscal(creditoFiscalFactory);  // CreditoFiscal must extend EDocument!!!
		return factura;
	}

}
