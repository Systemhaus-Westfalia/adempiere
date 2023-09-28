package org.shw.einvoice.es.factory;

import org.shw.einvoice.es.fefcfacturaelectronicav1.Factura;

public class FacturaStore extends EDocumentStore {
	EDocument factura;
	@Override
	EDocument createEDocument() {
		EDocumentFactory facturaFactory = new FacturaFactory();
		factura = new Factura(facturaFactory);  // FacturaElectronica must extend EDocument!!!
		return factura;
	}

	String createJsonObject() {
		return null;
	}
}
