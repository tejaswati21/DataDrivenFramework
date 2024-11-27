package com.w2a.base;
//import org.testng.annotations.Test;  

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

public class TestBase {
	
	/*
	 * Webdriver
	 * Properties
	 * Logs
	 * DB
	 * Excel
	 * ExtendReports
	 * Mail
	 * Jenkins
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static FileInputStream fis1;
	//public static Logger log = Logger.getLogger(null);
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		try {
			fis = new FileInputStream("/Users/tejaswatamwar/Documents/Udemy_Automation/src/test/resources/properties/Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//config.load(fis);
		}
		
		try {
			fis1 = new FileInputStream("/Users/tejaswatamwar/Documents/Udemy_Automation/src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//log.debug("config file loaded");
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			or.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(config.getProperty("browser").equals("firefox")) {
			
			//System.setProperty("webdriver.geco.driver","gecko.exe");
			driver = new FirefoxDriver();
		}else if(config.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/Users/tejaswatamwar/Downloads/chromedriver-mac-x64 5/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	
	
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
			
		}catch(NoSuchElementException e) {
			return false;
		}
		
		
	}

	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		
		
	}
	
	
}
