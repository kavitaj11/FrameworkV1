package org.projectname.dataprovider;

import java.io.File;
import java.lang.reflect.Method;

import org.projectname.utils.ApplicationSetUpPropertyFile;
import org.projectname.utils.ExcelLibrary;
import org.testng.annotations.DataProvider;

public class DataDrivenTestingFromExcel {

	
		@DataProvider(name="excelSheetDataRead")
		public static Object[][] excelSheetDataRead(Method methodName) throws Exception{
			File file = new File("resources/ExcelSheetData/"+methodName.getName()+".xlsx");
			ExcelLibrary excel =  new ExcelLibrary(file.getAbsolutePath());
			 Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath());
			return data;
		}
		
		@DataProvider(name="multipleSheetsSameExcel")
		public static Object[][] singleExcelMultipleSheets(Method methodName) throws Exception{
			
			ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
			File file = new File("resources/"+setUp.getProductName()+"TestData.xlsx");
			ExcelLibrary excel =  new ExcelLibrary(file.getAbsolutePath(),methodName.getName());
			Object data[][] =	excel.readFromExcelDataForTestNGDataProvider(file.getAbsolutePath(),methodName.getName());
			return data;
		}
}