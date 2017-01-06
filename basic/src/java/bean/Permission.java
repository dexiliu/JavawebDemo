package bean;

public class Permission implements java.io.Serializable {
	private static final long serialVersionUID = -7646634454202941938L;

	private Integer id;
	private String name;
	private String value;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}