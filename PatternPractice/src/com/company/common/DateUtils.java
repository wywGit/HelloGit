package com.company.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
	
	/**
	 * 获取本月最后一天
	 */
	public static void getLastDayOfMonth(){
		Calendar c = Calendar.getInstance();
		int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int min = c.getActualMinimum(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DATE, max);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(c.getTime()));
		c.set(Calendar.DATE, min);
		System.out.println(sdf.format(c.getTime()));
		
	}
	
	public static void getNextWeekDay(){
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		c.add(Calendar.DATE, 1*7);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(c.getTime()));
		c.add(Calendar.DATE, 1);
		System.out.println(sdf.format(c.getTime()));
		
	}
	
	public static void main(String[] args) {
//		getLastDayOfMonth();
//		getNextWeekDay();
//		String str = "";
//		String regex = "[F|f]+";
//		System.out.println(str.matches(regex));
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(str);
//		System.out.println(m.matches());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(Math.abs(-23));
	}
}
