package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;


public class SalesPage extends ProjectSpecificMethods {
	
//	public SalesPage(RemoteWebDriver driver) {
//		try {
//			this.driver=driver;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//	}
	public SalesPage clickCase() {
		try {
			js=(JavascriptExecutor)webdriver;
			js.executeScript("arguments[0].click()", getter().findElement(By.xpath("//a[@title='Cases']")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage(); 
		}
		//driver.findElementByXPath("//a[@title='Cases']").click();
		return this;
	}
	
	public SalesPage clickDropdownOfCase() {
		click(locateElement("xpath","//span[text()='Cases Menu']/ancestor::a[@class='slds-button slds-button_reset']"));
//		try {
//			driver.findElementByXPath("//span[text()='Cases Menu']/ancestor::a[@class='slds-button slds-button_reset']").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	
	public SalesPage clickMyCases() {
		try {
			js=(JavascriptExecutor)getter();
			js.executeScript("arguments[0].click()", getter().findElement(By.xpath("//span[text()='My Cases']/ancestor::a")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;

	}
	
	public SalesPage getStatus() {
		String caseStatus=getElementText(locateElement("xpath","//table[@role='grid']//tbody//tr"));
		System.out.println(caseStatus);
		caseNumber=getElementText(locateElement("xpath","//table[@role='grid']//tbody//tr//th//a"));
		System.out.println(caseNumber);
//		try {
//			String caseStatus = driver.findElementByXPath("//table[@role='grid']//tbody//tr").getText();
//			System.out.println(caseStatus);
//			caseNumber = driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a").getText();
//			System.out.println(caseNumber);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public SalesPage clickDropdowmofMyCase() {
		click(locateElement("xpath","//span[text()='Show Actions']/ancestor::a"));
//		try {
//			driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public EditPopupPage clickEdit() {
		click(locateElement("xpath","//div[text()='Edit']/ancestor::a"));
//		try {
//			driver.findElementByXPath("//div[text()='Edit']/ancestor::a").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return new EditPopupPage();
	}
	
	public SalesPage verifyStaus() throws InterruptedException {
		wait=new WebDriverWait(getter(),Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr")));
		Thread.sleep(3000);
		getElementText(locateElement("xpath","//table[@role='grid']//tbody//tr//th//a[text()='"+caseNumber+"']/following::span[@class='slds-truncate']"));
//		try {
//			wait=new WebDriverWait(driver,Duration.ofSeconds(90));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr")));
//			Thread.sleep(3000);
//			String status = driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a[text()='"+caseNumber+"']/following::span[@class='slds-truncate']").getText();
//			System.out.println(status);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	
	public SalesPage getCaseDetail_And_caseNumber() {
		getElementText(locateElement("xpath","//table[@role='grid']//tbody//tr"));
		getElementText(locateElement("xpath","//table[@role='grid']//tbody//tr//th//a"));
		contactName =getElementText(locateElement("xpath","//table[@role='grid']//tbody//tr//td[3]//a"));
		System.out.println(contactName);
//		try {
//			caseDetail= driver.findElementByXPath("//table[@role='grid']//tbody//tr").getText();
//			System.out.println(caseDetail);
//			caseNumberToDelete=driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a").getText();
//			System.out.println(caseNumberToDelete);
//			contactName = driver.findElementByXPath("//table[@role='grid']//tbody//tr//td[3]//a").getText();
//			System.out.println(contactName);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	
	public  SalesPage clickDelete(){
		click(locateElement("xpath","//div[text()='Delete']/parent::a"));
		click(locateElement("xpath","//span[text()='Delete']/parent::button"));
//		try {
//			driver.findElementByXPath("//div[text()='Delete']/parent::a").click();
//			driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public SalesPage enterContactnameToSearch() {
		sendKeywithKeyOptions(locateElement("xpath","//input[@name='Case-search-input']"),contactName);
//		try {
////			driver.findElementByXPath("//input[@name='Case-search-input']").sendKeys(contactName,Keys.ENTER);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public SalesPage verifyContactName_Deleted() {
//		String elementText = getElementText(locateElement("xpath","//div[@class='listViewContent slds-table--header-fixed_container']"));
		String expectedResult="No records to display";
		verifyExactText(locateElement("xpath","//div[@class='listViewContent slds-table--header-fixed_container']"), expectedResult);
//		try {
//			String text = driver.findElementByXPath("//div[@class='listViewContent slds-table--header-fixed_container']").getText();
//			if (text.equals("No records to display")) {
//				System.out.println("Case not deleted");
//			} else {
//				System.out.println("Case deleted");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}

}
