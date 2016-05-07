package org.etna.modules;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;

public class APAModuleTest extends PageFactoryInitializer {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	String addNewPurchasingAgentBreadcrump = data.getAddNewPurchasingAgentBreadcrump();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	@Features("APA Module")
	@Description("This is a test case which verifies whether Add new Purchasing Agent, Manage Purchasing Agent and Delete Purchasing Agent is displayed in the user account dropdown.")
	@TestCaseId("TC_APA_001")
	@Test(groups={"regression"})
	public void verifyDisplayOfManageAddDisablePAafterSuperUserLogin() throws Exception{
		loginModule.loginAsASuperUser(); 
		homePage()
		.clickOnUserAccountDropdown()
		.verifyAddManageDisablePANewPurchasingAgentIsDisplayedInUserAccountDropdown();	
	}
	
	@Features("APA Module")
	@Description("This is a test case which verifies the Add new Purchasing Agent page.")
	@TestCaseId("TC_APA_002,TC_APA_050")
	@Test(groups={"regression"})
	 public void verifyAddNewPA_afterSuperUserLogin_VerifyBreadcrumpOfAddNewPurchasingAgent() throws Exception{
		
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnAddNewPurchasingAgent()
		.addNewPurchasingAgentPage()
		.verifyAddNewPurchasingAgentPageName(addNewPurchasingAgentBreadcrump)
		.verifyAddNewPurchasingAgentInstructions()
		.verifyAddNewPurchasingEmailAddressTextbox()
		.verifyMandatoryFields()
		.verifyDisplayOfEmailAddressInstruction()
		.verifyDisplayOfFirstNameTextbox()
		.verifyDisplayOfLastNameTextbox()
		.verifyDisplayOfPasswordTextbox()
		.verifyDisplayOfConfirmPasswordTextbox()
		.verifyDisplayOfAddress1Textbox()
		.verifyDisplayOfAddress2Textbox()
		.verifyDisplayOfCityTextbox()
		.verifyDisplayOfZipCodeTextbox()
		.verifyDisplayOfPhoneNumberTextbox()
		.verifyDisplayOfFaxNumberTextbox()
		.verifyDisplayOfWebsiteTextbox()
		.verifyDisplayOfSubmitButton()
		.verifyUseEntityAddressCheckbox()
		.verifyRoleChosenDropdown()
		.verifyCountryDropdown()
		.verifyStateDropdown()
		.verifyAddNewPurchasingAgentBreadcrump(addNewPurchasingAgentBreadcrump);
		
	}
	
	@Features("APA Module")
	
	@Test(groups={"regression"})
	 public void _addNewPurchasingAgent_GeneralUser() throws Exception{
		
		throw new SkipException("pending.");
	}
	
	@Features("APA Module")
	@TestCaseId("TC_APA_004")
	@Description("This is a test case which makes sure that for a general user the checkout button is not displayed.")
	@Test(groups={"regression"})
	public void generalUserLoginCheckoutButtonNotDisplayedInCart() throws Exception{
		loginModule.login(data.getGeneralUserEmailID(), data.getGeneralUserPassword());
		homePage()
		.searchText(data.getSearchTextForUPCLabelTest())
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.verifyMyCartBreadcrump(data.getMyCartBreadcrump())
		.verifyMyCartPagename(data.getMyCartBreadcrump())
		.verifyMyCartTitle(data.getMyCartBreadcrump())
		.verifyCheckoutButtonNotDisplayedInMyCartPage()
		.verifyButtonsAvailableForGeneralUserInMyCart();
	}
	
	@Features("APA Module")
	@TestCaseId("TC_APA_005")
	@Test(groups={"regression"})
	 public void addNewPurchasingAgent_APA() throws Exception{
		
		throw new SkipException("pending.");
	}
	
	@Features("APA Module")
	@TestCaseId("TC_APA_006")
	@Test(groups={"regression"})
	 public void TC_APA_006() throws Exception{
		
		throw new SkipException("pending.");
	}
	
	@Features("APA Module")
	@Test(groups={"regression"})
	 public void TC_APA_007() throws Exception{
		
		throw new SkipException("pending.");
	}
	
	@Features("APA Module")
	@TestCaseId("TC_APA_008-to-TC_APA_022")
	@Description("These are a bunch of test cases that tests the error scenarios involved during Add New Purchasing Agent.")
	@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void addNewPurchasingAgent_errorScenarios(@Parameter("Email ID") String emailId,@Parameter("First Name") String firstName,@Parameter("Last Name") String lastName,@Parameter("Password") String password,@Parameter("Confirm Password") String confirmPassword,@Parameter("Address 1") String address1,@Parameter("Address 2") String address2,@Parameter("City") String city,@Parameter("State") String state,@Parameter("Zip Code") String zipCode,@Parameter("Phone Number") String phoneNumber,@Parameter("Role Assignment") String roleAssignment,@Parameter("Fax Number") String faxNumber,@Parameter("Website") String website,@Parameter("Error Message") String expectedErrorMsg) throws Exception
	{
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.clickOnAddNewPurchasingAgent()
		.addNewPurchasingAgentPage()
		.enterEmailId(emailId)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterPassword(password)
		.enterConfirmPassword(confirmPassword)
		.enterAddress1(address1)
		.etnerAddress2(address2)
		.enterCity(city)
		.enterZipCode(zipCode)
		.enterPhoneNumber(phoneNumber)
		.enterFaxNumber(faxNumber)
		.website(website)
		.chooseRoleAssignment(roleAssignment)
		.chooseState(state)
		.clickOnSubmit()
		.verifyErrorMsg(expectedErrorMsg);
	}

}

