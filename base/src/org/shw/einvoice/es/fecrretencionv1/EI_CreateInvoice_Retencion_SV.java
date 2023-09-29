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

package org.shw.einvoice.es.fecrretencionv1;

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
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceTax;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.Direccion;
import org.shw.einvoice.es.util.pojo.OtrosDocumentosItem;
import org.shw.einvoice.es.util.pojo.VentaTercero;
import org.shw.model.MLCOInvoiceWithholding;

import com.fasterxml.jackson.databind.ObjectMapper;

/** Generated Process for (EI_CreateInvoice_Retencion_SV)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_CreateInvoice_Retencion_SV extends EI_CreateInvoice_Retencion_SVAbstract
{
	static final String VALIDATION_RESULT_OK = "OK";

	String 				numeroControl;
	String 				codigoGeneracion;
	MClient				client = null;
	MOrgInfo 			orgInfo = null;
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
		MInvoice invoice = new MInvoice(getCtx(), getInvoiceId(), get_TrxName());		
		List<MLCOInvoiceWithholding> invoiceWithholdings = new Query(getCtx(), MLCOInvoiceWithholding.Table_Name, 
				" C_Invoice_ID=?", get_TrxName())
				.setParameters(getInvoiceId())
				.list();
		Boolean existsRetencion = false;
		existsRetencion = !invoiceWithholdings.isEmpty();		
		if (!existsRetencion) {
			System.out.println("No hay retenciones en este Credito Fiscal " + invoice.getDocumentNo());
			return "";
		}			
		System.out.println("Process EI_CreateInvoice_Retencion_SV : Started with Invoice " + invoice.getDocumentNo());
																					   
		
		int orgID = invoice.getAD_Org_ID();
		orgInfo= MOrgInfo.get(getCtx(), orgID, get_TrxName());
		Integer id = invoice.get_ID();
		client = new MClient(getCtx(), invoice.getAD_Client_ID(), get_TrxName());
		String prefix = invoice.getC_DocType().getDefiniteSequence().getPrefix();
		String suffix = invoice.getC_DocType().getDefiniteSequence().getSuffix();
		String documentno = invoice.getDocumentNo().replace(prefix,"");
		documentno = documentno.replace(suffix, "");
		String idIdentification  = StringUtils.leftPad(documentno, 15,"0");
		String duns = orgInfo.getDUNS().replace("-", "");
		Retencion comprobanteRetencion   = new Retencion();
		numeroControl = "DTE-" + comprobanteRetencion.getIdentificacion().getTipoDte()
				+ "-"+ StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
	    //final String PATTERN = "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$";
		Integer clientID = (Integer)client.getAD_Client_ID();
		codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(id.toString(), 12,"0");
		

		

		try
		{
			fillReceptor(comprobanteRetencion.getReceptor(), invoice);  
		}
		catch (Exception e)
		{
			error.append(e);
		}
		try
		{
			fillemisor(comprobanteRetencion.getEmisor(), invoice);  	
		}
		catch (Exception e)
		{
			error.append(e);
		}
		try
		{
			fillResumen(comprobanteRetencion.getResumen(), invoice, invoiceWithholdings);  	
		}
		catch (Exception e)
		{
			error.append(e);
		}
		try
		{
			fillIdentification(comprobanteRetencion.getIdentificacion(), invoice);
		}
		catch (Exception e)
		{
			error.append(e);
		}
    	   	
    	    	
    	//Durch InvoiceZeilen laufen
		try {
			int i = 1;
    	for (MLCOInvoiceWithholding invoiceWithholding:invoiceWithholdings) { 
    		
    		int numItem = i;
    		String tipoDte = invoiceWithholding.getC_Invoice().getC_DocType().getE_DocType().getValue();
    		int tipoDoc = 1;
    		String numDocumento = numeroControl;
    		BigDecimal montoSujetoGrav = invoiceWithholding.getTaxBaseAmt();
    		String codigoRetencionMH = invoiceWithholding.getC_Tax().getE_WithholdingType().getValue();
    		BigDecimal ivaRetenido = invoiceWithholding.getTaxAmt();
    		String descripcion = invoiceWithholding.getC_Tax().getE_WithholdingType().getName();
    		String fechaEmision = invoiceWithholding.getC_Invoice().getDateAcct().toString().substring(0, 10);
    		
    		
    		CuerpoDocumentoItem cuerpoDocumentoItem = 
    				new CuerpoDocumentoItem(numItem, tipoDte, tipoDoc, numDocumento, fechaEmision, montoSujetoGrav, 
    						codigoRetencionMH, ivaRetenido, descripcion);
    		
    		cuerpoDocumentoItem.validateValues();
    		comprobanteRetencion.getCuerpoDocumento().add(cuerpoDocumentoItem);
			System.out.println("Fill Cuerpo Documento: " + invoice.getDocumentNo() + " Line: " + invoiceWithholding.getC_Tax().getName() + " Finished");
    	}  
	}
		catch (Exception e)
		{
			error.append(e);
		}
    	validateValues(comprobanteRetencion, error);
    	
    	X_E_InvoiceElectronic invoiceElectronic = new X_E_InvoiceElectronic(getCtx(), 0, get_TrxName());
    	invoiceElectronic.setC_Invoice_ID(invoice.getC_Invoice_ID());
    	invoiceElectronic.setei_numeroControl(numeroControl);
    	invoiceElectronic.setei_ValidationStatus("01");
    	if (error != null && error.length() > 0) {
    		invoiceElectronic.seterrMsgIntern(error.toString());
    		invoiceElectronic.setei_ValidationStatus("02");
        	invoiceElectronic.saveEx();
    		return error.toString();
    	}    
	
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	String json = objectMapper.writeValueAsString(comprobanteRetencion);

       	invoiceElectronic.setjson(json);
    	invoiceElectronic.saveEx();
    	log.config(json);
    	if (isSaveInHistoric()) {
    		Path rootpath = Paths.get(absDirectory);
    		if (!Files.exists(rootpath)) {
    			invoiceElectronic.seterrMsgIntern("Root File From MSystConfig EI_PATH does not exist");
    		}
    		writeToFile(json, invoice);
    	}
		
    	System.out.println("Factura generada: " + invoice.getDocumentNo() + "Estado: " + invoiceElectronic.getei_ValidationStatus());
    	System.out.println(json);	    	
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
		identificacion.setAmbiente(client.getE_Enviroment().getValue());

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
	}
	
	private void fillReceptor(Receptor receptor, MInvoice invoice) {

		MBPartner partner = (MBPartner)invoice.getC_BPartner();

		if (partner.getE_Activity_ID()<0 || partner.getE_Recipient_Identification_ID() <= 0) {
			error.append("SdN: Falta configuracion para Facturacion Electronica");
			return;
		}
		receptor.setTipoDocumento(partner.getE_Recipient_Identification().getValue());
		receptor.setNumDocumento(partner.getTaxID().replace("-", ""));
		receptor.setNrc(partner.getDUNS().trim().replace("-", ""));
		receptor.setNombre(partner.getName());
		receptor.setCodActividad(partner.getE_Activity().getValue());
		receptor.setDescActividad(partner.getE_Activity().getName());
		String departamento = "";
		String municipio = "";
		String complemento = "";
		for (MBPartnerLocation partnerLocation : MBPartnerLocation.getForBPartner(getCtx(), partner.getC_BPartner_ID(), get_TrxName())){
			if (partnerLocation.isBillTo()) {
				departamento = partnerLocation.getC_Location().getC_City().getC_Region().getValue();
				municipio =  partnerLocation.getC_Location().getC_City().getValue();
				complemento = (partnerLocation.getC_Location().getAddress1() + " " + partnerLocation.getC_Location().getAddress2());
				break;
			}
		}
		Direccion direccion = new Direccion(departamento, municipio, complemento);
		receptor.setDireccion(direccion);
		receptor.setTelefono(partner.getPhone());
		receptor.setCorreo(partner.get_ValueAsString("EMail"));		
	}
	
	private void fillOtrosDocumentosItem(OtrosDocumentosItem otrosDocumentosItem, MInvoice invoice) {
		otrosDocumentosItem.setCodDocAsociado(1);
	}
	
	private void fillVentaTercero(VentaTercero ventaTercero, MInvoice invoice) {
		ventaTercero.setNit("41615488187047");
		ventaTercero.setNombre("Mi Presidente");
		
	}
	
	private void fillResumen(Resumen resumen, MInvoice invoice,
			List<MLCOInvoiceWithholding> invoiceWithholdings) {
		BigDecimal	totalSujetoRetencion = Env.ZERO;
		BigDecimal totalIVAretenido = Env.ZERO;
		for (MLCOInvoiceWithholding invoiceWithholding: invoiceWithholdings) {
			totalSujetoRetencion = totalSujetoRetencion.add(invoiceWithholding.getTaxBaseAmt());
			totalIVAretenido = totalIVAretenido.add(invoiceWithholding.getTaxAmt());
		}
		String totalIVAretenidoLetras=Msg.getAmtInWords(Env.getLanguage(getCtx()), totalIVAretenido.setScale(2).toString());
		resumen.setTotalIVAretenido(totalIVAretenido);
		resumen.setTotalIVAretenidoLetras(totalIVAretenidoLetras);
		resumen.setTotalSujetoRetencion(totalSujetoRetencion);
	}
	
	private void fillExtension(Extension extension, MInvoice invoice) {
		extension.setDocuEntrega("555");
		extension.setDocuRecibe("555");
		extension.setNombEntrega("55");
		extension.setNombRecibe("55");
		extension.setObservaciones("55");
		//extension.setPlacaVehiculo("");
		
	}
	
	private void fillApendiceItem(ApendiceItem apendiceItem, MInvoice invoice) {
		apendiceItem.setCampo("11");
		apendiceItem.setEtiqueta("777");
		apendiceItem.setValor("uu");
	}
	

	private void validateValues(Retencion comprobantereteRetencion, StringBuffer error) {
		String result = "";
		/*
		 * if (comprobantereteRetencion.getResumen() != null) { result =
		 * comprobantereteRetencion.getResumen().validateValues(); if
		 * (!result.equals(VALIDATION_RESULT_OK)) error.append(result); } if
		 * (comprobantereteRetencion.getIdentificacion() != null) { result =
		 * comprobantereteRetencion.getIdentificacion().validateValues(); if
		 * (!result.equals(VALIDATION_RESULT_OK)) error.append(result); }
		 */

		if (comprobantereteRetencion.getCuerpoDocumento() != null) {
			for (CuerpoDocumentoItem cuerpoDocumentoItem :comprobantereteRetencion.getCuerpoDocumento()) {
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

}