package org.collective.customer.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.collective.maincontroller.MainController;
import org.collective.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CollectiveShoppingCartPageObjects extends MainController {

	public CollectiveShoppingCartPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@name='checkout']")
	private WebElement checkout;
	
	@FindBy(xpath="//input[@id='order_bill_address_attributes_firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='order_bill_address_attributes_lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='order_bill_address_attributes_address1']")
	private WebElement streetAddress;

	
	@FindBy(xpath="//input[@id='order_bill_address_attributes_zipcode']")
	private WebElement pincode;
	
	@FindBy(xpath="//input[@id='order_bill_address_attributes_city']")
	private WebElement city;
	
	@FindBy(xpath="//select[@id='order_bill_address_attributes_state_id']")
	private WebElement chooseState;
	
	@FindBy(xpath="//select[@id='order_bill_address_attributes_country_id']")
	private WebElement chooseCountry;
	
	@FindBy(xpath="//input[@id='order_bill_address_attributes_phone']")
	private WebElement cartPhoneNumber;
	
	@FindBy(xpath="//input[@id='save_user_address']")
	private WebElement saveUserAddressCheckbox;
	
	@FindBy(xpath="//input[@value='Save and Continue']")
	private WebElement saveAndContinue;
	
	@FindBy(xpath="//input[@id='order_payments_attributes__payment_method_id_2']/ancestor::label")
	private WebElement cashOnDelivery;
	
	@FindBy(xpath="//a[@class='delete hide-in-small-screen']")
	private WebElement xButton;
	
	@FindBy(xpath="//div[@class='col-xs-12 text-center']")
	private WebElement cartStatus;
	
	@FindBy(xpath="//li[@id='link-to-cart']/a")
	private WebElement cartButton;
	
	@FindBy(xpath="//a[@id='payment-submit' and text()='Place Order']")
	private WebElement placeOrder;
	
	@FindBy(xpath="//div[contains(text(),'Your order has been processed successfully')]")
	private WebElement orderStatus;
	
	@FindBy(css="a[href='/cart']")
	public WebElement cartLink;
	
	public void clickCheckout(){
		Waiting.explicitWaitVisibilityOfElement(checkout, 5);
		checkout.click();
	}
	
	public void enterFirstName() throws IOException{
		Waiting.explicitWaitVisibilityOfElement(firstName, 5);
		firstName.clear();
		firstName.sendKeys(data.getcartFirstName());
	}
	
	public void enterLastName() throws IOException{
		lastName.clear();
		lastName.sendKeys(data.getcartLastName());
	}
	
	public void enterStreetAddress() throws IOException{
		streetAddress.clear();
		streetAddress.sendKeys(data.getcartStreetAddress());
	}
	
	public void enterPinCode() throws IOException
	{
	pincode.clear();
	pincode.sendKeys(data.getcartPincode());
	}
	
	public void enterCity() throws IOException{
	city.clear();	
	city.sendKeys(data.getcartCity());
	}
	
	public void chooseState() throws IOException
	{
		Select select = new Select(chooseState);
		select.selectByVisibleText(data.getcartState());
	}
	
	public void chooseCountry() throws IOException
	{
		Select select = new Select(chooseCountry);
		select.selectByVisibleText(data.getcartCountry());
	}
	
	public void enterCartPhoneNumber() throws IOException{
		cartPhoneNumber.clear();
		cartPhoneNumber.sendKeys(data.getcartPhoneNumber());
	}
	
	public void cartSaveMyAddress(){
		if(saveUserAddressCheckbox.isSelected())
		{
			saveUserAddressCheckbox.click();
			saveAndContinue.click();
		}
		else
		{
			saveAndContinue.click();
		}
		
	}
	
	public void saveAndContinueClick()
	{
		Waiting.explicitWaitVisibilityOfElement(saveAndContinue, 10);
		saveAndContinue.click();
	}

	public boolean checkForCashOnDeliveryGreaterthan20k() throws InterruptedException {
		Thread.sleep(2000);
		try
		{
		Assert.assertFalse(!cashOnDelivery.isDisplayed());
		}
		catch(Exception NoSuchElementException)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkForCashOnDeliveryLessThanOrEqualTo20k() throws InterruptedException {
Waiting.explicitWaitVisibilityOfElement(cashOnDelivery, 10);
try{
	Assert.assertTrue(cashOnDelivery.isDisplayed(),"cash on delivery button is displayed");
}
catch(Exception e)
{
	return false;
}
return true;
}

	public void clearCart() {
		Waiting.explicitWaitVisibilityOfElement(cartLink, 10);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , cartLink);
		Waiting.explicitWaitVisibilityOfElement(xButton, 5);
		xButton.click();
		Waiting.explicitWaitVisibilityOfElement(cartStatus, 6);
	
	}

	public void clickPlaceOrder() {
		Waiting.explicitWaitVisibilityOfElement(placeOrder, 6);
		placeOrder.click();
		
	}
	
	public void verifyOrderStatus() throws IOException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Assert.assertEquals((orderStatus.getText().trim()),data.getorderStatus().trim());
	}
}
