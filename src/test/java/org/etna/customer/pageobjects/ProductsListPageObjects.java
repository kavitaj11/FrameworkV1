package org.etna.customer.pageobjects;
import java.util.List;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class ProductsListPageObjects extends MainController
{
 SearchDataPropertyFile data = new SearchDataPropertyFile();
   Actions action = new Actions(driver);
	
	@FindBy(xpath="//p[@class='cimm_productDetailBrand']")
	private WebElement productDetailsBrandHeading;


	@FindAll(@FindBy(xpath="//li[@id='getchangemode']"))
	private List<WebElement> listOfProductsLocator;

	@FindBy(xpath="//div[@class='gridListControler']")
	private WebElement changeViewButtonLocator;
	
	@FindBy(xpath="//div[@class='searchResults']/h2")
	private WebElement searchResultsHeaderLocator;
	
	@FindBy(xpath="//div[@class='searchResults']/p")
	private WebElement searchResultsSectionOnTopLocator;
	
	@FindBy(xpath="//a[contains(text(),'Advanced Search')]")
	private WebElement advancedSearchLinkLocator;
	
	@FindBy(xpath="//div[@class='cimm_leftMenuEnclosure']")
	public WebElement filterSectionLocator;
	
	@FindBy(xpath="//input[@id='narrowText']")
	private WebElement filterSearchTextLocator;
	
	@FindBy(xpath="//button[@id='nSearchBtn']")
	private WebElement filterSearchButtonLocator;
	
	@FindBy(xpath="//h3[contains(text(),'Refine Results')]")
	private WebElement filterRefineResultsHeadingLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Category')]/following-sibling::span")
	public WebElement filterCategoryDropdownToggleButtonLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Category')]")
	public WebElement filterCategoryHeadingLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Brands')]/following-sibling::span")
	public WebElement filterBrandsDropdownToggleButtonLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Brands')]")
	public WebElement filterBrandsHeadingLocator;
	
	@FindAll(value={@FindBy(xpath="//dl[@id='bulkAction']/dd/descendant::li/descendant::span")})
	private List<WebElement> addDropdownLocator;
	
	
	@FindAll(value={@FindBy(css="select[id='sortBy']>option")})
	private List<WebElement> sortByDropdownOptionsLocator;
	
	@FindAll(value={@FindBy(css="select[id='resultPerPage']>option")})
	private List<WebElement> resultsPerPageDropdownOptionsLocator;
	
	@FindBy(xpath="//a[@onclick='compareItems();']")
	private WebElement compareLinkLocator;
	
	@FindAll(value={@FindBy(xpath="//span[contains(text(),'My Product Groups')]")})
	private List<WebElement> myProductGroupsLocator;
	
	@FindBy(id="resultPerPage")
	private WebElement resultsPerPageDrodownLocator;
	
	@FindBy(id="sortBy")
	private WebElement sortByDrodownLocator;
	
	@FindAll(value={@FindBy(xpath="//a[@class='log-addTocart-btn addToCart']/ancestor::li[@class='sessionDesp']/descendant::h4/a")})
	private List<WebElement> items;
	
	public ProductsListPageObjects verifyHeader(String searchText) {
		String productsHeader = "//b[contains(text(),'"+searchText+"')]";
		WebElement productHeaderLocator = driver.findElement(By.xpath(productsHeader));
		Waiting.explicitWaitVisibilityOfElement(productHeaderLocator, 15);
		Assert.assertEquals(productHeaderLocator.getText().trim().toLowerCase(), searchText.toLowerCase(),"products page search header is not displayed");
		return this;
		
	}


	public ProductsListPageObjects verifyGridView() {
		Waiting.explicitWaitVisibilityOfElements(listOfProductsLocator, 10);
		for(int i=0;i<listOfProductsLocator.size();i++)
		{
		Assert.assertTrue(listOfProductsLocator.get(i).getAttribute("class").equals("gridView"),"class name is not grid view");
		
	}
		return this;
	}
	public ProductsListPageObjects verifyListView() {
	
		Waiting.explicitWaitVisibilityOfElements(listOfProductsLocator, 10);
		for(int i=0;i<listOfProductsLocator.size();i++)
		{
		Assert.assertTrue(listOfProductsLocator.get(i).getAttribute("class").equals("listView"),"class name is not list view");
		}
		return this;
	}


	public ProductsListPageObjects verifyListOfProducts() {
		Waiting.explicitWaitVisibilityOfElements(listOfProductsLocator, 15);
		for(int i=0;i<listOfProductsLocator.size();i++)
		{
		Assert.assertTrue(listOfProductsLocator.get(i).isDisplayed(), "products are not displayed"); 
		}
		return this;
	}
	

	public ProductsListPageObjects clickOnChangeView() {
		Waiting.explicitWaitVisibilityOfElement(changeViewButtonLocator, 20);
		changeViewButtonLocator.click();
		return this;
		
	}


	public ProductsListPageObjects verifyAlertMessageForComparingMoreThan3Items(String expectedAlertMessageForComaringMoreThan3Items) {
		Waiting.explicitWaitForAlert(15);
		Assert.assertEquals(TestUtility.getAlertText().trim(),expectedAlertMessageForComaringMoreThan3Items,"getting wrong alert message. "+TestUtility.getAlertText()+" . ");
		TestUtility.alertAccept();
		return this;
		
	}


	public ProductsListPageObjects verifyClearListFunctionalityWhenNoItemsAreThereForComparing() {
		
		Waiting.explicitWaitForAlert(5);
		Assert.assertEquals(TestUtility.getAlertText(), "No Item in Compare List.");
		TestUtility.alertAccept();
		return this;
		
	}


	public ProductsListPageObjects selectSpecificFilter(int specificFilterNumber) {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		WebElement specificFilter = driver.findElement(By.xpath("(//dt[contains(.,'Brands')]/following-sibling::dd/descendant::ol/li)["+specificFilterNumber+"]/descendant::span[@class='customCheckBox']"));
		specificFilter.click();
		return this;
	}


	public String getFilterName(int specificFilterNumber) {
		String specficFilterName = "(//dt[contains(.,'Brands')]/following-sibling::dd/descendant::ol/li)[1]/descendant::span[@class='customCheckBox']";
		String nameOfTheFilter = driver.findElement(By.xpath(specficFilterName)).getText().trim();
		return nameOfTheFilter;
	}


	public ProductsListPageObjects verifySearchHeader(String searchText) {
		Assert.assertEquals(searchResultsHeaderLocator.getText().toLowerCase().replace("search results for: ","").trim(),searchText.toLowerCase());
		return this;
	}


	public ProductsListPageObjects verifySearchSection() {
		String actual = searchResultsSectionOnTopLocator.getText().replace("\n","").trim();
		Assert.assertTrue(assertSearchSection(actual));
		Assert.assertTrue(advancedSearchLinkLocator.isDisplayed(),"advanced search link is not displayed in the serach section.");
		return this;
	}
	
	public boolean assertSearchSection(String actual){
		String toGetInteger = actual.replace("We found", "").replace("results for true fitNot finding what you want, try our Advanced Search.", "");
		boolean t = (actual.contains("We found")&& actual.contains("results for true fitNot finding what you want, try our Advanced Search.") && toGetInteger.trim().matches("\\d+"));
		return t;
	}

	public ProductsListPageObjects verifyFilterSection() {
		Assert.assertTrue(filterSectionLocator.isDisplayed(), "filter section is not displayed");
		Assert.assertTrue(filterSearchTextLocator.isDisplayed());
		Assert.assertTrue(filterSearchButtonLocator.isDisplayed());
		Assert.assertTrue(filterRefineResultsHeadingLocator.isDisplayed());
		Assert.assertTrue(filterCategoryDropdownToggleButtonLocator.isDisplayed());
		Assert.assertTrue(filterCategoryHeadingLocator.isDisplayed());
		Assert.assertTrue(filterBrandsDropdownToggleButtonLocator.isDisplayed());
		return this;
	}
	
	public ProductsListPageObjects verifyCompareLinkLocator() {
		Assert.assertTrue(compareLinkLocator.isDisplayed());
		return this;
	}


	public ProductsListPageObjects clickOnMyProductGroup(int specificProductGroup) {
		myProductGroupsLocator.get(specificProductGroup-1).click();
		return this;
	}


	public ProductsListPageObjects verifyAddDropdown() throws Exception{
		for(int i=0 ;i<addDropdownLocator.size();i++)
		{
			System.out.println(addDropdownLocator.get(i).getText().trim());
		}
		return this;
	}
	
	public ProductsListPageObjects verifySortByDropdown() throws Exception{
		String [] expectedSortByOptions = data.getExpectedSortByOptions().split(",");
		for(int i=0 ;i<sortByDropdownOptionsLocator.size();i++)
		{
		Assert.assertEquals(sortByDropdownOptionsLocator.get(i).getText().trim(),expectedSortByOptions[i]);
		}
		return this;
	}


	public ProductsListPageObjects verifyResultsPerPageDropdown() {
		String [] expectedResultsPerPageOptions = data.getExpectedResultsPerPageOptions().split(",");
		for(int i=0 ;i<resultsPerPageDropdownOptionsLocator.size();i++)
		{
		Assert.assertEquals(Integer.parseInt(resultsPerPageDropdownOptionsLocator.get(i).getText().trim()),Integer.parseInt(expectedResultsPerPageOptions[i]));
		}
		return this;
	}


	public ProductsListPageObjects verifyShowItemsPerPage(int showItemsPerPage) throws Exception {
		Select select = new Select(resultsPerPageDrodownLocator);
		select.selectByValue(Integer.toString(showItemsPerPage));
		Thread.sleep(1500);
		Assert.assertTrue(verifyNoOfItemsDisplayedIsLessThanOrEqualToTheNumberOfItemsSelected(showItemsPerPage),"number of items in the page is NOT less than or equal ");
		return this;
		
	}


	private boolean verifyNoOfItemsDisplayedIsLessThanOrEqualToTheNumberOfItemsSelected(int showItemsPerPage) {
		if(listOfProductsLocator.size()<=showItemsPerPage)
		{
			return true;
		}
		else
		{
		return false;
	}
}


	public ProductsListPageObjects clickOnSpecificItem(int specificItemNumber) {
		items.get(specificItemNumber-1).click();
		return this;
	}
}	
	
