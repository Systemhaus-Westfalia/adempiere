/**
 * 
 */
package org.shw.einvoice.es.factory;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.shw.einvoice.es.fencnotadecreditov1.ApendiceItemNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.CuerpoDocumentoItemNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.DocumentoRelacionadoItemNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.EmisorNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.ExtensionNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.IdentificacionNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.ReceptorNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.ResumenNotaDeCredito;
import org.shw.einvoice.es.fencnotadecreditov1.VentaTerceroNotaDeCredito;
import org.shw.einvoice.es.util.pojo.EDocument;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;


/**
 * 
 */
public class NotaDeCredito extends EDocument {
	public StringBuffer errorMessages = new StringBuffer();

	IdentificacionNotaDeCredito identificacion;
	List<DocumentoRelacionadoItemNotaDeCredito> documentoRelacionado;
	EmisorNotaDeCredito emisor;
	ReceptorNotaDeCredito receptor;
	VentaTerceroNotaDeCredito ventaTercero = null;
	List<CuerpoDocumentoItemNotaDeCredito> cuerpoDocumento;
	ResumenNotaDeCredito resumen;
	ExtensionNotaDeCredito extension;
	List<ApendiceItemNotaDeCredito> apendice=null;  // null allowed

	/**
	 * No parameters
	 */
	public NotaDeCredito() {
		this.identificacion       = new IdentificacionNotaDeCredito();
	    this.documentoRelacionado      = new ArrayList<DocumentoRelacionadoItemNotaDeCredito>();
		this.emisor               = new EmisorNotaDeCredito();
		this.receptor             = new ReceptorNotaDeCredito();
		this.ventaTercero         = new VentaTerceroNotaDeCredito();
	    this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItemNotaDeCredito>();
		this.resumen              = new ResumenNotaDeCredito();
		this.extension            = new ExtensionNotaDeCredito();
	    this.apendice      = new ArrayList<ApendiceItemNotaDeCredito>();
	}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {		
		return EDocumentUtils.VALIDATION_RESULT_OK;
	}

	/**
	 * @return the identificacion
	 */
	public IdentificacionNotaDeCredito getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(IdentificacionNotaDeCredito identificacion) {
		this.identificacion = identificacion;
	}


	/**
	 * @param identificacion the (IdentificacionFactura) identificacion to set
	 */
	public StringBuffer fillIdentification(JSONObject factoryInput) {
		System.out.println("Start NotaDeCredito.fillIdentificacion()"); 

		JSONObject identificationJson = factoryInput.getJSONObject(IDENTIFICACION);
//		try {identificacion.setNumeroControl(identificationJson.getString(NUMEROCONTROL));} 		catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setCodigoGeneracion(identificationJson.getString(CODIGOGENERACION));} 	catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoModelo(identificationJson.getInt(TIPOMODELO));} 					catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoOperacion(identificationJson.getInt(TIPOOPERACION));} 			catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setFecEmi(identificationJson.getString(FECEMI));} 						catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setHorEmi(identificationJson.getString(HOREMI));} 						catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoMoneda(identificationJson.getString(TIPOMONEDA));} 				catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setAmbiente(identificationJson.getString(AMBIENTE));} 					catch (Exception e) {errorMessages.append(e);}

		System.out.println("End NotaDeCredito.fillIdentificacion()");
		return errorMessages;
	}

	@SuppressWarnings("unchecked")
	public List<DocumentoRelacionadoItemNotaDeCredito> getDocumentoRelacionado() {
		return documentoRelacionado;
	}

	public void setDocumentoRelacionado(List<DocumentoRelacionadoItemNotaDeCredito> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}

