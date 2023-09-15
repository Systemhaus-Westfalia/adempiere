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

package org.shw.einvoice.es.fefexfacturaexportacionv1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.core.domains.models.X_E_InvoiceElectronic;
import org.apache.commons.lang3.StringUtils;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MInvoiceTax;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.shw.einvoice.es.util.pojo.Direccion;
import org.shw.einvoice.es.util.pojo.PagosItem;

import com.fasterxml.jackson.databind.ObjectMapper;

/** Generated Process for (EI_CreateInvoice_FacturaExport_SV.java)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_CreateInvoice_FacturaExport_SV extends EI_CreateInvoice_FacturaExport_SVAbstract
{


	static final String VALIDATION_RESULT_OK = "OK";

	String 				numeroControl;
	String 				codigoGeneracion;
	MClient				client = null;
	MOrgInfo 			orgInfo = null;
	List<MInvoiceTax> invoiceTaxes = null;
	BigDecimal zero = new BigDecimal(0.00);
	StringBuffer error = new StringBuffer();
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{
		MInvoice invoice = new MInvoice(getCtx(), getInvoiceId(), get_TrxName());
		invoiceTaxes = new Query(getCtx() , MInvoiceTax.Table_Name , "C_Invoice_ID=?" , get_TrxName())
				.setParameters(invoice.getC_Invoice_ID())
				.list();
		int orgID = invoice.getAD_Org_ID();
		orgInfo= MOrgInfo.get(getCtx(), orgID, get_TrxName());
		client = new MClient(getCtx(), invoice.getAD_Client_ID(), get_TrxName());
		Integer id = invoice.get_ID();
		String idIdentification  = StringUtils.leftPad(id.toString(), 15,"0");
		//final String PATTERN = "^DTE-03-[A-Z0-9]{8}-[0-9]{15}$";	
		String duns = orgInfo.getDUNS().replace("-", "");
		numeroControl = "DTE-11-" + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
	    //final String PATTERN = "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$";
		Integer clientID = (Integer)client.getAD_Client_ID();
		codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(id.toString(), 12,"0");
		if (invoice.getC_DocType().getE_DocType_ID()<= 0 ||
				!invoice.getC_DocType().getE_DocType().getValue().equals(Identificacion.TIPO_DE_DOCUMENTO)) {
			error.append("el documento no es Factura");
			return error.toString();
		}
		FacturaExportacion facturaExportacion = new FacturaExportacion();
		try
		{
			fillReceptor(facturaExportacion.getReceptor(), invoice);  
		}
		catch (Exception e)
		{
			error.append(e);
		}
		try
		{
			fillemisor(facturaExportacion.getEmisor(), invoice);  	 
		}
		catch (Exception e)
		{
			error.append(e);
		}		
		try
		{
			fillResumen(facturaExportacion.getResumen(), invoice);	 
		}
		catch (Exception e)
		{
			error.append(e);
		}		
		try
		{
			fillIdentification(facturaExportacion.getIdentificacion(), invoice);
		}
		catch (Exception e)
		{
			error.append(e);
		}
		//fillReceptor(facturaExportacion.getReceptor(), invoice);    	

		try {
			//Durch InvoiceZeilen laufen
			for (MInvoiceLine invoiceLine:invoice.getLines()) {    		
				int numItem = invoiceLine.getLine();
				BigDecimal cantidad = invoiceLine.getQtyInvoiced();
				String codigo = invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName();
				//String codTributo = "20";
				ArrayList<String> tributosItems = new ArrayList<String>();
				tributosItems.add("C3");


				int uniMedida = 1;
				String descripcion = invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName();
				BigDecimal precioUni = invoiceLine.getPriceActual();
				BigDecimal montoDescu = Env.ZERO;
				BigDecimal ventaNoSuj = Env.ZERO;
				BigDecimal ventaExenta = Env.ZERO;
				BigDecimal ventaGravada = Env.ONEHUNDRED;
				if (invoiceLine.getC_Tax().getTaxIndicator().equals("NSUJ"))
					ventaNoSuj = invoiceLine.getLineNetAmt();
				if (!invoiceLine.getC_Tax().getTaxIndicator().equals("EXT"))
					ventaExenta = invoiceLine.getLineNetAmt();
				if (!invoiceLine.getC_Tax().getTaxIndicator().equals("IVA") )
					ventaGravada = invoiceLine.getLineNetAmt(); 
				BigDecimal noGravado = ventaNoSuj.add(ventaNoSuj);
				CuerpoDocumentoItem cuerpoDocumentoItem = new CuerpoDocumentoItem(numItem,  cantidad, codigo, uniMedida, 	descripcion, 
						precioUni, montoDescu,  ventaGravada, tributosItems, noGravado); 
				cuerpoDocumentoItem.validateValues();
				facturaExportacion.getCuerpoDocumento().add(cuerpoDocumentoItem);
			}  		
		}
		catch (Exception e){
			error.append(e);
		}

		validateValues(facturaExportacion, error);

		X_E_InvoiceElectronic invoiceElectronic = new X_E_InvoiceElectronic(getCtx(), 0, get_TrxName());
		invoiceElectronic.setC_Invoice_ID(invoice.getC_Invoice_ID());
		invoiceElectronic.setei_ValidationStatus("01");if (error.length() > 0) {
			invoiceElectronic.seterrMsgIntern(error.toString());
			invoiceElectronic.setei_ValidationStatus("02");
			invoiceElectronic.saveEx();
			return error.toString();
		}    


		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(facturaExportacion);

		invoiceElectronic.setjson(json);
		invoiceElectronic.saveEx();
		log.config(json);
		if (isSaveInHistoric()) {
			//String directory = "C:\\Users\\SHW_User\\Documents\\Json\\"
			//		+ invoice.getDocumentNo() + ".json";



			writeToFile(json, invoice);
		}
		System.out.println("Factura generada: " + invoice.getDocumentNo() + "Estado: " + invoiceElectronic.getei_ValidationStatus());

		return "";
	}



	private void fillIdentification(Identificacion identificacion, MInvoice invoice) {

		identificacion.setNumeroControl(numeroControl);
		identificacion.setCodigoGeneracion(codigoGeneracion);
		identificacion.setTipoModelo(1);
		identificacion.setTipoOperacion(1);

		String fecha = invoice.getDateAcct().toString().substring(0, 10);

		identificacion.setFecEmi(fecha);
		identificacion.setHorEmi("00:00:00");
		identificacion.setTipoMoneda("USD");
		identificacion.setAmbiente("00");

	}

	private void fillemisor(Emisor emisor, MInvoice invoice) {
		emisor.setNit(orgInfo.getTaxID().replace("-", ""));
		emisor.setNrc(StringUtils.leftPad(orgInfo.getDUNS().trim().replace("-", ""), 7));
		emisor.setNombre(client.getName()); 
		emisor.setCodActividad(client.getE_Activity().getValue());
		emisor.setDescActividad(client.getE_Activity().getName());
		emisor.setNombreComercial(client.getDescription());
		emisor.setTipoEstablecimiento(client.getE_PlantType().getValue());
		String departamento = orgInfo.getC_Location().getC_City().getC_Region().getValue();
		String municipio = orgInfo.getC_Location().getC_City().getValue();
		String complemento = orgInfo.getC_Location().getAddress1();
		Direccion direccion = new Direccion(departamento, municipio, complemento);
		emisor.setDireccion(direccion);
		emisor.setTelefono(client.get_ValueAsString("phone"));
		emisor.setCorreo(client.getEMail());
		emisor.setTipoItemExpor(2);
		emisor.setCodPuntoVentaMH(null);
	}

	private void fillReceptor(Receptor receptor, MInvoice invoice) {

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
				String codPais = "";
		String nombrePais = "";
		String complemento = "";
		String departamento = "";
		String municipio = "";
		int tipoPersona;	
		String descActividad;
		Direccion direccion;
	    String telefono=null; // null possible
	    String correo=null; // null possible

		receptor.setNombre(partner.getName());
		if (partner.getE_Recipient_Identification_ID() <=0 || partner.getE_Activity_ID() <=0
				|| partner.getE_BPType_ID() <0) {
			error.append("SdN: Falta configuracion para Fcturacion Electronica");
			return ;
		}
		receptor.setTipoDocumento(partner.getE_Recipient_Identification().getValue());
		if (partner.getE_Recipient_Identification().getValue().equals("36"))
		{
			receptor.setNumDocumento(partner.getTaxID().replace("-", ""));
		}
			//receptor.setNumDocumento(replace(partner.getTaxID(), "-", ""));
		else
			receptor.setNumDocumento(partner.getDUNS());
		receptor.setNombreComercial(partner.getName());
		receptor.setDescActividad(partner.getDescription());
		receptor.setTipoPersona(Integer.valueOf(partner.getE_BPType().getValue()));
		for (MBPartnerLocation partnerLocation : MBPartnerLocation.getForBPartner(getCtx(), partner.getC_BPartner_ID(), get_TrxName())){
			if (partnerLocation.isBillTo()) {
				if (partnerLocation.getC_Location().getC_City_ID() > 0) {
					departamento = partnerLocation.getC_Location().getC_City().getC_Region().getValue();
				}
				municipio =  partnerLocation.getC_Location().getCity();
				complemento = (partnerLocation.getC_Location().getAddress1() + " " + partnerLocation.getC_Location().getAddress2());
				codPais = partnerLocation.getC_Location().getC_Country().getValue();
				nombrePais = partnerLocation.getC_Location().getC_Country().getName();
				break;
			}
		}
		receptor.setCodPais(codPais);
		receptor.setNombrePais(nombrePais);
		receptor.setComplemento(complemento);
		receptor.setCorreo(partner.getEMail());
		receptor.setTelefono(partner.getPhone());
	}



	private void fillResumen(Resumen resumen, MInvoice invoice) {
		
		
		BigDecimal totalGravada = null;
	    String totalLetras = Msg.getAmtInWords(Env.getLanguage(getCtx()), invoice.getGrandTotal().setScale(2).toString());
	    
	    List<PagosItem> pagosItems = new ArrayList<PagosItem>();
		PagosItem pagoitem = new PagosItem("05",
				zero, 
				"Transferencia_ Depósito Bancario", 
				invoice.getC_PaymentTerm().getE_TimeSpan().getValue(),
				invoice.getC_PaymentTerm().getNetDays());
		pagosItems.add(pagoitem);
		resumen.setPagos(pagosItems);

		BigDecimal SaldoFavor = Env.ZERO;
		for (MInvoiceTax invoiceTax:invoiceTaxes) {
				totalGravada = invoiceTax.getTaxBaseAmt();
		}
		resumen.setCondicionOperacion(2);
		resumen.setTotalDescu(totalGravada);
		resumen.setDescuento(Env.ZERO);
		resumen.setPorcentajeDescuento(Env.ZERO);
		resumen.setTotalDescu(Env.ZERO);
		resumen.setMontoTotalOperacion(invoice.getGrandTotal());
		resumen.setTotalNoGravado(Env.ZERO);
		resumen.setTotalGravada(invoice.getGrandTotal());
		resumen.setTotalPagar(invoice.getGrandTotal());
		resumen.setTotalLetras(totalLetras);
	}
			



	private void validateValues(FacturaExportacion facturaExportacion, StringBuffer error) {
		String result = "";
		if (facturaExportacion.getIdentificacion() != null) {
			result = facturaExportacion.getIdentificacion().validateValues();		
			if (!result.equals(VALIDATION_RESULT_OK))
				error.append(result);
		}
		if (facturaExportacion.getReceptor() != null) {
			result = facturaExportacion.getReceptor().validateValues();
			if (!result.equals(VALIDATION_RESULT_OK))
				error.append(result);			
		}

		if (facturaExportacion.getEmisor() != null) {
			result = facturaExportacion.getEmisor().validateValues();
			if (!result.equals(VALIDATION_RESULT_OK))
				error.append(result);			
		}
		if (facturaExportacion.getCuerpoDocumento() != null) {
			for (CuerpoDocumentoItem cuerpoDocumentoItem :facturaExportacion.getCuerpoDocumento()) {
				result = cuerpoDocumentoItem.validateValues();
				if (!result.equals(VALIDATION_RESULT_OK))
					error.append(result);			
			}
		}
	}
	
	private void writeToFile (String json, MInvoice invoice)
	{
		try
		{
			Path path = Paths.get(MSysConfig.getValue("EI_PATH") + "/" + invoice.getDateAcct().toString().substring(0, 10) + "/");
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

}
