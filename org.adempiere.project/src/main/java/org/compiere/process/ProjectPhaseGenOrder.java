/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
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
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.process;


import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;

import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MProject;
import org.compiere.model.MProjectLine;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.util.Env;


/**
 *  Generate Order from Project Phase
 *
 *	@author Jorg Janke
 *	@version $Id: ProjectPhaseGenOrder.java,v 1.2 2006/07/30 00:51:01 jjanke Exp $
 *  @author Carlos Parada, cparada@erpya.com, ERPCyA http://www.erpya.com
 *  <a href="https://github.com/adempiere/adempiere/issues/1728">
	@see FR [ 1728 ] Add Support to Generate Sales Order On Credit or Quotation </a>

 *  
 */
public class ProjectPhaseGenOrder  extends ProjectPhaseGenOrderAbstract
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
	 *  @return Message (clear text)
	 *  @throws Exception if not successful
	 */
	protected String doIt() throws Exception
	{
		//FR [ 1728 ]
		String docSOSubType = getDocSubTypeSO();
		log.info("doIt - C_ProjectPhase_ID=" + getRecord_ID());
		if (getRecord_ID() == 0) {
			if (getTable_ID()==MProjectPhase.Table_ID)
				throw new IllegalArgumentException("C_ProjectPhase_ID == 0");
			if (getTable_ID()==MProject.Table_ID)
				throw new IllegalArgumentException("C_Project_ID == 0");
			else
				throw new IllegalArgumentException("Record_ID == 0");
		}
		
		//MOrder order = null;
		List<MProjectPhase> p_Phases = new ArrayList<MProjectPhase>();

		MProject fromProject = null;
		String p_Description = "";
		AtomicInteger count = new AtomicInteger(0);
		
		if (getTable_ID()==MProjectPhase.Table_ID) { 
			MProjectPhase fPhase = new MProjectPhase (getCtx(), getRecord_ID(), get_TrxName());
			fromProject = ProjectGenOrder.getProject (getCtx(), fPhase.getC_Project_ID(), get_TrxName());
			p_Description = fPhase.getName();
			p_Phases.add(fPhase);
		}else if (getTable_ID()==MProject.Table_ID) {
			fromProject = ProjectGenOrder.getProject (getCtx(), getRecord_ID(), get_TrxName());
			p_Description = fromProject.getName();
			p_Phases = fromProject.getPhases();
		}else 
			return "";
		
		MOrder order = new MOrder (fromProject, true, docSOSubType); 
		order.setDescription(order.getDescription() + " - " + p_Description);
		order.saveEx();
		
		for (MProjectPhase fromPhase : p_Phases) {
			//	Create an order on Phase Level
			if (fromPhase.getM_Product_ID() != 0) {
				MOrderLine orderLine = new MOrderLine(order);
				orderLine.setLine(fromPhase.getSeqNo());
				StringBuilder stringBuilder = new StringBuilder(fromPhase.getName());
				if (fromPhase.getDescription() != null && fromPhase.getDescription().length() > 0)
					stringBuilder.append(" - ").append(fromPhase.getDescription());
				orderLine.setDescription(stringBuilder.toString());
				//
				orderLine.setM_Product_ID(fromPhase.getM_Product_ID(), true);
				orderLine.setQty(fromPhase.getQty());
				orderLine.setC_Project_ID(fromProject.getC_Project_ID());
				orderLine.setC_ProjectPhase_ID(fromPhase.getC_ProjectPhase_ID());
				orderLine.setPrice();
				if (docSOSubType.equals(MOrder.DocSubTypeSO_OnCredit)) {
					if (fromPhase.getPriceActual() != null && fromPhase.getPriceActual().compareTo(Env.ZERO) != 0)
						orderLine.setPrice(fromPhase.getPriceActual());
				}else if (docSOSubType.equals(MOrder.DocSubTypeSO_Proposal) 
							|| docSOSubType.equals(MOrder.DocSubTypeSO_Quotation)) {
					if (fromPhase.getQty().compareTo(Env.ZERO)!=0)
						orderLine.setPrice(fromPhase.getPlannedAmt().divide(fromPhase.getQty(), MathContext.DECIMAL128));
				}
				orderLine.setTax();
				if (!orderLine.save())
					log.log(Level.SEVERE, "doIt - Lines not generated");
				return "@C_Order_ID@ " + order.getDocumentNo() + " (1)";
			}
	
			//	Project Phase Lines
			List<MProjectLine> projectLines = fromPhase.getLines();
			projectLines.stream()
					.forEach(projectLine -> {
						MOrderLine orderLine = new MOrderLine(order);
						orderLine.setLine(projectLine.getLine());
						orderLine.setDescription(projectLine.getDescription());
						//
						orderLine.setM_Product_ID(projectLine.getM_Product_ID(), true);
						orderLine.setQty(projectLine.getPlannedQty().subtract(projectLine.getInvoicedQty()));
						orderLine.setPrice();
						if (projectLine.getPlannedPrice() != null && projectLine.getPlannedPrice().compareTo(Env.ZERO) != 0)
							orderLine.setPrice(projectLine.getPlannedPrice());
						orderLine.setDiscount();
						orderLine.setTax();
						orderLine.setC_Project_ID(projectLine.getC_Project_ID());
						orderLine.setC_ProjectPhase_ID(projectLine.getC_ProjectPhase_ID());
						orderLine.saveEx();
						count.getAndUpdate(no -> no + 1);
					});    //	for all lines
			if (projectLines.size() != count.get())
				log.log(Level.SEVERE, "Lines difference - ProjectLines=" + projectLines.size() + " <> Saved=" + count.get());
	
			//	Project Tasks
			List<MProjectTask> tasks = fromPhase.getTasks();
			tasks.stream()
					.forEach(fromTask -> {
						{
							MOrderLine orderLine = new MOrderLine(order);
							orderLine.setLine(fromTask.getSeqNo());
							StringBuilder stringBuilder = new StringBuilder(fromTask.getName());
							if (fromTask.getDescription() != null && fromTask.getDescription().length() > 0)
								stringBuilder.append(" - ").append(fromTask.getDescription());
							orderLine.setDescription(stringBuilder.toString());
							orderLine.setM_Product_ID(fromTask.getM_Product_ID(), true);
							orderLine.setQty(fromTask.getQty());
							orderLine.setPrice();
							if (docSOSubType.equals(MOrder.DocSubTypeSO_Proposal) 
									|| docSOSubType.equals(MOrder.DocSubTypeSO_Quotation)) {
								if (fromTask.getQty().compareTo(Env.ZERO)!=0)
								orderLine.setPrice(fromTask.getPlannedAmt().divide(fromTask.getQty(), MathContext.DECIMAL128));
							}
							orderLine.setC_Project_ID(fromTask.getC_ProjectPhase().getC_Project_ID());
							orderLine.setC_ProjectPhase_ID(fromTask.getC_ProjectPhase_ID());
							orderLine.setC_ProjectTask_ID(fromTask.getC_ProjectTask_ID());
							orderLine.setTax();
							orderLine.saveEx();
							count.getAndUpdate(no -> no + 1);
						}
					});    //	for all lines
			
			if (tasks.size() != count.get() - projectLines.size())
				log.log(Level.SEVERE, "doIt - Lines difference - ProjectTasks=" + tasks.size() + " <> Saved=" + count.get());
				
		}
		return "@C_Order_ID@ " + order.getDocumentNo() + " (" + count + ")";
	}	//	doIt

}	//	ProjectPhaseGenOrder
