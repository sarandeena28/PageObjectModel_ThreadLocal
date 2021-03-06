package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class Create_NewCase extends ProjectSpecificMethods {
	
	@BeforeTest
	public void provideTestDetail() {
		testcaseName="Create_NewCase";
		testCaseInfo="Create_NewCase with Positive Credentials";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
		excelFileName="Create_NewCase";
//		sheetName="Create_NewCase";
	}
	@Test (dataProvider="fetchData")
	public void create_NewCase(String Username,String Password,String ContactName,String Subject,String Description) throws InterruptedException, IOException {
		new LoginPage()
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.click_GlobalActions_SVG()
		.clcikNewCase_dropdown()
		.choose_Contact_name(ContactName)
		.select_Status()
		.enterSubject(Subject)
		.enterDescription(Description)
		.clickSave()
		.verify_NewlyCreated_case();
	}
}
