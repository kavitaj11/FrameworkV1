package org.hgh.testmethods;
import org.hgh.customer.pageobjects.HGHHomePageObjects;
import org.hgh.customer.pageobjects.HGHLoginPageObjects;
import org.hgh.customer.pageobjects.HGHMyAccountsPageObjects;
import org.hgh.customer.pageobjects.HGHProductsDetailsPageObjects;
import org.hgh.customer.pageobjects.HGHProductsListPageObjects;
import org.hgh.customer.pageobjects.HGHRegistrationPageObjects;
import org.hgh.customer.pageobjects.HGHShoppingCartPageObjects;
import org.hgh.dataprovider.SearchData;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.TestUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HGHTestCustomer extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */

	
 SearchDataPropertyFile data = new SearchDataPropertyFile();
 
  @Test(groups={"regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void tc001_HGH_Registration_ErrorScenarios(String companyName,String accountNumber,String firstName,String lastName,String email,String password,String passwordConfirmation,String address1,String address2,String city,String country,String state,String zipPostalCode,String expectedErrorMsg) throws Exception
  {
			homePage().clickLoginLink().loginPage().clickNewCustomerRegisterNow()
			.clickIAmACurrentHGHHardwareCustomer().clickContinue()
			.clickOnThisIsMyFirstTimeOrderingOnlineWithHGHHardware()
			.clickContinueAgain()
			.enterCompanyName(companyName)
			.enterAccountNumber(accountNumber)
			.enterAccountFirstName(firstName)
			.enterAccountLastName(lastName)
			.enterAccountEmail(email)
			.enterAccountPassword(password)
			.enterAccountPasswordConfirmation(passwordConfirmation)
			.enterAccountAddress1(address1)
			.enterAccountAddress2(address2)
			.enterCity(city)
			.enterAccountCountry(country)
			.enterAccountState(state)
			.enterAccountZipCode(zipPostalCode)
			.clickIAccept()
			.verifyErrorMsg(expectedErrorMsg);
		}
  
  @Test(groups={"smoke","regression"})
	public void tc002_HGH_login() throws Exception
	{
	
	  homePage().clickLoginLink().loginPage().enterUsername().enterPassword().clickOnLoginButton();
	  Assert.assertTrue(homePage().verifyWelcomeMsg(),"welcome is not displayed");
	}

  @Test(groups={"regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void tc003_HGH_LoginErrorScenarios(String userName, String password,String expectedMsg) throws Exception
  {
	  homePage().clickLoginLink().loginPage().enterUsernameRegression(userName).enterPasswordRegression(password)
	  .clickOnLoginButton().homePage().assertForErrorMessages(expectedMsg);
		}
 
  
  @Test(groups={"smoke","regression"})
  public void tc004_HGH_generalSearch() throws Exception
  {
	  		String searchText = data.getSearchText();
			homePage().searchText(searchText).clickOnSearch().productListPage().verifyHeader(searchText)
			.clickOnFirstProduct().productDetailsPage().verifyHeadingOfProduct(searchText);
		}
  
  @Test(groups={"smoke","regression"})
  public void tc005_HGH_ListViewGridView() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		homePage().searchText(searchText).clickOnSearch().productListPage().verifyGridView().clickOnChangeView()
	  		.verifyListView();
  }
  
  
  @Test(groups={"smoke","regression"})
  public void tc006_HGH_ProductListPage() throws Exception
  {
	  		String searchText = data.getSearchText();
			homePage().searchText(searchText).clickOnSearch()
			.productListPage().verifyListOfProducts().verifyAdvancedSearchSection()
			.verifyRefineSearchHeader()
			.verifyCategoryFilterSection()
			.verifyBrandsFilterSection()
			.verifySortBySection()
			.verifyNarrowSearchBox()
			.verifyCompareListLink();
  }
  
  @Test(groups={"smoke","regression"})
  public void tc007_HGH_MyProductGroupCreateAndDelete() throws Exception
  {
	  		String groupName = data.getGroupName();
	  		String searchText = data.getSearchText();
			tc002_HGH_login();
			homePage().searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnFirstMyProductGroup()
			.enterGroupName(groupName);
			TestUtility.hitEnter();
			homePage()
			.clickOnMyAccounts()
			.myAccountsPage()
			.clickOnMyProductGroupsInMyAccountsPage()
			.myProductsPageHeader()
			.clickOnTheGroupCreated(groupName)
			.verifyGroupName(groupName)
			.deleteGroup();
			TestUtility.alertAccept();
			homePage().clickOnMyAccounts().myAccountsPage().clickOnMyProductGroupsInMyAccountsPage()
			.verifyNoProductGroupsNotAvailable();
  } 
 
  @Test(groups={"smoke","regression"})
  public void tc008_verifyHeaderAndFooter() throws Exception
  {
			homePage()
			.verifyDisplayOfLoginLink()
			.verifyDisplayOfMyAccountsInHeader()
			.verifyDisplayOfOrderStatusInHeader()
			.verifyDisplayOfOrderPadInHeader()
			.verifyResourcesLinkInHeader()
			.verifyHelpLinkHeader()
			.verifyHeadingOfEverySectionInFooter()
			.verifyCustomerServiceLinkInFooter()
			.verifyHelpCenterInFooter()
			.verifyHelpContactUsInFooter()
			.verifyReturnsInFooter()
			.verifyShippingPolicyInFooter()
			.verifyMyAccountInFooter()
			.verifyOrderStatusInFooter()
			.verifyQuickOrderpadInFooter()
			.verifyMyCartInFooter()
			.verifyTradePartnersInFooter()
			.verifyLearningCenterInFooter()
			.verifyManufacturersInFooter()
			.verifyBlogInFooter()
			.verifySecurityAndPrivacyInFooter()
			.verifyTermsOfUseInFooter()
			.verifyAboutUsInFooter()
			.verifyEventsInFooter()
			.verifyBranchLocationInFooter()
			.verifyCareersInFooter()
			.verifySiteMapInFooter()
			.verifyTaxonomies();
  } 
  
  
  @Test(groups={"smoke","regression"})
  public void tc009_compareFunctionality() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		homePage()
	  		.searchText(searchText)
	  		.clickOnSearch()
	  		.productListPage()
	  		.clickFirstTwoCompareCheckboxes()
	  		.clickOnCompare()
	  		.verifyCompareHeaderAndBreampCrump()
	  		.verifyDisplayOfCompareTable();
}
  
  @Test(groups={"smoke","regression"})
  public void tc010_HGH_saveCart() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		String saveCartName = data.getSaveCartName();
			tc002_HGH_login();
			shoppingCartPage().clearCart();
			homePage().searchText(searchText).clickOnSearch().productListPage().clickOnFirstProduct()
			.productDetailsPage().clickOnAddToCart().clickOnCheckout().shoppingCartPage().clickOnSaveCart()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName);
			TestUtility.hitEnter();
			homePage().clickOnMyAccounts().myAccountsPage().clickOnMySavedCartLinkInMyAccountsPage()
			.clickOnMySavedCartLinkInMyAccountsPage().clickOnTheCreatedSaveCart(saveCartName)
			.verifySaveCartHeading(saveCartName).deleteSaveCart();
			TestUtility.alertAccept();
			homePage().clickOnMyAccounts()
			.myAccountsPage().clickOnMySavedCartLinkInMyAccountsPage()
			.verifyMySavedCartNotAvialable();
			shoppingCartPage().clearCart();
			
}
  
  @Test(groups={"smoke","regression"})
  public void tc011_HGH_AccountsDashboard() throws Exception
  {
	  		
			tc002_HGH_login();
			homePage().clickOnMyAccounts()
			.myAccountsPage().verifyProductCategoriesSection()
			.verifyMyAccountSection();
}
  
  @Test(groups={"smoke","regression"})
  public void tc012_HGH_shoppingCartPage() throws Exception
  {
	 String searchText = data.getSearchText();
	 String quantity = data.getQuantityForShoppingCartPageVerification();
	 tc002_HGH_login();
	 shoppingCartPage().clearCart();
	 homePage().searchText(searchText)
	.clickOnSearch().productListPage()
	 .clickOnFirstProduct()
	 .productDetailsPage().addDifferentQuantity(quantity)
	 .clickOnAddToCart()
	 .clickOnCheckout()
	 .shoppingCartPage()
	 .checkWhetherItIsTheSameQuantity(quantity)
	 .shoppingCartPage().verifyShoppingCartBreadCrump().verifyShoppingCartPageHeading()
	.verifyButtonsOnTopOfTheCart()
	.verifyButtonsOnBottomOfTheCart();
}
  

