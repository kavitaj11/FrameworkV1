package org.collective.maincontroller;


import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.collective.utils.Screenshot;
import org.collective.utils.SearchData;
import org.collective.admin.pageobjects.CollectiveAdminHomePageObjects;
import org.collective.customer.pageobjects.CollectiveHomePageObjects;
import org.collective.utils.ApplicationSetUp;
import org.collective.utils.SendEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class MainController{
	
	
 public static WebDriver driver ;
 
/*
 * @author Hemanth.Sridhar
 */
 
public static SearchData data = new SearchData();
public static ApplicationSetUp applicationsetup = new ApplicationSetUp();
public static String outputFolder = "";

 	@BeforeSuite
 	public void screenshotCleanUp() throws IOException, InterruptedException{
 		
 		

 		if((applicationsetup.getOutputfolder()==(null)))
 				{
 			outputFolder = "./Report";
 	 		FileUtils.forceMkdir(new File(outputFolder));
 				}
 		else
 		{
 			outputFolder = applicationsetup.getOutputfolder();
 		}
 		
 		outputFolder += "/Report_" + SendEmail.getDate()+"_" + SendEmail.getTime();
 		System.out.println("before suite");
 	}
	
	@BeforeMethod
	public boolean checkForLogin() {
		CollectiveHomePageObjects checkForLogin = new CollectiveHomePageObjects(driver);
		try
		{
		if(checkForLogin.myAccountXpath.isDisplayed())
		{
			checkForLogin.logout();
			checkForLogin.verifyLogout();
		}
		}
		catch(Exception e)
		{
			return true;
		}
		return true;
	}
	
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		
		if(applicationsetup.getBrowser().trim().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(applicationsetup.getBrowser().trim().equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(applicationsetup.getBrowser().trim().equalsIgnoreCase("HTMLUnit"))
		{
			driver = new HtmlUnitDriver(true);
		}
		else if(applicationsetup.getBrowser().trim().equalsIgnoreCase("Ghost"))
		{
			 DesiredCapabilities caps = new DesiredCapabilities();
	    	 caps.setCapability("phantomjs.binary.path", "resources/drivers/phantomjs.exe");
	        driver = new PhantomJSDriver(caps);
		}
		else if(applicationsetup.getBrowser().trim().equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("cannot load driver");
		}
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult testResult) throws IOException{
		if (testResult.getStatus() == ITestResult.FAILURE)
 {
	 //type casting to takescreenshot INTERFACE!!!
Screenshot.captureScreenShot(driver, testResult.getName(),SendEmail.getDate());

 }
}
	
	@AfterMethod
	public static boolean checkForAdminLogout(){
		CollectiveAdminHomePageObjects logoutCheck = new CollectiveAdminHomePageObjects(driver);
		CollectiveHomePageObjects checkForLogin = new CollectiveHomePageObjects(driver);
		try
		{
			if(logoutCheck.adminLogout.isDisplayed())
			{
				logoutCheck.adminLogout();
				checkForLogin.verifyLogout();
			}
		}
		catch(Exception e)
		{
			return true;
		}
		return true;
	}
	
	
	@AfterSuite
	public void tearDownClass(){
		System.out.println("Ending Test Suite");
		driver.close();
		driver.quit();
	}
	
}
