package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class EditCase extends ProjectSpecificMethods{
	@BeforeTest
	public void provideTestDetail() {
		testcaseName="EditCase";
		testCaseInfo="EditCase with Positive Credentials";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
//		sheetName="EditCase";
		excelFileName="Edit_Case";
	}
	@Test(dataProvider="fetchData")
	public void editcase(String Username,String Password) throws InterruptedException, IOException {
		new LoginPage()
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
