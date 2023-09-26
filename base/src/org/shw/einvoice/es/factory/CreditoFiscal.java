/**
 * 
 */
package org.shw.einvoice.es.factory;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.feccfcreditofiscalv3.ApendiceItemCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.CuerpoDocumentoItemCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.DocumentoRelacionadoItemCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.EmisorCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.ExtensionCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.IdentificacionCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.OtrosDocumentosItemCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.ReceptorCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.ResumenCreditoFiscal;
import org.shw.einvoice.es.feccfcreditofiscalv3.VentaTerceroCreditoFiscal;
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
public class CreditoFiscal extends EDocument {
	IdentificacionCreditoFiscal identificacion;
	List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionado = null;
	EmisorCreditoFiscal emisor;
	ReceptorCreditoFiscal receptor;
	List<OtrosDocumentosItemCreditoFiscal> otrosDocumentos = null;
	VentaTerceroCreditoFiscal ventaTercero = null;
	List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumento;
	ResumenCreditoFiscal resumen;
	ExtensionCreditoFiscal extension;
	List<ApendiceItemCreditoFiscal> apendice=null;  // null allowed
	
	CreditoFiscalFactory creditoFiscalFactory;  // This must be eliminated from JSON production.

	/**
	 * No parameters
	 */
	@SuppressWarnings("unchecked")
	public CreditoFiscal() {
		List<?> tmpList;
		
		this.identificacion       = (IdentificacionCreditoFiscal) creditoFiscalFactory.createIdentificacion();

		// This is necessary, because though DocumentoRelacionadoItemCreditoFiscal is a subtype of DocumentoRelacionadoItem,
		// a List<DocumentoRelacionadoItemCreditoFiscal> is not a subtype of List<DocumentoRelacionadoItem>
	    tmpList = creditoFiscalFactory.createDocumentoRelacionado(); 
		this.documentoRelacionado = (List<DocumentoRelacionadoItemCreditoFiscal>) tmpList;

		this.emisor               = (EmisorCreditoFiscal) creditoFiscalFactory.createEmisor();
		this.receptor             = (ReceptorCreditoFiscal) creditoFiscalFactory.createReceptor();
		
		tmpList = creditoFiscalFactory.createOtrosDocumentos();
	    this.otrosDocumentos      = (List<OtrosDocumentosItemCreditoFiscal>) tmpList;
		
		this.ventaTercero         = (VentaTerceroCreditoFiscal) creditoFiscalFactory.createVentaTercero();

		tmpList = creditoFiscalFactory.createCuerpoDocumento();
	    this.cuerpoDocumento      = (List<CuerpoDocumentoItemCreditoFiscal>) tmpList;
				
		this.resumen              = (ResumenCreditoFiscal) creditoFiscalFactory.createResumen();
		this.extension            = (ExtensionCreditoFiscal) creditoFiscalFactory.createExtension();
		
	    tmpList = creditoFiscalFactory.createApendice();
	    this.apendice             = (List<ApendiceItemCreditoFiscal>) tmpList;;
	}
	
	/**
	 * No parameters
	 */
	public CreditoFiscal(EDocumentFactory creditoFiscalFactory) {
		// call constructor without parameters
		this();
		this.creditoFiscalFactory = (CreditoFiscalFactory) creditoFiscalFactory;
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
		this.identificacion = (IdentificacionCreditoFiscal) identificacion;
	}

	/**
	 * @param identificacion the (IdentificacionCreditoFiscal) identificacion to set
	 */
	@Override
	public void fillIdentification(JSONObject factoryInput, Identificacion identificacion) {
		creditoFiscalFactory.fillIdentification(factoryInput, (IdentificacionCreditoFiscal) identificacion );
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
	    List<?> tempList = (List<DocumentoRelacionadoItemCreditoFiscal>) this.documentoRelacionado;
	    List<DocumentoRelacionadoItem> finalList = (List<DocumentoRelacionadoItem>)tempList;
		return finalList;
	}



