package org.hgh.customer.pageobjects;
import java.util.List;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.PropertyFileReader;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class HGHHomePageObjects extends MainController{
	
   SearchDataPropertyFile data = new SearchDataPropertyFile();	
   Actions action = new Actions(driver);
   
	public HGHHomePageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
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
	
	@FindBy(xpath="//div[@class='gridListSwitchWrap']/a[@id='listView']/b")
	private WebElement listViewButton;
	
	@FindBy(xpath="//a[@href='Dashboard' and contains(text(),'My Accounts')]")
	private WebElement myAccountsLink;
	
	@FindBy(xpath="//a[contains(text(),'My Accounts')]")
	private WebElement myAccountsLocator;
	
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
	

	
	public boolean errorScenarios(String expectedMsg) {
		System.out.println(expectedMsg);
		boolean t = errorMsgLocator.getText().trim().equals(expectedMsg);
		return t;
	}

	public void clickLoginLink() {
		
		loginLinkLocator.click();
	}

	public boolean verifyWelcomeMsg() {
		Waiting.explicitWaitVisibilityOfElement(welcomeLocator, 10);
		boolean t = welcomeLocator.isDisplayed();
		return t;
		
	}

	public void assertForErrorMessages(String expectedMsg) {
		Assert.assertEquals(errorMsgLocator.getText().trim(),expectedMsg,errorMsgLocator.getText().trim()+" is displayed");
		
	}

	public void logout() {
		Waiting.explicitWaitVisibilityOfElement(logoutButton, 4);
		logoutButton.click();
	}
	
	public void verifyDisplayOfLoginLink(){
		Waiting.explicitWaitVisibilityOfElement(loginLinkLocator, 4);
		Assert.assertTrue(loginLinkLocator.isDisplayed(), "Login Link is not displayed");
	}

	public void searchText(String searchText) throws Exception {
		
		searchTextbox.sendKeys(searchText);
		
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

	public void clickOnSearch() {
		searchButton.click();
	}

	public void clickOnChangeView() {
		listViewButton.click();
		
	}

	public void clickOnMyAccounts() {
		Waiting.explicitWaitVisibilityOfElement(myAccountsLink, 5);
		myAccountsLink.click();
		
	}

	public void verifyDisplayOfMyAccountsInHeader() {
		Assert.assertTrue(myAccountsLocator.isDisplayed(), "My Accounts link is not displayed");
		
	}

	public void verifyDisplayOfOrderStatusInHeader() {
		Assert.assertTrue(orderStatusLinkHeader.isDisplayed(), "Order Status link is not displayed");
		
	}

	public void verifyDisplayOfOrderPadInHeader() {
		Assert.assertTrue(orderPadLinkHeader.isDisplayed(),"order pad link is not displayed");
		
	}

	public void verifyResourcesLinkInHeader() {
		
		Assert.assertTrue(resourcesLinkHeader.isDisplayed(), "resources link is not displayed");
	}

	public void verifyHelpLinkHeader() {
		Assert.assertTrue(helpLinkHeader.isDisplayed(), "resources link is not displayed");
	}

	public void verifyHeadingOfEverySectionInFooter() throws Exception {
		String footerHeadings[] =data.getFooterHeadings().split(",");
		for(int i=0;i<everyFooterHeader.size();i++)
		{ 
			everyFooterHeader.get(i).getText().trim().toLowerCase().equals(footerHeadings[i].toLowerCase().trim());
		}
		}

	public void verifyCustomerServiceLinkInFooter() {
		Assert.assertTrue(customerServiceLink.isDisplayed(), "customer service link is not displayed");
		
	}

	public void verifyHelpCenterInFooter() {
		Assert.assertTrue(helpCenterLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyHelpContactUsInFooter() {
		Assert.assertTrue(contactUsLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyReturnsInFooter() {
		Assert.assertTrue(returnsLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyShippingPolicyInFooter() {
		Assert.assertTrue(shippingPolicyLink.isDisplayed(), "customer service link is not displayed");
	}
	

	public void verifyMyAccountInFooter() {
		Assert.assertTrue(myAccountLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyOrderStatusInFooter() {
		Assert.assertTrue(orderStatusLink.isDisplayed(), "customer service link is not displayed");
	}

	public void verifyQuickOrderpadInFooter() {
		Assert.assertTrue(quickOrderpadLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyMyCartInFooter() {
		Assert.assertTrue(myCartLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyTradePartnersInFooter() {
		Assert.assertTrue(tradePartnersLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyLearningCenterInFooter() {
		Assert.assertTrue(learningCenterLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyManufacturersInFooter() {
		Assert.assertTrue(manufacturersLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyBlogInFooter() {
		Assert.assertTrue(blogLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifySecurityAndPrivacyInFooter() {
		Assert.assertTrue(securityAndPrivacyLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyTermsOfUseInFooter() {
		Assert.assertTrue(termsOfUseLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyAboutUsInFooter() {
		Assert.assertTrue(aboutUsLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyEventsInFooter() {
		Assert.assertTrue(eventsLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyBranchLocationInFooter() {
		Assert.assertTrue(branchLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifyCareersInFooter() {
		Assert.assertTrue(careersLink.isDisplayed(), "customer service link is not displayed");
	}
	
	public void verifySiteMapInFooter() {
		Assert.assertTrue(siteMapLink.isDisplayed(), "customer service link is not displayed");
	}

	public void verifyTaxonomies() throws Exception {
		String taxonomies[] = data.getTaxonomies().split(",");
		for(int i=0;i<taxonomiesInHeader.size();i++)
		{
			Assert.assertEquals(taxonomiesInHeader.get(i).getText().replace("\n", "").trim(), taxonomies[i].trim().toUpperCase(),taxonomies[i]+" is not displayed");
		}
		
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

	public void clickOnQuickOrderPadLink() {
		Waiting.explicitWaitVisibilityOfElement(quickOrderPadLink, 10);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();",quickOrderPadLink);
		
	}
}
	
	
