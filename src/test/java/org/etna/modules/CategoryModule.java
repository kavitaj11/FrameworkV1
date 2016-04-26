package org.etna.modules;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

/*
 * @author Hemanth.Sridhar
 */

public class CategoryModule extends MainController{
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();

	LoginModule loginModule = new LoginModule();
	
	@Test(groups={"regression"})
	@Description("Verification of breadcrumbs, Verification of Page Title, Verification of Page Name, Verification of categories in filter is displayed "
			+ "in the page ")
	  public void TC_categories_001_006_007_008() throws Exception
	  {
		  		
		  		String productsPageBreadCrump = data.getProductsPageBreadCrump();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnCategoryToggleButton()
				.verifyBreadcrump(productsPageBreadCrump)
				.verifyPageTitle(productsPageBreadCrump)
				.verifyNamesOfAllTheCategoriesInListAndInPage()
				.verifyPagename(productsPageBreadCrump);
				
	}
	
	@Test(groups={"regression"})
	@Description("Verification of level 1 category link.")
	  public void TC_categories_002() throws Exception
	  {
		  		data.setSpecificCategory("Safety & Security");
		  		String getSpecificCategory = data.getSpecificCategory();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategory(getSpecificCategory)
				.verifyLastButOneBreadcrump(getSpecificCategory);
				String lastBreadcrump = productsPage().getLastBreadCrump();
				String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
				productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump);
	}
	
		@Test(groups={"regression"})
		@Description("Verification of last level category link for Product List Page.")
		public void TC_categories_003_navigateProductListPage() throws Exception
		{
		  		data.setSpecificCategory("Safety & Security");
		  		String getSpecificCategory1 = data.getSpecificCategory();
		  		data.setSpecificCategory("Hand Protection");
		  		String getSpecificCategory2 = data.getSpecificCategory();
		  		data.setSpecificCategory("Coated Gloves");
		  		String getSpecificCategory3 = data.getSpecificCategory();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategory(getSpecificCategory1)
				.verifyLastButOneBreadcrump(getSpecificCategory1);
				String lastBreadcrump = productsPage().getLastBreadCrump();
				String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
				productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump)
				.clickOnSpecificCategory(getSpecificCategory2)
				.verifySecondBreadcrump(getSpecificCategory1);
				String lastBreadcrump1 = productsPage().getLastBreadCrump();
				productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump1)
				.clickOnSpecificCategory(getSpecificCategory3)
				.verifySecondBreadcrump(getSpecificCategory1);
				String lastBreadcrump2 = productsPage().getLastBreadCrump();
				productListPage()
				.verifyListOfProducts()
				.verifyBreadCrump(lastBreadcrump2)
				.verifyTitle(lastBreadcrump2)
				.verifySearchMatchesLink(getSpecificCategory3);
	  }
		
		@Test(groups={"regression"})
		@Description("Verification of last level category link for Product Details Page.")
		public void TC_categories_003_navigateProductDetailsPage() throws Exception
		{
		  		data.setSpecificCategory("Safety & Security");
		  		String getSpecificCategory1 = data.getSpecificCategory();
		  		data.setSpecificCategory("Hand Protection");
		  		String getSpecificCategory2 = data.getSpecificCategory();
		  		data.setSpecificCategory("Disposable Gloves");
		  		String getSpecificCategory3 = data.getSpecificCategory();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategory(getSpecificCategory1)
				.verifyLastButOneBreadcrump(getSpecificCategory1);
				String lastBreadcrump = productsPage().getLastBreadCrump();
				String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
				productsPage()
				.verifyPageTitle(lastButOneBreadcrump,lastBreadcrump)
				.clickOnSpecificCategory(getSpecificCategory2)
				.verifySecondBreadcrump(getSpecificCategory1);
				String lastBreadcrump1 = productsPage().getLastBreadCrump();
				productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump1)
				.clickOnSpecificCategory(getSpecificCategory3)
				.verifySecondBreadcrump(getSpecificCategory1);
				productDetailsPage()
				.verifyBreadCrump()
				.verifyPDPPageTitle();
	  }
		
		@Test(groups={"regression"})
		@Description("Verification of description and banners.")
		public void TC_categories_004_verifyBanners() throws Exception
			{
		  		data.setSpecificCategory("Safety & Security");
		  		String getSpecificCategory = data.getSpecificCategory();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.clickOnSpecificCategoryImage(getSpecificCategory)
				.verifyLastButOneBreadcrump(getSpecificCategory)
				.verifyBannerImages();
			}
		
		
			@Test(groups={"regression"})
			@Description("Verification of image link of any category")
			public void TC_categories_005_ClickingOnImages() throws Exception
				{
			  		data.setSpecificCategory("Safety & Security");
			  		String getSpecificCategory = data.getSpecificCategory();
					homePage()
					.clickOnProductsLink()
					.productsPage()
					.clickOnSpecificCategoryImage(getSpecificCategory)
					.verifyLastButOneBreadcrump(getSpecificCategory);
					String lastBreadcrump = productsPage().getLastBreadCrump();
					String lastButOneBreadcrump = productsPage().getLastButOneBreadCrump();
					productsPage().verifyPageTitle(lastButOneBreadcrump,lastBreadcrump);
				}
			

			
}
