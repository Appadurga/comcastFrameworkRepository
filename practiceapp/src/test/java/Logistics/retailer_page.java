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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;

public class retailer_page {

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
		//manufacturer tabs
		driver.findElement(By.linkText("Add Retailers")).click();
		driver.findElement(By.id("retailer:address")).sendKeys("gan");
		driver.findElement(By.id("retailer:email")).sendKeys("gaaft@gmail.com");
		driver.findElement(By.id("retailer:phone")).sendKeys("7467654068");
		driver.findElement(By.id("retailer:username")).sendKeys("gananga");
		driver.findElement(By.id("retailer:password")).sendKeys("12375");
		WebElement ele1=driver.findElement(By.id("retailer:areaCode"));
				ele1.click();
		Select sel1=new Select(ele1);
		sel1.selectByVisibleText("SRKJ (Sarkhej)");
		
		//driver.findElement(By.xpath("//options[@value='1')")).click();
		
		
		
		driver.findElement(By.xpath("//input[@value='Add Retailer']")).click();
		
				
		driver.switchTo().alert().accept();
		//logout
		
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		
		
		//manufacturer login
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("submit_button"))));
		driver.findElement(By.name("txtUsername")).sendKeys(MANUFATURER_USERNAME);
		driver.findElement(By.name("txtPassword")).sendKeys(MANUFACTURER_PASSWORD);
		//login
		
	WebElement ele2=driver.findElement(By.name("login_type"));
	ele2.click();
		Select se2=new Select(ele2);
		
		se2.selectByValue("manufacturer");
		
		// se2.selectByVisibleText("Manufacturer");
		 //driver.findElement(By.xpath("//option[@value='manufacturer']")).click();
		 
		driver.findElement(By.className("submit_button")).click();
               
			
		driver.findElement(By.linkText("Retailers")).click();
		
		WebElement ele3=driver.findElement(By.xpath("//table/tbody/tr"));
		String txt =ele3.getText();
		
		
		
		if(txt.contains("gananga"))
		{System.out.println("test case is pass");
		
		}
		else {
			System.out.println("test case is fail");
		}

	}

		}



