package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JQueryDualLB {
	WebDriver driver;
	
	public JQueryDualLB(WebDriver driver) {
		this.driver = driver;
	}
	
	By add = By.className("pAdd");
	By addAll = By.className("pAddAll");
	By remove = By.className("pRemove");
	By removeAll = By.className("pRemoveAll");
	
	By leftListIts = By.cssSelector(".pickData option");
	By rightListIts = By.cssSelector(".pickListResult option");
	
	By leftList = By.className("pickData");
	By rightList = By.className("pickListResult");
	
	
	public WebElement add() {
		return driver.findElement(add);
	}
	
	public WebElement addAll() {
		return driver.findElement(addAll);
	}
	
	public WebElement remove() {
		return driver.findElement(remove);
	}
	
	public WebElement removeAll() {
		return driver.findElement(removeAll);
	}
	
	public WebElement pickRandomDataToAdd() {
		List<WebElement> elements = driver.findElements(leftListIts);
//		System.out.println(elements.size());
		int rand = (int) Math.floor(Math.random() * elements.size());
		return elements.get(rand);
		
	}

	public WebElement pickRandomDataToRemove() {
		List<WebElement> arr = driver.findElements(rightListIts);
		int rand = (int) Math.floor(Math.random() * arr.size());
		return arr.get(rand);
		
	}
	
	public List<WebElement> multiRandomDataToAdd() {
		
		List<WebElement> elements = driver.findElements(leftListIts);
		List<WebElement> randElements = new ArrayList<>();
		
		randElements.add(elements.get((int) Math.floor(Math.random() * elements.size())));
		randElements.add(elements.get((int) Math.floor(Math.random() * elements.size())));
		randElements.add(elements.get((int) Math.floor(Math.random() * elements.size())));
		randElements.add(elements.get((int) Math.floor(Math.random() * elements.size())));
		
		return randElements;
		
	}
	
	public List<WebElement> multiRandomDataToRemove() {
		
		List<WebElement> elements = driver.findElements(rightListIts);
		List<WebElement> randElements = new ArrayList<>();
		
		randElements.add(elements.get((int) Math.floor(Math.random() * elements.size())));
		randElements.add(elements.get((int) Math.floor(Math.random() * elements.size())));
		randElements.add(elements.get((int) Math.floor(Math.random() * elements.size())));
		randElements.add(elements.get((int) Math.floor(Math.random() * elements.size())));
		return randElements;
	}
	
	public List<WebElement> leftListItems(){
		return driver.findElements(leftListIts);
	}
	
	public List<WebElement> rightListItems(){
		return driver.findElements(rightListIts);
	}
	
	public WebElement leftList() {
		return driver.findElement(leftList);
	}
	
	public WebElement rightList() {
		return driver.findElement(rightList);
	}
	
	
}
