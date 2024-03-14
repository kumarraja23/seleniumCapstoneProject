package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablePagination {
	WebDriver driver;
	
	public TablePagination(WebDriver driver) {
		this.driver = driver;
	}
	
	By forword = By.className("next_link");
	By back = By.className("prev_link");
	By cnt = By.xpath("//tr[contains(@style,'display: table-row;')]");
	
	public WebElement forword() {
		return driver.findElement(forword);
	}
	
	public WebElement backword() {
		return driver.findElement(back);
	}
	
	public int noOfRows() {
		List<WebElement> list = driver.findElements(cnt);
		return list.size();
	}
}
