package org.etna.modules;

import org.testng.SkipException;
import org.testng.annotations.Test;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;

public class ProductDetailsModule extends MainController{
	
SearchDataPropertyFile data = new SearchDataPropertyFile();
LoginModule loginModule = new LoginModule();

@Test(groups={"regression"})
public void TC_PDP_001_TC_PDP_003_TC_PDP_013_TC_PDP_014_unsignedUser_verifyProductDetailsPageTest() throws Exception
{
	String searchText = data.getSearchTextForUPCLabelTest();
	homePage()
	.searchText(searchText)
	.clickOnSearch()
	.productDetailsPage()
	.verifyPDPPageTitle()
	.verifyPDPFilterSectionNOTLoggedIn()
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

@Test(groups={"smoke","regression"})
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


@Test(groups={"regression"})
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


@Test
public void TC_PDP_008_PrintFunctionalityTest(){
	throw new SkipException("Feature not yet completely developed.");
}


@Test
public void TC_PDP_009_TC_PDP_010_ShareFunctionalityTest(){
	throw new SkipException("Feature not yet completely developed.");
}

@Test(groups={"smoke","regression"})
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


@Test(groups={"smoke","regression"})
public void TC_PDP_013_signedUser_tryingToCreateCPNInProductDetailsPage_ErrorScenariosTest() throws Exception{
	
	throw new SkipException("pending.");
	}
}
