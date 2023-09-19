package org.shw.einvoice.es.anulacionv2;

import java.util.regex.Pattern;

import org.shw.einvoice.es.util.pojo.Direccion;
import org.shw.einvoice.es.util.pojo.Emisor;

/**
 * Just for class Anulacion
 */
public class EmisorAnulacion implements Emisor {

	String nit;
	String nombre;
	String tipoEstablecimiento;
	String nomEstablecimiento=null; // null permitted
    String telefono;
    String correo;
    String codEstableMH;
    String codEstable;
    String codPuntoVentaMH;
    String codPuntoVenta;
    
    
	/**
	 * 
	 */
	public EmisorAnulacion() {
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
	        throw new IllegalArgumentException("Wrong expression 'nit' in Anulacion.Emisor.setNit()");
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
	 * "minLength" : 3, "maxLength" : 250
	 */
	@Override
	public void setNombre(String nombre) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 250;
		int length = nombre==null?0:nombre.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.nombre = nombre;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombre' in Anulacion.Emisor.setNombre()");
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
	 * "enum" : ["01", "02", "04", "07", "20"]
	 */
	@Override
	public void setTipoEstablecimiento(String tipoEstablecimiento) {
		if (tipoEstablecimiento.compareTo("01")==0 || tipoEstablecimiento.compareTo("02")==0 || tipoEstablecimiento.compareTo("04")==0 || tipoEstablecimiento.compareTo("07")==0 || tipoEstablecimiento.compareTo("20")==0)
			this.tipoEstablecimiento = tipoEstablecimiento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoEstablecimiento' in Anulacion.Emisor.setTipoEstablecimiento()");
	}


	/**
	 * @return the nomEstablecimiento
	 */
	@Override
	public String getNomEstablecimiento() {
		return nomEstablecimiento;
	}


	/**
	 * @param nomEstablecimiento the nomEstablecimiento to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 3, "maxLength" : 150; null also possible
	 */
	@Override
	public void setNomEstablecimiento(String nomEstablecimiento) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 150;
		int length = nomEstablecimiento==null?0:nomEstablecimiento.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH)  || (nomEstablecimiento==null) )
			this.nomEstablecimiento = nomEstablecimiento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nomEstablecimiento' in Anulacion.Emisor.setNomEstablecimiento()");
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
	 * "minLength" : 8, "maxLength" : 26<br>
	 * "pattern" : "^[0-9+;]{8,26}$"
	 */
	@Override
	public void setTelefono(String telefono) {
		final int MINLENGTH = 8;
		final int MAXLENGTH = 26;
		int length = telefono==null?0:telefono.length();

		final String PATTERN = "^[0-9+;]{8,26}$";
		boolean patternOK = (telefono!=null) && Pattern.matches(PATTERN, telefono);  
		
		if(length>=MINLENGTH && length<=MAXLENGTH && patternOK)
			this.telefono = telefono;
		else
	        throw new IllegalArgumentException("Wrong parameter 'telefono' in Anulacion.Emisor.setTelefono()");
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
	        throw new IllegalArgumentException("Wrong parameter 'correo' in Anulacion.Emisor.setCorreo()");
	}


	/**
	 * @return the codEstableMH
	 */
	@Override
	public String getCodEstableMH() {
		return codEstableMH;
	}


	/**
	 * @param codEstableMH the codEstableMH to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 4, "maxLength" : 4, null also possible
	 */
	@Override
	public void setCodEstableMH(String codEstableMH) {
		final int MINLENGTH = 4;
		final int MAXLENGTH = 4;
		int length = codEstableMH==null?0:codEstableMH.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (codEstableMH==null) )
			this.codEstableMH = codEstableMH;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codEstableMH' in Anulacion.Emisor.setCodEstableMH()");
	}


	/**
	 * @return the codEstable
	 */
	@Override
	public String getCodEstable() {
		return codEstable;
	}


	/**
	 * @param codEstable the codEstable to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 10, null also possible
	 */
	@Override
	public void setCodEstable(String codEstable) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 10;
		int length = codEstable==null?0:codEstable.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (codEstable==null) )
			this.codEstable = codEstable;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codEstable' in Anulacion.Emisor.setCodEstable()");
	}


	/**
	 * @return the codPuntoVentaMH
	 */
	@Override
	public String getCodPuntoVentaMH() {
		return codPuntoVentaMH;
	}


	/**
	 * @param codPuntoVentaMH the codPuntoVentaMH to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 4, "maxLength" : 4, null also possible
	 */
	@Override
	public void setCodPuntoVentaMH(String codPuntoVentaMH) {
		final int MINLENGTH = 4;
		final int MAXLENGTH = 4;
		int length = codPuntoVentaMH==null?0:codPuntoVentaMH.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (codPuntoVentaMH==null) )
			this.codPuntoVentaMH = codPuntoVentaMH;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codPuntoVentaMH' in Anulacion.Emisor.setCodPuntoVentaMH()");
	}


	/**
	 * @return the codPuntoVenta
	 */
	@Override
	public String getCodPuntoVenta() {
		return codPuntoVenta;
	}


	/**
	 * @param codPuntoVenta the codPuntoVenta to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 15, null also possible
	 */
	@Override
	public void setCodPuntoVenta(String codPuntoVenta) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 15;
		int length = codPuntoVenta==null?0:codPuntoVenta.length();

		if( (length>=MINLENGTH && length<=MAXLENGTH) || (codPuntoVenta==null) )
			this.codPuntoVenta = codPuntoVenta;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codPuntoVenta' in Anulacion.Emisor.setCodPuntoVenta()");
	}


    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNrc() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getNrc() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNrc(String nrc) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setNrc() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodActividad() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getCodActividad() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodActividad(String codActividad) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setCodActividad() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getDescActividad() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getDescActividad() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDescActividad(String descActividad) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setDescActividad() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNombreComercial() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getNombreComercial() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNombreComercial(String nombreComercial) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setNombreComercial() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public Direccion getDireccion() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getDireccion() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setDireccion(Direccion direccion) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setDireccion() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodigoMH() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getCodigoMH() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodigoMH(String codigoMH) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setCodigoMH() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodigo() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getCodigo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodigo(String codigo) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setCodigo() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getPuntoVentaMH() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getPuntoVentaMH() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPuntoVentaMH(String puntoVentaMH) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setPuntoVentaMH() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getPuntoVenta() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getPuntoVenta() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPuntoVenta(String puntoVenta) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setPuntoVenta() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public int getTipoItemExpor() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getTipoItemExpor() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setTipoItemExpor(int tipoItemExpor) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setTipoItemExpor() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getRecintoFiscal() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getRecintoFiscal() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setRecintoFiscal(String recintoFiscal) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setRecintoFiscal() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getRegimen() {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getRegimen() is not allowed");
	}


	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setRegimen(String regimen) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.setRegimen() is not allowed");
	}


	
	public static void main(String[] args) {
		throw new UnsupportedOperationException("In Document Anulacion calling the method Emisor.getNrc() is not allowed");
	}

}
