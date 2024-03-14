package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;

    private static String reportName;

    static {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
        reportName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\reports\\" + reportName);// specify location of the report
        sparkReporter.config().setDocumentTitle("SeleniumAutomationProject"); // Title of report
        sparkReporter.config().setReportName("CapStone Report"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Capstone Selenium Project");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Akula Kumar Raja");
    }

    @Override
    public void onStart(ITestContext testContext) {
        // Nothing specific needs to be done at the start of the test context
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getMethod().getMethodName());
        test.log(Status.PASS, "Test Passed");
        logClassInformation(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.createNode(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        logClassInformation(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.createNode(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
        logClassInformation(result);
    }

    private void logClassInformation(ITestResult result) {
        String className = result.getTestClass().getName();
        test.log(Status.INFO, "Test method belongs to class: " + className);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}

