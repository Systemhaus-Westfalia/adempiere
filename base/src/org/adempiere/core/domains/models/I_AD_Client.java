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
package org.adempiere.core.domains.models;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.MTable;
import org.compiere.util.KeyNamePair;

/** Generated Interface for AD_Client
 *  @author Adempiere (generated) 
 *  @version Release 3.9.4
 */
public interface I_AD_Client 
{

    /** TableName=AD_Client */
    public static final String Table_Name = "AD_Client";

    /** AD_Table_ID=112 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 6 - System - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(6);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_EMailConfig_ID */
    public static final String COLUMNNAME_AD_EMailConfig_ID = "AD_EMailConfig_ID";

	/** Set EMail Configuration	  */
	public void setAD_EMailConfig_ID (int AD_EMailConfig_ID);

	/** Get EMail Configuration	  */
	public int getAD_EMailConfig_ID();

	public org.adempiere.core.domains.models.I_AD_EMailConfig getAD_EMailConfig() throws RuntimeException;

    /** Column name AD_Language */
    public static final String COLUMNNAME_AD_Language = "AD_Language";

	/** Set Language.
	  * Language for this entity
	  */
	public void setAD_Language (String AD_Language);

	/** Get Language.
	  * Language for this entity
	  */
	public String getAD_Language();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name AD_ReplicationStrategy_ID */
    public static final String COLUMNNAME_AD_ReplicationStrategy_ID = "AD_ReplicationStrategy_ID";

	/** Set Replication Strategy.
	  * Data Replication Strategy
	  */
	public void setAD_ReplicationStrategy_ID (int AD_ReplicationStrategy_ID);

	/** Get Replication Strategy.
	  * Data Replication Strategy
	  */
	public int getAD_ReplicationStrategy_ID();

	public org.adempiere.core.domains.models.I_AD_ReplicationStrategy getAD_ReplicationStrategy() throws RuntimeException;

    /** Column name AutoArchive */
    public static final String COLUMNNAME_AutoArchive = "AutoArchive";

	/** Set Auto Archive.
	  * Enable and level of automatic Archive of documents
	  */
	public void setAutoArchive (String AutoArchive);

	/** Get Auto Archive.
	  * Enable and level of automatic Archive of documents
	  */
	public String getAutoArchive();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name DocumentDir */
    public static final String COLUMNNAME_DocumentDir = "DocumentDir";

	/** Set Document Directory.
	  * Directory for documents from the application server
	  */
	public void setDocumentDir (String DocumentDir);

	/** Get Document Directory.
	  * Directory for documents from the application server
	  */
	public String getDocumentDir();
	
	 /** Column name EMail */
    public static final String COLUMNNAME_EMail = "EMail";

	/** Set EMail Address.
	  * Electronic Mail Address
	  */
	public void setEMail (String EMail);

	/** Get EMail Address.
	  * Electronic Mail Address
	  */
	public String getEMail();


    /** Column name EMailTest */
    public static final String COLUMNNAME_EMailTest = "EMailTest";
    

    /** Column name E_BPType_ID */
    public static final String COLUMNNAME_E_BPType_ID = "E_BPType_ID";

	/** Set CAT-029 Tipo de persona	  */
	public void setE_BPType_ID (int E_BPType_ID);

	/** Get CAT-029 Tipo de persona	  */
	public int getE_BPType_ID();

    /** Column name E_FiscalResidence_ID */
    public static final String COLUMNNAME_E_FiscalResidence_ID = "E_FiscalResidence_ID";

	/** Set CAT-032 Domicilio Fiscal	  */
	public void setE_FiscalResidence_ID (int E_FiscalResidence_ID);

	/** Get CAT-032 Domicilio Fiscal	  */
	public int getE_FiscalResidence_ID();

    /** Column name E_InvoiceGenerationType_ID */
    public static final String COLUMNNAME_E_InvoiceGenerationType_ID = "E_InvoiceGenerationType_ID";

	/** Set CAT-007 Tipo de Generación del Documento	  */
	public void setE_InvoiceGenerationType_ID (int E_InvoiceGenerationType_ID);

	/** Get CAT-007 Tipo de Generación del Documento	  */
	public int getE_InvoiceGenerationType_ID();

    /** Column name E_InvoicingMode_ID */
    public static final String COLUMNNAME_E_InvoicingMode_ID = "E_InvoicingMode_ID";

	/** Set CAT-003 Modelo de Facturación	  */
	public void setE_InvoicingMode_ID (int E_InvoicingMode_ID);

