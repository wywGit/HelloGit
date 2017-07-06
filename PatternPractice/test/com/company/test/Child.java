package com.company.test;

public class Child extends Mother{

	public void print(){
		System.out.println("child.");
	}
	public Child test1(){
		this.print();return this;
	}
	public Child test2(){
		super.print();return this;
	}
	public Child test3(){
		this.callPrint();return this;
	}
	public Child test4(){
		super.callPrint();return this;
	}
	public static void main(String[] args) {
		new Child().test1().test2().test3().test4();
	}
}

class Mother{
	public void print(){
		System.out.println("mother.");
	}
	public void callPrint(){
		this.print();
	}
}
