package pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.ProjectSpecificMethods;

public class ServiceConsolePage extends ProjectSpecificMethods {

	public ServiceConsolePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
//	public ServiceConsolePage click_Home() {
//		driver.findElementByXPath("//a[@title='Home']").click();
//		return this;
//	}
	
	public OrdersPage click_orders() { 
		driver.findElementByXPath("//span[text()='Orders']/ancestor::a").click();
		return new OrdersPage(driver);
	}
	 
	public ServiceConsolePage click_dropdown() {
		driver.findElementByXPath("//span[text()='Show Navigation Menu']/parent::button").click();
		return this;
		
	}
	
	public FilesPage click_FilefromDropdown() throws IOException {
		try {
			driver.findElementByXPath("(//span[text()='Files']/ancestor::a)[2]").click();
			reportSteps("Dropdown Clicked successfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportSteps("Dropdown not Clicked successfully","Fail");
		}
		return new FilesPage(driver);
	}
	

}
