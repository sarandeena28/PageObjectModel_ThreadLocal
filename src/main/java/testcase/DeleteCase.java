package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class DeleteCase extends ProjectSpecificMethods {
	@BeforeTest
	public void getSheetName() {
		sheetName="DeleteCase";
	}
	@Test(dataProvider="fetchData")
	public void deleteCase(String Username,String Password) throws IOException {
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
		.getCaseDetail_And_caseNumber()
		.clickDropdowmofMyCase()
		.clickDelete()
		.enterContactnameToSearch()
		.verifyContactName_Deleted();
	}
	
	
}
