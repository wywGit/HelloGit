package com.company.strategy;

public class CashContext {

	private CashSuper cs;
	
	public CashContext(CashSuper cs){
		this.cs = cs;
	}
	
	public double getResult(double money){
		return cs.printCash(money);
	}
}
