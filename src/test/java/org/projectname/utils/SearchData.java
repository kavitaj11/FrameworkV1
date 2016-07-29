package org.projectname.utils;

import org.projectname.maincontroller.MainController;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.File("resources/PropertyFiles/SearchData.properties")

public class SearchData extends MainController{

	@Property("userName")
	private String userName;
	
	@Property("password")
	private String password;
	
	@Property("nameOfTheUser")
	private String nameOfTheUser;
	
	
	
	
	public SearchData()
	{
		PropertyLoader.populate(this);
	}



	public String getUserName() {
		
		return userName;
	}



	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}



	public String getNameOfTheUser() {
		// TODO Auto-generated method stub
		return nameOfTheUser;
	}

	}
