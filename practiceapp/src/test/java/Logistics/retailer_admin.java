package Logistics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.CHM.objectrepository.Loginpage;
import com.comcast.CHM.objectrepository.admin_addretailer;
import com.comcast.CHM.objectrepository.admin_retailerpage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

import net.bytebuddy.implementation.EqualsMethod;

public class retailer_admin {

	public static void main(String[] args) throws Throwable {
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
		
		 admin_addretailer adretailer=new admin_addretailer(driver);
		 adretailer.getAddretailerpage().click();
		 adretailer.getRetailername().sendKeys("muthu");
		adretailer.getRetailerpwd().sendKeys("12345");
		adretailer.retailercommondata();
		adretailer.getRetailerphone().sendKeys("9890709870");
		adretailer.getRetaileremailid().sendKeys("muthu@24");
		adretailer.getRetaileraddress().sendKeys("bengaluru-24");
		//submitbutton
		WebElement ele=driver.findElement(By.xpath("//input[@value='Add Retailer']"));
		  int x=ele.getLocation().getX();
		  int y=ele.getLocation().getY();
		JavascriptExecutor tst=(JavascriptExecutor) driver;
			tst.executeScript("window.scrollBy("+x+","+y+")");
			ele.click();
	
		wlib.SwitchtoAlertaccept(driver);
		
		//display retailer page
		Thread.sleep(4000);
		
		admin_retailerpage adretailpg=new admin_retailerpage(driver);
		adretailpg.getAddretailerpage().click();
		
		
		//driver.findElement(By.xpath("//table/tbody/tr[23]/td[1]")).click();
           Thread.sleep(3000);
		
		//WebElement ele2=driver.findElement(By.xpath("//table[@class='table_displayData']//tr[last()]"));
		//WebElement ele1=driver.findElement(By.xpath("//table/tbody/tr[107]/td[5]"));
           WebElement ele2=driver.findElement(By.xpath("//table/tbody/tr"));
           String txt =ele2.getText();
		
		
		
		if(txt.contains("9876546980"))
		{System.out.println("test case is pass");
		
		}
		else {
			System.out.println("test case is fail");
		}
  
	}

}