	/** Get CAT-003 Modelo de Facturación	  */
	public int getE_InvoicingMode_ID();
	
	/** Column name E_Activity_ID */
    public static final String COLUMNNAME_E_Activity_ID = "E_Activity_ID";

	/** Set CAT-019 Código de Actividad Económica	  */
	public void setE_Activity_ID (int E_Activity_ID);

	/** Get CAT-019 Código de Actividad Económica	  */
	public int getE_Activity_ID();
	
	/** Column name E_Activity_ID */
    public static final String COLUMNNAME_E_Enviroment_ID = "E_Enviroment_ID";

	/** Set CAT-019 Código de Actividad Económica	  */
	public void setE_Enviroment_ID (int E_Enviroment_ID);

	/** Get CAT-019 Código de Actividad Económica	  */
	public int getE_Enviroment_ID();
	
	public org.adempiere.core.domains.models.I_E_Enviroment getE_Enviroment() throws RuntimeException;



    /** Column name E_TransmissionType_ID */
    public static final String COLUMNNAME_E_TransmissionType_ID = "E_TransmissionType_ID";

	/** Set CAT-004 Tipo de Transmisión	  */
	public void setE_TransmissionType_ID (int E_TransmissionType_ID);

	/** Get CAT-004 Tipo de Transmisión	  */
	public int getE_TransmissionType_ID();
	
	 /** Column name E_PlantType_ID */
    public static final String COLUMNNAME_E_PlantType_ID = "E_PlantType_ID";

	/** Set CAT-009 Tipo de establecimiento	  */
	public void setE_PlantType_ID (int E_PlantType_ID);

	/** Get CAT-009 Tipo de establecimiento	  */
	public int getE_PlantType_ID();



	/** Set EMail Test.
	  * Test EMail
	  */
	public void setEMailTest (String EMailTest);

	/** Get EMail Test.
	  * Test EMail
	  */
	public String getEMailTest();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsCostImmediate */
    public static final String COLUMNNAME_IsCostImmediate = "IsCostImmediate";

	/** Set Cost Immediately.
	  * Update Costs immediately for testing
	  */
	public void setIsCostImmediate (boolean IsCostImmediate);

	/** Get Cost Immediately.
	  * Update Costs immediately for testing
	  */
	public boolean isCostImmediate();

    /** Column name IsMultiLingualDocument */
    public static final String COLUMNNAME_IsMultiLingualDocument = "IsMultiLingualDocument";

	/** Set Multi Lingual Documents.
	  * Documents are Multi Lingual
	  */
	public void setIsMultiLingualDocument (boolean IsMultiLingualDocument);

	/** Get Multi Lingual Documents.
	  * Documents are Multi Lingual
	  */
	public boolean isMultiLingualDocument();

    /** Column name IsPostImmediate */
    public static final String COLUMNNAME_IsPostImmediate = "IsPostImmediate";

	/** Set Post Immediately (Deprecated).
	  * Post the accounting immediately for testing (Deprecated)
	  */
	public void setIsPostImmediate (boolean IsPostImmediate);

	/** Get Post Immediately (Deprecated).
	  * Post the accounting immediately for testing (Deprecated)
	  */
	public boolean isPostImmediate();

    /** Column name IsServerEMail */
    public static final String COLUMNNAME_IsServerEMail = "IsServerEMail";

	/** Set Server EMail.
	  * Send EMail from Server
	  */
	public void setIsServerEMail (boolean IsServerEMail);

	/** Get Server EMail.
	  * Send EMail from Server
	  */
	public boolean isServerEMail();

    /** Column name IsUseASP */
    public static final String COLUMNNAME_IsUseASP = "IsUseASP";

	/** Set IsUseASP	  */
	public void setIsUseASP (boolean IsUseASP);

	/** Get IsUseASP	  */
	public boolean isUseASP();

    /** Column name IsUseBetaFunctions */
    public static final String COLUMNNAME_IsUseBetaFunctions = "IsUseBetaFunctions";

	/** Set Use Beta Functions.
	  * Enable the use of Beta Functionality
	  */
	public void setIsUseBetaFunctions (boolean IsUseBetaFunctions);

	/** Get Use Beta Functions.
	  * Enable the use of Beta Functionality
	  */
	public boolean isUseBetaFunctions();

    /** Column name LDAPQuery */
    public static final String COLUMNNAME_LDAPQuery = "LDAPQuery";

	/** Set LDAP Query	  */
	public void setLDAPQuery (String LDAPQuery);

	/** Get LDAP Query	  */
	public String getLDAPQuery();

