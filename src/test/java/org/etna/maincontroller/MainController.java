package org.etna.maincontroller;
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
import java.nio.charset.Charset;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.etna.customer.pageobjects.AddNewCreditCardPageObjects;
import org.etna.customer.pageobjects.AddNewPurchasingAgentPageObjects;
import org.etna.customer.pageobjects.CheckoutPageObjects;
import org.etna.customer.pageobjects.CheckoutWithCreditCardPageObjects;
import org.etna.customer.pageobjects.ComparePageObjects;
import org.etna.customer.pageobjects.ConfirmOrderPageObjects;
import org.etna.customer.pageobjects.DropdownShoppingCartPageObjects;
import org.etna.customer.pageobjects.ForgotPasswordPageObjects;
import org.etna.customer.pageobjects.HomePageObjects;
import org.etna.customer.pageobjects.LoginPopUpPageObjects;
import org.etna.customer.pageobjects.MyAccountsPageObjects;
import org.etna.customer.pageobjects.MyProductGroupsPageObjects;
import org.etna.customer.pageobjects.OrderConfirmationPageObjects;
import org.etna.customer.pageobjects.ProductPageObjects;
import org.etna.customer.pageobjects.ProductsDetailsPageObjects;
import org.etna.customer.pageobjects.ProductsListPageObjects;
import org.etna.customer.pageobjects.RegistrationPageObjects;
import org.etna.customer.pageobjects.SaveCartPageObjects;
import org.etna.customer.pageobjects.ShopByBrandsPageObjects;
import org.etna.customer.pageobjects.ShopByManufacturersPageObjects;
import org.etna.customer.pageobjects.MyCartPageObjects;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SendEmailGmail;
import org.etna.utils.TestUtility;
import org.etna.utils.Video;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ru.yandex.qatools.allure.AllureConfig;
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

public HomePageObjects homePage()
{
	HomePageObjects homePage = PageFactory.initElements(driver,HomePageObjects.class);
	return homePage;
}

public RegistrationPageObjects registrationPage()
{
	RegistrationPageObjects registrationPage = PageFactory.initElements(driver,RegistrationPageObjects.class);
	return registrationPage;
}

public MyAccountsPageObjects myAccountsPage()
{
	MyAccountsPageObjects myAccountsPage = PageFactory.initElements(driver,MyAccountsPageObjects.class);
	return myAccountsPage;
}

public ProductsDetailsPageObjects productDetailsPage()
{
	ProductsDetailsPageObjects productDetailsPage = PageFactory.initElements(driver,ProductsDetailsPageObjects.class);
	return productDetailsPage;
}

public ProductsListPageObjects productListPage()
{
	ProductsListPageObjects productListPage = PageFactory.initElements(driver,ProductsListPageObjects.class);
	return productListPage;
}



public MyCartPageObjects myCartPage()
{
	MyCartPageObjects shoppingCartPage = PageFactory.initElements(driver,MyCartPageObjects.class);
	return shoppingCartPage;
}


public ForgotPasswordPageObjects forgotPasswordPage()
{
	ForgotPasswordPageObjects forgotPasswordPage = PageFactory.initElements(driver,ForgotPasswordPageObjects.class);
	return forgotPasswordPage;
}



public LoginPopUpPageObjects loginPopUp()
{
	LoginPopUpPageObjects loginPopUp = PageFactory.initElements(driver,LoginPopUpPageObjects.class);
	return loginPopUp;
}

public CheckoutPageObjects checkoutPage()
{
	CheckoutPageObjects checkoutPage = PageFactory.initElements(driver,CheckoutPageObjects.class);
	return checkoutPage;
}

public CheckoutWithCreditCardPageObjects checkoutWithCreditCardPage()
{
	CheckoutWithCreditCardPageObjects creditCardPage = PageFactory.initElements(driver,CheckoutWithCreditCardPageObjects.class);
	return creditCardPage;
}

