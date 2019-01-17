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

import org.compiere.model.MProject;
import org.compiere.model.MProjectPhase;

/** Generated Process for (Copy Phase Tasks)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.1
 */
public class CopyFromProjectPhase extends CopyFromProjectPhaseAbstract
{
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt() throws Exception
	{
		int fromProjectPhaseID = getProjectPhaseId();
		int toProjectPhaseID = getRecord_ID();
		log.info("doIt - From C_ProjectPhase_ID=" + fromProjectPhaseID + " to " + toProjectPhaseID);
		
		if (fromProjectPhaseID == 0)
			throw new IllegalArgumentException("Source C_ProjectPhase_ID == 0");
		if (toProjectPhaseID == 0)
			throw new IllegalArgumentException("Target C_ProjectPhase_ID == 0");
		
		MProjectPhase fromProjectPhase = new MProjectPhase (getCtx(), fromProjectPhaseID, get_TrxName());
		MProjectPhase toProjectPhase = new MProjectPhase (getCtx(), toProjectPhaseID, get_TrxName());
		
		int no = toProjectPhase.copyTasksFromIgnoreMatches (fromProjectPhase);

		return "@Copied@=" + no;
	}
}