package com.comcast.crm.orgtest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.javautility;
import com.comcast.crm.generic.webdriverutility.utilityclassobject;
import com.comcast.crm.generic.webdriverutility.webdriverutility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;
import com.comcast.crm.objectrepositoryutility.createneworgname;
import com.comcast.crm.objectrepositoryutility.organizationspage;
import com.comcast.crm.objectrepositoryutility.orgganizationinfoclass;
import com.crmcast.crm.baseclass.Baseclass;

public class createorgTest extends Baseclass {
	@Test
	public void createorg() throws Throwable {

		utilityclassobject.getTest().log(Status.INFO, "read data from excel");
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
		


	}
}
