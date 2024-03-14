package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProgressBarModel {
	WebDriver driver;
	
	public ProgressBarModel(WebDriver driver) {
		this.driver = driver;
	}
	
	By simpleDialog = By.cssSelector(".btn.btn-primary");
	By customDialog = By.cssSelector(".btn.btn-success");
	By customSetting = By.cssSelector(".btn.btn-warning");
	
	By progressbar = By.xpath("/html/body/div[3]");
	
	
	public WebElement simpleDialog() {
		return driver.findElement(simpleDialog);
	}
	
	public WebElement dialogWithCustomMsg() {
		return driver.findElement(customDialog);
	}
	
	public WebElement dialogWithCustomSetting() {
		return driver.findElement(customSetting);
	}
	
	public WebElement progressBar() {
		return driver.findElement(progressbar);
	}

}
