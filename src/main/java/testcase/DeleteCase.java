package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class DeleteCase extends ProjectSpecificMethods {
	@BeforeTest
	public void provideTestDetail() {
		testcaseName="DeleteCase";
		testCaseInfo="DeleteCase with Positive Credentials";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
//		sheetName="DeleteCase";
		excelFileName="Delete_case";
	}
	@Test(dataProvider="fetchData")
	public void deleteCase(String Username,String Password) throws IOException {
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
		.getCaseDetail_And_caseNumber()
		.clickDropdowmofMyCase()
		.clickDelete()
		.enterContactnameToSearch()
		.verifyContactName_Deleted();
	}
	
	
}
