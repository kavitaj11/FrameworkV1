package org.hgh.modules;
import org.hgh.dataprovider.SearchData;
import org.hgh.maincontroller.MainController;
import org.hgh.utils.SearchDataPropertyFile;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class HGHLoginModule extends MainController{

	
	/*
	 * @author Hemanth.Sridhar
	 */
	
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	  @Test(groups={"smoke","regression"})
		public void TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027_HGH() throws Exception
		{
		   homePage()
		  .clickLoginLink()
		  .loginPage()
		  .verifyLoginPage()
		  .enterUsername()
		  .enterPassword()
		  .clickOnLoginButton()
		  .productCategoryPage()
		  .verifyWelcomeMsg();
		}

	  @Test(groups={"regression"},dataProvider="excelSheetDataRead", dataProviderClass=SearchData.class)
	  public void TS_Login_001_TC_HGH_Login_004_005_006_007_ErrorScenarios(String userName, String password,String expectedMsg) throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPage()
		  .enterUsernameRegression(userName)
		  .enterPasswordRegression(password)
		  .clickOnLoginButton()
		  .productCategoryPage()
		  .assertForErrorMessages(expectedMsg);	
	  }
	  
	  
	  @Test(groups={"regression"})
	  public void TS_Login_001_TC_HGH_Login_008_Verify_Tab_focus() throws Exception
	  {
		  
		  throw new SkipException("feature not present.");
		 /* homePage()
		  .clickLoginLink()
		  .loginPage()
		 
		  .clickOnLoginButton()
		  .verifyTabFocus();*/
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_002_TC_HGH_Login_009_010_RememberPassword_UserNameAndPasswordRefill() throws Exception
	  {
		  
		   homePage()
		  .clickLoginLink()
		  .loginPage()
		  .verifyLoginPage()
		  .enterUsername()
		  .enterPassword()
		  .clickOnRemeberMe()
		  .clickOnLoginButton()
		  .productCategoryPage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForLogoutLink()
		  .logout()
		  .clickLoginLink()
		  .loginPage()
		  .verifyAutofillOfUserNameAndPassword();
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_002_TC_HGH_Login_011_AutofillLogin() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPage()
		  .verifyLoginPage()
		  .enterUsername()
		  .enterPassword()
		  .clickOnRemeberMe()
		  .clickOnLoginButton()
		  .productCategoryPage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForLogoutLink()
		  .logout()
		  .clickLoginLink()
		  .loginPage()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg();
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_002_TC_HGH_Login_012_uncheckRememberMeWhenInAutoFillForm() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPage()
		  .verifyLoginPage()
		  .enterUsername()
		  .enterPassword()
		  .clickOnRemeberMe()
		  .clickOnLoginButton()
		  .productCategoryPage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForLogoutLink()
		  .logout()
		  .clickLoginLink()
		  .loginPage()
		  .clickOnRemeberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .waitForLogoutLink()
		  .logout()
		  .clickLoginLink()
		  .loginPage()
		  .verifyEmptyUserNameAndPasswordTextbox();
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_002_TC_HGH_Login_013_myProductGroupLoginPopupRememberMeClickUncheck() throws Exception
	  {
		  String searchText = data.getSearchText();
		  homePage()
		  .clickLoginLink()
		  .loginPage()
		  .verifyLoginPage()
		  .enterUsername()
		  .enterPassword()
		  .clickOnRemeberMe()
		  .clickOnLoginButton()
		  .productCategoryPage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForLogoutLink()
		  .logout()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .clickOnFirstMyProductGroup()
		  .loginPopUp()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .homePage()
		  .verifyWelcomeMsg()
		  .waitForLogoutLink()
		  .logout()
		  .clickLoginLink()
		  .loginPage()
		  .verifyEmptyUserNameAndPasswordTextbox();
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_002_TC_HGH_Login_015_rememberMeAsALink() throws Exception
	  {
		  throw new SkipException("this feature is having a bug.");
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_002_TC_HGH_Login_016_017_018_rememberMeCheckboxTest() throws Exception
	  {
		  homePage()
		  .clickLoginLink()
		  .loginPage()
		  .clickOnRemeberMe()
		  .verifyRememberMeCheckBoxSelected()
		  .clickOnRemeberMe()
		  .verifyRememberMeCheckboxNotSelected();
	}

	  @Test(groups={"regression"})
	  public void TS_Login_002_TC_HGH_Login_014_myProductGroupLoginPopupRememberMeClickCheck() throws Exception
	  {  
		  String searchText = data.getSearchText();
		  homePage()
		  .searchText(searchText)
		  .clickOnSearch()
		  .productListPage()
		  .clickOnFirstMyProductGroup()
		  .loginPopUp()
		  .enterUserName()
		  .enterPassword()
		  .clickOnRememberMe()
		  .clickOnLoginButton()
		  .productCategoryPage()
		  .verifyWelcomeMsg()
		  .homePage()
		  .waitForLogoutLink()
		  .logout()
		  .clickLoginLink()
		  .loginPage()
		  .verifyAutofillOfUserNameAndPassword();
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_005_TC_HGH_Login_021_loginVerifyOrderTopToBottom() throws Exception
	  {
		  throw new SkipException("This feature is having a bug.");
		  
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_005_TC_HGH_Login_022_loginVerifyOrderBottomToTop() throws Exception
	  {
		  throw new SkipException("This feature is having a bug.");
	  }
	  
	  @Test(groups={"regression"})
	  public void TS_Login_004_TC_HGH_Login_020_verifyForgotPasswordPage() throws Exception
	  {
		   homePage()
		  .clickLoginLink()
		  .loginPage()
		  .verifyLoginPage()
		  .clickOnForgotPassword()
		  .retrievePasswordPage()
		  .verifyRetrievePasswordPage();
		}
	  
	  @Test(groups={"regression"})
	  public void TS_Login_003_TC_HGH_Login_019_verifyRegisterPage() throws Exception
	  {
		   homePage()
		  .clickLoginLink()
		  .loginPage()
		  .verifyLoginPage()
		  .clickNewCustomerRegisterNow()
		  .registrationPage()
		  .verifyRegistrationPage();
		}
}
