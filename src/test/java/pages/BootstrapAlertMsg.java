package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BootstrapAlertMsg {
	WebDriver driver;

	public BootstrapAlertMsg(WebDriver driver) {
		this.driver = driver;
	}
	
	By autosuccess = By.id("autoclosable-btn-success");
	By normalsuc = By.id("normal-btn-success");
	By autowarning = By.id("autoclosable-btn-warning");
	By normalWrning = By.id("normal-btn-warning");
	By autodanger = By.id("autoclosable-btn-danger");
	By normaldanger = By.id("normal-btn-danger");
	By autoinfo = By.id("autoclosable-btn-info");
	By normalinfo = By.id("normal-btn-info");
	
	By successClose = By.cssSelector(".alert-normal-success button");
	By warningClose = By.cssSelector(".alert-normal-warning button");
	By dangerClose = By.cssSelector(".alert-normal-danger button");
	By infoClose = By.cssSelector(".alert-normal-info button");
	
	By autocloseSuccess = By.className("alert-autocloseable-success");
	By autocloseWarning = By.className("alert-autocloseable-warning");
	By autocloseDanger = By.className("alert-autocloseable-danger");
	By autocloseInfo = By.className("alert-autocloseable-info");
	
	
	public WebElement autoSuccessAlert() {
		return driver.findElement(autosuccess);
	}
	
	public WebElement normalSuccessAlert() {
		return driver.findElement(normalsuc);
	}
	
	public WebElement autoWarningAlert() {
		return driver.findElement(autowarning);
	}
	
	public WebElement normalWarningAlert() {
		return driver.findElement(normalWrning);
	}
	
	public WebElement autoDangerAlert() {
		return driver.findElement(autodanger);
	}
	
	public WebElement normalDangerAlert() {
		return driver.findElement(normaldanger);
	}
	
	public WebElement autoInfoAlert() {
		return driver.findElement(autoinfo);
	}
	
	public WebElement normalInfoAlert() {
		return driver.findElement(normalinfo);
	}
	
	public WebElement closeSuccessAlert() {
		return driver.findElement(successClose);
	}
	
	public WebElement closeWarningAlert() {
		return driver.findElement(warningClose);
	}
	
	public WebElement closeDangerAlert() {
		return driver.findElement(dangerClose);
	}
	
	public WebElement closeInfoAlert() {
		return driver.findElement(infoClose);
	}
	
	public WebElement autoCloseableSuccessAlert() {
		return driver.findElement(autocloseSuccess);
	}
	
	public WebElement autoCloseableWarningAlert() {
		return driver.findElement(autocloseWarning);
	}
	
	public WebElement autoCloseableDangerAlert() {
		return driver.findElement(autocloseDanger);
	}
	
	public WebElement autoCloseableInfoAlert() {
		return driver.findElement(autocloseInfo);
	}
	
	

}

