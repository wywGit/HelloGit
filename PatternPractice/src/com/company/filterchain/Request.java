package com.company.filterchain;

public class Request {

	private String reqStr;
	
	public Request() {
	}
	public Request(String str) {
		this.reqStr = str;
	}

	public void setReqStr(String reqStr) {
		this.reqStr = reqStr;
	}

	public String getReqStr() {
		return reqStr;
	}
}
