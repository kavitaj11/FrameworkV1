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
public class CollectiveAdminStoreLocatorPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminStoreLocatorPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'STORES')]")
	private WebElement storesHeader;
	
	@FindBy(xpath="//a[@id='admin_new_user_link']")
	private WebElement newStoreButton;
	
	@FindBy(xpath="//div[@class='row']")
	private WebElement storeTable;
	
	
	
	public void verifyStoresPage() {
		Waiting.explicitWaitVisibilityOfElement(storesHeader, 6);
		Assert.assertTrue(storesHeader.isDisplayed());
		Assert.assertTrue(newStoreButton.isDisplayed());
		Assert.assertTrue(storeTable.isDisplayed());
	}
	}

	
