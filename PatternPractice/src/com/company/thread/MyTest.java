package com.company.thread;

public class MyTest {

	public static void main(String[] args) {
//		MyThread mt1 = new MyThread("�߳�1");
//		mt1.start();
//		MyThread mt2 = new MyThread("�߳�2");
//		mt2.start();
		MyRunnable mr1 = new MyRunnable("�߳�1");
		Thread t1 = new Thread(mr1);
		Thread t2 = new Thread(mr1);
		t1.start();
		t2.start();
	}
}
