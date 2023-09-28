/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.                                     *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net                                                  *
 * or https://github.com/adempiere/adempiere/blob/develop/license.html        *
 *****************************************************************************/

package org.shw.einvoice.es.anulacionv2;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.adempiere.core.domains.models.X_E_InvoiceElectronic;
import org.apache.commons.lang3.StringUtils;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceTax;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.util.Env;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.io.IOException;

/** Generated Process for (EI_CreateInvoice_Anulacion_SV)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_CreateInvoice_Anulacion_SV extends EI_CreateInvoice_Anulacion_SVAbstract
{
	

	static final String VALIDATION_RESULT_OK = "OK";

	String 				numeroControl;
	String 				codigoGeneracion;
	MClient				client = null;
	MOrgInfo 			orgInfo = null;
	List<MInvoiceTax> invoiceTaxes = null;
	BigDecimal zero = new BigDecimal(0.00);
	StringBuffer error = new StringBuffer();
	String absDirectory = "";
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{	
		absDirectory = MSysConfig.getValue("EI_PATH");
		MInvoice invoiceAnulacion = new MInvoice(getCtx(), getInvoiceId(), get_TrxName());
		if (invoiceAnulacion.getC_Invoice_ID()<invoiceAnulacion.getReversal_ID())
			return "No es el documento de anulacion";
		if (invoiceAnulacion.getReversal_ID()<=0)
			return "Falta documento original";
		System.out.println("Process EI_CreateInvoice_FacturaExport_SV : Started with Invoice " + invoiceAnulacion.getDocumentNo());
		invoiceTaxes = new Query(getCtx() , MInvoiceTax.Table_Name , "C_Invoice_ID=?" , get_TrxName())
				.setParameters(invoiceAnulacion.getC_Invoice_ID())
				.list();
		int orgID = invoiceAnulacion.getAD_Org_ID();
		orgInfo= MOrgInfo.get(getCtx(), orgID, get_TrxName());
		client = new MClient(getCtx(), invoiceAnulacion.getAD_Client_ID(), get_TrxName());
		
		Integer id = invoiceAnulacion.get_ID();
		X_E_InvoiceElectronic e_InvoiceElectronic = new Query(getCtx(), X_E_InvoiceElectronic.Table_Name, 
				"C_Invoice_ID=?", get_TrxName())
				.setParameters(invoiceAnulacion.getReversal_ID())
				.first();
		Anulacion anulacion   = new Anulacion();
		if (e_InvoiceElectronic != null){
			fillDocument(anulacion.getDocumento(), invoiceAnulacion, e_InvoiceElectronic);
		}
		else {
			return "No hay documento original"; 
		}	

		try
		{
			fillemisor(anulacion.getEmisor(), invoiceAnulacion);  	
		}
		catch (Exception e)
		{
			error.append(e);
		}
		try
		{
			fillIdentification(anulacion.getIdentificacion(), invoiceAnulacion);  	
		}
		catch (Exception e)
		{
			error.append(e);
		}
		
    	validateValues(anulacion, error);
    	
    	X_E_InvoiceElectronic invoiceElectronic = new X_E_InvoiceElectronic(getCtx(), 0, get_TrxName());
    	invoiceElectronic.setC_Invoice_ID(invoiceAnulacion.getC_Invoice_ID());
    	invoiceElectronic.setei_ValidationStatus("01");
    	if (error.length() > 0) {
    		invoiceElectronic.seterrMsgIntern(error.toString());
    		invoiceElectronic.setei_ValidationStatus("02");
        	invoiceElectronic.saveEx();
    		return error.toString();
    	}    
	
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	String json = objectMapper.writeValueAsString(anulacion);

       	invoiceElectronic.setjson(json);
    	invoiceElectronic.saveEx();
    	log.config(json);
    	if (isSaveInHistoric()) {
    		Path rootpath = Paths.get(absDirectory);
    		if (!Files.exists(rootpath)) {
    			invoiceElectronic.seterrMsgIntern("Root File From MSystConfig EI_PATH does not exist");
    		}
    		writeToFile(json, invoiceAnulacion);
    	}
		
    	System.out.println("Factura generada: " + invoiceAnulacion.getDocumentNo() + "Estado: " + invoiceElectronic.getei_ValidationStatus());
    	System.out.println(json);	    	
		return "";
	}
	
	private void fillIdentification(Identificacion identificacion, MInvoice invoice) {
		
		identificacion.setCodigoGeneracion(codigoGeneracion);
		
		String fecha = invoice.getDateAcct().toString().substring(0, 10);		  
		identificacion.setfecAnula(fecha);
		identificacion.setAmbiente(client.getE_Enviroment().getValue());

	}
	
	private void fillemisor(Emisor emisor, MInvoice invoice) {
		emisor.setNit(orgInfo.getTaxID().replace("-", ""));
		emisor.setNombre(client.getName()); 
		emisor.setTipoEstablecimiento(client.getE_PlantType().getValue());
		emisor.setTelefono(client.get_ValueAsString("phone"));
		emisor.setCorreo(client.getEMail());
	}
	
	private void fillDocument(Documento documento, MInvoice invoiceAnulacion, X_E_InvoiceElectronic e_InvoiceElectronic) {

		numeroControl = e_InvoiceElectronic.getei_numeroControl();
		documento.setCodigoGeneracion(e_InvoiceElectronic.getCodigoGeneracion());
		documento.setNumDocumento(e_InvoiceElectronic.getei_numeroControl());
		documento.setTipoDte(invoiceAnulacion.getC_DocType().getE_DocType().getValue());
		documento.setFecEmi(invoiceAnulacion.getDateAcct().toString().substring(0, 10));
		documento.setSelloRecibido(e_InvoiceElectronic.getselloRecibido());
		documento.setTipoDocumento(invoiceAnulacion.getC_BPartner().getE_Recipient_Identification().getValue());
		if (invoiceAnulacion.getC_BPartner().getE_Recipient_Identification().getValue().equals("36"))
			documento.setNumDocumento(invoiceAnulacion.getC_BPartner().getTaxID());
		else documento.setNumDocumento(invoiceAnulacion.getC_BPartner().getDUNS());
		documento.setNombre(invoiceAnulacion.getC_BPartner().getName());
		
		BigDecimal montoIva = Env.ZERO;
		List<MInvoiceTax> invoiceTaxs = new Query(getCtx(), MInvoiceTax.Table_Name, "C_Invoice_ID=?", get_TrxName())
				.setParameters(getInvoiceId())
				.list();
		for (MInvoiceTax invoiceTax:invoiceTaxs) {
			if (invoiceTax.getC_Tax().getTaxIndicator().equals("IVA"))
			montoIva = montoIva.add(invoiceTax.getTaxAmt());
		}
		documento.setMontoIva(montoIva);
		Integer clientID = (Integer)client.getAD_Client_ID();
		Integer id = (Integer)invoiceAnulacion.getC_Invoice_ID();
		String codigoGeneracionR = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(id.toString(), 12,"0");
		documento.setCodigoGeneracionR(codigoGeneracionR);
	
	}
	
	
	
	
	

	private void validateValues(Anulacion anulacion, StringBuffer error) {}
	
	private void writeToFile (String json, MInvoice invoice)
	{
		try
		{
			absDirectory = (absDirectory.endsWith("/")
					|| absDirectory.endsWith("\\"))
					? absDirectory:absDirectory + "/";
			Path path = Paths.get(absDirectory + invoice.getDateAcct().toString().substring(0, 10) + "/");
			Files.createDirectories(path);
			//java.nio.file.Files;
			Files.createDirectories(path);
			String filename = path +"/" + invoice.getDocumentNo().replace(" ", "") + ".json"; 
			File out = new File (filename);
			Writer fw = new OutputStreamWriter(new FileOutputStream(out, false), "UTF-8");
			fw.write(json);
			fw.flush ();
			fw.close ();
			float size = out.length();
			size /= 1024;
			log.info(out.getAbsolutePath() + " - " + size + " kB");
			System.out.println("Printed To: " + filename);
									
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	public void givenDefaultConstructor_whenDeserializing_thenCorrect() 
			throws IOException {
		/*
		 * try {
		 * 
		 * String json =
		 * "{\"identificacion\":{\"version\":1,\"ambiente\":\"00\",\"tipoDte\":\"01\",\"numeroControl\":\"DTE-01-01422260-000000001265101\",\"codigoGeneracion\":\"01000001-0000-0000-0000-000001265101\",\"tipoModelo\":1,\"tipoOperacion\":1,\"tipoContingencia\":null,\"motivoContin\":null,\"fecEmi\":\"2023-04-04\",\"horEmi\":\"00:00:00\",\"tipoMoneda\":\"USD\"},\"documentoRelacionado\":null,\"emisor\":{\"nit\":\"06141305021037\",\"nrc\":\"1422260\",\"nombre\":\"CFS\",\"codActividad\":\"050120\",\"descActividad\":\"Transporte de carga marítimo y de cabotaje\",\"nombreComercial\":\"Consolidated Freight Services\",\"tipoEstablecimiento\":\"02\",\"direccion\":{\"departamento\":\"06\",\"municipio\":\"14\",\"complemento\":\"Torre Presidente\"},\"telefono\":\"79309098\",\"correo\":\"SCalderon@gmx.de\",\"codEstableMH\":null,\"codEstable\":null,\"codPuntoVentaMH\":null,\"codPuntoVenta\":null},\"receptor\":{\"tipoDocumento\":\"36\",\"numDocumento\":\"06140906161107\",\"nrc\":null,\"nombre\":\"CINCO PUNTOS CENTROAMÉRICA, S.A. DE C.V.\",\"codActividad\":\"010101\",\"descActividad\":\"Servicio de rastros y mataderos de bovinos y porcinos\",\"direccion\":{\"departamento\":\"05\",\"municipio\":\"09\",\"complemento\":\"Calle Numero 2, Boulevard Bazini # S/N, Talnique, La Liberta null\"},\"telefono\":\"79309099\",\"correo\":\"SCalderon@gmx.de\"},\"otrosDocumentos\":null,\"ventaTercero\":null,\"cuerpoDocumento\":[{\"numItem\":10,\"tipoItem\":2,\"numeroDocumento\":\"DTE-01-01422260-000000001265101\",\"cantidad\":1,\"codigo\":\"1000050\",\"codTributo\":null,\"uniMedida\":1,\"descripcion\":\"Trámite inspección física aduana Acajutla\",\"precioUni\":125,\"montoDescu\":0,\"ventaNoSuj\":0,\"ventaExenta\":0,\"ventaGravada\":125,\"tributos\":null,\"psv\":0,\"noGravado\":0,\"ivaItem\":14.38},{\"numItem\":20,\"tipoItem\":2,\"numeroDocumento\":\"DTE-01-01422260-000000001265101\",\"cantidad\":1,\"codigo\":\"CTAJ - Demora\",\"codTributo\":null,\"uniMedida\":1,\"descripcion\":\"CTAJ - Demora\",\"precioUni\":316.40,\"montoDescu\":0,\"ventaNoSuj\":316.40,\"ventaExenta\":0,\"ventaGravada\":100,\"tributos\":null,\"psv\":0,\"noGravado\":632.80,\"ivaItem\":0},{\"numItem\":30,\"tipoItem\":2,\"numeroDocumento\":\"DTE-01-01422260-000000001265101\",\"cantidad\":1,\"codigo\":\"CTAJ - Demora\",\"codTributo\":null,\"uniMedida\":1,\"descripcion\":\"CTAJ - Demora\",\"precioUni\":67.80,\"montoDescu\":0,\"ventaNoSuj\":67.80,\"ventaExenta\":0,\"ventaGravada\":100,\"tributos\":null,\"psv\":0,\"noGravado\":135.60,\"ivaItem\":0},{\"numItem\":40,\"tipoItem\":2,\"numeroDocumento\":\"DTE-01-01422260-000000001265101\",\"cantidad\":1,\"codigo\":\"7203\",\"codTributo\":null,\"uniMedida\":1,\"descripcion\":\"Cuadrilla aduana Acajutla (completo)\",\"precioUni\":150,\"montoDescu\":0,\"ventaNoSuj\":0,\"ventaExenta\":0,\"ventaGravada\":150,\"tributos\":null,\"psv\":0,\"noGravado\":0,\"ivaItem\":17.26}],\"resumen\":{\"totalNoSuj\":384.20,\"totalExenta\":0,\"totalGravada\":243.36,\"subTotalVentas\":627.56,\"descuNoSuj\":0,\"descuExenta\":0,\"descuGravada\":0,\"porcentajeDescuento\":0,\"totalDescu\":0,\"tributos\":null,\"subTotal\":627.56,\"ivaRete1\":0,\"reteRenta\":0,\"montoTotalOperacion\":659.20,\"totalNoGravado\":384.20,\"totalPagar\":659.20,\"totalLetras\":\"SEISCIENTOS CINCUENTA Y NUEVE 20/100\",\"totalIva\":31.64,\"saldoFavor\":659.20,\"condicionOperacion\":1,\"pagos\":[{\"codigo\":\"05\",\"montoPago\":0,\"referencia\":\"Transferencia_ Depósito Bancario\",\"plazo\":\"01\",\"periodo\":0}],\"numPagoElectronico\":null},\"extension\":{\"nombEntrega\":null,\"docuEntrega\":null,\"nombRecibe\":null,\"docuRecibe\":null,\"observaciones\":null,\"placaVehiculo\":null},\"apendice\":null}"
		 * ; ObjectMapper mapper = new ObjectMapper();
		 * 
		 * Anulacion anulacion = mapper.reader()
		 * .forType(Anulacion.class).readValue(json); assertEquals("John",
		 * anulacion.getIdentificacion().getCodigoGeneracion()); } finally{
		 * 
		 * 
		 * }
		 * 
		 * 
		 */}

}