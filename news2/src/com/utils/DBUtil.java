package com.utils;

/*
 * DBUtil类专门管理数据库连接和关闭，提供获取数据库连接和关闭数据库连接的方法
 * main方法实施测试数据库的连接与关闭
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static String user = "root";// 用户名
	private static String password = "root";// 连接数据库的密码
	private static String url = "jdbc:mysql://localhost:3306/newsdb?useUnicode=true&amp;"
			 + "characterEncoding=utf-8";// 连接数据库的url
	static Connection conn = null;// 连接数据库对象
	static Statement st = null;// 语句对象
	static ResultSet rs = null;// 结果集对象

	public static void main(String[] args) {
		
	}

	//获取数据库连接
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");  //加载驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//创建数据库连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	//关闭数据库连接对象
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed() ) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//关闭结果集对象
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
	}

	//关闭Statement对象
	public static void closeStatement(Statement st) {
		try {
			if (st != null && !st.isClosed()) {
				st.close();
				st = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
