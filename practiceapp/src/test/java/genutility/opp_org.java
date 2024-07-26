package genutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class opp_org {

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
		Row rw=sh.getRow(10);
		String orgName=rw.getCell(2).toString()+randomint;
		String lastname=rw.getCell(5).getStringCellValue();
		String campname=rw.getCell(3).toString()+randomint;
		String product=rw.getCell(4).getStringCellValue();
		String oppurni=rw.getCell(6).getStringCellValue();
		String type=rw.getCell(7).getStringCellValue();
		
		wb.close();
		
		//polymor or change the browser details
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
		
		//create Campaign
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campname);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//create product
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(product);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//create org with dropdown
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		//create dropdown
		WebElement ele=driver.findElement(By.name("accounttype"));
		Select sel=new Select(ele);
		sel.selectByVisibleText(type);
	
	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		//create contact
         driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//create oppurnities
               driver.findElement(By.linkText("Opportunities")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(oppurni);
		Thread.sleep(2000);
		
        driver.findElement(By.xpath("//input[@name='campaignname']/following-sibling::img")).click();
		
		//switch to child window of compaigns
        Set<String> set1=driver.getWindowHandles();
		Iterator<String> it=set1.iterator();
		while(it.hasNext())
		{
			String windowid=it.next();
			driver.switchTo().window(windowid);
			Thread.sleep(2000);
			
			String actUrl=driver.getCurrentUrl();
			
			Thread.sleep(2000);
			if(actUrl.contains("module=Campaigns")) {
				break;
			}
		}
		Thread.sleep(3000);
		
		 //new window and create dynamic xpath
		driver.findElement(By.name("search_text")).sendKeys(campname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+campname+"']")).click();
		Thread.sleep(2000);
		Set<String> set2=driver.getWindowHandles();
		Iterator<String> it1=set2.iterator();
		while(it1.hasNext())
		{
			String windowId=it1.next();
			driver.switchTo().window(windowId);
			
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains("module=Potentials")) {
				break;
			}
		}
		//childwindow of organization
		
     driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img")).click();
		
		//switch to child window
		
		
		Set<String> set3=driver.getWindowHandles();
		Iterator<String> it3=set3.iterator();
		while(it3.hasNext())
		{
			String windowid=it3.next();
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
		
		Set<String> set4=driver.getWindowHandles();
		Iterator<String> it4=set4.iterator();
		while(it4.hasNext())
		{
			String windowId=it4.next();
			driver.switchTo().window(windowId);
			
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains("module=Potentials")) {
				break;
			}
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.close();
		
		
		
	}
	

}
