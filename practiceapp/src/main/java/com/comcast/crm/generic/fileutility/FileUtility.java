package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertiesFile(String key) throws Throwable {
	
	FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");

	Properties pob=new Properties();
	
	pob.load(fis);
	
	String data=pob.getProperty(key);
	
	return data;
	
	
}
}
