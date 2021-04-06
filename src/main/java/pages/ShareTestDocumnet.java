package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.ProjectSpecificMethods;

public class ShareTestDocumnet extends ProjectSpecificMethods{
	public ShareTestDocumnet(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public ShareTestDocumnet click_SearchUser() {
		driver.findElementByXPath("//input[@title='Search People']").sendKeys("D");
		driver.findElementByXPath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']/ancestor::a").click();
		return this;
	}
	
	public ShareTestDocumnet verify_ErrorMsgNotToShare() {
		String errorMsge = driver.findElementByXPath("//li[@class='form-element__help']").getText();
		System.out.println(errorMsge);
		if(errorMsge.contains("Can't share file with the file owner.")) {
			System.out.println("Error Message displayed Successfully");
		}
		else {
			System.out.println("No Error Message displayed ");
		}
		return this;
	}
	public FileOpenedPage click_CloseWindow() {
		driver.findElementByXPath("//span[text()='Close this window']/parent::button").click();
		return new FileOpenedPage(driver);
	}
}
