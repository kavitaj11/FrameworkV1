package org.hgh.modules;

import org.testng.annotations.Test;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;

public class HGHProductDetailsModule extends MainController{
	
SearchDataPropertyFile data = new SearchDataPropertyFile();
HGHLoginModule loginModule = new HGHLoginModule();

@Test(groups={"smoke","regression"})
public void tc004_HGH_verifyProductDetailsPage() throws Exception
{
	  //pdp page
	
			loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
	  		String searchText = data.getSearchText();
			homePage()
			.searchText(searchText);
			Thread.sleep(1500);
			homePage()
			.clickOnSearch()
			.productListPage()
			.verifyHeader(searchText)
			.clickOnFirstProduct()
			.productDetailsPage()
			.verifyProductDetailsPage(searchText);
		}
}
