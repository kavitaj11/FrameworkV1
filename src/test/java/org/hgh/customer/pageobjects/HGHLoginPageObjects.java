package org.hgh.customer.pageobjects;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
	
	@FindBy(xpath="//span[contains(text(),'Remember Me')]")
	private WebElement rememberMeText;
	
	@FindBy(xpath="//label[@class='customCheckBox']")
	private WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//label[@class='customCheckBox']/descendant::input")
	private WebElement rememberMeCheckboxState;
	
	@FindBy(xpath="//span[contains(text(),'Forgot Password ?')]")
	private WebElement forgotMyPasswordLink;

	@FindBy(xpath="//li[contains(text(),'Login')]")
	private WebElement loginBreadCrump;
	
	@FindBy(xpath="/html/head/link[@href='/ASSETS/WEB_THEMES//HGH_HARDWARE/images/favicon.ico']")
	private WebElement favicon;
	
	@FindBy(xpath="//h2")
	public WebElement pageName;
	
	@FindBy(xpath="//span[contains(text(),'Forgot Password ?')]")
	private WebElement forgotPasswordLink;

	
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


	public HGHProductCategoryPageObjects clickOnLoginButton() {
		Waiting.explicitWaitVisibilityOfElement(loginButton, 10);
		loginButton.click();
		return new HGHProductCategoryPageObjects();
	}


	public HGHLoginPageObjects verifyLoginPage() throws Exception {
		Assert.assertTrue(userNameLocator.isDisplayed(),"user name is not displayed");
		Assert.assertTrue(passwordLocator.isDisplayed(),"password is not displayed");
		Assert.assertTrue(loginButton.isDisplayed(),"login button is not displayed");
		Assert.assertTrue(newCustomerRegisterNowLink.isDisplayed(),"new customer register now is not displayed");
		Assert.assertTrue(rememberMeText.isDisplayed(),"remember me checkbox is not displayed");
		Assert.assertTrue(forgotMyPasswordLink.isDisplayed(),"forgot my password link is not displayed");
		Assert.assertTrue(loginBreadCrump.isDisplayed(),"login bread crump is not displayed");
		Assert.assertEquals(favicon.getAttribute("href").trim(),data.faviconURL().trim(),"favicon is not displayed or is having a different path or it is broken. The href value of the favicon is "+favicon.getAttribute("href"));
		Assert.assertEquals(driver.getTitle(),data.getLoginPageTitle().trim(),"Invalid title. Title I am getting is "+driver.getTitle());
		Assert.assertEquals(pageName.getText().trim(), "Login");
		return this;
	}


	public HGHLoginPageObjects clickOnRemeberMe() {
		Waiting.explicitWaitVisibilityOfElement(rememberMeCheckbox,10);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",rememberMeCheckbox);
		return this;
	}


	public HGHLoginPageObjects verifyAutofillOfUserNameAndPassword() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(userNameLocator, 10);
		Assert.assertEquals(userNameLocator.getAttribute("value"), data.getUserName());
		Assert.assertEquals(passwordLocator.getAttribute("value"), data.getPassword());
		return this;
		
		
	}


	public HGHLoginPageObjects verifyEmptyUserNameAndPasswordTextbox() {
		
		Waiting.explicitWaitVisibilityOfElement(userNameLocator, 10);
		Assert.assertEquals(userNameLocator.getAttribute("value"), "");
		Assert.assertEquals(passwordLocator.getAttribute("value"), "");
		return this;
	}


	public HGHRetrievePasswordPageObjects clickOnForgotPassword() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",forgotPasswordLink);
		return new HGHRetrievePasswordPageObjects();
	}


	public HGHLoginPageObjects verifyRememberMeCheckBoxSelected() throws InterruptedException {
		Thread.sleep(1500);
		Assert.assertEquals(rememberMeCheckboxState.getAttribute("checked"),"true","remember me checkbox is not checked");
		return this;
	}


	public HGHLoginPageObjects verifyRememberMeCheckboxNotSelected() throws InterruptedException {
		Thread.sleep(1500);
		Assert.assertEquals(rememberMeCheckboxState.getAttribute("checked"),null,"remember me checkbox is selected");
		return this;
	}
}
