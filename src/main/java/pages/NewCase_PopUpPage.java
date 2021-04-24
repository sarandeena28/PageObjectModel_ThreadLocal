package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class NewCase_PopUpPage extends ProjectSpecificMethods {
	
//	public NewCase_PopUpPage(RemoteWebDriver driver) {
//		try {
//			this.driver=driver;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//	}
	public NewCase_PopUpPage choose_Contact_name(String ContactName) throws InterruptedException {
		sendKey(locateElement("xpath","//input[@title='Search Contacts']"),ContactName);
		Thread.sleep(2000);
//		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//		WebElement element = locateElement("xpath","//mark[contains(text(),'ContactName')]/ancestor::a");
//		wait.until(ExpectedConditions.stalenessOf(element));
//		click(element);
		click(locateElement("xpath","//mark[contains(text(),'Saran')]/ancestor::li"));
//		try {
//			driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys(ContactName);
//			driver.findElementByXPath("//ul[@class='lookup__list  visible']//li[3]").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	
	public NewCase_PopUpPage select_Status() {
		wait=new WebDriverWait(getter(),Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='select']"))).click();
		click(locateElement("xpath","//a[@title='Escalated']"));
//		try {
//			wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='select']"))).click();
//			driver.findElementByXPath("//a[@title='Escalated']").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public NewCase_PopUpPage enterSubject(String Subject) {
		sendKey(locateElement("xpath","//input[@class=' input']"),Subject);
//		try {
//			driver.findElementByXPath("//input[@class=' input']").sendKeys(Subject);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;

	}
	public NewCase_PopUpPage enterDescription(String Decription) {
		sendKey(locateElement("xpath","//textarea[@class=' textarea']"),Decription);
//		try {
//			driver.findElementByXPath("// textarea[@class=' textarea']").sendKeys(Decription);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;

	}
	 
	public HomePage clickSave() throws InterruptedException {
		click(locateElement("xpath","//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']"));
		Thread.sleep(3000);
//		try {
//			driver.findElementByXPath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']").click();
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return new HomePage();
	}
}
