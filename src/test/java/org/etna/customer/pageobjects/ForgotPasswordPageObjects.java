package org.etna.customer.pageobjects;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ForgotPasswordPageObjects extends MainController {
	
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//span[contains(text(),'Forgot Password ?')]")
	private WebElement forgotPasswordLink;
	
	@FindBy(id="username")
	private WebElement userNameTextbox;
	
	@FindBy(id="emailAddress")
	private WebElement emailAddressTextBox;
	
	@FindBy(id="submitBtn")
	private WebElement getNewPasswordButton;
	
	@FindBy(className="cimm_caption")
	private WebElement forgotYourPasswordInstructions;
	
	public ForgotPasswordPageObjects verifyRetrievePasswordPage() {
		Waiting.explicitWaitVisibilityOfElement(loginPopUp().pageName, 5);
		Assert.assertEquals(loginPopUp().pageName.getText().trim(), "FORGOT PASSWORD" , "Page name is not right. I am getting "+loginPopUp().pageName.getText().trim());
		Assert.assertTrue(userNameTextbox.isDisplayed(),"user name textbox is not displayed");
		Assert.assertTrue(emailAddressTextBox.isDisplayed(),"email address text box is not displayed");
		Assert.assertTrue(getNewPasswordButton.isDisplayed(), "retrieve password button is not displayed");
		Assert.assertEquals(getNewPasswordButton.getAttribute("value"),"Get New Password");
		Assert.assertEquals(forgotYourPasswordInstructions.getText().trim(),data.getForgotYourPasswordInstructions());
		return this;
	}
}
