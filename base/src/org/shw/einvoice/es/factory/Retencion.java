/**
 * 
 */
package org.shw.einvoice.es.factory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.shw.einvoice.es.feccfcreditofiscalv3.CuerpoDocumentoItemCreditoFiscal;
import org.shw.einvoice.es.fecrretencionv1.ApendiceItemRetencion;
import org.shw.einvoice.es.fecrretencionv1.CuerpoDocumentoItemRetencion;
import org.shw.einvoice.es.fecrretencionv1.EmisorRetencion;
import org.shw.einvoice.es.fecrretencionv1.ExtensionRetencion;
import org.shw.einvoice.es.fecrretencionv1.IdentificacionRetencion;
import org.shw.einvoice.es.fecrretencionv1.ReceptorRetencion;
import org.shw.einvoice.es.fecrretencionv1.ResumenRetencion;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.EDocument;
import org.shw.einvoice.es.util.pojo.EDocumentFactory;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;


/**
 * 
 */
public class Retencion extends EDocument {	
	static final int CUERPODOCUMENTO_MAXIMUM_ITEMS = 500;
	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_CUERPODOCUMENTO_MAX_ITEMS  = "Documento: Retencion, clase: Retencion. Validacion falló: valor de 'cuerpoDocumento' debe  contener de 1 a 500 elementos";
	
	IdentificacionRetencion identificacion;
	EmisorRetencion emisor;
	ReceptorRetencion receptor;
	List<CuerpoDocumentoItemRetencion> cuerpoDocumento;
	ResumenRetencion resumen;
	ExtensionRetencion extension;
	List<ApendiceItemRetencion> apendice=null;  // null allowed

	/**
	 * No parameters
	 */
	public Retencion() {

		this.identificacion       =  new IdentificacionRetencion();
		this.emisor               = new EmisorRetencion();
		this.receptor             = new ReceptorRetencion();
	    this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItemRetencion>();
		this.resumen              = new ResumenRetencion();
		this.extension            = new ExtensionRetencion();
	    this.apendice             = new ArrayList<ApendiceItemRetencion>();
	}

	/**
	 * @return the identificacion
	 */
	public IdentificacionRetencion getIdentificacion() {
		return identificacion;
	}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {		
		return EDocumentUtils.VALIDATION_RESULT_OK;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionRetencion identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @param identificacion the (IdentificacionFactura) identificacion to set
	 */
	public StringBuffer fillIdentification(JSONObject factoryInput) {
		System.out.println("Start Retencion.fillIdentificacion()"); 
		errorMessages.setLength(0);

		JSONObject identificationJson = factoryInput.getJSONObject(IDENTIFICACION);
		try {identificacion.setVersion(identificationJson.getInt(VERSION));} 		catch (Exception e) {errorMessages.append(e);}
		//TODO weitere Properties setzen

		System.out.println("End Retencion.fillIdentificacion()");
		return errorMessages;
	}

	/**
	 * @return the emisor
	 */
	public EmisorRetencion getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorRetencion emisor) {
		this.emisor = emisor;
	}

	public StringBuffer fillEmisor(JSONObject factoryInput) {
		System.out.println("Start Retencion.fillEmisor()"); 
		errorMessages.setLength(0);

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

		System.out.println("End Retencion.fillEmisor()");
		return errorMessages;
	}

