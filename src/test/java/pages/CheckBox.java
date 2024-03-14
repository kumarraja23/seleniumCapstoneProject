package pages;

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
		String arr[] = {"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input"};
		for(String str: arr) {
			if(!driver.findElement(By.xpath(str)).isSelected()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isUnCheckAll() {
		String arr[] = {"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input"};
		for(String str: arr) {
			if(driver.findElement(By.xpath(str)).isSelected()) {
				return false;
			}
		}
		return true;
	}
	
	
	// This method is used to select the check boxes randomly
	public void randomCheck() {
		String arr[] = {"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input",
				"//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input"};
		int arr1[] = randomNumbers(arr.length);
		driver.findElement(By.xpath(arr[arr1[0]])).click();
		driver.findElement(By.xpath(arr[arr1[1]])).click();
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
