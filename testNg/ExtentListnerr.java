package com.testNg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListnerr implements ITestListener{

	ExtentSparkReporter sparkRepo; //UI of the report : title, name, theme
	ExtentReports infoRepo; // common info abt repo : pc name, browsername, author name
	ExtentTest updateStats;//create test case entries in rpo and updte it
	
	
	public void onStart(ITestContext context) {
		
		sparkRepo = new ExtentSparkReporter(System.getProperty("user.dir") +"/ExoRepo/first.html" );
		sparkRepo.config().setDocumentTitle("My extent report");
		sparkRepo.config().setTheme(Theme.DARK);
		sparkRepo.config().setReportName("ReportUsingListner");
		
		infoRepo = new ExtentReports();
		infoRepo.attachReporter(sparkRepo);
		
		infoRepo.setSystemInfo("pc name : ", "Super");
		infoRepo.setSystemInfo("author", "dhanu");
		infoRepo.setSystemInfo("browser", "chrome");
		
	  }
	
	public void onTestSuccess(ITestResult result) {
		
		updateStats =infoRepo.createTest(result.getName());
		updateStats.log(Status.PASS, "Test is passed " + result.getTestName());
		
		  }
	 
	public void onTestFailure(ITestResult result) {
		
		updateStats = infoRepo.createTest(result.getName());
		updateStats.log(Status.FAIL, "Test is failed caused : " + result.getThrowable());
		  }
	public void onTestSkipped(ITestResult result) {
		
		updateStats = infoRepo.createTest(result.getName());
		updateStats.log(Status.SKIP, "Test is skipped " + result.getName());
		
		  }
	public void onFinish(ITestContext context) {
		
		infoRepo.flush();
	  }
}
