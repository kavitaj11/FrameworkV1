package org.etna.customer.pageobjects;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPopUpPageObjects extends MainController {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindBy(id="pLoginErr")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="//h2")
	public WebElement pageName;
	
	@FindBy(xpath="//span[@class='customCheckBox']")
	private WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//input[@id='popLoginBtn']")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='popUserName']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='popPassword']")
	private WebElement password;
	
	@FindBy(xpath="//a[contains(.,'Forgot your Password?')]")
	private WebElement forgotYourPassword;
	
	@FindBy(xpath="//h3[contains(.,'Login')]/a[contains(.,'Sign Up')]")
	private WebElement signUp;
	
	@FindBy(xpath="//a[@class='closeBtn']")
	private WebElement closeButton;
	
	@FindBy(xpath="//h3[contains(.,'Login')]")
	private WebElement loginPageName;
	
	@FindBy(xpath="//label[contains(.,'Remember me')]")
	private WebElement rememberMeText;
	
	
	public LoginPopUpPageObjects clickOnRememberMe(){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",rememberMeCheckbox);
		return this;
	}
	
	public RegistrationPageObjects clickOnSignUp(){
		Waiting.explicitWaitVisibilityOfElement(signUp, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",signUp);
		return new RegistrationPageObjects();
	}
	
	public LoginPopUpPageObjects clickCloseButton(){
		Waiting.explicitWaitVisibilityOfElement(closeButton, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",closeButton);
		return this;
	}
	
	public LoginPopUpPageObjects clickOnForgotYourPassword(){
		Waiting.explicitWaitVisibilityOfElement(forgotYourPassword, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",forgotYourPassword);
		return this;
	}
	
	public LoginPopUpPageObjects clickOnLoginButton(){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",loginButton);
		return this;
	}

	public LoginPopUpPageObjects enterUserName() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(userName, 10);
		userName.click();
		userName.clear();
		userName.sendKeys(data.getUserName());
		return this;
	}
	
	public LoginPopUpPageObjects enterPassword() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(password, 10);
		password.click();
		password.clear();
		password.sendKeys(data.getPassword());
		return this;
	}
	
	public LoginPopUpPageObjects enterUsernameRegression(String userName) {
		Waiting.explicitWaitVisibilityOfElement(this.userName, 20);
		this.userName.click();
		this.userName.clear();
		this.userName.sendKeys(userName);
		return this;
		
	}
	
	public LoginPopUpPageObjects enterPasswordRegression(String password) {
		Waiting.explicitWaitVisibilityOfElement(this.password, 20);
		this.password.click();
		this.password.clear();
		this.password.sendKeys(password);
		return this;
		
	}

	public LoginPopUpPageObjects verifyLoginPopUp() {
		Waiting.explicitWaitVisibilityOfElement(loginPageName, 20);
		Assert.assertTrue(loginPageName.isDisplayed(), "Login page name is not displayed");
		//Assert.assertTrue(rememberMeCheckbox.isDisplayed(),"Remember me checkbox is not displayed");
		Assert.assertTrue(loginButton.isDisplayed(),"login button is not displayed");
		Assert.assertTrue(password.isDisplayed(),"password textbox is not displayed");
		Assert.assertTrue(forgotYourPassword.isDisplayed(),"forgot your password link is not displayed");
		Assert.assertTrue(signUp.isDisplayed(),"Sign up link is not displayed");
		Assert.assertTrue(closeButton.isDisplayed(),"close button is not displayed");
		return this;
	}

	public LoginPopUpPageObjects verifyAutofillOfUserNameAndPassword() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(userName, 10);
		Assert.assertEquals(userName.getAttribute("value"), data.getUserName());
		Assert.assertEquals(password.getAttribute("value"), data.getPassword());
		return this;
}

	public LoginPopUpPageObjects verifyEmptyUserNameAndPasswordTextbox() {
			
			Waiting.explicitWaitVisibilityOfElement(userName, 20);
			Assert.assertEquals(userName.getAttribute("value"), "");
			Assert.assertEquals(password.getAttribute("value"), "");
			return this;
		}

	public LoginPopUpPageObjects clickOnRememberText() {
		rememberMeText.click();
		return this;
	}
	
	public LoginPopUpPageObjects verifyRememberMeCheckBoxSelected() throws InterruptedException {
		Thread.sleep(1500);
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#rememberMe').attr('checked');"),"checked","remember me checkbox is not checked");
		return this;
	}

	public LoginPopUpPageObjects clickOnRemeberMe() throws InterruptedException {
		Thread.sleep(1500);
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",rememberMeCheckbox);
		return this;
	}
	
	public LoginPopUpPageObjects verifyRememberMeCheckboxNotSelected() throws InterruptedException {
		Thread.sleep(1500);
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#rememberMe').attr('checked')",rememberMeCheckbox),null,"remember me checkbox is selected");
		return this;
	}

	public LoginPopUpPageObjects clickOnForgotPassword() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",forgotYourPassword);
		return this;
	}
}
