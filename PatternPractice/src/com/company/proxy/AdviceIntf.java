package com.company.proxy;

public interface AdviceIntf {

	public void beforeMethod(Object o);
	public void afterMethod(Object o);
	public void catchMethod(Object o);
	public void finallyMethod(Object o);
}
