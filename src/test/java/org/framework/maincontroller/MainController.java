package org.framework.maincontroller;


import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.framework.utils.Screenshot;
import org.framework.utils.SearchData;
import org.framework.utils.SendEmail;
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
 public static String outputFolder = "";
/*
 * @author Hemanth.Sridhar
 */
 
	
 	@BeforeSuite
 	public void screenshotCleanUp() throws IOException, InterruptedException{

 		if((SearchData.propertiesReader("Resources/PropertyFiles/ApplicationSetUp.properties", "outputfolder").isEmpty()))
 				{
 			outputFolder = "./Report";
 	 		FileUtils.forceMkdir(new File(outputFolder));
 	 		Thread.sleep(5000);
 				}
 		else
 		{
 			outputFolder = SearchData.propertiesReader("Resources/PropertyFiles/ApplicationSetUp.properties", "outputfolder");
 		}
 		
 		outputFolder += "/Report_" + SendEmail.getDate()+"_" + SendEmail.getTime();
 		
 	}
 	
	@BeforeMethod
	public void setUp() throws IOException{
		driver.get(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties","url"));
	}
	
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		
		if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties", "browser").trim().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties", "browser").trim().equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties","browser").trim().equalsIgnoreCase("HTMLUnit"))
		{
			driver = new HtmlUnitDriver(true);
		}
		else if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties", "browser").trim().equalsIgnoreCase("Ghost"))
		{
			 DesiredCapabilities caps = new DesiredCapabilities();
	    	 caps.setCapability("phantomjs.binary.path", "resources/drivers/phantomjs.exe");
	        driver = new PhantomJSDriver(caps);
		}
		else if(SearchData.propertiesReader("resources/PropertyFiles/ApplicationSetUp.properties", "browser").trim().equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("cannot load driver");
		}
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult testResult) throws IOException{
		if (testResult.getStatus() == ITestResult.FAILURE)
 {
	 //type casting to takescreenshot INTERFACE!!!
Screenshot.captureScreenShot(driver, testResult.getName(),SendEmail.getDate(),SendEmail.getTime());
 }
}
	@AfterSuite
	public void tearDownClass(){
		System.out.println("Ending Test Suite");
		driver.close();
		driver.quit();
	}
}
