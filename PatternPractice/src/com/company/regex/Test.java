package com.company.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		printDigtal();
//		printOneSide("EEEEEEE23423423EEE3");
//		printOneSide("23423423EEE3EEEEEEE");
		String str = "cdr_1234.tmp";
		String regex = ".*\\.[0-9]+$";
		System.out.println(str.matches(regex));
	}
	
	/**
	 * 去掉 数据 两边的无用信息
	 */
	public static void printOneSide(String str){
		if(str.startsWith("E")){
			char[] arr = str.toCharArray();
			for(int i=0; i<arr.length; i++){
				if(arr[i]!='E'){
					str = str.substring(i);
					break;
				}
			}
		}else{
			char[] arr = str.toCharArray();
			for(int i=arr.length-1; i>0; i--){
				if(arr[i]!='E'){
					str = str.substring(0,i+1);
					break;
				}
			}
		}
		System.out.println(str);
	}
	
	/**
	 * 提取字符串中的数字
	 */
	public static void printDigtal(){
		String str = "E22AA12345EEEDDD";
		String regex = "\\d+[A-Z]*\\d+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
//		System.out.println(m.start());
//		System.out.println(m.end());
//		System.out.println(str.substring(m.start(),m.end()));
		System.out.println(str.replaceAll("\\d+[A-Z]*\\d+", ""));
	}
}
