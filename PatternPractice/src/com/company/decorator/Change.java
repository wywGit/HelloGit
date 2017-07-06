package com.company.decorator;

public class Change implements Component {

	private Component component;
	
	public Change(Component c){
		this.component = c;
	}
	
	public void move() {
		this.component.move();
	}

}
