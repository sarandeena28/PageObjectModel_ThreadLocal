package baseClass;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;
import wrapperClass.BrowserAndElementImlementation;


public class ProjectSpecificMethods extends BrowserAndElementImlementation{
	
	public static JavascriptExecutor js;
	public static String entitynewName;	
	public static String entityName;
	public static Actions builder;
	public static String caseID;
	public static String caseNumber;
	public static String caseDetail;
	public static String caseNumberToDelete;
	public static String contactName;
	public static String sheetName;
	public  String excelFileName;
	public static Set<String> windowHandle;
	public static List<String> windowOpen;
	public static String newFileName;
	public static SoftAssert Assert;
	public static String fileName;
	public static String file ;
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		ReadExcel getData=new ReadExcel();
		String[][] data = getData.readData(excelFileName);
		return data;
	}
	
	
	@BeforeMethod
	public void startApp() throws InterruptedException {
	
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
	String downloadFilepath = "C:\\Our Folder\\Maven project\\PageObjectModel_SalesForce\\downloads";
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", downloadFilepath);
	option.setExperimentalOption("prefs", chromePrefs);
	webdriver = startApp("chrome", "https://login.salesforce.com/");
	node = testcase.createNode(testcaseName);
	}
	public void afterMethod() {
		close();
	}

	
}
