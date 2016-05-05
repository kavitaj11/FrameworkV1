package org.etna.testdefinitions;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;

public class HomePageModuleTest extends MainController{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	


	  public void tc008_verifyHomePage() throws Exception
	  {
		homePage()
		.verifyHomePage();
	  } 
	

	  public void tc009_verifyAllSectionOptionPages() throws Exception
	  {
		throw new SkipException("Feature not completely implemented yet.");
		
			/*verification of breadcrumps all the sections and subsections irrespective of whether it is a parent or a child,
	 	 	filter sections,page name,search box for filter */
			/*	homePage()
				.verifyAllSectionOptionPages();*/
	  } 	
	
	  public void tc010_verifyAllFooterSectionPages() throws Exception
	  {
		throw new SkipException("Feature not completely implemented yet.");
		//verification of breadcrumps,pagename and etc. for the footer links
	  } 
	
	

	  public void tc011_clickOnLogoNavigateBackToHomePage() throws Exception
	  {
		String searchText = data.getSearchText();
		homePage()
		.searchText(searchText)
		.clickOnSearch();
		homePage()
		.clickOnLogo()
		.verifyCarousel()
		.verifyFeaturedProductsSection();
	  } 
	
}
