package pageTesting;

import org.testng.annotations.Test;



import basePack.BaseClass;
import pages.CheckBox;
import pages.HomePage;
import pages.InputForm;
import pages.RadioButtons;
import pages.SelectDropdownList;
import pages.SimpleForm;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

@Listeners(basePack.Listeners.class)

public class Project1TestCases extends BaseClass{

	HomePage mainObj;
	
	public Project1TestCases() throws IOException {
		super();
	}

	@BeforeTest
	  public void beforeTest() {
		driver = getDriver();
		driver.get(getTestLink());
		System.out.println("------------------Project1 started------------------");
	  }
	
	  
	  
	  @Test(priority = 1)
	  public void simpleFormTest() {
		  mainObj = new HomePage(driver);
		  mainObj.scroll();
//		  mainObj.navigation(0, 0);
		  mainObj.navigation("Input Forms", "Simple Form Demo");
		  
		  System.out.println("In Input Forms Simple Form Demo Execution is Started !!");
		  Reporter.log("In Input Forms Simple Form Demo Execution is Started !!");
		  SimpleForm obj = new SimpleForm(driver);
		  obj.sendMsg().sendKeys("Hi this Kumar!");
		  obj.showMsg().click();
		  Assert.assertEquals(obj.displayMsg().getText(),"Hi this Kumar!");
		  
		  obj.num1().sendKeys(String.valueOf(30));
		  obj.num2().sendKeys(String.valueOf(26));
		  obj.calculate().click();
		  Assert.assertEquals(obj.displayValue().getText(), "56");
		  System.out.println("In Input Forms Simple Form Demo Execution is completed !!");
		  Reporter.log("\nIn Input Forms Simple Form Demo Execution is completed !!");
		  
	  }
	  
	  @Test(priority = 2)
	  public void checkBoxTest() {
//		  mainObj.navigation(0, 1);
		  mainObj.navigation("Input Forms","Checkbox Demo");
		  System.out.println("In Input Forms Check Box Demo Execution is Started !!");
		  Reporter.log("In Input Forms Check Box Demo Execution is Started !!");
		  CheckBox obj = new CheckBox(driver);
		  obj.singleCheck().click();
		  if(!obj.singleCheck().isSelected()) {
			  Assert.fail();
		  }
		  
		  obj.singleCheck().click();
		  if(obj.singleCheck().isSelected()) {
			  Assert.fail();
		  }
		  
		  obj.checkAll().click();
		  Assert.assertEquals(obj.isCheckAll(), true);
		  
		  obj.randomCheck();
		  obj.checkAll().click();
		  Assert.assertEquals(obj.isCheckAll(), true);
		  
		  obj.unCheckAll().click();
		  Assert.assertEquals(obj.isUnCheckAll(), true);
		  System.out.println("In Input Forms Check Box Demo Execution is Completed !!");
		  Reporter.log("\nIn Input Forms Check Box Demo Execution is Completed !!");
		  
	  }
	  
	  @Test(priority = 3)
	  public void radioButtonsTest() {
//		  mainObj.navigation(0, 2);
		  mainObj.navigation("Input Forms","Radio Buttons Demo");
		  
		  System.out.println("In Input Forms Radio Buttons Demo Execution is Started !!");
		  Reporter.log("In Input Forms Radio Buttons Demo Execution is Started !!");
		  
		  RadioButtons obj = new RadioButtons(driver);
		  obj.check().click();
		  Assert.assertEquals(obj.getMsg().getText(), "Radio button is Not checked");
		  
		  obj.gender().click();
		  obj.check().click();
		  Assert.assertEquals(obj.getMsg().getText(), "Radio button 'Male' is checked");
		  
		  obj.genderVal().click();
		  obj.age().click();
		  obj.getValues().click();
		  Assert.assertEquals(obj.getGroupmsg().getText(), "Sex : Male\n"
		  		+ "Age group: 5 - 15");
		  System.out.println("Input Forms Radio buttons Demo Execution is Completed !!");
		  Reporter.log("\nInput Forms Radio buttons Demo Execution is Completed !!");
		  
	  }
	  
