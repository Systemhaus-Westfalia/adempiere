/**************************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                               *
 * This program is free software; you can redistribute it and/or modify it    		  *
 * under the terms version 2 or later of the GNU General Public License as published  *
 * by the Free Software Foundation. This program is distributed in the hope           *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied         *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                   *
 * See the GNU General Public License for more details.                               *
 * You should have received a copy of the GNU General Public License along            *
 * with this program; if not, printLine to the Free Software Foundation, Inc.,        *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                             *
 * For the text or an alternative of this public license, you may reach us            *
 * Copyright (C) 2012-2018 E.R.P. Consultores y Asociados, S.A. All Rights Reserved.  *
 * Contributor: Carlos Parada cparada@erpya.com                                       *
 * See: www.erpya.com                                                                 *
 *************************************************************************************/

package org.compiere.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import org.compiere.process.ProcessInfo;
import org.compiere.util.Env;
import org.eevolution.model.MPPProductBOM;
import org.eevolution.model.MPPProductBOMLine;
import org.eevolution.service.dsl.ProcessBuilder;

/**
 * Model Validator for Assembly Project Managment 
 * @author Carlos Parada, cparada@erpya.com, http://www.erpya.com
 */
public class AssemblyProjectModelValidator implements ModelValidator {

	static int PROCESSID_PROJECT_LINE_PRICING = 230;
	
	@Override
	public void initialize(ModelValidationEngine engine, MClient client) {
		
		engine.addModelChange(MProjectLine.Table_Name, this);
		engine.addModelChange(MPPProductBOMLine.Table_Name, this);
		engine.addModelChange(MProjectTask.Table_Name, this);
		engine.addModelChange(MProjectPhase.Table_Name, this);
		engine.addModelChange(MProject.Table_Name, this);
		
		
	}

	@Override
	public int getAD_Client_ID() {
		return Env.getAD_Client_ID(Env.getCtx());
	}

	@Override
	public String login(int AD_Org_ID, int AD_Role_ID, int AD_User_ID) {
		return "";
	}

	@Override
	public String modelChange(PO po, int type) throws Exception {
		
		String result = null;
		
		//Controlled Project Phase/Task BOM Product 
		result = ProjectBOMControlled(po,type);
		
		if (result!=null)
			return result;
		//Project Margin Update
		result = ProjectPlannedMarginUpdate(po, type);
		
		return result;
	}

	@Override
	public String docValidate(PO po, int timing) {
		return null;
	}
	
