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
public class CollectiveAdminPromotionsPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminPromotionsPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Promotions')]")
	private WebElement promotionsHeader;
	
	@FindBy(xpath="//a[text()='New Promotion']")
	private WebElement newPromotionButton;
	
	@FindBy(xpath="//label[text()='name']")
	private WebElement nameLabel;
	
	@FindBy(xpath="//input[@id='q_name_cont']")
	private WebElement nameTextBox;
	
	@FindBy(xpath="//label[text()='code']")
	private WebElement codeLabel;
	
	@FindBy(xpath="//input[@id='q_code_cont']")
	private WebElement codeTextbox;
	
	@FindBy(xpath="//label[text()='path']")
	private WebElement pathLabel;

	@FindBy(xpath="//input[@id='q_path_cont']")
	private WebElement pathTextbox;
	
	@FindBy(xpath="//button[text()='Filter Results']")
	private WebElement filterResultsButton;

	
	public void verifyPromotionsPage() {
		Waiting.explicitWaitVisibilityOfElement(promotionsHeader, 6);
		Assert.assertTrue(promotionsHeader.isDisplayed());
		Assert.assertTrue(newPromotionButton.isDisplayed());
		Assert.assertTrue(nameLabel.isDisplayed());
		Assert.assertTrue(nameTextBox.isDisplayed());
		Assert.assertTrue(codeLabel.isDisplayed());
		Assert.assertTrue(codeTextbox.isDisplayed());
		Assert.assertTrue(pathLabel.isDisplayed());
		Assert.assertTrue(pathTextbox.isDisplayed());
		Assert.assertTrue(filterResultsButton.isDisplayed());
	}
	}

	
