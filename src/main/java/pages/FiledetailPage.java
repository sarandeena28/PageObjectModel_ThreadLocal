package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class FiledetailPage extends ProjectSpecificMethods {
//	public FiledetailPage(RemoteWebDriver driver) {
//		this.driver=driver;
//	}
	
	public FiledetailPage verifyFileName() throws InterruptedException, IOException {
		wait=new WebDriverWait(getter(),Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='"+file+"']//span[@class='uiOutputText']")));
		String fileName =getElementText(locateElement("xpath","//div[@title='"+file+"']//span[@class='uiOutputText']"));
		System.out.println("Print FileName"+fileName);
		verifyExactText(locateElement("xpath","//span[contains(text(),'"+ file +"')]"), fileName);
//		try {
//			wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='"+file+"']//span[@class='uiOutputText']")));
//			String fileName = driver.findElementByXPath("//div[@title='"+file+"']//span[@class='uiOutputText']").getText();
//			System.out.println("Print FileName"+fileName);
//			
//			if(newFileName.equals(fileName)) {
//				System.out.println("FileName Verified Succesfully");
//			}
//			else {
//				System.out.println("FileName doesnot match");
//			}
//			reportSteps("VerifiedFileName successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("VerifiedFileName not successfull","Fail");
//		}
		return this;
	}
	
	public FiledetailPage verifyFileExtension() throws InterruptedException, IOException {
		wait=new WebDriverWait(getter(),Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='saran_hello_world']/following::span[@class='uiOutputText']")));
		getElementText(locateElement("xpath","//div[@title='saran_hello_world']/following::span[@class='uiOutputText']"));
//		try {
//			wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='saran_hello_world']/following::span[@class='uiOutputText']")));
//			String fileExtension =driver.findElementByXPath("//div[@title='saran_hello_world']/following::span[@class='uiOutputText']").getText();
//			System.out.println(fileExtension);
//			reportSteps("VerifiedFileExtension successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("VerifiedFileExtension not successfull","Fail");
//		}
		return this;
	}
	
	public FilesPage closeFileDetailTab() throws IOException {
		click(locateElement("xpath","//span[contains(text(),'Close')]/ancestor::button"));
		click(locateElement("xpath","//span[text()='Files']/parent::a"));
//		try {
//			driver.findElementByXPath("//span[contains(text(),'Close')]/ancestor::button").click();
//			driver.findElementByXPath("//span[text()='Files']/parent::a").click();
//			reportSteps("CloseFileTab closed successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("CloseFileTab not closed successfully","Fail");
//		}
		return new FilesPage();
	}

}
