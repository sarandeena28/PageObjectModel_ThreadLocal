package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.ProjectSpecificMethods;

public class MySalesForcePage extends ProjectSpecificMethods{
	public MySalesForcePage(ChromeDriver driver) {
		try {
			this.driver=driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage(); 
		}
	}
}
 