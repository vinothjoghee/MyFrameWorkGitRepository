package vjPractise.Testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import vjPractice.resources.ExtendReportNG;

public class Listerners extends BaseTest implements ITestListener{
	
    ExtentTest test;
    ExtentReports extent=ExtendReportNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();//Thread safe
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //unique thread id
		}
	@Override
    public void onTestSuccess(ITestResult result) {
    	extentTest.get().log(Status.PASS, "Test Passed");
    	
		
	}
	@Override
     public void onTestFailure(ITestResult result) {
    	 extentTest.get().fail(result.getThrowable());
    		
 		String filePath = null;
    	 try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
					
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
	
		try {
			filePath = getScreeshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	@Override
 
	public void onFinish(ITestContext result) {
		
		extent.flush();
	}
	
     
}
