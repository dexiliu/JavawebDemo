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
	 * @param news新闻对象
	 * 
	 * @return boolean成功返回true,否则返回false
	 * 
	 * @throws AppException
	 */
	public boolean add(News news) throws AppException {
		boolean flag = false;// 操作标志
		// 声明数据库连接对象，预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，保存新闻信息，"?"为点位符
			String sql = "insert into t_news"
					+ "(title,user_id,newstype_id,source,author,createTime,keywords,content,state)"
					+ "values(?,?,?,?,?,?,?,?,?)";

			// 预编译sql，并指定返回生成的主键
			psmt = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);

			// 设置参数值
			psmt.setString(1, news.getTitle());
			psmt.setInt(2, news.getUserId());
			psmt.setInt(3, news.getNewsTypeId());
			psmt.setString(4, news.getSource());
			psmt.setString(5, news.getAuthor());
			psmt.setString(6, news.getCreateTime());
			psmt.setString(7, news.getKeywords());
			psmt.setString(8, news.getContent());
			psmt.setInt(9, news.getState());

			psmt.executeUpdate();// 执行更新
			rs = psmt.getGeneratedKeys();// 得到插入行的主键，结果集中只有一条记录

			if (rs.next()) {
				news.setId(rs.getInt(1));// 获取主键的值，并设置到news对象中
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.add");
		}
		return flag;
	}

	/**
	 * 根据状态查询信息列表，按创建时间降序排列
	 * 
	 * @param state新闻状态
	 * @return 信息列表
	 * @throws AppException
	 */
	public List<News> getList(int state) throws AppException {
		// 初始化新闻列表
		List<News> newsList = new ArrayList();

		// 声明数据库连接。预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "select id,title,author,source,createTime from t_news where state=? and del=0 order by createTime desc";

			// 预编译sql，并设置参数值
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, state);// 设置新闻状态
			rs = psmt.executeQuery();// 执行查询操作

			// 循环提取结果集中的信息，保存到newList中
			while (rs.next()) {
				News news = new News();// 实例化News对象
				// 设置news对象的属性值
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * 根据用户Id和新闻状态，获取用户发布的新闻
	 */
	public List<News> getListByuserId(int userId, int state)
			throws AppException {
		// 初始化新闻列表
		List<News> newsList = new ArrayList();

		// 声明数据库连接。预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "select id,title,author,source,createTime from t_news where user_id=? and state=? and del=0 order by createTime desc";

			// 预编译sql，并设置参数值
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userId);// 设置新闻状态
			psmt.setInt(2, state);
			rs = psmt.executeQuery();// 执行查询操作

			// 循环提取结果集中的信息，保存到newList中
			while (rs.next()) {
				News news = new News();// 实例化News对象
				// 设置news对象的属性值
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * 根据新闻id来获取新闻详细信息
	 */
	public List<News> getListById(int id) throws AppException {
		// 初始化新闻列表
		List<News> newsList = new ArrayList();

		// 声明数据库连接。预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "select id,title,createTime,source,author,click,content,newsType_id,keywords from t_news where id=? and del=0 order by createTime desc";

			// 预编译sql，并设置参数值
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);// 设置新闻状态
			rs = psmt.executeQuery();// 执行查询操作

			// 循环提取结果集中的信息，保存到newList中
			while (rs.next()) {
				News news = new News();// 实例化News对象
				// 设置news对象的属性值
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * 根据新闻类型id来查询已发布的新闻
	 */
	public List<News> getListByNewsTypeId(int newsTypeId) throws AppException {
		// 初始化新闻列表
		List<News> newsList = new ArrayList();

		// 声明数据库连接。预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "select id,title from t_news where newsType_id=? and del=0 and state=1 limit 1,6";

			// 预编译sql，并设置参数值
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, newsTypeId);// 设置新闻状态
			rs = psmt.executeQuery();// 执行查询操作

			// 循环提取结果集中的信息，保存到newList中
			while (rs.next()) {
				News news = new News();// 实例化News对象
				// 设置news对象的属性值
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));

				newsList.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(
					"com.dao.impl.NewsDaoImpl.getListByNewsTypeId");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * 获取最新新闻
	 */
	public List<News> getLatestList() throws AppException {
		// 初始化新闻列表
		List<News> newsList = new ArrayList();

		// 声明数据库连接。预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "select id,title,createTime,source,author,click,content from t_news where state=1 and del=0 order by createTime desc limit 1,10";

			// 预编译sql
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();// 执行查询操作

			// 循环提取结果集中的信息，保存到newList中
			while (rs.next()) {
				News news = new News();// 实例化News对象
				// 设置news对象的属性值
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * 获取点击率最高的新闻
	 */
	public List<News> getListByClick() throws AppException {
		// 初始化新闻列表
		List<News> newsList = new ArrayList();

		// 声明数据库连接。预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "select id,title,createTime,source,author,click,content from t_news where state=1 and del=0 order by click desc limit 1,9";

			// 预编译sql
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();// 执行查询操作

			// 循环提取结果集中的信息，保存到newList中
			while (rs.next()) {
				News news = new News();// 实例化News对象
				// 设置news对象的属性值
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * 根据新闻类型获取新闻信息
	 */
	public List<News> getList1(int newsTypeId) throws AppException {
		// 初始化新闻列表
		List<News> newsList = new ArrayList();

		// 声明数据库连接。预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "select id,title,createTime,click from t_news where newsType_id=? and state=1 and del=0 order by createTime desc";

			// 预编译sql
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, newsTypeId);
			rs = psmt.executeQuery();// 执行查询操作

			// 循环提取结果集中的信息，保存到newList中
			while (rs.next()) {
				News news = new News();// 实例化News对象
				// 设置news对象的属性值
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * 审核新闻
	 */
	public boolean ModifyNewsState(int id, int state) throws AppException {
		Connection conn = null; // 定义数据库连接对象
		PreparedStatement psmt = null; // 定义预处理对象

		boolean flag = false;
		int result = -1;
		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，删除用户信息
			String sql = "update t_news set state=? where id=?";
			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置点位符‘？’处的值
			psmt.setInt(2, id);
			psmt.setInt(1, state);

			result = psmt.executeUpdate();// 执行更新操作，返回受影响数
			if (result > 0) {
				System.out.println("result=" + result);
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.UserDaoImpl.ModifyNewsState");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	/**
	 * 根据关键字来搜索新闻
	 */
	public List<News> searchNews(String content) throws AppException {
		// 初始化新闻列表
		List<News> newsList = new ArrayList();

		// 声明数据库连接。预编译对象和结果集对象
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "select id,title,createTime,click from t_news where content like '%"
					+ content
					+ "%' and state=1 and del=0 order by createTime desc";

			// 预编译sql
			psmt = conn.prepareStatement(sql);
			// 设置点位符‘？’处的值
			// psmt.setString(1, content);
			rs = psmt.executeQuery();// 执行查询操作

			// 循环提取结果集中的信息，保存到newList中
			while (rs.next()) {
				News news = new News();// 实例化News对象
				// 设置news对象的属性值
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return newsList;
	}

	/**
	 * 根据新闻id删除新闻
	 */
	public boolean DelNews(int id) throws AppException {
		boolean flag = false;
		int result = -1;

		// 声明数据库连接。预编译对象
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
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
			// 关闭数据库操作对象，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		return flag;
	}

	public void addClick(int id) throws AppException {
		// 声明数据库连接。预编译对象
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			// 创建数据库连接
			conn = DBUtil.getConnection();
			// 声明操作语句，根据状态查询信息列表，按创建时间降序排序
			String sql = "update t_news set click=click+1 where id=?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);

			psmt.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.dao.impl.NewsDaoImpl.addClick");
		} finally {
			// 关闭数据库操作对象，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
	}

}
