package WebTesting;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Pass:"+result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed:"+result.getName());
		
	}

}
