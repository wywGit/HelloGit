package com.company.decorator;

public class Bear extends Change {

	public Bear(Component c) {
		super(c);
	}

	public void move() {
		System.out.println("Bear crach ");
	}

}
