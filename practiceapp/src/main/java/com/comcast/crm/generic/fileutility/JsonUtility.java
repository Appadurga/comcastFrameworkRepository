package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class JsonUtility {
	
public  String getDatafromJsonFile(String key) throws Throwable, ParseException
{
	FileReader fileR=new FileReader("./configAppData/commondata.properties");
	JSONParser parse=new JSONParser();
	Object obj=parse.parse(fileR);
	JSONObject map=(JSONObject)obj;
	String data=(String)map.get(key);
	return data;

	
	
}
}
