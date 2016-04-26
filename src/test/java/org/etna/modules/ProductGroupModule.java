package org.etna.modules;

import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ProductGroupModule  extends MainController {
	
	/*
	 * @author Hemanth.Sridhar
	 */
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModule loginModule = new LoginModule();

	@Test(groups={"smoke","regression"})
	public void TC_PDP_011_signedUser_createAndDeleteMyProductGroupInProductDetailsPage() throws Exception{
		if(setUp.getBrowser().equalsIgnoreCase("safari"))
		{
			throw new SkipException("The SafariDriver developed by Selenium unfortunately does not support interacting with modal dialogs.");
		}
		else
		{
		String searchText = data.getSearchTextForUPCLabelTest();
		String myProductGroupName = data.getMyProductGroupName();
		loginModule.loginAsASuperUser();
		homePage()
		.searchText(searchText)
		.clickOnSearch()
		.productDetailsPage()
		.clickOnMyProductGroupButton()
		.enterGroupName(myProductGroupName)
		.hitEnter()
		.verifyMyProductCreationSuccessMsg(myProductGroupName)
		.clickOnMyProductGroups()
		.myProductGroupsPage()
		.clickOnTheGroupCreated(myProductGroupName)
		.verifyBreadCrump(myProductGroupName)
		.verifyPageName(myProductGroupName)
		.clickOnDelete()
		.verifyAlertText();
		TestUtility.alertAccept();
		homePage()
		.navigateToMyProductGroups()
		.myProductGroupsPage()
		.verifyPageName()
		.verifyWhetherGroupIsDeleted(myProductGroupName);
		}
	}
}
