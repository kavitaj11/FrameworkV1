package org.projectname.utils;

import org.projectname.maincontroller.MainController;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

@Resource.File("resources/PropertyFiles/SearchData.properties")
public class SearchData extends MainController{

	
	@Property("searchText.generalSearch")
	private String searchText;
	
	public SearchData()
	{
		PropertyLoader.populate(this);
	}

	public String getSearchText() {
		return searchText;
	}
}
