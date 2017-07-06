package com.company.test;

import java.util.Arrays;


public class NewTest{
	
	public NewTest(){
		System.out.println(System.currentTimeMillis());
	}
	public static void main(String[] args) {
		
		int money = 100;
		int[] coins = {50,20,10};
		StringBuffer str=new StringBuffer("\n");
		
		System.out.println(printMethod(money,coins,str));
		System.out.println(str);
	}

	private static int printMethod(int money, int[] coins,StringBuffer str) {
		if(money==0){
			str.append("\n");
			return 1;
		}else if(money < 0){
			return 0;
		}else if(coins.length==1){
			str.append(coins[0]+"*"+money/coins[0]+"\n");
			return money%coins[0]==0?1:0;
		}
		return printMethod(money-coins[0], coins,str.append(coins[0]+","))
				+ printMethod(money, Arrays.copyOfRange(coins, 1, coins.length),str);
	}
	
}
