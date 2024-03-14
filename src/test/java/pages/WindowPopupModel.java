package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowPopupModel {
	WebDriver driver;

	public WindowPopupModel(WebDriver driver) {
		this.driver = driver;
	}
	
	By singleppTwitter = By.cssSelector(".followeasy[title = 'Follow @seleniumeasy on Twitter']");
	By singleppFb = By.cssSelector(".followeasy[title = 'Follow @seleniumeasy on Facebook']");
	By twitterFb = By.linkText("Follow Twitter & Facebook");
	By followall = By.id("followall");
	
	public WebElement followOnTwitter() {
		return driver.findElement(singleppTwitter);
	}
	
	public WebElement followOnFacebook() {
		return driver.findElement(singleppFb);
	}
	
	public WebElement followBothTwFb() {
		return driver.findElement(twitterFb);
	}
	public WebElement followAll() {
		return driver.findElement(followall);
	}
	
	public boolean isPopupWindowAppears() {
		Set<String> popups = driver.getWindowHandles();
		return popups.size()>1;
	}
	
	public void popupsClose() {
		  String mainWindow = driver.getWindowHandle();
		  Set<String> popups = driver.getWindowHandles();
		  Iterator<String> iter = popups.iterator();
		  while(iter.hasNext()) {
			  String child = iter.next();
			  if(!mainWindow.equalsIgnoreCase(child)) {
				  driver.switchTo().window(child).close();
			  }
		  }
		  driver.switchTo().window(mainWindow);
	  }

}
