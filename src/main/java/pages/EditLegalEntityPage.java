package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class EditLegalEntityPage extends ProjectSpecificMethods{
//	public EditLegalEntityPage(RemoteWebDriver driver) {
//		try {
//			this.driver=driver;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//	}
	public EditLegalEntityPage enterCompanyName(String CompanyName) {
		sendKey(locateElement("xpath","(//input[@class=' input'])[2]"),CompanyName);
//		try {
//			driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys(CompanyName);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;		
	}
	
	public EditLegalEntityPage enterDescription(String Description) {
		sendKey(locateElement("xpath","//textarea[@class= ' textarea']"),Description);
//		try {
//			driver.findElementByXPath("//textarea[@class= ' textarea']").sendKeys(Description);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public EditLegalEntityPage selectstatus() {
		click(locateElement("xpath","//a[@class='select']"));
		click(locateElement("xpath","//a[@title='Active']"));
//		try {
//			driver.findElementByXPath("//a[@class='select']").click();
//			driver.findElementByXPath("//a[@title='Active']").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public LegalEntitiesPage clickSave() throws InterruptedException {
		click(locateElement("xpath","//button[@title='Save']"));
		Thread.sleep(1000);
//		try {
//			driver.findElementByXPath("//button[@title='Save']").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return new LegalEntitiesPage();
	}
	
}
