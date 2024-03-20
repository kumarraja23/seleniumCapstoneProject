package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicData {
	WebDriver driver;

	public DynamicData(WebDriver driver) {
		this.driver = driver;
	}
	
	By newuser = By.id("save");
	By dynamic = By.id("loading");
	
	By item = By.xpath("//*[@id='treemenu']//a[text() = 'Others']");
	By subitem = By.xpath("//*[@id='treemenu']//a[contains(text(),'Dynamic')]");
	
	
	public WebElement newUser() {
		return driver.findElement(newuser);
	}
	
	public WebElement dynamicData() {
		return driver.findElement(dynamic);
	}

	public WebElement item() {
		return driver.findElement(item);
	}
	
	public WebElement subtIem() {
		return driver.findElement(subitem);
	}
    
}
