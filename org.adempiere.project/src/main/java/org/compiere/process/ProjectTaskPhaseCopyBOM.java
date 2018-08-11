/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.										*
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net or http://www.adempiere.net/license.html         *
 *****************************************************************************/

package org.compiere.process;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.compiere.model.MProduct;
import org.compiere.model.MProject;
import org.compiere.model.MProjectLine;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.model.Query;
import org.compiere.util.Env;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductBOMLine;
import org.eevolution.service.dsl.ProcessBuilder;

/**
 *	Copy the BOM and Components from the Product inside the Project Task.
 *  The new BOM/Components will have the same contents as the original;
 *  additionally it will link to the calling Project Task.
 *	
 *  @author Mario Calderon, mario.calderon@westfalia-it.com, http://www.westfalia-it.com
 *  @version $Id: CopyProjectTypeTasksIntoProject.java,v 1.0 2018/05/29 04:58:38 marcalwestf Exp $
 *  @author Carlos Parada, cparada@erpya.com, ERPCyA http://www.erpya.com
 * 			<li>BR [ 1723 ] Change for call CopyFromBOM class to copy Product BOM
 * 			@see https://github.com/adempiere/adempiere/issues/1723
 */
public class ProjectTaskPhaseCopyBOM extends ProjectTaskPhaseCopyBOMAbstract
{
	
	int m_C_ProjectPhase_ID = 0;
	int m_C_ProjectTask_ID	= 0;
	private int lineNo = 0;
	private MProject m_C_Project = null;
	static int PROCESSID_PRODUCT_BOM_COPY = 53004;
	static int PROCESSID_PROJECT_LINE_PRICING = 230;
	private boolean isCopyBOM = true;
	
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{

		isCopyBOM = isCreateProductBOMCopy();
		MProjectPhase phase = null;
		MProjectTask task = null;
		MProduct product = null;
		MPPProductBOM defaultBOM = null;
		String resultBOM = "";
		MPPProductBOM newBOM = null;
		BigDecimal qty = Env.ZERO;
		//Explode BOM from Product Project Phase
		
		if (getTable_ID() == MProjectTask.Table_ID) {
			task = new MProjectTask(getCtx(), getRecord_ID(), get_TrxName());
			product = (MProduct)task.getM_Product();
			m_C_ProjectTask_ID = task.getC_ProjectTask_ID();
			phase = (MProjectPhase) task.getC_ProjectPhase();
			m_C_ProjectPhase_ID = phase.getC_ProjectPhase_ID();
			m_C_Project = (MProject)phase.getC_Project();
			qty = task.getQty();
		}
		else if (getTable_ID() == MProjectPhase.Table_ID) {
			phase = new MProjectPhase(getCtx(), getRecord_ID(), get_TrxName());
			product = (MProduct)phase.getM_Product();
			m_C_ProjectPhase_ID = phase.getC_ProjectPhase_ID();
			m_C_Project = (MProject)phase.getC_Project();
			qty = phase.getQty();
		}
		
		if (product==null )
			return "@M_Product_ID@ @NotFound@" ;
		
		if (!(product.isBOM() && product.isVerified()))
			return "@InValid@ @PP_Product_BOM_ID@";

		
		if (m_C_ProjectTask_ID!=0) {
			defaultBOM = new Query(getCtx(), MPPProductBOM.Table_Name, "M_Product_ID = ? AND C_ProjectTask_ID= ?", get_TrxName())
					.setParameters(product.getM_Product_ID(),m_C_ProjectTask_ID)
					.first();
		}else if (m_C_ProjectPhase_ID!=0) {
			defaultBOM = new Query(getCtx(), MPPProductBOM.Table_Name, "M_Product_ID = ? AND C_ProjectPhase_ID= ? AND C_ProjectTask_ID IS NULL", get_TrxName())
					.setParameters(product.getM_Product_ID(),m_C_ProjectPhase_ID)
					.first();	
		}
		
		if (defaultBOM!=null)
			return "@AlreadyExists@ @PP_Product_BOM_ID@ -> @C_ProjectPhase_ID@ /  @C_ProjectTask_ID@";
		else
			defaultBOM = MPPProductBOM.getDefault(product, get_TrxName());
		
		if (defaultBOM==null)
			return "@PP_Product_BOM_ID@ @NotFound@";

		if (isCopyBOM) {
			newBOM = new MPPProductBOM(getCtx(), 0, get_TrxName());
			MPPProductBOM.copyValues(defaultBOM, newBOM, true);
			newBOM.setIsDefault(false);
			newBOM.setValue("");
			newBOM.setC_ProjectTask_ID(m_C_ProjectTask_ID);
			newBOM.setC_ProjectPhase_ID(m_C_ProjectPhase_ID);
			newBOM.saveEx();
	
			
			ProcessInfo processInfo = ProcessBuilder.create(getCtx())
					.process(PROCESSID_PRODUCT_BOM_COPY)
					.withRecordId(MPPProductBOM.Table_ID, newBOM.getPP_Product_BOM_ID())
					.withoutTransactionClose()
					.withParameter(MPPProductBOM.COLUMNNAME_PP_Product_BOM_ID, defaultBOM.getPP_Product_BOM_ID())
					.execute(get_TrxName());
			
			resultBOM = processInfo.getSummary();
		}else {
			newBOM = defaultBOM;
			resultBOM += explodeBOM(product, newBOM ,qty);
		}
		
		return resultBOM;
	}	//	doIt

