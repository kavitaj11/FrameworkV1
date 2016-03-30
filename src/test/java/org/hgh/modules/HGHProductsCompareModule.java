package org.hgh.modules;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class HGHProductsCompareModule extends MainController {

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	HGHLoginModule loginModule = new HGHLoginModule();
	
	@Test(groups={"smoke","regression"})
	  public void tc009_compareFunctionality() throws Exception
	  {
		  		String searchText = data.getSearchText();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productListPage()
		  		.clickFirstTwoCompareCheckboxes()
		  		.clickOnCompare()
		  		.verifyCompareHeaderAndBreampCrump()
		  		.verifyDisplayOfCompareTable();
	}
}
