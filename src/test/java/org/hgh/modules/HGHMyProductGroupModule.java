package org.hgh.modules;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.TestUtility;
import org.testng.annotations.Test;

public class HGHMyProductGroupModule  extends MainController {
	
	/*
	 * @author Hemanth.Sridhar
	 */
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	HGHLoginModule loginModule = new HGHLoginModule();

	@Test(groups={"smoke","regression"})
	  public void tc007_HGH_MyProductGroupCreateAndDelete() throws Exception
	  {
		  		
		  		String groupName = data.getGroupName();
		  		String searchText = data.getSearchText();
		  		loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH();
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
	
}
