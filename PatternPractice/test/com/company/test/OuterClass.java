package com.company.test;

import java.io.Serializable;

public class OuterClass extends Itest {

	String name;
	
	public OuterClass(){
		super("1");
		this.name = "1";
	}
	

	public class InnerClass extends Itest{
		
		String name;
		public InnerClass(){
			super("2");
			this.name="4";
//			System.out.println("OuterClass:"+OuterClass.this.name);
			System.out.println("InterClass:"+this.name);
			System.out.println("SuperClass:"+super.name);
		}
	}
}
