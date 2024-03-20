package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DualListBox {
	WebDriver driver;
	
	public DualListBox(WebDriver driver) {
		this.driver = driver;
	}
	
	By leftsng = By.xpath("//div[@class = 'well text-right'] /ul/li[3]");
	By right_mv = By.cssSelector(".move-right");
	By left_mv = By.cssSelector(".move-left");
	By leftall = By.xpath("(//div[@class = 'btn-group'])[1]/a/i");
	By rightall = By.xpath("(//div[@class = 'btn-group'])[2]/a/i");
	By rightSearch = By.xpath("(//div[@class = 'input-group'])[2]/input");
	By leftSearch = By.xpath("(//div[@class = 'input-group'])[1]/input");
	By rightsng = By.xpath("//div[@class = 'dual-list list-right col-md-5']//li[contains(text() ,'Dapibus')]");
	
	By unselectR = By.xpath("//div[@class = 'dual-list list-right col-md-5']//li[last()]");
	By unselectL = By.xpath("//div[@class = 'well text-right']//li[last()]");
	By leftSearchedItem = By.xpath("//div[@class = 'well text-right']//li[not(@style)]");
	By rightSearchItem = By.xpath("//div[@class = 'dual-list list-right col-md-5']//li[not(@style)]");
	
	
	
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
