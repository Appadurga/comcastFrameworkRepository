package genutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crmcast.crm.baseclass.Baseclass;

public class integorgcontact extends Baseclass {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\hostproject\\commondata.properties");
		Properties pob=new Properties();
		pob.load(fis);
	         String BROWSER=pob.getProperty("browser");
	         String URL=pob.getProperty("url");
	         String USERNAME=pob.getProperty("username");
	         String PASSWORD=pob.getProperty("password");
		 Random random=	new Random();
		 int randomint=random.nextInt(1000);
		 
	    FileInputStream fis1=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\hostproject\\tsetscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("org");
		Row rw=sh.getRow(1);
		String orgName=rw.getCell(2).toString()+randomint;
		String lastname=rw.getCell(3).getStringCellValue();
		wb.close();
		
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
		
		//create orgnization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(3000);
		
		
		
		
		//create contact
        driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
		
		
		Set<String> set1=driver.getWindowHandles();
		Iterator<String> it=set1.iterator();
		while(it.hasNext())
		{
			String windowid=it.next();
			driver.switchTo().window(windowid);
			Thread.sleep(2000);
			
			String actUrl=driver.getCurrentUrl();
			
			Thread.sleep(2000);
			if(actUrl.contains("module=Accounts")) {
				break;
			}
		}
		
		Thread.sleep(3000);
		
		 //new window and create dynamic xpath
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		Set<String> set2=driver.getWindowHandles();
		Iterator<String> it1=set2.iterator();
		while(it1.hasNext())
		{
			String windowId=it1.next();
			driver.switchTo().window(windowId);
			
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains("module=Contacts&action")) {
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		String lastnametxtboxString=driver.findElement(By.id("mouseArea_Last Name")).getText();
		
		if (lastnametxtboxString.trim().equals(lastname)) {
			System.out.println(lastname+" is created=pass");		
		}
		else {
			System.out.println(lastname+" is not created=fail");
		}
      
		
		
	}

}
