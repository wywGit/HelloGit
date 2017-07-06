package com.company.strategy;

public class Test {

	public static void main(String[] args) {
		
		double money = 500;
		CashContext context = new CashContext(new CashNormal());
		System.out.println("正常收费："+context.getResult(money));
		context = new CashContext(new CashRebate(0.7));
		System.out.println("打折收费："+context.getResult(money));
		context = new CashContext(new CashReturn(200,100));
		System.out.println("返利收费："+context.getResult(money));
		
		boolean flag = false;
		System.out.println(flag);
	}
}
