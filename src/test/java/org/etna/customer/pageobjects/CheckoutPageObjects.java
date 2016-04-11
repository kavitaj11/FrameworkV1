package org.etna.customer.pageobjects;
import org.etna.maincontroller.MainController;
import org.etna.utils.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutPageObjects extends MainController{

	@FindBy(xpath="//li[contains(.,'Checkout')]")
	private WebElement checkoutBreadCrump;
	
	@FindBy(xpath="//h2[contains(.,'Checkout')]")
	private WebElement checkoutPageName;
	
	@FindBy(xpath="//textarea[@id='shippingInstruction']")
	private WebElement shippingInstructions;
	
	@FindBy(xpath="//textarea[@id='orderNotes']")
	private WebElement orderNote;
	
	@FindBy(xpath="//input[@id='checkoutByCC']")
	private WebElement checkoutWithCC;
	
	public CheckoutPageObjects verifyCheckoutPage(){
		Waiting.explicitWaitVisibilityOfElement(checkoutBreadCrump, 20);
		Assert.assertTrue(checkoutBreadCrump.isDisplayed(),"checkout page breadcrump is not displayed");
		Assert.assertTrue(checkoutPageName.isDisplayed(),"checkout page name is not displayed");
		return this;
	}
	
	public CheckoutPageObjects enterShippingInstructions(String shippingInstructions) {
		this.shippingInstructions.sendKeys("Shipping instructions. "+shippingInstructions);
		return this;
	}

	public CheckoutPageObjects enterOrderNote(String orderNote) {
		
		this.orderNote.sendKeys("Order note. "+orderNote);
		return this;
	}

	public CheckoutWithCreditCardPageObjects clickOnCheckoutWithCreditCard() {
		checkoutWithCC.sendKeys(Keys.ENTER);
		return new CheckoutWithCreditCardPageObjects();
	}
	
	
	
	
	
	
	

}
