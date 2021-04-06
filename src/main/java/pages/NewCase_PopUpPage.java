package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class NewCase_PopUpPage extends ProjectSpecificMethods {
	
	public NewCase_PopUpPage(ChromeDriver driver) {
		try {
			this.driver=driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	public NewCase_PopUpPage choose_Contact_name(String ContactName) {
		try {
			driver.findElementByXPath("//input[@title='Search Contacts']").sendKeys(ContactName);
			driver.findElementByXPath("//ul[@class='lookup__list  visible']//li[3]").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	
	public NewCase_PopUpPage select_Status() {
		try {
			wait=new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='select']"))).click();
			driver.findElementByXPath("//a[@title='Escalated']").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public NewCase_PopUpPage enterSubject(String Subject) {
		try {
			driver.findElementByXPath("//input[@class=' input']").sendKeys(Subject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;

	}
	public NewCase_PopUpPage enterDescription(String Decription) {
		try {
			driver.findElementByXPath("// textarea[@class=' textarea']").sendKeys(Decription);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;

	}
	 
	public HomePage clickSave() throws InterruptedException {
		try {
			driver.findElementByXPath("//button[@class='slds-button slds-button--brand cuf-publisherShareButton uiButton']").click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new HomePage(driver);
	}
}
