package com.company.observer;

import java.util.ArrayList;
import java.util.List;

public class InstanceWatched implements Watched {

	private String name;
	private List<Watcher> watchList = new ArrayList<Watcher>();
	
	public InstanceWatched(String name){
		this.name = name;
	}
	
	public void addWatcher(Watcher w) {
		if(w instanceof InstanceWatcher){
			InstanceWatcher watcher = (InstanceWatcher) w;
			watcher.setWatched(this.name);
			this.watchList.add(watcher);
		}
	}

	public void removeWatcher(Watcher w) {
		this.watchList.remove(w);
	}
	
	public void notifyWatcher(String str) {
		System.out.println(this.name+"say:"+str);
		for(Watcher w:watchList){
			w.update(str);
		}
	}
}
