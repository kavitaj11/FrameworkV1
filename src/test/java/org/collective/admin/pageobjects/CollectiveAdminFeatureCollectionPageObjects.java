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
public class CollectiveAdminFeatureCollectionPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminFeatureCollectionPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'Feature Collection')]")
	private WebElement featureCollectionHeader;
	
	@FindBy(xpath="//a[@id='admin_feature_collection_link']")
	private WebElement addSlideButton;
	
	@FindBy(xpath="//div[@class='row']")
	private WebElement featureCollectionTable;
	
	
	
	public void verifyFeatureCollectionPage() {
		Waiting.explicitWaitVisibilityOfElement(featureCollectionHeader, 6);
		Assert.assertTrue(featureCollectionHeader.isDisplayed());
		Assert.assertTrue(addSlideButton.isDisplayed());
		Assert.assertTrue(featureCollectionTable.isDisplayed());
	}
	}

	
