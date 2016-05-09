package org.projectname.maincontroller;
import org.openqa.selenium.support.PageFactory;
import org.projectname.customer.pageobjects.HomePageObjects;

public class PageFactoryInitializer extends MainController{

	public HomePageObjects homePage()
	{
		HomePageObjects homePage = PageFactory.initElements(driver,HomePageObjects.class);
		return homePage;
	}
	
}
