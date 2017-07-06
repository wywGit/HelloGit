package com.company.strategy;

public class CashNormal extends CashSuper {

	@Override
	public double printCash(double money) {
		return money;
	}

}
