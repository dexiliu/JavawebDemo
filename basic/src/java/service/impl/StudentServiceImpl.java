package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import service.StudentService;
import bean.Student;
import bean.querypage.Page;
import bean.querypage.StudentQp;
import dao.StudentDao;

//命名：Bean名+ServiceImpl
//函数顺序：遵循增删改查的顺序，由简单到复杂的顺序
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	public void insert(Student student) {
		studentDao.insert(student);
	}
	
	public void update(Student student) {
		studentDao.update(student);
	}

	public void deleteById(int id) {
		studentDao.deleteById(id);
	}

	public Student getById(int id) {
		return studentDao.getById(id);
	}
	
	public Page getPage(StudentQp qp) {
		qp.setTotalElements(studentDao.getCountByQueryBean(qp));
		qp.setDatas(studentDao.getByQueryBean(qp));
		return qp;
	}
	
	public Long getCountByQueryBean(StudentQp qp) {
		return studentDao.getCountByQueryBean(qp);
	}
}
