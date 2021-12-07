package com.Swag_Labs.qa.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;


public class propConfig {
static Properties prop;
	
	
	public static String getpropertyKey(String key) throws Exception  {
	
	//location
	String path=System.getProperty("user.dir")+"/src/main/java/com/Swag_Labs/qa/config/config.properties";
	System.out.println(path);
	prop=new Properties();
	
	FileInputStream fis;
	try {
		fis = new FileInputStream(path);
		prop.load(fis);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String value=prop.get(key).toString();
	if(StringUtils.isEmpty(value)) {
		throw new Exception("Value is not specified for the Key "+key +" in properties file .");
	}
	return value;
}
}
