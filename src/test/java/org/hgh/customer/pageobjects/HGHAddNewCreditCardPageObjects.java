package org.hgh.customer.pageobjects;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.TestUtility;
import org.hgh.utils.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HGHAddNewCreditCardPageObjects extends MainController{
	
	
	@FindBy(xpath="//li[contains(.,'Add New Credit Card')]")
	private WebElement addNewCreditCardBreadCrump;
	
	@FindBy(xpath="//h4[contains(.,'Add New Credit Card')]")
	private WebElement addNewCreditCardPageName;
	
	@FindBy(xpath="//td[@id='tdWelcomeMessage']/span")
	private WebElement welcomeMessage;
	
	@FindBy(xpath="//input[@id='cardNumber']")
	private WebElement cardNumber;
	
	@FindBy(xpath="//select[@id='ddlExpirationMonth']")
	private WebElement expirationMonth;
	
	@FindBy(xpath="//select[@id='ddlExpirationYear']")
	private WebElement expirationYear;
	
	@FindBy(xpath="//a[@id='submit' and contains(.,'Place Order')]")
	private WebElement placeOrderButton;
	
	String frameId = "frameCont";
	
	public HGHAddNewCreditCardPageObjects verifyAddNewCreditCardPage(String welcomeMessageInAddNewCreditCardPage)
	{
		Waiting.explicitWaitVisibilityOfElement(addNewCreditCardBreadCrump, 20);
		Assert.assertTrue(addNewCreditCardBreadCrump.isDisplayed(),"add new credit card page breadcrump is not displayed");
		Assert.assertTrue(addNewCreditCardPageName.isDisplayed(),"add new credit card page name is not displayed");
		driver.switchTo().frame(frameId);
		Waiting.explicitWaitVisibilityOfElement(welcomeMessage, 20);
		Assert.assertEquals(welcomeMessage.getText().trim(),welcomeMessageInAddNewCreditCardPage,"welcome message is not the same in the add new credit card page. Getting welcome message as "+welcomeMessage.getText().trim()+".");
		return this;
	}

	public HGHAddNewCreditCardPageObjects enterCardNumber(String cardNumber) {
		this.cardNumber.sendKeys(cardNumber);
		return this;
		
	}
	public HGHAddNewCreditCardPageObjects selectMonth(String month) {
		TestUtility.selectByVisibleText(expirationMonth, month);
		return this;
		
	}
	
	public HGHAddNewCreditCardPageObjects selectYear(String year) {
		TestUtility.selectByVisibleText(expirationYear, year);
		return this;
		
	}

	public HGHCheckoutWithCreditCardPageObjects clickOnPlaceOrder() {
		placeOrderButton.sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		return new HGHCheckoutWithCreditCardPageObjects();
		
	}
	
}
