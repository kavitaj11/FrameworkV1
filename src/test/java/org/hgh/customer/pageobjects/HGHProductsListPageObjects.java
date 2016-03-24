package org.hgh.customer.pageobjects;
import java.util.List;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class HGHProductsListPageObjects extends MainController{
	
	
 SearchDataPropertyFile data = new SearchDataPropertyFile();
 
   Actions action = new Actions(driver);


	@FindBy(xpath="(//h5/a)[1]")
	private WebElement firstProduct;
	
	@FindBy(xpath="//p[@class='cimm_productDetailBrand']")
	private WebElement productDetailsBrandHeading;


	@FindBy(xpath="//ul[@id='getchangemode']")
	private WebElement listOfProducts;
	
	@FindAll(value={@FindBy(xpath="//ul[@id='getchangemode']")})
	private List<WebElement> listOfProductsLocator;
	
	@FindBy(xpath="//div[@class='cimm_advancedSearch']")
	private WebElement advancedSearchSection;
	
	@FindBy(xpath="//div[@class='cimm_multiFilterListBlock']/h4")
	private WebElement refineResults;
	
	@FindBy(xpath="//dt[contains(text(),'Category')]/ancestor::dl[@id='narrow-by-list']")
	private WebElement categoryFilterSection;
	
	@FindBy(xpath="//dt[contains(text(),'Brands')]/ancestor::dl[@id='narrow-by-list']")
	private WebElement brandsFilterSection;
	
	@FindBy(xpath="//div[@class='cimm_listGridTopRightCtrls']")
	private WebElement sortByFunctionality;
	
	@FindBy(xpath="//input[@id='narrowText']")
	private WebElement narrowSearchTextBox;
	
	@FindBy(xpath="//a[contains(text(),'Compare List')]")
	private WebElement compareListLink;
	
	@FindBy(xpath="(//b[contains(text(),'View')])[2]")
	private WebElement viewChangeButton;
	
	@FindBy(xpath="(//span[contains(text(),'My Product Group')])[1]")
	private WebElement firstMyProductGroup;
	
	@FindBy(xpath="//dl[@class='dropdown']/descendant::input[@type='text']")
	public WebElement myProductTextbox;
	
	@FindAll(value={@FindBy(xpath="//div[@class='checkToCompare']/descendant::span[@class='customCheckBox']")})
	private List<WebElement> compareCheckbox;

	
	@FindBy(xpath="//table")
	private WebElement compareTable;
	
	@FindBy(xpath="//h2[text()='Compare']")
	private WebElement compareHeader;
	
	@FindBy(xpath="//li[contains(text(),'Compare')]")
	private WebElement compareBreadCrump;
	
	@FindBy(xpath="//a[@id='cartQuickView']/img")
	private WebElement cartIcon;

	@FindBy(xpath="//div[@class='gridListSwitchWrap']/a[@id='listView']/b")
	private WebElement listViewButton;
	
	public HGHProductsListPageObjects verifyHeader(String searchText) {
		
		String productsHeader = "//b[contains(text(),'"+searchText+"')]";
		WebElement productHeaderLocator = driver.findElement(By.xpath(productsHeader));
		Waiting.explicitWaitVisibilityOfElement(productHeaderLocator, 15);
		Assert.assertEquals(productHeaderLocator.getText().trim().toLowerCase(), searchText.toLowerCase(),"products page search header is not displayed");
		return this;
		
	}


	public HGHProductsDetailsPageObjects clickOnFirstProduct() {
		Waiting.explicitWaitVisibilityOfElement(firstProduct, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",firstProduct);
		return new HGHProductsDetailsPageObjects();
	}


	public boolean verifyHeadingOfProduct(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(productDetailsBrandHeading, 15);
		boolean t = productDetailsBrandHeading.getText().trim().toUpperCase().contains(searchTextUpperCase);
		return t;
	}


	public HGHProductsListPageObjects verifyGridView() {
		Waiting.explicitWaitVisibilityOfElement(listOfProducts, 10);
		Assert.assertTrue(listOfProducts.getAttribute("class").equals("gridView"),"class name is not grid view");
		return this;
	}

	public HGHProductsListPageObjects verifyListView() {
	
		Waiting.explicitWaitVisibilityOfElement(listOfProducts, 10);
		
		Assert.assertTrue(listOfProducts.getAttribute("class").equals("listView"),"class name is not list view");
		return this;
	}


	public HGHProductsListPageObjects verifyListOfProducts() {
		Waiting.explicitWaitVisibilityOfElement(listOfProducts, 15);
		Assert.assertTrue(listOfProducts.isDisplayed(), "products are not displayed"); 
		return this;
	}


	public HGHProductsListPageObjects verifyAdvancedSearchSection() {
		Waiting.explicitWaitVisibilityOfElement(advancedSearchSection, 15);
		Assert.assertTrue(advancedSearchSection.isDisplayed(), "Advanced search section is not displayed");
		return this;
	}


	public HGHProductsListPageObjects verifyRefineSearchHeader() {
		Waiting.explicitWaitVisibilityOfElement(refineResults, 15);
		Assert.assertTrue(refineResults.isDisplayed(),"refine results header is not displayed") ;
		return this;
	}


	public HGHProductsListPageObjects verifyCategoryFilterSection() {
		Waiting.explicitWaitVisibilityOfElement(categoryFilterSection, 15);
	Assert.assertTrue(categoryFilterSection.isDisplayed(),"category Filter section is not displayed");
		return this;
	}


	public HGHProductsListPageObjects verifyBrandsFilterSection() {
		Waiting.explicitWaitVisibilityOfElement(brandsFilterSection, 15);
		Assert.assertTrue(brandsFilterSection.isDisplayed(),"brand Filter section is not displayed");
		return this;
	}


	public HGHProductsListPageObjects verifySortBySection() {
		Waiting.explicitWaitVisibilityOfElement(sortByFunctionality, 15);
		Assert.assertTrue(sortByFunctionality.isDisplayed(),"Sort By section is not displayed");
		return this;
	}


	public HGHProductsListPageObjects verifyNarrowSearchBox() {
		Waiting.explicitWaitVisibilityOfElement(narrowSearchTextBox, 15);
	Assert.assertTrue(narrowSearchTextBox.isDisplayed(),"narrow Search box is not displayed");
	return this;
	}


	public HGHProductsListPageObjects verifyCompareListLink() {
		Waiting.explicitWaitVisibilityOfElement(compareListLink, 15);
		Assert.assertTrue(compareListLink.isDisplayed(),"Compare List is not displayed");	
		return this;
	}


	public boolean verifyViewToggleButton() {
		Waiting.explicitWaitVisibilityOfElement(viewChangeButton, 15);
		boolean t = viewChangeButton.isDisplayed();
		return t;
	}


	public HGHProductsListPageObjects clickOnFirstMyProductGroup() {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",firstMyProductGroup);
		return this;
	}


	public void enterGroupName(String groupName) {
		Waiting.explicitWaitVisibilityOfElement(myProductTextbox, 10);
		myProductTextbox.sendKeys(groupName);
	}


public HGHProductsListPageObjects clickFirstTwoCompareCheckboxes() {
		
		for(int i=0;i<2;i++)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",compareCheckbox.get(i));
			
		}
		return this;
	}

	public HGHProductsListPageObjects clickOnCompare() {
		compareListLink.click();
		return this;
		
	}

	public HGHProductsListPageObjects verifyDisplayOfCompareTable() {
		Assert.assertTrue(compareTable.isDisplayed(),"compare table is not displayed");
		return this;
	}

	public HGHProductsListPageObjects verifyCompareHeaderAndBreampCrump() {
		Assert.assertTrue(compareBreadCrump.isDisplayed(),"compare bread crump is not displayed");
		Assert.assertTrue(compareHeader.isDisplayed(),"compare header is not displayed");
		return this;
		
	}



	

	public void clickOnCartIcon() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",cartIcon);
		
	}




	public HGHProductsListPageObjects clickOnChangeView() {
		listViewButton.click();
		return this;
		
	}


}
	
	
