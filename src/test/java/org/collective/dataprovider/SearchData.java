package org.collective.dataprovider;

import org.testng.annotations.DataProvider;

public class SearchData {

	@DataProvider(name="loginScenarios")
	public static Object[][] loginScenarios(){
		return new Object[][]{
			{"9900623434","hemanth123"},
			{"9900623434","hemanth1234"}
		};
		
	}		
	}


