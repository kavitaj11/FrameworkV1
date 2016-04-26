package org.etna.customer.pageobjects;

import java.util.List;

import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;


/*
 * @author Hemanth.Sridhar
 */
public class MyCartPageObjects extends MainController{
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	public ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	Actions action = new Actions(driver);

	
	@FindBy(xpath="//div[contains(@class,'popCheckout')]/a[@href='/Cart']")
	private WebElement checkoutButtonInMyCartPopUp;
	
	@FindBy(xpath="//h2")
	private WebElement pageName;
	
	@FindBy(xpath="//li/a[contains(text(),'Checkout')]")
	private WebElement checkoutButtonInMyCartPage;

	@FindBy(xpath="//a[contains(text(),'Empty Cart')]")
	private WebElement emptyCartButton;

	@FindBy(xpath="//li/a[@title='View cart']")
	private WebElement cartButtonInTopNavigationMenu;
	
	@FindBy(xpath="//h4[text()='No items in your shopping cart']")
	private WebElement checkForEmptyCart; 
	
	@FindBy(xpath="//div[@class='cimm_mainContentEnclosure']/descendant::a[contains(text(),'Continue Shopping')]")
	private WebElement continueShoppingButtonInMyCartPage;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_btnGroupEnclosure']/descendant::a")})
	private List<WebElement> buttonsInMyCart;
	
	public MyCartPageObjects clickOnCheckoutInMyCartPopup() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",checkoutButtonInMyCartPopUp);
		return this;
		
	}


	public MyCartPageObjects verifyMyCartTitle(String myCartBreadcrump) throws Exception {
		Assert.assertEquals(driver.getTitle().trim(), myCartBreadcrump+" | "+setUp.getProductName().toUpperCase());
		return this;
	}


	public MyCartPageObjects verifyMyCartBreadcrump(String myCartBreadcrump) throws Exception {
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertEquals(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim(),myCartBreadcrump);
		return this;
	}


	public MyCartPageObjects verifyMyCartPagename(String myCartBreadcrump) {
		Assert.assertEquals(pageName.getText().trim(),myCartBreadcrump.toUpperCase());
		return this;
	}

	public boolean assertCheckoutButtonInMyCartPage(){
		try
		{
		if(checkoutButtonInMyCartPage.isDisplayed())
		{
			return false;
		}
		
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		return false;


	}

	public MyCartPageObjects verifyCheckoutButtonNotDisplayedInMyCartPage() {
		Assert.assertTrue(assertCheckoutButtonInMyCartPage(), "checkout button is displayed in my cart page for general user.");
		return this;
	}



		public boolean clearCart() throws InterruptedException {
			navigateToShoppingCart();
			try
			{
				if(checkForEmptyCart.isDisplayed())
				{
					clickOnContinueShopping();
				}
			}
			catch(NoSuchElementException e)
			{
				clickOnEmptyCartButton();
				Waiting.explicitWaitForAlert(5);
				TestUtility.alertAccept();
				clickOnContinueShopping();
				return true;
			}
			return true;
		}
		
		private MyCartPageObjects clickOnContinueShopping() {
			Waiting.explicitWaitVisibilityOfElement(continueShoppingButtonInMyCartPage, 5);
			continueShoppingButtonInMyCartPage.click();
			return this;
		}


	private MyCartPageObjects clickOnEmptyCartButton() {
		Waiting.explicitWaitVisibilityOfElement(emptyCartButton, 7);
		emptyCartButton.click();
			return this;
		}
	

	public MyCartPageObjects navigateToShoppingCart() throws InterruptedException {
		clickOnCartIcon();
		return this;
	}


	private MyCartPageObjects clickOnCartIcon() {
		cartButtonInTopNavigationMenu.click();
		return this;
	}


	public MyCartPageObjects verifyButtonsAvailableForGeneralUserInMyCart() throws Exception {
		String expectedButtonsInMyCartForGeneralUser[] = data.getExpectedButtonsInMyCartForGeneralUser().split(",");
		for(int i = 0; i < buttonsInMyCart.size() ; i++)
		{
		Assert.assertTrue(buttonsInMyCart.get(i).getText().trim().equalsIgnoreCase(expectedButtonsInMyCartForGeneralUser[i]),"Button actual is "+buttonsInMyCart.get(i).getText().trim()+"Button expected is : "+expectedButtonsInMyCartForGeneralUser[i] );
		}
		clearCart();
		return this;
	}
	
}