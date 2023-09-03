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
	 * Validate the Schema conditions
	 */
	public boolean validateValues() {
		String pattern;
		boolean patternOK;

		// In schema: "pattern" : "^0[1-9]|1[0-2]$"
		if(getDepartamento()=="01") {
			pattern = "^0[1-9]|1[0-2]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}

		// In schema: "pattern" : "^0[1-9]|1[0-3]$"
		if(getDepartamento()=="02" || getDepartamento()=="10") {
			pattern = "^0[1-9]|1[0-3]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		} 

		// In schema: "pattern" : "^0[1-9]|1[0-6]$"
		if(getDepartamento()=="03" || getDepartamento()=="07") {
			pattern = "^0[1-9]|1[0-6]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}  
		
		// In schema: "pattern" : "^0[1-9]|[12][0-9]|3[0-3]$"
		if(getDepartamento()=="04") {
			pattern = "^0[1-9]|[12][0-9]|3[0-3]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		} 
		
		// In schema: "pattern" : "^0[1-9]|1[0-9]|2[0-2]$"
		if(getDepartamento()=="05" || getDepartamento()=="08") {
			pattern = "^0[1-9]|1[0-9]|2[0-2]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}  
		
		// In schema: "pattern" : "^0[1-9]|1[0-9]$"
		if(getDepartamento()=="06") {
			pattern = "^0[1-9]|1[0-9]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}  

		// In schema: "pattern" : "^0[1-9]$"
		if(getDepartamento()=="09") {
			pattern = "^0[1-9]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}

		// In schema: "pattern" : "^0[1-9]|1[0-9]|2[0-3]$"
		if(getDepartamento()=="11") {
			pattern = "^0[1-9]|1[0-9]|2[0-3]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}
		
		// In schema: "pattern" : "^0[1-9]|1[0-9]|20$"
		if(getDepartamento()=="12") {
			pattern = "^0[1-9]|1[0-9]|20$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}

		// In schema: "pattern" : "^0[1-9]|1[0-9]|2[0-6]$"
		if(getDepartamento()=="13") {
			pattern = "^0[1-9]|1[0-9]|2[0-6]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}
		// In schema: "pattern" : "^0[1-9]|1[0-8]$"
		if(getDepartamento()=="14") {
			pattern = "^0[1-9]|1[0-8]$";
			patternOK = Pattern.matches(pattern, getMunicipio());
			if(!patternOK)
				return false;
		}

		return true;
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
		String pattern = "^0[1-9]|1[0-4]$";
		boolean patternOK = Pattern.matches(pattern, departamento);  

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
