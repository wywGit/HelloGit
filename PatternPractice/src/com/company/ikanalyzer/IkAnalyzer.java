package com.company.ikanalyzer;

import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
public class IkAnalyzer {
	public static String str="Ե����Ժǰ10+�죬����������������ֱ�������ƶ���С�������ʹ����η�䡢���ȣ�������������ŧ�ȡ�δ���ӣ�δ���ơ�10+���������Դ��޺�����ʹ����������ŧ����Ϊ��һ�����ƾ�����Ժ�������ԡ������෢�����ס��Ժ����������������ʳ�����ã���С������������δ�����Ըı䡣";
//	public static String str="IK Analyzer��һ����Դ�ģ�����java����" +
//			"�����������������ķִʹ��߰�����2006��12���Ƴ�1.0�濪ʼ�� " +
//			"IKAnalyzer�Ѿ��Ƴ���4����汾������������Կ�Դ��ĿLuenceΪ" +
//			"Ӧ������ģ���ϴʵ�ִʺ��ķ������㷨�����ķִ��������3.0��" +
//			"����ʼ��IK��չΪ����Java�Ĺ��÷ִ������������Lucene��Ŀ��ͬʱ" +
//			"�ṩ�˶�Lucene��Ĭ���Ż�ʵ�֡�";
	
	public static void main(String[] args) throws IOException {
		
//		//����Luceneʵ��
//		Analyzer analyzer = new IKAnalyzer(true);//true�����з�
//		StringReader reader = new StringReader(str);
//		TokenStream ts = analyzer.tokenStream("", reader);
//		CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
//		while(ts.incrementToken()){
//			System.out.print(term.toString()+"|");
//		}
//		reader.close();
//		System.out.println();
		
		//����Luceneʵ��
		StringReader re = new StringReader(str);
		IKSegmenter ik = new IKSegmenter(re,true);
		Lexeme lex = null;
		while((lex=ik.next())!=null){
			if(lex.getLength()==1)continue;
			System.out.print(lex.getLexemeText()+",");
		}
//		Map<String,String> map = new HashMap<String, String>();
//		map.put("����", "S��");
//		map.put("����", "ddd");
//		Iterator<Entry<String, String>> entry = map.entrySet().iterator();
//		while(entry.hasNext()){
//			Entry<String, String> e = entry.next();
//			System.out.println(e.getKey()+","+e.getValue());
//		}
	}
}
