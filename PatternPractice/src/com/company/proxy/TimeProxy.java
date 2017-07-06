package com.company.proxy;

public class TimeProxy implements AdviceIntf{

	private long beginTime = 0;
	private long endTime = 0;
	
	public void beforeMethod(Object o){
		setBeginTime(System.currentTimeMillis());
		System.out.println("��ʼʱ��:"+getBeginTime());
	}
	public void afterMethod(Object o){
		setEndTime(System.currentTimeMillis());
		System.out.println("����ʱ��:"+getEndTime());
	}
	public void catchMethod(Object o){
		System.out.println("�����쳣������");
	}
	public void finallyMethod(Object o){
		System.out.println("ʱ��"+(getEndTime()-getBeginTime()));
	}
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}
	public long getBeginTime() {
		return beginTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public long getEndTime() {
		return endTime;
	}
}
