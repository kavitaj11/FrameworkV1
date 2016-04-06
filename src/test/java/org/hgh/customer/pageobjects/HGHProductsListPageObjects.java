package org.hgh.customer.pageobjects;
import java.util.List;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.TestUtility;
import org.hgh.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class HGHProductsListPageObjects extends MainController
{
 
   Actions action = new Actions(driver);


	@FindBy(xpath="(//h5/a)[1]")
	private WebElement firstProduct;
	
	@FindAll(value={@FindBy(xpath="(//h5/a)")})
	private List<WebElement> allProductsNames;
	
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
	
	@FindBy(xpath="//a[@id='cartQuickView']/img")
	private WebElement cartIcon;

	@FindBy(xpath="//div[@class='gridListSwitchWrap']/a[@id='listView']/b")
	private WebElement listViewButton;
	
	@FindAll({@FindBy(xpath="//span[contains(.,'Call for Price')]/ancestor::ul/descendant::span[@class='customCheckBox']")})
	private List<WebElement> callForPriceCompareCheckBox;
	
	@FindBy(xpath="//span[@id='compareSpan']")
	private WebElement compareCount;
	
	@FindBy(xpath="//a[contains(.,'Clear List')]")
	private WebElement clearList;
	
	@FindBy(xpath="//dt[contains(.,'Brands')]/following-sibling::dd/descendant::button[@id='nSearchBtn']")
	private WebElement searchButtonForBrandFilter;
	
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

	public HGHProductsDetailsPageObjects clickOnSpecificProduct(int specificProduct) {
		Waiting.explicitWaitVisibilityOfElements(allProductsNames, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",allProductsNames.get(specificProduct-1));
		return new HGHProductsDetailsPageObjects();
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
		Waiting.explicitWaitVisibilityOfElement(firstMyProductGroup, 20);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",firstMyProductGroup);
		return this;
	}


	public HGHProductsListPageObjects enterGroupName(String groupName) {
		Waiting.explicitWaitVisibilityOfElement(myProductTextbox, 20);
		myProductTextbox.sendKeys(groupName);
		return this;
	}

	public HGHProductsListPageObjects hitEnterForGroupCreation() {
		myProductTextbox.sendKeys(Keys.ENTER);
		return this;
	}

public HGHProductsListPageObjects clickCompareCheckboxes(int numberOfCheckBoxesToBeClicked) {
		
		for(int i=0;i<numberOfCheckBoxesToBeClicked;i++)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",compareCheckbox.get(i));
			
		}
		return this;
	}

	public HGHProductsListPageObjects clickOnCompare() {
		compareListLink.click();
		return this;
		
	}
	
	public HGHProductsListPageObjects clickOnCartIcon() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",cartIcon);
		return this;
		
	}

	public HGHProductsListPageObjects clickOnChangeView() {
		Waiting.explicitWaitVisibilityOfElement(listViewButton, 20);
		listViewButton.click();
		return this;
		
	}


	public HGHProductsListPageObjects verifyAlertMessageForComparingMoreThan3Items(String expectedAlertMessageForComaringMoreThan3Items) {
		Waiting.explicitWaitForAlert(15);
		Assert.assertEquals(TestUtility.getAlertText().trim(),expectedAlertMessageForComaringMoreThan3Items,"getting wrong alert message. "+TestUtility.getAlertText()+" . ");
		TestUtility.alertAccept();
		return this;
		
	}


	public HGHProductsListPageObjects clickOnCompareWhoseProductsPriceIsCallForPrice(int numberOfCheckBoxesToBeClicked) {
		for(int i=0;i<numberOfCheckBoxesToBeClicked;i++)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",callForPriceCompareCheckBox.get(i));
			
		}
		return this;
		
	}


	public HGHProductsListPageObjects checkCompareCount(int checkCount) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String compareCountBuffer = compareCount.getText().replace("Item(s)", "").trim();
		int compareCount = Integer.parseInt(compareCountBuffer);
		Assert.assertEquals(compareCount,checkCount,"Compare count is wrong."+compareCount);
		return this;
	}


	public HGHProductsListPageObjects clickOnASpecificCompareChecbox(int checkboxNumber) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",compareCheckbox.get(checkboxNumber-1));
		
		return this;
	}


	public HGHProductsListPageObjects clickOnClearList() {
		Waiting.explicitWaitVisibilityOfElement(clearList, 6);
		clearList.click();
		return this;
	}


	public HGHProductsListPageObjects verifyClearListFunctionality() {
		Waiting.explicitWaitForAlert(5);
		Assert.assertEquals(TestUtility.getAlertText(), "Item(s) removed from compare list.");
		TestUtility.alertAccept();
		checkCompareCount(0);
		return this;
	}


	public HGHProductsListPageObjects verifyClearListFunctionalityWhenNoItemsAreThereForComparing() {
		
		Waiting.explicitWaitForAlert(5);
		Assert.assertEquals(TestUtility.getAlertText(), "No Item in Compare List.");
		TestUtility.alertAccept();
		return this;
		
	}


	public HGHProductsListPageObjects selectSpecificFilter(int specificFilterNumber) {
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


	public HGHProductsListPageObjects clickOnSearchFilterButton() {
		searchButtonForBrandFilter.click();
		return this;
	}
}
	
	
