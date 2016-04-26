package org.etna.customer.pageobjects;
import org.etna.maincontroller.MainController;
import org.etna.utils.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutWithCreditCardPageObjects extends MainController {
	
	@FindBy(xpath="//li[contains(.,'Checkout with Credit Card')]")
	private WebElement checkoutWithCreditCardBreadCrump;
	
	@FindBy(xpath="//h2[contains(.,'Checkout with Credit Card')]")
	private WebElement checkoutWithCreditCardPageName;
	
	@FindBy(xpath="//input[@id='nickName']")
	private WebElement nickName;
	
	@FindBy(xpath="//input[@id='cardHolder']")
	private WebElement cardHolder;
	
	@FindBy(xpath="//input[@id='cardAddress']")
	private WebElement streetAddress;
	
	@FindBy(xpath="//input[@id='postalCode']")
	private WebElement postalCode;
	
	@FindBy(xpath="//input[@value='Place Order']")
	private WebElement placeOrderButton;
	
	@FindBy(xpath="//button[@id='addPcard']")
	private WebElement addNewCreditCardButton;
	
	@FindBy(xpath="//input[@id='r_1']")
	private WebElement firstCard;
	
	public CheckoutWithCreditCardPageObjects verifyCheckoutWithCreditCardPage(){
		Assert.assertTrue(checkoutWithCreditCardBreadCrump.isDisplayed(),"checkout With Credit Card breadcrump is not displayed");
		Assert.assertTrue(checkoutWithCreditCardPageName.isDisplayed(),"checkout With Credit Card page name is not displayed");
		return this;
	}

	public CheckoutWithCreditCardPageObjects enterNickName(String nickName) {
		this.nickName.clear();
		this.nickName.sendKeys(nickName);
		return this;
	}

	public CheckoutWithCreditCardPageObjects enterCardHolder(String cardHolder) {
		this.cardHolder.clear();
		this.cardHolder.sendKeys(cardHolder);
		return this;
	}

	public CheckoutWithCreditCardPageObjects enterStreetAddress(String streetAddress) {
		this.streetAddress.clear();
		this.streetAddress.sendKeys(streetAddress);
		return this;
	}

	public CheckoutWithCreditCardPageObjects enterPostalCode(String postalCode) {
		this.postalCode.clear();
		this.postalCode.sendKeys(postalCode);
		
		return this;
		
	}

	public AddNewCreditCardPageObjects clickAddNewCreditCard() {
		addNewCreditCardButton.sendKeys(Keys.ENTER);
		return new AddNewCreditCardPageObjects();
	}

	public CheckoutWithCreditCardPageObjects chooseFirstCard() {
		Waiting.explicitWaitVisibilityOfElement(firstCard, 10);
		firstCard.click();
		return this;
	}
	
	public CheckoutWithCreditCardPageObjects clickOnPlaceOrder() {
		placeOrderButton.click();
		return this;
	}
}
