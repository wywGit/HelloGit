package com.company.strategy;

public class CashRebate extends CashSuper {

	private double moneyRebate;
	
	public CashRebate(double moneyRebate){
		this.moneyRebate = moneyRebate;
	}
	@Override
	public double printCash(double money) {
		return this.moneyRebate*money;
	}

}
