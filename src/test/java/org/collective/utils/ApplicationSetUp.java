package org.collective.utils;

import org.collective.maincontroller.MainController;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;



@Resource.Classpath("org/collective/utils/ApplicationSetUp.properties")

public class ApplicationSetUp extends MainController {

	public ApplicationSetUp() {
		PropertyLoader.populate(this);
	}
	
	@Property("browser")
	private static String browser;
	
	@Property("url")
	private static String url;
	
	@Property("outputfolder")
	private static String outputfolder;

	@Property("from")
	private static String from;
	
	@Property("username")
	private static String username;
	
	@Property("password")
	private static String password;
	
	@Property("bcc")
	private static String bcc;
	
	@Property("cc")
	private static String cc;
	
	@Property("to")
	private static String to;
	
	@Property("productName")
	private static String productName;
	
	@Property("prodURL")
	private static String prodURL;
	
	@Property("outputVideo")
	private static String outputVideo;
	
	public String getBrowser() {
		return browser;
	}

	public String getURL() {
		return url;
	}
	
	public String getOutputfolder() {
		return outputfolder;
	}
	public String getFrom() {
		return from;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getBCC() {
		return bcc;
	}
	
	public String getCC() {
		return cc;
	}
	
	public String getTo() {
		return to;
	}
	
	public String getproductName(){
		return productName;
	}
	
	public String getProdURL(){
		return prodURL;
	}

	public String getOutputVideo() {
		
		return outputVideo;
	}
	
}
