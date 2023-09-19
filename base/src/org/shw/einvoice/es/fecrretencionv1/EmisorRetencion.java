package org.shw.einvoice.es.fecrretencionv1;

import java.util.regex.Pattern;

import org.shw.einvoice.es.util.pojo.Direccion;
import org.shw.einvoice.es.util.pojo.Emisor;

public class EmisorRetencion implements Emisor {

	String nit;
	String nrc;
	String nombre;
	String codActividad;
	String descActividad;
	String nombreComercial=null;  // null possible
	String tipoEstablecimiento;
    Direccion direccion;
    String telefono;
    String codigoMH=null;  // null possible
    String codigo=null;  // null possible
    String puntoVentaMH=null;  // null possible
    String puntoVenta=null;  // null possible
    String correo;
    
	/**
	 * 
	 */
	public EmisorRetencion() {
	}


	/**
	 * Validate the Schema conditions
	 */
	@Override
	public String validateValues() {
		return VALIDATION_RESULT_OK;
	}


	/**
	 * @return the nit
	 */
	@Override
	public String getNit() {
		return nit;
	}


	/**
	 * @param nit the nit to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^([0-9]{14}|[0-9]{9})$"
	 */
	@Override
	public void setNit(String nit) {
		final String PATTERN = "^([0-9]{14}|[0-9]{9})$";
		boolean patternOK = (nit!=null) && Pattern.matches(PATTERN, nit);  
		
		if(patternOK)
			this.nit = nit;
		else
	        throw new IllegalArgumentException("Wrong expression 'nit' in Retencion.Emisor.setNit()");
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
	        throw new IllegalArgumentException("Wrong expression 'nrc' in Retencion.Emisor.setNrc()");
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
	 * "minLength" : 1, "maxLength" : 250
	 */
	@Override
	public void setNombre(String nombre) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 250;
		int length = nombre==null?0:nombre.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.nombre = nombre;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombre' in Retencion.Emisor.setNombre()");
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
	 * "pattern" : "^[0-9]{5,6}$"
	 * Schema also says "maxLength": 6, "minLength": 5, but it is redundant. 
	 */
	@Override
	public void setCodActividad(String codActividad) {
		final String PATTERN = "^[0-9]{5,6}$";
		boolean patternOK = (codActividad!=null) && Pattern.matches(PATTERN, codActividad);  
		
		if(patternOK)
			this.codActividad = codActividad;
		else
	        throw new IllegalArgumentException("Wrong expression 'codActividad' in Retencion.Emisor.setCodActividad()");
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
	 * "minLength" : 5, "maxLength" : 150
	 */
	@Override
	public void setDescActividad(String descActividad) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 150;
		int length = descActividad==null?0:descActividad.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.descActividad = descActividad;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descActividad' in Retencion.Emisor.setDescActividad()");
	}


	/**
	 * @return the nombreComercial
	 */
	@Override
	public String getNombreComercial() {
		return nombreComercial;
	}


	/**
	 * @param nombreComercial the nombreComercial to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 150; null also possible
	 */
	@Override
	public void setNombreComercial(String nombreComercial) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 150;
		int length = nombreComercial==null?0:nombreComercial.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (nombreComercial==null) )
			this.nombreComercial = nombreComercial;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombreComercial' in Retencion.Emisor.setNombreComercial()");
	}


	/**
	 * @return the tipoEstablecimiento
	 */
	@Override
	public String getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}


	/**
	 * @param tipoEstablecimiento the tipoEstablecimiento to set<br>
	 * The parameter is validated.<br>
	 * "enum" : ["01", "02", "04", "20"]
	 */
	@Override
	public void setTipoEstablecimiento(String tipoEstablecimiento) {
		if (tipoEstablecimiento.compareTo("01")==0 || tipoEstablecimiento.compareTo("02")==0 || tipoEstablecimiento.compareTo("04")==0 || tipoEstablecimiento.compareTo("20")==0)
			this.tipoEstablecimiento = tipoEstablecimiento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoEstablecimiento' in Retencion.Emisor.setTipoEstablecimiento()");
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
	 * "minLength" : 8, "maxLength" : 30<br>
	 * "pattern" : "^[A-Z0-9]{8,30}$". The pattern will be implemented.
	 */
	@Override
	public void setTelefono(String telefono) {
		//final int MINLENGTH = 8;
		//final int MAXLENGTH = 30;
		//int length = telefono==null?0:telefono.length();
		
		final String PATTERN = "^[A-Z0-9]{8,30}$";
		boolean patternOK = (telefono!=null) && Pattern.matches(PATTERN, telefono);  
		
		//if(length>=MINLENGTH && length<=MAXLENGTH)
		if(patternOK)
			this.telefono = telefono;
		else
	        throw new IllegalArgumentException("Wrong parameter 'telefono' in Retencion.Emisor.setTelefono()");
	}


	/**
	 * @return the codigoMH
	 */
	@Override
	public String getCodigoMH() {
		return codigoMH;
	}


	/**
	 * @param codigoMH the codigoMH to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 4, "maxLength" : 4, null also possible
	 */
	@Override
	public void setCodigoMH(String codigoMH) {
		final int MINLENGTH = 4;
		final int MAXLENGTH = 4;
		int length = codigoMH==null?0:codigoMH.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (codigoMH==null) )
			this.codigoMH = codigoMH;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codigoMH' in Retencion.Emisor.setCodigoMH()");
	}


	/**
	 * @return the codigo
	 */
	@Override
	public String getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo the codigo to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 4, "maxLength" : 4, null also possible
	 */
	@Override
	public void setCodigo(String codigo) {
		final int MINLENGTH = 4;
		final int MAXLENGTH = 4;
		int length = codigo==null?0:codigo.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (codigo==null) )
			this.codigo = codigo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codigo' in Retencion.Emisor.setCodigo()");
	}


	/**
	 * @return the puntoVentaMH
	 */
	@Override
	public String getPuntoVentaMH() {
		return puntoVentaMH;
	}


	/**
	 * @param puntoVentaMH the puntoVentaMH to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 4, "maxLength" : 4, null also possible
	 */
	@Override
	public void setPuntoVentaMH(String puntoVentaMH) {
		final int MINLENGTH = 4;
		final int MAXLENGTH = 4;
		int length = puntoVentaMH==null?0:puntoVentaMH.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (puntoVentaMH==null) )
			this.puntoVentaMH = puntoVentaMH;
		else
	        throw new IllegalArgumentException("Wrong parameter 'puntoVentaMH' in Retencion.Emisor.setPuntoVentaMH()");
	}


	/**
	 * @return the puntoVenta
	 */
	@Override
	public String getPuntoVenta() {
		return puntoVenta;
	}


	/**
	 * @param puntoVenta the puntoVenta to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 15, null also possible
	 */
	@Override
	public void setPuntoVenta(String puntoVenta) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 15;
		int length = puntoVenta==null?0:puntoVenta.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (puntoVenta==null) )
			this.puntoVenta = puntoVenta;
		else
	        throw new IllegalArgumentException("Wrong parameter 'puntoVenta' in Retencion.Emisor.setPuntoVenta()");
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
	 * "minLength" : 3, "maxLength" : 100
	 */
	@Override
	public void setCorreo(String correo) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 100;
		int length = correo==null?0:correo.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.correo = correo;
		else
	        throw new IllegalArgumentException("Wrong parameter 'correo' in Retencion.Emisor.setCorreo()");
	}


    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodEstableMH() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.getCodEstableMH() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodEstableMH(String codEstableMH) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.setCodEstableMH() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodEstable() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.getCodEstable() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodEstable(String codEstable) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.setCodEstable() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodPuntoVentaMH() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.getCodPuntoVentaMH() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodPuntoVentaMH(String codPuntoVentaMH) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.setCodPuntoVentaMH() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodPuntoVenta() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.getCodPuntoVenta() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodPuntoVenta(String codPuntoVenta) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.setCodPuntoVenta() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNomEstablecimiento() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.getNomEstablecimiento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNomEstablecimiento(String nomEstablecimiento) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.setNomEstablecimiento() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public int getTipoItemExpor() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.getTipoItemExpor() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoItemExpor(int tipoItemExpor) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.setTipoItemExpor() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getRecintoFiscal() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.getRecintoFiscal() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setRecintoFiscal(String recintoFiscal) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.setRecintoFiscal() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getRegimen() {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.getRegimen() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setRegimen(String regimen) {
		throw new UnsupportedOperationException("In Document Retencion calling the method Emisor.setRegimen() is not allowed");
	}

    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
