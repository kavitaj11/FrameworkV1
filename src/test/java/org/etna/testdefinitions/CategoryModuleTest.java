package org.etna.testdefinitions;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;

public class CategoryModuleTest extends MainController{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	String shopByBrandBreadcrump = data.getShopByBrandsBreadcrump();
	String shopByManufacturersBreadcrump = data.getShopByManufacturersBreadcrump();
	
	
	  public void TC_categories_001_TC_categories_006_TC_categories_007_TC_categories_008() throws Exception
	  {
		  		
		  		String productsPageBreadCrump = data.getProductsPageBreadCrump();
				homePage()
				.clickOnProductsLink()
				.productsPage()
				.verifyBreadcrump(productsPageBreadCrump)
				.verifyPageTitle(productsPageBreadCrump)
				.verifyNamesOfAllTheCategoriesInListAndInPage();
				//.verifyPagename(productsPageBreadCrump);
				
	}
	
	
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
