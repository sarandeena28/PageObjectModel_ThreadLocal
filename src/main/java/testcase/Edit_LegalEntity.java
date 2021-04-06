package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;


public class Edit_LegalEntity extends ProjectSpecificMethods {
	@BeforeTest
	public void getSheetName() {
		sheetName="Edit_LegalEntity";
	}
	@Test(dataProvider="fetchData")
	public void edit_LegalEntity(String Username,String Password,String SearchByName,String CompanyName,String Description) throws InterruptedException, IOException {
		new LoginPage(driver)
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
