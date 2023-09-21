package org.shw.einvoice.es.util.pojo;

public interface Extension {

		// For ComprobanteCreditoFiscal, Retencion, FacturaElectronica, NotaDeCredito, NotaDeDebito
		public String getNombEntrega();
		public void setNombEntrega(String nombEntrega);
		public String getDocuEntrega();
		public void setDocuEntrega(String docuEntrega);
		public String getNombRecibe();
		public void setNombRecibe(String nombRecibe);
		public String getDocuRecibe();
		public void setDocuRecibe(String docuRecibe);
		public String getObservaciones();
		public void setObservaciones(String observaciones);
		
		// ComprobanteCreditoFiscal, FacturaElectronica
		public String getPlacaVehiculo();
		public void setPlacaVehiculo(String placaVehiculo);
		
}
