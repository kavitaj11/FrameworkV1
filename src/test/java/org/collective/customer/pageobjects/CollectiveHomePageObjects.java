package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
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
	
	@FindBy(xpath="//div[contains(text(),'Signed out successfully.')]")
	private WebElement logoutAlert;
	
	@FindBy(xpath="//a[contains(text(),'Men')]")
	private WebElement menTab;
	
	@FindBy(xpath="//a[contains(text(),'Women')]")
	private WebElement womenTab;
	
	public void emailSignUpBtnClick() throws AWTException, InterruptedException{
		By css = By.cssSelector("a[href='/users/register']");
		WebElement emailSignUpBtn = driver.findElement(css);
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
	}
	
	
