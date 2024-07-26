package com.comcast.CHM.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.webdriverutility;


public class Loginpage {

WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="txtUsername")
	private WebElement usernameedt;
	
	@FindBy(name="txtPassword")
	private WebElement passwordedt;
	
	@FindBy(name="login_type")
	private WebElement logintype;
	
	@FindBy(className="submit_button")
	private WebElement loginbtn;

	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLogintype() {
		return logintype;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public void login()
	 {
		webdriverutility wlib=new webdriverutility();
		wlib.selectdropdownvisibletext(logintype, "Admin");
		
		getLoginbtn().click();
	}
	
	
}
