/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2008 e-Evolution,SC. All Rights Reserved.               *
 * Contributor(s): Victor Perez www.e-evolution.com                           *
 *****************************************************************************/
package org.shw.process;


import java.math.BigDecimal;
import java.sql.Timestamp;

import org.compiere.model.MBankAccount;
import org.compiere.model.MPayment;
import org.compiere.util.DB;
import org.compiere.util.Env;
 
/**
 *  Bank Transfer. Generate two Payments entry
 *  
 *  For Bank Transfer From Bank Account "A" 
 *                 
 *	@author Susanne Calderon Not Used
 *	
 **/
public class BankTransfer extends BankTransferAbstract
{
	/**
	 *  Prepare - e.g., get Parameters.
	 */
	protected void prepare()
	{
		super.prepare();
	}	//	prepare

	/**
	 *  Perform process.
	 *  @return Message (translated text)
	 *  @throws Exception if not successful
	 */
	protected String doIt() throws Exception
	{
		
				Timestamp statementDate = getStatementDate();
				Timestamp dateAcct = getDateAcct();
				int projectID = getProcessId();
		        if (getCBankAccountId() == getBankAccountToId())
		            return "Banco origen = banco destino" ;
		        
		        
		    
		        if (getAmount().compareTo(new BigDecimal(0)) == 0)
		            return "El monto es cero";

		        //    Login Date
		        if (getStatementDate() == null)
		        	statementDate = Env.getContextAsDate(getCtx(), "#Date");
		        if (getStatementDate() == null)
		        	statementDate = new Timestamp(System.currentTimeMillis());            

		        if (getDateAcct() == null)
		            dateAcct = getStatementDate();


		        int         m_created = 0;
		        MBankAccount mBankFrom = new MBankAccount(getCtx(),getCBankAccountId(), get_TrxName());
		        MBankAccount mBankTo = new MBankAccount(getCtx(),getBankAccountToId(), get_TrxName());
		        
		        MPayment paymentBankFrom = new MPayment(getCtx(), 0 ,  get_TrxName());
		        paymentBankFrom.setC_BankAccount_ID(mBankFrom.getC_BankAccount_ID());
		        paymentBankFrom.setC_DocType_ID(false);
		        String value = DB.getDocumentNo(paymentBankFrom.getC_DocType_ID(),get_TrxName(), false,  paymentBankFrom);
		        paymentBankFrom.setDocumentNo(value);
		       // paymentBankFrom.setDocumentNo(P_DocumentNo);
		        
		        paymentBankFrom.setDateAcct(dateAcct);
		        paymentBankFrom.setDateTrx(statementDate);
		        paymentBankFrom.setTenderType(getTenderType());
		        paymentBankFrom.setDescription(getDescription());
		        paymentBankFrom.setC_BPartner_ID (getBPartnerId());
		        paymentBankFrom.setC_Currency_ID(getCurrencyId());
		        if (getConversionTypeId() > 0)
		        paymentBankFrom.setC_ConversionType_ID(getConversionTypeId());    
		        paymentBankFrom.setPayAmt(getAmount());
		        paymentBankFrom.setOverUnderAmt(Env.ZERO);
		        paymentBankFrom.setC_Charge_ID(getChargeId());
		        paymentBankFrom.setCheckNo(getCheckNo());
		        if (projectID > 0)
		            paymentBankFrom.setC_Project_ID(projectID);
		        if (getOrgId() > 0)
		            paymentBankFrom.setAD_Org_ID(getOrgId());
		        if (getUser1Id() > 0)
		            paymentBankFrom.setUser1_ID(getUser1Id());
		        paymentBankFrom.saveEx();
		        paymentBankFrom.processIt(MPayment.DOCACTION_Complete);
		        paymentBankFrom.saveEx();
		        
		        MPayment paymentBankTo = new MPayment(getCtx(), 0 ,  get_TrxName());
		        paymentBankTo.setC_BankAccount_ID(mBankTo.getC_BankAccount_ID());
		        paymentBankTo.setC_DocType_ID(true);
		        value = DB.getDocumentNo(paymentBankTo.getC_DocType_ID(),get_TrxName(), false,  paymentBankTo);
		        paymentBankTo.setDocumentNo(value);
		      //  paymentBankTo.setDocumentNo(P_DocumentNo);
		        paymentBankTo.setDateAcct(dateAcct);
		        paymentBankTo.setDateTrx(statementDate);
		        paymentBankTo.setTenderType(getTenderType());
		        paymentBankTo.setDescription(getDescription());
		        paymentBankTo.setC_BPartner_ID (getBPartnerId());
		        paymentBankTo.setC_Currency_ID(getCurrencyId());
		        if (getConversionTypeId() > 0)
		            paymentBankFrom.setC_ConversionType_ID(getConversionTypeId());    
		        paymentBankTo.setPayAmt(getAmount());
		        paymentBankTo.setOverUnderAmt(Env.ZERO);
		        paymentBankTo.setC_Charge_ID(getChargeId());
		        paymentBankTo.setRef_Payment_ID(paymentBankFrom.getC_Payment_ID());

		        if (getProjectId() > 0)
		            paymentBankTo.setC_Project_ID(getProjectId());
		        if (getOrgId() > 0)
		            paymentBankTo.setAD_Org_ID(getOrgId());
		        if (getUser1Id() > 0)
		            paymentBankTo.setUser1_ID(getUser1Id());
		        paymentBankTo.saveEx();
		        paymentBankTo.processIt(MPayment.DOCACTION_Complete);
		        paymentBankTo.saveEx();

		        paymentBankFrom.setRef_Payment_ID(paymentBankTo.getC_Payment_ID());
		        paymentBankFrom.saveEx();
		        m_created++;

		    
		        return "@Created@ = " + m_created;
	}	//	doIt
	
}