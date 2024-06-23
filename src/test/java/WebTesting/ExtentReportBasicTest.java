package WebTesting;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportBasicTest {
  @Test
  public void testReport() {
	  
	  ExtentReports extent = new ExtentReports();
	  //path of report
	  //ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("use.dir") + "null//Reports//AutomationTest.html");
	 ExtentSparkReporter spark = new ExtentSparkReporter("D:\\Leela_Selenium_Demos\\StarAgileCapstoneProject\\Reports\\AutomationTest1.html");
	  
	  //setup
	  spark.config().setDocumentTitle("This is Extent Report for Automation Test");
	  spark.config().setReportName("Sprint 1 Test Case");
	  spark.config().setTheme(Theme.DARK);
	  
	  //attached Report
	  extent.attachReporter(spark);
	  
	  //create a test
	  ExtentTest test = extent.createTest("AutomationTestReport");
	  
	 //   log
	  test.log(Status.PASS, "Test passed!");
	  test.log(Status.FAIL,"Test Failed");
	  test.log(Status.SKIP,"Test Skipped");
	
	  // flush
	  extent.flush();

  }
}
