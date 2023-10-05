/**
 * 
 */
package org.shw.einvoice.es.factory;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.shw.einvoice.es.fendnotadedebitov3.ApendiceItemNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.CuerpoDocumentoItemNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.DocumentoRelacionadoItemNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.EmisorNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.ExtensionNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.IdentificacionNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.ReceptorNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.ResumenNotaDeDebito;
import org.shw.einvoice.es.fendnotadedebitov3.VentaTerceroNotaDeDebito;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.EDocument;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;


/**
 * 
 */
public class NotaDeDebito extends EDocument {
	IdentificacionNotaDeDebito identificacion;
	List<DocumentoRelacionadoItemNotaDeDebito> documentoRelacionado;
	EmisorNotaDeDebito emisor;
	ReceptorNotaDeDebito receptor;
	VentaTerceroNotaDeDebito ventaTercero = null;
	List<CuerpoDocumentoItemNotaDeDebito> cuerpoDocumento;
	ResumenNotaDeDebito resumen;
	ExtensionNotaDeDebito extension;
	List<ApendiceItemNotaDeDebito> apendice=null;  // null allowed
	
	/**
	 * No parameters
	 */
	public NotaDeDebito() {
		this.identificacion       = new IdentificacionNotaDeDebito();
	    this.documentoRelacionado = new ArrayList<DocumentoRelacionadoItemNotaDeDebito>();
		this.emisor               = new EmisorNotaDeDebito();
		this.receptor             = new ReceptorNotaDeDebito();
		this.ventaTercero         = new VentaTerceroNotaDeDebito();
	    this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItemNotaDeDebito>();
		this.resumen              = new ResumenNotaDeDebito();
		this.extension            = new ExtensionNotaDeDebito();
	    this.apendice             = new ArrayList<ApendiceItemNotaDeDebito>();
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
	public IdentificacionNotaDeDebito getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(IdentificacionNotaDeDebito identificacion) {
		this.identificacion = identificacion;
	}


	/**
	 * @param identificacion the (IdentificacionFactura) identificacion to set
	 */
	public StringBuffer fillIdentification(JSONObject factoryInput) {
		System.out.println("Start NotaDeDebito.fillIdentificacion()");

		JSONObject identificationJson = factoryInput.getJSONObject(IDENTIFICACION);
//		try {identificacion.setNumeroControl(identificationJson.getString(NUMEROCONTROL));} 		catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setCodigoGeneracion(identificationJson.getString(CODIGOGENERACION));} 	catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoModelo(identificationJson.getInt(TIPOMODELO));} 					catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoOperacion(identificationJson.getInt(TIPOOPERACION));} 			catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setFecEmi(identificationJson.getString(FECEMI));} 						catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setHorEmi(identificationJson.getString(HOREMI));} 						catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoMoneda(identificationJson.getString(TIPOMONEDA));} 				catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setAmbiente(identificationJson.getString(AMBIENTE));} 					catch (Exception e) {errorMessages.append(e);}

		System.out.println("End NotaDeDebito.fillIdentificacion()");
		return errorMessages;
	}

	public List<DocumentoRelacionadoItemNotaDeDebito> getDocumentoRelacionado() {
		return this.documentoRelacionado;
	}

	public void setDocumentoRelacionado(List<DocumentoRelacionadoItemNotaDeDebito> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}

	/**
	 * @return the emisor
	 */
	public EmisorNotaDeDebito getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorNotaDeDebito emisor) {
		this.emisor = emisor;
	}

	public StringBuffer fillEmisor(JSONObject factoryInput) {
		System.out.println("Start NotaDeDebito.fillEmisor()");

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

		System.out.println("End NotaDeDebito.fillEmisor()");
		return errorMessages;
	}

