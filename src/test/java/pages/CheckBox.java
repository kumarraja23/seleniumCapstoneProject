package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
	WebDriver driver;

	public CheckBox(WebDriver driver) {
		this.driver = driver;
	}
	
	By check = By.id("isAgeSelected");
	By checkall = By.id("check1");
	By uncheckall = By.cssSelector("input[value='Uncheck All']");
	
	
	public WebElement singleCheck() {
		return driver.findElement(check);
	}
	
	
	public WebElement checkAll() {
		return driver.findElement(checkall);	
	}
	
	public WebElement unCheckAll() {
		return driver.findElement(uncheckall);	
	}
	
	public boolean isCheckAll() {
		List<WebElement> elements = driver.findElements(By.className("cb1-element"));
		for(WebElement webEle: elements) {
			if(!webEle.isSelected()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isUnCheckAll() {
		List<WebElement> elements = driver.findElements(By.className("cb1-element"));
		for(WebElement webEle: elements) {
			if(webEle.isSelected()) {
				return false;
			}
		}
		return true;
	}
	
	
	// This method is used to select the check boxes randomly
	public void randomCheck() {
		List<WebElement> elements = driver.findElements(By.className("cb1-element"));
		int arr1[] = randomNumbers(elements.size());
		elements.get(arr1[0]).click();
		elements.get(arr1[1]).click();
		
	}
	
	// This method is used to generate two random integers 
	static int[] randomNumbers(int N) {
		int n1 = (int) Math.floor(Math.random()*N);
		int n2;
		do {
			n2 = (int) Math.floor(Math.random()*N);
		}while(n1==n2);
		
		int arr[] = {n1,n2};
		return arr;
	}

}
