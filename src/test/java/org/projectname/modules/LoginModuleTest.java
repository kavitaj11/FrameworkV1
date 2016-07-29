package org.projectname.modules;
import org.projectname.dataprovider.DataProviderFromExcel;
import org.projectname.maincontroller.PageFactoryInitializer;
import org.projectname.utils.ApplicationSetUp;
import org.projectname.utils.SearchData;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LoginModuleTest extends PageFactoryInitializer{

	SearchData data = new SearchData();
	ApplicationSetUp setUp = new ApplicationSetUp();
	
	@Features("Login Module")
	@Test(groups={"regression"})
	@TestCaseId("TC_Login_001")
	@Description("This is a test for qa engineering team")
	public void loginTest(){
		homePage()
		.clickOnLoginLink()
		.enterUsername(data.getUserName())
		.enterPassword(data.getPassword())
		.clickOnLoginButton()
		.homePage()
		.verifyNameTheUser(data.getNameOfTheUser()+"1");
	}
	
	
	@Features("Login Module")
	@Test(groups={"regression"},dataProvider="excelSheetDataRead",dataProviderClass=DataProviderFromExcel.class)
	@TestCaseId("{0}")
	@Description("This is a test for qa engineering team to demonstrate error scenarios for a login pop up")
	public void loginTestErrorScenarios(String testCaseId,@Parameter("user name")String userName,@Parameter("password")String password,@Parameter("expected error msg")String expectedErrorMsg){
		homePage()
		.clickOnLoginLink()
		.enterUsername(userName)
		.enterPassword(password)
		.clickOnLoginButton()
		.verifyErrorMessage(expectedErrorMsg);
	}
}
