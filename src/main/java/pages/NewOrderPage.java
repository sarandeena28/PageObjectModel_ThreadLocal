package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseClass.ProjectSpecificMethods;

public class NewOrderPage extends ProjectSpecificMethods {
	public NewOrderPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public NewOrderPage select_ContractNumber() {
		driver.findElementByXPath("//span[text()='New Order']/parent::a").click();
		driver.findElementByXPath("//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys("0000010");
		driver.findElementByXPath("//li[@class='lookup__item  default uiAutocompleteOption forceSearchInputLookupDesktopOption']//a").click();
		return this;
	}
	public NewOrderPage select_AccountName() {
		driver.findElementByXPath("(//input[@class=' default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[2]").sendKeys("Test");
		driver.findElementByXPath("(//mark[text()='Test'])[2]/ancestor::a").click();
		return this;
	}
	public NewOrderPage select_Status() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='select'])[2]"))).click();
		driver.findElementByXPath("//a[@title='Activated']").click();
		return this;
	}
	public NewOrderPage select_OrderStartDate() {
		LocalDate date=LocalDate.now();
		LocalDate plusDays = date.plusDays(11);
		System.out.println(plusDays);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String nextMonth = dtf.format(plusDays);
		driver.findElementByXPath("//div[@class='form-element']//input").sendKeys(nextMonth);
		return this;
	}
	
	public OrdersPage click_Save() {
		driver.findElementByXPath("(//span[text()='Save']/parent::button)[2]").click();
		return  new OrdersPage(driver);
	}
}
