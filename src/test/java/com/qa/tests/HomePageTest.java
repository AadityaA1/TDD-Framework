package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class HomePageTest 
	extends TestBase {

		@BeforeMethod
		public void setUp(){
			initDriver();
		}
		
		@Test
		public void checkLogo(){
			
		}
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
	}