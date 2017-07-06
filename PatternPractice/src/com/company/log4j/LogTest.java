package com.company.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogTest {

	private static Logger log = Logger.getLogger(LogTest.class);
	/*
	 * #自定义样式  
		# %r 时间 0  
		# %t 方法名 main  
		# %p 优先级 DEBUG/INFO/ERROR  
		# %c 所属类的全名(包括包名)  
		# %l 发生的位置，在某个类的某行  
		# %m 输出代码中指定的讯息，如log(message)中的message  
		# %n 输出一个换行符号  
		log4j.appender.appender1.layout.ConversionPattern=[%d{yy/MM/dd HH:mm:ss:SSS}][%C-%M] %m%n 
	 */
	public static void main(String[] args) {
//		PropertyConfigurator.configure("E:\\workspace\\PatternPractice\\src\\com\\company\\log4j\\log4j.properties");//加载.properties文件
		PropertyConfigurator.configure("bin\\com\\company\\log4j\\log4j.properties");//加载.properties文件.相对路径
		log.debug("debug something");
		log.info("info something");
		log.error("error something");
	}
}
