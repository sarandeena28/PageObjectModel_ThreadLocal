package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class Edit_Order extends ProjectSpecificMethods{
	@BeforeTest
	public void  provideTestDetail(){
		testcaseName="Edit_Order";
		testCaseInfo="Edit_Order with Positive Credentials";
		testCaseCategory="Functional";
		testcaseAuthor="Saranya";
//		sheetName="Edit_Order";
		excelFileName="Edit_Order";
	}
	@Test(dataProvider="fetchData")
	public void edit_Order(String Username,String Password,String AccountName) throws IOException {
		new LoginPage()
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.click_ServiceConsole()
		.click_dropdown()
		.click_orders()
//		.click_AllOrders()
		.click_FirstOrder()
		.click_EditFromdropdown()
		.remove_AlreadyExistingAccount()
		.select_AnotherAccountName(AccountName)
		.clear_RemoveAlreadyExistingContractNumber()
		.select_AnotherContractNumber()
		.click_Save();
	}
}
