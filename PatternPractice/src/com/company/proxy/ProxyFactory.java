package com.company.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyFactory{

	private List<AdviceIntf> advices = new ArrayList<AdviceIntf>();
	
	private Object target;
	
	public ProxyFactory(){}
	/**
	 * 构造函数
	 * @param target 执行的目标
	 */
	public ProxyFactory(Object target){
		this.target = target;
	}
	public ProxyFactory addAdvice(AdviceIntf advice){
		advices.add(advice);
		return this;
	}
	public Object getProxy(){
		Object proxy = Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args){
							Object result = null;
							for(int i=0; i<advices.size(); i++){
								advices.get(i).beforeMethod(method);
							}
							try{
//								System.out.println("parameter:"+args[0]+","+args[1]+","+args[2]);
								result = method.invoke(target, args);
								for(int i=0; i<advices.size(); i++){
									advices.get(i).afterMethod(method);
								}
							}catch(Exception e){
								for(int i=0; i<advices.size(); i++){
									advices.get(i).catchMethod(method);
								}
							}finally{
								for(int i=0; i<advices.size(); i++){
									advices.get(i).finallyMethod(method);
								}
							}
							return result;
					}
				});
		return proxy;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	public List<AdviceIntf> getAdvices() {
		return advices;
	}
	public void setAdvices(List<AdviceIntf> advices) {
		this.advices = advices;
	}
}
