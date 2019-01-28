package com.qa.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.tests.CartPageTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	static Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase(){
		prop = new Properties();
		try {
			InputStream input = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(input);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void initDriver(){
		try{
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			log.info("****************Starting Chrome Browser*****************");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "C:/Users/aaditya.a/Downloads/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}catch(Exception e){
			log.error(e);
		}
	}
	
	@BeforeSuite
	public void startExtent(){
		log.info("****************Starting Before Suite*****************");
		log.info("****************Starting Extent*****************");
		extent = new ExtentReports(System.getProperty("user.dir")+"//src//test-output//ExtentAutomationSummary.html", true);
		extent.addSystemInfo("Title", "American Golf - Automation Report");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("OS","Windows 10");
	
	}
	
	
	@AfterSuite
	public void endExtent(){
		extent.flush();
		extent.close();
		log.info("****************End Extent*****************");
	}
	
	
	
}