	/**
	 * @param documentoRelacionado the documentoRelacionado to set
	 */
	public void setDocumentoRelacionado(List<DocumentoRelacionadoItem> documentoRelacionado) {
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      DocumentoRelacionadoItemCreditoFiscal is a subtype of DocumentoRelacionadoItem
		// 		Integer                         is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe):
		//		List<?> tmpList = (List<DocumentoRelacionadoItem>) documentoRelacionado;
	    //		List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionadoCreditoFiscal = (List<DocumentoRelacionadoItemCreditoFiscal>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends DocumentoRelacionadoItemCreditoFiscal> documentoRelacionadoItemCreditoFiscal = new ArrayList<>();
		//		List<? extends DocumentoRelacionadoItem>  documentoRelacionadoItem = documentoRelacionadoItemCreditoFiscal;  
		//		setDocumentoRelacionado((List<DocumentoRelacionadoItemCreditoFiscal>) documentoRelacionadoItem);
		//
		//		Also possible III (cast List):
		// 		Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemCreditoFiscal)
		//		List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionadoItemCreditoFiscal= new ArrayList<DocumentoRelacionadoItemCreditoFiscal>();
		//		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemCreditoFiscal.add((DocumentoRelacionadoItemCreditoFiscal) e) );
		//
		//		Also possible IV (cast single entry):
		//  	DocumentoRelacionadoItemCreditoFiscal xxx = (DocumentoRelacionadoItemCreditoFiscal) documentoRelacionado.get(1);
		
		// Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemCreditoFiscal)
		List<DocumentoRelacionadoItemCreditoFiscal> documentoRelacionadoItemCreditoFiscal= new ArrayList<DocumentoRelacionadoItemCreditoFiscal>();
		documentoRelacionado.stream().forEach(e -> documentoRelacionadoItemCreditoFiscal.add((DocumentoRelacionadoItemCreditoFiscal) e) );
		
		this.documentoRelacionado = documentoRelacionadoItemCreditoFiscal;
	}

	@Override
	public void fillDocumentoRelacionado(JSONObject factoryInput, List<DocumentoRelacionadoItem> documentoRelacionado) {
		
		creditoFiscalFactory.fillDocumentoRelacionado(factoryInput, documentoRelacionado);
		
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
		this.emisor = (EmisorCreditoFiscal) emisor;
	}
	
	@Override
	public void fillEmisor(JSONObject factoryInput, Emisor emisor) {
		creditoFiscalFactory.fillEmisor(factoryInput, (EmisorCreditoFiscal) emisor);
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
		this.receptor = (ReceptorCreditoFiscal) receptor;
	}

	@Override
	public void fillReceptor(JSONObject factoryInput, Receptor receptor) {
		creditoFiscalFactory.fillReceptor(factoryInput, (ReceptorCreditoFiscal) receptor);
	}

	/**
	 * @return the otrosDocumentos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OtrosDocumentosItem> getOtrosDocumentos() {
	    List<?> tempList = (List<OtrosDocumentosItemCreditoFiscal>) this.otrosDocumentos;
	    List<OtrosDocumentosItem> finalList = (List<OtrosDocumentosItem>)tempList;
		return finalList;
	}


	/**
	 * @param otrosDocumentos the otrosDocumentos to set
	 */
	public void setOtrosDocumentos(List<OtrosDocumentosItem> otrosDocumentos) {
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      OtrosDocumentosItemCreditoFiscal is a subtype of OtrosDocumentosItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe)::
		//		List<?> tmpList = (List<OtrosDocumentosItem>) otrosDocumentos;
	    //		List<OtrosDocumentosItemCreditoFiscal> otrosDocumentosCreditoFiscal = (List<OtrosDocumentosItemCreditoFiscal>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends OtrosDocumentosItemCreditoFiscal> otrosDocumentosItemCreditoFiscal = new ArrayList<>();
		//		List<? extends OtrosDocumentosItem>  otrosDocumentosItem = otrosDocumentosItemCreditoFiscal;  // new ArrayList<>(); would be OK
		//		setOtrosDocumentos((List<OtrosDocumentosItemCreditoFiscal>) otrosDocumentosItem);
		//
		//		Also possible III (cast List):
		// 		Convert (=cast) all (DocumentoRelacionadoItem) to (DocumentoRelacionadoItemCreditoFiscal)
		//		List<OtrosDocumentosItemCreditoFiscal> otrosDocumentosItemCreditoFiscal= new ArrayList<OtrosDocumentosItemCreditoFiscal>();
		//		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemCreditoFiscal.add((OtrosDocumentosItemCreditoFiscal) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemCreditoFiscal xxx = (OtrosDocumentosItemCreditoFiscal) otrosDocumentos.get(1);

