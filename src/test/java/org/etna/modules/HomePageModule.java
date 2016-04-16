package org.etna.modules;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class HomePageModule extends MainController{

	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	LoginModule loginModule = new LoginModule();
	
	@Test(groups={"smoke","regression"},enabled=false)
	  public void tc008_verifyHomePage() throws Exception
	  {
		homePage()
		.verifyHomePage();
	  } 
	
	@Test(groups={"regression"})
	  public void tc009_verifyAllSectionOptionPages() throws Exception
	  {
		throw new SkipException("Feature not completely implemented yet.");
		
			/*verification of breadcrumps all the sections and subsections irrespective of whether it is a parent or a child,
	 	 	filter sections,page name,search box for filter */
			/*	homePage()
				.verifyAllSectionOptionPages();*/
	  } 	
	
	@Test(groups={"regression"})
	  public void tc010_verifyAllFooterSectionPages() throws Exception
	  {
		throw new SkipException("Feature not completely implemented yet.");
		//verification of breadcrumps,pagename and etc. for the footer links
	  } 	
	
	
	@Test(groups={"regression"})
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
