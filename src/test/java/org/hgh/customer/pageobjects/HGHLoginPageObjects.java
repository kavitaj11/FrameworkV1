package org.hgh.customer.pageobjects;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HGHLoginPageObjects extends MainController {

	SearchDataPropertyFile data = new SearchDataPropertyFile();

	
	@FindBy(xpath="//a[contains(.,'New customer?? Register Now!')]")
	private WebElement newCustomerRegisterNowLink;
	
	@FindBy(xpath="//input[@id='mainUserName']")
	private WebElement userNameLocator;
	
	@FindBy(id="mainPassword")
	private WebElement passwordLocator;
	
	@FindBy(xpath="(//input[@value='Login'])[2]")
	private WebElement loginButton;
	

	public HGHRegistrationPageObjects clickNewCustomerRegisterNow() {
		Waiting.explicitWaitVisibilityOfElement(newCustomerRegisterNowLink, 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",newCustomerRegisterNowLink);
		return new HGHRegistrationPageObjects();
		}


	public HGHLoginPageObjects enterUsername() throws Exception{
		userNameLocator.sendKeys(data.getUserName());
		return this;
		
	}


	public HGHLoginPageObjects enterPassword() throws Exception {
		passwordLocator.sendKeys(data.getPassword());
		return this;
	}


	public HGHLoginPageObjects enterUsernameRegression(String userName) {
		userNameLocator.sendKeys(userName);
		return this;
		
	}


	public HGHLoginPageObjects enterPasswordRegression(String password) {
		passwordLocator.sendKeys(password);
		return this;
		
	}


	public HGHLoginPageObjects clickOnLoginButton() {
		
		loginButton.click();
		return new HGHLoginPageObjects();
	}
}
