package com.company.observer;

public class Observer {
	
	public static void main(String[] args) {
		Watched obj = new InstanceWatched("小李");
		
		Watcher one = new InstanceWatcher("同事1");
		Watcher two = new InstanceWatcher("同事2");
		Watcher three = new InstanceWatcher("同事3");
		
		obj.addWatcher(one);
		obj.addWatcher(two);
		obj.addWatcher(three);
		
		obj.notifyWatcher("吃水果");
	}
	
}
