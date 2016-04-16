package org.etna.modules;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class ProductListModule extends MainController{
	
	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	LoginModule loginModule = new LoginModule();
	
	@Test(groups={"smoke","regression"})
	  public void tc005_HGH_ListViewGridView() throws Exception
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
	  
	  
	  @Test(groups={"smoke","regression"})
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
