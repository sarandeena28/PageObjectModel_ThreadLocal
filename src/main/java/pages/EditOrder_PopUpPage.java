package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.ProjectSpecificMethods;

public class EditOrder_PopUpPage extends ProjectSpecificMethods {
	public EditOrder_PopUpPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public EditOrder_PopUpPage remove_AlreadyExistingAccount() {
		driver.findElementByXPath("(//a[@class='deleteAction'])[2]").click();
		return this;
	}
	
	public EditOrder_PopUpPage select_AnotherAccountName() {
		driver.findElementByXPath("(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]").sendKeys("Test");
		driver.findElementByXPath("(//mark[text()='Test'])[2]/ancestor::a").click();
		return this;
	}
	
	public EditOrder_PopUpPage clear_RemoveAlreadyExistingContractNumber() {
	driver.findElementByXPath("//a[@class='deleteAction']").click();
	return this;
	}
	public EditOrder_PopUpPage select_AnotherContractNumber() {
		driver.findElementByXPath("//div[text()='TestLeaf']/ancestor::a").click();
		return this;
	}
	public OrdersPage click_Save() {
	driver.findElementByXPath("(//span[text()='Save']/parent::button)[2]").click();
	return new OrdersPage(driver);
	}
}
