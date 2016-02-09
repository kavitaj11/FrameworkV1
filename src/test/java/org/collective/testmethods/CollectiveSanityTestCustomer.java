package org.collective.testmethods;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.collective.admin.pageobjects.CollectiveAdminStoreLocatorPageObjects;
import org.collective.customer.pageobjects.CollectiveAdrianoGoldschmiedPageObjects;
import org.collective.customer.pageobjects.CollectiveBagsPageObjects;
import org.collective.customer.pageobjects.CollectiveBlogPageObjects;
import org.collective.customer.pageobjects.CollectiveHomePageObjects;
import org.collective.customer.pageobjects.CollectiveLoginPageObjects;
import org.collective.customer.pageobjects.CollectiveShoppingCartPageObjects;
import org.collective.customer.pageobjects.CollectiveSignupPageObjects;
import org.collective.maincontroller.MainController;
import org.testng.annotations.Test;

public class CollectiveSanityTestCustomer extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */
	
  /*@Test
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
  }*/
  
  @Test
	  public void tc001_collective_signup() throws IOException, InterruptedException, AWTException {
  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
  CollectiveSignupPageObjects signupPage = new CollectiveSignupPageObjects(driver);
  homePage.clickLoginLink();
  homePage.emailSignUpBtnClick();	  
  signupPage.signupUsername();
  signupPage.signupEmail();
  signupPage.signupPhoneNumber();
  signupPage.signUpPasswordAndConfirmation();
  signupPage.signupBtnClick();
  homePage.verifySignFunctionality();
}
  
  @Test
  public void tc002_collective_login() throws InterruptedException, IOException
  {
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  homePage.clickLoginLink();
	  loginPage.enterPhoneNumberForLogin();
	  loginPage.enterPasswordForLogin();
	  loginPage.clickLogin();
	  homePage.verifySignFunctionality();
  }
  
  @Test
  public void tc003_collective_blog(){
	 CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	 CollectiveBlogPageObjects blogPage = new CollectiveBlogPageObjects(driver);
	 homePage.clickBlog();
	 blogPage.verifyBlogPage();	 
  }	

  @Test
  public void tc004_collective_accessories(){
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.hoverAccessories();
	  homePage.hoverAccessoriesMen();
	  homePage.clickBags();
	  bagsPage.verifyProductsDisplay();
	  
  }
  
  @Test
  public void tc005_collective_accessories_Filter_Brand(){
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.hoverAccessories();
	  homePage.hoverAccessoriesMen();
	  homePage.clickBags();
	  bagsPage.verifyProductsDisplay();
	  bagsPage.filterTest();
  }
  
  @Test
  public void tc006_collective_pagination()
  {
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.hoverOverMenTab();
	  homePage.navigateToAdrianoGoldschmiedFromMen();
	  bagsPage.verifyProductsDisplay();
	  bagsPage.verifyPagination();
  }
  
  @Test
  public void tc007_collective_sales(){
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  homePage.clickSales();
	  bagsPage.verifyProductsDisplay();
  }
  
  @Test
  public void tc008_collective_orderGreaterThan20000() throws IOException, InterruptedException{
	  
	   /** covers Mens tab as well
	   * cover price filtering as well
	   * */
	   
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
	  homePage.navigateToArmaniFromMen();
	  andrianoPage.dragLeftSlider(90);
	  Thread.sleep(5000);
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
	 
  }
  
  @Test
  public void tc009_collective_orderLessOrEqualThan20000() throws IOException, InterruptedException{
	  CollectiveAdrianoGoldschmiedPageObjects andrianoPage = new CollectiveAdrianoGoldschmiedPageObjects(driver);
	  CollectiveShoppingCartPageObjects shoppingcartPage = new CollectiveShoppingCartPageObjects(driver);
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
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
	  
  }
  
  @Test
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
  }
  
  @Test(alwaysRun = true)
  public void tc011_collective_placeorder_OrderCancellation() throws ParseException, IOException{
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver); 
	  CollectiveBagsPageObjects bagsPage = new CollectiveBagsPageObjects(driver);
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdrianoGoldschmiedPageObjects andrianoPage = new CollectiveAdrianoGoldschmiedPageObjects(driver);
	  CollectiveShoppingCartPageObjects shoppingcartPage = new CollectiveShoppingCartPageObjects(driver);
	  CollectiveAdminStoreLocatorPageObjects storesPage = new CollectiveAdminStoreLocatorPageObjects(driver);
	  homePage.clickLoginLink();
	  loginPage.enterPhoneNumberForLogin();
	  loginPage.enterPasswordForLogin();
	  loginPage.clickLogin();
	  homePage.verifySignFunctionality();
	  homePage.hoverAccessories();
	  homePage.hoverAccessoriesMen();
	  homePage.navigateToArmaniFromMen();
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
	  shoppingcartPage.clickCancel();
	  storesPage.switchToAlertAndAccept();
	  shoppingcartPage.verifyOrderCancellation();
  
  /*@Test
  public void tc011_collective_CategoriesAndBrandsUIVerifications(){
	  CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver);
	  homePage.verifyProductURLsPages();
  }*/
}
}