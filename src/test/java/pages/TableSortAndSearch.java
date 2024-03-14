package pages;


import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TableSortAndSearch {
	WebDriver driver;
	
	public TableSortAndSearch(WebDriver driver) {
		this.driver = driver;
	}
	
	By showRecords = By.cssSelector("select[name = 'example_length']");
	By next = By.id("example_next");
	By prev = By.id("example_previous");
	
	By search = By.xpath("//*[@id=\"example_filter\"]/label/input");
	By name = By.xpath("//*[@id=\"example\"]/thead/tr/th[1]");
	By position = By.xpath("//*[@id=\"example\"]/thead/tr/th[2]");
	By office = By.xpath("//*[@id=\"example\"]/thead/tr/th[3]");
	By age = By.xpath("//*[@id=\"example\"]/thead/tr/th[4]");
	By date = By.xpath("//*[@id=\"example\"]/thead/tr/th[5]");
	By salary = By.xpath("//*[@id=\"example\"]/thead/tr/th[6]");
	
	By noof = By.xpath("//*[@id=\"example\"]/tbody/tr");
	By table = By.xpath("//table[@id = 'example']");
	By tableRows = By.xpath("//table[@id = 'example']/tbody/tr");
	
	
	public WebElement setNoOfRecords() {
		return driver.findElement(showRecords);
	}
	
	public WebElement next() {
		return driver.findElement(next);
	}
	
	public WebElement previous() {
		return driver.findElement(prev);
	}
	
	public WebElement search() {
		return driver.findElement(search);
	}
	
	public WebElement name() {
		return driver.findElement(name);
	}
	
	public WebElement position() {
		return driver.findElement(position);
	}
	
	public WebElement office() {
		return driver.findElement(office);
	}
	
	public WebElement age() {
		return driver.findElement(age);
	}
	
	public WebElement date() {
		return driver.findElement(date);
	}
	
	public WebElement salary() {
		return driver.findElement(salary);
	}
	
	public List<WebElement> records(){
		return driver.findElements(noof);
	}
	
	public WebElement table() {
		return driver.findElement(table);
	}
	
	public List<WebElement> tableRows() {
		return driver.findElements(tableRows);
	}
	
	public List<WebElement> sortRecords(int index){
		String sordid = "//*[@id=\"example\"]/tbody/tr/td[%d]";
		String sorted = String.format(sordid, index);
		return driver.findElements(By.xpath(sorted));
	}
	
//	public void checkWhetherDataSortedInAscOrNot(List<WebElement> array) {
//		
//		List<String> contantList = new ArrayList<>();
//		  for(WebElement element: array) {
//			  contantList.add(element.getText());
//		  }
//		  
//		  List<String> sortedList = new ArrayList<>(contantList);
//		  Collections.sort(sortedList);
//		  
//		  System.out.println("\nList: "+contantList);
//		  System.out.println("Sorted List: "+sortedList);
//		  Assert.assertEquals(contantList, sortedList);
//		  
//	}	
//	
	public void checkWhetherDataIsSorted(List<WebElement> array,String order) {
		
		List<String> contantList = new ArrayList<>();
		  for(WebElement element: array) {
			  contantList.add(element.getText());
		  }
		  
		  List<String> sortedList = new ArrayList<>(contantList);
		  if(order.equalsIgnoreCase("ASC")) {
			  Collections.sort(sortedList);
		  }else {
			  Collections.sort(sortedList, Collections.reverseOrder());
		  }
		  
		  System.out.println("\nList: "+contantList);
		  System.out.println("Sorted List: "+sortedList);
		  Assert.assertEquals(contantList, sortedList);
		  
	}
	
	public void checkWhetherDateIsSorted(List<WebElement> array,String order) {
		List<String> contantList = new ArrayList<>();
		  for(WebElement element: array) {
			  contantList.add(element.getText());
		  }
		  
		  List<String> sortedList = new ArrayList<>(contantList);
		  
		  if (order.equalsIgnoreCase("ASC")) {
			 Collections.sort(sortedList, new CustomDateComparator());
		  }else {
			  Collections.sort(sortedList, Collections.reverseOrder(new CustomDateComparator()));
		  }
		 
		  
		  
		  System.out.println("\nList: "+contantList);
		  System.out.println("Sorted List: "+sortedList);
		  Assert.assertEquals(contantList, sortedList);
	}
	
	static class CustomDateComparator implements Comparator<String> {
		@Override
	    public int compare(String date1, String date2) {
			try {
				date1 = date1.replaceAll("(?<=\\d)(st|nd|rd|th)", "");
	            date2 = date2.replaceAll("(?<=\\d)(st|nd|rd|th)", "");

	            SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yy");
	            Date d1 = sdf.parse(date1);
	            Date d2 = sdf.parse(date2);
	            return d1.compareTo(d2);
	        } catch (Exception e) {
	        	e.printStackTrace();
	            return 0;
	        }
		}
	}
	
	public void checkWhetherSalaryIsSorted(List<WebElement> array,String order) {
		List<String> contantList = new ArrayList<>();
		  for(WebElement element: array) {
			  contantList.add(element.getText());
		  }
		  
		  List<String> sortedList = new ArrayList<>(contantList);
		  
		  if (order.equalsIgnoreCase("ASC")) {
			  Collections.sort(sortedList, new CustomSalaryComparator());
		  }else {
			  Collections.sort(sortedList, Collections.reverseOrder(new CustomSalaryComparator()));
		  }
		  
		  System.out.println("\nList: "+contantList);
		  System.out.println("Sorted List: "+sortedList);
		  Assert.assertEquals(contantList, sortedList);
		
	}
	
	static class CustomSalaryComparator implements Comparator<String> {

        @Override
        public int compare(String salary1, String salary2) {
            try {
                // Extract numeric values from salary strings
                long value1 = extractSalaryValue(salary1);
                long value2 = extractSalaryValue(salary2);

                // Compare based on numeric values
                return Long.compare(value1, value2);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        // Helper method to extract numeric value from salary string
        private long extractSalaryValue(String salary) throws Exception {
            NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
            return format.parse(salary.replaceAll("[\\$,/y]", "")).longValue();
        }
    }
		
	
	
}
