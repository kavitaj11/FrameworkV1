package org.etna.customer.pageobjects;
import java.util.List;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class ProductPageObjects extends MainController{
	
	
	 SearchDataPropertyFile data = new SearchDataPropertyFile();
	 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
   Actions action = new Actions(driver);
  
	
	@FindBy(xpath="//h4[contains(text(),'Category')]/following-sibling::span")
	private WebElement categoryToggleButton;
	
	
	@FindAll(value={@FindBy(xpath="(//h4[contains(text(),'Category')]/ancestor::dt/following-sibling::dd)[1]/ul/li/a")})
	private List<WebElement> categoriesList;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_productCategory']/descendant::h5")})
	private List<WebElement> categoryNamesInThePage;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_productCategory']/descendant::div[@class='cimm_categoryImg']")})
	private List<WebElement> categoryNamesInPageImagesLink;
	
	@FindBy(xpath="//h2")
	private WebElement pageName;
	
	@FindAll(value={@FindBy(xpath="//div[@class='slick-track']/descendant::img")})
	private List<WebElement> bannerImages;
	
	public ProductPageObjects clickOnCategoryToggleButton() {
		Waiting.explicitWaitVisibilityOfElement(categoryToggleButton, 15);
		categoryToggleButton.click();
		return this;
	}
	
	public ProductPageObjects verifyNamesOfAllTheCategoriesInListAndInPage() {
		
	Waiting.explicitWaitVisibilityOfElements(categoriesList, 15);
		for(int i=0;i<categoriesList.size(); i++)
		{
			Assert.assertTrue(categoriesList.get(i).getText().trim().equalsIgnoreCase(categoryNamesInThePage.get(i).getText().trim()),"category name is not the same as it was in the dropdown. The name in the category list is : "+categoriesList.get(i).getText().trim()+" and the name in the category page is "+categoryNamesInThePage.get(i).getText()+".");
		}
	
		return this;
	}

	public ProductPageObjects verifyBreadcrump(String productsPageBreadCrump) {	
		Assert.assertEquals(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim(), productsPageBreadCrump);
		return this;
	}

	public ProductPageObjects verifyPageTitle(String productsPageBreadCrump) throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),productsPageBreadCrump+" | "+setUp.getProductName().toUpperCase());
		return this;
	}

	public ProductPageObjects verifyPagename(String productsPageBreadCrump) throws Exception {
		Assert.assertEquals(pageName.getText().trim().toLowerCase(),productsPageBreadCrump.toLowerCase());
		return this;
	}

	public ProductPageObjects clickOnSpecificCategory(String getSpecificCategory) 
 {
	Waiting.explicitWaitVisibilityOfElements(categoryNamesInThePage, 10);	
	for(WebElement categoryOption : categoryNamesInThePage)
	{
		if(categoryOption.getText().trim().contains(getSpecificCategory.toUpperCase()))
		{
			categoryOption.click();
			break;
		}	
	}	
		return this;
 }

	public ProductPageObjects verifySecondBreadcrump(String getSpecificCategory) {
		Assert.assertEquals(productDetailsPage().breadCrumps.get(2).getText().replace("/", "").trim(), getSpecificCategory);
		return this;
	}

	public String getLastBreadCrump() {
		String lastBreadcrump = (productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim());
		return lastBreadcrump;
	}
	
	public String getLastButOneBreadCrump() {
		String lastButOneBreadcrump = (productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-2).getText().replace("/", "").trim());
		return lastButOneBreadcrump;
	}

	public ProductPageObjects verifyPageTitle(String lastButOneBreadcrump, String lastBreadcrump) throws Exception {
		Thread.sleep(1500);
		String title = lastButOneBreadcrump+" | "+lastBreadcrump+" | "+setUp.getProductName().toUpperCase();
		System.out.println(title);
		System.out.println(driver.getTitle().trim());
		Assert.assertEquals(driver.getTitle().trim(), title);
		return this;
	}

	public ProductPageObjects verifyLastButOneBreadcrump(String getSpecificCategory) {
		
		Assert.assertEquals(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-2).getText().replace("/", "").trim(), getSpecificCategory);
		return this;
	}

	public ProductPageObjects clickOnSpecificCategoryImage(String getSpecificCategory) {
		String clickOnSpecificCategoryImage = "//div[@class='cimm_productCategory']/descendant::h5[contains(text(),'"+getSpecificCategory+"')]/preceding-sibling::div[@class='cimm_categoryImg']";	
		driver.findElement(By.xpath(clickOnSpecificCategoryImage)).click();
		return this;
	}

	public ProductPageObjects verifyBannerImages() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String bannerImagesInLevelOne [] = data.getBannerImagesInLevelOne().split(",");
		for(int i = 0 ; i<bannerImages.size() ; i++)
		{
		Assert.assertTrue(bannerImages.get(i).getAttribute("src").trim().equals(bannerImagesInLevelOne[i]));
		}
		return this;
	}
	
}
