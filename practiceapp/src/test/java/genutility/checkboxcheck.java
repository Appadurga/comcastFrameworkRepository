package genutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;

public class checkboxcheck {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileUtility fLib=new  FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		//get the value based on key
	         String BROWSER=fLib.getDataFromPropertiesFile("browser");
	         String URL=fLib.getDataFromPropertiesFile("url");
	         String USERNAME=fLib.getDataFromPropertiesFile("username");
	         String PASSWORD=fLib.getDataFromPropertiesFile("password");
	    //generate random number
		 Random random=	new Random();
		 int randomint=random.nextInt(1000);
		   
		 
		 
		 //read the data from excel file
	    String lastname=eLib.getDataFromExcel("contact", 1, 2) + randomint;
		//polymorphysium or change the browser details
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
			
		}
		//login to application
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.name("selected_id")).click();
		driver.findElement(By.linkText("del")).click();
		//td[text()='Action']/child::tr//input[@value='30']
		
		
	}}