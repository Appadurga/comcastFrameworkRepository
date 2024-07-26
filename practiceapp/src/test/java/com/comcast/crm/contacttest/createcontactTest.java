package com.comcast.crm.contacttest;

/**
 * test class for contact module
 * @author Durga
 * 
 * 
 */
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.CHM.objectrepository.Loginpage;
import com.comcast.crm.generic.webdriverutility.utilityclassobject;
import com.comcast.crm.listenerutility.ListeImpclass;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.contactpage;
import com.comcast.crm.objectrepositoryutility.createnewcontactname;

import com.crmcast.crm.baseclass.Baseclass;
@Listeners(com.comcast.crm.listenerutility.ListeImpclass.class)
public class createcontactTest extends Baseclass {
	//String lastname=null;
	@Test
	public void createcontactdeatils() throws Throwable, Throwable {

		utilityclassobject.getTest().log(Status.INFO, "read data from excel");
		/* read the data from excelutitlity */
		String lastname = elib.getDataFromExcel("contact", 1, 3) + jlib.getRandomNumber();
		/* click on the contactlink */
		utilityclassobject.getTest().log(Status.INFO, "navigate to contact page");
		Home home = new Home(driver);
		home.getContactlink().click();
		/* click on plus symbol */
		contactpage contactpagesymbol = new contactpage(driver);
		contactpagesymbol.createcontact();

		/* createlastname */
		utilityclassobject.getTest().log(Status.INFO, "craeting new lastname");
		createnewcontactname createcontact = new createnewcontactname(driver);
		createcontact.createlastname(lastname);
		createcontact.getSavebtn().click();
		/* hardassert */
		utilityclassobject.getTest().log(Status.PASS, "both header and names are same");
		String actheader = createcontact.getHeaderEdt().getText();
		// boolean status=actheader.contains("muthu");
		boolean status = actheader.contains(lastname);
		Assert.assertEquals(status, true);
		/* softassert */
		utilityclassobject.getTest().log(Status.PASS, "both created and page names are same");
		String actlastname = createcontact.getLastname().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actlastname, true);
	}

	@Test
	public void createcontactdate() throws Exception {
		/* read the data from excelutitlity */
		utilityclassobject.getTest().log(Status.INFO, "read data from excel");
		String lastname = elib.getDataFromExcel("contact", 1, 3) + jlib.getRandomNumber();

		/*click on the contactlink*/
		utilityclassobject.getTest().log(Status.INFO, "navigate to contact page");
		Home home = new Home(driver);
		home.getContactlink().click();

		/*click on plus symbol*/

		contactpage contactpagesymbol = new contactpage(driver);
		contactpagesymbol.createcontact();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		/* createlastname*/
		utilityclassobject.getTest().log(Status.INFO, "craeting new lastname");
		createnewcontactname createcontact = new createnewcontactname(driver);

		createcontact.createlastname(lastname);

		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		utilityclassobject.getTest().log(Status.INFO, "craeting new starting and end date");
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
		createcontact.getSavebtn().click();

		/* verify hard assert*/
		utilityclassobject.getTest().log(Status.PASS, "both header and names are same");
		String actheader = createcontact.getHeaderEdt().getText();
		// boolean status = actheader.contains("durga");
		boolean status = actheader.contains(lastname);
		Assert.assertEquals(status, true);
		/* softassert*/
		utilityclassobject.getTest().log(Status.PASS, "both created and page names are same");
		String actlastname = createcontact.getLastname().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actlastname, true);

	}

}
