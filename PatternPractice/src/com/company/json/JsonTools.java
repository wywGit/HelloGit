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
 * json-lib��org.json��ʹ�ü�������ͬ�ģ����ܽ�������������㣺

      1. org.json��json-libҪ�����ö࣬ǰ��û�������κ�����jar����������Ҫ����ezmorph��commons��lang��logging��beanutils��collections�����

      2. json-lib�ڹ���bean�ͽ���beanʱ��org.jsonҪ����Ķ࣬json-lib��ֱ����bean����ת������org.json����ֱ����bean�໥ת������Ҫmap��Ϊ��ת������beanתΪjson���ݣ�������Ҫ�Ƚ�beanת��Ϊmap�ٽ�mapתΪjson���Ƚ��鷳��
 */
//jsonת��Bean��ʱ����Ҫͨ��get�ֶ�����ȡ��Ա����
public class JsonTools {

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
