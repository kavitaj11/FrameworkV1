package org.etna.customer.pageobjects;
import java.util.List;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
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

	@FindBy(className="cimm_prodDetailTitle")
	private WebElement itemTitleLocator;

	@FindBy(xpath="//input[@class='quantity']")
	public WebElement quantityTextbox;
	
	@FindBy(xpath="//a[@class='log-addTocart-btn addToCart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="(//a[contains(text(),'Checkout')])[2]")
	private WebElement checkoutButton;
	
	@FindBy(className="cimm_itemShortDesc")
	private WebElement shortDescriptionLocator;
	
	@FindBy(xpath="//span[contains(text(),'MPN')]/following-sibling::span")
	private WebElement mpnValue;
	
	@FindBy(xpath="//li[@id='mPartNo']/b")
	private WebElement mpnLabel;
	
	@FindBy(xpath="//span[contains(.,'My Product Group')]")
	private WebElement myProductGroupButton;
	
	@FindBy(xpath="//span[contains(text(),'Customer Part Number')]/ancestor::a")
	private WebElement addOrRemoveCustomerPartNumberButton;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='resp-tabs-list domtabs']/descendant::span")})
	private List<WebElement> productDetailsTabs;
	
	@FindBy(xpath="//a[@title='Send this Page']")
	private WebElement sendThisPageLink;
	
	@FindBy(xpath="//a[@title='Print this page']")
	private WebElement printThisPageLink;
	
	@FindBy(xpath="//li[@id='sitePartNo']/b")
	private WebElement partNumberLabel;
	
	@FindBy(xpath="//li[@id='minOrdQty']/b")
	private WebElement minimumOrderQuantityLabel;
	
	@FindBy(xpath="//li[@id='qtyInt']/b")
	private WebElement quantityIntervalLabel;
	
	@FindBy(xpath="//div[@id='ProdRating']")
	private WebElement proRatingLabel;

	@FindBy(xpath="//li[@class='hideForPrint']/b")
	private WebElement quantityLabel;
	
	@FindBy(xpath="//div[@id='yourPrices']/b")
	private WebElement yourPriceLabel;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/li")})
	private List<WebElement> breadCrumps;
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]/following-sibling::span")
	private WebElement filterManufactureresToggleButtonLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]")
	private WebElement filterManufacturersHeading;
	
	@FindBy(xpath="//b[contains(text(),'Print')]/ancestor::a")
	private WebElement printLink;
	
	@FindBy(xpath="//b[contains(text(),'Share')]/ancestor::a")
	private WebElement shareLink;
	
	@FindAll(value={@FindBy(xpath="//div[@class='productAccordionWrap']/descendant::li/descendant::span")})
	private List<WebElement> accordiansLocator;
	
	@FindBy(xpath="//span[contains(text(),'My Product Group')]")
	private WebElement addToMyProductGroupButton;
	
	@FindBy(xpath="//li[@id='shipBranchNames']/b")
	private WebElement shipBranchNameLabel;
	
	@FindBy(xpath="//li[@id='upcNo']/b")
	private WebElement upcLabel;
	
	@FindBy(xpath="//a[@class='imgEnlargeIcon']")
	private WebElement enlargeIcon;
	
	@FindBy(xpath="//a[@class='imgEnlargeIcon']/preceding-sibling::a/descendant::div[@class='zoomPad']/img")
	private WebElement productImage;
	
	@FindBy(xpath="//img[@id='fullResImage']")
	private WebElement fullProductImage;
	
	public ProductsDetailsPageObjects verifyDisplayOfItemName(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(itemTitleLocator, 5);
		Assert.assertTrue(itemTitleLocator.getText().trim().toUpperCase().contains(searchTextUpperCase.replace(" ", "")),"product brand name does not contain the search text. Item name from web : "+itemTitleLocator.getText().trim().toUpperCase()+". "+"Expected is : "+searchTextUpperCase);
		return this;
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

	public ProductsDetailsPageObjects verifyDisplayOfShortDescription(String searchText)
	{
		
		Assert.assertTrue(assertDisplayOfShortDescription(searchText), "short description does not contain the search text. Actual : "+shortDescriptionLocator.getText().trim()+".");
		return this;
		
	}
	
	public boolean assertDisplayOfShortDescription(String searchText) {
		boolean t = shortDescriptionLocator.getText().trim().toUpperCase().contains(searchText.toUpperCase().replace(" ", ""));
		return t;
	}


	public ProductsDetailsPageObjects verifyDisplayOfPartNumber() {
		Assert.assertEquals(partNumberLabel.getText().replace(":","").trim(),"PN");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfMPN() {
		Assert.assertEquals(mpnLabel.getText().replace(":","").trim(), "MPN");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfMinimumOrderQuantity() {
		Assert.assertEquals(minimumOrderQuantityLabel.getText().replace(":","").trim(), "Min. Order Qty");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfQuantityInterval() {
		Assert.assertEquals(quantityIntervalLabel.getText().replace(":","").trim(), "Qty. Interval");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfYourPrice() {
		Assert.assertEquals(yourPriceLabel.getText().replace(":","").trim(), "Your Price");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfQuantity() {
		Assert.assertEquals(quantityLabel.getText().replace(":","").trim(), "Qty");
		
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfPrintLink() {
		Assert.assertTrue(printLink.isDisplayed());
		return this;
	}
	
	public ProductsDetailsPageObjects verifyToolTipOfPrintLink() {
	TestUtility.verifyToolTip(printLink,"Print this page");
	return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfShare() {
		Assert.assertTrue(shareLink.isDisplayed());
		return this;
	}
	
	public ProductsDetailsPageObjects verifyToolTipOfShareLink() {
		TestUtility.verifyToolTip(shareLink,"Send this Page");
		return this;
		}


	public ProductsDetailsPageObjects verifyDisplayOfAccordians() {
		Assert.assertTrue(assertAccordiansLocator());
		return this;
		
	}


	private boolean assertAccordiansLocator() {
		if(accordiansLocator.size()>=1)
		{
			return true;
		}
		else
		{
			return false;
	}
}


	public ProductsDetailsPageObjects verifyDisplayOfCustomerPartNumberButton() {
		Assert.assertTrue(addOrRemoveCustomerPartNumberButton.isDisplayed(),"add or remove customer part number is not displayed.");
		return this;
	}


	public ProductsDetailsPageObjects verifyAddToCartButton() {
		
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfAddMyProductGroupButton() {
		Assert.assertTrue(addToMyProductGroupButton.isDisplayed(),"add to my product group button is not displayed.");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfShipBranchName() {
		Assert.assertEquals(shipBranchNameLabel.getText().replace(":","").trim(), "Ship Branch Name");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfUPC() {
		Assert.assertEquals(upcLabel.getText().replace(":","").trim(), "UPC");
		return this;
	}


	public ProductsDetailsPageObjects clickOnEnlargeIcon() {
		Waiting.explicitWaitVisibilityOfElement(enlargeIcon, 10);
		enlargeIcon.click();
		return this;
	}


	public int getHeightOfTheImage() {
		int height = Integer.parseInt(productImage.getAttribute("height"));
		System.out.println(height);
		return height;
	}
	
	public int getWidthOfTheImage() {
		
		int width = Integer.parseInt(productImage.getAttribute("width"));
		System.out.println(width);
		return width;
	}


	public ProductsDetailsPageObjects verifyImageHeightAndWidthAfterEnlarge(int height,int width) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertTrue(assertImageHeight(height));
		Assert.assertTrue(assertImageWidth(width));
		return this;
		
	}


	private boolean assertImageWidth(int height) {
		int actualHeight = Integer.parseInt(fullProductImage.getAttribute("height").replace("px", "").trim());
		System.out.println(actualHeight);
		System.out.println(height);
		if(actualHeight>=height)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	private boolean assertImageHeight(int width) {
		int actualwidth = Integer.parseInt(fullProductImage.getAttribute("width").replace("px", "").trim());
		if(actualwidth>=width)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
}
	
