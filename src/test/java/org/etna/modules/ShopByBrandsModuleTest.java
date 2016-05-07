package org.etna.modules;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class ShopByBrandsModuleTest extends PageFactoryInitializer{


	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	LoginModuleTest loginModule = new LoginModuleTest();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_001_unsignedUser_hoverOverBrandsLinkInTopNavigationMenu() throws Exception
	  {
		  		homePage()
				.hoverOverBrandsLink()
				.verifyBrandsDropdown();
				
	}
	
		
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_001_signedUser_hoverOverBrandsLinkInTopNavigationMenu() throws Exception
	  {
		  		
		loginModule.loginAsASuperUser();
				homePage()
				.hoverOverBrandsLink()
				.verifyBrandsDropdown();
				
	}
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_002_TC_Brand_010_unsignedUser_clickOnOneOfTheBrandLinksAndVerifyAssertThePageForTheParticularBrand() throws Exception
	  {
				String brandName = homePage()
				.hoverOverBrandsLink()
				.getSpecificBrandLinkName(1);
				homePage()
				.clickOnASpecificBrand(1)
				.verifyWhetherTitleAndBreadcrumpHaveTheBrandName(brandName);
				
	}
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
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
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
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
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
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
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_004_TC_Brand_007_TC_Brand_008_TC_Brand_009_unsignedUser_clickingBrandsLinkShouldNavigateToShopByBrandsPage() throws Exception
	  {
		
		homePage()
		.clickOnBrandsLink()
		.shopByBrandsPage()
		.verifyShopByBrandsPageName()
		.verifyShopByBreadcrump(shopByBrandBreadcrump)
		.verifyTitleOfShopByBrand(shopByBrandBreadcrump);	
	}
	
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
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
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_005_unsignedUser_verificationOfBrandsFirstLetterLink() throws Exception
	  {
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveBrands();	
	}
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
	  public void TC_Brand_005_signedUser_verificationOfBrandsFirstLetterLink() throws Exception
	  {
		loginModule.loginAsASuperUser();
		homePage()
		.hoverOverBrandsLink()
		.clickOnViewAllBrandsLink()
		.shopByBrandsPage()
		.clickOnEveryAlphabetAndCheckTheFirstLetterOfTheRespectiveBrands();	
	}
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
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
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
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
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
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
	
	@Test(alwaysRun=true,groups={"ShopByBrandsModule","regression"})
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
	
}
