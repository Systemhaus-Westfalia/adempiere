package org.shw.einvoice.es.factory;

import java.util.Iterator;

import org.json.JSONObject;
import org.shw.einvoice.es.fefcfacturaelectronicav1.Factura;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
    	String facturaAsString    = objectMapper.writeValueAsString(factura);
        JSONObject  facturaAsJson = new JSONObject(facturaAsString);
        
        facturaAsJson.remove("documentoRelacionado");
        facturaAsJson.remove("otrosDocumentos");
        facturaAsJson.remove("receptor");
        facturaAsJson.remove("ventaTercero");        
        facturaAsJson.remove("extension");
        facturaAsJson.remove("apendice");
        facturaAsJson.remove("documento");
        facturaAsJson.remove("motivo");
        facturaAsJson.remove("errorMessages");

        facturaAsJson.getJSONObject("identificacion").remove("horAnula");
        facturaAsJson.getJSONObject("identificacion").remove("motivoContigencia");
        facturaAsJson.getJSONObject("identificacion").remove("fecAnula");
        facturaAsJson.getJSONObject("identificacion").remove("motivoContingencia");

        facturaAsJson.getJSONObject("resumen").remove("seguro");
		facturaAsJson.getJSONObject("resumen").remove("totalSujetoRetencion");
		facturaAsJson.getJSONObject("resumen").remove("tributos");
		facturaAsJson.getJSONObject("resumen").remove("tributosFactura");
		facturaAsJson.getJSONObject("resumen").remove("numPagoElectronico");
		facturaAsJson.getJSONObject("resumen").remove("flete");
		facturaAsJson.getJSONObject("resumen").remove("ivaPerci1");
		facturaAsJson.getJSONObject("resumen").remove("descuento");
		facturaAsJson.getJSONObject("resumen").remove("codIncoterms");
		facturaAsJson.getJSONObject("resumen").remove("totalIVAretenidoLetras");
		facturaAsJson.getJSONObject("resumen").remove("descIncoterms");
		facturaAsJson.getJSONObject("resumen").remove("observaciones");
		facturaAsJson.getJSONObject("resumen").remove("totalIVAretenido");

		facturaAsJson.getJSONObject("cuerpoDocumento").remove("numDocumento");
		facturaAsJson.getJSONObject("cuerpoDocumento").remove("fechaEmision");
		facturaAsJson.getJSONObject("cuerpoDocumento").remove("tributos");
		facturaAsJson.getJSONObject("cuerpoDocumento").remove("codTributo");
		facturaAsJson.getJSONObject("cuerpoDocumento").remove("codigoRetencionMH");
		facturaAsJson.getJSONObject("cuerpoDocumento").remove("montoSujetoGrav");
		facturaAsJson.getJSONObject("cuerpoDocumento").remove(" ivaRetenido");
		facturaAsJson.getJSONObject("cuerpoDocumento").remove("tipoDte");

		facturaAsJson.getJSONObject("emisor").remove("codigo");
		facturaAsJson.getJSONObject("emisor").remove("puntoVentaMH");
		facturaAsJson.getJSONObject("emisor").remove("direccion");
		facturaAsJson.getJSONObject("emisor").remove("codEstable");
		facturaAsJson.getJSONObject("emisor").remove("codPuntoVenta");
		facturaAsJson.getJSONObject("emisor").remove("codigoMH");
		facturaAsJson.getJSONObject("emisor").remove("codEstableMH");
		facturaAsJson.getJSONObject("emisor").remove("puntoVenta");
		facturaAsJson.getJSONObject("emisor").remove("recintoFiscal");
		facturaAsJson.getJSONObject("emisor").remove("regimen");
		facturaAsJson.getJSONObject("emisor").remove("nomEstablecimiento");
		facturaAsJson.getJSONObject("emisor").remove("codPuntoVentaMH");

        String finalFacturaAsString = objectMapper.writeValueAsString(facturaAsJson);
		return finalFacturaAsString;
	}
}
