package com.qa.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.CartPage;
import com.qa.utils.TestUtils;
import com.relevantcodes.extentreports.LogStatus;



public class CartPageTest extends TestBase {
	
	CartPage cartPage;
	
	SoftAssert softAssert;
	static Logger log = Logger.getLogger(CartPageTest.class);
	
	public CartPageTest(){
		super();
		
	}

	@BeforeMethod
	public void setUp(){
		initDriver();
		cartPage = new CartPage();

	}
	
	@DataProvider(name="DataProv")
	public Object[][] read(){
		
		Object[][] ob = TestUtils.readData();
		return ob;
	}
	
	@Test(priority=1)
	public void verifyLogo(){
		//extentTest = extent.startTest("verifyLogo");
		//boolean checkLogo = cartPage.checkCartLogo();
//		if(checkLogo){
//			extentTest.log(LogStatus.PASS, "Logo is present");
//		}else{
//			extentTest.log(LogStatus.FAIL, "Logo isn't present");
//		}
	
		softAssert.assertTrue(false);
		softAssert.assertTrue(true);
		
		
		//extent.endTest(extentTest);
		
		
	}
	
	@Test(priority=2)
	public void verifyTitle(){
		//extentTest = extent.startTest("verifyLogo");
		
		Assert.assertTrue(true);
		
		
		//extent.endTest(extentTest);
		
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		extentTest = extent.startTest(result.getName());
		if(result.getStatus()==result.FAILURE){
			
			log.info(result.getName());
			extentTest.log(LogStatus.FAIL, result.getName()+" failed");
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(TestUtils.getScreenshot(result.getName())));
		}else{
			extentTest.log(LogStatus.PASS, result.getName()+" passed");
		}
		
		extent.endTest(extentTest);
		
		driver.quit();
	}
	
}
