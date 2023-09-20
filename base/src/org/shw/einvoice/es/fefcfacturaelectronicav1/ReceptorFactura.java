/**
 * 
 */
package org.shw.einvoice.es.fefcfacturaelectronicav1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.shw.einvoice.es.util.pojo.Direccion;
import org.shw.einvoice.es.util.pojo.Receptor;

/**
 * 
 */
public class ReceptorFactura implements Receptor {
	static final String VALIDATION_NUMERODOCUMENTO_PATTERN_FAILED  = "Documento: Factura, clase: Receptor. Validacion falló: valor de 'numDocumento' no corresponde a patrón";
	static final String VALIDATION_NRC_NOT_NULL                    = "Documento: Factura, clase: Receptor. Validacion falló: valor de 'nrc' debe ser ='null'";

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
	public ReceptorFactura() {
	}
	

	
	/**
	 * Validate the Schema conditions
	 */
	@Override
	public String validateValues() {
		String pattern;
		boolean patternOK;

		// In schema: "pattern" : "^([0-9]{14}|[0-9]{9})$"
		if(getTipoDocumento() !=null &&   getTipoDocumento().equals("36")) {
			pattern = "^([0-9]{14}|[0-9]{9})$";
			patternOK = (getNumDocumento()!=null) && Pattern.matches(pattern, getNumDocumento());
			if(!patternOK)
				return VALIDATION_NUMERODOCUMENTO_PATTERN_FAILED;
		} else {
			if(getNrc()!=null)
				return VALIDATION_NRC_NOT_NULL;
		}

		// In schema: "pattern" : "^[0-9]{8}-[0-9]{1}$"
		if(getTipoDocumento() !=null && getTipoDocumento().equals("13")) {
			pattern = "^[0-9]{8}-[0-9]{1}$";
			patternOK = (getNumDocumento()!=null) && Pattern.matches(pattern, getNumDocumento());
			if(!patternOK)
				return VALIDATION_NUMERODOCUMENTO_PATTERN_FAILED;
		}
		
		return VALIDATION_RESULT_OK;
	}
	
	/**
	 * @return the tipoDocumento
	 */
	@Override
	public String getTipoDocumento() {
		return tipoDocumento;
	}


	/**
	 * @param tipoDocumento the tipoDocumento to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [null,"36","13","02","03","37"]; null permitted.
	 */
	@Override
	public void setTipoDocumento(String tipoDocumento) {
		String[] validTipoDocumento = { "36", "13", "02", "03", "37" };
		
		if((tipoDocumento==null) || (Arrays.stream(validTipoDocumento).anyMatch(tipoDocumento::equals)) )
			this.tipoDocumento = tipoDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoDocumento' in Factura.Receptor.setTipoDocumento()");
	}


	/**
	 * @return the numDocumento
	 */
	@Override
	public String getNumDocumento() {
		return numDocumento;
	}


	/**
	 * @param numDocumento the numDocumento to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 3, "maxLength" : 20; null also possible
	 */
	@Override
	public void setNumDocumento(String numDocumento) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 20;
		int length = numDocumento==null?0:numDocumento.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (numDocumento==null) )
			this.numDocumento = numDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numDocumento' in Factura.Receptor.setNumDocumento()");
	}


	/**
	 * @return the nrc
	 */
	@Override
	public String getNrc() {
		return nrc;
	}

	/**
	 * @param nrc the nrc to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^[0-9]{1,8}$"
	 */
	@Override
	public void setNrc(String nrc) {
		final String PATTERN = "^[0-9]{1,8}$";
		boolean patternOK = (nrc!=null) && Pattern.matches(PATTERN, nrc);  
		
		if(patternOK)
			this.nrc = nrc;
		else
	        throw new IllegalArgumentException("Wrong expression 'nrc' in Factura.Receptor.setNrc()");
	}
    
	/**
	 * @return the nombre
	 */
	@Override
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 250; null permitted
	 */
	@Override
	public void setNombre(String nombre) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 250;
		int length = nombre==null?0:nombre.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH)  || (nombre==null) )
			this.nombre = nombre;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombre' in Factura.Receptor.setNombre()");
	}

	/**
	 * @return the codActividad
	 */
	@Override
	public String getCodActividad() {
		return codActividad;
	}

	/**
	 * @param codActividad the codActividad to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^[0-9]{2,6}$"
	 */
	@Override
	public void setCodActividad(String codActividad) {
		final String PATTERN = "^[0-9]{2,6}$";
		boolean patternOK = (codActividad!=null) && Pattern.matches(PATTERN, codActividad);  
		
		if(patternOK)
			this.codActividad = codActividad;
		else
	        throw new IllegalArgumentException("Wrong expression 'codActividad' in Factura.Receptor.setCodActividad()");
	}

	/**
	 * @return the descActividad
	 */
	@Override
	public String getDescActividad() {
		return descActividad;
	}

	/**
	 * @param descActividad the descActividad to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 5, "maxLength" : 150; null also possible
	 */
	@Override
	public void setDescActividad(String descActividad) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 150;
		int length = descActividad==null?0:descActividad.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (descActividad==null) )
			this.descActividad = descActividad;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descActividad' in Factura.Receptor.setDescActividad()");
	}

	/**
	 * @return the direccion
	 */
	@Override
	public Direccion getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	@Override
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	@Override
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 8, "maxLength" : 30; null also possible
	 */
	@Override
	public void setTelefono(String telefono) {
		final int MINLENGTH = 8;
		final int MAXLENGTH = 30;
		int length = telefono==null?0:telefono.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (telefono==null) )
			this.telefono = telefono;
		else
	        throw new IllegalArgumentException("Wrong parameter 'telefono' in Factura.Receptor.setTelefono()");
	}

	/**
	 * @return the correo
	 */
	@Override
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 100
	 */
	@Override
	public void setCorreo(String correo) {
		final int MAXLENGTH = 100;
		int length = correo==null?0:correo.length();
		
		if(length<=MAXLENGTH)
			this.correo = correo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'correo' in Factura.Receptor.setCorreo()");
	}


    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNit() {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.getNit() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNit(String nit) {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.setNit() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNombreComercial() {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.getNombreComercial() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNombreComercial(String nombreComercial) {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.setNombreComercial() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNombrePais() {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.getNombrePais() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNombrePais(String nombrePais) {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.setNombrePais() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodPais() {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.getCodPais() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodPais(String codPais) {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.setCodPais() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getComplemento() {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.getComplemento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setComplemento(String complemento) {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.setComplemento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public int getTipoPersona() {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.getTipoPersona() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoPersona(int tipoPersona) {
		throw new UnsupportedOperationException("In Document Factura calling the method Receptor.setTipoPersona() is not allowed");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
