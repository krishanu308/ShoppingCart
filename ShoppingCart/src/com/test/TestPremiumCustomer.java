package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shopping.customer.Customer;
import com.shopping.factory.CustomerFactory;

public class TestPremiumCustomer {

	private static CustomerFactory cs = null;
	Customer cust = null;

	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
		 cs = new CustomerFactory(); 
    } 
	
	@Before  
    public void setUp() throws Exception {  
		cust = cs.getCustomer("Premium");
    } 
	
	@Test
	public void testcalculateDiscount(){  
		assertEquals(new Double(3600),cust.calculateDiscount(new Double(4000)));
		assertEquals(new Double(7000),cust.calculateDiscount(new Double(8000)));
		assertEquals(new Double(10200),cust.calculateDiscount(new Double(12000)));  
		assertEquals(new Double(15800),cust.calculateDiscount(new Double(20000))); 
	}
}
