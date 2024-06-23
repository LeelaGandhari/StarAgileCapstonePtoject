package listeners;
	
	import java.text.SimpleDateFormat;

	import java.util.Date;

	import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;

	import Scenario_1.HRMTest;
    public class ExtentITestNGListeners implements ITestListener {
		
		ExtentReports extent=ExtentManager.getInstance();
		ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
		public void onTestStart(ITestResult result) 
		{
			ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName());
			parentTest.set(extentTest);
		}		
		public void onTestSuccess(ITestResult result) {
			parentTest.get().pass("Test Passed");
		  }
		
		private String timestamp()
		{
			return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		}
		public void onTestFailure(ITestResult result) 
		{
			parentTest.get().fail("Test Failed "+result.getThrowable().getMessage());
   
		  }
		    public void onTestSkipped(ITestResult result) {
			parentTest.get().skip("Test Skipped "+result.getThrowable().getMessage());
		   	  }
			public  void onFinish(ITestContext context) {
			extent.flush();
		     }
	}



