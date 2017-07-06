package com.company.decorator;


public class Decorator {

	
	public static void main(String[] args) {
		Component flesh = new Monkey();
		Component bear = new Bear(flesh);
		Component wolf = new Wolf(flesh);
		bear.move();
		
	}
}
