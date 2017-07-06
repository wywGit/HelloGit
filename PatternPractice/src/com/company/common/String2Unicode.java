package com.company.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String2Unicode {
	
	/**
	 * 用Runtime类调用系统程序 转码
	 * @since 2015-3-3
	 * @param str
	 * @return String
	 * @author wuyw
	 */
	public static String String2UnicodeByBin(String str){
		String path = "F:\\jdkX32\\jdk1.5.0_22\\bin";
//		str = "撞我啊！";//\u649e\u6211\u554a\uff01
		System.out.println(StringToUnicode(str));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			Process exc = Runtime.getRuntime().exec(path+"/native2ascii.exe");//-reverse 反转
			OutputStream os = exc.getOutputStream();
			os.write(str.getBytes());
			os.flush();
			os.close();
			InputStream is = exc.getInputStream();
			byte[] b = new byte[1024];
			int length;
			while((length = is.read(b,0,1024))!=-1){
				bos.write(b,0,length);
			}
//			System.out.println(bos.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bos.toString();
	}

	/**
	 * 把字符串转化为unicode编码的字符
	 * @since 2015-3-3
	 * @param str
	 * @return String
	 * @author wuyw
	 */
	public static String StringToUnicode(String str){
    	String value = "";
	    for(int i = 0;i<str.length();i++)
	    {
	    	value += "\\u" + Integer.toHexString(str.charAt(i));
	    }
	//    System.out.println(value); 
	    return value;
     }
	
	/**
	 * 把unicode字符转化为字符串
	 * @since 2015-3-3
	 * @param str
	 * @return String
	 * @author wuyw
	 */
	 public static String UnicodeToString(String str){
	        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");    
	        Matcher matcher = pattern.matcher(str);
	        char ch;
	        while (matcher.find())
	        {
	            ch = (char) Integer.parseInt(matcher.group(2), 16);
	            str = str.replace(matcher.group(1), ch + "");    
	        }
	        return str;
	  }
}
