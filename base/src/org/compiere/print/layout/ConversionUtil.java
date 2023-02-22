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

import org.compiere.model.MConversionRate;
import org.compiere.model.MCurrency;
import org.compiere.util.CCache;
import org.compiere.util.Env;
import org.compiere.util.TimeUtil;

/**
 *	Conversion Document
 *  Prints conversion for Document
 *
 * 	@author Yamel Senih
 */
public class ConversionUtil {
	
	private ConversionUtil() {
		//	Nothing
	}
	
	/** Engine Singleton				*/
	private static ConversionUtil conversionEngine = null;
	/** Static Cache */
	private static CCache<String, BigDecimal> conversionValues = new CCache<String, BigDecimal>("ConversionRate", 30);

	/**
	 * 	Get Singleton
	 *	@return modelValidatorEngine
	 */
	public synchronized static ConversionUtil get() {
		if (conversionEngine == null) {
			conversionEngine = new ConversionUtil();
		}
		return conversionEngine;
	}	//	get
	
	/**
	 * Get Conversion Rate
	 * @param context
	 * @param conversionTypeId
	 * @param fromCurrencyId
	 * @param toCurrencyId
	 * @param conversionDate
	 * @param clientId
	 * @param organizationId
	 * @return
	 */
	public BigDecimal getConversionRate(Properties context, int conversionTypeId, int fromCurrencyId, int toCurrencyId, Timestamp conversionDate, int clientId, int organizationId) {
		if(conversionDate == null) {
			return Env.ZERO;
		}
		//	Validate same currency
		if(fromCurrencyId == toCurrencyId) {
			return Env.ONE;
		}
		//	Create key
		String key = conversionTypeId + "|" + fromCurrencyId + "|" + toCurrencyId + "|" + TimeUtil.getDay(conversionDate).getTime();
		BigDecimal conversionRate = conversionValues.get(key);
		if(conversionRate != null) {
			return conversionRate;
		}
		conversionRate = Optional.ofNullable(MConversionRate.getRate (fromCurrencyId, toCurrencyId, conversionDate, conversionTypeId, clientId, organizationId)).orElse(Env.ZERO);
		conversionValues.put(key, conversionRate);
		return conversionRate;
	}
	
	/**
	 * Get converted Amount
	 * @param context
	 * @param conversionTypeId
	 * @param fromCurrencyId
	 * @param toCurrencyId
	 * @param conversionDate
	 * @param clientId
	 * @param organizationId
	 * @param amount
	 * @return
	 */
	public BigDecimal getConvertedAmount(Properties context, int conversionTypeId, int fromCurrencyId, int toCurrencyId, Timestamp conversionDate, int clientId, int organizationId, BigDecimal amount) {
		MCurrency currencyTo = MCurrency.get (context, toCurrencyId);
		return Optional.ofNullable(amount)
				.orElse(Env.ZERO)
				.multiply(getConversionRate(context, conversionTypeId, fromCurrencyId, toCurrencyId, conversionDate, clientId, organizationId))
				.setScale(currencyTo.getStdPrecision(), BigDecimal.ROUND_HALF_UP);
	}
}
