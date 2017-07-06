package com.company.thread;

public class MyThread extends Thread {

	private int ticket=20;
	private String name;
	public MyThread() {
	}
	public MyThread(String string) {
		this.name = string;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println(this.name+"Ê£ÓàÆ±Êý£º"+ ticket--);
		}
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
}
