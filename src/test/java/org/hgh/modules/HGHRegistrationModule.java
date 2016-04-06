package org.hgh.modules;

import org.hgh.dataprovider.SearchData;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;

public class HGHRegistrationModule extends MainController {
	
	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	  @Test(groups={"regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
	  public void tc001_HGH_Registration_ErrorScenarios(String companyName,String accountNumber,String firstName,String lastName,String email,String password,String passwordConfirmation,String address1,String address2,String city,String country,String state,String zipPostalCode,String phoneNumber,String expectedErrorMsg) throws Exception
	  {
		 
				homePage()
				.clickLoginLink()
				.loginPage()
				.clickNewCustomerRegisterNow()
				.registrationPage()
				.clickIAmACurrentHGHHardwareCustomer()
				.clickContinue()
				.clickOnThisIsMyFirstTimeOrderingOnlineWithHGHHardware()
				.clickContinueAgain()
				.enterCompanyName(companyName)
				.enterAccountNumber(accountNumber)
				.enterAccountFirstName(firstName)
				.enterAccountLastName(lastName)
				.enterAccountEmail(email)
				.enterAccountPassword(password)
				.enterAccountPasswordConfirmation(passwordConfirmation)
				.enterAccountAddress1(address1)
				.enterAccountAddress2(address2)
				.enterCity(city)
				.enterAccountCountry(country)
				.enterAccountState(state)
				.enterAccountZipCode(zipPostalCode)
				.enterPhoneNumber(phoneNumber)
				.clickIAccept()
				.verifyErrorMsg(expectedErrorMsg);
	  }
}
