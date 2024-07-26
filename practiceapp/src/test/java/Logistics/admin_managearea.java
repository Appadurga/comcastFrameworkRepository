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

import com.comcast.CHM.objectrepository.Loginpage;
import com.comcast.CHM.objectrepository.admin_manage_area;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class admin_managearea {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
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
	    
		//manage area
		admin_manage_area adminarea=new admin_manage_area(driver);
		adminarea.getManagearealink().click();
		
		//driver.findElement(By.xpath("//img[@alt='edit']")).click();
		adminarea.editcategory();
		
		adminarea.getUpdateareabtn().click();
		
		
	}

}
