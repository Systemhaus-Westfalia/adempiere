/**
 * 
 */
package org.shw.einvoice.es.fefcfacturaelectronicav1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.factory.EDocument;
import org.shw.einvoice.es.factory.EDocumentFactory;
import org.shw.einvoice.es.factory.FacturaFactory;
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
public class Factura extends EDocument {
	static final int MINIMUM_TOTOTAL_OF_OPERATION = 1095;
	static final int CUERPODOCUMENTO_MAXIMUM_ITEMS = 2000;

	static final String VALIDATION_RESULT_OK = "OK";
	static final String VALIDATION_RESUMEN_OR_MONTO_IS_NULL   = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'getResumen() y getMontoTotalOperacion()' no debe ser ='null'";
	static final String VALIDATION_TIPODOCUMENTO_IS_NULL      = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'tipoDocumento' no debe ser ='null'";
	static final String VALIDATION_NUMDOCUMENTO_IS_NULL       = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'numDocumento' no debe ser ='null'";
	static final String VALIDATION_NOMBRE_IS_NULL             = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'NOMBRE' no debe ser ='null'";
	static final String VALIDATION_CUERPODOCUMENTO_MAX_ITEMS  = "Documento: Factura, clase: FacturaElectronica. Validacion falló: valor de 'cuerpoDocumento' debe  contener máximo " + CUERPODOCUMENTO_MAXIMUM_ITEMS + " elementos";
	
	IdentificacionFactura identificacion;
	List<DocumentoRelacionadoItemFactura> documentoRelacionado = null;
	EmisorFactura emisor;
	ReceptorFactura receptor;
	List<OtrosDocumentosItemFactura> otrosDocumentos = null;
	VentaTerceroFactura ventaTercero = null;
	List<CuerpoDocumentoItemFactura> cuerpoDocumento;
	ResumenFactura resumen;
	ExtensionFactura extension;
	List<ApendiceItemFactura> apendice=null;  // null allowed
	
	FacturaFactory facturaFactory;  // This must be eliminated from JSON production.

	/**
	 * No parameters
	 */
	@SuppressWarnings("unchecked")
	public Factura() {
		List<?> tmpList;
		
		this.identificacion       = (IdentificacionFactura) facturaFactory.createIdentificacion();

		// This is necessary, because though DocumentoRelacionadoItemFactura is a subtype of DocumentoRelacionadoItem,
		// a List<DocumentoRelacionadoItemFactura> is not a subtype of List<DocumentoRelacionadoItem>
		//		List<DocumentoRelacionadoItem> documentoRelacionado = facturaFactory.createDocumentoRelacionado();
		//	    tmpList = (List<DocumentoRelacionadoItem>) documentoRelacionado;
		//	    List<DocumentoRelacionadoItemFactura> documentoRelacionadoFactura = (List<DocumentoRelacionadoItemFactura>) tmpList;
		//		this.documentoRelacionado = documentoRelacionadoFactura;
	    tmpList = facturaFactory.createDocumentoRelacionado();
	    this.documentoRelacionado = (List<DocumentoRelacionadoItemFactura>) tmpList;

		this.emisor               = (EmisorFactura) facturaFactory.createEmisor();
		this.receptor             = (ReceptorFactura) facturaFactory.createReceptor();
		
		tmpList = facturaFactory.createOtrosDocumentos();
	    this.otrosDocumentos      = (List<OtrosDocumentosItemFactura>) tmpList;
		
		this.ventaTercero         = (VentaTerceroFactura) facturaFactory.createVentaTercero();

	    tmpList = facturaFactory.createCuerpoDocumento();
	    this.cuerpoDocumento      = (List<CuerpoDocumentoItemFactura>) tmpList;
				
		this.resumen              = (ResumenFactura) facturaFactory.createResumen();
		this.extension            = (ExtensionFactura) facturaFactory.createExtension();
		
		tmpList = facturaFactory.createApendice();
	    this.apendice             = (List<ApendiceItemFactura>) tmpList;
	}
	
	/**
	 * No parameters
	 */
	public Factura(EDocumentFactory facturaFactory) {
		// call constructor without parameters
		this();
		this.facturaFactory = (FacturaFactory) facturaFactory;
	}

	/**
	 * Validate the Schema conditions
	 */
	public String validateValues() {
		if( (getResumen()==null) || (getResumen().getMontoTotalOperacion()==null) ) {
			return VALIDATION_RESUMEN_OR_MONTO_IS_NULL;
		}
		
		if(getResumen().getMontoTotalOperacion().compareTo(BigDecimal.valueOf(MINIMUM_TOTOTAL_OF_OPERATION))==1) {
			if ( getReceptor().getTipoDocumento()== null)
				return VALIDATION_TIPODOCUMENTO_IS_NULL;
			if ( getReceptor().getNumDocumento()== null)
				return VALIDATION_NUMDOCUMENTO_IS_NULL;
			if ( getReceptor().getNombre()== null)
				return VALIDATION_NOMBRE_IS_NULL;
		} 
		
		if( (getCuerpoDocumento()==null) ||  (getCuerpoDocumento().size()==0)  ||  (getCuerpoDocumento().size()>CUERPODOCUMENTO_MAXIMUM_ITEMS) ) {
			return VALIDATION_CUERPODOCUMENTO_MAX_ITEMS;
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
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = (IdentificacionFactura) identificacion;
	}

	/**
	 * @param identificacion the (IdentificacionFactura) identificacion to set
	 */
	@Override
	public void fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		facturaFactory.fillIdentification( (IdentificacionFactura) identificacion );
	}


