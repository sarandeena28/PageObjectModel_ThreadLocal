package wrapperClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReport;

public class BrowserAndElementImlementation extends ExtentReport implements BrowserAndElementInterface{
//	public  ChromeDriver driver;
	public RemoteWebDriver webdriver;
	public  ChromeOptions option;
	public  WebDriverWait wait;
	public String attributeTitle;
	public EventFiringWebDriver driver;
	
	public RemoteWebDriver startApp(String url) {
		// TODO Auto-generated method stub
		return startApp("chrome", url);
	}
	public RemoteWebDriver startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				webdriver = new ChromeDriver();
				driver=new EventFiringWebDriver(webdriver);
				setter(driver);
				
			} else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				webdriver = new FirefoxDriver();
				driver=new EventFiringWebDriver(webdriver);
				setter(driver);
			} else if(browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				webdriver = new InternetExplorerDriver();
				driver=new EventFiringWebDriver(webdriver);
				setter(driver);
			}
			getter().navigate().to(url);
			getter().manage().window().maximize();
			getter().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			
				reportSteps("The Browser Could not be Launched. Hence Failed", "fail");
			
			throw new RuntimeException();
		} 
		return webdriver;
	}
//	public RemoteWebDriver startApp(String browser, String url) {
//		try {
//			if(browser.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//			} else if(browser.equalsIgnoreCase("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//			} else if(browser.equalsIgnoreCase("ie")) {
//				WebDriverManager.iedriver().setup();
//				driver = new InternetExplorerDriver();
//			}
//			driver.navigate().to(url);
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		} catch (Exception e) {
//			
//				reportSteps("The Browser Could not be Launched. Hence Failed", "fail");
//			
//			throw new RuntimeException();
//		} 
//		return driver;
//	}
	public long takeSnap(){
		long randomNum= (long) (Math.random() * 999999999L);
		try {File source = getter().getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/img"+ randomNum +".png");
		FileUtils.copyFile(source, target);
		}catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return randomNum;
	}
	public WebElement locateElement(String locatorType, String value) {
		try {
			switch(locatorType.toLowerCase()) {
			case "id": return getter().findElement(By.id(value));
			case "name": return getter().findElement(By.name(value));
			case "class": return getter().findElement(By.className(value));
			case "link": return getter().findElement(By.linkText(value));
			case "xpath": return getter().findElement(By.xpath(value));
			}
		} catch (NoSuchElementException e) {
			reportSteps("The Element locator:"+locatorType+" value Not found: "+value, "fail");
			throw new RuntimeException();
		}catch (Exception e) {
			reportSteps("The Element locator:"+locatorType+" value Not found: "+value, "fail");
		}
		return null;
	}

	public WebElement locateElement(String locatorValue) {
		// TODO Auto-generated method stub
		WebElement findElementById = getter().findElement(By.id(locatorValue));
		return findElementById;
	}

	public List<WebElement> locateElements(String type, String value) {
		// TODO Auto-generated method stub
		try {
			switch(type.toLowerCase()) {
			case "id": return getter().findElements(By.id(value));
			case "name": return getter().findElements(By.name(value));
			case "class": return getter().findElements(By.className(value));
			case "link": return getter().findElements(By.linkText(value));
			case "xpath": return getter().findElements(By.xpath(value));
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element locator:"+type+" value not found: "+value);
			throw new RuntimeException();
		}
		return null;
	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		try {
			Set<String> allWindows = getter().getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			String windowIndex = allhandles.get(index);
			getter().switchTo().window(windowIndex);
			System.out.println("The Window With index: "+index+
					" switched successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With index: "+index+ " not found");	
		}	
	}

	public void switchToWindow(String title) {
		// TODO Auto-generated method stub
		try {
			Set<String> allWindows = getter().getWindowHandles();
			for (String eachWindow : allWindows) {
				getter().switchTo().window(eachWindow);
				if (getter().getTitle().equals(title)) {
					break;
				}
			}
			System.out.println("The Window Title: "+title+
					"is switched ");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window Title: "+title+
					" not found");
		}
	}

	public void switchToFrame(int index) {
		// TODO Auto-generated method stub
		getter().switchTo().frame(index);
	}

	public void switchToFrame(String idOrName) {
		// TODO Auto-generated method stub
		getter().switchTo().frame(idOrName);
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		getter().switchTo().frame(ele);
	}

	public void defaultContent() {
		// TODO Auto-generated method stub
		getter().switchTo().defaultContent();
	}

	public boolean verifyUrl(String url) {
		// TODO Auto-generated method stub
		if (getter().getCurrentUrl().equals(url)) {
			System.out.println("The url: "+url+" matched successfully");
			return true;
		} else {
			System.out.println("The url: "+url+" not matched");
		}
		return false;
	}

	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		if (getter().getTitle().equals(title)) {
			System.out.println("Page title: "+title+" matched successfully");
			return true;
		} else {
			System.out.println("Page url: "+title+" not matched");
		}
		return false;
	}

	public void close() {
		// TODO Auto-generated method stub
		getter().close();
	}

	public void quit() {
		// TODO Auto-generated method stub
		getter().quit();
	}

	public void click(WebElement ele) {
		String text = "";
		// TODO Auto-generated method stub
		try {
			wait = new WebDriverWait(getter(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportSteps("Element "+text+" clicked", "pass"); 
		} catch (StaleElementReferenceException e) {
			reportSteps("Element "+text+"  not clicked", "fail");
			throw new RuntimeException();
		} 
	}

	public void sendKey(WebElement ele, String data) {
		// TODO Auto-generated method stub
		ele.sendKeys(data);
	}
	public void sendKeywithKeyOptions(WebElement ele, String data) {
		// TODO Auto-generated method stub
		ele.sendKeys(data,Keys.ENTER);
	}
	public void clear(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			ele.clear();
			reportSteps("The text field is cleared Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportSteps("The text field is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	public void clearAndType(WebElement ele, String data) {
		// TODO Auto-generated method stub
		try {
			ele.clear();
			ele.sendKeys(data);
			reportSteps("The sendkey data :"+data+" entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportSteps("Element "+ele+" is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	public String getElementText(WebElement ele) {
		// TODO Auto-generated method stub
		String text = ele.getText();
		return text;
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select dropdown=new Select(ele);
		dropdown.selectByVisibleText(value);
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		Select dropdown=new Select(ele);
		dropdown.selectByIndex(index);
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		Select dropdown=new Select(ele);
		dropdown.selectByValue(value);
	}

	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		try {
			if(ele.getText().contains(expectedText)) {
				reportSteps("Expected text contains the actualText "+expectedText,"pass");
				return true;
			}else {
				reportSteps("Expected text doesn't contain the actualText "+expectedText,"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		} 
		return false;
	}
	public boolean verifyExactText(WebElement ele, String expectedText) {
		try {
			if(ele.getText().equals(expectedText)) {
				reportSteps("The expected text contains the actual "+expectedText,"pass");
				return true;
			}else {
				reportSteps("The expected text doesn't contain the actual "+expectedText,"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		} 

		return false;
	}
	
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(ele.getAttribute(attribute).equals(value)) {
				reportSteps("The expected attribute :"+attribute+" value contains the actual "+value,"pass");
				return true;
			}else {
				reportSteps("The expected attribute :"+attribute+" value does not contains the actual "+value,"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}
		return false;
	} 
	public String getTypedTextByValue(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		return attributeValue;
	}
	public String getTypedTextByTitle(WebElement ele) {
		attributeTitle = ele.getAttribute("title");
		return attributeTitle;
	}
	public boolean verifyEnabled(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			if(ele.isEnabled()) {
				reportSteps("The element "+ele+" is Enabled","pass");
				return true;
			} else {
				reportSteps("The element "+ele+" is not Enabled","fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		return false;
	}

}
