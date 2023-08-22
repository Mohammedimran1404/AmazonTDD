package com.global;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/* This class contains the methods which is used to read data from propertyfile
 *@Author Mohammed Imran */
public class PropertyFile {
	Constants constantutility = new Constants();
	FileInputStream fis;
	Properties pro;
	/* This methods will read specific key value form the propertyfile */
	public PropertyFile() {
		File f=new File(constantutility.getPropertyFilePath());
		try {
			fis= new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationUrl() {
		String url=pro.getProperty("Url");
		return url;
	}
	public String getApplicationUserName() {
		String username=pro.getProperty("Username");
		return username;
	}
	public String getApplicationPassword() {
		String password=pro.getProperty("Password");
		return password;
	}
	public String getApplicationBrowser() {
		String browser=pro.getProperty("Browser");
		return browser;
	}
}
