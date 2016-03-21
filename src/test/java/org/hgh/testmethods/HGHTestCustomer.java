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
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHLoginPageObjects loginPage = new HGHLoginPageObjects(driver);
			HGHRegistrationPageObjects registrationPage = new HGHRegistrationPageObjects(driver);
			homePage.clickLoginLink();
			loginPage.clickNewCustomerRegisterNow();
			registrationPage.clickIAmACurrentHGHHardwareCustomer();
			registrationPage.clickContinue();
			registrationPage.clickOnThisIsMyFirstTimeOrderingOnlineWithHGHHardware();
			registrationPage.clickContinueAgain();
			registrationPage.enterCompanyName(companyName);
			registrationPage.enterAccountNumber(accountNumber);
			registrationPage.enterAccountFirstName(firstName);
			registrationPage.enterAccountLastName(lastName);
			registrationPage.enterAccountEmail(email);
			registrationPage.enterAccountPassword(password);
			registrationPage.enterAccountPasswordConfirmation(passwordConfirmation);
			registrationPage.enterAccountAddress1(address1);
			registrationPage.enterAccountAddress2(address2);
			registrationPage.enterCity(city);
			registrationPage.enterAccountCountry(country);
			registrationPage.enterAccountState(state);
			registrationPage.enterAccountZipCode(zipPostalCode);
			registrationPage.clickIAccept();
			registrationPage.verifyErrorMsg(expectedErrorMsg);
			
		}
  
  @Test(groups={"smoke","regression"})
	public void tc002_HGH_login() throws Exception
	{
		HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
		HGHLoginPageObjects loginPage = new HGHLoginPageObjects(driver);
		homePage.clickLoginLink();
		loginPage.enterUsername();
		loginPage.enterPassword();
		TestUtility.hitEnter();
		Assert.assertTrue(homePage.verifyWelcomeMsg(),"welcome is not displayed");
	}

  @Test(groups={"regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void tc003_HGH_LoginErrorScenarios(String userName, String password,String expectedMsg) throws Exception
  {
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHLoginPageObjects loginPage = new HGHLoginPageObjects(driver);
			homePage.clickLoginLink();
			loginPage.enterUsernameRegression(userName);
			loginPage.enterPasswordRegression(password);
			TestUtility.hitEnter();
			homePage.assertForErrorMessages(expectedMsg);
		}
 
  
  @Test(groups={"smoke","regression"})
  public void tc004_HGH_generalSearch() throws Exception
  {
	  		String searchText = data.getSearchText();
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			HGHProductsDetailsPageObjects productDetailsPage = new HGHProductsDetailsPageObjects(driver);
			homePage.searchText(searchText);
			homePage.clickOnSearch();
			Assert.assertTrue(productsListPage.verifyHeader(searchText),"products page search header is not displayed");
			productsListPage.clickOnFirstProduct();
			Assert.assertTrue(productDetailsPage.verifyHeadingOfProduct(searchText),"product brand name is not contain the search text");
		}
  
  @Test(groups={"smoke","regression"})
  public void tc005_HGH_ListViewGridView() throws Exception
  {
	  		String searchText = data.getSearchText();
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			homePage.searchText(searchText);
			homePage.clickOnSearch();
			Assert.assertTrue(productsListPage.verifyGridView(),"class name is not grid view");
			homePage.clickOnChangeView();
			Assert.assertTrue(productsListPage.verifyListView(),"class name is not list view");
  }
  
  
  @Test(groups={"smoke","regression"})
  public void tc006_HGH_ProductListPage() throws Exception
  {
	  		String searchText = data.getSearchText();
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			homePage.searchText(searchText);
			homePage.clickOnSearch();
			Assert.assertTrue(productsListPage.verifyListOfProducts(), "products are not displayed");
			Assert.assertTrue(productsListPage.verifyAdvancedSearchSection(),"Advanced search section is not displayed");
			Assert.assertTrue(productsListPage.verifyRefineSearchHeader(),"refine results header is not displayed");
			Assert.assertTrue(productsListPage.verifyCategoryFilterSection(),"category Filter section is not displayed");
			Assert.assertTrue(productsListPage.verifyBrandsFilterSection(),"category Filter section is not displayed");
			Assert.assertTrue(productsListPage.verifySortBySection(),"Sort By section is not displayed");
			Assert.assertTrue(productsListPage.verifyNarrowSearchBox(),"narrow Search box is not displayed");
			Assert.assertTrue(productsListPage.verifyCompareListLink(),"Compare List is not displayed");
  }
  
  @Test(groups={"smoke","regression"})
  public void tc007_HGH_MyProductGroupCreateAndDelete() throws Exception
  {
	  		String groupName = data.getGroupName();
	  		String searchText = data.getSearchText();
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			HGHMyAccountsPageObjects myAccountsPage = new HGHMyAccountsPageObjects(driver);
			tc002_HGH_login();
			homePage.searchText(searchText);
			homePage.clickOnSearch();
			productsListPage.clickOnFirstMyProductGroup();
			productsListPage.enterGroupName(groupName);
			TestUtility.hitEnter();
			homePage.clickOnMyAccounts();
			myAccountsPage.clickOnMyProductGroupsInMyAccountsPage();
			myAccountsPage.myProductsPageHeader();
			myAccountsPage.clickOnTheGroupCreated(groupName);
			Assert.assertTrue(myAccountsPage.verifyGroupName(groupName),"group Name is not displayed after clicking on the group");
			myAccountsPage.deleteGroup();
			TestUtility.alertAccept();
			homePage.clickOnMyAccounts();
			myAccountsPage.clickOnMyProductGroupsInMyAccountsPage();
			Assert.assertTrue(myAccountsPage.verifyNoProductGroupsNotAvailable(),"no product group available is not displayed");
  } 
 
  @Test(groups={"smoke","regression"})
  public void tc008_verifyHeaderAndFooter() throws Exception
  {
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			homePage.verifyDisplayOfLoginLink();
			homePage.verifyDisplayOfMyAccountsInHeader();
			homePage.verifyDisplayOfOrderStatusInHeader();
			homePage.verifyDisplayOfOrderPadInHeader();
			homePage.verifyResourcesLinkInHeader();
			homePage.verifyHelpLinkHeader();
			homePage.verifyHeadingOfEverySectionInFooter();
			homePage.verifyCustomerServiceLinkInFooter();
			homePage.verifyHelpCenterInFooter();
			homePage.verifyHelpContactUsInFooter();
			homePage.verifyReturnsInFooter();
			homePage.verifyShippingPolicyInFooter();
			homePage.verifyMyAccountInFooter();
			homePage.verifyOrderStatusInFooter();
			homePage.verifyQuickOrderpadInFooter();
			homePage.verifyMyCartInFooter();
			homePage.verifyTradePartnersInFooter();
			homePage.verifyLearningCenterInFooter();
			homePage.verifyManufacturersInFooter();
			homePage.verifyBlogInFooter();
			homePage.verifySecurityAndPrivacyInFooter();
			homePage.verifyTermsOfUseInFooter();
			homePage.verifyAboutUsInFooter();
			homePage.verifyEventsInFooter();
			homePage.verifyBranchLocationInFooter();
			homePage.verifyCareersInFooter();
			homePage.verifySiteMapInFooter();
			homePage.verifyTaxonomies();
  } 
  
  
  @Test(groups={"smoke","regression"})
  public void tc009_compareFunctionality() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			homePage.searchText(searchText);
			homePage.clickOnSearch();
			productsListPage.clickFirstTwoCompareCheckboxes();
			productsListPage.clickOnCompare();
			Assert.assertTrue(productsListPage.verifyCompareHeader(), "compare header is not displayed");;
			Assert.assertTrue(productsListPage.verifyDisplayOfCompareTable(), "compare table is not displayed");
}
  
  @Test(groups={"smoke","regression"})
  public void tc010_HGH_saveCart() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		String saveCartName = data.getSaveCartName();
	  		HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			HGHMyAccountsPageObjects myAccountsPage = new HGHMyAccountsPageObjects(driver);
			HGHShoppingCartPageObjects shoppingCartPage = new HGHShoppingCartPageObjects(driver);
			 HGHProductsDetailsPageObjects productsDetailsPage = new HGHProductsDetailsPageObjects(driver);
			tc002_HGH_login();
			shoppingCartPage.clearCart();
			homePage.searchText(searchText);
			homePage.clickOnSearch();
			productsListPage.clickOnFirstProduct();
			productsDetailsPage.clickOnAddToCart();
			productsDetailsPage.clickOnCheckout();
			shoppingCartPage.clickOnSaveCart();
			shoppingCartPage.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName);
			TestUtility.hitEnter();
			homePage.clickOnMyAccounts();
			myAccountsPage.clickOnMySavedCartLinkInMyAccountsPage();
			myAccountsPage.clickOnTheCreatedSaveCart(saveCartName);
			Assert.assertTrue(myAccountsPage.verifySaveCartHeading(saveCartName),"cart heading is not displayed with the relevant save cart name");
			myAccountsPage.deleteSaveCart();
			TestUtility.alertAccept();
			homePage.clickOnMyAccounts();
			myAccountsPage.clickOnMySavedCartLinkInMyAccountsPage();
			Assert.assertTrue(myAccountsPage.verifyMySavedCartNotAvialable(),"no saved cart available is not displayed");
			shoppingCartPage.clearCart();
			
}
  
  @Test(groups={"smoke","regression"})
  public void tc011_HGH_AccountsDashboard() throws Exception
  {
	  		HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHMyAccountsPageObjects myAccountsPage = new HGHMyAccountsPageObjects(driver);
			tc002_HGH_login();
			homePage.clickOnMyAccounts();
			myAccountsPage.verifyProductCategoriesSection();
			Assert.assertTrue(myAccountsPage.verifyMyAccountSection(),"my account section is not working properly");
}
  
  @Test(groups={"smoke","regression"})
  public void tc012_HGH_shoppingCartPage() throws Exception
  {
	 String searchText = data.getSearchText();
	 String quantity = data.getQuantityForShoppingCartPageVerification();
	 HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
	 HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
	 HGHProductsDetailsPageObjects productsDetailsPage = new HGHProductsDetailsPageObjects(driver);
	 HGHShoppingCartPageObjects shoppingCartPage = new HGHShoppingCartPageObjects(driver);
	 tc002_HGH_login();
	 shoppingCartPage.clearCart();
	 homePage.searchText(searchText);
	 homePage.clickOnSearch();
	 productsListPage.clickOnFirstProduct();
	 productsDetailsPage.addDifferentQuantity(quantity);
	 productsDetailsPage.clickOnAddToCart();
	 productsDetailsPage.clickOnCheckout();
	 shoppingCartPage.checkWhetherItIsTheSameQuantity(quantity);
	 Assert.assertTrue(shoppingCartPage.verifyShoppingCartBreadCrump(),"quantity is not the same as it was in the product list page") ;
	 Assert.assertTrue(shoppingCartPage.verifyShoppingCartPageHeading(),"shopping cart page heading is not displayed");
	 shoppingCartPage.verifyButtonsOnTopOfTheCart();
	 shoppingCartPage.verifyButtonsOnBottomOfTheCart();
}
  
  @Test(groups={"smoke","regression"})
  public void tc013_HGH_cartFileUpload() throws Exception
  {
	 HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
	 HGHShoppingCartPageObjects shoppingCartPage = new HGHShoppingCartPageObjects(driver);
	 HGHMyAccountsPageObjects myAccountsPage = new HGHMyAccountsPageObjects(driver);
	 tc002_HGH_login();
	 shoppingCartPage.clearCart();
	 homePage.clickOnMyAccounts();
	 myAccountsPage.clickOnCartFileUpload();
	 myAccountsPage.verifyBreadCrumpAndHeadingOfCartFileUpload();
	 myAccountsPage.fileUpload(data.getFileUploadPath());
	 myAccountsPage.clickOnUpload();
	 myAccountsPage.verifyQuickCartPage();
  }
  
  @Test(groups={"smoke","regression"})
  public void tc014_HGH_quickOrderPad() throws Exception
  {
	 HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
	 HGHShoppingCartPageObjects shoppingCartPage = new HGHShoppingCartPageObjects(driver);
	 HGHMyAccountsPageObjects myAccountsPage = new HGHMyAccountsPageObjects(driver);
	 tc002_HGH_login();
	 shoppingCartPage.clearCart();
	 homePage.clickOnQuickOrderPadLink();
	 myAccountsPage.verifyQuickCartBreadCrump();
	 myAccountsPage.verifyQuickCartPage();
	 myAccountsPage.selectPartNumberFromDropdown();
	// myAccountsPage.enterPartNumberValues();
	 
  }
  
  @Test(groups={"smoke","regression"})
  public void tc015_HGH_requestForQuote() throws Exception
  {
	 HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
	 HGHShoppingCartPageObjects shoppingCartPage = new HGHShoppingCartPageObjects(driver);
	 HGHMyAccountsPageObjects myAccountsPage = new HGHMyAccountsPageObjects(driver);
	 tc002_HGH_login();
	 shoppingCartPage.clearCart();
	 homePage.clickOnMyAccounts();
	 myAccountsPage.clickOnRequestForQuote();
	 myAccountsPage.verifyRequestForQuoteHeadingAndBreadcrump();
	 myAccountsPage.enterPhoneNumberForRequestQuote();
	 myAccountsPage.enterRequestDetails();
	 myAccountsPage.clickSubmit();
	 myAccountsPage.clickOnOkForAfterCompletionOfRequestForQuote();
  }
  
  
  
  /*@Test
  public void dayanandTest() throws Exception{
	  HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
	  homePage.findNow();
  }*/
}
