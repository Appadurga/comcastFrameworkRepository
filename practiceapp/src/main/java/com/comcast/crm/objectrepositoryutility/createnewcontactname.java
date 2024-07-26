package com.comcast.crm.objectrepositoryutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class createnewcontactname {

WebDriver driver;
	
	public createnewcontactname(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
    
	@FindBy(className = "dvHeaderText")
	private WebElement headerEdt;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement plusiconbtn;
	
	@FindBy(name="support_start_date")
	private WebElement startdatecalender;
	
	@FindBy(name="support_end_date")
	private WebElement enddatecalender;
	
	
	public WebElement getStartdatecalender() {
		return startdatecalender;
	}

	public WebElement getEnddatecalender() {
		return enddatecalender;
	}

	public WebElement getHeaderEdt() {
		return headerEdt;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getOrgnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
		
		
	}


public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getPlusiconbtn() {
		return plusiconbtn;
	}

public void createlastname(String lastname)
{
	lastnameEdt.sendKeys(lastname);
	
	//savebtn.click();
}


	
}
