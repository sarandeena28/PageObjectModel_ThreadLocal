package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class NewLegal_Entity_PopUpPage extends ProjectSpecificMethods {
//	public NewLegal_Entity_PopUpPage(RemoteWebDriver driver) {
//		try {
//			this.driver=driver;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//	}
	public NewLegal_Entity_PopUpPage enterEntityName(String EntityName) {
		sendKey(locateElement("xpath","//input[@class=' input']"),EntityName);
		entitynewName = webdriver.findElementByXPath("//input[@class=' input']").getAttribute("value");
		System.out.println(entitynewName);
//	try {
//		driver.findElementByXPath("//input[@class=' input']").sendKeys(EntityName);
//		entitynewName = driver.findElementByXPath("//input[@class=' input']").getAttribute("value");
//		System.out.println(entitynewName);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.getMessage();
//	}	
	return this;
	}
	
//	public  String getEntityNewName() {
//		
//		return (this,getTypedText(locateElement("xpath","//input[@class=' input']")));
//	}
	public NewlyCreate_EntityPage clickSave() {
		click(locateElement("xpath","//button[@title='Save']"));
//	try {
//		driver.findElementByXPath("//button[@title='Save']").click();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.getMessage();
//	}
	return new NewlyCreate_EntityPage();

	}
	
}
