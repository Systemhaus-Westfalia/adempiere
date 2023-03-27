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

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.process.SvrProcess;

/** Generated Process for (Bank Transfer)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.3
 */
public abstract class BankTransferAbstract extends SvrProcess {
	/** Process Value 	*/
	private static final String VALUE_FOR_PROCESS = "C_BankStatement BankTransfer";
	/** Process Name 	*/
	private static final String NAME_FOR_PROCESS = "Bank Transfer";
	/** Process Id 	*/
	private static final int ID_FOR_PROCESS = 53153;
	/**	Parameter Name for Bank Account From	*/
	public static final String FROM_C_BANKACCOUNT_ID = "From_C_BankAccount_ID";
	/**	Parameter Name for Bank Account To	*/
	public static final String C_BANKACCOUNTTO_ID = "C_BankAccountTo_ID";
	/**	Parameter Name for Business Partner 	*/
	public static final String C_BPARTNER_ID = "C_BPartner_ID";
	/**	Parameter Name for Currency	*/
	public static final String C_CURRENCY_ID = "C_Currency_ID";
	/**	Parameter Name for Currency Type	*/
	public static final String C_CONVERSIONTYPE_ID = "C_ConversionType_ID";
	/**	Parameter Name for Charge	*/
	public static final String C_CHARGE_ID = "C_Charge_ID";
	/**	Parameter Name for Document No	*/
	public static final String DOCUMENTNO = "DocumentNo";
	/**	Parameter Name for Document No (To)	*/
	public static final String DOCUMENTNOTO = "DocumentNoTo";
	/**	Parameter Name for Amount	*/
	public static final String AMOUNT = "Amount";
	/**	Parameter Name for Description	*/
	public static final String DESCRIPTION = "Description";
	/**	Parameter Name for Statement date	*/
	public static final String STATEMENTDATE = "StatementDate";
	/**	Parameter Name for Account Date	*/
	public static final String DATEACCT = "DateAcct";
	/**	Parameter Name for Project	*/
	public static final String C_PROJECT_ID = "C_Project_ID";
	/**	Parameter Name for User List 1	*/
	public static final String USER1_ID = "User1_ID";
	/**	Parameter Name for Organization	*/
	public static final String AD_ORG_ID = "AD_Org_ID";
	/**	Parameter Name for Tender type	*/
	public static final String TENDERTYPE = "TenderType";
	/**	Parameter Name for Check No	*/
	public static final String CHECKNO = "CheckNo";
	/**	Parameter Value for Bank Account From	*/
	private int cBankAccountId;
	/**	Parameter Value for Bank Account To	*/
	private int bankAccountToId;
	/**	Parameter Value for Business Partner 	*/
	private int bPartnerId;
	/**	Parameter Value for Currency	*/
	private int currencyId;
	/**	Parameter Value for Currency Type	*/
	private int conversionTypeId;
	/**	Parameter Value for Charge	*/
	private int chargeId;
	/**	Parameter Value for Document No	*/
	private String documentNo;
	/**	Parameter Value for Document No (To)	*/
	private String documentNoTo;
	/**	Parameter Value for Amount	*/
	private BigDecimal amount;
	/**	Parameter Value for Description	*/
	private String description;
	/**	Parameter Value for Statement date	*/
	private Timestamp statementDate;
	/**	Parameter Value for Account Date	*/
	private Timestamp dateAcct;
	/**	Parameter Value for Project	*/
	private int projectId;
	/**	Parameter Value for User List 1	*/
	private int user1Id;
	/**	Parameter Value for Organization	*/
	private int orgId;
	/**	Parameter Value for Tender type	*/
	private String tenderType;
	/**	Parameter Value for Check No	*/
	private String checkNo;

	@Override
	protected void prepare() {
		cBankAccountId = getParameterAsInt(FROM_C_BANKACCOUNT_ID);
		bankAccountToId = getParameterAsInt(C_BANKACCOUNTTO_ID);
		bPartnerId = getParameterAsInt(C_BPARTNER_ID);
		currencyId = getParameterAsInt(C_CURRENCY_ID);
		conversionTypeId = getParameterAsInt(C_CONVERSIONTYPE_ID);
		chargeId = getParameterAsInt(C_CHARGE_ID);
		documentNo = getParameterAsString(DOCUMENTNO);
		documentNoTo = getParameterAsString(DOCUMENTNOTO);
		amount = getParameterAsBigDecimal(AMOUNT);
		description = getParameterAsString(DESCRIPTION);
		statementDate = getParameterAsTimestamp(STATEMENTDATE);
		dateAcct = getParameterAsTimestamp(DATEACCT);
		projectId = getParameterAsInt(C_PROJECT_ID);
		user1Id = getParameterAsInt(USER1_ID);
		orgId = getParameterAsInt(AD_ORG_ID);
		tenderType = getParameterAsString(TENDERTYPE);
		checkNo = getParameterAsString(CHECKNO);
	}