	/**
	 * Controlled Product BOM on Project Phase / Task
	 * @param po
	 * @param type
	 * @return
	 */
	private String ProjectBOMControlled(PO po, int type) {
		if (type == TYPE_AFTER_CHANGE) {
			ArrayList<Object> params = new ArrayList<>();
			String whereClause = "";
			if (po.get_Table_ID() == MProjectLine.Table_ID) {
				MProjectLine pl = (MProjectLine) po;
				BigDecimal qty = Env.ZERO;
				if (pl.is_ValueChanged(MProjectLine.COLUMNNAME_PlannedQty)) {
					
					if (pl.getC_ProjectTask_ID()!=0) {
						MProjectTask pt = (MProjectTask) pl.getC_ProjectTask();
						qty = pl.getPlannedQty().divide(pt.getQty());
						whereClause = "EXISTS (SELECT 1 " + 
										"FROM " + 
										"PP_Product_BOM ppb " + 
										"WHERE ppb.C_ProjectTask_ID = ?  " + 
										"AND ppb.M_Product_ID = ? " +
										"AND ppb.PP_Product_BOM_ID = PP_Product_BOMLine.PP_Product_BOM_ID)" + 
										"AND M_Product_ID = ? ";
						
						params.add(pl.getC_ProjectTask_ID());
						params.add(pt.getM_Product_ID());
						params.add(pl.getM_Product_ID());
						
					}else if (pl.getC_ProjectPhase_ID()!=0) {
						MProjectPhase pp = (MProjectPhase) pl.getC_ProjectPhase();
						qty = pl.getPlannedQty().divide(pp.getQty());
						whereClause = "EXISTS (SELECT 1 " + 
								"FROM " + 
								"PP_Product_BOM ppb " + 
								"WHERE ppb.C_ProjectPhase_ID = ?  " +
								"AND ppb.C_ProjectTask_ID IS NULL " + 
								"AND ppb.M_Product_ID = ? " +
								"AND ppb.PP_Product_BOM_ID = PP_Product_BOMLine.PP_Product_BOM_ID)" + 
								"AND M_Product_ID = ? ";
				
						params.add(pl.getC_ProjectPhase_ID());
						params.add(pp.getM_Product_ID());
						params.add(pl.getM_Product_ID());
					}else 
						return null;
					
					MPPProductBOMLine ppbl = new Query(pl.getCtx(), MPPProductBOMLine.Table_Name, whereClause, pl.get_TrxName())
												.setParameters(params)
												.first();
					if (ppbl!=null) {
						ppbl.setQtyBOM(qty);
						ppbl.save();
					}
				}
			}else if (po.get_Table_ID() == MPPProductBOMLine.Table_ID) {
				MPPProductBOMLine ppbl = (MPPProductBOMLine) po;
				MPPProductBOM ppb = (MPPProductBOM) ppbl.getPP_Product_BOM();
				BigDecimal qty = Env.ZERO;
				
				if (ppbl.is_ValueChanged(MPPProductBOMLine.COLUMNNAME_QtyBOM)) {
					
					if (ppb.getC_ProjectTask_ID()!=0) {
						whereClause = "C_ProjectTask_ID = ? AND  M_Product_ID = ? ";
						params.add(ppb.getC_ProjectTask_ID());
						params.add(ppbl.getM_Product_ID());
					}else if (ppb.getC_ProjectPhase_ID()!=0) {
						whereClause = "C_ProjectPhase_ID = ? AND C_ProjectTask_ID IS NULL AND M_Product_ID = ? ";
						params.add(ppb.getC_ProjectPhase_ID());
						params.add(ppbl.getM_Product_ID());
					}else 
						return null;
					MProjectLine pl = new Query(ppbl.getCtx(), MProjectLine.Table_Name, whereClause, ppbl.get_TrxName())
												.setParameters(params)
												.first();
					if (pl!=null) {
						if (pl.getC_ProjectTask_ID()!=0) {
							MProjectTask pt = (MProjectTask) pl.getC_ProjectTask();
							qty = ppbl.getQtyBOM().multiply(pt.getQty());
						}else if (pl.getC_ProjectPhase_ID()!=0) {
							MProjectPhase pp = (MProjectPhase) pl.getC_ProjectPhase();
							qty = ppbl.getQtyBOM().multiply(pp.getQty());
						}
						
						pl.setPlannedQty(qty);
						pl.save();
					}
				}
			} 
		}else if (type == TYPE_AFTER_NEW) {

			ArrayList<Object> params = new ArrayList<>();
			String whereClause = "";
			
			if (po.get_Table_ID() == MProjectLine.Table_ID) {
				MProjectLine pl = (MProjectLine) po;
				BigDecimal qty = Env.ZERO;
					
				if (pl.getC_ProjectTask_ID()!=0) {
					MProjectTask pt = (MProjectTask) pl.getC_ProjectTask();
					qty = pl.getPlannedQty().divide(pt.getQty());
					whereClause = "C_ProjectTask_ID = ?  " + 
								  "AND M_Product_ID = ? ";
					
					params.add(pl.getC_ProjectTask_ID());
					params.add(pt.getM_Product_ID());
					
				}else if (pl.getC_ProjectPhase_ID()!=0) {
					MProjectPhase pp = (MProjectPhase) pl.getC_ProjectPhase();
					qty = pl.getPlannedQty().divide(pp.getQty());
					whereClause = "C_ProjectTask_ID = ?  " + 
							  "AND M_Product_ID = ? ";
					
					params.add(pl.getC_ProjectPhase_ID());
					params.add(pp.getM_Product_ID());

				}else 
					return null;
				
				if (pl.getM_Product_ID()==0)
					return null;
				
				MPPProductBOM ppb = new Query(pl.getCtx(), MPPProductBOM.Table_Name, whereClause, pl.get_TrxName())
											.setParameters(params)
											.first();
				if (ppb!=null) {
					MPPProductBOMLine ppbl = new Query(pl.getCtx(), MPPProductBOMLine.Table_Name, "PP_Product_BOM_ID = ? AND M_Product_ID = ?", pl.get_TrxName())
										.setParameters(ppb.getPP_Product_BOM_ID(),pl.getM_Product_ID())
										.first();
					
					if (ppbl==null) {
						ppbl = new MPPProductBOMLine(ppb);
						ppbl.setM_Product_ID(pl.getM_Product_ID());
						ppbl.setQtyBOM(qty);
						ppbl.save();	
					}
				}
					
			}else if (po.get_Table_ID() == MPPProductBOMLine.Table_ID) {
				MPPProductBOMLine ppbl = (MPPProductBOMLine) po;
				MPPProductBOM ppb = (MPPProductBOM) ppbl.getPP_Product_BOM();
				MProject project = null;
				BigDecimal qty = Env.ZERO;
					
				if (ppb.getC_ProjectTask_ID()!=0) {
					whereClause = "C_ProjectTask_ID = ? AND  M_Product_ID = ? ";
					params.add(ppb.getC_ProjectTask_ID());
					params.add(ppbl.getM_Product_ID());
				}else if (ppb.getC_ProjectPhase_ID()!=0) {
					whereClause = "C_ProjectPhase_ID = ? AND C_ProjectTask_ID IS NULL AND M_Product_ID = ? ";
					params.add(ppb.getC_ProjectPhase_ID());
					params.add(ppbl.getM_Product_ID());
				}else 
					return null;
				
				MProjectLine pl = new Query(ppbl.getCtx(), MProjectLine.Table_Name, whereClause, ppbl.get_TrxName())
											.setParameters(params)
											.first();
				
				if (pl==null) {
					if (ppb.getC_ProjectTask_ID()!=0) {
						MProjectTask pt = (MProjectTask) ppb.getC_ProjectTask();
						project = (MProject) pt.getC_ProjectPhase().getC_Project();
						qty = ppbl.getQty().multiply(pt.getQty());
					}else if (ppb.getC_ProjectPhase_ID()!=0) {
						MProjectPhase pp = (MProjectPhase) ppb.getC_ProjectPhase();
						project = (MProject) pp.getC_Project();
						qty = ppbl.getQty().multiply(pp.getQty());
					}else 
						return null;
					
					pl = new MProjectLine(project);
					pl.setLine(ppbl.getLine());
					pl.setM_Product_ID(ppbl.getM_Product_ID());
					pl.setPlannedQty(qty);
					pl.setC_ProjectPhase_ID(ppb.getC_ProjectPhase_ID());
					pl.setC_ProjectTask_ID(ppb.getC_ProjectTask_ID());
					pl.save();
					
					ProcessInfo processInfo = ProcessBuilder.create(project.getCtx())
							.process(PROCESSID_PROJECT_LINE_PRICING)
							.withRecordId(MProjectLine.Table_ID, pl.getC_ProjectLine_ID())
							.withoutTransactionClose()
							.execute(project.get_TrxName());
					
					if (processInfo.isError()) 
						return processInfo.getSummary();
					
				}
			} 
		}else if (type == TYPE_AFTER_DELETE) {
			ArrayList<Object> params = new ArrayList<>();
			String whereClause = "";
			if (po.get_Table_ID() == MProjectLine.Table_ID) {
				
				MProjectLine pl = (MProjectLine) po;
				if (pl.getC_ProjectTask_ID()!=0) {
					MProjectTask pt = (MProjectTask) pl.getC_ProjectTask();
					whereClause = "EXISTS (SELECT 1 " + 
									"FROM " + 
									"PP_Product_BOM ppb " + 
									"WHERE ppb.C_ProjectTask_ID = ?  " + 
									"AND ppb.M_Product_ID = ? " +
									"AND ppb.PP_Product_BOM_ID = PP_Product_BOMLine.PP_Product_BOM_ID)" + 
									"AND M_Product_ID = ? ";
					
					params.add(pl.getC_ProjectTask_ID());
					params.add(pt.getM_Product_ID());
					params.add(pl.getM_Product_ID());
					
				}else if (pl.getC_ProjectPhase_ID()!=0) {
					MProjectPhase pp = (MProjectPhase) pl.getC_ProjectPhase();
					whereClause = "EXISTS (SELECT 1 " + 
							"FROM " + 
							"PP_Product_BOM ppb " + 
							"WHERE ppb.C_ProjectPhase_ID = ?  " +
							"AND ppb.C_ProjectTask_ID IS NULL " + 
							"AND ppb.M_Product_ID = ? " +
							"AND ppb.PP_Product_BOM_ID = PP_Product_BOMLine.PP_Product_BOM_ID)" +
							"AND M_Product_ID = ? ";
			
					params.add(pl.getC_ProjectPhase_ID());
					params.add(pp.getM_Product_ID());
					params.add(pl.getM_Product_ID());
				}else 
					return null;
				
				MPPProductBOMLine ppbl = new Query(pl.getCtx(), MPPProductBOMLine.Table_Name, whereClause, pl.get_TrxName())
											.setParameters(params)
											.first();
				if (ppbl!=null) 
					ppbl.delete(true);
					
				
			}else if (po.get_Table_ID() == MPPProductBOMLine.Table_ID) {
				MPPProductBOMLine ppbl = (MPPProductBOMLine) po;
				MPPProductBOM ppb = (MPPProductBOM) ppbl.getPP_Product_BOM();
				
				if (ppb.getC_ProjectTask_ID()!=0) {
					whereClause = "C_ProjectTask_ID = ? AND  M_Product_ID = ? ";
					params.add(ppb.getC_ProjectTask_ID());
					params.add(ppbl.getM_Product_ID());
				}else if (ppb.getC_ProjectPhase_ID()!=0) {
					whereClause = "C_ProjectPhase_ID = ? AND C_ProjectTask_ID IS NULL AND M_Product_ID = ? ";
					params.add(ppb.getC_ProjectPhase_ID());
					params.add(ppbl.getM_Product_ID());
				}else 
					return null;
				
				MProjectLine pl = new Query(ppbl.getCtx(), MProjectLine.Table_Name, whereClause, ppbl.get_TrxName())
											.setParameters(params)
											.first();
				if (pl!=null) 
					pl.delete(true);
				
				if (ppb.getLines().length==0) 
					ppb.delete(true);
				
			}
		}
		if (type == TYPE_BEFORE_DELETE) {
			if (po.get_Table_ID() == MProjectPhase.Table_ID) {
				MProjectPhase pPhase = (MProjectPhase) po;
				if (pPhase.getC_ProjectPhase_ID()!=0) {
					List<MProjectLine> pLines = pPhase.getLines();
					for (MProjectLine mProjectLine : pLines) 
						mProjectLine.delete(true);
				}
			}else if (po.get_Table_ID() == MProjectTask.Table_ID) {
				MProjectTask pTask = (MProjectTask) po;
				if (pTask.getC_ProjectTask_ID()!=0) {
					MProjectLine[] pLines = pTask.getLines();
					for (MProjectLine mProjectLine : pLines) 
						mProjectLine.delete(true);
				}
			}
			
		}
		
		return null;
	}
	
