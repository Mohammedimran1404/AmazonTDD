package com.global;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
 *This class contains all the methods which is releated to the Logs
 *@Author Mohammed Imran */
public class CreateLog {
	Logger logger = LogManager.getLogger(CreateLog.class);
	/* This method is used to send as a info message
	 * @Param message */
   public void info(String message) {
	   logger.info(message);
   }
   /* This method is used to send as a pass message
	 * @Param message */
   public void pass(String message) {
	   logger.info(message);
   }
   /* This method is used to send as a fail message
	 *@Param message */
   public void fail(String message) {
	   logger.error(message);
   }
   /* This method is used to send as a error message
  	 *@Param message */
   public void error(String message) {
	   logger.error(message);
   }
}
