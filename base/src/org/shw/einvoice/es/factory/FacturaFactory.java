/**
 * 
 */
package org.shw.einvoice.es.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.shw.einvoice.es.fefcfacturaelectronicav1.ApendiceItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.CuerpoDocumentoItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.DocumentoRelacionadoItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.EmisorFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.ExtensionFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.IdentificacionFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.OtrosDocumentosItemFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.ReceptorFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.ResumenFactura;
import org.shw.einvoice.es.fefcfacturaelectronicav1.VentaTerceroFactura;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.CuerpoDocumentoItem;
import org.shw.einvoice.es.util.pojo.Documento;
import org.shw.einvoice.es.util.pojo.DocumentoRelacionadoItem;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;
import org.shw.einvoice.es.util.pojo.Emisor;
import org.shw.einvoice.es.util.pojo.Extension;
import org.shw.einvoice.es.util.pojo.Identificacion;
import org.shw.einvoice.es.util.pojo.Motivo;
import org.shw.einvoice.es.util.pojo.OtrosDocumentosItem;
import org.shw.einvoice.es.util.pojo.PagosItem;
import org.shw.einvoice.es.util.pojo.Receptor;
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.VentaTercero;

/**
 * To cast Lists where B extends A
 * 
 * List<B> b = new ArrayList<>();
 * List<?> t = (List<B>)b;
 * List<A> a = (List<A>)t;
 * 
 */
public class FacturaFactory implements EDocumentFactory {

	StringBuffer errorMessages = new StringBuffer();

	@Override
	public Identificacion createIdentificacion() {
		Identificacion identificacion = new IdentificacionFactura();
		return identificacion;
	}

