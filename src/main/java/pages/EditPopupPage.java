package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class EditPopupPage extends ProjectSpecificMethods {
//	public EditPopupPage(RemoteWebDriver driver) {
//		this.driver=driver;
//	}
	public EditPopupPage selectStatus() throws InterruptedException {
		Thread.sleep(3000); 
		wait=new WebDriverWait(getter(),Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='slds-input slds-combobox__input'])[2]"))).click();
		click(locateElement("xpath","//input[@class='slds-input slds-combobox__input']/following::span[text()='Working']/ancestor::lightning-base-combobox-item"));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='slds-input slds-combobox__input']/following::span[text()='Working']/ancestor::lightning-base-combobox-item")));
//		driver.findElementByXPath("//input[@class='slds-input slds-combobox__input']/following::span[text()='Working']/ancestor::lightning-base-combobox-item").click();
		return this;

	}
	public EditPopupPage selectPriority() {
		click(locateElement("xpath","//a[@class='select']"));
		click(locateElement("xpath","//a[text()='Low']"));
//	driver.findElementByXPath("//a[@class='select']").click();
//	driver.findElementByXPath("//a[text()='Low']").click();
	return this;
	}
	public EditPopupPage selectCaseOrigin() throws InterruptedException {
	Thread.sleep(3000);
	wait=new WebDriverWait(getter(),Duration.ofSeconds(90));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='Case Origin']/following::a")));
		click(locateElement("xpath","//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='Case Origin']/following::a"));
		click(locateElement("xpath","//a[text()='Phone']"));
//	driver.findElementByXPath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='Case Origin']/following::a").click();
//	driver.findElementByXPath("//a[text()='Phone']").click();
	return this;
	}
	
	public EditPopupPage selectSLAViolation() {
		click(locateElement("xpath","//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='SLA Violation']/following::a"));
		click(locateElement("xpath","//a[text()='No']"));
//	driver.findElementByXPath("//div[@class='uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//span[text()='SLA Violation']/following::a").click();
//	driver.findElementByXPath("//a[text()='No']").click();
	return this;
	}
	public SalesPage clickSaveEditedCase() {
		click(locateElement("xpath","(//span[text()='Save'])[2]/parent::button"));
//	driver.findElementByXPath("(//span[text()='Save'])[2]/parent::button").click();
	return new SalesPage();
	}
}
