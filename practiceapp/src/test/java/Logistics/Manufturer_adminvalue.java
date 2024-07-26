package Logistics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class Manufturer_adminvalue {

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
		
		wlib.waitforPageLoad(driver);
		driver.get(URL);

	}

}
