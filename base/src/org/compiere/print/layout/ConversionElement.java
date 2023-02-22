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
package org.compiere.print.layout;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.Properties;

import org.compiere.print.PrintDataElement;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Language;

/**
 *	Conversion Document
 *  Prints conversion for Document
 *
 * 	@author Yamel Senih
 */
public class ConversionElement extends PrintDataElement {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create conversion based on document
	 * @param columnName
	 * @param amount
	 * @param sourceColumnDocumentId
	 * @param sourceColumnDateId
	 * @param conversionTypeId
	 * @param fromCurrencyId
	 * @param toCurrencyId
	 * @param conversionDate
	 * @param pattern
	 */
	public ConversionElement(Properties context, String columnName, BigDecimal amount, int conversionTypeId, int fromCurrencyId, int toCurrencyId, Timestamp conversionDate, int clientId, int organizationId, String pattern) {
		super(columnName, Env.ONEHUNDRED, DisplayType.CostPrice, pattern);
		this.convertedValue = ConversionUtil.get()
				.getConvertedAmount(context, conversionTypeId, fromCurrencyId, toCurrencyId, conversionDate, clientId, organizationId, amount);
	}
	/**	Converted Value	*/
	private BigDecimal convertedValue = null;
	
	@Override
	public Object getValue() {
		return convertedValue;
	}
	
	@Override
	public String getColumnName() {
		return super.getColumnName();
	}
	
	/**
	 * 	Get Function Value
	 * 	@return length or numeric value
	 */
	public BigDecimal getFunctionValue() {
		if (convertedValue == null)
			return Env.ZERO;
		//	
		return convertedValue;
	}	//	getFunctionValue
	
	@Override
	public boolean isNumeric() {
		return true;
	}
	
	@Override
	public String getValueAsString() {
		return Optional.ofNullable(convertedValue).orElse(Env.ZERO).toString();
	}
	
	/**
	 * 	String representation
	 * 	@return info
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer(getColumnName()).append("=").append(convertedValue);
		return sb.toString();
	}	//	toString
	
	@Override
	public String getValueDisplay(Language language) {
		if(getValue() == null) {
			return "";
		}
		return DisplayType.getNumberFormat(getDisplayType(), language, getM_formatPattern()).format(getValue());
	}
}
