package org.hgh.modules;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class HGHRequestForQuoteModule extends MainController {

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	HGHLoginModule loginModule = new HGHLoginModule();
	
	 @Test(groups={"smoke","regression"})
	  public void tc015_HGH_requestForQuote() throws Exception
	  {
		 
		  loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
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
}
