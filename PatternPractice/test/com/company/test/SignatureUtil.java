package com.company.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具�?
 * 
 *
 * 
 */
public class SignatureUtil {
	private static Logger logger = LoggerFactory.getLogger(SignatureUtil.class);
	public static final String key="zydjpt_his_yx";
	
	public static boolean checkSignature(Map<String, String> dataMap,String signature){
		
		String result =createSignature(dataMap);
		logger.debug(result);
		if(signature.equals(result)){
			return true;
		}else{
			return false;
		}
	}
	
	public static String createSignature(Map<String, String> dataMap){
		ArrayList<String> list = new ArrayList<String>();
		for(String key:dataMap.keySet()){
			if(dataMap.get(key)!=null&&!"".equals(dataMap.get(key))){
				list.add(key + "=" + dataMap.get(key));
			}
		}
		int size = list.size();
		String [] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i ++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + key;
		System.out.println(result);
		result = SecurityUtil.md5Encode(result);
		return result;
	}
	public static void main(String[] args) {
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("nonce", "wl6FrBRXIWpmqd80");
		dataMap.put("timestamp", "1482223601681");
		dataMap.put("sign", "8a8f6698a60f1280d041b3d0d7e0b5e8eda1b24");
		createSignature(dataMap );
	}
}
