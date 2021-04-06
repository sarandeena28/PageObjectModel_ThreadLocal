package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class EditCase extends ProjectSpecificMethods{
	@BeforeTest
	public void getSheetName() {
		sheetName="EditCase";
	}
	@Test(dataProvider="fetchData")
	public void editcase(String Username,String Password) throws InterruptedException, IOException {
		new LoginPage(driver)
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.clickSales()
		.clickCase()
		.clickDropdownOfCase()
		.clickMyCases() 
		.getStatus()
		.clickDropdowmofMyCase()
		.clickEdit()
		.selectStatus()
		.selectPriority()
		.selectCaseOrigin()
		.selectSLAViolation()
		.clickSaveEditedCase()
		.verifyStaus();
	}

}