	/**
	 * Project Planned Margin and Amount Update
	 * @param po
	 * @param type
	 * @return
	 */
	private String ProjectPlannedMarginUpdate(PO po, int type) {
		if (type == TYPE_AFTER_CHANGE) {
			if (po.get_Table_ID() == MProjectLine.Table_ID) {
				MProjectLine pl = (MProjectLine) po;
				if (pl.is_ValueChanged(MProjectLine.COLUMNNAME_PlannedMarginAmt)
						&& pl.getPlannedMarginAmt()!=null
							&& pl.getPlannedMarginAmt()!=Env.ZERO
								&& pl.getPlannedQty()!=null
									&& pl.getPlannedQty()!=Env.ZERO) {
					if (pl.getPlannedQty().compareTo(Env.ZERO)==0)
						pl.setPlannedMarginAmt(Env.ZERO);
					else {
						BigDecimal unitMargin = pl.getPlannedMarginAmt().divide(pl.getPlannedQty(), MathContext.DECIMAL128);
						BigDecimal limitPrice = pl.getLimitPrice();
						BigDecimal price = pl.getPlannedPrice();
						if (limitPrice!=null) {
							if (price.compareTo(unitMargin.add(limitPrice))!=0) {
								pl.setPlannedPrice(unitMargin.add(limitPrice));
								pl.save();
							}
						}
					}
				}
			}else if (po.get_Table_ID() == MProjectTask.Table_ID
							|| po.get_Table_ID() == MProjectPhase.Table_ID
								|| po.get_Table_ID() == MProject.Table_ID) {
				
				MProjectTask pTask = null;
				MProjectPhase pPhase = null;
				MProject project = null;
				BigDecimal previousAmt = Env.ZERO;
				BigDecimal currentAmt = Env.ZERO;
				MProjectLine[] pLines = null;
				
				if (po.get_Table_ID() == MProjectTask.Table_ID) {
					pTask = (MProjectTask) po;
				
					if (pTask.is_ValueChanged(MProjectTask.COLUMNNAME_PlannedAmt)) {
						previousAmt = (BigDecimal) pTask.get_ValueOld(MProjectTask.COLUMNNAME_PlannedAmt);
						currentAmt = pTask.getPlannedAmt();
						pLines = pTask.getLines();
					}
				}
				
				if (po.get_Table_ID() == MProjectPhase.Table_ID) {
					pPhase = (MProjectPhase) po;
				
					if (pPhase.is_ValueChanged(MProjectTask.COLUMNNAME_PlannedAmt)) {
						previousAmt = (BigDecimal) pPhase.get_ValueOld(MProjectTask.COLUMNNAME_PlannedAmt);
						currentAmt = pPhase.getPlannedAmt();
						List<MProjectLine> projectLines = pPhase.getLines();
						MProjectLine[] retValue = new MProjectLine[projectLines.size()];
						pLines = projectLines.toArray(retValue);
					}
				}
				
				if (po.get_Table_ID() == MProject.Table_ID) {
					project = (MProject) po;
				
					if (project.is_ValueChanged(MProjectTask.COLUMNNAME_PlannedAmt)) {
						previousAmt = (BigDecimal) project.get_ValueOld(MProjectTask.COLUMNNAME_PlannedAmt);
						currentAmt = project.getPlannedAmt();
						List<MProjectLine> projectLines = project.getLines();
						MProjectLine[] retValue = new MProjectLine[projectLines.size()];
						pLines = projectLines.toArray(retValue);
					}
				}
				
				if (pLines != null) {
					for (MProjectLine mProjectLine : pLines) {
						BigDecimal linePercent = mProjectLine.getPlannedAmt().divide(previousAmt, MathContext.DECIMAL128);
						mProjectLine.setPlannedAmt(currentAmt.multiply(linePercent, MathContext.DECIMAL128));
						mProjectLine.setPlannedPrice(mProjectLine.getPlannedAmt().divide(mProjectLine.getPlannedQty(), MathContext.DECIMAL128));
						mProjectLine.save();
					}
				}
			
			}
			
		}
		
		return null;
	}

}
