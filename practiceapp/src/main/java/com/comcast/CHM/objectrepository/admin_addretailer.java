package com.comcast.CHM.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class admin_addretailer {

WebDriver driver;
	
	public admin_addretailer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Add Retailers")
	private WebElement addretailerpage;
	
	@FindBy(id="retailer:username")
	private WebElement retailername;
	
	@FindBy(id="retailer:password")
	private WebElement retailerpwd;
	
	@FindBy(id = "retailer:phone")
	private WebElement retailerphone;
	
	@FindBy(id ="retailer:address" )
	private WebElement retaileraddress;
		
	@FindBy(id = "retailer:email")
	private WebElement retaileremailid;
	
	@FindBy(id="retailer:areaCode")
	private WebElement retailerareacode;
	
	@FindBy(xpath ="//input[@value='Add Retailer']")
	private WebElement addretailerbtn;
	
	
	
	
	public WebElement getRetailerphone() {
		return retailerphone;
	}

	public WebElement getAddretailerpage() {
		return addretailerpage;
		
	}

	public WebElement getRetailername() {
		return retailername;
	}


	public WebElement getRetailerpwd() {
		return retailerpwd;
	}


	public WebElement getRetaileraddress() {
		return retaileraddress;
	}


	public WebElement getRetaileremailid() {
		return retaileremailid;
	}


	public WebElement getRetailerareacode() {
		return retailerareacode;
	}


	public WebElement getAddretailerbtn() {
		return addretailerbtn;
	}


	public void retailercommondata() {
		
	
		getRetailerareacode().click();
		Select select=new Select(retailerareacode);
		select.selectByVisibleText("NRANIP (New Ranip)");
	}
	
	public void addretailerbtn() {
		getAddretailerbtn().click();
	}
	
}
