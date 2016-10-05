package org.projectname.initializer;

import org.openqa.selenium.support.PageFactory;
import org.projectname.customer.pageobjects.HomePageObjects;
import org.projectname.customer.pageobjects.LoginPopUpPageObjects;
import org.projectname.maincontroller.MainController;

public class PageFactoryInitializer extends MainController{

	public HomePageObjects homePage(){
		
		return PageFactory.initElements(driver, HomePageObjects.class);
	}
	
	
	public LoginPopUpPageObjects loginPopUp(){
		
		return PageFactory.initElements(driver, LoginPopUpPageObjects.class);
	}
	
}