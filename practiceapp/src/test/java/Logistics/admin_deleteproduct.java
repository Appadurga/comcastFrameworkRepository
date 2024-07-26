package Logistics;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class admin_deleteproduct {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		//utilityobject
		
				FileUtility flib=new FileUtility();
		 webdriverutility wlib=new webdriverutility();
		 javautility jlib=new javautility();
		 ExcelUtility elib=new ExcelUtility();
		 
		 //propertyfile
		 
		             String BROWSER=flib.getDataFromPropertiesFile("browser");      
			         String URL= flib.getDataFromPropertiesFile("url");
			         String ADMIN_USERNAME=flib.getDataFromPropertiesFile("admid_UN");
			         String ADMIN_PASSWORD=flib.getDataFromPropertiesFile("admin_PWD");
			         
			         
		WebDriver driver=null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		wlib.waitforPageLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("txtUsername")).sendKeys(ADMIN_USERNAME);
		driver.findElement(By.name("txtPassword")).sendKeys(ADMIN_PASSWORD);
		//login
	WebElement ele=driver.findElement(By.name("login_type"));
	ele.click();
		Select sel=new Select(ele);
		 sel.selectByVisibleText("Admin");
		driver.findElement(By.className("submit_button")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		try {
			
			WebElement del=driver.findElement(By.xpath("//input[@value='Delete']"));
			del.click();
			
		} catch (Exception e) {
			// TODO: handle exception
			Actions act=new Actions(driver);
			
			act.sendKeys(Keys.PAGE_DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
			
		}
		
	
		
	}
	
}
