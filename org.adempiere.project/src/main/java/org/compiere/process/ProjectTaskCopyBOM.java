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

import org.adempiere.util.ProcessUtil;
import org.compiere.model.MProduct;
import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;
import org.compiere.model.MProjectTask;
import org.compiere.util.Trx;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.process.CopyFromBOM;;

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
public class ProjectTaskCopyBOM extends ProjectTaskCopyBOMAbstract
{
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{

		int count = 0;
		MProjectTask projectTask = new MProjectTask (getCtx(), getRecord_ID(), get_TrxName());
		MProjectPhase projectPhase = (MProjectPhase) projectTask.getC_ProjectPhase();
		MProject project = (MProject) projectPhase.getC_Project();
		
		MProduct product = (MProduct) projectTask.getM_Product();
		if (!(product.isBOM() && product.isVerified()))
			return "@Created@/@Updated@ #" + count;
		
		MPPProductBOM defaultBOM = MPPProductBOM.getDefault(product, get_TrxName());
		if (defaultBOM==null)
			return "@Created@/@Updated@ #" + count;

		
		MPPProductBOM newBOM = new MPPProductBOM(getCtx(), 0, get_TrxName());
		MPPProductBOM.copyValues(defaultBOM, newBOM, true);
		newBOM.setIsDefault(false);
		newBOM.setValue(product.getValue() + "-" + projectTask.getName() + "-" + projectPhase.getC_ProjectPhase_ID() + "-" + projectTask.getC_ProjectTask_ID());
		newBOM.setName(product.getValue() + "-" + + projectTask.getC_ProjectTask_ID());
		newBOM.setDescription("Product: " + product.getValue() + ", Project: " +  project.getName() + ", Project phase: " +  
				projectPhase.getName() + ", Project task: "  +  projectTask.getName());
		newBOM.setC_ProjectTask_ID(projectTask.getC_ProjectTask_ID());
		newBOM.saveEx();

		
		ProcessInfo pi = new ProcessInfo(getProcessInfo().getTitle(), CopyFromBOM.getProcessId(), MPPProductBOM.Table_ID, newBOM.getPP_Product_BOM_ID(), false);

		pi.addParameter(MPPProductBOM.COLUMNNAME_PP_Product_BOM_ID, defaultBOM.getPP_Product_BOM_ID(), "");
		pi.setClassName(CopyFromBOM.class.getName());
		pi.setAD_PInstance_ID(getAD_PInstance_ID());
		Trx trx = Trx.get(get_TrxName(), true);
		ProcessUtil.startJavaProcess(getCtx(), pi, trx, false);
		if(pi.isError()) 
			rollback();
		
		return pi.getSummary();

	}	//	doIt
	
}