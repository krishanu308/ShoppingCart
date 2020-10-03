package com.shopping.factory;

import com.shopping.customer.Customer;
import com.shopping.customer.PremiumCustomer;
import com.shopping.customer.RegularCustomer;

public class CustomerFactory {
	
	public Customer getCustomer(String customerType) {
		
		if(customerType == null || "".equals(customerType))
			return null;
		
		if(customerType.equalsIgnoreCase("Regular"))
			return new RegularCustomer();
		else if(customerType.equalsIgnoreCase("Premium"))
			return new PremiumCustomer();
		
		return null;
	}

}