	/**
	 * @return the receptor
	 */
	public ReceptorNotaDeDebito getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorNotaDeDebito receptor) {
		this.receptor = receptor;
	}

	public StringBuffer fillReceptor(JSONObject factoryInput) {
		System.out.println("Start NotaDeDebito.fillReceptor()");

		JSONObject receptorJson = factoryInput.getJSONObject(RECEPTOR);
		try {emisor.setNit(receptorJson.getString(NIT));} 									catch (Exception e) {errorMessages.append(e);}
		
		System.out.println("End NotaDeDebito.fillReceptor()");
		return errorMessages;
	}

	/**
	 * @return the ventaTercero
	 */
	public VentaTerceroNotaDeDebito getVentaTercero() {
		return ventaTercero;
	}

	/**
	 * @param ventaTercero the ventaTercero to set
	 */
	public void setVentaTercero(VentaTerceroNotaDeDebito ventaTercero) {
		this.ventaTercero = ventaTercero;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	public List<CuerpoDocumentoItemNotaDeDebito> getCuerpoDocumento() {
		return cuerpoDocumento;
	}

	public void setCuerpoDocumento(List<CuerpoDocumentoItemNotaDeDebito> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}

	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput) {
		System.out.println("Start NotaDeDebito.fillCuerpoDocumento()");

		JSONObject cuerpoDocumentoItemsJson = factoryInput.getJSONObject(CUERPODOCUMENTO);
		JSONArray cuerpoDocumentoArrayJson = cuerpoDocumentoItemsJson.getJSONArray(CUERPODOCUMENTO);
	
		for (int i=0; i< cuerpoDocumentoArrayJson.length(); i++) { 
			JSONObject cuerpoDocumentoItemJson = cuerpoDocumentoArrayJson.getJSONObject(i);
			CuerpoDocumentoItemNotaDeDebito cuerpoDocumentoItemNotaDeDebito = new CuerpoDocumentoItemNotaDeDebito();
			try {cuerpoDocumentoItemNotaDeDebito.setNumItem(cuerpoDocumentoItemJson.getInt(NUMITEM));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setTipoItem(cuerpoDocumentoItemJson.getInt(TIPOITEM));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setNumeroDocumento(cuerpoDocumentoItemJson.getString(NUMERODOCUMENTO));} 	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setCantidad(cuerpoDocumentoItemJson.getBigDecimal(CANTIDAD));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setCodigo(cuerpoDocumentoItemJson.getString(CODIGO));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setCodTributo(null);} 																	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setUniMedida(cuerpoDocumentoItemJson.getInt(UNIMEDIDA));} 				catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setDescripcion(cuerpoDocumentoItemJson.getString(DESCRIPCION));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setPrecioUni(cuerpoDocumentoItemJson.getBigDecimal(PRECIOUNI));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setMontoDescu(cuerpoDocumentoItemJson.getBigDecimal(MONTODESCU));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setVentaNoSuj(cuerpoDocumentoItemJson.getBigDecimal(VENTANOSUJ));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setVentaExenta(cuerpoDocumentoItemJson.getBigDecimal(VENTAEXENTA));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setVentaGravada(cuerpoDocumentoItemJson.getBigDecimal(VENTAGRAVADA));} 	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setTributos(null);} 																		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setPsv(cuerpoDocumentoItemJson.getBigDecimal(PSV));} 						catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setNoGravado(cuerpoDocumentoItemJson.getBigDecimal(NOGRAVADO));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemNotaDeDebito.setIvaItem(cuerpoDocumentoItemJson.getBigDecimal(IVAITEM));} 				catch (Exception e) {errorMessages.append(e);}

			cuerpoDocumento.add(cuerpoDocumentoItemNotaDeDebito);						
		}

		System.out.println("End NotaDeDebito.fillCuerpoDocumento()"); 
		return errorMessages;
	}

	/**
	 * @return the resumen
	 */
	public ResumenNotaDeDebito getResumen() {
		return resumen;
	}

	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(ResumenNotaDeDebito resumen) {
		this.resumen = resumen;
	}

	public StringBuffer fillResumen(JSONObject factoryInput) {
		System.out.println("Start NotaDeDebito.fillResumen()");
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

		System.out.println("End NotaDeDebito.fillResumen()"); 
		return errorMessages;
	}

	/**
	 * @return the extension
	 */
	public ExtensionNotaDeDebito getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(ExtensionNotaDeDebito extension) {
		this.extension = extension;
	}

	/**
	 * @return the apendice
	 */
	public List<ApendiceItemNotaDeDebito> getApendice() {
		return this.apendice;
	}

	public void setApendice(List<ApendiceItemNotaDeDebito> apendice) {
		this.apendice = apendice;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
}