	  @Test(priority = 4)
	  public void selectDropdownTest() {
//		  mainObj.navigation(0, 3);
		  mainObj.navigation("Input Forms","Select Dropdown List");
		  
		  System.out.println("In Input Forms Select Dropdown Demo Execution is Started !!");
		  Reporter.log("In Input Forms Select Dropdown Demo Execution is Started !!");
		  SelectDropdownList obj = new SelectDropdownList(driver);
		  
		  Select options = new Select(obj.dropDown());
		  options.selectByIndex(4);
		  Assert.assertEquals(obj.showTestMsg1().getText(), "Day selected :- Wednesday");
		  
		  Actions act = new Actions(driver);
		  act.keyDown(Keys.CONTROL);
		  System.out.println("Before selection: " + obj.showTestMsg2().getText());
		  act.click(obj.element1());
		  act.click(obj.element1());
		  act.click(obj.element2());
		  act.click(obj.element3());
		  act.keyUp(Keys.CONTROL);
		  act.perform();
		  
		  obj.firstSelected().click();
		  System.out.println("After selection: " + obj.showTestMsg2().getText());
		  Assert.assertEquals(obj.showTestMsg2().getText(), "First selected option is : Florida");
		  
		  
		  obj.getAll().click();
		  Assert.assertEquals(obj.showTestMsg2().getText(), "Options selected are : Florida,New Jersey,Texas");
		  System.out.println("Input Forms Select Dropdown Demo Execution is Completed !!");
		  Reporter.log("\nInput Forms Select Dropdown Demo Execution is Completed !!");
		  
	  }
	  
	  @Test(priority =5)
	  public void inputFormTest() throws IOException {
//		  mainObj.navigation(0, 4);
		  mainObj.navigation("Input Forms","Input Form Submit");
		  
		  System.out.println("In Input Forms Submit form Demo Execution is Started !!");
		  Reporter.log("In Input Forms Submit form Demo Execution is Started !!");
		  InputForm obj = new InputForm(driver);
		  
		  FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\userdata.xlsx");
		  try (XSSFWorkbook workBook = new XSSFWorkbook(file)) {
			XSSFSheet sheet = workBook.getSheet("Sheet1");
			  int rowNum = (int) Math.floor(Math.random()*6)+1; // randomly selecting rows from Excel sheet 
			  XSSFRow row1 = sheet.getRow(rowNum);
			  
			  obj.firstName().sendKeys(row1.getCell(0).getStringCellValue());
			  obj.lastName().sendKeys(row1.getCell(1).getStringCellValue());
			  obj.email().sendKeys(row1.getCell(2).getStringCellValue());
			  obj.phNumber().sendKeys(String.valueOf((int) row1.getCell(3).getNumericCellValue()));
			  obj.address().sendKeys(row1.getCell(4).getStringCellValue());
			  obj.city().sendKeys(row1.getCell(5).getStringCellValue());
			  
			  WebElement statedd = obj.state();
			  Select dd = new Select(statedd);
			  dd.selectByVisibleText(row1.getCell(6).getStringCellValue());
			  
			  obj.zipcode().sendKeys(String.valueOf((int) row1.getCell(7).getNumericCellValue()));
			  obj.website().sendKeys(row1.getCell(8).getStringCellValue());
			  
			  // based on the hosting data retrieved from Excel,I am performing click operations
			  if(row1.getCell(9).getStringCellValue().equalsIgnoreCase("yes")) {
				  obj.hosted().click();
			  }else {	
				  obj.notHosted().click();
			  }
			  obj.discription().sendKeys(row1.getCell(10).getStringCellValue());
			  Assert.assertEquals(obj.color().getCssValue("color"),"rgba(60, 118, 61, 1)");
			  obj.submit().click();
			  Assert.assertEquals(obj.color().getCssValue("color"),"rgba(51, 51, 51, 1)");
			  Assert.assertEquals(obj.submit().isEnabled(), true);
		}
		System.out.println("In Input Forms Submit form Demo Execution is Completed !!");
		Reporter.log("\nIn Input Forms Submit form Demo Execution is Completed !!");
	  }
	
	  @AfterTest
	  public void afterTest() {
		  System.out.println("-----------------Project1 Completed-----------------");
//		  driver.close();
//		  driver = null;
	  }

}
