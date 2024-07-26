package genutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.contactpage;
import com.comcast.crm.objectrepositoryutility.createnewcontactname;
import com.comcast.crm.objectrepositoryutility.organizationspage;
import com.comcast.crm.objectrepositoryutility.orgganizationinfoclass;
import com.crmcast.crm.baseclass.Baseclass;

public class createcontact extends Baseclass{
   @Test
   public void createcontactdeatils() throws Throwable, Throwable
   {
	   String lastname = elib.getDataFromExcel("contact", 1, 3) + jlib.getRandomNumber();
	//click on the contactlink   
	   Home home = new Home(driver);
	   home.getContactlink().click();
	   //click on plus symbol
	   contactpage contactpagesymbol=new contactpage(driver);
	   contactpagesymbol.createcontact();
	   //createlastname
	   createnewcontactname createcontact=new createnewcontactname(driver);
	  createcontact.createlastname(lastname);
	   
	   if(lastname.trim().contains("durga")) {
		    System.out.println(lastname + "name is verified==pass");} else {
		    System.out.println(lastname + "name is not veriffed==fail"); }
	    
	   
	   
	   
   }
}
