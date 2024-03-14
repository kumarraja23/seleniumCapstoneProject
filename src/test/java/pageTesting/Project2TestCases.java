package pageTesting;

import org.testng.annotations.Test;

import basePack.BaseClass;
import pages.HomePage;
import pages.TableDataSearch;
import pages.TablePagination;
import pages.TableSortAndSearch;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

@Listeners(basePack.Listeners.class)

public class Project2TestCases extends BaseClass {
	
	HomePage mainObj;  
	
	public Project2TestCases() throws IOException {
		super();
	}

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("\n------------------Project2 started------------------");
//		  driver = getDriver();
//		  driver.get(getTestLink());
	  }
	  
	  
	  @Test
	  public void tablePaginationTest() {
		  System.out.println("In Table -> Pagination Testing is Started !!");
		  Reporter.log("In Table -> Pagination Testing is Started !!");
		  mainObj = new HomePage(driver);
//		  mainObj.scroll();
		  mainObj.navigation(2, 0);
		  
		  TablePagination obj = new TablePagination(driver);
		  Assert.assertEquals(obj.noOfRows(), 5);
		  
		  obj.forword().click();
		  Assert.assertEquals(obj.noOfRows(), 5);
		  
		  obj.forword().click();
		  Assert.assertEquals(obj.noOfRows(), 3);
		  
		  obj.backword().click();
		  Assert.assertEquals(obj.noOfRows(), 5);
		  
		  System.out.println("In Table -> Pagination Testing is Completed !!");
		  Reporter.log("\nIn Table -> Pagination Testing is Completed !!");
	  }
	  
	  @Test(priority = 1)
	  public void tableDataSearchTest() throws IOException {
		  
		  System.out.println("In Table -> Table Data Search Testing is Started !!");
		  Reporter.log("In Table -> Table Data Search Testing is Started !!");
		  mainObj.navigation(2, 1);
		  TableDataSearch obj = new TableDataSearch(driver);
		  
		  FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\tableData.xlsx");
		  try (XSSFWorkbook workBook = new XSSFWorkbook(file)) {
			  XSSFSheet sheet = workBook.getSheet("Sheet1");
			  int rowNum = (int) Math.floor(Math.random()*7)+1;
			  int colNum = (int) Math.floor(Math.random()*4);
			  XSSFRow row = sheet.getRow(rowNum);
			  XSSFCell cell = row.getCell(colNum);
				
			  if (colNum == 0) {
				  int val = (int) cell.getNumericCellValue();
				  obj.filter().sendKeys(String.valueOf(val));
				  
				  Assert.assertEquals(obj.isDataIsPresent(1, String.valueOf(val)), true);
				  
			  }else {
				  String value = cell.getStringCellValue();
				  obj.filter().sendKeys(value);
				  Assert.assertEquals(obj.isDataIsPresent(colNum+1, value), true);
			  }		
		  }
		  file.close();
		  
		  List<WebElement> filterDisableList = obj.filterDisable();
		  
		  for(WebElement we: filterDisableList) {
			  if(we.isEnabled()) {
				  Assert.fail();
			  }
		  }
		  
		  obj.filterEnable().click();
		  
		  for(WebElement we: filterDisableList) {
			  if(!we.isEnabled()) {
				  Assert.fail();
			  }
		  }

		  
		  FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\tableData.xlsx");
			try (XSSFWorkbook workBook2 = new XSSFWorkbook(file1)) {
				XSSFSheet sheet2 = workBook2.getSheet("Sheet2");
				
				String sno = String.valueOf((int) sheet2.getRow(obj.randomNumber()).getCell(0).getNumericCellValue());
				obj.sectionNo().sendKeys(sno);
				Assert.assertEquals(obj.checkDataIsPresent(1, sno), true);
				
				String userName = sheet2.getRow(obj.randomNumber()).getCell(1).getStringCellValue();
				obj.userName().sendKeys(userName);
				Assert.assertEquals(obj.checkDataIsPresent(2, userName), true);
				
				String firstName = sheet2.getRow(obj.randomNumber()).getCell(2).getStringCellValue();
				obj.firstName().sendKeys(firstName);
				Assert.assertEquals(obj.checkDataIsPresent(3, firstName), true);
				
				String lastName = sheet2.getRow(obj.randomNumber()).getCell(3).getStringCellValue();
				obj.lastName().sendKeys(lastName);
				Assert.assertEquals(obj.checkDataIsPresent(4, lastName), true);
			}
		  file1.close();
		  
		  System.out.println("In Table -> Table Data Search Testing is Completed !!");
		  Reporter.log("\nIn Table -> Table Data Search Testing is Completed !!");
	  }
	  

	  @Test(priority = 2 , dependsOnMethods = {"tableDataSearchTest"} )
	  public void tableSortAndSearchTest() {
		System.out.println("In Table -> Table Sort And Search Testing is Started !!");
		Reporter.log("In Table -> Table Sort And Search Testing is Started !!");
		  mainObj.navigation(2, 3);
		  
		  TableSortAndSearch obj = new TableSortAndSearch(driver);
		  Select options = new Select(obj.setNoOfRecords());
		  options.selectByVisibleText("25");
		  
		  Assert.assertEquals(obj.records().size(), 25);
		  
		  obj.next().click();
		  obj.previous();
		  
		  obj.checkWhetherDataIsSorted(obj.sortRecords(1), "asc");
		  obj.name().click();
		  obj.checkWhetherDataIsSorted(obj.sortRecords(1),"dsc");
		  
//		  obj.checkWhetherDataIsSorted(obj.sortRecords(2),"asc");
		  obj.position().click();
		  obj.checkWhetherDataIsSorted(obj.sortRecords(2),"asc");
		  obj.position().click();
		  obj.checkWhetherDataIsSorted(obj.sortRecords(2),"dsc");
		  
		  obj.office().click();
		  obj.checkWhetherDataIsSorted(obj.sortRecords(3),"asc");
		  
		  obj.age().click();
		  obj.checkWhetherDataIsSorted(obj.sortRecords(4),"asc");
		  
		  obj.date().click();
		  obj.checkWhetherDateIsSorted(obj.sortRecords(5),"asc");
		  
		  obj.salary().click();
		  obj.checkWhetherSalaryIsSorted(obj.sortRecords(6),"asc");
		  obj.salary().click();
		  obj.checkWhetherSalaryIsSorted(obj.sortRecords(6),"dsc");
		  
		  obj.search().sendKeys("Tokyo");
		  Assert.assertEquals(obj.tableRows().size(), 4);
		  obj.search().clear();
		  
		  obj.search().sendKeys("Hi Guys");
		  Assert.assertEquals(obj.tableRows().get(0).getText(), "No matching records found");
		  	 
		  System.out.println("In Table -> Table Sort And Search Testing is Completed !!\n");
		  Reporter.log("\nIn Table -> Table Sort And Search Testing is Completed !!\n");
	  }
	
	  @AfterTest
	  public void afterTest() {
		  System.out.println("\n------------------Project2 Completed------------------");
//		  driver.close();
//		  driver = null;
	  }

}
