package org.shw.electronicInvoice.feccfv3CreditoFiscal;

import java.util.regex.Pattern;

public class DocumentoRelacionadoItem {
	String tipoDocumento;
	int tipoGeneracion;
	String numeroDocumento;
	String fechaEmision;
	

	/**
	 */
	public DocumentoRelacionadoItem() {
	}
	
	/**
	 * @param tipoDocumento
	 * @param tipoGeneracion
	 * @param numeroDocumento
	 * @param fechaEmision
	 */
	
	public DocumentoRelacionadoItem(String tipoDocumento, int tipoGeneracion, String numeroDocumento,
			String fechaEmision) {
		this.tipoDocumento = tipoDocumento;
		this.tipoGeneracion = tipoGeneracion;
		this.numeroDocumento = numeroDocumento;
		this.fechaEmision = fechaEmision;
	}


	/**
	 * Validate the Schema conditions
	 */
	public boolean validateValues() {
		final String PATTERN = "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$";
		if(getTipoGeneracion()==2) {
			boolean patternOK = Pattern.matches(PATTERN, getNumeroDocumento());  
			
			if(!patternOK)
				return false;
		}
		return true;
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set<br>
	 * The parameter is validated.<br>
	 * "enum" : ["04", "08", "09"]
	 */
	public void setTipoDocumento(String tipoDocumento) {
		if (tipoDocumento.compareTo("04")==0 || tipoDocumento.compareTo("08")==0 || tipoDocumento.compareTo("09")==0)
			this.tipoDocumento = tipoDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoDocumento' in setTipoDocumento()");
	}
	
	/**
	 * @return the tipoGeneracion
	 */
	public int getTipoGeneracion() {
		return tipoGeneracion;
	}

	/**
	 * @param tipoGeneracion the tipoGeneracion to set.<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2]
	 */
	public void setTipoGeneracion(int tipoGeneracion) {	
		if (tipoGeneracion==1 || tipoGeneracion==2)
			this.tipoGeneracion = tipoGeneracion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoGeneracion' in setTipoGeneracion()");
	}

	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 36
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 36;
		int length = numeroDocumento.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.numeroDocumento = numeroDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numeroDocumento' in setNumeroDocumento()");
	}

	/**
	 * @return the fechaEmision
	 */
	public String getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
