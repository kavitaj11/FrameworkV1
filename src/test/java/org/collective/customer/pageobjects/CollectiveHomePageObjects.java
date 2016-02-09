package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.ApplicationSetUp;
import org.collective.utils.SearchData;
import org.collective.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
 * @author Hemanth.Sridhar
 */
public class CollectiveHomePageObjects extends MainController{
	
   SearchData data = new SearchData();
   Actions action = new Actions(driver);
   
	public CollectiveHomePageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Accessories')]")
	private WebElement accessories;
	
	@FindBy(xpath="//a[contains(text(),'Accessories')]/following-sibling::ul/descendant::a[contains(text(),'Men')]")
	private WebElement accessoriesMen;
	
	@FindBy(xpath="//a[contains(text(),'Sale')]")
	private WebElement sales;
	
	@FindBy(xpath="//a[@href='/account']")
    public WebElement myAccountXpath;
	
	@FindBy(xpath="//li[@class='myAccount']/a")
	public WebElement mansha;
	
	@FindBy(css="a[href='/account']")
	public WebElement account;
	
	@FindBy(xpath="//div[@class='alert alert-notice']")
	private WebElement logoutAlert;
	
	@FindBy(xpath="//li[@id='link-to-login']")
	public WebElement myAccountPath;
	
	@FindBy(xpath="//a[contains(text(),'Men')]")
	private WebElement menTab;
	
	@FindBy(xpath="//a[contains(text(),'Women')]")
	private WebElement womenTab;
	
	@FindBy(css="a[href='/t/brands/men/apparel/armani-collezioni']")
	private WebElement armaniLink;
	
	@FindBy(xpath="//div[@class='row block']")
	private WebElement blogDiv;
	
	@FindBy(xpath="//h2/b")
	private WebElement blogStoriesHeader;
	
	@FindBy(css="a[href='/users/register']")
	private WebElement emailSignUpBtn;
	
	@FindBy(xpath="//li[@class='myAccount']/a")
	public WebElement myAccountAfterLogin;
	
	public void emailSignUpBtnClick() throws AWTException, InterruptedException{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , emailSignUpBtn);
		}

	public void clickBlog() {
		By css = By.cssSelector("a[href='/blogs']");
		WebElement blogLink = driver.findElement(css);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , blogLink);
		}
	
	public void hoverAccessories(){
		action.moveToElement(accessories);
	}
	
	public void hoverAccessoriesMen(){
		
		action.moveToElement(accessoriesMen);
	}
	
	public void clickBags(){
		By css = By.cssSelector("a[href='/t/categories/men/bags']");
		WebElement bags = driver.findElement(css);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , bags);
		
		}
	
	public void clickSales()
	{
		By css = By.cssSelector("a[href='/t/sales']");
		WebElement salesLink = driver.findElement(css);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , salesLink);
		}

	public void clickLoginLink() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By css = By.cssSelector("a[href='/login']");
		WebElement loginLink = driver.findElement(css);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , loginLink);
	}

	public void verifySignFunctionality() throws IOException {
		Waiting.explicitWaitVisibilityOfElement(myAccountXpath, 10);
		Assert.assertTrue(myAccountXpath.isDisplayed());

	}
	
		public void logout(){
			Actions action = new Actions(driver);
			action.moveToElement(myAccountXpath);
			By css = By.cssSelector("a[href='/logout']");
			WebElement signOutLink = driver.findElement(css);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();" , signOutLink);
		}
		
		public void verifyLogout() {
		 Assert.assertTrue(logoutAlert.isDisplayed(),"Logout alert is not displayed");
         Assert.assertEquals((logoutAlert.getText().trim()),data.getLogoutMsg().trim());
		}
		
		public void hoverOverMenTab()
		{
			action.moveToElement(menTab);
		}
		
		public void navigateToAdrianoGoldschmiedFromMen(){
			By css = By.cssSelector("a[href='/t/brands/men/apparel/adriano-goldschmied']");
			WebElement adrianoGoldschmied = driver.findElement(css);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();" , adrianoGoldschmied);
		}
		
		public void hoverOverWomenTab()
		{
			action.moveToElement(womenTab);
		} 
		
		public void navigateToAdrianoGoldschmiedFromWomen(){
			By css = By.cssSelector("a[href='/t/brands/women/apparel/adriano-goldschmied']");
			WebElement adrianoGoldschmied = driver.findElement(css);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();" , adrianoGoldschmied);
		}
		

			public void navigateToArmaniFromMen() {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",armaniLink);
				
			}

			public void verifyBlogStories() {
				Waiting.explicitWaitVisibilityOfElement(blogStoriesHeader, 5);
				Assert.assertTrue(blogStoriesHeader.isDisplayed(), "Blog Stories header is not displayed");
				Assert.assertTrue(blogDiv.isDisplayed(), "Blogs are displayed");
				
			}

			public void verifyProductURLsPages() {
				{
					CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
					ApplicationSetUp application = new ApplicationSetUp();
					String everyURL[] = data.getPageURLs().split(",");
					for(int i=0;i<everyURL.length;i++)
					{
						driver.get(application.getURL()+everyURL[i]);	
						bagsPage.verifyProductsDisplay();
						Waiting.explicitWaitVisibilityOfElement(bagsPage.colour, 5);
						Assert.assertTrue(bagsPage.colour.isDisplayed(),"colour section is not displayed");
						Assert.assertTrue(bagsPage.size.isDisplayed(),"size section is not displayed");
						Assert.assertTrue(bagsPage.prices.isDisplayed(),"price section is not displayed");
						}
					}
				
			}

			public void hoverOverMyAccount() {
				Waiting.explicitWaitVisibilityOfElement(myAccountPath, 10);
				action.moveToElement(myAccountPath).build().perform();
				
			}

			public void hoverOverMyAccountAfterLogin() {
				Waiting.explicitWaitVisibilityOfElement(account, 10);
				action.moveToElement(account).perform();
			}
}
	
	
