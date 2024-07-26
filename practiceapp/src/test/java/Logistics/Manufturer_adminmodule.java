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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class Manufturer_adminmodule {

	public static void main(String[] args) throws Throwable {
		
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
			         String RETAILER_USERNAME=flib.getDataFromPropertiesFile("retailer_UN");
			         String RETAILER_PASSWORD=flib.getDataFromPropertiesFile("retailer_PWD");
			         String MANUFATURER_USERNAME=flib.getDataFromPropertiesFile("manufacturer_UN");
			         String MANUFACTURER_PASSWORD=flib.getDataFromPropertiesFile("manufacturer_PWD");
			         
			         
		//excel
			         
			         String Manufacturer=elib.getDataFromExcel("contact",1,1)+jlib.getRandomNumber();
			         String email=elib.getDataFromExcel("contact",1,1);
			 		String phone=elib.getDataFromExcel("contact",1,1);
			 		String username=elib.getDataFromExcel("contact",1,1);
			 		String password=elib.getDataFromExcel("contact",1,1);
		
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
		//manufacturer tab
		driver.findElement(By.linkText("Add Manufacturer")).click();
		driver.findElement(By.id("manufacturer:name")).sendKeys("kumumdevi");
		driver.findElement(By.id("manufacturer:email")).sendKeys("tha789@gmail.com");
		driver.findElement(By.id("manufacturer:phone")).sendKeys("8907654781");
		driver.findElement(By.id("manufacturer:username")).sendKeys("kumutha");
		driver.findElement(By.id("manufacturer:password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().alert().accept();
		//display manufacturer page
		
		driver.findElement(By.linkText("Manufacturers")).click();
		Thread.sleep(3000);
		
		WebElement ele1=driver.findElement(By.xpath("//table[@class='table_displayData']//tr[last()]"));
		//WebElement ele1=driver.findElement(By.xpath("//table/tbody/tr[107]/td[5]"));
		
		String txt =ele1.getText();
		
		System.out.println(txt);
		
		if(txt.contains("kumumdevi"))
		{System.out.println("test case is pass");
		
		}
		else {
			System.out.println("test case is fail");
		}
		
		
	}

}
