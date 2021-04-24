package pages;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class NewlyCreate_EntityPage extends ProjectSpecificMethods{
//	public NewlyCreate_EntityPage(RemoteWebDriver driver) {
//		try {
//			this.driver=driver;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//	}
	public boolean verifyLegalEntityName() {
		return	verifyExactText(locateElement("xpath","//div[@class='toastContent slds-notify__content']//span[@class='toastMessage slds-text-heading--small forceActionsText']"),entitynewName);
//		try {
//			wait=new WebDriverWait(driver,Duration.ofSeconds(500));
//			String createdEntityName = driver.findElementByXPath("//div[@class='toastContent slds-notify__content']//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
//			System.out.println(createdEntityName);
//			if(entitynewName.contains(createdEntityName)) {
//				System.out.println("New Legal Entity Created Succesfully");
//			}
//			else {
//				System.out.println("New Legal Entity not Created");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//		return this;
	}
}
