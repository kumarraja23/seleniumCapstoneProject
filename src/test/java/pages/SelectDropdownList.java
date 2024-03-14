package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectDropdownList {
	WebDriver driver;
	
	public SelectDropdownList(WebDriver driver) {
		this.driver = driver;
	}
	
	By dropdown = By.id("select-demo");
	By show = By.cssSelector("p.selected-value");
	
	By firstSelect = By.xpath("//button[@id='printMe']");
	By getall = By.xpath("//button[@id='printAll']");
	
	
	By first = By.cssSelector("option[value = 'Florida']");
	By second = By.cssSelector("option[value = 'New Jersey']");
	By third = By.cssSelector("option[value = 'Texas']");
	
	By showall = By.cssSelector("p.getall-selected");
	
	public WebElement firstSelected() {
		return driver.findElement(firstSelect);
	}
	
	public WebElement getAll() {
		return driver.findElement(getall);
	}
	
	public WebElement dropDown() {
		return driver.findElement(dropdown);
	}
	
	
	public WebElement element1() {
		return driver.findElement(first);
	}
	
	public WebElement element2() {
		return driver.findElement(second);
	}
	
	public WebElement element3() {
		return driver.findElement(third);
	}
	
	public WebElement showTestMsg1() {
		return driver.findElement(show);
	}
	
	public WebElement showTestMsg2() {
		return driver.findElement(showall);
	}
}
