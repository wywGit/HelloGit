package com.company.singleton;

public class Singleton {

	private Singleton(){
		System.out.println("i am singleton");
	}
	
	private static Singleton singleton;
	
	public static synchronized Singleton getSingleton() {
		if(singleton==null)
			singleton = new Singleton();
		return singleton;
	}

}
