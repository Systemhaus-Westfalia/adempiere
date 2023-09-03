package org.shw.util.pojoAdempiere;

import java.util.regex.Pattern;

public class Direccion {

	String departamento;
	String municipio;
	String complemento;

	/**
	 * @param departamento
	 * @param municipio
	 * @param complemento
	 */
	public Direccion(String departamento, String municipio, String complemento) {
		this.departamento = departamento;
		this.municipio = municipio;
		this.complemento = complemento;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^0[1-9]|1[0-4]$"
	 */
	public void setDepartamento(String departamento) {
		final String PATTERN = "^0[1-9]|1[0-4]$";
		boolean patternOK = Pattern.matches(PATTERN, departamento);  

		if(patternOK)
			this.departamento = departamento;
		else
			throw new IllegalArgumentException("Wrong expression 'departamento' in setDepartamento()");
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set<br>
	 * The parameter is validated.<br>
	 * "pattern" : "^[0-9]{2}$"
	 */
	public void setMunicipio(String municipio) {
		final String PATTERN = "^[0-9]{2}$";
		boolean patternOK = Pattern.matches(PATTERN, municipio);  

		if(patternOK)
			this.municipio = municipio;
		else
			throw new IllegalArgumentException("Wrong expression 'municipio' in setMunicipio()");
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set<br>
	 * The parameter is validated.<br>
	 * "minLength" : 1, "maxLength" : 200
	 */
	public void setComplemento(String complemento) {
		final int MINLENGTH = 1;
		final int MAXLENGTH = 200;
		int length = complemento.length();

		if(length>=MINLENGTH && length<=MAXLENGTH)
			this.complemento = complemento;
		else
			throw new IllegalArgumentException("Wrong parameter 'complemento' in setComplemento()");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
