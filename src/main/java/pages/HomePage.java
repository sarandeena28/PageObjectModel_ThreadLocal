package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import baseClass.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
//	public HomePage(RemoteWebDriver driver) {
//		try {
//			this.driver=driver;  
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//	} 
	public HomePage clickToggle() throws IOException {
		click(locateElement("xpath","//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']"));
//		try {
//			driver.findElementByXPath("//button[@class='bare slds-icon-waffle_container slds-context-bar__button slds-button uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']").click();
//			reportSteps("Toggle Clicked successfully","Pass");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			reportSteps("Toggle not  Clicked successfully","Fail");
//		}
		return this;
	}
	
	public AppLauncher_PopUpPage clickViewAll() throws IOException {
		click(locateElement("xpath","//button[text()='View All']"));
//		try {
//			driver.findElementByXPath("//button[text()='View All']").click();
//			reportSteps("ViewAll Clicked successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("ViewAll Not Clicked successfully","Fail");
//		}
		return new AppLauncher_PopUpPage();

	}
	
	public HomePage click_GlobalActions_SVG() throws IOException {
		click(locateElement("xpath","//lightning-icon[@class='slds-button slds-button--icon slds-button--icon-small slds-button--icon-container slds-button--icon-x-small slds-global-header__button--icon-actions globalCreateButton slds-icon-utility-add slds-icon_container']/ancestor::a"));
//		try {
//			driver.findElementByXPath("//lightning-icon[@class='slds-button slds-button--icon slds-button--icon-small slds-button--icon-container slds-button--icon-x-small slds-global-header__button--icon-actions globalCreateButton slds-icon-utility-add slds-icon_container']/ancestor::a").click();
//			reportSteps("GlobalActions Clicked successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("GlobalActions not Clicked successfully","Fail");
//		}
		return this;
	}
	
	public NewCase_PopUpPage clcikNewCase_dropdown() {
		click(locateElement("xpath","//a[@title='New Case']"));
//		try {
//			driver.findElementByXPath("//a[@title='New Case']").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return new NewCase_PopUpPage();
	}
	public HomePage verify_NewlyCreated_case() throws InterruptedException {
		String VerifySaveMessage=getElementText(locateElement("xpath","//div[@class='toastContainer slds-notify_container slds-is-relative']//div[@role='alert']"));
		System.out.println(VerifySaveMessage);
		caseID = VerifySaveMessage.replaceAll("\\D", "");
		System.out.println(caseID);
		SoftAssert checkassert=new SoftAssert();
		checkassert.assertEquals(VerifySaveMessage, "case was Created");
		Thread.sleep(3000);
		String actualResult="case was Created";
		verifyPartialText(locateElement("xpath","//div[@class='toastContainer slds-notify_container slds-is-relative']//div[@role='alert']"),actualResult);
//		try {
//			String VerifySaveMessage = driver.findElementByXPath("//div[@class='toastContainer slds-notify_container slds-is-relative']//div[@role='alert']").getText();
//			System.out.println(VerifySaveMessage);
//			caseID = VerifySaveMessage.replaceAll("\\D", "");
//			System.out.println(caseID);
//			SoftAssert checkassert=new SoftAssert();
//			checkassert.assertEquals(VerifySaveMessage, "case was Created");
//			Thread.sleep(3000);
//			if(VerifySaveMessage.contains("case was Created")) {
//				System.out.println("Case Succesfully Created");
//			}
//			else
//			{
//				System.out.println("Case not Created");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;

	}
	
	public MySalesForcePage click_LearnMore() {
		click(locateElement("xpath","//button[@title='Learn More']"));
		 switchToWindow(1);
//		driver.findElementByXPath("//button[@title='Learn More']").click();
//		 windowHandle=driver.getWindowHandles();
//		 windowOpen=new ArrayList<String>(windowHandle);
//		driver.switchTo().window(windowOpen.get(1));
		return new MySalesForcePage();
		
	}
	
}
