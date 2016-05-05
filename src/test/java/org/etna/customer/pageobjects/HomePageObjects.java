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
	
	@FindBy(xpath="//div[@class='cimm_headerRight hideForDevices']/descendant::a[contains(text(),'Login')]")
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
	
	@FindAll(value={@FindBy(xpath="//div[@class='Widget_slideJssor']/descendant::img")})
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
	
	@FindBy(css="a[href='/SavedGroups/Products']")
	private WebElement myProductGroupsLinkInUserDropdown;
	
	@FindBy(css="ul[class='clearAfter']>li>a[href='/Brands']")
	private WebElement brandsLink;
	
	@FindBy(css="ul[class='clearAfter']>li>a[href='/Manufacturers']")
	private WebElement manufacturersLink;
	
	@FindBy(xpath="//h3[contains(text(),'Shop By Brands')]")
	private WebElement shopByBrandsHeading;
	
	@FindBy(xpath="//p[contains(text(),'Use the Shop By Brands to choose the particular brand related product list.')]")
	private WebElement brandsDropdownInstructions;
	
	@FindAll(value={@FindBy(xpath="//li[@id='brandLink']/descendant::li/a")})
	private List<WebElement> brandDropdownLinks;
	
	@FindAll(value={@FindBy(xpath="//li[@id='manufacturerLink']/descendant::li/a")})
	private List<WebElement> manufacturersDropdownLinks;
	
	@FindBy(xpath="//div[@class='cimm_shopByBrand']/descendant::a[@href='/Brands']")
	private WebElement viewAllBrandsLink;
	
	@FindBy(xpath="//div[@class='cimm_shopByManufacturer']/descendant::a[@href='/Manufacturers']")
	private WebElement viewAllManufacturersLink;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(text(),'Add New Purchasing Agent')]")
	private WebElement addNewPurchasingAgentInUserAccountDropdown;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(text(),'Manage Purchasing Agent')]")
	private WebElement managePurchasingAgentInUserAccountDropdown;
	
	@FindBy(xpath="//ul[@class='cimm_myAccountMenu']/descendant::a[contains(text(),'Disable Purchasing Agent')]")
	private WebElement disablePurchasingAgentInuserAccountDropdown;
	
	@FindBy(xpath="//a[@href='Products']")
	private WebElement productsLink;

	@FindBy(css=".cimm_myAccountMenu>li>a[href='/SavedGroups/Cart']")
	private WebElement mySaveCartLink;
	
	
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

	public HomePageObjects clickOnSearch() {
		searchButton.click();
		return this;
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
		Assert.assertTrue(userAccountDropdown.isDisplayed(), "user account dropdown is not displayed");;
		return this;
	}

	public HomePageObjects verifyWelcomeMsg(String expectedMsg) {
		try
		{
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 20);
		Assert.assertEquals(userAccountDropdown.getText().trim(), expectedMsg);
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			verifyWelcomeMsg(expectedMsg);
		}
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

	public MyProductGroupsPageObjects navigateToMyProductGroups() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",myProductGroupsLinkInUserDropdown);
		return new MyProductGroupsPageObjects();
	}

	public HomePageObjects hoverOverBrandsLink() {
		try
		{
		action.moveToElement(brandsLink).build().perform();
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			hoverOverBrandsLink();
		}
		return this;	
	}

	public HomePageObjects verifyShopByBrandsHeadingInBrandsDropdown(){
		Waiting.explicitWaitVisibilityOfElement(shopByBrandsHeading, 10);
		Assert.assertTrue(shopByBrandsHeading.isDisplayed(),"Shop by Brands Heading is not displayed.");
		return this;
	}
	
	public HomePageObjects brandsDropdownInstructions(){
		Assert.assertTrue(brandsDropdownInstructions.isDisplayed(),"Brands dropdown instructions is not displayed.");
		return this;
	}
	
	public HomePageObjects verifyBrandsDropdownLinks() throws Exception{
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			for(WebElement brandLinkDropdown : brandDropdownLinks)
			{
			Assert.assertTrue(brandLinkDropdown.isDisplayed(), "Brand dropdown Link is not displayed.");
			}
			Assert.assertTrue(viewAllBrandsLink.isDisplayed(),"View All Brands link is not displayed.");
		}
		for(WebElement brandLinkDropdown : brandDropdownLinks)
		{
		Assert.assertTrue(brandLinkDropdown.isDisplayed(), "Brand dropdown Link is not displayed.");
		}
		Assert.assertTrue(viewAllBrandsLink.isDisplayed(),"View All Brands link is not displayed.");
		return this;
	}
	public HomePageObjects verifyBrandsDropdown() throws Exception {
		verifyShopByBrandsHeadingInBrandsDropdown();
		brandsDropdownInstructions();
		verifyBrandsDropdownLinks();
		return this;
	}

	public HomePageObjects clickOnASpecificBrand(int specificBrand) {
		brandDropdownLinks.get(specificBrand-1).click();
		return this;
	}
	
	public HomePageObjects clickOnASpecificManufacturer(int specificManufacturer) {
		manufacturersDropdownLinks.get(specificManufacturer-1).click();
		return this;
	}
	

	public String getSpecificBrandLinkName(int specificBrand) {
		
		Waiting.explicitWaitVisibilityOfElements(brandDropdownLinks, 10);
		String brandName = brandDropdownLinks.get(specificBrand-1).getText().trim();
		return brandName;
	}
	
	public String getSpecificManufacturersLinkName(int specificManufacturer) {
		Waiting.explicitWaitVisibilityOfElements(manufacturersDropdownLinks, 10);
		String brandName = manufacturersDropdownLinks.get(specificManufacturer-1).getText().trim();
		return brandName;
	}

	public HomePageObjects verifyWhetherTitleAndBreadcrumpHaveTheManufacturersName(String manufacturerName) throws Exception{
		Thread.sleep(2000);
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim().
				contains(manufacturerName),
				"breadcrump is not the same as the manufacturer name clicked. BreadCrump is -"
				+ " "+productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1)
				.getText().replace("/", "").trim()+" , but manufacturer name is - "+manufacturerName+".");
		Assert.assertTrue(driver.getTitle().trim().contains(manufacturerName), "Title does not contain the manufacturer name.");
		return this;
	}
	
	
	public HomePageObjects verifyWhetherTitleAndBreadcrumpHaveTheBrandName(String brandName) throws Exception{
		Thread.sleep(2000);
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim().
				contains(brandName),
				"breadcrump is not the same as the brand name clicked. BreadCrump is -"
				+ " "+productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1)
				.getText().replace("/", "").trim()+" , but brand name is - "+brandName+".");
		Assert.assertTrue(driver.getTitle().trim().contains(brandName), "Title does not contain the brand name.");
		return this;
	}

	public ShopByBrandsPageObjects clickOnViewAllBrandsLink() {
		Waiting.explicitWaitVisibilityOfElement(viewAllBrandsLink,3);
		try
		{
		viewAllBrandsLink.click();
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			clickOnViewAllBrandsLink();
		}
		return new ShopByBrandsPageObjects();
	}

	public ShopByBrandsPageObjects clickOnBrandsLink() {
		Waiting.explicitWaitVisibilityOfElement(brandsLink, 6);
		brandsLink.click();
		return new ShopByBrandsPageObjects();
	}

	public HomePageObjects hoverOverManufacturersLink() {
		try
		{
	action.moveToElement(manufacturersLink).build().perform();
		}
		catch(StaleElementReferenceException e)
		{
			driver.navigate().refresh();
			hoverOverManufacturersLink();
		}
		return this;
	}

	public HomePageObjects verifyManufacturersDropdown() {
		Waiting.explicitWaitVisibilityOfElements(manufacturersDropdownLinks, 10);
		for(WebElement manufacturerLinkDropdown : manufacturersDropdownLinks)
		{
		Assert.assertTrue(manufacturerLinkDropdown.isDisplayed(), "Manufacturers dropdown Links are not displayed.");
		}
		Assert.assertTrue(viewAllManufacturersLink.isDisplayed(),"View All Manufacturers link is not displayed.");
		return this;
	}

	public ShopByManufacturersPageObjects clickOnViewAllManufacturersLink() {
		Waiting.explicitWaitVisibilityOfElement(viewAllManufacturersLink, 4);
		viewAllManufacturersLink.click();
		return new ShopByManufacturersPageObjects();
	}

	public ShopByManufacturersPageObjects clickOnManufacturersLink() {
		Waiting.explicitWaitVisibilityOfElement(manufacturersLink, 6);
		manufacturersLink.click();
		return new ShopByManufacturersPageObjects();
	}

	public HomePageObjects clickOnUserAccountDropdown() throws Exception {
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			Thread.sleep(1500);
		}
		else
		{
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdown, 10);
		
		}
		userAccountDropdown.click();
		return this;
	}

	public HomePageObjects verifyAddManageDisablePANewPurchasingAgentIsDisplayedInUserAccountDropdown() throws Exception {
		addNewPurchasingAgentInUserAccountDropdown();
		managePurchasingAgentInUserAccountDropdown();
		disablePurchasingAgentInuserAccountDropdown();
		return this;
	}
	
	public HomePageObjects addNewPurchasingAgentInUserAccountDropdown() throws Exception
	{
		if(setUp.getBrowser().equalsIgnoreCase("ghost"))
		{
			Thread.sleep(1000);
		}
		else
		{
		Waiting.explicitWaitVisibilityOfElement(addNewPurchasingAgentInUserAccountDropdown, 10);
		}
		Assert.assertTrue(addNewPurchasingAgentInUserAccountDropdown.isDisplayed(),"add new purchasing agent is not present in user account dropdown.");
		return this;
	}
	
	public HomePageObjects managePurchasingAgentInUserAccountDropdown()
	{
		Assert.assertTrue(managePurchasingAgentInUserAccountDropdown.isDisplayed(),"manage new purchasing agent is not present in user account dropdown.");
return this;
	}
	
	public HomePageObjects disablePurchasingAgentInuserAccountDropdown()
	{
		Assert.assertTrue(disablePurchasingAgentInuserAccountDropdown.isDisplayed(),"disable new purchasing agent is not present in user account dropdown.");
		return this;
	}

	public AddNewPurchasingAgentPageObjects clickOnAddNewPurchasingAgent() {
		Waiting.explicitWaitVisibilityOfElement(addNewPurchasingAgentInUserAccountDropdown, 10);
		addNewPurchasingAgentInUserAccountDropdown.click();
		return new AddNewPurchasingAgentPageObjects();	
	}

	public ProductPageObjects clickOnProductsLink() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",productsLink);
		return new ProductPageObjects();
	}

	public HomePageObjects clickOnMySaveCart() {
		Waiting.explicitWaitVisibilityOfElement(mySaveCartLink, 3);
		mySaveCartLink.click();
		return this;
	}

}
	
