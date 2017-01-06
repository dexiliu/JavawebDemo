package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.model.User;
import com.utils.AppException;
import com.utils.DBUtil;

public class UserDaoImpl implements UserDao {

	public boolean add(User user) throws AppException {
		
		Connection conn = null;  //定义数据库连接对象
		PreparedStatement psmt = null;  //定义预处理对象
		
		boolean flag = false; //操作标志
		int result = -1;
		try {
			conn = DBUtil.getConnection();  //创建数据库连接
			//声明操作语句:将用户信息保存到数据库中,"?"为占位符
			String sql = "insert into t_user (name,password)" + "values(?,?)";
			
			psmt = conn.prepareStatement(sql);
			//为占位符设置值
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			
			result = psmt.executeUpdate();  //执行更新操作，返回受影响数
			if(result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.add");
		} finally {
			DBUtil.closeStatement(psmt); //关闭数据库预处理对象
			DBUtil.closeConnection(conn);  //关闭数据库连接对象
		}
		return flag;
	}

	public boolean isExist(String name) throws AppException {
		Connection conn = null;  //定义数据库连接对象
		PreparedStatement psmt = null;  //定义预处理对象
		ResultSet rs = null;  //定义结果集合对象
		
		boolean flag = false; //操作标志
		
		try {
			conn = DBUtil.getConnection(); //创建数据库连接
			//声明操作语句，根据用户名查询记录数，"?"为占位符
			String sql = "select id from t_user where name = ? and del = 0";
			
			psmt = conn.prepareStatement(sql);  //预编译sql
			psmt.setString(1, name);
			
			rs = psmt.executeQuery();  //执行查询，返回查询结果
			if(rs.next()) { //判断结果集中是否有值
				flag = true;
			} 
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.isExist"); 
		} finally {
			DBUtil.closeResultSet(rs);  //关闭数据库查询结果集
			DBUtil.closeStatement(psmt); // 关闭数据库预处理对象
			DBUtil.closeConnection(conn);
		}
		
		return flag;
	}

	public int login(String name, String password) throws AppException {
		int userId = -1; //初始化用户编号
		//声明数据库连接对象，和预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//创建数据库连接
			conn = DBUtil.getConnection();
			//声明操作语句:根据用户名和密码查询用户，"?"为占位符
			String sql = "select id from t_user where name = ? and password = ? and del = 0";
			//预编译sql
			psmt = conn.prepareStatement(sql);
			//为占位符
			psmt.setString(1, name);
			psmt.setString(2, password);
			//执行查询操作
			rs = psmt.executeQuery();
			//查询到记录，提取用户编号
			if(rs.next()) {
				userId = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.login");
		} finally {
			DBUtil.closeConnection(conn);
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
		}
		return userId;
	}
	
	public int getRoleById(int id) throws AppException{
		int role=-1;//初始化角色编号
		//声明数据库连接对象，预编译对象和结果集对象
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			//初始数据库连接
			conn=DBUtil.getConnection();
			//声明操作语句，根据用户id查询角色，“？”为点位符
			String sql="select role from t_user where id=? and del=0";
			//预编译sql
			psmt=conn.prepareStatement(sql);
			//设置点位符‘？’处的值
			psmt.setInt(1, id);
			//查询结果集
			rs=psmt.executeQuery();
			
			//将查询到的角色赋给role
			if(rs.next()){
				role=rs.getInt("role");
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.getRoleById");
		}finally{
			//关闭数据库操作对象，释放资源
			
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return role;
	}
	
	/**
	 * 获取用户信息
	 */
	public List<User> getUser() throws AppException{
		// 初始化用户列表
		List<User> userList = new ArrayList();
		
		Connection conn = null;  //定义数据库连接对象
		PreparedStatement psmt = null;  //定义预处理对象
		ResultSet rs = null;  //定义结果集合对象
		
		try{
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，查询用户信息列表
			String sql="select id,name,password,role from t_user where role=0 and del=0;";
			// 预编译sql，并设置参数值
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// 执行查询操作
			
			//循环提取用户信息
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getInt("role"));
				
				userList.add(user);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.getUser");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return userList;
	}
	
	/**
	 * 根据用户id删除用户
	 */
	public boolean delUser(int userId) throws AppException{
		Connection conn = null;  //定义数据库连接对象
		PreparedStatement psmt = null;  //定义预处理对象
		
		boolean flag=false;
		int result=-1;
		try{
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，删除用户信息
			String sql="delete from t_user where id=?";
			psmt = conn.prepareStatement(sql);
			//设置点位符‘？’处的值
			psmt.setInt(1, userId);
			result=psmt.executeUpdate();//执行更新操作，返回受影响数
			if(result>0){
				flag=true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.delUser");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
	
	/**
	 * 根据用户id提取用户信息
	 */
	public List<User> getUserById(int id) throws AppException{
		// 初始化用户列表
				List<User> userList = new ArrayList();
				
				Connection conn = null;  //定义数据库连接对象
				PreparedStatement psmt = null;  //定义预处理对象
				ResultSet rs = null;  //定义结果集合对象
				
				try{
					// 创建数据库连接
					conn = DBUtil.getConnection();
					// 声明操作语句，查询用户信息列表
					String sql="select id,name,password,role from t_user where id=? and del=0;";
					// 预编译sql，并设置参数值
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1,id);
					rs = psmt.executeQuery();// 执行查询操作
					
					//循环提取用户信息
					while(rs.next()){
						User user=new User();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						user.setRole(rs.getInt("role"));
						
						userList.add(user);
						
					}
				}catch (SQLException e) {
					e.printStackTrace();
					throw new AppException("com.dao.impl.UserDaoImpl.getUserById");
				} finally {
					// 关闭数据库操作对象，释放资源
					DBUtil.closeResultSet(rs);
					DBUtil.closeStatement(psmt);
					DBUtil.closeConnection(conn);
				}
				return userList;
	}
	
	/**
	 *修改用户信息
	 */
	public boolean ModifyUser(User user) throws AppException{
		Connection conn = null;  //定义数据库连接对象
		PreparedStatement psmt = null;  //定义预处理对象
		
		boolean flag=false;
		int result=-1;
		try{
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，删除用户信息
			String sql="update t_user set name=?,password=?,role=? where id=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			//设置点位符‘？’处的值
			psmt.setString(1, user.getName());
			psmt.setString(2,user.getPassword());
			psmt.setInt(3,user.getRole());
			psmt.setInt(4,user.getId());

	
			result=psmt.executeUpdate();//执行更新操作，返回受影响数
			if(result>0){
				flag=true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.ModifyUser");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
	
	/**
	 * 增加用户
	 */
	public boolean addUser(User user) throws AppException{
		Connection conn = null;  //定义数据库连接对象
		PreparedStatement psmt = null;  //定义预处理对象
		
		boolean flag = false; //操作标志
		int result = -1;
		try {
			conn = DBUtil.getConnection();  //创建数据库连接
			//声明操作语句:将用户信息保存到数据库中,"?"为占位符
			String sql = "insert into t_user (name,password,role)" + "values(?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			//为占位符设置值
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			psmt.setInt(3, user.getRole());
			
			result = psmt.executeUpdate();  //执行更新操作，返回受影响数
			if(result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.addUser");
		} finally {
			DBUtil.closeStatement(psmt); //关闭数据库预处理对象
			DBUtil.closeConnection(conn);  //关闭数据库连接对象
		}
		return flag;
	}

}
