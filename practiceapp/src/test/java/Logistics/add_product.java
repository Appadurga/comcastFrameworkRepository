package Logistics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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

import com.comcast.CHM.objectrepository.Loginpage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class add_product {

	public static void main(String[] args) throws Throwable, Throwable {
		// TODO Auto-generated method stub
 //utilityobject
		
		FileUtility flib=new FileUtility();
		webdriverutility wlib=new webdriverutility();
		
 
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
		
		//waitstatement
		wlib.waitforPageLoad(driver);
		
		driver.get(URL);
		
	    Loginpage loginpage=new Loginpage(driver);
	  
	    loginpage.getUsernameedt().sendKeys(ADMIN_USERNAME);

	    loginpage.getPasswordedt().sendKeys(ADMIN_PASSWORD);
	  
	    loginpage.login();
		 
		 
	
	     
		 
		
		
		driver.findElement(By.linkText("Add Products")).click();
	}
	
}
