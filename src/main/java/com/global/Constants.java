package com.global;

/*
 *This class contains all the paths which is releated to the framework
 *@Author Mohammed Imran 
 * */
public class Constants {
	private String propertyFilePath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
	private String excellFilePath=System.getProperty("user.dir")+"/src/test/resources/Amazon.xlsx";
	
	/* This method is used to store propertyfilepath */
	 public String getPropertyFilePath() {
	  return propertyFilePath;
   }
	 /* This method is used to store excellFilePath */
	 public String getExcellFilePath() {
		 return excellFilePath;
	 }
}
