package org.etna.customer.pageobjects;
import org.testng.Assert;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageObjects extends PageFactoryInitializer{
	
	@FindBy(xpath="//span[@id='question' and contains(text(),'I am a current HGH Hardware Supply Customer')]")
	private WebElement iAmAcurrentHGHHardwareCustomer;
	
	@FindBy(xpath="//div[@id='firstQuestion']/descendant::span[contains(text(),'Continue')]")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@class='buttonGrad']")
	private WebElement loginButton;
	
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
	
	@FindBy(xpath="//div[@id='first']/descendant::span[contains(text(),'Continue')]")
	private WebElement continueButtonAgain;
	
	@FindBy(xpath="//input[@id='phoneNo1B']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//li[contains(text(),'Registration')]")
	private WebElement registrationBreadCrump;
	
	public RegistrationPageObjects clickIAmACurrentHGHHardwareCustomer() throws InterruptedException{
		Waiting.explicitWaitVisibilityOfElement(iAmAcurrentHGHHardwareCustomer, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",iAmAcurrentHGHHardwareCustomer);
	return this;
	}
	

	public RegistrationPageObjects clickContinue() throws Exception {
	
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",continueButton);
		return this;
	}
	
	public RegistrationPageObjects clickLoginButton(){
		Waiting.explicitWaitVisibilityOfElement(loginButton, 10);
		loginButton.click();
		return this;
	}


	public RegistrationPageObjects clickOnThisIsMyFirstTimeOrderingOnlineWithHGHHardware() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(thisIsMyFirstTimeOrderingOnlineWithHGHHardware, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",thisIsMyFirstTimeOrderingOnlineWithHGHHardware);
		return this;
	}


	public RegistrationPageObjects enterCompanyName(String companyNameText) {
		Waiting.explicitWaitVisibilityOfElement(companyName, 5);
		companyName.sendKeys(companyNameText);
		return this;
	}


	public RegistrationPageObjects enterAccountNumber(String accountNumber) {
		accountNumberXpath.sendKeys(accountNumber);
		return this;
	}


	public RegistrationPageObjects enterAccountFirstName(String firstName) {
		firstNameXpath.sendKeys(firstName);
		return this;
		
	}


	public RegistrationPageObjects enterAccountLastName(String lastName) {
		lastNameXpath.sendKeys(lastName);
		return this;
		
	}


	public RegistrationPageObjects enterAccountEmail(String email) {
		emailXpath.sendKeys(email);
		return this;
		
	}


	public RegistrationPageObjects enterAccountPassword(String password) {
		passwordXpath.sendKeys(password);
		return this;
	}


	public RegistrationPageObjects enterAccountPasswordConfirmation(String passwordConfirmation) {
		confirmPasswordXpath.sendKeys(passwordConfirmation);
		return this;
	}


	public RegistrationPageObjects enterAccountAddress1(String address1) {
		address1Xpath.sendKeys(address1);
		return this;
	}


	public RegistrationPageObjects enterAccountAddress2(String address2) {
		address2Xpath.sendKeys(address2);
		return this;
	}


	public RegistrationPageObjects enterAccountCountry(String country) {
		Select select = new Select(countryXpath);
		select.selectByVisibleText(country);
		return this;
	}


	public RegistrationPageObjects enterAccountState(String state) {
		
		Select select = new Select(stateXpath);
		select.selectByVisibleText(state.trim());
		return this;
	}


	public RegistrationPageObjects enterAccountZipCode(String zipPostalCode) {
		zipCodeXpath.sendKeys(zipPostalCode);
		return this;
	}


	public RegistrationPageObjects clickIAccept() {
		iAcceptButton.click();
		return this;
	}


	public RegistrationPageObjects verifyErrorMsg(String expectedErrorMsg) {
		Waiting.explicitWaitVisibilityOfElement(errorMsgSection, 7);
		Assert.assertEquals(errorMsgSection.getText().trim(), expectedErrorMsg);
		return this;
	}


	public RegistrationPageObjects clickContinueAgain() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",continueButtonAgain);
		return this;
	}


	public RegistrationPageObjects enterCity(String city) {
		cityXpath.sendKeys(city);
		return this;
	}


	public RegistrationPageObjects enterPhoneNumber(String phonenumber) {
		phoneNumber.sendKeys(phonenumber);
		return this;
	}


	public RegistrationPageObjects verifyRegistrationPage() {
		Waiting.explicitWaitVisibilityOfElement(registrationBreadCrump, 10);
		Assert.assertTrue(registrationBreadCrump.isDisplayed(),"registration breadcrump is not displayed");
		Assert.assertEquals(loginPopUp().pageName.getText().trim(), "Registration");
		return this;
		
	}
	
}
