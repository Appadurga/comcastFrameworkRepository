package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class javautility {
 public int getRandomNumber()
 {
	 Random random=new Random();
	 int randomnumber=random.nextInt(5000);
	 return randomnumber;
 }
  public String getsystemdateyymmdd() {
	  Date dateobj=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	  String data=sdf.format(dateobj);
	  return data;
	
}
  public String getrequireddateyymmdd(int days) {
	  
	  
	  SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	  
	  Calendar cal=sim.getCalendar();
	  cal.add(Calendar.DAY_OF_MONTH, days);
	  String reqdate=sim.format(cal.getTime());
	  return reqdate;
}
}