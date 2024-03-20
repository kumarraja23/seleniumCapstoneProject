package pageTesting;

import org.testng.annotations.Test;

import basePack.BaseClass;
import pages.DragAndDrop;
import pages.DynamicData;
import pages.HomePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

@Listeners(basePack.Listeners.class)

public class Project5TestCases extends BaseClass {
	
	HomePage mainObj; 
  
	public Project5TestCases() throws IOException {
		super();
	}
	
	@BeforeTest
	  public void beforeTest() {
		System.out.println("\n------------------Project5 started------------------");
//		driver = getDriver();
//		driver.get(getTestLink());
		
	  }
	
	  @Test()
	  public void dragAndDropTest() {
		  System.out.println("In   Others -> Drag and Drop Testing is Started !!");
		  Reporter.log("In   Others -> Drag and Drop Testing is Started !!");
		  mainObj = new HomePage(driver);
		 
		  mainObj.navigation(6, 0);
		  
//		  mainObj.scrollByPixel(0, 280);
		  
		  DragAndDrop obj = new DragAndDrop(driver);
	      Actions dd = new Actions(driver);
	      
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	      ArrayList<String> dragdummyList = new ArrayList<>();
	      ArrayList<String> dropdummyList = new ArrayList<>();
	      
	      for (WebElement item : obj.from()) {
	    	  System.out.println("Draged file name: "+item.getText());
	    	  dragdummyList.add(item.getText());
	    	  dd.dragAndDrop(item, obj.to()).build().perform();
	    	  System.out.println("Droped file name: "+obj.dropList().get(obj.dropList().size()-1).getText());
	    	  dropdummyList.add(obj.dropList().get(obj.dropList().size()-1).getText());
	    	  wait.until(ExpectedConditions.stalenessOf(item));
	          
	      }
	      Assert.assertEquals(dropdummyList, dragdummyList);
		  System.out.println("In   Others -> Drag and Drop Testing is Completed !!");
		  Reporter.log("\nIn   Others -> Drag and Drop Testing is Completed !!");

	  }
	  
	  @Test(priority = 1)
	  public void dynamicDataTest() {
		  System.out.println("In   Others -> Dynamic Data Testing is Started !!");
		  Reporter.log("In   Others -> Dynamic Data Testing is Started !!");
		  DynamicData obj = new DynamicData(driver);
		  obj.item().click();
		  obj.subtIem().click();
		 
		  obj.newUser().click();
		  if(!obj.dynamicData().isDisplayed()) {
			  Assert.fail();
		  }
		  
		  obj.newUser().click();
		  if(!obj.dynamicData().isDisplayed()) {
			  Assert.fail();
		  }
		  
		  System.out.println("In   Others -> Dynamic Data Testing is Completed !!");
		  Reporter.log("\nIn   Others -> Dynamic Data Testing is Completed !!");
		  
	  }
	
	  @AfterTest
	  public void afterTest() {
		  System.out.println("\n------------------Project5 Completed------------------");
		  driver.close();
		  driver = null;
	  }

}
