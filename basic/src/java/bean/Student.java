package bean;

public class Student implements java.io.Serializable {
	private static final long serialVersionUID = -7789376458124710219L;

	// bean 本身的id名称一律使用id，如果bean中包含其他对象id，名称需为xxId，可参见UserRole bean
	// 对应数据库中的设计命名同上，并且禁止使用缩写
	private Integer id;
	private String name;
	private String phoneNumber;
	private String teacher;
	private String email;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}