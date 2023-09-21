/**
 * 
 */
package org.shw.einvoice.es.fendnotadedebitov3;

import org.shw.einvoice.es.util.pojo.Extension;

/**
 * 
 */
public class ExtensionNotaDeDebito implements Extension {
	
	String nombEntrega=null;  // null allowed
	String docuEntrega=null;  // null allowed
	String nombRecibe=null;  // null allowed
	String docuRecibe=null;  // null allowed
	String observaciones=null;  // null allowed
	
	/**
	 * No parameters
	 */
	public ExtensionNotaDeDebito() {

	}

	/**
	 * @return the nombEntrega
	 */
	@Override
	public String getNombEntrega() {
		return nombEntrega;
	}

	/**
	 * @param nombEntrega the nombEntrega to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 100; null also possible
	 */
	@Override
	public void setNombEntrega(String nombEntrega) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 100;
		int length = nombEntrega==null?0:nombEntrega.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (nombEntrega==null) )
			this.nombEntrega = nombEntrega;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombEntrega' in NotaDeDebito.Extension.setNombEntrega()");
	}

	/**
	 * @return the docuEntrega
	 */
	@Override
	public String getDocuEntrega() {
		return docuEntrega;
	}

	/**
	 * @param docuEntrega the docuEntrega to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 25; null also possible
	 */
	@Override
	public void setDocuEntrega(String docuEntrega) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 25;
		int length = docuEntrega==null?0:docuEntrega.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (docuEntrega==null) )
			this.docuEntrega = docuEntrega;
		else
	        throw new IllegalArgumentException("Wrong parameter 'docuEntrega' in NotaDeDebito.Extension.setDocuEntrega()");
	}

	/**
	 * @return the nombRecibe
	 */
	@Override
	public String getNombRecibe() {
		return nombRecibe;
	}

	/**
	 * @param nombRecibe the nombRecibe to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 100; null also possible
	 */
	@Override
	public void setNombRecibe(String nombRecibe) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 100;
		int length = nombRecibe==null?0:nombRecibe.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (nombRecibe==null) )
			this.nombRecibe = nombRecibe;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombRecibe' in NotaDeDebito.Extension.setNombRecibe()");
	}

	/**
	 * @return the docuRecibe
	 */
	@Override
	public String getDocuRecibe() {
		return docuRecibe;
	}

	/**
	 * @param docuRecibe the docuRecibe to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 25; null also possible
	 */
	@Override
	public void setDocuRecibe(String docuRecibe) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 25;
		int length = docuRecibe==null?0:docuRecibe.length();
		
		if( (length>=MINLENGTH && length<=MAXLENGTH) || (docuRecibe==null) )
			this.docuRecibe = docuRecibe;
		else
	        throw new IllegalArgumentException("Wrong parameter 'docuRecibe' in NotaDeDebito.Extension.setDocuRecibe()");
	}

	/**
	 * @return the observaciones
	 */
	@Override
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 3000; null also possible
	 */
	@Override
	public void setObservaciones(String observaciones) {
		final int MAXLENGTH = 3000;
		int length = observaciones==null?0:observaciones.length();
		
		if( (length<=MAXLENGTH) || (observaciones==null) )
			this.observaciones = observaciones;
		else
	        throw new IllegalArgumentException("Wrong parameter 'observaciones' in NotaDeDebito.Extension.setObservaciones()");
	}

    
	// HERE, GETTERS AND SETTERS ONLY TO COMPLY WITH INTERFACE.
	// THEY ARE ACTUALLY NOT ALLOWED AND MUST THROW AN EXCEPTION



	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public String getPlacaVehiculo() {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method Extension.getPlacaVehiculo() is not allowed");
	}

	/**
	 * DO NO USE THIS METHOD!! IT WILL YIELD A RUNTIME EXCEPTION!!!!!
	 */
	@Override
	public void setPlacaVehiculo(String placaVehiculo) {
		throw new UnsupportedOperationException("In Document Nota de Debito calling the method Extension.setPlacaVehiculo() is not allowed");
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
