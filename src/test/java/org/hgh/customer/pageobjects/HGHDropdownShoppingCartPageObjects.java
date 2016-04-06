package org.hgh.customer.pageobjects;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.hgh.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/*
 * @author Hemanth.Sridhar
 */
public class HGHDropdownShoppingCartPageObjects extends MainController{
   Actions action = new Actions(driver);

SearchDataPropertyFile data = new SearchDataPropertyFile();

	
	@FindBy(xpath="(//a[contains(text(),'Checkout')])[2]")
	private WebElement checkoutButton;
	
	@FindBy(xpath="(//a[contains(text(),'Continue Shopping')])[2]")
	private WebElement continueShoppingButton;

	public HGHShoppingCartPageObjects clickOnCheckout() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(checkoutButton, 20);
		checkoutButton.click();
		return new HGHShoppingCartPageObjects();
	}
	
	public HGHDropdownShoppingCartPageObjects clickOnContinueShoppingButton() throws InterruptedException {
		Waiting.explicitWaitVisibilityOfElement(continueShoppingButton, 20);
		continueShoppingButton.click();
		return this;
	}
}
	
	
