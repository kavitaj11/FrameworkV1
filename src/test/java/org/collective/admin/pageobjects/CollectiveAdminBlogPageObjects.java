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
public class CollectiveAdminBlogPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminBlogPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[contains(text(),'Blog Entries')]")
	private WebElement blogHeader;
	
	@FindBy(xpath="//a[text()='New Blog Entry']")
	private WebElement newBlogEntryButton;
	
	
	public void verifyBlogPage() {
		Waiting.explicitWaitVisibilityOfElement(blogHeader, 6);
		Assert.assertTrue(blogHeader.isDisplayed());
		Assert.assertTrue(newBlogEntryButton.isDisplayed());
	}
	}

	
