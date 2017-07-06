package com.company.proxy;

import java.lang.reflect.Method;
/**
 * 日志代理类
 * @author Administrator
 *
 */
public class LogProxy implements AdviceIntf{

	public void beforeMethod(Object o){
		if(o instanceof Method){
			Method m = (Method) o;
			System.out.println("开始日志"+m.getName()+"方法");
		}
	}
	public void afterMethod(Object o){
		if(o instanceof Method){
			Method m = (Method) o;
			System.out.println("结束日志"+m.getName()+"方法");
		}
	}
	public void catchMethod(Object o){
		if(o instanceof Exception){
			Exception e = (Exception) o;
			System.out.println("抛出异常信息："+e.getLocalizedMessage());
		}
	}
	public void finallyMethod(Object o){
			System.out.println("开始日志finally块");
	}
}
