package org.projectname.utils;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.File("resources/PropertyFiles/SearchData.properties")

public class SearchDataPropertyFile {
	
	public SearchDataPropertyFile()
	{
		PropertyLoader.populate(this);
	}


	@Property("userName")
	private String userName;
	
	@Property("password")
	private String password;
	
	@Property("nameOfTheUser")
	private String nameOfTheUser;
	
	
	public String getUserName() {
		
		return userName;
	}



	public String getPassword() {
		
		return password;
	}



	public String getNameOfTheUser() {
	
		return nameOfTheUser;
	}

	}
