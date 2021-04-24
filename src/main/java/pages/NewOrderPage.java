package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class NewOrderPage extends ProjectSpecificMethods {
//	public NewOrderPage(RemoteWebDriver driver) {
//		this.driver=driver;
//	}
//	
	public NewOrderPage select_ContractNumber(String ContractNumber) {
		click(locateElement("xpath","//span[text()='New Order']/parent::a"));
		sendKey(locateElement("xpath","//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']"),ContractNumber);
		click(locateElement("xpath","//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']//a"));
//		driver.findElementByXPath("//span[text()='New Order']/parent::a").click();
//		driver.findElementByXPath("//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys(ContractNumber);
//		driver.findElementByXPath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']//a").click();
		return this;
	}
	public NewOrderPage select_AccountName(String AccountName) {
		sendKey(locateElement("xpath","(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]"),AccountName);
		click(locateElement("xpath","(//mark[text()='Test'])[2]/ancestor::a"));
//		driver.findElementByXPath("(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]").sendKeys(AccountName);
//		driver.findElementByXPath("(//mark[text()='Test'])[2]/ancestor::a").click();
		return this;
	}
	public NewOrderPage select_Status() {
		wait=new WebDriverWait(getter(),Duration.ofSeconds(900));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='select'])[2]"))).click();
		click(locateElement("xpath","//a[@title='Activated']"));
//		driver.findElementByXPath("//a[@title='Activated']").click();
		return this;
	}
	public NewOrderPage select_OrderStartDate() {
		LocalDate date=LocalDate.now();
		LocalDate plusDays = date.plusDays(11);
		System.out.println(plusDays);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String nextMonth = dtf.format(plusDays);
		sendKey(locateElement("xpath","//div[@class='form-element']//input"),nextMonth);
//		driver.findElementByXPath("//div[@class='form-element']//input").sendKeys(nextMonth);
		return this;
	}
	
	public OrdersPage click_Save() {
		click(locateElement("xpath","(//span[text()='Save']/parent::button)[2]"));
//		driver.findElementByXPath("(//span[text()='Save']/parent::button)[2]").click();
		return  new OrdersPage();
	}
}
