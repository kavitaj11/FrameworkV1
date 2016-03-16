package org.hgh.customer.pageobjects;
import java.util.List;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Hemanth.Sridhar
 */
public class HGHProductsListPageObjects extends MainController{
   Actions action = new Actions(driver);
   
	public HGHProductsListPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
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
	
	public boolean verifyHeader(String searchText) {
		
		String productsHeader = "//b[contains(text(),'"+searchText+"')]";
		WebElement productHeaderLocator = driver.findElement(By.xpath(productsHeader));
		Waiting.explicitWaitVisibilityOfElement(productHeaderLocator, 5);
		boolean t = productHeaderLocator.getText().trim().equalsIgnoreCase(searchText);
		return t;
		
	}


	public void clickOnFirstProduct() {
		Waiting.explicitWaitVisibilityOfElement(firstProduct, 5);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",firstProduct);
	}


	public boolean verifyHeadingOfProduct(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(productDetailsBrandHeading, 5);
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
		
		boolean t = listOfProducts.getAttribute("class").equals("gridView");

		return t;
	}


	public boolean verifyListOfProducts() {
		boolean t = listOfProducts.isDisplayed();
		return t;
	}


	public boolean verifyAdvancedSearchSection() {
		boolean t = advancedSearchSection.isDisplayed();
		return t;
	}


	public boolean verifyRefineSearchHeader() {
		boolean t = refineResults.isDisplayed();
		return t;
	}


	public boolean verifyCategoryFilterSection() {
		boolean t = categoryFilterSection.isDisplayed();
		return t;
	}


	public boolean verifyBrandsFilterSection() {
		boolean t = brandsFilterSection.isDisplayed();
		return t;
	}


	public boolean verifySortBySection() {
		boolean t = sortByFunctionality.isDisplayed();
		return t;
	}


	public boolean verifyNarrowSearchBox() {
	boolean t = narrowSearchTextBox.isDisplayed();
		return t;
	}

}
	
	
