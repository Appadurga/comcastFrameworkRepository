package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createneworgname {
WebDriver driver;
	
	public createneworgname(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(name="accountname")
	private WebElement orgnameEdt;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
    
	@FindBy(name="industry")
	private WebElement industrydd;
	
	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
		
		
	}
public WebElement getIndustrydd() {
		return industrydd;
	}

public void createorg(String orgname) {
	orgnameEdt.sendKeys(orgname);
	savebtn.click();
}
public void createorg(String orgname,String industry) {
	
	orgnameEdt.sendKeys(orgname);
	Select sel=new Select(industrydd);
	sel.selectByVisibleText(industry);
	savebtn.click();
}

	


}
