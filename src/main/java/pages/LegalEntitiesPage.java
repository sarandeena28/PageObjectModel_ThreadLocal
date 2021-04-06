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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class LegalEntitiesPage extends ProjectSpecificMethods {
	public LegalEntitiesPage(ChromeDriver driver) {
		try {
			this.driver=driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	public NewLegal_Entity_PopUpPage clickNew() {
		try {
			driver.findElementByXPath("//div[text()='New']/ancestor::li").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new NewLegal_Entity_PopUpPage(driver);
	}
	public LegalEntitiesPage clickDropdownnext_To_RecentlyViewed() {
		try {
			driver.findElementByXPath("//a[@title='Select List View']/parent::div").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	
	public LegalEntitiesPage select_AllLegalEntities() {
		try {
			driver.findElementByXPath("//span[text()='All Legal Entities']/ancestor::li").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	
	
	public LegalEntitiesPage searchByYourName(String SearchByName) throws InterruptedException {
		try {
			Thread.sleep(4000);
			wait=new WebDriverWait(driver,Duration.ofSeconds(900));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='LegalEntity-search-input']")));
			driver.findElementByXPath("//input[@name='LegalEntity-search-input']").sendKeys(SearchByName,Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-refid='recordId']")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public LegalEntitiesPage clcikDropdown() throws InterruptedException {
		try {
			wait=new WebDriverWait(driver,Duration.ofSeconds(900));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Show Actions']/ancestor::a")));
			Thread.sleep(1000);
			driver.findElementByXPath("//span[text()='Show Actions']/ancestor::a").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public EditLegalEntityPage clcikEdit() throws InterruptedException {
		try {
			driver.findElementByXPath("//a[@title='Edit']").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new EditLegalEntityPage(driver);
	}
	public LegalEntitiesPage getStatus() {
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Active']")));
		try {
			String getStatus = driver.findElementByXPath("//a[@data-refid='recordId']/following::span[text()='Active']").getText();
			//String getStatus = driver.findElementByXPath("//span[text()='Active']").getText();
			System.out.println(getStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public LegalEntitiesPage clickLegalEntitiesTab() {
		try {
			js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click()",driver.findElementByXPath("//a[@title='Legal Entities']"));
//		driver.findElementByXPath("//a[@title='Legal Entities']").click();
			//driver.findElementByXPath("//a[@title='Recently Viewed | Legal Entities']").click();
			js.executeScript("arguments[0].click()",driver.findElementByXPath("//a[@title='Recently Viewed']"));
			//driver.findElementByXPath("//a[@title='Recently Viewed']").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;

	}
	public LegalEntitiesPage clickSortArrow_LastModifiedDate() throws InterruptedException {
		try {
			Thread.sleep(4000);
			 wait=new WebDriverWait(driver,Duration.ofSeconds(60));
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Last Modified Date')]/ancestor::a")));
			 driver.findElementByXPath("//span[contains(text(),'Last Modified Date')]/ancestor::a").click();
			 Thread.sleep(4000);
			 driver.findElementByXPath("//span[contains(text(),'Last Modified Date')]/ancestor::a").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		 
		return this;
		
	}
	public LegalEntitiesPage verifyLegalEntities_InascendingOrder() throws InterruptedException, ParseException {
		try {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='slds-truncate uiOutputDateTime']")));
			List<WebElement> lastModifiedDate = driver.findElementsByXPath("//span[@class='slds-truncate uiOutputDateTime']");
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
