package org.hgh.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.hgh.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class SearchData {

	
	@DataProvider(name="excelSheetDataRead")
	public static Object[][] excelSheetDataRead(Method methodName) throws Exception{
		File file = new File("resources/ExcelSheetData/"+methodName.getName().toString()+".xlsx");
		 Object data[][] =	ExcelLibrary.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
		return data;
	}
}