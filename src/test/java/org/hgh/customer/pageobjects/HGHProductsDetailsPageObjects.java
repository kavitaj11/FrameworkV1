package org.hgh.customer.pageobjects;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Hemanth.Sridhar
 */
public class HGHProductsDetailsPageObjects extends MainController{
   Actions action = new Actions(driver);
   
	public HGHProductsDetailsPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//p[@class='cimm_productDetailBrand']")
	private WebElement productDetailsBrandHeading;

	



	public boolean verifyHeadingOfProduct(String searchText) {
		String searchTextUpperCase =searchText.toUpperCase(); 
		Waiting.explicitWaitVisibilityOfElement(productDetailsBrandHeading, 5);
		boolean t = productDetailsBrandHeading.getText().trim().toUpperCase().contains(searchTextUpperCase);
		return t;
	}


}
	
	
