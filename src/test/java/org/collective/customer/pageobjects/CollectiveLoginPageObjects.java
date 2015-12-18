package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.SearchData;
import org.collective.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

/*
 * @author Hemanth.Sridhar
 */
public class CollectiveLoginPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveLoginPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//input[@id='spree_user_phone_number']")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//input[@id='spree_user_password']")
	private WebElement password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;

	@FindBy(xpath="//div[contains(text(),'Logged in successfully')]")
	private WebElement adminLoginMsg;
	
	public void enterPhoneNumberForLogin() throws IOException {
		Waiting.explicitWaitVisibilityOfElement(phoneNumber, 6);
		phoneNumber.clear();
		phoneNumber.sendKeys(data.getsignInPhoneNumber());
	}
	
	public void enterPasswordForLogin() throws IOException{
		password.clear();
		password.sendKeys(data.getsignInPassword());
	}
	
	public void clickLogin(){
		loginBtn.click();
	}

	public void verifyAdminLoginMsg() {
		Waiting.explicitWaitVisibilityOfElement(adminLoginMsg, 6);
		Assert.assertTrue(adminLoginMsg.isDisplayed());
		
	}

	public void enterPhoneNumberForAdmin() throws IOException {
		Waiting.explicitWaitVisibilityOfElement(phoneNumber, 6);
		phoneNumber.clear();
		phoneNumber.sendKeys(data.getadminSignInPhoneNumber());
		
	}

	public void enterPasswordForAdmin() throws IOException {
	password.clear();
	password.sendKeys(data.getadminadminSignInPassword());
		
	}
}
