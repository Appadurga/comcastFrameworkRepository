package com.comcast.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	
	public Home(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Organizations")   
	private WebElement orgLink;              //object identification
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement Campaignslink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminmsg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutlink;

    public WebElement getOrgLink() {
		return orgLink;
	}



	public WebElement getContactlink() {
		return contactlink;
	}



	public WebElement getCampaignslink() {
		return Campaignslink;
	}



	public WebElement getMorelink() {
		return morelink;
	}



	public void navigateTocampaginpage() {
   Actions act=new Actions(driver);
   act.moveToElement(morelink).perform();
    	Campaignslink.click();
	}
	
	public void logout() {
		Actions actions=new Actions(driver);
		actions.moveToElement(adminmsg).perform();
		signoutlink.click();
		
		
	}
	
}
