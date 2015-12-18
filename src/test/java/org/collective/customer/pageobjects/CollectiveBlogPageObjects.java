package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.SearchData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class CollectiveBlogPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveBlogPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='blog_entry_container']")
	private WebElement blogEntryContainer;
	
	@FindAll(value = { @FindBy (xpath="//div[@id='blog_entry_container']/div")})
	private WebElement blogEntryContainerChildren;
	
	@FindAll(value={@FindBy(xpath="//p")})
	private WebElement blogParagraphs;
	
	public void verifyBlogPage() {
		Assert.assertTrue(blogEntryContainer.isDisplayed());
		Assert.assertTrue(blogEntryContainerChildren.isDisplayed());
		Assert.assertTrue(blogParagraphs.isDisplayed());
		}		
	}
