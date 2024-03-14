package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleForm {
    WebDriver driver;
    WebDriverWait wait;

    public SimpleForm(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); 
    }

    By msg = By.id("user-message");
    By showButton = By.xpath("//*[@id='get-input']/button");
    By num1 = By.id("value1");
    By num2 = By.id("value2");
    By calButton = By.xpath("//*[@id='gettotal']/button");
    By display = By.id("display");
    By displayval = By.id("displayvalue");
    
    public WebElement sendMsg() {
    	return driver.findElement(msg);
    }
    
    public WebElement showMsg() {
    	return driver.findElement(showButton);
    }
    
    public WebElement num1() {
    	return driver.findElement(num1);
    }
    
    public WebElement num2() {
    	return driver.findElement(num2);
    }
    
    public WebElement calculate() {
    	return driver.findElement(calButton);
    }
    
    public WebElement displayMsg() {
    	return driver.findElement(display);
    }
    
    public WebElement displayValue() {
    	return driver.findElement(displayval);
    }


}
