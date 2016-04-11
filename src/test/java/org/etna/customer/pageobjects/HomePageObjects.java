package org.etna.customer.pageobjects;
import java.util.List;

import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
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
public class HomePageObjects extends MainController{
	 SearchDataPropertyFile data = new SearchDataPropertyFile();
	 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
   Actions action = new Actions(driver);
   
	@FindBy(id="pLoginErr")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="//a[contains(.,'Log in')]")
	private WebElement loginLinkLocator;
	
	@FindBy(xpath="//li[@class='welcomeUser']")
	private WebElement welcomeLocator;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(.,'Log Out')]")
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
	
	
	@FindBy(xpath="//img[@alt='Logo']")
	private WebElement logo;
	
	String faviconURL="//link[@href='/ASSETS/WEB_THEMES//ETNA_SUPPLY_COMPANY/images/favicon.ico']";
	
	
	@FindBy(xpath="//label[contains(.,'Featured Products')]")
	private WebElement featuredProductsHeading;
	
	@FindBy(xpath="//ul[@id='featuredProductList']")
	private WebElement featuredProductsList;
	
	@FindBy(xpath="//span[@class='foot_copy halfBlokWrap']")
	private WebElement copyRightsOfUnilog;
	
	@FindAll(value={@FindBy(xpath="(//div[@class='slick-track'])[1]/descendant::img")})
	private List<WebElement> carouselImages;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='clearAfter']/li/a")})
	private List<WebElement> mainSectionOptions;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='clearAfter']/descendant::a")})
	private List<WebElement> allSections;
	
	@FindBy(className="cartCountDisplayLi")
	private WebElement cartCountLink;
	
	@FindBy(className="cartTotalDisplayLi")
	private WebElement cartTotalLink;
	
	@FindBy(xpath="//a[contains(.,'Sign Up')]")
	private WebElement signUpLink;
	
	@FindAll(value={@FindBy(xpath="//div[@class='footerCol']/descendant::a")})
	private List<WebElement> footerSection;
	
	public HomePageObjects errorScenarios(String expectedMsg) {
		System.out.println(expectedMsg);
		Assert.assertEquals(errorMsgLocator.getText().trim(), expectedMsg);
		return this;
	}

	public LoginPopUpPageObjects clickLoginLink() {
		Waiting.explicitWaitVisibilityOfElement(loginLinkLocator, 20);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",loginLinkLocator);
		return new LoginPopUpPageObjects();
	}

	public HomePageObjects verifyWelcomeMsg() {
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

	public HomePageObjects assertForErrorMessages(String expectedMsg) {
		Waiting.explicitWaitVisibilityOfElement(errorMsgLocator, 10);
		Assert.assertEquals(errorMsgLocator.getText().trim(),expectedMsg,errorMsgLocator.getText().trim()+" is displayed");
		return this;
	}

	public HomePageObjects logout() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",logoutButton);
		return this;
	}
	
	public HomePageObjects verifyDisplayOfLoginLink(){
		Waiting.explicitWaitVisibilityOfElement(loginLinkLocator, 4);
		Assert.assertTrue(loginLinkLocator.isDisplayed(), "Login Link is not displayed");
		return this;
	}

	public HomePageObjects searchText(String searchText) throws Exception {
		Waiting.explicitWaitVisibilityOfElement(searchTextbox, 20);
		searchTextbox.clear();
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

	public HomePageObjects verifyDisplayOfMyAccountsInHeader() {
		Assert.assertTrue(myAccountInHeader.isDisplayed(), "My Account link is not displayed");
		return this;
	}

	public HomePageObjects verifyDisplayOfOrderStatusInHeader() {
		Assert.assertTrue(orderStatusLinkHeader.isDisplayed(), "Order Status link is not displayed");
		return this;
	}

	public HomePageObjects verifyDisplayOfOrderPadInHeader() {
		Assert.assertTrue(orderPadLinkHeader.isDisplayed(),"order pad link is not displayed");
		return this;
	}

	public HomePageObjects verifyResourcesLinkInHeader() {
		
		Assert.assertTrue(resourcesLinkHeader.isDisplayed(), "resources link is not displayed");
	return this;
	}

	public HomePageObjects verifyHelpLinkHeader() {
		Assert.assertTrue(helpLinkHeader.isDisplayed(), "help link is not displayed");
		return this;
	}

	public HomePageObjects verifyHeadingOfEverySectionInFooter() throws Exception {
		String footerHeadings[] =data.getFooterHeadings().split(",");
		for(int i=0;i<everyFooterHeader.size();i++)
		{ 
			Assert.assertEquals(everyFooterHeader.get(i).getText().trim().toLowerCase(),footerHeadings[i].toLowerCase().trim());
			
		}
		return this;
		}

	public HomePageObjects verifyCustomerServiceLinkInFooter() {
		Assert.assertTrue(customerServiceLink.isDisplayed(), "customer service link is not displayed");
		return this;
		
	}

	public HomePageObjects verifyHelpCenterInFooter() {
		Assert.assertTrue(helpCenterLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyHelpContactUsInFooter() {
		Assert.assertTrue(contactUsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyReturnsInFooter() {
		Assert.assertTrue(returnsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyShippingPolicyInFooter() {
		Assert.assertTrue(shippingPolicyLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	

	public HomePageObjects verifyMyAccountInFooter() {
		Assert.assertTrue(myAccountLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyOrderStatusInFooter() {
		Assert.assertTrue(orderStatusLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}

	public HomePageObjects verifyQuickOrderpadInFooter() {
		Assert.assertTrue(quickOrderpadLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyMyCartInFooter() {
		Assert.assertTrue(myCartLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyTradePartnersInFooter() {
		Assert.assertTrue(tradePartnersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyLearningCenterInFooter() {
		Assert.assertTrue(learningCenterLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyManufacturersInFooter() {
		Assert.assertTrue(manufacturersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyBlogInFooter() {
		Assert.assertTrue(blogLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifySecurityAndPrivacyInFooter() {
		Assert.assertTrue(securityAndPrivacyLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyTermsOfUseInFooter() {
		Assert.assertTrue(termsOfUseLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyAboutUsInFooter() {
		Assert.assertTrue(aboutUsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyEventsInFooter() {
		Assert.assertTrue(eventsLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyBranchLocationInFooter() {
		Assert.assertTrue(branchLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifyCareersInFooter() {
		Assert.assertTrue(careersLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}
	
	public HomePageObjects verifySiteMapInFooter() {
		Assert.assertTrue(siteMapLink.isDisplayed(), "customer service link is not displayed");
		return this;
	}

	public HomePageObjects verifyTaxonomies() throws Exception {
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

	public HomePageObjects verifyTabFocus() {
		focusTab.isDisplayed();
		return this;
		
	}

	public HomePageObjects waitForProfileDropdownLink() {
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 20);
		Assert.assertTrue(productCategoryPage().userAccountDropdown.isDisplayed(), "user account dropdown is not displayed");;
		return this;
	}

	public HomePageObjects verifyWelcomeMsg(String expectedMsg) {
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 20);
		Assert.assertEquals(userAccountDropdown.getText().trim(), expectedMsg);
		return this;
	}

	public HomePageObjects verifyLogo() {
		Assert.assertEquals(logo.getAttribute("src").trim(),data.getLogo());
		return this;
	}

	public HomePageObjects verifyFavicon() throws Exception {
		Assert.assertEquals(driver.findElement(By.xpath(faviconURL)).getAttribute("href").trim(), data.getFaviconURL());
		return this;
	}
	
	public HomePageObjects verifyFeaturedProductsHeading() {
		Assert.assertTrue(featuredProductsHeading.isDisplayed(),"featured products heading is not displayed");
		return this;
	}

	public HomePageObjects verifyFeaturedProductsList() {
		Assert.assertTrue(featuredProductsList.isDisplayed(),"featured products list is not displayed");
		return this;
	}
	
	public HomePageObjects verifyCopyRightsOfUnilog() {
		Assert.assertEquals(copyRightsOfUnilog.getText().trim(),"© Unilog, Co. 2016 - All Right Reserved");
		return this;
	}
	
	
	
	public HomePageObjects verifyFeaturedProductsSection() {
		verifyFeaturedProductsHeading();
		verifyFeaturedProductsList();
		return this;
	}

	public HomePageObjects verifyCarousel() throws Exception {
		String [] expectedCarouselImages = data.getCarouselImages().split(",");
		for(int i=0;i<carouselImages.size();i++)
		{
		Assert.assertEquals(carouselImages.get(i).getAttribute("src").trim(),setUp.getURL()+expectedCarouselImages[i]);
		
	}
		return this;
	}

	public HomePageObjects verifyMainSectionOptions() throws Exception {
		String [] expectedMainSectionOptions = data.getMainSectionOptions().split(",");
		for(int i=0;i<mainSectionOptions.size();i++)
		{
		Assert.assertEquals(mainSectionOptions.get(i).getText().toUpperCase().trim(),expectedMainSectionOptions[i].toUpperCase());
		
	}
		return this;
	}
	
	
	public HomePageObjects verifyHomePage() throws Exception {
		verifyLogo();
		verifyCopyRightsOfUnilog();
		verifyFavicon();
		verifyCarousel();
		verifyFeaturedProductsSection();
		verifySectionsAndSubsections();
		verifyDisplayOfSearchTextboxButton();
		verifyHeaderSection();
		verifyFooterSectionLinksText();
		return this;
	}
	
	public HomePageObjects verifyFooterSectionLinksText() {
		String[] expectedFooterLinks = data.getFooterLinksText().split(",");
		for(int i=0;i<footerSection.size();i++)
		{
		Assert.assertEquals(footerSection.get(i).getText().trim(),expectedFooterLinks[i].trim());
		}
		return this;
		
	}
	
	public HomePageObjects verifyHeaderSection() {
		verifyDisplayOfLoginLink();
		verifySignUpLink();
		verifyCartCountLink();
		verifyCartTotalLink();
		return this;
		
	}

	public HomePageObjects verifySignUpLink() {
		Assert.assertTrue(signUpLink.isDisplayed(), "sign up link is not displayed");;
		return this;
	}
	
	public HomePageObjects verifyCartCountLink() {
		Assert.assertTrue(cartCountLink.isDisplayed(), "cart count link is not displayed");;
		return this;
	}
	
	public HomePageObjects verifyCartTotalLink() {
		Assert.assertTrue(cartTotalLink.isDisplayed(), "cart total link is not displayed");;
		return this;
	}

	public boolean verifyDisplayOfSearchTextboxButton() {
		Assert.assertTrue(searchTextbox.isDisplayed(), "search Textbox is not displayed");
		Assert.assertTrue(searchButton.isDisplayed(),"search Button is not displayed");
		return true;
		
	}

	public HomePageObjects verifyMainSectionOptionPages() {
		String [] expectedMainSectionOptions = data.getMainSectionOptions().split(",");
		for(int i=0;i<mainSectionOptions.size();i++)
		{
		Assert.assertEquals(mainSectionOptions.get(i).getText().toUpperCase().trim(),expectedMainSectionOptions[i].toUpperCase());
		
	}
		return this;
	}

	public HomePageObjects verifySectionsAndSubsections() {
		
		String[] s = data.getAllSectionsText().split(",");
		for(int i=0;i<allSections.size();i++)
		{
			String x = allSections.get(i).getAttribute("href").trim();
			String y = x.substring(x.lastIndexOf("/")+1);
		Assert.assertEquals(y, s[i]);
		}
		return this;
	}

	public HomePageObjects clickOnLogo() {
		logo.click();
		return this;
	}
}

	
	
