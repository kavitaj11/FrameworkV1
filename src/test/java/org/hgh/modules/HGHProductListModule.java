package org.hgh.modules;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class HGHProductListModule extends MainController{
	
	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	HGHLoginModule loginModule = new HGHLoginModule();
	
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
