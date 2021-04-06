package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.ProjectSpecificMethods;

public class FileOpenedPage extends ProjectSpecificMethods{

	public FileOpenedPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public PublicLinkSharing_PopUp click_PublicLink() throws InterruptedException, IOException { 
		try {
			Thread.sleep(2000);
			driver.findElementByXPath("//span[text()='Public Link']/parent::button").click();
			reportSteps("clicked Link successfully","Pass");
		} catch (Exception e) {
			reportSteps("clicked link not successfull","Fail");
		}
		return new PublicLinkSharing_PopUp(driver); 
	}
	public FileOpenedPage click_Download() throws InterruptedException, IOException { 
//		Thread.sleep(2000);
		try {
			wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Download']/ancestor::button/ancestor::div[@class='slds-truncate']")));
			driver.findElementByXPath("//span[text()='Download']/ancestor::button/ancestor::div[@class='slds-truncate']").click();
			reportSteps("clicked Download successfully","Pass");
		} catch (Exception e) {
			reportSteps("clicked Download not successfull","Fail");
		}	
		return this;
	}
	
	public ShareTestDocumnet click_Share() throws IOException {
		try {
			driver.findElementByXPath("//span[text()='Share']/parent::button").click();
			reportSteps("clicked share successfully","Pass");
		} catch (Exception e) {
			reportSteps("clicked share not successfull","Fail");
		}
		return new ShareTestDocumnet(driver);
	}
	public FilesPage click_CloseFileOpenedPage() throws IOException {
		try {
			driver.findElementByXPath("//button[@title='Close']").click();
			reportSteps("closed file successfully","Pass");
		} catch (Exception e) {
			reportSteps("File not closed successfully","Fail");
		}
		return new FilesPage(driver);
	}
	
}
