package com.company.composite;

import com.company.dom4j.Dom4j;
import com.company.jxl.ExcelTools;


public class Test {
	
	public static void main(String[] args) {
		Component cloth = new Composite("��װ�̳�");
		Component man = new Composite("��װ");
		Component female = new Composite("Ůװ");
		
		Component leaf1 = new Leaf("T��");
		Component leaf2 = new Leaf("����");
		Component leaf3 = new Leaf("����");
		
		Component leaf4 = new Leaf("ȹ��");
		Component leaf5 = new Leaf("����");
		Component leaf6 = new Leaf("ë��");
		
		Component brand = new Composite("Ʒ��");
		
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
