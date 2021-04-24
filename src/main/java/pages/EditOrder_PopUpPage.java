package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class EditOrder_PopUpPage extends ProjectSpecificMethods {
//	public EditOrder_PopUpPage(RemoteWebDriver driver) {
//		this.driver=driver;
//	}
//	
	public EditOrder_PopUpPage remove_AlreadyExistingAccount() {
//		driver.findElementByXPath("(//a[@class='deleteAction'])[2]").click();
		click(locateElement("xpath","(//a[@class='deleteAction'])[2]"));
		return this;
	}
	
	public EditOrder_PopUpPage select_AnotherAccountName(String AccountName) {
		sendKey(locateElement("xpath","(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]"),AccountName);
		click(locateElement("xpath","(//mark[text()='Test'])[2]/ancestor::a"));
//		driver.findElementByXPath("(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]").sendKeys("Test");
//		driver.findElementByXPath("(//mark[text()='Test'])[2]/ancestor::a").click();
		return this;
	}
	
	public EditOrder_PopUpPage clear_RemoveAlreadyExistingContractNumber() {
		click(locateElement("xpath","//a[@class='deleteAction']"));
//	driver.findElementByXPath("//a[@class='deleteAction']").click();
	return this;
	}
	public EditOrder_PopUpPage select_AnotherContractNumber() {
		click(locateElement("xpath","//div[text()='TestLeaf']/ancestor::a"));
//		driver.findElementByXPath("//div[text()='TestLeaf']/ancestor::a").click();
		return this;
	}
	public OrdersPage click_Save() {
		click(locateElement("xpath","(//span[text()='Save']/parent::button)[2]"));
//	driver.findElementByXPath("(//span[text()='Save']/parent::button)[2]").click();
	return new OrdersPage();
	}
}
