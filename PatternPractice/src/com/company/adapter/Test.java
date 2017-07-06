package com.company.adapter;

public class Test {

	public static void main(String[] args) {
			
		ObjectAdapter desk = new Desk();
		ObjectAdapter chair = new Chair();
		
		Adapter adapter = new Adapter(desk);
		desk.whoIAm();
		adapter.whoIAm();
	}
	
}
