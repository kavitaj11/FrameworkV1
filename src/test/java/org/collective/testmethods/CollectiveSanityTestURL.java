package org.collective.testmethods;

import org.collective.utils.ApplicationSetUp;
import org.collective.utils.RestCustomMethods;
import org.collective.utils.SearchData;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.restassured.RestAssured;

public class CollectiveSanityTestURL {

	@Test(alwaysRun = true)
	public void tc023_PageURLsStaging()
	{
		ApplicationSetUp applicationSetUp = new ApplicationSetUp();
		RestAssured.baseURI=applicationSetUp.getURL();
		
		SearchData data = new SearchData();
		String g[] =  data.getPageURLsStaging().split(",");
		String s= RestCustomMethods.getRequestTestURLs(g, 200);
		 Assert.assertEquals("", s,s);
	
	}
	
	/*@Test(alwaysRun = true)*/
	/*public void tc002_PageURLProd() throws Exception
	{			    
		ApplicationSetUp applicationSetUp = new ApplicationSetUp();
		RestAssured.baseURI=applicationSetUp.getProdURL();
		SearchData data = new SearchData();
		String g[] =  data.getPageURLs().split(",");
		String s= RestCustomMethods.getRequestTestURLs(g, 200);
		Assert.assertEquals("", s,s);
	}*/
}