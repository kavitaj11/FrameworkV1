package org.etna.customer.pageobjects;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class ShoppingCartPageObjects extends MainController{
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	Actions action = new Actions(driver);

	@FindBy(xpath="(//a[text()='Empty Cart'])[1]")
	private WebElement emptyCartButton;

	@FindBy(xpath="//h4[text()='No items in your shopping cart']")
	private WebElement checkForEmptyCart;

	@FindBy(xpath="//a[contains(text(),'Continue Shopping')]")
	private WebElement continueShoppingButton;

	@FindBy(xpath="//dl/descendant::li/input[@type='text']")
	private WebElement saveCartTextbox;

	@FindBy(xpath="//a[@id='linkg0']")
	private WebElement saveCartButton;
	
	@FindBy(xpath="//li[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCartBreadCrump;
	
	@FindBy(xpath="//h2[contains(text(),'Shopping Cart')]")
	private WebElement shoppingCartHeading;
	
	@FindAll(value={@FindBy(xpath="(//div[@class='cimm_btnGroupEnclosure'])[1]/descendant::li")})
	private List<WebElement> shoppingCartFormButtonsOnTop;
	
	@FindAll(value={@FindBy(xpath="(//div[@class='cimm_btnGroupEnclosure'])[1]/descendant::li/a")})
	private List<WebElement> shoppingCartFormButtonsOnTopForButton;
	
	@FindAll(value={@FindBy(xpath="(//div[@class='cimm_btnGroupEnclosure'])[2]/descendant::li")})
	private List<WebElement> shoppingCartFormButtonsOnBottom;
	
	@FindAll(value={@FindBy(xpath="(//div[@class='cimm_btnGroupEnclosure'])[2]/descendant::li/a")})
	private List<WebElement> shoppingCartFormButtonsOnBottomForButton;
	
	@FindBy(xpath="//div[@class='cimm_instructions']/ul")
	private WebElement shoppingCartPageInstructions;
	
	@FindBy(xpath="//input[@class='quantity']")
	private WebElement quantityInShoppingCartPage;
	
	@FindBy(xpath="(//a[contains(text(),'Update Cart')])[1]")
	private WebElement updateCartButton; 
	
	@FindBy(xpath="//b[contains(text(),'Ext Price')]/following-sibling::span")
	private WebElement extPriceInsideTheShoppingCart;
	
	@FindBy(xpath="//span[@class='priceValue']")
	private WebElement currentTotalPriceInShoppingCart;
	
	@FindBy(xpath="(//b[contains(text(),'Price')]/following-sibling::span)[1]")
	private WebElement priceInShoppingCart;
	
	@FindBy(xpath="//h4")
	private WebElement noItemsInYourShoppingCart;
	
	@FindBy(xpath="//i[@class='fa fa-lg fa-trash']/ancestor::a")
	private WebElement deleteButton;
	
	@FindBy(xpath="//i[@class='fa fa-lg fa-refresh']/ancestor::a")
	private WebElement refreshButton;
	
	@FindBy(xpath="//div[@class='cimm_cartProdDescription']/descendant::h2[@class='cimm_prodDetailTitle cimm_pageTitle clear']")
	private WebElement productTitleLocator;
	
	@FindBy(xpath="//div[@class='cimm_cartProdImg']/a")
	private WebElement imageLink;
	
	@FindBy(xpath="//a[contains(text(),'More')]")
	private WebElement moreLink;
	
	@FindBy(xpath="//select[@id='sortBy']")
	private WebElement sortByDropdown;
	
	@FindAll(value={@FindBy(xpath="//select[@id='sortBy']/option")})
	private List<WebElement> selectByDropdownValues;
	
	@FindBy(xpath="(//a[contains(text(),'Continue Checkout')])[1]")
	private WebElement continueCheckout;
	
	@FindBy(xpath="//textarea[@id='shippingInstruction']")
	private WebElement shippingInstructions;
	
	public ShoppingCartPageObjects clickOnEmptyCartButton(){
		Waiting.explicitWaitVisibilityOfElement(emptyCartButton, 15);
		emptyCartButton.click();
		return this;
	}

	public boolean clearCart() throws InterruptedException {
		navigateToShoppingCart();
		try
		{
			if(checkForEmptyCart.isDisplayed())
			{
				clickContinueShopping();
			}
		}
		catch(NoSuchElementException e)
		{
			clickOnEmptyCartButton();
			Waiting.explicitWaitForAlert(5);
			TestUtility.alertAccept();
			return true;
		}
		return true;
	}

	public ProductCategoryPageObjects clickContinueShopping() {
		continueShoppingButton.click();
		return new ProductCategoryPageObjects();
	}

	public void navigateToShoppingCart() throws InterruptedException {
		productListPage().clickOnCartIcon();
		productDetailsPage().clickOnCheckout();
		
	}
	
	public ShoppingCartPageObjects enterNameOfSaveCartAndAddTheProductToSaveCart(String saveCartName) {
		Waiting.explicitWaitVisibilityOfElement(saveCartTextbox, 15);
		saveCartTextbox.sendKeys(saveCartName);
		return this;
	}
	
	public ShoppingCartPageObjects hitEnterForSaveCartCreation() {
		Waiting.explicitWaitVisibilityOfElement(saveCartTextbox, 15);
		saveCartTextbox.sendKeys(Keys.ENTER);
		return this;
	}
	
	public ShoppingCartPageObjects clickOnSaveCart() {
		Waiting.explicitWaitVisibilityOfElement(saveCartButton, 15);
		saveCartButton.click();
		return this;
	}

	public ShoppingCartPageObjects checkWhetherItIsTheSameQuantity(String quantity) {
		Assert.assertEquals(productDetailsPage().quantityTextbox.getAttribute("value"),quantity,productDetailsPage().quantityTextbox.getAttribute("value"));
		return this;
	}

	public ShoppingCartPageObjects verifyShoppingCartBreadCrump() {
		Waiting.explicitWaitVisibilityOfElement(shoppingCartBreadCrump, 20);
		Assert.assertTrue(shoppingCartBreadCrump.isDisplayed(), "shopping breadcrump page heading is not displayed");
		return this;
	}

	public ShoppingCartPageObjects verifyShoppingCartPageHeading() {
		Assert.assertTrue(shoppingCartHeading.isDisplayed(),"shopping cart page heading is not displayed");
		return this;
	}

	public ShoppingCartPageObjects verifyContinueShoppingButton() throws Exception
	{
		Waiting.explicitWaitVisibilityOfElement(continueShoppingButton, 10);
		Assert.assertTrue(continueShoppingButton.isDisplayed());
		return this;
	}

	public ShoppingCartPageObjects verifyButtonsOnTopOfTheCart() throws Exception {
		String nameOfShoppingCartButtonsArray[] = data.getNameOfShoppingCartButtons().split(",");
		for(int i=0;i<shoppingCartFormButtonsOnTopForButton.size();i++)
		{
		Assert.assertEquals(shoppingCartFormButtonsOnTopForButton.get(i).getAttribute("class"),"button",shoppingCartFormButtonsOnTop.get(i).getText()+" is not a button");
		Assert.assertEquals(shoppingCartFormButtonsOnTop.get(i).getText().trim().replace("\n", ""),nameOfShoppingCartButtonsArray[i].trim());	
		}
		return this;
	}

	public ShoppingCartPageObjects verifyButtonsOnBottomOfTheCart() throws Exception {
		String nameOfShoppingCartButtonsArray[] = data.getNameOfShoppingCartButtons().split(",");
		for(int i=0;i<shoppingCartFormButtonsOnBottomForButton.size();i++)
		{
		Assert.assertEquals(shoppingCartFormButtonsOnBottomForButton.get(i).getAttribute("class"),"button",shoppingCartFormButtonsOnBottom.get(i).getText()+" is not a button");
		Assert.assertEquals(shoppingCartFormButtonsOnBottom.get(i).getText().trim().replace("\n", ""),nameOfShoppingCartButtonsArray[i].trim());	
		}
		return this;
	}

	public ShoppingCartPageObjects verifyShoppingCartPageInstructions() throws Exception {
		String shoppingCartInstructions = data.getShoppingCartInstructions();
		Assert.assertEquals(shoppingCartPageInstructions.getText().replace("\n", "").trim(), shoppingCartInstructions);
		return this;
	}

	public ShoppingCartPageObjects enterQuantityInShoppingCart(String quantity) {
		Waiting.explicitWaitVisibilityOfElement(quantityInShoppingCartPage, 20);
		quantityInShoppingCartPage.click();
		quantityInShoppingCartPage.clear();
		quantityInShoppingCartPage.sendKeys(quantity);
		return this;
		
	}

	public ShoppingCartPageObjects clickOnUpdateCart() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",updateCartButton);
		return this;
	}

	public ShoppingCartPageObjects verifyUpdateOfQuantityInShoppingCart(String quantity) throws Exception {
		Thread.sleep(5000);
		Waiting.explicitWaitVisibilityOfElement(quantityInShoppingCartPage, 20);
		Assert.assertEquals(quantityInShoppingCartPage.getAttribute("value"), quantity,"Quantity in shopping cart page is not getting updated. The updated quantity is "+quantityInShoppingCartPage.getAttribute("value"));
		return this;
	}

	public ShoppingCartPageObjects verifyExtPrice(String quantity,Number previousExtensionPrice) throws Exception {
		Number afterUpdateExtensionPrice = NumberFormat.getCurrencyInstance(Locale.US).parse(extPriceInsideTheShoppingCart.getText().replace("\n", "").trim());
		int quantityValue = Integer.parseInt(quantity);
		Assert.assertTrue(checkForExtnPrice(previousExtensionPrice,afterUpdateExtensionPrice,quantityValue),"extension price is not getting updated");
		return this;
	}
	
	private boolean checkForExtnPrice(Number previousPrice,Number afterPrice,int quantityValue)
	{
		DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
		String previous = oneDigit.format(previousPrice.doubleValue()*quantityValue);
		System.out.println(previous);
		String after = oneDigit.format(afterPrice.doubleValue());
		System.out.println(after);
		if(previous.equals(after))
		{	
			return true;
		}
		return false;
	}

	public Number getExtensionPrice() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(extPriceInsideTheShoppingCart, 5);
		Number extPriceInsideTheShoppingCartValue = NumberFormat.getCurrencyInstance(Locale.US).parse(extPriceInsideTheShoppingCart.getText().replace("\n", "").trim());
		return extPriceInsideTheShoppingCartValue;
	}

	public Number getTotalPrice() throws ParseException {
		Waiting.explicitWaitVisibilityOfElement(currentTotalPriceInShoppingCart, 5);
		Number currentTotalPrice = NumberFormat.getCurrencyInstance(Locale.US).parse(currentTotalPriceInShoppingCart.getText().replace("\n", "").trim());
		return currentTotalPrice;
	}

	public ShoppingCartPageObjects verifyTotalPrice(String quantity, Number currentTotalPrice) throws ParseException {
		Number afterUpdateTotalPrice = NumberFormat.getCurrencyInstance(Locale.US).parse(currentTotalPriceInShoppingCart.getText().replace("\n", "").trim());
		int quantityValue = Integer.parseInt(quantity);
		Assert.assertTrue(checkForExtnPrice(currentTotalPrice,afterUpdateTotalPrice,quantityValue),"total price is not getting updated");
		return this;
	}

	public Number getPrice() throws ParseException {
		Waiting.explicitWaitVisibilityOfElement(priceInShoppingCart, 5);
		Number price = NumberFormat.getCurrencyInstance(Locale.US).parse(priceInShoppingCart.getText().replace("\n", "").trim());
		return price;
	}

	public ShoppingCartPageObjects verifyPrice(Number price) throws ParseException {
		Waiting.explicitWaitVisibilityOfElement(priceInShoppingCart, 10);
		Number afterUpdateTotalPrice = NumberFormat.getCurrencyInstance(Locale.US).parse(priceInShoppingCart.getText().replace("\n", "").trim());
		Assert.assertTrue(checkForPrice(price,afterUpdateTotalPrice), "price has been updated after updation of cart");
		return this;
	}

	private boolean checkForPrice(Number price,Number afterUpdateTotalPrice) {
		DecimalFormat oneDigit = new DecimalFormat("#,##0.0");
		String previous = oneDigit.format(price.doubleValue());
		System.out.println(previous);
		String after = oneDigit.format(afterUpdateTotalPrice.doubleValue());
		System.out.println(after);
		if(previous.equals(after))
		{	
			return true;
		}
		return false;
	}

	public ShoppingCartPageObjects enterQuantityFieldWithZero() {
		quantityInShoppingCartPage.clear();
		quantityInShoppingCartPage.click();
		quantityInShoppingCartPage.sendKeys("0");
		return this;
	}

	public ShoppingCartPageObjects verifyEmptyCart() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(noItemsInYourShoppingCart, 10);
		Assert.assertEquals(noItemsInYourShoppingCart.getText().trim(), data.getEmptyCartText());
		return this;
		
	}

	public ShoppingCartPageObjects hoverOverDeleteButton() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(deleteButton, 10);
		TestUtility.mouseHoverActions(deleteButton);
		return this;
	}

	public ShoppingCartPageObjects verifyDeleteToolTip() {
		Assert.assertEquals(deleteButton.getAttribute("title"), "Delete");
		return this;
		
	}

	public ShoppingCartPageObjects hoverOverRefreshButton() {
		Waiting.explicitWaitVisibilityOfElement(refreshButton, 10);
		TestUtility.mouseHoverActions(refreshButton);
		return this;
	}

	public ShoppingCartPageObjects verifyRefreshToolTip() {
		Assert.assertEquals(refreshButton.getAttribute("title"), "Refresh");
		return this;
		
	}

	public ShoppingCartPageObjects clickOnDeleteButton() {
		Waiting.explicitWaitVisibilityOfElement(deleteButton, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",deleteButton);
		return this;
		
	}

	public String getProductTitle() {
		String productTitleInShoppingCart = productTitleLocator.getText().trim();
		return productTitleInShoppingCart;
	}

	public ShoppingCartPageObjects verifyProductTitle(String productTitle, String productTitleInShoppingCart) {
		Assert.assertEquals(productTitle, productTitleInShoppingCart);
		return this;
	}

	public ShoppingCartPageObjects verifyDeleteItemThroughDeleteLink() {
		Waiting.explicitWaitVisibilityOfElement(checkForEmptyCart, 10);
		Assert.assertTrue(checkForEmptyCart.isDisplayed(),"no items to display is not displayed");
		return this;
	}

	public ShoppingCartPageObjects verifyDeleteAlertText(String MPN) throws Exception {
		Assert.assertEquals(TestUtility.getAlertText(), "You want to delete item "+MPN+" from cart?");
		
		return this;
	}
	
	public ProductsDetailsPageObjects clickOnImageOfTheProduct() {
		Waiting.explicitWaitVisibilityOfElement(imageLink, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",imageLink);
		return new ProductsDetailsPageObjects();
		
	}

	public ProductsDetailsPageObjects clickOnProductDescriptionMoreLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",moreLink);
		return new ProductsDetailsPageObjects();
	}

	public ShoppingCartPageObjects verifySaveCartCreationMessage(String saveCartName) {
		
		WebElement cartSaveMessage = driver.findElement(By.xpath("//a[contains(text(),'Cart Saved Successfully -"+saveCartName+"')]"));
		Waiting.explicitWaitVisibilityOfElement(cartSaveMessage, 10);
		Assert.assertTrue(cartSaveMessage.isDisplayed(),"cart save message is not coming");
		return this;
		
	}

	public ShoppingCartPageObjects clickOnTheConfirmationMessage(String saveCartName) {
		
		WebElement cartSaveMessage = driver.findElement(By.xpath("//a[contains(text(),'Cart Saved Successfully -"+saveCartName+"')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",cartSaveMessage);
		return this;		
	}

	public ShoppingCartPageObjects clickOnRefresh() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",refreshButton);
		return this;
	}

	public ShoppingCartPageObjects verifySortByDropdownValues() throws Exception {
		Waiting.explicitWaitVisibilityOfElement(sortByDropdown, 10);
		String dropdownValues[] = data.getSortByShoppingCartDropdownValues().split(",");
		for(int i=0;i<selectByDropdownValues.size();i++)
		{
			Assert.assertEquals(selectByDropdownValues.get(i).getText().trim(), dropdownValues[i]);
		}
		return this;	
	}

public CheckoutPageObjects clickOnContinueCheckout() {
		
		Waiting.explicitWaitVisibilityOfElement(continueCheckout, 20);
		continueCheckout.sendKeys(Keys.ENTER);;
		return new CheckoutPageObjects();
		
}
}

	
	
