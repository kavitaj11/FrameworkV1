package org.hgh.customer.pageobjects;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HGHLoginPageObjects extends MainController {

	public HGHLoginPageObjects(WebDriver driver){
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,15);
		PageFactory.initElements(driver, this);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath="//a[contains(.,'New customer?? Register Now!')]")private WebElement newCustomerRegisterNowLink;
	
	@FindBy(xpath="//input[@id='mainUserName']")
	private WebElement userNameLocator;
	
	@FindBy(id="mainPassword")
	private WebElement passwordLocator;
	
	

	public void clickNewCustomerRegisterNow() {
		Waiting.explicitWaitVisibilityOfElement(newCustomerRegisterNowLink, 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",newCustomerRegisterNowLink);
		}


	public void enterUsername(String userName) {
		userNameLocator.sendKeys(userName);
		
	}


	public void enterPassword(String password) {
		passwordLocator.sendKeys(password);
		
	}
}
