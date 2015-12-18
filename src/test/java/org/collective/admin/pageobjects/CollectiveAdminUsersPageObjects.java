package org.collective.admin.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.SearchData;
import org.collective.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/*
 * @author Hemanth.Sridhar
 */
public class CollectiveAdminUsersPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminUsersPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'Listing Users')]")
	private WebElement usersHeader;
	
	@FindBy(xpath="//a[@id='admin_new_user_link']")
	private WebElement newUserButton;
	
	@FindBy(xpath="//aside[@id='sidebar']")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@id='q_phone_number_or_email_cont']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//button[@name='button']")
	private WebElement searchButton;
	
	public void verifyPromotionsPage() {
		Waiting.explicitWaitVisibilityOfElement(usersHeader, 6);
		Assert.assertTrue(usersHeader.isDisplayed());
		Assert.assertTrue(newUserButton.isDisplayed());
		Assert.assertTrue(searchBox.isDisplayed());
		Assert.assertTrue(searchTextBox.isDisplayed());
		Assert.assertTrue(searchButton.isDisplayed());
	}
	}

	
