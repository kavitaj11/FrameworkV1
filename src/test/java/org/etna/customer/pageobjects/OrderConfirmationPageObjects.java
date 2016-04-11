package org.etna.customer.pageobjects;

import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderConfirmationPageObjects extends MainController {
	
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	
	@FindBy(xpath="//li[contains(.,'Order Confirmation')]")
	private WebElement orderConfirmationBreadCrump;
	
	@FindBy(xpath="//h2[contains(.,'Order Confirmation')]")
	private WebElement orderConfirmationPageName;
	
	@FindBy(xpath="//h5[contains(.,'Billing Address')]/ancestor::div[@class='cimm_halfBlockColumns']")
	private WebElement billingAddressBlock;
	
	@FindBy(xpath="//h5[contains(.,'Shipping Address')]/ancestor::div[@class='cimm_halfBlockColumns']")
	private WebElement shippingAddressBlock;
	
	
	@FindBy(xpath="//div[@class='cimm_cartItemWrap']")
	private WebElement cartPreview;
	
	@FindBy(xpath="//p[contains(.,'Enter Coupon')]")
	private WebElement enterCouponLabel;
	
	@FindBy(xpath="//input[@id='userCoupons']")
	private WebElement enterCouponTextBox;
	
	@FindBy(xpath="//input[@value='Apply']")
	private WebElement applyCoupon;
	
	@FindBy(xpath="//input[@value='Place Order']")
	private WebElement placeOrderButton;
	
	@FindBy(xpath="//h4")
	private WebElement orderStatus;
	
	@FindBy(xpath="//a[@title='Print Invoice']")
	private WebElement printInvoice;
	
	public OrderConfirmationPageObjects verifyConfirmOrderPage() throws Exception{
		Waiting.explicitWaitVisibilityOfElement(orderConfirmationBreadCrump, 20);
		Assert.assertTrue(orderConfirmationBreadCrump.isDisplayed(),"order Confirmation BreadCrump is not displayed");
		Assert.assertTrue(orderConfirmationPageName.isDisplayed(),"order Confirmation Page Name is not displayed");
		Assert.assertTrue(billingAddressBlock.isDisplayed(),"billing address block is not displayed");
		Assert.assertTrue(shippingAddressBlock.isDisplayed(),"shipping address block is not displayed");
		Assert.assertTrue(printInvoice.isDisplayed(),"print Invoice link is not displayed");
		return this;
	}
	
	
	public OrderConfirmationPageObjects verifyOrderStatus() throws Exception{
		Assert.assertEquals(orderStatus.getText().replace("\n", "").trim(),data.getOrderConfirmationText());
		return this;
	}
	
}
