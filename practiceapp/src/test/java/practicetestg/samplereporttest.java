package practicetestg;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class samplereporttest {
	public ExtentSparkReporter spark;
	public ExtentReports reports;

	@BeforeSuite
	public void configBS()

	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		// spart report config
		spark.config().setDocumentTitle("CRM Testsuite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		// add env information and create test

		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("os", "window-10");

	}

	@AfterSuite

	public void configAS() {

		reports.flush();
	}

	@Test

	public void createcontacttest() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		TakesScreenshot eDriver=(TakesScreenshot)driver;
		String filepath=eDriver.getScreenshotAs(OutputType.BASE64);
		ExtentTest test = reports.createTest("create contact test");

		test.log(Status.INFO, "login to app");

		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filepath, "error file");
		}
		}
@Test
public void createcontactinformation() {
	ExtentTest test = reports.createTest("create contact information");

	test.log(Status.INFO, "login to app");

	test.log(Status.INFO, "navigate to contact page");
	test.log(Status.INFO, "create contact");
	if ("Hello".equals("Hello")) {
		test.log(Status.PASS, "contact information is created");
	} else {
		test.log(Status.FAIL, "contact information is created");
	}
	}
}
