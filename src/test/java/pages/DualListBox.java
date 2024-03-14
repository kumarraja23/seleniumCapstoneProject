package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DualListBox {
	WebDriver driver;
	
	public DualListBox(WebDriver driver) {
		this.driver = driver;
	}
	
	By leftsng = By.xpath("//div/div[1]/div/ul/li[3]");
	By right_mv = By.cssSelector(".move-right");
	By left_mv = By.cssSelector(".move-left");
	By leftall = By.xpath("//*[@id=\"listhead\"]/div[2]/div/a/i");
	By rightall = By.xpath("//*[@id=\"listhead\"]/div[1]/div/a/i");
	By rightSearch = By.xpath("//*[@id=\"listhead\"]/div[2]/div/input");
	By leftSearch = By.xpath("//*[@id=\"listhead\"]/div[1]/div/input");
	By rightsng = By.xpath("//div[2]/div/div[3]/div/ul/li[2]");
	
	By unselectR = By.xpath("//div/div[3]/div/ul/li[6]");
	By unselectL = By.xpath("//div[2]/div/div[1]/div/ul/li[5]");
	By leftSearchedItem = By.xpath("//div[2]/div/div[1]/div/ul/li[4]");
	By rightSearchItem = By.xpath("//div/div[3]/div/ul/li[1]");
	
	
	
	public WebElement leftSearchedItem() {
		return driver.findElement(leftSearchedItem);
	}
	
	public WebElement rightSearchedItem() {
		return driver.findElement(rightSearchItem);
	}
	
	public WebElement singleLeftSl() {
		return driver.findElement(leftsng);
	}
	
	public WebElement singleRightsl() {
		return driver.findElement(rightsng);
	}
	
	public WebElement moveToLeft() {
		return driver.findElement(left_mv);
	}
	
	public WebElement moveToRight() {
		return driver.findElement(right_mv);
	}
	
	public WebElement selectLeftAll() {
		return driver.findElement(leftall);
	}
	
	public WebElement selectRightAll() {
		return driver.findElement(rightall);
	}
	
	public WebElement unselectRight() {
		return driver.findElement(unselectR);
	}
	
	public WebElement unselectLeft() {
		return driver.findElement(unselectL);
	}
	
	public WebElement leftSearch() {
		return driver.findElement(leftSearch);
	}
	
	public WebElement rightSearch() {
		return driver.findElement(rightSearch);
	}
	
	public void leftSearchClear() {
		driver.findElement(leftSearch).clear();
		driver.findElement(leftSearch).sendKeys(" ");
	}
	
	public void rightSearchClear() {
		driver.findElement(rightSearch).clear();
		driver.findElement(rightSearch).sendKeys(" ");;
	}
	
	
}
