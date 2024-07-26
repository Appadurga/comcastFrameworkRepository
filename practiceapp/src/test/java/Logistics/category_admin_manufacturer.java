package Logistics;

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import javax.lang.model.element.Element;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.webdriverutility;
import com.graphbuilder.curve.Point;

import genutility.integorgcontact;

public class category_admin_manufacturer {

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
		//manufacturer
		driver.findElement(By.name("txtUsername")).sendKeys(MANUFATURER_USERNAME);
		driver.findElement(By.name("txtPassword")).sendKeys(MANUFACTURER_PASSWORD);
		//login
	WebElement ele=driver.findElement(By.name("login_type"));
	ele.click();
	wlib.selectdropdownvisibletext(ele,"Manufacturer");
	
		driver.findElement(By.className("submit_button")).click();
		
		driver.findElement(By.linkText("Manage Category")).click();

			
			//wlib.waitforElementPresent(driver,ele4);
		//WebElement ele4=driver.findElement(By.xpath("//input[@value='+ Add Category']"));
		WebElement ele4=driver.findElement(By.xpath("//input[@value='+ Add Category']"));
	  int x=ele4.getLocation().getX();
	  int y=ele4.getLocation().getY();
	JavascriptExecutor tst=(JavascriptExecutor) driver;
		tst.executeScript("window.scrollBy("+x+","+y+")");
		ele4.click();
	
	
		/*	try {
				
				ele4.click();
			} catch (Exception e) {
				Actions act=new Actions(driver);
				act.sendKeys(Keys.PAGE_DOWN).perform();
				act.sendKeys(Keys.ENTER).perform();
				
			
			} 
			*/
			
		
			
			//JavascriptExecutor tst=(JavascriptExecutor) driver;
			//tst.executeScript("Arguments[0].scrollIntoView(true);",ele4);
			
		
		
			
		
		driver.findElement(By.id("categoryName")).sendKeys("fresh dairy products");
		
		driver.findElement(By.id("categoryDetails")).sendKeys("its maximum of one week of usage");
		
		driver.findElement(By.xpath("//input[@value='Add Category']")).click();
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//input[@value='Log out']")).click();

		//admin 
		
		driver.manage().window().maximize();
		
		wlib.waitforPageLoad(driver);
		
		driver.get(URL);
		
		driver.findElement(By.name("txtUsername")).sendKeys(ADMIN_USERNAME);
		driver.findElement(By.name("txtPassword")).sendKeys(ADMIN_PASSWORD);
		//login
	WebElement ele1=driver.findElement(By.name("login_type"));
	ele1.click();
	wlib.selectdropdownvisibletext(ele1,"Admin");
		driver.findElement(By.className("submit_button")).click();
		
		driver.findElement(By.linkText("Manage Category")).click();
		
		WebElement ele3=driver.findElement(By.xpath("//table[@class='table_displayData']//tr[last()]"));
		String txt=ele3.getText();
		if(txt.contains("dairy products"))
		{  
		System.out.println("test case is pass");
	}
		else {
			System.out.println("test case is fail");
		

}}

}
