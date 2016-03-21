package org.hgh.customer.pageobjects;
import java.util.List;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.TestUtility;
import org.hgh.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class HGHShoppingCartPageObjects extends MainController{
 
	Actions action = new Actions(driver);
   SearchDataPropertyFile data = new SearchDataPropertyFile();
   
	public HGHShoppingCartPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


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
	
	HGHProductsDetailsPageObjects productsDetailsPage = new HGHProductsDetailsPageObjects(driver);
	HGHProductsListPageObjects productsListPage = new HGHProductsListPageObjects(driver);
	
	public void clickOnEmptyCartButton(){
		Waiting.explicitWaitVisibilityOfElement(emptyCartButton, 15);
		emptyCartButton.click();
	}

	public boolean clearCart() {
		navigateToShoppingCart();
		try
		{
			Waiting.explicitWaitVisibilityOfElement(checkForEmptyCart, 5);
			if(checkForEmptyCart.isDisplayed())
			{
				clickContinueShopping();
			}
		}
		catch(Exception e)
		{
			clickOnEmptyCartButton();
			Waiting.explicitWaitForAlert(5);
			TestUtility.alertAccept();
			return true;
		}
		return true;
	}

	private void clickContinueShopping() {
		continueShoppingButton.click();
	}

	public void navigateToShoppingCart() {
		productsListPage.clickOnCartIcon();
		productsDetailsPage.clickOnCheckout();
		
	}
	
	public void enterNameOfSaveCartAndAddTheProductToSaveCart(String saveCartName) {
		Waiting.explicitWaitVisibilityOfElement(saveCartTextbox, 15);
		saveCartTextbox.sendKeys(saveCartName);

	}
	public void clickOnSaveCart() {
		Waiting.explicitWaitVisibilityOfElement(saveCartButton, 15);
		saveCartButton.click();
	}

	public void checkWhetherItIsTheSameQuantity(String quantity) {
		Assert.assertEquals(productsDetailsPage.quantityTextbox.getAttribute("value"),quantity,productsDetailsPage.quantityTextbox.getAttribute("value"));
	}

	public boolean verifyShoppingCartBreadCrump() {
		boolean t = shoppingCartBreadCrump.isDisplayed();
		return t;
	}

	public boolean verifyShoppingCartPageHeading() {
		boolean t = shoppingCartHeading.isDisplayed();
		return t;
	}

	public boolean verifyContinueShoppingButton()
	{
		boolean t = continueShoppingButton.isDisplayed();
		return t;
	}

	public void verifyButtonsOnTopOfTheCart() throws Exception {
		String nameOfShoppingCartButtonsArray[] = data.getNameOfShoppingCartButtons().split(",");
		for(int i=0;i<shoppingCartFormButtonsOnTopForButton.size();i++)
		{
		Assert.assertEquals(shoppingCartFormButtonsOnTopForButton.get(i).getAttribute("class"),"button",shoppingCartFormButtonsOnTop.get(i).getText()+" is not a button");
		Assert.assertEquals(shoppingCartFormButtonsOnTop.get(i).getText().trim().replace("\n", ""),nameOfShoppingCartButtonsArray[i].trim());	
		}
	}

	public void verifyButtonsOnBottomOfTheCart() throws Exception {
		String nameOfShoppingCartButtonsArray[] = data.getNameOfShoppingCartButtons().split(",");
		for(int i=0;i<shoppingCartFormButtonsOnBottomForButton.size();i++)
		{
		Assert.assertEquals(shoppingCartFormButtonsOnBottomForButton.get(i).getAttribute("class"),"button",shoppingCartFormButtonsOnBottom.get(i).getText()+" is not a button");
		Assert.assertEquals(shoppingCartFormButtonsOnBottom.get(i).getText().trim().replace("\n", ""),nameOfShoppingCartButtonsArray[i].trim());	
		}
		
	}

}
	
	
