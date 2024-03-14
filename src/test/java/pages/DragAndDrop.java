package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DragAndDrop {
    WebDriver driver;
    
    public DragAndDrop(WebDriver driver) {
        this.driver = driver;
    }
    
    By drop = By.xpath("//*[@id=\"mydropzone\"]");
    By drag = By.xpath("//*[@id=\"todrag\"]/span");
    
    By dropLt = By.xpath("//*[@id=\"droppedlist\"]/span");
  
    public WebElement to() {
    	return driver.findElement(drop);
    }
    
    public List<WebElement> from(){
    	return driver.findElements(drag);
    }
    
    public List<WebElement> dropList() {
    	return driver.findElements(dropLt);
    }
}
