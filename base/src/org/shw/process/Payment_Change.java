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

package org.shw.process;

import org.compiere.model.MFactAcct;
import org.compiere.model.MPayment;
import org.compiere.model.MPeriod;

/** Generated Process for (ChangePayment)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.3
 */
public class Payment_Change extends Payment_ChangeAbstract
{
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{
		MPayment payment = new MPayment(getCtx(), getRecord_ID(), get_TrxName() );

		//		    Can we delete posting
		int no = 0;
		String docbasetype = payment.isReceipt()?"ARR":"APP";
		Boolean openPeriod = MPeriod.isOpen(getCtx(), payment.getDateAcct(), docbasetype , payment.getAD_Org_ID(),get_TrxName());
		if (!openPeriod)
			return "Periodo Cerrado";
		no = MFactAcct.deleteEx(MPayment.Table_ID,  getRecord_ID(), get_TrxName());

		if (getChargeId() !=0){
			payment.setC_Charge_ID(getChargeId());
		}
		if (getBankAccountId() != 0){
			payment.setC_BankAccount_ID(getBankAccountId());
		}
		if (getBPartnerId() != 0){
			payment.setC_BPartner_ID(getBPartnerId());
		}
		if (getDocumentNo() != null){
			payment.setDocumentNo(getDocumentNo());
		}
		if (getTenderType() != null){
			payment.setTenderType(getTenderType());
		}

		if (getDateTrx() != null){
			payment.setDateTrx(getDateTrx()); 
			payment.setDateAcct(getDateTrx());
		}

		payment.setPosted (false);
		payment.saveEx();
		return payment.getDocumentNo();
	}
}