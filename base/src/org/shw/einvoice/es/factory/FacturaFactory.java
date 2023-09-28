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
	static final String NUMEROCONTROL =  "numeroControl";
	static final String CODIGOGENERACION =  "codigoGeneracion";
	static final String TIPOMODELO =  "tipoModelo";
	static final String TIPOOPERACION =  "tipoOperacion";
	static final String FECEMI =  "fecEmi";
	static final String HOREMI =  "horEmi";
	static final String TIPOMONEDA =  "tipoMoneda";
	static final String NIT =  "nit";
	static final String NRC =  "nrc";
	static final String NOMBRE =  "nombre";
	static final String CODACTIVIDAD =  "codActividad";
	static final String DESCACTIVIDAD =  "descActividad";
	static final String NOMBRECOMERCIAL =  "nombreComercial";
	static final String TIPOESTABLECIMIENTO =  "tipoEstablecimiento";
	static final String DEPARTAMENTO =  "departamento";
	static final String MUNICIPIO =  "municipio";
	static final String COMPLEMENTO =  "complemento";
	static final String TELEFONO =  "telefono";
	static final String CORREO =  "correo";
	static final String TIPODOCUMENTO =  "tipoDocumento";
	static final String NUMDOCUMENTO =  "numDocumento";
	static final String NUMITEM = "numItem";
	static final String TIPOITEM = "tipoItem";
	static final String NUMERODOCUMENTO = "numeroDocumento";
	static final String CANTIDAD = "cantidad";
	static final String CODIGO = "codigo";
	static final String CODIGOTRIBUTO = "codigoTributo";
	
	static final String UNIMEDIDA = "uniMedida";
	static final String DESCRIPCION = "descripcion";
	static final String PRECIOUNI = "precioUni";
	static final String MONTODESCU = "montoDescu";
	static final String VENTANOSUJ = "ventaNoSuj";
	static final String VENTAEXENTA = "ventaExenta";
	static final String VENTAGRAVADA = "ventaGravada";
	static final String IVAITEM = "ivaItem";
	static final String PSV = "psv";
	static final String NOGRAVADO = "noGravado";

    
								
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
		try {identificacionFactura.setNumeroControl(identificationJson.getString(NUMEROCONTROL));} 			catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setCodigoGeneracion(identificationJson.getString(CODIGOGENERACION));} 	catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setTipoModelo(identificationJson.getInt(TIPOMODELO));} 					catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setTipoOperacion(identificationJson.getInt(TIPOOPERACION));} 			catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setFecEmi(identificationJson.getString(FECEMI));} 						catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setHorEmi(identificationJson.getString(HOREMI));} 						catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setTipoMoneda(identificationJson.getString(TIPOMONEDA));} 				catch (Exception e) {errorMessages.append(e);}
		try {identificacionFactura.setAmbiente("00");} catch (Exception e) {errorMessages.append(e);}
		
		System.out.println("End fillIdentificacion"); 
		return errorMessages;
	}


	@Override
	public StringBuffer fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		// Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemFactura)
		List<DocumentoRelacionadoItemFactura> documentoRelacionadoItemFactura = new ArrayList<DocumentoRelacionadoItemFactura>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemFactura.add((DocumentoRelacionadoItemFactura) e) );
		
		// No Documento Relacionado for Factura

		return errorMessages;
		
	}


	@Override
	public StringBuffer fillEmisor(JSONObject factoryInput, Emisor emisor) {
		EmisorFactura emisorFactura = (EmisorFactura) emisor;	
		System.out.println("Start fillEmisor"); 
		errorMessages.setLength(0);

		JSONObject emisorJson = factoryInput.getJSONObject("emisor");
		try {emisorFactura.setNit(emisorJson.getString(NIT));} 									catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setNrc(emisorJson.getString(NRC));} 									catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setNombre(emisorJson.getString(NOMBRE));} 								catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setCodActividad(emisorJson.getString(CODACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setDescActividad(emisorJson.getString(DESCACTIVIDAD));} 				catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setNombreComercial(emisorJson.getString(NOMBRECOMERCIAL));} 			catch (Exception e) {errorMessages.append(e);}		
		try {emisorFactura.setTipoEstablecimiento(emisorJson.getString(TIPOESTABLECIMIENTO));}	catch (Exception e) {errorMessages.append(e);}	
		
		JSONObject jsonDireccion = emisorJson.getJSONObject("direccion");
		try {emisorFactura.getDireccion().setDepartamento(jsonDireccion.getString(DEPARTAMENTO));}	catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.getDireccion().setMunicipio(jsonDireccion.getString(MUNICIPIO));} 		catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.getDireccion().setComplemento(jsonDireccion.getString(COMPLEMENTO));} 	catch (Exception e) {errorMessages.append(e);}
		
		try {emisorFactura.setTelefono(emisorJson.getString(TELEFONO));} 							catch (Exception e) {errorMessages.append(e);}
		try {emisorFactura.setCorreo(emisorJson.getString(CORREO));} 								catch (Exception e) {errorMessages.append(e);}

		System.out.println("End fillEmisor");
		return errorMessages;
	}


	@Override
	public StringBuffer fillReceptor(JSONObject factoryInput, Receptor receptor) {
		ReceptorFactura receptorFactura = (ReceptorFactura) receptor;
		System.out.println("Start fillReceptor"); 
		errorMessages.setLength(0);		

		JSONObject receptorJson = factoryInput.getJSONObject("receptor");
		try {receptorFactura.setTipoDocumento(receptorJson.getString(TIPODOCUMENTO));} 					catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.setNumDocumento(receptorJson.getString(NUMDOCUMENTO));} 					catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.setNombre(receptorJson.getString(NOMBRE));} 								catch (Exception e) {errorMessages.append(e);}
        try {receptorFactura.setCodActividad(receptorJson.getString(CODACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
        try {receptorFactura.setDescActividad(receptorJson.getString(DESCACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
        
		JSONObject jsonDireccion = receptorJson.getJSONObject("direccion");
		try {receptorFactura.getDireccion().setDepartamento(jsonDireccion.getString(DEPARTAMENTO));}	catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.getDireccion().setMunicipio(jsonDireccion.getString(MUNICIPIO));} 			catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.getDireccion().setComplemento(jsonDireccion.getString(COMPLEMENTO));} 		catch (Exception e) {errorMessages.append(e);}
		
		try {receptorFactura.setTelefono(receptorJson.getString(TELEFONO));} 							catch (Exception e) {errorMessages.append(e);}
		try {receptorFactura.setCorreo(receptorJson.getString(CORREO));} 								catch (Exception e) {errorMessages.append(e);}

		System.out.println("Start fillReceptor"); 
		return errorMessages;
	}


	@Override
	public StringBuffer fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		// Convert (=cast) all (OtrosDocumentosItem) to (OtrosDocumentosItemFactura)
		List<OtrosDocumentosItemFactura> otrosDocumentosItemFactura = new ArrayList<OtrosDocumentosItemFactura>();
		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemFactura.add((OtrosDocumentosItemFactura) e) );
		
		// No Otros Documentos for Factura

		
		return errorMessages;
	}


	@Override
	public StringBuffer fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		VentaTerceroFactura ventaTerceroFactura = (VentaTerceroFactura) ventaTercero;
		
		// No Venta Tercero for Factura

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
			try {newCuerpoDocumentoItemFactura.setNumItem(cuerpoDocumentoItemJson.getInt(NUMITEM));} 					catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setTipoItem(cuerpoDocumentoItemJson.getInt(TIPOITEM));} 					catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setNumeroDocumento(cuerpoDocumentoItemJson.getString(NUMERODOCUMENTO));} catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setCantidad(cuerpoDocumentoItemJson.getBigDecimal(CANTIDAD));} 			catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setCodigo(cuerpoDocumentoItemJson.getString(CODIGO));} 					catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setCodTributo(null);} 													catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setUniMedida(cuerpoDocumentoItemJson.getInt(UNIMEDIDA));} 				catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setDescripcion(cuerpoDocumentoItemJson.getString(DESCRIPCION));} 		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setPrecioUni(cuerpoDocumentoItemJson.getBigDecimal(PRECIOUNI));} 		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setMontoDescu(cuerpoDocumentoItemJson.getBigDecimal(MONTODESCU));} 		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setVentaNoSuj(cuerpoDocumentoItemJson.getBigDecimal(VENTANOSUJ));} 		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setVentaExenta(cuerpoDocumentoItemJson.getBigDecimal(VENTAEXENTA));} 	catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setVentaGravada(cuerpoDocumentoItemJson.getBigDecimal(VENTAGRAVADA));} 	catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setTributos(null);} 														catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setPsv(cuerpoDocumentoItemJson.getBigDecimal(PSV));} 					catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setNoGravado(cuerpoDocumentoItemJson.getBigDecimal(NOGRAVADO));} 		catch (Exception e) {errorMessages.append(e);}
			try {newCuerpoDocumentoItemFactura.setIvaItem(cuerpoDocumentoItemJson.getBigDecimal(IVAITEM));} 			catch (Exception e) {errorMessages.append(e);}

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

		try {resumenFactura.setTotalNoSuj(resumenJson.getBigDecimal("totalNoSuj"));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalExenta(resumenJson.getBigDecimal("totalExenta"));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalGravada(resumenJson.getBigDecimal("totalGravada"));} 				catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setSubTotalVentas(resumenJson.getBigDecimal("subTotalVentas"));} 			catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setDescuNoSuj(resumenJson.getBigDecimal("descuNoSuj"));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setDescuExenta(resumenJson.getBigDecimal("descuExenta"));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setDescuGravada(resumenJson.getBigDecimal("descuGravada"));} 				catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setPorcentajeDescuento(resumenJson.getBigDecimal("porcentajeDescuento"));} 	catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setSubTotal(resumenJson.getBigDecimal("subTotal"));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setIvaRete1(resumenJson.getBigDecimal("ivaRete1"));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setMontoTotalOperacion(resumenJson.getBigDecimal("montoTotalOperacion"));} 	catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalNoGravado(resumenJson.getBigDecimal("totalNoGravado"));} 			catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalPagar(resumenJson.getBigDecimal("totalPagar"));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalLetras(resumenJson.getString("totalLetras"));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setSaldoFavor(resumenJson.getBigDecimal("saldoFavor"));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setCondicionOperacion(resumenJson.getInt("condicionOperacion"));} 			catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalDescu(resumenJson.getBigDecimal("totalDescu"));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setReteRenta(resumenJson.getBigDecimal("reteRenta"));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumenFactura.setTotalIva(resumenJson.getBigDecimal("totalIva"));} 						catch (Exception e) {errorMessages.append(e);}

		JSONArray pagosItemsJson = factoryInput.getJSONArray("pagos");
		JSONObject pagosItemJson = pagosItemsJson.getJSONObject(0);
		
		PagosItem newPagosItem = new PagosItem();
		try {newPagosItem.setCodigo(pagosItemJson.getString("codigo"));} 			catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setMontoPago(pagosItemJson.getBigDecimal("montoPago"));}	catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setReferencia(pagosItemJson.getString("referencia"));} 	catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setPlazo(pagosItemJson.getString("plazo"));} 				catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setPeriodo(pagosItemJson.getInt("periodo"));} 			catch (Exception e) {errorMessages.append(e);}
		
		resumenFactura.getPagos().add(newPagosItem);

		System.out.println("Finish fillResumen"); 
		return errorMessages;
	}


	@Override
	public StringBuffer fillExtension(JSONObject factoryInput, Extension extension) {
		ExtensionFactura extensionFactura = (ExtensionFactura) extension;
		return errorMessages;
	}


	@Override
	public StringBuffer fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemFactura)
		List<ApendiceItemFactura> apendiceItemFactura = new ArrayList<ApendiceItemFactura>();
		apendice.stream().forEach(e -> apendiceItemFactura.add((ApendiceItemFactura) e) );
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
