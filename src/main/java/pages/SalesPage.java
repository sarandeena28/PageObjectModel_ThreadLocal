package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;


public class SalesPage extends ProjectSpecificMethods {
	public SalesPage(ChromeDriver driver) {
		try {
			this.driver=driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	public SalesPage clickCase() {
		try {
			js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", driver.findElementByXPath("//a[@title='Cases']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage(); 
		}
		//driver.findElementByXPath("//a[@title='Cases']").click();
		return this;
	}
	
	public SalesPage clickDropdownOfCase() {
		try {
			driver.findElementByXPath("//span[text()='Cases Menu']/ancestor::a[@class='slds-button slds-button_reset']").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	
	public SalesPage clickMyCases() {
		try {
			js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='My Cases']/ancestor::a"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;

	}
	
	public SalesPage getStatus() {
		try {
			String caseStatus = driver.findElementByXPath("//table[@role='grid']//tbody//tr").getText();
			System.out.println(caseStatus);
			caseNumber = driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a").getText();
			System.out.println(caseNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public SalesPage clickDropdowmofMyCase() {
		try {
			driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public EditPopupPage clickEdit() {
		try {
			driver.findElementByXPath("//div[text()='Edit']/ancestor::a").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new EditPopupPage(driver);
	}
	
	public SalesPage verifyStaus() throws InterruptedException {
		try {
			wait=new WebDriverWait(driver,Duration.ofSeconds(90));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr")));
			Thread.sleep(3000);
			String status = driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a[text()='"+caseNumber+"']/following::span[@class='slds-truncate']").getText();
			System.out.println(status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	
	public SalesPage getCaseDetail_And_caseNumber() {
		try {
			caseDetail= driver.findElementByXPath("//table[@role='grid']//tbody//tr").getText();
			System.out.println(caseDetail);
			caseNumberToDelete=driver.findElementByXPath("//table[@role='grid']//tbody//tr//th//a").getText();
			System.out.println(caseNumberToDelete);
			contactName = driver.findElementByXPath("//table[@role='grid']//tbody//tr//td[3]//a").getText();
			System.out.println(contactName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	
	public  SalesPage clickDelete(){
		try {
			driver.findElementByXPath("//div[text()='Delete']/parent::a").click();
			driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public SalesPage enterContactnameToSearch() {
		try {
			driver.findElementByXPath("//input[@name='Case-search-input']").sendKeys(contactName,Keys.ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public SalesPage verifyContactName_Deleted() {
		try {
			String text = driver.findElementByXPath("//div[@class='listViewContent slds-table--header-fixed_container']").getText();
			if (text.equals("No records to display")) {
				System.out.println("Case not deleted");
			} else {
				System.out.println("Case deleted");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}

}
