package com.crmcast.crm.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.CHM.objectrepository.Loginpage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.utilityclassobject;
import com.comcast.crm.generic.webdriverutility.webdriverutility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;

public class Baseclass  {
   public WebDriver driver=null;
	public DataBaseUtility dbLiB= new DataBaseUtility();
	public  FileUtility fli=new FileUtility();
	public  ExcelUtility eLib=new ExcelUtility();
	public  javautility jlib=new javautility();
	public ExcelUtility elib=new ExcelUtility();
	public static WebDriver edriver=null;
	
	@BeforeSuite 
	public void configBS()
	{
		dbLiB.getDataConnection();
		
		
	}
	@BeforeClass 
	public void configBC() throws Throwable
	{
		String BROWSER=fli.getDataFromPropertiesFile("browser");

		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		edriver=driver;
	   utilityclassobject.setDriver(driver);
		}
		
	@BeforeMethod
	public void configBM() throws Throwable 
	{
		
		/* step1:login to application 
		 * scenario:login()==>navigate to contact */
		String URL=fli.getDataFromPropertiesFile("url");
        String USERNAME=fli.getDataFromPropertiesFile("username");
        String PASSWORD=fli.getDataFromPropertiesFile("password");
		Login lp=new Login(driver);
		lp.Logintoapp(URL, USERNAME, PASSWORD);
				
	}
	
	@AfterMethod
	public void configAM() throws Throwable
	{
		Thread.sleep(3000);
		Home hp=new Home(driver);
		hp.logout();
	}
	@AfterClass
	public void configAC()	
	{
		
		driver.quit();
	}
	@AfterSuite
	public void configAS()	
	{
		dbLiB.closeDbconnection();
	    
	}
}


