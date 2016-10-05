package org.projectname.utils;

import org.projectname.maincontroller.MainController;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.File("resources/PropertyFiles/ApplicationSetUp.properties")
public class ApplicationSetUpPropertyFile extends MainController{
	
	public ApplicationSetUpPropertyFile()
	{
		PropertyLoader.populate(this);
	}
	
	@Property("url")
	private String url;
	
	@Property("browser")
	private String browser;
	
	@Property("productName")
	private String productName;
	
	@Property("videoPermisson")
	private String videoPermisson;
	
	@Property("typeOfTestForReport")
	private String typeOfTestForReport;
	
	
	@Property("from")
	private String from;
	
	@Property("getUsername")
	private String getUsername;
	
	
	@Property("password")
	private String password;
	
	
	@Property("bcc")
	private String bcc;
	
	
	@Property("cc")
	private String cc;
	
	@Property("to")
	private String to;
	
	@Property("sendEmailPermission")
	private String sendEmailPermission;
	
	
	
	public String getURL() throws Exception{
		
		return url;
		
	}
	
	
	public String getBrowser() throws Exception{
		
		return browser;
		
	}
	
	public String getProductName() throws Exception{
		
		return productName;
	}
	
	
	public String getVideoPermission() throws Exception{
		
		return videoPermisson;
	}
	
	public String getTypeOfTestForReport() throws Exception{
		
		return typeOfTestForReport;
	}
	
	public String getFrom() throws Exception{
		
		return from;
	}
	
	public String getUsername() throws Exception{
	
		return getUsername;
	}
	
	public String getPassword() throws Exception{
		
		return password;
	}
	
	public String getBcc() throws Exception{
		
		return bcc;
	}
	
	public String getcc() throws Exception{
	
		return cc;
	}
	
	public String getTo() throws Exception{
		
		return to;
	}
	
	public String getSendEmailPermisson() throws Exception{
		
		return sendEmailPermission;
	}
	
}
