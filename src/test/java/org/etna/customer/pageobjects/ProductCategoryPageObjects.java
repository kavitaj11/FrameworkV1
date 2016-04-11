package org.etna.customer.pageobjects;
import java.util.List;

import org.etna.maincontroller.MainController;
import org.etna.utils.PropertyFileReader;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class ProductCategoryPageObjects extends MainController{
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
   Actions action = new Actions(driver);
   
	@FindBy(xpath="//div[@class='errMsg']")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="(//a[@href='/Login'])[1]")
	private WebElement loginLinkLocator;
	
	@FindBy(xpath="//li[@class='welcomeUser']")
	private WebElement welcomeLocator;
	
	@FindBy(xpath="(//a[contains(text(),'Logout')])[1]")
	public WebElement logoutButton;
	
	@FindBy(xpath="//input[@id='txtSearch']")
	private WebElement searchTextbox;

	@FindBy(xpath="//li[@class='ui-menu-item']")
	private List<WebElement> searchResultsLocator;
	
	@FindBy(xpath="//button[@id='performSearchBtn']")
	private WebElement searchButton;
	
	@FindBy(xpath="//ul[@class='pullRight']/descendant::a[@href='Dashboard']")
	private WebElement myAccountsLink;
	
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	private WebElement myAccountInHeader;
	
	
	@FindBy(xpath="//div[@class='cimm_headerTop']/descendant::a[contains(text(),'Order Status')]")
	private WebElement orderStatusLinkHeader;
	
	@FindBy(xpath="//div[@class='cimm_headerTop']/descendant::a[contains(text(),'Quick Order Pad')]")
	private WebElement orderPadLinkHeader;
	
	@FindBy(xpath="//div[@class='cimm_headerTop']/descendant::a[contains(text(),'Resources')]")
	private WebElement resourcesLinkHeader;
	
	@FindBy(xpath="//div[@class='cimm_headerTop']/descendant::a[contains(text(),'Help')]")
	private WebElement helpLinkHeader;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_footAccordion_head']")})
	private List<WebElement> everyFooterHeader;
	
	@FindBy(xpath="//a[contains(text(),'Customer Service')]")
	private WebElement customerServiceLink;
	
	@FindBy(xpath="//a[contains(text(),'Help Center')]")
	private WebElement helpCenterLink;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	private WebElement contactUsLink;
	
	@FindBy(xpath="//a[contains(text(),'Returns')]")
	private WebElement returnsLink;
	
	@FindBy(xpath="//a[contains(text(),'Shipping Policy')]")
	private WebElement shippingPolicyLink;
	
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//a[contains(text(),'Order Status')]")
	private WebElement orderStatusLink;
	
	@FindBy(xpath="//a[contains(text(),'Quick Order Pad')]")
	private WebElement quickOrderpadLink;
	
	@FindBy(xpath="//a[contains(text(),'My Cart')]")
	private WebElement myCartLink;
	
	@FindBy(xpath="//a[contains(text(),'Trade Partners')]")
	private WebElement tradePartnersLink;
	
	@FindBy(xpath="//a[contains(text(),'Learning Center')]")
	private WebElement learningCenterLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Manufacturers')]")
	private WebElement manufacturersLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	private WebElement blogLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Security & Privacy')]")
	private WebElement securityAndPrivacyLink;
	
	@FindBy(xpath="//a[contains(text(),'Terms of Use')]")
	private WebElement termsOfUseLink;
	
	@FindBy(xpath="//a[contains(text(),'About Us')]")
	private WebElement aboutUsLink;
	
	@FindBy(xpath="//a[contains(text(),'Events')]")
	private WebElement eventsLink;
	
	@FindBy(xpath="//a[contains(text(),'Branch Locations')]")
	private WebElement branchLink;
	
	@FindBy(xpath="//a[contains(text(),'Branch Locations')]")
	private WebElement careersLink;
	
	@FindBy(xpath="//a[contains(text(),'Site Map')]")
	private WebElement siteMapLink;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='splitTaxonomy']/li")})
	private List<WebElement> taxonomiesInHeader;
	
	@FindAll(value={@FindBy(xpath="//div[@class='cimm_locateSubContent']/descendant::li/p[not(contains(.,'Contact Us'))]")})
	private List<WebElement> firstBlockOfEveryAddress;
	
	@FindBy(xpath="//input[@id='selectedZipCode']")
	private WebElement zipCode;
	
	@FindBy(xpath="//select[@id='selectedMiles']")
	private WebElement selectMiles;
	
	@FindBy(xpath="//input[@id='findNowButton']")
	private WebElement findNowButton;
	
	@FindBy(xpath="//ul[@class='pullRight']/descendant::a[contains(text(),'Quick Order Pad')]")
	private WebElement quickOrderPadLink;
	
	@FindBy(css="")
	private WebElement focusTab;
	
	
	@FindBy(xpath="//a[@class='cimm_myaccountDropDown']")
	public WebElement userAccountDropdown;
	
	public ProductCategoryPageObjects errorScenarios(String expectedMsg) {
		System.out.println(expectedMsg);
		Assert.assertEquals(errorMsgLocator.getText().trim(), expectedMsg);
		return this;
	}

	public LoginPopUpPageObjects clickLoginLink() {
		Waiting.explicitWaitVisibilityOfElement(loginLinkLocator, 5);
		loginLinkLocator.click();
		return new LoginPopUpPageObjects();
	}

	public ProductCategoryPageObjects verifyWelcomeMsg() {
		try
		{
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 10);
		Assert.assertTrue(userAccountDropdown.isDisplayed(),"user dropdown is not displayed");
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			verifyWelcomeMsg();
		}
		return this;
		
	}

	public ProductCategoryPageObjects assertForErrorMessages(String expectedMsg) {
		Assert.assertEquals(errorMsgLocator.getText().trim(),expectedMsg,errorMsgLocator.getText().trim()+" is displayed");
		return this;
	}

	public ProductCategoryPageObjects logout() {
		logoutButton.click();
		return this;
	}
	
	public ProductCategoryPageObjects verifyDisplayOfLoginLink(){
		Waiting.explicitWaitVisibilityOfElement(loginLinkLocator, 4);
		Assert.assertTrue(loginLinkLocator.isDisplayed(), "Login Link is not displayed");
		return this;
	}

	public ProductCategoryPageObjects searchText(String searchText) throws Exception {
		
		searchTextbox.sendKeys(searchText);
		return this;
	}

	public void chooseOption(String textToChoose) {
		Waiting.explicitWaitVisibilityOfElements(searchResultsLocator, 10);
		for(WebElement option : searchResultsLocator)
		{
		if(option.getText().trim().equals(textToChoose))
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",option);
		}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
	}

	public ProductsListPageObjects clickOnSearch() {
		searchButton.click();
		return new ProductsListPageObjects();
	}

	

	public MyAccountsPageObjects clickOnMyAccounts() {
		Waiting.explicitWaitVisibilityOfElement(myAccountsLink, 5);
		myAccountsLink.click();
		return new MyAccountsPageObjects();
		
	}

	public ProductCategoryPageObjects verifyDisplayOfMyAccountsInHeader() {
		Assert.assertTrue(myAccountInHeader.isDisplayed(), "My Account link is not displayed");
		return this;
	}

	public ProductCategoryPageObjects verifyDisplayOfOrderStatusInHeader() {
		Assert.assertTrue(orderStatusLinkHeader.isDisplayed(), "Order Status link is not displayed");
		return this;
	}

	public ProductCategoryPageObjects verifyDisplayOfOrderPadInHeader() {
		Assert.assertTrue(orderPadLinkHeader.isDisplayed(),"order pad link is not displayed");
		return this;
	}

	public ProductCategoryPageObjects verifyResourcesLinkInHeader() {
		
		Assert.assertTrue(resourcesLinkHeader.isDisplayed(), "resources link is not displayed");
	return this;
	}

	public ProductCategoryPageObjects verifyHelpLinkHeader() {
		Assert.assertTrue(helpLinkHeader.isDisplayed(), "help link is not displayed");
		return this;
	}

	public ProductCategoryPageObjects verifyHeadingOfEverySectionInFooter() throws Exception {
		String footerHeadings[] =data.getFooterHeadings().split(",");
		for(int i=0;i<everyFooterHeader.size();i++)
		{ 
			Assert.assertEquals(everyFooterHeader.get(i).getText().trim().toLowerCase(),footerHeadings[i].toLowerCase().trim());
			
		}
		return this;
		}

	public ProductCategoryPageObjects verifyCustomerServiceLinkInFooter() {
		Assert.assertTrue(customerServiceLink.isDisplayed(), "customer service link is not displayed");
		return this;
		
	}

	public ProductCategoryPageObjects verifyHelpCenterInFooter() {
		Assert.assertTrue(helpCenterLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyHelpContactUsInFooter() {
		Assert.assertTrue(contactUsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyReturnsInFooter() {
		Assert.assertTrue(returnsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyShippingPolicyInFooter() {
		Assert.assertTrue(shippingPolicyLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	

	public ProductCategoryPageObjects verifyMyAccountInFooter() {
		Assert.assertTrue(myAccountLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyOrderStatusInFooter() {
		Assert.assertTrue(orderStatusLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}

	public ProductCategoryPageObjects verifyQuickOrderpadInFooter() {
		Assert.assertTrue(quickOrderpadLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyMyCartInFooter() {
		Assert.assertTrue(myCartLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyTradePartnersInFooter() {
		Assert.assertTrue(tradePartnersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyLearningCenterInFooter() {
		Assert.assertTrue(learningCenterLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyManufacturersInFooter() {
		Assert.assertTrue(manufacturersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyBlogInFooter() {
		Assert.assertTrue(blogLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifySecurityAndPrivacyInFooter() {
		Assert.assertTrue(securityAndPrivacyLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyTermsOfUseInFooter() {
		Assert.assertTrue(termsOfUseLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyAboutUsInFooter() {
		Assert.assertTrue(aboutUsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyEventsInFooter() {
		Assert.assertTrue(eventsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyBranchLocationInFooter() {
		Assert.assertTrue(branchLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifyCareersInFooter() {
		Assert.assertTrue(careersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public ProductCategoryPageObjects verifySiteMapInFooter() {
		Assert.assertTrue(siteMapLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}

	public ProductCategoryPageObjects verifyTaxonomies() throws Exception {
		String taxonomies[] = data.getTaxonomies().split(",");
		for(int i=0;i<taxonomiesInHeader.size();i++)
		{
			Assert.assertEquals(taxonomiesInHeader.get(i).getText().replace("\n", "").trim(), taxonomies[i].trim().toUpperCase(),taxonomies[i]+" is not displayed");
		}
		return this;
		
	}

	public void findNow() throws Exception {
		String text = PropertyFileReader.propertiesReader(searchData, "miles");
		for(int i=1;i<=2500;i++)
		{
			Thread.sleep(2000);
			String x = driver.findElement(By.xpath("(//div[@class='cimm_locateSubContent']/descendant::li/p[not(contains(.,'Contact Us'))])"+"[1]")).getText().replace("\n", "");
			String lastword = x.substring(x.lastIndexOf(" ")+1);
			zipCode.clear();
			zipCode.sendKeys(lastword);
			Select select = new Select(selectMiles);
			select.selectByVisibleText(text);
			findNowButton.click();
		}
	}

	public MyAccountsPageObjects clickOnQuickOrderPadLink() {
		Waiting.explicitWaitVisibilityOfElement(quickOrderPadLink, 10);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",quickOrderPadLink);
		return new MyAccountsPageObjects();
		
	}

	public ProductCategoryPageObjects verifyTabFocus() {
		focusTab.isDisplayed();
		return this;
		
	}

	public ProductCategoryPageObjects waitForLogoutLink() {
		Waiting.explicitWaitVisibilityOfElement(logoutButton, 10);
		return this;
	}

	public ProductCategoryPageObjects verifyWelcomeMsg(String expectedMsg) {
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 20);
		Assert.assertEquals(userAccountDropdown.getText().trim(), expectedMsg);
		return this;
	}
	}

	
	
