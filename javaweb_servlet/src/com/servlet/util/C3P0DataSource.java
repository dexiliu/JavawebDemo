package com.servlet.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.beans.PropertyVetoException;


import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 用连接池来连接数据库
 * @author Administrator
 *
 */

public class C3P0DataSource {

	private static C3P0DataSource c3p0;
	private static ComboPooledDataSource dataSource;
	static{
		//创建连接池实例
		c3p0=new C3P0DataSource();
	}
	
	public C3P0DataSource(){
		try{
			dataSource=new ComboPooledDataSource();
			//设置连接池连接数据库的用户名
			dataSource.setUser("root");
			//设置连接池连接数据库的密码
			dataSource.setPassword("root");
			//设置连接池连接数据库的地址和一些参数设置
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/servlet?"
					+ "autoReconnect=true&useUnicode=true&"
					+ "characterEncoding=UTF-8&defaultRowPrefectch=50&dufaultBatchValue=50");
			//设置连接池连接数据库的驱动
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			//初始化时获取三个连接，取值应在minPoolSize与maxPoolSize之间
			dataSource.setInitialPoolSize(3);
			//连接池中保留最小连接数
			dataSource.setMinPoolSize(2);
			//连接池中保留最大连接数
			dataSource.setMaxPoolSize(40);
			//最大空闲时间,60秒内未使用则连接被丢弃
			dataSource.setMaxIdleTime(60);
			//JDBC的标准参数，用以控制数据源内加载的PreparedStatements数量。
			//但由于预缓存的statements属于单个connection而不是整个连接池
			dataSource.setMaxStatements(100);
			//c3p0是异步操作的，缓慢的JDBC操作通过帮助进程完成。扩展这些操作可以有效的提升性能
			//通过多线程实现多个操作同时被执行
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
			throw new RuntimeException("无法从数据源获取连接", e);
		}
	}
	
}
