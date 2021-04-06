package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.ProjectSpecificMethods;
import pages.LoginPage;

public class Edit_Order extends ProjectSpecificMethods{
	@BeforeTest
	public void  getSheetName(){
		sheetName="Edit_Order";
	}
	@Test(dataProvider="fetchData")
	public void edit_Order(String Username,String Password) throws IOException {
		new LoginPage(driver)
		.enterUsernam(Username)
		.enterPassword(Password)
		.clickLoginButton()
		.clickToggle()
		.clickViewAll()
		.click_ServiceConsole()
		.click_orders()
//		.click_AllOrders()
		.click_FirstOrder()
		.click_EditFromdropdown()
		.remove_AlreadyExistingAccount()
		.select_AnotherAccountName()
		.clear_RemoveAlreadyExistingContractNumber()
		.select_AnotherContractNumber()
		.click_Save();
	}
}
