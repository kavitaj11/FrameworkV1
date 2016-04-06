package org.hgh.customer.pageobjects;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HGHCheckoutPageObjects extends MainController{

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
	
	public HGHCheckoutPageObjects verifyCheckoutPage(){
		Waiting.explicitWaitVisibilityOfElement(checkoutBreadCrump, 20);
		Assert.assertTrue(checkoutBreadCrump.isDisplayed(),"checkout page breadcrump is not displayed");
		Assert.assertTrue(checkoutPageName.isDisplayed(),"checkout page name is not displayed");
		return this;
	}
	
	public HGHCheckoutPageObjects enterShippingInstructions(String shippingInstructions) {
		this.shippingInstructions.sendKeys("Shipping instructions. "+shippingInstructions);
		return this;
	}

	public HGHCheckoutPageObjects enterOrderNote(String orderNote) {
		
		this.orderNote.sendKeys("Order note. "+orderNote);
		return this;
	}

	public HGHCheckoutWithCreditCardPageObjects clickOnCheckoutWithCreditCard() {
		checkoutWithCC.sendKeys(Keys.ENTER);
		return new HGHCheckoutWithCreditCardPageObjects();
	}
	
	
	
	
	
	
	

}
