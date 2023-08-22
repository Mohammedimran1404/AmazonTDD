package com.global;

import java.text.SimpleDateFormat;
import java.util.Date;
/* This class contains all the java specicfic methods
 * @Author Mohammed Imran */
public class DateTime {
	/* This method will generate the system date and time
	 * @Param message */
	public String getSystemdate() {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		return timeStamp;

	}
}
