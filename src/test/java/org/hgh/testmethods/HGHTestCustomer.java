package org.hgh.testmethods;
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
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
  @Test(groups={"regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void tc001_HGH_Registration_ErrorScenarios(String companyName,String accountNumber,String firstName,String lastName,String email,String password,String passwordConfirmation,String address1,String address2,String city,String country,String state,String zipPostalCode,String phoneNumber,String expectedErrorMsg) throws Exception
  {
			homePage()
			.clickLoginLink()
			.loginPage()
			.clickNewCustomerRegisterNow()
			.registrationPage()
			.clickIAmACurrentHGHHardwareCustomer()
			.clickContinue()
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
			.enterPhoneNumber(phoneNumber)
			.clickIAccept()
			.verifyErrorMsg(expectedErrorMsg);
  }
  
  @Test(groups={"smoke","regression"})
	public void TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH() throws Exception
	{
	   homePage()
	  .clickLoginLink()
	  .loginPage()
	  .verifyLoginPage()
	  .enterUsername()
	  .enterPassword()
	  .clickOnLoginButton()
	  .productCategoryPage()
	  .verifyWelcomeMsg();
	}

  @Test(groups={"regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
  public void TS_Login_001_TC_HGH_Login_004_005_006_007_ErrorScenarios(String userName, String password,String expectedMsg) throws Exception
  {
	  homePage()
	  .clickLoginLink()
	  .loginPage()
	  .enterUsernameRegression(userName)
	  .enterPasswordRegression(password)
	  .clickOnLoginButton()
	  .productCategoryPage()
	  .assertForErrorMessages(expectedMsg);	
  }
  
  
  @Test(groups={"regression"})
  public void TS_Login_001_TC_HGH_Login_008_Verify_Tab_focus() throws Exception
  {
	  
	  Assert.assertEquals(true, false,"feature not present in the application");
	 /* homePage()
	  .clickLoginLink()
	  .loginPage()
	 
	  .clickOnLoginButton()
	  .verifyTabFocus();*/
	}
  
  @Test(groups={"regression"})
  public void TS_Login_002_TC_HGH_Login_009_010_RememberPassword_UserNameAndPasswordRefill() throws Exception
  {
	  
	   homePage()
	  .clickLoginLink()
	  .loginPage()
	  .verifyLoginPage()
	  .enterUsername()
	  .enterPassword()
	  .clickOnRemeberMe()
	  .clickOnLoginButton()
	  .productCategoryPage()
	  .verifyWelcomeMsg()
	  .homePage()
	  .waitForLogoutLink()
	  .logout()
	  .clickLoginLink()
	  .loginPage()
	  .verifyAutofillOfUserNameAndPassword();
	}
  
  @Test(groups={"regression"})
  public void TS_Login_002_TC_HGH_Login_011_AutofillLogin() throws Exception
  {
	  homePage()
	  .clickLoginLink()
	  .loginPage()
	  .verifyLoginPage()
	  .enterUsername()
	  .enterPassword()
	  .clickOnRemeberMe()
	  .clickOnLoginButton()
	  .productCategoryPage()
	  .verifyWelcomeMsg()
	  .homePage()
	  .waitForLogoutLink()
	  .logout()
	  .clickLoginLink()
	  .loginPage()
	  .clickOnLoginButton()
	  .homePage()
	  .verifyWelcomeMsg();
	}
  
  @Test(groups={"regression"})
  public void TS_Login_002_TC_HGH_Login_012_uncheckRememberMeWhenInAutoFillForm() throws Exception
  {
	  homePage()
	  .clickLoginLink()
	  .loginPage()
	  .verifyLoginPage()
	  .enterUsername()
	  .enterPassword()
	  .clickOnRemeberMe()
	  .clickOnLoginButton()
	  .productCategoryPage()
	  .verifyWelcomeMsg()
	  .homePage()
	  .waitForLogoutLink()
	  .logout()
	  .clickLoginLink()
	  .loginPage()
	  .clickOnRemeberMe()
	  .clickOnLoginButton()
	  .homePage()
	  .verifyWelcomeMsg()
	  .waitForLogoutLink()
	  .logout()
	  .clickLoginLink()
	  .loginPage()
	  .verifyEmptyUserNameAndPasswordTextbox();
	}
  
  @Test(groups={"regression"})
  public void TS_Login_002_TC_HGH_Login_013_myProductGroupLoginPopupRememberMeClickUncheck() throws Exception
  {
	  String searchText = data.getSearchText();
	  homePage()
	  .clickLoginLink()
	  .loginPage()
	  .verifyLoginPage()
	  .enterUsername()
	  .enterPassword()
	  .clickOnRemeberMe()
	  .clickOnLoginButton()
	  .productCategoryPage()
	  .verifyWelcomeMsg()
	  .homePage()
	  .waitForLogoutLink()
	  .logout()
	  .searchText(searchText)
	  .clickOnSearch()
	  .productListPage()
	  .clickOnFirstMyProductGroup()
	  .loginPopUp()
	  .clickOnRememberMe()
	  .clickOnLoginButton()
	  .homePage()
	  .verifyWelcomeMsg()
	  .waitForLogoutLink()
	  .logout()
	  .clickLoginLink()
	  .loginPage()
	  .verifyEmptyUserNameAndPasswordTextbox();
	}
  
  @Test(groups={"regression"})
  public void TS_Login_002_TC_HGH_Login_015_rememberMeAsALink() throws Exception
  {
	  Assert.assertEquals(true,false,"remember me as a link");
	}
  
  @Test(groups={"regression"})
  public void TS_Login_002_TC_HGH_Login_016_017_18_0rememberMeCheckboxTest() throws Exception
  {
	  homePage()
	  .clickLoginLink()
	  .loginPage()
	  .clickOnRemeberMe()
	  .verifyRememberMeCheckBoxSelected()
	  .clickOnRemeberMe()
	  .verifyRememberMeCheckboxNotSelected();
}

  @Test(groups={"regression"})
  public void TS_Login_002_TC_HGH_Login_014_myProductGroupLoginPopupRememberMeClickCheck() throws Exception
  {  
	  String searchText = data.getSearchText();
	  homePage()
	  .searchText(searchText)
	  .clickOnSearch()
	  .productListPage()
	  .clickOnFirstMyProductGroup()
	  .loginPopUp()
	  .enterUserName()
	  .enterPassword()
	  .clickOnRememberMe()
	  .clickOnLoginButton()
	  .productCategoryPage()
	  .verifyWelcomeMsg()
	  .homePage()
	  .waitForLogoutLink()
	  .logout()
	  .clickLoginLink()
	  .loginPage()
	  .verifyAutofillOfUserNameAndPassword();
	}
  
  @Test(groups={"regression"})
  public void TS_Login_005_TC_HGH_Login_021_loginVerifyOrderTopToBottom() throws Exception
  {
	  Assert.assertEquals(true, false,"bug");
	  
	}
  
  @Test(groups={"regression"})
  public void TS_Login_005_TC_HGH_Login_022_loginVerifyOrderBottomToTop() throws Exception
  {
	  Assert.assertEquals(true, false,"bug");
  }
  
  @Test(groups={"regression"})
  public void TS_Login_004_TC_HGH_Login_020_verifyForgotPasswordPage() throws Exception
  {
	   homePage()
	  .clickLoginLink()
	  .loginPage()
	  .verifyLoginPage()
	  .clickOnForgotPassword()
	  .retrievePasswordPage()
	  .verifyRetrievePasswordPage();
	}
  
  @Test(groups={"regression"})
  public void TS_Login_003_TC_HGH_Login_019_verifyRegisterPage() throws Exception
  {
	   homePage()
	  .clickLoginLink()
	  .loginPage()
	  .verifyLoginPage()
	  .clickNewCustomerRegisterNow()
	  .registrationPage()
	  .verifyRegistrationPage();
	}
  
  

  
  @Test(groups={"smoke","regression"})
  public void tc004_HGH_generalSearch() throws Exception
  {
	  		String searchText = data.getSearchText();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.verifyHeader(searchText)
			.clickOnFirstProduct()
			.productDetailsPage()
			.verifyHeadingOfProduct(searchText);
		}
  
  
  @Test(groups={"smoke","regression"})
  public void tc005_HGH_ListViewGridView() throws Exception
  {
	  String searchText = data.getSearchText();
	  homePage()
	  .searchText(searchText)
	  .clickOnSearch()
	  .productListPage()
	  .verifyGridView()
	  .clickOnChangeView()
	  .verifyListView();
  }
  
  
  @Test(groups={"smoke","regression"})
  public void tc006_HGH_ProductListPage() throws Exception
  {
	  		String searchText = data.getSearchText();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.verifyListOfProducts()
			.verifyAdvancedSearchSection()
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
	  		TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnFirstMyProductGroup()
			.enterGroupName(groupName)
			.hitEnterForGroupCreation();
			homePage()
			.clickOnMyAccounts()
			.myAccountsPage()
			.clickOnMyProductGroupsInMyAccountsPage()
			.myProductsPageHeader()
			.clickOnTheGroupCreated(groupName)
			.verifyGroupName(groupName)
			.deleteGroup();
			TestUtility.alertAccept();
			homePage()
			.clickOnMyAccounts()
			.myAccountsPage()
			.clickOnMyProductGroupsInMyAccountsPage()
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
  public void TS_ShoppingCart_002_TC_ShoppingCart_011_HGH_saveCart() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		String saveCartName = data.getSaveCartName();
	  		TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
			shoppingCartPage().clearCart();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnFirstProduct()
			.productDetailsPage()
			.clickOnAddToCart()
			.clickOnCheckout()
			.shoppingCartPage()
			.clickOnSaveCart()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			shoppingCartPage().verifySaveCartCreationMessage(saveCartName);
			 homePage()
			.clickOnMyAccounts()
			.myAccountsPage()
			.clickOnMySavedCartLinkInMyAccountsPage()
			.clickOnMySavedCartLinkInMyAccountsPage()
			.clickOnTheCreatedSaveCart(saveCartName)
			.verifySaveCartHeading(saveCartName)
			.deleteSaveCart();
			TestUtility.alertAccept();
			homePage()
			.clickOnMyAccounts()
			.myAccountsPage()
			.clickOnMySavedCartLinkInMyAccountsPage()
			.verifyMySavedCartNotAvialable();
		}
  
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_002_TC_ShoppingCart_012_HGH_saveCart_ClickOnCofirmationPopup() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		String saveCartName = data.getSaveCartName();
	  		TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
			shoppingCartPage().clearCart();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnFirstProduct()
			.productDetailsPage()
			.clickOnAddToCart()
			.clickOnCheckout()
			.shoppingCartPage()
			.clickOnSaveCart()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			shoppingCartPage().verifySaveCartCreationMessage(saveCartName)
			.clickOnTheConfirmationMessage(saveCartName)
			.myAccountsPage()
			.verifySaveCartHeading(saveCartName)
			.deleteSaveCart();
			TestUtility.alertAccept();
  }
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_013_HGH_shipViaMethodModication() throws Exception
  {
	  	
	  Assert.assertEquals(true, false,"feature not present in the application");
  }
  
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_014_HGH_signedUser_ShoppingCartRefreshToolTip() throws Exception
  {
	  	String searchText = data.getSearchText();
	  	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout()
		 .shoppingCartPage()
		 .hoverOverRefreshButton()
		 .verifyRefreshToolTip();
  }

  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_015_HGH_refreshFunctionality() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		String quantity = data.getQuantityForShoppingCartPageVerification();
	  		TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
			shoppingCartPage().clearCart();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnFirstProduct()
			.productDetailsPage()
			.clickOnAddToCart()
			.clickOnCheckout();
			 Number price = shoppingCartPage().getPrice();
			 Number currentExtnPrice = shoppingCartPage().getExtensionPrice();
			 Number currentTotalPrice = shoppingCartPage().getTotalPrice();
			 shoppingCartPage()
			 .enterQuantityInShoppingCart(quantity)
			 .clickOnRefresh()
			 .verifyUpdateOfQuantityInShoppingCart(quantity)
			 .verifyExtPrice(quantity,currentExtnPrice)
			 .verifyTotalPrice(quantity,currentTotalPrice)
			 .verifyPrice(price);
  }
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_002_TC_ShoppingCart_016_HGH_emptyCartFunctionality() throws Exception
  {
	  		String searchText = data.getSearchText();
	  		TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
			shoppingCartPage().clearCart();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnFirstProduct()
			.productDetailsPage()
			.clickOnAddToCart()
			.clickOnCheckout();
			shoppingCartPage()
			.clickOnEmptyCartButton();
			TestUtility.alertAccept();
			shoppingCartPage().verifyEmptyCart();
  }
  
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_017_HGH_collapseViewAndExpandView() throws Exception
  {
	  		Assert.assertEquals(true, false,"this feature is not present in the application");
  }
  
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_018_HGH_sortByDropdownListValues() throws Exception
  {
	  String searchText = data.getSearchText();
	  TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  shoppingCartPage().clearCart();
	  homePage()
	  .searchText(searchText)
	  .clickOnSearch()
	  .productListPage()
	  .clickOnFirstProduct()
	  .productDetailsPage()
	  .clickOnAddToCart()
	  .clickOnCheckout()
	  .shoppingCartPage()
	  .verifySortByDropdownValues();
  }
  
  
  @Test(groups={"smoke","regression"})
  public void tc011_HGH_AccountsDashboard() throws Exception
  {
	  		
	  TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
			homePage()
			.clickOnMyAccounts()
			.myAccountsPage()
			.verifyProductCategoriesSection()
			.verifyMyAccountSection();
}
  
  @Test(groups={"smoke","regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_002_TC_ShoppingCart_019_TC_ShoppingCart_020_TC_ShoppingCart_021_HGH_signedUserAddingItemToCart() throws Exception
  {
	  String searchText = data.getSearchText();
	  String quantity = data.getQuantityForShoppingCartPageVerification();
	  TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  shoppingCartPage()
	 .clearCart();
	  homePage()
	 .searchText(searchText)
	 .clickOnSearch()
	 .productListPage()
	 .clickOnFirstProduct()
	 .productDetailsPage()
	 .addDifferentQuantity(quantity)
	 .clickOnAddToCart()
	 .clickOnCheckout()
	 .shoppingCartPage()
	 .checkWhetherItIsTheSameQuantity(quantity)
	 .shoppingCartPage()
	 .verifyShoppingCartBreadCrump()
	 .verifyShoppingCartPageHeading()
	 .verifyShoppingCartPageInstructions()
	 .verifyButtonsOnTopOfTheCart()
	 .verifyButtonsOnBottomOfTheCart();
}
  

@Test(groups={"smoke","regression"})
  public void tc013_HGH_cartFileUpload() throws Exception
  {

	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	 shoppingCartPage().clearCart();
	 homePage()
	 .clickOnMyAccounts()
	 .myAccountsPage()
	 .clickOnCartFileUpload()
	 .verifyBreadCrumpAndHeadingOfCartFileUpload()
	 .fileUpload(data.getFileUploadPath())
	 .clickOnUpload()
	 .verifyQuickCartPage();
  }
  
  @Test(groups={"smoke","regression"})
  public void tc014_HGH_quickOrderPad() throws Exception
  {
	  
	  TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	 shoppingCartPage().clearCart();
	 homePage()
	 .clickOnQuickOrderPadLink()
	 .myAccountsPage()
	 .verifyQuickOrderPadBreadCrump()
	 .verifyQuickCartPage()
	 .selectPartNumberFromDropdown();
	// myAccountsPage.enterPartNumberValues();
	 
  }
  
  @Test(groups={"smoke","regression"})
  public void tc015_HGH_requestForQuote() throws Exception
  {
	 
	  TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	 shoppingCartPage()
	 .clearCart();
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
  
  

  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_001_HGH_guestUserAddingItemToCart() throws Exception
  {
	  String searchText = data.getSearchText();
	  String quantity = data.getQuantityForShoppingCartPageVerification();
	  shoppingCartPage()
		 .clearCart();
		 homePage()
		 .searchText(searchText)
		.clickOnSearch()
		.productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage()
		 .addDifferentQuantity(quantity)
		 .clickOnAddToCart()
		 .clickOnCheckout()
		 .shoppingCartPage()
		 .checkWhetherItIsTheSameQuantity(quantity)
		 .shoppingCartPage()
		 .verifyShoppingCartBreadCrump()
		 .verifyShoppingCartPageHeading()
		 .verifyShoppingCartPageInstructions()
		.verifyButtonsOnTopOfTheCart()
		.verifyButtonsOnBottomOfTheCart();
  }
  
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_003_HGH_signedUser_ShoppingCartQuanitityUpdate() throws Exception
  {
	  	String searchText = data.getSearchText();
	  	String quantity = data.getQuantityForShoppingCartPageVerification();
	  	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout()
		 .shoppingCartPage()
		 .verifyShoppingCartBreadCrump()
		 .verifyShoppingCartPageHeading()
		 .verifyShoppingCartPageInstructions()
		 .verifyButtonsOnTopOfTheCart()
		 .verifyButtonsOnBottomOfTheCart()
		 .enterQuantityInShoppingCart(quantity);
		 Number price = shoppingCartPage().getPrice();
		 Number currentExtnPrice = shoppingCartPage().getExtensionPrice();
		 Number currentTotalPrice = shoppingCartPage().getTotalPrice();
		 shoppingCartPage().
		 clickOnUpdateCart()
		 .verifyUpdateOfQuantityInShoppingCart(quantity)
		 .verifyExtPrice(quantity,currentExtnPrice)
		 .verifyTotalPrice(quantity,currentTotalPrice)
		 .verifyPrice(price);
  }
  
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_004_HGH_signedUser_ShoppingCartQuanitityUpdateWithZero() throws Exception
  {
	  	String searchText = data.getSearchText();
	  	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout()
		 .shoppingCartPage()
		 .enterQuantityFieldWithZero()
		 .clickOnUpdateCart()
		 .verifyEmptyCart()
		 .verifyContinueShoppingButton();
  }
  
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_005_HGH_signedUser_ShoppingCartDeleteToolTip() throws Exception
  {
	  	String searchText = data.getSearchText();
	  	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout()
		 .shoppingCartPage()
		 .hoverOverDeleteButton()
		 .verifyDeleteToolTip();
  }
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_006_HGH_signedUser_DeleteLinkForDeletingTheItem() throws Exception
  {
	  	String searchText = data.getSearchText();
	  	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage();
		 String productTitle = productDetailsPage().productTitle();
		 String MPN = productDetailsPage().getMPN();
		 productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout();
		 String productTitleInShoppingCart = shoppingCartPage().getProductTitle();
		 shoppingCartPage()
		 .verifyProductTitle(productTitle,productTitleInShoppingCart)
		 .clickOnDeleteButton()
		 .verifyDeleteAlertText(MPN);
		 TestUtility.alertAccept();
		 shoppingCartPage().verifyDeleteItemThroughDeleteLink();
  }
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_007_HGH_signedUser_CancellingOfDeletingTheItemThroughDeleteLink() throws Exception
  {
	  	String searchText = data.getSearchText();
	  	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage();
		 String productTitle = productDetailsPage().productTitle();
		 String MPN = productDetailsPage().getMPN();
		 productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout();
		 String productTitleInShoppingCart = shoppingCartPage().getProductTitle();
		 shoppingCartPage()
		 .clickOnDeleteButton()
		 .verifyDeleteAlertText(MPN);
		 TestUtility.alertDismiss();
		 shoppingCartPage().verifyProductTitle(productTitle,productTitleInShoppingCart);
  }
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_008_HGH_signedUser_clickOnImageNavigateBackToPDP() throws Exception
  {
	  	String searchText = data.getSearchText();
	  	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout();
		String productTitle= shoppingCartPage().getProductTitle();
		shoppingCartPage()
		.clickOnImageOfTheProduct()
		.productDetailsPage()
		.verifyProductTitle(productTitle);
  }
  
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_001_TC_ShoppingCart_009_HGH_signedUser_clickOnProductDescNavigateBackToPDP() throws Exception
  {
	  	String searchText = data.getSearchText();
	  	TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout();
	  	 String productTitle= shoppingCartPage().getProductTitle();
	  	 shoppingCartPage()
	  	 .clickOnProductDescriptionMoreLink()
	  	 .productDetailsPage()
	  	 .verifyProductTitle(productTitle);
  }
  
  @Test(groups={"regression"})
  public void TS_ShoppingCart_002_TC_ShoppingCart_010_HGH_signedUser_verifyContinueShoppingButton() throws Exception
  {
	  	 String searchText = data.getSearchText();
	  	 TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  	 shoppingCartPage()
		 .clearCart();
	  	 homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnFirstProduct()
		 .productDetailsPage()
		 .clickOnAddToCart()
		 .clickOnCheckout()
		 .shoppingCartPage()
		 .clickContinueShopping()
		 .productCategoryPage()
		 .verifyWelcomeMsg();
  }
  
  /*@Test
  public void dayanandTest() throws Exception{
	  HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
	  homePage.findNow();
  }*/
}
