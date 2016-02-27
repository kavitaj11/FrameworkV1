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
import org.collective.customer.pageobjects.CollectiveHomePageObjects;
import org.collective.utils.SendEmail;
import org.collective.utils.Video;
import org.collective.utils.PropertyFileReader;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.net.URL;

public class MainController{
	
	
 public static WebDriver driver ;
 
/*
 * @author Hemanth.Sridhar
 */
public static String outputFolder = "";
public static String outputVideo="";
private Video screenRecorder;
public static String applicationSetUp = "src/test/java/org/collective/utils/ApplicationSetUp.properties";
public static final String USERNAME = "hemanthsridhar2";
public static final String AUTOMATE_KEY = "pwixoaay7x2VsHwKBqxF";
public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

  

	/*@BeforeSuite
	public void beforeSuite() throws IOException, InterruptedException{
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
	}*/

	@BeforeSuite
	public void beforeSuite() throws Exception{
		if((PropertyFileReader.propertiesReader(applicationSetUp,"outputFolder")==(null)))
				{
			outputFolder = "./Report";
			outputVideo="./Videos";
	 		FileUtils.forceMkdir(new File(outputFolder));
				}
		else
		{
			PropertyFileReader.propertiesReader(applicationSetUp,"outputFolder");
			PropertyFileReader.propertiesReader(applicationSetUp,"outputVideo");
		}
		
		outputFolder += "/Report_" + SendEmail.getDate()+"_" + SendEmail.getTime();
		//outputVideo += "/Videos_" + SendEmail.getDate()+"_" + SendEmail.getTime();
		FileUtils.forceMkdir(new File(outputFolder+outputVideo));
	}
 	
 	@BeforeMethod
 	public void setUp() throws Exception{
 		driver.get(PropertyFileReader.propertiesReader(applicationSetUp,"url"));
		driver.manage().window().maximize();
	}
 	
   
    
 	@BeforeMethod
	public void startRecording(Method methodName) throws IOException, AWTException{
 		
 		 //File file = new File(outputFolder+"/"+"Videos/");
 		
 		 File file = new File(outputFolder+outputVideo+"/");
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
          new Format(MediaTypeKey, MediaType.VIDEO, MimeTypeKey, MIME_AVI),
          new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
               CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
               DepthKey, 24, FrameRateKey, Rational.valueOf(15),
               QualityKey, 1.0f,
               KeyFrameIntervalKey, 15 * 60),
          new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
               FrameRateKey, Rational.valueOf(30)),
          null, file, testcaseName);
	
	//ITestResult result = Reporter.getCurrentTestResult();
	//result.setAttribute("video", this.screenRecorder.fileName);
     this.screenRecorder.start();
 }
 	
 	 public void stopRecording() throws Exception
     {
       this.screenRecorder.stop(); 
     }
	
	@BeforeMethod
	public static boolean checkForLogin() {
		CollectiveHomePageObjects checkForLogin = new CollectiveHomePageObjects(driver);
		try
		{
		if(checkForLogin.account.isDisplayed())
		{
//			/checkForLogin.hoverOverMyAccountAfterLogin();
			driver.navigate().refresh();
			checkForLogin.logout();
		}
		
		}
		catch(Exception e)
		{
			return true;
		}
		return true;
	}
	
	
	@BeforeTest
	public void beforeTest() throws Exception
	{
		 
		  
		if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("chrome"))
		{
			/*DesiredCapabilities caps = new DesiredCapabilities();
			  caps.setCapability("browser", "chrome");
			  caps.setCapability("browser_version", "48");
			  caps.setCapability("os", "Windows");
			  caps.setCapability("os_version", "7");
			  caps.setCapability("browserstack.debug", "true");
			  driver = new RemoteWebDriver(new URL(URL), caps);*/
			  
			System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			  
		}
		else if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("IE"))
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			 /* caps.setCapability("browser", "IE");
			  caps.setCapability("browser_version", "7.0");
			  caps.setCapability("os", "Windows");
			  caps.setCapability("os_version", "7");
			  caps.setCapability("browserstack.debug", "true");
			  driver = new RemoteWebDriver(new URL(URL), caps);*/
			  
			System.setProperty("webdriver.ie.driver", "resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();			  
			  
		}
		else if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("HTMLUnit"))
		{
			driver = new HtmlUnitDriver(true);
		}
		else if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("Ghost"))
		{
			 DesiredCapabilities caps1 = new DesiredCapabilities();
			 caps1.setCapability("phantomjs.binary.path", "resources/drivers/phantomjs.exe");
	        driver = new PhantomJSDriver(caps1);
		}
		else if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("firefox"))
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
	public void callStopRecording() throws Exception{
		stopRecording();
	}
	
	
	
	@AfterSuite
	public void tearDownClass(){
		System.out.println("Ending Test Suite");
		driver.close();
		driver.quit();
	}
	
}
