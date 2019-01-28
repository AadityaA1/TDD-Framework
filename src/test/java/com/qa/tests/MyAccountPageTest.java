package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.base.TestBase;

public class MyAccountPageTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		initDriver();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
