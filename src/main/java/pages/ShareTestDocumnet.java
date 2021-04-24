package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class ShareTestDocumnet extends ProjectSpecificMethods{
//	public ShareTestDocumnet(RemoteWebDriver driver) {
//		this.driver=driver;
//	}
//	
	public ShareTestDocumnet click_SearchUser() {
		sendKey(locateElement("xpath","//input[@title='Search People']"),"D");
//		driver.findElementByXPath("//input[@title='Search People']").sendKeys("D");
//		driver.findElementByXPath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']/ancestor::a").click();
		return this;
	}
	
	public ShareTestDocumnet verify_ErrorMsgNotToShare() {
		String errorMsg="Can't share file with the file owner.";
		verifyPartialText(locateElement("xpath","//li[@class='form-element__help']"),errorMsg);
		
//		getElementText(locateElement("xpath","//li[@class='form-element__help']"));
//		String errorMsge = driver.findElementByXPath("//li[@class='form-element__help']").getText();
//		System.out.println(errorMsge);
//		if(errorMsge.contains("Can't share file with the file owner.")) {
//			System.out.println("Error Message displayed Successfully");
//		}
//		else {
//			System.out.println("No Error Message displayed ");
//		}
		return this;
	}
	public FileOpenedPage click_CloseWindow() {
		click(locateElement("xpath","//span[text()='Close this window']/parent::button"));
//		driver.findElementByXPath("//span[text()='Close this window']/parent::button").click();
		return new FileOpenedPage();
	}
}
