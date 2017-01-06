package service;

import bean.Student;
import bean.querypage.Page;
import bean.querypage.StudentQp;

// 命名：Bean名+Service
// 函数顺序：遵循增删改查的顺序，由简单到复杂的顺序
public interface StudentService {
	public void insert(Student student);
	
	public void deleteById(int id);

	public void update(Student student);
	
	public Student getById(int id);
	
	public Page getPage(StudentQp qp);
	
}
