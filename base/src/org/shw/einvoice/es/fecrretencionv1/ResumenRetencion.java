/**
 * 
 */
package org.shw.einvoice.es.fecrretencionv1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.shw.einvoice.es.util.pojo.PagosItem;

/**
 * 
 */
public class ResumenRetencion {

	BigDecimal totalSujetoRetencion;
	BigDecimal totalIVAretenido;
	String totalIVAretenidoLetras;

	/**
	 * No parameters
	 */
	public ResumenRetencion() {
	}

	/**
	 * @return the totalSujetoRetencion
	 */
	public BigDecimal getTotalSujetoRetencion() {
		return totalSujetoRetencion;
	}

	/**
	 * @param totalSujetoRetencion the totalSujetoRetencion to set
	 */
	public void setTotalSujetoRetencion(BigDecimal totalSujetoRetencion) {
		this.totalSujetoRetencion = totalSujetoRetencion;
	}

	/**
	 * @return the totalIVAretenido
	 */
	public BigDecimal getTotalIVAretenido() {
		return totalIVAretenido;
	}

	/**
	 * @param totalIVAretenido the totalIVAretenido to set
	 */
	public void setTotalIVAretenido(BigDecimal totalIVAretenido) {
		this.totalIVAretenido = totalIVAretenido;
	}

	/**
	 * @return the totalIVAretenidoLetras;
	 */
	public String getTotalIVAretenidoLetras() {
		return totalIVAretenidoLetras;
	}


	/**
	 * @param totalLetras the totalIVAretenidoLetras; to set<br>
	 * The parameter is validated.<br>
	 * "maxLength" : 200
	 */
	public void setTotalIVAretenidoLetras(String totalIVAretenidoLetras) {
		final int MAXLENGTH = 200;
		int length = totalIVAretenidoLetras==null?0:totalIVAretenidoLetras.length();

		if( length<=MAXLENGTH)
			this.totalIVAretenidoLetras = totalIVAretenidoLetras;
		else
			throw new IllegalArgumentException("Wrong parameter 'totalLetras' in Retencion.Resumen.setTotalIVAretenidoLetras()");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
