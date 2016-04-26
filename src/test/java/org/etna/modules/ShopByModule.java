package org.etna.modules;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

/*
 * @author Hemanth.Sridhar
 */

public class ShopByModule extends MainController{
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	LoginModule loginModule = new LoginModule();
	
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
		
	@Test(groups={"regression"})
	  public void TC_Brand_001_unsignedUser_hoverOverBrandsLinkInTopNavigationMenu() throws Exception
	  {
		  		homePage()
				.hoverOverBrandsLink()
				.verifyBrandsDropdown();
				
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_001_signedUser_hoverOverBrandsLinkInTopNavigationMenu() throws Exception
	  {
		  		
			loginModule.loginAsASuperUser();
				homePage()
				.hoverOverBrandsLink()
				.verifyBrandsDropdown();
				
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_002_TC_Brand_010_unsignedUser_clickOnOneOfTheBrandLinksAndVerifyAssertThePageForTheParticularBrand() throws Exception
	  {
				String brandName = homePage()
				.hoverOverBrandsLink()
				.getSpecificBrandLinkName(1);
				homePage()
				.clickOnASpecificBrand(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheBrandName(brandName);
				
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_002_TC_Brand_010_signedUser_hoverOverBrandsLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePageForTheParticularBrand() throws Exception
	  {
		loginModule.loginAsASuperUser();
				String brandName = homePage()
				.hoverOverBrandsLink()
				.getSpecificBrandLinkName(1);
				homePage()
				.clickOnASpecificBrand(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheBrandName(brandName);
				
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_003_unsignedUser_clickingViewAllBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrump)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrump);	
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_003_signedUser_clickingViewAllBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		loginModule.loginAsASuperUser();
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrump)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrump);	
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_004_TC_Brand_007_TC_Brand_008_TC_Brand_009_unsignedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.clickOnBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrump)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrump);	
	}
	
	
	@Test(groups={"regression"})
	  public void TC_Brand_004_TC_Brand_007_TC_Brand_008_TC_Brand_009_signedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		loginModule.loginAsASuperUser();
		homePage()
		.clickOnBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrump)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrump);	
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_005_unsignedUser_verificationOfBrandsFirstLetterLink() throws Exception
	  {
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveBrands();	
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_005_signedUser_verificationOfBrandsFirstLetterLink() throws Exception
	  {
		loginModule.loginAsASuperUser();
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveBrands();	
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_006_unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_OnlyOneProduct() throws Exception
	  {
		data.setSpecificBrandName("ASMC");
		loginModule.loginAsASuperUser();
		String nameOfTheBrand = homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnBrandsToggleButton()
		.getNameOfTheSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.clickOnSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.verifyBrandBreadCrump(nameOfTheBrand)
		.verifyTitleOfTheBrand(nameOfTheBrand);	
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_006_signedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_OnlyOneProduct() throws Exception
	  {
				data.setSpecificBrandName("ASMC");
				loginModule.loginAsASuperUser();
				String nameOfTheBrand = homePage()
				.hoverOverBrandsLink()
				.clickOnViewAllBrandsLink()
				.shopByBrandsPage()
				.clickOnBrandsToggleButton()
				.getNameOfTheSpecificBrand(data.getSpecificBrandname());
				shopByBrandsPage()
				.clickOnSpecificBrand(data.getSpecificBrandname());
				shopByBrandsPage()
				.verifyBrandBreadCrump(nameOfTheBrand)
				.verifyTitleOfTheBrand(nameOfTheBrand);	
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_006_unsignedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_MultipleProducts() throws Exception
	  {
		data.setSpecificBrandName("DuPont");
		loginModule.loginAsASuperUser();
		String nameOfTheBrand = homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnBrandsToggleButton()
		.getNameOfTheSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.clickOnSpecificBrand(data.getSpecificBrandname());
		shopByBrandsPage()
		.verifyBrandBreadCrump(nameOfTheBrand)
		.verifyTitleOfTheBrand(nameOfTheBrand);	
	}
	
	@Test(groups={"regression"})
	  public void TC_Brand_006_signedUser_verificationOfBrandAfterClickingOnAnyBrandNameDisplayedInList_MultipleProducts() throws Exception
	  {
				data.setSpecificBrandName("DuPont");
				loginModule.loginAsASuperUser();
				String nameOfTheBrand = homePage()
				.hoverOverBrandsLink()
				.clickOnViewAllBrandsLink()
				.shopByBrandsPage()
				.clickOnBrandsToggleButton()
				.getNameOfTheSpecificBrand(data.getSpecificBrandname());
				shopByBrandsPage()
				.clickOnSpecificBrand(data.getSpecificBrandname());
				shopByBrandsPage()
				.verifyBrandBreadCrump(nameOfTheBrand)
				.verifyTitleOfTheBrand(nameOfTheBrand);	
	}
	
	
	@Test(groups={"regression"})
	  public void TC_Manufacturers_001_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
	  {
				homePage()
				.hoverOverManufacturersLink()
				.verifyManufacturersDropdown();
	}
	
	@Test(groups={"regression"})
	  public void TC_Manufacturers_001_signedUser_hoverOverManufacturersLinkInTopNavigationMenu() throws Exception
	  {
			loginModule.loginAsASuperUser();
			homePage()
			.hoverOverManufacturersLink()
			.verifyManufacturersDropdown();		
	}
	
	@Test(groups={"regression"})
	  public void TC_Manufacturers_002_TC_Manufacturers_010_unsignedUser_hoverOverManufacturersLinkInTopNavigationMenu_clickOnOneOfTheBrandLinksAndVerifyAssertThePage() throws Exception
	  {
				String manufacturerName = homePage()
				.hoverOverManufacturersLink()
				.getSpecificManufacturersLinkName(1);
				homePage()
				.clickOnASpecificManufacturer(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheManufacturersName(manufacturerName);
				
	}
	
	@Test(groups={"regression"})
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
	
	@Test(groups={"regression"})
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
	
	@Test(groups={"regression"})
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
	
	@Test(groups={"regression"})
	  public void TC_Manufacturers_004_TC_Manufacturers_007_TC_Manufacturers_008_TC_Manufacturers_009_unsignedUser_clickingManufacturersLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.clickOnManufacturersLink()
		.shopByManufacturersPage()
		.verifyShopByManufacturersPageName()
		.verifyShopByBreadcrump(shopByManufacturersBreadcrump)
		.verifyTitleOfShopByManufacturers(shopByManufacturersBreadcrump);	
	}
	
	
	@Test(groups={"regression"})
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
	
	@Test(groups={"regression"})
	  public void TC_Manufacturers_005_unsignedUser_verificationOfManufacturersFirstLetterLink() throws Exception
	  {
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveManufacturers();	
	}
	
	@Test(groups={"regression"})
	  public void TC_Manufacturers_005_signedUser_verificationOfManufacturersFirstLetterLink() throws Exception
	  {
		loginModule.loginAsASuperUser();
		homePage()
		.hoverOverManufacturersLink()
		.clickOnViewAllManufacturersLink()
		.shopByManufacturersPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveManufacturers();	
	}
	
	
	@Test(groups={"regression"})
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
	
	
	@Test(groups={"regression"})
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
	@Test(groups={"regression"})
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
	
	@Test(groups={"regression"})
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
