package org.etna.customer.pageobjects;
import java.util.List;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class ProductsDetailsPageObjects extends MainController{
   Actions action = new Actions(driver);

SearchDataPropertyFile data = new SearchDataPropertyFile();
ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	@FindBy(className="cimm_prodDetailTitle")
	private WebElement itemTitleLocator;

	@FindBy(xpath="//input[@class='quantity']")
	public WebElement quantityTextbox;
	
	@FindBy(xpath="//a[@class='log-addTocart-btn addToCart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="(//a[contains(text(),'Checkout')])[2]")
	private WebElement checkoutButton;
	
	@FindBy(className="cimm_itemShortDesc")
	private WebElement shortDescriptionLocator;
	
	@FindBy(xpath="//span[contains(text(),'MPN')]/following-sibling::span")
	private WebElement mpnValue;
	
	@FindBy(xpath="//li[@id='mPartNo']/b")
	private WebElement mpnLabel;
	
	@FindBy(xpath="//span[contains(.,'My Product Group')]")
	private WebElement myProductGroupButton;
	
	@FindBy(xpath="//span[contains(text(),'Customer Part Number')]/ancestor::a")
	private WebElement addOrRemoveCustomerPartNumberButton;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='resp-tabs-list domtabs']/descendant::span")})
	private List<WebElement> productDetailsTabs;
	
	@FindBy(xpath="//a[@title='Send this Page']")
	private WebElement sendThisPageLink;
	
	@FindBy(xpath="//a[@title='Print this page']")
	private WebElement printThisPageLink;
	
	@FindBy(xpath="//li[@id='sitePartNo']/b")
	private WebElement partNumberLabel;
	
	@FindBy(xpath="//li[@id='minOrdQty']/b")
	private WebElement minimumOrderQuantityLabel;
	
	@FindBy(xpath="//li[@id='qtyInt']/b")
	private WebElement quantityIntervalLabel;
	
	@FindBy(xpath="//div[@id='ProdRating']")
	private WebElement proRatingLabel;

	@FindBy(xpath="//li[@class='hideForPrint']/b")
	private WebElement quantityLabel;
	
	@FindBy(xpath="//div[@id='yourPrices']/b")
	private WebElement yourPriceLabel;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/li")})
	public List<WebElement> breadCrumps;
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]/following-sibling::span")
	private WebElement filterManufactureresToggleButtonLocator;
	
	@FindBy(xpath="//h4[contains(text(),'Manufacturers')]")
	private WebElement filterManufacturersHeading;
	
	@FindBy(xpath="//b[contains(text(),'Print')]/ancestor::a")
	private WebElement printLink;
	
	@FindBy(xpath="//b[contains(text(),'Share')]/ancestor::a")
	private WebElement shareLink;
	
	@FindAll(value={@FindBy(xpath="//div[@class='productAccordionWrap']/descendant::li/descendant::span")})
	private List<WebElement> accordiansLocator;
	
	@FindBy(xpath="//span[contains(text(),'My Product Group')]")
	private WebElement addToMyProductGroupButton;
	
	@FindBy(xpath="//li[@id='shipBranchNames']/b")
	private WebElement shipBranchNameLabel;
	
	@FindBy(xpath="//li[@id='upcNo']/b")
	private WebElement upcLabel;
	
	@FindBy(xpath="//a[@class='imgEnlargeIcon']")
	private WebElement enlargeIcon;
	
	@FindBy(xpath="//a[@class='imgEnlargeIcon']/preceding-sibling::a/descendant::div[@class='zoomPad']/img")
	private WebElement productImage;
	
	@FindBy(xpath="//img[@id='fullResImage']")
	private WebElement fullProductImage;
	
	@FindBy(xpath="//div[@id='drpdwnDiv']/descendant::li/input")
	private WebElement myProductGroupTextbox;
	
	@FindBy(xpath="//div[@id='popSelector']/descendant::a")
	private WebElement productGroupCreationMsg;
	
	@FindBy(xpath="//ul/descendant::a[contains(text(),'My Product Groups')]")
	private WebElement myProductGroupsUnderGroups;
	
	@FindBy(xpath="//h4[contains(text(),'Groups')]/following-sibling::span")
	private WebElement groupsToggleButton;
	
	@FindBy(xpath="//span[contains(text(),'Customer Part Number')]")
	private WebElement customerPartNumberButton;
	
	@FindBy(xpath="//input[@id='newCustomerPartNumber']")
	private WebElement customerPartNumberTextbox;
	
	@FindBy(id="add")
	private WebElement addButton;
	
	
	@FindBy(id="remove")
	private WebElement removeButton;
	
	@FindAll(value={@FindBy(xpath="//dl/descendant::h4")})
	private List <WebElement> leftPanelNames; 
	
	@FindAll(value={@FindBy(xpath="//dl/descendant::h4/following-sibling::span")})
	private List <WebElement> toggleButtons;
	
	public ProductsDetailsPageObjects verifyDisplayOfItemName(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(itemTitleLocator, 5);
		Assert.assertTrue(itemTitleLocator.getText().trim().toUpperCase().contains(searchTextUpperCase.replace(" ", "")),"product brand name does not contain the search text. Item name from web : "+itemTitleLocator.getText().trim().toUpperCase()+". "+"Expected is : "+searchTextUpperCase);
		return this;
	}


	public ProductsDetailsPageObjects verifyPDPFilterSectionNOTLoggedIn() {
		Assert.assertTrue(productListPage().filterSectionLocator.isDisplayed(), "Filter section is not displayed in the PDP page.");
		String a[] = data.getFilterNamesInPDPNOTLogin().split(",");
		for(int i = 0 ; i<leftPanelNames.size(); i++)
		{
			Assert.assertEquals(leftPanelNames.get(i).getText().trim().toLowerCase(), a[i].trim().toLowerCase(),"Getting left Panel name as "+leftPanelNames.get(i).getText().trim()+" but expected "+a[i].trim()+". ");
		}
		
		return this;
	}

	public ProductsDetailsPageObjects verifyDisplayOfShortDescription(String searchText)
	{
		
		Assert.assertTrue(assertDisplayOfShortDescription(searchText), "short description does not contain the search text. Actual : "+shortDescriptionLocator.getText().trim()+".");
		return this;
		
	}
	
	public boolean assertDisplayOfShortDescription(String searchText) {
		boolean t = shortDescriptionLocator.getText().trim().toUpperCase().contains(searchText.toUpperCase().replace(" ", ""));
		return t;
	}


	public ProductsDetailsPageObjects verifyDisplayOfPartNumber() {
		Assert.assertEquals(partNumberLabel.getText().replace(":","").trim(),"PN");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfMPN() {
		Assert.assertEquals(mpnLabel.getText().replace(":","").trim(), "MPN");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfMinimumOrderQuantity() {
		Assert.assertEquals(minimumOrderQuantityLabel.getText().replace(":","").trim(), "Min. Order Qty");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfQuantityInterval() {
		Assert.assertEquals(quantityIntervalLabel.getText().replace(":","").trim(), "Qty. Interval");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfYourPrice() {
		Assert.assertEquals(yourPriceLabel.getText().replace(":","").trim(), "Your Price");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfQuantity() {
		Assert.assertEquals(quantityLabel.getText().replace(":","").trim(), "Qty");
		
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfPrintLink() {
		Assert.assertTrue(printLink.isDisplayed());
		return this;
	}
	
	public ProductsDetailsPageObjects verifyToolTipOfPrintLink() {
	TestUtility.verifyToolTip(printLink,"Print this page");
	return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfShare() {
		Assert.assertTrue(shareLink.isDisplayed());
		return this;
	}
	
	public ProductsDetailsPageObjects verifyToolTipOfShareLink() {
		TestUtility.verifyToolTip(shareLink,"Send this Page");
		return this;
		}


	public ProductsDetailsPageObjects verifyDisplayOfAccordians() {
		Assert.assertTrue(assertAccordiansLocator());
		return this;
		
	}


	private boolean assertAccordiansLocator() {
		if(accordiansLocator.size()>=1)
		{
			return true;
		}
		else
		{
			return false;
	}
}


	public ProductsDetailsPageObjects verifyDisplayOfCustomerPartNumberButton() {
		Assert.assertTrue(addOrRemoveCustomerPartNumberButton.isDisplayed(),"add or remove customer part number is not displayed.");
		return this;
	}


	public ProductsDetailsPageObjects verifyAddToCartButton() {
		
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfAddMyProductGroupButton() {
		Assert.assertTrue(addToMyProductGroupButton.isDisplayed(),"add to my product group button is not displayed.");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfShipBranchName() {
		Assert.assertEquals(shipBranchNameLabel.getText().replace(":","").trim(), "Ship Branch Name");
		return this;
	}


	public ProductsDetailsPageObjects verifyDisplayOfUPC() {
		Assert.assertEquals(upcLabel.getText().replace(":","").trim(), "UPC");
		return this;
	}


	public ProductsDetailsPageObjects clickOnEnlargeIcon() {
		Waiting.explicitWaitVisibilityOfElement(enlargeIcon, 10);
		enlargeIcon.click();
		return this;
	}


	public int getHeightOfTheImage() {
		Waiting.explicitWaitVisibilityOfElement(productImage, 20);
		Integer height = Integer.parseInt(productImage.getAttribute("height"));
		int intheight = height.intValue();
		return intheight;
	}
	
	public int getWidthOfTheImage() {
		
		Integer width = Integer.parseInt(productImage.getAttribute("width"));
		int intwidth = width.intValue();
		return intwidth;
	}


	public ProductsDetailsPageObjects verifyImageHeightAndWidthAfterEnlarge(int height,int width) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertTrue(assertImageHeight(height),"The enlarged image height is less than the image present in the PDP page.");
		Assert.assertTrue(assertImageWidth(width),"The enlarged image width is less than the image present in the PDP page.");
		return this;
		
	}


	private boolean assertImageWidth(int height) {
		Integer heightFromWeb = Integer.parseInt(fullProductImage.getAttribute("height").replace("px", "").trim());
		int actualHeight = heightFromWeb.intValue();
		if(actualHeight>=height)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	private boolean assertImageHeight(int width) {
		Integer widthFromWeb = Integer.parseInt(fullProductImage.getAttribute("width").replace("px", "").trim());
		int actualWidth = widthFromWeb.intValue();
		if(actualWidth>=width)
		{
			return true;
		}
		else
		{
		return false;
		}
	}


	public ProductsDetailsPageObjects verifyPDPPageTitle() throws Exception {
		if(setUp.getBrowser().equalsIgnoreCase("safari"))
		{
		Thread.sleep(3000);
		}
		String PDPTitle = driver.getTitle();
		Waiting.explicitWaitVisibilityOfElement(itemTitleLocator, 10);
		String itemName=itemTitleLocator.getText().trim();
		Assert.assertEquals(PDPTitle, itemName+" | "+setUp.getProductName().toUpperCase());
		return this;
	}


	public ProductsDetailsPageObjects verifyBreadCrump() {
		String itemName = itemTitleLocator.getText().trim();
		String lastBreadCrump = breadCrumps.get(breadCrumps.size()-1).getText().trim();
		Assert.assertEquals(itemName, lastBreadCrump.replace("/", "").trim(),"item name and the last breadcrump is not the same. Item name is : "+itemName +" and the last breadcrump is : "+ lastBreadCrump);
		return this;
	}


	public ProductsDetailsPageObjects clickOnMyProductGroupButton() {
		Waiting.explicitWaitVisibilityOfElement(myProductGroupButton, 15);
		myProductGroupButton.click();
		return this;
	}


	public ProductsDetailsPageObjects enterGroupName(String myProductGroupName) {
		Waiting.explicitWaitVisibilityOfElement(myProductGroupTextbox, 6);
		myProductGroupTextbox.sendKeys(myProductGroupName);
		return this;
	}


	public ProductsDetailsPageObjects hitEnter() {
		myProductGroupTextbox.sendKeys(Keys.ENTER);
		return this;
	}


	public ProductsDetailsPageObjects verifyMyProductCreationSuccessMsg(String myProductGroupName) {
		Waiting.explicitWaitVisibilityOfElement(productGroupCreationMsg, 10);
		Assert.assertEquals(productGroupCreationMsg.getText().trim(), itemTitleLocator.getText().trim()+" Added To Group - "+myProductGroupName);
		return this;
	}


	public MyProductGroupsPageObjects clickOnMyProductGroups() throws InterruptedException {
		groupsToggleButton.click();
		Thread.sleep(1500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",myProductGroupsUnderGroups);
		return new MyProductGroupsPageObjects();
	}


	public ProductsDetailsPageObjects clickOnAddOrRemoveCustomerPartNumber() throws Exception{
		Thread.sleep(2000);
		customerPartNumberButton.click();
		return this;
	}


	public ProductsDetailsPageObjects enterCPN(String customerPartNumber) throws Exception {
		Thread.sleep(3000);
	((JavascriptExecutor) driver).executeScript("document.getElementById('newCustomerPartNumber').value='"+customerPartNumber+"'");
		return this;
	}


	public ProductsDetailsPageObjects clickOnAddButton() throws InterruptedException {
		Thread.sleep(1500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()",addButton);
		return this;
	}


	public ProductsDetailsPageObjects clickOnCheckbox(String customerPartNumber) throws Exception {
	Thread.sleep(1500);
		String customerPartNumberCheckbox = "//input[@value='"+customerPartNumber+"']";
		driver.findElement(By.xpath(customerPartNumberCheckbox)).click();
		return this;
				
	}


	public ProductsDetailsPageObjects clickOnRemove() throws Exception{
		removeButton.click();
		Thread.sleep(1700);
		return this;
	}


	public boolean verifyDeletionOfCPN(String customerPartNumber) throws Exception {
		Thread.sleep(1500);
		try
		{
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+customerPartNumber+"')]")).isDisplayed());
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
		return false;
	}


	public ProductsDetailsPageObjects verifyPDPFilterSectionWhenLoggedIn() {
		String a[] = data.getFilterNamesInPDPAfterLogin().split(",");
		for(int i = 0 ; i<leftPanelNames.size(); i++)
		{
			Assert.assertEquals(leftPanelNames.get(i).getText().trim().toLowerCase(), a[i].trim().toLowerCase(),"Getting left Panel name as "+leftPanelNames.get(i).getText().trim()+" but expected "+a[i].trim()+". ");
		}
		return this;
	}
	
	public ProductsDetailsPageObjects verifyPDPFilterSectionToggleButtons(){
		Assert.assertEquals(leftPanelNames.size(), toggleButtons.size());
		return this;
	}


	public ProductsDetailsPageObjects clickOnAddToCartButton() {
		Waiting.explicitWaitVisibilityOfElement(addToCartButton, 10);
		addToCartButton.click();
		return this;
	}
}	

