package com.servlet.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.beans.PropertyVetoException;


import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * �����ӳ����������ݿ�
 * @author Administrator
 *
 */

public class C3P0DataSource {

	private static C3P0DataSource c3p0;
	private static ComboPooledDataSource dataSource;
	static{
		//�������ӳ�ʵ��
		c3p0=new C3P0DataSource();
	}
	
	public C3P0DataSource(){
		try{
			dataSource=new ComboPooledDataSource();
			//�������ӳ��������ݿ���û���
			dataSource.setUser("root");
			//�������ӳ��������ݿ������
			dataSource.setPassword("root");
			//�������ӳ��������ݿ�ĵ�ַ��һЩ��������
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/servlet?"
					+ "autoReconnect=true&useUnicode=true&"
					+ "characterEncoding=UTF-8&defaultRowPrefectch=50&dufaultBatchValue=50");
			//�������ӳ��������ݿ������
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			//��ʼ��ʱ��ȡ�������ӣ�ȡֵӦ��minPoolSize��maxPoolSize֮��
			dataSource.setInitialPoolSize(3);
			//���ӳ��б�����С������
			dataSource.setMinPoolSize(2);
			//���ӳ��б������������
			dataSource.setMaxPoolSize(40);
			//������ʱ��,60����δʹ�������ӱ�����
			dataSource.setMaxIdleTime(60);
			//JDBC�ı�׼���������Կ�������Դ�ڼ��ص�PreparedStatements������
			//������Ԥ�����statements���ڵ���connection�������������ӳ�
			dataSource.setMaxStatements(100);
			//c3p0���첽�����ģ�������JDBC����ͨ������������ɡ���չ��Щ����������Ч����������
			//ͨ�����߳�ʵ�ֶ������ͬʱ��ִ��
			dataSource.setNumHelperThreads(50);
		}catch(PropertyVetoException e){
			throw new RuntimeException(e);
		}
	}
		
	public final static C3P0DataSource getInstance() {
		return c3p0;
	}

	public final static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("�޷�������Դ��ȡ����", e);
		}
	}
	
}
