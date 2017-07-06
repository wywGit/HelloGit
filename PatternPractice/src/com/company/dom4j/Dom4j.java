package com.company.dom4j;


import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.company.composite.Component;

public class Dom4j {
	
	public static void main(String[] args) {
		// *************************************** test ****************************************
//         String xmlText = "<?xml version='1.0' encoding='GBK'?><content><cust_info><customer_id>593100005582951</customer_id><cust_name>sisis</cust_name><ic_type>1</ic_type><ic_type_name>身份证</ic_type_name><ic_no>352229771004002</ic_no><address/><telephone/><postcode/><confirm_flag>0</confirm_flag><confirm_flag_name>无资料</confirm_flag_name></cust_info><user_id>593100005582961</user_id><msisdn>13706030649</msisdn><home_city>593</home_city><home_city_name>宁德</home_city_name><home_county>301</home_county><home_county_name>宁德市区</home_county_name><password>A70C78261E40BC5E</password><user_type>4</user_type><user_type_name>测试机</user_type_name><msisdn_type>3</msisdn_type><msisdn_type_name>GSM</msisdn_type_name><imsi>460006037128074</imsi><old_brand_id>1000</old_brand_id><old_brand_id_name>全球通(升级版)</old_brand_id_name><user_status>0</user_status><user_status_name>正常</user_status_name><bill_type>5</bill_type><bill_type_name>虚扣</bill_type_name><bill_credit>99999999</bill_credit><service_type>1</service_type><service_type_name>普通</service_type_name><create_operator>0</create_operator><create_operator_name>武夷山超级管理员</create_operator_name><order_id>100000015194</order_id><history_id>100000010073</history_id><sim_card_no>8987000000940094083</sim_card_no><sim_card_type>10</sim_card_type><sim_card_type_name>远程写卡</sim_card_type_name><bank_card_type>0</bank_card_type><bank_card_type_name>无</bank_card_type_name><create_time>20051118113447</create_time><open_time/><transfer_time/><stop_time/><expire_time/><modify_time>20060411163003</modify_time><operator_id>3014040</operator_id><modify_content>爱贝通平安卡开通绑定</modify_content><consume_level/><consume_level_name>零星级</consume_level_name><card_level>1</card_level><card_level_name>钻石卡</card_level_name><vip_card_no>12345678</vip_card_no><voucher_type>3</voucher_type><voucher_type_name>移动使用证</voucher_type_name><voucher_id>59300002</voucher_id><current_brand_id>1000</current_brand_id><current_brand_id_name>全球通(升级版)</current_brand_id_name><current_product_id>1000</current_product_id><current_product_id_name>全球通（升级版）</current_product_id_name><current_deal_kind>1000</current_deal_kind><current_deal_id>10000000</current_deal_id></content>";
//         String xmlText = "<?xml version='1.0' encoding='GBK'?><operation_out><accept_id name='123'>2150241</accept_id><response_time>20060417141242</response_time><response><resp_result>0</resp_result><resp_code></resp_code><resp_desc></resp_desc></response><content><user_sec_info></user_sec_info></content></operation_out>";
         String xmlText = "<?xml version='1.0' encoding='UTF-8'?><CONTENT><MQ_CONFIG><NAMESERVER_ADDR>192.168.27.128:9876</NAMESERVER_ADDR><AUTH_ID ENCRYPT_FLAG='true'>admin</AUTH_ID><AUTH_PWD ENCRYPT_FLAG='true'>123456</AUTH_PWD><PRODUCER_GROUP>crmProducerGroupName</PRODUCER_GROUP><CONSUMER_GROUP>crmConsumerGroupName</CONSUMER_GROUP><CONSUME_ORDER>true</CONSUME_ORDER></MQ_CONFIG></CONTENT>";
        // *************************************************************************************
		try {
//			Composite2XML(null);
			Document document = DocumentHelper.parseText(xmlText);
			OutputFormat format = OutputFormat.createPrettyPrint();
	        format.setEncoding("gb2312");
	        StringWriter writer = new StringWriter();
	        // 格式化输出流
	        XMLWriter xmlWriter = new XMLWriter(writer, format);
	        // 将document写入到输出流
	        xmlWriter.write(document);
//			SAXReader reader = new SAXReader();
//			makeUpXML(document);
//			writeXML(document);
//			Element root = document.getRootElement();
//			System.out.println(root.getName());
//			getElements(root,"\t");
//			getAttributes(root);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void getAttributes(Element root) {
		Element e = root.element("MQ_CONFIG").element("AUTH_PWD");
		Attribute attr = e.attribute("ENCRYPT_FLAG");
		System.out.println(attr.getValue());
	}

	/**
	 * 在xml文件中添加节点
	 * @since 2015-2-9
	 * @param document
	 * @return void
	 * @author wuyw
	 */
	private static void makeUpXML(Document document) {
		Element root = document.getRootElement();
		Element node = root.element("content");
//		List<Element> nodes = root.elements("content");
//		System.out.println(nodes.size());;
		Element el_new = node.addElement("new");
		Element el_too = el_new.addElement("new2");
		el_too.addAttribute("type", "string");
		el_too.addText("I am new");
		
	}

	/**
	 * 遍历某个节点下的所有子节点
	 * 2014-11-21
	 * @param
	 * @return void
	 * @author Administrator
	 */
	public static void getElements(Element rootElement,String separator){
		for(Iterator it = rootElement.elementIterator(); it.hasNext();){
			Element e = (Element) it.next();
//			List<Element> es = e.elements();
//			for(int i=0;i<es.size();i++){
//				System.out.println(es.get(i).getName());
//			}
			System.out.println(separator+e.getName()+":"+e.getText());
			if(e.elementIterator().hasNext()){
				getElements(e,"\t"+separator);
			}
		}
	}
	
	/**
	 * 生成XML文件
	 * 2014-11-21
	 * @param document
	 * @return void
	 * @author wuyw
	 */
	public static void writeXML(Document document){
		String path = "E:\\workspace\\PatternPractice\\src\\com\\company\\dom4j\\123.xml";
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		try {
			File file = new File(path);
			if(!file.exists()){
				System.out.println("文件不存在，正在创建。。。");
				file.createNewFile();
			}
			Writer out = new OutputStreamWriter(new FileOutputStream(file));
			XMLWriter xw = new XMLWriter(out,format);
			xw.write(document);
			xw.flush();
			xw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		}
	}
	
	/**
	 * 把合成模式中的树状形成xml
	 * @since 2015-2-9
	 * @param comp
	 * @return void
	 * @author wuyw
	 */
	public static void Composite2XML(Component comp){
		String xmlText = "<?xml version='1.0' encoding='GBK'?>";
		try {
			Element root = DocumentHelper.createElement(comp.getName());//parseText(xmlText);
			Document document = DocumentHelper.createDocument(root);
			searchChild(comp, root);
			writeXML(document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchChild(Component comp,Element root){
		List<Component> cList = comp.getChild();
		for(Component c:cList){
			Element e = root.addElement(c.getName());
			if(null!=c.getChild() && c.getChild().size()!=0){
				searchChild(c, e);
			}
		}
	}
}
