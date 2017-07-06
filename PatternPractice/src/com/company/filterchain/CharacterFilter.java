package com.company.filterchain;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class CharacterFilter implements Filter {

	public void doFilter(Request req, Response resp, FilterChain chain) {
//		req.setReqStr(req.getReqStr().replace("Ï°", "*")
//									 .replace("·´¸¯", "**")
//									 +"--CharacterFilter--");
		replaceFollowFile(req);
		req.setReqStr(req.getReqStr()+"--CharacterFilter--");
		chain.doFilter(req, resp, chain);
		resp.setRespStr(resp.getRespStr()+"--CharacterFilter--");
	}
	
	private void replaceFollowFile(Request req){
		ResourceBundle rb = ResourceBundle.getBundle("com.company.filterchain.character_filter");
		Enumeration<String> keys = rb.getKeys();
		while(keys.hasMoreElements()){
			String tmp = keys.nextElement();
			req.setReqStr(req.getReqStr().replace(tmp, rb.getString(tmp)));
		}
	}
}
