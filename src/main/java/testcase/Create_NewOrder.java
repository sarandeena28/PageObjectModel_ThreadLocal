package testcase;


import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class Create_NewOrder extends ProjectSpecificMethods {
	@BeforeTest
	public void provideTestDetail() {
		testcaseName="Create_NewOrder";
		testCaseInfo="Create_NewOrder with Positive Credentials";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
//		sheetName="Create_NewOrder";
		excelFileName="Create_NewOrder";
	}
	@Test (dataProvider="fetchData")
	public void create_NewOrder(String Username,String Password,String AccountName,String ContractNumber) throws InterruptedException, IOException {
		
		new LoginPage()
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.click_ServiceConsole()
		.click_dropdown()
//		.click_Home()
//		.click_HomePageDropdown()
		.click_orders()
		.click_OrderDropdown()
		.click_AllOrders()
		.click_New()
		.select_AccountName(AccountName)
		.select_ContractNumber(ContractNumber)
		.select_Status()
		.select_OrderStartDate()
		.click_Save();
	}

}
