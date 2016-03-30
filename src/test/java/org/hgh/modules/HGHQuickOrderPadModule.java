package org.hgh.modules;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class HGHQuickOrderPadModule extends MainController{

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	HGHLoginModule loginModule = new HGHLoginModule();
	
	 @Test(groups={"smoke","regression"})
	  public void tc014_HGH_quickOrderPad() throws Exception
	  {
		  
		  loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
		 shoppingCartPage().clearCart();
		 homePage()
		 .clickOnQuickOrderPadLink()
		 .myAccountsPage()
		 .verifyQuickOrderPadBreadCrump()
		 .verifyQuickCartPage()
		 .selectPartNumberFromDropdown();
		// myAccountsPage.enterPartNumberValues();
		 
	  }
}
