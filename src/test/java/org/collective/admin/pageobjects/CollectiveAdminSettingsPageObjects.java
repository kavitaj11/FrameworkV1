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
public class CollectiveAdminSettingsPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminSettingsPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'General Settings')]")
	private WebElement settingsHeader;
	
	@FindBy(xpath="//label[text()='Site Name']")
	private WebElement siteNameLabel;
	
	@FindBy(xpath="//input[@id='store_name']")
	private WebElement siteNameTextBox;
	
	@FindBy(xpath="//label[text()='Seo Title']")
	private WebElement seoLabel;
	
	@FindBy(xpath="//input[@id='store_seo_title']")
	private WebElement seoTextbox;
	
	@FindBy(xpath="//label[text()='Meta Keywords']")
	private WebElement metaKeywordsLabel;
	
	@FindBy(xpath="//input[@id='store_meta_keywords']")
	private WebElement metaKeywordsTextbox;

	@FindBy(xpath="//label[text()='Meta Description']")
	private WebElement filterResultsButtonReturnsTab;
	
	@FindBy(xpath="//label[text()='Meta Description']")
	private WebElement metaDescriptionLabel;
	
	@FindBy(xpath="//input[@id='store_meta_keywords']")
	private WebElement metaDescriptionTextbox;
	
	@FindBy(xpath="//label[text()='Site URL']")
	private WebElement siteURLTab;
	
	@FindBy(xpath="//fieldset[@class='security no-border-bottom']")
	private WebElement securitySettings;
	
	@FindBy(xpath="//fieldset[@class='currency no-border-bottom']")
	private WebElement currencySettings;
	
	@FindBy(xpath="//span[text()='Invoices Settings']/ancestor::fieldset[@class='currency no-border-bottom']")
	private WebElement invoiceSettings;
	
	@FindBy(xpath="//span[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateButton;
	
	@FindBy(xpath="//aside[@id='sidebar']")
	private WebElement configurationsSettings;


	
	public void verifySettingsPage() {
		Waiting.explicitWaitVisibilityOfElement(settingsHeader, 6);
		Assert.assertTrue(settingsHeader.isDisplayed());
		Assert.assertTrue(siteNameLabel.isDisplayed());
		Assert.assertTrue(siteNameTextBox.isDisplayed());
		Assert.assertTrue(seoLabel.isDisplayed());
		Assert.assertTrue(seoTextbox.isDisplayed());
		Assert.assertTrue(metaKeywordsLabel.isDisplayed());
		Assert.assertTrue(metaKeywordsTextbox.isDisplayed());
		Assert.assertTrue(filterResultsButtonReturnsTab.isDisplayed());
		Assert.assertTrue(metaDescriptionLabel.isDisplayed());
		Assert.assertTrue(metaDescriptionTextbox.isDisplayed());
		Assert.assertTrue(siteURLTab.isDisplayed());
		Assert.assertTrue(securitySettings.isDisplayed());
		Assert.assertTrue(currencySettings.isDisplayed());
		Assert.assertTrue(invoiceSettings.isDisplayed());
		Assert.assertTrue(cancelButton.isDisplayed());
		Assert.assertTrue(updateButton.isDisplayed());
		Assert.assertTrue(configurationsSettings.isDisplayed());
	}
	}

	
