package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
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
	private WebElement productsList;
	
	@FindBy(xpath="//input[@id='ARMANI_JEANS']")
	private WebElement armaniCheckbox;
	
	@FindAll(value={@FindBy(xpath="//a[text()='Armani Jeans Laptop Bag']")})
	private WebElement armaniDisplayCheck;
	
	@FindBy(xpath="//ul[@class='image-list no-pad clearfix']/li[1]")
	private WebElement firstProduct;
	
	@FindBy(css="a[href='/t/categories/men/bags?page=2']")
	private WebElement paginatorNextClick;
	
	
	public void verifyProductsDisplay() {
		Waiting.explicitWaitVisibilityOfElement(productsdiv, 5);
		Assert.assertTrue(productsdiv.isDisplayed());
		Assert.assertTrue(productsList.isDisplayed());
		
		}
	
	public void filterTest(){
		armaniCheckbox.click();
		Waiting.explicitWaitVisibilityOfElement(armaniDisplayCheck, 6);
	   Assert.assertTrue(armaniDisplayCheck.isDisplayed());
	  
	}
	
	public void verifyPagination()
	{
		Assert.assertTrue(firstProduct.isDisplayed());
		((JavascriptExecutor)driver).executeScript("arguments[0].click();" , paginatorNextClick);		
		Waiting.explicitWaitVisibilityOfElement(firstProduct, 20);
		Assert.assertTrue(firstProduct.isDisplayed());
	    
	}
	}
	 
		
	/*List<WebElement> s=	driver.findElements(By.xpath("productsList"));
		for(int i=0;i<s.size();i++)
		{
			if(s.contains("ARMANI SIZE"))
			{
				return true;
			}
		}
		
		return false;
		for(WebElement everyproductslist:s)
		{
			if(everyproductslist.getText().contains("ARMANI JEANS"))
			{
				System.out.println("Filter Test Passed");
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;*/
		

	
