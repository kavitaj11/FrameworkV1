package org.etna.modules;

import org.testng.annotations.Test;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;

public class ProductDetailsModule extends MainController{
	
SearchDataPropertyFile data = new SearchDataPropertyFile();
LoginModule loginModule = new LoginModule();

@Test(groups={"smoke","regression"})
public void tc004_HGH_verifyProductDetailsPage() throws Exception
{
	String searchText = data.getSearchText();
	homePage()
	.searchText(searchText)
	.clickOnSearch()
	.productListPage()
	.verifyListOfProducts()
	.clickOnSpecificItem(1)
	.productDetailsPage()
	.verifyPDPFilterSection();
}
}
