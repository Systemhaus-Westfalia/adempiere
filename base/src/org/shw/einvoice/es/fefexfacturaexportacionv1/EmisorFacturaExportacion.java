package org.shw.einvoice.es.fefexfacturaexportacionv1;

import java.util.regex.Pattern;

import org.shw.einvoice.es.util.pojo.Direccion;
import org.shw.einvoice.es.util.pojo.Emisor;

public class EmisorFacturaExportacion implements Emisor {
	static final String VALIDATION_RECINTOFISCAL_NOT_NULL = "Documento: Factura de Exportacion, clase: Emisor. Validacion falló: valor de 'recintoFiscal' de pagos debe ser ='null'";
	static final String VALIDATION_REGIMEN_NOT_NULL       = "Documento: Factura de Exportacion, clase: Emisor. Validacion falló: valor de 'regimen' de pagos debe ser ='null'";

	String nit;
	String nrc;
	String nombre;
	String codActividad;
	String descActividad;
	String nombreComercial=null;  // null possible
	String tipoEstablecimiento;
    Direccion direccion;
    String telefono;
    String correo;
    String codEstableMH;
    String codEstable;
    String codPuntoVentaMH;
    String codPuntoVenta;
    int tipoItemExpor;
    String recintoFiscal=null;  // null possible
    String regimen=null;  // null possible
    
    
	/**
	 * 
	 */
	public EmisorFacturaExportacion() {
	}

/**
 * Validate the Schema conditions
 */
	@Override
public String validateValues() {
	
	if(getTipoItemExpor()== 2) {
		if ( getRecintoFiscal()!= null)
			return VALIDATION_RECINTOFISCAL_NOT_NULL;
		if ( getRegimen()!= null)
			return VALIDATION_REGIMEN_NOT_NULL;
	}
	// In schema there are more validations, but they are redundant.
	
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
	        throw new IllegalArgumentException("Wrong expression 'nit' in FacturaExportacion.Emisor.setNit()");
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
	        throw new IllegalArgumentException("Wrong expression 'nrc' in FacturaExportacion.Emisor.setNrc()");
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
	 * "minLength" : 3, "maxLength" : 200
	 */
	@Override
	public void setNombre(String nombre) {
		final int MINLENGTH = 3;
		final int MAXLENGTH = 200;
		int length = nombre==null?0:nombre.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.nombre = nombre;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombre' in FacturaExportacion.Emisor.setNombre()");
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
	        throw new IllegalArgumentException("Wrong expression 'codActividad' in FacturaExportacion.Emisor.setCodActividad()");
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
	 * "minLength" : 1, "maxLength" : 150
	 */
	@Override
	public void setDescActividad(String descActividad) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 150;
		int length = descActividad==null?0:descActividad.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.descActividad = descActividad;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descActividad' in FacturaExportacion.Emisor.setDescActividad()");
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
	        throw new IllegalArgumentException("Wrong parameter 'nombreComercial' in FacturaExportacion.Emisor.setNombreComercial()");
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
	        throw new IllegalArgumentException("Wrong parameter 'tipoEstablecimiento' in FacturaExportacion.Emisor.setTipoEstablecimiento()");
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
	 * "minLength" : 8, "maxLength" : 30
	 */
	@Override
	public void setTelefono(String telefono) {
		final int MINLENGTH = 8;
		final int MAXLENGTH = 30;
		int length = telefono==null?0:telefono.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.telefono = telefono;
		else
	        throw new IllegalArgumentException("Wrong parameter 'telefono' in FacturaExportacion.Emisor.setTelefono()");
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
	        throw new IllegalArgumentException("Wrong parameter 'correo' in FacturaExportacion.Emisor.setCorreo()");
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
	        throw new IllegalArgumentException("Wrong parameter 'codEstableMH' in FacturaExportacion.Emisor.setCodEstableMH()");
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
	        throw new IllegalArgumentException("Wrong parameter 'codEstable' in FacturaExportacion.Emisor.setCodEstable()");
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
	        throw new IllegalArgumentException("Wrong parameter 'codPuntoVentaMH' in FacturaExportacion.Emisor.setCodPuntoVentaMH()");
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
	        throw new IllegalArgumentException("Wrong parameter 'codPuntoVenta' in FacturaExportacion.Emisor.setCodPuntoVenta()");
	}


    

	/**
	 * @return the tipoItemExpor
	 */
	@Override
	public int getTipoItemExpor() {
		return tipoItemExpor;
	}


	/**
	 * @param tipoItemExpor the tipoItemExpor to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2,3]
	 */
	public void setTipoItemExpor(int tipoItemExpor) {
		if (tipoItemExpor==1 || tipoItemExpor==2 || tipoItemExpor==3)
			this.tipoItemExpor = tipoItemExpor;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoItemExpor' in FacturaExportacion.Emisor.setTipoItemExpor()");
	}


	/**
	 * @return the recintoFiscal
	 */
	@Override
	public String getRecintoFiscal() {
		return recintoFiscal;
	}


	/**
	 * @param recintoFiscal the recintoFiscal to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 2, "maxLength" : 2
	 */
	@Override
	public void setRecintoFiscal(String recintoFiscal) {
		final int MINLENGTH = 2;		
		final int MAXLENGTH = 2;
		int length = recintoFiscal==null?0:recintoFiscal.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH ) || (recintoFiscal==null) )
			this.recintoFiscal = recintoFiscal;
		else
	        throw new IllegalArgumentException("Wrong parameter 'recintoFiscal' in FacturaExportacion.Emisor.setRecintoFiscal()");
	}


	/**
	 * @return the regimen
	 */
	@Override
	public String getRegimen() {
		return regimen;
	}


	/**
	 * @param regimen the regimen to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 13
	 */
	@Override
	public void setRegimen(String regimen) {
		final int MINLENGTH = 1;		
		final int MAXLENGTH = 13;
		int length = regimen==null?0:regimen.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH ) || (regimen==null) )
			this.regimen = regimen;
		else
	        throw new IllegalArgumentException("Wrong parameter 'regimen' in FacturaExportacion.Emisor.setRegimen()");
	}




    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getNomEstablecimiento() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.getNomEstablecimiento() is not allowed");
	}
	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setNomEstablecimiento(String nomEstablecimiento) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.setNomEstablecimiento() is not allowed");
	}

	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodigoMH() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.getCodigoMH() is not allowed");
	}

	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodigoMH(String codigoMH) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.setCodigoMH() is not allowed");
	}

	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getCodigo() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.getCodigo() is not allowed");
	}

	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setCodigo(String codigo) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.setCodigo() is not allowed");
	}

	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getPuntoVentaMH() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.getPuntoVentaMH() is not allowed");
	}

	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPuntoVentaMH(String puntoVentaMH) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.setPuntoVentaMH() is not allowed");
	}

	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getPuntoVenta() {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.getPuntoVenta() is not allowed");
	}

	
	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPuntoVenta(String puntoVenta) {
		throw new UnsupportedOperationException("In Document Factura Exportacion calling the method Emisor.setPuntoVenta() is not allowed");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
