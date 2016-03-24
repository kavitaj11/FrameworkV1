package org.hgh.customer.pageobjects;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class HGHProductsDetailsPageObjects extends MainController{
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
	
	
	

	public HGHProductsDetailsPageObjects verifyHeadingOfProduct(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(productDetailsBrandHeading, 5);
		Assert.assertTrue(productDetailsBrandHeading.getText().trim().toUpperCase().contains(searchTextUpperCase),"product brand name is not contain the search text");
		return this;
	}



	public HGHProductsDetailsPageObjects addDifferentQuantity(String quantity) {
		quantityTextbox.clear();
		quantityTextbox.sendKeys(quantity);
		return this;
	}
	
	public HGHProductsDetailsPageObjects clickOnAddToCart() {
		Waiting.explicitWaitVisibilityOfElement(addToCartButton, 10);
		addToCartButton.click();
		return this;
	}


	public HGHShoppingCartPageObjects clickOnCheckout() {
		Waiting.explicitWaitVisibilityOfElement(checkoutButton, 5);
		checkoutButton.click();
		return new HGHShoppingCartPageObjects();
		
	}


	
	
	
}
	
	
