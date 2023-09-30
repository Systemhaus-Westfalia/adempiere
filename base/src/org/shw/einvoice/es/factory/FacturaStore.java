package org.shw.einvoice.es.factory;

import org.json.JSONObject;
import org.shw.einvoice.es.fefcfacturaelectronicav1.Factura;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;

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
    	String facturaAsString    = objectMapper.writeValueAsString(factura);
        JSONObject  facturaAsJson = new JSONObject(facturaAsString);
        
        facturaAsJson.remove(EDocumentUtils.DOCUMENTORELACIONADO);
        facturaAsJson.remove(EDocumentUtils.OTROSDOCUMENTOS);
        facturaAsJson.remove(EDocumentUtils.RECEPTOR);
        facturaAsJson.remove(EDocumentUtils.VENTATERCERO);        
        facturaAsJson.remove(EDocumentUtils.EXTENSION);
        facturaAsJson.remove(EDocumentUtils.APENDICE);
        facturaAsJson.remove(EDocumentUtils.DOCUMENTO);
        facturaAsJson.remove(EDocumentUtils.MOTIVO);
        facturaAsJson.remove(EDocumentUtils.ERRORMESSAGES);

        facturaAsJson.getJSONObject(EDocumentUtils.IDENTIFICACION).remove("horAnula");
        facturaAsJson.getJSONObject(EDocumentUtils.IDENTIFICACION).remove("motivoContigencia");
        facturaAsJson.getJSONObject(EDocumentUtils.IDENTIFICACION).remove("fecAnula");
        facturaAsJson.getJSONObject(EDocumentUtils.IDENTIFICACION).remove("motivoContingencia");

        facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("seguro");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("totalSujetoRetencion");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("tributos");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("tributosFactura");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("numPagoElectronico");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("flete");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("ivaPerci1");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("descuento");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("codIncoterms");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("totalIVAretenidoLetras");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("descIncoterms");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("observaciones");
		facturaAsJson.getJSONObject(EDocumentUtils.RESUMEN).remove("totalIVAretenido");

		facturaAsJson.getJSONObject(EDocumentUtils.CUERPODOCUMENTO).remove("numDocumento");
		facturaAsJson.getJSONObject(EDocumentUtils.CUERPODOCUMENTO).remove("fechaEmision");
		facturaAsJson.getJSONObject(EDocumentUtils.CUERPODOCUMENTO).remove("tributos");
		facturaAsJson.getJSONObject(EDocumentUtils.CUERPODOCUMENTO).remove("codTributo");
		facturaAsJson.getJSONObject(EDocumentUtils.CUERPODOCUMENTO).remove("codigoRetencionMH");
		facturaAsJson.getJSONObject(EDocumentUtils.CUERPODOCUMENTO).remove("montoSujetoGrav");
		facturaAsJson.getJSONObject(EDocumentUtils.CUERPODOCUMENTO).remove(" ivaRetenido");
		facturaAsJson.getJSONObject(EDocumentUtils.CUERPODOCUMENTO).remove("tipoDte");

		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("codigo");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("puntoVentaMH");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("direccion");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("codEstable");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("codPuntoVenta");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("codigoMH");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("codEstableMH");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("puntoVenta");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("recintoFiscal");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("regimen");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("nomEstablecimiento");
		facturaAsJson.getJSONObject(EDocumentUtils.EMISOR).remove("codPuntoVentaMH");

        String finalFacturaAsString = objectMapper.writeValueAsString(facturaAsJson);
		return finalFacturaAsString;
	}
}
