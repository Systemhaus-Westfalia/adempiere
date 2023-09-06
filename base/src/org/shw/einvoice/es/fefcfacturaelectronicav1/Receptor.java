/**
 * 
 */
package org.shw.einvoice.es.fefcfacturaelectronicav1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.shw.einvoice.es.util.pojo.Direccion;

/**
 * 
 */
public class Receptor {

	String tipoDocumento=null; // null possible
	String numDocumento=null; // null possible
	String nrc;
	String nombre=null; // null possible
	String codActividad;
	String descActividad=null; // null possible
	Direccion direccion;
    String telefono=null; // null possible
    String correo;
	
	/**
	 * No parameters
	 */
	public Receptor() {
	}
	

	
	/**
	 * Validate the Schema conditions
	 */
	public boolean validateValues() {
		String pattern;
		boolean patternOK;

		// In schema: "pattern" : "^([0-9]{14}|[0-9]{9})$"
		if(getTipoDocumento()=="36") {
			pattern = "^([0-9]{14}|[0-9]{9})$";
			patternOK = (getNumDocumento()!=null) && Pattern.matches(pattern, getNumDocumento());
			if(!patternOK)
				return false;
		} else {
			if(getNrc()!=null)
				return false;
		}

		// In schema: "pattern" : "^[0-9]{8}-[0-9]{1}$"
		if(getTipoDocumento()=="13") {
			pattern = "^[0-9]{8}-[0-9]{1}$";
			patternOK = (getNumDocumento()!=null) && Pattern.matches(pattern, getNumDocumento());
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
	 * "enum" : [null,"36","13","02","03","37"]; null permitted.
	 */
	public void setTipoDocumento(String tipoDocumento) {
		String[] validTipoDocumento = { "36", "13", "02", "03", "37" };
		
		if((tipoDocumento==null) || (Arrays.stream(validTipoDocumento).anyMatch(tipoDocumento::equals)) )
			this.tipoDocumento = tipoDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoDocumento' in setTipoDocumento()");
	}


	/**
	 * @return the numDocumento
	 */
	public String getNumDocumento() {
		return numDocumento;
	}


	/**
	 * @param numDocumento the numDocumento to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 3, "maxLength" : 20; null also possible
	 */
	public void setNumDocumento(String numDocumento) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 20;
		int length = numDocumento==null?0:numDocumento.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (numDocumento==null) )
			this.numDocumento = numDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numDocumento' in setNumDocumento()");
	}


	/**
	 * @return the nrc
	 */
	public String getNrc() {
		return nrc;
	}

	/**
	 * @param nrc the nrc to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^[0-9]{1,8}$"
	 */
	public void setNrc(String nrc) {
		final String PATTERN = "^[0-9]{1,8}$";
		boolean patternOK = (nrc!=null) && Pattern.matches(PATTERN, nrc);  
		
		if(patternOK)
			this.nrc = nrc;
		else
	        throw new IllegalArgumentException("Wrong expression 'nrc' in setNrc()");
	}
    
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 250; null permitted
	 */
	public void setNombre(String nombre) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 250;
		int length = nombre==null?0:nombre.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH)  || (nombre==null) )
			this.nombre = nombre;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombre' in setNombre()");
	}

	/**
	 * @return the codActividad
	 */
	public String getCodActividad() {
		return codActividad;
	}

	/**
	 * @param codActividad the codActividad to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^[0-9]{2,6}$"
	 */
	public void setCodActividad(String codActividad) {
		final String PATTERN = "^[0-9]{2,6}$";
		boolean patternOK = (codActividad!=null) && Pattern.matches(PATTERN, codActividad);  
		
		if(patternOK)
			this.codActividad = codActividad;
		else
	        throw new IllegalArgumentException("Wrong expression 'codActividad' in setCodActividad()");
	}

	/**
	 * @return the descActividad
	 */
	public String getDescActividad() {
		return descActividad;
	}

	/**
	 * @param descActividad the descActividad to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 5, "maxLength" : 150; null also possible
	 */
	public void setDescActividad(String descActividad) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 150;
		int length = descActividad==null?0:descActividad.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (descActividad==null) )
			this.descActividad = descActividad;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descActividad' in setDescActividad()");
	}

	/**
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 8, "maxLength" : 30; null also possible
	 */
	public void setTelefono(String telefono) {
		final int MINLENGTH = 8;
		final int MAXLENGTH = 30;
		int length = telefono==null?0:telefono.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (telefono==null) )
			this.telefono = telefono;
		else
	        throw new IllegalArgumentException("Wrong parameter 'telefono' in setTelefono()");
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 100
	 */
	public void setCorreo(String correo) {
		final int MAXLENGTH = 100;
		int length = correo==null?0:correo.length();
		
		if(length<=MAXLENGTH)
			this.correo = correo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'correo' in setCorreo()");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
