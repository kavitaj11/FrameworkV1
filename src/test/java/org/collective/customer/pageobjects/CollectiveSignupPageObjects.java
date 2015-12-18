package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.RandomNumberGenerator;
import org.collective.utils.SearchData;
import org.collective.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/*
 * @author Hemanth.Sridhar
 */
public class CollectiveSignupPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveSignupPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='spree_user_name']")
	private WebElement signupName;
	
	@FindBy(xpath="//input[@id='spree_user_email']")
	private WebElement signupEmail;
	
	@FindBy(xpath="//input[@id='spree_user_phone_number']")
	private WebElement signUpPhoneNumber;
	
	@FindBy(xpath="//input[@id='spree_user_password']")
	private WebElement signUpPassword;
	
	@FindBy(xpath="//input[@id='spree_user_password_confirmation']")
	private WebElement signUpPasswordConfirmation;
	
	@FindBy(xpath="//input[@value='Signup']")
	private WebElement signUpBtn;
	
	
	
	public void signupUsername() throws IOException{
		Waiting.explicitWaitVisibilityOfElement(signupName, 6);
	signupName.sendKeys((data.getsignupUsername()+RandomNumberGenerator.generateRandomNumber()).replace("-", "9"));
	}
	
	public void signupEmail() throws IOException {
String[] split = data.getsignupEmail().split("@");
String email = split[0]+"+"+RandomNumberGenerator.generateRandomNumber()+"@"+split[1]; 
signupEmail.sendKeys(email);		
	}
	
	public void signupPhoneNumber() throws InterruptedException{
		String n = "99"+Integer.toOctalString(RandomNumberGenerator.generateEightRandomNumbers());
		signUpPhoneNumber.sendKeys(n);	
	}
	
	public void signUpPasswordAndConfirmation() throws IOException
	{
	signUpPassword.sendKeys(data.getsignupPassword());
	signUpPasswordConfirmation.sendKeys(data.getsignupPassword());
	}
	
	public void signupBtnClick() throws InterruptedException{
		signUpBtn.click();
	}	
}
