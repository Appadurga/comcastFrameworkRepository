package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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
import com.comcast.crm.generic.webdriverutility.utilityclassobject;
import com.crmcast.crm.baseclass.Baseclass;

public class ListeImpclass implements ITestListener,ISuiteListener {
	public ExtentSparkReporter spark;
	public  ExtentReports reports ;
	public ExtentTest test;
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		//spart report config
		spark.config().setDocumentTitle("CRM Testsuite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		//add env information and create test
		
		reports=new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("os", "window-10");
		//ExtentTest test=reports.createTest("create contact test");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backup");
		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==="+result.getMethod().getMethodName()+"=test started=");
		
		test = reports.createTest(result.getMethod().getMethodName());
	
		utilityclassobject.setTest(test);
		
		test.log(Status.INFO, result.getMethod().getMethodName()+"==>Started<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	         System.out.println("==="+result.getMethod().getMethodName()+"=test finished=");
	         test.log(Status.PASS, result.getMethod().getMethodName()+"==>Completed<==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname=result.getMethod().getMethodName();
		
		TakesScreenshot eDriver=(TakesScreenshot)Baseclass.edriver;
		String filepath=eDriver.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		test.addScreenCaptureFromBase64String(filepath, testname+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==>Failed<==");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, result.getMethod().getMethodName()+"==>skipped<==");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
