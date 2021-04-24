package pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class LegalEntitiesPage extends ProjectSpecificMethods {
//	public LegalEntitiesPage(RemoteWebDriver driver) {
//		try {
//			this.driver=driver;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
//	}
	public NewLegal_Entity_PopUpPage clickNew() {
		click(locateElement("xpath","//div[text()='New']/ancestor::li"));
//		try {
//			driver.findElementByXPath("//div[text()='New']/ancestor::li").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return new NewLegal_Entity_PopUpPage();
	}
	public LegalEntitiesPage clickDropdownnext_To_RecentlyViewed() {
		click(locateElement("xpath","//a[@title='Select List View']/parent::div"));
//		try {
//			driver.findElementByXPath("//a[@title='Select List View']/parent::div").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	
	public LegalEntitiesPage select_AllLegalEntities() {
		click(locateElement("xpath","//span[text()='All Legal Entities']/ancestor::li"));
//		try {
//			driver.findElementByXPath("//span[text()='All Legal Entities']/ancestor::li").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	
	
	public LegalEntitiesPage searchByYourName(String SearchByName) throws InterruptedException {
		Thread.sleep(4000);
		wait=new WebDriverWait(getter(),Duration.ofSeconds(900));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='LegalEntity-search-input']")));
		sendKeywithKeyOptions(locateElement("xpath","//input[@name='LegalEntity-search-input']"),(SearchByName));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-refid='recordId']")));
//		try {
//			Thread.sleep(4000);
//			wait=new WebDriverWait(driver,Duration.ofSeconds(900));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='LegalEntity-search-input']")));
//			driver.findElementByXPath("//input[@name='LegalEntity-search-input']").sendKeys(SearchByName,Keys.ENTER);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-refid='recordId']")));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public LegalEntitiesPage clcikDropdown() throws InterruptedException {
		
//		Thread.sleep(2000);
//		WebElement element = locateElement("xpath","//span[text()='Show Actions']/ancestor::a");
//		wait=new WebDriverWait(driver,Duration.ofSeconds(900));
//		wait.until(ExpectedConditions.stalenessOf(element));
		wait=new WebDriverWait(getter(),Duration.ofSeconds(900));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Show Actions']/ancestor::a")));
		Thread.sleep(1000);

		click(locateElement("xpath","//span[text()='Show Actions']/ancestor::a"));
//		try {
//			wait=new WebDriverWait(driver,Duration.ofSeconds(900));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Show Actions']/ancestor::a")));
//			Thread.sleep(1000);
//			driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return this;
	}
	public EditLegalEntityPage clcikEdit() throws InterruptedException {
		click(locateElement("xpath","//a[@title='Edit']"));
//		try {
//			driver.findElementByXPath("//a[@title='Edit']").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		return new EditLegalEntityPage();
	}
	public String getStatus() throws InterruptedException {
		Thread.sleep(4000);
		return getElementText(locateElement("xpath","//a[@data-refid='recordId']/following::span[text()='Active']"));
		
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Active']")));
//		try {
//			String getStatus = driver.findElementByXPath("//a[@data-refid='recordId']/following::span[text()='Active']").getText();
//			//String getStatus = driver.findElementByXPath("//span[text()='Active']").getText();
//			System.out.println(getStatus);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		 
	}
	public LegalEntitiesPage clickLegalEntitiesTab() {
		try {
			js=(JavascriptExecutor)webdriver;
//		js.executeScript("arguments[0].click()",driver.findElementByXPath("//a[@title='Legal Entities']"));
//		driver.findElementByXPath("//a[@title='Legal Entities']").click();
			//driver.findElementByXPath("//a[@title='Recently Viewed | Legal Entities']").click();
			js.executeScript("arguments[0].click()",getter().findElement(By.xpath("//a[@title='Recently Viewed']")));
			//driver.findElementByXPath("//a[@title='Recently Viewed']").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;

	}
	public LegalEntitiesPage clickSortArrow_LastModifiedDate() throws InterruptedException {
		Thread.sleep(4000);
		click(locateElement("xpath","//span[contains(text(),'Last Modified Date')]/ancestor::a"));
		 Thread.sleep(4000);
		 click(locateElement("xpath","//span[contains(text(),'Last Modified Date')]/ancestor::a"));
//		try {
//			Thread.sleep(4000);
//			 wait=new WebDriverWait(driver,Duration.ofSeconds(60));
//			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Last Modified Date')]/ancestor::a")));
//			 driver.findElementByXPath("//span[contains(text(),'Last Modified Date')]/ancestor::a").click();
//			 Thread.sleep(4000);
//			 driver.findElementByXPath("//span[contains(text(),'Last Modified Date')]/ancestor::a").click();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}
		 
		return this;
		
	}
	public LegalEntitiesPage verifyLegalEntities_InascendingOrder() throws InterruptedException, ParseException {
		try {
			Thread.sleep(4000);
			wait=new WebDriverWait(getter(),Duration.ofSeconds(900));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='slds-truncate uiOutputDateTime']")));
			List<WebElement> lastModifiedDate = getter().findElements(By.xpath("//span[@class='slds-truncate uiOutputDateTime']"));
			List getDates=new ArrayList();
			for (int i = 0; i <lastModifiedDate.size(); i++) {
				String text = lastModifiedDate.get(i).getText();
				getDates.add(text);			
				}

			for (int j = 0; j <lastModifiedDate.size()-1; j++) {
				String firstEntry = getDates.get(j).toString();
				System.out.println(firstEntry);
				String nextEntry = getDates.get(j+1).toString();
				System.out.println(nextEntry);
				 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy, hh:mm a"); 
				 Date firstEntryDate = formatter.parse(firstEntry);
				System.out.println(firstEntryDate);
				Date NextEntryDate =formatter.parse(nextEntry);
			    System.out.println(NextEntryDate);		
			    if(NextEntryDate.after(firstEntryDate)) {
					System.out.println("Dates are in ascending order by Last Modified Date verified Successfully ");
				}
				else {
					System.out.println("Dates are in descending order by Last Modified Date ");
				}
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;

	}
	
}
