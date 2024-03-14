package basePack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Properties prop;

	public BaseClass() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop.load(file);
	}
	
	public WebDriver getDriver() {
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getTestLink() {
		return prop.getProperty("testUrl");
	}
	
	public void takeScreenShot(String name) throws IOException {
		System.out.println("Screen shot has been taken!!");
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("C:/Users/I7023/eclipse-workspace/capstoneProject/target/screenshots/"+timeStamp()+".png"));
	}
	
	public String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
