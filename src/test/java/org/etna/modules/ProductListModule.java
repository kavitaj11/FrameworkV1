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
		  .verifyGridView()
		  .clickOnChangeView()
		  .verifyListView();
	  }
	  
	  
	  @Test(groups={"smoke","regression"})
	  public void tc006_HGH_ProductListPage() throws Exception
	  {
		  		String searchText = data.getSearchText();
				homePage()
				.searchText(searchText)
				.clickOnSearch()
				.productListPage()
				.verifyListOfProducts()
				.verifyAdvancedSearchSection()
				.verifyRefineSearchHeader()
				.verifyCategoryFilterSection()
				.verifyBrandsFilterSection()
				.verifySortBySection()
				.verifyNarrowSearchBox()
				.verifyCompareListLink();
	  }
}
