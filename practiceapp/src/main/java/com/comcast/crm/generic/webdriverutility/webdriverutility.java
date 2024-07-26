package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutility {
//implicitywait
public void waitforPageLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
//explicitywait
public void waitforElementPresent(WebDriver driver,WebElement element) {
	

	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
	
}
//switchwindowpartialurl
public void switchNewBrowserTab(WebDriver driver,String partialURL) {
	
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	while(it.hasNext())
	{
		String windowid=it.next();
		driver.switchTo().window(windowid);
		String actUrl=driver.getCurrentUrl();
		
		if(actUrl.contains(partialURL)) {
			break;
		}
	}
}
//switchwindowpartialtitle
public void switchToTabonTitle(WebDriver driver,String partialTitle) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String windowId=it.next();
			driver.switchTo().window(windowId);
			
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialTitle)) {
				break;
			}
		}
	}
//switchtoframe
public void switchtoFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}	
public void switchtoFrame(WebDriver driver,String nameId) {
	driver.switchTo().frame(nameId);
}
public void switchtoFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
//switchtoalert
public void SwitchtoAlertaccept(WebDriver driver) {
	driver.switchTo().alert().accept();
	
}
public void SwitchtoAlertdismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
//dropdown
public void selectdropdownindex(WebElement element,int index) {
	Select sel=new Select(element);
	sel.selectByIndex(index);
	
}
public void selectdropdownvisibletext(WebElement element,String txt) {
	Select sel=new Select(element);
	sel.selectByVisibleText(txt);
}
//mouseoveraction
public void mouseoveraction(WebDriver driver,WebElement element) {
	Actions actions=new Actions(driver);
	actions.moveToElement(element).perform();
}
public void doubleclick(WebDriver driver,WebElement element) {
	Actions actions=new Actions(driver);
	actions.doubleClick(element).perform();
}
//javascriptexecutor
public void javascript(WebDriver driver,String values) {
	JavascriptExecutor tst=(JavascriptExecutor) driver;
	tst.executeScript(values);
	
}
//contextclick
public void contextclick(WebDriver driver,WebElement element) {
	Actions actions=new Actions(driver);
	actions.contextClick(element).perform();

}
//draganddrop
public void draganddrop(WebDriver driver,WebElement src,WebElement crc){
	Actions actions=new Actions(driver);
	actions.dragAndDrop(src,crc).perform();

}
//clickandholdrelease
public void clickandhold(WebDriver driver,WebElement value){
	Actions actions=new Actions(driver);
	actions.clickAndHold(value).perform();
	actions.release(value).perform();
	
//scrollbyelement
}
	public void scrollbyelement(WebDriver driver,WebElement element){
		Actions actions=new Actions(driver);
		actions.scrollToElement(element).perform();

}


}















