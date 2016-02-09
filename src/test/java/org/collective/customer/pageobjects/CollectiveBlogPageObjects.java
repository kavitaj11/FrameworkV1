package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.SearchData;
import org.collective.utils.Waiting;
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
	
	@FindBy(xpath="//div[@class='row block']")
	private WebElement blogDiv;
	
	@FindBy(xpath="//h2/b")
	private WebElement blogStoriesHeader;
	
	@FindBy(xpath="//div[@class='grid clearfix']")
	private WebElement blogsPage;
	
	public void verifyBlogPage() {
		Assert.assertTrue(blogEntryContainer.isDisplayed());
		Assert.assertTrue(blogEntryContainerChildren.isDisplayed());
		Assert.assertTrue(blogParagraphs.isDisplayed());
		//Assert.assertTrue(blogsPage.isDisplayed(), "blogs page is not displayed");
		
		}

	public void verifyBlogStories(){
		Waiting.explicitWaitVisibilityOfElement(blogStoriesHeader, 3);
			Assert.assertTrue(blogStoriesHeader.isDisplayed(), "Blog Stories header is not displayed");
			Assert.assertTrue(blogDiv.isDisplayed(), "Blogs are displayed");
		}		
	}
