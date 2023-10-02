/**
 * 
 */
package org.shw.einvoice.es.util.pojo;

import java.util.Properties;

import org.compiere.model.MClient;
import org.compiere.model.MOrgInfo;
import org.json.JSONObject;

/**
 * 
 */
public abstract class EDocumentFactory {
	public abstract void generateJSONInputData();
	public abstract StringBuffer getEDocumentErrorMessages(); 

	protected MClient	client = null;
	protected MOrgInfo orgInfo = null;
	protected String trxName;
	protected Properties contextProperties;
	protected JSONObject jsonInputToFactory;  // Will contain data passed to factory
	
	
	public EDocumentFactory(String trxName, Properties contextProperties, MClient client, MOrgInfo orgInfo) {
		this.trxName = trxName;
		this.contextProperties = contextProperties;
		this.client = client;
		this.orgInfo = orgInfo;
	}

}
