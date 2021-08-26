package com.shopping.customer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import java.util.Map.Entry;

import com.shopping.configuration.ConfigReader;

public class PremiumCustomer extends Customer{
	
	private Properties property = null;
	static Logger logger = Logger.getLogger(PremiumCustomer.class.getName());  
	
	public PremiumCustomer() {
		property = ConfigReader.getInstance().getProperty("premium_customer.properties");
		ConfigReader.getInstance().getLogger();
	}
	
	@Override
	public Double calculateDiscount(Double totalPurchaseAmt) {
		Double customerFinalAmt = 0.0;
		double disCountAmt = 0.0;
		
		Map<String,String> hMap = new LinkedHashMap<String,String>();
		
		for(int i =1;i<property.size();i++) {
			if(property.getProperty("slab"+i+".range") != null &&
					property.getProperty("slab"+i+".discount") != null) {
			hMap.put(property.getProperty("slab"+i+".range"),property.getProperty("slab"+i+".discount"));
			}else {
				break;
			}
			
		}
		
		for(Entry<String, String> val:hMap.entrySet()) {
			String[] splitVal = val.getKey().split("-");
			
			if((!splitVal[1].equalsIgnoreCase("MAX") && totalPurchaseAmt > Double.parseDouble(splitVal[0]) && 
					totalPurchaseAmt <= Double.parseDouble(splitVal[1]) ) ||
					(!splitVal[1].equalsIgnoreCase("MAX") && totalPurchaseAmt > Double.parseDouble(splitVal[0]))
					) {
				double discount = Double.parseDouble(val.getValue());
				double calAmt = (Double.parseDouble(splitVal[1]) - Double.parseDouble(splitVal[0])) * (discount/100);
				disCountAmt = disCountAmt + calAmt;
			}
			
			if(totalPurchaseAmt >  Double.parseDouble(splitVal[0]) &&
					splitVal[1].equalsIgnoreCase("MAX")) {
				double discount = Double.parseDouble(val.getValue());
				double calAmt = (totalPurchaseAmt - Double.parseDouble(splitVal[0])) * (discount/100);
				disCountAmt = disCountAmt + calAmt;
			}
		}
		
		logger.debug("Total Discount for Premium customer registered for shopping cart:$"+disCountAmt);
		customerFinalAmt = totalPurchaseAmt - disCountAmt;
		logger.debug("Final amount that needs to be paid by premium customer after discount:$"+customerFinalAmt);
		return customerFinalAmt;
	}

}
