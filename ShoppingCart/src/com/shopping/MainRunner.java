package com.shopping;

import com.shopping.customer.Customer;
import com.shopping.factory.CustomerFactory;

public class MainRunner {

	public static void main(String[] args) {
		CustomerFactory cs = new CustomerFactory();
		
		Customer cust = cs.getCustomer("Regular");
		cust.calculateDiscount(7000.0);
		
		Customer cust1 = cs.getCustomer("Premium");
		cust1.calculateDiscount(25000.0);

	}

}
