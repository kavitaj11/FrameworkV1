package org.hgh.customer.pageobjects;
import java.util.List;

import org.hgh.maincontroller.MainController;
import org.hgh.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class HGHHomePageObjects extends MainController{
   Actions action = new Actions(driver);
   
	public HGHHomePageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	/*@FindBy(xpath="(//a[@href='/Login'])[1]")
	private WebElement loginLink;
	
	@FindBy(xpath="//li[@class='welcomeUser']")
	private WebElement welcomeUserLocator;*/
	
	@FindBy(xpath="//div[@class='errMsg']")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="(//a[@href='/Login'])[1]")
	private WebElement loginLinkLocator;
	
	@FindBy(xpath="//li[@class='welcomeUser']")
	private WebElement welcomeLocator;
	
	@FindBy(xpath="(//a[contains(text(),'Logout')])[1]")
	public WebElement logoutButton;
	
	@FindBy(xpath="//input[@id='txtSearch']")
	private WebElement searchTextbox;

	@FindBy(xpath="//li[@class='ui-menu-item']")
	private List<WebElement> searchResultsLocator;
	
	@FindBy(xpath="//button[@id='performSearchBtn']")
	private WebElement searchButton;
	
	@FindBy(xpath="//div[@class='gridListSwitchWrap']/a[@id='listView']/b")
	private WebElement listViewButton;
	
	public boolean errorScenarios(String expectedMsg) {
		System.out.println(expectedMsg);
		boolean t = errorMsgLocator.getText().trim().equals(expectedMsg);
		return t;
	}

	public void clickLoginLink() {
		
		loginLinkLocator.click();
	}

	public boolean verifyWelcomeMsg() {
		boolean t = welcomeLocator.isDisplayed();
		return t;
		
	}

	public void assertForErrorMessages(String expectedMsg) {
		Assert.assertEquals(errorMsgLocator.getText().trim(),expectedMsg,errorMsgLocator.getText().trim()+" is displayed");
		
	}

	public void logout() {
		Waiting.explicitWaitVisibilityOfElement(logoutButton, 4);
		logoutButton.click();
	}
	
	public void verifyDisplayOfLoginLink(){
		Waiting.explicitWaitVisibilityOfElement(loginLinkLocator, 4);
		Assert.assertTrue(loginLinkLocator.isDisplayed(), "Login Link is not displayed");
	}

	public void searchPartialText(String searchText) {
		searchTextbox.sendKeys(searchText);
		
	}

	public void chooseOption(String textToChoose) {
		Waiting.explicitWaitVisibilityOfElements(searchResultsLocator, 10);
		for(WebElement option : searchResultsLocator)
		{
		if(option.getText().trim().equals(textToChoose))
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",option);
		}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void clickOnSearch() {
		searchButton.click();
	}

	public void clickOnChangeView() {
		listViewButton.click();
		
	}

}
	
	
