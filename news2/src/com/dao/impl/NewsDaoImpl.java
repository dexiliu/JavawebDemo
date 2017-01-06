package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.NewsDao;
import com.model.News;
import com.model.NewsBModel;
import com.utils.AppException;
import com.utils.DBUtil;

public class NewsDaoImpl implements NewsDao {

	/*
	 * @param news���Ŷ���
	 * 
	 * @return boolean�ɹ�����true,���򷵻�false
	 * 
	 * @throws AppException
	 */
	public boolean add(News news) throws AppException {
		boolean flag = false;// ������־
		// �������ݿ����Ӷ���Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����������Ϣ��"?"Ϊ��λ��
			String sql = "insert into t_news"
					+ "(title,user_id,newstype_id,source,author,createTime,keywords,content,state)"
					+ "values(?,?,?,?,?,?,?,?,?)";

			// Ԥ����sql����ָ���������ɵ�����
			psmt = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);

			// ���ò���ֵ
			psmt.setString(1, news.getTitle());
			psmt.setInt(2, news.getUserId());
			psmt.setInt(3, news.getNewsTypeId());
			psmt.setString(4, news.getSource());
			psmt.setString(5, news.getAuthor());
			psmt.setString(6, news.getCreateTime());
			psmt.setString(7, news.getKeywords());
			psmt.setString(8, news.getContent());
			psmt.setInt(9, news.getState());

			psmt.executeUpdate();// ִ�и���
			rs = psmt.getGeneratedKeys();// �õ������е��������������ֻ��һ����¼

