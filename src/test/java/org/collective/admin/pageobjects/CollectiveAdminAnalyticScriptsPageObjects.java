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
public class CollectiveAdminAnalyticScriptsPageObjects extends MainController{
	
   SearchData data = new SearchData();
   
	public CollectiveAdminAnalyticScriptsPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@id='admin_new_analytic_scripts_link']")
	private WebElement newAnalyticScripts;
	
	@FindBy(xpath="//h1")
	private WebElement analyticScriptsHeading;


	public void verifyAnalyticScriptPage(){
		Waiting.explicitWaitVisibilityOfElement(analyticScriptsHeading, 3);
			Assert.assertTrue(analyticScriptsHeading.isDisplayed(), "analytic scripts heading is not displayed");
			Assert.assertTrue(newAnalyticScripts.isDisplayed(), "analytic scripts button is not displayed");
		}		
	}
