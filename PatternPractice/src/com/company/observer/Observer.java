package com.company.observer;

public class Observer {
	
	public static void main(String[] args) {
		Watched obj = new InstanceWatched("С��");
		
		Watcher one = new InstanceWatcher("ͬ��1");
		Watcher two = new InstanceWatcher("ͬ��2");
		Watcher three = new InstanceWatcher("ͬ��3");
		
		obj.addWatcher(one);
		obj.addWatcher(two);
		obj.addWatcher(three);
		
		obj.notifyWatcher("��ˮ��");
	}
	
}
