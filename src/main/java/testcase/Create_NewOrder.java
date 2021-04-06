package testcase;


import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class Create_NewOrder extends ProjectSpecificMethods {
	@BeforeTest
	public void getSheetName() {
		sheetName="Create_NewOrder";
	}
	@Test (dataProvider="fetchData")
	public void create_NewOrder(String Username,String Password) throws InterruptedException, IOException {
		
		new LoginPage(driver)
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.click_ServiceConsole()
//		.click_Home()
//		.click_HomePageDropdown()
		.click_orders()
		.click_OrderDropdown()
		.click_AllOrders()
		.click_New()
		.select_AccountName()
		.select_ContractNumber()
		.select_Status()
		.select_OrderStartDate()
		.click_Save();
	}

}
