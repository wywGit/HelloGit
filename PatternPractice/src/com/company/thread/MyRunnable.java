package com.company.thread;

public class MyRunnable implements Runnable {

	private int ticket = 20;
	private String name;
	
	public MyRunnable() {
		super();
	}

	public MyRunnable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println(this.name+"Ê£ÓàÆ±Êý£º"+ ticket--);
		}
	}

}
