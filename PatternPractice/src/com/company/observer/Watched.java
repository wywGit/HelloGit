package com.company.observer;

public interface Watched {

	public void addWatcher(Watcher w);
	
	public void removeWatcher(Watcher w);
	
	public void notifyWatcher(String str);
}
