package com.company.factory;

public class FactoryTwo implements Factory {

	public Product product(){
		return new ProductTwo();
	}
}
