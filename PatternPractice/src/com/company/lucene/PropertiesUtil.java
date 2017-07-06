package com.company.lucene;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**  
 * PropertiesUtil.java
 * @version 1.0
 * @createTime ��ȡ�����ļ���Ϣ��
 */
public class PropertiesUtil {

	private static String defaultPropertyFilePath = "test.properties";
	
	private static Map<String,Properties> ppsMap = new HashMap<String,Properties>();
	
	/**
	 * ��ȡĬ���ļ���������Ϣ����key����value
	 * @param key
	 * @return value
	 */
	public static final String getPropertyValue(String key) {
		Properties pps = getPropertyFile(defaultPropertyFilePath);
		return pps == null ? null : pps.getProperty(key);
	}
	
	/**
	 * ����filePath��ȡָ��property�ļ�����key����value
	 * @param propertyFilePath
	 * @param key
	 * @return value
	 */
	public static String getPropertyValue(String propertyFilePath,String key) {
		if(propertyFilePath == null) {
			propertyFilePath = defaultPropertyFilePath;
		}
		Properties pps = getPropertyFile(propertyFilePath);
		return pps == null ? null : pps.getProperty(key);
	}
	
	/**
	 * ����path����property�ļ��������浽HashMap�У����Ч��
	 * @param propertyFilePath
	 * @return
	 */
	public static Properties getPropertyFile(String propertyFilePath) {
		if(propertyFilePath == null) {
			return null;
		}
		Properties pps = ppsMap.get(propertyFilePath);
		if(pps == null) {
			InputStream in = PropertiesUtil.class.getResourceAsStream(propertyFilePath);
			pps = new Properties();
			try {
				pps.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ppsMap.put(propertyFilePath, pps);
		}
		
		return pps;
	}
}