public AddNewCreditCardPageObjects addNewCreditCardPage()
{
	AddNewCreditCardPageObjects addNewCreditCardPage = PageFactory.initElements(driver,AddNewCreditCardPageObjects.class);
	return addNewCreditCardPage;
}

public ConfirmOrderPageObjects confirmOrderPage()
{
	ConfirmOrderPageObjects confirmOrderPage = PageFactory.initElements(driver,ConfirmOrderPageObjects.class);
	return confirmOrderPage;
}

public OrderConfirmationPageObjects orderConfirmationPage()
{
	OrderConfirmationPageObjects orderConfirmationPage = PageFactory.initElements(driver,OrderConfirmationPageObjects.class);
	return orderConfirmationPage;
}


public ComparePageObjects comparePage()
{
	ComparePageObjects comparePage = PageFactory.initElements(driver,ComparePageObjects.class);
	return comparePage;
}


public DropdownShoppingCartPageObjects dropdownShoppingCart()
{
	DropdownShoppingCartPageObjects dropdownShoppingCart = PageFactory.initElements(driver,DropdownShoppingCartPageObjects.class);
	return dropdownShoppingCart;
}

public MyProductGroupsPageObjects myProductGroupsPage(){
	MyProductGroupsPageObjects myProductGroupsPage = PageFactory.initElements(driver,MyProductGroupsPageObjects.class);
	return myProductGroupsPage;
}

public ShopByBrandsPageObjects shopByBrandsPage()
{
	ShopByBrandsPageObjects shopByBrandsPage = PageFactory.initElements(driver,ShopByBrandsPageObjects.class);
	return shopByBrandsPage;
}

public ShopByManufacturersPageObjects shopByManufacturersPage()
{
	ShopByManufacturersPageObjects shopByManufacturersPage = PageFactory.initElements(driver,ShopByManufacturersPageObjects.class);
	return shopByManufacturersPage;
}

public AddNewPurchasingAgentPageObjects addNewPurchasingAgentPage()
{
	AddNewPurchasingAgentPageObjects addNewPurchasingAgentPage = PageFactory.initElements(driver,AddNewPurchasingAgentPageObjects.class);
	return addNewPurchasingAgentPage;
}


public ProductPageObjects productsPage()
{
	ProductPageObjects productsPage = PageFactory.initElements(driver,ProductPageObjects.class);
	return productsPage;
}


public SaveCartPageObjects saveCartPage()
{
	SaveCartPageObjects saveCartPage = PageFactory.initElements(driver,SaveCartPageObjects.class);
	return saveCartPage;
}



DesiredCapabilities caps = new DesiredCapabilities();

	
@BeforeSuite(alwaysRun=true)
public void beforeSuite() throws Exception{
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		outputVideo="./Videos";
 		FileUtils.forceMkdir(new File(outputVideo));	
 		outputVideo += "/Videos_" + setUp.getBrowser().toUpperCase()+"_"+SendEmailGmail.getDate()+"_" + SendEmailGmail.getTime();
}


	@BeforeMethod(alwaysRun=true)
	public boolean setUp() throws Exception{
	
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		driver.get(setUp.getURL());
		driver.manage().deleteAllCookies();
		try
		{
		if(homePage().userAccountDropdown.isDisplayed())
		{
			homePage().logout();
		}
	}
		catch(Exception e)
		{
			return true;
		}
		return true;
	
	}
	
	@BeforeMethod(alwaysRun=true)
	public void startRecording(Method methodName) throws Exception{
 		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
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
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
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
		driver = new FirefoxDriver();
		
	}
	else
	{
		System.out.println("cannot load driver");
	}
}
	
	TestUtility.maximizeScreen(driver);
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

/*@Override
public void onTestFailure(ITestResult tr) {
	saveScreenshot(tr.getMethod().getMethodName(),driver);
}*/



@Attachment(value = "Screenshot of {0}", type = "image/png")
  public byte[] saveScreenshot(String name,WebDriver driver) {
	return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }


@AfterMethod(alwaysRun=true)
public void callStopRecording() throws Exception{
	driver.manage().deleteAllCookies();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
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
