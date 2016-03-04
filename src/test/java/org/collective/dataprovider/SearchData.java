package org.collective.dataprovider;

import org.testng.annotations.DataProvider;

public class SearchData {

	@DataProvider(name="tc001_collective_login")
	public static Object[][] tc001_collective_login(){
		return new Object[][]{
			{"selenium"},
			{"appium"},
			{"        "}
		};
		
	}		
	}


