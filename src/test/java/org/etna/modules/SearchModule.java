package org.etna.modules;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class SearchModule extends MainController {

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	LoginModule loginModule = new LoginModule();

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
