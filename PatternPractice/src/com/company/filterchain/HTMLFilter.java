package com.company.filterchain;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class HTMLFilter implements Filter {

	public void doFilter(Request req, Response resp, FilterChain chain) {
//		req.setReqStr(req.getReqStr().replace("<", "[")
//									 .replace(">", "]")
//									 +"--HTMLFIlter--");
		replaceFollowFile(req);
		req.setReqStr(req.getReqStr()+"--HTMLFIlter--");
		chain.doFilter(req, resp, chain);
		resp.setRespStr(resp.getRespStr()+"--HTMLFIlter--");
	}
	
	private void replaceFollowFile(Request req){
		ResourceBundle rb = ResourceBundle.getBundle("com/company/filterchain/html_filter");
//		ResourceBundle rb = ResourceBundle.getBundle("com.company.filterchain.html_filter");
		Enumeration<String> keys = rb.getKeys();
		while(keys.hasMoreElements()){
			String tmp = keys.nextElement();
			System.out.println(tmp);
			req.setReqStr(req.getReqStr().replace(tmp, rb.getString(tmp)));
		}
	}

}
