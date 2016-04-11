package org.etna.modules;
import org.etna.maincontroller.MainController;
import org.etna.utils.SearchDataPropertyFile;
import org.testng.annotations.Test;


public class CartFileUploadModule extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */
	 SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	LoginModule loginModule = new LoginModule();

@Test(groups={"smoke","regression"})
  public void tc013_HGH_cartFileUpload() throws Exception
  {

	loginModule.TS_Login_001_TS_Login_006_TC_Login_001_TC_Login_002_TC_Login_024_TC_Login_025_TC_Login_026_TC_Login_027();
	 shoppingCartPage().clearCart();
	 homePage()
	 .clickOnMyAccounts()
	 .myAccountsPage()
	 .clickOnCartFileUpload()
	 .verifyBreadCrumpAndHeadingOfCartFileUpload()
	 .fileUpload(data.getFileUploadPath())
	 .clickOnUpload()
	 .verifyQuickCartPage();
  }
  
 

  /*@Test
  public void dayanandTest() throws Exception{
	  HGHHomePageObjects homePage = new HGHHomePageObjects(driver);
	  homePage.findNow();
  }*/
}
