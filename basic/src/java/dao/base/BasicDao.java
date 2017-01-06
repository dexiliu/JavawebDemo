package dao.base;

import java.io.Serializable;
import java.util.List;

import bean.querypage.Page;

/**
 * 基本接口，不是为了公用，而是为了约束常用功能方法的命名。<br/>
 * 类和子类中的方法排序需遵守 增、删、改、查 的顺序，在此基础上常用名要优先，如getById要先于getByUserId。
 */
public interface BasicDao<T> {

	/** 插入新对象 */
	void insert(T o);
	
	/** 删除一个或多个对象 */
	void delete(T o);
	
	/** 根据对象id删除单一对象 */
	void deleteById(Serializable id);
	
	/** 更新修改的对象 */
	void update(T o);
	
	/** 根据对象id获取单一对象 */
	T getById(Serializable id);
	
	/** 无条件获取所有对象 */
	List<T> getAll();
	
	/** 根据查询对象获取多个对象 */
	List<Object> getByQueryBean(Page page);
	
	/** 根据查询对象统计结果个数 */
	Long getCountByQueryBean(Page page);
	
}
