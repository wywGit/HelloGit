package com.company.lucene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**  
 * JdbcUtil.java
 * @version 1.0
 * @createTime JDBC��ȡConnection������
 */
public class JdbcUtil {
	
	private static Connection conn = null;
	
	private static final String URL;
	
	private static final String JDBC_DRIVER;
	
	private static final String USER_NAME;
	
	private static final String PASSWORD;
	
	static {
		URL = PropertiesUtil.getPropertyValue("jdbc.url");
		JDBC_DRIVER = PropertiesUtil.getPropertyValue("jdbc.driverClassName");
		USER_NAME = PropertiesUtil.getPropertyValue("jdbc.username");
		PASSWORD = PropertiesUtil.getPropertyValue("jdbc.password");
	}
	
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}

