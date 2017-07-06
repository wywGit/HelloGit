package com.company.proxy;

import java.lang.reflect.Method;
/**
 * ��־������
 * @author Administrator
 *
 */
public class LogProxy implements AdviceIntf{

	public void beforeMethod(Object o){
		if(o instanceof Method){
			Method m = (Method) o;
			System.out.println("��ʼ��־"+m.getName()+"����");
		}
	}
	public void afterMethod(Object o){
		if(o instanceof Method){
			Method m = (Method) o;
			System.out.println("������־"+m.getName()+"����");
		}
	}
	public void catchMethod(Object o){
		if(o instanceof Exception){
			Exception e = (Exception) o;
			System.out.println("�׳��쳣��Ϣ��"+e.getLocalizedMessage());
		}
	}
	public void finallyMethod(Object o){
			System.out.println("��ʼ��־finally��");
	}
}
