package org.framework.testmethods;

import java.io.IOException;

import org.framework.maincontroller.MainController;
import org.framework.pageobjects.GoogleHomePageObjects;
import org.testng.annotations.Test;

public class GoogleSearchTest extends MainController{
	  
	/*
	 * @author Hemanth.Sridhar
	 */
  
  @Test
  public void HM_1254() throws IOException, InterruptedException {
	  GoogleHomePageObjects homePage = new GoogleHomePageObjects(driver); 
	  homePage.searchForTextAndClick();
  }
  
  
  /*@Test
  public void searchText(){
	  googleHomePageObjects homePage = new googleHomePageObjects(driver);
	  homePage.searchForAnotherOne();
  }*/
}