package com.company.json;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.company.composite.Component;
import com.company.composite.Composite;
import com.company.composite.Leaf;

/*
 * json-lib和org.json的使用几乎是相同的，我总结出的区别有两点：

      1. org.json比json-lib要轻量得多，前者没有依赖任何其他jar包，而后者要依赖ezmorph和commons的lang、logging、beanutils、collections等组件

      2. json-lib在构造bean和解析bean时比org.json要方便的多，json-lib可直接与bean互相转换，而org.json不能直接与bean相互转换而需要map作为中转，若将bean转为json数据，首先需要先将bean转换为map再将map转为json，比较麻烦。
 */
//json转换Bean的时候，需要通过get字段来获取成员变量
public class JsonTools {

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
		
//		List list = new ArrayList();
//		list.add("123");
//		list.add("qwe");
		JSONArray jsa = JSONArray.fromObject(cloth);
		System.out.println(jsa.toString());
		printStruct(jsa, "");
		
	}
	
	public static void printStruct(JSONArray jsa,String prefix){
		for(int i=0; i<jsa.size(); i++){
			 JSONObject jo = jsa.getJSONObject(i);
			 System.out.println(prefix+jo.get("level")+jo.get("name"));
//			 Map<String, Class> map = new HashMap<String, Class>();
//			 map.put("child", Component.class);
//			 Composite c = (Composite) JSONObject.toBean(jo,Composite.class,map);
			 if(jo.get("child")!=null){
				 printStruct(jo.getJSONArray("child"), prefix+"\t");
			 }
		}
	}
}
