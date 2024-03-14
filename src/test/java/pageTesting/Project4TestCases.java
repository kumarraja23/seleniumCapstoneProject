package pageTesting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basePack.BaseClass;
import pages.DualListBox;
import pages.HomePage;
import pages.JQueryDualLB;

@Listeners(basePack.Listeners.class)

public class Project4TestCases extends BaseClass{
	 public Project4TestCases() throws IOException {
		super();
	}

	HomePage mainObj; 
  
	 @BeforeTest
	  public void beforeTest() {
		  System.out.println("\n------------------Project4 started------------------");
//		  driver = getDriver();
//		  driver.get(getTestLink());
	  }
 
	
	  @Test
	  public void dualListBoxTest() throws InterruptedException   {
		  System.out.println("In   List Box -> Bootstrap List Box Testing is Started !!");
		  Reporter.log("In   List Box -> Bootstrap List Box Testing is Started !!");
		  mainObj = new HomePage(driver);
		  Thread.sleep(4000);
//		  WebDriverWait wait = new WebDriverWait(driver,20);
//		  wait.until(ExpectedConditions.elementToBeClickable(mainObj.sideBar()));
//		  wait.until(ExpectedConditions.elementToBeClickable(mainObj.bListBox()));
//		  
		  mainObj.navigation(5, 0);
		  mainObj.scrollByPixel(0, 280);
		  
		  DualListBox obj = new DualListBox(driver);
		  obj.singleLeftSl().click();
		  String leftSelect = obj.singleLeftSl().getText();
		  
		  obj.moveToRight().click();
		  String move2RStr = obj.unselectRight().getText();
		  obj.unselectRight().click();
		  Assert.assertEquals(leftSelect, move2RStr);
		  
		  obj.singleRightsl().click();
		  String rightSelect = obj.singleRightsl().getText();
		  obj.moveToLeft().click();
		  
		  String move2Lstr = obj.unselectLeft().getText();
		  obj.unselectLeft().click();
		  Assert.assertEquals(rightSelect, move2Lstr);
		  
		  obj.leftSearch().sendKeys("Vestibulum");
		  obj.leftSearchedItem().click();
		  if(!obj.leftSearchedItem().getText().contains(obj.leftSearch().getText())) {
			  Assert.fail();
		  }
		  obj.moveToRight().click();
		  obj.unselectRight().click();
		  
		  obj.leftSearchClear();
		  obj.rightSearch().sendKeys("Cras justo");
		  obj.rightSearchedItem().click();
		  if(!obj.rightSearchedItem().getText().contains(obj.rightSearch().getText())) {
			  Assert.fail();
		  }
		  obj.moveToLeft().click();
		  obj.unselectLeft().click();
		  obj.rightSearchClear();
		  
		  obj.selectLeftAll().click();
		  obj.moveToRight().click();
		  obj.selectLeftAll().click();

		  obj.selectRightAll().click();
		  obj.moveToLeft().click();
		  obj.selectRightAll().click();
		  
		  obj.selectLeftAll().click();
		  obj.selectLeftAll().click();
		  
		  System.out.println("In   List Box -> Bootstrap List Box Testing is Completed !!");
		  Reporter.log("\nIn   List Box -> Bootstrap List Box Testing is Completed !!");
	  }
	  
	  @Test(priority = 1)
	  public void jQueryDualLBTest() {
		  System.out.println("In List Box -> JQuery List Box Testing is Started !!\n");
		  Reporter.log("In List Box -> JQuery List Box Testing is Started !!");
		  mainObj.navigation(5, 1);
		  mainObj.scrollByPixel(0, 250);
		  
		  JQueryDualLB obj = new JQueryDualLB(driver);
		  WebElement ele = obj.pickRandomDataToAdd();
		  ele.click();
		  String randDatatoAdd = ele.getText();
		  obj.add().click();
		  
		  List<WebElement> rL = obj.rightListItems();
		  Assert.assertEquals(rL.get(rL.size()-1).getText(), randDatatoAdd);
		  
		  ArrayList<String> dummyaddlist = new ArrayList<>();
		  ArrayList<String> dummyremovelist = new ArrayList<>();
		  
		  List<WebElement> randomAddList = obj.multiRandomDataToAdd();
		  Select options = new Select(obj.leftList());
		  
		  for(WebElement elem: randomAddList) {
			  options.selectByVisibleText(elem.getText());
			  dummyaddlist.add(elem.getText());
		  }
		  obj.add().click();
		  
		  rL = obj.rightListItems();
		  for(WebElement elem: rL) {
			  dummyremovelist.add(elem.getText());
		  }
		  System.out.println("Random select List: "+dummyaddlist);
		  System.out.println("Random added List: "+dummyremovelist);
//		  System.out.println(dummyremovelist.subList(1, dummyremovelist.size()));
		  if (!dummyremovelist.containsAll(dummyaddlist)){
			  Assert.fail();
		  }
		  
		  obj.pickRandomDataToRemove().click();
		  obj.remove().click();
		  
		  List<WebElement> randomRemoveList = obj.multiRandomDataToRemove();
		  Select option = new Select(obj.rightList());
		  
		  for(WebElement elem: randomRemoveList) {
			  option.selectByVisibleText(elem.getText());
		  }
		  obj.remove().click();
		  
		  obj.addAll().click();
		  Assert.assertEquals(obj.leftListItems().size(), 0);

		  obj.removeAll().click();
		  Assert.assertEquals(obj.rightListItems().size(), 0);
		  
		  System.out.println("\nIn List Box -> JQuery List Box Testing is Completed !!");
		  Reporter.log("\nIn List Box -> JQuery List Box Testing is Completed !!");
	  }
	 
	
	  @AfterTest
	  public void afterTest() {
		  System.out.println("\n------------------Project4 Completed------------------");
//		  driver.close();
//		  driver = null;
	  }

}
