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
public class CollectiveAdminOrdersPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminOrdersPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Download']/ancestor::button")
	private WebElement downloadButton;
	
	@FindBy(xpath="//h1[contains(text(),'Listing Orders')]")
	private WebElement ordersHeader;
	
	@FindBy(xpath="//label[text()='Date Range']")
	private WebElement dateRangeOrdersTab;
	
	@FindBy(xpath="//input[@id='q_created_at_gt']")
	private WebElement startDateRangeOrdersTab;
	
	@FindBy(xpath="//input[@id='q_created_at_lt']")
	private WebElement stopDateRangeOrdersTab;
	
	@FindBy(xpath="//label[text()='Status']")
	private WebElement StatusOrdersTab;
	
	@FindBy(xpath="//label[text()='Status']/ancestor::div/div/a")
	private WebElement StatusDropdownBoxOrdersTab;

	@FindBy(xpath="//button[text()='Filter Results']")
	private WebElement filterResultsButtonOrdersTab;
	
	@FindBy(xpath="//label[contains(text(),'Order')]")
	private WebElement orderNumberLabelOrdersTab;
	
	@FindBy(xpath="//input[@id='q_number_cont']")
	private WebElement orderTextBoxOrdersTab;
	
	@FindBy(xpath="//label[text()='Email']")
	private WebElement emailLabelOrdersTab;
	
	@FindBy(xpath="//input[@id='q_email_cont']")
	private WebElement emailTextBoxOrdersTab;
	
	@FindBy(xpath="//label[text()='First Name Begins With']")
	private WebElement firstNameLabelOrdersTab;
	
	@FindBy(xpath=".//input[@id='q_bill_address_firstname_start']")
	private WebElement firstNameTextBoxOrdersTab;
	
	@FindBy(xpath="//label[text()='Stock Locations']")
	private WebElement stockLocationsLabelOrdersTab;
	
	@FindBy(xpath="//label[text()='Stock Locations']/ancestor::div/div/a")
	private WebElement stockLocationsDropdownOrdersTab;
	
	@FindBy(xpath="//input[@id='q_completed_at_not_null']/ancestor::label")
	private WebElement showCompeteOrdersLabelOrdersTab;
	
	@FindBy(xpath="//label[text()='Promotion']")
	private WebElement promotionLabelOrdersTab;
	
	@FindBy(xpath="//div[@id='s2id_q_promotions_id_in']")
	private WebElement promotionsDropdownOrdersTab;
	
	@FindBy(xpath="//label[text()='Last Name Begins With']")
	private WebElement lastNameLabelOrdersTab;	
	
	@FindBy(xpath="//input[@id='q_bill_address_lastname_start']")
	private WebElement lastNameTextBoxOrdersTab;
	
	@FindBy(xpath="//a[@id='admin_new_order']")
	private WebElement newOrderButton;
	
	public void verifyOrdersPage() {
		Waiting.explicitWaitVisibilityOfElement(ordersHeader, 6);
		Assert.assertTrue(ordersHeader.isDisplayed());
		Assert.assertTrue(dateRangeOrdersTab.isDisplayed());
		Assert.assertTrue(startDateRangeOrdersTab.isDisplayed());
		Assert.assertTrue(stopDateRangeOrdersTab.isDisplayed());
		Assert.assertTrue(StatusOrdersTab.isDisplayed());
		Assert.assertTrue(StatusDropdownBoxOrdersTab.isDisplayed());
		Assert.assertTrue(filterResultsButtonOrdersTab.isDisplayed());
		Assert.assertTrue(orderNumberLabelOrdersTab.isDisplayed());
		Assert.assertTrue(orderTextBoxOrdersTab.isDisplayed());
		Assert.assertTrue(emailLabelOrdersTab.isDisplayed());
		Assert.assertTrue(emailTextBoxOrdersTab.isDisplayed());
		Assert.assertTrue(firstNameLabelOrdersTab.isDisplayed());
		Assert.assertTrue(firstNameTextBoxOrdersTab.isDisplayed());
		Assert.assertTrue(lastNameLabelOrdersTab.isDisplayed());
		Assert.assertTrue(lastNameTextBoxOrdersTab.isDisplayed());
		Assert.assertTrue(stockLocationsLabelOrdersTab.isDisplayed());
		Assert.assertTrue(stockLocationsDropdownOrdersTab.isDisplayed());
		Assert.assertTrue(showCompeteOrdersLabelOrdersTab.isDisplayed());
		Assert.assertTrue(promotionLabelOrdersTab.isDisplayed());
		Assert.assertTrue(promotionsDropdownOrdersTab.isDisplayed());
		Assert.assertTrue(newOrderButton.isDisplayed());
	}
	}

	
