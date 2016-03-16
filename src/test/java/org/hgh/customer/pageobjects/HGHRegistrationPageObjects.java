package org.hgh.customer.pageobjects;
import org.testng.Assert;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class HGHRegistrationPageObjects extends MainController{

	public HGHRegistrationPageObjects(WebDriver driver){
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,15);
		PageFactory.initElements(driver, this);
		PageFactory.initElements(factory, this);
	}
	
	@FindBy(xpath="//span[@id='question' and text()='I am a current HGH Hardware Customer']")
	private WebElement iAmAcurrentHGHHardwareCustomer;
	
	@FindBy(xpath="//div[@id='first']/descendant::span[contains(text(),'Continue')]")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@class='buttonGrad']")private WebElement loginButton;
	
	@FindBy(xpath="//span[@id='question' and text()='This is my first time ordering online with HGH Hardware']")
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
	
	public void clickIAmACurrentHGHHardwareCustomer(){
		Waiting.explicitWaitVisibilityOfElement(iAmAcurrentHGHHardwareCustomer, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",iAmAcurrentHGHHardwareCustomer);
	}
	

	public void clickContinue() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",continueButton);
	}
	
	
	public void clickLoginButton(){
		Waiting.explicitWaitVisibilityOfElement(loginButton, 10);
		loginButton.click();
	}


	public void clickOnThisIsMyFirstTimeOrderingOnlineWithHGHHardware() {
		Waiting.explicitWaitVisibilityOfElement(thisIsMyFirstTimeOrderingOnlineWithHGHHardware, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",thisIsMyFirstTimeOrderingOnlineWithHGHHardware);
		
	}


	public void enterCompanyName(String companyNameText) {
		Waiting.explicitWaitVisibilityOfElement(companyName, 5);
		companyName.sendKeys(companyNameText);
		
	}


	public void enterAccountNumber(String accountNumber) {
		accountNumberXpath.sendKeys(accountNumber);
	}


	public void enterAccountFirstName(String firstName) {
		firstNameXpath.sendKeys(firstName);
		
	}


	public void enterAccountLastName(String lastName) {
		lastNameXpath.sendKeys(lastName);
		
	}


	public void enterAccountEmail(String email) {
		emailXpath.sendKeys(email);
		
	}


	public void enterAccountPassword(String password) {
		passwordXpath.sendKeys(password);
		
	}


	public void enterAccountPasswordConfirmation(String passwordConfirmation) {
		confirmPasswordXpath.sendKeys(passwordConfirmation);
		
	}


	public void enterAccountAddress1(String address1) {
		address1Xpath.sendKeys(address1);
		
	}


	public void enterAccountAddress2(String address2) {
		address2Xpath.sendKeys(address2);
		
	}


	public void enterAccountCountry(String country) {
		Select select = new Select(countryXpath);
		select.selectByVisibleText(country);
		
	}


	public void enterAccountState(String state) {
		
		Select select = new Select(stateXpath);
		select.selectByVisibleText(state.trim());
		
	}


	public void enterAccountZipCode(String zipPostalCode) {
		zipCodeXpath.sendKeys(zipPostalCode);
		
	}


	public void clickIAccept() {
		iAcceptButton.click();
		
	}


	public void verifyErrorMsg(String expectedErrorMsg) {
		Waiting.explicitWaitVisibilityOfElement(errorMsgSection, 7);
		Assert.assertEquals(errorMsgSection.getText().trim(), expectedErrorMsg);
		
	}


	public void clickContinueAgain() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",continueButtonAgain);
		
	}


	public void enterCity(String city) {
		cityXpath.sendKeys(city);
		
	}
	
}
