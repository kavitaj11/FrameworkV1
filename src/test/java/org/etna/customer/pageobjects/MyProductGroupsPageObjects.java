package org.etna.customer.pageobjects;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class MyProductGroupsPageObjects extends MainController{
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	Actions action = new Actions(driver);
	
	ProductsDetailsPageObjects productDetailsPage = new ProductsDetailsPageObjects();
	
	@FindBy(id="groupName")
	private WebElement groupName;
	
	@FindBy(xpath="//h2")
	public WebElement pageName;
	
	@FindBy(xpath="//button[contains(@onclick,'deleteSavedProductGroup')]")
	private WebElement deleteGroupButton;
	
	@FindBy(xpath="//li[contains(text(),'No Product Group Available')]")
	private WebElement noProductGroupsAvailableText;
	
	public MyProductGroupsPageObjects clickOnTheGroupCreated(String myProductGroupName) {
		String productGroup = "//a[contains(text(),'"+myProductGroupName+"')]";
		Waiting.explicitWaitVisibilityOfElement( driver.findElement(By.xpath(productGroup)), 10);
		WebElement myProductGroup = driver.findElement(By.xpath(productGroup));
		myProductGroup.click();
		return this;
	}
	
	//alert accept
	//come back again
	//and check no product groups available
	//check page name as my product groups 
	
	public MyProductGroupsPageObjects verifyBreadCrump(String myProductGroupName) throws Exception
	{
		if(setUp.getBrowser().equalsIgnoreCase("safari"))
		{
		Thread.sleep(3500);
		}
		else
		{
			Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		}
	String lastBreadCrump = productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().trim();
	Assert.assertEquals(myProductGroupName, lastBreadCrump.replace("/", "").trim(),"item name and the last breadcrump is not the same. Item name is : "+myProductGroupName +" and the last breadcrump is : "+ lastBreadCrump);
	return this;

	}

	public MyProductGroupsPageObjects verifyPageName() {
		Assert.assertEquals(pageName.getText().trim(), data.getMyProductGroupsPageName().toUpperCase());
		return this;
	}
	
	public MyProductGroupsPageObjects verifyPageName(String myProductGroupName) {
		Assert.assertEquals(groupName.getText().trim(), myProductGroupName.toUpperCase());
		return this;
	}

	public MyProductGroupsPageObjects clickOnDelete() {
		deleteGroupButton.click();
		return this;	
	}

	public void verifyAlertText() {
		Waiting.explicitWaitForAlert(5);
		Assert.assertEquals(TestUtility.getAlertText().trim(), data.getDeleteGroupAlertText());
		
	}

	public MyProductGroupsPageObjects verifyNoProductGroupAvailableText() {
		Assert.assertTrue(noProductGroupsAvailableText.isDisplayed());
		return this;
		
	}
	
	public MyProductGroupsPageObjects verifyWhetherGroupIsDeleted(String myProductGroupName)
	{
		Assert.assertTrue(assertGroupdIsDeleted(myProductGroupName),"group is not deleted.");
		return this;
	}

	public boolean assertGroupdIsDeleted(String myProductGroupName) {
		try
		{
		String productGroup = "//a[contains(text(),'"+myProductGroupName+"')]";
		Waiting.explicitWaitVisibilityOfElement( driver.findElement(By.xpath(productGroup)), 10);
		WebElement myProductGroup = driver.findElement(By.xpath(productGroup));
		Assert.assertTrue(myProductGroup.isDisplayed(),"group is not deleted yet.");
		return false;
		}
		catch(NoSuchElementException e)
		{
			return true;
		}
	}
}