    /** Column name MMPolicy */
    public static final String COLUMNNAME_MMPolicy = "MMPolicy";

	/** Set Material Policy.
	  * Material Movement Policy
	  */
	public void setMMPolicy (String MMPolicy);

	/** Get Material Policy.
	  * Material Movement Policy
	  */
	public String getMMPolicy();

    /** Column name ModelValidationClasses */
    public static final String COLUMNNAME_ModelValidationClasses = "ModelValidationClasses";

	/** Set Model Validation Classes.
	  * List of data model validation classes separated by ;

	  */
	public void setModelValidationClasses (String ModelValidationClasses);

	/** Get Model Validation Classes.
	  * List of data model validation classes separated by ;

	  */
	public String getModelValidationClasses();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name RequestEMail */
    public static final String COLUMNNAME_RequestEMail = "RequestEMail";

	/** Set Request EMail.
	  * EMail address to send automated mails from or receive mails for automated processing (fully qualified)
	  */
	public void setRequestEMail (String RequestEMail);

	/** Get Request EMail.
	  * EMail address to send automated mails from or receive mails for automated processing (fully qualified)
	  */
	public String getRequestEMail();

    /** Column name RequestFolder */
    public static final String COLUMNNAME_RequestFolder = "RequestFolder";

	/** Set Request Folder.
	  * EMail folder to process incoming emails;
 if empty INBOX is used
	  */
	public void setRequestFolder (String RequestFolder);

	/** Get Request Folder.
	  * EMail folder to process incoming emails;
 if empty INBOX is used
	  */
	public String getRequestFolder();

    /** Column name RequestUser */
    public static final String COLUMNNAME_RequestUser = "RequestUser";

	/** Set Request User.
	  * User Name (ID) of the email owner
	  */
	public void setRequestUser (String RequestUser);

	/** Get Request User.
	  * User Name (ID) of the email owner
	  */
	public String getRequestUser();

    /** Column name RequestUserPW */
    public static final String COLUMNNAME_RequestUserPW = "RequestUserPW";

	/** Set Request User Password.
	  * Password of the user name (ID) for mail processing
	  */
	public void setRequestUserPW (String RequestUserPW);

	/** Get Request User Password.
	  * Password of the user name (ID) for mail processing
	  */
	public String getRequestUserPW();

    /** Column name StoreArchiveOnFileSystem */
    public static final String COLUMNNAME_StoreArchiveOnFileSystem = "StoreArchiveOnFileSystem";

	/** Set Store Archive On File System	  */
	public void setStoreArchiveOnFileSystem (boolean StoreArchiveOnFileSystem);

	/** Get Store Archive On File System	  */
	public boolean isStoreArchiveOnFileSystem();

    /** Column name StoreAttachmentsOnFileSystem */
    public static final String COLUMNNAME_StoreAttachmentsOnFileSystem = "StoreAttachmentsOnFileSystem";

	/** Set Store Attachments On File System	  */
	public void setStoreAttachmentsOnFileSystem (boolean StoreAttachmentsOnFileSystem);

	/** Get Store Attachments On File System	  */
	public boolean isStoreAttachmentsOnFileSystem();

    /** Column name UnixArchivePath */
    public static final String COLUMNNAME_UnixArchivePath = "UnixArchivePath";

	/** Set Unix Archive Path	  */
	public void setUnixArchivePath (String UnixArchivePath);

	/** Get Unix Archive Path	  */
	public String getUnixArchivePath();

    /** Column name UnixAttachmentPath */
    public static final String COLUMNNAME_UnixAttachmentPath = "UnixAttachmentPath";

	/** Set Unix Attachment Path	  */
	public void setUnixAttachmentPath (String UnixAttachmentPath);

	/** Get Unix Attachment Path	  */
	public String getUnixAttachmentPath();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name UUID */
    public static final String COLUMNNAME_UUID = "UUID";

	/** Set Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID);

	/** Get Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public String getUUID();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();

    /** Column name WindowsArchivePath */
    public static final String COLUMNNAME_WindowsArchivePath = "WindowsArchivePath";

	/** Set Windows Archive Path	  */
	public void setWindowsArchivePath (String WindowsArchivePath);

	/** Get Windows Archive Path	  */
	public String getWindowsArchivePath();

    /** Column name WindowsAttachmentPath */
    public static final String COLUMNNAME_WindowsAttachmentPath = "WindowsAttachmentPath";

	/** Set Windows Attachment Path	  */
	public void setWindowsAttachmentPath (String WindowsAttachmentPath);

	/** Get Windows Attachment Path	  */
	public String getWindowsAttachmentPath();
}
