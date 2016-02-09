package org.collective.testmethods;

import java.awt.AWTException;
import java.io.IOException;

import org.collective.admin.pageobjects.CollectiveAdminAnalyticScriptsPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminBlogPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminCarouselPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminHomePageObjects;
import org.collective.admin.pageobjects.CollectiveAdminOrdersPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminProductsPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminPromotionsPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminReportPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminReturnsPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminSettingsPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminStoreLocatorPageObjects;
import org.collective.admin.pageobjects.CollectiveAdminUsersPageObjects;
import org.collective.customer.pageobjects.CollectiveLoginPageObjects;
import org.collective.maincontroller.MainController;
import org.testng.annotations.Test;

public class CollectiveSanityTestAdmin extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */
	
  @Test(alwaysRun = true)
  public void tc012_collective_adminLogin() throws IOException, InterruptedException, AWTException {
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  
  }
  
  @Test(alwaysRun = true)
  public void tc013_collective_admin_reports_OrderTotalsSheet() throws InterruptedException, IOException
  {
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminReportPageObjects reportsPage = new CollectiveAdminReportPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnReports();
	  reportsPage.clickOrderTotals();
	  reportsPage.verifyOrderTotalsHeader();
	  reportsPage.clickDownloadButton();
	  
  }
  
  @Test(alwaysRun = true)
  public void tc014_evaluateAdminTabs_Returns() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminReturnsPageObjects returnsPage = new CollectiveAdminReturnsPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnReturns();
	  returnsPage.verifyReturnsPage();
	  
  }	
  
  @Test(alwaysRun = true)
  public void tc015_evaluateAdminTabs_Carousel() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminCarouselPageObjects carouselPage = new CollectiveAdminCarouselPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnCarousel();
	  carouselPage.verifyCarouselPage();
	 
  }	
  
  @Test(alwaysRun = true)
  public void tc016_evaluateAdminTabs_Orders() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminOrdersPageObjects ordersPage = new CollectiveAdminOrdersPageObjects(driver); 
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnOrders();
	  ordersPage.verifyOrdersPage();
	  
  }	
  
  @Test(alwaysRun = true)
  public void tc017_evaluateAdminTabs_Products() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminProductsPageObjects productsPage = new CollectiveAdminProductsPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnProducts();
	  productsPage.verifyProductsPage();
	
  }	
  
  @Test(alwaysRun = true)
  public void tc018_evaluateAdminTabs_Settings() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminSettingsPageObjects settingsPage = new CollectiveAdminSettingsPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnSettings();
	  settingsPage.verifySettingsPage();
	  /*adminHomePage.adminLogout();
	  homePage.verifyLogout();*/
  }
  
  
  @Test(alwaysRun = true)
  public void tc019_evaluateAdminTabs_Promotions() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminPromotionsPageObjects promotionsPage = new CollectiveAdminPromotionsPageObjects(driver);  
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnPromotions();
	  promotionsPage.verifyPromotionsPage();
	 
  }
  
  @Test(alwaysRun = true)
  public void tc020_evaluateAdminTabs_Users() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminUsersPageObjects usersPage = new CollectiveAdminUsersPageObjects(driver);  
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnUsers();
	  usersPage.verifyPromotionsPage();
	 
  }
  
  @Test(alwaysRun = true)
  public void tc021_evaluateAdminTabs_Blog() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminBlogPageObjects blogsPage = new CollectiveAdminBlogPageObjects(driver); 
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnBlog();
	  blogsPage.verifyBlogPage();
	 
  }
  
  @Test(alwaysRun = true)
  public void tc022_evaluateAdminTabs_Store() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminStoreLocatorPageObjects storesPage = new CollectiveAdminStoreLocatorPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnStores();
	  storesPage.verifyStoresPage();
	  
  }
  
  
  
  @Test(alwaysRun = true)
  public void tc023_evaluateAdminTabs_AnalyticScript() throws IOException{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminAnalyticScriptsPageObjects featureCollectionPage = new CollectiveAdminAnalyticScriptsPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickAnalyticScript();
	  featureCollectionPage.verifyAnalyticScriptPage();
	  
  }
  
  
  @Test
  public void tc024_Reports_UserList() throws Exception{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminReportPageObjects reportsPage = new CollectiveAdminReportPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnReports();
	  adminHomePage.clickUsersList();
	  reportsPage.verifyUsersListHeader();
	  reportsPage.clickDownloadButton();
  }
  
  @Test
  public void tc025_Reports_returnList() throws Exception{
	  CollectiveAdminHomePageObjects adminHomePage = new CollectiveAdminHomePageObjects(driver); 
	  CollectiveLoginPageObjects loginPage = new CollectiveLoginPageObjects(driver);
	  CollectiveAdminReportPageObjects reportsPage = new CollectiveAdminReportPageObjects(driver);
	  adminHomePage.openAdminPage();
	  loginPage.enterPhoneNumberForAdmin();
	  loginPage.enterPasswordForAdmin();
	  loginPage.clickLogin();
	  loginPage.verifyAdminLoginMsg();
	  adminHomePage.clickOnReports();
	  adminHomePage.clickReturnList();
	  reportsPage.verifyReturnsListHeader();
	  reportsPage.clickDownloadButton();
  }
  
}