		// Convert (=cast) all (OtrosDocumentosItem) to (OtrosDocumentosItemCreditoFiscal)
		List<OtrosDocumentosItemCreditoFiscal> otrosDocumentosItemCreditoFiscal = new ArrayList<OtrosDocumentosItemCreditoFiscal>();
		otrosDocumentos.stream().forEach(e -> otrosDocumentosItemCreditoFiscal.add((OtrosDocumentosItemCreditoFiscal) e) );
		
		this.otrosDocumentos = otrosDocumentosItemCreditoFiscal;
	}

	@Override
	public void fillOtrosDocumentos(JSONObject factoryInput, List<OtrosDocumentosItem> otrosDocumentos) {	
		creditoFiscalFactory.fillOtrosDocumentos(factoryInput, otrosDocumentos);
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
		this.ventaTercero = (VentaTerceroCreditoFiscal) ventaTercero;
	}

	@Override
	public void fillVentaTercero(JSONObject factoryInput, VentaTercero ventaTercero) {
		creditoFiscalFactory.fillVentaTercero(factoryInput, (VentaTerceroCreditoFiscal) ventaTercero);
	}


	/**
	 * @return the cuerpoDocumento
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CuerpoDocumentoItem> getCuerpoDocumento() {
	    List<?> tempList = (List<CuerpoDocumentoItemCreditoFiscal>) this.cuerpoDocumento;
	    List<CuerpoDocumentoItem> finalList = (List<CuerpoDocumentoItem>)tempList;
		return finalList;
	}


	/**
	 * @param cuerpoDocumento the cuerpoDocumento to set
	 */
	public void setCuerpoDocumento(List<CuerpoDocumentoItem> cuerpoDocumento) {
		// TODO Implement actual code
		
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      CuerpoDocumentoItemCreditoFiscal is a subtype of CuerpoDocumentoItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe):
		//		List<?> tmpList = (List<CuerpoDocumentoItem>) cuerpoDocumento;
	    //		List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumentoCreditoFiscal = (List<CuerpoDocumentoItemCreditoFiscal>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends CuerpoDocumentoItemCreditoFiscal> cuerpoDocumentoItemCreditoFiscal = new ArrayList<>();
		//		List<? extends CuerpoDocumentoItem>  cuerpoDocumentoItem = cuerpoDocumentoItemCreditoFiscal;  // new ArrayList<>(); would be OK
		//		setCuerpoDocumento((List<CuerpoDocumentoItemCreditoFiscal>) cuerpoDocumentoItem);
		//
		//		Also possible III (cast List):
		//		@SuppressWarnings("unchecked")
		// 		Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemCreditoFiscal)
		//		List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumentoItemCreditoFiscal= new ArrayList<CuerpoDocumentoItemCreditoFiscal>();
		//		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemCreditoFiscal.add((CuerpoDocumentoItemCreditoFiscal) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemCreditoFiscal xxx = (OtrosDocumentosItemCreditoFiscal) otrosDocumentos.get(1);	
		
		// Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemCreditoFiscal)
		List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumentoItemCreditoFiscal = new ArrayList<CuerpoDocumentoItemCreditoFiscal>();
		cuerpoDocumento.stream().forEach(e -> cuerpoDocumentoItemCreditoFiscal.add((CuerpoDocumentoItemCreditoFiscal) e) );
		
		this.cuerpoDocumento = cuerpoDocumentoItemCreditoFiscal;
	}

	
	@Override
	public void fillCuerpoDocumento(JSONObject factoryInput, List<CuerpoDocumentoItem> cuerpoDocumento) {

		creditoFiscalFactory.fillCuerpoDocumento(factoryInput, cuerpoDocumento);
		
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
		this.resumen = (ResumenCreditoFiscal) resumen;
	}

	@Override
	public void fillResumen(JSONObject factoryInput, Resumen resumen) {
		creditoFiscalFactory.fillResumen(factoryInput, (ResumenCreditoFiscal) resumen);
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
		this.extension = (ExtensionCreditoFiscal) extension;
	}

	@Override
	public void fillExtension(JSONObject factoryInput, Extension extension) {
		creditoFiscalFactory.fillExtension(factoryInput, (ExtensionCreditoFiscal) extension);
	}



	/**
	 * @return the apendice
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ApendiceItem> getApendice() {
	    List<?> tempList = (List<ApendiceItemCreditoFiscal>) this.apendice;
	    List<ApendiceItem> finalList = (List<ApendiceItem>)tempList;
		return finalList;
	}


	/**
	 * @param apendice the apendice to set
	 */
	public void setApendice(List<ApendiceItem> apendice) {
		// See: https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
		// See: https://docs.oracle.com/javase/tutorial/java/generics/subtyping.html
		//      CuerpoDocumentoItemCreditoFiscal is a subtype of CuerpoDocumentoItem
		// 		Integer                    is a subtype of Number,
		//		List<? extends Integer> intList = new ArrayList<>();
		//		List<? extends Number>  numList = intList;
		//
		//		Also possible I (but unsafe):
		//		List<?> tmpList = (List<CuerpoDocumentoItem>) cuerpoDocumento;
	    //		List<CuerpoDocumentoItemCreditoFiscal> cuerpoDocumentoCreditoFiscal = (List<CuerpoDocumentoItemCreditoFiscal>) tmpList;
		//		
		//		Also possible II (safe with compiler directive):
		// 		@SuppressWarnings("unchecked")
		//		List<? extends ApendiceItemCreditoFiscal> apendiceCreditoFiscal = new ArrayList<>();
		//		List<? extends ApendiceItem>  apendiceItem = apendiceCreditoFiscal;  // new ArrayList<>(); would be OK
		//		setApendice((List<ApendiceItemCreditoFiscal>) apendiceItem);
		//
		//		Also possible III (cast List):
		//		Convert (=cast) all (CuerpoDocumentoItem) to (CuerpoDocumentoItemCreditoFiscal)
		//		List<ApendiceItemCreditoFiscal> apendiceItemCreditoFiscal= new ArrayList<ApendiceItemCreditoFiscal>();
		//		apendice.stream().forEach(e -> apendiceItemCreditoFiscal.add((ApendiceItemCreditoFiscal) e) );
		//
		//		Also possible IV (cast single entry):
		//  	OtrosDocumentosItemCreditoFiscal xxx = (OtrosDocumentosItemCreditoFiscal) otrosDocumentos.get(1);	

		// Convert (=cast) all (ApendiceItem) to (ApendiceItemCreditoFiscal)
		List<ApendiceItemCreditoFiscal> apendiceItemCreditoFiscal = new ArrayList<ApendiceItemCreditoFiscal>();
		apendice.stream().forEach(e -> apendiceItemCreditoFiscal.add((ApendiceItemCreditoFiscal) e) );
		
		this.apendice = apendiceItemCreditoFiscal;
	}

	@Override
	public void fillApendice(JSONObject factoryInput, List<ApendiceItem> apendice) {		

		creditoFiscalFactory.fillApendice(factoryInput, apendice);		
		
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
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method CreditoFiscal.fillDocumento() is not allowed");
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
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method CreditoFiscal.fillMotivo() is not allowed");
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	
}
