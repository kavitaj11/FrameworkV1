package org.etna.modules;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class ShopByManufacturersModuleTest extends PageFactoryInitializer{

	
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	LoginModuleTest loginModule = new LoginModuleTest();
	
	
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_001_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
	  {
				homePage()
				.hoverOverManufacturersLink()
				.verifyManufacturersDropdown();
	}
	
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_001_signedUser_hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
	  {
		loginModule.loginAsASuperUser();
			homePage()
			.hoverOverManufacturersLink()
			.verifyManufacturersDropdown();		
	}
	
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_002_TC_Manufacturers_010_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage() throws Exception
	  {
				String manufacturerName = homePage()
				.hoverOverManufacturersLink()
				.getSpecificManufacturersLinkName(1);
				homePage()
				.clickOnASpecificManufacturer(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheManufacturersName(manufacturerName);
				
	}
	
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_002_TC_Manufacturers_010_signedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage() throws Exception
	  {
		loginModule.loginAsASuperUser();
				String manufacturerName = homePage()
				.hoverOverManufacturersLink()
				.getSpecificManufacturersLinkName(1);
				homePage()
				.clickOnASpecificManufacturer(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheManufacturersName(manufacturerName);
				
	}
	
	@Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_003_unsignedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);	
	}
	

	  public void TC_Manufacturers_003_signedUser_clickingViewAllManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		loginModule.loginAsASuperUser();
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);
	}
	
	
	  public void TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_unsignedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.clickOnManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);	
	}
	
	
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_signedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
	
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);	
	}
	
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_005_unsignedUser_verificationOfManufacturersFirstLetterLink() throws Exception
	  {
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveManufacturers();	
	}
	
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_005_signedUser_verificationOfManufacturersFirstLetterLink() throws Exception
	  {
		loginModule.loginAsASuperUser();
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveManufacturers();	
	}
	
	
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_006_unsignedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_onlyOneProduct() throws Exception
	  {
		data.setSpecificManufacturerName("ASMC");
		String nameOfTheManufacturer = 
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnManufacturersToggleButton()
		.getNameOfTheSpecificManufacturer(data.getSpecificManufacturerName());
		 shopByManufacturersPage()
		.clickOnSpecificManufacturer(data.getSpecificManufacturerName());
		 shopByManufacturersPage()
		.verifyManufacturerBreadCrump(nameOfTheManufacturer)
		.verifyTitleOfTheManufacturer(nameOfTheManufacturer);	
	}
	
	
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_006_signedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_onlyOneProduct() throws Exception
	  {
		data.setSpecificManufacturerName("ASMC");
		loginModule.loginAsASuperUser();
		String nameOfTheManufacturer = 
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnManufacturersToggleButton()
		.getNameOfTheSpecificManufacturer(data.getSpecificManufacturerName());
		 shopByManufacturersPage()
		.clickOnSpecificManufacturer(data.getSpecificManufacturerName());
		 shopByManufacturersPage()
		.verifyManufacturerBreadCrump(nameOfTheManufacturer)
		.verifyTitleOfTheManufacturer(nameOfTheManufacturer);	
	}
	
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_006_unsignedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_ThatHaveMultipleProducts() throws Exception
	  {
		data.setSpecificManufacturerName("Ansell");
		String nameOfTheManufacturer = 
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnManufacturersToggleButton()
		.getNameOfTheSpecificManufacturer(data.getSpecificManufacturerName());
		shopByManufacturersPage()
		.clickOnSpecificManufacturer(data.getSpecificManufacturerName());
		shopByManufacturersPage()
		.verifyManufacturerBreadCrump(nameOfTheManufacturer)
		.verifyTitleOfTheManufacturer(nameOfTheManufacturer);	
	}
	
	  @Test(alwaysRun=true,groups={"ShopByManufacturersModule","regression"})
	  public void TC_Manufacturers_006_signedUser_verificationOfManufacturersAfterClickingOnAnyManufacturersNameDisplayedInList_ThatHaveMultipleProducts() throws Exception
	  {
		data.setSpecificManufacturerName("Ansell");
		loginModule.loginAsASuperUser();
		String nameOfTheManufacturer = 
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnManufacturersToggleButton()
		.getNameOfTheSpecificManufacturer(data.getSpecificManufacturerName());
		shopByManufacturersPage()
		.clickOnSpecificManufacturer(data.getSpecificManufacturerName());
		shopByManufacturersPage()
		.verifyManufacturerBreadCrump(nameOfTheManufacturer)
		.verifyTitleOfTheManufacturer(nameOfTheManufacturer);	
	}
	
	
	
}