	/**
	 * @return the documentoRelacionado
	 * To cast Lists where B extends A
	 * 
	 * List<B> b = new ArrayList<>();
	 * List<?> t = (List<B>)b;
	 * List<A> a = (List<A>)t;
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentoRelacionadoItem> getDocumentoRelacionado() {
	    List<?> tempList = (List<DocumentoRelacionadoItemFactura>) this.documentoRelacionado;
	    List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}



	/**
	 * @param documentoRelacionado the documentoRelacionado to set
	 */
	public void setDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado) {
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      DocumentoRelacionadoItemFactura is a subtype of DocumentoRelacionadoItem
		// 		Integer                         is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe):
		//		List<?> tmpList = (List<DocumentoRelacionadoItem>) documentoRelacionado;
	    //		List<DocumentoRelacionadoItemFactura> documentoRelacionadoFactura = (List<DocumentoRelacionadoItemFactura>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends DocumentoRelacionadoItemFactura> documentoRelacionadoItemFactura = new ArrayList<>();
		//		List<? extends DocumentoRelacionadoItem>  documentoRelacionadoItem = documentoRelacionadoItemFactura;  
		//		setDocumentoRelacionado((List<DocumentoRelacionadoItemFactura>) documentoRelacionadoItem);
		//
		//		Also possible III (cast List):
		// 		Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemFactura)
		//		List<DocumentoRelacionadoItemFactura> documentoRelacionadoItemFactura= new ArrayList<DocumentoRelacionadoItemFactura>();
		//		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemFactura.add((DocumentoRelacionadoItemFactura) e) );
		//
		//		Also possible IV (cast single entry):
		//  	DocumentoRelacionadoItemFactura xxx = (DocumentoRelacionadoItemFactura) documentoRelacionado.get(1);
		
		// Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemFactura)
		List<DocumentoRelacionadoItemFactura> documentoRelacionadoItemFactura = new ArrayList<DocumentoRelacionadoItemFactura>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemFactura.add((DocumentoRelacionadoItemFactura) e) );
		
		this.documentoRelacionado = documentoRelacionadoItemFactura;
	}

	@Override
	public void fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		
		facturaFactory.fillDocumentoRelacionado(documentoRelacionado);
		
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
	public void setEmisor(Emisor emisor) {
		this.emisor = (EmisorFactura) emisor;
	}
	
	@Override
	public void fillEmisor(JSONObject factoryInput, Emisor emisor) {
		facturaFactory.fillEmisor( (EmisorFactura) emisor);
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
	public void setReceptor(Receptor receptor) {
		this.receptor = (ReceptorFactura) receptor;
	}

	@Override
	public void fillReceptor(Receptor receptor) {
		facturaFactory.fillReceptor( (ReceptorFactura) receptor);
	}

	/**
	 * @return the otrosDocumentos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OtrosDocumentosItem> getOtrosDocumentos() {
	    List<?> tempList = (List<OtrosDocumentosItemFactura>) this.otrosDocumentos;
	    List<OtrosDocumentosItem> finalList = (List<OtrosDocumentosItem>)tempList;
		return finalList;
	}


	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos) {
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      OtrosDocumentosItemFactura is a subtype of OtrosDocumentosItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe)::
		//		List<?> tmpList = (List<OtrosDocumentosItem>) otrosDocumentos;
	    //		List<OtrosDocumentosItemFactura> otrosDocumentosFactura = (List<OtrosDocumentosItemFactura>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends OtrosDocumentosItemFactura> otrosDocumentosItemFactura = new ArrayList<>();
		//		List<? extends OtrosDocumentosItem>  otrosDocumentosItem = otrosDocumentosItemFactura;  // new ArrayList<>(); would be OK
		//		setOtrosDocumentos((List<OtrosDocumentosItemFactura>) otrosDocumentosItem);
		//
		//		Also possible III (cast List):
		// 		Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemFactura)
		//		List<OtrosDocumentosItemFactura> otrosDocumentosItemFactura= new ArrayList<OtrosDocumentosItemFactura>();
		//		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemFactura.add((OtrosDocumentosItemFactura) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemFactura xxx = (OtrosDocumentosItemFactura) otrosDocumentos.get(1);	
		
		// Convert (=cast) all (OtrosDocumentosItem) to (OtrosDocumentosItemFactura)
		List<OtrosDocumentosItemFactura> otrosDocumentosItemFactura = new ArrayList<OtrosDocumentosItemFactura>();
		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemFactura.add((OtrosDocumentosItemFactura) e) );
		
		this.otrosDocumentos = otrosDocumentosItemFactura;
	}

	@Override
	public void fillOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos) {
		facturaFactory.fillOtrosDocumentos(otrosDocumentos);
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
	public void setVentaTercero(VentaTercero ventaTercero) {
		this.ventaTercero = (VentaTerceroFactura) ventaTercero;
	}

	@Override
	public void fillVentaTercero(VentaTercero ventaTercero) {
		facturaFactory.fillVentaTercero( (VentaTerceroFactura) ventaTercero);
	}


	/**
	 * @return the cuerpoDocumento
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
	    List<?> tempList = (List<CuerpoDocumentoItemFactura>) this.cuerpoDocumento;
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}


	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      CuerpoDocumentoItemFactura is a subtype of CuerpoDocumentoItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe):
		//		List<?> tmpList = (List<CuerpoDocumentoItem>) cuerpoDocumento;
	    //		List<CuerpoDocumentoItemFactura> cuerpoDocumentoFactura = (List<CuerpoDocumentoItemFactura>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends CuerpoDocumentoItemFactura> cuerpoDocumentoItemFactura = new ArrayList<>();
		//		List<? extends CuerpoDocumentoItem>  cuerpoDocumentoItem = cuerpoDocumentoItemFactura;  // new ArrayList<>(); would be OK
		//		setCuerpoDocumento((List<CuerpoDocumentoItemFactura>) cuerpoDocumentoItem);
		//
		//		Also possible III (cast List):
		//		@SuppressWarnings("unchecked")
		// 		Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemFactura)
		//		List<CuerpoDocumentoItemFactura> cuerpoDocumentoItemFactura= new ArrayList<CuerpoDocumentoItemFactura>();
		//		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemFactura.add((CuerpoDocumentoItemFactura) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemFactura xxx = (OtrosDocumentosItemFactura) otrosDocumentos.get(1);	
		
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemFactura)
		List<CuerpoDocumentoItemFactura> cuerpoDocumentoItemFactura = new ArrayList<CuerpoDocumentoItemFactura>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemFactura.add((CuerpoDocumentoItemFactura) e) );
		
		this.cuerpoDocumento = cuerpoDocumentoItemFactura;
	}

	
	@Override
	public void fillCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		facturaFactory.fillCuerpoDocumento(cuerpoDocumento);
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
	public void setResumen(Resumen resumen) {
		this.resumen = (ResumenFactura) resumen;
	}

	@Override
	public void fillResumen(Resumen resumen) {
		facturaFactory.fillResumen( (ResumenFactura) resumen);
	}


	/**
	 * @return the extension
	 */
	@Override
	public Extension getExtension() {
		return extension;
	}


	/**
	 * @param extension the extension to set
	 */
	public void setExtension(Extension extension) {
		this.extension = (ExtensionFactura) extension;
	}

	@Override
	public void fillExtension(Extension extension) {
		facturaFactory.fillExtension( (ExtensionFactura) extension);
	}



	/**
	 * @return the apendice
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApendiceItem> getApendice() {
	    List<?> tempList = (List<ApendiceItemFactura>) this.apendice;
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(List<ApendiceItem> apendice) {
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      CuerpoDocumentoItemFactura is a subtype of CuerpoDocumentoItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe):
		//		List<?> tmpList = (List<CuerpoDocumentoItem>) cuerpoDocumento;
	    //		List<CuerpoDocumentoItemFactura> cuerpoDocumentoFactura = (List<CuerpoDocumentoItemFactura>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends ApendiceItemFactura> apendiceFactura = new ArrayList<>();
		//		List<? extends ApendiceItem>  apendiceItem = apendiceFactura;  // new ArrayList<>(); would be OK
		//		setApendice((List<ApendiceItemFactura>) apendiceItem);
		//
		//		Also possible III (cast List):
		//		Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemFactura)
		//		List<ApendiceItemFactura> apendiceItemFactura= new ArrayList<ApendiceItemFactura>();
		//		apendice.stream().forEach(e -> apendiceItemFactura.add((ApendiceItemFactura) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemFactura xxx = (OtrosDocumentosItemFactura) otrosDocumentos.get(1);	
		
		// Convert (=cast) all (ApendiceItem) to (ApendiceItemFactura)
		List<ApendiceItemFactura> apendiceItemFactura = new ArrayList<ApendiceItemFactura>();
		apendice.stream().forEach(e -> apendiceItemFactura.add((ApendiceItemFactura) e) );
		
		this.apendice = apendiceItemFactura;
	}

	@Override
	public void fillApendice(List<ApendiceItem> apendice) {
		facturaFactory.fillApendice(apendice);		
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
	public void fillDocumento(Documento documento) {
		throw new UnsupportedOperationException("In Document Factura calling the method Factura.fillDocumento() is not allowed");
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
	public void fillMotivo(Motivo motivo) {
		throw new UnsupportedOperationException("In Document Factura calling the method Factura.fillMotivo() is not allowed");
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	
}
