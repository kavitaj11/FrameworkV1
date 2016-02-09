package org.collective.maincontroller;


import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.collective.utils.Screenshot;
import org.collective.utils.SearchData;
import org.collective.admin.pageobjects.CollectiveAdminHomePageObjects;
import org.collective.customer.pageobjects.CollectiveHomePageObjects;
import org.collective.utils.ApplicationSetUp;
import org.collective.utils.SendEmail;
import org.collective.utils.Video;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
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
public static String outputVideo="";
private ScreenRecorder screenRecorder;

@BeforeSuite
	public void beforeSuite() throws IOException, InterruptedException{
		if((applicationsetup.getOutputfolder()==(null)))
				{
			outputFolder = "./Report";
			outputVideo="./Videos";
	 		FileUtils.forceMkdir(new File(outputFolder));
	 		FileUtils.forceMkdir(new File(outputVideo));
				}
		else
		{
			outputFolder = applicationsetup.getOutputfolder();
			outputVideo = applicationsetup.getOutputVideo();
		}
		
		outputFolder += "/Report_" + SendEmail.getDate()+"_" + SendEmail.getTime();
		outputVideo += "/Videos_" + SendEmail.getDate()+"_" + SendEmail.getTime();
	}
 	
 	@BeforeMethod
 	public void setUp() throws IOException{
		driver.get(applicationsetup.getURL());
	}
 	
 	@BeforeMethod
	public void startRecording(Method methodName) throws IOException, AWTException{
		/*ITestContext context = null;
 		context.getName();*/
 		 File file = new File(MainController.outputVideo+"/");
         
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         int width = screenSize.width;
         int height = screenSize.height;    
         String testcaseName = methodName.getName();
         Rectangle captureSize = new Rectangle(0,0, width, height);
                        
       GraphicsConfiguration gc = GraphicsEnvironment
          .getLocalGraphicsEnvironment()
          .getDefaultScreenDevice()
          .getDefaultConfiguration();

	this.screenRecorder = new Video(gc, captureSize,
          new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
          new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
               CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
               DepthKey, 24, FrameRateKey, Rational.valueOf(15),
               QualityKey, 1.0f,
               KeyFrameIntervalKey, 15 * 60),
          new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
               FrameRateKey, Rational.valueOf(30)),
          null, file, testcaseName);
     this.screenRecorder.start();
       
	}
	
	@BeforeMethod
	public static boolean checkForLogin() {
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
			else if(checkForLogin.myAccountXpath.isDisplayed())
			{
				checkForLogin.logout();
			}
			else
			{
				return true;
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
