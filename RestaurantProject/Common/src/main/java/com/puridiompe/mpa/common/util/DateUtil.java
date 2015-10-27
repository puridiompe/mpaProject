package com.puridiompe.mpa.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtil {

	public static Date getCurrentDate(){
		
		Calendar calendar = new GregorianCalendar();
		calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"));
		
		return calendar.getTime();
	
	}
	
}
