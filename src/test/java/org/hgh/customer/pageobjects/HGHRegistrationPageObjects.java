package org.hgh.customer.pageobjects;
import org.testng.Assert;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class HGHRegistrationPageObjects extends MainController{

	
 SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//span[@id='question' and contains(text(),'I am a current HGH Hardware Supply Customer')]")
	private WebElement iAmAcurrentHGHHardwareCustomer;
	
	@FindBy(xpath="//div[@id='first']/descendant::span[contains(text(),'Continue')]")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@class='buttonGrad']")private WebElement loginButton;
	
	@FindBy(xpath="//span[@id='question' and contains(text(),'This is my first time ordering online with HGH Hardware')]")
	private WebElement thisIsMyFirstTimeOrderingOnlineWithHGHHardware;

	@FindBy(xpath="//input[@id='companyName1B']")
	private WebElement companyName;
	
	@FindBy(xpath="//input[@id='accountNo1B']")
	private WebElement accountNumberXpath;
	
	@FindBy(xpath="//input[@id='firstName1B']")
	private WebElement firstNameXpath;
	
	@FindBy(xpath="//input[@id='lastName1B']")
	private WebElement lastNameXpath;
	
	
	@FindBy(xpath="//input[@id='emailAddress1B']")
	private WebElement emailXpath;
	
	@FindBy(xpath="//input[@id='newPassword1B']")
	private WebElement passwordXpath;
	
	@FindBy(xpath="//input[@id='newPasswordConfirm1B']")
	private WebElement confirmPasswordXpath;
	
	@FindBy(xpath="//input[@id='companyBillingAddress1B']")
	private WebElement address1Xpath;
	
	@FindBy(xpath="//input[@id='suiteNo1B']")
	private WebElement address2Xpath;
	
	@FindBy(xpath="//input[@id='cityName1B']")
	private WebElement cityXpath;
	
	
	@FindBy(xpath="//select[@id='countryName1B']")
	private WebElement countryXpath;
	
	
	@FindBy(xpath="//select[@id='stateName1B']")
	private WebElement stateXpath;
	
	@FindBy(xpath="//input[@id='zipCode1B']")
	private WebElement zipCodeXpath;
	
	@FindBy(xpath="//input[@id='RegisterWSA']")
	private WebElement iAcceptButton;
	
	@FindBy(xpath="//span[@id='errorMsg']")
	private WebElement errorMsgSection;
	
	@FindBy(xpath="//div[@id='second']/descendant::span[contains(text(),'Continue')]")
	private WebElement continueButtonAgain;
	
	public HGHRegistrationPageObjects clickIAmACurrentHGHHardwareCustomer(){
		Waiting.explicitWaitVisibilityOfElement(iAmAcurrentHGHHardwareCustomer, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",iAmAcurrentHGHHardwareCustomer);
	return this;
	}
	

	public HGHRegistrationPageObjects clickContinue() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",continueButton);
		return this;
	}
	
	
	public HGHRegistrationPageObjects clickLoginButton(){
		Waiting.explicitWaitVisibilityOfElement(loginButton, 10);
		loginButton.click();
		return this;
	}


	public HGHRegistrationPageObjects clickOnThisIsMyFirstTimeOrderingOnlineWithHGHHardware() {
		Waiting.explicitWaitVisibilityOfElement(thisIsMyFirstTimeOrderingOnlineWithHGHHardware, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",thisIsMyFirstTimeOrderingOnlineWithHGHHardware);
		return this;
	}


	public HGHRegistrationPageObjects enterCompanyName(String companyNameText) {
		Waiting.explicitWaitVisibilityOfElement(companyName, 5);
		companyName.sendKeys(companyNameText);
		return this;
	}


	public HGHRegistrationPageObjects enterAccountNumber(String accountNumber) {
		accountNumberXpath.sendKeys(accountNumber);
		return this;
	}


	public HGHRegistrationPageObjects enterAccountFirstName(String firstName) {
		firstNameXpath.sendKeys(firstName);
		return this;
		
	}


	public HGHRegistrationPageObjects enterAccountLastName(String lastName) {
		lastNameXpath.sendKeys(lastName);
		return this;
		
	}


	public HGHRegistrationPageObjects enterAccountEmail(String email) {
		emailXpath.sendKeys(email);
		return this;
		
	}


	public HGHRegistrationPageObjects enterAccountPassword(String password) {
		passwordXpath.sendKeys(password);
		return this;
	}


	public HGHRegistrationPageObjects enterAccountPasswordConfirmation(String passwordConfirmation) {
		confirmPasswordXpath.sendKeys(passwordConfirmation);
		return this;
	}


	public HGHRegistrationPageObjects enterAccountAddress1(String address1) {
		address1Xpath.sendKeys(address1);
		return this;
	}


	public HGHRegistrationPageObjects enterAccountAddress2(String address2) {
		address2Xpath.sendKeys(address2);
		return this;
	}


	public HGHRegistrationPageObjects enterAccountCountry(String country) {
		Select select = new Select(countryXpath);
		select.selectByVisibleText(country);
		return this;
	}


	public HGHRegistrationPageObjects enterAccountState(String state) {
		
		Select select = new Select(stateXpath);
		select.selectByVisibleText(state.trim());
		return this;
	}


	public HGHRegistrationPageObjects enterAccountZipCode(String zipPostalCode) {
		zipCodeXpath.sendKeys(zipPostalCode);
		return this;
	}


	public HGHRegistrationPageObjects clickIAccept() {
		iAcceptButton.click();
		return this;
	}


	public HGHRegistrationPageObjects verifyErrorMsg(String expectedErrorMsg) {
		Waiting.explicitWaitVisibilityOfElement(errorMsgSection, 7);
		Assert.assertEquals(errorMsgSection.getText().trim(), expectedErrorMsg);
		return this;
	}


	public HGHRegistrationPageObjects clickContinueAgain() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",continueButtonAgain);
		return this;
	}


	public HGHRegistrationPageObjects enterCity(String city) {
		cityXpath.sendKeys(city);
		return this;
	}
	
}
