package org.etna.customer.pageobjects;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class MyAccountsPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	Actions action = new Actions(driver);

	@FindBy(css="a[href='/SavedGroups/Products']")
	private WebElement myProductsGroupsLink;
	
	@FindBy(css="a[href='OpenOrderSale.action?reqType=webOrder&orderStatus=New']")
	private WebElement openOrdersLink;
	
	@FindBy(css="a[href='/SavedGroups/Cart")
	private WebElement mySavedCartLink;
	
	@FindBy(xpath="//h2[text()='My Product Groups']")
	private WebElement myProductGroupsHeader;
	
	@FindBy(xpath="//span[@id='groupName']")
	private WebElement groupNameAfterClickTheGroupLocator;
	
	@FindBy(xpath="//input[@id='groupNameSaveBtn' and @value='Delete Group']")
	private WebElement deleteGroupButton;
	
	@FindBy(xpath="//li[contains(text(),'No Product Group Available')]")
	private WebElement noProductGroupsAvialableLocator;
	
	@FindBy(xpath="//div[@class='cimm_pageTitle']/descendant::span")
	private WebElement headingOfTheSavedCart;
	
	@FindBy(xpath="//input[@id='groupNameSaveBtn' and @value='Delete Cart']")
	private WebElement deleteCartButton;
	
	@FindBy(xpath="//li[contains(text(),'No Saved Cart Available')]")
	private WebElement noSavedCartAvailable;
	
	@FindBy(xpath="//a[contains(text(),'Product Categories')]")
	private WebElement productCategoriesHeader;
	
	@FindAll(value={@FindBy(xpath="//a[contains(text(),'Product Categories')]/ancestor::h3/following-sibling::ul/li/a")})
	private List<WebElement> productMainCategories;
	
	@FindAll(value={@FindBy(xpath="//a[contains(text(),'Product Categories')]/ancestor::h3/following-sibling::ul/li/descendant::li")})
	private List<WebElement> subcategories;
	
	@FindBy(xpath="//li[contains(text(),'Account Dashboard')]")
	private WebElement accountDashboardBreadcrumb;
	
	@FindBy(xpath="//div[@class='cimm_previousInvoice']/descendant::a[contains(text(),'Open Orders')]")
	private WebElement openOrdersButton;
	
	@FindBy(xpath="//div[@class='cimm_previousInvoice']/descendant::a[contains(text(),'Order History')]")
	private WebElement orderHistoryButton;
	
	@FindBy(xpath="//h5[contains(text(),'Contact Address')]/ancestor::li/div[@class='cimm_oneThirdColumns']")
	private WebElement contactAddressInformation;
	
	@FindBy(xpath="//h5[contains(text(),'Billing Address')]/ancestor::li/div[@class='cimm_oneThirdColumns']")
	private WebElement billingAddressInformation;
	
	@FindBy(xpath="//h5[contains(text(),'Shipping Address')]/ancestor::li/div[@class='cimm_oneThirdColumns']")
	private WebElement shippingAddressInformation;
	
	@FindBy(xpath="//h5[contains(text(),'My Product Group')]/ancestor::div[@class='cimm_halfBlockColumns']")
	private WebElement myProductGroupSection;
	
	@FindBy(xpath="//h5[contains(text(),'My Saved Cart')]/ancestor::div[@class='cimm_halfBlockColumns']")
	private WebElement mySavedCartSection;
	
	@FindBy(xpath="//h4[contains(text(),'Ship Address List')]/following-sibling::table[@class='cimm_responsiveDataTable']")
	private WebElement shippingAddressSection;
	
	@FindBy(xpath="//b[contains(text(),'Refresh Shipping Information')]/ancestor::a[@onclick='scynInitiate();']")
	private WebElement refreshShippingInfoButton;
	
	@FindBy(xpath="//h4[contains(text(),'Your Shopping Cart')]/following-sibling::div")
	private WebElement shoppingCartAddressDetails;
	
	@FindAll(value={@FindBy(xpath="//h3[@id='slideAccount']/following-sibling::ul/li")})
	private List<WebElement> accountTabs;
	
	@FindBy(css="a[href='/FileUpload']")
	private WebElement cartFileUpload;
	
	@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/descendant::a[contains(text(),'File Upload')]")
	private WebElement fileUploadBreadCrump;
	
	@FindBy(xpath="//h2[contains(text(),'File Upload')]")
	private WebElement fileUploadHeading;
	
	@FindBy(xpath="//input[@id='datafile']")
	private WebElement browseButton;
	
	@FindBy(xpath="//input[@value='Upload File']")
	private WebElement uploadFileButton;
	
	@FindBy(xpath="//div[@class='cimm_siteTableEnclosure']")
	private WebElement quickCartTable;
	
	@FindBy(xpath="//h2[contains(text(),'Quick Cart')]")
	private WebElement quickCartHeading;
	
	@FindBy(xpath="//li[contains(text(),'Quick Cart')]")
	private WebElement quickCartBreadCrump;
	
	@FindBy(xpath="//select[@id='flip_all']")
	private WebElement selectItemTypeInQuickCart;
	
	@FindBy(css="a[href='RequestForQuote']")
	private WebElement requestForQuoteLink;
	
	@FindBy(xpath="//li[contains(text(),'Request for Quote')]")
	private WebElement requestForQuoteBreadCrump;
	
	@FindBy(xpath="//h2[contains(text(),'Request for Quote')]")
	private WebElement requestForQuoteHeading;
	
	@FindBy(xpath="//input[@id='rfnpPhone']")
	private WebElement enterPhoneNumberForRequestQuote;
	
	@FindAll(value={@FindBy(xpath="//table/descendant::tr/td[@data-th='Manufacturer Part Number']/input")})
	private List<WebElement> mpnRequestQuote;
	
	@FindAll(value={@FindBy(xpath="//table/descendant::tr/td[@data-th='Brand / Mfr Name']/input")})
	private List<WebElement>brandNameRequestQuote;
	
	@FindAll(value={@FindBy(xpath="//table/descendant::tr/td[@data-th='Qty']/input")})
	private List<WebElement> quantityRequestQuote;
	
	@FindBy(xpath="//textarea[@id='comments']")
	private WebElement commentsSectionRequestQuote;
	
	@FindBy(xpath="//input[@id='submitBtn']")
	private WebElement submitButtonRequestQuote;
	
	@FindBy(xpath="//input[@id='popup_ok']")
	private WebElement popUpOkRequestQuote;
	
	@FindBy(xpath="//li[contains(text(),'Quick Order Pad')]")
	private WebElement quickOrderPadBreadCrump;
	
	public MyAccountsPageObjects clickOnMyProductGroupsInMyAccountsPage() {
		try
		{
		Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",myProductsGroupsLink);
		return this;
		
	}

	public MyAccountsPageObjects myProductsPageHeader() {
		Waiting.explicitWaitVisibilityOfElement(myProductGroupsHeader, 10);
		Assert.assertTrue(myProductGroupsHeader.isDisplayed());
		return this;
	}

	public MyAccountsPageObjects clickOnTheGroupCreated(String groupName) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String groupNameLocator= "//a[contains(text(),'"+groupName+"')]" ;
	driver.findElement(By.xpath(groupNameLocator)).click();
		return this;
	}

	public MyAccountsPageObjects verifyGroupName(String groupName) {
		Waiting.explicitWaitVisibilityOfElement(groupNameAfterClickTheGroupLocator, 20);
		Assert.assertEquals(groupNameAfterClickTheGroupLocator.getText().trim(),groupName.trim(),"group Name is not displayed after clicking on the group");
		
		return this;
		
	}

	public MyAccountsPageObjects deleteGroup() {
		Waiting.explicitWaitVisibilityOfElement(deleteGroupButton, 20);
		deleteGroupButton.click();
		return this;
		
	}

	public MyAccountsPageObjects verifyNoProductGroupsNotAvailable() {
		Assert.assertTrue(noProductGroupsAvialableLocator.isDisplayed(),"no product group available is not displayed");
		return this;
	}

	public MyAccountsPageObjects clickOnMySavedCartLinkInMyAccountsPage() {
		try
		{
		Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",mySavedCartLink);
		return this;
	}

	public MyAccountsPageObjects clickOnTheCreatedSaveCart(String saveCartName) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String saveCartXpath = "//a[contains(text(),'"+saveCartName+"')]";	
		driver.findElement(By.xpath(saveCartXpath)).click();
		return this;
	}

	public MyAccountsPageObjects verifySaveCartHeading(String saveCartName) {
		Waiting.explicitWaitVisibilityOfElement(headingOfTheSavedCart, 5);
		Assert.assertEquals(headingOfTheSavedCart.getText().trim(),saveCartName,"cart heading is not displayed with the relevant save cart name");
		
		return this;
	}

	public MyAccountsPageObjects deleteSaveCart() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		deleteCartButton.click();
		return this;
	}

	public MyAccountsPageObjects verifyMySavedCartNotAvialable() {
		Assert.assertTrue(noSavedCartAvailable.isDisplayed(),"no saved cart available is not displayed");
		return this;
	}

	public MyAccountsPageObjects verifyProductCategoriesSection() {
		 
		 Waiting.explicitWaitVisibilityOfElement(accountDashboardBreadcrumb, 5);
		Assert.assertTrue(accountDashboardBreadcrumb.isDisplayed(),"Account Dashboard is not displayed");
		Assert.assertTrue(productCategoriesHeader.isDisplayed(),"product categories hyperlink is not displayed");
		Assert.assertTrue(openOrdersButton.isDisplayed(),"open orders button is not displayed");
		Assert.assertTrue(orderHistoryButton.isDisplayed(), "order history button is not displayed");
		Assert.assertTrue(contactAddressInformation.isDisplayed(),"contact address information is not displayed");
		Assert.assertTrue(myProductGroupSection.isDisplayed(),"my product section is not displayed");
		Assert.assertTrue(mySavedCartSection.isDisplayed(),"my save cart section is not displayed");
		Assert.assertTrue(shippingAddressSection.isDisplayed(),"shipping address section is not displayed");
		Assert.assertTrue(refreshShippingInfoButton.isDisplayed(),"refresh shipping address info button is not displayed");
		Assert.assertTrue(shoppingCartAddressDetails.isDisplayed(), "shopping cart address details is not displayed");
	return this;
		
}
	
	public MyAccountsPageObjects verifyMyAccountSection() throws Exception{
		
		String  accountsHyperLinks[]= data.getMyAccountTabs().split(",");
		for(int i=0;i<accountTabs.size();i++)
		{
		Assert.assertEquals(accountTabs.get(i).getText().replace("\n", "").trim(),accountsHyperLinks[i].trim(),accountTabs.get(i).getText().replace("\n", "").trim()+" is not displayed");	 
		}
		return this;
	}

	
	public MyAccountsPageObjects clickOnCartFileUpload() {
		try
		{
		Thread.sleep(4000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",cartFileUpload);
		return this;
	}

	public MyAccountsPageObjects verifyBreadCrumpAndHeadingOfCartFileUpload() {
		Waiting.explicitWaitVisibilityOfElement(fileUploadBreadCrump, 30);
		Assert.assertTrue(fileUploadBreadCrump.isDisplayed(), "file upload breadcrump is not displayed");
		Assert.assertTrue(fileUploadHeading.isDisplayed(), "file upload heading is not displayed");
		return this;
	}

	public MyAccountsPageObjects fileUpload(String filePath) {
		
		browseButton.sendKeys(filePath);
		return this;
	}

	public MyAccountsPageObjects clickOnUpload() {
		Waiting.explicitWaitVisibilityOfElement(uploadFileButton, 5);
		uploadFileButton.click();
		return this;
		
	}

	public MyAccountsPageObjects verifyQuickCartPage() {
		Waiting.explicitWaitVisibilityOfElement(quickCartTable, 120);
		
		Assert.assertTrue(quickCartTable.isDisplayed(),"quick cart table is not displayed");
		Assert.assertTrue(quickCartHeading.isDisplayed(), "quick cart heading is not displayed");
		return this;
	}
	
	
	public MyAccountsPageObjects verifyQuickCartBreadCrump(){
		Assert.assertTrue(quickCartBreadCrump.isDisplayed(), "quick cart breadcrump is not displayed");
		return this;
	}

	public MyAccountsPageObjects selectPartNumberFromDropdown() {
		
		TestUtility.selectByVisibleText(selectItemTypeInQuickCart, "HGH Part Number");
		return this;
	}

	public MyAccountsPageObjects clickOnRequestForQuote() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",requestForQuoteLink);
		return this;
	}

	public MyAccountsPageObjects verifyRequestForQuoteHeadingAndBreadcrump() {
		Waiting.explicitWaitVisibilityOfElement(requestForQuoteBreadCrump, 10);
		Assert.assertTrue(requestForQuoteBreadCrump.isDisplayed(),"request for quote bread crump is not displayed");
		Assert.assertTrue(requestForQuoteHeading.isDisplayed(),"request for quote heading is not displayed");
		return this;
		
	}

	public MyAccountsPageObjects enterPhoneNumberForRequestQuote() throws Exception {
		enterPhoneNumberForRequestQuote.clear();
		enterPhoneNumberForRequestQuote.sendKeys(data.getPhoneNumber());
		return this;
		
	}

	public MyAccountsPageObjects enterRequestDetails() throws Exception {
		String mpn [] = data.getMPN().split(",");
		String brandName []  = data.getBrandNameForRequestQuote().split(",");
		String quantity []  = data.getQunatityForRequestQuote().split(",");
		int n = Integer.parseInt(data.getNumberOfRowsToEnter());
		for(int i=0;i<n;i++)
		{
			
			mpnRequestQuote.get(i).click();
			mpnRequestQuote.get(i).sendKeys(mpn[i]);
			brandNameRequestQuote.get(i).click();
			brandNameRequestQuote.get(i).sendKeys(brandName[i]);
			quantityRequestQuote.get(i).click();
			quantityRequestQuote.get(i).sendKeys(quantity[i]);
			commentsSectionRequestQuote.click();
			commentsSectionRequestQuote.sendKeys(data.getCommentForRequestQuote());
		}
		return this;
	}

	public MyAccountsPageObjects clickSubmit() {
		
		submitButtonRequestQuote.click();
		return this;
	}

	public MyAccountsPageObjects clickOnOkForAfterCompletionOfRequestForQuote() {
		Waiting.explicitWaitVisibilityOfElement(popUpOkRequestQuote, 10);
	    popUpOkRequestQuote.click();
	    return this;
	}

	public MyAccountsPageObjects verifyQuickOrderPadBreadCrump() {
		Assert.assertTrue(quickOrderPadBreadCrump.isDisplayed(), "quick order pad breadcrump is not displayed");
		return this;
	}

	public MyAccountsPageObjects clickOnOpenOrders() {
		
		return this;
	}
}
	
	
