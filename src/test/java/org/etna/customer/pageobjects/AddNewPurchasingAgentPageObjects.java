package org.etna.customer.pageobjects;
import java.util.List;

import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class AddNewPurchasingAgentPageObjects extends MainController{
	
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//div[@class='cimm_instructions']/p")
	private WebElement addNewPurchasingAgentInstructions; 

	@FindBy(xpath="//h2")
	private WebElement addNewPurchasingAgentPageName;
	
	@FindBy(id="contactemailAddress")
	private WebElement emailAddressTextbox;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_formContent']/li/descendant::span[contains(text(),'*')]/ancestor::label")})
	private List<WebElement> mandatoryLabels;
	
	@FindBy(xpath="//input[@id='contactemailAddress']/following-sibling::p")
	private WebElement emailAddressInstruction;
	
	@FindBy(id="contactFirstName")
	private WebElement firstName;
	
	@FindBy(id="contactLastName")
	private WebElement lastName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id="getentityAddress")
	private WebElement useEntityAddressCheckbox;
	
	@FindBy(id="contactAddress1")
	private WebElement address1;
	
	@FindBy(id="contactAddress2")
	private WebElement address2;
	
	@FindBy(id="contactCity")
	private WebElement city;
	
	@FindBy(id="zip")
	private WebElement zipPostalCode;
	
	@FindBy(id="contactPhone")
	private WebElement phoneNumber;
	
	@FindBy(id="contactFax")
	private WebElement faxNumber;
	
	@FindBy(id="contactWebsite")
	private WebElement website;
	
	@FindAll(value={@FindBy(xpath="//div[@id='countrySelect_chosen']/div/descendant::li")})
	private List<WebElement> countryDropdownOptions;
	
	@FindAll(value={@FindBy(xpath="//div[@id='stateSelect_chosen']/div/descendant::li")})
	private List<WebElement> stateDrodpdownOptions;
	
	@FindAll(value={@FindBy(xpath="//div[@id='roleAssign_chosen']/div/descendant::li")})
	private List<WebElement> roleAssignmentDropdownOptions;
	
	@FindBy(xpath="//i[contains(@class,'file-text')]")
	private WebElement instructionsSymbol;
	
	@FindBy(xpath="//h1[contains(text(),'Please Wait')]")
	private WebElement pleaseWait;
	
	@FindBy(xpath="//input[@id='Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@id='roleAssign_chosen']/a")
	private WebElement roleAssignmentSelectdropdown;
	
	@FindBy(xpath="//div[@id='countrySelect_chosen']/a")
	private WebElement countryDropdown;
	
	@FindBy(xpath="//div[@id='stateSelect_chosen']/a")
	private WebElement stateDropdown;
	
	@FindBy(id="errorMsg")
	private WebElement errorMsg;
	
	public AddNewPurchasingAgentPageObjects verifyAddNewPurchasingAgentInstructions() {
	
		Assert.assertEquals(addNewPurchasingAgentInstructions.getText().replace("\n", "").trim(),data.getAddNewPurchasingAgentInstructions().trim(),"Add new purchasing agent is not the displayed.");
		return this;
	}
	
	public AddNewPurchasingAgentPageObjects verifyAddNewPurchasingAgentPageName(String addNewPurchasingAgentBreadcrump) {
		Waiting.explicitWaitVisibilityOfElement(addNewPurchasingAgentPageName, 10);
		Assert.assertEquals(addNewPurchasingAgentPageName.getText().trim(),addNewPurchasingAgentBreadcrump.trim().toUpperCase(),"Add new purchasing agent page is nat right.");
		return this;
	}
	
	
	public AddNewPurchasingAgentPageObjects verifyAddNewPurchasingEmailAddressTextbox() {
		
		Assert.assertTrue(emailAddressTextbox.isDisplayed(),"Add new purchasing agent EmailID textbox is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyMandatoryFields() {
		String expectedMandatoryFieldsInAddNewPurchasingAgent [] = data.getExpectedMandatoryFieldsInAddNewPurchasingAgent().split(",");
		for(int i = 0; i<mandatoryLabels.size();i++)
		{
			Assert.assertEquals(mandatoryLabels.get(i).getText().replace("*", "").trim(), expectedMandatoryFieldsInAddNewPurchasingAgent[i].trim());
		}
		return this;
	}
	
	public AddNewPurchasingAgentPageObjects verifyDisplayOfEmailAddressInstruction() {
		Assert.assertEquals(emailAddressInstruction.getText().trim(),data.getEmailAddressInstruction().trim(),"The email address instruction is  "+emailAddressInstruction.getText().trim()+" but expecting email address instruction as "+data.getEmailAddressInstruction().trim());
		return this;
	}
	
	public AddNewPurchasingAgentPageObjects verifyAddNewPurchasingAgentBreadcrump() {
		Assert.assertEquals(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().trim(),"Add New Purchasing Agent");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyAddNewPurchasingAgentBreadcrump(String addNewPurchasingAgentBreadcrump) throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),addNewPurchasingAgentBreadcrump+" | "+setUp.getProductName().toUpperCase());
		return this;
		
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfFirstNameTextbox() {
		Assert.assertTrue(firstName.isDisplayed(), "firstname textbox is not displayed");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfLastNameTextbox() {
		Assert.assertTrue(lastName.isDisplayed(), "lastname textbox is not displayed");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfPasswordTextbox() {
		Assert.assertTrue(password.isDisplayed(), "password textbox is not displayed");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfConfirmPasswordTextbox() {
		Assert.assertTrue(confirmPassword.isDisplayed(), "confirm password textbox is not displayed");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyUseEntityAddressCheckbox() throws Exception {
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#getentityAddress').prop('checked');"),false,"Use entity address is checked.");
		Thread.sleep(1500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",useEntityAddressCheckbox);
		Thread.sleep(3000);
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#getentityAddress').prop('checked');"),true,"Use entity address is not checked.");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",useEntityAddressCheckbox);
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#getentityAddress').prop('checked');"),false,"Use entity address is checked.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfAddress1Textbox() {
		Assert.assertTrue(address1.isDisplayed(), "address1 textbox is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfAddress2Textbox() {
		Assert.assertTrue(address2.isDisplayed(), "address2 textbox is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfCityTextbox() {
		Assert.assertTrue(city.isDisplayed(), "city textbox is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfZipCodeTextbox() {
		Assert.assertTrue(zipPostalCode.isDisplayed(), "zip Postal Code textbox is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfPhoneNumberTextbox() {
		Assert.assertTrue(phoneNumber.isDisplayed(), "phone Number textbox is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfFaxNumberTextbox() {
		Assert.assertTrue(faxNumber.isDisplayed(), "fax textbox is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfWebsiteTextbox() {
		Assert.assertTrue(website.isDisplayed(), "website textbox is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyDisplayOfSubmitButton() {
		Assert.assertTrue(submitButton.isDisplayed(), "submit Button is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyRoleChosenDropdown() {
		Assert.assertTrue(roleAssignmentSelectdropdown.isDisplayed(), "role assignment dropdown is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyCountryDropdown() {
		Assert.assertTrue(countryDropdown.isDisplayed(), "country dropdown is not displayed.");
		
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyStateDropdown() {
		Assert.assertTrue(stateDropdown.isDisplayed(), "state dropdown is not displayed.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects clickOnSubmit() {
		submitButton.click();
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterEmailId(String emailId) {
		emailAddressTextbox.sendKeys(emailId);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterPassword(String password) {
		this.password.sendKeys(password);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterConfirmPassword(String confirmPassword) {
		this.confirmPassword.sendKeys(confirmPassword);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterAddress1(String address1) {
		this.address1.sendKeys(address1);
		return this;
	}

	public AddNewPurchasingAgentPageObjects etnerAddress2(String address2) {
		this.address2.sendKeys(address2);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterCity(String city) {
		this.city.sendKeys(city);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterZipCode(String zipPostalCode) {
		this.zipPostalCode.sendKeys(zipPostalCode);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterPhoneNumber(String phoneNumber) {
		this.phoneNumber.sendKeys(phoneNumber);
		return this;
	}

	public AddNewPurchasingAgentPageObjects enterFaxNumber(String faxNumber) {
		this.faxNumber.sendKeys(faxNumber);
		return this;
	}

	public AddNewPurchasingAgentPageObjects website(String website) {
		this.website.sendKeys(website);
		return this;
	}

	public AddNewPurchasingAgentPageObjects chooseRoleAssignment(String roleAssignment) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(roleAssignmentSelectdropdown, 5);
		roleAssignmentSelectdropdown.click();
		Waiting.explicitWaitVisibilityOfElements(roleAssignmentDropdownOptions, 3);
		for(WebElement roleOption : roleAssignmentDropdownOptions)
		{
			if(roleOption.getText().trim().equals(roleAssignment))
			{
				roleOption.click();
				break;
			}
		}
		return this;
	}

	public AddNewPurchasingAgentPageObjects chooseState(String state) throws Exception {
		stateDropdown.click();
		Waiting.explicitWaitVisibilityOfElements(stateDrodpdownOptions, 3);
		for(WebElement stateOption : stateDrodpdownOptions)
		{
			if(stateOption.getText().trim().equals(state))
			{
				stateOption.click();
				break;
			}
		}
		return this;
	}

	public AddNewPurchasingAgentPageObjects verifyErrorMsg(String expectedErrorMsg) {
		Waiting.explicitWaitVisibilityOfElement(errorMsg, 20);
		Assert.assertEquals(errorMsg.getText().replace("\n", "").trim(), expectedErrorMsg.trim());
		return this;
	}
	
	
}