	/**
	 * @return the emisor
	 */
	public EmisorNotaDeCredito getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorNotaDeCredito emisor) {
		this.emisor = emisor;
	}

	public StringBuffer fillEmisor(JSONObject factoryInput) {
		System.out.println("Start NotaDeCredito.fillEmisor()"); 

		JSONObject emisorJson = factoryInput.getJSONObject(EMISOR);
		try {emisor.setNit(emisorJson.getString(NIT));} 									catch (Exception e) {errorMessages.append(e);}
//		try {emisor.setNrc(emisorJson.getString(NRC));} 									catch (Exception e) {errorMessages.append(e);}
//		try {emisor.setNombre(emisorJson.getString(NOMBRE));} 								catch (Exception e) {errorMessages.append(e);}
//		try {emisor.setCodActividad(emisorJson.getString(CODACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
//		try {emisor.setDescActividad(emisorJson.getString(DESCACTIVIDAD));} 				catch (Exception e) {errorMessages.append(e);}
//		try {emisor.setNombreComercial(emisorJson.getString(NOMBRECOMERCIAL));} 			catch (Exception e) {errorMessages.append(e);}		
//		try {emisor.setTipoEstablecimiento(emisorJson.getString(TIPOESTABLECIMIENTO));}		catch (Exception e) {errorMessages.append(e);}	
//
//		JSONObject jsonDireccion = emisorJson.getJSONObject(DIRECCION);
//		try {emisor.getDireccion().setDepartamento(jsonDireccion.getString(DEPARTAMENTO));}	catch (Exception e) {errorMessages.append(e);}
//		try {emisor.getDireccion().setMunicipio(jsonDireccion.getString(MUNICIPIO));} 		catch (Exception e) {errorMessages.append(e);}
//		try {emisor.getDireccion().setComplemento(jsonDireccion.getString(COMPLEMENTO));} 	catch (Exception e) {errorMessages.append(e);}
//
//		try {emisor.setTelefono(emisorJson.getString(TELEFONO));} 							catch (Exception e) {errorMessages.append(e);}
//		try {emisor.setCorreo(emisorJson.getString(CORREO));} 								catch (Exception e) {errorMessages.append(e);}

		System.out.println("End NotaDeCredito.fillEmisor()");
		return errorMessages;
	}

	/**
	 * @return the receptor
	 */
	public ReceptorNotaDeCredito getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorNotaDeCredito receptor) {
		this.receptor = receptor;
	}

	public StringBuffer fillReceptor(JSONObject factoryInput) {
		System.out.println("Start NotaDeCredito.fillReceptor()"); 

		JSONObject receptorJson = factoryInput.getJSONObject(RECEPTOR);
		try {emisor.setNit(receptorJson.getString(NIT));} 									catch (Exception e) {errorMessages.append(e);}
		
		System.out.println("End NotaDeCredito.fillReceptor()");
		return errorMessages;
	}

	/**
	 * @return the ventaTercero
	 */
	public VentaTerceroNotaDeCredito getVentaTercero() {
		return ventaTercero;
	}

	/**
	 * @param ventaTercero the ventaTercero to set
	 */
	public void setVentaTercero(VentaTerceroNotaDeCredito ventaTercero) {
		this.ventaTercero = ventaTercero;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	@SuppressWarnings("unchecked")
	public List<CuerpoDocumentoItemNotaDeCredito> getCuerpoDocumento() {
		return cuerpoDocumento;
	}

	public void setCuerpoDocumento(List<CuerpoDocumentoItemNotaDeCredito> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}

	@SuppressWarnings("unchecked")
	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput) {
		System.out.println("Start NotaDeCredito.fillCuerpoDocumento()"); 

		JSONObject cuerpoDocumentoItemsJson = factoryInput.getJSONObject(CUERPODOCUMENTO);
		JSONArray cuerpoDocumentoArrayJson = cuerpoDocumentoItemsJson.getJSONArray(CUERPODOCUMENTO);
	
		for (int i=0; i< cuerpoDocumentoArrayJson.length(); i++) { 
			JSONObject cuerpoDocumentoItemJson = cuerpoDocumentoArrayJson.getJSONObject(i);
			CuerpoDocumentoItemNotaDeCredito cuerpoDocumentoItemNotaDeCredito = new CuerpoDocumentoItemNotaDeCredito();
			try {cuerpoDocumentoItemNotaDeCredito.setNumItem(cuerpoDocumentoItemJson.getInt(NUMITEM));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setTipoItem(cuerpoDocumentoItemJson.getInt(TIPOITEM));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setNumeroDocumento(cuerpoDocumentoItemJson.getString(NUMERODOCUMENTO));} 	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setCantidad(cuerpoDocumentoItemJson.getBigDecimal(CANTIDAD));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setCodigo(cuerpoDocumentoItemJson.getString(CODIGO));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setCodTributo(null);} 																	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setUniMedida(cuerpoDocumentoItemJson.getInt(UNIMEDIDA));} 				catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setDescripcion(cuerpoDocumentoItemJson.getString(DESCRIPCION));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setPrecioUni(cuerpoDocumentoItemJson.getBigDecimal(PRECIOUNI));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setMontoDescu(cuerpoDocumentoItemJson.getBigDecimal(MONTODESCU));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setVentaNoSuj(cuerpoDocumentoItemJson.getBigDecimal(VENTANOSUJ));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setVentaExenta(cuerpoDocumentoItemJson.getBigDecimal(VENTAEXENTA));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setVentaGravada(cuerpoDocumentoItemJson.getBigDecimal(VENTAGRAVADA));} 	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setTributos(null);} 																		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setPsv(cuerpoDocumentoItemJson.getBigDecimal(PSV));} 						catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setNoGravado(cuerpoDocumentoItemJson.getBigDecimal(NOGRAVADO));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeCredito.setIvaItem(cuerpoDocumentoItemJson.getBigDecimal(IVAITEM));} 				catch (Exception e) {errorMessages.append(e);}

			cuerpoDocumento.add(cuerpoDocumentoItemNotaDeCredito);						
		}

		System.out.println("End NotaDeCredito.fillCuerpoDocumento()"); 
		return errorMessages;
	}

	/**
	 * @return the resumen
	 */
	public ResumenNotaDeCredito getResumen() {
		return resumen;
	}

	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(ResumenNotaDeCredito resumen) {
		this.resumen = resumen;
	}

	public StringBuffer fillResumen(JSONObject factoryInput) {
		System.out.println("Start NotaDeCredito.fillResumen()"); 
		JSONObject resumenJson = factoryInput.getJSONObject(RESUMEN);		

		try {resumen.setTotalNoSuj(resumenJson.getBigDecimal(TOTALNOSUJ));} 					catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setTotalExenta(resumenJson.getBigDecimal(TOTALEXENTA));} 				catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setTotalGravada(resumenJson.getBigDecimal(TOTALGRAVADA));} 				catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setSubTotalVentas(resumenJson.getBigDecimal(SUBTOTALVENTAS));} 			catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setDescuNoSuj(resumenJson.getBigDecimal(DESCUNOSUJ));} 					catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setDescuExenta(resumenJson.getBigDecimal(DESCUEXENTA));} 				catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setDescuGravada(resumenJson.getBigDecimal(DESCUGRAVADA));} 				catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setPorcentajeDescuento(resumenJson.getBigDecimal(PORCENTAJEDESCUENTO));} catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setSubTotal(resumenJson.getBigDecimal(SUBTOTAL));} 						catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setIvaRete1(resumenJson.getBigDecimal(IVARETE1));} 						catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setMontoTotalOperacion(resumenJson.getBigDecimal(MONTOTOTALOPERACION));} catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setTotalNoGravado(resumenJson.getBigDecimal(TOTALNOGRAVADO));} 			catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setTotalPagar(resumenJson.getBigDecimal(TOTALPAGAR));} 					catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setTotalLetras(resumenJson.getString(TOTALLETRAS));} 					catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setSaldoFavor(resumenJson.getBigDecimal(SALDOFAVOR));} 					catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setCondicionOperacion(resumenJson.getInt(CONDICIONOPERACION));} 		catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setTotalDescu(resumenJson.getBigDecimal(TOTALDESCU));} 					catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setReteRenta(resumenJson.getBigDecimal(RETERENTA));} 					catch (Exception e) {errorMessages.append(e);}
