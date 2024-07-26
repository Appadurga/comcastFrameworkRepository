package genutility;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.util.Properties;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.contactpage;
import com.comcast.crm.objectrepositoryutility.createnewcontactname;
import com.crmcast.crm.baseclass.Baseclass;

public class datefix extends Baseclass {
	@Test
	public void createcontactdate() throws Exception {

		String lastname = elib.getDataFromExcel("contact", 1, 3) + jlib.getRandomNumber();
		// click on the contactlink
		Home home = new Home(driver);
		home.getContactlink().click();
		// click on plus symbol
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		contactpage contactpagesymbol = new contactpage(driver);
		contactpagesymbol.createcontact();
		// createlastname
		createnewcontactname createcontact = new createnewcontactname(driver);
		createcontact.createlastname(lastname);

		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Date dateobj = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		String actdateString = simp.format(dateobj);

		Calendar cal = simp.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String reqdate = simp.format(cal.getTime());

		createcontact.getStartdatecalender().clear();
		createcontact.getStartdatecalender().sendKeys(actdateString);
		createcontact.getEnddatecalender().clear();
		createcontact.getEnddatecalender().sendKeys(reqdate);

		// verify
		String actheader = createcontact.getHeaderEdt().getText();
		boolean status = actheader.contains(lastname);
		Assert.assertEquals(status, true);
		// softassert
		String actlastname = createcontact.getLastname().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actlastname, true);

	}

}
