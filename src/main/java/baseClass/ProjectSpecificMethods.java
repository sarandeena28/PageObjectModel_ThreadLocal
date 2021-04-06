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


public class ProjectSpecificMethods {
	public  ChromeDriver driver;
	public  ChromeOptions option;
	public static JavascriptExecutor js;
	public static String entitynewName;
	public static WebDriverWait wait;
	public static String entityName;
	public static Actions builder;
	public static String caseID;
	public static String caseNumber;
	public static String caseDetail;
	public static String caseNumberToDelete;
	public static String contactName;
	public static String sheetName;
	public static Set<String> windowHandle;
	public static List<String> windowOpen;
	public static String newFileName;
	public static SoftAssert Assert;
	public static String fileName;
	public static String file ;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest testcase;
	public String testcaseName,testCaseInfo,testCaseCategory,testcaseAuthor;
	public static ExtentTest node;
	
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		ReadExcel getData=new ReadExcel();
		String[][] data = getData.readData(sheetName);
		return data;
	}
	@BeforeSuite
	public void startReport() {
		reporter=new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(reporter);

	}
	@BeforeClass
	public void testCaseDetails() {
		testcase = extent.createTest(testcaseName, testCaseInfo);
		testcase.assignAuthor(testcaseAuthor);
		testcase.assignCategory(testCaseCategory);
		
	}
	public long takeSnap() throws IOException {
		long randomNum= (long) (Math.random() * 999999999L);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/img"+ randomNum +".png");
		FileUtils.copyFile(source, target);
		return randomNum;
		
	}
	
	public void reportSteps(String msg,String status) throws IOException {
		if(status.equalsIgnoreCase("Pass")) {
			node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("Fail")) {
			node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}
		
	}
	@BeforeMethod
	public void startApp() throws InterruptedException {
	node = testcase.createNode(testcaseName);
	WebDriverManager.chromedriver().setup();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
	String downloadFilepath = "C:\\Our Folder\\Maven project\\PageObjectModel_SalesForce\\downloads";
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", downloadFilepath);
	option.setExperimentalOption("prefs", chromePrefs);
	driver = new ChromeDriver(option);
	driver.manage().window().maximize(); 
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://login.salesforce.com/");

	}
	
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
}
