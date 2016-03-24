package org.hgh.maincontroller;
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

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.hgh.customer.pageobjects.HGHHomePageObjects;
import org.hgh.customer.pageobjects.HGHLoginPageObjects;
import org.hgh.customer.pageobjects.HGHMyAccountsPageObjects;
import org.hgh.customer.pageobjects.HGHProductsDetailsPageObjects;
import org.hgh.customer.pageobjects.HGHProductsListPageObjects;
import org.hgh.customer.pageobjects.HGHRegistrationPageObjects;
import org.hgh.customer.pageobjects.HGHShoppingCartPageObjects;
import org.hgh.utils.PropertyFileReader;
import org.hgh.utils.Screenshot;
import org.hgh.utils.SendEmailGmail;
import org.hgh.utils.Video;
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
import org.openqa.selenium.support.PageFactory;
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
public static String outputFolder = "";
public static String outputVideo="";
private ScreenRecorder screenRecorder;
public static String applicationSetUp = "resources/Property Files/ApplicationSetUp.properties";
public static String searchData = "resources/Property Files/SearchData.properties";

public HGHHomePageObjects homePage()
{
	HGHHomePageObjects homePage = PageFactory.initElements(driver,HGHHomePageObjects.class);
	return homePage;
}

public HGHLoginPageObjects loginPage()
{
	HGHLoginPageObjects loginPage = PageFactory.initElements(driver,HGHLoginPageObjects.class);
	return loginPage;
}

public HGHRegistrationPageObjects registrationPage()
{
	HGHRegistrationPageObjects registrationPage = PageFactory.initElements(driver,HGHRegistrationPageObjects.class);
	return registrationPage;
}

public HGHMyAccountsPageObjects myAccountsPage()
{
	HGHMyAccountsPageObjects myAccountsPage = PageFactory.initElements(driver,HGHMyAccountsPageObjects.class);
	return myAccountsPage;
}

public HGHProductsDetailsPageObjects productDetailsPage()
{
	HGHProductsDetailsPageObjects productDetailsPage = PageFactory.initElements(driver,HGHProductsDetailsPageObjects.class);
	return productDetailsPage;
}

public HGHProductsListPageObjects productListPage()
{
	HGHProductsListPageObjects productListPage = PageFactory.initElements(driver,HGHProductsListPageObjects.class);
	return productListPage;
}



public HGHShoppingCartPageObjects shoppingCartPage()
{
	HGHShoppingCartPageObjects shoppingCartPage = PageFactory.initElements(driver,HGHShoppingCartPageObjects.class);
	return shoppingCartPage;
}





DesiredCapabilities caps = new DesiredCapabilities();

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() throws Exception{
		if((PropertyFileReader.propertiesReader(applicationSetUp,"outputFolder")==(null)))
				{
			outputFolder = "./Report";
			outputVideo="./Videos";
	 		FileUtils.forceMkdir(new File(outputFolder));
	 		FileUtils.forceMkdir(new File(outputVideo));
				}
		else
		{
			PropertyFileReader.propertiesReader(applicationSetUp,"outputFolder");
			PropertyFileReader.propertiesReader(applicationSetUp,"outputVideo");
		}
		
		outputFolder += "/Report_" + SendEmailGmail.getDate()+"_" + SendEmailGmail.getTime();
		outputVideo += "/Videos_" + SendEmailGmail.getDate()+"_" + SendEmailGmail.getTime();
		
	}
	
	
 	@BeforeMethod(alwaysRun=true)
 	public static void setUp() throws Exception{
 		driver.get(PropertyFileReader.propertiesReader(applicationSetUp,"url"));
	
	}
 	
   
    
 	@BeforeMethod(alwaysRun=true)
	public void startRecording(Method methodName) throws Exception{
 		
 		 //File file = new File(outputFolder+"/"+"Videos/");
 		if(PropertyFileReader.propertiesReader(applicationSetUp, "videoPermisson").equalsIgnoreCase("yes"))
 		{
 		 File file = new File(outputVideo+"/");
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
     this.screenRecorder.start();
 		}
 }
 	
 	 public void stopRecording() throws Exception
     {
       this.screenRecorder.stop(); 
     }
	
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest() throws Exception
	{
		 
		  
		if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("chrome"))
		{
			  
			System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			  
		}
		else if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("IE"))
		{
			  
			System.setProperty("webdriver.ie.driver", "resources/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();			  
			  
		}
		
		//how to give resolution
		
		else if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("HTMLUnit"))
		{
			driver = new HtmlUnitDriver(true);
		}
		else if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("Ghost"))
		{
			 
			 System.setProperty("phantomjs.binary.path", "resources/drivers/phantomjs.exe");
	        driver = new PhantomJSDriver();
		}
		else if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").trim().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else
		{
			System.out.println("cannot load driver");
		}
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun=true)
	public void takeScreenshot(ITestResult testResult) throws IOException{

		if (testResult.getStatus() == ITestResult.FAILURE)
 {
Screenshot.captureScreenShot(driver, testResult.getName(),testResult);

 }	
}
	@AfterMethod(alwaysRun=true)
	public boolean checkForLogout()
	{
		
		try
		{
		if(homePage().logoutButton.isDisplayed())
		{
			homePage().logout();
			homePage().verifyDisplayOfLoginLink();
		}
	}
		catch(Exception e)
		{
			return true;
		}
		return true;

	}	
 	
	
	@AfterMethod(alwaysRun=true)
	public void callStopRecording() throws Exception{
		if(PropertyFileReader.propertiesReader(applicationSetUp, "videoPermisson").equalsIgnoreCase("yes"))
 		{
		stopRecording();
 		}
	}
	
	
	
	@AfterSuite(alwaysRun=true)
	public void tearDownClass(){
		System.out.println("Ending Test Suite");
		driver.close();
		driver.quit();
	}
	
}