	/**	 Getter Parameter Value for Bank Account From	*/
	protected int getCBankAccountId() {
		return cBankAccountId;
	}

	/**	 Setter Parameter Value for Bank Account From	*/
	protected void setCBankAccountId(int cBankAccountId) {
		this.cBankAccountId = cBankAccountId;
	}

	/**	 Getter Parameter Value for Bank Account To	*/
	protected int getBankAccountToId() {
		return bankAccountToId;
	}

	/**	 Setter Parameter Value for Bank Account To	*/
	protected void setBankAccountToId(int bankAccountToId) {
		this.bankAccountToId = bankAccountToId;
	}

	/**	 Getter Parameter Value for Business Partner 	*/
	protected int getBPartnerId() {
		return bPartnerId;
	}

	/**	 Setter Parameter Value for Business Partner 	*/
	protected void setBPartnerId(int bPartnerId) {
		this.bPartnerId = bPartnerId;
	}

	/**	 Getter Parameter Value for Currency	*/
	protected int getCurrencyId() {
		return currencyId;
	}

	/**	 Setter Parameter Value for Currency	*/
	protected void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	/**	 Getter Parameter Value for Currency Type	*/
	protected int getConversionTypeId() {
		return conversionTypeId;
	}

	/**	 Setter Parameter Value for Currency Type	*/
	protected void setConversionTypeId(int conversionTypeId) {
		this.conversionTypeId = conversionTypeId;
	}

	/**	 Getter Parameter Value for Charge	*/
	protected int getChargeId() {
		return chargeId;
	}

	/**	 Setter Parameter Value for Charge	*/
	protected void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	/**	 Getter Parameter Value for Document No	*/
	protected String getDocumentNo() {
		return documentNo;
	}

	/**	 Setter Parameter Value for Document No	*/
	protected void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	/**	 Getter Parameter Value for Document No (To)	*/
	protected String getDocumentNoTo() {
		return documentNoTo;
	}

	/**	 Setter Parameter Value for Document No (To)	*/
	protected void setDocumentNoTo(String documentNoTo) {
		this.documentNoTo = documentNoTo;
	}

	/**	 Getter Parameter Value for Amount	*/
	protected BigDecimal getAmount() {
		return amount;
	}

	/**	 Setter Parameter Value for Amount	*/
	protected void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**	 Getter Parameter Value for Description	*/
	protected String getDescription() {
		return description;
	}

	/**	 Setter Parameter Value for Description	*/
	protected void setDescription(String description) {
		this.description = description;
	}

	/**	 Getter Parameter Value for Statement date	*/
	protected Timestamp getStatementDate() {
		return statementDate;
	}

	/**	 Setter Parameter Value for Statement date	*/
	protected void setStatementDate(Timestamp statementDate) {
		this.statementDate = statementDate;
	}

	/**	 Getter Parameter Value for Account Date	*/
	protected Timestamp getDateAcct() {
		return dateAcct;
	}

	/**	 Setter Parameter Value for Account Date	*/
	protected void setDateAcct(Timestamp dateAcct) {
		this.dateAcct = dateAcct;
	}

	/**	 Getter Parameter Value for Project	*/
	protected int getProjectId() {
		return projectId;
	}

	/**	 Setter Parameter Value for Project	*/
	protected void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**	 Getter Parameter Value for User List 1	*/
	protected int getUser1Id() {
		return user1Id;
	}

	/**	 Setter Parameter Value for User List 1	*/
	protected void setUser1Id(int user1Id) {
		this.user1Id = user1Id;
	}

	/**	 Getter Parameter Value for Organization	*/
	protected int getOrgId() {
		return orgId;
	}

	/**	 Setter Parameter Value for Organization	*/
	protected void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	/**	 Getter Parameter Value for Tender type	*/
	protected String getTenderType() {
		return tenderType;
	}

	/**	 Setter Parameter Value for Tender type	*/
	protected void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}

	/**	 Getter Parameter Value for Check No	*/
	protected String getCheckNo() {
		return checkNo;
	}

	/**	 Setter Parameter Value for Check No	*/
	protected void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	/**	 Getter Parameter Value for Process ID	*/
	public static final int getProcessId() {
		return ID_FOR_PROCESS;
	}

	/**	 Getter Parameter Value for Process Value	*/
	public static final String getProcessValue() {
		return VALUE_FOR_PROCESS;
	}

	/**	 Getter Parameter Value for Process Name	*/
	public static final String getProcessName() {
		return NAME_FOR_PROCESS;
	}
}