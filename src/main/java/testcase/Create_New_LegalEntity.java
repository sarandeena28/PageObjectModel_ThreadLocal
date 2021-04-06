package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class Create_New_LegalEntity extends ProjectSpecificMethods {
	
	@BeforeTest
	public void getSheetName() {
		sheetName="Create_New_LegalEntity";
	}
	@Test(dataProvider="fetchData")
	public void create_New_LegalEntity(String Username,String Password,String EntityName) throws IOException {
		new LoginPage(driver)
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.clickLegalEntities()
		.clickNew()
		.enterEntityName(EntityName)
		.clickSave()
		.verifyLegalEntityName();
	
		
	
	}
}