			if (rs.next()) {
				news.setId(rs.getInt(1));// ��ȡ������ֵ�������õ�news������
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.add");
		}
		return flag;
	}

	/**
	 * ����״̬��ѯ��Ϣ�б�������ʱ�併������
	 * 
	 * @param state����״̬
	 * @return ��Ϣ�б�
	 * @throws AppException
	 */
	public List<News> getList(int state) throws AppException {
		// ��ʼ�������б�
		List<News> newsList = new ArrayList();

		// �������ݿ����ӡ�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "select id,title,author,source,createTime from t_news where state=? and del=0 order by createTime desc";

			// Ԥ����sql�������ò���ֵ
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// ��������״̬
			rs = psmt.executeQuery();// ִ�в�ѯ����

			// ѭ����ȡ������е���Ϣ�����浽newList��
			while (rs.next()) {
				News news = new News();// ʵ����News����
				// ����news���������ֵ
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setAuthor(rs.getString("author"));
				news.setSource(rs.getString("source"));
				news.setCreateTime(rs.getString("createTime"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.getList");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * �����û�Id������״̬����ȡ�û�����������
	 */
	public List<News> getListByuserId(int userId, int state)
			throws AppException {
		// ��ʼ�������б�
		List<News> newsList = new ArrayList();

		// �������ݿ����ӡ�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "select id,title,author,source,createTime from t_news where user_id=? and state=? and del=0 order by createTime desc";

			// Ԥ����sql�������ò���ֵ
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userId);// ��������״̬
			psmt.setInt(2, state);
			rs = psmt.executeQuery();// ִ�в�ѯ����

			// ѭ����ȡ������е���Ϣ�����浽newList��
			while (rs.next()) {
				News news = new News();// ʵ����News����
				// ����news���������ֵ
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setAuthor(rs.getString("author"));
				news.setSource(rs.getString("source"));
				news.setCreateTime(rs.getString("createTime"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.getListByuserId");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * ��������id����ȡ������ϸ��Ϣ
	 */
	public List<News> getListById(int id) throws AppException {
		// ��ʼ�������б�
		List<News> newsList = new ArrayList();

		// �������ݿ����ӡ�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "select id,title,createTime,source,author,click,content,newsType_id,keywords from t_news where id=? and del=0 order by createTime desc";

			// Ԥ����sql�������ò���ֵ
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);// ��������״̬
			rs = psmt.executeQuery();// ִ�в�ѯ����

			// ѭ����ȡ������е���Ϣ�����浽newList��
			while (rs.next()) {
				News news = new News();// ʵ����News����
				// ����news���������ֵ
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getString("createTime"));
				news.setSource(rs.getString("source"));
				news.setAuthor(rs.getString("author"));
				news.setClick(rs.getInt("click"));
				news.setContent(rs.getString("content"));
				news.setNewsTypeId(rs.getInt("newsType_id"));
				news.setKeywords(rs.getString("keywords"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.getListById");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * ������������id����ѯ�ѷ���������
	 */
	public List<News> getListByNewsTypeId(int newsTypeId) throws AppException {
		// ��ʼ�������б�
		List<News> newsList = new ArrayList();

		// �������ݿ����ӡ�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "select id,title from t_news where newsType_id=? and del=0 and state=1 limit 1,6";

			// Ԥ����sql�������ò���ֵ
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, newsTypeId);// ��������״̬
			rs = psmt.executeQuery();// ִ�в�ѯ����

			// ѭ����ȡ������е���Ϣ�����浽newList��
			while (rs.next()) {
				News news = new News();// ʵ����News����
				// ����news���������ֵ
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(
					"com.dao.impl.NewsDaoImpl.getListByNewsTypeId");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * ��ȡ��������
	 */
	public List<News> getLatestList() throws AppException {
		// ��ʼ�������б�
		List<News> newsList = new ArrayList();

		// �������ݿ����ӡ�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "select id,title,createTime,source,author,click,content from t_news where state=1 and del=0 order by createTime desc limit 1,10";

			// Ԥ����sql
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();// ִ�в�ѯ����

			// ѭ����ȡ������е���Ϣ�����浽newList��
			while (rs.next()) {
				News news = new News();// ʵ����News����
				// ����news���������ֵ
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getString("createTime"));
				news.setSource(rs.getString("source"));
				news.setAuthor(rs.getString("author"));
				news.setClick(rs.getInt("click"));
				news.setContent(rs.getString("content"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.getLatestList");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * ��ȡ�������ߵ�����
	 */
	public List<News> getListByClick() throws AppException {
		// ��ʼ�������б�
		List<News> newsList = new ArrayList();

		// �������ݿ����ӡ�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "select id,title,createTime,source,author,click,content from t_news where state=1 and del=0 order by click desc limit 1,9";

			// Ԥ����sql
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();// ִ�в�ѯ����

			// ѭ����ȡ������е���Ϣ�����浽newList��
			while (rs.next()) {
				News news = new News();// ʵ����News����
				// ����news���������ֵ
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getString("createTime"));
				news.setSource(rs.getString("source"));
				news.setAuthor(rs.getString("author"));
				news.setClick(rs.getInt("click"));
				news.setContent(rs.getString("content"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.getListByClick");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * �����������ͻ�ȡ������Ϣ
	 */
	public List<News> getList1(int newsTypeId) throws AppException {
		// ��ʼ�������б�
		List<News> newsList = new ArrayList();

		// �������ݿ����ӡ�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "select id,title,createTime,click from t_news where newsType_id=? and state=1 and del=0 order by createTime desc";

			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, newsTypeId);
			rs = psmt.executeQuery();// ִ�в�ѯ����

			// ѭ����ȡ������е���Ϣ�����浽newList��
			while (rs.next()) {
				News news = new News();// ʵ����News����
				// ����news���������ֵ
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getString("createTime"));
				news.setClick(rs.getInt("click"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.getList1()");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * �������
	 */
	public boolean ModifyNewsState(int id, int state) throws AppException {
		Connection conn = null; // �������ݿ����Ӷ���
		PreparedStatement psmt = null; // ����Ԥ�������

		boolean flag = false;
		int result = -1;
		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬ɾ���û���Ϣ
			String sql = "update t_news set state=? where id=?";
			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ���õ�λ������������ֵ
			psmt.setInt(2, id);
			psmt.setInt(1, state);

			result = psmt.executeUpdate();// ִ�и��²�����������Ӱ����
			if (result > 0) {
				System.out.println("result=" + result);
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.ModifyNewsState");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * ���ݹؼ�������������
	 */
	public List<News> searchNews(String content) throws AppException {
		// ��ʼ�������б�
		List<News> newsList = new ArrayList();

		// �������ݿ����ӡ�Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "select id,title,createTime,click from t_news where content like '%"
					+ content
					+ "%' and state=1 and del=0 order by createTime desc";

			// Ԥ����sql
			psmt = conn.prepareStatement(sql);
			// ���õ�λ������������ֵ
			// psmt.setString(1, content);
			rs = psmt.executeQuery();// ִ�в�ѯ����

			// ѭ����ȡ������е���Ϣ�����浽newList��
			while (rs.next()) {
				News news = new News();// ʵ����News����
				// ����news���������ֵ
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getString("createTime"));
				news.setClick(rs.getInt("click"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.searchNews");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * ��������idɾ������
	 */
	public boolean DelNews(int id) throws AppException {
		boolean flag = false;
		int result = -1;

		// �������ݿ����ӡ�Ԥ�������
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "delete from t_news where id=?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);

			result = psmt.executeUpdate();
			if (result > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.DelNews");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	public void addClick(int id) throws AppException {
		// �������ݿ����ӡ�Ԥ�������
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// �������ݿ�����
			conn = DBUtil.getConnection();
			// ����������䣬����״̬��ѯ��Ϣ�б�������ʱ�併������
			String sql = "update t_news set click=click+1 where id=?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);

			psmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.addClick");
		} finally {
			// �ر����ݿ���������ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
	}

}
