package org.hgh.customer.pageobjects;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HGHRetrievePasswordPageObjects extends MainController {
	
	@FindBy(xpath="//span[contains(text(),'Forgot Password ?')]")
	private WebElement forgotPasswordLink;
	
	
	@FindBy(xpath="//li[contains(text(),'Retrieve Password')]")
	private WebElement retrievePasswordBreampCrump;

	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameTextbox;
	
	@FindBy(xpath="//input[@id='emailAddress']")
	private WebElement emailAddressTextBox;
	
	@FindBy(xpath="//input[@id='submitBtn']")
	private WebElement retrievePasswordButton;
	

	
	public HGHRetrievePasswordPageObjects verifyRetrievePasswordPage() {
		Waiting.explicitWaitVisibilityOfElement(retrievePasswordBreampCrump, 10);
		Assert.assertTrue(retrievePasswordBreampCrump.isDisplayed(),"retrieve password breadcrump is not displayed");
		Assert.assertEquals(loginPage().pageName.getText().trim(), "Retrieve Password" , "page name is right. I am getting "+loginPage().pageName);
		Assert.assertTrue(userNameTextbox.isDisplayed(),"user name textbox is not displayed");
		Assert.assertTrue(emailAddressTextBox.isDisplayed(),"email address text box is not displayed");
		Assert.assertTrue(retrievePasswordButton.isDisplayed(), "retrieve password button is not displayed");
		return this;
	}
}
