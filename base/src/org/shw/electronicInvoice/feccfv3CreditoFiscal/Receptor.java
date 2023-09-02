/**
 * 
 */
package org.shw.electronicInvoice.feccfv3CreditoFiscal;

import org.shw.util.pojoAdempiere.Direccion;

/**
 * 
 */
public class Receptor {

	String nombre;
	String codActividad;
	String descActividad;
	String nombreComercial;
	Direccion direccion;
    String telefono;
    String correo;
	
	/**
	 * No parameters
	 */
	public Receptor() {
	}
    
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the codActividad
	 */
	public String getCodActividad() {
		return codActividad;
	}

	/**
	 * @param codActividad the codActividad to set
	 */
	public void setCodActividad(String codActividad) {
		this.codActividad = codActividad;
	}

	/**
	 * @return the descActividad
	 */
	public String getDescActividad() {
		return descActividad;
	}

	/**
	 * @param descActividad the descActividad to set
	 */
	public void setDescActividad(String descActividad) {
		this.descActividad = descActividad;
	}

	/**
	 * @return the nombreComercial
	 */
	public String getNombreComercial() {
		return nombreComercial;
	}

	/**
	 * @param nombreComercial the nombreComercial to set
	 */
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
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
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
