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
public class CollectiveAdminReportPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminReportPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//span[text()='Order Totals']")
	private WebElement orderTotals;
	
	@FindBy(xpath="//span[text()='Download']/ancestor::button")
	private WebElement downloadButton;
	
	
	
	@FindBy(xpath="//h1/span[text()='User List']")
	private WebElement userListHeader;
	

	@FindBy(xpath="//h1/span[text()='Return List']")
	private WebElement returnListHeader;
	
	
	
	
	public void clickOrderTotals(){
		Waiting.explicitWaitVisibilityOfElement(orderTotals, 20);
		orderTotals.click();
	}
	
	
	public void verifyOrderTotalsHeader() throws InterruptedException{
		Waiting.explicitWaitVisibilityOfElement(orderTotals, 20);
		orderTotals.isDisplayed();

	}
	
	public void clickDownloadButton() throws InterruptedException{
		Waiting.explicitWaitVisibilityOfElement(downloadButton, 4);
		downloadButton.click();
		Thread.sleep(2000);
	}
	
	public void verifyUsersListHeader() {
		Waiting.explicitWaitVisibilityOfElement(userListHeader, 20);
		Assert.assertTrue(userListHeader.isDisplayed(), "user list header is not displayed");
		
	}


	public void verifyReturnsListHeader() {
		Assert.assertTrue(returnListHeader.isDisplayed(), "return list header is not displayed");
		
		
	}

	}

	
