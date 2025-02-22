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
/** Generated Model - DO NOT CHANGE */
package org.adempiere.core.domains.models;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.I_Persistent;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.POInfo;
import org.compiere.util.KeyNamePair;

/** Generated Model for AD_Client
 *  @author Adempiere (generated) 
 *  @version Release 3.9.4 - $Id$ */
public class X_AD_Client extends PO implements I_AD_Client, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230102L;

	/** Standard Constructor */
	public X_AD_Client (Properties ctx, int AD_Client_ID, String trxName)
	{
		super (ctx, AD_Client_ID, trxName);
		/** if (AD_Client_ID == 0)
        {
			setAutoArchive (null);
// N
			setIsCostImmediate (false);
// N
			setIsMultiLingualDocument (false);
			setIsPostImmediate (false);
// N
			setIsServerEMail (false);
			setIsUseASP (false);
// N
			setIsUseBetaFunctions (true);
// Y
			setMMPolicy (null);
// F
			setName (null);
			setStoreArchiveOnFileSystem (false);
			setStoreAttachmentsOnFileSystem (false);
			setValue (null);
        } */
	}

	/** Load Constructor */
	public X_AD_Client (Properties ctx, ResultSet rs, String trxName)
	{
		super (ctx, rs, trxName);
	}

	/** AccessLevel
	 * @return 6 - System - Client 
	 */
	protected int get_AccessLevel()
	{
		return accessLevel.intValue();
	}

	/** Load Meta Data */
	protected POInfo initPO (Properties ctx)
	{
		POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
		return poi;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer ("X_AD_Client[")
				.append(get_ID()).append("]");
		return sb.toString();
	}

	public org.adempiere.core.domains.models.I_AD_EMailConfig getAD_EMailConfig() throws RuntimeException
	{
		return (org.adempiere.core.domains.models.I_AD_EMailConfig)MTable.get(getCtx(), org.adempiere.core.domains.models.I_AD_EMailConfig.Table_Name)
				.getPO(getAD_EMailConfig_ID(), get_TrxName());	}

	/** Set EMail Configuration.
		@param AD_EMailConfig_ID EMail Configuration	  */
	public void setAD_EMailConfig_ID (int AD_EMailConfig_ID)
	{
		if (AD_EMailConfig_ID < 1) 
			set_Value (COLUMNNAME_AD_EMailConfig_ID, null);
		else 
			set_Value (COLUMNNAME_AD_EMailConfig_ID, Integer.valueOf(AD_EMailConfig_ID));
	}

	/** Get EMail Configuration.
		@return EMail Configuration	  */
	public int getAD_EMailConfig_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_EMailConfig_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/** AD_Language AD_Reference_ID=327 */
	public static final int AD_LANGUAGE_AD_Reference_ID=327;
	/** Set Language.
		@param AD_Language 
		Language for this entity
	 */
	public void setAD_Language (String AD_Language)
	{

		set_Value (COLUMNNAME_AD_Language, AD_Language);
	}

	/** Get Language.
		@return Language for this entity
	 */
	public String getAD_Language () 
	{
		return (String)get_Value(COLUMNNAME_AD_Language);
	}

	public org.adempiere.core.domains.models.I_AD_ReplicationStrategy getAD_ReplicationStrategy() throws RuntimeException
	{
		return (org.adempiere.core.domains.models.I_AD_ReplicationStrategy)MTable.get(getCtx(), org.adempiere.core.domains.models.I_AD_ReplicationStrategy.Table_Name)
				.getPO(getAD_ReplicationStrategy_ID(), get_TrxName());	}

	/** Set Replication Strategy.
		@param AD_ReplicationStrategy_ID 
		Data Replication Strategy
	 */
	public void setAD_ReplicationStrategy_ID (int AD_ReplicationStrategy_ID)
	{
		if (AD_ReplicationStrategy_ID < 1) 
			set_Value (COLUMNNAME_AD_ReplicationStrategy_ID, null);
		else 
			set_Value (COLUMNNAME_AD_ReplicationStrategy_ID, Integer.valueOf(AD_ReplicationStrategy_ID));
	}

	/** Get Replication Strategy.
		@return Data Replication Strategy
	 */
	public int getAD_ReplicationStrategy_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_ReplicationStrategy_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/** AutoArchive AD_Reference_ID=334 */
	public static final int AUTOARCHIVE_AD_Reference_ID=334;
	/** None = N */
	public static final String AUTOARCHIVE_None = "N";
	/** All (Reports, Documents) = 1 */
	public static final String AUTOARCHIVE_AllReportsDocuments = "1";
	/** Documents = 2 */
	public static final String AUTOARCHIVE_Documents = "2";
	/** External Documents = 3 */
	public static final String AUTOARCHIVE_ExternalDocuments = "3";
	/** Set Auto Archive.
		@param AutoArchive 
		Enable and level of automatic Archive of documents
	 */
	public void setAutoArchive (String AutoArchive)
	{

		set_Value (COLUMNNAME_AutoArchive, AutoArchive);
	}

	/** Get Auto Archive.
		@return Enable and level of automatic Archive of documents
	 */
	public String getAutoArchive () 
	{
		return (String)get_Value(COLUMNNAME_AutoArchive);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	 */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	 */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Document Directory.
		@param DocumentDir 
		Directory for documents from the application server
	 */
	public void setDocumentDir (String DocumentDir)
	{
		set_Value (COLUMNNAME_DocumentDir, DocumentDir);
	}

	/** Get Document Directory.
		@return Directory for documents from the application server
	 */
	public String getDocumentDir () 
	{
		return (String)get_Value(COLUMNNAME_DocumentDir);
	}
	

	public org.adempiere.core.domains.models.I_E_Enviroment getE_Enviroment() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_E_Enviroment)MTable.get(getCtx(), org.adempiere.core.domains.models.I_E_Enviroment.Table_Name)
			.getPO(getE_Enviroment_ID(), get_TrxName());	}

	/** Set CAT-019 Código de E_Enviroment.
		@param E_Enviroment_ID CAT-001 E_Enviroment	  */
	public void setE_Enviroment_ID (int E_Enviroment_ID)
	{
		if (E_Enviroment_ID < 1) 
			set_Value (COLUMNNAME_E_Enviroment_ID, null);
		else 
			set_Value (COLUMNNAME_E_Activity_ID, Integer.valueOf(E_Enviroment_ID));
	}

	/** Get CAT-019 Código de Actividad Económica.
		@return CAT-019 Código de Actividad Económica	  */
	public int getE_Enviroment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_Enviroment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}



	public org.adempiere.core.domains.models.I_E_Activity getE_Activity() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_E_Activity)MTable.get(getCtx(), org.adempiere.core.domains.models.I_E_Activity.Table_Name)
			.getPO(getE_Activity_ID(), get_TrxName());	}

	/** Set CAT-019 Código de Actividad Económica.
		@param E_Activity_ID CAT-019 Código de Actividad Económica	  */
	public void setE_Activity_ID (int E_Activity_ID)
	{
		if (E_Activity_ID < 1) 
			set_Value (COLUMNNAME_E_Activity_ID, null);
		else 
			set_Value (COLUMNNAME_E_Activity_ID, Integer.valueOf(E_Activity_ID));
	}

	/** Get CAT-019 Código de Actividad Económica.
		@return CAT-019 Código de Actividad Económica	  */
	public int getE_Activity_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_E_BPType getE_BPType() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_E_BPType)MTable.get(getCtx(), org.adempiere.core.domains.models.I_E_BPType.Table_Name)
			.getPO(getE_BPType_ID(), get_TrxName());	}

	/** Set CAT-029 Tipo de persona.
		@param E_BPType_ID CAT-029 Tipo de persona	  */
	public void setE_BPType_ID (int E_BPType_ID)
	{
		if (E_BPType_ID < 1) 
			set_Value (COLUMNNAME_E_BPType_ID, null);
		else 
			set_Value (COLUMNNAME_E_BPType_ID, Integer.valueOf(E_BPType_ID));
	}

	/** Get CAT-029 Tipo de persona.
		@return CAT-029 Tipo de persona	  */
	public int getE_BPType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_BPType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_E_FiscalResidence getE_FiscalResidence() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_E_FiscalResidence)MTable.get(getCtx(), org.adempiere.core.domains.models.I_E_FiscalResidence.Table_Name)
			.getPO(getE_FiscalResidence_ID(), get_TrxName());	}

	/** Set CAT-032 Domicilio Fiscal.
		@param E_FiscalResidence_ID CAT-032 Domicilio Fiscal	  */
	public void setE_FiscalResidence_ID (int E_FiscalResidence_ID)
	{
		if (E_FiscalResidence_ID < 1) 
			set_Value (COLUMNNAME_E_FiscalResidence_ID, null);
		else 
			set_Value (COLUMNNAME_E_FiscalResidence_ID, Integer.valueOf(E_FiscalResidence_ID));
	}

	/** Get CAT-032 Domicilio Fiscal.
		@return CAT-032 Domicilio Fiscal	  */
	public int getE_FiscalResidence_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_FiscalResidence_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_E_InvoiceGenerationType getE_InvoiceGenerationType() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_E_InvoiceGenerationType)MTable.get(getCtx(), org.adempiere.core.domains.models.I_E_InvoiceGenerationType.Table_Name)
			.getPO(getE_InvoiceGenerationType_ID(), get_TrxName());	}

	/** Set CAT-007 Tipo de Generación del Documento.
		@param E_InvoiceGenerationType_ID CAT-007 Tipo de Generación del Documento	  */
	public void setE_InvoiceGenerationType_ID (int E_InvoiceGenerationType_ID)
	{
		if (E_InvoiceGenerationType_ID < 1) 
			set_Value (COLUMNNAME_E_InvoiceGenerationType_ID, null);
		else 
			set_Value (COLUMNNAME_E_InvoiceGenerationType_ID, Integer.valueOf(E_InvoiceGenerationType_ID));
	}

	/** Get CAT-007 Tipo de Generación del Documento.
		@return CAT-007 Tipo de Generación del Documento	  */
	public int getE_InvoiceGenerationType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_InvoiceGenerationType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_E_InvoicingMode getE_InvoicingMode() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_E_InvoicingMode)MTable.get(getCtx(), org.adempiere.core.domains.models.I_E_InvoicingMode.Table_Name)
			.getPO(getE_InvoicingMode_ID(), get_TrxName());	}

	/** Set CAT-003 Modelo de Facturación.
		@param E_InvoicingMode_ID CAT-003 Modelo de Facturación	  */
	public void setE_InvoicingMode_ID (int E_InvoicingMode_ID)
	{
		if (E_InvoicingMode_ID < 1) 
			set_Value (COLUMNNAME_E_InvoicingMode_ID, null);
		else 
			set_Value (COLUMNNAME_E_InvoicingMode_ID, Integer.valueOf(E_InvoicingMode_ID));
	}

	/** Get CAT-003 Modelo de Facturación.
		@return CAT-003 Modelo de Facturación	  */
	public int getE_InvoicingMode_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_InvoicingMode_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_E_PlantType getE_PlantType() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_E_PlantType)MTable.get(getCtx(), org.adempiere.core.domains.models.I_E_PlantType.Table_Name)
			.getPO(getE_PlantType_ID(), get_TrxName());	}

	/** Set CAT-009 Tipo de establecimiento.
		@param E_PlantType_ID CAT-009 Tipo de establecimiento	  */
	public void setE_PlantType_ID (int E_PlantType_ID)
	{
		if (E_PlantType_ID < 1) 
			set_Value (COLUMNNAME_E_PlantType_ID, null);
		else 
			set_Value (COLUMNNAME_E_PlantType_ID, Integer.valueOf(E_PlantType_ID));
	}

	/** Get CAT-009 Tipo de establecimiento.
		@return CAT-009 Tipo de establecimiento	  */
	public int getE_PlantType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_PlantType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.adempiere.core.domains.models.I_E_TransmissionType getE_TransmissionType() throws RuntimeException
    {
		return (org.adempiere.core.domains.models.I_E_TransmissionType)MTable.get(getCtx(), org.adempiere.core.domains.models.I_E_TransmissionType.Table_Name)
			.getPO(getE_TransmissionType_ID(), get_TrxName());	}

	/** Set CAT-004 Tipo de Transmisión.
		@param E_TransmissionType_ID CAT-004 Tipo de Transmisión	  */
	public void setE_TransmissionType_ID (int E_TransmissionType_ID)
	{
		if (E_TransmissionType_ID < 1) 
			set_Value (COLUMNNAME_E_TransmissionType_ID, null);
		else 
			set_Value (COLUMNNAME_E_TransmissionType_ID, Integer.valueOf(E_TransmissionType_ID));
	}

	/** Get CAT-004 Tipo de Transmisión.
		@return CAT-004 Tipo de Transmisión	  */
	public int getE_TransmissionType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_E_TransmissionType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set EMail Address.
		@param EMail 
		Electronic Mail Address
	  */
	public void setEMail (String EMail)
	{
		set_Value (COLUMNNAME_EMail, EMail);
	}

	/** Get EMail Address.
	@return Electronic Mail Address
	 */
	public String getEMail () 
	{
		return (String)get_Value(COLUMNNAME_EMail);
	}
	public void setEMailTest (String EMailTest)
	{
		set_Value (COLUMNNAME_EMailTest, EMailTest);
	}

	/** Get EMail Test.
		@return Test EMail
	 */
	public String getEMailTest () 
	{
		return (String)get_Value(COLUMNNAME_EMailTest);
	}

	/** Set Cost Immediately.
		@param IsCostImmediate 
		Update Costs immediately for testing
	 */
	public void setIsCostImmediate (boolean IsCostImmediate)
	{
		set_Value (COLUMNNAME_IsCostImmediate, Boolean.valueOf(IsCostImmediate));
	}

	/** Get Cost Immediately.
		@return Update Costs immediately for testing
	 */
	public boolean isCostImmediate () 
	{
		Object oo = get_Value(COLUMNNAME_IsCostImmediate);
		if (oo != null) 
		{
			if (oo instanceof Boolean) 
				return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Multi Lingual Documents.
		@param IsMultiLingualDocument 
		Documents are Multi Lingual
	 */
	public void setIsMultiLingualDocument (boolean IsMultiLingualDocument)
	{
		set_Value (COLUMNNAME_IsMultiLingualDocument, Boolean.valueOf(IsMultiLingualDocument));
	}

	/** Get Multi Lingual Documents.
		@return Documents are Multi Lingual
	 */
	public boolean isMultiLingualDocument () 
	{
		Object oo = get_Value(COLUMNNAME_IsMultiLingualDocument);
		if (oo != null) 
		{
			if (oo instanceof Boolean) 
				return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Post Immediately (Deprecated).
		@param IsPostImmediate 
		Post the accounting immediately for testing (Deprecated)
	 */
	public void setIsPostImmediate (boolean IsPostImmediate)
	{
		set_Value (COLUMNNAME_IsPostImmediate, Boolean.valueOf(IsPostImmediate));
	}

	/** Get Post Immediately (Deprecated).
		@return Post the accounting immediately for testing (Deprecated)
	 */
	public boolean isPostImmediate () 
	{
		Object oo = get_Value(COLUMNNAME_IsPostImmediate);
		if (oo != null) 
		{
			if (oo instanceof Boolean) 
				return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Server EMail.
		@param IsServerEMail 
		Send EMail from Server
	 */
	public void setIsServerEMail (boolean IsServerEMail)
	{
		set_Value (COLUMNNAME_IsServerEMail, Boolean.valueOf(IsServerEMail));
	}

	/** Get Server EMail.
		@return Send EMail from Server
	 */
	public boolean isServerEMail () 
	{
		Object oo = get_Value(COLUMNNAME_IsServerEMail);
		if (oo != null) 
		{
			if (oo instanceof Boolean) 
				return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set IsUseASP.
		@param IsUseASP IsUseASP	  */
	public void setIsUseASP (boolean IsUseASP)
	{
		set_Value (COLUMNNAME_IsUseASP, Boolean.valueOf(IsUseASP));
	}

	/** Get IsUseASP.
		@return IsUseASP	  */
	public boolean isUseASP () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseASP);
		if (oo != null) 
		{
			if (oo instanceof Boolean) 
				return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Use Beta Functions.
		@param IsUseBetaFunctions 
		Enable the use of Beta Functionality
	 */
	public void setIsUseBetaFunctions (boolean IsUseBetaFunctions)
	{
		set_Value (COLUMNNAME_IsUseBetaFunctions, Boolean.valueOf(IsUseBetaFunctions));
	}

	/** Get Use Beta Functions.
		@return Enable the use of Beta Functionality
	 */
	public boolean isUseBetaFunctions () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseBetaFunctions);
		if (oo != null) 
		{
			if (oo instanceof Boolean) 
				return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set LDAP Query.
		@param LDAPQuery LDAP Query	  */
	public void setLDAPQuery (String LDAPQuery)
	{
		set_Value (COLUMNNAME_LDAPQuery, LDAPQuery);
	}

	/** Get LDAP Query.
		@return LDAP Query	  */
	public String getLDAPQuery () 
	{
		return (String)get_Value(COLUMNNAME_LDAPQuery);
	}

	/** MMPolicy AD_Reference_ID=335 */
	public static final int MMPOLICY_AD_Reference_ID=335;
	/** LiFo = L */
	public static final String MMPOLICY_LiFo = "L";
	/** FiFo = F */
	public static final String MMPOLICY_FiFo = "F";
	/** Set Material Policy.
		@param MMPolicy 
		Material Movement Policy
	 */
	public void setMMPolicy (String MMPolicy)
	{

		set_Value (COLUMNNAME_MMPolicy, MMPolicy);
	}

	/** Get Material Policy.
		@return Material Movement Policy
	 */
	public String getMMPolicy () 
	{
		return (String)get_Value(COLUMNNAME_MMPolicy);
	}

	/** Set Model Validation Classes.
		@param ModelValidationClasses 
		List of data model validation classes separated by ;
	 */
	public void setModelValidationClasses (String ModelValidationClasses)
	{
		set_Value (COLUMNNAME_ModelValidationClasses, ModelValidationClasses);
	}

	/** Get Model Validation Classes.
		@return List of data model validation classes separated by ;
	 */
	public String getModelValidationClasses () 
	{
		return (String)get_Value(COLUMNNAME_ModelValidationClasses);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	 */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	 */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Get Record ID/ColumnName
        @return ID/ColumnName pair
	 */
	public KeyNamePair getKeyNamePair() 
	{
		return new KeyNamePair(get_ID(), getName());
	}

	/** Set Request EMail.
		@param RequestEMail 
		EMail address to send automated mails from or receive mails for automated processing (fully qualified)
	 */
	public void setRequestEMail (String RequestEMail)
	{
		set_Value (COLUMNNAME_RequestEMail, RequestEMail);
	}

	/** Get Request EMail.
		@return EMail address to send automated mails from or receive mails for automated processing (fully qualified)
	 */
	public String getRequestEMail () 
	{
		return (String)get_Value(COLUMNNAME_RequestEMail);
	}

	/** Set Request Folder.
		@param RequestFolder 
		EMail folder to process incoming emails; if empty INBOX is used
	 */
	public void setRequestFolder (String RequestFolder)
	{
		set_Value (COLUMNNAME_RequestFolder, RequestFolder);
	}

	/** Get Request Folder.
		@return EMail folder to process incoming emails; if empty INBOX is used
	 */
	public String getRequestFolder () 
	{
		return (String)get_Value(COLUMNNAME_RequestFolder);
	}

	/** Set Request User.
		@param RequestUser 
		User Name (ID) of the email owner
	 */
	public void setRequestUser (String RequestUser)
	{
		set_Value (COLUMNNAME_RequestUser, RequestUser);
	}

	/** Get Request User.
		@return User Name (ID) of the email owner
	 */
	public String getRequestUser () 
	{
		return (String)get_Value(COLUMNNAME_RequestUser);
	}

	/** Set Request User Password.
		@param RequestUserPW 
		Password of the user name (ID) for mail processing
	 */
	public void setRequestUserPW (String RequestUserPW)
	{
		set_Value (COLUMNNAME_RequestUserPW, RequestUserPW);
	}

	/** Get Request User Password.
		@return Password of the user name (ID) for mail processing
	 */
	public String getRequestUserPW () 
	{
		return (String)get_Value(COLUMNNAME_RequestUserPW);
	}

	/** Set Store Archive On File System.
		@param StoreArchiveOnFileSystem Store Archive On File System	  */
	public void setStoreArchiveOnFileSystem (boolean StoreArchiveOnFileSystem)
	{
		set_Value (COLUMNNAME_StoreArchiveOnFileSystem, Boolean.valueOf(StoreArchiveOnFileSystem));
	}

	/** Get Store Archive On File System.
		@return Store Archive On File System	  */
	public boolean isStoreArchiveOnFileSystem () 
	{
		Object oo = get_Value(COLUMNNAME_StoreArchiveOnFileSystem);
		if (oo != null) 
		{
			if (oo instanceof Boolean) 
				return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Store Attachments On File System.
		@param StoreAttachmentsOnFileSystem Store Attachments On File System	  */
	public void setStoreAttachmentsOnFileSystem (boolean StoreAttachmentsOnFileSystem)
	{
		set_Value (COLUMNNAME_StoreAttachmentsOnFileSystem, Boolean.valueOf(StoreAttachmentsOnFileSystem));
	}

	/** Get Store Attachments On File System.
		@return Store Attachments On File System	  */
	public boolean isStoreAttachmentsOnFileSystem () 
	{
		Object oo = get_Value(COLUMNNAME_StoreAttachmentsOnFileSystem);
		if (oo != null) 
		{
			if (oo instanceof Boolean) 
				return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Unix Archive Path.
		@param UnixArchivePath Unix Archive Path	  */
	public void setUnixArchivePath (String UnixArchivePath)
	{
		set_Value (COLUMNNAME_UnixArchivePath, UnixArchivePath);
	}

	/** Get Unix Archive Path.
		@return Unix Archive Path	  */
	public String getUnixArchivePath () 
	{
		return (String)get_Value(COLUMNNAME_UnixArchivePath);
	}

	/** Set Unix Attachment Path.
		@param UnixAttachmentPath Unix Attachment Path	  */
	public void setUnixAttachmentPath (String UnixAttachmentPath)
	{
		set_Value (COLUMNNAME_UnixAttachmentPath, UnixAttachmentPath);
	}

	/** Get Unix Attachment Path.
		@return Unix Attachment Path	  */
	public String getUnixAttachmentPath () 
	{
		return (String)get_Value(COLUMNNAME_UnixAttachmentPath);
	}

	/** Set Immutable Universally Unique Identifier.
		@param UUID 
		Immutable Universally Unique Identifier
	 */
	public void setUUID (String UUID)
	{
		set_Value (COLUMNNAME_UUID, UUID);
	}

	/** Get Immutable Universally Unique Identifier.
		@return Immutable Universally Unique Identifier
	 */
	public String getUUID () 
	{
		return (String)get_Value(COLUMNNAME_UUID);
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	 */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	 */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}

	/** Set Windows Archive Path.
		@param WindowsArchivePath Windows Archive Path	  */
	public void setWindowsArchivePath (String WindowsArchivePath)
	{
		set_Value (COLUMNNAME_WindowsArchivePath, WindowsArchivePath);
	}

	/** Get Windows Archive Path.
		@return Windows Archive Path	  */
	public String getWindowsArchivePath () 
	{
		return (String)get_Value(COLUMNNAME_WindowsArchivePath);
	}

	/** Set Windows Attachment Path.
		@param WindowsAttachmentPath Windows Attachment Path	  */
	public void setWindowsAttachmentPath (String WindowsAttachmentPath)
	{
		set_Value (COLUMNNAME_WindowsAttachmentPath, WindowsAttachmentPath);
	}

	/** Get Windows Attachment Path.
		@return Windows Attachment Path	  */
	public String getWindowsAttachmentPath () 
	{
		return (String)get_Value(COLUMNNAME_WindowsAttachmentPath);
	}
}