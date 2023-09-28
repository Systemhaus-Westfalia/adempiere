package org.shw.einvoice.es.factory;

import org.json.JSONObject;
import org.shw.einvoice.es.fefcfacturaelectronicav1.Factura;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FacturaStore extends EDocumentStore {
	EDocument factura;
	@Override
	EDocument createEDocument() {
		factura = new Factura();  // FacturaElectronica must extend EDocument!!!
		return factura;
	}

	@Override
	public String createJsonString() throws Exception {		
    	ObjectMapper objectMapper = new ObjectMapper();
    	String facturaAsString = objectMapper.writeValueAsString(factura);
        JsonNode facturaAsJsonNode = objectMapper.readTree(facturaAsString);        
        
        deleteJsonNOde(facturaAsJsonNode.path("documentoRelacionado"));
        deleteJsonNOde(facturaAsJsonNode.path("otrosDocumentos"));
        deleteJsonNOde(facturaAsJsonNode.path("ventaTercero"));
        deleteJsonNOde(facturaAsJsonNode.path("extension"));
        deleteJsonNOde(facturaAsJsonNode.path("apendice"));
        deleteJsonNOde(facturaAsJsonNode.path("documento"));
        deleteJsonNOde(facturaAsJsonNode.path("motivo"));

        String finalFacturaAsString = objectMapper.writeValueAsString(facturaAsJsonNode);
		return finalFacturaAsString;
	}
}
