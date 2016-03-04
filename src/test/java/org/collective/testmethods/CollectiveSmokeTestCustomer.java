package org.collective.testmethods;
import org.collective.maincontroller.MainController;
import org.collective.customer.pageobjects.CollectiveHomePageObjects;
import org.collective.dataprovider.SearchData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CollectiveSmokeTestCustomer extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */

  
  @Test(dataProvider="tc001_collective_login", dataProviderClass=SearchData.class)
  public void tc001_collective_login(String search) throws Exception
  {
			CollectiveHomePageObjects homePage = new CollectiveHomePageObjects(driver);
			homePage.searchTest(search);
			Assert.assertTrue(homePage.verifyButton(), "button is not displayed");
		}

  }

