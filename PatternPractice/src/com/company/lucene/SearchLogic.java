package com.company.lucene;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.TermVector;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**  
 * SearchLogic.java
 * @version 1.0
 * @createTime Lucene数据库检索
 */
public class SearchLogic {

	private static Connection conn = null;
	
	private static Statement stmt = null;
	
	private static  ResultSet rs = null;
	
	private String searchDir = PropertiesUtil.getPropertyValue("res.index.indexPath");
	
	private static File indexFile = null;
	
	private static IndexSearcher searcher = null;
	
	private static Analyzer analyzer = new IKAnalyzer(true);//new SmartChineseAnalyzer();
	
	/** 索引页面缓冲 */
	private int maxBufferedDocs = 500;
	/**
	 * 获取数据库数据
	 * @return ResultSet
	 * @throws Exception
	 */
	public List<SearchBean> getResult(String queryStr) throws Exception {
		
		List<SearchBean> result = null;
		conn = JdbcUtil.getConnection();
		if(conn == null) {
			throw new Exception("数据库连接失败！");
		}
		String sql = "select sympton,name,lab_type from tba_disease";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			this.createIndex(rs);   //给数据库创建索引,此处执行一次，不要每次运行都创建索引，以后数据有更新可以后台调用更新索引
			TopDocs topDocs = this.search(queryStr);

			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			
			result = this.addHits2List(scoreDocs);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("数据库查询sql出错！ sql : " + sql);
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
		return result;
	}
	
	/**
	 * 为数据库检索数据创建索引
	 * @param rs
	 * @throws Exception
	 */
	private void createIndex(ResultSet rs) throws Exception {
		
		Directory directory = null;
		IndexWriter indexWriter = null;
		
		try {
			indexFile = new File(searchDir);
			if(!indexFile.exists()) {
				indexFile.mkdir();
			}
			directory = FSDirectory.open(Paths.get(searchDir));
			
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			indexWriter = new IndexWriter(directory, config);
			Document doc = null;
			while(rs.next()) {
				doc = new Document();
				Field sympton = new Field("sympton", String.valueOf(rs
						.getString("sympton")), Field.Store.YES,
						Field.Index.ANALYZED, TermVector.NO);
				Field name = new Field("name", rs
						.getString("name") == null ? "" : rs
								.getString("name"), Field.Store.YES,
								Field.Index.NOT_ANALYZED, TermVector.YES);
				Field lab_type = new Field("lab_type", rs
						.getString("lab_type") == null ? "" : rs
						.getString("lab_type"), Field.Store.YES,
						Field.Index.NOT_ANALYZED, TermVector.NO);
				doc.add(name);
				doc.add(sympton);
				doc.add(lab_type);
//				indexWriter.addDocument(doc);//完全添加
				indexWriter.updateDocument(new Term("name",rs.getString("name")), doc);//根据name字段merge
			}
			
//			indexWriter.optimize();
			indexWriter.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 搜索索引
	 * @param queryStr
	 * @return
	 * @throws Exception
	 */
	private TopDocs search(String queryStr) throws Exception {

		if(searcher == null) {
//			indexFile = new File(searchDir);
			Directory directory = FSDirectory.open(Paths.get(searchDir));
			DirectoryReader ir = DirectoryReader.open(directory);
			searcher = new IndexSearcher(ir);	
		}
//		searcher.setSimilarity(new IKSimilarity());
		QueryParser parser = new QueryParser("sympton",analyzer);
		parser.setPhraseSlop(4);
		Query query = parser.parse(queryStr);
		System.out.println(query.toString());
		TopDocs topDocs = searcher.search(query,1000);
		
		return topDocs;
	}
	
	/**
	 * 返回结果并添加到List中
	 * @param scoreDocs
	 * @return
	 * @throws Exception
	 */
	private List<SearchBean> addHits2List(ScoreDoc[] scoreDocs ) throws Exception {
		
		List<SearchBean> listBean = new ArrayList<SearchBean>();
		SearchBean bean = null;
		for(int i=0 ; i<scoreDocs.length; i++) {
			int docId = scoreDocs[i].doc;
			Document doc = searcher.doc(docId);
			bean = new SearchBean();
			bean.setName(doc.get("name"));
			bean.setSympton(doc.get("sympton"));
			bean.setLabType(doc.get("lab_type"));
			bean.setScore(scoreDocs[i].score);
			listBean.add(bean);
		}
		return listBean;
	}
	
	public static void main(String[] args) {
		SearchLogic logic = new SearchLogic();
		try {
			Long startTime = System.currentTimeMillis();
			List<SearchBean> result = logic.getResult("情绪不宁");
			int i = 0;
			for(SearchBean bean : result) {
				if(i == 100) break;
				System.out.println(""
						+ " bean.score : " + bean.getScore()
						+ " bean.name : " + bean.getName()
						+ " bean.sympton : " + bean.getSympton()
						+ " bean.lab_type : " + bean.getLabType());
				i++;
			}
			System.out.println("searchBean.result.size : " + result.size());
			Long endTime = System.currentTimeMillis();
			System.out.println("查询所花费的时间为：" + (endTime-startTime)/1000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
