package org.collective.testmethods;
import org.collective.maincontroller.MainController;
import org.collective.testImplementation.CollectiveTestCaseImplementation;
import org.collective.dataprovider.SearchData;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class CollectiveSmokeTestCustomer extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */

  
  @Test(dataProvider="loginScenarios", dataProviderClass=SearchData.class)
  public void tc001_collective_login(String phoneNumber, String password) throws Exception
  {
	  CollectiveTestCaseImplementation.loginScenarios(phoneNumber,password);
  }
}
