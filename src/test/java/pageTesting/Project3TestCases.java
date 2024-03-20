package pageTesting;

import org.testng.annotations.Test;

import basePack.BaseClass;
import pages.BootstrapAlertMsg;
import pages.HomePage;
import pages.ProgressBarModel;
import pages.WindowPopupModel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

@Listeners(basePack.Listeners.class)

public class Project3TestCases extends BaseClass {
	HomePage mainObj;
	
	 public Project3TestCases() throws IOException {
		super();
	}


	@BeforeTest
	  public void beforeTest() {
		  System.out.println("\n------------------Project3 Started------------------");
//		  driver = getDriver();
//		  driver.get(getTestLink());
	  }
	  
	  
	  @Test
	  public void bootStrapAlertMsgTest() {
		  System.out.println("In  Alerts & Modals -> Bootstrap Alerts Testing is Started !!");
		  Reporter.log("In  Alerts & Modals -> Bootstrap Alerts Testing is Started !!");
		  mainObj = new HomePage(driver);
//		  mainObj.scroll();
		  mainObj.navigation(4, 0);
		  
		  BootstrapAlertMsg obj = new BootstrapAlertMsg(driver);
		  obj.autoSuccessAlert().click();
		  Assert.assertEquals(obj.autoCloseableSuccessAlert().isDisplayed(), true);
		  
		  obj.normalSuccessAlert().click();
		  Assert.assertEquals(obj.closeSuccessAlert().isDisplayed(), true);
		  
		  obj.closeSuccessAlert().click();
		  Assert.assertEquals(obj.closeSuccessAlert().isDisplayed(), false);
		  
		  obj.autoWarningAlert().click();
		  Assert.assertEquals(obj.autoCloseableWarningAlert().isDisplayed(), true);
		  
		  obj.normalWarningAlert().click();
		  Assert.assertEquals(obj.closeWarningAlert().isDisplayed(), true);
		  
		  obj.closeWarningAlert().click();
		  Assert.assertEquals(obj.closeWarningAlert().isDisplayed(), false);
		  
		  obj.autoDangerAlert().click();
		  Assert.assertEquals(obj.autoCloseableDangerAlert().isDisplayed(), true);
		  
		  obj.normalDangerAlert().click();
		  Assert.assertEquals(obj.closeDangerAlert().isDisplayed(), true);
		  
		  obj.closeDangerAlert().click();
		  Assert.assertEquals(obj.closeDangerAlert().isDisplayed(), false);
		  
		  obj.autoInfoAlert().click();
		  Assert.assertEquals(obj.autoCloseableInfoAlert().isDisplayed(), true);
		  
		  obj.normalInfoAlert().click();
		  Assert.assertEquals(obj.closeInfoAlert().isDisplayed(), true);
		  
		  obj.closeInfoAlert().click();
		  Assert.assertEquals(obj.closeDangerAlert().isDisplayed(), false);
		  
		  System.out.println("In  Alerts & Modals -> Bootstrap Alerts Testing is Completed !!");
		  Reporter.log("\nIn  Alerts & Modals -> Bootstrap Alerts Testing is Completed !!");
	  }
	  
	  @Test(priority = 1)
	  public void windowPopupModelTest() {
		  System.out.println("In  Alerts & Modals -> Window Popup Modal Testing is Started !!");
		  Reporter.log("In  Alerts & Modals -> Window Popup Modal Testing is Started !!");
		  mainObj.navigation(4, 2);
		  
		  WindowPopupModel obj = new WindowPopupModel(driver);
		  obj.followOnTwitter().click();
		  Assert.assertEquals(obj.isPopupWindowAppears(), true);
		  obj.popupsClose();
		  Assert.assertEquals(obj.isPopupWindowAppears(), false);
		  
		  obj.followOnFacebook().click();
		  Assert.assertEquals(obj.isPopupWindowAppears(), true);
		  obj.popupsClose();
		  
		  obj.followBothTwFb().click();
		  Assert.assertEquals(obj.isPopupWindowAppears(), true);
		  obj.popupsClose();
		  
		  obj.followAll().click();
		  Assert.assertEquals(obj.isPopupWindowAppears(), true);
		  obj.popupsClose();
		  Assert.assertEquals(obj.isPopupWindowAppears(), false);
		  
		  System.out.println("In  Alerts & Modals -> Window Popup Modal Testing is Completed !!");
		  Reporter.log("\nIn  Alerts & Modals -> Window Popup Modal Testing is Completed !!");
	  }
	  
	  @Test(priority = 2)
	  public void progressBarModel() {
		  System.out.println("In  Alerts & Modals -> Progress Bar Modal Testing is Started !!");
		  Reporter.log("In  Alerts & Modals -> Progress Bar Modal Testing is Started !!");
		  mainObj.navigation(4, 3);
		  
		  ProgressBarModel obj = new ProgressBarModel(driver);
		  obj.simpleDialog().click();
		  Assert.assertEquals(obj.progressBar().isDisplayed(), true);
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.elementToBeClickable(obj.dialogWithCustomMsg()));
		  
		  obj.dialogWithCustomMsg().click();
		  wait.until(ExpectedConditions.visibilityOf(obj.progressBar()));
		  Assert.assertEquals(obj.progressBar().isDisplayed(), true);
		  
		  wait.until(ExpectedConditions.elementToBeClickable(obj.dialogWithCustomSetting()));
		  obj.dialogWithCustomSetting().click();
		  wait.until(ExpectedConditions.visibilityOf(obj.progressBar()));
		  Assert.assertEquals(obj.progressBar().isDisplayed(), true);
		 
//		  wait.until(ExpectedConditions.elementToBeClickable(mainObj.sideBar()));
		  
		  System.out.println("In  Alerts & Modals -> Progress Bar Modal Testing is Completed !!");
		  Reporter.log("\nIn  Alerts & Modals -> Progress Bar Modal Testing is Completed !!");
	  }
	  
	
	  @AfterTest
	  public void afterTest() {
		  System.out.println("\n------------------Project3 Completed------------------");
//		  driver.close();
//		  driver = null;
	  }

}
