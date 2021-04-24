package testcase;

import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class verify_LegalEntities_SortByLastModifiedDate extends ProjectSpecificMethods {
	@BeforeTest
	public void provideTestDetails() {
		testcaseName="verify_LegalEntities_SortByLastModifiedDate";
		testCaseInfo="verify_LegalEntities_SortByLastModifiedDate with Positive Credentials";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
//		sheetName="Verify_LegalEntities_SortBy";
		excelFileName="Verify_LegalEntities_SortBy";
	}
	
	@Test(dataProvider="fetchData")
	public void verify_LegalEntities_AscendingOrder(String Username,String Password) throws InterruptedException, ParseException, IOException {
		new LoginPage()
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.clickLegalEntities()
		.clickLegalEntitiesTab()
		.clickSortArrow_LastModifiedDate()
		.verifyLegalEntities_InascendingOrder();
	}

}
