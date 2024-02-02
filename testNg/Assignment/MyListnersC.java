package com.testNg.Assignment;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListnersC implements ITestListener{

      ExtentSparkReporter uiRep;
      ExtentReports infoRepo;
      ExtentTest updateRepo;
      
	public  void onTestStart(ITestResult result) {
		
		uiRep = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExoRepo/sec.html");
		uiRep.config().setReportName("MyUiTest");
		uiRep.config().setTheme(Theme.STANDARD);
		uiRep.config().setDocumentTitle("Learning");
		
		infoRepo = new ExtentReports();
		infoRepo.attachReporter(uiRep);
		
		infoRepo.setSystemInfo("Author", "Dhanu");
		
	  }
	 public  void onTestSuccess(ITestResult result) {
		 updateRepo = infoRepo.createTest(result.getName()) ;
		 updateRepo.log(Status.PASS, "Test is passed ");
		 
		  }
	 public  void onTestFailure(ITestResult result) {
		 updateRepo = infoRepo.createTest(result.getName());
		 updateRepo.log(Status.FAIL, "Test is failed bcz : " + result.getThrowable());
		 
		  }
	 public  void onTestSkipped(ITestResult result) {
		    
		 updateRepo= infoRepo.createTest(result.getName());
		 updateRepo.log(Status.SKIP, "Test is skipped bcz " + result.getThrowable());
		  }
	 
	 public void onFinish(ITestContext context) {
		 
		 infoRepo.flush();
	 }

}
