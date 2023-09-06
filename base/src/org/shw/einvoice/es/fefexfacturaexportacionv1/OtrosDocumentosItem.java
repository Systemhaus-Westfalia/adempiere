/**
 * 
 */
package org.shw.einvoice.es.fefexfacturaexportacionv1;

import java.util.Objects;

;

/**
 * 
 */
public class OtrosDocumentosItem {

	int codDocAsociado;
	String descDocumento=null;  // null allowed
	String detalleDocumento=null;  // null allowed
	String placaTrans=null;  // null allowed
	Integer modoTransp=null;  // null erlaubt
	String numConductor=null;  // null allowed
	String nombreConductor=null;  // null allowed
	
	/**
	 * No Parameters
	 */
	public OtrosDocumentosItem() {
	}

	/**
	 * Validate the Schema conditions
	 */
	public boolean validateValues() {
		if(getCodDocAsociado()==4){
			if (Objects.isNull(getModoTransp()))
				return false;
			if (getNumConductor()==null)
				return false;
			if (getNombreConductor()==null)
				return false;
			if (getPlacaTrans()==null)
				return false;
		} else  {
			if (getNumConductor()!=null)
				return false;
			if (getNombreConductor()!=null)
				return false;
			if (getPlacaTrans()!=null)
				return false;
			if (!(Objects.isNull(getModoTransp())) )
				return false;
		}
		
		if(getCodDocAsociado()==1 || getCodDocAsociado()==2 ){
			if (getDescDocumento()==null)
				return false;
			if (getDetalleDocumento()==null)
				return false;
		} 
		
		return true;
	}

	/**
	 * @return the codDocAsociado
	 */
	public int getCodDocAsociado() {
		return codDocAsociado;
	}


	/**
	 * @param codDocAsociado the codDocAsociado to set<br>
	 * The parameter is validated.<br>
	 * "minimum" : 1, "maximum" : 4
	 */
	public void setCodDocAsociado(int codDocAsociado) {
		final int MINIMUM = 1;
		final int MAXIMUM = 4;
		
		if(codDocAsociado>=MINIMUM && codDocAsociado<=MAXIMUM)
			this.codDocAsociado = codDocAsociado;
		else
	        throw new IllegalArgumentException("Wrong parameter 'codDocAsociado' in setCodDocAsociado()");
	}


	/**
	 * @return the descDocumento
	 */
	public String getDescDocumento() {
		return descDocumento;
	}

	/**
	 * @param descDocumento the descDocumento to set<br>
	 * The parameter is validated; null also possible.<br>
	 * "maxLength" : 100
	 */
	public void setDescDocumento(String descDocumento) {
		final int MAXLENGTH = 100;
		int length = descDocumento==null?0:descDocumento.length();
		
		if( (length<=MAXLENGTH)  || (descDocumento==null) )
			this.descDocumento = descDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'descDocumento' in setDescDocumento()");
	}

	/**
	 * @return the detalleDocumento
	 */
	public String getDetalleDocumento() {
		return detalleDocumento;
	}

	/**
	 * @param detalleDocumento the detalleDocumento to set<br>
	 * The parameter is validated; null also possible.<br>.<br>
	 * "maxLength" : 300
	 */
	public void setDetalleDocumento(String detalleDocumento) {
		final int MAXLENGTH = 300;
		int length = detalleDocumento==null?0:detalleDocumento.length();
		
		if( (length<=MAXLENGTH)  || (detalleDocumento==null) )
			this.detalleDocumento = detalleDocumento;
		else
	        throw new IllegalArgumentException("Wrong parameter 'detalleDocumento' in setDetalleDocumento()");
	}


	/**
	 * @return the placaTrans
	 */
	public String getPlacaTrans() {
		return placaTrans;
	}

	/**
	 * @param placaTrans the placaTrans to set<br>
	 * The parameter is validated; null also possible.<br>
	 * "minLength" : 5, "maxLength" : 70
	 */
	public void setPlacaTrans(String placaTrans) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 70;
		int length = placaTrans==null?0:placaTrans.length();
		
		if( (placaTrans==null) || (length>=MINLENGTH && length<=MAXLENGTH) )
			this.placaTrans = placaTrans;
		else
	        throw new IllegalArgumentException("Wrong parameter 'placaTrans' in setPlacaTrans()");
	}

	/**
	 * @return the modoTransp
	 */
	public Integer getModoTransp() {
		return modoTransp;
	}

	/**
	 * @param modoTransp the modoTransp to set<br>
	 * The parameter is validated.<br>
	 * "enum" : [1,2,3,4,5,6,7], null
	 * "minimum" : 1, "maximum" : 4. This contradicts the Enum. The enum is taken.
	 */
	public void setModoTransp(Integer modoTransp) {
		if ( (modoTransp==null) || (modoTransp>=1 && modoTransp<=7) )
			this.modoTransp = modoTransp;
		else
	        throw new IllegalArgumentException("Wrong parameter 'modoTransp' in setModoTransp()");
	}

	/**
	 * @return the numConductor
	 */
	public String getNumConductor() {
		return numConductor;
	}

	/**
	 * @param numConductor the numConductor to set<br>
	 * The parameter is validated; null also possible.<br>
	 * "minLength" : 5, "maxLength" : 100
	 */
	public void setNumConductor(String numConductor) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 100;
		int length = numConductor==null?0:placaTrans.length();
		
		if( (numConductor==null) || (length>=MINLENGTH && length<=MAXLENGTH) )
			this.numConductor = numConductor;
		else
	        throw new IllegalArgumentException("Wrong parameter 'numConductor' in setNumConductor()");
	}

	/**
	 * @return the nombreConductor
	 */
	public String getNombreConductor() {
		return nombreConductor;
	}

	/**
	 * @param nombreConductor the nombreConductor to set<br>
	 * The parameter is validated; null also possible.<br>
	 * "minLength" : 5, "maxLength" : 200
	 */
	public void setNombreConductor(String nombreConductor) {
		final int MINLENGTH = 5;
		final int MAXLENGTH = 200;
		int length = nombreConductor==null?0:nombreConductor.length();
		
		if( (nombreConductor==null) || (length>=MINLENGTH && length<=MAXLENGTH) )
			this.nombreConductor = nombreConductor;
		else
	        throw new IllegalArgumentException("Wrong parameter 'nombreConductor' in setNombreConductor()");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
