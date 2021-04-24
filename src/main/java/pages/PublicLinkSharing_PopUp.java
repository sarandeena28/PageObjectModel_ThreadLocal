package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class PublicLinkSharing_PopUp extends ProjectSpecificMethods {
//	public PublicLinkSharing_PopUp(RemoteWebDriver driver) {
//		this.driver=driver;
//	}
//	
	
	public PublicLinkSharing_PopUp check_Link() throws IOException {
		getTypedTextByTitle(locateElement("xpath","//div[@class='slds-grid']//button[@type='button']"));
		if(getter().findElement(By.xpath("//button[text()='"+attributeTitle+"']")).isDisplayed()) { 
			getter().findElement(By.xpath("//button[text()='Create Link']")).click();
			getter().findElement(By.xpath("//span[text()='Create']/parent::button")).click();
		}
//		String Link = driver.findElementByXPath("//div[@class='slds-grid']//button[@type='button']").getAttribute("title");
//		System.out.println(Link);
//		try {
//			if(driver.findElementByXPath("//button[text()='"+Link+"']").isDisplayed()) { 
//				driver.findElementByXPath("//button[text()='Create Link']").click();
//				driver.findElementByXPath("//span[text()='Create']/parent::button").click();
//			}
////			else {	
////				driver.findElementByXPath("//button[text()='Copy Link']");
////			}
//			reportSteps("CheckLink disabled successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("Link not disabled successfully","Fail");
//		} 
		return this;
	}

	public PublicLinkSharing_PopUp publicLinkSharing_CopyLink() throws IOException {
		click(locateElement("xpath","//button[text()='Copy Link']"));
//		try {
//			driver.findElementByXPath("//button[text()='Copy Link']");
//			reportSteps("CopyLink clicked successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("CopyLink not clicked successfully","Fail");
//		}
		return this;
	}
	
	public PublicLinkSharing_PopUp check_TextFieldIsDisabled() throws InterruptedException, IOException {
		try {
			WebElement link=getter().findElement(By.xpath("//input[@name='publicLinkURL']"));
			System.out.println(link.isEnabled());
			reportSteps("CheckedTextField successfully","Pass");
		} catch (Exception e) {
			reportSteps("CheckedTextField not successfull","Fail");
		}
		return this;
	}
	public FileOpenedPage close_PublicLinkSharingPopUp() throws InterruptedException, IOException {
		click(locateElement("xpath","//span[text()='Close this window']/ancestor::button"));
		Thread.sleep(2000);
//		try {
//			driver.findElementByXPath("//span[text()='Close this window']/ancestor::button").click();
//			Thread.sleep(2000);
//			reportSteps("closed publickSharingLink successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("closed publickSharingLink not successfull","Fail");
//		}
		return new FileOpenedPage() ;
		
	}
}
