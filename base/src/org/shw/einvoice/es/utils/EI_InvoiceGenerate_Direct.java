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

package org.shw.einvoice.es.utils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MClient;
import org.compiere.model.MInvoice;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfo;
import org.compiere.util.Env;
import org.eevolution.services.dsl.ProcessBuilder;

/** Generated Process for (EI_InvoiceGenerate_Direct)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_InvoiceGenerate_Direct extends EI_InvoiceGenerate_DirectAbstract
{
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{
		
		MClient client = new MClient(getCtx(),Env.getAD_Client_ID(getCtx()), get_TrxName());
		Timestamp startdate = (Timestamp)(client.get_Value("ei_Startdate"));
		String whereClause = "issotrx = 'Y' AND processed = 'Y' AND dateacct>=? "
				+ " AND ei_Processing = 'N' AND (ei_validationstatus is null OR ei_validationstatus = '02')";
		List<MInvoice> invoices = new Query(getCtx(), MInvoice.Table_Name, whereClause, get_TrxName())
				.setClient_ID()
				.setParameters(startdate)
				.list();
		invoices.stream()
		.filter(invoice -> invoice.getC_DocType().getE_DocType_ID() >0)
		.forEach(invoice -> {
			
		});
		return "";
	 }
		
		private void processingInvoice(MInvoice invoice) {

            ProcessInfo processInfo = ProcessBuilder.create(getCtx())
                    .process(EI_CreateInvoice_Electronic.getProcessId())
                    .withParameter(MInvoice.COLUMNNAME_C_Invoice_ID, invoice.getC_Invoice_ID())
                    .withoutTransactionClose()
                    .execute(get_TrxName());
            if (processInfo.isError()) {

                throw new AdempiereException(processInfo.getSummary());
            }

            addLog(processInfo.getSummary());
   
		
		
		return ;
	}
}