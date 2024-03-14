package pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By page = By.xpath("//*[@id=\"treemenu\"]/li/ul/li");
	By menu = By.className("panel-heading");
	By sidebar = By.xpath("//a[text() = 'List Box']");
	By BLB = By.xpath("//a[text() = 'List Box']//following-sibling::ul/li//a[text() = 'Bootstrap List Box']");
	
	
	
	public void navigation(int mainIndex, int subIndex) {
		List<WebElement> listOfpages = driver.findElements(page);
		listOfpages.get(mainIndex).click();
		String str = "//*[@id=\"treemenu\"]/li/ul/li[%d]/ul/li";
		String fstr = String.format(str, mainIndex+1);
		List <WebElement> listOfSubpages = driver.findElements(By.xpath(fstr));
//		System.out.println(listOfSubpages);
		listOfSubpages.get(subIndex).click();
	}
	
	public void navigation(String mainbar, String subBar) {
		String str1 = "//a[text()='" +mainbar+ "']";
		driver.findElement(By.xpath(str1)).click();
		
		String str2="//li//a[text()='" +mainbar+ "']//following-sibling::ul//li//a[text()='" +subBar+ "']";
		driver.findElement(By.xpath(str2)).click();
	}
	
	// it will scroll the page until specified web element is viewed
	public void scroll() {
		WebElement ele = driver.findElement(menu);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	// it will scroll the page based on the pixel values
	public void scrollByPixel(int a,int b) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1])", a, b);
	}
	
	public WebElement sideBar() {
		return driver.findElement(sidebar);
	}
	
	public WebElement bListBox() {
		return driver.findElement(BLB);
	}

}
