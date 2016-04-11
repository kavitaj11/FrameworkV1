package org.etna.modules;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

/*
 * @author Hemanth.Sridhar
 */

public class AccountDashboardModule extends MainController{
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	LoginModule loginModule = new LoginModule();
	
	@Test(groups={"smoke","regression"})
	  public void tc011_HGH_AccountsDashboard() throws Exception
	  {
		  		
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
				homePage()
				.clickOnMyAccounts()
				.myAccountsPage()
				.verifyProductCategoriesSection()
				.verifyMyAccountSection();
	}
}
