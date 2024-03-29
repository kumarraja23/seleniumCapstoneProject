package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtons {
	WebDriver driver;
	
	public RadioButtons(WebDriver driver) {
		this.driver = driver;
	}
	
	By gender = By.xpath("//*[@class = 'radio-inline']/input[@name='optradio' and @value = 'Male']");
	By checkedValue = By.id("buttoncheck");
	By gender1 = By.xpath("//*[@class = 'radio-inline']/input[@value = 'Male' and @name='gender']");
	By age = By.cssSelector("input[value = '5 - 15']");
	By get = By.xpath("//button[text() = 'Get values']");
	By msg = By.xpath("//p[@class = 'radiobutton']");
	By gmsg = By.cssSelector("p.groupradiobutton");
	
	public WebElement gender() {
		return driver.findElement(gender);
	}
	
	public WebElement check() {
		return driver.findElement(checkedValue);
	}
	
	public WebElement genderVal() {
		return driver.findElement(gender1);
	}
	
	public WebElement age() {
		return driver.findElement(age);
	}
	
	public WebElement getValues() {
		return driver.findElement(get);
	}
	
	public WebElement getMsg() {
		return driver.findElement(msg);
	}
	
	public WebElement getGroupmsg() {
		return driver.findElement(gmsg);
	}

}
