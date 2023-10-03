/**
 * 
 */
package org.shw.einvoice.es.factory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ApendiceItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.CuerpoDocumentoItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.EmisorFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.IdentificacionFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.OtrosDocumentosItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ReceptorFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ResumenFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.VentaTerceroFacturaExportacion;
import org.shw.einvoice.es.util.pojo.EDocument;
import org.shw.einvoice.es.util.pojo.PagosItem;


/**
 * 
 */
public class FacturaExportacion extends EDocument {
	
	static final int OTROSDOCUMENTOS_MAXIMUM_ITEMS = 20;
	static final int CUERPODOCUMENTO_MAXIMUM_ITEMS = 2000;

	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_RESUMEN_OR_MONTO_IS_NULL  = "Documento: Factura, clase: FacturaExportacion. Validacion falló: valor de 'getResumen() y getMontoTotalOperacion()' no debe ser ='null'";
	static final String VALIDATION_CORREO_IS_NULL            = "Documento: Factura de Exportacion, clase: FacturaExportacion. Validacion falló: valor de 'receptor.correo' no debe ser ='null'";
	static final String VALIDATION_OTROSDOCUMENTOS_MAXITEMS  = "Documento: Factura de Exportacion, clase: FacturaExportacion. Validacion falló: valor de 'otrosDocumentos' debe contemner entre 1 y " + 
																OTROSDOCUMENTOS_MAXIMUM_ITEMS + " elementos";
	static final String VALIDATION_CUERPODOCUMENTO_MAXITEMS  = "Documento: Factura de Exportacion, clase: FacturaExportacion. Validacion falló: valor de 'cuerpoDocumento' debe contemner entre 1 y " + 
																CUERPODOCUMENTO_MAXIMUM_ITEMS + " elementos";
	
	IdentificacionFacturaExportacion identificacion;
	EmisorFacturaExportacion emisor;
	ReceptorFacturaExportacion receptor;
	List<OtrosDocumentosItemFacturaExportacion> otrosDocumentos = null;
	VentaTerceroFacturaExportacion ventaTercero = null;
	List<CuerpoDocumentoItemFacturaExportacion> cuerpoDocumento;
	ResumenFacturaExportacion resumen;
	List<ApendiceItemFacturaExportacion> apendice=null;  // null allowed
	
	/**
	 * No parameters
	 */
	public FacturaExportacion() {
		
		this.identificacion       = new IdentificacionFacturaExportacion();
		this.emisor               = new EmisorFacturaExportacion();
		this.receptor             = new ReceptorFacturaExportacion();
	    this.otrosDocumentos      = new ArrayList<OtrosDocumentosItemFacturaExportacion>();		
		this.ventaTercero         = new VentaTerceroFacturaExportacion();
		this.cuerpoDocumento      = new ArrayList<CuerpoDocumentoItemFacturaExportacion>();
		this.resumen              = new ResumenFacturaExportacion();
	    this.apendice             = new ArrayList<ApendiceItemFacturaExportacion>();
	}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {
		System.out.println("Factura de Exportacion: start validating values");

		if( (getResumen()==null) || (getResumen().getMontoTotalOperacion()==null) ) {
			return VALIDATION_RESUMEN_OR_MONTO_IS_NULL;
		}
		
		if(getResumen().getMontoTotalOperacion().compareTo(BigDecimal.valueOf(10000-1))==1) {
			if ( getReceptor().getCorreo()== null)
				return VALIDATION_CORREO_IS_NULL;
		} 
		
		if( (getOtrosDocumentos()!=null) && ( (getOtrosDocumentos().size()==0) || (getOtrosDocumentos().size()>OTROSDOCUMENTOS_MAXIMUM_ITEMS) ) ) {
			return VALIDATION_OTROSDOCUMENTOS_MAXITEMS;
		}
		
		if( (getCuerpoDocumento()==null) || (getCuerpoDocumento().size()==0) || (getCuerpoDocumento().size()>CUERPODOCUMENTO_MAXIMUM_ITEMS) ) {
			return VALIDATION_CUERPODOCUMENTO_MAXITEMS;
		}

		System.out.println("Factura de Exportacion: end validating values");
		return VALIDATION_RESULT_OK;
	}


