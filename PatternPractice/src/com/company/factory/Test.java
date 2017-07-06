package com.company.factory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		
		Factory one = new FactoryOne();
		Factory two = new FactoryTwo();
		
		Product p1 = one.product();
		Product p2 = two.product();
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(path);
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//		System.out.println( sdf.format(date));

	}
}
