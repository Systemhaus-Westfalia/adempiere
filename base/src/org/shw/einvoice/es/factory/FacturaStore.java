package org.shw.einvoice.es.factory;

import org.shw.einvoice.es.fefcfacturaelectronicav1.Factura;

public class FacturaStore extends EDocumentStore {

	@Override
	EDocument createEDocument() {
		EDocumentFactory facturaFactory = new FacturaFactory();
		EDocument factura = new Factura(facturaFactory);  // FacturaElectronica must extend EDocument!!!
		return factura;
	}
}
