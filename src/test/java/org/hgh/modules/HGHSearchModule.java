package org.hgh.modules;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class HGHSearchModule extends MainController {

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	HGHLoginModule loginModule = new HGHLoginModule();

	@Test(groups={"smoke","regression"})
	  public void tc004_HGH_generalSearch() throws Exception
	  {
		  //pdp page
		  		String searchText = data.getSearchText();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.verifyHeader(searchText)
				.clickOnFirstProduct()
				.productDetailsPage()
				.verifyHeadingOfProduct(searchText);
			}
	
}
