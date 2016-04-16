package org.etna.modules;

import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ProductsCompareModule extends MainController {

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModule loginModule = new LoginModule();
	
	/*
	@Test(groups={"regression"})
	  public void TS_CMP_01_TC_CMP_01_unsignedMoreThan4ItemsToCompare() throws Exception
	  {
			    data.setNumberOfCheckboxesToBeClicked(4);
			    int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		String expectedAlertMessageForComaringMoreThan3Items = data.expectedAlertMessageForComaringMoreThan3Items();
		  		if(setUp.getBrowser().equalsIgnoreCase("ie"))
		  		{
		  			throw new SkipException("IESeriverDriver is not able to handle some Alerts. Need to test this manually in IE");
		  		}
		  		else
		  		{
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.verifyAlertMessageForComparingMoreThan3Items(expectedAlertMessageForComaringMoreThan3Items);
	}
}
	
	@Test(groups={"regression"})
	  public void TS_CMP_01_TC_CMP_01_signedMoreThan4ItemsToCompare() throws Exception
	  {
		   data.setNumberOfCheckboxesToBeClicked(4);
		    int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
	  		String searchText = data.getSearchText();
	  		String expectedAlertMessageForComaringMoreThan3Items = data.expectedAlertMessageForComaringMoreThan3Items();
	  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
	  		if(setUp.getBrowser().equalsIgnoreCase("ie"))
	  		{
	  			throw new SkipException("IESeriverDriver is not able to handle some Alerts. Need to test this manually in IE");
	  		}
	  		else
	  		{
	  		homePage()
	  		.searchText(searchText)
	  		.clickOnSearch()
	  		.productListPage()
	  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
	  		.verifyAlertMessageForComparingMoreThan3Items(expectedAlertMessageForComaringMoreThan3Items);
	}
}
	
	@Test(groups={"smoke","regression"})
	  public void TS_CMP_02_TC_CMP_02_TS_CMP_04_TC_CMP_16_TC_CMP_30_TC_CMP_31_TC_CMP_32_unsignedUserComparePageDisplayVerification() throws Exception
	  {
		shoppingCartPage().clearCart();
		Thread.sleep(1500);
		String searchText = data.getSearchText();
  		homePage()
  		.searchText(searchText)
  		.clickOnSearch()
  		.productListPage()
		.clickOnSpecificProduct(1);
		String productTitle1 = productDetailsPage().productTitle();
		driver.navigate().back();
		productListPage()
		.clickOnASpecificCompareChecbox(1)
		.clickOnSpecificProduct(2);
		String productTitle2 = productDetailsPage().productTitle();
		driver.navigate().back();
		productListPage()
		.clickOnASpecificCompareChecbox(2)
		.clickOnSpecificProduct(3);
		String productTitle3 = productDetailsPage().productTitle();
		driver.navigate().back();
		productListPage()
		.clickOnASpecificCompareChecbox(3)
		.clickOnCompare()
		.comparePage()
		.verifyCompareHeaderAndBreampCrumpAndTitle()
		.verifyWhetherAllTheProductsAreDisplayed(productTitle1,productTitle2,productTitle3);
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_02_TS_CMP_04_TC_CMP_16_TC_CMP_30_TC_CMP_31_TC_CMP_32_signedUserComparePageDisplayVerification() throws Exception
	  {
		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		Thread.sleep(1500);
		shoppingCartPage().clearCart();
		String searchText = data.getSearchText();
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productListPage()
		.clickOnSpecificProduct(1);
		String productTitle1 = productDetailsPage().productTitle();
		driver.navigate().back();
		productListPage()
		.clickOnASpecificCompareChecbox(1)
		.clickOnSpecificProduct(2);
		String productTitle2 = productDetailsPage().productTitle();
		driver.navigate().back();
		productListPage()
		.clickOnASpecificCompareChecbox(2)
		.clickOnSpecificProduct(3);
		String productTitle3 = productDetailsPage().productTitle();
		driver.navigate().back();
		productListPage()
		.clickOnASpecificCompareChecbox(3)
		.clickOnCompare()
		.comparePage()
		.verifyCompareHeaderAndBreampCrumpAndTitle()
		.verifyWhetherAllTheProductsAreDisplayed(productTitle1,productTitle2,productTitle3);
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_02_TS_CMP_04_TC_CMP_30_TC_CMP_31_TC_CMP_32_signedUserComparePageDisplayVerification() throws Exception
	  {
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.verifyCompareHeaderAndBreampCrumpAndTitle()
		  		.verifyDisplayOfCompareTable();
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_03_signedUserCompareFunctionalityShowSimilar() throws Exception
	  {
				
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnShowSimilar()
		  		.verifyColourOfShowSimilarButtonAfterClicking()
		  		.verifyActivationOfSimilarProperties();
		  		//throw new SkipException("Functionality cannot be verified completely. Verified till whether for the rows changes to yellow after clicking 'show similar'. Need to check whether the coloured items are similar.");
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_03_unsignedUserCompareFunctionalityShowSimilar() throws Exception
	  {
				
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnShowSimilar()
		  		.verifyColourOfShowSimilarButtonAfterClicking()
		  		.verifyActivationOfSimilarProperties();
		  		//throw new SkipException("Functionality cannot be verified completely. Verified till whether the rows changes to yellow after clicking 'show similar'. Need to check whether the coloured items are similar.");
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_04_signedUserCompareFunctionalityShowDifferent() throws Exception
	  {
				
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnShowDifferent()
		  		.verifyColourOfShowDifferentButtonAfterClicking()
		  		.verifyActivationOfDifferentProperties();
		  		//throw new SkipException("Functionality cannot be verified completely. Verified till whether the rows changes to a pinkish colour after clicking 'show different'. Need to check whether the coloured items are actually different manually.");
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_04_unsignedUserCompareFunctionalityShowDifferent() throws Exception
	  {
				
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnShowDifferent()
		  		.verifyColourOfShowDifferentButtonAfterClicking()
		  		.verifyActivationOfDifferentProperties();
		  		//throw new SkipException("Functionality cannot be verified completely. Verified till whether the rows changes to a pinkish colour after clicking 'show different'. Need to check whether the coloured items are actually different manually.");
	}
	
	//@Test(groups={"regression"},expectedExceptions={NoSuchElementException.class},expectedExceptionsMessageRegExp = ".*no such element.*")
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_05_signedUserCompareFunctionalityShowSimilarOFF() throws Exception
	  {
				
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnShowSimilar()
		  		.verifyColourOfShowSimilarButtonAfterClicking()
		  		.verifyActivationOfSimilarProperties()
		  		.clickOnOffButton()
		  		.verifyColourOfShowSimilarButton()
		  		.verifyActivationOfSimilarPropertiesIsPresent();
		  		//throw new SkipException("Functionality cannot be verified completely. Verified till whether the rows changes to a pinkish colour after clicking 'show different'. Need to check whether the coloured items are actually different manually.");
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_05_signedUserCompareFunctionalityShowDifferentOFF() throws Exception
	  {
				
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnShowSimilar()
		  		.verifyColourOfShowDifferentButtonAfterClicking()
		  		.verifyActivationOfDifferentProperties()
		  		.clickOnOffButton()
		  		.verifyColourOfShowDifferentButton()
		  		.verifyActivationOfDifferentPropertiesIsPresent();
		  		//throw new SkipException("Functionality cannot be verified completely. Verified till whether the rows changes to a pinkish colour after clicking 'show different'. Need to check whether the coloured items are actually different manually.");
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_05_unsignedUserCompareFunctionalityShowSimilarOFF() throws Exception
	  {
				
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnShowSimilar()
		  		.verifyColourOfShowSimilarButtonAfterClicking()
		  		.verifyActivationOfSimilarProperties()
		  		.clickOnOffButton()
		  		.verifyColourOfShowSimilarButton()
		  		.verifyActivationOfSimilarPropertiesIsPresent();
		  		//throw new SkipException("Functionality cannot be verified completely. Verified till whether the rows changes to a pinkish colour after clicking 'show different'. Need to check whether the coloured items are actually different manually.");
	}
	

	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_05_unsignedUserCompareFunctionalityShowDifferentOFF() throws Exception
	  {
				
		 		data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnShowSimilar()
		  		.verifyColourOfShowDifferentButtonAfterClicking()
		  		.verifyActivationOfDifferentProperties()
		  		.clickOnOffButton()
		  		.verifyColourOfShowDifferentButton()
		  		.verifyActivationOfDifferentPropertiesIsPresent();
		  		//throw new SkipException("Functionality cannot be verified completely. Verified till whether the rows changes to a pinkish colour after clicking 'show different'. Need to check whether the coloured items are actually different manually.");
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_06_buyNowButton() throws Exception
	  {
			
				throw new SkipException("feature not there in the application.");
			
	}
	
	@Test(groups={"regression"})
	  public void TS_CMP_02_TC_CMP_07_buyNowRegisteredUserLogin() throws Exception
	  {
			
				throw new SkipException("feature not there in the application.");
			
	}
	
	
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_08_signedAddToCartFromCompare() throws Exception
		{
			if(setUp.getBrowser().equalsIgnoreCase("ie"))
			{
				throw new SkipException("need to test this manually in IE.");
			}
			else
			{
				data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompare();
		  		String nameOfTheProduct = comparePage().getFirstProductName();
		  		comparePage()
		  		.clickOnFirstAddToCart()
		  		.productDetailsPage()
		  		.clickOnCheckout()
		  		.shoppingCartPage()
		  		.verifyShoppingCartBreadCrump()
		  		.verifyShoppingCartPageHeading()
		  		.verifyShoppingCartPageInstructions();
		  		String titleOfTheProductInShppingCart = shoppingCartPage().getProductTitle();
		  		shoppingCartPage().verifyProductTitle(nameOfTheProduct, titleOfTheProductInShppingCart);
			}
	}
		
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_09_signedAddToCartProductWhenListPriceIsCallForPrice() throws Exception
		{
				data.setNumberOfCheckboxesToBeClicked(2);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		 		data.setNumberOfCheckboxesToBeClicked(1);
		 		int numberOfCheckboxesToBeClickedForListPrice = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.clickOnCompareWhoseProductsPriceIsCallForPrice(numberOfCheckboxesToBeClickedForListPrice)
		  		.productListPage()
		  		.clickOnCompare()
		  		.comparePage()
		  		.checkDisableOfAddToCartButton();
			}
		
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_09_unsignedAddToCartProductWhenListPriceIsCallForPrice() throws Exception
		{
				data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		//loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickOnCompareWhoseProductsPriceIsCallForPrice(numberOfCheckBoxesToBeClicked)
		  		.productListPage()
		  		.clickOnCompare()
		  		.comparePage()
		  		.checkDisableOfAddToCartButton();
			}
		
		
		
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_10_signedContinueShoppingDropdownCartCompare() throws Exception
		{
			if(setUp.getBrowser().equalsIgnoreCase("ie"))
			{
				throw new SkipException("need to test this manually in IE.");
			}
			else
			{
				data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.productListPage()
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnFirstAddToCart()
		  		.dropdownShoppingCart()
		  		.clickOnContinueShoppingButton()
		  		.comparePage()
		  		.verifyCompareHeaderAndBreampCrumpAndTitle()
		  		.verifyDisplayOfCompareTable();
		}
		}
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_10_unsignedContinueShoppingDropdownCartCompare() throws Exception
		{
			if(setUp.getBrowser().equalsIgnoreCase("ie"))
			{
				throw new SkipException("need to test this manually in IE.");
			}
			else
			{
				data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.productListPage()
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnFirstAddToCart()
		  		.dropdownShoppingCart()
		  		.clickOnContinueShoppingButton()
		  		.comparePage()
		  		.verifyCompareHeaderAndBreampCrumpAndTitle()
		  		.verifyDisplayOfCompareTable();
		}
		}
		
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_11_signedCheckoutDropdownCartCompare() throws Exception
		{
			if(setUp.getBrowser().equalsIgnoreCase("ie"))
			{
				throw new SkipException("need to test this manually in IE.");
			}
			else
			{
				data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.productListPage()
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnFirstAddToCart()
		  		.dropdownShoppingCart()
		  		.clickOnCheckout()
		  		.shoppingCartPage()
		  		.verifyShoppingCartBreadCrump()
		  		.verifyShoppingCartPageHeading()
		  		.verifyShoppingCartPageInstructions()
		  		.verifyButtonsOnTopOfTheCart()
		  		.verifyButtonsOnTopOfTheCart();
		}
		}
		
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_11_unsignedCheckoutDropdownCartCompare() throws Exception
		{
			
			if(setUp.getBrowser().equalsIgnoreCase("ie"))
			{
				throw new SkipException("need to test this manually in IE.");
			}
			else
			{
				data.setNumberOfCheckboxesToBeClicked(3);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		shoppingCartPage().clearCart();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.productListPage()
		  		.clickOnCompare()
		  		.comparePage()
		  		.clickOnFirstAddToCart()
		  		.dropdownShoppingCart()
		  		.clickOnCheckout()
		  		.shoppingCartPage()
		  		.verifyShoppingCartBreadCrump()
		  		.verifyShoppingCartPageHeading()
		  		.verifyShoppingCartPageInstructions()
		  		.verifyButtonsOnTopOfTheCart()
		  		.verifyButtonsOnTopOfTheCart();
		  	}
		}
		
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_12_signedCompareCount() throws Exception
		{
				data.setNumberOfCheckboxesToBeClicked(1);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.checkCompareCount(0)
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.checkCompareCount(1)
		  		.clickOnASpecificCompareChecbox(2)
		  		.checkCompareCount(2)
		  		.clickOnASpecificCompareChecbox(2)
		  		.checkCompareCount(1)
		  		.clickOnASpecificCompareChecbox(1)
		  		.checkCompareCount(0);
		 }
		
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_12_unsignedCompareCount() throws Exception
		{
				data.setNumberOfCheckboxesToBeClicked(1);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.checkCompareCount(0)
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.checkCompareCount(1)
		  		.clickOnASpecificCompareChecbox(2)
		  		.checkCompareCount(2)
		  		.clickOnASpecificCompareChecbox(2)
		  		.checkCompareCount(1)
		  		.clickOnASpecificCompareChecbox(1)
		  		.checkCompareCount(0);
		  	}
		
		
		
		@Test(groups={"regression"})
		public void TS_CMP_02_TC_CMP_13_signedCompareClear() throws Exception
		{
			if(setUp.getBrowser().equalsIgnoreCase("ie"))
			{
				throw new SkipException("need to test this manually in IE.");
			}
			else
			{
			data.setNumberOfCheckboxesToBeClicked(1);
	 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
	  		String searchText = data.getSearchText();
	  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
	  		Thread.sleep(1500);
	  		homePage()
	  		.searchText(searchText)
	  		.clickOnSearch()
	  		.productListPage()
	  		.checkCompareCount(0)
	  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
	  		.checkCompareCount(1)
	  		.clickOnASpecificCompareChecbox(2)
	  		.checkCompareCount(2)
			.clickOnClearList()
			.verifyClearListFunctionality();
		 }
		}	
			@Test(groups={"regression"})
			public void TS_CMP_02_TC_CMP_13_unsignedCompareClear() throws Exception
			{
				if(setUp.getBrowser().equalsIgnoreCase("ie"))
				{
					throw new SkipException("need to test this manually in IE.");
				}
				else
				{
				data.setNumberOfCheckboxesToBeClicked(1);
		 		int numberOfCheckBoxesToBeClicked = data.getNumberOfCheckboxesToBeClicked();
		  		String searchText = data.getSearchText();
		  		Thread.sleep(1500);
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.checkCompareCount(0)
		  		.clickCompareCheckboxes(numberOfCheckBoxesToBeClicked)
		  		.checkCompareCount(1)
		  		.clickOnASpecificCompareChecbox(2)
		  		.checkCompareCount(2)
				.clickOnClearList()
				.verifyClearListFunctionality();
			 }
		}		
			
			@Test(groups={"regression"})
			public void TS_CMP_02_TC_CMP_14_unsignedCompareClearWhenNoItemsAreAvailableInCompareList() throws Exception
			{
				if(setUp.getBrowser().equalsIgnoreCase("ie"))
				{
					throw new SkipException("need to test this manually in IE.");
				}
				else
				{
				data.setNumberOfCheckboxesToBeClicked(1);
		  		String searchText = data.getSearchText();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
				.clickOnClearList()
				.verifyClearListFunctionalityWhenNoItemsAreThereForComparing();
			 }
		 }
			
			@Test(groups={"regression"})
			public void TS_CMP_02_TC_CMP_14_signedCompareClearWhenNoItemsAreAvailableInCompareList() throws Exception
			{
				if(setUp.getBrowser().equalsIgnoreCase("ie"))
				{
					throw new SkipException("need to test this manually in IE.");
				}
				else
				{
				loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
				data.setNumberOfCheckboxesToBeClicked(1);
		  		String searchText = data.getSearchText();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
				.clickOnClearList()
				.verifyClearListFunctionalityWhenNoItemsAreThereForComparing();
			 }
		 }
			
			@Test(groups={"regression"})
			public void TS_CMP_02_TC_CMP_15_signedComparingOfThreeCategoriesWhereOneCategoryIsDifferent() throws Exception
			{
				loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
				shoppingCartPage().clearCart();
				Thread.sleep(1500);
				String searchText = data.getSearchText();
		  		String anotherSearchText = data.getAnotherSearchText();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
				.clickOnSpecificProduct(1);
				String productTitle1 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(1)
				.clickOnSpecificProduct(2);
				String productTitle2 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(2)
				.homePage()
				.searchText(anotherSearchText)
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificProduct(1);
				String productTitle3 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(1)
				.clickOnCompare()
				.comparePage()
				.verifyCompareHeaderAndBreampCrumpAndTitle()
				.verifyWhetherAllTheProductsAreDisplayed(productTitle1,productTitle2,productTitle3);
			 }
			
			@Test(groups={"regression"})
			public void TS_CMP_02_TC_CMP_15_unsignedComparingOfThreeCategoriesWhereOneCategoryIsDifferent() throws Exception
			{
				shoppingCartPage().clearCart();
				Thread.sleep(1500);
				String searchText = data.getSearchText();
		  		String anotherSearchText = data.getAnotherSearchText();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
				.clickOnSpecificProduct(1);
				String productTitle1 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(1)
				.clickOnSpecificProduct(2);
				String productTitle2 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(2)
				.homePage()
				.searchText(anotherSearchText)
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificProduct(1);
				String productTitle3 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(1)
				.clickOnCompare()
				.comparePage()
				.verifyCompareHeaderAndBreampCrumpAndTitle()
				.verifyWhetherAllTheProductsAreDisplayed(productTitle1,productTitle2,productTitle3);
			 }
			
			@Test(groups={"regression"})
			  public void TS_CMP_02_TC_CMP_017_signeduserTwoProductsInGridAndOneProductInListSameCategory() throws Exception
			  {
				loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
				Thread.sleep(1500);
				shoppingCartPage().clearCart();
				String searchText = data.getSearchText();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificProduct(1);
				String productTitle1 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(1)
				.clickOnSpecificProduct(2);
				String productTitle2 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(2)
				.clickOnSpecificProduct(3);
				String productTitle3 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnChangeView()
				.clickOnASpecificCompareChecbox(3)
				.clickOnCompare()
				.comparePage()
				.verifyCompareHeaderAndBreampCrumpAndTitle()
				.verifyWhetherAllTheProductsAreDisplayed(productTitle1,productTitle2,productTitle3);
			}
			
			@Test(groups={"regression"})
			  public void TS_CMP_02_TC_CMP_017_unsigneduserTwoProductsInGridAndOneProductInListSameCategory() throws Exception
			  {
				String searchText = data.getSearchText();
				shoppingCartPage().clearCart();
				Thread.sleep(1500);
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.clickOnSpecificProduct(1);
				String productTitle1 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(1)
				.clickOnSpecificProduct(2);
				String productTitle2 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(2)
				.clickOnSpecificProduct(3);
				String productTitle3 = productDetailsPage().productTitle();
				driver.navigate().back();
				productListPage()
				.clickOnChangeView()
				.clickOnASpecificCompareChecbox(3)
				.clickOnCompare()
				.comparePage()
				.verifyCompareHeaderAndBreampCrumpAndTitle()
				.verifyWhetherAllTheProductsAreDisplayed(productTitle1,productTitle2,productTitle3);
			}
			
			  @Test(groups={"regression"})
			  public void TS_CMP_02_TC_CMP_018_chooseProductWithNoImageAvailable() throws Exception
			  {
				throw new SkipException("This testcase has to be tested manually.");
			  }
			
			  @Test(groups={"regression"})
			  public void TS_CMP_02_TC_CMP_019_signeduserCompareProductsFromSameBrand() throws Exception
			  {
				String searchText = data.getSearchText();
				loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
				shoppingCartPage().clearCart();
				Thread.sleep(1500);
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.selectSpecificFilter(1);
				String filterName = productListPage().getFilterName(1);
				productListPage()
				.clickOnSearchFilterButton()
				.clickOnSpecificProduct(1);
				String productTitle1 = productDetailsPage().productTitle();
				productDetailsPage().verifyProductTitleHasTheFilterChosen(filterName);
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(1)
				.clickOnSpecificProduct(2);
				String productTitle2 = productDetailsPage().productTitle();
				productDetailsPage().verifyProductTitleHasTheFilterChosen(filterName);
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(2)
				.clickOnSpecificProduct(3);
				String productTitle3 = productDetailsPage().productTitle();
				productDetailsPage().verifyProductTitleHasTheFilterChosen(filterName);
				driver.navigate().back();
				productListPage()
				.clickOnChangeView()
				.clickOnASpecificCompareChecbox(3)
				.clickOnCompare()
				.comparePage()
				.verifyCompareHeaderAndBreampCrumpAndTitle()
				.verifyWhetherAllTheProductsAreDisplayed(productTitle1,productTitle2,productTitle3);
			}
			
			  @Test(groups={"regression"})
			  public void TS_CMP_02_TC_CMP_019_unsigneduserCompareProductsFromSameBrand() throws Exception
			  {
				String searchText = data.getSearchText();
				shoppingCartPage().clearCart();
				Thread.sleep(1500);
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.selectSpecificFilter(1);
				String filterName = productListPage().getFilterName(1);
				productListPage()
				.clickOnSearchFilterButton()
				.clickOnSpecificProduct(1);
				String productTitle1 = productDetailsPage().productTitle();
				productDetailsPage().verifyProductTitleHasTheFilterChosen(filterName);
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(1)
				.clickOnSpecificProduct(2);
				String productTitle2 = productDetailsPage().productTitle();
				productDetailsPage().verifyProductTitleHasTheFilterChosen(filterName);
				driver.navigate().back();
				productListPage()
				.clickOnASpecificCompareChecbox(2)
				.clickOnSpecificProduct(3);
				String productTitle3 = productDetailsPage().productTitle();
				productDetailsPage().verifyProductTitleHasTheFilterChosen(filterName);
				driver.navigate().back();
				productListPage()
				.clickOnChangeView()
				.clickOnASpecificCompareChecbox(3)
				.clickOnCompare()
				.comparePage()
				.verifyCompareHeaderAndBreampCrumpAndTitle()
				.verifyWhetherAllTheProductsAreDisplayed(productTitle1,productTitle2,productTitle3);
			}		*/
}