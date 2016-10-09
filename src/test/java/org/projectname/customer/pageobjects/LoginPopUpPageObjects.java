package org.projectname.customer.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.projectname.initializer.PageFactoryInitializer;
import org.projectname.utils.Waiting;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import ru.yandex.qatools.allure.annotations.Step;

public class LoginPopUpPageObjects extends PageFactoryInitializer {

	@FindBy(id="popUserName")
	private WebElement userNameLocator;
	
	@FindBy(id="popPassword")
	private WebElement passwordLocator;
	
	@FindBy(id="popLoginBtn")
	private WebElement loginButtonLocator;
	
	@FindBy(id="pLoginErr")
	private WebElement errorMsgLocator;
	
	

	@Step("enter username name as {0}")
	public LoginPopUpPageObjects enterUsername(String userName) {
		userNameLocator.sendKeys(userName);
		return this;
	}

	@Step("enter password as {0}")
	public LoginPopUpPageObjects enterPassword(String password) {
		passwordLocator.sendKeys(password);
		return this;
	}

	@Step("click on login button")
	public LoginPopUpPageObjects clickOnLoginButton() {
		loginButtonLocator.click();
		return this;
		
	}
	
	@Step("verify error message is {0}")
	public LoginPopUpPageObjects verifyErrorMessage(String expectedErrorMsg) {
		
		Waiting.explicitWaitVisibilityOfElement(errorMsgLocator, 2);
		assertThat(errorMsgLocator.getText().trim(),equalTo(expectedErrorMsg));
		return this;
	}

	
}
