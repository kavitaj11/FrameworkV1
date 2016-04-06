package org.hgh.customer.pageobjects;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HGHCheckoutWithCreditCardPageObjects extends MainController {
	
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
	
	public HGHCheckoutWithCreditCardPageObjects verifyCheckoutWithCreditCardPage(){
		Assert.assertTrue(checkoutWithCreditCardBreadCrump.isDisplayed(),"checkout With Credit Card breadcrump is not displayed");
		Assert.assertTrue(checkoutWithCreditCardPageName.isDisplayed(),"checkout With Credit Card page name is not displayed");
		return this;
	}

	public HGHCheckoutWithCreditCardPageObjects enterNickName(String nickName) {
		this.nickName.clear();
		this.nickName.sendKeys(nickName);
		return this;
	}

	public HGHCheckoutWithCreditCardPageObjects enterCardHolder(String cardHolder) {
		this.cardHolder.clear();
		this.cardHolder.sendKeys(cardHolder);
		return this;
	}

	public HGHCheckoutWithCreditCardPageObjects enterStreetAddress(String streetAddress) {
		this.streetAddress.clear();
		this.streetAddress.sendKeys(streetAddress);
		return this;
	}

	public HGHCheckoutWithCreditCardPageObjects enterPostalCode(String postalCode) {
		this.postalCode.clear();
		this.postalCode.sendKeys(postalCode);
		
		return this;
		
	}

	public HGHAddNewCreditCardPageObjects clickAddNewCreditCard() {
		addNewCreditCardButton.sendKeys(Keys.ENTER);
		return new HGHAddNewCreditCardPageObjects();
	}

	public HGHCheckoutWithCreditCardPageObjects chooseFirstCard() {
		Waiting.explicitWaitVisibilityOfElement(firstCard, 10);
		firstCard.click();
		return this;
	}
	
	public HGHCheckoutWithCreditCardPageObjects clickOnPlaceOrder() {
		placeOrderButton.click();
		return this;
	}
}
