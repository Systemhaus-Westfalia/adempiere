/**
 * 
 */
package org.shw.einvoice.es.fefsefacturanosujeto;
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
import org.shw.einvoice.es.util.pojo.EDocument;
import org.shw.einvoice.es.util.pojo.EDocumentUtils;
import org.shw.einvoice.es.util.pojo.PagosItem;
import org.shw.einvoice.es.util.pojo.TributosItem;


/**
 * 
 */
public class FacturaNoSujeto extends EDocument {
	static final int MINIMUM_TOTOTAL_OF_OPERATION = 1095;
	static final int CUERPODOCUMENTO_MAXIMUM_ITEMS = 2000;

	static final String VALIDATION_RESUMEN_OR_MONTO_IS_NULL   = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'getResumen() y getMontoTotalOperacion()' no debe ser ='null'";
	static final String VALIDATION_TIPODOCUMENTO_IS_NULL      = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'tipoDocumento' no debe ser ='null'";
	static final String VALIDATION_NUMDOCUMENTO_IS_NULL       = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'numDocumento' no debe ser ='null'";
	static final String VALIDATION_NOMBRE_IS_NULL             = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'NOMBRE' no debe ser ='null'";
	static final String VALIDATION_CUERPODOCUMENTO_MAX_ITEMS  = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'cuerpoDocumento' debe  contener máximo " + CUERPODOCUMENTO_MAXIMUM_ITEMS + " elementos";
	IdentificacionFacturaNoSujeto identificacion;
	EmisorFacturaNoSujeto emisor;
	ReceptorFacturaNoSujeto receptor;
	List<CuerpoDocumentoItemFacturaNoSujeto> cuerpoDocumento;
	ResumenFacturaNoSujeto resumen;
	SujetoExcluidoFacturaNoSujeto sujetoExcluido;

	ExtensionFacturaNoSujeto extension = null;
	List<ApendiceItemFacturaNoSujeto> apendice=null;  // null allowed
	List<DocumentoRelacionadoItemFacturaNoSujeto> documentoRelacionado = null;
	List<OtrosDocumentosItemFacturaNoSujeto> otrosDocumentos = null;
	VentaTerceroFacturaNoSujeto ventaTercero = null;

	/**
	 * No parameters
	 */
	public FacturaNoSujeto() {
		this.identificacion       			= new IdentificacionFacturaNoSujeto();
		this.emisor               			= new EmisorFacturaNoSujeto();
		this.receptor             			= new ReceptorFacturaNoSujeto();
	    this.cuerpoDocumento      			= new ArrayList<CuerpoDocumentoItemFacturaNoSujeto>();
		this.resumen              			= new ResumenFacturaNoSujeto();
		this.sujetoExcluido 				= new SujetoExcluidoFacturaNoSujeto();
		
		//leer
		this.extension						= new ExtensionFacturaNoSujeto();
		this.apendice						= new ArrayList<ApendiceItemFacturaNoSujeto>();
		this.documentoRelacionado			= new ArrayList<DocumentoRelacionadoItemFacturaNoSujeto>();
		this.ventaTercero					= new VentaTerceroFacturaNoSujeto();
		this.otrosDocumentos				= new ArrayList<OtrosDocumentosItemFacturaNoSujeto>();}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {		
		return EDocumentUtils.VALIDATION_RESULT_OK;
	}

	/**
	 * @return the identificacion
	 */
	public IdentificacionFacturaNoSujeto getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(IdentificacionFacturaNoSujeto identificacion) {
		this.identificacion = identificacion;
	}


