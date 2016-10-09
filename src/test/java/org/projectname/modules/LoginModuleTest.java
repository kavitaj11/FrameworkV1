package org.projectname.modules;
import java.io.File;
import java.io.IOException;

import org.projectname.dataprovider.DataDrivenTestingFromExcel;
import org.projectname.initializer.PageFactoryInitializer;
import org.projectname.utils.ApplicationSetUpPropertyFile;
import org.projectname.utils.ExcelLibrary;
import org.projectname.utils.SearchDataPropertyFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LoginModuleTest extends PageFactoryInitializer{

	SearchDataPropertyFile data = new SearchDataPropertyFile();
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@Features("Login Module")
	@Test(groups={"regression"},dataProvider="multipleSheetsSameExcel",dataProviderClass=DataDrivenTestingFromExcel.class)
	@TestCaseId("TC_Login_001")
	@Description("This is a test for qa engineering team")
	public void loginTest1(String testCaseId,String userName,String password,String expectedName){
		
		System.out.println(testCaseId);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(expectedName);
	}
	
	@Features("Login Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_Login_002")
	@Description("This is a test for failed scenario screenshot attachment")
	public void failedCaseTest(){
		Assert.assertTrue(false);
	}
	
	@Features("Login Module")
	@Test(groups={"regression"},dataProvider="multipleSheetsSameExcel",dataProviderClass=DataDrivenTestingFromExcel.class)
	@TestCaseId("TC_Login_003")
	@Description("This is a test for qa engineering team")
	public void loginTest2(String testCaseId,String userName,String password,String expectedName){
		
		System.out.println(testCaseId);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(expectedName);
	}
	
	@Features("Login Module")
	@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=DataDrivenTestingFromExcel.class)
	@TestCaseId("TC_Login_004")
	@Description("This is a test for qa engineering team")
	public void searchText_Scenarios(String testCaseId,String searchText){
		
		System.out.println(testCaseId);
		System.out.println(searchText);
	}
	
	@Test(groups={"regression"})
	@Features("Login Module")
	public void loginTest3() throws IOException{
		File file = new File("resources/ETNATestData.xlsx");
		ExcelLibrary excel = new ExcelLibrary(file.getAbsolutePath(),"loginTest2");		
		
		System.out.println(excel.xlsxReadCell("Password", 2));
		
		//for row number and column number reading, make sure you provider 1 value less for the respective row number and the column number. 
		System.out.println(excel.xlsxReadCell(0, 2));
		
		ExcelLibrary excel1 = new ExcelLibrary(file.getAbsolutePath(),"loginTest1");
		
		System.out.println(excel1.xlsxReadCell("Password", 1));
		//for row number and column number reading, make sure you provider 1 value less for the respective row number and the column number. 
		
		System.out.println(excel1.xlsxReadCell(3, 1));
	}
	
	@Test(groups={"regression"},dataProvider="multipleSheetsSameExcel",dataProviderClass=DataDrivenTestingFromExcel.class)
	@Features("attachment test")
	@Description("Simple attachment tests for different file formats")
	public void attachmentsTest1(String format, String filePath) throws Exception{
	
		attachFile(filePath);
	}
	
	@Test(groups={"regression"},dataProvider="multipleSheetsSameExcel",dataProviderClass=DataDrivenTestingFromExcel.class)
	@Features("Login Module")
	@TestCaseId("")
	@Description("")
	public void login_ErrorScenarios(String userName,String password,String expectedErrorMsg) throws Exception
	{
		homePage().clickOnLoginLink().enterUsername(userName).enterPassword(password)
		.clickOnLoginButton().verifyErrorMessage(expectedErrorMsg);
	}
}
