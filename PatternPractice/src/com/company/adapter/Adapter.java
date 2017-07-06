package com.company.adapter;

public class Adapter {

	private ObjectAdapter oa;
	
	public Adapter(ObjectAdapter oa){
		this.oa=oa;
	}
	
	public void whoIAm(){
		oa.whoIAm();
	}
	
	public void whichUseI(){
		oa.whichUseI();
	}
}
