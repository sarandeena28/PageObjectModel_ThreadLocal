package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;
import utils.ReadExcel;

public class Login extends ProjectSpecificMethods {
	
	@BeforeTest
	public void provideTestDetail() {
		testcaseName="Login";
		testCaseInfo="Login with Positive Credentials";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
		excelFileName="Login";
//		sheetName="Login";
	}
	@Test(dataProvider="fetchData") 
	public void login(String Username,String Password) throws IOException {
		new LoginPage()
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton();
	}
}
