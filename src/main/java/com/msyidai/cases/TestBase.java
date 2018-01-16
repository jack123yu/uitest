package com.msyidai.cases;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import bsh.This;

import com.msyidai.config.BaseConfig;
import com.msyidai.utils.DriverFactory;
import com.msyidai.utils.locater;

public class TestBase {
	public  static WebDriver driver;
	protected Assertion assertion=new Assertion();
	protected SoftAssert asert=new SoftAssert();
	protected static locater local=null;
	protected Logger logger=Logger.getLogger(This.class);
	
	@BeforeSuite
	public static void setup(){
		driver=DriverFactory.createrDriver(BaseConfig.driverType,BaseConfig.driverPath);
		driver.manage().window().maximize();
		local= new locater();
		
	}
	@AfterSuite
	public static void tearDown(){
	    driver.close();
	    driver.quit();
		
	}


}
