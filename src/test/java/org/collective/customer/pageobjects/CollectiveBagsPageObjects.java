package org.collective.customer.pageobjects;
import java.util.List;

import org.collective.maincontroller.MainController;
import org.collective.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class CollectiveBagsPageObjects extends MainController{
	
	public CollectiveBagsPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@id='products_page']")
	private WebElement productsdiv;
	
	@FindAll(value={@FindBy(xpath="//div[@id='products_page']/ul/li")})
	private List<WebElement> productsList;
	
	@FindBy(xpath="//input[@id='ARMANI_JEANS']")
	private WebElement armaniCheckbox;
	
	@FindAll(value={@FindBy(xpath="//a[text()='Armani Jeans Laptop Bag']")})
	private WebElement armaniDisplayCheck;
	
	@FindBy(xpath="//ul[@class='image-list no-pad clearfix']/li[1]")
	private WebElement firstProduct;
	
	@FindBy(css="a[href='/t/brands/men/apparel/adriano-goldschmied?page=2']")
	private WebElement paginatorNextClick;
	
	
	@FindBy(xpath="//div[@id='size_color']/div[1]")
	public WebElement size;
	
	@FindBy(xpath="//div[@id='size_color']/div[2]")
	public WebElement colour;
	
	@FindBy(xpath="//div[@id='prices']")
	public WebElement prices;
	
	@FindBy(xpath="//div[contains(text(),'Coming Soon')]")
	private WebElement comingSoonText;
	
	public void verifyProductsDisplay() {
		try
		{
		{
			Assert.assertTrue(productsdiv.isDisplayed(), "products complete section is not displayed");
			for(int i=0;i<productsList.size();i++)
			{
			Assert.assertTrue(productsList.get(i).isDisplayed(),"every product is not displayed");
		}
		}
		}
		catch(Exception e)
		{
			try
			{
			Assert.assertTrue(comingSoonText.isDisplayed(), "coming soon text is also not displayed!!!!");
			}
			catch(NoSuchElementException e1)
			{
				System.out.println(driver.getCurrentUrl());
			}
			}
		}
	
	public void filterTest(){
		armaniCheckbox.click();
		Waiting.explicitWaitVisibilityOfElement(armaniDisplayCheck, 10);
	   Assert.assertTrue(armaniDisplayCheck.isDisplayed());
	  
	}
	
	public void scrollDown() {
		((JavascriptExecutor) driver).executeScript("scroll(0, 8000);");
		
	}
	}