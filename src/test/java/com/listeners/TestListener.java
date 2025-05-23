package com.listeners;



import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;


import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;



public class TestListener implements ITestListener
{
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public void onTestStart(ITestResult result) 
	{
	    logger.info(result.getMethod().getMethodName());
	    logger.info(result.getMethod().getDescription());
	    logger.info(result.getMethod().getGroups());
	    
	    ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
	    
	   // extentTest = extentReports.createTest(result.getMethod().getMethodName());
	    
	 }

	  
	  public void onTestSuccess(ITestResult result) 
	  {
		  logger.info(result.getMethod().getMethodName()+" PASSED");
		  
		 // extentTest.log(Status.PASS,result.getMethod().getMethodName()+" PASSED");
		  
		  ExtentReportUtility.getExtentTest().log(Status.PASS,result.getMethod().getMethodName()+" PASSED");
	  }

	  public void onTestFailure(ITestResult result) 
	  {
		  logger.error(result.getMethod().getMethodName()+" FAILED");
		  logger.error(result.getThrowable().getMessage());
		  
		 // extentTest.log(Status.FAIL,result.getMethod().getMethodName()+" FAILED");
		  
		  ExtentReportUtility.getExtentTest().log(Status.FAIL,result.getMethod().getMethodName()+" FAILED");
		  
		  ExtentReportUtility.getExtentTest().log(Status.FAIL,result.getThrowable().getMessage()+" FAILED");
		  
		  Object testclass = result.getInstance();
		  
		  BrowserUtility browserUtility = ((TestBase)testclass).getInstance();
		  
		  logger.info("Capturing screenshot for the failed tests");
		  
		  String screenshotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		  
		  logger.info("Attaching screenshot to HTML file");
		  
		  ExtentReportUtility.getExtentTest().addScreenCaptureFromPath(screenshotPath);
		  
	  }

	  
	  
	  public void onTestSkipped(ITestResult result) 
	  {
		  logger.warn(result.getMethod().getMethodName()+" SKIPPED");
		  
		 // extentTest.log(Status.SKIP,result.getMethod().getMethodName()+" SKIPPED");
		  
		  ExtentReportUtility.getExtentTest().log(Status.SKIP,result.getMethod().getMethodName()+" SKIPPED");
	  }
	  
	  
	  public void onStart(ITestContext context) 
	  {
		  logger.info("Test Suite Started!!"); 
		  
		  System.out.println("==> onStart called");
		  
		  ExtentReportUtility.setupSparkReporter("report");
		  
		 //extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//report.html");
		 //extentReports = new ExtentReports();
		 //extentReports.attachReporter(extentSparkReporter);
		  
	  }
	  
	  public void onFinish(ITestContext context) 
	  {
		  logger.info("Test Suite Completed!!");
		  
		  ExtentReportUtility.flushReport();
	  }

    
}
