package org.etna.modules;

import org.testng.annotations.Test;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;

public class APAModuleTest extends MainController {
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	
	@Test(groups={"APAModule","regression"},alwaysRun=true)
	 public void TC_APA_001_verifyDisplayOfManageAddDisablePAafterSuperUserLogin() throws Exception{
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnUserAccountDropdown()
		.verifyAddManageDisablePANewPurchasingAgentIsDisplayedInUserAccountDropdown();
		
	}
	
	@Test(groups={"APAModule","regression"},alwaysRun=true)
	 public void TC_APA_002_TC_APA_050_verifyAddNewPA_afterSuperUserLogin_VerifyBreadcrumpOfAddNewPurchasingAgent() throws Exception{
		String addNewPurchasingAgentBreadcrump = data.getAddNewPurchasingAgentBreadcrump();
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
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_003_addNewPurchasingAgent_GeneralUser() throws Exception{
		
		throw new SkipException("pending.");
	}
	
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_004_generalUserLoginCheckoutButtonNotDisplayedInCart() throws Exception{
		
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
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_005_addNewPurchasingAgent_APA() throws Exception{
		
		throw new SkipException("pending.");
	}
	
	@Test(groups={"APAModule","regression"},enabled=false)
	 public void TC_APA_006() throws Exception{
		
		throw new SkipException("pending.");
	}
	
	@Test(groups={"regression"},enabled=false)
	 public void TC_APA_007() throws Exception{
		
		throw new SkipException("pending.");
	}
	
	@Test(alwaysRun=true,groups={"APAModule","regression"},dataProvider="excelSheetDataRead",dataProviderClass=SearchData.class)
	public void TC_PA_008_To_TC_PA_022_errorScenarios(String emailId,String firstName, String lastName, String password, String confirmPassword,String address1, String address2, String city, String state, String zipCode,String phoneNumber,String roleAssignment,String faxNumber,String website,String expectedErrorMsg) throws Exception
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

