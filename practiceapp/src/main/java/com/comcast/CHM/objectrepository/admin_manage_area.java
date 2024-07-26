package com.comcast.CHM.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class admin_manage_area {
WebDriver driver;
	
	public admin_manage_area(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Manage Area")
	private WebElement managearealink;
	
	@FindBy(xpath = "//input[@value='Update Area']")
	private WebElement updateareabtn;

	public WebElement getUpdateareabtn() {
		return updateareabtn;
	}
	public WebElement getManagearealink() {
		return managearealink;
	}
	public void editcategory() {
		
		driver.findElement(By.xpath("(//img[@alt='edit'])[3]")).click();
		
	}
	
	

}
