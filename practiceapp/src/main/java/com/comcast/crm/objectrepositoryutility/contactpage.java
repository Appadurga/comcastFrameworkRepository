package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactpage {
WebDriver driver;
	
	public contactpage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//img[@title='Create Contact...']" )
	private WebElement createcontactlink;

	public WebElement getCreateneworg() {
		return createcontactlink;
		
	
	}
public void createcontact() {
	createcontactlink.click();
}	

}