	/**
	 * To cast Lists where B extends A
	 * 
	 * List<B> b = new ArrayList<>();
	 * List<?> t = (List<B>)b;
	 * List<A> a = (List<A>)t;
	 * 
	 * List<DocumentoRelacionadoItemFactura> documentoRelacionado = new ArrayList<DocumentoRelacionadoItemFactura>();
	 * List<?> tempList = (List<DocumentoRelacionadoItemFactura>) documentoRelacionado;
	 * List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoRelacionadoItem> createDocumentoRelacionado() {
		List<?> tempList = new ArrayList<DocumentoRelacionadoItemFactura>();
		List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}

	@Override
	public Emisor createEmisor() {
		Emisor emisor = new EmisorFactura();
		return emisor;
	}

	@Override
	public Receptor createReceptor() {
		Receptor receptor = new ReceptorFactura();
		return receptor;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OtrosDocumentosItem> createOtrosDocumentos() {
		List<?> tempList = new ArrayList<OtrosDocumentosItemFactura>();
		List<OtrosDocumentosItem> finalList = (List<OtrosDocumentosItem>)tempList;
		return finalList;
	}

	@Override
	public VentaTercero createVentaTercero() {
		VentaTercero ventaTercero = new VentaTerceroFactura();
		return ventaTercero;
	}

	/**
	 * To cast Lists where B extends A
	 * 
	 * List<B> b = new ArrayList<>();
	 * List<?> t = (List<B>)b;
	 * List<A> a = (List<A>)t;
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CuerpoDocumentoItem> createCuerpoDocumento() {
		List<?> tempList = new ArrayList<CuerpoDocumentoItemFactura>();
		List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}

	@Override
	public Resumen createResumen() {
		Resumen resumen = new ResumenFactura();
		return resumen;
	}

	@Override
	public Extension createExtension() {
		Extension extension = new ExtensionFactura();
		return extension;
	}


	/**
	 * To cast Lists where B extends A
	 * 
	 * List<B> b = new ArrayList<>();
	 * List<?> t = (List<B>)b;
	 * List<A> a = (List<A>)t;
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApendiceItem> createApendice() {
		List<?> tempList = new ArrayList<ApendiceItemFactura>();
		List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	@Override
	public StringBuffer fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		IdentificacionFactura identificacionFactura = (IdentificacionFactura) identificacion;		
		System.out.println("Start fillIdentificacion"); 
		errorMessages.setLength(0);

		JSONObject identificationJson = factoryInput.getJSONObject("identificacion");
		try {identificacionFactura.setNumeroControl(identificationJson.getString(EDocumentUtils.NUMEROCONTROL));} 		catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setCodigoGeneracion(identificationJson.getString(EDocumentUtils.CODIGOGENERACION));} catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setTipoModelo(identificationJson.getInt(EDocumentUtils.TIPOMODELO));} 				catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setTipoOperacion(identificationJson.getInt(EDocumentUtils.TIPOOPERACION));} 			catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setFecEmi(identificationJson.getString(EDocumentUtils.FECEMI));} 					catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setHorEmi(identificationJson.getString(EDocumentUtils.HOREMI));} 					catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setTipoMoneda(identificationJson.getString(EDocumentUtils.TIPOMONEDA));} 			catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setAmbiente(identificationJson.getString(EDocumentUtils.AMBIENTE));} 				catch (Exception e) {errorMessages.append(e);}

		System.out.println("End fillIdentificacion"); 
		return errorMessages;
	}


	@Override
	public StringBuffer fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		// Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemFactura)
		List<DocumentoRelacionadoItemFactura> documentoRelacionadoItemFactura = new ArrayList<DocumentoRelacionadoItemFactura>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemFactura.add((DocumentoRelacionadoItemFactura) e) );

		// No Documento Relacionado for Factura
		errorMessages.setLength(0);
		return errorMessages;

	}


	@Override
	public StringBuffer fillEmisor(JSONObject factoryInput, Emisor emisor) {
		EmisorFactura emisorFactura = (EmisorFactura) emisor;	
		System.out.println("Start fillEmisor"); 
		errorMessages.setLength(0);

		JSONObject emisorJson = factoryInput.getJSONObject("emisor");
		try {emisorFactura.setNit(emisorJson.getString(EDocumentUtils.NIT));} 										catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setNrc(emisorJson.getString(EDocumentUtils.NRC));} 										catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setNombre(emisorJson.getString(EDocumentUtils.NOMBRE));} 								catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setCodActividad(emisorJson.getString(EDocumentUtils.CODACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setDescActividad(emisorJson.getString(EDocumentUtils.DESCACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setNombreComercial(emisorJson.getString(EDocumentUtils.NOMBRECOMERCIAL));} 				catch (Exception e) {errorMessages.append(e);}		
		try {emisorFactura.setTipoEstablecimiento(emisorJson.getString(EDocumentUtils.TIPOESTABLECIMIENTO));}		catch (Exception e) {errorMessages.append(e);}	

		JSONObject jsonDireccion = emisorJson.getJSONObject("direccion");
		try {emisorFactura.getDireccion().setDepartamento(jsonDireccion.getString(EDocumentUtils.DEPARTAMENTO));}	catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.getDireccion().setMunicipio(jsonDireccion.getString(EDocumentUtils.MUNICIPIO));} 		catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.getDireccion().setComplemento(jsonDireccion.getString(EDocumentUtils.COMPLEMENTO));} 	catch (Exception e) {errorMessages.append(e);}

		try {emisorFactura.setTelefono(emisorJson.getString(EDocumentUtils.TELEFONO));} 							catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setCorreo(emisorJson.getString(EDocumentUtils.CORREO));} 								catch (Exception e) {errorMessages.append(e);}

		System.out.println("End fillEmisor");
		return errorMessages;
	}


	@Override
	public StringBuffer fillReceptor(JSONObject factoryInput, Receptor receptor) {
		ReceptorFactura receptorFactura = (ReceptorFactura) receptor;
		System.out.println("Start fillReceptor"); 
		errorMessages.setLength(0);		

		JSONObject receptorJson = factoryInput.getJSONObject("receptor");
		try {receptorFactura.setTipoDocumento(receptorJson.getString(EDocumentUtils.TIPODOCUMENTO));} 				catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.setNumDocumento(receptorJson.getString(EDocumentUtils.NUMDOCUMENTO));} 				catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.setNombre(receptorJson.getString(EDocumentUtils.NOMBRE));} 							catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.setCodActividad(receptorJson.getString(EDocumentUtils.CODACTIVIDAD));} 				catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.setDescActividad(receptorJson.getString(EDocumentUtils.DESCACTIVIDAD));} 				catch (Exception e) {errorMessages.append(e);}

		JSONObject jsonDireccion = receptorJson.getJSONObject("direccion");
		try {receptorFactura.getDireccion().setDepartamento(jsonDireccion.getString(EDocumentUtils.DEPARTAMENTO));}	catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.getDireccion().setMunicipio(jsonDireccion.getString(EDocumentUtils.MUNICIPIO));} 		catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.getDireccion().setComplemento(jsonDireccion.getString(EDocumentUtils.COMPLEMENTO));} 	catch (Exception e) {errorMessages.append(e);}

		try {receptorFactura.setTelefono(receptorJson.getString(EDocumentUtils.TELEFONO));} 						catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.setCorreo(receptorJson.getString(EDocumentUtils.CORREO));} 							catch (Exception e) {errorMessages.append(e);}

		System.out.println("Start fillReceptor"); 
		return errorMessages;
	}


	@Override
	public StringBuffer fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		// Convert (=cast) all (OtrosDocumentosItem) to (OtrosDocumentosItemFactura)
		List<OtrosDocumentosItemFactura> otrosDocumentosItemFactura = new ArrayList<OtrosDocumentosItemFactura>();
		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemFactura.add((OtrosDocumentosItemFactura) e) );

		// No Otros Documentos for Factura
		errorMessages.setLength(0);
		return errorMessages;
	}


	@Override
	public StringBuffer fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		VentaTerceroFactura ventaTerceroFactura = (VentaTerceroFactura) ventaTercero;

		// No Venta Tercero for Factura
		errorMessages.setLength(0);
		return errorMessages;
	}


	@Override
	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {	
		System.out.println("Start fillCuerpoDocumento"); 
		errorMessages.setLength(0);
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemFactura)
		List<CuerpoDocumentoItemFactura> cuerpoDocumentoItemFactura = new ArrayList<CuerpoDocumentoItemFactura>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemFactura.add((CuerpoDocumentoItemFactura) e) );

		JSONArray cuerpoDocumentoItemsJson = factoryInput.getJSONArray("cuerpoDocumento");

		for (int i=0; i< cuerpoDocumentoItemsJson.length(); i++) {
			JSONObject cuerpoDocumentoItemJson = cuerpoDocumentoItemsJson.getJSONObject(i);		

			CuerpoDocumentoItemFactura newCuerpoDocumentoItemFactura = new CuerpoDocumentoItemFactura();
			try {newCuerpoDocumentoItemFactura.setNumItem(cuerpoDocumentoItemJson.getInt(EDocumentUtils.NUMITEM));} 					catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setTipoItem(cuerpoDocumentoItemJson.getInt(EDocumentUtils.TIPOITEM));} 					catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setNumeroDocumento(cuerpoDocumentoItemJson.getString(EDocumentUtils.NUMERODOCUMENTO));} 	catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setCantidad(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.CANTIDAD));} 			catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setCodigo(cuerpoDocumentoItemJson.getString(EDocumentUtils.CODIGO));} 					catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setCodTributo(null);} 																	catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setUniMedida(cuerpoDocumentoItemJson.getInt(EDocumentUtils.UNIMEDIDA));} 				catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setDescripcion(cuerpoDocumentoItemJson.getString(EDocumentUtils.DESCRIPCION));} 			catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setPrecioUni(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.PRECIOUNI));} 			catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setMontoDescu(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.MONTODESCU));} 		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setVentaNoSuj(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.VENTANOSUJ));} 		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setVentaExenta(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.VENTAEXENTA));} 		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setVentaGravada(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.VENTAGRAVADA));} 	catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setTributos(null);} 																		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setPsv(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.PSV));} 						catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setNoGravado(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.NOGRAVADO));} 			catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setIvaItem(cuerpoDocumentoItemJson.getBigDecimal(EDocumentUtils.IVAITEM));} 				catch (Exception e) {errorMessages.append(e);}

			cuerpoDocumentoItemFactura.add(newCuerpoDocumentoItemFactura);						
		}

		System.out.println("Start fillCuerpoDocumento"); 
		return errorMessages;
	}


	@Override
	public StringBuffer fillResumen(JSONObject factoryInput, Resumen resumen) {
		System.out.println("Start fillResumen"); 
		errorMessages.setLength(0);		
		ResumenFactura resumenFactura = (ResumenFactura) resumen;
		JSONObject resumenJson = factoryInput.getJSONObject("resumen");		

		try {resumenFactura.setTotalNoSuj(resumenJson.getBigDecimal(EDocumentUtils.TOTALNOSUJ));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalExenta(resumenJson.getBigDecimal(EDocumentUtils.TOTALEXENTA));} 				catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalGravada(resumenJson.getBigDecimal(EDocumentUtils.TOTALGRAVADA));} 				catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setSubTotalVentas(resumenJson.getBigDecimal(EDocumentUtils.SUBTOTALVENTAS));} 			catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setDescuNoSuj(resumenJson.getBigDecimal(EDocumentUtils.DESCUNOSUJ));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setDescuExenta(resumenJson.getBigDecimal(EDocumentUtils.DESCUEXENTA));} 				catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setDescuGravada(resumenJson.getBigDecimal(EDocumentUtils.DESCUGRAVADA));} 				catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setPorcentajeDescuento(resumenJson.getBigDecimal(EDocumentUtils.PORCENTAJEDESCUENTO));} catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setSubTotal(resumenJson.getBigDecimal(EDocumentUtils.SUBTOTAL));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setIvaRete1(resumenJson.getBigDecimal(EDocumentUtils.IVARETE1));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setMontoTotalOperacion(resumenJson.getBigDecimal(EDocumentUtils.MONTOTOTALOPERACION));} catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalNoGravado(resumenJson.getBigDecimal(EDocumentUtils.TOTALNOGRAVADO));} 			catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalPagar(resumenJson.getBigDecimal(EDocumentUtils.TOTALPAGAR));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalLetras(resumenJson.getString(EDocumentUtils.TOTALLETRAS));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setSaldoFavor(resumenJson.getBigDecimal(EDocumentUtils.SALDOFAVOR));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setCondicionOperacion(resumenJson.getInt(EDocumentUtils.CONDICIONOPERACION));} 			catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalDescu(resumenJson.getBigDecimal(EDocumentUtils.TOTALDESCU));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setReteRenta(resumenJson.getBigDecimal(EDocumentUtils.RETERENTA));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalIva(resumenJson.getBigDecimal(EDocumentUtils.TOTALIVA));} 						catch (Exception e) {errorMessages.append(e);}

		JSONArray pagosItemsJson = factoryInput.getJSONArray("pagos");
		JSONObject pagosItemJson = pagosItemsJson.getJSONObject(0);

		PagosItem newPagosItem = new PagosItem();
		try {newPagosItem.setCodigo(pagosItemJson.getString(EDocumentUtils.CODIGO));} 			catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setMontoPago(pagosItemJson.getBigDecimal(EDocumentUtils.MONTOPAGO));}	catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setReferencia(pagosItemJson.getString(EDocumentUtils.REFERENCIA));} 	catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setPlazo(pagosItemJson.getString(EDocumentUtils.PLAZO));} 			catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setPeriodo(pagosItemJson.getInt(EDocumentUtils.PERIODO));} 			catch (Exception e) {errorMessages.append(e);}

		resumenFactura.getPagos().add(newPagosItem);

		System.out.println("Finish fillResumen"); 
		return errorMessages;
	}


	@Override
	public StringBuffer fillExtension(JSONObject factoryInput, Extension extension) {
		ExtensionFactura extensionFactura = (ExtensionFactura) extension;

		// No Otros Extension for Factura
		errorMessages.setLength(0);
		return errorMessages;
	}


	@Override
	public StringBuffer fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemFactura)
		List<ApendiceItemFactura> apendiceItemFactura = new ArrayList<ApendiceItemFactura>();
		apendice.stream().forEach(e -> apendiceItemFactura.add((ApendiceItemFactura) e) );

		// No Apendice for Factura
		errorMessages.setLength(0);
		return errorMessages;
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Documento createDocumento() {
		throw new UnsupportedOperationException("In Document Factura calling the method FacturaFactory.createDocumento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillDocumento(JSONObject factoryInput, Documento documento) {
		throw new UnsupportedOperationException("In Document Factura calling the method FacturaFactory.fillDocumento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Motivo createMotivo() {
		throw new UnsupportedOperationException("In Document Factura calling the method FacturaFactory.createMotivo() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public StringBuffer fillMotivo(JSONObject factoryInput, Motivo motivo) {
		throw new UnsupportedOperationException("In Document Factura calling the method FacturaFactory.fillMotivo() is not allowed");
	}


}
