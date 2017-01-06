package bean.querypage;


// Class name end with Qp.
/**
 * 继承page对象，增加更多的查询条件 。
 */
public class StudentQp extends Page {

	private String name;
	private String email;

	public String getName() {
		return name;
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
