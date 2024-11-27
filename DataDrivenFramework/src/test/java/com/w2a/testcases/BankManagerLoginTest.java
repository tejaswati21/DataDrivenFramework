package com.w2a.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.w2a.base.*;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void LoginAsBankManger() throws Exception {
		
		
		
		System.out.println(or.getProperty("bmlBtn"));
		driver.findElement(By.xpath(or.getProperty("bmlxpath"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("addCustBtn"))),"Login not successfull");
		
		
	}


}
