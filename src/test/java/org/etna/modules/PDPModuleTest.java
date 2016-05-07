package org.etna.modules;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class PDPModuleTest extends MainController {
	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	
	@Test(alwaysRun=true,groups={"PDPModule","regression"})
	  public void TC_PDP_001_TC_PDP_003_TC_PDP_013_TC_PDP_014_unsignedUser_verifyProductDetailsPageTest() throws Exception
	  {
	  	String searchText = data.getSearchTextForUPCLabelTest();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()
	  	.verifyPDPPageTitle()
	  	.verifyPDPFilterSectionToggleButtons()
	  	.verifyDisplayOfItemName(searchText)
	  	.verifyDisplayOfShortDescription(searchText)
	  	.verifyDisplayOfPartNumber()
	  	.verifyDisplayOfMPN()
	  	.verifyDisplayOfMinimumOrderQuantity()
	  	.verifyDisplayOfQuantityInterval()
	  	.verifyDisplayOfYourPrice()
	  	.verifyDisplayOfUPC()
	  	.verifyDisplayOfQuantity()
	  	.verifyDisplayOfPrintLink()
	  	.verifyToolTipOfPrintLink()
	  	.verifyDisplayOfShare()
	  	.verifyDisplayOfAccordians()
	  	.verifyDisplayOfCustomerPartNumberButton()
	  	.verifyAddToCartButton()
	  	.verifyDisplayOfAddMyProductGroupButton()
	  	.verifyBreadCrump();
	  }

	@Test(alwaysRun=true,groups={"smoke","regression"})
	  public void TC_PD_002_TC_PD_004_signedUser_verifyProductDetailsPageTest() throws Exception
	  {
	  	String searchText = data.getSearchTextForUPCLabelTest();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()
	  	.verifyPDPPageTitle()
	  	.verifyPDPFilterSectionWhenLoggedIn()
	  	.verifyPDPFilterSectionToggleButtons()
	  	.verifyDisplayOfItemName(searchText)
	  	.verifyDisplayOfShortDescription(searchText)
	  	.verifyDisplayOfPartNumber()
	  	.verifyDisplayOfMPN()
	  	.verifyDisplayOfMinimumOrderQuantity()
	  	.verifyDisplayOfQuantityInterval()
	  	.verifyDisplayOfYourPrice()
	  	.verifyDisplayOfQuantity()
	  	.verifyDisplayOfShipBranchName()
	  	.verifyDisplayOfUPC()
	  	.verifyDisplayOfPrintLink()
	  	.verifyToolTipOfPrintLink()
	  	.verifyDisplayOfShare()
	  	.verifyDisplayOfAccordians()
	  	.verifyDisplayOfCustomerPartNumberButton()
	  	.verifyAddToCartButton()
	  	.verifyDisplayOfAddMyProductGroupButton()
	  	.verifyBreadCrump();
	  }


	 @Test(alwaysRun=true,groups={"PDPModule","regression"})
	  public void TC_PDP_006_enlargeImageFunctionalityTest() throws Exception
	  	{
	  	String searchText = data.getSearchTextForEnlargeImageTest();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage();
	  	int height = productDetailsPage().getHeightOfTheImage();
	  	int width = productDetailsPage().getWidthOfTheImage();
	  	productDetailsPage()
	  	.clickOnEnlargeIcon()
	  	.verifyImageHeightAndWidthAfterEnlarge(height,width);
	  	}


	  @Test(enabled=false,groups={"PDPModule","regression"})
	  public void TC_PDP_008_PrintFunctionalityTest(){
	  	throw new SkipException("Feature not yet completely developed.");
	  }


	  @Test(enabled=false,groups={"PDPModule","regression"})
	  public void TC_PDP_009_TC_PDP_010_ShareFunctionalityTest(){
	  	throw new SkipException("Feature not yet completely developed.");
	  }

	  @Test(alwaysRun=true,groups={"PDPModule","smoke","regression"})
	  public void TC_PDP_012_signedUser_createAndDeleteCPNInProductDetailsPageTest() throws Exception{
	  	
	  	String searchText = data.getSearchTextForUPCLabelTest();
	  	String customerPartNumber = data.getCustomerPartNumber();
	  	loginModule.loginAsASuperUser();
	  	homePage()
	  	.searchText(searchText)
	  	.clickOnSearch()
	  	.productDetailsPage()  
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.enterCPN(customerPartNumber)
	  	.clickOnAddButton()
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.clickOnCheckbox(customerPartNumber)
	  	.clickOnRemove()
	  	.clickOnAddOrRemoveCustomerPartNumber()
	  	.verifyDeletionOfCPN(customerPartNumber);	
	  	}


	  @Test(groups={"PDPModule","smoke","regression"},enabled=false)
	  public void TC_PDP_013_signedUser_tryingToCreateCPNInProductDetailsPage_ErrorScenariosTest() throws Exception{
	  	
	  	throw new SkipException("pending.");
	  	}
	  
	  @Test(alwaysRun=true,groups={"PDPModule","smoke","regression"})
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
	  
	  @Test(alwaysRun=true,groups={"PDPModule","smoke","regression"})
	  public void tc005_ListViewGridView() throws Exception
	  {
		  String searchText = data.getSearchText();
		  homePage()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .verifyListView()
		  .clickOnChangeView()
		  .verifyGridView();
	  }
	
	  
	  @Test(alwaysRun=true,groups={"PDPModule","smoke","regression"})
	  public void tc006_verifyProductListPage() throws Exception
	  {
		  		String searchText = data.getSearchText();
		  		data.setShowItemsPerPage(24);
		  		int showItemsPerPage = data.getShowItemsPerPage();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.verifyListOfProducts()
				.verifySearchHeader(searchText)
				.verifySearchSection()
				.verifyFilterSection()
				.verifyCompareLinkLocator()
				//.verifyAddDropdown()
				.verifySortByDropdown()
				.verifyResultsPerPageDropdown()
				.verifyShowItemsPerPage(showItemsPerPage);
	  }
	  
}
