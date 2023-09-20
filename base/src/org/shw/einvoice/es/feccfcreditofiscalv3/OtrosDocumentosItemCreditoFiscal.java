/**
 * 
 */
package org.shw.einvoice.es.feccfcreditofiscalv3;

import java.util.Objects;

import org.shw.einvoice.es.util.pojo.Medico;
import org.shw.einvoice.es.util.pojo.OtrosDocumentosItem;


/**
 * 
 */
public class OtrosDocumentosItemCreditoFiscal implements OtrosDocumentosItem {
	static final String VALIDATION_MEDICO_IS_NULL            = "Documento: Credito Fiscal, clase: OtrosDocumentosItem. Validacion falló: valor de 'medico' no debe ser ='null'";
	static final String VALIDATION_DESCDOCUMENTO_NOT_NULL    = "Documento: Credito Fiscal, clase: OtrosDocumentosItem. Validacion falló: valor de 'descDocumento' debe ser ='null'";
	static final String VALIDATION_DETALLEDOCUMENTO_NOT_NULL = "Documento: Credito Fiscal, clase: OtrosDocumentosItem. Validacion falló: valor de 'detalleDocumento' debe ser ='null'";
	static final String VALIDATION_MEDICO_NOT_NULL           = "Documento: Credito Fiscal, clase: OtrosDocumentosItem. Validacion falló: valor de 'medico' debe ser ='null'";
	static final String VALIDATION_DESCDOCUMENTO_IS_NULL     = "Documento: Credito Fiscal, clase: OtrosDocumentosItem. Validacion falló: valor de 'descDocumento' no debe ser ='null'";
	static final String VALIDATION_DETALLEDOCUMENTO_IS_NULL  = "Documento: Credito Fiscal, clase: OtrosDocumentosItem. Validacion falló: valor de 'detalleDocumento' no debe ser ='null'";

	int codDocAsociado;
	String descDocumento=null;  // null allowed
	String detalleDocumento=null;  // null allowed
	Medico medico=null;  // null allowed
	
	/**
	 * No Parameters
	 */
	public OtrosDocumentosItemCreditoFiscal() {
		this.medico = new Medico();
	}

	/**
	 * Validate the Schema conditions
	 */
	@Override
	public String validateValues() {
		if(getCodDocAsociado()==3) {
			if (Objects.isNull(getMedico()))
				return VALIDATION_MEDICO_IS_NULL;
			if (getDescDocumento()!=null)
				return VALIDATION_DESCDOCUMENTO_NOT_NULL;
			if (getDetalleDocumento()!=null)
				return VALIDATION_DETALLEDOCUMENTO_NOT_NULL;
		} else  {
			if (!Objects.isNull(getMedico()))
				return VALIDATION_MEDICO_NOT_NULL;
			if (getDescDocumento()==null)
				return VALIDATION_DESCDOCUMENTO_IS_NULL;
			if (getDetalleDocumento()==null)
				return VALIDATION_DETALLEDOCUMENTO_IS_NULL;
		}
		
		return VALIDATION_RESULT_OK;
	}

	/**
	 * @return the codDocAsociado
	 */
	@Override
	public int getCodDocAsociado() {
		return codDocAsociado;
	}


	/**
	 * @param codDocAsociado the codDocAsociado to set<br>
	 * The parameter is validated.<br>
	 * "minimum" : 1, "maximum" : 4
	 */
	@Override
	public void setCodDocAsociado(int codDocAsociado) {
		final int MINIMUM = 1;
		final int MAXIMUM = 4;
		
		if(codDocAsociado>=MINIMUM && codDocAsociado<=MAXIMUM)
			this.codDocAsociado = codDocAsociado;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codDocAsociado' in Credito Fiscal.OtrosDocumentosItem.setCodDocAsociado()");
	}


	/**
	 * @return the descDocumento
	 */
	@Override
	public String getDescDocumento() {
		return descDocumento;
	}

	/**
	 * @param descDocumento the descDocumento to set<br>
	 * The parameter is validated; null also possible.<br>
	 * "maxLength" : 100
	 */
	@Override
	public void setDescDocumento(String descDocumento) {
		final int MAXLENGTH = 100;
		int length = descDocumento==null?0:descDocumento.length();
		
		if( (length<=MAXLENGTH)  || (descDocumento==null) )
			this.descDocumento = descDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descDocumento' in Credito Fiscal.OtrosDocumentosItem.setDescDocumento()");
	}

	/**
	 * @return the detalleDocumento
	 */
	@Override
	public String getDetalleDocumento() {
		return detalleDocumento;
	}

	/**
	 * @param detalleDocumento the detalleDocumento to set<br>
	 * The parameter is validated; null also possible.<br>.<br>
	 * "maxLength" : 300
	 */
	@Override
	public void setDetalleDocumento(String detalleDocumento) {
		final int MAXLENGTH = 300;
		int length = detalleDocumento==null?0:detalleDocumento.length();
		
		if( (length<=MAXLENGTH)  || (detalleDocumento==null) )
			this.detalleDocumento = detalleDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'detalleDocumento' in Credito Fiscal.OtrosDocumentosItem.setDetalleDocumento()");
	}

	/**
	 * @return the medico
	 */
	@Override
	public Medico getMedico() {
		return medico;
	}

	/**
	 * @param medico the medico to set
	 */
	@Override
	public void setMedico(Medico medico) {
		this.medico = medico;
	}



    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getPlacaTrans() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Receptor.getPlacaTrans() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPlacaTrans(String placaTrans) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Receptor.setPlacaTrans() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Integer getModoTransp() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Receptor.getModoTransp() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setModoTransp(Integer modoTransp) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Receptor.setModoTransp() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNumConductor() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Receptor.getNumConductor() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNumConductor(String numConductor) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Receptor.setNumConductor() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNombreConductor() {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Receptor.getNombreConductor() is not allowed");
	}
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNombreConductor(String nombreConductor) {
		throw new UnsupportedOperationException("In Document Credito Fiscal calling the method Receptor.setNombreConductor() is not allowed");
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
