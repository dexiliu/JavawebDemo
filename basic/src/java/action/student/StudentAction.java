package action.student;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import service.StudentService;
import action.base.BasicAction;
import bean.Student;
import bean.querypage.StudentQp;

//命名：Bean名+Action，有些Bean涉及到的操作过多时，可视情况拆分
//函数顺序：add->edit->save->delete->list->others
public class StudentAction extends BasicAction {
	// 使用默认uid即可
	private static final long serialVersionUID = 1L;
	
	// 查询Bean命名为：Bean名+Qp
	private StudentQp qp;
	private int id;
	private Student student;
	
	// Service变量名即为类名，第一字母小写
	private StudentService studentService;
	
	@RequiresPermissions("student:add")
	public String add() {
		student = new Student();
		return "add";
	}
	
	@RequiresPermissions("student:edit")
	public String edit() {
		student = studentService.getById(id);
		return "edit";
	}
	
	@RequiresPermissions("student:save")
	public String save() {
		// 表单验证
		if(StringUtils.isBlank(student.getName()))
			errorMap.put("name", "请输入学生名！");
		if(StringUtils.isBlank(student.getEmail()))
			errorMap.put("email", "请输入邮箱！");
		if(!errorMap.isEmpty()) return INPUT;
		
		// 更新操作
		if(id > 0) {
			Student studentIndb = studentService.getById(id);
			studentIndb.setName(student.getName());
			studentIndb.setEmail(student.getEmail());
			studentService.update(studentIndb);
			
		// 添加操作
		} else {
			studentService.insert(student);	
		}
		
		return SUCCESS;
	}
	
	@RequiresPermissions("student:delete")
	public String delete() {
		studentService.deleteById(id);
		return SUCCESS;
	}
	
	public String list() {
		// 如果页面变量不常用，用如下方法设置，不需要定义为action级别变量
		// 注意保持名称统一
		// List<Course> courses = 如从数据库中获取此值;
		// super.getRequest().setAttribute("courses", courses);
		
		if(qp == null) qp = new StudentQp();
		qp = (StudentQp)studentService.getPage(qp);
		
		// 返回字符串命名：除了无返回、INPUT 或 SUCCESS外，返回的字符串需要与方法名一致
		return "list";
	}
	

	// 涉及到的set和get方法必须放在action的最下边，之前用符号隔开，以方便分别
	// ==================================================================
	public StudentQp getQp() {
		return qp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQp(StudentQp qp) {
		this.qp = qp;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
