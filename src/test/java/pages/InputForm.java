package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputForm {
	WebDriver driver;
	
	public InputForm(WebDriver driver) {
		this.driver = driver;
	}
	
	By fname = By.name("first_name");
	By lname = By.name("last_name");
	By email = By.name("email");
	By ph = By.name("phone");
	By address = By.name("address");
	By city = By.name("city");
	By postal = By.name("zip");
	By web = By.name("website");
	By hstYes = By.xpath("//input[@name = 'hosting' and @value = 'yes']");
	By hstNo = By.xpath("//input[@name = 'hosting' and @value = 'no']");
	By comment = By.xpath("//textarea");
	By submit = By.cssSelector(".col-md-4 button");
	By state = By.xpath("//select[@name = 'state']");
	By color = By.xpath("//label[text() = 'First Name']");
	
	public WebElement firstName() {
		return driver.findElement(fname);
	}
	
	public WebElement lastName() {
		return driver.findElement(lname);
	}
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement phNumber() {
		return driver.findElement(ph);
	}
	
	public WebElement address() {
		return driver.findElement(address);
	}
	
	public WebElement city() {
		return driver.findElement(city);
	}
	
	public WebElement zipcode() {
		return driver.findElement(postal);
	}
	
	public WebElement website() {
		return driver.findElement(web);
	}
	
	public WebElement hosted() {
		return driver.findElement(hstYes);
	}
	
	public WebElement notHosted() {
		return driver.findElement(hstNo);
	}
	
	public WebElement discription() {
		return driver.findElement(comment);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	public WebElement state() {
		return driver.findElement(state);
	}
	
	public WebElement color() {
		return driver.findElement(color);
	}

}
