package com.utils;

/*
 * DBUtil��ר�Ź������ݿ����Ӻ͹رգ��ṩ��ȡ���ݿ����Ӻ͹ر����ݿ����ӵķ���
 * main����ʵʩ�������ݿ��������ر�
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static String user = "root";// �û���
	private static String password = "root";// �������ݿ������
	private static String url = "jdbc:mysql://localhost:3306/newsdb?useUnicode=true&amp;"
			 + "characterEncoding=utf-8";// �������ݿ��url
	static Connection conn = null;// �������ݿ����
	static Statement st = null;// ������
	static ResultSet rs = null;// ���������

	public static void main(String[] args) {
		
	}

	//��ȡ���ݿ�����
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");  //��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//�������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	//�ر����ݿ����Ӷ���
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
	
	//�رս��������
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

	//�ر�Statement����
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
