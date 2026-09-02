package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.BaseClass2;
import genericUtility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public  ExtentReports report;
	public static ExtentTest test ;//for using this "test" variable in different class we convert into [public static]

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", " ");
		
		// For SampleReport
		 spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information &    Create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==== ====>" + result.getMethod().getMethodName() + "<====START====");
		 test = report.createTest(result.getMethod().getMethodName());//i want to execute this for 1000 test cases for that instead of writing particular class name we need to provide this method
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==> STARTED< =====");
		 
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("==== ====>" + result.getMethod().getMethodName() + "<====END====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"==> COMPLETED < =====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass2.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", " ");
		
		test.addScreenCaptureFromBase64String(filepath, testName+ "_ " + time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED < =====");
		
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		String time = new Date().toString().replace(" ", "_").replace(":", " ");
//		// store screenshot in local storage
//		try {
//			FileHandler.copy(src, new File("./Screenshot/" + testName + "+" + time + ".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		
	}
	public void onTestFailedButWithSuccessPercentage(ITestResult result) {
		
		
	}
	public void onStart(ITestContext context) {

	}
	
	public void onFinish(ITestContext context) {

	}
}