//		try {resumen.setTotalIva(resumenJson.getBigDecimal(TOTALIVA));} 						catch (Exception e) {errorMessages.append(e);}
//
//		JSONArray pagosItemsJson = resumenJson.getJSONArray(PAGOS);
//		JSONObject pagosItemJson = pagosItemsJson.getJSONObject(0);
//
//		PagosItem newPagosItem = new PagosItem();
//		try {newPagosItem.setCodigo(pagosItemJson.getString(CODIGO));} 			catch (Exception e) {errorMessages.append(e);}
//		try {newPagosItem.setMontoPago(pagosItemJson.getBigDecimal(MONTOPAGO));}	catch (Exception e) {errorMessages.append(e);}
//		try {newPagosItem.setReferencia(pagosItemJson.getString(REFERENCIA));} 	catch (Exception e) {errorMessages.append(e);}
//		try {newPagosItem.setPlazo(pagosItemJson.getString(PLAZO));} 			catch (Exception e) {errorMessages.append(e);}
//		try {newPagosItem.setPeriodo(pagosItemJson.getInt(PERIODO));} 			catch (Exception e) {errorMessages.append(e);}

		//resumen.getPagos().add(newPagosItem);

		System.out.println("End NotaDeCredito.fillResumen()"); 
		return errorMessages;
	}

	/**
	 * @return the extension
	 */
	public ExtensionNotaDeCredito getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(ExtensionNotaDeCredito extension) {
		this.extension = extension;
	}

	/**
	 * @return the apendice
	 */
	@SuppressWarnings("unchecked")
	public List<ApendiceItemNotaDeCredito> getApendice() {
		return apendice;
	}

	public void setApendice(List<ApendiceItemNotaDeCredito> apendice) {
		this.apendice = apendice;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
}
