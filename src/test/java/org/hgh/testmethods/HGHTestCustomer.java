package org.hgh.testmethods;
import java.awt.AWTException;

import org.hgh.customer.pageobjects.HGHHomePageObjects;
import org.hgh.customer.pageobjects.HGHLoginPageObjects;
import org.hgh.customer.pageobjects.HGHProductsDetailsPageObjects;
import org.hgh.customer.pageobjects.HGHProductsListPageObjects;
import org.hgh.customer.pageobjects.HGHRegistrationPageObjects;
import org.hgh.dataprovider.SearchData;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.TestUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HGHTestCustomer extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */

 
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
  
	@Test(groups={"smoke","regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
	public void tc002_HGH_loginAndLogout(String userName,String password) throws AWTException
	{
		HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
		HGHLoginPageObjects loginPage = new HGHLoginPageObjects(driver);
		homePage.clickLoginLink();
		loginPage.enterUsername(userName);
		loginPage.enterPassword(password);
		TestUtility.hitEnter();
		Assert.assertTrue(homePage.verifyWelcomeMsg(),"welcome is not displayed");
		homePage.logout();
		homePage.verifyDisplayOfLoginLink();
	}

  @Test(groups={"regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void tc003_HGH_LoginErrorScenarios(String userName, String password,String expectedMsg) throws Exception
  {
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHLoginPageObjects loginPage = new HGHLoginPageObjects(driver);
			homePage.clickLoginLink();
			loginPage.enterUsername(userName);
			loginPage.enterPassword(password);
			TestUtility.hitEnter();
			homePage.assertForErrorMessages(expectedMsg);
		}
 
  
  @Test(groups={"smoke","regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void tc004_HGH_generalSearch(String searchText) throws Exception
  {
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			HGHProductsDetailsPageObjects productDetailsPage = new HGHProductsDetailsPageObjects(driver);
			homePage.searchPartialText(searchText);
			homePage.clickOnSearch();
			Assert.assertTrue(productsListPage.verifyHeader(searchText),"products page search header is not displayed");
			productsListPage.clickOnFirstProduct();
			Assert.assertTrue(productDetailsPage.verifyHeadingOfProduct(searchText),"product brand name is not contain the search text");
		}
  
  @Test(groups={"smoke","regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void tc005_HGH_ListViewGridView(String searchText) throws Exception
  {
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			homePage.searchPartialText(searchText);
			homePage.clickOnSearch();
			Assert.assertTrue(productsListPage.verifyGridView(),"class name is not grid view");
			homePage.clickOnChangeView();
			Assert.assertTrue(productsListPage.verifyListView(),"class name is not list view");
  }
  
  
  @Test(groups={"smoke","regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void tc006_HGH_ProductListPage(String searchText) throws Exception
  {
			HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
			HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
			homePage.searchPartialText(searchText);
			homePage.clickOnSearch();
			Assert.assertTrue(productsListPage.verifyListOfProducts(), "products are not displayed");
			Assert.assertTrue(productsListPage.verifyAdvancedSearchSection(),"Advanced search section is not displayed");
			Assert.assertTrue(productsListPage.verifyRefineSearchHeader(),"refine results header is not displayed");
			Assert.assertTrue(productsListPage.verifyCategoryFilterSection(),"category Filter section is not displayed");
			Assert.assertTrue(productsListPage.verifyBrandsFilterSection(),"category Filter section is not displayed");
			Assert.assertTrue(productsListPage.verifySortBySection(),"Sort By section is not displayed");
			Assert.assertTrue(productsListPage.verifyNarrowSearchBox(),"narrow Search box is not displayed");
			
  }
}

