package org.projectname.maincontroller;
import java.io.File;
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
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.projectname.utils.ApplicationSetUp;
import org.projectname.utils.SendEmailGmail;
import org.projectname.utils.TestUtility;
import org.projectname.utils.Video;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.yandex.qatools.allure.annotations.Attachment;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;


public class MainController implements IHookable{
	
	
 public static WebDriver driver ;
 
/*
 * @author Hemanth.Sridhar
 */
public static String outputVideo="";
private ScreenRecorder screenRecorder;
public static String applicationSetUp = "resources/PropertyFiles/ApplicationSetUp.properties";
public static String searchData = "resources/PropertyFiles/SearchData.properties";
DesiredCapabilities caps = new DesiredCapabilities();
public static String outputFolder="";


	
@BeforeSuite(alwaysRun=true)
public void beforeSuite() throws Exception{
	ApplicationSetUp setUp = new ApplicationSetUp();
		outputVideo="./Videos";
 		FileUtils.forceMkdir(new File(outputVideo));
 		outputFolder="./Screenshots";
 		FileUtils.forceMkdir(new File(outputFolder));
 		outputFolder += "/Screenshot_" + setUp.getBrowser().toUpperCase()+"_"+SendEmailGmail.getDate()+"_" + SendEmailGmail.getTime();
 		outputVideo += "/Videos_" + setUp.getBrowser().toUpperCase()+"_"+SendEmailGmail.getDate()+"_" + SendEmailGmail.getTime();
}


	@BeforeMethod(alwaysRun=true)
	public void setUp() throws Exception {
	
		ApplicationSetUp setUp = new ApplicationSetUp();
		driver.get(setUp.getURL());
		driver.manage().deleteAllCookies();
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void startRecording(Method methodName) throws Exception{
 		ApplicationSetUp setUp = new ApplicationSetUp();
 		 //File file = new File(outputFolder+"/"+"Videos/");
 		if(setUp.getVideoPermission().equalsIgnoreCase("yes"))
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
	
	
		
@BeforeTest(alwaysRun=true)
public void beforeTest() throws Exception
{
	ApplicationSetUp setUp = new ApplicationSetUp();
if(System.getProperty("os.name").toUpperCase().contains("MAC"))
	
{
	
	if(setUp.getBrowser().trim().equalsIgnoreCase("chrome"))
	{
		  
		System.setProperty("webdriver.chrome.driver", "resources/drivers/Mac/chromedriver");
		driver = new ChromeDriver();
		
		  
	}
	else if(setUp.getBrowser().trim().equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.ie.driver","resources/drivers/Mac/IEDriverServer.exe");
		driver=new InternetExplorerDriver();			  
		  
	}

	
	else if(setUp.getBrowser().trim().equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "resources/drivers/Mac/geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	
	else if(setUp.getBrowser().trim().equalsIgnoreCase("safari"))
	{
		driver = new SafariDriver();
		
	}
		
	else
	{
		System.out.println("cannot load driver");
	}
	
	TestUtility.maximizeScreen(driver);
}

else if(System.getProperty("os.name").toUpperCase().contains("WIN"))
{
	if(setUp.getBrowser().trim().equalsIgnoreCase("chrome"))
	{
		  
		System.setProperty("webdriver.chrome.driver", "resources/drivers/Windows/chromedriver.exe");
		driver = new ChromeDriver();
		
		  
	}
	else if(setUp.getBrowser().trim().equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.ie.driver","resources/drivers/Windows/IEDriverServer.exe");
		driver=new InternetExplorerDriver();			  
		  
	}
	
	else if(setUp.getBrowser().trim().equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "resources/drivers/Windows/geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	else
	{
		System.out.println("cannot load driver");
	}
}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
}

@Override
public void run(IHookCallBack callBack, ITestResult testResult){
	callBack.runTestMethod(testResult);
    if (testResult.getThrowable()!= null) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	try
    	{
    	saveScreenshot(testResult.getName(),driver);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
   }
}


@Attachment(value = "Screenshot of {0}", type = "image/png")
  public byte[] saveScreenshot(String name,WebDriver driver) {
	return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }


@AfterMethod(alwaysRun=true)
public void callStopRecording() throws Exception{
	driver.manage().deleteAllCookies();
	ApplicationSetUp setUp = new ApplicationSetUp();
	if(setUp.getVideoPermission().equalsIgnoreCase("yes"))
		{
		  this.screenRecorder.stop();
		}	
}

@AfterSuite(alwaysRun=true)
public void tearDownClass(){
	System.out.println("Ending Test Suite");
	driver.quit();
}


}
