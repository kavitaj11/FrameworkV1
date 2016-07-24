package org.projectname.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.projectname.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class DataProviderFromExcel {

	
	@DataProvider(name="excelSheetDataRead")
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
}