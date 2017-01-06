package com.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.servlet.dao.UserDao;
import com.servlet.entity.User;
import com.servlet.util.C3P0DataSource;

@SuppressWarnings("static-access")
public class UserDaoImpl implements UserDao {

	Connection conn = null; // 定义数据库连接对象
	PreparedStatement psmt = null; // 定义预处理对象
	ResultSet rs = null; // 定义结果集合对象
	
	@Override
	public void addUser(User user) {
		try{
			conn=C3P0DataSource.getInstance().getConnection();
			psmt=conn.prepareStatement("insert into t_user(username,password,email) values(?,?,?)");
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getEmail());
			psmt.execute();
			psmt.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}

	@Override
	public List<User> getAllUser() {
		List<User> userlist=new ArrayList<User>();
		try{
			conn=C3P0DataSource.getInstance().getConnection();
			psmt=conn.prepareStatement("select * from t_user",ResultSet.CONCUR_READ_ONLY,
					ResultSet.FETCH_FORWARD);
			rs=psmt.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				userlist.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return userlist;
	}

	@Override
	public void deleteUser(int id) {
		try{
			conn=C3P0DataSource.getInstance().getConnection();
			psmt=conn.prepareStatement("delete from t_user where id=?");
			psmt.setInt(1, id);
			psmt.execute();
			psmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}

	@Override
	public void updateUser(User user) {
		
		
	}

}
