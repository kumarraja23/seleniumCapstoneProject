package pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableDataSearch {
    WebDriver driver;
    
	public TableDataSearch(WebDriver driver) {
		this.driver = driver;
	}
	
	By filter = By.id("task-table-filter");
	By filterBtn = By.className("btn-filter");
	By sNo = By.cssSelector("input[placeholder = '#' ]");
	By username = By.cssSelector("input[placeholder = 'Username' ]");
	By firstName = By.cssSelector("input[placeholder = 'First Name' ]");
	By lastName = By.cssSelector("input[placeholder = 'Last Name' ]");
	
	By chk = By.xpath("//tr[contains(@style,'display: table-row;')]");
	By filterdisable = By.cssSelector("tr.filters th input"); 
	
	public static String disData = "//table[@id='task-table']/tbody/tr[not(@style) or @style != 'display: none;']/td";
	public static String basePath = "//*[@class='table']/tbody/tr[not(@style) or @style != 'display: none;']/td";
	
	public WebElement filter() {
		return driver.findElement(filter);
	}
	
	public WebElement filterEnable() {
		return driver.findElement(filterBtn);
	}
	
	public WebElement sectionNo() {
		return driver.findElement(sNo);
	}
	
	public WebElement userName() {
		return driver.findElement(username);
	}
	
	public WebElement firstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement lastName() {
		return driver.findElement(lastName);
	}
	
	
	public int randomNumber() {
		return (int) Math.floor(Math.random()*5);
	}
	
	public WebElement displayData() {
		return driver.findElement(By.xpath(disData));
	}
	
	public WebElement checkData() {
		return driver.findElement(chk);
	}
	
	public List<WebElement> filterDisable(){
		return driver.findElements(filterdisable);
	}
	
	public boolean isDataIsPresent(int column,String data) {
		String path = disData+"["+column+"]";
		List<WebElement> listOfElements = driver.findElements(By.xpath(path));
		List<String> dataset = new ArrayList<>();
		for(WebElement ele : listOfElements) {
			dataset.add(ele.getText());
		}
		if(dataset.contains(data)) {
			return true;
		}
		return false;
	}
	
	public boolean checkDataIsPresent(int col, String data) {
		String path = basePath+"["+col+"]";
		String actualData = driver.findElement(By.xpath(path)).getText();
		if(actualData.equals(data)) {
			return true;
		}
		else {
			return false;
		}
	}
}
