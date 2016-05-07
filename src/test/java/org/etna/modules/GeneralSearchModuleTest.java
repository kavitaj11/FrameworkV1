package org.etna.modules;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class GeneralSearchModuleTest extends MainController{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	  
	@Test(alwaysRun=true,groups={"GeneralSearchModule","smoke","regression"})
	  public void tc004_generalSearch() throws Exception
	  {
				String searchText = data.getSearchTextForUPCLabelTest();
		  		homePage()
		  		.searchText(searchText)
		  		.clickOnSearch()
		  		.productDetailsPage()
		  		.verifyPDPPageTitle()
		  		.verifyPDPFilterSectionToggleButtons()
		  		.verifyDisplayOfItemName(searchText);
			}
}
