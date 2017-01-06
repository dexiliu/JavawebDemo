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
		
		Connection conn = null;  //�������ݿ����Ӷ���
		PreparedStatement psmt = null;  //����Ԥ�������
		
		boolean flag = false; //������־
		int result = -1;
		try {
			conn = DBUtil.getConnection();  //�������ݿ�����
			//�����������:���û���Ϣ���浽���ݿ���,"?"Ϊռλ��
			String sql = "insert into t_user (name,password)" + "values(?,?)";
			
			psmt = conn.prepareStatement(sql);
			//Ϊռλ������ֵ
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			
			result = psmt.executeUpdate();  //ִ�и��²�����������Ӱ����
			if(result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.add");
		} finally {
			DBUtil.closeStatement(psmt); //�ر����ݿ�Ԥ�������
			DBUtil.closeConnection(conn);  //�ر����ݿ����Ӷ���
		}
		return flag;
	}

	public boolean isExist(String name) throws AppException {
		Connection conn = null;  //�������ݿ����Ӷ���
		PreparedStatement psmt = null;  //����Ԥ�������
		ResultSet rs = null;  //���������϶���
		
		boolean flag = false; //������־
		
		try {
			conn = DBUtil.getConnection(); //�������ݿ�����
			//����������䣬�����û�����ѯ��¼����"?"Ϊռλ��
			String sql = "select id from t_user where name = ? and del = 0";
			
			psmt = conn.prepareStatement(sql);  //Ԥ����sql
			psmt.setString(1, name);
			
			rs = psmt.executeQuery();  //ִ�в�ѯ�����ز�ѯ���
			if(rs.next()) { //�жϽ�������Ƿ���ֵ
				flag = true;
			} 
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.isExist"); 
		} finally {
			DBUtil.closeResultSet(rs);  //�ر����ݿ��ѯ�����
			DBUtil.closeStatement(psmt); // �ر����ݿ�Ԥ�������
			DBUtil.closeConnection(conn);
		}
		
		return flag;
	}

	public int login(String name, String password) throws AppException {
		int userId = -1; //��ʼ���û����
		//�������ݿ����Ӷ��󣬺�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//�������ݿ�����
			conn = DBUtil.getConnection();
			//�����������:�����û����������ѯ�û���"?"Ϊռλ��
			String sql = "select id from t_user where name = ? and password = ? and del = 0";
			//Ԥ����sql
			psmt = conn.prepareStatement(sql);
			//Ϊռλ��
			psmt.setString(1, name);
			psmt.setString(2, password);
			//ִ�в�ѯ����
			rs = psmt.executeQuery();
			//��ѯ����¼����ȡ�û����
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
		int role=-1;//��ʼ����ɫ���
		//�������ݿ����Ӷ���Ԥ�������ͽ��������
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			//��ʼ���ݿ�����
			conn=DBUtil.getConnection();
			//����������䣬�����û�id��ѯ��ɫ��������Ϊ��λ��
			String sql="select role from t_user where id=? and del=0";
			//Ԥ����sql
			psmt=conn.prepareStatement(sql);
			//���õ�λ������������ֵ
			psmt.setInt(1, id);
			//��ѯ�����
			rs=psmt.executeQuery();
			
			//����ѯ���Ľ�ɫ����role
			if(rs.next()){
				role=rs.getInt("role");
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.getRoleById");
		}finally{
			//�ر����ݿ���������ͷ���Դ
			
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return role;
	}
	
	/**
	 * ��ȡ�û���Ϣ
	 */
	public List<User> getUser() throws AppException{
		// ��ʼ���û��б�
		List<User> userList = new ArrayList();
		
		Connection conn = null;  //�������ݿ����Ӷ���
		PreparedStatement psmt = null;  //����Ԥ�������
		ResultSet rs = null;  //���������϶���
		
		try{
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬��ѯ�û���Ϣ�б�
			String sql="select id,name,password,role from t_user where role=0 and del=0;";
			// Ԥ����sql�������ò���ֵ
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();// ִ�в�ѯ����
			
			//ѭ����ȡ�û���Ϣ
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
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return userList;
	}
	
	/**
	 * �����û�idɾ���û�
	 */
	public boolean delUser(int userId) throws AppException{
		Connection conn = null;  //�������ݿ����Ӷ���
		PreparedStatement psmt = null;  //����Ԥ�������
		
		boolean flag=false;
		int result=-1;
		try{
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬ɾ���û���Ϣ
			String sql="delete from t_user where id=?";
			psmt = conn.prepareStatement(sql);
			//���õ�λ������������ֵ
			psmt.setInt(1, userId);
			result=psmt.executeUpdate();//ִ�и��²�����������Ӱ����
			if(result>0){
				flag=true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.delUser");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
	
	/**
	 * �����û�id��ȡ�û���Ϣ
	 */
	public List<User> getUserById(int id) throws AppException{
		// ��ʼ���û��б�
				List<User> userList = new ArrayList();
				
				Connection conn = null;  //�������ݿ����Ӷ���
				PreparedStatement psmt = null;  //����Ԥ�������
				ResultSet rs = null;  //���������϶���
				
				try{
					// �������ݿ�����
					conn = DBUtil.getConnection();
					// ����������䣬��ѯ�û���Ϣ�б�
					String sql="select id,name,password,role from t_user where id=? and del=0;";
					// Ԥ����sql�������ò���ֵ
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1,id);
					rs = psmt.executeQuery();// ִ�в�ѯ����
					
					//ѭ����ȡ�û���Ϣ
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
					// �ر����ݿ���������ͷ���Դ
					DBUtil.closeResultSet(rs);
					DBUtil.closeStatement(psmt);
					DBUtil.closeConnection(conn);
				}
				return userList;
	}
	
	/**
	 *�޸��û���Ϣ
	 */
	public boolean ModifyUser(User user) throws AppException{
		Connection conn = null;  //�������ݿ����Ӷ���
		PreparedStatement psmt = null;  //����Ԥ�������
		
		boolean flag=false;
		int result=-1;
		try{
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬ɾ���û���Ϣ
			String sql="update t_user set name=?,password=?,role=? where id=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			//���õ�λ������������ֵ
			psmt.setString(1, user.getName());
			psmt.setString(2,user.getPassword());
			psmt.setInt(3,user.getRole());
			psmt.setInt(4,user.getId());

	
			result=psmt.executeUpdate();//ִ�и��²�����������Ӱ����
			if(result>0){
				flag=true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.ModifyUser");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
	
	/**
	 * �����û�
	 */
	public boolean addUser(User user) throws AppException{
		Connection conn = null;  //�������ݿ����Ӷ���
		PreparedStatement psmt = null;  //����Ԥ�������
		
		boolean flag = false; //������־
		int result = -1;
		try {
			conn = DBUtil.getConnection();  //�������ݿ�����
			//�����������:���û���Ϣ���浽���ݿ���,"?"Ϊռλ��
			String sql = "insert into t_user (name,password,role)" + "values(?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			//Ϊռλ������ֵ
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getPassword());
			psmt.setInt(3, user.getRole());
			
			result = psmt.executeUpdate();  //ִ�и��²�����������Ӱ����
			if(result > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.addUser");
		} finally {
			DBUtil.closeStatement(psmt); //�ر����ݿ�Ԥ�������
			DBUtil.closeConnection(conn);  //�ر����ݿ����Ӷ���
		}
		return flag;
	}

}
