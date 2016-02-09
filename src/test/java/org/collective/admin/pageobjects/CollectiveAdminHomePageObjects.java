package org.collective.admin.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.SearchData;
import org.collective.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/*
 * @author Hemanth.Sridhar
 */
public class CollectiveAdminHomePageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminHomePageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	public WebElement adminLogout;
	
	@FindBy(xpath="//span[text()='Reports']")
	private WebElement reportsTab;
	
	@FindBy(xpath="//span[text()='Order Totals']")
	private WebElement orderTotals;
	
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
	
	@FindBy(css="a[href='/admin/feature_collection']")
	private WebElement featureCollectionLink;
	
	@FindBy(css="a[href='/admin/store_locator']")
	private WebElement storeLocatorLink;
	
	@FindBy(css="a[href='/admin/blog_entries']")
	private WebElement blogsLink;
	
	@FindBy(css="a[href='/admin/users']")
	private WebElement usersLink;
	
	@FindBy(css="a[href='/admin/promotions']")
	private WebElement promotionsLink;
	
	@FindBy(css="a[href='/admin/general_settings/edit']")
	private WebElement settingsLink;
	
	@FindBy(css="a[href='/admin/products']")
	private WebElement productsLink;
	
	@FindBy(css="a[href='/admin/orders']")
	private WebElement ordersLink;
	
	@FindBy(css="a[href='/admin/carousel']")
	private WebElement carouselLink;
	
	@FindBy(css="a[href='/admin/returns']")
	private WebElement returnsLink;
	
	@FindBy(css="a[href='/admin/logout']")
	private WebElement logOutLink;
	
	@FindBy(css="a[href='/admin/analytic_scripts']")
	private WebElement analyticScriptLink;
	
	@FindBy(xpath="//span[text()='Return List']")
	private WebElement returnList;
	
	@FindBy(xpath="//span[contains(text(),'User List')]")
	private WebElement userList;
	
	public void openAdminPage() throws IOException {
		driver.get(data.getadminPageURL());
	}

	public void adminLogout() {

		((JavascriptExecutor)driver).executeScript("arguments[0].click();" ,logOutLink);
	}

	public void clickOnReturns()
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , returnsLink);
		
	}

	public void clickOnCarousel() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , carouselLink);
	}

	public void clickOnOrders() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , ordersLink);
	}

	public void clickOnProducts() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , productsLink);
	}
	
	public void clickOnReports(){
		Waiting.explicitWaitVisibilityOfElement(reportsTab, 10);
		reportsTab.click();
	}

	public void clickReturnList() {
		Waiting.explicitWaitVisibilityOfElement(returnList, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",returnList);
	}

public void clickUsersList() {
	Waiting.explicitWaitVisibilityOfElement(userList, 10);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();",userList);
}

	public void clickOnSettings() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , settingsLink);
		
	}

	public void clickOnPromotions() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , promotionsLink);
	}

	public void clickOnUsers() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , usersLink);
	}

	public void clickOnBlog() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , blogsLink);
	}

	public void clickOnStores() {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , storeLocatorLink);
		
	}
	
	public void clickOnFeatureCollection() {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , featureCollectionLink);
	}

	public void clickAnalyticScript() {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , analyticScriptLink);
	}
	
	
	}

	
