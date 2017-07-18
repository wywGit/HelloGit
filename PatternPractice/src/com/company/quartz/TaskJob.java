package com.company.quartz;

import java.lang.reflect.Method;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TaskJob implements Job{

//	private String schedule;
	private String clazz;
	private String method;
	private String cron;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("method:"+method);
//		System.out.println("method:"+context.getJobDetail().getJobDataMap().getString("method"));
		try {
			Class<?> c = Class.forName(clazz);
			Method m = c.getDeclaredMethod(method, null);
			m.invoke(c.newInstance(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}

}
