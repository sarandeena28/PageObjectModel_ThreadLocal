package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class FilesPage extends ProjectSpecificMethods{
	
	public FilesPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public FileOpenedPage click_FirstFile() { 
		driver.findElementByXPath("//a[@class='slds-resizable forceContentCompoundFieldsTitleRenderer']").click();
		return new FileOpenedPage(driver);
	}
	public FilesPage click_UploadFiles() throws AWTException, InterruptedException {
		driver.findElementByXPath("//div[text()='Upload Files']/parent::a").click();
		Thread.sleep(1000);
		StringSelection stringSelection = new StringSelection("C:\\Users\\jegan\\saran_hello_world.py");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);			
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);	

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		return this;
	}
	
	public FilesPage click_Done() throws InterruptedException {
		Thread.sleep(2000);
		fileName = driver.findElementByXPath("//div[@class='fileName slds-truncate']").getText();
		String input = fileName.substring(0,fileName.indexOf(".")+1);
		file = input.replaceAll("\\.","");
		System.out.println(file);
		Thread.sleep(2000);
		wait=new WebDriverWait(driver,Duration.ofSeconds(500));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button[class=slds-button slds-button--neutral ok uiButton--default uiButton--brand uiButton]")));
		driver.findElementByXPath("//span[text()='Done']/parent::button").click();
		return this;
	}
	public FilesPage Click_DropdownFile() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			newFileName = driver.findElementByXPath("//span[contains(text(),'"+ file +"')]").getText();
			System.out.println(newFileName);
			wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+ file +"')]/following::td[3]//span"))).click();
			reportSteps("DropdownFile Clicked successfully","Pass");
		} catch (Exception e) {
			reportSteps("DropdownFile not Clicked successfully","Fail");
		}
		return this;
	}
	public FiledetailPage click_ViewFileDetails() throws IOException {
		try {
			driver.findElementByXPath("//a[@title='View File Details']").click();
			reportSteps("ViewFileDetails Clicked successfully","Pass");
		} catch (Exception e) {
			reportSteps("ViewFileDetails not Clicked successfully","Fail");
		}
		return new FiledetailPage(driver);
	}
	
	public FilesPage click_Delete() throws IOException {
		try {
			driver.findElementByXPath("//div[text()='Delete']/parent::a").click();
			reportSteps("Delete Clicked successfully","Pass");
		
		} catch (Exception e) {
			reportSteps("Delete not Clicked successfully","Fail");
		}
		
		return this;
	}
	public FilesPage click_DeleteConfirm() throws IOException {
		try {
			driver.findElementByXPath("//span[text()='Delete']/parent::button").click();
			reportSteps("DeleteConfirm not Clicked successfully","Pass");
		
		} catch (Exception e) {
			reportSteps("DeleteConfirm not Clicked successfully","Fail");
		
		}
		return this;
	}
	public FilesPage confirm_DeleteMessage() throws InterruptedException, IOException {
		Thread.sleep(2000);
		try {
			String deleteMessage = driver.findElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']").getText();
			System.out.println(deleteMessage);
			reportSteps("DeleteMessage displayed successfully","Pass");
		
		} catch (Exception e) {
			reportSteps("DeleteMessage not displayed successfully","Fail");
		
		}
		return this;
	}

}
