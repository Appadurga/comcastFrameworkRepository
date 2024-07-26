package com.comcast.crm.contacttest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.contactpage;
import com.comcast.crm.objectrepositoryutility.createnewcontactname;
import com.comcast.crm.objectrepositoryutility.createneworgname;
import com.comcast.crm.objectrepositoryutility.organizationspage;
import com.crmcast.crm.baseclass.Baseclass;

public class switchpage extends Baseclass{
@Test
public void pagechange() throws Exception, Throwable
{
	String orgname = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();

	Home home = new Home(driver);

	home.getOrgLink().click();

	organizationspage cnp = new organizationspage(driver);
	cnp.creatorg();

	createneworgname cnop = new createneworgname(driver);
	cnop.createorg(orgname);
	if(orgname.trim().contains(orgname)) {
    System.out.println(orgname + "name is verified==pass");} else {
    System.out.println(orgname + "name is not veriffed==fail"); }
	
	String lastname = elib.getDataFromExcel("contact", 1, 3) + jlib.getRandomNumber();
	// click on the contactlink
	home.getContactlink().click();
	// click on plus symbol
	
	
	contactpage contactpagesymbol = new contactpage(driver);
	contactpagesymbol.createcontact();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	// createlastname
	createnewcontactname createcontact = new createnewcontactname(driver);
	
	createcontact.createlastname(lastname);

	// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	
	Date dateobj = new Date();
	SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
	String actdate = simp.format(dateobj);

	Calendar cal = simp.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, 30);
	String requireddate = simp.format(cal.getTime());
	
	 createcontact.getStartdatecalender().clear();
	 createcontact.getStartdatecalender().sendKeys(actdate);
	 createcontact.getEnddatecalender().clear();
	 createcontact.getEnddatecalender().sendKeys(requireddate);
	 
	 createcontact.getPlusiconbtn().click();
		
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
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		
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
	createcontact.getSavebtn().click();

	// verify
	String actheader = createcontact.getHeaderEdt().getText();
	//boolean status = actheader.contains("durga");
	boolean status = actheader.contains(lastname);
	Assert.assertEquals(status, true);
	// softassert
	String actlastname = createcontact.getLastname().getText();
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertEquals(actlastname, true);

	
		}
}
}