package com.company.factory;

public class FactoryOne implements Factory {

	public Product product(){
		return new ProductOne();
	}
}
