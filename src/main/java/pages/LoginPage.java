package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
//	public LoginPage(RemoteWebDriver driver) {
//		this.driver=driver;
//		
//	}
	public LoginPage enterUsernam(String Username) throws IOException {
		sendKey(locateElement("username"), Username) ;
//		try { 
//			//String title = driver.getTitle();
//			//System.out.println(title);
//			driver.findElementById("username").sendKeys(Username);
//			reportSteps("username entered successfully","Pass");
//		} catch (Exception e) {
//			
//			reportSteps("username not entered successfully","Fail");
//		} 
		return this;

	}
	public LoginPage enterPassword(String Password) throws IOException {
		sendKey(locateElement("password"), Password) ;
//		try {
//			driver.findElementById("password").sendKeys(Password);
//			reportSteps("password entered successfully","Pass");
//		} catch (Exception e) {
//			reportSteps("password not entered successfully","Fail");
//		}
		return this;

	}
	public HomePage clickLoginButton() throws IOException {
		click(locateElement("Login"));
//		try {
//			driver.findElementById("Login").click();
//			reportSteps("Login Clicked successfully","Pass");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			reportSteps("Login not Clicked successfully","Fail");
//		}
		return new HomePage();
		
	}

}
