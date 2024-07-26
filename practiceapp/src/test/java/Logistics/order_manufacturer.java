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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class order_manufacturer {

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
		driver.findElement(By.name("txtUsername")).sendKeys(MANUFATURER_USERNAME);
		driver.findElement(By.name("txtPassword")).sendKeys(MANUFACTURER_PASSWORD);
		//login
	WebElement ele=driver.findElement(By.name("login_type"));
	ele.click();
		Select sel=new Select(ele);
		 sel.selectByVisibleText("Manufacturer");
		driver.findElement(By.className("submit_button")).click();

		driver.findElement(By.linkText("Orders")).click();
		
		//WebElement ele1=driver.findElement(By.xpath("//table/tbody/tr[10]/td[2]"));
		//problem in execution in confirm
		 WebElement ele2=driver.findElement(By.xpath("//table/tbody/tr[12]/td[6]"));
		 ele2.click();
		//WebElement ele1=driver.findElement(By.xpath("//table/tbody/tr[10]/td[7]"));
		 //ele1.click();
		 driver.findElement(By.xpath("//input[@value='Confirm Order']")).click();
		// String txt=ele1.getText();
				//td[text()='+ Invoice']")).click();
		// System.out.println(txt);
		
	}

}
