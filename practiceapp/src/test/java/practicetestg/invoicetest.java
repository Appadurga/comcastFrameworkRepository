package practicetestg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crmcast.crm.baseclass.Baseclass;

public class invoicetest extends Baseclass {
@Test
public void createinvoicetest() {
	System.out.println("created");
	String acttitle=driver.getTitle();
	Assert.assertEquals(acttitle, "login");
	
	
}
@Test(retryAnalyzer = com.comcast.crm.listenerutility.Retrylistenerimpl.class)
public void createinvoicewithcontact(){
	
	System.out.println("created with contact");
	//String acttitle=driver.getTitle();
	//Assert.assertEquals(acttitle, "login");
}
}
