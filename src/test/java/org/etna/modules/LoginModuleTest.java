package org.etna.modules;
import org.etna.dataprovider.SearchData;
import org.etna.maincontroller.MainController;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LoginModuleTest extends MainController{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	
	  public void loginAsASuperUser() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
	  }
	
	
		public void login(String userName,String password) throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUsernameRegression(userName)
		  .enterPasswordRegression(password)
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
		}
		
		
	@Test(alwaysRun=true,groups={"LoginModule","smoke","regression"})
		public void TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027() throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyLoginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
		}
	  

	
	  
	  
	  
	@Test(alwaysRun=true,groups={"LoginModule","regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
			public void TC_Login_001_AsASuperUser_PurchaseAgent_GeneralUser(String userName,String password,String expectedMsg) throws Exception
			{
			   homePage()
			  .clickLoginLink()
			  .loginPopUp()
			  .enterUsernameRegression(userName)
			  .enterPasswordRegression(password)
			  .clickOnLoginButton()
			  .homePage()
			  .verifyWelcomeMsg(expectedMsg);
			}

	@Test(alwaysRun=true,groups={"LoginModule","regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
	  public void TC_Login_004_TC_Login_005_TC_Login_006_TC_Login_007_ErrorScenarios(String userName, String password,String expectedMsg) throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUsernameRegression(userName)
		  .enterPasswordRegression(password)
		  .clickOnLoginButton()
		  .homePage()
		  .assertForErrorMessages(expectedMsg);	
	  }
	  
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TS_Login_001_TC_Login_008_Verify_Tab_focus() throws Exception
	  {
		  
		  throw new SkipException("having a bug.");
		  /*homePage()
		  .clickLoginLink()
		  .loginPage()
		 
		  .clickOnLoginButton()
		  .verifyTabFocus();*/
		}
	
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_009_010_RememberPassword_UserNameAndPasswordRefill() throws Exception
	  {
		  
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyAutofillOfUserNameAndPassword();
		}
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_011_AutofillLogin() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
		}
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_012_uncheckRememberMeWhenInAutoFillForm() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyEmptyUserNameAndPasswordTextbox();
		}
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_013_myProductGroupLoginPopupRememberMeClickUncheck() throws Exception
	  {
		  String searchText = data.getSearchText();
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .clickOnMyProductGroup(1)
		  .loginPopUp()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyEmptyUserNameAndPasswordTextbox();
		}
	  
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_015_rememberMeAsALink() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnRememberText()
		  .verifyRememberMeCheckBoxSelected();
		}
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_016_TC_Login_017_TC_Login_018_rememberMeCheckboxTest() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnRemeberMe()
		  .verifyRememberMeCheckBoxSelected()
		  .clickOnRemeberMe()
		  .verifyRememberMeCheckboxNotSelected();
	}

	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_014_myProductGroupLoginPopupRememberMeClickCheck() throws Exception
	  {  
		  String searchText = data.getSearchText();
		  homePage()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .clickOnMyProductGroup(1)
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForProfileDropdownLink()
		  .logout()
		  .clickLoginLink()
		  .loginPopUp()
		  .verifyAutofillOfUserNameAndPassword();
		}
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_021_loginVerifyOrderTopToBottom() throws Exception
	  {
		  throw new SkipException("This feature is having a bug.");
		  
		}
	
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_020_verifyForgotPasswordPage() throws Exception
	  {
		   homePage()
		  .clickLoginLink()
		  .loginPopUp()
		  .clickOnForgotPassword()
		  .forgotPasswordPage()
		  .verifyRetrievePasswordPage();
		}
	  
	@Test(groups={"LoginModule","regression"},enabled=true)
	  public void TC_Login_019_verifyRegisterPage() throws Exception
	  {
		  throw new SkipException("Sign up yet to be implemented.");
		  /* homePage()
		  .clickLoginLink()
		  .loginPage()
		  .verifyLoginPage()
		  .clickNewCustomerRegisterNow()
		  .registrationPage()
		  .verifyRegistrationPage();*/
		
	  }

	  
}
