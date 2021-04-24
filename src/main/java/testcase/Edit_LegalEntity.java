package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;


public class Edit_LegalEntity extends ProjectSpecificMethods {
	@BeforeTest
	public void provideTestDetail() {
		testcaseName="Edit_LegalEntity";
		testCaseInfo="Edit_LegalEntity with Positive Credentials";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
//		sheetName="Edit_LegalEntity";
		excelFileName="Edit_LegalEntity";
	}
	@Test(dataProvider="fetchData")
	public void edit_LegalEntity(String Username,String Password,String SearchByName,String CompanyName,String Description) throws InterruptedException, IOException {
		new LoginPage()
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.clickLegalEntities()
		.clickDropdownnext_To_RecentlyViewed()
		.select_AllLegalEntities()
		.searchByYourName(SearchByName)
		.clcikDropdown()
		.clcikEdit()
		.enterCompanyName(CompanyName)
		.enterDescription(Description)
		.selectstatus()
		.clickSave()
		.getStatus();	
	
	}
}
