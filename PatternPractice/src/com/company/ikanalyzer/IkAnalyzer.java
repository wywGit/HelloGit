package com.company.ikanalyzer;

import java.io.IOException;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;
public class IkAnalyzer {
	public static String str="缘于入院前10+天，患者无明显诱因出现背部多个黄豆大小肿物，无疼痛，无畏冷、发热，无肿物破溃流脓等。未重视，未治疗。10+天来肿物稍大，无红肿疼痛，无破溃流脓。今为进一步治疗就诊我院，门诊以“背部多发肿物”收住入院。发病以来，精神食欲良好，大小便正常，体重未见明显改变。";
//	public static String str="IK Analyzer是一个开源的，基于java语言" +
//			"开发的轻量级的中文分词工具包。从2006年12月推出1.0版开始， " +
//			"IKAnalyzer已经推出了4个大版本。最初，它是以开源项目Luence为" +
//			"应用主体的，结合词典分词和文法分析算法的中文分词组件。从3.0版" +
//			"本开始，IK发展为面向Java的公用分词组件，独立于Lucene项目，同时" +
//			"提供了对Lucene的默认优化实现。";
	
	public static void main(String[] args) throws IOException {
		
//		//基于Lucene实现
//		Analyzer analyzer = new IKAnalyzer(true);//true智能切分
//		StringReader reader = new StringReader(str);
//		TokenStream ts = analyzer.tokenStream("", reader);
//		CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
//		while(ts.incrementToken()){
//			System.out.print(term.toString()+"|");
//		}
//		reader.close();
//		System.out.println();
		
		//独立Lucene实现
		StringReader re = new StringReader(str);
		IKSegmenter ik = new IKSegmenter(re,true);
		Lexeme lex = null;
		while((lex=ik.next())!=null){
			if(lex.getLength()==1)continue;
			System.out.print(lex.getLexemeText()+",");
		}
//		Map<String,String> map = new HashMap<String, String>();
//		map.put("试试", "S的");
//		map.put("试试", "ddd");
//		Iterator<Entry<String, String>> entry = map.entrySet().iterator();
//		while(entry.hasNext()){
//			Entry<String, String> e = entry.next();
//			System.out.println(e.getKey()+","+e.getValue());
//		}
	}
}
