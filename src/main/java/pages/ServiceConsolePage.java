package pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class ServiceConsolePage extends ProjectSpecificMethods {
//
//	public ServiceConsolePage(RemoteWebDriver driver) {
//		this.driver=driver;
//	}
	
//	public ServiceConsolePage click_Home() {
//		driver.findElementByXPath("//a[@title='Home']").click();
//		return this;
//	}
	
	public OrdersPage click_orders() { 
		click(locateElement("xpath","//span[text()='Orders']/ancestor::a"));
//		driver.findElementByXPath("//span[text()='Orders']/ancestor::a").click();
		return new OrdersPage();
	}
	 
	public ServiceConsolePage click_dropdown() {
		click(locateElement("xpath","//span[text()='Show Navigation Menu']/parent::button"));
//		driver.findElementByXPath("//span[text()='Show Navigation Menu']/parent::button").click();
		return this;
		
	}
	
	public FilesPage click_FilefromDropdown() throws IOException {
		click(locateElement("xpath","(//span[text()='Files']/ancestor::a)[2]"));
//		try {
//			driver.findElementByXPath("(//span[text()='Files']/ancestor::a)[2]").click();
//			reportSteps("Dropdown Clicked successfully","Pass");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			reportSteps("Dropdown not Clicked successfully","Fail");
//		}
		return new FilesPage();
	}
	

}
