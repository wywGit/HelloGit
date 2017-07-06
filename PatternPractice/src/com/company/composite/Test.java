package com.company.composite;

import com.company.dom4j.Dom4j;
import com.company.jxl.ExcelTools;


public class Test {
	
	public static void main(String[] args) {
		Component cloth = new Composite("服装商城");
		Component man = new Composite("男装");
		Component female = new Composite("女装");
		
		Component leaf1 = new Leaf("T恤");
		Component leaf2 = new Leaf("长袖");
		Component leaf3 = new Leaf("长裤");
		
		Component leaf4 = new Leaf("裙子");
		Component leaf5 = new Leaf("披风");
		Component leaf6 = new Leaf("毛衣");
		
		Component brand = new Composite("品牌");
		
		cloth.addChild(man);
		cloth.addChild(female);
		cloth.addChild(brand);
		
		man.addChild(leaf1);
		man.addChild(leaf2);
		man.addChild(leaf2);
		man.addChild(leaf3);
		
		female.addChild(leaf4);
		female.addChild(leaf5);
		female.addChild(leaf6);
		
//		cloth.printStruct("");
		cloth.printStruct("");
		System.out.println("===============================");
		cloth.removeChild(man);
		brand.addChild(man);
		cloth.printStruct("");
//		Dom4j.Composite2XML(cloth);
		ExcelTools.Composite2Excel(cloth,0);
	}
	
}
