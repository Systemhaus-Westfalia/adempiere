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

package org.shw.einvoice.es.fefcfacturaelectronicav1;


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
import org.compiere.model.MTax;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.shw.einvoice.es.util.pojo.ApendiceItem;
import org.shw.einvoice.es.util.pojo.Direccion;
import org.shw.einvoice.es.util.pojo.Emisor;
import org.shw.einvoice.es.util.pojo.Extension;
import org.shw.einvoice.es.util.pojo.PagosItem;

import com.fasterxml.jackson.databind.ObjectMapper;

/** Generated Process for (SHW_Create_ElectronicInvoice)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_CreateInvoice_Factura_SV extends EI_CreateInvoice_Factura_SVAbstract
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
		// TODO Auto-generated method stub
	
	
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
		System.out.println("Process EI_CreateInvoice_FacturaExport_SV : Started with Invoice " + invoice.getDocumentNo());
																											   
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
		numeroControl = "DTE-01-" + StringUtils.leftPad(duns.trim(), 8,"0") + "-"+ idIdentification;
	    //final String PATTERN = "^[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}$";
		Integer clientID = (Integer)client.getAD_Client_ID();
		codigoGeneracion = StringUtils.leftPad(clientID.toString(), 8, "0") + "-0000-0000-0000-" + StringUtils.leftPad(id.toString(), 12,"0");
		if (invoice.getC_DocType().getE_DocType_ID()<= 0 ||
				!invoice.getC_DocType().getE_DocType().getValue().equals(Identificacion.TIPO_DE_DOCUMENTO)) {
			error.append("el documento no es Factura");
			System.out.println("el documento no es Factura de Exportacion");
			return error.toString();
		}
		FacturaElectronica facturaElectronica   = new FacturaElectronica();

		try
		{
			fillReceptor(facturaElectronica.getReceptor(), invoice);  
		}
		catch (Exception e)
		{
			error.append(e);
		}
		try
		{
			fillemisor(facturaElectronica.getEmisor(), invoice);   
		}
		catch (Exception e)
		{
			error.append(e);
		}		
		try
		{
			fillResumen(facturaElectronica.getResumen(), invoice);  
		}
		catch (Exception e)
		{
			error.append(e);
		}
		try
		{
			fillIdentification(facturaElectronica.getIdentificacion(), invoice);
		}
		catch (Exception e)
		{
			error.append(e);
		}
		//Durch InvoiceZeilen laufen
		for (MInvoiceLine invoiceLine:invoice.getLines()) { 
			System.out.println("Fill Cuerpo Documento: " + invoice.getDocumentNo() + " Line: " + invoiceLine.getLine() );

			int numItem = invoiceLine.getLine();
			int tipoItem = 2;
			String numeroDocumento = numeroControl;
			BigDecimal cantidad = invoiceLine.getQtyInvoiced();
			String codigo = invoiceLine.getM_Product_ID()>0? invoiceLine.getProduct().getValue(): invoiceLine.getC_Charge().getName();
			//String codTributo = "20";
			ArrayList<String> tributosItems = new ArrayList<String>();
			//TributosItem tributosItem = new TributosItem("20", "", invoiceLine.getTaxAmt());
			//tributosItems.add("20");

			int uniMedida = 1;
			String descripcion = invoiceLine.getM_Product_ID()>0?invoiceLine.getM_Product().getName():invoiceLine.getC_Charge().getName();
			BigDecimal precioUni = invoiceLine.getPriceActual();
			BigDecimal montoDescu = Env.ZERO;
			BigDecimal ventaNoSuj = Env.ZERO;
			BigDecimal ventaExenta = Env.ZERO;
			BigDecimal ventaGravada = Env.ONEHUNDRED;
			BigDecimal ivaItem = Env.ZERO;
			if (invoiceLine.getC_Tax().getTaxIndicator().equals("NSUJ"))
				ventaNoSuj = invoiceLine.getLineNetAmt();
			if (invoiceLine.getC_Tax().getTaxIndicator().equals("EXT"))
				ventaExenta = invoiceLine.getLineNetAmt();
			if (invoiceLine.getC_Tax().getTaxIndicator().equals("IVA") ) {
				ventaGravada = invoiceLine.getLineNetAmt(); 
				MTax tax = (MTax)invoiceLine.getC_Tax();
				if (invoiceLine.getTaxAmt().compareTo(Env.ZERO) == 0)
					ivaItem = tax.calculateTax(invoiceLine.getLineNetAmt(), invoice.getM_PriceList().isTaxIncluded(), 2);
			}
			BigDecimal psv = invoiceLine.getTaxAmt();
			BigDecimal noGravado = ventaNoSuj.add(ventaNoSuj);
			CuerpoDocumentoItem cuerpoDocumentoItem = new CuerpoDocumentoItem(numItem, tipoItem, numeroDocumento, cantidad, codigo, 
					null, uniMedida, 
					descripcion, precioUni, montoDescu, ventaNoSuj, ventaExenta, ventaGravada, null, psv, noGravado,ivaItem); 
			cuerpoDocumentoItem.validateValues();
			facturaElectronica.getCuerpoDocumento().add(cuerpoDocumentoItem);
			System.out.println("Fill Cuerpo Documento: " + invoice.getDocumentNo() + " Line: " + invoiceLine.getLine() + " Finished");

		}  

		validateValues(facturaElectronica, error);

    	X_E_InvoiceElectronic invoiceElectronic = new X_E_InvoiceElectronic(getCtx(), 0, get_TrxName());
    	invoiceElectronic.setC_Invoice_ID(invoice.getC_Invoice_ID());
    	invoiceElectronic.setei_ValidationStatus("01");
    	if (error.length() > 0) {
    		invoiceElectronic.seterrMsgIntern(error.toString());
    		invoiceElectronic.setei_ValidationStatus("02");
        	invoiceElectronic.saveEx();
    		return error.toString();
    	}    
	
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	String json = objectMapper.writeValueAsString(facturaElectronica);

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

		System.out.println("Start fillIdentificacion");
		identificacion.setNumeroControl(numeroControl);
		identificacion.setCodigoGeneracion(codigoGeneracion);
		identificacion.setTipoModelo(1);
		identificacion.setTipoOperacion(1);
		
		String fecha = invoice.getDateAcct().toString().substring(0, 10);
		  
		identificacion.setFecEmi(fecha);
		identificacion.setHorEmi("00:00:00");
		identificacion.setTipoMoneda("USD");
		identificacion.setAmbiente("00");
		System.out.println("fillIdentificacion Finished");

	}
	
	private void fillemisor(Emisor emisor, MInvoice invoice) {
		System.out.println("Start fillEmisor");
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
		System.out.println("fillEmisor Finished");
	}
	
	private void fillReceptor(Receptor receptor, MInvoice invoice) {

		System.out.println("Start fillemisor");

		MBPartner partner = (MBPartner)invoice.getC_BPartner();
		if (partner.getE_Activity_ID()<=0 || partner.getE_Recipient_Identification_ID() <= 0) {
			error.append("SdN: Falta configuracion para Facturacion Electronica");
			return;
		}
		receptor.setTipoDocumento(partner.getE_Recipient_Identification().getValue());
		if (receptor.getTipoDocumento().equals("36"))

			receptor.setNumDocumento(partner.getTaxID().replace("-", ""));
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
		receptor.setTelefono("79309099");
		receptor.setCorreo(partner.get_ValueAsString("EMail"));	
		System.out.println("fillemisor Finished");

	}
	
	
	
	private void fillResumen(Resumen resumen, MInvoice invoice) {
		System.out.println("Start fillResumenr");


		//List<TributosItem> tributos;
		//List<PagosItem> pagos ;  // there must be at least one item

		BigDecimal TotalNoSuj = Env.ZERO;
		BigDecimal TotalExenta = Env.ZERO;
		BigDecimal TotalGravada = Env.ZERO;
		BigDecimal SubTotalVentas = Env.ZERO;
		BigDecimal DescuNoSuj = Env.ZERO;
		BigDecimal DescuExenta = Env.ZERO;
		BigDecimal DescuGravada = Env.ZERO;
		BigDecimal PorcentajeDescuento = Env.ZERO;
		BigDecimal SubTotal = invoice.getTotalLines();
		BigDecimal IvaPerci1 = Env.ZERO;
		BigDecimal IvaRete1 = Env.ZERO;
		BigDecimal MontoTotalOperacion = invoice.getGrandTotal();
		BigDecimal TotalPagar =invoice.getGrandTotal();
		BigDecimal totalIVA = Env.ZERO;

		int CondicionOperacion =2;
		List<PagosItem> pagosItems = new ArrayList<PagosItem>();
		PagosItem pagoitem = new PagosItem("05",
				zero, 
				"Transferencia_ Depósito Bancario", 
				invoice.getC_PaymentTerm().getE_TimeSpan().getValue(),
				invoice.getC_PaymentTerm().getNetDays());
		pagosItems.add(pagoitem);
		resumen.setPagos(pagosItems);

		String TotalLetras=Msg.getAmtInWords(Env.getLanguage(getCtx()), invoice.getGrandTotal().setScale(2).toString());
		BigDecimal SaldoFavor = Env.ZERO;
		for (MInvoiceTax invoiceTax:invoiceTaxes) {
			if (invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ")) {
				TotalNoSuj = invoiceTax.getTaxBaseAmt();
			}
			if (!invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ") && invoiceTax.getC_Tax().getRate().doubleValue()==0.00)
				TotalExenta = invoiceTax.getTaxBaseAmt();
			if (!invoiceTax.getC_Tax().getTaxIndicator().equals("NSUJ") && invoiceTax.getC_Tax().getRate().doubleValue()!=0.00) {
				TotalGravada = invoiceTax.getTaxBaseAmt();
				totalIVA = invoiceTax.getTaxAmt();
			}

		}

		resumen.setTotalNoSuj(TotalNoSuj);
		resumen.setTotalExenta(TotalExenta);
		resumen.setTotalGravada(TotalGravada);
		resumen.setSubTotalVentas(TotalGravada.add(TotalNoSuj).add(TotalExenta));
		resumen.setDescuNoSuj(DescuNoSuj);
		resumen.setDescuExenta(DescuExenta);
		resumen.setDescuGravada(DescuGravada);
		resumen.setPorcentajeDescuento(PorcentajeDescuento);
		resumen.setSubTotal(TotalGravada.add(TotalNoSuj).add(TotalExenta));
		resumen.setIvaRete1(IvaRete1);
		resumen.setMontoTotalOperacion(invoice.getGrandTotal());
		resumen.setTotalNoGravado(TotalExenta.add(TotalNoSuj));
		resumen.setTotalPagar(invoice.getGrandTotal());
		resumen.setTotalLetras(TotalLetras);
		resumen.setSaldoFavor(invoice.getGrandTotal());
		resumen.setCondicionOperacion(1);
		resumen.setTotalDescu(Env.ZERO);
		resumen.setReteRenta(Env.ZERO);
		resumen.setTotalIva(totalIVA);
		System.out.println("fillResumenr Finished");


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
	

	private void validateValues(FacturaElectronica facturaElectronica, StringBuffer error) {

		System.out.println("Start validateValues");
		System.out.println("Start Resumen validateValues");
		String result = "";
		
		if (facturaElectronica.getResumen() != null)
		{
			result = facturaElectronica.getResumen().validateValues();
			if (!result.equals(VALIDATION_RESULT_OK))
				error.append(result);
		}

		System.out.println("Start Identification validateValues");
		if (facturaElectronica.getIdentificacion() != null) {
			result = facturaElectronica.getIdentificacion().validateValues();
			if (!result.equals(VALIDATION_RESULT_OK))
				error.append(result);
		}

		System.out.println("Start Receptor validateValues");
		if (facturaElectronica.getReceptor() != null){
			result = facturaElectronica.getReceptor().validateValues();
			if (!result.equals(VALIDATION_RESULT_OK))
				error.append(result);
		}

		System.out.println("Start Cuerpo Documento validateValues");
		if (facturaElectronica.getCuerpoDocumento() != null) {
			for (CuerpoDocumentoItem cuerpoDocumentoItem :facturaElectronica.getCuerpoDocumento()) {
				result = cuerpoDocumentoItem.validateValues();
				if (!result.equals(VALIDATION_RESULT_OK))
					error.append(result);			
			}			
		}

		System.out.println("validateValues Finished");


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