package org.etna.modules;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.PropertyFileReader;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class MyCartModuleTest extends MainController{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	@Test(alwaysRun=true,groups={"MyCartModule","smoke","regression"})
	public void TC_MyCart_001() throws Exception{
		String searchText = data.getSearchTextForUPCLabelTest();
		String myCartBreadcrump = data.getMyCartBreadcrump();
		loginModule.loginAsASuperUser();
		myCartPage().clearCart();
		String productName = homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnAddToCartButton()
		.getProductName();
		 myCartPage()
		.clickOnCheckoutInMyCartPopup()
		.verifyMyCartTitle(myCartBreadcrump)
		.verifyMyCartPagename(myCartBreadcrump)
		.verifyMyCartBreadcrump(myCartBreadcrump)
		.verifyCartPageInstructions()
		.verifyNameOfTheProductInMyCartPage(productName)
		.verifyButtonsAvailableForSuperUserInMyCart();
	}
	
	
	@Test(groups={"MyCartModule","smoke","regression"},enabled=true)
	  public void TC_ShoppingCart_011_CreateAndDeleteSaveCart() throws Exception
	  {
		  	String searchText = data.getSearchTextForUPCLabelTest();
			String saveCartName = data.getSaveCartName();
			String saveCartBreadcrump = data.getSaveCartBreadcrump();
			loginModule.loginAsASuperUser();
			myCartPage().clearCart();
			String productName = homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productDetailsPage()
			.clickOnAddToCartButton()
			.getProductName();
		 	myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.verifyNameOfTheProductInMyCartPage(productName)
			.myCartPage()
		 	.clickOnSaveCart()
			.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
			.hitEnterForSaveCartCreation();
			Thread.sleep(1000);
			myCartPage().verifySaveCartCreationMessage(saveCartName);
			 homePage()
			.clickOnUserAccountDropdown()
			.clickOnMySaveCart()
			.saveCartPage()
			.verifyBreadCrumps(saveCartBreadcrump)
			.verifyPageName(saveCartBreadcrump)
			.verifySaveCartTitle()
			.clickOnTheCreatedSaveCart(saveCartName)	
			.verifyBreadCrumps(saveCartName)
			.verifyPageName(saveCartName)
			.verifyTitleAfterClickingOnTheCartCreated()
			.deleteSaveCart();
			TestUtility.alertAccept();
			saveCartPage()
			.verifyDeletionOfSaveCart(saveCartName);
			}
	  
	  
	@Test(groups={"MyCartModule","regression"},enabled=true)
	  public void TC_ShoppingCart_012_saveCart_ClickOnCofirmationPopup() throws Exception
	  {
		  		String searchText = data.getSearchText();
		  		String saveCartName = data.getSaveCartName();
		  		loginModule.loginAsASuperUser();
				myCartPage().clearCart();
				Thread.sleep(1500);
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificItem(1)
				.productDetailsPage()
				.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup()
				.clickOnSaveCart()
				.enterNameOfSaveCartAndAddTheProductToSaveCart(saveCartName)
				.hitEnterForSaveCartCreation();
				Thread.sleep(1000);
				myCartPage()
				.verifySaveCartCreationMessage(saveCartName)
				.clickOnTheConfirmationMessage(saveCartName)
				.saveCartPage()
				.verifyPageName(saveCartName)
				.verifyBreadCrumps(saveCartName)
				.verifyTitleAfterClickingOnTheCartCreated()
				.deleteSaveCart();
				TestUtility.alertAccept();
				saveCartPage()
				.verifyDeletionOfSaveCart(saveCartName);
	  }
	  
//	  @Test(groups={"regression"})
//	  public void TS_ShoppingCart_001_TC_ShoppingCart_013_HGH_shipViaMethodModication() throws Exception
//	  {
//		  	
//		 throw new SkipException("this feature is not present in the application");
//	  }
//	  
	  
	@Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_014_signedUser_ShoppingCartUpdateToolTip() throws Exception
	  {
		  	String searchText = data.getSearchText();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productListPage()
			 .clickOnSpecificItem(1)
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup()
			 .myCartPage()
			 .hoverOverUpdateLink()
			 .verifyRefreshToolTip();
	  }
	  
	@Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_015_updateLinkFunctionality() throws Exception
	  {
		  		String searchText = data.getSearchText();
		  		String quantity = data.getQuantityForShoppingCartPageVerification();
		  		loginModule.loginAsASuperUser();
		  		myCartPage()
				 .clearCart();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificItem(1)
				.productDetailsPage()
				.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup();
				 Number currentExtnPrice = myCartPage().getExtensionPrice();
				 Number currentTotalPrice = myCartPage().getTotalPrice();
				 myCartPage()
				 .enterQuantityInShoppingCart(quantity)
				 .clickOnUpdateLink()
				 .verifyUpdateOfQuantityInShoppingCart(quantity)
				 .verifyExtPrice(quantity,currentExtnPrice)
				 .verifyTotalPrice(quantity,currentTotalPrice);
	  }
  
	@Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_016_emptyCartFunctionality() throws Exception
	  {
		  		String searchText = data.getSearchText();
		  		loginModule.loginAsASuperUser();
				myCartPage()
				.clearCart();
				Thread.sleep(1500);
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificItem(1)
				.productDetailsPage()
				.clickOnAddToCartButton()
				.myCartPage()
				.clickOnCheckoutInMyCartPopup();
				myCartPage()
				.clickOnEmptyCartButton();
				TestUtility.alertAccept();
				myCartPage()
				.verifyEmptyCart();
	  }
	  
	  
//	  @Test(groups={"regression"})
//	  public void TS_ShoppingCart_001_TC_ShoppingCart_017_HGH_collapseViewAndExpandView() throws Exception
//	  {
//		  throw new SkipException("this feature is not present in the application");
//	  }
	  
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"},enabled=false)
	  public void TC_ShoppingCart_018_sortByDropdownListValues() throws Exception
	  {
		  String searchText = data.getSearchText();
		  loginModule.loginAsASuperUser();
		  myCartPage()
		  .clearCart();
		  Thread.sleep(1500);
		  homePage()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .clickOnSpecificItem(1)
		  .productDetailsPage()
		  .clickOnAddToCartButton()
		  .myCartPage()
		  .clickOnCheckoutInMyCartPopup()
		  .verifySortByDropdownValues();
	  }
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","smoke","regression"})
	  public void TC_ShoppingCart_002_TC_ShoppingCart_019_TC_ShoppingCart_020_TC_ShoppingCart_021_signedUserAddingItemToCart() throws Exception
	  {
		  String searchText = data.getSearchText();
		  String quantity = data.getQuantityForShoppingCartPageVerification();
		  loginModule.loginAsASuperUser();
		  myCartPage()
		 .clearCart();
		  Thread.sleep(1500);
		  homePage()
		 .searchText(searchText)
		 .clickOnSearch()
		 .productListPage()
		 .clickOnSpecificItem(1)
		 .productDetailsPage()
		 .enterQuanityInProductDetailsPage(quantity)
		 .clickOnAddToCartButton()
		 .myCartPage()
		 .clickOnCheckoutInMyCartPopup()
		 .checkWhetherItIsTheSameQuantity(quantity);
	}
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TS_ShoppingCart_001_TC_ShoppingCart_001_guestUserAddingItemToCart() throws Exception
	  {
		  String searchText = data.getSearchText();
		  String quantity = data.getQuantityForShoppingCartPageVerification();
		  	myCartPage()
			.clearCart();
		  Thread.sleep(1500);
			 homePage()
			 .searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnSpecificItem(1)
			.productDetailsPage()
			.enterQuanityInProductDetailsPage(quantity)
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup()
			 .checkWhetherItIsTheSameQuantity(quantity);
	  }
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_003_signedUser_ShoppingCartQuanitityUpdateCartButton() throws Exception
	  {

	  		String searchText = data.getSearchText();
	  		String quantity = data.getQuantityForShoppingCartPageVerification();
	  		loginModule.loginAsASuperUser();
	  		myCartPage()
			 .clearCart();
			homePage()
			.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnSpecificItem(1)
			.productDetailsPage()
			.clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup();
			 Number currentExtnPrice = myCartPage().getExtensionPrice();
			 Number currentTotalPrice = myCartPage().getTotalPrice();
			 myCartPage()
			 .enterQuantityInShoppingCart(quantity)
			 .clickOnUpdateButton()
			 .verifyUpdateOfQuantityInShoppingCart(quantity)
			 .verifyExtPrice(quantity,currentExtnPrice)
			 .verifyTotalPrice(quantity,currentTotalPrice);
	  }
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"},enabled = false)
	  public void TC_ShoppingCart_004_signedUser_ShoppingCartQuanitityUpdateWithZero() throws Exception
	  {
		  	String searchText = data.getSearchText();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productListPage()
			 .clickOnSpecificItem(1)
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			.myCartPage()
			.clickOnCheckoutInMyCartPopup()
			 .enterQuantityInShoppingCart("0")
			 .clickOnUpdateButton()
			 .verifyEmptyCart();
	  }
	  
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_005_signedUser_ShoppingCartDeleteToolTip() throws Exception
	  {
		  	String searchText = data.getSearchText();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productListPage()
			.clickOnSpecificItem(1)
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup()
			 .myCartPage()
			 .hoverOverDeleteButton()
			 .verifyDeleteToolTip();
	  }
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_006_signedUser_DeleteLinkForDeletingTheItem() throws Exception
	  {
		  if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").equalsIgnoreCase("safari"))
		  {
			  throw new SkipException("Unfortunately safari browser does not handle alerts.");
			  
		  }
		  else
		  {
		  	String searchText = data.getSearchText();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	 Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productListPage()
			 .clickOnSpecificItem(1);
			 String productName = productDetailsPage().getProductName();
			 String MPN = productDetailsPage().getMPN();
			 productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup();
			 myCartPage()
			 .verifyNameOfTheProductInMyCartPage(productName)
			 .verifyMPN(MPN)
			 .clickOnDeleteLink()
			 .verifyDeleteAlertText(MPN);
			 TestUtility.alertAccept();
			 myCartPage()
			 .verifyEmptyCart();
	  }
	  }
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_007_signedUser_CancellingOfDeletingTheItemThroughDeleteLink() throws Exception
	  {
		  if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").equalsIgnoreCase("safari"))
		  {
			  throw new SkipException("Code does not work in IE.Problem with IE driver server in handling alerts.Need to do this manually");
			  
		  }
		  else
		  {
			String searchText = data.getSearchText();
			loginModule.loginAsASuperUser();
		  	 myCartPage()
		  	.clearCart();
		  	Thread.sleep(1500);
		  	homePage()
		  	.searchText(searchText)
			.clickOnSearch()
			.productListPage()
			.clickOnSpecificItem(1)
			.productDetailsPage();
			 String productName = productDetailsPage().getProductName();
			 String MPN = productDetailsPage().getMPN();
			 productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			.clickOnCheckoutInMyCartPopup()
			.verifyNameOfTheProductInMyCartPage(productName)
			.clickOnDeleteLink()
			 .verifyDeleteAlertText(MPN);
			 TestUtility.alertDismiss();
			 myCartPage()
			 .verifyEmptyCart();
		  }
	  }
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_008_signedUser_clickOnImageNavigateBackToPDP() throws Exception
	  {
		  	String searchText = data.getSearchText();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productListPage()
			 .clickOnSpecificItem(1)
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup();
		  	 String productNameFromShoppingCart = myCartPage().getProductNameInShoppingCart();
		  	 myCartPage()
			.clickOnImageIfTheProduct()
			.productDetailsPage()
			.verifyProductNameIsSameAsItWasInShoppingCart(productNameFromShoppingCart);
	  }
	  
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_010_signedUser_verifyContinueShoppingButton() throws Exception
	  {
		  	 String searchText = data.getSearchText();
		  	 String productsPageBreadCrump = data.getProductsPageBreadCrump();
		  	loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	 Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productListPage()
			 .clickOnSpecificItem(1)
			 .productDetailsPage() 
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup()
			 .clickOnContinueShopping()
			 .productsPage()
			 .verifyBreadcrump(productsPageBreadCrump)
			 .verifyPageTitle(productsPageBreadCrump);

	  }
	  
	  @Test(alwaysRun=true,groups={"MyCartModule","regression"})
	  public void TC_ShoppingCart_008_signedUser_clickOnProductName() throws Exception
	  {
		  String searchText = data.getSearchText();
		  loginModule.loginAsASuperUser();
		  	 myCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
		  	 homePage()
			 .searchText(searchText)
			 .clickOnSearch()
			 .productListPage()
			 .clickOnSpecificItem(1)
			 .productDetailsPage()
			 .clickOnAddToCartButton()
			 .myCartPage()
			 .clickOnCheckoutInMyCartPopup();
		  	 String productNameFromShoppingCart = myCartPage().getProductNameInShoppingCart();
		  	 myCartPage()
			.clickOnProductName()
			.productDetailsPage()
			.verifyProductNameIsSameAsItWasInShoppingCart(productNameFromShoppingCart);
	  }

	  
}
