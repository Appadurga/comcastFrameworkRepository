package practicetestg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;


public class simpletestforscreenshot {
@Test
public void amazontest() throws Throwable
{

WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in/");


	EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
	
	File srcFile =eDriver.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
	
	
	
}
}