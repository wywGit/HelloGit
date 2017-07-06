package com.company.decorator;

public class Wolf extends Change {

	public Wolf(Component c) {
		super(c);
	}

	public void move() {
		System.out.println("Wolf sound ");
	}

}
