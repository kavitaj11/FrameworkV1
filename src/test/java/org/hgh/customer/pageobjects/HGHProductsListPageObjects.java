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
   
	public HGHProductsListPageObjects(WebDriver driver){
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(driver, this);
		PageFactory.initElements(factory, this);
	}


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

	
	public boolean verifyHeader(String searchText) {
		
		String productsHeader = "//b[contains(text(),'"+searchText+"')]";
		WebElement productHeaderLocator = driver.findElement(By.xpath(productsHeader));
		Waiting.explicitWaitVisibilityOfElement(productHeaderLocator, 15);
		boolean t = productHeaderLocator.getText().trim().equalsIgnoreCase(searchText);
		return t;
		
	}


	public void clickOnFirstProduct() {
		Waiting.explicitWaitVisibilityOfElement(firstProduct, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",firstProduct);
	}


	public boolean verifyHeadingOfProduct(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(productDetailsBrandHeading, 15);
		boolean t = productDetailsBrandHeading.getText().trim().toUpperCase().contains(searchTextUpperCase);
		return t;
	}


	public boolean verifyGridView() {
		Waiting.explicitWaitVisibilityOfElement(listOfProducts, 10);
		boolean t = listOfProducts.getAttribute("class").equals("gridView");
		return t;
	}

	public boolean verifyListView() {
	
		Waiting.explicitWaitVisibilityOfElement(listOfProducts, 10);
		
		boolean t = listOfProducts.getAttribute("class").equals("listView");

		return t;
	}


	public boolean verifyListOfProducts() {
		Waiting.explicitWaitVisibilityOfElement(listOfProducts, 15);
		boolean t = listOfProducts.isDisplayed();
		return t;
	}


	public boolean verifyAdvancedSearchSection() {
		Waiting.explicitWaitVisibilityOfElement(advancedSearchSection, 15);
		boolean t = advancedSearchSection.isDisplayed();
		return t;
	}


	public boolean verifyRefineSearchHeader() {
		Waiting.explicitWaitVisibilityOfElement(refineResults, 15);
		boolean t = refineResults.isDisplayed();
		return t;
	}


	public boolean verifyCategoryFilterSection() {
		Waiting.explicitWaitVisibilityOfElement(categoryFilterSection, 15);
		boolean t = categoryFilterSection.isDisplayed();
		return t;
	}


	public boolean verifyBrandsFilterSection() {
		Waiting.explicitWaitVisibilityOfElement(brandsFilterSection, 15);
		boolean t = brandsFilterSection.isDisplayed();
		return t;
	}


	public boolean verifySortBySection() {
		Waiting.explicitWaitVisibilityOfElement(sortByFunctionality, 15);
		boolean t = sortByFunctionality.isDisplayed();
		return t;
	}


	public boolean verifyNarrowSearchBox() {
		Waiting.explicitWaitVisibilityOfElement(narrowSearchTextBox, 15);
	boolean t = narrowSearchTextBox.isDisplayed();
		return t;
	}


	public boolean verifyCompareListLink() {
		Waiting.explicitWaitVisibilityOfElement(compareListLink, 15);
		boolean t = compareListLink.isDisplayed();	
		return t;
	}


	public boolean verifyViewToggleButton() {
		Waiting.explicitWaitVisibilityOfElement(viewChangeButton, 15);
		boolean t = viewChangeButton.isDisplayed();
		return t;
	}


	public void clickOnFirstMyProductGroup() {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",firstMyProductGroup);
	}


	public void enterGroupName(String groupName) {
		Waiting.explicitWaitVisibilityOfElement(myProductTextbox, 10);
		myProductTextbox.sendKeys(groupName);
	}


public void clickFirstTwoCompareCheckboxes() {
		
		for(int i=0;i<2;i++)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",compareCheckbox.get(i));
			
		}
	}

	public void clickOnCompare() {
		compareListLink.click();
		
	}

	public boolean verifyDisplayOfCompareTable() {
		boolean t = compareTable.isDisplayed();
		return t;
	}

	public boolean verifyCompareHeader() {
		Assert.assertTrue(compareBreadCrump.isDisplayed());
		boolean t = compareHeader.isDisplayed();
		return t;
		
	}



	

	public void clickOnCartIcon() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",cartIcon);
		
	}




	


	public void checkWhetherItIsTheSameQuantity() {
		
		
	}


}
	
	
