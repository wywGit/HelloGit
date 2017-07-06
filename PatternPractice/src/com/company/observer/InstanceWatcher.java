package com.company.observer;


public class InstanceWatcher implements Watcher {

	private String name;
	private String watched;
	
	public InstanceWatcher(String name){
		this.name = name;
	}
	
	public void update(String str){
		System.out.println(this.name+" ¹Û²ì "+this.watched+":"+str);
	}
	
	public void setWatched(String watched) {
		this.watched = watched;
	}

	public String getWatched() {
		return watched;
	}
}