	/**
	 * @return the identificacion
	 */
	public IdentificacionFacturaExportacion getIdentificacion() {
		return identificacion;
	}


	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionFacturaExportacion identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @param identificacion the (IdentificacionFacturaExportacion) identificacion to set
	 */
	public StringBuffer fillIdentification(JSONObject factoryInput) {
		System.out.println("Start FacturaExportacion.fillIdentificacion()"); 
		errorMessages.setLength(0);

		JSONObject identificationJson = factoryInput.getJSONObject(IDENTIFICACION);
//		try {identificacion.setNumeroControl(identificationJson.getString(NUMEROCONTROL));} 		catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setCodigoGeneracion(identificationJson.getString(CODIGOGENERACION));} 	catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoModelo(identificationJson.getInt(TIPOMODELO));} 					catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoOperacion(identificationJson.getInt(TIPOOPERACION));} 			catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setFecEmi(identificationJson.getString(FECEMI));} 						catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setHorEmi(identificationJson.getString(HOREMI));} 						catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setTipoMoneda(identificationJson.getString(TIPOMONEDA));} 				catch (Exception e) {errorMessages.append(e);}
//		try {identificacion.setAmbiente(identificationJson.getString(AMBIENTE));} 					catch (Exception e) {errorMessages.append(e);}

		System.out.println("End FacturaExportacion.fillIdentificacion()");
		return errorMessages;
	}


	/**
	 * @return the emisor
	 */
	public EmisorFacturaExportacion getEmisor() {
		return emisor;
	}


	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorFacturaExportacion emisor) {
		this.emisor = emisor;
	}
	
	public StringBuffer fillEmisor(JSONObject factoryInput) {
		System.out.println("Start FacturaExportacion.fillEmisor()"); 
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

		System.out.println("End FacturaExportacion.fillEmisor()");
		return errorMessages;
	}


	/**
	 * @return the receptor
	 */
	public ReceptorFacturaExportacion getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorFacturaExportacion receptor) {
		this.receptor = receptor;
	}

	public StringBuffer fillReceptor(JSONObject factoryInput) {
		System.out.println("Start FacturaExportacion.fillReceptor()"); 
		errorMessages.setLength(0);

		JSONObject receptorJson = factoryInput.getJSONObject(RECEPTOR);
		try {emisor.setNit(receptorJson.getString(NIT));} 									catch (Exception e) {errorMessages.append(e);}
		
		System.out.println("End FacturaExportacion.fillReceptor()");
		return errorMessages;
	}

	/**
	 * @return the otrosDocumentos
	 */
	public List<OtrosDocumentosItemFacturaExportacion> getOtrosDocumentos() {
		return otrosDocumentos;
	}


	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(List<OtrosDocumentosItemFacturaExportacion> otrosDocumentos) {
		this.otrosDocumentos = otrosDocumentos;
	}


	/**
	 * @return the ventaTercero
	 */
	public VentaTerceroFacturaExportacion getVentaTercero() {
		return ventaTercero;
	}


	/**
	 * @param ventaTercero the ventaTercero to set
	 */
	public void setVentaTercero(VentaTerceroFacturaExportacion ventaTercero) {
		this.ventaTercero = ventaTercero;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	public List<CuerpoDocumentoItemFacturaExportacion> getCuerpoDocumento() {
		return cuerpoDocumento;
	}


	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItemFacturaExportacion> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}


	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput) {
		System.out.println("Start CreditoFiscal.fillCuerpoDocumento()"); 
		errorMessages.setLength(0);

		JSONObject cuerpoDocumentoItemsJson = factoryInput.getJSONObject(CUERPODOCUMENTO);
		JSONArray cuerpoDocumentoArrayJson = cuerpoDocumentoItemsJson.getJSONArray(CUERPODOCUMENTO);
	
		for (int i=0; i< cuerpoDocumentoArrayJson.length(); i++) { 
			JSONObject cuerpoDocumentoItemJson = cuerpoDocumentoArrayJson.getJSONObject(i);
			CuerpoDocumentoItemFacturaExportacion cuerpoDocumentoItemFacturaExportacion = new CuerpoDocumentoItemFacturaExportacion();
			try {cuerpoDocumentoItemFacturaExportacion.setNumItem(cuerpoDocumentoItemJson.getInt(NUMITEM));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setTipoItem(cuerpoDocumentoItemJson.getInt(TIPOITEM));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setNumeroDocumento(cuerpoDocumentoItemJson.getString(NUMERODOCUMENTO));} 	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setCantidad(cuerpoDocumentoItemJson.getBigDecimal(CANTIDAD));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setCodigo(cuerpoDocumentoItemJson.getString(CODIGO));} 					catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setCodTributo(null);} 																	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setUniMedida(cuerpoDocumentoItemJson.getInt(UNIMEDIDA));} 				catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setDescripcion(cuerpoDocumentoItemJson.getString(DESCRIPCION));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setPrecioUni(cuerpoDocumentoItemJson.getBigDecimal(PRECIOUNI));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setMontoDescu(cuerpoDocumentoItemJson.getBigDecimal(MONTODESCU));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setVentaNoSuj(cuerpoDocumentoItemJson.getBigDecimal(VENTANOSUJ));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setVentaExenta(cuerpoDocumentoItemJson.getBigDecimal(VENTAEXENTA));} 		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setVentaGravada(cuerpoDocumentoItemJson.getBigDecimal(VENTAGRAVADA));} 	catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setTributos(null);} 																		catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setPsv(cuerpoDocumentoItemJson.getBigDecimal(PSV));} 						catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setNoGravado(cuerpoDocumentoItemJson.getBigDecimal(NOGRAVADO));} 			catch (Exception e) {errorMessages.append(e);}
