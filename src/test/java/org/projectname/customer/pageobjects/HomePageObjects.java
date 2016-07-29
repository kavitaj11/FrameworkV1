package org.projectname.customer.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.projectname.maincontroller.PageFactoryInitializer;
import org.projectname.utils.Waiting;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class HomePageObjects extends PageFactoryInitializer {

	@FindBy(xpath="//div[contains(@class,'header')]/descendant::a[contains(text(),'Login')]")
	private WebElement loginLinkLocator;
	
	@FindBy(xpath="//div[@class='userProfile']/p")
	private WebElement userAccountDropdownLocator;
	
	@Step("clicking on login link")
	public LoginPopUpPageObjects clickOnLoginLink() {
		
		loginLinkLocator.click();
		
		return loginPopUp();
	}
	
	@Step("verify whether the name of the user after logging in is  {0}")
	public HomePageObjects verifyNameTheUser(String nameOfTheUser) {
		Waiting.explicitWaitVisibilityOfElement(userAccountDropdownLocator, 5);
		Assert.assertEquals(userAccountDropdownLocator.getText().trim(), nameOfTheUser);
		return this;
	}

	
}
