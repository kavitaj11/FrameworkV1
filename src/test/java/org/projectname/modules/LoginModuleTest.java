package org.projectname.modules;
import org.projectname.dataprovider.DataProviderFromExcel;
import org.projectname.maincontroller.PageFactoryInitializer;
import org.projectname.utils.ApplicationSetUp;
import org.projectname.utils.SearchData;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LoginModuleTest extends PageFactoryInitializer{

	SearchData data = new SearchData();
	ApplicationSetUp setUp = new ApplicationSetUp();
	
	@Features("Login Module")
	@Test(groups={"regression"},dataProvider="multipleSheetsSameExcel",dataProviderClass=DataProviderFromExcel.class)
	@TestCaseId("TC_Login_001")
	@Description("This is a test for qa engineering team")
	public void loginTest1(String testCaseId,String userName,String password,String expectedName){
		
		System.out.println(testCaseId);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(expectedName);
	}
	
	@Features("Login Module")
	@Test(groups={"regression"},dataProvider="multipleSheetsSameExcel",dataProviderClass=DataProviderFromExcel.class)
	@TestCaseId("TC_Login_002")
	@Description("This is a test for qa engineering team")
	public void loginTest2(String testCaseId,String userName,String password,String expectedName){
		
		System.out.println(testCaseId);
		System.out.println(userName);
		System.out.println(password);
		System.out.println(expectedName);
	}
	
	@Features("Login Module")
	@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=DataProviderFromExcel.class)
	@TestCaseId("TC_Login_003")
	@Description("This is a test for qa engineering team")
	public void searchText_Scenarios(String testCaseId,String searchText){
		
		System.out.println(testCaseId);
		System.out.println(searchText);
	}
}
