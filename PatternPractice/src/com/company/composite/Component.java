package com.company.composite;

import java.util.List;

/**
 * 树的抽象类
 * @author WYW
 *
 */
public abstract class Component {
	private String name;
	private int level = 0;
	public abstract void printStruct(String prefix);
	
	public Component(){
		
	}
	public void addChild(Component child){
		//throw new UnsupportedOperationException("对象不支持此方法");
	}
	
	public void removeChild(int index){
		//throw new UnsupportedOperationException("对象不支持此方法");
	}
	public void removeChild(Component c) {
	}
	
	public void removeChild(String name) {
	}
	public List<Component> getChild(){
		//throw new UnsupportedOperationException("对象不支持此方法");
		return null;
	}
	public String getName(){
		return this.name;
	}
	public int getLevel(){
		return this.level;
	}
	public void setLevel(int level){
		this.level = level;
	}
}
