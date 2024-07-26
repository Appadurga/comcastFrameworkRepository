package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orgganizationinfoclass {
WebDriver driver;
	
	public orgganizationinfoclass(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[class='dvHeaderText']")
	private WebElement orgheadElement;

	public WebElement getOrgheadElement() {
		return orgheadElement;
	}    
	
}
