package org.etna.modules;

import org.testng.annotations.Test;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;

public class ProductDetailsModule extends MainController{
	
SearchDataPropertyFile data = new SearchDataPropertyFile();
LoginModule loginModule = new LoginModule();

@Test(groups={"regression"})
public void TC_PD_001__unsignedUser_verifyProductDetailsPage() throws Exception
{
	String searchText = data.getSearchTextForUPCLabelTest();
	homePage()
	.searchText(searchText)
	.clickOnSearch()
	.productDetailsPage()
	.verifyPDPFilterSection()
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
	.verifyDisplayOfAddMyProductGroupButton();
}

@Test(groups={"smoke","regression"})
public void TC_PD_002_signedUser_verifyProductDetailsPage() throws Exception
{
	String searchText = data.getSearchTextForUPCLabelTest();
	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
	homePage()
	.searchText(searchText)
	.clickOnSearch()
	.productDetailsPage()
	.verifyPDPFilterSection()
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
	.verifyDisplayOfAddMyProductGroupButton();
}

@Test(groups={"smoke","regression"})
public void TC_PD_003_enlargeImageFunctionality() throws Exception
	{
	String searchText = data.getSearchTextForUPCLabelTest();
	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
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
}
