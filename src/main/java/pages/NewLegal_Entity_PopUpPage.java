package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.ProjectSpecificMethods;

public class NewLegal_Entity_PopUpPage extends ProjectSpecificMethods {
	public NewLegal_Entity_PopUpPage(ChromeDriver driver) {
		try {
			this.driver=driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	public NewLegal_Entity_PopUpPage enterEntityName(String EntityName) {
	try {
		driver.findElementByXPath("//input[@class=' input']").sendKeys(EntityName);
		entitynewName = driver.findElementByXPath("//input[@class=' input']").getAttribute("value");
		System.out.println(entitynewName);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}
	return this;
	}
	public NewlyCreate_EntityPage clickSave() {
	try {
		driver.findElementByXPath("//button[@title='Save']").click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}
	return new NewlyCreate_EntityPage(driver);

	}
	
}
