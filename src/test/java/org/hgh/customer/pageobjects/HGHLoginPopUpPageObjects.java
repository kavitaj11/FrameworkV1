package org.hgh.customer.pageobjects;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HGHLoginPopUpPageObjects extends MainController {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindBy(xpath="//input[@id='rememberMe' and @type='checkbox']")
	private WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//input[@id='popLoginBtn']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='popUserName']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='popPassword']")
	private WebElement password;
	
	public HGHLoginPopUpPageObjects clickOnRememberMe(){
		Waiting.explicitWaitVisibilityOfElement(rememberMeCheckbox, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",rememberMeCheckbox);
		return this;
	}
	
	public HGHProductsListPageObjects clickOnLoginButton(){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",loginButton);
		return new HGHProductsListPageObjects();
	}

	public HGHLoginPopUpPageObjects enterUserName() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(userName, 10);
		userName.sendKeys(data.getUserName());
		return this;
	}
	
	public HGHLoginPopUpPageObjects enterPassword() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(password, 10);
		password.sendKeys(data.getPassword());
		return this;
	}
}
