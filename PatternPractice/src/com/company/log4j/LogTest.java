package com.company.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogTest {

	private static Logger log = Logger.getLogger(LogTest.class);
	/*
	 * #�Զ�����ʽ  
		# %r ʱ�� 0  
		# %t ������ main  
		# %p ���ȼ� DEBUG/INFO/ERROR  
		# %c �������ȫ��(��������)  
		# %l ������λ�ã���ĳ�����ĳ��  
		# %m ���������ָ����ѶϢ����log(message)�е�message  
		# %n ���һ�����з���  
		log4j.appender.appender1.layout.ConversionPattern=[%d{yy/MM/dd HH:mm:ss:SSS}][%C-%M] %m%n 
	 */
	public static void main(String[] args) {
//		PropertyConfigurator.configure("E:\\workspace\\PatternPractice\\src\\com\\company\\log4j\\log4j.properties");//����.properties�ļ�
		PropertyConfigurator.configure("bin\\com\\company\\log4j\\log4j.properties");//����.properties�ļ�.���·��
		log.debug("debug something");
		log.info("info something");
		log.error("error something");
	}
}
