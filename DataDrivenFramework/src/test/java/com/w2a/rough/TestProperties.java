package com.w2a.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) throws IOException {
		
		
		System.out.println(System.getProperty("user.dir"));
		Properties config = new Properties();
		Properties or = new Properties();
		
		
		FileInputStream fis = new FileInputStream("/Users/tejaswatamwar/Documents/Udemy_Automation/src/test/resources/properties/Config.properties");
		
		FileInputStream fis1 = new FileInputStream("/Users/tejaswatamwar/Documents/Udemy_Automation/src/test/resources/properties/OR.properties");
		
		config.load(fis);
		or.load(fis1);
		
		System.out.println(config.getProperty("browser"));
		System.out.println(or.getProperty("bmlBtn"));
	}

}
