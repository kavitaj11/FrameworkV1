package org.etna.customer.pageobjects;
import java.util.List;






import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class ProductsDetailsPageObjects extends MainController{
   Actions action = new Actions(driver);

SearchDataPropertyFile data = new SearchDataPropertyFile();

	@FindBy(xpath="//p[@class='cimm_productDetailBrand']")
	private WebElement productDetailsBrandHeading;

	@FindBy(xpath="//input[@class='quantity']")
	public WebElement quantityTextbox;
	
	@FindBy(xpath="//a[@class='log-addTocart-btn addToCart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="(//a[contains(text(),'Checkout')])[2]")
	private WebElement checkoutButton;
	
	@FindBy(xpath="//ul[@id='productDetailList']/descendant::h2")
	private WebElement productTitleLocator;
	
	@FindBy(xpath="//span[contains(text(),'MPN')]/following-sibling::span")
	private WebElement mpnValue;
	
	@FindBy(xpath="//a[@id='reviewbox']")
	private WebElement writeAReview;
	
	@FindBy(xpath="//span[contains(text(),'MPN')]")
	private WebElement mpnLabel;
	
	@FindBy(xpath="//span[contains(.,'My Product Group')]")
	private WebElement myProductGroupButton;
	
	@FindBy(xpath="//span[contains(text(),'Add / Remove Customer')]")
	private WebElement addOrRemoveCustomerPartNumberButton;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='resp-tabs-list domtabs']/descendant::span")})
	private List<WebElement> productDetailsTabs;
	
	@FindBy(xpath="//a[@title='Send this Page']")
	private WebElement sendThisPageLink;
	
	@FindBy(xpath="//a[@title='Print this page']")
	private WebElement printThisPageLink;
	
	@FindBy(xpath="//span[contains(text(),'HGH Part')]")
	private WebElement hghPartNumberLabel;
	
	@FindBy(xpath="//span[contains(text(),'UPC')]")
	private WebElement upcLabel;
	
	@FindBy(xpath="//a[@id='clickforAllBranch']")
	private WebElement wareHouseDetailsButton;
	
	
	@FindBy(xpath="//span[contains(text(),'Availability')]")
	private WebElement  availabilityLabel;
	
	@FindBy(xpath="//span[contains(text(),'Total')]")
	private WebElement totalLabel;
	
	@FindBy(xpath="//span[contains(text(),'Minimum Order Quantity')]")
	private WebElement minimumOrderQuantityLabel;
	
	@FindBy(xpath="//span[contains(text(),'Quantity Interval')]")
	private WebElement quantityIntervalLabel;
	
	
	@FindBy(xpath="//span[contains(text(),'Quantity Interval')]")
	private WebElement soldAsLabel;
	
	@FindBy(xpath="//div[@id='ProdRating']")
	private WebElement stars;

	@FindBy(xpath="//b[contains(text(),'Qty')]")
	private WebElement quantityLabel;
	
	@FindBy(xpath="//b[contains(text(),'Your Price')]")
	private WebElement yourPriceLabel;
	
	@FindBy(xpath="//p[@class='cimm_itemShortDesc printDesc']")
	private WebElement itemDescription;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/li")})
	private List<WebElement> breadCrumps;
	
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]/following-sibling::span")
	public WebElement filterManufactureresToggleButtonLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]")
	public WebElement filterManufacturersHeading;
	
	public ProductsDetailsPageObjects verifyHeadingOfProduct(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(productDetailsBrandHeading, 5);
		Assert.assertTrue(productDetailsBrandHeading.getText().trim().toUpperCase().contains(searchTextUpperCase),"product brand name is not contain the search text");
		return this;
	}



	public ProductsDetailsPageObjects addDifferentQuantity(String quantity) throws InterruptedException {
		Thread.sleep(3000);
		quantityTextbox.clear();
		quantityTextbox.sendKeys(quantity);
		return this;
	}
	
	public ProductsDetailsPageObjects clickOnAddToCart() throws Exception {
		
		Waiting.explicitWaitVisibilityOfElement(addToCartButton, 10);
		addToCartButton.sendKeys(Keys.ENTER);;
		return this;
	}


	public ShoppingCartPageObjects clickOnCheckout() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(checkoutButton, 20);
		checkoutButton.click();
		return new ShoppingCartPageObjects();
		
	}



	public String productTitle() {
		Waiting.explicitWaitVisibilityOfElement(productTitleLocator, 10);
		String productTitle = productTitleLocator.getText().trim();
		return productTitle;
	}



	public String getMPN() {
		String mpnVal = mpnValue.getText().trim();
		return mpnVal;
	}



	public ProductsDetailsPageObjects verifyProductTitle(String productTitle)
	{
		Waiting.explicitWaitVisibilityOfElement(productTitleLocator, 10);
		Assert.assertEquals(productTitleLocator.getText().trim(), productTitle,"product Title is not the same as the it was in shopping cart page");
		return this;
	}

	

	public ProductsDetailsPageObjects verifyProductDetailsPage(String searchText) throws Exception {
		String [] productDetailsTabsArray = data.getProductDetailsTabs().split(",");
		verifyHeadingOfProduct(searchText);
		Waiting.explicitWaitVisibilityOfElement(writeAReview, 20);
		Assert.assertTrue(writeAReview.isDisplayed(), "write a review is not displayed.");
		Assert.assertTrue(mpnLabel.isDisplayed(),"mpn label is not displayed.");
		Waiting.explicitWaitVisibilityOfElement(addToCartButton, 20);
		Assert.assertTrue(addToCartButton.isDisplayed(), "Add to cart button is not displayed.");
		Assert.assertTrue(myProductGroupButton.isDisplayed(),"my productgroup button is not displayed");
		Assert.assertTrue(addOrRemoveCustomerPartNumberButton.isDisplayed(), "add or remove customer part number button is not displayed.");
		for(int i=0;i<productDetailsTabs.size();i++)
		{
		Assert.assertEquals(productDetailsTabs.get(i).getText().trim(), productDetailsTabsArray[i]);
		}
		Assert.assertTrue(sendThisPageLink.isDisplayed(), "send this page link is not present.");
		Assert.assertTrue(printThisPageLink.isDisplayed(),"print this page link is not present.");
		Assert.assertTrue(hghPartNumberLabel.isDisplayed(),"hgh part number label is not present");
		Assert.assertTrue(upcLabel.isDisplayed(),"UPC label is not present.");
		Assert.assertTrue(wareHouseDetailsButton.isDisplayed(),"ware House Details Button label is not present.");
		Assert.assertTrue(availabilityLabel.isDisplayed(),"availability label is not present.");
		Assert.assertTrue(totalLabel.isDisplayed(),"total label is not present.");
		Assert.assertTrue(minimumOrderQuantityLabel.isDisplayed(),"minimum Order Quantity Label is not present.");
		Assert.assertTrue(quantityIntervalLabel.isDisplayed(),"quantity Interval Label is not present.");
		Assert.assertTrue(soldAsLabel.isDisplayed(),"sold As Label is not present.");
		Assert.assertTrue(stars.isDisplayed(),"stars are not present.");
		Assert.assertTrue(quantityLabel.isDisplayed(),"quantity label is not present.");
		Assert.assertTrue(yourPriceLabel.isDisplayed(),"your Price Label is not present.");
		Assert.assertTrue(itemDescription.isDisplayed(), "item description is not displayed");
		int size = breadCrumps.size();
		Assert.assertEquals(breadCrumps.get(size-1).getText().trim(),productTitleLocator.getText().trim(),"last breadcrump and the product title are not the same");
		return this;
		
	}



	public ProductsDetailsPageObjects verifyProductTitleHasTheFilterChosen(String filterName) {
		Waiting.explicitWaitVisibilityOfElement(productTitleLocator, 10);
		Assert.assertTrue(checkFilterChosenAndProductTitle(filterName.toUpperCase()),"product Title does not contain the filter name that was chosen. Getting text from web "+productTitleLocator.getText().toUpperCase().trim()+"but expected : "+filterName.toUpperCase()+".");
		return this;
	}



	private boolean checkFilterChosenAndProductTitle(String filterName) {
		boolean t = productTitleLocator.getText().toUpperCase().trim().contains(filterName);
		return t;
	}



	public ProductsDetailsPageObjects verifyPDPFilterSection() {
		
		Assert.assertTrue(productListPage().filterSectionLocator.isDisplayed(), "Filter section is not displayed in the PDP page.");
		Assert.assertTrue(productListPage().filterCategoryDropdownToggleButtonLocator.isDisplayed(), "Filter category dropdown toggle button is not displayed.");
		Assert.assertTrue(productListPage().filterCategoryHeadingLocator.isDisplayed(), "Filter category heading is not displayed.");
		Assert.assertTrue(productListPage().filterBrandsDropdownToggleButtonLocator.isDisplayed(), "Filter brands dropdown toggle button is not displayed.");
		Assert.assertTrue(productListPage().filterBrandsHeadingLocator.isDisplayed(), "Filter brands heading is not displayed.");
		Assert.assertTrue(filterManufacturersHeading.isDisplayed(),"Manufacturers heading is not displayed.");
		Assert.assertTrue(filterManufactureresToggleButtonLocator.isDisplayed(),"Manufacturers heading is not displayed.");
		return this;
	}
}
	
	
