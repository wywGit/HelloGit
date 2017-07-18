package com.company.quartz;

import java.util.ArrayList;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class QuartzMain {

	public static void main(String[] args) {
		String str = "!23~%fdf";
		System.out.println(str.split("~").length);
	}
	public static void main2(String[] args) {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		try {
			Scheduler schedule = schedulerFactory.getScheduler();
			JobDataMap jobDataMap = new JobDataMap();
			jobDataMap.put("clazz", "com.company.quartz.Task");
			jobDataMap.put("method", "doTask");
			jobDataMap.put("cron", "0/5 * * * * ?");
			JobDataMap jobDataMap1 = new JobDataMap();
			jobDataMap1.put("clazz", "com.company.quartz.Task");
			jobDataMap1.put("method", "doTask2");
			jobDataMap1.put("cron", "0/10 * * * * ?");
			List<JobDataMap> list = new ArrayList<>();
			list.add(jobDataMap1);
			list.add(jobDataMap);
			for(int i=0; i<list.size(); i++){
				JobDataMap j = list.get(i);
				JobDetail jobDetail = JobBuilder.newJob(TaskJob.class).usingJobData(j).build();
				CronTrigger trigger = new CronTriggerImpl(j.getString("method")+i,null,j.getString("cron"));
				schedule.scheduleJob(jobDetail, trigger);
			}
			schedule.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("123");
	}
	
}
