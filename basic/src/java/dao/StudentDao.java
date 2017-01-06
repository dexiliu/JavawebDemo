package dao;

import bean.Student;
import dao.base.BasicDao;

//命名：Bean名+Dao
//函数顺序：遵循增删改查的顺序，由简单到复杂的顺序，同对应的xml文件
public interface StudentDao extends BasicDao<Student> {

}
