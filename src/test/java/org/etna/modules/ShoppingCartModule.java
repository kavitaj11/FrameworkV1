package org.etna.modules;

import org.etna.maincontroller.MainController;
import org.etna.utils.PropertyFileReader;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ShoppingCartModule extends MainController
{

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	LoginModule loginModule = new LoginModule();
	
	/*@Test(groups={"smoke","regression"})
	  public void TS_ShoppingCart_002_TC_ShoppingCart_011_HGH_saveCart() throws Exception
	  {
		  		String searchText = data.getSearchText();
		  		String saveCartName = data.getSaveCartName();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
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
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
				shoppingCartPage().clearCart();
				Thread.sleep(1500);
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
		  	
		 throw new SkipException("this feature is not present in the application");
	  }
	  
	  
	  @Test(groups={"regression"})
	  public void TS_ShoppingCart_001_TC_ShoppingCart_014_HGH_signedUser_ShoppingCartRefreshToolTip() throws Exception
	  {
		  	String searchText = data.getSearchText();
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	 shoppingCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
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
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
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
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
				shoppingCartPage().clearCart();
				Thread.sleep(1500);
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
		  throw new SkipException("this feature is not present in the application");
	  }
	  
	  
	  @Test(groups={"regression"})
	  public void TS_ShoppingCart_001_TC_ShoppingCart_018_HGH_sortByDropdownListValues() throws Exception
	  {
		  String searchText = data.getSearchText();
		  loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  shoppingCartPage().clearCart();
		  Thread.sleep(1500);
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
	  public void TS_ShoppingCart_001_TC_ShoppingCart_002_TC_ShoppingCart_019_TC_ShoppingCart_020_TC_ShoppingCart_021_HGH_signedUserAddingItemToCart() throws Exception
	  {
		  String searchText = data.getSearchText();
		  String quantity = data.getQuantityForShoppingCartPageVerification();
		  loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  shoppingCartPage()
		 .clearCart();
		  Thread.sleep(1500);
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
	  public void TS_ShoppingCart_001_TC_ShoppingCart_001_HGH_guestUserAddingItemToCart() throws Exception
	  {
		  String searchText = data.getSearchText();
		  String quantity = data.getQuantityForShoppingCartPageVerification();
		  shoppingCartPage()
			 .clearCart();
		  Thread.sleep(1500);
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
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	 shoppingCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
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
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	 shoppingCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
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
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	 shoppingCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
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
		  if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").equalsIgnoreCase("ie"))
		  {
			  throw new SkipException("Code does not work in IE.Problem with IE driver server in handling alerts. Does not work in IE. Need to do this manually");
			  
		  }
		  else
		  {
		  	String searchText = data.getSearchText();
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	 shoppingCartPage()
			 .clearCart();
		  	 Thread.sleep(1500);
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
			 shoppingCartPage()
			 .verifyDeleteItemThroughDeleteLink();
	  }
	  }
	  
	  @Test(groups={"regression"})
	  public void TS_ShoppingCart_001_TC_ShoppingCart_007_HGH_signedUser_CancellingOfDeletingTheItemThroughDeleteLink() throws Exception
	  {
		  if(PropertyFileReader.propertiesReader(applicationSetUp, "browser").equalsIgnoreCase("ie"))
		  {
			  throw new SkipException("Code does not work in IE.Problem with IE driver server in handling alerts.Need to do this manually");
			  
		  }
		  else
		  {
			String searchText = data.getSearchText();
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	shoppingCartPage()
		  	.clearCart();
		  	Thread.sleep(1500);
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
	  }
	  
	  @Test(groups={"regression"})
	  public void TS_ShoppingCart_001_TC_ShoppingCart_008_HGH_signedUser_clickOnImageNavigateBackToPDP() throws Exception
	  {
		  	String searchText = data.getSearchText();
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	 shoppingCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
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
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	 shoppingCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
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
		  	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  	 shoppingCartPage()
			 .clearCart();
		  	Thread.sleep(1500);
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
*/}
