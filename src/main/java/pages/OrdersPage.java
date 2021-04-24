package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class OrdersPage extends ProjectSpecificMethods{
//	public OrdersPage(RemoteWebDriver driver) {
//		this.driver=driver;
//	}
	
	public OrdersPage click_OrderDropdown() {
//		driver.findElementByXPath("//a[@title='Select List View']").click();
		click(locateElement("xpath","//a[@title='Select List View']"));
		return this;
	}
	public OrdersPage click_AllOrders() {
//		driver.findElementByXPath("//span[text()='All Orders']/ancestor::a").click();
		click(locateElement("xpath","//span[text()='All Orders']/ancestor::a"));
		return this;
	}
	
	public NewOrderPage click_New() throws InterruptedException {
		click(locateElement("xpath","//div[text()='New']/ancestor::a"));
//		driver.findElementByXPath("//div[text()='New']/ancestor::a").click();
		return new NewOrderPage();
	}
	public OrdersPage click_FirstOrder() {
		wait=new WebDriverWait(getter(),Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable']//tbody//tr//td[8]//a"))).click();
		return this;
	}
	public EditOrder_PopUpPage click_EditFromdropdown() {
		click(locateElement("xpath","//a[@title='Edit']"));
//		driver.findElementByXPath("//a[@title='Edit']").click();
		return new EditOrder_PopUpPage();
	}
	
	
}
