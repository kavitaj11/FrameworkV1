package org.etna.customer.pageobjects;

import org.etna.maincontroller.MainController;
import org.etna.utils.Waiting;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ConfirmOrderPageObjects extends MainController {
	
	@FindBy(xpath="//li[contains(.,'Confirm Order')]")
	private WebElement confirmOrderBreadCrump;
	
	@FindBy(xpath="//h2[contains(.,'Confirm Order')]")
	private WebElement confirmOrderPageName;
	
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
	
	public ConfirmOrderPageObjects verifyConfirmOrderPage(){
		Waiting.explicitWaitVisibilityOfElement(confirmOrderBreadCrump, 20);
		Assert.assertTrue(confirmOrderBreadCrump.isDisplayed(),"confirm Order breadcrump is not displayed");
		Assert.assertTrue(confirmOrderPageName.isDisplayed(),"confirm Order Page Name is not displayed");
		Assert.assertTrue(billingAddressBlock.isDisplayed(),"billing address block is not displayed");
		Assert.assertTrue(shippingAddressBlock.isDisplayed(),"shipping address block is not displayed");
		Assert.assertTrue(cartPreview.isDisplayed(),"cart Preview block is not displayed");
		Assert.assertTrue(enterCouponLabel.isDisplayed(),"enter coupon label is not displayed");
		Assert.assertTrue(enterCouponTextBox.isDisplayed(),"enter coupon texbox is not displayed");
		Assert.assertTrue(applyCoupon.isDisplayed(),"Apply Coupon is not displayed");
		Assert.assertTrue(placeOrderButton.isDisplayed(),"Place Order Button is not displayed");
		return this;
	}

	public OrderConfirmationPageObjects clickOnPlaceOrder() {
		
		placeOrderButton.sendKeys(Keys.ENTER);
		return new OrderConfirmationPageObjects();
	}
}
