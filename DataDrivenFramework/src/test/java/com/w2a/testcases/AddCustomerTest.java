package com.w2a.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest {
	
	
	@Test(dataProvider="getData")
	public void addCustomer(String firstname, String lastname, String postCode) {
		
		System.out.println("This is after commit");
	}
	
	//@DataProvider
	//public Object[][] getData(){
		
	}
	


