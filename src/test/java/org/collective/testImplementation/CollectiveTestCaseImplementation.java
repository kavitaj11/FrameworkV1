package org.collective.testImplementation;

import org.collective.customer.pageobjects.CollectiveHomePageObjects;
import org.collective.customer.pageobjects.CollectiveLoginPageObjects;
import org.collective.maincontroller.MainController;


public class CollectiveTestCaseImplementation extends MainController{

	

	public static void loginScenarios(String phoneNumber, String password) throws Exception {
		CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
		CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver);
		homePage.clickLoginLink();
		loginPage.enterPhoneNumberForLogin(phoneNumber);
		loginPage.enterPasswordForLogin(password);
		loginPage.clickLogin();
	}

}
