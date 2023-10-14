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

package org.shw.einvoice.es.utils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.compiere.model.MInvoice;
import org.compiere.model.Query;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
/** Generated Process for (EI_ReadJsonResponse)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class EI_ReadJsonResponse extends EI_ReadJsonResponseAbstract

{
	StringBuffer result = new StringBuffer();
	@Override
	protected void prepare()
	{
		super.prepare();
	}

	@Override
	protected String doIt()  throws IOException, Exception
	{
		
		readFiles();
		return "";
        }
	
	public void readFiles()
	        throws IOException {
		String pathname = EDocument.ABSDIRECTORYRESPONSE;
		Path path = Paths.get(pathname);
		JSONParser parser = new JSONParser();
	        try (Stream<Path> walk = Files.walk(path)) {
	            walk
	                    .filter(Files::isReadable)      // read permission
	                    .filter(Files::isRegularFile)   // file only
	                    .forEach(p -> {
	                        try {
	                        	 Object obj = parser.parse(new FileReader(p.toString()));
	                             JSONObject eDocumentAsJson  = new JSONObject(obj.toString());
	                             updateInvoice(eDocumentAsJson);
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }catch (Exception e) {
	                            e.printStackTrace();
	                        }
	                    });
	        }
	    }
	
	private void updateInvoice(JSONObject eDocumentAsJson) {
   	 String codigoGeneracion = eDocumentAsJson.getString(EDocument.CODIGOGENERACION);
		String whereClause = "ei_codigoGeneracion = ?";
		List<MInvoice> invoices = new Query(getCtx(), MInvoice.Table_Name, whereClause, get_TrxName())
				.setParameters(codigoGeneracion)
				.list();
		
		//	Validate contact
		Optional<MInvoice> maybeInvoice = invoices
				.stream()
				.findFirst();
		if(maybeInvoice.isPresent()) {
			MInvoice invoice = maybeInvoice.get();
			invoice.setei_selloRecibido(eDocumentAsJson.getString(EDocument.SELLORECIBIDO));
			invoice.saveEx();
		}
		else {
			result.append("Invoice not present");
			
		}
    
		
	}
}