	/**
	 * @return the receptor
	 */
	public ReceptorRetencion getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorRetencion receptor) {
		this.receptor = receptor;
	}

	public StringBuffer fillReceptor(JSONObject factoryInput) {
		System.out.println("Start Retencion.fillReceptor()"); 
		errorMessages.setLength(0);

		JSONObject receptorJson = factoryInput.getJSONObject(RECEPTOR);
		try {emisor.setNit(receptorJson.getString(NIT));} 									catch (Exception e) {errorMessages.append(e);}
		
		System.out.println("End Retencion.fillReceptor()");
		return errorMessages;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	public List<CuerpoDocumentoItemRetencion> getCuerpoDocumento() {
		return cuerpoDocumento;
	}

	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItemRetencion> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}


	@SuppressWarnings("unchecked")
	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput) {
		System.out.println("Start Retencion.fillCuerpoDocumento()"); 
		errorMessages.setLength(0);

		JSONObject cuerpoDocumentoItemsJson = factoryInput.getJSONObject(CUERPODOCUMENTO);
		JSONArray cuerpoDocumentoArrayJson = cuerpoDocumentoItemsJson.getJSONArray(CUERPODOCUMENTO);
	
		for (int i=0; i< cuerpoDocumentoArrayJson.length(); i++) { 
			JSONObject cuerpoDocumentoItemJson = cuerpoDocumentoArrayJson.getJSONObject(i);
			CuerpoDocumentoItemRetencion cuerpoDocumentoItemRetencion = new CuerpoDocumentoItemRetencion();
//			try {cuerpoDocumentoItemRetencion.setNumItem(cuerpoDocumentoItemJson.getInt(NUMITEM));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setTipoItem(cuerpoDocumentoItemJson.getInt(TIPOITEM));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setNumeroDocumento(cuerpoDocumentoItemJson.getString(NUMERODOCUMENTO));} 	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setCantidad(cuerpoDocumentoItemJson.getBigDecimal(CANTIDAD));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setCodigo(cuerpoDocumentoItemJson.getString(CODIGO));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setCodTributo(null);} 																	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setUniMedida(cuerpoDocumentoItemJson.getInt(UNIMEDIDA));} 				catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setDescripcion(cuerpoDocumentoItemJson.getString(DESCRIPCION));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setPrecioUni(cuerpoDocumentoItemJson.getBigDecimal(PRECIOUNI));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setMontoDescu(cuerpoDocumentoItemJson.getBigDecimal(MONTODESCU));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setVentaNoSuj(cuerpoDocumentoItemJson.getBigDecimal(VENTANOSUJ));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setVentaExenta(cuerpoDocumentoItemJson.getBigDecimal(VENTAEXENTA));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setVentaGravada(cuerpoDocumentoItemJson.getBigDecimal(VENTAGRAVADA));} 	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setTributos(null);} 																		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setPsv(cuerpoDocumentoItemJson.getBigDecimal(PSV));} 						catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setNoGravado(cuerpoDocumentoItemJson.getBigDecimal(NOGRAVADO));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemRetencion.setIvaItem(cuerpoDocumentoItemJson.getBigDecimal(IVAITEM));} 				catch (Exception e) {errorMessages.append(e);}

			cuerpoDocumento.add(cuerpoDocumentoItemRetencion);						
		}

		System.out.println("End Retencion.fillCuerpoDocumento()"); 
		return errorMessages;
	}

	/**
	 * @return the resumen
	 */
	public ResumenRetencion getResumen() {
		return resumen;
	}

	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(ResumenRetencion resumen) {
		this.resumen = (ResumenRetencion) resumen;
	}

	
	public StringBuffer fillResumen(JSONObject factoryInput) {
		System.out.println("Start Retencion.fillResumen()"); 
		errorMessages.setLength(0);		
		JSONObject resumenJson = factoryInput.getJSONObject(RESUMEN);		

		try {resumen.setTotalIVAretenido(resumenJson.getBigDecimal(TOTALIVARETENIDO));} 					catch (Exception e) {errorMessages.append(e);}

		System.out.println("End Retencion.fillResumen()"); 
		return errorMessages;
	}

	/**
	 * @return the extension
	 */
	public ExtensionRetencion getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(ExtensionRetencion extension) {
		this.extension = extension;
	}

	/**
	 * @return the apendice
	 */
	public List<ApendiceItemRetencion> getApendice() {
		return apendice;
	}

	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(List<ApendiceItemRetencion> apendice) {
		this.apendice = apendice;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