	/**
	 * Explode BOM on Project Line
	 * @param product
	 * @param p_bom
	 * @param p_QtyRequired
	 */
	private String explodeBOM(MProduct product, MPPProductBOM p_bom , BigDecimal p_QtyRequired) {
		String result = "";
		MPPProductBOM bom = null;
		if (p_bom!=null)
			bom = p_bom;
		else
			bom =MPPProductBOM.getDefault(product, get_TrxName());
		
		if (bom==null)
			return "";
		for (MPPProductBOMLine bLine : bom.getLines())
		{			
			lineNo = lineNo + 10;
			BigDecimal BOMMovementQty = bLine.getQty(true).multiply(p_QtyRequired);	
			int precision = bLine.getPrecision();
			if (BOMMovementQty.scale() > precision)
			{
				BOMMovementQty = BOMMovementQty.setScale(precision, RoundingMode.HALF_UP);
			}
			MProduct bomproduct = bLine.getProduct();
			if ( bomproduct.isBOM() && bomproduct.isPhantom() )
			{
				explodeBOM(bomproduct, null, BOMMovementQty);
			}
			else
			{
				MProjectLine projectLine = new MProjectLine(m_C_Project);
				if (!bomproduct.isStocked())
				{					
					projectLine.setLine(lineNo);
					projectLine.setM_Product_ID(bomproduct.getM_Product_ID());
					projectLine.setPlannedQty(BOMMovementQty);
					projectLine.setC_ProjectPhase_ID(m_C_ProjectPhase_ID);
					projectLine.setC_ProjectTask_ID(m_C_ProjectTask_ID);
				}
				else if (BOMMovementQty.signum() == 0) 
				{
					projectLine.setLine(lineNo);
					projectLine.setM_Product_ID(bomproduct.getM_Product_ID());
					projectLine.setPlannedQty(BOMMovementQty);
					projectLine.setC_ProjectPhase_ID(m_C_ProjectPhase_ID);
					projectLine.setC_ProjectTask_ID(m_C_ProjectTask_ID);
				}
				else
				{					
					
					projectLine.setLine(lineNo);
					projectLine.setM_Product_ID(bomproduct.getM_Product_ID());
					projectLine.setPlannedQty(BOMMovementQty);
					projectLine.setC_ProjectPhase_ID(m_C_ProjectPhase_ID);
					projectLine.setC_ProjectTask_ID(m_C_ProjectTask_ID);
								
				} // for available storages
				projectLine.saveEx(get_TrxName());
				
				ProcessInfo processInfo = ProcessBuilder.create(getCtx())
						.process(PROCESSID_PROJECT_LINE_PRICING)
						.withRecordId(MProjectLine.Table_ID, projectLine.getC_ProjectLine_ID())
						.withoutTransactionClose()
						.execute(get_TrxName());
				if (processInfo.isError())
					result = processInfo.getSummary();
				
			}			
		}
		return result;
	}
}