package org.collective.customer.pageobjects;
import org.collective.maincontroller.MainController;
import org.collective.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CollectiveAdrianoGoldschmiedPageObjects extends MainController {

	public CollectiveAdrianoGoldschmiedPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='products_page']/ul/li[1]")
	private WebElement firstProduct;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-lower']")
	private WebElement leftSlider;
	
	public void dragLeftSlider(){
		Actions moveSlider = new Actions(driver);
		Action action = (Action) moveSlider.dragAndDropBy(leftSlider, 50, 0).build();
		action.perform();
		
	}
	public void clickOnFirstProduct() {
		Waiting.explicitWaitVisibilityOfElement(firstProduct, 6);
		firstProduct.click();
	}
	
	public void clickOnAddToCart(){
		Waiting.explicitWaitVisibilityOfElement(addToCartButton, 5);
		addToCartButton.submit();
	}
}