	/**
	 * @param identificacion the (IdentificacionFactura) identificacion to set
	 */
	public StringBuffer fillIdentification(JSONObject factoryInput) {
		System.out.println("Start FacturaNoSujeto.fillIdentificacion()");

		JSONObject identificationJson = factoryInput.getJSONObject(IDENTIFICACION);
		try {identificacion.setMotivoContin(identificationJson.getString(MOTIVOCONTIN));} 			catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setTipoContingencia(identificationJson.getInt(TIPOCONTINGENCIA));} 		catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setNumeroControl(identificationJson.getString(NUMEROCONTROL));} 		catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setCodigoGeneracion(identificationJson.getString(CODIGOGENERACION));} 	catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setTipoModelo(identificationJson.getInt(TIPOMODELO));} 					catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setTipoOperacion(identificationJson.getInt(TIPOOPERACION));} 			catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setFecEmi(identificationJson.getString(FECEMI));} 						catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setHorEmi(identificationJson.getString(HOREMI));} 						catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setTipoMoneda(identificationJson.getString(TIPOMONEDA));} 				catch (Exception e) {errorMessages.append(e);}
		try {identificacion.setAmbiente(identificationJson.getString(AMBIENTE));} 					catch (Exception e) {errorMessages.append(e);}

		System.out.println("End FacturaNoSujeto.fillIdentificacion()");
		return errorMessages;
	}

	public List<DocumentoRelacionadoItemFacturaNoSujeto> getDocumentoRelacionado() {
		return documentoRelacionado;
	}

	public void setDocumentoRelacionado(List<DocumentoRelacionadoItemFacturaNoSujeto> documentoRelacionado) {
		this.documentoRelacionado = documentoRelacionado;
	}

	/**
	 * @return the emisor
	 */
	public EmisorFacturaNoSujeto getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorFacturaNoSujeto emisor) {
		this.emisor = emisor;
	}

	public StringBuffer fillEmisor(JSONObject factoryInput) {
		System.out.println("Start FacturaNoSujeto.fillEmisor()");

		JSONObject emisorJson = factoryInput.getJSONObject(EMISOR);
		try {emisor.setNit(emisorJson.getString(NIT));} 									catch (Exception e) {errorMessages.append(e);}
		try {emisor.setNrc(emisorJson.getString(NRC));} 									catch (Exception e) {errorMessages.append(e);}
		try {emisor.setNombre(emisorJson.getString(NOMBRE));} 								catch (Exception e) {errorMessages.append(e);}
		try {emisor.setCodActividad(emisorJson.getString(CODACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
		try {emisor.setDescActividad(emisorJson.getString(DESCACTIVIDAD));} 				catch (Exception e) {errorMessages.append(e);}
		try {emisor.setNombreComercial(emisorJson.getString(NOMBRECOMERCIAL));} 			catch (Exception e) {errorMessages.append(e);}		
		try {emisor.setTipoEstablecimiento(emisorJson.getString(TIPOESTABLECIMIENTO));}		catch (Exception e) {errorMessages.append(e);}	

		JSONObject jsonDireccion = emisorJson.getJSONObject(DIRECCION);
		try {emisor.getDireccion().setDepartamento(jsonDireccion.getString(DEPARTAMENTO));}	catch (Exception e) {errorMessages.append(e);}
		try {emisor.getDireccion().setMunicipio(jsonDireccion.getString(MUNICIPIO));} 		catch (Exception e) {errorMessages.append(e);}
		try {emisor.getDireccion().setComplemento(jsonDireccion.getString(COMPLEMENTO));} 	catch (Exception e) {errorMessages.append(e);}

		try {emisor.setTelefono(emisorJson.getString(TELEFONO));} 							catch (Exception e) {errorMessages.append(e);}
		try {emisor.setCorreo(emisorJson.getString(CORREO));} 								catch (Exception e) {errorMessages.append(e);}

		System.out.println("End FacturaNoSujeto.fillEmisor()");
		return errorMessages;
	}

	/**
	 * @return the receptor
	 */
	public ReceptorFacturaNoSujeto getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorFacturaNoSujeto receptor) {
		this.receptor = receptor;
	}

	public StringBuffer fillReceptor(JSONObject factoryInput) {
		System.out.println("Start CreditoFiscal.fillReceptor()"); 

		
		JSONObject receptorJson = factoryInput.getJSONObject(RECEPTOR);
		try {receptor.setNit(receptorJson.getString(NIT));} 									catch (Exception e) {errorMessages.append(e);}
		try {receptor.setNrc(receptorJson.getString(NRC));} 									catch (Exception e) {errorMessages.append(e);}
		try {receptor.setNombre(receptorJson.getString(NOMBRE));} 								catch (Exception e) {errorMessages.append(e);}
		try {receptor.setCodActividad(receptorJson.getString(CODACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
		try {receptor.setDescActividad(receptorJson.getString(DESCACTIVIDAD));} 				catch (Exception e) {errorMessages.append(e);}

		JSONObject jsonDireccion = receptorJson.getJSONObject(DIRECCION);
		try {receptor.getDireccion().setDepartamento(jsonDireccion.getString(DEPARTAMENTO));}	catch (Exception e) {errorMessages.append(e);}
		try {receptor.getDireccion().setMunicipio(jsonDireccion.getString(MUNICIPIO));} 		catch (Exception e) {errorMessages.append(e);}
		try {receptor.getDireccion().setComplemento(jsonDireccion.getString(COMPLEMENTO));} 	catch (Exception e) {errorMessages.append(e);}

		try {receptor.setTelefono(receptorJson.getString(TELEFONO));} 							catch (Exception e) {errorMessages.append(e);}
		try {receptor.setCorreo(receptorJson.getString(CORREO));} 								catch (Exception e) {errorMessages.append(e);}

		System.out.println("End Factura.fillReceptor()"); 
		return errorMessages;
	}
	
	public StringBuffer fillSujetoExcluido(JSONObject factoryInput) {
		System.out.println("Start CreditoFiscal.fillReceptor()"); 

		
		JSONObject sujetoExcluidoJson = factoryInput.getJSONObject(RECEPTOR);
		try {sujetoExcluido.setNumDocumento(sujetoExcluidoJson.getString(NUMDOCUMENTO));} 					catch (Exception e) {errorMessages.append(e);}
		try {sujetoExcluido.setNombre(sujetoExcluidoJson.getString(NOMBRE));} 								catch (Exception e) {errorMessages.append(e);}
		try {sujetoExcluido.setCodActividad(sujetoExcluidoJson.getString(CODACTIVIDAD));} 					catch (Exception e) {errorMessages.append(e);}
		try {sujetoExcluido.setDescActividad(sujetoExcluidoJson.getString(DESCACTIVIDAD));} 				catch (Exception e) {errorMessages.append(e);}
		try {sujetoExcluido.setTipoDocumento(sujetoExcluidoJson.getString(DESCACTIVIDAD));} 				catch (Exception e) {errorMessages.append(e);}

		JSONObject jsonDireccion = sujetoExcluidoJson.getJSONObject(DIRECCION);
		try {sujetoExcluido.getDireccion().setDepartamento(jsonDireccion.getString(DEPARTAMENTO));}			catch (Exception e) {errorMessages.append(e);}
		try {sujetoExcluido.getDireccion().setMunicipio(jsonDireccion.getString(MUNICIPIO));} 				catch (Exception e) {errorMessages.append(e);}
		try {sujetoExcluido.getDireccion().setComplemento(jsonDireccion.getString(COMPLEMENTO));} 			catch (Exception e) {errorMessages.append(e);}

		try {sujetoExcluido.setTelefono(sujetoExcluidoJson.getString(TELEFONO));} 							catch (Exception e) {errorMessages.append(e);}
		try {sujetoExcluido.setCorreo(sujetoExcluidoJson.getString(CORREO));} 								catch (Exception e) {errorMessages.append(e);}

		System.out.println("End Factura.fillReceptor()"); 
		return errorMessages;
	}


	/**
	 * @return the ventaTercero
	 */
	public VentaTerceroFacturaNoSujeto getVentaTercero() {
		return ventaTercero;
	}

	/**
	 * @param ventaTercero the ventaTercero to set
	 */
	public void setVentaTercero(VentaTerceroFacturaNoSujeto ventaTercero) {
		this.ventaTercero = ventaTercero;
	}

	/**
	 * @return the cuerpoDocumento
	 */
	public List<CuerpoDocumentoItemFacturaNoSujeto> getCuerpoDocumento() {
		return cuerpoDocumento;
	}

	public void setCuerpoDocumento(List<CuerpoDocumentoItemFacturaNoSujeto> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}


	public StringBuffer fillCuerpoDocumento(JSONObject factoryInput) {
		System.out.println("Start FacturaNoSujeto.fillCuerpoDocumento()");

		JSONObject cuerpoDocumentoItemsJson = factoryInput.getJSONObject(CUERPODOCUMENTO);
		JSONArray cuerpoDocumentoArrayJson = cuerpoDocumentoItemsJson.getJSONArray(CUERPODOCUMENTO);
	
		for (int i=0; i< cuerpoDocumentoArrayJson.length(); i++) { 
			JSONObject cuerpoDocumentoItemJson = cuerpoDocumentoArrayJson.getJSONObject(i);
			CuerpoDocumentoItemFacturaNoSujeto cuerpoDocumentoItemFacturaNoSujeto = new CuerpoDocumentoItemFacturaNoSujeto();
			try {cuerpoDocumentoItemFacturaNoSujeto.setNumItem(cuerpoDocumentoItemJson.getInt(NUMITEM));} 					catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setTipoItem(cuerpoDocumentoItemJson.getInt(TIPOITEM));} 					catch (Exception e) {errorMessages.append(e);}
			//try {cuerpoDocumentoItemFacturaNoSujeto.setNumeroDocumento(cuerpoDocumentoItemJson.getString(NUMERODOCUMENTO));} 	catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setCantidad(cuerpoDocumentoItemJson.getBigDecimal(CANTIDAD));} 			catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setCodigo(cuerpoDocumentoItemJson.getString(CODIGO));} 					catch (Exception e) {errorMessages.append(e);}
			
			if (cuerpoDocumentoItemJson.getString(CODTRIBUTO).equals(""))
				try {cuerpoDocumentoItemFacturaNoSujeto.setCodTributo(null);} 												catch (Exception e) {errorMessages.append(e);}
			else
				try {cuerpoDocumentoItemFacturaNoSujeto.setCodTributo(cuerpoDocumentoItemJson.getString(CODTRIBUTO));} 		catch (Exception e) {errorMessages.append(e);}

			try {cuerpoDocumentoItemFacturaNoSujeto.setUniMedida(cuerpoDocumentoItemJson.getInt(UNIMEDIDA));} 				catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setDescripcion(cuerpoDocumentoItemJson.getString(DESCRIPCION));} 			catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setPrecioUni(cuerpoDocumentoItemJson.getBigDecimal(PRECIOUNI));} 			catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setMontoDescu(cuerpoDocumentoItemJson.getBigDecimal(MONTODESCU));} 		catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setVentaNoSuj(cuerpoDocumentoItemJson.getBigDecimal(VENTANOSUJ));} 		catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setVentaExenta(cuerpoDocumentoItemJson.getBigDecimal(VENTAEXENTA));} 		catch (Exception e) {errorMessages.append(e);}
			try {cuerpoDocumentoItemFacturaNoSujeto.setVentaGravada(cuerpoDocumentoItemJson.getBigDecimal(VENTAGRAVADA));} 	catch (Exception e) {errorMessages.append(e);}
			
			JSONArray tributosArrayJson = cuerpoDocumentoItemJson.getJSONArray(TRIBUTOS);
			for (int j=0; j< tributosArrayJson.length(); j++) { 
				String tributosItemJson = tributosArrayJson.getString(j);
				try {cuerpoDocumentoItemFacturaNoSujeto.getTributos().add(tributosItemJson);} 								catch (Exception e) {errorMessages.append(e);}	
			}			

			cuerpoDocumento.add(cuerpoDocumentoItemFacturaNoSujeto);						
		}

		System.out.println("End FacturaNoSujeto.fillCuerpoDocumento()"); 
		return errorMessages;
	}
	
	public StringBuffer fillDocumentosRelacionados(JSONObject factoryInput) {
		System.out.println("Start FacturaNoSujeto.fillCuerpoDocumento()");

		JSONObject documentosRelacionadosItemsJson = factoryInput.getJSONObject(DOCUMENTORELACIONADO);
		JSONArray DocumentosRelacionadosArrayJson = documentosRelacionadosItemsJson.getJSONArray(DOCUMENTORELACIONADO);
	
		for (int i=0; i< DocumentosRelacionadosArrayJson.length(); i++) { 
			JSONObject DocRelaciondadosItemJson = DocumentosRelacionadosArrayJson.getJSONObject(i);
			DocumentoRelacionadoItemFacturaNoSujeto documentoRelacionadoItem = new DocumentoRelacionadoItemFacturaNoSujeto();
			try {documentoRelacionadoItem.setNumeroDocumento(DocRelaciondadosItemJson.getString(NUMERODOCUMENTO));} 			catch (Exception e) {errorMessages.append(e);}
			try {documentoRelacionadoItem.setTipoDocumento(DocRelaciondadosItemJson.getString(TIPODOCUMENTO));} 				catch (Exception e) {errorMessages.append(e);}
			try {documentoRelacionadoItem.setTipoGeneracion(DocRelaciondadosItemJson.getInt(TIPOGENERACION));} 					catch (Exception e) {errorMessages.append(e);}
			try {documentoRelacionadoItem.setFechaEmision(DocRelaciondadosItemJson.getString(FECEMI));} 						catch (Exception e) {errorMessages.append(e);}
					

			documentoRelacionado.add(documentoRelacionadoItem);						
		}

		System.out.println("End FacturaNoSujeto.fillCuerpoDocumento()"); 
		return errorMessages;
	}

	/**
	 * @return the resumen
	 */
	public ResumenFacturaNoSujeto getResumen() {
		return resumen;
	}

	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(ResumenFacturaNoSujeto resumen) {
		this.resumen = resumen;
	}

	public StringBuffer fillResumen(JSONObject factoryInput) {
		System.out.println("Start CreditoFiscal.fillResumen()");
		JSONObject resumenJson = factoryInput.getJSONObject(RESUMEN);

		JSONArray tributosArrayJson = resumenJson.getJSONArray(TRIBUTOS);	
		for (int i=0; i< tributosArrayJson.length(); i++) {
			JSONObject tributosItemJson = tributosArrayJson.getJSONObject(i);
			TributosItem tributosItemCreditoFiscal = new TributosItem();
			try {tributosItemCreditoFiscal.setCodigo(tributosItemJson.getString(CODIGO));} 				catch (Exception e) {errorMessages.append(e);}
			try {tributosItemCreditoFiscal.setDescripcion(tributosItemJson.getString(DESCRIPCION));}	catch (Exception e) {errorMessages.append(e);}
			try {tributosItemCreditoFiscal.setValor(tributosItemJson.getBigDecimal(VALOR));} 			catch (Exception e) {errorMessages.append(e);}
			resumen.getTributos().add(tributosItemCreditoFiscal);						
		}

		try {resumen.setTotalNoSuj(resumenJson.getBigDecimal(TOTALNOSUJ));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumen.setTotalExenta(resumenJson.getBigDecimal(TOTALEXENTA));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumen.setTotalGravada(resumenJson.getBigDecimal(TOTALGRAVADA));} 				catch (Exception e) {errorMessages.append(e);}
		try {resumen.setSubTotalVentas(resumenJson.getBigDecimal(SUBTOTALVENTAS));} 			catch (Exception e) {errorMessages.append(e);}
		try {resumen.setDescuNoSuj(resumenJson.getBigDecimal(DESCUNOSUJ));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumen.setDescuExenta(resumenJson.getBigDecimal(DESCUEXENTA));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumen.setDescuGravada(resumenJson.getBigDecimal(DESCUGRAVADA));} 				catch (Exception e) {errorMessages.append(e);}
		try {resumen.setSubTotal(resumenJson.getBigDecimal(SUBTOTAL));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumen.setIvaRete1(resumenJson.getBigDecimal(IVARETE1));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumen.setMontoTotalOperacion(resumenJson.getBigDecimal(MONTOTOTALOPERACION));} 	catch (Exception e) {errorMessages.append(e);}
		try {resumen.setTotalLetras(resumenJson.getString(TOTALLETRAS));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumen.setCondicionOperacion(resumenJson.getInt(CONDICIONOPERACION));} 			catch (Exception e) {errorMessages.append(e);}
		try {resumen.setTotalDescu(resumenJson.getBigDecimal(TOTALDESCU));} 					catch (Exception e) {errorMessages.append(e);}
		try {resumen.setReteRenta(resumenJson.getBigDecimal(RETERENTA));} 						catch (Exception e) {errorMessages.append(e);}
		try {resumen.setIvaPerci1(resumenJson.getBigDecimal(IVAPERCI1));} 						catch (Exception e) {errorMessages.append(e);}

		JSONArray pagosItemsJson = resumenJson.getJSONArray(PAGOS);
		JSONObject pagosItemJson = pagosItemsJson.getJSONObject(0);

		PagosItem newPagosItem = new PagosItem();
		try {newPagosItem.setCodigo(pagosItemJson.getString(CODIGO));} 				catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setMontoPago(pagosItemJson.getBigDecimal(MONTOPAGO));}	catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setReferencia(pagosItemJson.getString(REFERENCIA));} 		catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setPlazo(pagosItemJson.getString(PLAZO));} 				catch (Exception e) {errorMessages.append(e);}
		try {newPagosItem.setPeriodo(pagosItemJson.getInt(PERIODO));} 				catch (Exception e) {errorMessages.append(e);}


		System.out.println("End CreditoFiscal.fillResumen()"); 
		return errorMessages;
	}

	/**
	 * @return the extension
	 */
	public ExtensionFacturaNoSujeto getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(ExtensionFacturaNoSujeto extension) {
		this.extension = extension;
	}

	/**
	 * @return the apendice
	 */
	public List<ApendiceItemFacturaNoSujeto> getApendice() {
		return apendice;
	}

	public void setApendice(List<ApendiceItemFacturaNoSujeto> apendice) {
		this.apendice = apendice;
	}


	public SujetoExcluidoFacturaNoSujeto getSujetoExcluidoFacturaNoSujeto() {
		return sujetoExcluido;
	}

	public void setSujetoExcluidoFacturaNoSujeto(SujetoExcluidoFacturaNoSujeto sujetoExcluidoFacturaNoSujeto) {
		this.sujetoExcluido = sujetoExcluidoFacturaNoSujeto;
	}

	public List<OtrosDocumentosItemFacturaNoSujeto> getOtrosDocumentos() {
		return otrosDocumentos;
	}

	public void setOtrosDocumentos(List<OtrosDocumentosItemFacturaNoSujeto> otrosDocumentos) {
		this.otrosDocumentos = otrosDocumentos;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}	
}
