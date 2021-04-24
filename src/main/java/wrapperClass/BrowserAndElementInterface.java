package wrapperClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface BrowserAndElementInterface {
	
	public RemoteWebDriver startApp(String url) ;
	public RemoteWebDriver startApp(String browser,String url);
	public WebElement locateElement(String locatorType,String value);
	public WebElement locateElement(String locatorType);
	public List<WebElement> locateElements(String type, String value);	
	public void switchToWindow(int index);
	public void switchToWindow(String Title);
	public void switchToFrame(int index);
	public void switchToFrame(String idOrName);
	public void switchToFrame(WebElement ele);
	public void defaultContent();
	public boolean verifyUrl(String url);
	public boolean verifyTitle(String title);
	public void close();
	public void quit();
	public void click(WebElement ele);
	public void sendKey(WebElement ele, String data);
	public void clear(WebElement ele);
	public void clearAndType(WebElement ele,String data);
	public String getElementText(WebElement ele);	
	public void selectDropDownUsingVisibleText(WebElement ele, String value) ;
	public void selectDropDownUsingIndex(WebElement ele, int index) ;
	public void selectDropDownUsingValue(WebElement ele, String value) ;
	public boolean verifyPartialText(WebElement ele, String expectedText);
	public boolean verifyEnabled(WebElement ele);
	

}
