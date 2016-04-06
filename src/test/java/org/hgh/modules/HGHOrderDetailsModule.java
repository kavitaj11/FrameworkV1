package org.hgh.modules;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class HGHOrderDetailsModule extends MainController{
	
SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	HGHLoginModule loginModule = new HGHLoginModule();
	
	@Test(groups={"regression"})
	  public void TS_OrderDetails_001_TC_OrderDetails_001_HGH_orderDetailsPageDisplayWhenClickOnReOrderInOpenOrders() throws Exception
	  {
		String searchText = data.getSearchText();
		String shippingInstructions = data.getCommentForRequestQuote();
		String nickName = data.getNickName();
		String cardHolder = data.getCardHolder();
		String streetAddress = data.getStreetAddress();
		String postalCode = data.getPostalCode();
		String welcomeMessageInAddNewCreditCardPage = data.welcomeMessageInAddNewCreditCardPage();
		String cardNumber = data.getCardNumber();
		String month = data.getMonth();
		String year = data.getYear();
		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
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
		 .clickOnContinueCheckout()
		 .checkoutPage()
		 .verifyCheckoutPage()
		 .enterShippingInstructions(shippingInstructions)
		 .enterOrderNote(shippingInstructions)
		 .clickOnCheckoutWithCreditCard()
		 .checkoutWithCreditCardPage()
		 .verifyCheckoutWithCreditCardPage()
		 .enterNickName(nickName)
		 .enterCardHolder(cardHolder)
		 .enterStreetAddress(streetAddress)
		 .enterPostalCode(postalCode)
		 .clickAddNewCreditCard()
		 .addNewCreditCardPage()
		 .verifyAddNewCreditCardPage(welcomeMessageInAddNewCreditCardPage)
		 .enterCardNumber(cardNumber)
		 .selectMonth(month)
		 .selectYear(year)
		 .clickOnPlaceOrder()
		 .checkoutWithCreditCardPage()
		 .chooseFirstCard()
		 .clickOnPlaceOrder()
		 .checkoutWithCreditCardPage()
		 .chooseFirstCard()
		 .clickOnPlaceOrder()
		 .confirmOrderPage()
		 .verifyConfirmOrderPage()
		 .clickOnPlaceOrder()
		 .orderConfirmationPage()
		 .verifyConfirmOrderPage()
		 .verifyOrderStatus();
	  }
}