//			try {cuerpoDocumentoItemFacturaExportacion.setIvaItem(cuerpoDocumentoItemJson.getBigDecimal(IVAITEM));} 				catch (Exception e) {errorMessages.append(e);}

			cuerpoDocumento.add(cuerpoDocumentoItemFacturaExportacion);						
		}

		System.out.println("End CreditoFiscal.fillCuerpoDocumento()"); 
		return errorMessages;
	}

	/**
	 * @return the resumen
	 */
	public ResumenFacturaExportacion getResumen() {
		return resumen;
	}


	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(ResumenFacturaExportacion resumen) {
		this.resumen = resumen;
	}

	public StringBuffer fillResumen(JSONObject factoryInput) {
		System.out.println("Start FacturaExportacion.fillResumen()"); 
		errorMessages.setLength(0);		
		JSONObject resumenJson = factoryInput.getJSONObject(RESUMEN);		

//		try {resumen.setTotalNoSuj(resumenJson.getBigDecimal(TOTALNOSUJ));} 					catch (Exception e) {errorMessages.append(e);}
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

		JSONArray pagosItemsJson = resumenJson.getJSONArray(PAGOS);
		JSONObject pagosItemJson = pagosItemsJson.getJSONObject(0);

		PagosItem newPagosItem = new PagosItem();
		try {newPagosItem.setCodigo(pagosItemJson.getString(CODIGO));} 			catch (Exception e) {errorMessages.append(e);}
//		try {newPagosItem.setMontoPago(pagosItemJson.getBigDecimal(MONTOPAGO));}	catch (Exception e) {errorMessages.append(e);}
//		try {newPagosItem.setReferencia(pagosItemJson.getString(REFERENCIA));} 	catch (Exception e) {errorMessages.append(e);}
//		try {newPagosItem.setPlazo(pagosItemJson.getString(PLAZO));} 			catch (Exception e) {errorMessages.append(e);}
//		try {newPagosItem.setPeriodo(pagosItemJson.getInt(PERIODO));} 			catch (Exception e) {errorMessages.append(e);}

		resumen.getPagos().add(newPagosItem);

		System.out.println("End FacturaExportacion.fillResumen()"); 
		return errorMessages;
	}


	/**
	 * @return the apendice
	 */
	public List<ApendiceItemFacturaExportacion> getApendice() {
		return apendice;
	}


	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(List<ApendiceItemFacturaExportacion> apendice) {
		this.apendice = apendice;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	
}
