package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shopping.customer.Customer;
import com.shopping.factory.CustomerFactory;

public class TestRegularCustomer {
	
	private static CustomerFactory cs = null;
	Customer cust = null;

	@BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
		 cs = new CustomerFactory(); 
    } 
	
	@Before  
    public void setUp() throws Exception {  
		cust = cs.getCustomer("Regular");
    } 
	
	@Test
	public void testcalculateDiscount(){  
		assertEquals(new Double(5000),cust.calculateDiscount(new Double(5000)));
		assertEquals(new Double(9500),cust.calculateDiscount(new Double(10000)));
		assertEquals(new Double(13500),cust.calculateDiscount(new Double(15000)));  
	}
}
