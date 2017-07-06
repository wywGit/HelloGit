package com.company.proxy;

public class Test implements ITest {

	public void test() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("target object!");
	}
	
	public void proxy(String s,int i, double d){
		System.out.println("test proxy!");
	}
	
	public static void main(String[] args) {
//		ProxyFactory pf = new ProxyFactory(new TimeProxy(), new Test());
		
		ProxyFactory pf = new ProxyFactory(new Test());
		pf.addAdvice(new TimeProxy()).addAdvice(new LogProxy());
		ITest i = (ITest) pf.getProxy();
		i.proxy("1",2,3.0);
	}
	
}
