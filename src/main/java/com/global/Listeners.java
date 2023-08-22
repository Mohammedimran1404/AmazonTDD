package com.global;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends BaseTest implements ITestListener{

	
	ExtentSparkReporter sparkreporter;
	ExtentReports reports;
	ExtentTest test;
	String url=propertyfile.getApplicationUrl();

	@Override
	public void onTestStart(ITestResult result) {
	 String methodname = result.getMethod().getMethodName();
	 test = reports.createTest(methodname);
	 log.info(methodname + " Test case started");
	 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	 String methodname = result.getMethod().getMethodName();
	 test.log(Status.PASS, MarkupHelper.createLabel(methodname, ExtentColor.GREEN));
	 test.log(Status.INFO, methodname + " Passed");
	 log.pass(methodname + " Test case executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	 String methodname = result.getMethod().getMethodName();
	 test.log(Status.FAIL, MarkupHelper.createLabel(methodname, ExtentColor.RED));
	 log.fail(methodname + " Test case failed");
	 test.log(Status.INFO, methodname + " Failed");
	 test.log(Status.FAIL, result.getThrowable());
	}
		

	@Override
	public void onTestSkipped(ITestResult result) {
	 String methodname = result.getMethod().getMethodName();
	 test.log(Status.SKIP, MarkupHelper.createLabel(methodname, ExtentColor.ORANGE));
	 log.fail(methodname + " Test case failed");
	}

	@Override
	public void onStart(ITestContext context) {
	 String repname = "Test-Report-" + new DateTime().getSystemdate() + ".html";
	 log.info(repname + " Report generating started");

	 sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentsReports/" + repname);
	 sparkreporter.config().setDocumentTitle("Amazon reports");
	 sparkreporter.config().setReportName("Test Case ");
	 sparkreporter.config().setTheme(Theme.STANDARD);

	 reports = new ExtentReports();
	 reports.attachReporter(sparkreporter);
	 reports.setSystemInfo("Reporter name","Mohammed Imran");
	 reports.setSystemInfo("URl",url );
	 reports.setSystemInfo("OPERATING SYSTEM", System.getProperty("os.name"));
	 reports.setSystemInfo("Os Version", System.getProperty("os.version"));
	 reports.setSystemInfo("Java Version",System.getProperty("java.version"));	
	}

	@Override
	public void onFinish(ITestContext context) {
	 String browserName =browsername();
	 String browserVersion=browserversion();
	 reports.setSystemInfo("Browser", browserName);
	 reports.setSystemInfo("BrowserVersion",browserVersion );
	 reports.flush();
	 log.info("Report generated successfully");
	}

}
