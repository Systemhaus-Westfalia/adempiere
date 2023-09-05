package org.shw.einvoice.es.anulacionv2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Just for class Anulacion
 */
public class Motivo {

	int tipoAnulacion;
	String motivoAnulacion=null;  // null permitted
	String nombreResponsable;
	String tipDocResponsable;
	String numDocResponsable;
	String nombreSolicita;
	String tipDocSolicita;
	String numDocSolicita;
    
	/**
	 * 
	 */
	public Motivo() {
	}
    


/**
 * Validate the Schema conditions
 */
public boolean validateValues() {
	
	if(getTipoAnulacion()==3) {
		if ( getMotivoAnulacion()== null)
			return false;
	} 
	
	return true;
}
	
	
	/**
	 * @return the tipoAnulacion
	 */
	public int getTipoAnulacion() {
		return tipoAnulacion;
	}




	/**
	 * @param tipoAnulacion the tipoAnulacion to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2,3]
	 */
	public void setTipoAnulacion(int tipoAnulacion) {
		if (tipoAnulacion==1 || tipoAnulacion==2 || tipoAnulacion==3)
			this.tipoAnulacion = tipoAnulacion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoAnulacion' in setTipoAnulacion()");
	}




	/**
	 * @return the motivoAnulacion
	 */
	public String getMotivoAnulacion() {
		return motivoAnulacion;
	}




	/**
	 * @param motivoAnulacion the motivoAnulacion to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 5, "maxLength" : 250; null also possible
	 */
	public void setMotivoAnulacion(String motivoAnulacion) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 250;
		int length = motivoAnulacion.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH)  || (motivoAnulacion==null) )
			this.motivoAnulacion = motivoAnulacion;
		else
		    throw new IllegalArgumentException("Wrong parameter 'motivoAnulacion' in setMotivoAnulacion()");
	}




	/**
	 * @return the nombreResponsable
	 */
	public String getNombreResponsable() {
		return nombreResponsable;
	}




	/**
	 * @param nombreResponsable the nombreResponsable to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 5, "maxLength" : 100
	 */
	public void setNombreResponsable(String nombreResponsable) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 100;
		int length = nombreResponsable.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.nombreResponsable = nombreResponsable;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombreResponsable' in setNombreResponsable()");
	}




	/**
	 * @return the tipDocResponsable
	 */
	public String getTipDocResponsable() {
		return tipDocResponsable;
	}




	/**
	 * @param tipDocResponsable the tipDocResponsable to set<br>
	 * The parameter is validated.<br>
	 * Specific values allowed according to schema: ["36", "13", "02", .....].
	 * Tipo documento de identificación CAT-22: 36 -> NIT, 13 -> DUI, 02 -> Carnet de residente, 03 -> PASAPORTE, 37 -> OTRO
	 * The enum was chosen for validation.
	 */
	public void setTipDocResponsable(String tipDocResponsable) {
		String[] validTipDocResponsable = { "36", "13", "02", "03", "37" };		
		boolean isTipoDocResponsableValid = Arrays.stream(validTipDocResponsable).anyMatch(tipDocResponsable::equals);

		if(isTipoDocResponsableValid)
			this.tipDocResponsable = tipDocResponsable;
		else
			throw new IllegalArgumentException("Wrong parameter 'tipDocResponsable' in setTipDocResponsable()");
	}




	/**
	 * @return the numDocResponsable
	 */
	public String getNumDocResponsable() {
		return numDocResponsable;
	}




	/**
	 * @param numDocResponsable the numDocResponsable to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 3, "maxLength" : 20
	 */
	public void setNumDocResponsable(String numDocResponsable) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 20;
		int length = numDocResponsable.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.numDocResponsable = numDocResponsable;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numDocResponsable' in setNumDocResponsable()");
	}




	/**
	 * @return the nombreSolicita
	 */
	public String getNombreSolicita() {
		return nombreSolicita;
	}




	/**
	 * @param nombreSolicita the nombreSolicita to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 5, "maxLength" : 100
	 */
	public void setNombreSolicita(String nombreSolicita) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 100;
		int length = nombreSolicita.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.nombreSolicita = nombreSolicita;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombreSolicita' in setNombreSolicita()");
	}




	/**
	 * @return the tipDocSolicita
	 */
	public String getTipDocSolicita() {
		return tipDocSolicita;
	}




	/**
	 * @param tipDocSolicita the tipDocSolicita to set<br>
	 * The parameter is validated.<br>
	 * Specific values allowed according to schema: ["36", "13", "02", .....].
	 * Tipo documento de identificación CAT-22: 36 -> NIT, 13 -> DUI, 02 -> Carnet de residente, 03 -> PASAPORTE, 37 -> OTRO
	 * The enum was chosen for validation.
	 */
	public void setTipDocSolicita(String tipDocSolicita) {
		String[] validTipDocSolicita = { "36", "13", "02", "03", "37" };		
		boolean isTipoDocSolicitaValid = Arrays.stream(validTipDocSolicita).anyMatch(tipDocSolicita::equals);

		if(isTipoDocSolicitaValid)
			this.tipDocSolicita = tipDocSolicita;
		else
			throw new IllegalArgumentException("Wrong parameter 'tipDocSolicita' in setTipDocSolicita()");
	}




	/**
	 * @return the numDocSolicita
	 */
	public String getNumDocSolicita() {
		return numDocSolicita;
	}




	/**
	 * @param numDocSolicita the numDocSolicita to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 3, "maxLength" : 20
	 */
	public void setNumDocSolicita(String numDocSolicita) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 20;
		int length = numDocSolicita.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.numDocSolicita = numDocSolicita;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numDocSolicita' in setNumDocSolicita()");
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
