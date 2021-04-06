package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.ProjectSpecificMethods;

public class EditLegalEntityPage extends ProjectSpecificMethods{
	public EditLegalEntityPage(ChromeDriver driver) {
		try {
			this.driver=driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	public EditLegalEntityPage enterCompanyName(String CompanyName) {
		try {
			driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys(CompanyName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;		
	}
	
	public EditLegalEntityPage enterDescription(String Description) {
		try {
			driver.findElementByXPath("//textarea[@class= ' textarea']").sendKeys(Description);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public EditLegalEntityPage selectstatus() {
		try {
			driver.findElementByXPath("//a[@class='select']").click();
			driver.findElementByXPath("//a[@title='Active']").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return this;
	}
	public LegalEntitiesPage clickSave() {
		try {
			driver.findElementByXPath("//button[@title='Save']").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return new LegalEntitiesPage(driver);
	}
	
}
