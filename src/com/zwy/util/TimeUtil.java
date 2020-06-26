package com.zwy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeUtil {
	private static String timeFormat = "yyyy-MM-dd";
	private static SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
	
	
	public static String getTimeStr(long time) {
		return sdf.format(time);
	}
	
	public static Long getTimeLong(String time) {
		Long timeL = 0L;
		try {
			timeL = sdf.parse(time).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeL;
	}
	
	public static void main(String[] args) {
		System.out.println(getTimeStr(1522598400000L));
		System.out.println(getTimeLong("2018-04-02"));
	}
}
