/**
 * 
 */
package org.shw.einvoice.es.factory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ApendiceItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.CuerpoDocumentoItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.EmisorFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.IdentificacionFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.OtrosDocumentosItemFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ReceptorFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.ResumenFacturaExportacion;
import org.shw.einvoice.es.fefexfacturaexportacionv1.VentaTerceroFacturaExportacion;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.CuerpoDocumentoItem;
import org.shw.einvoice.es.util.pojo.Documento;
import org.shw.einvoice.es.util.pojo.DocumentoRelacionadoItem;
import org.shw.einvoice.es.util.pojo.Emisor;
import org.shw.einvoice.es.util.pojo.Extension;
import org.shw.einvoice.es.util.pojo.Identificacion;
import org.shw.einvoice.es.util.pojo.Motivo;
import org.shw.einvoice.es.util.pojo.OtrosDocumentosItem;
import org.shw.einvoice.es.util.pojo.Receptor;
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.VentaTercero;


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
	
	FacturaExportacionFactory facturaExportacionFactory;  // This must be eliminated from JSON production.

	/**
	 * No parameters
	 */
	@SuppressWarnings("unchecked")
	public FacturaExportacion() {
		List<?> tmpList;
		
		this.identificacion       = (IdentificacionFacturaExportacion) facturaExportacionFactory.createIdentificacion();
		this.emisor               = (EmisorFacturaExportacion) facturaExportacionFactory.createEmisor();
		this.receptor             = (ReceptorFacturaExportacion) facturaExportacionFactory.createReceptor();
		
		tmpList = facturaExportacionFactory.createOtrosDocumentos();
	    this.otrosDocumentos      = (List<OtrosDocumentosItemFacturaExportacion>) tmpList;
		
		this.ventaTercero         = (VentaTerceroFacturaExportacion) facturaExportacionFactory.createVentaTercero();

		tmpList = facturaExportacionFactory.createCuerpoDocumento();
	    this.cuerpoDocumento      = (List<CuerpoDocumentoItemFacturaExportacion>) tmpList;
				
		this.resumen              = (ResumenFacturaExportacion) facturaExportacionFactory.createResumen();
		
		tmpList = facturaExportacionFactory.createApendice();
	    this.apendice             = (List<ApendiceItemFacturaExportacion>) tmpList;
	}
	
	/**
	 * No parameters
	 */
	public FacturaExportacion(EDocumentFactory facturaExportacionFactory) {
		// call constructor without parameters
		this();
		this.facturaExportacionFactory = (FacturaExportacionFactory) facturaExportacionFactory;
	}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {

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
		
		return VALIDATION_RESULT_OK;
	}


	/**
	 * @return the identificacion
	 */
	@Override
	public Identificacion getIdentificacion() {
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
	@Override
	public void fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		facturaExportacionFactory.fillIdentification(factoryInput, (IdentificacionFacturaExportacion) identificacion );
	}


	/**
	 * @return the emisor
	 */
	@Override
	public Emisor getEmisor() {
		return emisor;
	}


	/**
	 * @param emisor the emisor to set
	 */
	public void setEmisor(EmisorFacturaExportacion emisor) {
		this.emisor = emisor;
	}
	
	@Override
	public void fillEmisor(JSONObject factoryInput, Emisor emisor) {
		facturaExportacionFactory.fillEmisor(factoryInput, (EmisorFacturaExportacion) emisor);
	}


	/**
	 * @return the receptor
	 */
	@Override
	public Receptor getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor the receptor to set
	 */
	public void setReceptor(ReceptorFacturaExportacion receptor) {
		this.receptor = receptor;
	}

	@Override
	public void fillReceptor(JSONObject factoryInput, Receptor receptor) {
		facturaExportacionFactory.fillReceptor(factoryInput, (ReceptorFacturaExportacion) receptor);
	}

	/**
	 * @return the otrosDocumentos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OtrosDocumentosItem> getOtrosDocumentos() {
	    List<?> tempList = (List<OtrosDocumentosItemFacturaExportacion>) this.otrosDocumentos;
	    List<OtrosDocumentosItem> finalList = (List<OtrosDocumentosItem>)tempList;
		return finalList;
	}


	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(List<OtrosDocumentosItemFacturaExportacion> otrosDocumentos) {
		this.otrosDocumentos = otrosDocumentos;
	}

	@Override
	public void fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      OtrosDocumentosItemFacturaExportacion is a subtype of OtrosDocumentosItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe)::
		//		List<?> tmpList = (List<OtrosDocumentosItem>) otrosDocumentos;
	    //		List<OtrosDocumentosItemFacturaExportacion> otrosDocumentosFacturaExportacion = (List<OtrosDocumentosItemFacturaExportacion>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends OtrosDocumentosItemFacturaExportacion> otrosDocumentosItemFacturaExportacion = new ArrayList<>();
		//		List<? extends OtrosDocumentosItem>  otrosDocumentosItem = otrosDocumentosItemFacturaExportacion;  // new ArrayList<>(); would be OK
		//		setOtrosDocumentos((List<OtrosDocumentosItemFacturaExportacion>) otrosDocumentosItem);
		//
		//		Also possible III (cast List):
		// 		Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemFacturaExportacion)
		//		List<OtrosDocumentosItemFacturaExportacion> otrosDocumentosItemFacturaExportacion= new ArrayList<OtrosDocumentosItemFacturaExportacion>();
		//		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemFacturaExportacion.add((OtrosDocumentosItemFacturaExportacion) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemFacturaExportacion xxx = (OtrosDocumentosItemFacturaExportacion) otrosDocumentos.get(1);	

		facturaExportacionFactory.fillOtrosDocumentos(factoryInput, otrosDocumentos);
		
	}


	/**
	 * @return the ventaTercero
	 */
	@Override
	public VentaTercero getVentaTercero() {
		return ventaTercero;
	}


	/**
	 * @param ventaTercero the ventaTercero to set
	 */
	public void setVentaTercero(VentaTerceroFacturaExportacion ventaTercero) {
		this.ventaTercero = ventaTercero;
	}

	@Override
	public void fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		facturaExportacionFactory.fillVentaTercero(factoryInput, (VentaTerceroFacturaExportacion) ventaTercero);
	}


	/**
	 * @return the cuerpoDocumento
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
	    List<?> tempList = (List<CuerpoDocumentoItemFacturaExportacion>) this.cuerpoDocumento;
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}


	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItemFacturaExportacion> cuerpoDocumento) {
		this.cuerpoDocumento = cuerpoDocumento;
	}

	
	@Override
	public void fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {
		// TODO Implement actual code
		
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      CuerpoDocumentoItemFacturaExportacion is a subtype of CuerpoDocumentoItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe):
		//		List<?> tmpList = (List<CuerpoDocumentoItem>) cuerpoDocumento;
	    //		List<CuerpoDocumentoItemFacturaExportacion> cuerpoDocumentoFacturaExportacion = (List<CuerpoDocumentoItemFacturaExportacion>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends CuerpoDocumentoItemFacturaExportacion> cuerpoDocumentoItemFacturaExportacion = new ArrayList<>();
		//		List<? extends CuerpoDocumentoItem>  cuerpoDocumentoItem = cuerpoDocumentoItemFacturaExportacion;  // new ArrayList<>(); would be OK
		//		setCuerpoDocumento((List<CuerpoDocumentoItemFacturaExportacion>) cuerpoDocumentoItem);
		//
		//		Also possible III (cast List):
		//		@SuppressWarnings("unchecked")
		// 		Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemFacturaExportacion)
		//		List<CuerpoDocumentoItemFacturaExportacion> cuerpoDocumentoItemFacturaExportacion= new ArrayList<CuerpoDocumentoItemFacturaExportacion>();
		//		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemFacturaExportacion.add((CuerpoDocumentoItemFacturaExportacion) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemFacturaExportacion xxx = (OtrosDocumentosItemFacturaExportacion) otrosDocumentos.get(1);	

		facturaExportacionFactory.fillCuerpoDocumento(factoryInput, cuerpoDocumento);
		
	}

	/**
	 * @return the resumen
	 */
	@Override
	public Resumen getResumen() {
		return resumen;
	}


	/**
	 * @param resumen the resumen to set
	 */
	public void setResumen(ResumenFacturaExportacion resumen) {
		this.resumen = resumen;
	}

	@Override
	public void fillResumen(JSONObject factoryInput, Resumen resumen) {
		facturaExportacionFactory.fillResumen(factoryInput, (ResumenFacturaExportacion) resumen);
	}


	/**
	 * @return the apendice
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApendiceItem> getApendice() {
	    List<?> tempList = (List<ApendiceItemFacturaExportacion>) this.apendice;
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(List<ApendiceItemFacturaExportacion> apendice) {
		this.apendice = apendice;
	}

	@Override
	public void fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {
		// TODO Implement actual code
		
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      CuerpoDocumentoItemFacturaExportacion is a subtype of CuerpoDocumentoItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe):
		//		List<?> tmpList = (List<CuerpoDocumentoItem>) cuerpoDocumento;
	    //		List<CuerpoDocumentoItemFacturaExportacion> cuerpoDocumentoFacturaExportacion = (List<CuerpoDocumentoItemFacturaExportacion>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends ApendiceItemFacturaExportacion> apendiceFacturaExportacion = new ArrayList<>();
		//		List<? extends ApendiceItem>  apendiceItem = apendiceFacturaExportacion;  // new ArrayList<>(); would be OK
		//		setApendice((List<ApendiceItemFacturaExportacion>) apendiceItem);
		//
		//		Also possible III (cast List):
		//		Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemFacturaExportacion)
		//		List<ApendiceItemFacturaExportacion> apendiceItemFacturaExportacion= new ArrayList<ApendiceItemFacturaExportacion>();
		//		apendice.stream().forEach(e -> apendiceItemFacturaExportacion.add((ApendiceItemFacturaExportacion) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemFacturaExportacion xxx = (OtrosDocumentosItemFacturaExportacion) otrosDocumentos.get(1);	

		facturaExportacionFactory.fillApendice(factoryInput, apendice);		
		
	}


	/**
	 * THIS CLASS DOESN'T HAVE A DOCUMENTORELACIONADOITEM PROPERTY
	 */
	@Override
	public List<DocumentoRelacionadoItem> getDocumentoRelacionado() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Identificacion.fillDocumentoRelacionado() is not allowed");
	}


	/**
	 * THIS CLASS DOESN'T HAVE AN EXTENSION PROPERTY
	 */
	@Override
	public Extension getExtension() {
		return null;
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillExtension(JSONObject factoryInput, Extension extension) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Identificacion.fillExtension() is not allowed");
	}

	/**
	 * THIS CLASS DOESN'T HAVE A DOCUMENTO PROPERTY
	 */
	@Override
	public Documento getDocumento() {
		return null;
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillDocumento(JSONObject factoryInput, Documento documento) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacion.fillDocumento() is not allowed");
	}

	/**
	 * THIS CLASS DOESN'T HAVE A MOTIVO PROPERTY
	 */
	@Override
	public Motivo getMotivo() {
		return null;
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void fillMotivo(JSONObject factoryInput, Motivo motivo) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method FacturaExportacion.fillMotivo() is not allowed");
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	
}
