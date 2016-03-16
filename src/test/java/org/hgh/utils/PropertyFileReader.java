package org.hgh.utils;

import java.io.FileReader;
import java.util.Properties;


public class PropertyFileReader {

	public static String propertiesReader(String Filename, String key) throws Exception{		
		FileReader reader = new FileReader(Filename);
		Properties properties = new Properties();
		properties.load(reader);
		String s = properties.getProperty(key);
		return s;	
	}
}