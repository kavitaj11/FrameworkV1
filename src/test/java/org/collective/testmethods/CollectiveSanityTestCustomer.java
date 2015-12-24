package org.collective.testmethods;

import java.awt.AWTException;
import java.io.IOException;

import org.collective.customer.pageobjects.CollectiveAdrianoGoldschmiedPageObjects;
import org.collective.customer.pageobjects.CollectiveBagsPageObjects;
import org.collective.customer.pageobjects.CollectiveBlogPageObjects;
import org.collective.customer.pageobjects.CollectiveHomePageObjects;
import org.collective.customer.pageobjects.CollectiveLoginPageObjects;
import org.collective.customer.pageobjects.CollectiveShoppingCartPageObjects;
import org.collective.customer.pageobjects.CollectiveSignupPageObjects;
import org.collective.maincontroller.MainController;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CollectiveSanityTestCustomer extends MainController{
	
	@BeforeClass
	public void setUp() throws IOException{
		driver.get(applicationsetup.getURL());
	}
	  
	/*
	 * @author Hemanth.Sridhar
	 */
  @Test(alwaysRun = true)
  public void tc001_collective_signup() throws IOException, InterruptedException, AWTException {
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveSignupPageObjects signupPage = new CollectiveSignupPageObjects(driver);
	  homePage.emailSignUpBtnClick();	  
	  signupPage.signupUsername();
	  signupPage.signupEmail();
	  signupPage.signupPhoneNumber();
	  signupPage.signUpPasswordAndConfirmation();
	  signupPage.signupBtnClick();
	  homePage.verifySignFunctionality();
	  homePage.logout();
  }
  
  @Test(alwaysRun = true)
  public void tc002_collective_login() throws InterruptedException, IOException
  {
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  homePage.clickLoginLink();
	  loginPage.enterPhoneNumberForLogin();
	  loginPage.enterPasswordForLogin();
	  loginPage.clickLogin();
	  homePage.verifySignFunctionality();
	  homePage.logout();
	  homePage.verifyLogout();
  }
  
  @Test(alwaysRun = true)
  public void tc003_collective_blog(){
	 CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	 CollectiveBlogPageObjects blogPage = new CollectiveBlogPageObjects(driver);
	 homePage.clickBlog();
	 blogPage.verifyBlogPage();	 
  }	

  @Test(alwaysRun = true)
  public void tc004_collective_accessories(){
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.hoverAccessories();
	  homePage.hoverAccessoriesMen();
	  homePage.clickBags();
	  bagsPage.verifyProductsDisplay();
	  
  }
  
  @Test(alwaysRun = true)
  public void tc005_collective_accessories_Filter_Brand(){
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.hoverAccessories();
	  homePage.hoverAccessoriesMen();
	  homePage.clickBags();
	  bagsPage.verifyProductsDisplay();
	  bagsPage.filterTest();
  }
  
  @Test(alwaysRun = true)
  public void tc006_collective_accessories_pagination()
  {
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.hoverAccessories();
	  homePage.hoverAccessoriesMen();
	  homePage.clickBags();
	  bagsPage.verifyProductsDisplay();
	  bagsPage.verifyPagination();
  }
  
  @Test(alwaysRun = true)
  public void tc007_collective_sales(){
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.clickSales();
	  bagsPage.verifyProductsDisplay();
  }
  
  @Test(alwaysRun = true)
  public void tc008_collective_orderGreaterThan20000() throws IOException, InterruptedException{
	  /*
	   * covers Mens tab as well
	   */
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdrianoGoldschmiedPageObjects andrianoPage = new CollectiveAdrianoGoldschmiedPageObjects(driver);
	  CollectiveShoppingCartPageObjects shoppingcartPage = new CollectiveShoppingCartPageObjects(driver);
	  homePage.clickLoginLink();
	  loginPage.enterPhoneNumberForLogin();
	  loginPage.enterPasswordForLogin();
	  loginPage.clickLogin();
	  homePage.verifySignFunctionality();
	  homePage.hoverOverMenTab();
	  homePage.navigateToAdrianoGoldschmiedFromMen();
	  andrianoPage.dragLeftSlider();
	  andrianoPage.clickOnFirstProduct();
	  andrianoPage.clickOnAddToCart();
	  shoppingcartPage.clickCheckout();
	  shoppingcartPage.enterFirstName();
	  shoppingcartPage.enterLastName();
	  shoppingcartPage.enterStreetAddress();
	  shoppingcartPage.enterPinCode();
	  shoppingcartPage.enterCity();
	  shoppingcartPage.chooseState();
	  shoppingcartPage.chooseCountry();
	  shoppingcartPage.enterCartPhoneNumber(); 
	  shoppingcartPage.cartSaveMyAddress();
	  shoppingcartPage.saveAndContinueClick();
	  shoppingcartPage.checkForCashOnDeliveryGreaterthan20k();
	  shoppingcartPage.clearCart();
	  homePage.logout();
	  homePage.verifyLogout();
  }
  
  @Test(alwaysRun = true)
  public void tc009_collective_orderLessOrEqualThan20000() throws IOException, InterruptedException{
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdrianoGoldschmiedPageObjects andrianoPage = new CollectiveAdrianoGoldschmiedPageObjects(driver);
	  CollectiveShoppingCartPageObjects shoppingcartPage = new CollectiveShoppingCartPageObjects(driver);
	  homePage.clickLoginLink();
	  loginPage.enterPhoneNumberForLogin();
	  loginPage.enterPasswordForLogin();
	  loginPage.clickLogin();
	  homePage.verifySignFunctionality();
	  homePage.hoverOverMenTab();
	  homePage.navigateToAdrianoGoldschmiedFromMen();
	  andrianoPage.clickOnFirstProduct();
	  andrianoPage.clickOnAddToCart();
	  shoppingcartPage.clickCheckout();
	  shoppingcartPage.enterFirstName();
	  shoppingcartPage.enterLastName();
	  shoppingcartPage.enterStreetAddress();
	  shoppingcartPage.enterPinCode();
	  shoppingcartPage.enterCity();
	  shoppingcartPage.chooseState();
	  shoppingcartPage.chooseCountry();
	  shoppingcartPage.enterCartPhoneNumber(); 
	  shoppingcartPage.cartSaveMyAddress();
	  shoppingcartPage.saveAndContinueClick();
	  shoppingcartPage.checkForCashOnDeliveryLessThanOrEqualTo20k();
	  shoppingcartPage.clearCart();
	  homePage.logout();
	  homePage.verifyLogout();
  }
  
  @Test(alwaysRun = true)
  public void tc010_collective_orderPlacement() throws IOException{
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdrianoGoldschmiedPageObjects andrianoPage = new CollectiveAdrianoGoldschmiedPageObjects(driver);
	  CollectiveShoppingCartPageObjects shoppingcartPage = new CollectiveShoppingCartPageObjects(driver);
	  homePage.clickLoginLink();
	  loginPage.enterPhoneNumberForLogin();
	  loginPage.enterPasswordForLogin();
	  loginPage.clickLogin();
	  homePage.verifySignFunctionality();
	  homePage.hoverAccessories();
	  homePage.hoverAccessoriesMen();
	  homePage.clickBags();
	  bagsPage.verifyProductsDisplay();
	  andrianoPage.clickOnFirstProduct();
	  andrianoPage.clickOnAddToCart();
	  shoppingcartPage.clickCheckout();
	  shoppingcartPage.enterFirstName();
	  shoppingcartPage.enterLastName();
	  shoppingcartPage.enterStreetAddress();
	  shoppingcartPage.enterPinCode();
	  shoppingcartPage.enterCity();
	  shoppingcartPage.chooseState();
	  shoppingcartPage.chooseCountry();
	  shoppingcartPage.enterCartPhoneNumber(); 
	  shoppingcartPage.cartSaveMyAddress();
	  shoppingcartPage.saveAndContinueClick();
	  shoppingcartPage.clickPlaceOrder();
	  shoppingcartPage.verifyOrderStatus();
	  homePage.logout();
	  homePage.verifyLogout();
  }
  
  @Test(alwaysRun = true)
  public void tc011_collective_womenTab() throws InterruptedException{
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver);
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.hoverOverWomenTab();
	  homePage.navigateToAdrianoGoldschmiedFromWomen();
	  bagsPage.verifyProductsDisplay();
  }
  
  /*@Test(alwaysRun=true)
  public void tc012_collective_blogStories(){
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver);
	  homePage.verifyBlogStories();
  }*/
}