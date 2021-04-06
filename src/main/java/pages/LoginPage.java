package pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	public LoginPage(ChromeDriver driver) {
		this.driver=driver;
		
	}
	public LoginPage enterUsernam(String Username) throws IOException {
		try { 
			//String title = driver.getTitle();
			//System.out.println(title);
			driver.findElementById("username").sendKeys(Username);
			reportSteps("username entered successfully","Pass");
		} catch (Exception e) {
			
			reportSteps("username not entered successfully","Fail");
		} 
		return this;

	}
	public LoginPage enterPassword(String Password) throws IOException {
		try {
			driver.findElementById("password").sendKeys(Password);
			reportSteps("password entered successfully","Pass");
		} catch (Exception e) {
			reportSteps("password not entered successfully","Fail");
		}
		return this;

	}
	public HomePage clickLoginButton() throws IOException {
		try {
			driver.findElementById("Login").click();
			reportSteps("Login Clicked successfully","Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportSteps("Login not Clicked successfully","Fail");
		}
		return new HomePage(driver);
		
	}

}
