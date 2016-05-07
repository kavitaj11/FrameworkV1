package org.etna.customer.pageobjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/*
 * @author Hemanth.Sridhar
 */
public class DropdownShoppingCartPageObjects extends PageFactoryInitializer{
   Actions action = new Actions(driver);

SearchDataPropertyFile data = new SearchDataPropertyFile();

	
	@FindBy(xpath="(//a[contains(text(),'Checkout')])[2]")
	private WebElement checkoutButton;
	
	@FindBy(xpath="(//a[contains(text(),'Continue Shopping')])[2]")
	private WebElement continueShoppingButton;

	public MyCartPageObjects clickOnCheckout() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(checkoutButton, 20);
		checkoutButton.click();
		return new MyCartPageObjects();
	}
	
	public DropdownShoppingCartPageObjects clickOnContinueShoppingButton() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(continueShoppingButton, 20);
		continueShoppingButton.click();
		return this;
	}
}
	
	
