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
public class CollectiveAdminCarouselPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminCarouselPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='row']")
	private WebElement carouselDiv;
	
	@FindBy(xpath="//h1[contains(text(),'Carousel')]")
	private WebElement carouselHeader;
	
	@FindBy(xpath="//a[@id='admin_new_user_link']")
	private WebElement carouselAddSlideButton;
	
	public void verifyCarouselPage() {
		Waiting.explicitWaitVisibilityOfElement(carouselHeader, 6);
		Assert.assertTrue(carouselHeader.isDisplayed());
		Assert.assertTrue(carouselDiv.isDisplayed());
		Assert.assertTrue(carouselAddSlideButton.isDisplayed());
	}
	}

	
