package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/*
 * @author Hemanth.Sridhar
 */
public class CollectiveHomePageObjects extends MainController{
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
	
	@FindBy(xpath="//span[@class='fa fa-user user-btn']")
	public WebElement mansha;
	
	@FindBy(css="a[href='/account']")
	public WebElement account;
	
	@FindBy(xpath="//div[@class='alert alert-notice']")
	private WebElement logoutAlert;
	
	@FindBy(xpath="//img[@class='user-btn']")
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
	
	@FindBy(xpath="//div[@class='alert alert-notice']")
	private WebElement alertMessage;
	
	@FindBy(css="a[href='/t/brands/men/apparel/adriano-goldschmied']")
	private WebElement adrianoGoldschmied;
	
	@FindBy(css="a[href='/t/brands/women/apparel/adriano-goldschmied']")
	private WebElement adrianoGoldschmiedWomen;
	
	@FindBy(css="a[href='/blogs']")
	private WebElement blogLink;
	
	@FindBy(css="a[href='/t/categories/men/bags']")
	private WebElement bags;
	
	@FindBy(css="a[href='/t/sales']")
	private WebElement salesLink;
	
	@FindBy(css="a[href='/login']")
	private	WebElement loginLink ;
	
	@FindBy(css="a[href='/logout']")
	private WebElement signOutLink;
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@class='lsb']")
	private WebElement button;


	public void clickLoginLink() {
		hoverOverMyAccount();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , loginLink);
	}
	
		public void logout(){
			Waiting.explicitWaitVisibilityOfElement(myAccountXpath, 5);
			Actions action = new Actions(driver);
			action.moveToElement(myAccountXpath).build().perform();
			Waiting.explicitWaitVisibilityOfElement(signOutLink, 5);
			((JavascriptExecutor)driver).executeScript("arguments[0].click();" , signOutLink);
		}
		
				
			

			public void hoverOverMyAccount() {
				Waiting.explicitWaitVisibilityOfElement(myAccountPath, 10);
				action.moveToElement(myAccountPath).build().perform();
				
			}

			public void searchTest(String search) {
				searchBox.sendKeys(search);
				
			}

			public boolean verifyButton() {
				Waiting.explicitWaitVisibilityOfElement(button, 5);
				boolean t  = button.isEnabled();
				return t;
			}	
}
	
	
