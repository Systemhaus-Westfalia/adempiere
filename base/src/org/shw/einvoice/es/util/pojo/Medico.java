/**
 * 
 */
package org.shw.einvoice.es.util.pojo;

import java.util.regex.Pattern;

/**
 * 
 */
public class Medico {
	
	String nombre;
	String nit;
	String docIdentificacion;
	int tipoServicio;  // en schema: "type" : "number", "minimum" : 1, "maximum" : 6. Das wÄre double, wäre aber unsinnig 
	
	/**
	 * No parameters
	 */
	public Medico() {
	}

	/**
	 * Validate the Schema conditions
	 */
	public boolean validateValues() {
		if(getNit()==null) {
			if (getDocIdentificacion()==null) {
				return false;
			}
		}
		
		if(getDocIdentificacion()==null) {
			if (getNit()==null) {
				return false;
			}
		}
		return true;
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
	 * "maxLength" : 100
	 */
	public void setNombre(String nombre) {
		final int MAXLENGTH = 100;
		int length = nombre==null?0:nombre.length();
		
		if(length<=MAXLENGTH)
			this.nombre = nombre;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombre' in (POJO).Medico.setNombre()");
	}

	/**
	 * @return the nit
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * @param nit the nit to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^([0-9]{14}|[0-9]{9})$"
	 */
	public void setNit(String nit) {
		final String PATTERN = "^([0-9]{14}|[0-9]{9})$";
		boolean patternOK = (nit!=null) && Pattern.matches(PATTERN, nit);  
		
		if(patternOK)
			this.nit = nit;
		else
	        throw new IllegalArgumentException("Wrong expression 'nit' in (POJO).Medico.setNit()");
	}

	/**
	 * @return the docIdentificacion
	 */
	public String getDocIdentificacion() {
		return docIdentificacion;
	}

	/**
	 * @param docIdentificacion the docIdentificacion to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 2, "maxLength" : 25
	 */
	public void setDocIdentificacion(String docIdentificacion) {
		final int MINLENGTH = 2;
		final int MAXLENGTH = 25;
		int length = docIdentificacion==null?0:docIdentificacion.length();
		
		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.docIdentificacion = docIdentificacion;
		else
	        throw new IllegalArgumentException("Wrong parameter 'docIdentificacion' in (POJO).Medico.setDocIdentificacion()");
	}


	/**
	 * @return the tipoServicio
	 */
	public int getTipoServicio() {
		return tipoServicio;
	}



	/**
	 * @param tipoServicio the tipoServicio to set<br>
	 * The parameter is validated.<br>
	 * "minimum" : 1, "maximum" : 6
	 */
	public void setTipoServicio(int tipoServicio) {
		final int MINIMUM = 1;
		final int MAXIMUM = 6;
		
		if(tipoServicio>=MINIMUM && tipoServicio<=MAXIMUM)
			this.tipoServicio = tipoServicio;
		else
	        throw new IllegalArgumentException("Wrong parameter 'tipoServicio' in (POJO).Medico.setTipoServicio()");
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
