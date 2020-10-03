package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.shopping.customer.Customer;
import com.shopping.customer.PremiumCustomer;
import com.shopping.customer.RegularCustomer;
import com.shopping.factory.CustomerFactory;


public class TestCustomerFactory {
	
	private CustomerFactory cust = null;
	
	@Before  
    public void setUp() throws Exception {  
		cust = new CustomerFactory();
    } 
	
	@Test
	public void testgetCustomer(){  
		Customer custRegular = cust.getCustomer("Regular");
		assertEquals(custRegular.getClass().getName(), RegularCustomer.class.getName());
		Customer custPremium = cust.getCustomer("Premium");
		assertEquals(custPremium.getClass().getName(), PremiumCustomer.class.getName());
		assertNull(cust.getCustomer(""));
		assertNull(cust.getCustomer(null));
		assertNull(cust.getCustomer("Diamond"));
	}
}
