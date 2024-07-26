package com.comcast.crm.objectrepositoryutility;

/**
 * 
 * @author Durga
 * 
 * contains Loginpage elements and business libraries like login
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.webdriverutility;



public class Login extends webdriverutility {
	
	WebDriver driver;
	public Login(WebDriver driver) {
		
		this.driver=driver;
		
	PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private  WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * login to application based on user name password and url aruguments
	 * @param url
	 * @param username
	 * @param password
	 */
	
    public void Logintoapp(String url, String username,String password) {
    	waitforPageLoad(driver);
    	driver.get(url);
    	driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
    
	
}
