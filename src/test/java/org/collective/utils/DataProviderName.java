package org.collective.utils;

import org.testng.annotations.DataProvider;

public class DataProviderName {

	public static String dataProviderName(DataProvider data) {
		String s = data.name(); 
		return s;
		
	}

}
