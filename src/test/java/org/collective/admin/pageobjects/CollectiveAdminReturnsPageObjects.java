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
public class CollectiveAdminReturnsPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminReturnsPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Download']/ancestor::button")
	private WebElement downloadButton;
	
	@FindBy(xpath="//h1[contains(text(),'LISTING RETURNS')]")
	private WebElement returnsHeader;
	
	@FindBy(xpath="//label[text()='Date Range']")
	private WebElement dateRangeReturnsTab;
	
	@FindBy(xpath="//input[@id='q_created_at_gt']")
	private WebElement startDateRangeReturnsTab;
	
	@FindBy(xpath="//input[@id='q_created_at_lt']")
	private WebElement stopDateRangeReturnsTab;
	
	@FindBy(xpath="//label[text()='Status']")
	private WebElement StatusReturnsTab;
	
	@FindBy(xpath="//label[text()='Status']/ancestor::div/div/a")
	private WebElement StatusDropdownBoxReturnsTab;

	@FindBy(xpath="//button[text()='Filter Results']")
	private WebElement filterResultsButtonReturnsTab;
	
	@FindBy(xpath="//label[contains(text(),'Order')]")
	private WebElement orderNumberLabelReturnsTab;
	
	@FindBy(xpath="//input[@id='q_line_item_order_number_cont']")
	private WebElement orderTextBoxReturnsTab;
	
	@FindBy(xpath="//label[text()='Email']")
	private WebElement emailLabelReturnsTab;
	
	@FindBy(xpath="//input[@id='q_line_item_order_email_cont']")
	private WebElement emailTextBoxReturnsTab;
	
	@FindBy(xpath="//label[text()='First Name Begins With']")
	private WebElement firstNameLabelReturnsTab;
	
	@FindBy(xpath="//input[@id='q_line_item_order_bill_address_firstname_start']")
	private WebElement firstNameTextBoxReturnsTab;
	
	@FindBy(xpath="//label[text()='Last Name Begins With']")
	private WebElement lastNameLabelReturnsTab;
	
	@FindBy(xpath="//input[@id='q_line_item_order_bill_address_lastname_start']")
	private WebElement lastNameTextBoxReturnsTab;
	
	@FindBy(xpath="//span[text()='Return Reference Number']")
	private WebElement returnReferenceNumberLabelReturnsTab;
	
	@FindBy(xpath="//input[@id='q_return_reference_number_cont']")
	private WebElement returnReferenceNumberLabelTexBoxReturnsTab;
	
	@FindBy(xpath="//span[text()='Fedex Tracking Number']")
	private WebElement fedexTrackingNumberLabelReturnsTab;
	
	@FindBy(xpath="//input[@id='q_tracking_cont']")
	private WebElement fedexTrackingNumberLabelTextBoxReturnsTab;

	
	public void verifyReturnsPage() {
		Waiting.explicitWaitVisibilityOfElement(returnsHeader, 6);
		Assert.assertTrue(returnsHeader.isDisplayed());
		Assert.assertTrue(dateRangeReturnsTab.isDisplayed());
		Assert.assertTrue(startDateRangeReturnsTab.isDisplayed());
		Assert.assertTrue(stopDateRangeReturnsTab.isDisplayed());
		Assert.assertTrue(StatusReturnsTab.isDisplayed());
		Assert.assertTrue(StatusDropdownBoxReturnsTab.isDisplayed());
		Assert.assertTrue(filterResultsButtonReturnsTab.isDisplayed());
		Assert.assertTrue(orderNumberLabelReturnsTab.isDisplayed());
		Assert.assertTrue(orderTextBoxReturnsTab.isDisplayed());
		Assert.assertTrue(emailLabelReturnsTab.isDisplayed());
		Assert.assertTrue(emailTextBoxReturnsTab.isDisplayed());
		Assert.assertTrue(firstNameTextBoxReturnsTab.isDisplayed());
		Assert.assertTrue(lastNameLabelReturnsTab.isDisplayed());
		Assert.assertTrue(lastNameTextBoxReturnsTab.isDisplayed());
		Assert.assertTrue(returnReferenceNumberLabelReturnsTab.isDisplayed());
		Assert.assertTrue(returnReferenceNumberLabelTexBoxReturnsTab.isDisplayed());
		Assert.assertTrue(fedexTrackingNumberLabelReturnsTab.isDisplayed());
		Assert.assertTrue(fedexTrackingNumberLabelTextBoxReturnsTab.isDisplayed());
	}
	}

	
