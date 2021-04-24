package pages;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import baseClass.ProjectSpecificMethods;

public class AppLauncher_PopUpPage extends ProjectSpecificMethods {
//	public AppLauncher_PopUpPage(RemoteWebDriver driver) {
//		try {
//			this.driver=driver;

//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage(); 
//		}
//	}
	public LegalEntitiesPage clickLegalEntities() {
		js=(JavascriptExecutor)getter();
		js.executeScript("javascript:window.scrollBy(0,500)");
		click(locateElement("xpath","//p[text()='Legal Entities']/ancestor::li"));

//		try {
//			js=(JavascriptExecutor)driver;
//			js.executeScript("javascript:window.scrollBy(0,500)");
//			driver.findElementByXPath("//p[text()='Legal Entities']/ancestor::li").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return new LegalEntitiesPage();

	}
	public SalesPage clickSales() {
		click(locateElement("xpath","//p[text()='Sales']/ancestor::div[@class='slds-app-launcher__tile-body slds-truncate']"));
//		try {
//			driver.findElementByXPath("//p[text()='Sales']/ancestor::div[@class='slds-app-launcher__tile-body slds-truncate']").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return new SalesPage();

	}
	public ServiceConsolePage click_ServiceConsole() throws IOException {
		try {
			 wait=new WebDriverWait(getter(),Duration.ofSeconds(30));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Service Console']"))).click();
				reportSteps("ServiceConsole Clicked successfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportSteps("ServiceConsole not Clicked successfully","Fail");
		}
		return new ServiceConsolePage();
	}
}
