package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class ExtentReport {
	private static final ThreadLocal<EventFiringWebDriver> localDriver=new ThreadLocal<EventFiringWebDriver>();
	public void setter(EventFiringWebDriver driver) {
		localDriver.set(driver);
	}
	
	public EventFiringWebDriver getter() {
		return localDriver.get();
	}
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest testcase;
	public String testcaseName,testCaseInfo,testCaseCategory,testcaseAuthor;
	public static ExtentTest node;
	public String excelFileName;
	
	@BeforeSuite
	public void startReport() {
		reporter=new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(reporter);

	}
	@BeforeClass
	public void testCaseDetails() {
		testcase = extent.createTest(testcaseName,testCaseInfo);
		testcase.assignAuthor(testcaseAuthor);
		testcase.assignCategory(testCaseCategory);
		
	}
	
	public abstract  long takeSnap();
	public void reportSteps(String msg,String status)  {
		try {
			if(status.equalsIgnoreCase("Pass")) {
				node.pass(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			}else if(status.equalsIgnoreCase("Fail")) {
				node.fail(msg,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
}