@Test(groups={"smoke","regression"})
  public void tc013_HGH_cartFileUpload() throws Exception
  {

	 tc002_HGH_login();
	 shoppingCartPage().clearCart();
	 homePage().clickOnMyAccounts()
	 .myAccountsPage().clickOnCartFileUpload()
	 .verifyBreadCrumpAndHeadingOfCartFileUpload()
	 .fileUpload(data.getFileUploadPath())
	 .clickOnUpload()
	 .verifyQuickCartPage();
  }
  
  @Test(groups={"smoke","regression"})
  public void tc014_HGH_quickOrderPad() throws Exception
  {
	  
	 tc002_HGH_login();
	 shoppingCartPage().clearCart();
	 homePage().clickOnQuickOrderPadLink()
	 .myAccountsPage().verifyQuickCartBreadCrump()
	 .verifyQuickCartPage()
	 .selectPartNumberFromDropdown();
	// myAccountsPage.enterPartNumberValues();
	 
  }
  
  @Test(groups={"smoke","regression"})
  public void tc015_HGH_requestForQuote() throws Exception
  {
	 
	 tc002_HGH_login();
	 shoppingCartPage().clearCart();
	 homePage()
	 .clickOnMyAccounts()
	 .myAccountsPage()
	 .clickOnRequestForQuote()
	 .verifyRequestForQuoteHeadingAndBreadcrump()
	 .enterPhoneNumberForRequestQuote()
	 .enterRequestDetails()
	 .clickSubmit()
	 .clickOnOkForAfterCompletionOfRequestForQuote();
  }
  
  
  
  /*@Test
  public void dayanandTest() throws Exception{
	  HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
	  homePage.findNow();
  }*/
}
