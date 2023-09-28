package org.shw.einvoice.es.factory;

import java.util.List;

import org.json.JSONObject;
import org.shw.einvoice.es.fefcfacturaelectronicav1.OtrosDocumentosItemFactura;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.CuerpoDocumentoItem;
import org.shw.einvoice.es.util.pojo.Documento;
import org.shw.einvoice.es.util.pojo.DocumentoRelacionadoItem;
import org.shw.einvoice.es.util.pojo.Emisor;
import org.shw.einvoice.es.util.pojo.Extension;
import org.shw.einvoice.es.util.pojo.Identificacion;
import org.shw.einvoice.es.util.pojo.Motivo;
import org.shw.einvoice.es.util.pojo.OtrosDocumentosItem;
import org.shw.einvoice.es.util.pojo.Resumen;
import org.shw.einvoice.es.util.pojo.VentaTercero;

public abstract class EDocumentStore {

	StringBuffer errorMessages = new StringBuffer();
	EDocument eDocument;
	abstract EDocument createEDocument();
	
	public EDocument generateEDocument(JSONObject factoryInput) {
		String result="";
		eDocument = createEDocument();
		
		Identificacion identification = eDocument.getIdentificacion();
		if(identification!=null) {
			errorMessages.append(eDocument.fillIdentification(factoryInput, identification));
			result = identification.validateValues();
			if(! result.equals(EDocument.VALIDATION_RESULT_OK)) {
				errorMessages.append(result);
			}
		}
		
		List<DocumentoRelacionadoItem> documentoRelacionado = eDocument.getDocumentoRelacionado();
		if(documentoRelacionado!=null) {
			errorMessages.append(eDocument.fillDocumentoRelacionado(factoryInput, documentoRelacionado));
			
			documentoRelacionado.stream().forEach( documentoRelacionadoItem -> { 
					String resultLambda = documentoRelacionadoItem.validateValues();
					if(! resultLambda.equals(EDocument.VALIDATION_RESULT_OK)) {
						errorMessages.append(resultLambda);
					}
				} 
			);
		}
		
		Emisor emisor = eDocument.getEmisor();
		if(emisor!=null) {
			eDocument.fillEmisor(factoryInput, emisor);
			result = emisor.validateValues();
			if(! result.equals(EDocument.VALIDATION_RESULT_OK)) {
				errorMessages.append(result);
			}
		}
		
		List<OtrosDocumentosItem> otrosDocumentos = eDocument.getOtrosDocumentos();
		if(otrosDocumentos!=null) {
			eDocument.fillOtrosDocumentos(factoryInput, otrosDocumentos);
			
			otrosDocumentos.stream().forEach( otrosDocumentosItem -> { 
				String resultLambda = otrosDocumentosItem.validateValues();
					if(! resultLambda.equals(EDocument.VALIDATION_RESULT_OK)) {
						errorMessages.append(resultLambda);
					}
				} 
			);
		}
		
		VentaTercero ventaTercero = eDocument.getVentaTercero();
		if(ventaTercero!=null) {
			eDocument.fillVentaTercero(factoryInput, ventaTercero);
			result = ventaTercero.validateValues();
			if(! result.equals(EDocument.VALIDATION_RESULT_OK)) {
				errorMessages.append(result);
			}
		}
		
		List<CuerpoDocumentoItem> cuerpoDocumento = eDocument.getCuerpoDocumento();
		if(cuerpoDocumento!=null) {
			eDocument.fillCuerpoDocumento(factoryInput, cuerpoDocumento);
			
			cuerpoDocumento.stream().forEach( cuerpoDocumentoItem -> { 
				String resultLambda = cuerpoDocumentoItem.validateValues();
					if(! resultLambda.equals(EDocument.VALIDATION_RESULT_OK)) {
						errorMessages.append(resultLambda);
					}
				} 
			);
		}
		
		Resumen resumen = eDocument.getResumen();
		if(resumen!=null) {
			eDocument.fillResumen(factoryInput, resumen);
			result = resumen.validateValues();
			if(! result.equals(EDocument.VALIDATION_RESULT_OK)) {
				errorMessages.append(result);
			}
		}
		
		Extension extension = eDocument.getExtension();
		if(extension!=null) {
			eDocument.fillExtension(factoryInput, extension);
			result = extension.validateValues();
			if(! result.equals(EDocument.VALIDATION_RESULT_OK)) {
				errorMessages.append(result);
			}
		}
		
		List<ApendiceItem> apendice = eDocument.getApendice();
		if(apendice!=null) {
			eDocument.fillApendice(factoryInput, apendice);
			
			apendice.stream().forEach( apendiceItem -> { 
				String resultLambda = apendiceItem.validateValues();
					if(! resultLambda.equals(EDocument.VALIDATION_RESULT_OK)) {
						errorMessages.append(resultLambda);
					}
				} 
			);
		}
		
		Documento documento = eDocument.getDocumento();
		if(documento!=null) {
			eDocument.fillDocumento(factoryInput, documento);
			result = documento.validateValues();
			if(! result.equals(EDocument.VALIDATION_RESULT_OK)) {
				errorMessages.append(result);
			}
		}
		
		Motivo motivo = eDocument.getMotivo();
		if(documento!=null) {
			eDocument.fillMotivo(factoryInput, motivo);
			result = motivo.validateValues();
			if(! result.equals(EDocument.VALIDATION_RESULT_OK)) {
				errorMessages.append(result);
			}
		}

		eDocument.validateValues();
		if(! result.equals(EDocument.VALIDATION_RESULT_OK)) {
			errorMessages.append(result);
		}
		
		return eDocument;
	}

	public StringBuffer getEDocumentErrorMessages() {
		 return this.errorMessages;
	 }
}
