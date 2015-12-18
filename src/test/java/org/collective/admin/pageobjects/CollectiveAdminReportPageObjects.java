package org.collective.admin.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.SearchData;
import org.collective.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	}

	
