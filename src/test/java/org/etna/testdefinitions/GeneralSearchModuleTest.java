package org.etna.testdefinitions;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;

public class GeneralSearchModuleTest extends MainController{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	  
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
