package org.shw.util.pojoAdempiere;

public class Direccion {
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


		String departamento;
		String municipio;
        String complemento;
        
		/**
		 * @return the departamento
		 */
		public String getDepartamento() {
			return departamento;
		}

		/**
		 * @param departamento the departamento to set
		 */
		public void setDepartamento(String departamento) {
			this.departamento = departamento;
		}

		/**
		 * @return the municipio
		 */
		public String getMunicipio() {
			return municipio;
		}

		/**
		 * @param municipio the municipio to set
		 */
		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}

		/**
		 * @return the complemento
		 */
		public String getComplemento() {
			return complemento;
		}

		/**
		 * @param complemento the complemento to set
		 */
		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
